package com.zw.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ConnectionPool {

    private static String driverClassName; //= "org.apache.hive.jdbc.HiveDriver";
    private static String url;// = "jdbc:hive2://192.168.55.12:10000/default";
    private static String username;// = "root";
    private static String password;// = "";
    private static int initCapacity=10; // 初始化数量
    private static int maxCapacity=20; // 最大数量
    private static List<NotifyConnection> poolList = new ArrayList<>(); // 连接池容器
    //全局变量 为false表示尚未往连接池创建连接，为true表示已经创建
    private static Boolean addflag=false;

    @Value("${hive.driver}")
    public void setDriverClassName(String driverClassName) {
        ConnectionPool.driverClassName = driverClassName;
    }
    @Value("${hive.jdbcUrl}")
    public void setUrl(String url) {
        ConnectionPool.url = url;
    }
    @Value("${hive.user}")
    public void setUsername(String username) {
        ConnectionPool.username = username;
    }
    @Value("${hive.password}")
    public void setPassword(String password) {
        ConnectionPool.password = password;
    }

    /*
    * 初始化连接池
    */
//    @PostConstruct
    private static void initConnectionPool() {
        //尝试创建连接，失败则抛出异常
        Connection test = createConnection();
        if (null == test){
            throw new RuntimeException("*********创建hive连接失败，请检查hive是否启动后再次尝试创建连接*********");
        }
        System.out.println("初始化jabc连接池");
        poolList = new ArrayList<>();
        for (int i=0; i<initCapacity; i++) {
            addConnctionToPool();
        }
    }

    /*
    *  向连接池中添加连接
    */
    private static void addConnctionToPool(){
        if (poolList.size() < maxCapacity) {
            synchronized (poolList) {
                if (poolList.size() < maxCapacity) {
                    Connection oConnection;
                    do {
                        oConnection = createConnection();
                        if (null == oConnection) { // 建立连接池异常，重试
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } while (null == oConnection);
                    NotifyConnection oNotifyConnection = new NotifyConnection(oConnection);
                    poolList.add(oNotifyConnection);
                }
            }
        }
    }

    /*
    *  创建连接
    */
    private static Connection createConnection(){
        Connection oConnection = null;
        try {
            Class.forName(driverClassName);
            oConnection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oConnection;
    }

    /**
     * 从连接池获取连接
     *
     *  @return
     *  @author zhangh-ag
     *  @date 2017年6月7日
     *
     */
    public Connection getConnection() {
        if (!addflag){
            initConnectionPool();
            addflag=true;
        }
        Connection oConnection = null;
        Iterator<NotifyConnection> oIterator = poolList.iterator();
        NotifyConnection oNotifyConnection;
        while (oIterator.hasNext()) {
            oNotifyConnection = oIterator.next();
            if (!oNotifyConnection.isUsed) {
                synchronized (oNotifyConnection) {
                    if (!oNotifyConnection.isUsed) {
                        oNotifyConnection.setIsUsed(true);
                        oConnection = oNotifyConnection.getConnection();
                        break;
                    }
                }
            }
        }
        if (null == oConnection) {
            if (poolList.size() < maxCapacity) {
                addConnctionToPool();
            } else {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return getConnection();
            }
        }
        return oConnection;
    }

    /**
     * 归还连接
     *
     *  @param con
     *  @param statement
     *  @param resultSet
     *  @author zhangh-ag
     *  @date 2017年6月7日
     *
     */
    public void closeConnection(Connection con, Statement statement, ResultSet resultSet) {
        if (null != resultSet) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != statement) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != con) {
            NotifyConnection oNotifyConnection;
            Connection oConnection;
            Iterator<NotifyConnection> oIterator = poolList.iterator();
            while (oIterator.hasNext()) {
                oNotifyConnection = oIterator.next();
                oConnection = oNotifyConnection.getConnection();
                if (con.equals(oConnection)) {
                    oNotifyConnection.setIsUsed(false);
                    break;
                }
            }
        }
    }

    /**
     * 归还连接
     *
     *  @param con
     *  @param statement
     *  @param resultSet
     *  @author zhangh-ag
     *  @date 2017年6月7日
     *
     */
    public void closeConnection(Connection con, PreparedStatement statement, ResultSet resultSet) {
        if (null != resultSet) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != statement) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != con) {
            NotifyConnection oNotifyConnection;
            Connection oConnection;
            Iterator<NotifyConnection> oIterator = poolList.iterator();
            while (oIterator.hasNext()) {
                oNotifyConnection = oIterator.next();
                oConnection = oNotifyConnection.getConnection();
                if (con.equals(oConnection)) {
                    oNotifyConnection.setIsUsed(false);
                    break;
                }
            }
        }
    }

    /**
     * 连接不可用，销毁该连接
     *
     *  @param connection
     *  @author zhangh-ag
     *  @date 2017年6月7日
     *
     */
    public static void destoryConnection(Connection connection) {
        NotifyConnection oNotifyConnection;
        Iterator<NotifyConnection> oIterator = poolList.iterator();
        Connection con;
        while (oIterator.hasNext()) {
            oNotifyConnection = oIterator.next();
            con = oNotifyConnection.getConnection();
            if (con.equals(connection)) {
                oIterator.remove();
                break;
            }
        }
    }

    //连接池中连接实体
    static class NotifyConnection {
        private Boolean isUsed;
        private Connection connection;
        public NotifyConnection(Connection connection) {
            isUsed = false;
            this.connection = connection;
        }

        public Boolean getIsUsed() {
            return isUsed;
        }


        public void setIsUsed(Boolean isUsed) {
            this.isUsed = isUsed;
        }


        public Connection getConnection() {
            return connection;
        }
        public void setConnection(Connection connection) {
            this.connection = connection;
        }

    }

}
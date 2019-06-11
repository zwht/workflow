package com.zw.common.util;

import java.io.UnsupportedEncodingException;

/**
 * Created by tracy on 2018/4/17.
 */
public class StrKit {
    public static final String DEFAULT_ENCODING = "UTF-8";
    /**
     * 首字母变小写
     */
    public static String firstCharToLowerCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'A' && firstChar <= 'Z') {
            char[] arr = str.toCharArray();
            arr[0] += ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    /**
     * 首字母变大写
     */
    public static String firstCharToUpperCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'a' && firstChar <= 'z') {
            char[] arr = str.toCharArray();
            arr[0] -= ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    /**
     * 字符串为 null 或者为  "" 时返回 true
     */
    public static boolean isBlank(String str) {
        return str == null || "".equals(str.trim()) ? true : false;
    }

    /**
     * 字符数组有一个元素为 null 或者为  "" 返回true
     *
     * @param strArray
     * @return
     */
    public static boolean isAnyBlank(String[] strArray) {
        if (strArray == null || strArray.length == 0) {
            return true;
        }
        for (String str : strArray) {
            if (isBlank(str)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 字符串不为 null 而且不为  "" 时返回 true
     */
    public static boolean notBlank(String str) {
        return str == null || "".equals(str.trim()) ? false : true;
    }

    public static boolean notBlank(String... strings) {
        if (strings == null)
            return false;
        for (String str : strings)
            if (str == null || "".equals(str.trim()))
                return false;
        return true;
    }

    public static boolean notNull(Object... paras) {
        if (paras == null)
            return false;
        for (Object obj : paras)
            if (obj == null)
                return false;
        return true;
    }


    //首字母转小写
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }


    //首字母转大写
    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    /**
     * 将字符串类型的数字转换为int类型 转换发生异常返回默认值
     *
     * @param src
     * @param defaultNum
     * @return
     */
    public static int parseToInt(String src, int defaultNum) {
        try {
            return Integer.parseInt(src);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return defaultNum;
        }
    }


    /**
     * 将包含下划线"_"的原生sql列名转换成javaBean对应的小驼峰形式的属性名
     */
    public static String _2Camel(String columns){
        StringBuffer fieldName = new StringBuffer();
        String[] columnArr;
        if(columns.contains("_")){
            columnArr = columns.split("_");
        }else{
            columnArr = new String[]{columns};
        }
        for (String s : columnArr) {
            fieldName.append( StrKit.toUpperCaseFirstOne(s));
        }
        return StrKit.toLowerCaseFirstOne(fieldName.toString());
    }

    public static byte[] getBytesWithDefaultEncoding(String str) {
        try {
            return str.getBytes(DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            //应该永远不会发生 DEFAULT_ENCODING 肯定是对的
            throw new RuntimeException(e);
        }
    }

    public static String byteToStringWithDefaultEncoding(byte[] bytes){
        try {
            return new String(bytes, DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            //应该永远不会发生 DEFAULT_ENCODING 肯定是对的
            throw new RuntimeException(e);
        }
    }

    /**
     * 将数组的每个元素trim
     */
    public static void trim(String[] patterns) {
        for (int i = 0; i < patterns.length; i++) {
            patterns[i] = patterns[i].trim();
        }
    }

    /**
     * 检查某个值是否在数组中
     */
    public static <T> boolean targetInArray(T[] array, T target) {
        if(null == array || array.length == 0){
            return false;
        }
        for (T s : array) {
            if(s.equals(target)){
                return true;
            }
        }
        return false;
    }
}

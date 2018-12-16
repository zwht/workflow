package com.zw.common.db;
import org.jooq.util.GenerationTool;
import org.jooq.util.jaxb.*;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;


public class JooqPgGen {

    /**
     * Jooq 自动化生成代码
     */
    public void gen(Properties props) {

        String driverClassName = props.getProperty("db.driverClassName");
        String username = props.getProperty("db.username");
        String url = props.getProperty("db.url");
        String password = props.getProperty("db.password");
        String schema = props.getProperty("db.schema");

        Jdbc jdbc = new Jdbc().withDriver(driverClassName)
                .withUrl(url)
                .withUser(username)
                .withPassword(password);
        Database database = new Database()
                .withName("org.jooq.util.postgres.PostgresDatabase")
                .withExcludes("schema_version")
                .withSchemata(new Schema().withInputSchema(schema));
        Generator generator = new Generator()
                .withName("org.jooq.util.DefaultGenerator")
                .withDatabase(database)
                .withGenerate(new Generate())
                .withTarget(new Target().withPackageName("com.zw.model").withDirectory("cfmy-model/src/main/java"));
        Configuration conf = new Configuration()
                .withJdbc(jdbc)
                .withGenerator(generator);

        try {
            GenerationTool.generate(conf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application-local.yml"));
        Properties properties = yaml.getObject();
        JooqPgGen jg = new JooqPgGen();
        jg.gen(properties);
        System.out.println("JooqPgGenerator finished.");
    }

}

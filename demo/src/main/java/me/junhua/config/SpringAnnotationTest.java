package me.junhua.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class SpringAnnotationTest {

    public static void main(String[] args) {
        // 1.创建容器（基于注解的创建方式）
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("me.junhua.config");
        // 2.获取bean对象
        JdbcTemplate jdbcTemplate = ac.getBean(JdbcTemplate.class);
        String sql = "select * from sys_dept";
        ResultSetExtractor<? extends Object> xxx = (ResultSetExtractor<Object>) rs -> {
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println("name = " + name);
            }
            return null;
        };
        Object query = jdbcTemplate.query(sql, xxx);
    }
}

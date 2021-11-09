package me.junhua;

import me.junhua.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringComponentScanTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("me.junhua.config");
        UserService userService = ac.getBean(UserService.class);
        userService.saveUser();
    }
}

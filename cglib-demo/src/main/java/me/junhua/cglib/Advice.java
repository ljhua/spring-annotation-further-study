package me.junhua.cglib;

public class Advice {
    public void before() {
        System.out.println("before");
    }

    public void afterReturning() {
        System.out.println("afterReturning");
    }
}

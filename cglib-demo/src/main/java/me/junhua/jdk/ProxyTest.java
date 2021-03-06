package me.junhua.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        // 目标对象
        final Target target = new Target();

        // 增强对象
        final Advice advice = new Advice();

        TargetInterface targetInterface = (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                advice.before();
                Object invoke = method.invoke(target, args);
                advice.afterReturning();
                return invoke;
            }
        });

        targetInterface.save();
    }
}

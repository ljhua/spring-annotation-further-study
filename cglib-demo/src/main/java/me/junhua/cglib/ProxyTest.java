package me.junhua.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class ProxyTest {

    public static void main(String[] args) {
        // 目标对象
        final Target target = new Target();

        // 增强对象
        final Advice advice = new Advice();

        // 创建增强器
        Enhancer enhancer = new Enhancer();

        // 设置父类（目标）
        enhancer.setSuperclass(Target.class);

        // 设置回调
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            advice.before();
            Object invoke = method.invoke(target, objects);
            advice.afterReturning();
            return invoke;
        });

        // 创建代理对象
        Target proxy = (Target) enhancer.create();
        proxy.save();
    }
}

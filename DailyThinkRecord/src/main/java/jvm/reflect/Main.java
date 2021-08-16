package jvm.reflect;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("jvm.reflect.MethodInvokeTestV1");
        Method method = klass.getMethod("target", int.class);
        for (int i = 0; i < 20; i++) {
            method.invoke(null, i);
        }
    }
}

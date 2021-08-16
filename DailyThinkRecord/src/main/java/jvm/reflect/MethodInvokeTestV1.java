package jvm.reflect;

import java.lang.reflect.Method;

public class MethodInvokeTestV1 {

    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }


}

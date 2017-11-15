package com.unique.reflect;



import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

    private MyReflect myReflect1;

    public static void main(String[] args) throws Exception {
        Class reflectTest = Class.forName("com.unique.reflect.MyReflect");
        System.out.println(reflectTest.getName());
        System.out.println(reflectTest.newInstance());

        Constructor constructor = reflectTest.getConstructor(int.class);
        MyReflect myReflect = (MyReflect) constructor.newInstance(80);
        System.out.println(myReflect);

        Constructor<MyReflect> constructor1 = reflectTest.getDeclaredConstructor(int.class, String.class);

        constructor1.setAccessible(true);

        MyReflect myReflect1 = constructor1.newInstance(2,"private");
        System.out.println(myReflect1);

        Field field = reflectTest.getDeclaredField("num");
        field.setAccessible(true);
        field.set(myReflect, 200);
        System.out.println(myReflect);


        Method sayHello = reflectTest.getMethod("sayHello");
        sayHello.invoke(myReflect1);

        Method pp = reflectTest.getDeclaredMethod("pp",String.class);
        pp.setAccessible(true);
        pp.invoke(myReflect,"ppppp");

    }
}

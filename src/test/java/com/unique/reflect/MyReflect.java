package com.unique.reflect;

public class MyReflect {



    private int num ;
    public MyReflect(){
        this.num = 100;
    }

    private MyReflect(int num, String info) {
        this.num = num;
        System.out.println("我是私有构造函数info:" + info);
    }

    private void pp(String s){
        System.out.println(s);
    }

    public MyReflect(int num) {
        this.num = num;
    }
    public void sayHello(){
        System.out.println("hello , i am a reflect class");
    }

    @Override
    public String toString() {
        return "num = " + num;
    }


}

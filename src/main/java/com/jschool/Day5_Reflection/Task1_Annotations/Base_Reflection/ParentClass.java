package com.jschool.Day5_Reflection.Task1_Annotations.Base_Reflection;

public class ParentClass {
    String name;
    private String string2;
    int age;

    public void sayHello() {
        System.out.println("Hello, my name is " + name + " I'am " + age + " years old.");
    }
    private void sayYouSecret() {
        System.out.println("I'am a spy from the USSR!");
    }

    public ParentClass(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

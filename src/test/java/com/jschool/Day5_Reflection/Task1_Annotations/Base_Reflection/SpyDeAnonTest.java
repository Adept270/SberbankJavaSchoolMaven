package com.jschool.Day5_Reflection.Task1_Annotations.Base_Reflection;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpyDeAnonTest {

    @Test
    public void printAllMethods() {
        SpyDeAnon.getAllMethodsRec(ChildClass.class);
    }

    @Test
    public void getClassGetters() {
        SpyDeAnon.getClassGetters(ChildClass.class);
    }

    @Test
    public void checkConstantFields() throws Exception {
        boolean result = SpyDeAnon.checkConstantFields(new ChildClass("Tom", 17, "programmer", "Spy"));
        System.out.println(result);
        assertFalse(result);
    }
}
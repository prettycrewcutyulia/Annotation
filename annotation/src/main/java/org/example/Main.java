package org.example;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
    String value();
    String createdBy() default "Unknown";
    String lastModified() default "N/A";
}

public class Main {
    @MyAnnotation(value = "Hello World!", createdBy = "John Doe")
    public static void main(String[] args) throws NoSuchMethodException {
        Main mainObj = new Main();
        mainObj.myMethod();
    }

    @MyAnnotation(value = "This is my custom method.", createdBy = "Jane Smith", lastModified = "2022-03-23")
    public void myMethod() throws NoSuchMethodException {
        Method method = Main.class.getMethod("myMethod");
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        System.out.println("Method name: " + method.getName());
        System.out.println("Annotation value: " + annotation.value());
        System.out.println("Annotation created by: " + annotation.createdBy());
        System.out.println("Annotation last modified: " + annotation.lastModified());
    }
}

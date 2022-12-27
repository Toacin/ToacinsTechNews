package com.ToacinsTechNews;

public class Actor {
    public String firstName;
    public String lastName;

    public void getName() {
        System.out.println(this.firstName+" "+this.lastName);
    }

    public static void helloWorld() {
        System.out.println("hello world");
    }
}

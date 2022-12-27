package com.ToacinsTechNews;

import java.util.Objects;

public class HelloWorld {
    private String name;
    private int age;
    private String petName;

    public HelloWorld(String name, int age, String petName) {
        this.name = name;
        this.age = age;
        this.petName = petName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return petName;
    }

    public void setLastName(String petName) {
        this.petName = petName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HelloWorld that)) return false;
        return getAge() == that.getAge() && Objects.equals(getName(), that.getName()) && Objects.equals(petName, that.petName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), petName);
    }

    @Override
    public String toString() {
        return "HelloWorld {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", petName='" + petName + '\'' +
                '}';
    }



    //    public static void main(String[] args) {
//        System.out.println("Hello");
//    }
}




package com.bjp.ba01;

public class Student {
    private String name;
    private int age;

    public Student() {
        System.out.println("spring会调用无参的构造");
    }

    public void setEmail(String email){
        System.out.println("email"+email);
    }

    public void setName(String name) {
        System.out.println("set name");
        this.name = name;
    }

    public void setAge(int age) {
        System.out.println("set age");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

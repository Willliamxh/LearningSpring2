package com.bjp.ba06;

public class Student {
    private String name;
    private int age;

    //声明一个引用类型
    private School school;



    public Student() {
//        System.out.println("student的构造");
    }

    public void setEmail(String email){
        System.out.println("email"+email);
    }

    public void setName(String name) {
//        System.out.println("set name");
        this.name = name;
    }

    public void setAge(int age) {
//        System.out.println("set age");
        this.age = age;
    }

    public void setSchool(School school) {
        System.out.println("set school "+school);
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}

package com.bjp.ba03;

public class Student {
    private String name;
    private int age;

    //声明一个引用类型
    private School school;



    public Student() {
        System.out.println("student的构造");
    }

    //创建一个有参的构造


    public Student(String myName, int myAge, School mySchool) {
        System.out.println("Student的有参数构造方法");
        this.name = myName;
        this.age = myAge;
        this.school = mySchool;
    }

    public void setEmail(String email){
        System.out.println("email"+email);
    }

    public void setName(String name) {
        // System.out.println("set name");
        this.name = name;
    }

    public void setAge(int age) {
        // System.out.println("set age");
        this.age = age;
    }

    public void setSchool(School school) {
        // System.out.println("set school "+school);
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

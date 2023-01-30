package com.example.StudentReportDB.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity(name = "student")
public class Student {
    @Id
    private int id;
    private  String name;
    private String gender;
    private int age;
    private String city;

    public Student() {
    }

    public Student(int id, String name, String gender, int age, String city) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}

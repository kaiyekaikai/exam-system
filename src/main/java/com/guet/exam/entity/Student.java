package com.guet.exam.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private int id;
    private String name;
    private String sex;
    private String dept;
    private String major;
    private String phone;
    private String faceVector;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaceVector() {
        return faceVector;
    }

    public void setFaceVector(String faceVector) {
        this.faceVector = faceVector;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", dept='" + dept + '\'' +
                ", major='" + major + '\'' +
                ", phone='" + phone + '\'' +
                ", faceVector='" + faceVector + '\'' +
                '}';
    }
}

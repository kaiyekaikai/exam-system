package com.guet.exam.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Teacher implements Serializable {
    private int id;
    private String name;
    private String sex;
    private String dept;
    private String phone;
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
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", dept='" + dept + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

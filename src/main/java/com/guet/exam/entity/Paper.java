package com.guet.exam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Paper implements Serializable {
    private int id;
    private String subject;
    private String major;
    private String active;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime startTime;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime endTime;
    private String tidId;
    private int qnum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getTidId() {
        return tidId;
    }

    public void setTidId(String tidId) {
        this.tidId = tidId;
    }

    public int getQnum() {
        return qnum;
    }

    public void setQnum(int qnum) {
        this.qnum = qnum;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", major='" + major + '\'' +
                ", active='" + active + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", tidId='" + tidId + '\'' +
                ", qnum=" + qnum +
                '}';
    }
}

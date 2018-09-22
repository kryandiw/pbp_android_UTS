package com.example.ryandiwdjj.login_test2;

public class MatKulDAO {

    private String name;
    private String teacher;
    private String room;
    private int thumbnail;

    public MatKulDAO() {
    }

    public MatKulDAO(String name, String teacher, String room) {
        this.name = name;
        this.teacher = teacher;
        this.room = room;
        //this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getRoom() {
        return room;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setRoom(String room) {
        this.room = room;
    }

}


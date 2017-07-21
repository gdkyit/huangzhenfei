package com.example.demo.entity;


import java.util.Date;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public class User {
    private  int id;
    private  String title;
    private  String content;
    private Date time;
    private byte yxbz;

    public int getId(){
        return id;
    }
    public void setId(int Id){
        this.id = id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){ this.title = title;}

    public String getContent(){return content;}
    public void setContent(String content){
        this.content = content;
    }

    public Date getTime(){
        return time;
    }

    public void setTime(Date time){
        this.time = time;
    }
    public byte getYxbz(){
        return yxbz;
    }
    public void setYxbz(byte yxbz){
        this.yxbz = yxbz;
    }

    @Override
    public String toString(){
        return "User{"+
                "id=" + id +
                ", title='" + title + '\''+
                ",content=" + content + '\'' +
                ", time=" + time +
                ", yxbz=" + yxbz +
                '}';
    }

}


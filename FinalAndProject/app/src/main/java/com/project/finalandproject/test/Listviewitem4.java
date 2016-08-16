package com.project.finalandproject.test;

import java.util.Date;

/**
 * Created by Administrator on 2016-08-03.
 */
public class Listviewitem4 {
    private int icon;
    private String message;
    private Date date;
    private String id;
    private String num;
    private int type;//자기의 메세지인지 구분
    public Date getDate(){return date;}
    public String getId(){return id;}
    public int getIcon(){return icon;}
    public String getMessage(){return message;}
    public String getNum(){return num;}
    public int getType(){return type;}
    public Listviewitem4(int icon, String message, String num, Date date,String id,int type){
        this.icon=icon;
        this.message=message;
        this.date=date;
        this.num=num;
        this.id=id;
        this.type=type;
        //icon,message,GATHERING_NUM,date,id
        //채팅창 매개변수
        //출력 : 프로필, 메세지, 날짜
        //히든 : 그룹번호, 아이디
    }
}

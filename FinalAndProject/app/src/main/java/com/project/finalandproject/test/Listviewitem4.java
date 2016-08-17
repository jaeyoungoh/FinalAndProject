package com.project.finalandproject.test;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2016-08-03.
 */
public class Listviewitem4 {
    private int icon;
    private String message;
    private String date;
    private String id;
    private String num;
    private int type;//자기의 메세지인지 구분
    public String getDate(){return date;}
    public String getId(){return id;}
    public int getIcon(){return icon;}
    public String getMessage(){return message;}
    public String getNum(){return num;}
    public int getType(){
        Log.i("type2",message+"ss"+type);
        return type;}
    public Listviewitem4(int icon, String message, String num, Date date,String id,int type){
        this.icon=icon;
        this.message=message;
        SimpleDateFormat sdf = new SimpleDateFormat("aa h:mm", new Locale("ko", "KR"));
        this.date= sdf.format(date);
        //
        //android.text.format.DateFormat.format("aa h:mm", date).toString();
        //new SimpleDateFormat("dd-MMM-yyyy hh:mm", new Locale("en", "US"))
        //new Date(2016,8,16)Log.i("date",android.text.format.DateFormat.format("yy/MM/dd h:mmaa", new Date(2016,8,16)));
        this.num=num;
        this.id=id;
        this.type=type;
        //icon,message,GATHERING_NUM,date,id
        //채팅창 매개변수
        //출력 : 프로필, 메세지, 날짜
        //히든 : 그룹번호, 아이디
    }

    @Override
    public String toString() {
        return getDate()+" mess "+getMessage()+" num "+getNum()+"  type "+getType();
    }
}

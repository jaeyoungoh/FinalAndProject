package com.project.finalandproject.test;

/**
 * Created by Administrator on 2016-08-03.
 */
public class Listviewitem3 {
    private int icon;
    private String name;
    private String information;
    private String num;
    public int getIcon(){return icon;}
    public String getName(){return name;}
    public String getNum(){return num;}
    public String getInformation(){return information;}
    public Listviewitem3(int icon, String name,String num,String information){
        this.icon=icon;
        this.name=name;
        this.information=information;
        this.num=num;
    }
}

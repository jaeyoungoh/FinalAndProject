package com.project.finalandproject.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 김희윤 on 2016-08-18.
 */
public class MeettingDTO implements Serializable {
    private int meeting_num;
    private String meetting_title;
    private String meetting_content;
    private int meetting_gathering_num;
    private String meetting_join_member;
    private String meetting_event_date;
    private String meetting_location;
    private String meetting_location_title;
    private String meetting_date;

    public MeettingDTO(int meeting_num,String meetting_title,String meetting_content,int meetting_gathering_num,String meetting_join_member,Date meetting_event_date,String meetting_location,String meetting_location_title,Date meetting_date){
        this.meeting_num=meeting_num;
        this.meetting_content=meetting_content;
        this.meetting_date=meetting_date.toString();
        this.meetting_gathering_num=meetting_gathering_num;
        this.meetting_join_member=meetting_join_member;
        this.meetting_event_date=meetting_event_date.toString();
        this.meetting_location=meetting_location;
        this.meetting_location_title=meetting_location_title;
        this.meetting_title=meetting_title;
    }

    public MeettingDTO(String meetting_title,String meetting_content,int meetting_gathering_num,String meetting_join_member,Date meetting_event_date,String meetting_location,String meetting_location_title,Date meetting_date){
        this.meeting_num=meeting_num;
        this.meetting_content=meetting_content;
        this.meetting_date=meetting_date.toString();
        this.meetting_gathering_num=meetting_gathering_num;
        this.meetting_join_member=meetting_join_member;
        this.meetting_event_date=meetting_event_date.toString();
        this.meetting_location=meetting_location;
        this.meetting_location_title=meetting_location_title;
        this.meetting_title=meetting_title;
    }

    public Date getMeetting_date() {
        return new Date(meetting_date) ;
    }

    public Date getMeetting_event_date() {
        return new Date(meetting_event_date);
    }

    public int getMeeting_num() {
        return meeting_num;
    }

    public int getMeetting_gathering_num() {
        return meetting_gathering_num;
    }

    public String getMeetting_content() {
        return meetting_content;
    }

    public String getMeetting_join_member() {
        return meetting_join_member;
    }

    public String getMeetting_location() {
        return meetting_location;
    }

    public String getMeetting_title() {
        return meetting_title;
    }
}

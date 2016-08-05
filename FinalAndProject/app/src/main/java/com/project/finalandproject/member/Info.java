package com.project.finalandproject.member;

import android.os.StrictMode;
import android.util.Log;

import com.project.finalandproject.dto.MemberDTO;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-04.
 */
public class Info {

    public static String USER_ID="";
    public static String USER_NAME="";

    public static boolean connServer(String type, Object obj){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        InputStream is=null;
        StrictMode.setThreadPolicy(policy);

        String requestURL = "";

        List<NameValuePair> paramList = new ArrayList<>();


        if(type.equals("login")){

            requestURL = "http://192.168.14.31:8805/finalproject/login.do";
            paramList.add(new BasicNameValuePair("id", ((MemberDTO) obj).getId()));
            paramList.add(new BasicNameValuePair("pwd", ((MemberDTO) obj).getPwd()));

        } else if(type.equals("join")){

            requestURL = "http://192.168.14.31:8805/finalproject/join.do";
            paramList.add(new BasicNameValuePair("name", ((MemberDTO) obj).getName()));
            paramList.add(new BasicNameValuePair("id", ((MemberDTO) obj).getId()));
            paramList.add(new BasicNameValuePair("pwd", ((MemberDTO) obj).getPwd()));
            paramList.add(new BasicNameValuePair("email", ((MemberDTO) obj).getEmail()));

        } else if(type.equals("makeProfile")){

            paramList.add(new BasicNameValuePair("id", USER_ID));
            paramList.add(new BasicNameValuePair("interest", ((MemberDTO) obj).getInterest()));
            paramList.add(new BasicNameValuePair("location", ((MemberDTO) obj).getLocation()));
            paramList.add(new BasicNameValuePair("post", ((MemberDTO) obj).getPost()));
            paramList.add(new BasicNameValuePair("address", ((MemberDTO) obj).getAddress()));
            paramList.add(new BasicNameValuePair("sex", ((MemberDTO) obj).getSex()));
            paramList.add(new BasicNameValuePair("phone", ((MemberDTO) obj).getPhone()));

        }



        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(requestURL);
        try {
            post.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            int chkNum = is.read();
            if(chkNum==49){
                Log.d(type, "성공");
                if(type.equals("login") || type.equals("join")){
                    USER_ID = ((MemberDTO)obj).getId();
                    USER_NAME = ((MemberDTO)obj).getName();
                }
                Log.d("login ID:", USER_ID);
                return true;
            } else {
                Log.d(type, "실패");
                return false;
            }

        } catch (Exception e) {
            Log.d("sendPost===> ", e.toString());
        }finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        return true;
    }



}

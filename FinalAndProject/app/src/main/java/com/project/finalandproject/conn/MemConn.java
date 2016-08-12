package com.project.finalandproject.conn;

import android.os.StrictMode;
import android.util.Log;

import com.project.finalandproject.dto.MemberDTO;
import com.project.finalandproject.member.MemInfo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-11.
 */
public class MemConn {
    static private String requestURL=null;
    static private List<NameValuePair> setParamList(String type, Object obj){
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
            requestURL = "http://192.168.14.31:8805/finalproject/makeprofile.do";
            paramList.add(new BasicNameValuePair("id", MemInfo.USER_ID));
            paramList.add(new BasicNameValuePair("interest", ((MemberDTO) obj).getInterest()));
            paramList.add(new BasicNameValuePair("location", ((MemberDTO) obj).getLocation()));
            paramList.add(new BasicNameValuePair("post", ((MemberDTO) obj).getPost()));
            paramList.add(new BasicNameValuePair("address", ((MemberDTO) obj).getAddress()));
            paramList.add(new BasicNameValuePair("sex", ((MemberDTO) obj).getSex()));
            paramList.add(new BasicNameValuePair("phone", ((MemberDTO) obj).getPhone()));
        }
        return paramList;
    }

    public static Object getJSONDatas(String type, Object obj){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        InputStream is=null;
        StrictMode.setThreadPolicy(policy);
        List<NameValuePair> paramList = setParamList(type, obj);
        BufferedReader rd = null;
        JSONObject JSONObj =null;

        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(requestURL);
            post.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();

            StringBuffer sb = new StringBuffer();
            String line = null;
            rd = new BufferedReader(new InputStreamReader(is));
            while((line = rd.readLine()) != null) {
                sb.append(line);
            }

            //로그인과 회원가입시 JSONOBJECT 파싱
            if(type.equals("join")||type.equals("login")){
                JSONParser parser =  new JSONParser();
                JSONObj = (JSONObject)parser.parse(sb.toString());
                Log.i("============>>>>>>>","JSON 넘어온 값"+sb.toString());
            }else if(type.equals("info")){

            }

        } catch (Exception e) {
            Log.d("sendPost===> ", e.toString());
        }finally {
            try {
                if (is != null) {
                    is.close();
                }
                if(rd != null){
                    rd.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }

        }
        return JSONObj;
    }
}

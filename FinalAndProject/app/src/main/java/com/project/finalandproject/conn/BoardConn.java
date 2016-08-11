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
public class BoardConn {
    static private String requestURL=null;

    static private List<NameValuePair> connController(String type, Object obj){
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

    public static boolean connServer(String type, Object obj){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        InputStream is=null;
        StrictMode.setThreadPolicy(policy);
        List<NameValuePair> paramList = connController(type, obj);

        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(requestURL);
            post.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
//            HttpResponse response = client.execute(post);
//            HttpEntity entity = response.getEntity();
//            is = entity.getContent();
//            int chkNum = is.read();
//            if(chkNum==49){
//                Log.d(type, "성공");
//                if(type.equals("login") || type.equals("join")){
//                    MemInfo.USER_ID = ((MemberDTO)obj).getId();
//                    MemInfo.USER_NAME = ((MemberDTO)obj).getName();
//                }
//                Log.d("login ID:", MemInfo.USER_ID);
//                return true;
//            } else {
//                Log.d(type, "실패");
//                return false;
//            }
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();

            StringBuffer sb = new StringBuffer();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while((line=rd.readLine()) != null){
                sb.append(line);
            }
            rd.close();
            is.close();
            JSONParser parser =  new JSONParser();
            JSONObject JSONobj = (JSONObject)parser.parse(sb.toString());
            Log.i("============>>>>>>>","JSON 넘어온 값"+sb.toString());
            Log.i("============>>>>>>>","JSON 넘어온 값"+JSONobj.get("msg").toString());

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

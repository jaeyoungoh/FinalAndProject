package com.project.finalandproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-02.
 */
public class Mem_Join_Page extends Activity {

    String member_name, member_id, member_pwd, member_email, category;

    Intent intent;
    Button goback, cancle, joinsubmit;
    int texts[] = {R.id.join_name_txt, R.id.join_id_txt, R.id.join_pass_txt, R.id.join_email_txt};
    EditText edtTxt[] = new EditText[texts.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memjoin_page);
        goback = (Button) findViewById(R.id.goback);
        cancle = (Button) findViewById(R.id.cancle);
        joinsubmit = (Button) findViewById(R.id.joinsubmit);
        for (int i = 0; i < texts.length; i++) {
            edtTxt[i] = (EditText) findViewById(texts[i]);
        }


    }


    public void SubmitJoin(View v) { //조인 부분

            member_name =edtTxt[0].getText().toString();
            member_id = edtTxt[1].getText().toString();
            member_pwd = edtTxt[2].getText().toString();
            member_name = edtTxt[3].getText().toString();
            member_email = edtTxt[4].getText().toString();
            category = "mvcIns";


        String requestURL = "http://192.168.14.20:8805/gogoJDBC/andController.do";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(requestURL);
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair("member_name", member_name));
        paramList.add(new BasicNameValuePair("member_id", member_id));
        paramList.add(new BasicNameValuePair("member_pwd", member_pwd));
        paramList.add(new BasicNameValuePair("member_name", member_name));
        paramList.add(new BasicNameValuePair("member_email", member_email));
        paramList.add(new BasicNameValuePair("category", category));


        try {
            post.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
            HttpResponse response = client.execute(post);
        } catch (Exception e) {
            Log.d("sendPost===> ", e.toString());
        }


    }



    public void Cancle(View v) { //취소 부분
        if (v.getId() == cancle.getId()) {
            for (int i = 0; i < texts.length; i++) {
                edtTxt[i].setText("");
            }
        }
    }


    public void Goback(View v) { //뒤로가기 부분
        if (v.getId() == goback.getId()) {
            intent = new Intent(getApplication(), Main_Page.class);
            startActivity(intent);
        }
    }
}

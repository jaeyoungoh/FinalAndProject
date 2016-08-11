package com.project.finalandproject.member;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.finalandproject.Main_Page2;
import com.project.finalandproject.R;

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
public class Mem_Modify_Page extends Activity {

    String member_name, member_id, member_pwd, member_email;

    Intent intent;
    Button cancle, modifysubmit;
    int texts[] = {R.id.modify_name_txt, R.id.modify_id_txt, R.id.modify_pass_txt, R.id.modify_email_txt};
    EditText edtTxt[] = new EditText[texts.length];



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_menu_layout);
        LinearLayout container=(LinearLayout) findViewById(R.id.container);
        TextView title=(TextView) findViewById(R.id.title);
        TextView next=(TextView) findViewById(R.id.next);
        next.setText("수정");
        title.setText("회원수정");
        ImageButton back=(ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.mem_modify_page, container,true);
        cancle = (Button) findViewById(R.id.cancle);
        modifysubmit = (Button) findViewById(R.id.modifysubmit);
        for (int i = 0; i < texts.length; i++) {
            edtTxt[i] = (EditText) findViewById(texts[i]);
        }

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }


    public void SubmitModify(View v) { //조인 부분

        member_name = edtTxt[0].getText().toString();
        member_id = edtTxt[1].getText().toString();
        member_pwd = edtTxt[2].getText().toString();
        member_email = edtTxt[3].getText().toString();


        String requestURL = "http://192.168.14.31:8805/finalproject/join.do";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(requestURL);
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair("name", member_name));
        paramList.add(new BasicNameValuePair("id", member_id));
        paramList.add(new BasicNameValuePair("pwd", member_pwd));
        paramList.add(new BasicNameValuePair("email", member_email));


        try {
            post.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
            HttpResponse response = client.execute(post);
        } catch (Exception e) {
            Log.d("sendPost===> ", e.toString());
        }

        Toast.makeText(getApplicationContext(), "수정완료", Toast.LENGTH_LONG).show();
        intent = new Intent(getApplication(), Main_Page2.class);
        startActivity(intent);
        finish();
    }


    public void Cancle(View v) { //취소 부분
        if (v.getId() == cancle.getId()) {
            for (int i = 0; i < texts.length; i++) {
                edtTxt[i].setText("");
            }
        }
    }


}

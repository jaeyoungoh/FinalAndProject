package com.project.finalandproject.member;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.project.finalandproject.Main_Page;
import com.project.finalandproject.R;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016-07-14.
 */
public class Mem_Category_Interest extends Activity {
    int ckall = 0;
    String member_interest;
    Intent intent;
    Button chk, back;
    CheckBox allbox;
    int checkboxs[] = {R.id.checkbox_travel, R.id.checkbox_sport, R.id.checkbox_books,
            R.id.checkbox_language, R.id.checkbox_volunteer, R.id.checkbox_free};
    CheckBox checkbox[] = new CheckBox[checkboxs.length];
    int total = 0;
    String retxt = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mem_category_interest);
        chk = (Button) findViewById(R.id.chk);
        back = (Button) findViewById(R.id.back);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        for (int i = 0; i < checkboxs.length; i++) {
            checkbox[i] = (CheckBox) findViewById(checkboxs[i]);
        }


    }


    public void onCheckboxClicked(View view) {
        if (view instanceof CheckBox) {
            boolean checked = ((CheckBox) view).isChecked();

        /*    if (view.getId() == allbox.getId() && checked) { //모두선택
                for (int p = 0; p < 6; p++) {
                    checkbox[p].setChecked(true);
                }
                Toast.makeText(getApplicationContext(), "전체 선택", Toast.LENGTH_SHORT).show();
            } else if (view.getId() == allbox.getId() && !checked) {
                for (int p = 0; p < 6; p++) {
                    checkbox[p].setChecked(false);
                }
                Toast.makeText(getApplicationContext(), "전체 선택 해제", Toast.LENGTH_SHORT).show();
            }*/

            for (int i = 0; i < checkboxs.length; i++) {
                if (view.getId() == checkbox[i].getId()) {

                } else if (view.getId() == checkbox[0].getId() && checked) { //아웃도어/여행

                    Toast.makeText(getApplicationContext(), checkbox[0].getText() + " 선택", Toast.LENGTH_SHORT).show();


                } else if (view.getId() == checkbox[0].getId() && !checked) {

                    Toast.makeText(getApplicationContext(), checkbox[0].getText() + " 선택 해제", Toast.LENGTH_SHORT).show();

                } else if (view.getId() == checkbox[1].getId() && checked) { //운동/스포츠

                    Toast.makeText(getApplicationContext(), checkbox[1].getText() + " 선택", Toast.LENGTH_SHORT).show();

                } else if (view.getId() == checkbox[1].getId() && !checked) {

                    Toast.makeText(getApplicationContext(), checkbox[1].getText() + " 선택 해제", Toast.LENGTH_SHORT).show();

                } else if (view.getId() == checkbox[2].getId() && checked) { //인문학/책/글

                    Toast.makeText(getApplicationContext(), checkbox[2].getText() + " 선택", Toast.LENGTH_SHORT).show();

                } else if (view.getId() == checkbox[2].getId() && !checked) {

                    Toast.makeText(getApplicationContext(), checkbox[2].getText() + " 선택 해제", Toast.LENGTH_SHORT).show();

                } else if (view.getId() == checkbox[3].getId() && checked) {//외국/언어

                    Toast.makeText(getApplicationContext(), checkbox[3].getText() + " 선택", Toast.LENGTH_SHORT).show();

                } else if (view.getId() == checkbox[3].getId() && !checked) {

                    Toast.makeText(getApplicationContext(), checkbox[3].getText() + " 선택 해제", Toast.LENGTH_SHORT).show();

                } else if (view.getId() == checkbox[4].getId() && checked) { //봉사활동

                    Toast.makeText(getApplicationContext(), checkbox[4].getText() + " 선택", Toast.LENGTH_SHORT).show();

                } else if (view.getId() == checkbox[4].getId() && !checked) {

                    Toast.makeText(getApplicationContext(), checkbox[4].getText() + " 선택 해제", Toast.LENGTH_SHORT).show();

                } else if (view.getId() == checkbox[5].getId() && checked) { //자유주제

                    Toast.makeText(getApplicationContext(), checkbox[5].getText() + " 선택", Toast.LENGTH_SHORT).show();

                } else if (view.getId() == checkbox[5].getId() && !checked) {

                    Toast.makeText(getApplicationContext(), checkbox[5].getText() + " 선택 해제", Toast.LENGTH_SHORT).show();
                }
            }
        }



    if(view.getId()==chk.getId())

    {

        member_interest = "";
        total=0;
        for (int j = 0; j < checkboxs.length; j++) {
            if (checkbox[j].isChecked()) {
                member_interest += checkbox[j].getText().toString() + ",";
                total++;
            }
        }
        if (total < 2) {
            Toast.makeText(getApplicationContext(), "최소2개부터 선택 가능합니다."+total, Toast.LENGTH_LONG).show();
        } else if (total >= 6) {
            Toast.makeText(getApplicationContext(), "최대5개까지만 선택 가능합니다."+total, Toast.LENGTH_LONG).show();
        } else {

            String requestURL = "http://192.168.14.31:8805/finalproject/join.do";

            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(requestURL);
            List<NameValuePair> paramList = new ArrayList<>();
            paramList.add(new BasicNameValuePair("interest", member_interest));

            Toast.makeText(getApplicationContext(), member_interest, Toast.LENGTH_LONG).show();
            intent = new Intent(getApplication(), Mem_Join_Success_page.class);
            startActivity(intent);


                    /*    String requestURL = "http://192.168.14.31:8805/finalproject/join.do";

            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(requestURL);
            List<NameValuePair> paramList = new ArrayList<>();
            paramList.add(new BasicNameValuePair("interest", member_interest));

            try {
                post.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
                HttpResponse response = client.execute(post);
            } catch (Exception e) {
                Log.d("sendPost===> ", e.toString());
            }
*/
        }

    }


    if(view.getId()==back.getId())

    {
        intent = new Intent(getApplication(), Main_Page.class);
        startActivity(intent);
    }
}
}








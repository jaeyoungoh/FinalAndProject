package com.project.finalandproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.finalandproject.dto.MemberDTO;
import com.project.finalandproject.member.Info;
import com.project.finalandproject.member.Mem_Join_Page;
import com.project.finalandproject.naver.OAuthSampleActivity;

/**
 * Created by Administrator on 2016-08-02.
 */
public class Main_Page2 extends Activity {

    Intent intent;
    Button naverbt, Logbt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        naverbt = (Button) findViewById(R.id.Log_naver);
        Logbt = (Button) findViewById(R.id.Log);



        Logbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplication(), Main_page3.class);
                startActivity(intent);

            }
        });


        naverbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplication(), OAuthSampleActivity.class);
                startActivity(intent);
            }
        });


    }



}

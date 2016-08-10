package com.project.finalandproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.project.finalandproject.dto.MemberDTO;
import com.project.finalandproject.member.Info;
import com.project.finalandproject.member.Mem_Join_Page;
import com.project.finalandproject.test.Test_Menu_Activity;

/**
 * Created by 김희윤 on 2016-08-08.
 */
public class Main_page3 extends Activity{
    EditText member_id,member_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page2);
        member_id = (EditText)findViewById(R.id.num1);
        member_pwd = (EditText)findViewById(R.id.num2);
    }


    public void Join(View v){
        Intent intent = new Intent(getApplication(), Mem_Join_Page.class);
        startActivity(intent);
        finish();
    }

    public void Login(View v){

        Log.d("로그인","버튼누름");
        MemberDTO m = new MemberDTO();
        m.setId(member_id.getText().toString());
        m.setPwd(member_pwd.getText().toString());

        if(Info.connServer("login", m)){
            Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplication(), Test_Menu_Activity.class);
            startActivity(intent);
            finish();
        } else
            Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();


    }
}

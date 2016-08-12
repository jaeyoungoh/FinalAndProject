package com.project.finalandproject.member;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.finalandproject.R;
import com.project.finalandproject.conn.MemConn;
import com.project.finalandproject.dto.MemberDTO;

import org.json.simple.JSONObject;


public class Mem_Join_Page extends Activity {

    String member_name, member_id, member_pwd, member_email, category;

    Intent intent;
    Button goback, cancle, joinsubmit;
    int texts[] = {R.id.join_name_txt, R.id.join_id_txt, R.id.join_pass_txt, R.id.join_email_txt};
    EditText edtTxt[] = new EditText[texts.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_menu_layout);
        LinearLayout container=(LinearLayout) findViewById(R.id.container);
        TextView title=(TextView) findViewById(R.id.title);
        TextView next=(TextView) findViewById(R.id.next);
        next.setText("가입");
        title.setText("회원가입");
        ImageButton back=(ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.mem_join_page, container,true);
        cancle = (Button) findViewById(R.id.cancle);
        joinsubmit = (Button) findViewById(R.id.joinsubmit);
        for (int i = 0; i < texts.length; i++) {
            edtTxt[i] = (EditText) findViewById(texts[i]);
        }

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }


    public void SubmitJoin(View v) { //조인 부분

        member_name = edtTxt[0].getText().toString();
        member_id = edtTxt[1].getText().toString();
        member_pwd = edtTxt[2].getText().toString();
        member_email = edtTxt[3].getText().toString();

        MemberDTO dto = new MemberDTO();
        dto.setName(member_name);
        dto.setId(member_id);
        dto.setPwd(member_pwd);
        dto.setEmail(member_email);


        JSONObject Jobj =null;
        try {
            Jobj = MemConn.getJSONDatas("join", dto);

            if (Jobj.get("msg").toString().equals("Success")) {
                Toast.makeText(getApplicationContext(), "가입완료", Toast.LENGTH_LONG).show();
                MemInfo.USER_ID = dto.getId();
                MemInfo.USER_NAME = dto.getName();
                intent = new Intent(getApplication(), Mem_Category_Interest.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "가입실패", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "가입실패", Toast.LENGTH_LONG).show();
        }
    }


    public void Cancle(View v) { //취소 부분
        if (v.getId() == cancle.getId()) {
            for (int i = 0; i < texts.length; i++) {
                edtTxt[i].setText("");
            }
        }
    }


}


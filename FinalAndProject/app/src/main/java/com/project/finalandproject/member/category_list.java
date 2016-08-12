package com.project.finalandproject.member;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.finalandproject.R;
import com.project.finalandproject.dto.GatheringDTO;
import com.project.finalandproject.dto.MemberDTO;
import com.project.finalandproject.test.Test_Menu_Activity;

/**
 * Created by Administrator on 2016-08-10.
 */
public class category_list extends Activity{
    int count=0;
    String categorytxt="";
    Intent intent;
    TextView next;
    MemberDTO dto;
    GatheringDTO dto2;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_menu_layout);
        intent=getIntent();
        type=intent.getStringExtra("type");
        if(type.equals("mjoin")) {
            dto = (MemberDTO) intent.getSerializableExtra("dto");
        }else{
            dto2=(GatheringDTO)intent.getSerializableExtra("dto");
        }

        LinearLayout container=(LinearLayout) findViewById(R.id.container);
        TextView title=(TextView) findViewById(R.id.title);
        next=(TextView) findViewById(R.id.next);
        next.setText("건너뛰기");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    intent=new Intent(getApplication(), Test_Menu_Activity.class);
                    if(dto!=null) {
                        intent.putExtra("dto",dto);
                        intent.putExtra("type","mjoin");
                        Log.i("11dto",dto.toString());
                        //회원가입 DB연동

                    }else {
                        intent.putExtra("dto",dto2);
                        intent.putExtra("type","gjoin");
                        Log.i("11dto",dto2.toString());
                        //그룹만들기 DB연동.
                    }
                    startActivity(intent);
            }
        });
        title.setText("카테고리선택");
        ImageButton back=(ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.category, container,true);
        final GridLayout category=(GridLayout) findViewById(R.id.category);
        for(int i=0;i<category.getChildCount();i++){
            category.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        select(view);
                }
            });
        }
    }

    private void select(View view){

            if(categorytxt.indexOf((((Button) view).getText().toString() + ","))!=-1) {
                count--;
                categorytxt = categorytxt.replace((((Button) view).getText().toString() + ","), "");
                view.setSelected(false);
                if(count==0){
                    next.setText("건너뛰기");
                    if(type.equals("mjoin")){
                        dto.setInterest(null);
                    }else{
                        dto2.setGathering_category(null);
                    }
                }
            }else{
            if(count<3) {
                count++;
                categorytxt += ((Button) view).getText().toString() + ",";
                view.setSelected(true);
                next.setText("다음");
                if(type.equals("mjoin")){
                    dto.setInterest(categorytxt);

                }else{
                    dto2.setGathering_category(categorytxt);

                }
            }else
            {
                Toast.makeText(getApplicationContext(),"카테고리는 3개만 선택해 주세요.",Toast.LENGTH_SHORT).show();
            }
            }
        Log.i("category",categorytxt+","+count);



    }
}

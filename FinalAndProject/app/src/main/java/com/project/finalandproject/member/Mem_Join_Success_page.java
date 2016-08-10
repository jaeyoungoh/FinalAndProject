package com.project.finalandproject.member;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.finalandproject.Main_Page2;
import com.project.finalandproject.R;

/**
 * Created by Administrator on 2016-08-04.
 */
public class Mem_Join_Success_page extends Activity {

    Button join_success_bt;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mem_join_success_page);
        join_success_bt = (Button) findViewById(R.id.join_success_bt);

    }

    public void GoToMain(View v){
        if(v.getId()==join_success_bt.getId()){
            Intent intent = new Intent(getApplication(), Main_Page2.class);
            startActivity(intent);
            finish();
        }

    }
}

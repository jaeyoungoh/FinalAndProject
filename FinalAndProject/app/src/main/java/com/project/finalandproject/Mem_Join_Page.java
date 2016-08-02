package com.project.finalandproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016-08-02.
 */
public class Mem_Join_Page extends Activity {

    Intent intent;
    Button goback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memjoin_page);
        goback = (Button) findViewById(R.id.goback);


    }


    public void Goback (View v){
        if(v.getId()==goback.getId()){
            intent = new Intent(getApplication(), Main_Page.class);
            startActivity(intent);
        }
    }
}

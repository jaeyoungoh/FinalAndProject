package com.project.finalandproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016-08-02.
 */
public class Main_Page extends Activity {

    Intent intent;
    Button Joinbt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        Joinbt = (Button)findViewById(R.id.joinbt);


    }

    public void Joinbt(View v){
        if(v.getId()==Joinbt.getId()){
            intent = new Intent(getApplication(), Mem_Join_Page.class);
            startActivity(intent);
        }
    }


}

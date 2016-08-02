package com.project.finalandproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 2016-08-02.
 */
public class Mem_Join_Page extends Activity {

    Intent intent;
    Button goback,cancle;
    int texts[] = {R.id.join_name_txt, R.id.join_id_txt, R.id.join_pass_txt, R.id.join_email_txt};
    EditText edtTxt[] = new EditText[texts.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memjoin_page);
        goback = (Button) findViewById(R.id.goback);
        cancle = (Button) findViewById(R.id.cancle);
        for (int i=0; i<texts.length; i++){
            edtTxt[i] = (EditText)findViewById(texts[i]);
        }


    }

    public void Cancle(View v){
        if(v.getId()==cancle.getId()){
            for (int i=0; i<texts.length; i++){
                edtTxt[i].setText("");
            }
        }
    }


    public void Goback (View v){
        if(v.getId()==goback.getId()){
            intent = new Intent(getApplication(), Main_Page.class);
            startActivity(intent);
        }
    }
}

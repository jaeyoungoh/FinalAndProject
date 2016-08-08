package com.project.finalandproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by 김희윤 on 2016-08-04.
 */
public class login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        LinearLayout logintype=(LinearLayout) findViewById(R.id.logintype);
        for(int i=0;i<logintype.getChildCount();i++){
            final Class c1[]={Main_Page.class,Main_Page.class};
            logintype.getChildAt(i).setId(i);
            logintype.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(getApplicationContext(),c1[view.getId()]);
                    finish();
                    startActivity(intent);

                }
            });
        }
    }
}

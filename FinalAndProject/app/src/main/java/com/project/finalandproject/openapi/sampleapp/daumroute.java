package com.project.finalandproject.openapi.sampleapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by 김희윤 on 2016-08-04.
 */
public class daumroute extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout=new LinearLayout(this);
        setContentView(linearLayout);
        EditText tv=new EditText(this);
        tv.setText(getIntent().getData().getScheme()+"://"+getIntent().getData().getHost()+"?"+getIntent().getData().getQuery());
        linearLayout.addView(tv);
    }
}

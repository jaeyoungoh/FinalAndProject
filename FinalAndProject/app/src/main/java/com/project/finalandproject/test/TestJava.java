package com.project.finalandproject.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.project.finalandproject.R;

/**
 * Created by Administrator on 2016-08-03.
 */
public class TestJava extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testholdtitle);
        LinearLayout container = (LinearLayout) findViewById(R.id.containerInflater);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.test_top, container,true);



    }
}

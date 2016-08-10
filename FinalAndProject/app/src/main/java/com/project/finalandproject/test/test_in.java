package com.project.finalandproject.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.project.finalandproject.R;

/**
 * Created by 김희윤 on 2016-08-10.
 */
public class test_in extends LinearLayout {

    Context context;
    public test_in(Context context){
        super(context);
        excute(context);
    }

    public void excute(Context context) {
        this.context = context;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.main_page2, this, true);
    }
}


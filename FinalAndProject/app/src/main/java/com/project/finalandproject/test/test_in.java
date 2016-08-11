package com.project.finalandproject.test;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;
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
        this.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        inflater.inflate(R.layout.mem_join_page, this, true);
    }


}


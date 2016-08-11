package com.project.finalandproject.gathering;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.project.finalandproject.R;

/**
 * Created by Administrator on 2016-08-11.
 */
public class Gathering_Search_Page extends Activity{

    int radios[] = {R.id.radio_man,R.id.radio_woman,R.id.radio_dontcaresex};
    int serachbts[] = {R.id.title_search_bt,R.id.sex_search_bt,R.id.area_search_bt,R.id.hashtag_search_bt,
    R.id.total_search_bt};
    RadioButton radiobt[] = new RadioButton[radios.length];
    Button serachbt[] = new Button[serachbts.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gathering_search_page);
        Spinner spinnerarea=(Spinner)findViewById(R.id.spinner_area);
        ArrayAdapter areaAdapter = ArrayAdapter.createFromResource(this,R.array.area,android.R.layout.simple_spinner_dropdown_item);
        spinnerarea.setAdapter(areaAdapter);

        for(int j=0; j<radios.length; j++){
            radiobt[j] = (RadioButton)findViewById(radios[j]);
        }

        for(int i=0; i<serachbts.length; i++){
            serachbt[i] = (Button)findViewById(serachbts[i]);
        }
    }

    public void StartSearch (View v){
        if(v.getId()==serachbt[0].getId()){

        }

    }
}

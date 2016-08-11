package com.project.finalandproject.gathering;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.project.finalandproject.R;

/**
 * Created by Administrator on 2016-08-11.
 */
public class Gathering_Search_Page extends Activity {


    String title, sex, area, hash;
    Intent intent;

    int radios[] = {R.id.radio_man, R.id.radio_woman, R.id.radio_dontcaresex};
    int serachbts[] = {R.id.title_search_bt, R.id.sex_search_bt, R.id.area_search_bt, R.id.hashtag_search_bt,
            R.id.total_search_bt};
    RadioButton radiobt[] = new RadioButton[radios.length];
    Button serachbt[] = new Button[serachbts.length];
    Button cancle;
    EditText search_title_txt, hashtag_search_txt;
    Spinner spinnerarea;
    ArrayAdapter areaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gathering_search_page);
        search_title_txt = (EditText) findViewById(R.id.search_title_txt);
        hashtag_search_txt = (EditText) findViewById(R.id.hashtag_search_txt);
        cancle = (Button)findViewById(R.id.cancle);

        spinnerarea = (Spinner) findViewById(R.id.spinner_area);
        areaAdapter = ArrayAdapter.createFromResource(this, R.array.area, android.R.layout.simple_spinner_dropdown_item);
        spinnerarea.setAdapter(areaAdapter);

        for (int j = 0; j < radios.length; j++) {
            radiobt[j] = (RadioButton) findViewById(radios[j]);
        }

        for (int i = 0; i < serachbts.length; i++) {
            serachbt[i] = (Button) findViewById(serachbts[i]);
        }
    }

    public void StartSearch(View v) {

        if (v.getId() == serachbt[0].getId()) { //제목부분 체크
            title = search_title_txt.getText().toString();
            Toast.makeText(getApplicationContext(), title, Toast.LENGTH_LONG).show();

        } else if (v.getId() == serachbt[1].getId()) {  //성별 체크
            for (int i = 0; i < radios.length; i++) {
                if (radiobt[i].isChecked()) {   //라디오버튼 클릭되었는지 체크하는 부분
                    sex = radiobt[i].getText().toString();
                }
            }
            Toast.makeText(getApplicationContext(), sex, Toast.LENGTH_LONG).show();

        } else if (v.getId() == serachbt[2].getId()) { //지역 부분
            area = spinnerarea.getSelectedItem().toString();
            Toast.makeText(getApplicationContext(), area, Toast.LENGTH_LONG).show();

        } else if (v.getId() == serachbt[3].getId()) { //해쉬태그부분
            hash = hashtag_search_txt.getText().toString();
            Toast.makeText(getApplicationContext(), hash, Toast.LENGTH_LONG).show();


        } else if (v.getId() == serachbt[4].getId()) {  //전체선택
            title = search_title_txt.getText().toString();
            for (int i = 0; i < radios.length; i++) {
                if (radiobt[i].isChecked()) {   //라디오버튼 클릭되었는지 체크하는 부분
                    sex = radiobt[i].getText().toString();
                }
            }
            area = spinnerarea.getSelectedItem().toString();
            hash = hashtag_search_txt.getText().toString();

            if (title == null || sex == null || area == null || hash == null) { //Null 체크
                Toast.makeText(getApplicationContext(), "모두 입력후 눌러주세요.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), title + "//" + sex + "//" + area + "//" + hash, Toast.LENGTH_LONG).show();
            }
        }

    }

    public void Cancle (View v){
        if(v.getId()==cancle.getId()){
            intent = new Intent(getApplication(), Gathering_Search_Page.class);
            startActivity(intent);
            finish();
        }
    }
}

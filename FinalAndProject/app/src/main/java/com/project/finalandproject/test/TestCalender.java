package com.project.finalandproject.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.finalandproject.R;


public class TestCalender extends Activity {

    CalendarView calendar;
    TextView text11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_calendar);
        calendar = (CalendarView) findViewById(R.id.calendar);
        text11 = (TextView)findViewById(R.id.text11);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayy) {
                month++;
                text11.setText(year+" 년 " + month +" 월 " + dayy+" 일 ");
                Toast.makeText(getApplicationContext(), "Year : " + year + "\n" +
                        "Month : " + month +  "\n" +
                        "Day : " + dayy, Toast.LENGTH_LONG).show();

            }
        });
    }
}

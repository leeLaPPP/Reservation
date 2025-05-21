package com.example.date_n_clock_0515;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private Button btnStart, btnFinish,btnreset;
    private RadioGroup radioGroup;
    private RadioButton radioDate, radioTime;
    private TimePicker timePicker;
    private DatePicker datePicker;
    private TextView year, month, day, hour, minute;
    
    // 선택된 날짜를 저장할 변수들
    private int selectYear, selectMonth, selectDay;
    private void result() {
        year.setText("0000");
        month.setText("00");
        day.setText("00");
        hour.setText("00");
        minute.setText("00");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnFinish = findViewById(R.id.btnFinish);
        radioGroup = findViewById(R.id.radioGroup);
        radioDate = findViewById(R.id.radioDate);
        radioTime = findViewById(R.id.radioTime);
        timePicker = findViewById(R.id.timePicker);
        datePicker = findViewById(R.id.datePicker);
        year = findViewById(R.id.year);
        month = findViewById(R.id.month);
        day = findViewById(R.id.day);
        hour = findViewById(R.id.hour);
        minute = findViewById(R.id.minute);
        chronometer = findViewById(R.id.chronometer1);
        btnreset = findViewById(R.id.btnreset);

        timePicker.setVisibility(View.INVISIBLE);
        datePicker.setVisibility(View.INVISIBLE);







        radioTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.VISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
            }
        });

        radioDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.VISIBLE);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                radioDate.setVisibility(View.VISIBLE);
                radioTime.setVisibility(View.VISIBLE);

            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                year.setText(Integer.toString(selectYear));
                month.setText(Integer.toString(selectMonth));
                day.setText(Integer.toString(selectDay));
                hour.setText(Integer.toString(timePicker.getHour()));
                minute.setText(Integer.toString(timePicker.getMinute()));
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                radioGroup.clearCheck();
                radioDate.setVisibility(View.INVISIBLE);
                radioTime.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
                chronometer.stop();
                chronometer.setBase(SystemClock.elapsedRealtime());
                result();
            }
        });

        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int month, int day) {
                selectYear = year;
                selectMonth = month + 1;
                selectDay = day;
            }
        });



    }
}
package com.dictionaryapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.Month;
import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity {

    private TextView tvDOB;
    private TextView tvTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        tvDOB = findViewById(R.id.tvDOB);
        tvTime = findViewById(R.id.tvTime);
        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });
        tvDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadCalendar();
            }
        });
    }

    private void loadCalendar() {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = "Month/Day/Year : " + month + "/" + dayOfMonth + "/" + year;
                tvDOB.setText(date);
            }
        },year,month,day);
        datePickerDialog.show();
    }

    private void loadTime() {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        final int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String amPm;
                if(hourOfDay>=12)
                {
                    hourOfDay-=12;
                    amPm = "PM";
                }
                else
                {
                    amPm="AM";
                }
                tvTime.setText(("Time is : " + hourOfDay + ":" + minute + " " + amPm).toString());
            }
        }, hour, minute, false);
        timePickerDialog.show();
    }
}
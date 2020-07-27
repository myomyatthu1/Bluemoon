package com.lightidea.bluemoon;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnBtn;
    TimePicker time;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBtn=(Button)findViewById(R.id.Btnbtn);
        time=(TimePicker) findViewById(R.id.time);
        time.setCurrentMinute(35);
        time.setMinute(35);
        btnBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                int day=calendar.get(Calendar.DAY_OF_MONTH);
                int month=calendar.get(Calendar.MONTH);
                int year=calendar.get(Calendar.YEAR);
                DatePickerDialog picker=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        btnBtn.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },year,month,day);
                picker.show();
            }
        });

    }
}
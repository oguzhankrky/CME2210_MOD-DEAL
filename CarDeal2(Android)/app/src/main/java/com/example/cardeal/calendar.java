package com.example.cardeal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class calendar extends AppCompatActivity {
    CalendarView calendarForm;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        calendarForm=(CalendarView)findViewById(R.id.CalendarView);
        calendarForm.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                CalendarToHour(view,year,month,dayOfMonth);
            }
        });

    }
    public  void CalendarToHour(View view, int year, int month, int dayOfMonth)// for go to the  next page and necessary values was sent.
    {
        Intent intent =new Intent(this,PickHour.class);
        intent.putExtra("year",year);
        intent.putExtra("month",month);
        intent.putExtra("dayOfMonth",dayOfMonth);
        startActivity(intent);
    }
    public  void CalendarToReg(View view)
    {
        Intent intents =new Intent(calendar.this,UserInput.class);
        startActivity(intents);
    }
}


package com.example.cardeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//  Service application result screen was added. Also printed.
public class ResultScreen extends AppCompatActivity {
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        Intent intent = getIntent();

        int y=intent.getIntExtra("year",2020);
        int m=intent.getIntExtra("month",1)+1;//on android studio january index is 0;
        int d=intent.getIntExtra("dayOfMonth",1);
        int hour=intent.getIntExtra("message",9);
        tv=(TextView)findViewById(R.id.lastText);
        User user=UserInput.getUser();

        String result="NAME SURNAME: "+user.getName()+" "+user.getSurname()+"\n"+
                "MAKE: "+user.getBrand()+"\n"+
                "PLATE: "+user.getPlate()+"\n"+
                "PHONE: "+user.getPhone()+"\n"+
                "DATE: " +d+"/"+m+"/"+y+"\n"+
                "HOUR: "+hour+":00 please be punctial\n"
                +"Please check the informations \n"+
                "If you want to return main screen please click main button";
        tv.setBackgroundColor(Color.DKGRAY);
        tv.setTextColor(Color.RED);
        tv.setTextIsSelectable(true);
        tv.setTextSize(14);
        tv.setText(result);
        btn =(Button)findViewById(R.id.main);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ResultScreen.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}

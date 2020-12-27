package com.example.cardeal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
// necessary time values was obtained.
public class PickHour extends AppCompatActivity implements View.OnClickListener {
    TextView selDate;
    TextView errorMessage;
    Button btnNine;
    Button btnTen;
    Button btnEleven;
    Button btnTwelve;
    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    boolean NINE=true;
    boolean TEN=true;
    boolean ELEVEN=true;
    boolean TWELVE=true;
    boolean ONE=true;
    boolean TWO=true;
    boolean THREE=true;
    boolean FOUR=true;
    int y;
    int m;
    int d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_hour);

        Intent intent = getIntent();
        y=intent.getIntExtra("year",2020);
        m=intent.getIntExtra("month",1)+1;//on android studio january index is 0;
        d=intent.getIntExtra("dayOfMonth",1);
        selDate=(TextView) findViewById(R.id.date);
        selDate.setText(d+"/"+m+"/"+y);
        ArrayList<String> timeList=bringTime(y,m,d);
        printResult(timeList);

    }
    public ArrayList<String> bringTime(int selYear,int selMonth,int selDay) {
        InputStream is =getResources().openRawResource(R.raw.userdatacsv);
        BufferedReader bf = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
        try {
            bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> timeList=new ArrayList<>();
        try {

            while ((line = bf.readLine()) != null) {
                String[] tokens = line.split(",");
                if(Integer.valueOf(tokens[5].substring(0,2))==selDay&& Integer.valueOf(tokens[5].substring(3,5))==selMonth)
                {timeList.add(tokens[6]);}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return timeList;
    }
    public void printResult(ArrayList<String> timeList)
    {

        Collections.sort(timeList);
        btnNine=(Button)findViewById(R.id.btn1);
        btnTen=(Button)findViewById(R.id.btn2);
        btnEleven=(Button)findViewById(R.id.btn3);
        btnTwelve=(Button)findViewById(R.id.btn4);
        btnOne=(Button)findViewById(R.id.btn5);
        btnTwo=(Button)findViewById(R.id.btn6);
        btnThree=(Button)findViewById(R.id.btn7);
        btnFour=(Button)findViewById(R.id.btn8);

        for (int index =0;index<timeList.size();index++)
        {
            if(Integer.parseInt(timeList.get(index))==9)
            {
                NINE=false;
                btnNine.setBackgroundColor(Color.RED);

            }
            else if(Integer.parseInt(timeList.get(index))==10)
            {

                TEN=false;
                btnTen.setBackgroundColor(Color.RED);
            }
            else if(Integer.parseInt(timeList.get(index))==11)
            {
                ELEVEN=false;
                btnEleven.setBackgroundColor(Color.RED);
            }
            else if(Integer.parseInt(timeList.get(index))==12)
            {
                TWELVE=false;
                btnTwelve.setBackgroundColor(Color.RED);
            }
            else if(Integer.parseInt(timeList.get(index))==13)
            {
                ONE=false;
                btnOne.setBackgroundColor(Color.RED);
            }
            else if(Integer.parseInt(timeList.get(index))==14)
            {
                TWO=false;
                btnTwo.setBackgroundColor(Color.RED);
            }
            else if(Integer.parseInt(timeList.get(index))==15)
            {
                THREE=false;
                btnThree.setBackgroundColor(Color.RED);
            }
            else if(Integer.parseInt(timeList.get(index))==16)
            {
                FOUR=false;
                btnFour.setBackgroundColor(Color.RED);
            }

        }
        btnNine.setOnClickListener(this);
        btnTen.setOnClickListener(this);
        btnEleven.setOnClickListener(this);
        btnTwelve.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        errorMessage=(TextView)findViewById(R.id.error_message);
        if(v.getId()==btnNine.getId())
        {
            if(NINE)
            {
                Intent intent = new Intent(PickHour.this,ResultScreen.class);
                intent.putExtra("message",9);
                intent.putExtra("year",y);
                intent.putExtra("month",m);
                intent.putExtra("dayOfMonth",d);
                startActivity(intent);
            }
            else
            {

                errorMessage.setText("09:00 is not available");
            }
        }
        if(v.getId()==btnTen.getId())
        {
            if(TEN)
            {
                Intent intent = new Intent(PickHour.this,ResultScreen.class);
                intent.putExtra("message",10);
                intent.putExtra("year",y);
                intent.putExtra("month",m);
                intent.putExtra("dayOfMonth",d);
                startActivity(intent);
            }
            else
            {

                errorMessage.setText("10:00 is not available");
            }
        }
        if(v.getId()==btnEleven.getId())
        {
            if(ELEVEN)
            {
                Intent intent = new Intent(PickHour.this,ResultScreen.class);
                intent.putExtra("message",11);
                intent.putExtra("year",y);
                intent.putExtra("month",m);
                intent.putExtra("dayOfMonth",d);
                startActivity(intent);
            }
            else
            {
                errorMessage.setText("11:00 is not available");
            }
        }
        if(v.getId()==btnTwelve.getId())
        {
            if(TWELVE)
            {

                Intent intent = new Intent(PickHour.this,ResultScreen.class);
                intent.putExtra("message", 12);
                intent.putExtra("year",y);
                intent.putExtra("month",m);
                intent.putExtra("dayOfMonth",d);
                startActivity(intent);
            }
            else {
                errorMessage.setText("12:00 is not available");
            }
        }
        if(v.getId()==btnOne.getId())
        {
            if(ONE)
            {

                Intent intent = new Intent(PickHour.this,ResultScreen.class);
                intent.putExtra("message", 13);
                intent.putExtra("year",y);
                intent.putExtra("month",m);
                intent.putExtra("dayOfMonth",d);
                startActivity(intent);
            }
            else {
                errorMessage.setText("13:00 is not available");
            }
        }
        if(v.getId()==btnTwo.getId())
        {
            if(TWO)
            {

                Intent intent = new Intent(PickHour.this,ResultScreen.class);
                intent.putExtra("message", 2);
                intent.putExtra("year",y);
                intent.putExtra("month",m);
                intent.putExtra("dayOfMonth",d);
                startActivity(intent);
            }
            else {
                errorMessage.setText("14:00 is not available");
            }
        }
        if(v.getId()==btnThree.getId())
        {
            if(THREE)
            {

                Intent intent = new Intent(PickHour.this,ResultScreen.class);
                intent.putExtra("message", 3);
                intent.putExtra("year",y);
                intent.putExtra("month",m);
                intent.putExtra("dayOfMonth",d);
                startActivity(intent);
            }
            else {
                errorMessage.setText("15:00 is not available");
            }
        }
        if(v.getId()==btnFour.getId())
        {
            if(FOUR)
            {

                Intent intent = new Intent(PickHour.this,ResultScreen.class);
                intent.putExtra("message", 4);
                intent.putExtra("year",y);
                intent.putExtra("month",m);
                intent.putExtra("dayOfMonth",d);
                startActivity(intent);
            }
            else {
                errorMessage.setText("16:00 is not available");
            }
        }

    }
}

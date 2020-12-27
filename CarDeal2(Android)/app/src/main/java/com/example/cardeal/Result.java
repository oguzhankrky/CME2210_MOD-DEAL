package com.example.cardeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;


public class Result extends AppCompatActivity {
    TextView textView;
    String model;
    String transmiissonType;
    public ArrayList<CarStore> Cars =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        carReadData();
        Intent intent =getIntent();
        model=intent.getStringExtra("model");
        transmiissonType=intent.getStringExtra("transmiissonType");

        textView =(TextView)findViewById(R.id.textView);
            String temp="";
            for(int j=0;j<Cars.size();j++){
            if(Cars.get(j).getTransmission_Type().equalsIgnoreCase(transmiissonType)&&Cars.get(j).getModel().equalsIgnoreCase(model)) {
                if(!temp.contains(Cars.get(j).toString()))// for check same cars.
                temp+=Cars.get(j).toString();



            }}
            textView.setText(temp);//  car was printed to page properly and page scroll was added .
            textView.setMovementMethod(new ScrollingMovementMethod());


    }
    public void carReadData()//  essential csv file read and car object created  thanks to this function.

    {
        InputStream is = getResources().openRawResource(R.raw.data);
        BufferedReader reader =new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String line ="";
        int i=0;
        try{
            while ((line = reader.readLine()) != null) {
                if(i==0)
                {
                    i++;
                }
                else
                {
                    String[]tokens =line.split(",");
                    CarStore carstore =new CarStore();
                    carstore.setMake(tokens[0]);
                    carstore.setModel(tokens[1]);
                    carstore.setYear(tokens[2]);
                    carstore.setEngine_Fuel_Type(tokens[3]);
                    carstore.setEngine_HP(tokens[4]);
                    carstore.setEngine_Cylinders(tokens[5]);
                    carstore.setTransmission_Type(tokens[6]);
                    carstore.setDriven_Wheels(tokens[7]);
                    carstore.setNumber_of_Doors(tokens[8]);
                    carstore.setMarket_Category(tokens[9]);
                    carstore.setVehicle_Size(tokens[10]);
                    carstore.setVehicle_Style(tokens[11]);
                    carstore.setCity_mpg(tokens[12]);
                    carstore.setPopularity(tokens[13]);
                    carstore.setMSRP(tokens[14]);

                    Cars.add(carstore);


                }

            }

        }catch (IOException e)
        {
            Log.wtf("MainActivity","error"+line,e);
            e.printStackTrace();
        }



    }
}

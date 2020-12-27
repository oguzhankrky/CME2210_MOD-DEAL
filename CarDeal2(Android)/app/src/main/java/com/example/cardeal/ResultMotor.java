package com.example.cardeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import com.example.cardeal.ui.cars.MotorStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class ResultMotor extends AppCompatActivity {
    TextView textView;
    String model;
    private ArrayList<MotorStore> Motors =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_motor);
        MotorReadData();
        Intent intent =getIntent();
        model=intent.getStringExtra("motormodel");
        String make=intent.getStringExtra("motormake");
        textView =(TextView)findViewById(R.id.textView);
        String temp="";
        for(int j=0;j<Motors.size();j++){
            if(Motors.get(j).getModel().equalsIgnoreCase(model)&&Motors.get(j).getMake().equalsIgnoreCase(make)) {
                if(!temp.contains(Motors.get(j).toString()))// for check same motors.
                    temp+=Motors.get(j).toString();



            }}
        textView.setText(temp);//  motor was printed to page properly and page scroll was added .
        textView.setMovementMethod(new ScrollingMovementMethod());


    }
    public void MotorReadData()//  essential csv file read and motor object created  thanks to this function.

    {
        InputStream is = getResources().openRawResource(R.raw.datamotor);
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
                    MotorStore motorStore =new MotorStore();

                    motorStore.setId(tokens[0]);
                    motorStore.setCondition(tokens[1]);
                    motorStore.setCondition_Desc(tokens[2]);
                    motorStore.setPrice(tokens[3] + tokens[4]);
                    motorStore.setLocation(tokens[5] + tokens[6] + tokens[7]);
                    motorStore.setModel_Year(tokens[8]);
                    motorStore.setMileage(tokens[9] + tokens[10]);
                    motorStore.setExterior_Color(tokens[11]);
                    motorStore.setMake(tokens[12]);
                    motorStore.setWarranty(tokens[13]);
                    motorStore.setModel(tokens[14]);
                    motorStore.setSub_Model(tokens[15]);
                    motorStore.setType(tokens[16]);
                    if (tokens[25].equalsIgnoreCase("FALSE"))
                    tokens[25] = "NO";
                    if (tokens[25].equalsIgnoreCase("TRUE"))
                        tokens[25] = "YES";
                    motorStore.setBuy_Now(tokens[25]);


                    Motors.add(motorStore);
                }




            }

        }catch (IOException e)
        {
            Log.wtf("MainActivity","error"+line,e);
            e.printStackTrace();
        }



    }


        ;

}

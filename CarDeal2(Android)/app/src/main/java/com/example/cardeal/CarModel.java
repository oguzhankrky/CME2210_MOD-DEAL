package com.example.cardeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class CarModel extends AppCompatActivity {
    ListView listview;
    public ArrayList<String> carmodel =new ArrayList<>();
    public ArrayList<CarStore> Cars =new ArrayList<>();
    String Model="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_model);
        Intent intent =getIntent();
        carmodel.clear();// some values cleared for return back page.
        Cars.clear();
        carReadData();
        carmodel=intent.getStringArrayListExtra("carmodel");
        listview=(ListView) findViewById(R.id.listview);
        ArrayAdapter arrayAdapter =new ArrayAdapter(this,android.R.layout.simple_list_item_1,carmodel);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public ArrayList<String> choose =new ArrayList<>();
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String data=(String)adapterView.getItemAtPosition(i);

                Model=data;
                changepagego(view);
            }


        });


    }
    public  void changepagego(View view){// for go transmission type page.

        Intent intent =new Intent(CarModel.this,TransmissionType.class);
        intent.putExtra("model",Model);



        startActivity(intent);
    }


    public void carReadData() //  essential csv file read and car object created  thanks to this function.
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

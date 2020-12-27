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
import java.util.List;

public class Cars extends AppCompatActivity {
    ListView listview;
    private ArrayList<CarStore> Cars =new ArrayList<>();// necessary values kept in array list properly.
    public  ArrayList<String> carmake =new ArrayList<>();
    public ArrayList<String> carmodel =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);


        listview=(ListView) findViewById(R.id.listview);
        carReadData();

        for(int i=0;i<Cars.size();i++)// for data adding.
            if(!(carmake.contains(Cars.get(i).getMake())))
            carmake.add(Cars.get(i).getMake());
        ArrayAdapter arrayAdapter =new ArrayAdapter(this,android.R.layout.simple_list_item_1,carmake);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                carmodel.clear();
                String data=(String)adapterView.getItemAtPosition(i);

                for(int j=0;j<Cars.size();j++){

                    if(Cars.get(j).getMake().equalsIgnoreCase(data)&&!(carmodel.contains(Cars.get(j).getModel()))) {
                        carmodel.add(Cars.get(j).getModel());
                    }}

                    changepagego(view);

            }

        });



    }
    public  void changepagego(View view){

        Intent intent =new Intent(Cars.this,CarModel.class);
        intent.putExtra("carmodel",carmodel);



        startActivity(intent);
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


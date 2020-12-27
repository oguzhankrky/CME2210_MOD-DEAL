package com.example.cardeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cardeal.ui.cars.MotorStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Motors extends AppCompatActivity {
    ListView listview;
    public  ArrayList<String> Motormake =new ArrayList<>();// Essential array list was created to kept data properly.
    public ArrayList<String> Motormodel =new ArrayList<>();

    private ArrayList<MotorStore> Motors =new ArrayList<>();
    String make="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motors);
        listview=(ListView) findViewById(R.id.listview);
        MotorReadData();

        for(int i=0;i<Motors.size();i++)
            if(!(Motormake.contains(Motors.get(i).getMake())))
                Motormake.add(Motors.get(i).getMake());
        ArrayAdapter arrayAdapter =new ArrayAdapter(this,android.R.layout.simple_list_item_1,Motormake);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Motormodel.clear();

                String data=(String)adapterView.getItemAtPosition(i);
                make=data;
                for(int j=0;j<Motors.size();j++){

                    if(Motors.get(j).getMake().equalsIgnoreCase(data)&&!(Motormodel.contains(Motors.get(j).getModel()))) {
                        if(!Motors.get(j).getModel().equalsIgnoreCase(""))
                        Motormodel.add(Motors.get(j).getModel());
                    }}

                changepagego(view);

            }

        });



    }
    public  void changepagego(View view){// to go next page


        Intent intent =new Intent(Motors.this,MotorModel.class);
        intent.putExtra("motormodel",Motormodel);// for sent necessary values to  next page.
        intent.putExtra("motormake",make);


        startActivity(intent);
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
                    motorStore.setPrice(tokens[3]+tokens[4]);
                    motorStore.setLocation(tokens[5]+tokens[6]+tokens[7]);
                    motorStore.setModel_Year(tokens[8]);
                    motorStore.setMileage(tokens[9]+tokens[10]);
                    motorStore.setExterior_Color(tokens[11]);
                    motorStore.setMake(tokens[12]);
                    motorStore.setWarranty(tokens[13]);
                    motorStore.setModel(tokens[14]);
                    motorStore.setSub_Model(tokens[15]);
                    motorStore.setType(tokens[16]);
                    if(tokens[25].equalsIgnoreCase("FALSE"))
                        tokens[25]="NO";
                    if(tokens[25].equalsIgnoreCase("TRUE"))
                        tokens[25]="YES";
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


}

package com.example.cardeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TransmissionType extends AppCompatActivity {
    ListView listview;
    ArrayList<String> transmission =new ArrayList<>();
    String model="";
    String transmiissonType="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transmission_type);
        transmission.clear();
        transmission.add("AUTOMATIC");
        transmission.add("MANUAL");
        Intent intent =getIntent();
         model=intent.getStringExtra("model");
        listview=(ListView) findViewById(R.id.listview);
        ArrayAdapter arrayAdapter =new ArrayAdapter(this,android.R.layout.simple_list_item_1,transmission);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {// Transmission type was selected.


            public ArrayList<String> choose =new ArrayList<>();
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String data=(String)adapterView.getItemAtPosition(i);
                transmiissonType=data;
                changepagego(view);
            }



        });

    }
    public  void changepagego(View view){// to go next page

        Intent intent =new Intent(TransmissionType.this,Result.class);
        intent.putExtra("transmiissonType",transmiissonType);// mode and transmission type was sent to next page .
        intent.putExtra("model", model);



        startActivity(intent);
    }
}

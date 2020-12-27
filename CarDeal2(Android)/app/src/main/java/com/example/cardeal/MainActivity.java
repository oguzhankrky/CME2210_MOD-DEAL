package com.example.cardeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

     // to go to the selected page

    public  void changepage(View view){ // to go to the selected page


        Intent intent =new Intent(MainActivity.this,Cars.class);


        startActivity(intent);
    }

    public  void changepage2(View view){ // to go to the selected page


        Intent intent =new Intent(MainActivity.this,Motors.class);


        startActivity(intent);
    }
    public  void changepage3(View view){ // to go to the selected page


        Intent intent =new Intent(MainActivity.this,UserInput.class);


        startActivity(intent);
    }







}

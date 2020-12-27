package com.example.cardeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

// This class  was created for keep   the first  user form .
public class UserInput extends AppCompatActivity implements View.OnClickListener  {

    EditText TextName;
    EditText TextSurname;
    EditText TextPlate;
    EditText TextBrand;
    EditText TextPhone;
    private static User user;
    TextView tv;
    Button Enter;


    public UserInput() {

    }

    public static User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
        tv=(TextView) findViewById(R.id.textView2);
        TextName =(EditText) findViewById(R.id.Name);
        TextSurname=(EditText) findViewById(R.id.Surname);
        TextPlate=(EditText) findViewById(R.id.Plate);
        TextBrand=(EditText) findViewById(R.id.Brand);
        TextPhone=(EditText) findViewById(R.id.Phone);
        Enter=(Button) findViewById(R.id.Enter);
        Enter.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if(TextName.getText().toString().isEmpty()||TextSurname.getText().toString().isEmpty()||
                TextPlate.getText().toString().isEmpty()||TextBrand.getText().toString().isEmpty()||
                TextPhone.getText().toString().isEmpty())
        {
            tv.setText("Please fill the empty lines");
        }
        else {


            User userdata = new User(TextName.getText().toString(), TextSurname.getText().toString(),
                    TextPlate.getText().toString(), TextBrand.getText().toString(),
                    TextPhone.getText().toString());
            setUser(userdata);
            tv.setText(userdata.toString());
            servisToCalendar(v);
        }
    }
    public  void servisToMain(View view){

        Intent intent =new Intent(UserInput.this,MainActivity.class);


        startActivity(intent);
    }
    public  void servisToCalendar(View view){// to go to the selected page

        Intent intent =new Intent(UserInput.this,calendar.class);


        startActivity(intent);
    }
}

package com.example.vidhisinha.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    TextView regText;
    EditText username,password,email;
    Button newUserBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regText=(TextView)findViewById(R.id.RegisterText);
        username=(EditText)findViewById(R.id.regUserText);
        password=(EditText)findViewById(R.id.regPassText);
        email=(EditText)findViewById(R.id.regEmailText);
        newUserBtn=(Button)findViewById(R.id.buttonRegister);

        newUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences=getSharedPreferences("MySharedPrefs",MODE_PRIVATE);
                String newUser=username.getText().toString();
                String newPass=password.getText().toString();


                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString(newUser + newPass + "data","Username : "+newUser + "\n" + "Password : "+newPass);

                editor.commit();


                Toast.makeText(getApplicationContext(),"Successfully Registered.",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Register.this,MainActivity.class);

                startActivity(intent);
            }
        });

    }
}

package com.example.myapplication;

import static com.example.myapplication.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        Button b1 = findViewById(id.login_button);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent1 = new Intent(MainActivity.this, Login_Page.class);
                startActivity(intent1);

            }

        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button b2 = findViewById(id.signup_button);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent2 = new Intent(MainActivity.this,Signup_page.class) ;
                startActivity(intent2);
            }




        });







    }
}

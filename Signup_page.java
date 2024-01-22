package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Signup_page extends AppCompatActivity
{

    EditText t4, t5, t6, t7;
    TextView resulttextView;
    Button b1;
    private static final String url = "http://172.16.39.122/android_project/db_insert.php";

    private OkHttpClient client = new OkHttpClient();
    @SuppressLint({"MissingInflatedId", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);


        //Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup_page);


        //dont touch these codes
        //******************************************************
        @SuppressLint({"MissingInflatedId", "LocalSuppress", "WrongViewCast"})
        TextView t2 = findViewById(R.id.textView12);

        t2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent4 = new Intent(Signup_page.this, Login_Page.class);
                startActivity(intent4);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button b4 = findViewById(R.id.button2);

        b4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent2 = new Intent(Signup_page.this, Login_Page.class);
                startActivity(intent2);
            }
        });

        //********************************************************************************************************
        //********************************************************************************************************

        t4 = (EditText) findViewById(R.id.editTextText3);
        t5 = (EditText) findViewById(R.id.editTextTextEmailAddress);
        t6 = (EditText) findViewById(R.id.editTextPhone);
        t7 = (EditText) findViewById(R.id.editTextText4);
        resulttextView = (TextView) findViewById(R.id.tv);
        b1 = (Button)findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saved(t4.getText().toString(),t5.getText().toString(),t6.getText().toString(),t7.getText().toString());
            }

            private void saved(String Name, String Email, String phone, String password)
            {
                RequestBody format = new FormBody.Builder()
                        .add("t4",Name)
                        .add("t5",Email)
                        .add("t6",phone)
                        .add("t7",password)
                        .build();

                Request request = new Request.Builder().url(url).post(format).build();

                Call call = client .newCall(request);

                call.enqueue(new Callback() {

                    public void onFailure(Call call, IOException e) {
                        resulttextView.setText(e.toString());
                    }

                    public void onResponse(Call call, Response response) throws IOException {
                        try {
                            String resp = response.body().string();
                            if (response.isSuccessful()) {
                                resulttextView.setText("Signup completed succesfully...........Now please Login through your details");
                                t4.setText("");
                                t5.setText("");
                                t6.setText("");
                                t7.setText("");
                            }
                        } catch (Exception ex) {
                            t4.setText("");
                            t5.setText("");
                            t6.setText("");
                            t7.setText("");
                            resulttextView.setText(ex.toString());
                        }
                    }
                });
            }


        });
    }

}

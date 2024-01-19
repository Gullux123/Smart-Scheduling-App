package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login_Page extends AppCompatActivity {
    private static final String url = "http://172.16.39.122/android_project/login_details.php";
     EditText T1,T2;
     TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        // Move the following code inside the onCreate method
        @SuppressLint({"MissingInflatedId", "LocalSuppress", "WrongViewCast"})
        TextView t1 = findViewById(R.id.signup);

        // Move the following code outside the onClick method for t1
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button b5 = findViewById(R.id.button);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Login_Page.this, task.class);
                startActivity(intent2);
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fix syntax error here
                Intent intent4 = new Intent(Login_Page.this, Signup_page.class);
                startActivity(intent4);
            }

        });

        checklogoutmsg(tv1);
    }

    public void  login_process(View view)
    {
        T1 = (EditText)findViewById(R.id.id_username);
        T2 = (EditText)findViewById(R.id.id_password);
        tv1 = (TextView)findViewById(R.id.tv1);

        String qry = "?T1=" + T1.getText().toString().trim()+"&T2=" + T2.getText().toString().trim();

        class dbprocess extends AsyncTask<String,Void,String>
        {
            protected <editor> void onPostExecute(String data)
            {
                if(data.equals("found"))
                {
                    SharedPreferences sp = getSharedPreferences("credentials",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("uname",T1.getText().toString());
                    editor.commit();
                    startActivity(new Intent(getApplicationContext(),dashboard.class));

                }

                else {
                    T1.setText("");
                    T2.setText("");
                }
            }
        }
    }
}

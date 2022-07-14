package com.whlinks.myapplication6633;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
EditText emailText, passText;
Button login , getData;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailText = findViewById(R.id.email);
        passText = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        getData = findViewById(R.id.getData);
        sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("email",emailText.getText().toString().trim());
                editor.putString("pass",passText.getText().toString().trim());
                editor.commit();
            }
        });

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailText.setText(sharedPreferences.getString("email",""));
                passText.setText(sharedPreferences.getString("pass",""));
                sharedPreferences.edit().clear();
            }
        });

    }
}
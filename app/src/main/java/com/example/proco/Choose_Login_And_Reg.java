package com.example.proco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Choose_Login_And_Reg extends AppCompatActivity {

    private Button mlogin, mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_login_and_reg);

        mlogin = (Button) findViewById(R.id.login);
        mRegister = (Button) findViewById(R.id.register);

        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Choose_Login_And_Reg.this, LoginActivity.class);
                startActivity(i);
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Choose_Login_And_Reg.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
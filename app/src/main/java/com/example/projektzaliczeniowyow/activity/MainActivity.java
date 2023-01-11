package com.example.projektzaliczeniowyow.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projektzaliczeniowyow.R;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    public static Activity loginActivity;
    Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginActivity = this;

        utils = new Utils(this);

        if(!utils.redirectIfSavedLoginInfo()) {
            utils.resetUserId();

            loginButton = findViewById(R.id.loginButton);
            loginButton.setOnClickListener(view -> {
                Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show();
                utils.openOrderActivity();
                finish();
            });
        }
    }
}
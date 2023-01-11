package com.example.projektzaliczeniowyow.activity;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.Toast;

import com.example.projektzaliczeniowyow.R;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    Context context;

    public Utils(Context context) {
        this.context = context;
    }

    public void logout() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("sharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("userId");
        editor.putBoolean("saveLoginInfo", false);
        editor.apply();
        Toast.makeText(context, R.string.info_logged_out, Toast.LENGTH_SHORT).show();
    }


    public void openAllOrdersActivity() {
        Intent intent = new Intent(context, AllOrdersActivity.class);
        context.startActivity(intent);
    }



    public void openOrderActivity() {
        Intent intent = new Intent(context, OrderActivity.class);
        context.startActivity(intent);
    }


    public void openAuthorActivity() {
        Intent intent = new Intent(context, AuthorInformation.class);
        context.startActivity(intent);
    }

    public void resetUserId() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("sharedPref", MODE_PRIVATE);
        if(sharedPreferences.contains("userId")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove("userId");
            editor.apply();
        }
    }

    public boolean redirectIfSavedLoginInfo() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("sharedPref", MODE_PRIVATE);
        boolean saving = sharedPreferences.getBoolean("saveLoginInfo", false);
        if(saving) {
            openOrderActivity();
            MainActivity.loginActivity.finish();
            return true;
        }
        return false;
    }

    public void setLocale(String lang) {
        Locale locale = new Locale(lang);
        locale.setDefault(locale);
        Resources res = context.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, dm);
    }


    public String getLocaleInfo() {
        SharedPreferences preferences = context.getSharedPreferences("sharedPref", MODE_PRIVATE);
        return preferences.getString("locale", "pl");
    }



    public void openLoginActivity() {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public int getUserId() {
        SharedPreferences preferences = context.getSharedPreferences("sharedPref", MODE_PRIVATE);
        return preferences.getInt("userId", -1);
    }

}

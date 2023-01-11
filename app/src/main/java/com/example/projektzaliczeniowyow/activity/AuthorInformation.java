package com.example.projektzaliczeniowyow.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projektzaliczeniowyow.R;
import com.example.projektzaliczeniowyow.database.FeedReaderDbHelper;

public class AuthorInformation extends AppCompatActivity {

    Utils utils;
    FeedReaderDbHelper dbHelper;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.logout:
                utils.logout();
                utils.openLoginActivity();
                dbHelper.truncate();
                finish();
                break;
            case R.id.allOrders:
                utils.openAllOrdersActivity();
                finish();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_information);

        utils = new Utils(this);
        dbHelper = new FeedReaderDbHelper(this);
    }
}
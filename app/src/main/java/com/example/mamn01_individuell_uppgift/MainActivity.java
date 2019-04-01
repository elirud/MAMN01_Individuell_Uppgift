package com.example.mamn01_individuell_uppgift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openCompass(View View) {
        Intent intent = new Intent(this, CompassActivity.class);
        startActivity(intent);
    }

    public void openAccelerometer(View View) {
        Intent intent = new Intent(this, AccelerometerActivity.class);
        startActivity(intent);
    }
}

package com.example.imagetransitionpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
    }

    public void openDataPage(View view) {
        Intent intent = new Intent(this, DataDisplayPages.class);
        startActivity(intent);
    }

    public void launchAsync(View view) {
        Intent intent = new Intent(this, AsyncTester.class);
        startActivity(intent);
    }
}

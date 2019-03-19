package com.example.imagetransitionpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AsyncTester extends AppCompatActivity {
    private AsyncTestLoader myTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_tester);
    }

    public void startAsyncTest(View view) {
        myTest = new AsyncTestLoader();
        myTest.execute();

    }
}

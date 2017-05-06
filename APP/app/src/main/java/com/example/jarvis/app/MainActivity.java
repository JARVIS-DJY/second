package com.example.jarvis.app;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import lay.Myview;

public class MainActivity extends AppCompatActivity {
    private  Myview myview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myview=new Myview(this);
        setContentView(myview);
    }

    @Override
    protected void onResume() {
        super.onResume();
        myview.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myview.stop();
    }
}

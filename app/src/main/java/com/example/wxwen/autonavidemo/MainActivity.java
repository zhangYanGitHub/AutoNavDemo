package com.example.wxwen.autonavidemo;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {

    private boolean mShowMap = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mShowMap) {
                    showDefault();
                } else {
                    showMap();
                }
            }
        });
        showMap();
    }

    private void showMap() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, new MapFragment(), MapFragment.class.getName());
        transaction.commit();
        mShowMap = true;
    }

    private void showDefault() {
        androidx.fragment.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, new DefaultFragment(), DefaultFragment.class.getName());
        transaction.commit();
        mShowMap = false;
    }
}

package com.hugo.androidtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
    }


    public void onNext(View view) {
        Intent intent = new Intent(this,LaunchNextActivity.class);
        intent.putExtra("key","toNext");
        startActivityForResult(intent,101);
    }
}

package com.hugo.androidtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LaunchActivity extends Activity {

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

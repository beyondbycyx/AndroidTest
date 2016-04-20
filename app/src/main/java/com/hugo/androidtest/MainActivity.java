package com.hugo.androidtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String str ;
    private TextView tv;
    private TextView testTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        testTv = (TextView) findViewById(R.id.test_tv);

    }

    public void onClick(View view) {

        str = "onclick";
        tv.setText(str);
        testTv.setVisibility(View.GONE);
    }

    public void onLaunch(View view) {
    }
}

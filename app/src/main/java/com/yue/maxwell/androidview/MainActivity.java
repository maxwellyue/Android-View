package com.yue.maxwell.androidview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yue.maxwell.androidview.views.RatioImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RatioImageView imageView = (RatioImageView) findViewById(R.id.iv3);
        imageView.setRatio(1);
    }
}

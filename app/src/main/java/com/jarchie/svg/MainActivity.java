package com.jarchie.svg;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.tv_cart);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"iconfont.ttf");
        textView.setTypeface(typeface);
    }
}

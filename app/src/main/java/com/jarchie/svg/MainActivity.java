package com.jarchie.svg;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.context.IconicsLayoutInflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.tv_cart);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"iconfont.ttf");
        textView.setTypeface(typeface);
        ImageView imageView = (ImageView) findViewById(R.id.iv_set);
        TextView textView1 = (TextView) findViewById(R.id.tv_qrcode);
        imageView.setImageDrawable(new IconicsDrawable(this).icon(MyIconFont.Icon.archie_set)
                .color(Color.BLUE).sizeDp(50));
        textView1.setBackground(new IconicsDrawable(this).icon(MyIconFont.Icon.archie_qrcoed).sizeDp(50));
    }
}

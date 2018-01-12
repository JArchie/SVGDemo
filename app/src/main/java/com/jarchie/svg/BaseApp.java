package com.jarchie.svg;

import android.app.Application;

import com.mikepenz.iconics.Iconics;

/**
 * Created by Jarchie on 2018\1\12.
 * 自定义Application
 */

public class BaseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //only required if you add a custom or generic font on your own
        Iconics.init(this);

        //register custom fonts like this (or also provide a font definition file)
        Iconics.registerFont(new MyIconFont());
    }
}

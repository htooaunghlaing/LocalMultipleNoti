package com.hah.localmultiplenoti;

import android.app.Application;
import android.content.Context;

/**
 * Created by htooaunghlaing on 11/25/16.
 */

public class MyApp extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
    }

    public static Context getAppContext(){
        return context;
    }
}

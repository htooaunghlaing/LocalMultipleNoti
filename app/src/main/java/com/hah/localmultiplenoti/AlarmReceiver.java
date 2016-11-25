package com.hah.localmultiplenoti;

/**
 * Created by htooaunghlaing on 11/22/16.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

    private static int MY_NOTIFICATION_ID=0;
    NotificationManager notificationManager;
    Notification myNotification;
    private final String myBlog = "http://android-developers.blogspot.com/";


    @Override
    public void onReceive(Context context, Intent arg1) {

        MY_NOTIFICATION_ID = (int)System.currentTimeMillis();

        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(myBlog));
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                MY_NOTIFICATION_ID,
                myIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        myNotification = new NotificationCompat.Builder(context)
                .setContentTitle("Your Notification is Up!")
                .setContentText("Mingalarpar, Happy Coding for Noti")
                .setTicker("Notification!")
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();

        notificationManager =
                (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

         MainActivity.count += 1;

        MainActivity.setBadge(MainActivity.count);

        notificationManager.notify(MY_NOTIFICATION_ID, myNotification);

    }
}
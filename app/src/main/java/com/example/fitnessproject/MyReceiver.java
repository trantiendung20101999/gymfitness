package com.example.fitnessproject;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("fdadsa","not");
        NotificationManager manager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    intent.getStringExtra("channel"),
                    "Channel 1", NotificationManager.IMPORTANCE_HIGH
            );

            channel1.setDescription("This is Channel 1");
            manager.createNotificationChannel(channel1);
        }


        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context,intent.getStringExtra("channel"))
                        .setSmallIcon(R.drawable.ic_fitness)
                        .setContentTitle(
                                "Gym Now "
                        )
                        .setContentText(intent.getStringExtra("title"))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true);
//        Intent i = new Intent(context, MainActivity.class);
//        PendingIntent pendingIntent =
//                PendingIntent.getActivity( context,
//                        0,
//                        i, PendingIntent.FLAG_ONE_SHOT
//                );
//        builder.setContentIntent(pendingIntent);
        manager.notify(12345, builder.build());
    }
}

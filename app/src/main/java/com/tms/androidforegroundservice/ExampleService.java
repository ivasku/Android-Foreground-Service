package com.tms.androidforegroundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

import static com.tms.androidforegroundservice.App.CHANNEL_ID;

public class ExampleService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String data = intent.getStringExtra("input");

        Intent notificIntent = new Intent (this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificIntent,0);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Example Service")
                .setContentText(data)
                .setSmallIcon(R.drawable.ic_an)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1, notification);

        //do heavy work on backround thread
        //stopSelf();

        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

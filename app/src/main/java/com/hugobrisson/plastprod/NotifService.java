package com.hugobrisson.plastprod;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.UiThread;
import android.support.v4.content.LocalBroadcastManager;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EIntentService;
import org.androidannotations.annotations.EService;
import org.androidannotations.annotations.RootContext;

/**
 * Created by hugo on 19/06/2015.
 */
@EService
public class NotifService extends Service {

    Handler mHandler;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        mHandler = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                showNotif();
                sendBroadcast();
                mHandler.postDelayed(this, 100000);
            }
        };
        mHandler.postDelayed(r, 100000);
    }

    private void showNotif() {

        final String notificationTitle = "Mise a jour";
        final String notificationDesc = "Les produits ont ete mis a jour";

        final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //Cr
        // 0.é0
        // .............ation de la notification avec spécification de l'icône de la notification et le texte qui apparait à la création de la notification
        final Notification notification = new Notification(R.mipmap.ic_launcher, notificationTitle, System.currentTimeMillis());

        Intent intent = new Intent(getApplicationContext(),HomeActivity_.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);


        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0, intent,PendingIntent.FLAG_UPDATE_CURRENT);

        //Notification & Vibration
        notification.setLatestEventInfo(this, notificationTitle, notificationDesc, null);
        notification.vibrate = new long[]{0, 200, 100, 200, 100, 200};
        notification.sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        notificationManager.notify(1, notification);

    }

    private void sendBroadcast() {
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("Update"));
    }

}

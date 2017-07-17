package edu.gsu.httpscs.finalproject.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

/**
 * Created by nipunasenanayake on 7/16/17.
 */

public class BackgroundSoundService extends Service {
    private static final String TAG = null;
    MediaPlayer player;

    public IBinder onBind(Intent arg0) {

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("service", "onCreate");
//        player = new MediaPlayer();
//        try {
//            player.setDataSource("http://www.noiseaddicts.com/free-samples-mp3/?id=4160");
//            player.prepare();
//            player.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        player.setLooping(true); // Set looping
//        player.setVolume(100, 100);

    }


        public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("service", "onStartCommand");
        try {
            player = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
            player.setLooping(true);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Service.START_STICKY;
    }

    public void onStart(Intent intent, int startId) {
        // TO DO
    }

    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }

    public void onStop() {

    }

    public void onPause() {

    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    @Override
    public void onLowMemory() {

    }
}
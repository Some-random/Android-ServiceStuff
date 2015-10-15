package com.example.bob_jiang.servicestuff;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.ServiceConfigurationError;

/**
 * Created by Bob_JIANG on 10/14/2015.
 */

//Stuff about start service: 1 onCreate is called only once when the service is created, so you
// should only put initialization into this method. 2 On the other hand, onStartCommand is called
// every time startService is called, so that's what you need to implement 3 If you need to do any
// heavy communication, broadcastreceiver is recommended, messager can also get things done

public class StartServiceClass extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(), "lol", Toast.LENGTH_SHORT).show();
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

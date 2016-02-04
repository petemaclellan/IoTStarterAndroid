package com.ibm.iot.android.iotstarter.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by mlgpmacl on 1/27/2016.
 */
public class MyBroadcastReceiver extends BroadcastReceiver
{

    private String payload = "";
    private static MyBroadcastReceiver instance = null;

    public MyBroadcastReceiver() {
        super();
        Log.d("CONSTRUCT", "we did it!");
        instance = this;
    }

    public static MyBroadcastReceiver getInstance() {
        if (instance != null) {
            return instance;
        } else {
            return new MyBroadcastReceiver();
//            return instance;
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String newString = extras.getString("VehicleData");
        if (newString != null) {
            Log.d("...", newString);
            payload += " " + newString;
        } else {
            Log.d("...", "nuthin");
        }
    }

    public String getPayload() {
        return this.payload;
    }

    public void clearPayload() {
        this.payload = "";
    }
}
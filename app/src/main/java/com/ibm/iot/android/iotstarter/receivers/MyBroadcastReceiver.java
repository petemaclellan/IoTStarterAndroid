package com.ibm.iot.android.iotstarter.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by mlgpmacl on 1/27/2016.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

    private String payload = "";
    private static MyBroadcastReceiver instance = null;

    public MyBroadcastReceiver() {
        super();
        instance = this;
    }

    public static MyBroadcastReceiver getInstance() {
        if (instance != null) {
            return instance;
        } else {
            return new MyBroadcastReceiver();
        }
    }

    public String getPayload() {
        return this.payload;
    }

    public void clearPayload() {
        this.payload = "";
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String newString = extras.getString("VehicleData");
        if (newString != null) {
            this.payload = newString;
        }
    }

}

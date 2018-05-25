package com.bqlab.themelab.custom;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkDetector {
    private Context context;

    public NetworkDetector(Context context) {
        this.context = context;
    }

    public boolean isConnected() {
        ConnectivityManager mCM = (ConnectivityManager) context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if (mCM != null) {
            NetworkInfo networkInfo = mCM.getActiveNetworkInfo();
            if (networkInfo != null) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED)
                    return true;
            }
        }
        return false;
    }
}

package com.bqlab.themelab.custom;

import android.content.Context;
import android.content.pm.PackageManager;

public class ApplicationDetector {

    private Context context;

    public ApplicationDetector(Context context) {
        this.context=context;
    }

    public boolean hasApplication(String packageName) {
        try {
            context.getPackageManager().getApplicationInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e ){
            return false;
        }
    }
}

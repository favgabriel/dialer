package com.dialerapp;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if (intent.getAction().equals("android.provider.Telephony.SECRET_CODE")){
            //intent.getExtras().getString()
           context.startActivity(new Intent(context,MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
        String enableicon ="#1000#";
        String dialcode  = "#3332#";
        String disableicon ="#0001#";
        String dialedNumber = getResultData();
        if (dialedNumber.equals(dialcode)){
            setResultData(null);
            Intent intent1 = new Intent(context, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }else if (disableicon.equals(dialedNumber)){
            if (islauncherIconVsible(context)) {
                PackageManager packageManager = context.getPackageManager();
                ComponentName componentName = new ComponentName(context, com.dialerapp.MainActivity.class);
                packageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
            }
        } else if (enableicon.equals(dialedNumber)) {
            if (!islauncherIconVsible(context)) {
                PackageManager packageManager = context.getPackageManager();
                ComponentName componentName = new ComponentName(context, com.dialerapp.MainActivity.class);
                packageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
            }
        }

    }

    private boolean islauncherIconVsible(Context context){
        ComponentName componentName = new ComponentName(context,com.dialerapp.MainActivity.class);
        int enabledsetting = context.getPackageManager().getComponentEnabledSetting(componentName);
        return enabledsetting != PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
    }
}
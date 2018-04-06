/***
 Developed by AKASH SINGH SENGAR ON 5TH APRIL 2018
 */

package com.paranormal.anandshashi.screenlock;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.logging.Handler;


public class AdminReceiver extends DeviceAdminReceiver {
  @Override
  public void onEnabled(Context ctxt, Intent intent) {
    ComponentName cn=new ComponentName(ctxt, AdminReceiver.class);
    DevicePolicyManager mgr=
        (DevicePolicyManager)ctxt.getSystemService(Context.DEVICE_POLICY_SERVICE);

    mgr.setPasswordQuality(cn,
                           DevicePolicyManager.PASSWORD_QUALITY_ALPHANUMERIC);
    
    onPasswordChanged(ctxt, intent);
  }

  @Override
  public void onPasswordChanged(Context ctxt, Intent intent) {
    DevicePolicyManager mgr=
        (DevicePolicyManager)ctxt.getSystemService(Context.DEVICE_POLICY_SERVICE);
    int msgId;

    if (mgr.isActivePasswordSufficient()) {
      msgId= R.string.compliant;
    }
    else {
      msgId=R.string.not_compliant;
    }

    Toast.makeText(ctxt, "Put wrong Lock Screen Password and see the Paranormal Activity(After Lock opens)", Toast.LENGTH_LONG).show();
  }

  @Override
  public void onPasswordFailed(final Context ctxt, Intent intent) {
    //Toast.makeText(ctxt, R.string.password_failed, Toast.LENGTH_LONG).show();
    Thread thread = new Thread( new Runnable() {
      @Override
      public void run() {
        try
        {
          Thread.sleep(15000);
          Intent intent2=new Intent(ctxt,FullScreen.class);
          intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          ctxt.startActivity(intent2);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  });

    thread.start();
//    Intent intent2=new Intent(ctxt,FullScreen.class);
//    intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//    ctxt.startActivity(intent2);
  }

  @Override
  public void onPasswordSucceeded(Context ctxt, Intent intent) {
    //Toast.makeText(ctxt, R.string.password_success, Toast.LENGTH_LONG).show();

  }



}

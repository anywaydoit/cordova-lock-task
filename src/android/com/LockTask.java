/**
 */
package com.locktask.ep;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;

import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;

import android.util.Log;

import java.util.Date;

public class LockTask extends CordovaPlugin {
  private static final String TAG = "LockTask";
  private Activity activity = null;
  private ActivityManager activityManager = null;
  
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
    
     activity = cordova.getActivity();
        activityManager = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);

    Log.d(TAG, "Initializing LockTask");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if(action.equals("initLock")) {
      String phrase = args.getString(0);
      // Echo back the first argument
      //startLockTask();
      try {

            // activity not already pinned...
            if (!activityManager.isInLockTaskMode()) {
                activity.startLockTask();
                //callback.success();
                return true;
            }

            // activity already pinned...
            //callback.error("Activity is already pinned");
            return false;  

        }

        catch (Exception e) {
            //callback.error(e.getMessage());
            return false;
        }    
      
      //Log.d(TAG, phrase);
    } else if(action.equals("endLock")) {
      // An example of returning data back to the web layer
      //final PluginResult result = new PluginResult(PluginResult.Status.OK, (new Date()).toString());
      //callbackContext.sendPluginResult(result);
       //stopLockTask();
       try {

            // activity is pinned...
            if (activityManager.isInLockTaskMode()) {
                activity.stopLockTask();
                //callback.success();
                return true;
            }

            // activity is not pinned...
            //callback.error("Activity is already unpinned");
            return false; 

        }

        catch (Exception e) {
            //callback.error(e.getMessage());
            return false;
        }    
    }
    return true;
  }

}

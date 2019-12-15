/**
 */
package com.locktask.ep;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import java.util.Date;

public class LockTask extends CordovaPlugin {
  private static final String TAG = "LockTask";

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Initializing LockTask");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if(action.equals("initLock")) {
      String phrase = args.getString(0);
      // Echo back the first argument
      startLockTask();
      //Log.d(TAG, phrase);
    } else if(action.equals("endLock")) {
      // An example of returning data back to the web layer
      //final PluginResult result = new PluginResult(PluginResult.Status.OK, (new Date()).toString());
      //callbackContext.sendPluginResult(result);
       stopLockTask();
    }
    return true;
  }

}

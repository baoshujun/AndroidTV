package com.hongdong.test.utils;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

import java.io.IOException;

public class TVDevicesUtils {
    private static final String TAG = "TVDevicesUtils";

    /**
     *
     * 检查是当前app是否运行在TV设备上
     *
     * @param context :getApplicationContext
     * @return true 是tv设备，false 手机等其他
     */
    public static boolean isTVDevices(Context context){
        boolean isTVDevices;
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService(Context.UI_MODE_SERVICE);
        if (uiModeManager!= null &&uiModeManager.getCurrentModeType() == Configuration.UI_MODE_TYPE_TELEVISION){
            Log.d(TAG, "onCreate: Running on a TV devices");
            isTVDevices = true;
        }else {
            Log.d(TAG, "onCreate: Running on a Phone devices");
            isTVDevices = false;

        }

        return isTVDevices;
    }

     /**
     * 是否支持电话特性
     * @param context:getApplicationContext
     * @return true 支持电话功能，false不支持
     */
    public static  boolean isSurportTelephony(Context context){
         boolean isCanTelephony = false;
         if (context.getPackageManager().hasSystemFeature("android.hardware.telephony")){
             isCanTelephony = true;
         }
         return isCanTelephony;

    }


    /**
     * 是否支持摄像头
     * @param context :getApplicationContext
     * @return true 支持摄像头，false不支持
     */
    public static  boolean isSurportCamera(Context context){
        boolean isSurportCamera = false;
        if (context.getPackageManager().hasSystemFeature("android.hardware.camera")){
            isSurportCamera = true;
        }
        return isSurportCamera;

    }

    /**
     * 是否支持触摸屏
     * @param context :getApplicationContext
     * @return true 支持touch false 不支持
     */
    public static  boolean isCanTouch(Context context){
        boolean isCanTouch = false;
        if (context.getPackageManager().hasSystemFeature("android.hardware.touchscreen")){
            isCanTouch = true;
        }
        return  isCanTouch;
    }

}

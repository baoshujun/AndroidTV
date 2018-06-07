[参考链接](https://blog.csdn.net/hejjunlin/article/details/52792562)
>当你为电视构建一个应用程序,你必须仔细考虑硬件操作电视硬件的限制和要求

**app上检查电视设备**
1. 通过使用UiModeManager.getCurrentModeType()方法来检查该设备是否在TV模式下运行

        /**
         *
         * 检查是当前app是否运行在TV设备上
         *
         * @param context
         * @return true 是tv设备，false 手机等其他
         */
        public static boolean isTVDevices(Context context){
            boolean isTVDevices = false;
            UiModeManager uiModeManager = (UiModeManager) context.getSystemService(Context.UI_MODE_SERVICE);
            if (uiModeManager.getCurrentModeType() == Configuration.UI_MODE_TYPE_TELEVISION){
                Log.d(TAG, "onCreate: Running on a TV devices");
                isTVDevices = true;
            }else {
                Log.d(TAG, "onCreate: Running on a Phone devices");
                isTVDevices = false;

            }

            return isTVDevices;
        }
2. Declaring hardware requirements for TV in Manifest.xml
>\<uses-feature android:name="android.hardware.touchscreen" android:required="false"/>
3. 检查硬件Features

       /**
         * 是否支持电话特性
         * @param context
         * @return
         */
        public static  boolean isSurportTelephony(Context context){
             boolean isCanTelephony = false;
             if (context.getPackageManager().hasSystemFeature("android.hardware.telephony")){
                 isCanTelephony = true;
             }

             return isCanTelephony;

        }
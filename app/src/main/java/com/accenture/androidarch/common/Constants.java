package com.accenture.androidarch.common;

import com.accenture.androidarch.BuildConfig;

public class Constants {

    public static String appVersion() {
        return "v" + BuildConfig.VERSION_NAME;
    }

    public static boolean isDebugApp() {
        return BuildConfig.BUILD_TYPE.equalsIgnoreCase("debug");
    }

}

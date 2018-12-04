package com.accenture.androidarch.common;

import com.accenture.androidarch.BuildConfig;

public class Constants {

    public static String appEmojis() {
        return "\uD83C\uDFAC \uD83D\uDCFD \uD83C\uDF7F" +
                "\u0020\u0020\u0020\u0020\u0020\u0020" +
                "\uD83E\uDD14 \uD83D\uDE03 \uD83D\uDE09";
    }

    public static String appVersion() {
        return "v" + BuildConfig.VERSION_NAME;
    }

    public static boolean isAdminApp() {
        return BuildConfig.BUILD_TYPE.equalsIgnoreCase("admin");
    }

}

package mobi.mergen.androidshowcase.common;

import mobi.mergen.androidshowcase.BuildConfig;

public class Constants {

    public static String appVersion() {
        return "v" + BuildConfig.VERSION_NAME;
    }

    public static boolean isDebugApp() {
        return BuildConfig.BUILD_TYPE.equalsIgnoreCase("debug");
    }

}

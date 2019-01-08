/*
 * Copyright 2018 UGURCAN YILDIRIM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mobi.mergen.androidshowcase.common;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.AppUtils;

public class Navigator {

    public final static int ENTER_ANIM = android.R.anim.slide_in_left;
    public final static int EXIT_ANIM = android.R.anim.slide_out_right;


    public static void start(Activity currentActivity,
                             Class<? extends Activity> newActivity) {
        ActivityUtils.startActivity(currentActivity, newActivity,
                ENTER_ANIM, EXIT_ANIM);
    }

    public static void finish(Activity currentActivity) {
        ActivityUtils.finishActivity(currentActivity,
                ENTER_ANIM, EXIT_ANIM);
    }

    public static void finishAndStart(Activity currentActivity,
                                      Class<? extends Activity> newActivity) {
        finish(currentActivity);
        start(currentActivity, newActivity);
    }

    public static void finishAll() {
        ActivityUtils.finishAllActivities(ENTER_ANIM, EXIT_ANIM);
    }

    public static void goToPlayStorePage() {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("market://details?id=" + AppUtils.getAppPackageName()));
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            ActivityUtils.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            goToWebPage("http://play.google.com/store/apps/details?id="
                    + AppUtils.getAppPackageName());
        }
    }

    public static void goToWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        ActivityUtils.startActivity(intent);
    }
}

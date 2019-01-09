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

package mobi.mergen.androidshowcase;

import android.view.Gravity;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.evernote.android.state.StateSaver;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.picasso.Picasso;

import androidx.core.content.ContextCompat;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import mobi.mergen.androidshowcase.common.Constants;
import mobi.mergen.androidshowcase.di.DaggerAppComponent;

public class TheApp extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        //LeakCanary.install(this); //NOT NOW!!!
        StateSaver.setEnabledForAllActivitiesAndSupportFragments(this, true);
        initUtils();
        initPicasso();
    }

    private void initUtils() {
        Utils.init(this);
        ToastUtils.setBgColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        ToastUtils.setMsgColor(ContextCompat.getColor(this, R.color.colorLight));
        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
    }

    private void initPicasso() {
        Picasso.get().setIndicatorsEnabled(Constants.isDebugApp());
    }

    @Override
    protected AndroidInjector<TheApp> applicationInjector() {
        return DaggerAppComponent.builder()
                .app(this)
                .build();
    }
}

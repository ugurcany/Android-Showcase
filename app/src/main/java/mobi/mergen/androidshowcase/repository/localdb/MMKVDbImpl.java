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

package mobi.mergen.androidshowcase.repository.localdb;

import android.content.Context;
import android.os.Parcelable;

import com.tencent.mmkv.MMKV;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MMKVDbImpl implements LocalDb {

    @Inject
    public MMKVDbImpl(Context context) {
        MMKV.initialize(context);
    }

    @Override
    public <T extends Parcelable> Box getBox(String boxId, Class<T> classOfValues) {
        return new BoxImpl<>(boxId, classOfValues);
    }


    public class BoxImpl<T extends Parcelable> implements Box<T> {

        private MMKV mmkv;
        private Class<T> classOfValues;

        BoxImpl(String boxId, Class<T> classOfValues) {
            this.mmkv = MMKV.mmkvWithID(boxId);
            this.classOfValues = classOfValues;
        }

        @Override
        public void put(String key, T value) {
            mmkv.encode(key, value);
        }

        @Override
        public T get(String key) {
            return mmkv.decodeParcelable(key, classOfValues, null);
        }

    }
}

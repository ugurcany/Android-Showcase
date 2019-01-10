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

package mobi.mergen.androidshowcase.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobi.mergen.androidshowcase.repository.movie.MovieApi;
import mobi.mergen.androidshowcase.repository.movie.MovieApiInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
class RestModule {

    @Provides
    @Singleton
    MovieApi movieApi(Retrofit.Builder retrofitBuilder,
                      OkHttpClient.Builder httpClientBuilder) {
        OkHttpClient httpClient = httpClientBuilder
                .addInterceptor(new MovieApiInterceptor())
                .build();

        return retrofitBuilder
                .client(httpClient)
                .baseUrl("https://www.omdbapi.com/")
                .build()
                .create(MovieApi.class);
    }

    @Provides
    @Singleton
    Retrofit.Builder retrofitBuilder() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

    @Provides
    @Singleton
    OkHttpClient.Builder httpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(interceptor);
    }

}
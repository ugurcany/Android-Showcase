package mobi.mergen.androidshowcase.di;

import android.content.Context;

import net.rehacktive.waspdb.WaspDb;
import net.rehacktive.waspdb.WaspFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class LocalDbModule {

    @Provides
    @Singleton
    WaspDb waspDb(Context context) {
        String path = context.getFilesDir().getPath();
        String dbName = "ShowcaseDb";
        String password = "VerySecretPassword";

        return WaspFactory.openOrCreateDatabase(path, dbName, password);
    }

}
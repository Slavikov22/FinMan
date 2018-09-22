package com.finman

import android.app.Application
import com.finman.dagger.component.AppComponent
import com.finman.dagger.component.DaggerAppComponent
import com.finman.dagger.module.AppModule
import com.finman.dagger.module.StorageModule
import com.finman.logger.debug.DebugTree
import com.finman.logger.debug.FileLoggingDebugTree
import com.finman.logger.release.ReleaseTree
import io.realm.Realm
import io.realm.RealmConfiguration
import timber.log.Timber


/**
 * Created by Artem Korolchuk on 19.09.17.
 * <href a="http://blak-it.com"></href>
 */

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        setupLogger()
        configureDagger()
        configureRealm()
    }

    private fun setupLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
            Timber.plant(FileLoggingDebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }

    private fun configureDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .storageModule(StorageModule(this))
                .build()
    }

    private fun configureRealm() {
        Realm.init(this)
        val config: RealmConfiguration = RealmConfiguration.Builder()
                .schemaVersion(0)
                .build()
        Realm.setDefaultConfiguration(config)
    }
}
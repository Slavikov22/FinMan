package com.finman.dagger.component

import com.finman.dagger.module.AppModule
import com.finman.dagger.module.StorageModule
import com.finman.presenter.UtilityWrapper
import dagger.Component
import javax.inject.Singleton


/**
 * Created by Artem Korolchuk on 19.09.17.
 * <href a="http://blak-it.com"></href>
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, StorageModule::class))
interface AppComponent {
    fun inject(utilityWrapper: UtilityWrapper)
}
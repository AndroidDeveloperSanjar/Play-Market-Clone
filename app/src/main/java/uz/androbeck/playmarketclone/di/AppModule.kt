package uz.androbeck.playmarketclone.di

import android.content.Context
import uz.androbeck.playmarketclone.core.cache.preferences.PreferencesManager
import uz.androbeck.playmarketclone.data.repository.abstraction.AppRepository
import uz.androbeck.playmarketclone.data.repository.implementation.AppRepositoryImpl

object AppModule {

    fun providePreferenceManager(context: Context): PreferencesManager {
        return PreferencesManager(context)
    }

    fun provideAppRepository(): AppRepository {
        return AppRepositoryImpl()
    }

}
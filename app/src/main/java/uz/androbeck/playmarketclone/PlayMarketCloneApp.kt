package uz.androbeck.playmarketclone

import android.app.Application
import uz.androbeck.playmarketclone.core.cache.preferences.PreferencesManager
import uz.androbeck.playmarketclone.core.language.AppLanguage
import uz.androbeck.playmarketclone.di.AppModule

class PlayMarketCloneApp : Application() {

    lateinit var preferences: PreferencesManager

    override fun onCreate() {
        super.onCreate()
        preferences = AppModule.providePreferenceManager(applicationContext)

        AppLanguage.init(this, getString(R.string.en))

        setAppLanguage()
    }

    private fun setAppLanguage() {
        when (preferences.locale) {
            getString(R.string.en) -> {
                AppLanguage.getInstance().setLocale(applicationContext, getString(R.string.en))
            }
            getString(R.string.ru) -> {
                AppLanguage.getInstance().setLocale(applicationContext, getString(R.string.ru))
            }
            getString(R.string.uz) -> {
                AppLanguage.getInstance().setLocale(applicationContext, getString(R.string.uz))
            }
        }
    }

}
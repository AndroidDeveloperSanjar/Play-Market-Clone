package uz.androbeck.playmarketclone.core.language

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.res.Configuration
import uz.androbeck.playmarketclone.core.language.store.LocaleStore
import uz.androbeck.playmarketclone.core.language.store.PreferenceLocaleStore
import uz.androbeck.playmarketclone.util.getLocaleCompat
import uz.androbeck.playmarketclone.util.resetTitle
import java.util.*

class AppLanguage private constructor(
    private val store: LocaleStore,
    private val delegate: UpdateLocaleDelegate
) {

    internal var systemLocale: Locale = defaultLocale

    @JvmOverloads
    fun setLocale(context: Context, language: String, country: String = "", variant: String = "") {
        setLocale(context, Locale(language, country, variant))
    }

    fun setLocale(context: Context, locale: Locale) {
        store.setFollowSystemLocale(false)
        persistAndApply(context, locale)
    }

    fun getLocale(): Locale {
        return store.getLocale()
    }

    fun getLanguage(): String {
        return verifyLanguage(getLocale().language)
    }

    fun setFollowSystemLocale(context: Context) {
        store.setFollowSystemLocale(true)
        persistAndApply(context, systemLocale)
    }

    fun isFollowingSystemLocale() = store.isFollowingSystemLocale()

    private fun verifyLanguage(language: String): String {
        // get rid of deprecated language tags
        return when (language) {
            "iw" -> "he"
            "ji" -> "yi"
            "in" -> "id"
            else -> language
        }
    }

    internal fun initialize(application: Application) {
        application.registerActivityLifecycleCallbacks(
            AppLanguageActivityLifecycleCallbacks {
                applyForActivity(it)
            }
        )
        application.registerComponentCallbacks(
            AppLanguageApplicationCallbacks {
                processConfigurationChange(application, it)
            }
        )
        val locale = if (store.isFollowingSystemLocale()) {
            systemLocale
        } else {
            store.getLocale()
        }
        persistAndApply(application, locale)
    }

    private fun persistAndApply(context: Context, locale: Locale) {
        store.persistLocale(locale)
        delegate.applyLocale(context, locale)
    }

    private fun applyLocale(context: Context) {
        delegate.applyLocale(context, store.getLocale())
    }

    private fun processConfigurationChange(context: Context, config: Configuration) {
        systemLocale = config.getLocaleCompat()
        if (store.isFollowingSystemLocale()) {
            persistAndApply(context, systemLocale)
        } else {
            applyLocale(context)
        }
    }

    private fun applyForActivity(activity: Activity) {
        applyLocale(activity)
        activity.resetTitle()
    }

    companion object {
        @SuppressLint("ConstantLocale")
        private val defaultLocale: Locale = Locale.getDefault()

        private lateinit var instance: AppLanguage

        @JvmStatic
        fun getInstance(): AppLanguage {
            check(Companion::instance.isInitialized) { "App language should be initialized first" }
            return instance
        }

        @JvmStatic
        fun init(application: Application, defaultLanguage: String): AppLanguage {
            return init(application, Locale(defaultLanguage))
        }

        @JvmStatic
        @JvmOverloads
        fun init(
            application: Application,
            defaultLocale: Locale = Locale.getDefault()
        ): AppLanguage {
            return init(application, PreferenceLocaleStore(application, defaultLocale))
        }

        @JvmStatic
        fun init(application: Application, store: LocaleStore): AppLanguage {
            check(!Companion::instance.isInitialized) { "Already initialized" }
            val language = AppLanguage(store, UpdateLocaleDelegate())
            language.initialize(application)
            instance = language
            return language
        }

        internal fun createInstance(
            store: LocaleStore,
            delegate: UpdateLocaleDelegate
        ): AppLanguage {
            return AppLanguage(store, delegate)
        }
    }
}

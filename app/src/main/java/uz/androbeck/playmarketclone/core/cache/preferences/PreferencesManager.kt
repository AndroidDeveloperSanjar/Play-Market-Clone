package uz.androbeck.playmarketclone.core.cache.preferences

import android.content.Context
import androidx.preference.PreferenceManager
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.core.delegation.PreferencesDelegate

class PreferencesManager(
    private val context: Context
) {

    private val preferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(
            context
        )
    }

    var locale by PreferencesDelegate(preferences, LOCALE, context.getString(R.string.en))
    var theme by PreferencesDelegate(preferences, THEME, context.getString(R.string.mode_light))

    companion object {
        private const val LOCALE = "locale"
        private const val THEME = "theme"
    }
}
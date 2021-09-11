package uz.androbeck.playmarketclone.core.language

import android.content.ComponentCallbacks
import android.content.res.Configuration

internal class AppLanguageApplicationCallbacks(private val callback: (Configuration) -> Unit) :
    ComponentCallbacks {

    override fun onConfigurationChanged(newConfig: Configuration) {
        callback.invoke(newConfig)
    }

    override fun onLowMemory() {
        // no-op
    }
}

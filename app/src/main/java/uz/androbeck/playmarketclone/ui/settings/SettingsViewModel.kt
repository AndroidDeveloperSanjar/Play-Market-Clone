package uz.androbeck.playmarketclone.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import uz.androbeck.playmarketclone.core.base.viewmodel.SettingsBaseViewModel
import uz.androbeck.playmarketclone.core.lifecycle.Event

class SettingsViewModel : SettingsBaseViewModel() {
    private val _navigateToChangeLanguage = MutableLiveData<Event<Unit>>()
    val navigateToChangeLanguage: LiveData<Event<Unit>> get() = _navigateToChangeLanguage
    private val _navigateToChangeTheme = MutableLiveData<Event<Unit>>()
    val navigateToChangeTheme: LiveData<Event<Unit>> get() = _navigateToChangeTheme
    private val _changeLanguage = MutableLiveData<Event<String>>()
    val changeLanguage: LiveData<Event<String>> get() = _changeLanguage
    private val _backToHome = MutableLiveData<Event<Unit>>()
    val backToHome: LiveData<Event<Unit>> get() = _backToHome
    private val _set = MutableLiveData<Event<Unit>>()
    val set: LiveData<Event<Unit>> get() = _set
    private val _setTheme = MutableLiveData<Event<String>>()
    val setTheme: LiveData<Event<String>> get() = _setTheme

    fun setTheme(theme: String) {
        _setTheme.value = Event(theme)
    }

    fun set() {
        _set.value = Event(Unit)
    }

    fun backToHome() {
        _backToHome.value = Event(Unit)
    }

    fun changeLanguage(locale: String) {
        _changeLanguage.value = Event(locale)
    }

    fun navigateToChangeTheme() {
        _navigateToChangeTheme.value = Event(Unit)
    }

    fun navigateToChangeLanguage() {
        _navigateToChangeLanguage.value = Event(Unit)
    }
}
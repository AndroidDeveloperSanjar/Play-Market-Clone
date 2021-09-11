package uz.androbeck.playmarketclone.core.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import uz.androbeck.playmarketclone.core.lifecycle.Event
import uz.androbeck.playmarketclone.util.exception

abstract class BaseViewModel : ViewModel() {

    private val _loader = MutableLiveData<Boolean>()
    val loader: LiveData<Boolean> get() = _loader

    private val _navigateToSettings = MutableLiveData<Event<Unit>>()
    val navigateToSettings: LiveData<Event<Unit>> get() = _navigateToSettings

    fun navigateToSettings() {
        _navigateToSettings.value = Event(Unit)
    }

    fun <T> Flow<T>.proceed(action: suspend (T) -> Unit = { }): Job {
        return onStart { start() }
            .catch {
                it.exception(it.stackTraceToString())
                loader(false)
                catch(it)
            }
            .onEach {
                loader(false)
                action.invoke(it)
            }
            .launchIn(viewModelScope)
    }

    open fun start() {
        loader(true)
    }

    abstract fun catch(cause: Throwable)

    open fun loader(isLoading: Boolean) {
        _loader.postValue(isLoading)
    }
}
package uz.androbeck.playmarketclone.ui.games

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import uz.androbeck.playmarketclone.core.base.viewmodel.GamesBaseViewModel
import uz.androbeck.playmarketclone.core.lifecycle.Event
import uz.androbeck.playmarketclone.di.Inject

class GamesViewModel : GamesBaseViewModel() {
    private val repository = Inject.repository

    private val _fragments = MutableLiveData<Event<List<Fragment>>>()
    val fragments: LiveData<Event<List<Fragment>>> get() = _fragments

    fun fragments() {
        repository.fragments().proceed {
            _fragments.value = Event(it)
        }
    }

}
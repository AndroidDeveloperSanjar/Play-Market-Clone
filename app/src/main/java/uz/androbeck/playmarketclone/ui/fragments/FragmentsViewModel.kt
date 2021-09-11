package uz.androbeck.playmarketclone.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import uz.androbeck.playmarketclone.core.base.viewmodel.FragmentsBaseViewModel
import uz.androbeck.playmarketclone.core.lifecycle.Event
import uz.androbeck.playmarketclone.data.model.UIModel
import uz.androbeck.playmarketclone.di.Inject

class FragmentsViewModel : FragmentsBaseViewModel() {

    private val repository = Inject.repository

    private val _data = MutableLiveData<Event<List<UIModel>>>()
    val data: LiveData<Event<List<UIModel>>> get() = _data

    fun data() {
        repository.data().proceed {
            _data.value = Event(it)
        }
    }
}
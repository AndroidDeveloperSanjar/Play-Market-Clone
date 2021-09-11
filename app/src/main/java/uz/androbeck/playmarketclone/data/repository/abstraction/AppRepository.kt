package uz.androbeck.playmarketclone.data.repository.abstraction

import androidx.fragment.app.Fragment
import kotlinx.coroutines.flow.Flow
import uz.androbeck.playmarketclone.data.model.UIModel

interface AppRepository {

    fun fragments(): Flow<List<Fragment>>

    fun data(): Flow<List<UIModel>>
}
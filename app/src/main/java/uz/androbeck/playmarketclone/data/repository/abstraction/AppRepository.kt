package uz.androbeck.playmarketclone.data.repository.abstraction

import androidx.fragment.app.Fragment
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    fun fragments(): Flow<List<Fragment>>
}
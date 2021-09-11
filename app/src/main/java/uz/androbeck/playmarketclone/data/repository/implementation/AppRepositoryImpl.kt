package uz.androbeck.playmarketclone.data.repository.implementation

import kotlinx.coroutines.flow.flow
import uz.androbeck.playmarketclone.data.Data
import uz.androbeck.playmarketclone.data.repository.abstraction.AppRepository

class AppRepositoryImpl : AppRepository {

    override fun fragments() = flow {
        emit(Data.fragments)
    }
}
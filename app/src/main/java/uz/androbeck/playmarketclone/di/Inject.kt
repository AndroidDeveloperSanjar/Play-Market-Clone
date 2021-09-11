package uz.androbeck.playmarketclone.di

object Inject {
    val repository = AppModule.provideAppRepository()
}
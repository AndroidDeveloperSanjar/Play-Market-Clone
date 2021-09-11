package uz.androbeck.playmarketclone.data.model

data class UIModel(
    val viewType: Int,
    val title: String,
    val data: List<UIHorizontalData>
)

data class UIHorizontalData(
    val imageUrl: String,
    val contentName: String,
    val contentStar: Int
)

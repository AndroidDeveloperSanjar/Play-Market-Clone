package uz.androbeck.playmarketclone.data.model

data class UIModel(
    val viewType: Int,
    val verticalData: List<UIVerticalData>
)

data class UIVerticalData(
    val title: String,
    val horizontalData: List<UIHorizontalData>
)

data class UIHorizontalData(
    val imageUrl: String,
    val contentName: String,
    val contentStar: Int
)

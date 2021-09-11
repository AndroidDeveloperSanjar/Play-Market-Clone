package uz.androbeck.playmarketclone.data

import android.content.Context
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.data.model.UIHorizontalData
import uz.androbeck.playmarketclone.data.model.UIModel
import uz.androbeck.playmarketclone.data.model.UIVerticalData
import uz.androbeck.playmarketclone.ui.fragments.*

object Data {

    val fragments = listOf(
        ForYouFragment(),
        TopChartsFragment(),
        ChildrenFragment(),
        PremiumFragment(),
        CategoriesFragment(),
        EditorsChoiceFragment()
    )

    fun titles(context: Context) = listOf(
        context.getString(R.string.title_for_you),
        context.getString(R.string.title_top_charts),
        context.getString(R.string.title_children),
        context.getString(R.string.title_premium),
        context.getString(R.string.title_categories),
        context.getString(R.string.title_editors_choice),
    )

    val uiData = listOf(
        UIModel(
            viewType = 0,
            verticalData = listOf(
                UIVerticalData(
                    titles = listOf(
                        "Sample 1",
                        "Sample 2",
                        "Sample 3",
                    ),
                    horizontalData = emptyList()
                )
            )
        ),
        UIModel(
            viewType = 1,
            verticalData = listOf(
                UIVerticalData(
                    titles = emptyList(),
                    horizontalData = listOf(
                        UIHorizontalData(
                            imageUrl = "",
                            contentName = "Name 1",
                            contentStar = 1
                        ),
                        UIHorizontalData(
                            imageUrl = "",
                            contentName = "Name 2",
                            contentStar = 2
                        ),
                        UIHorizontalData(
                            imageUrl = "",
                            contentName = "Name 3",
                            contentStar = 3
                        )
                    )
                )
            )
        )
    )

}
/*



 */
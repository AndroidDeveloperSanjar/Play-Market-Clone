package uz.androbeck.playmarketclone.data

import android.content.Context
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.data.model.UIHorizontalData
import uz.androbeck.playmarketclone.data.model.UIModel
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

    private var list1 = listOf(
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/221/200/300.jpg?hmac=vFrrajnPFCrr5ttjepVTsUDWzoo-orpnXOsqdqAd0LU",
            contentName = "Item 1 content name 1",
            contentStar = 1,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/237/200/300.jpg?hmac=TmmQSbShHz9CdQm0NkEjx1Dyh_Y984R9LpNrpvH2D_U",
            contentName = "Item 1 content name 2 bla bla bla bla bla bla bla bla",
            contentStar = 2,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/866/200/300.jpg?hmac=rcadCENKh4rD6MAp6V_ma-AyWv641M4iiOpe1RyFHeI",
            contentName = "Item 1 content name 3",
            contentStar = 3,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/598/200/300.jpg?grayscale&hmac=tbhTi6Y3jxqoBsTob_3qOiF2OGj0Q102NPDRMwdRlqw",
            contentName = "Item 1 content name 4",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/944/200/300.jpg?blur=2&hmac=Vk1ENWwQBHXUeBKM4phlo1vSAJhBdBqvrncHXyNXl2A",
            contentName = "Item 1 content name 5",
            contentStar = 5,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/169/200/300.jpg?blur=5&hmac=T5oB8AM70zm_oCIG4DRJlmljwSmIdsFT3fdbT2Pd-Tk",
            contentName = "Item 1 content name 6",
            contentStar = 6,
        )
    )

    private var list2 = listOf(
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/870/200/300.jpg?blur=2&grayscale&hmac=ujRymp644uYVjdKJM7kyLDSsrqNSMVRPnGU99cKl6Vs",
            contentName = "Item 2 content name 1",
            contentStar = 1,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/620/200/300.jpg?hmac=ZLg-jrbFo8ASzAzQlxN4yMTNJJBpZtcpDXfwBxAvcT4",
            contentName = "Item 2 content name 2 bla bla bla bla bla bla bla bla",
            contentStar = 2,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 2 content name 3",
            contentStar = 3,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 2 content name 4",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 2 content name 5",
            contentStar = 5,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 2 content name 6",
            contentStar = 6,
        )
    )

    private var list3 = listOf(
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 3 content name 1",
            contentStar = 1,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 3 content name 2 bla bla bla bla bla bla bla bla",
            contentStar = 2,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 3 content name 3",
            contentStar = 3,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 3 content name 4",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 3 content name 5",
            contentStar = 5,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 3 content name 6",
            contentStar = 6,
        )
    )

    private var list4 = listOf(
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 3 content name 1",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 3 content name 2 bla bla bla bla bla bla bla bla",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 3 content name 3",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 3 content name 4",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 3 content name 5",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 3 content name 6",
            contentStar = 4,
        )
    )

    private var list5 = listOf(
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 5 content name 1",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 5 content name 2 bla bla bla bla bla bla bla bla",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 5 content name 3",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 5 content name 4",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 5 content name 5",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 5 content name 6",
            contentStar = 4,
        )
    )

    private var list6 = listOf(
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 6 content name 1",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 6 content name 2 bla bla bla bla bla bla bla bla",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 6 content name 3",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 6 content name 4",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 6 content name 5",
            contentStar = 4,
        ),
        UIHorizontalData(
            imageUrl = "https://i.picsum.photos/id/786/200/300.webp?hmac=kbpRAPv5gYLji6157ovfRl-uwd1pt1aX0pJqwGDJZdQ",
            contentName = "Item 6 content name 6",
            contentStar = 4,
        )
    )

    val uiData = listOf(
        UIModel(
            viewType = 0,
            title = "Title 1",
            data = emptyList()
        ),
        UIModel(
            viewType = 1,
            title = "",
            data = list1
        ),
        UIModel(
            viewType = 0,
            title = "Title 2",
            data = emptyList()
        ),
        UIModel(
            viewType = 1,
            title = "",
            list2
        ),
        UIModel(
            viewType = 0,
            title = "Title 3",
            data = emptyList()
        ),
        UIModel(
            viewType = 1,
            title = "",
            list3
        ),
        UIModel(
            viewType = 0,
            title = "Title 4",
            data = emptyList()
        ),
        UIModel(
            viewType = 1,
            title = "",
            list4
        ),
        UIModel(
            viewType = 0,
            title = "Title 5",
            data = emptyList()
        ),
        UIModel(
            viewType = 1,
            title = "",
            list5
        ),
        UIModel(
            viewType = 0,
            title = "Title 6",
            data = emptyList()
        ),
        UIModel(
            viewType = 1,
            title = "",
            list6
        ),
    )
}
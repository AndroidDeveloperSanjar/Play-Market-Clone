package uz.androbeck.playmarketclone.ui

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.core.base.BaseListAdapter
import uz.androbeck.playmarketclone.data.model.UIHorizontalData

class HorizontalAdapter : BaseListAdapter<UIHorizontalData>(
    R.layout.item_horizontal_contents,
    COMPARATOR
) {

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<UIHorizontalData>() {
            override fun areItemsTheSame(
                oldItem: UIHorizontalData,
                newItem: UIHorizontalData
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: UIHorizontalData,
                newItem: UIHorizontalData
            ): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun bind(
        itemView: View,
        item: UIHorizontalData,
        position: Int,
        viewHolder: BaseViewHolderImp
    ) {
        with(itemView) {
            findViewById<AppCompatTextView>(R.id.tv_content_name).text = item.contentName
            findViewById<AppCompatTextView>(R.id.tv_content_star).text =
                "${item.contentStar} * Free"
        }
    }
}
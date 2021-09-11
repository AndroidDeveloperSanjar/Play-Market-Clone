package uz.androbeck.playmarketclone.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.androbeck.playmarketclone.data.model.UIModel
import uz.androbeck.playmarketclone.databinding.ItemHorizontalRvBinding
import uz.androbeck.playmarketclone.databinding.ItemTitleBinding
import uz.androbeck.playmarketclone.util.Constants

class UIAdapter : ListAdapter<UIModel, RecyclerView.ViewHolder>(COMPARATOR) {

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<UIModel>() {
            override fun areItemsTheSame(
                oldItem: UIModel,
                newItem: UIModel
            ): Boolean {
                return oldItem.viewType == newItem.viewType
            }

            override fun areContentsTheSame(
                oldItem: UIModel,
                newItem: UIModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Constants.VIEW_TYPE_TITLE -> TitleViewHolder(
                ItemTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            Constants.VIEW_TYPE_HORIZONTAL_CONTENTS -> HorizontalContentsViewHolder(
                ItemHorizontalRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> TitleViewHolder(
                ItemTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TitleViewHolder -> holder.bind(currentList[position])
            is HorizontalContentsViewHolder -> holder.bind(currentList[position])
        }
    }

    inner class TitleViewHolder(
        private val viewBinding: ItemTitleBinding
    ) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: UIModel) {
            viewBinding.tvTitle.text = item.title
        }
    }

    inner class HorizontalContentsViewHolder(
        private val viewBinding: ItemHorizontalRvBinding
    ) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: UIModel) {
            with(viewBinding) {
                val mAdapter = HorizontalAdapter()
                recyclerViewHorizontal.layoutManager =
                    LinearLayoutManager(root.context, RecyclerView.HORIZONTAL, false)
                recyclerViewHorizontal.adapter = mAdapter
                mAdapter.submitList(item.data)
            }
        }
    }

    override fun getItemCount() = currentList.size

    override fun getItemViewType(position: Int): Int {
        return when (currentList[position].viewType) {
            Constants.VIEW_TYPE_TITLE -> Constants.VIEW_TYPE_TITLE
            Constants.VIEW_TYPE_HORIZONTAL_CONTENTS -> Constants.VIEW_TYPE_HORIZONTAL_CONTENTS
            else -> Constants.VIEW_TYPE_TITLE
        }
    }

}
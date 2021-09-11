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
            is TitleViewHolder -> holder.bind()
            is HorizontalContentsViewHolder -> holder.bind()
        }
    }

    inner class TitleViewHolder(
        private val viewBinding: ItemTitleBinding
    ) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind() {
            currentList.find { it.viewType == 0 }?.verticalData?.forEach {
                viewBinding.tvTitle.text = it.title
            }
        }
    }

    inner class HorizontalContentsViewHolder(
        private val viewBinding: ItemHorizontalRvBinding
    ) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind() {
            println(currentList)
            with(viewBinding) {
                val mAdapter = HorizontalAdapter()
                recyclerViewHorizontal.layoutManager =
                    LinearLayoutManager(root.context, RecyclerView.HORIZONTAL, false)
                recyclerViewHorizontal.adapter = mAdapter
                currentList.find { it.viewType == 1 }?.verticalData?.forEach {
                    println(it.horizontalData)
                    mAdapter.submitList(it.horizontalData)
                }
                //mAdapter.submitList(currentList[bindingAdapterPosition].verticalData[bindingAdapterPosition].horizontalData)
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
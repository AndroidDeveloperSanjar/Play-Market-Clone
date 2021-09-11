package uz.androbeck.playmarketclone.ui.fragments

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.core.base.BaseFragment
import uz.androbeck.playmarketclone.databinding.FragmentCategoriesBinding


class CategoriesFragment : BaseFragment(R.layout.fragment_categories) {

    private val viewBinding: FragmentCategoriesBinding by viewBinding()

    private val viewModel: FragmentsViewModel by viewModels()

}
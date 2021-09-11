package uz.androbeck.playmarketclone.ui.fragments

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.core.base.BaseFragment
import uz.androbeck.playmarketclone.databinding.FragmentChildrenBinding


class ChildrenFragment : BaseFragment(R.layout.fragment_children) {

    private val viewBinding: FragmentChildrenBinding by viewBinding()

    private val viewModel: FragmentsViewModel by viewModels()

}
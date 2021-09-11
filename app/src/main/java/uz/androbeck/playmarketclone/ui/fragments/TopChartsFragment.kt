package uz.androbeck.playmarketclone.ui.fragments

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.core.base.BaseFragment
import uz.androbeck.playmarketclone.databinding.FragmentTopChartsBinding


class TopChartsFragment : BaseFragment(R.layout.fragment_top_charts) {

    private val viewBinding: FragmentTopChartsBinding by viewBinding()

    private val viewModel: FragmentsViewModel by viewModels()

}
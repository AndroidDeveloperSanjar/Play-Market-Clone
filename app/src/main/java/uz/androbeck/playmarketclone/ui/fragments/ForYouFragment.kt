package uz.androbeck.playmarketclone.ui.fragments

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.core.base.BaseFragment
import uz.androbeck.playmarketclone.core.lifecycle.EventObserver
import uz.androbeck.playmarketclone.databinding.FragmentForYouBinding
import uz.androbeck.playmarketclone.ui.UIAdapter

class ForYouFragment : BaseFragment(R.layout.fragment_for_you) {

    private val viewBinding: FragmentForYouBinding by viewBinding()

    private val viewModel: FragmentsViewModel by viewModels()

    private val mAdapter = UIAdapter()

    override fun setup() {
        viewModel.data()

        viewBinding.recyclerView.setHasFixedSize(true)
        viewBinding.recyclerView.adapter = mAdapter
    }

    override fun observe() {
        viewModel.data.observe(viewLifecycleOwner, EventObserver { data ->
            mAdapter.submitList(data)
        })
    }

}
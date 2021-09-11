package uz.androbeck.playmarketclone.ui.books

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.core.base.BaseFragment
import uz.androbeck.playmarketclone.core.lifecycle.EventObserver
import uz.androbeck.playmarketclone.databinding.FragmentBooksBinding

class BooksFragment : BaseFragment(R.layout.fragment_books) {

    private val viewBinding: FragmentBooksBinding by viewBinding()

    private val viewModel: BooksViewModel by viewModels()

    override fun clicks() {
        viewBinding.ivSettings.setOnClickListener {
            viewModel.navigateToSettings()
        }
    }

    override fun observe() {
        viewModel.navigateToSettings.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(R.id.navigation_settings)
        })
    }

}
package uz.androbeck.playmarketclone.ui.movies

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.core.base.BaseFragment
import uz.androbeck.playmarketclone.core.lifecycle.EventObserver
import uz.androbeck.playmarketclone.databinding.FragmentMoviesBinding

class MoviesFragment : BaseFragment(R.layout.fragment_movies) {

    private val viewBinding: FragmentMoviesBinding by viewBinding()

    private val viewModel: MoviesViewModel by viewModels()

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
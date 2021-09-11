package uz.androbeck.playmarketclone.ui.apps

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.core.base.BaseFragment
import uz.androbeck.playmarketclone.core.lifecycle.EventObserver
import uz.androbeck.playmarketclone.databinding.FragmentAppsBinding

class AppsFragment : BaseFragment(R.layout.fragment_apps) {

    private val viewBinding: FragmentAppsBinding by viewBinding()

    private val viewModel: AppsViewModel by viewModels()

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
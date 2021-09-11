package uz.androbeck.playmarketclone.ui.games

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.core.base.BaseFragment
import uz.androbeck.playmarketclone.core.base.BaseViewPagerAdapter
import uz.androbeck.playmarketclone.core.lifecycle.EventObserver
import uz.androbeck.playmarketclone.data.Data
import uz.androbeck.playmarketclone.databinding.FragmentGamesBinding

class GamesFragment : BaseFragment(R.layout.fragment_games) {

    private val viewBinding: FragmentGamesBinding by viewBinding()

    private val viewModel: GamesViewModel by viewModels()

    override fun setup() {
        viewModel.fragments()
    }

    override fun clicks() {
        viewBinding.ivSettings.setOnClickListener {
            viewModel.navigateToSettings()
        }
    }

    override fun observe() {
        viewModel.navigateToSettings.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(R.id.navigation_settings)
        })
        viewModel.fragments.observe(viewLifecycleOwner, fragmentsObserver)
    }

    private val fragmentsObserver = EventObserver<List<Fragment>> { fragments ->
        val viewPagerAdapter = BaseViewPagerAdapter(childFragmentManager, lifecycle, fragments)
        viewBinding.viewPager.adapter = viewPagerAdapter
        viewBinding.viewPager.isUserInputEnabled = false
        TabLayoutMediator(viewBinding.tabLayout, viewBinding.viewPager) { tab, position ->
            tab.text = Data.titles(requireContext())[position]
        }.attach()
    }
}
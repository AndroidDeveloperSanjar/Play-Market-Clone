package uz.androbeck.playmarketclone.ui.settings

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.core.base.BaseFragment
import uz.androbeck.playmarketclone.core.lifecycle.EventObserver
import uz.androbeck.playmarketclone.databinding.FragmentSettingsBinding
import uz.androbeck.playmarketclone.ui.settings.dialogs.language.ChangeLanguageBottomDialog
import uz.androbeck.playmarketclone.ui.settings.dialogs.theme.ChangeThemeBottomDialog

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    private val viewBinding: FragmentSettingsBinding by viewBinding()

    private val viewModel: SettingsViewModel by viewModels()

    override fun initialize() {
    }

    override fun setup() {
        viewModel.set()
    }

    override fun clicks() {
        viewBinding.ivBack.setOnClickListener {
            viewModel.backToHome()
        }
        viewBinding.viewChangeLanguage.setOnClickListener {
            viewModel.navigateToChangeLanguage()
        }
        viewBinding.viewChangeTheme.setOnClickListener {
            viewModel.navigateToChangeTheme()
        }
    }

    override fun observe() {
        viewModel.navigateToChangeLanguage.observe(viewLifecycleOwner, EventObserver {
            ChangeLanguageBottomDialog().show(parentFragmentManager, null)
        })
        viewModel.navigateToChangeTheme.observe(viewLifecycleOwner, EventObserver {
            ChangeThemeBottomDialog().show(parentFragmentManager, null)
        })
        viewModel.backToHome.observe(viewLifecycleOwner, EventObserver {
            findNavController().popBackStack()
        })
        viewModel.set.observe(viewLifecycleOwner, setObserver)
    }

    private val setObserver = EventObserver<Unit> {
        when (preferences.locale) {
            getString(R.string.en) -> {
                viewBinding.tvLanguage.text = getString(R.string.lan_english)
            }
            getString(R.string.ru) -> {
                viewBinding.tvLanguage.text = getString(R.string.lan_russian)
            }
            getString(R.string.uz) -> {
                viewBinding.tvLanguage.text = getString(R.string.lan_uzbek)
            }
        }
        when (preferences.theme) {
            getString(R.string.mode_night) -> {
                viewBinding.tvTheme.text = getString(R.string.text_night_mode)
            }
            getString(R.string.mode_light) -> {
                viewBinding.tvTheme.text = getString(R.string.text_light_mode)
            }
            getString(R.string.mode_red) -> {
                viewBinding.tvTheme.text = getString(R.string.text_red_mode)
            }
        }
    }
}
package uz.androbeck.playmarketclone.ui.settings.dialogs.theme

import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.core.base.BaseBottomDialog
import uz.androbeck.playmarketclone.core.lifecycle.EventObserver
import uz.androbeck.playmarketclone.databinding.DialogChangeThemeBinding
import uz.androbeck.playmarketclone.ui.settings.SettingsViewModel

class ChangeThemeBottomDialog : BaseBottomDialog(R.layout.dialog_change_theme) {

    private val viewBinding: DialogChangeThemeBinding by viewBinding()

    private val viewModel: SettingsViewModel by viewModels()

    override fun initialize() {
    }

    override fun setup() {
        viewModel.set()
    }

    override fun clicks() {
        viewBinding.viewDarkMode.setOnClickListener {
            viewModel.setTheme(getString(R.string.mode_night))
        }
        viewBinding.viewLightMode.setOnClickListener {
            viewModel.setTheme(getString(R.string.mode_light))
        }
        viewBinding.viewRedMode.setOnClickListener {
            viewModel.setTheme(getString(R.string.mode_red))
        }
    }

    override fun observe() {
        viewModel.setTheme.observe(viewLifecycleOwner, setThemeObserver)
        viewModel.set.observe(viewLifecycleOwner, setObserver)
    }

    private val setObserver = EventObserver<Unit> {
        with(viewBinding) {
            when (preferences.theme) {
                getString(R.string.mode_night) -> checkTheme(
                    ivCheckDarkMode,
                    ivCheckLightMode,
                    ivCheckRedMode
                )
                getString(R.string.mode_light) -> checkTheme(
                    ivCheckLightMode,
                    ivCheckDarkMode,
                    ivCheckRedMode
                )
                getString(R.string.mode_red) -> checkTheme(
                    ivCheckRedMode,
                    ivCheckDarkMode,
                    ivCheckLightMode
                )
            }
        }
    }

    private val setThemeObserver = EventObserver<String> { theme ->
        preferences.theme = theme
        requireActivity().recreate()
        dismiss()
    }

    private fun checkTheme(
        checkOne: AppCompatImageView,
        checkTwo: AppCompatImageView,
        checkThree: AppCompatImageView
    ) {
        checkOne.isVisible = true
        checkTwo.isVisible = false
        checkThree.isVisible = false
    }
}
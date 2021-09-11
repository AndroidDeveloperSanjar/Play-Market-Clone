package uz.androbeck.playmarketclone.ui.settings.dialogs.language

import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.androbeck.playmarketclone.PlayMarketCloneApp
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.core.base.BaseBottomDialog
import uz.androbeck.playmarketclone.core.language.AppLanguage
import uz.androbeck.playmarketclone.core.lifecycle.EventObserver
import uz.androbeck.playmarketclone.databinding.DialogChangeLanguageBinding
import uz.androbeck.playmarketclone.ui.settings.SettingsViewModel

class ChangeLanguageBottomDialog : BaseBottomDialog(R.layout.dialog_change_language) {

    private val viewBinding: DialogChangeLanguageBinding by viewBinding()

    private val viewModel: SettingsViewModel by viewModels()

    override fun initialize() {
        preferences = (requireActivity().application as PlayMarketCloneApp).preferences
    }

    override fun setup() {
        viewModel.set()
    }

    override fun clicks() {
        viewBinding.viewEnglish.setOnClickListener {
            viewModel.changeLanguage(getString(R.string.en))
        }
        viewBinding.viewRussian.setOnClickListener {
            viewModel.changeLanguage(getString(R.string.ru))
        }
        viewBinding.viewUzbek.setOnClickListener {
            viewModel.changeLanguage(getString(R.string.uz))
        }
    }

    override fun observe() {
        viewModel.changeLanguage.observe(viewLifecycleOwner, changeLanguageObserver)
        viewModel.set.observe(viewLifecycleOwner, setObserver)
    }

    private val setObserver = EventObserver<Unit> {
        with(viewBinding) {
            when (preferences.locale) {
                getString(R.string.en) -> checkLanguage(
                    ivCheckEnglish,
                    ivCheckRussian,
                    ivCheckUzbek
                )
                getString(R.string.ru) -> checkLanguage(
                    ivCheckRussian,
                    ivCheckEnglish,
                    ivCheckUzbek
                )
                getString(R.string.uz) -> checkLanguage(
                    ivCheckUzbek,
                    ivCheckRussian,
                    ivCheckEnglish
                )
            }
        }
    }

    private val changeLanguageObserver = EventObserver<String> { locale ->
        AppLanguage.getInstance().setLocale(requireContext(), locale)
        preferences.locale = locale
        dismiss()
        requireActivity().recreate()
    }

    private fun checkLanguage(
        checkOne: AppCompatImageView,
        checkTwo: AppCompatImageView,
        checkThree: AppCompatImageView
    ) {
        checkOne.isVisible = true
        checkTwo.isVisible = false
        checkThree.isVisible = false
    }
}
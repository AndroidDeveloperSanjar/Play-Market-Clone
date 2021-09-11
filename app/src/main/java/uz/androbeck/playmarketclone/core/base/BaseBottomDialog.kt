package uz.androbeck.playmarketclone.core.base

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import uz.androbeck.playmarketclone.PlayMarketCloneApp
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.core.cache.preferences.PreferencesManager
import uz.androbeck.playmarketclone.util.screenResolution

abstract class BaseBottomDialog(@LayoutRes private val resId: Int) : BottomSheetDialogFragment() {

    var canFullHeight = false

    lateinit var preferences: PreferencesManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        preferences = (requireActivity().application as PlayMarketCloneApp).preferences

        val contextWrapper = when (preferences.theme) {
            getString(R.string.mode_light) -> ContextThemeWrapper(
                requireActivity(),
                R.style.ThemeLight
            )
            getString(R.string.mode_night) -> ContextThemeWrapper(
                requireActivity(),
                R.style.ThemeDark
            )
            getString(R.string.mode_red) -> ContextThemeWrapper(
                requireActivity(),
                R.style.ThemeRed
            )
            else -> ContextThemeWrapper(requireActivity(), R.style.ThemeLight)
        }

        return inflater.cloneInContext(contextWrapper).inflate(resId, null, false)
    }

    @CallSuper
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            setOnShowListener {
                val bottomSheet: FrameLayout? =
                    findViewById(com.google.android.material.R.id.design_bottom_sheet)
                bottomSheet?.setBackgroundResource(android.R.color.transparent)
                bottomSheet?.background = ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.bottom_sheet_corner_radius
                )
                onShow(it)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialize()
        observe()
        setup()
        clicks()
    }

    open fun observe() {}
    open fun setup() {}
    open fun initialize() {}
    open fun clicks() {}

    @CallSuper
    open fun onShow(dialogInterface: DialogInterface) {
        if (canFullHeight) {
            val dialog = dialogInterface as BottomSheetDialog
            val sheet: FrameLayout? =
                dialog.findViewById(com.google.android.material.R.id.design_bottom_sheet)

            val layoutParams = sheet?.layoutParams

            val windowHeight = requireActivity().screenResolution.height

            layoutParams?.height = windowHeight
            sheet?.layoutParams = layoutParams
        }
    }
}
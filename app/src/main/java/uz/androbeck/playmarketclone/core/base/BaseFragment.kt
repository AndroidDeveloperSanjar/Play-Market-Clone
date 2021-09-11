package uz.androbeck.playmarketclone.core.base

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.*
import androidx.activity.addCallback
import androidx.annotation.CallSuper
import androidx.annotation.ColorInt
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.androbeck.playmarketclone.PlayMarketCloneApp
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.core.cache.preferences.PreferencesManager
import uz.androbeck.playmarketclone.util.appCompatActivity
import uz.androbeck.playmarketclone.util.toast

abstract class BaseFragment(
    private val
    contentLayoutId: Int
) : Fragment() {

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
            getString(R.string.mode_red) -> ContextThemeWrapper(requireActivity(), R.style.ThemeRed)
            else -> ContextThemeWrapper(requireActivity(), R.style.ThemeLight)
        }

        val mInflater = inflater.cloneInContext(contextWrapper)

        val rootView = mInflater.inflate(contentLayoutId, null, false)

        return rootView
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this) {
            if (!onBackPressed()) {
                isEnabled = false
                activity?.onBackPressed()
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

    fun <T> entryLiveData(key: String) =
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key)

    fun updateStatusColor(@ColorInt color: Int) {
        with(activity?.window ?: return) {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = color
        }
    }

    fun resetStatusColor() {
        with(activity?.window ?: return) {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

            val typedValue = TypedValue()
            appCompatActivity.theme.resolveAttribute(
                android.R.attr.colorPrimaryDark,
                typedValue,
                true
            )
            val color =
                if (typedValue.type >= TypedValue.TYPE_FIRST_COLOR_INT && typedValue.type <= TypedValue.TYPE_FIRST_COLOR_INT)
                    typedValue.data
                else Color.TRANSPARENT
            statusBarColor = color
        }
    }

    fun updateStatusAndNavigationColor(@ColorInt color: Int) {
        with(activity?.window ?: return) {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = color
            navigationBarColor = color
        }
    }

    fun attachToolbar(toolbar: Toolbar, isBackEnabled: Boolean = true, label: String? = null) {
        with(appCompatActivity) {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(isBackEnabled)
            supportActionBar?.setDisplayShowHomeEnabled(isBackEnabled)
            title = label ?: findNavController().currentDestination?.label
        }
    }

    fun fullScreenBar() {
        with(activity?.window ?: return) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                insetsController?.apply {
                    systemBarsBehavior =
                        WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                    hide(WindowInsets.Type.statusBars())
                }
            } else setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }

    fun translucentBar() {
        with(activity?.window ?: return) {
            setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }

    fun clearTranslucent() {
        with(activity?.window ?: return) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                insetsController?.apply {
                    show(WindowInsets.Type.statusBars())
                }
            } else {
                clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            }
        }
    }

    fun finish() = findNavController().popBackStack()

    open fun onBackPressed(): Boolean {
        return false
    }

}
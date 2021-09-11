package uz.androbeck.playmarketclone.util

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.os.Build
import android.util.DisplayMetrics
import android.util.Size
import android.util.TypedValue
import android.view.Display
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

fun <T> ArrayList<T>.cleanup(collection: Collection<T>) {
    clear()
    addAll(collection)
}

fun EditText.textOrNull(): String? {
    return if (text.isNullOrEmpty()) null
    else text.toString()
}

val Fragment.appCompatActivity: AppCompatActivity
    get() {
        return requireActivity() as AppCompatActivity
    }

fun ViewPager2.setOnPageSelected(onPageSelected: (Int) -> Unit) {
    registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            onPageSelected.invoke(position)
        }
    })
}

fun Fragment.launchWithDelay(interval: Long = 300, onLaunch: () -> Unit) {
    viewLifecycleOwner.lifecycleScope.launch {
        delay(interval)
        onLaunch.invoke()
    }
}

fun Activity.toast(message: String, isLong: Boolean = false) {
    if (isLong) Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    else Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(message: String, isLong: Boolean = false) {
    if (isLong) Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    else Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun View.enable(enabled: Boolean) {
    isEnabled = enabled
    alpha = if (enabled) 1f else 0.5f
}

fun Fragment.hideKeyboard() {
    val imm: InputMethodManager =
        activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    //Find the currently focused view, so we can grab the correct window token from it.
    var view: View? = activity?.currentFocus
    //If no view currently has focus, create a new one, just so we can grab a window token from it
    if (view == null) {
        view = View(activity)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun View.hideKeyboard() {
    val imm: InputMethodManager =
        context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager

    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun View.showSoftInput() {
    val imm: InputMethodManager =
        context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager

    imm.showSoftInput(this, WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
}

@Suppress("DEPRECATION")
val Context.screenResolution: Size
    get() {
        val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) display
        else wm.defaultDisplay

        val metrics = DisplayMetrics()
        display?.getRealMetrics(metrics)

        val width = metrics.widthPixels
        val height = metrics.heightPixels

        return Size(width, height)
    }

fun Context.px(dp: Float) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)

fun Context.px(dp: Int) = px(dp.toFloat()).toInt()

@ColorInt
fun Context.getColorFromAttr(
    @AttrRes attrColor: Int,
    typedValue: TypedValue = TypedValue(),
    resolveRefs: Boolean = true,
): Int {
    theme.resolveAttribute(attrColor, typedValue, resolveRefs)
    return typedValue.data
}

fun View.px(dp: Float) = context.px(dp)

fun View.px(dp: Int) = context.px(dp)

fun Fragment.px(dp: Float) = requireContext().px(dp)

fun Fragment.px(dp: Int) = requireContext().px(dp)

@Suppress("DEPRECATION")
internal fun Configuration.getLocaleCompat(): Locale {
    return if (isAtLeastSdkVersion(Build.VERSION_CODES.N)) locales.get(0) else locale
}

internal fun isAtLeastSdkVersion(versionCode: Int): Boolean {
    return Build.VERSION.SDK_INT >= versionCode
}

internal fun Activity.resetTitle() {
    try {
        val info = packageManager.getActivityInfo(componentName, PackageManager.GET_META_DATA)
        if (info.labelRes != 0) {
            setTitle(info.labelRes)
        }
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
    }
}



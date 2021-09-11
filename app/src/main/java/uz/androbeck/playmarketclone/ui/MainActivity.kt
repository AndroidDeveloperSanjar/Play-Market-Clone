package uz.androbeck.playmarketclone.ui

import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.iterator
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import uz.androbeck.playmarketclone.PlayMarketCloneApp
import uz.androbeck.playmarketclone.R
import uz.androbeck.playmarketclone.core.cache.preferences.PreferencesManager
import uz.androbeck.playmarketclone.core.lifecycle.EventObserver
import uz.androbeck.playmarketclone.databinding.ActivityMainBinding
import uz.androbeck.playmarketclone.util.NetworkManager
import uz.androbeck.playmarketclone.util.snack

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var preferences: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NetworkManager(this).observe(this, EventObserver { isNetwork ->
            if (!isNetwork) binding.root.snack("Network disabled. Please network enabled") {}
        })

        preferences = (application as PlayMarketCloneApp).preferences

        val navView: BottomNavigationView = binding.navView

        navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_games,
                R.id.navigation_apps,
                R.id.navigation_movies,
                R.id.navigation_books
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->

            for (menuItem in navView.menu.iterator()) {
                menuItem.isEnabled = true
            }

            val menu = navView.menu.findItem(destination.id)
            menu?.isEnabled = false
        }

        statusBarColor()
    }

    private fun statusBarColor() {
        when (preferences.theme) {
            getString(R.string.mode_night) -> {
                updateStatusColor(ContextCompat.getColor(this, R.color.black))
                setLightStatusBarTextColor(false)
                binding.navView.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.dark_back_bottom_dialog_color
                    )
                )
            }
            getString(R.string.mode_light) -> {
                updateStatusColor(ContextCompat.getColor(this, R.color.white))
                setLightStatusBarTextColor(true)
                binding.navView.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
            }
            getString(R.string.mode_red) -> {
                updateStatusColor(
                    ContextCompat.getColor(
                        this,
                        R.color.holo_red
                    )
                )
                setLightStatusBarTextColor(false)
                binding.navView.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.red_back_bottom_dialog_color
                    )
                )
            }
        }
    }

    private fun updateStatusColor(@ColorInt color: Int) {
        with(window ?: return) {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = color
        }
    }

    private fun setLightStatusBarTextColor(isLight: Boolean) {
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars =
            isLight
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
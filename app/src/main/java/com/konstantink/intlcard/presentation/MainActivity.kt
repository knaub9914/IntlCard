package com.konstantink.intlcard.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.konstantink.intlcard.R
import com.konstantink.intlcard.di.AppComponent
import com.konstantink.intlcard.domain.entities.CardSet
import com.konstantink.intlcard.presentation.fragments.EntryPageFragment
import com.konstantink.intlcard.presentation.viewmodels.CardSetViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    var currentCardSet : CardSet? = null
    private val viewModel : CardSetViewModel by viewModels {
        getAppComponent().cardSetViewModelsFactory()
    }

    private fun AppCompatActivity.getAppComponent(): AppComponent = (this.applicationContext as IntlCardApp).appComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as IntlCardApp).appComponent.inject(this)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}

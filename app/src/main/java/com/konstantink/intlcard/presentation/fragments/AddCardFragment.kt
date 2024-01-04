package com.konstantink.intlcard.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.konstantink.intlcard.databinding.AddCardPageBinding
import com.konstantink.intlcard.di.AppComponent
import com.konstantink.intlcard.presentation.IntlCardApp
import com.konstantink.intlcard.presentation.viewmodels.CardSetViewModel

class AddCardFragment : Fragment() {
    private var _binding: AddCardPageBinding? = null

    private val viewModel : CardSetViewModel by activityViewModels {
        getAppComponent().cardSetViewModelsFactory()
    }

    private fun Fragment.getAppComponent(): AppComponent = (requireContext().applicationContext as IntlCardApp).appComponent

    private val binding get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = AddCardPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        binding.idCloseAddCarSetPage.setOnClickListener {
            navController.navigateUp()
        }
        binding.idSubmitCardSetBtn.setOnClickListener {
            viewModel.createCard(binding.idTargetSetText.text.toString(),
                    binding.idTranslationSetText.text.toString(), binding.idContextText.text.toString() )
        }
        viewModel.getCards()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
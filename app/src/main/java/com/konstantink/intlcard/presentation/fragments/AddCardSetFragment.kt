package com.konstantink.intlcard.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.konstantink.intlcard.R
import com.konstantink.intlcard.databinding.AddCardSetPageBinding
import com.konstantink.intlcard.di.AppComponent
import com.konstantink.intlcard.presentation.IntlCardApp
import com.konstantink.intlcard.presentation.viewmodels.CardSetViewModel

class AddCardSetFragment: Fragment() {
    private lateinit var _binding: AddCardSetPageBinding
    private val viewModel : CardSetViewModel by activityViewModels {
        getAppComponent().cardSetViewModelsFactory()
    }
    private fun Fragment.getAppComponent(): AppComponent = (requireContext().applicationContext as IntlCardApp).appComponent

    private val binding get() = _binding

    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = AddCardSetPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        navController = Navigation.findNavController(view)
        binding.spinnerOrigin.adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.languages_array,
            android.R.layout.simple_spinner_item
        )

        binding.spinnerTarget.adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.languages_array,
            android.R.layout.simple_spinner_item
        )

        binding.idCloseAddCarSetPage.setOnClickListener {
            navController.navigateUp()
        }

        binding.idSubmitCardSetBtn.setOnClickListener {
            viewModel.createCardSet(
                binding.spinnerOrigin.selectedItem.toString(),
                binding.spinnerTarget.selectedItem.toString(),
                binding.idContextText.text.toString()
            )

            if (viewModel.shouldScreenClose.value == true) {
                navController.navigateUp()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}
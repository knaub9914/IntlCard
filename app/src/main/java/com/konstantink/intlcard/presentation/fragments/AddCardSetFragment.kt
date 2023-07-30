package com.konstantink.intlcard.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.konstantink.intlcard.R
import com.konstantink.intlcard.databinding.AddCardSetPageBinding
import com.konstantink.intlcard.databinding.CardSetsOverviewBinding
import com.konstantink.intlcard.presentation.viewmodels.CardSetViewModel

class AddCardSetFragment: Fragment() {
    private var _binding: AddCardSetPageBinding? = null

    private lateinit var  viewModel: CardSetViewModel

    private val binding get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = AddCardSetPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[CardSetViewModel::class.java]
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
        binding.idSubmitCardSetBtn.setOnClickListener{
            viewModel.createCardSet(
                binding.spinnerOrigin.selectedItem.toString(),
                binding.spinnerTarget.selectedItem.toString(),
                binding.idContextText.text.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
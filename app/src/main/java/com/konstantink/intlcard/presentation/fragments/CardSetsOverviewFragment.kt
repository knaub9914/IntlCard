package com.konstantink.intlcard.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.konstantink.intlcard.R
import com.konstantink.intlcard.databinding.CardSetsOverviewBinding
import com.konstantink.intlcard.databinding.LogInPageBinding
import com.konstantink.intlcard.presentation.adapters.CardSetAdapter
import com.konstantink.intlcard.presentation.viewmodels.CardSetViewModel

class CardSetsOverviewFragment: Fragment() {

    private var _binding: CardSetsOverviewBinding? = null

    private val binding get() = _binding!!

    private lateinit var navController: NavController

    private lateinit var viewModel: CardSetViewModel

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = CardSetsOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[CardSetViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        navController = Navigation.findNavController(view)
        binding.idAddCardSetButton.setOnClickListener {
         navController.navigate(R.id.action_CardSetsOverviewPageFragment_to_AddCardSetFragment)

        }
        val adapter = CardSetAdapter(requireActivity())
        binding.rvCardSetList.adapter = adapter
        viewModel.cardSetList.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
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
import com.konstantink.intlcard.R
import com.konstantink.intlcard.databinding.CardsOverviewBinding
import com.konstantink.intlcard.di.AppComponent
import com.konstantink.intlcard.presentation.IntlCardApp
import com.konstantink.intlcard.presentation.MainActivity
import com.konstantink.intlcard.presentation.adapters.card.CardAdapter
import com.konstantink.intlcard.presentation.viewmodels.CardSetViewModel

class CardsOverviewFragment: Fragment() {
    private var _binding: CardsOverviewBinding? = null

    private val binding get() = _binding!!

    private lateinit var navController: NavController

    private val viewModel : CardSetViewModel by activityViewModels {
        getAppComponent().cardSetViewModelsFactory()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CardsOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun Fragment.getAppComponent(): AppComponent = (requireContext().applicationContext as IntlCardApp).appComponent
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = viewLifecycleOwner

        navController = Navigation.findNavController(view)
        binding.idAddCardButton.setOnClickListener {
            navController.navigate(R.id.action_CardsOverviewFragment_to_AddCardFragment)
        }
        val adapter = CardAdapter(requireActivity(), longListener =  { item ->
//            viewModel.deleteCardSet(item.id)
            true
        },
            listener = {
                navController.navigate(R.id.action_CardsOverviewFragment_to_AddCardFragment)
            })
        binding.rvCardList.adapter = adapter

        viewModel.cardList.observe(viewLifecycleOwner) {
            val currentCardSetList = it.filter { it.cardSetId == viewModel.currentCardSet?.id }
            adapter.submitList(currentCardSetList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
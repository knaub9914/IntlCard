package com.konstantink.intlcard.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.konstantink.intlcard.R
import com.konstantink.intlcard.databinding.CardSetsOverviewBinding
import com.konstantink.intlcard.di.AppComponent
import com.konstantink.intlcard.presentation.IntlCardApp
import com.konstantink.intlcard.presentation.adapters.cardset.CardSetAdapter
import com.konstantink.intlcard.presentation.viewmodels.CardSetViewModel

class CardSetsOverviewFragment: Fragment() {

    private var _binding: CardSetsOverviewBinding? = null

    private val binding get() = _binding!!

    private lateinit var navController: NavController

    private val viewModel : CardSetViewModel by activityViewModels {
        getAppComponent().cardSetViewModelsFactory()
    }
    private fun Fragment.getAppComponent(): AppComponent = (requireContext().applicationContext as IntlCardApp).appComponent
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = CardSetsOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewModel = viewModel
//        viewModel.clearCurrentCardSet()
        binding.lifecycleOwner = viewLifecycleOwner
        navController = Navigation.findNavController(view)
        val bundle = bundleOf("test" to 1)
        binding.idAddCardSetButton.setOnClickListener {
            navController.navigate(R.id.action_CardSetsOverviewPageFragment_to_AddCardSetFragment)

        }
        val adapter = CardSetAdapter(requireActivity(), longListener =  { item ->
            viewModel.deleteCardSet(item.id)
            true
        },
            listener = {
                viewModel.setActiveCardSet(it)
                navController.navigate(
                    R.id.action_CardSetsOverviewPageFragment_to_CardsOverviewFragment, bundle)
            })
        binding.rvCardSetList.adapter = adapter
        viewModel.cardSetList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
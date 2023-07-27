package com.konstantink.intlcard.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.konstantink.intlcard.R
import com.konstantink.intlcard.databinding.EntryPageBinding

class EntryPageFragment : Fragment() {

    private var _binding: EntryPageBinding? = null

    private val binding get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = EntryPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        binding.idLogInBtn.setOnClickListener {
            navController.navigate(R.id.action_EntryPageFragment_to_LogInPageFragment)
        }
        binding.idSignUpBtn.setOnClickListener {
            navController.navigate(R.id.action_EntryPageFragment_to_RegistrationPageFragment)

        }
        binding.idSkipLogIn.setOnClickListener {
            navController.navigate(R.id.action_EntryPageFragment_to_CardSetsOverviewPageFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
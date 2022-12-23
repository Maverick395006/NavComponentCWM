package com.maverick.navcomponentcwm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.maverick.navcomponentcwm.R
import com.maverick.navcomponentcwm.databinding.FragmentSpecifyAmountBinding

class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentSpecifyAmountBinding? = null
    private val binding get() = _binding!!

    lateinit var navController: NavController
    lateinit var recipient: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = requireArguments().getString("recipient").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSpecifyAmountBinding.inflate(inflater, container, false)
        val view = binding.root



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recipient.text = buildString {
            append("Sending money to ")
            append(recipient)
        }

        navController = Navigation.findNavController(view)

        binding.apply {
            sendBtn.setOnClickListener(this@SpecifyAmountFragment)
            cancelBtn.setOnClickListener(this@SpecifyAmountFragment)
        }

    }

    override fun onClick(v: View?) {
        binding.apply {
            when (v!!.id) {
                sendBtn.id -> navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment)
                cancelBtn.id -> activity?.onBackPressed()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
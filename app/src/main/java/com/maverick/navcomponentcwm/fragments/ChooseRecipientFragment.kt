package com.maverick.navcomponentcwm.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.maverick.navcomponentcwm.R
import com.maverick.navcomponentcwm.databinding.FragmentChooseReceipientBinding

class ChooseRecipientFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentChooseReceipientBinding? = null
    private val binding get() = _binding!!

    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentChooseReceipientBinding.inflate(inflater, container, false)
        val view = binding.root



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.apply {
            nextBtn.setOnClickListener(this@ChooseRecipientFragment)
            cancelBtn.setOnClickListener(this@ChooseRecipientFragment)
        }

    }

    override fun onClick(v: View?) {
        binding.apply {
            when (v!!.id) {
                nextBtn.id -> {
                    if (!TextUtils.isEmpty(binding.inputRecipient.text.toString())) {
                        val bundle = bundleOf("recipient" to binding.inputRecipient.text.toString())
                        navController!!.navigate(
                            R.id.action_chooseRecipientFragment_to_specifyAmountFragment,
                            bundle
                        )
                    } else {
                        Toast.makeText(activity, "Enter name of recipient", Toast.LENGTH_SHORT).show()
                    }
                }
                cancelBtn.id -> activity?.onBackPressed()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        navController = null
    }
}
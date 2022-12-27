package com.maverick.navcomponentcwm.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.maverick.navcomponentcwm.databinding.FragmentSpecifyAmountBinding
import com.maverick.navcomponentcwm.model.Money
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentSpecifyAmountBinding? = null
    private val binding get() = _binding!!

    lateinit var navController: NavController
    lateinit var recipient: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient").toString()
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

        binding.tvRecipient.text = buildString {
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
                sendBtn.id -> {
                    if (!TextUtils.isEmpty(binding.inputAmount.text.toString())) {
                        val amount = Money(BigDecimal(binding.inputAmount.text.toString()))
                        val action = SpecifyAmountFragmentDirections.actionSpecifyAmountFragmentToConfirmationFragment(recipient,amount)
                        navController.navigate(action)
                    } else {
                        Toast.makeText(activity, "Fill amount", Toast.LENGTH_SHORT).show()
                    }
                }
                cancelBtn.id -> activity?.onBackPressed()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
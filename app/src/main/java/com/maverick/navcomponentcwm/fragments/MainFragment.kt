package com.maverick.navcomponentcwm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.maverick.navcomponentcwm.R
import com.maverick.navcomponentcwm.databinding.FragmentMainBinding

class MainFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.apply {
            viewTransactionsBtn.setOnClickListener(this@MainFragment)
            sendMoneyBtn.setOnClickListener(this@MainFragment)
            viewBalanceBtn.setOnClickListener(this@MainFragment)
        }

    }

    override fun onClick(v: View?) {
        binding.apply {
            when (v!!.id) {
                viewTransactionsBtn.id -> navController!!.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
                sendMoneyBtn.id -> navController!!.navigate(R.id.action_mainFragment_to_chooseRecipientFragment)
                viewBalanceBtn.id -> navController!!.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        navController = null
    }
}
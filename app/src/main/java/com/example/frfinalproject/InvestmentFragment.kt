package com.example.frfinalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.net.Uri
import androidx.navigation.Navigation
import com.example.frfinalproject.databinding.FragmentInvestmentBinding
import kotlin.math.pow


class InvestmentFragment : Fragment() {


    private lateinit var binding: FragmentInvestmentBinding
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInvestmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.investmentToStart)
        }
    }

    override fun onStart() {
        super.onStart()
        arguments?.let{
            val args = InvestmentFragmentArgs.fromBundle(it)
            val initialInvestment = args.message.toFloat()

            val growthRate = 0.1f

            binding.tvOneYearValue.text = calculateFutureValue(initialInvestment,growthRate, 1).toString()
            binding.tvFiveYearsValue.text = calculateFutureValue(initialInvestment, growthRate, 5).toString()
            binding.tvTenYearsValue.text = calculateFutureValue(initialInvestment, growthRate, 10).toString()
            binding.tvTwentyYearsValue.text = calculateFutureValue(initialInvestment, growthRate, 20).toString()
            binding.tvThirtyYearsValue.text = calculateFutureValue(initialInvestment, growthRate, 30).toString()
        }
    }

    private fun calculateFutureValue(investment: Float, annualGrowthRate: Float, years: Int): Float {
        return investment * (1 + annualGrowthRate).pow(years)
    }


}
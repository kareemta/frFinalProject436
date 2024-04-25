package com.example.frfinalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.net.Uri
import androidx.navigation.Navigation
import com.example.frfinalproject.databinding.FragmentInvestmentBinding


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
            binding.tvFiveYearsValue.text = args.message
        }
    }


}
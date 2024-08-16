package com.example.androidcodesandtricks.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.adapter.CountryCodeAdapter
import com.example.androidcodesandtricks.databinding.FragmentCountryCodeBinding
import com.example.androidcodesandtricks.model.loadCountryData

class CountryCodeFragment : Fragment() {

    private lateinit var binding: FragmentCountryCodeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCountryCodeBinding.inflate(layoutInflater)

        initViews()

        return binding.root
    }

    private fun initViews() {

        val countryList = loadCountryData(requireContext())
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvCountryCode.layoutManager = linearLayoutManager
        binding.rvCountryCode.adapter = CountryCodeAdapter(requireContext(), countryList)

    }

}
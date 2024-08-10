package com.example.androidcodesandtricks.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.adapter.AboutDeviceAdapter
import com.example.androidcodesandtricks.adapter.TrendingListAdapter
import com.example.androidcodesandtricks.databinding.FragmentAboutDeviceBinding
import com.example.androidcodesandtricks.databinding.FragmentHomeBinding
import com.example.androidcodesandtricks.model.AboutDeviceModel
import com.example.androidcodesandtricks.model.TrendingListModel


class AboutDeviceFragment : Fragment() {

    private lateinit var binding: FragmentAboutDeviceBinding
    lateinit var aboutDeviceAdapter: AboutDeviceAdapter
    lateinit var aboutDeviceList: ArrayList<AboutDeviceModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAboutDeviceBinding.inflate(inflater, container, false)

        initList()
        initViews()

        return binding.root
    }

    private fun initList() {

        aboutDeviceList = ArrayList()

        aboutDeviceList.add(AboutDeviceModel("Brand", Build.BRAND))
        aboutDeviceList.add(AboutDeviceModel("Device ID", Build.DEVICE))
        aboutDeviceList.add(AboutDeviceModel("Model", Build.MODEL))
        aboutDeviceList.add(AboutDeviceModel("ID", Build.ID))
        aboutDeviceList.add(AboutDeviceModel("SDK", "${Build.VERSION.SDK_INT}"))
        aboutDeviceList.add(AboutDeviceModel("Manufacture", Build.MANUFACTURER))
        aboutDeviceList.add(AboutDeviceModel("User", Build.USER))
        aboutDeviceList.add(AboutDeviceModel("Type", Build.TYPE))
        aboutDeviceList.add(AboutDeviceModel("Base", Build.VERSION.BASE_OS))
        aboutDeviceList.add(AboutDeviceModel("Incremental", Build.VERSION.INCREMENTAL))
        aboutDeviceList.add(AboutDeviceModel("Board", Build.BOARD))
        aboutDeviceList.add(AboutDeviceModel("Host", Build.HOST))
        aboutDeviceList.add(AboutDeviceModel("Display", Build.DISPLAY))
        aboutDeviceList.add(AboutDeviceModel("Hardware", Build.HARDWARE))
        aboutDeviceList.add(AboutDeviceModel("Product", Build.PRODUCT))
        aboutDeviceList.add(AboutDeviceModel("CPU ABI", Build.CPU_ABI))
        aboutDeviceList.add(AboutDeviceModel("Fingerprint", Build.FINGERPRINT))
        aboutDeviceList.add(AboutDeviceModel("Android Version", Build.VERSION.RELEASE))

    }

    private fun initViews() {

        //setting up device info list linear recycler view layout manager and adapter and passing list to adapter
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvDeviceInfo.layoutManager = linearLayoutManager
        aboutDeviceAdapter = AboutDeviceAdapter(requireContext(), aboutDeviceList)
        binding.rvDeviceInfo.adapter = aboutDeviceAdapter
        aboutDeviceAdapter.notifyDataSetChanged()

    }

}
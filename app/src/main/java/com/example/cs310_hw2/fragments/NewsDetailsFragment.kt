package com.example.cs310_hw2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.cs310_hw2.R
import com.example.cs310_hw2.databinding.FragmentNewsBinding
import com.example.cs310_hw2.databinding.FragmentNewsDetailsBinding


class NewsDetailsFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsDetailsBinding.inflate(inflater)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar2)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false) //Remove toolbar default title
        binding.toolbar2.setNavigationOnClickListener { requireActivity().onBackPressed() }

        return binding.root
    }

}
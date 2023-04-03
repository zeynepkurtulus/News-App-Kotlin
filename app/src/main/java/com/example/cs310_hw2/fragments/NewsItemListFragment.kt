package com.example.cs310_hw2.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cs310_hw2.R
import com.example.cs310_hw2.adapter.NewsAdapter
import com.example.cs310_hw2.adapter.NewsViewPagerViewAdapter
import com.example.cs310_hw2.data.NewsCategoryByIdItem
import com.example.cs310_hw2.data.NewsCategoryByIdResponse
import com.example.cs310_hw2.data.NewsCategoryResponse
import com.example.cs310_hw2.databinding.FragmentNewsBinding
import com.example.cs310_hw2.databinding.FragmentNewsItemListBinding
import com.example.cs310_hw2.remote.Apiservice
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsItemListFragment : Fragment() {

    private lateinit var binding: FragmentNewsItemListBinding
    private lateinit var list: ArrayList<NewsCategoryByIdItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsItemListBinding.inflate(inflater)

        val apiInterface = Apiservice.create().getByCategoryId(arguments?.get(POSITION_ARG).toString().toInt()+1)
        apiInterface.enqueue( object : Callback<NewsCategoryByIdResponse> {
            override fun onResponse(call: Call<NewsCategoryByIdResponse>?, response: Response<NewsCategoryByIdResponse>?) {
                if(response?.body() != null){
                    list = response.body()!!.items
                    var adapter = NewsAdapter(requireContext(),list)
                    binding.recyclerviewnews.adapter = adapter

                }
            }
            override fun onFailure(call: Call<NewsCategoryByIdResponse>?, t: Throwable?) { }
        })



        return binding.root
    }

    companion object {
        var POSITION_ARG = "position_arg"

        @JvmStatic
        fun newInstance(position: Int) = NewsItemListFragment().apply {
            arguments = Bundle().apply {
                putInt(POSITION_ARG, position)
            }
        }
    }

}
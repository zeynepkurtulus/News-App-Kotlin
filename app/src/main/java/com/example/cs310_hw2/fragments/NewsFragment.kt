package com.example.cs310_hw2.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.cs310_hw2.Data
import com.example.cs310_hw2.R
import com.example.cs310_hw2.adapter.NewsViewPagerViewAdapter
import com.example.cs310_hw2.data.NewsCategoryItem
import com.example.cs310_hw2.data.NewsCategoryResponse
import com.example.cs310_hw2.databinding.FragmentNewsBinding
import com.example.cs310_hw2.remote.Apiservice
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsFragment : Fragment() {

    private lateinit var binding:FragmentNewsBinding
    private lateinit var viewPager:ViewPager2
    private lateinit var listCategory: ArrayList<NewsCategoryItem>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater)


        val apiInterface = Apiservice.create().getAllNewsCategories()
        apiInterface.enqueue( object : Callback<NewsCategoryResponse> {
            override fun onResponse(call: Call<NewsCategoryResponse>?, response: Response<NewsCategoryResponse>?) {
                if(response?.body() != null){
                    listCategory = response.body()!!.items
                    val adapter = NewsViewPagerViewAdapter(this@NewsFragment)
                    viewPager = binding.viewpagernews
                    viewPager?.adapter = adapter

                    TabLayoutMediator(binding.tabLayout,
                        viewPager!!) { tab, position ->

                        tab.text = listCategory[position].name

                    }.attach()
                }
            }
            override fun onFailure(call: Call<NewsCategoryResponse>?, t: Throwable?) { }
        })


        return binding.root
    }

}
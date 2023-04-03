package com.example.cs310_hw2.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cs310_hw2.ListOption
import com.example.cs310_hw2.data.NewsCategoryItem
import com.example.cs310_hw2.fragments.NewsItemListFragment

class NewsViewPagerViewAdapter (fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int) = NewsItemListFragment.newInstance(position)

}
package com.example.cs310_hw2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cs310_hw2.R
import com.example.cs310_hw2.data.NewsCategoryByIdItem
import com.example.cs310_hw2.databinding.NewsRecycleritemLayoutBinding
import com.squareup.picasso.Picasso

class NewsAdapter(
    var mContext: Context,
    var list: List<NewsCategoryByIdItem>,
) : RecyclerView.Adapter<NewsAdapter.CardDesignAttachment>() {

    inner class CardDesignAttachment(binding: NewsRecycleritemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: NewsRecycleritemLayoutBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignAttachment {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding:NewsRecycleritemLayoutBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.news_recycleritem_layout, parent, false)
        return CardDesignAttachment(binding)

    }

    override fun onBindViewHolder(holder: CardDesignAttachment, position: Int) {
        val item = list.get(position)
        val t = holder.binding
        Picasso.get().load(item.image).into(t.imageView)
        t.textView.text = item.date
        t.textView2.text = item.title

    }

    override fun getItemCount(): Int {
        return list.size
    }
}
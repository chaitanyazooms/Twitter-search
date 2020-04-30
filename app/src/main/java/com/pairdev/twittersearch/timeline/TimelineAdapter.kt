package com.pairdev.twittersearch.timeline

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.pairdev.twittersearch.core.models.Tweet
import com.pairdev.twittersearch.databinding.ItemTextTweetBinding

class TimelineAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    companion object {
        const val VIEW_TYPE_TEXT = 1
        const val VIEW_TYPE_MEDIA = 2
    }

    private var data: MutableList<Tweet> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            VIEW_TYPE_TEXT -> TextViewHolder.create(parent)
            VIEW_TYPE_MEDIA -> TextViewHolder.create(parent)
            else -> throw IllegalArgumentException("cannot find view type for this tweet")
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemViewType(position: Int): Int {
        val tweet: Tweet = data[position]

        if (tweet.text.isNotEmpty()) {
            return VIEW_TYPE_TEXT
        } else {
            return VIEW_TYPE_MEDIA
        }
    }

    fun setData(newData: List<Tweet>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
}

abstract class BaseViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: Tweet)
}

class TextViewHolder(val binding: ItemTextTweetBinding) : BaseViewHolder(binding) {

    companion object {
        fun create(parent: ViewGroup): TextViewHolder {
            val binding =
                ItemTextTweetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TextViewHolder(binding)
        }
    }

    override fun bind(item: Tweet) {
        binding.screenNameTextView.text = item.user.screenName
        binding.tweetTextView.text = item.text
    }
}

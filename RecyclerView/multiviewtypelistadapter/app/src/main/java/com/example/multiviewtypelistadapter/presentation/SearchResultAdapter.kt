package com.example.multiviewtypelistadapter.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.multiviewtypelistadapter.R
import com.example.multiviewtypelistadapter.databinding.ItemBookResultBinding
import com.example.multiviewtypelistadapter.databinding.ItemMoimResultBinding
import com.example.multiviewtypelistadapter.domain.entity.SearchItem


class SearchResultAdapter(private val type: Int) :
    ListAdapter<SearchItem, RecyclerView.ViewHolder>(DiffCallback) {

    class BookHolder(private val binding: ItemBookResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SearchItem.BookItem) {
            binding.book = item
        }
    }

    class MoimHolder(private val binding: ItemMoimResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SearchItem.MoimItem) {
            binding.moim = item
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<SearchItem>() {
        override fun areItemsTheSame(oldItem: SearchItem, newItem: SearchItem): Boolean {
            return when (oldItem) {
                is SearchItem.BookItem -> {
                    oldItem.isbn == (newItem as SearchItem.BookItem).isbn
                }
                is SearchItem.MoimItem -> {
                    oldItem.moimId == (newItem as SearchItem.MoimItem).moimId
                }
            }
        }

        override fun areContentsTheSame(
            oldItem: SearchItem,
            newItem: SearchItem
        ): Boolean {
            return when (oldItem) {
                is SearchItem.BookItem -> {
                    oldItem == (newItem as SearchItem.BookItem)
                }
                is SearchItem.MoimItem -> {
                    oldItem == (newItem as SearchItem.MoimItem)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("onCreateViewHolder", "$viewType")
        val inflater = LayoutInflater.from(parent.context)
        val moimBinding: ItemMoimResultBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_moim_result, parent, false)
        val bookBinding: ItemBookResultBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_book_result, parent, false)
        return when (viewType) {
            SearchItem.BookItem_TYPE -> {
                BookHolder(bookBinding)
            }
            SearchItem.MoimItem_TYPE -> {
                MoimHolder(moimBinding)
            }
            else -> {
                BookHolder(bookBinding)
            } // 알 수 없는 뷰 타입은 디폴트로 BookHolder 지정
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("onBindViewHolder", "$type")
        when (type) {
            SearchItem.BookItem_TYPE -> {
                (holder as BookHolder).bind(getItem(position) as SearchItem.BookItem)
            }
            SearchItem.MoimItem_TYPE -> {
                (holder as MoimHolder).bind(getItem(position) as SearchItem.MoimItem)
            }
            else -> {
                (holder as BookHolder).bind(getItem(position) as SearchItem.BookItem)
            } // 알 수 없는 뷰 타입(비정상 상황)은 디폴트로 BookHolder 지정

        }
    }

    override fun getItemViewType(position: Int): Int { // 사실상 의미 없을지도
        Log.d("getItemViewType", "$type")
        return when (type) {
            SearchItem.BookItem_TYPE -> 0
            SearchItem.MoimItem_TYPE -> 1
            else -> 0 // 알 수 없는 뷰 타입(비정상 상황)은 디폴트로 BookHolder 지정
        }
    }
}
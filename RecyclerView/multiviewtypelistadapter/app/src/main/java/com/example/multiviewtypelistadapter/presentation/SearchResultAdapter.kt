package com.example.multiviewtypelistadapter.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.multiviewtypelistadapter.R
import com.example.multiviewtypelistadapter.databinding.ItemBookResultBinding
import com.example.multiviewtypelistadapter.databinding.ItemMoimResultBinding
import com.example.multiviewtypelistadapter.domain.entity.SearchItem


class SearchResultAdapter(private val type: Int) :
    ListAdapter<SearchItem, RecyclerView.ViewHolder>(DIFF_CALLBACK()) {


    abstract class BaseViewHolder<T>(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        abstract fun bind(item: T)
    }

    class BookHolder(private val binding: ItemBookResultBinding) :
        BaseViewHolder<SearchItem.BookItem>(binding) {
        override fun bind(item: SearchItem.BookItem) {
            binding.book = item
        }

    }

    class MoimHolder(private val binding: ItemMoimResultBinding) :
        BaseViewHolder<SearchItem.MoimItem>(binding) {
        override fun bind(item: SearchItem.MoimItem) {
            binding.moim = item
        }


    }


    companion object {
        @JvmStatic
        fun DIFF_CALLBACK(): DiffUtil.ItemCallback<SearchItem> =
            object : DiffUtil.ItemCallback<SearchItem>() {
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
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val moimBinding: ItemMoimResultBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_moim_result, parent, false)
        val bookBinding: ItemBookResultBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_book_result, parent, false)
        Log.d("onCreateViewHolder", "$viewType")
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
//        val item = list[position]
        when (type) {
            SearchItem.BookItem_TYPE -> {
                (holder as BookHolder).bind(getItem(position) as SearchItem.BookItem)
//                (holder as BookHolder).bind(item as SearchItem.BookItem)
            }
            SearchItem.MoimItem_TYPE -> {
                (holder as MoimHolder).bind(getItem(position) as SearchItem.MoimItem)
//                (holder as MoimHolder).bind(item as SearchItem.MoimItem)
            }
            else -> {
//                (holder as BookHolder).bind(item as SearchItem.BookItem)
            } // 알 수 없는 뷰 타입은 디폴트로 BookHolder 지정

        }
    }

    override fun getItemViewType(position: Int): Int {
        Log.d("getItemViewType", "$position")
        return when (type) {
            SearchItem.BookItem_TYPE -> {
                (getItem(position) as SearchItem.BookItem).type
            }
            SearchItem.MoimItem_TYPE -> {
                (getItem(position) as SearchItem.MoimItem).type
            }
            else -> {
                (getItem(position) as SearchItem.BookItem).type
            } // 알 수 없는 뷰 타입은 디폴트로 BookHolder 지정

        }

    }

}
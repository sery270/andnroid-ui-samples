package com.example.multiviewtypelistadapter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.multiviewtypelistadapter.domain.entity.SearchItem
import com.example.multiviewtypelistadapter.domain.repository.SearchRepository
import kotlinx.coroutines.launch

class SearchViewModel constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {
    private val _bookList = MutableLiveData<List<SearchItem.BookItem>>()
    val bookList: LiveData<List<SearchItem.BookItem>>
        get() = _bookList
    private val _moimList = MutableLiveData<List<SearchItem.MoimItem>>()
    val moimList: LiveData<List<SearchItem.MoimItem>>
        get() = _moimList

    fun getBookList() {
        viewModelScope.launch {
            _bookList.value = searchRepository.getBookList()
        }
    }

    fun getMoimList() {
        viewModelScope.launch {
            _moimList.value = searchRepository.getMoimList()
        }
    }
}
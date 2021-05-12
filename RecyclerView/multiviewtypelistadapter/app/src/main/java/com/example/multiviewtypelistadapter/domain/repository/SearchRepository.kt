package com.example.multiviewtypelistadapter.domain.repository

import com.example.multiviewtypelistadapter.domain.entity.SearchItem

interface SearchRepository {
    suspend fun getBookList(): List<SearchItem.BookItem>
    suspend fun getMoimList(): List<SearchItem.MoimItem>
}
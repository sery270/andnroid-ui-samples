package com.example.multiviewtypelistadapter.data.repository

import com.example.multiviewtypelistadapter.data.datasource.SearchDataSource
import com.example.multiviewtypelistadapter.domain.entity.SearchItem
import com.example.multiviewtypelistadapter.domain.repository.SearchRepository

class SearchRepositoryImpl constructor(
    private val searchDataSource: SearchDataSource
) : SearchRepository {
    override suspend fun getBookList(): List<SearchItem.BookItem> {
        val bookList = searchDataSource.fetchBookList()
        return when (bookList.success) {
            true -> bookList.data.responseSearchBookList.map { it.toBookItem() }
            else -> throw IllegalArgumentException("JSON Parsing Error in getPopularBookList")
        }
    }

    override suspend fun getMoimList(): List<SearchItem.MoimItem> {
        val moimList = searchDataSource.fetchMoimList()
        return when (moimList.success) {
            true -> moimList.data.responseSearchMoimList.map { it.toMoimItem() }
            else -> throw IllegalArgumentException("JSON Parsing Error in getPopularBookList")
        }
    }
}
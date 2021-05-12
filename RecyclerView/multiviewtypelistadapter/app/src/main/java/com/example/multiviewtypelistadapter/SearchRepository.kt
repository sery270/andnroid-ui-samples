package com.example.multiviewtypelistadapter

interface SearchRepository {
    suspend fun getBookList(): List<SearchItem.BookItem>
    suspend fun getMoimList(): List<SearchItem.MoimItem>
}
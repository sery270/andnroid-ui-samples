package com.example.multiviewtypelistadapter.domain.entity

sealed class SearchItem {
    data class BookItem(
        val type: Int,
        val isbn: Int,
        val title: String,
        val author: String,
        val imageUrl: String
    ) : SearchItem()

    data class MoimItem(
        val type: Int,
        val isbn: Int,
        val title: String,
        val author: String,
        val imageUrl: String,
        val moimId: Int,
        val sentence: String,
        val moimHost: String
    ) : SearchItem()

    companion object {
        const val BookItem_TYPE = 0
        const val MoimItem_TYPE = 1
    }
}

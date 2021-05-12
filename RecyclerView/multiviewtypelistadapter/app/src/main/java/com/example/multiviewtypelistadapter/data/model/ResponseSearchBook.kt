package com.example.multiviewtypelistadapter.data.model

import com.example.multiviewtypelistadapter.domain.entity.SearchItem
import com.google.gson.annotations.SerializedName

data class WrapperResponseSearchBook(
    @SerializedName("SearchBookList")
    val responseSearchBookList: List<ResponseSearchBook>
)

data class ResponseSearchBook(
    @SerializedName("authors")
    val authors: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("isbn")
    val isbn: String,
    @SerializedName("thumbnail")
    val thumbnail: String
) {
    fun toBookItem(): SearchItem.BookItem {
        return SearchItem.BookItem(
            type = 0,
            author = authors,
            title = title,
            isbn = isbn,
            imageUrl = thumbnail
        )
    }
}
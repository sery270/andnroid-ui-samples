package com.example.multiviewtypelistadapter.data.model

import com.example.multiviewtypelistadapter.domain.entity.SearchBook
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
    fun toBook(): SearchBook {
        return SearchBook(
            author = authors,
            title = title,
            isbn = isbn,
            imageUrl = thumbnail
        )
    }
}
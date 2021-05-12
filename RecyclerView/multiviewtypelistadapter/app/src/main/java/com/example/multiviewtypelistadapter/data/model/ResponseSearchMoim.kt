package com.example.multiviewtypelistadapter.data.model

import com.example.multiviewtypelistadapter.domain.entity.SearchItem
import com.google.gson.annotations.SerializedName

data class WrapperResponseSearchMoim(
    @SerializedName("SearchMoimList")
    val responseSearchMoimList: List<ResponseSearchMoim>
)

data class ResponseSearchMoim(
    @SerializedName("roomIdx")
    val roomIdx: Int,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("info")
    val info: String,
    @SerializedName("nickName")
    val nickName: String

) {
    fun toMoimItem(): SearchItem.MoimItem {
        return SearchItem.MoimItem(
            type = 1, isbn = "isbn",
            title, author, thumbnail, moimId = roomIdx, sentence = "sentence", moimHost = "moimHost"
        )

    }
}
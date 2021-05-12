package com.example.multiviewtypelistadapter.data.model

import com.example.multiviewtypelistadapter.domain.entity.SearchMoim
import com.google.gson.annotations.SerializedName

data class WrapperResponseSearchMoim(
    @SerializedName("SearchMoimList")
    val responseSearchMoimList: List<ResponseSearchMoim>
)

data class ResponseSearchMoim(
    @SerializedName("roomIdx")
    val roomIdx: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("info")
    val info: String,
    @SerializedName("nickName")
    val nickName: String

) {
    fun toBook(): SearchMoim {
        return SearchMoim(
            roomIdx, imageUrl, title, author, info, nickName
        )
    }
}
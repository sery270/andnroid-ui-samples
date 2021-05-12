package com.example.multiviewtypelistadapter.data.datasource

import com.example.multiviewtypelistadapter.data.model.BaseResponse
import com.example.multiviewtypelistadapter.data.model.WrapperResponseSearchBook
import com.example.multiviewtypelistadapter.data.model.WrapperResponseSearchMoim

interface SearchDataSource {
    suspend fun fetchBookList(): BaseResponse<WrapperResponseSearchBook>
    suspend fun fetchMoimList(): BaseResponse<WrapperResponseSearchMoim>

}
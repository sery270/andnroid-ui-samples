package com.example.multiviewtypelistadapter.data.local

import android.content.Context
import com.example.multiviewtypelistadapter.base.objectFromJson
import com.example.multiviewtypelistadapter.data.datasource.SearchDataSource
import com.example.multiviewtypelistadapter.data.model.BaseResponse
import com.example.multiviewtypelistadapter.data.model.WrapperResponseSearchBook
import com.example.multiviewtypelistadapter.data.model.WrapperResponseSearchMoim
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalSearchDataSourceImpl constructor(
    private val context: Context
) : SearchDataSource {
    override suspend fun fetchBookList(): BaseResponse<WrapperResponseSearchBook> {
        return withContext(Dispatchers.IO) {
            objectFromJson(context, "book_list.json")
        }

    }

    override suspend fun fetchMoimList(): BaseResponse<WrapperResponseSearchMoim> {
        return withContext(Dispatchers.IO) {
            objectFromJson(context, "moim_list.json")
        }
    }

}
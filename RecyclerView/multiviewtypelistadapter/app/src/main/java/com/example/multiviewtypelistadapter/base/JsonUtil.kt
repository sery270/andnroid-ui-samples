package com.example.multiviewtypelistadapter.base

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

inline fun <reified T> objectFromJson(
    context: Context,
    fileName: String
): T {
    val jsonObject = runCatching {
        context.assets
            .open(fileName)
            .bufferedReader()
            .use { it.readText() }
    }
    return Gson().fromJson(jsonObject.getOrNull(), typeOf<T>())
}

fun <T> objectListFromJson(
    context: Context,
    fileName: String
): List<T> {
    val jsonListObject = runCatching {
        context.assets
            .open(fileName)
            .bufferedReader()
            .use { it.readText() }
    }
    return Gson().fromJson(jsonListObject.getOrNull(), typeOf<List<T>>())
}

inline fun <reified T> typeOf(): Type = object : TypeToken<T>() {}.type

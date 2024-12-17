package com.dicoding2.submissionandroidsederhana.model

import android.content.res.TypedArray
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val name: String,
    val description: String,
    val photo: Int,
    val path: String,
    val element: String,
    val nameRelic1: String,
    val imageRelic1: Int,
    val nameRelic2: String,
    val imageRelic2: Int,
    val nameRelic3: String,
    val imageRelic3: Int,
) : Parcelable


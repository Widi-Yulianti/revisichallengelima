package com.example.revchap5.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Movie(
    @SerializedName("id")
    val id : String ?,

    @SerializedName("title")
    val title : String?,

    @SerializedName("poster_path")
    val poster : String?,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("release_date")
    val release : String?

) : Parcelable, Serializable {
    constructor() : this("", "", "", "", "")
}
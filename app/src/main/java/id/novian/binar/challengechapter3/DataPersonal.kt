package id.novian.binar.challengechapter3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataPersonal(
    val age: Int,
    val address: String,
    val job: String
) : Parcelable

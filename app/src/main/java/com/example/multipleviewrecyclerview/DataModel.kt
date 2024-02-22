package com.example.multipleviewrecyclerview

import android.icu.text.CaseMap.Title
import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize

data class DataModel(var imgUrl : String, var theViewType: Int, var title: String, var description: String)

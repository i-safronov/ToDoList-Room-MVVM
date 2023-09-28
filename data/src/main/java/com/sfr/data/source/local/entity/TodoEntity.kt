package com.sfr.data.source.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = TodoEntity.TABLE_NAME)
data class TodoEntity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var title: String,
    var description: String,
    var checked: Boolean
) : Parcelable {

    companion object {
        const val TABLE_NAME = "TodoEntityTable"
    }

}
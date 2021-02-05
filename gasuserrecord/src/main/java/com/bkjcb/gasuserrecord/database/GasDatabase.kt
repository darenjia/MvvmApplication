package com.bkjcb.gasuserrecord.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bkjcb.gasuserrecord.model.GasRecord

/**
 * Created by DengShuai on 2021/2/3.
 * Description :
 */
@Database(entities = [GasRecord::class],version = 1)
abstract class GasDatabase: RoomDatabase() {

    abstract fun gasRecordDao(): GasRecordDao

    companion object {

        @Volatile private var INSTANCE: GasDatabase? = null

        fun getInstance(context: Context): GasDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                GasDatabase::class.java, "gas.db")
                .build()
    }
}
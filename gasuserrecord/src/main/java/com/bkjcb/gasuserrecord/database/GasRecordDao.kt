package com.bkjcb.gasuserrecord.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bkjcb.gasuserrecord.model.GasRecord


/**
 * Created by DengShuai on 2021/2/3.
 * Description :
 */
@Dao
interface GasRecordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(record: GasRecord)
    @Query("select * from gas_record where type=:type")
    fun query(type:Int):LiveData<List<GasRecord>>
    @Query("select * from gas_record where uid=:uid")
    fun queryById(uid:Int): LiveData<GasRecord>
}
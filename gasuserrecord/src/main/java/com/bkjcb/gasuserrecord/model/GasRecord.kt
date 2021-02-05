package com.bkjcb.gasuserrecord.model

import androidx.databinding.BaseObservable
import androidx.databinding.Observable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by DengShuai on 2020/4/30.
 * Description :
 */
@Entity(tableName = "gas_record")
data class GasRecord(
@PrimaryKey(autoGenerate = true)
var uid: Int,
var id:String?,
var anjianriqi: String?,
var qiyeanjianjilu: String?,
var ranqixieloubaojinqi: String?,
var xihuobaohu_geshu: String?,
var xihuobaohu: String?,
var zaojuleixing_gufeng: String?,
var zaojuleixing_dafeng: String?,
var lianjieguan: String?,
var tiaoyafa_geshu: String?,
var tiaoyafa: String?,
var qiandingriqi: String?,
var yongqihetong: String?,
var gongqiqiyeid: String?,
var gongqiqiye: String?,
var ranqiguanlizhidu: String?,
var faren: String?,
var yingyezhizhao: String?,
var dianhua: String?,
var dizhi: String?,
var fuzeren: String?,
var yonghuming: String?,
var jiandangriqi: String?,
var jiedao: String?,
var suoshuqu: String?,
var userId: String?,
var rqdizhi: String?,
var rqyonghuming: String?,
var rquserid: String?,
var location: String?,
var beizhu: String?,
var mbuid: String?,
var phoneftp: String?,
var year: String?,
var yihuyidangid: String?,
var type:Int = 0
):Serializable, BaseObservable()



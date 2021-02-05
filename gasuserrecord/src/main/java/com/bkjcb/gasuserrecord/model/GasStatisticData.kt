package com.bkjcb.gasuserrecord.model

import com.bkjcb.gasuserrecord.Flag
import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * Created by DengShuai on 2020/6/30.
 * Description :
 */
class GasStatisticData : MultiItemEntity {
    /**
     * name : 马桥镇
     * gs :
     * tiaoyafa_geshu :
     * tiaoyafa :
     * xihuobaohu :
     * childrens : null
     */
    var name: String? = null
    var gs: String? = null
    var tiaoyafa_geshu: String? = null
    var tiaoyafa: String? = null
    var xihuobaohu: String? = null
    var jrgs: String? = null
    var childrens: List<GasStatisticData>? = null
    override val itemType: Int
        get() =  if (childrens == null) Flag.STREET_TYPE else Flag.DISTRICT_TYPE

}
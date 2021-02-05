package com.bkjcb.gasuserrecord.model

import java.io.Serializable

/**
 * Created by DengShuai on 2020/5/6.
 * Description :
 */
class ReviewRecord : Serializable {
    var tiaoyaqi_zhenggai: String? = null
    var tiaoyaqi_zhenggairiqi: String? = null
    var lianjieguan_geshu: String? = null
    var lianjieguan_zhenggai: String? = null
    var lianjieguan_zhenggairiqi: String? = null
    var ranju_geshu: String? = null
    var ranju_zhenggai: String? = null
    var ranju_zhenggairiqi: String? = null
    var yehuaqi_shiyong: String? = null
    var tuihuriqi: String? = null
    var userId: String? = null
    var yihuyidangid: String? = null
    var jianchariqi: String? = null
    var jianchadanwei: String? = null
    var jianchadanweiid: String? = null
    var tiaoyaqi_geshu: String? = null
    var jianchajieguo: String? = null
    var phoneftp: String? = null
    var yonghuming: String? = null
    var beizhu: String? = null
    var status = 0

    constructor(status: Int) {
        this.status = status
    }
}
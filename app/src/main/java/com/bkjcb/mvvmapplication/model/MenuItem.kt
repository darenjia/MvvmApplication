package com.bkjcb.mvvmapplication.model

/**
 * Created by DengShuai on 2021/2/1.
 * Description :
 */
data class MenuItem(
    val text: String,
    val imgUrl: Int,
    val type: Int,
    var messageCount: Int = 0,
    var purview: Boolean = false
)

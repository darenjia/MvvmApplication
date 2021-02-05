package com.bkjcb.mvvmapplication.model

data class User(
    val area: Area? = null,
    val areaId: String? = null,
    val areacode: String? = null,
    val company: Company? = null,
    val contact_phone: String? = null,
    val danweileixing: String? = null,
    val email: String? = null,
    val is_use: Boolean? = null,
    val password: String? = null,
    val real_name: String? = null,
    val roles: List<String>? = null,
    val sc_id: String? = null,
    val userId: String? = null,
    val user_name: String? = null,
    val usercomp: String? = null,
    val userleixing: String? = null
)
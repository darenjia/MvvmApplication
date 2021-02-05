package com.bkjcb.base.utils

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.experimental.and

/**
 * Created by BKJCB on 2017/3/20.
 */
object MD5Util {
    fun encode(text: String): String {
        return try {
            val digest = MessageDigest.getInstance("md5")
            val result = digest.digest(text.toByteArray())
            val sb = StringBuilder()
            for (b in result) {
                val number: Int = b.toInt() and 0xff
                val hex = Integer.toHexString(number)
                if (hex.length == 1) {
                    sb.append("0$hex")
                } else {
                    sb.append(hex)
                }
            }
            sb.toString()
        } catch (e: NoSuchAlgorithmException) {
            ""
        }
    }
}
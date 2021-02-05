package com.bkjcb.base.utils

import android.text.TextUtils
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by DengShuai on 2021/2/2.
 * Description :
 */
object DateUtil {
    fun dateFormat(format: String?, date: Date): String {
        var formatString = format
        if (TextUtils.isEmpty(format)) {
            formatString = "yyyy-MM-dd"
        }
        return SimpleDateFormat(formatString!!, Locale.CHINESE).format(date)
    }

    fun dateFormat(s: String): String {
        if (TextUtils.isEmpty(s)) {
            return ""
        }
        val date = try {
            Date(s.toLong())
        } catch (e: NumberFormatException) {
            return s
        }
        return dateFormat("", date)
    }

    fun dateFormat(time: Long): String {
        if (time == 0L) {
            return ""
        }
        val date = try {
            Date(time)
        } catch (e: NumberFormatException) {
            //e.printStackTrace();
            return ""
        }
        return dateFormat("", date)
    }
    fun getCurrentTime(): String {
        return dateFormat(System.currentTimeMillis())
    }

    fun isSameDay(date1: Long, date2: Long): Boolean {
        val cal1 = Calendar.getInstance()
        cal1.timeInMillis = date1
        val cal2 = Calendar.getInstance()
        cal2.timeInMillis = date2
        return isSameDay(cal1, cal2)
    }

    fun isSameDay(cal1: Calendar?, cal2: Calendar?): Boolean {
        return if (cal1 != null && cal2 != null) {
            cal1[0] == cal2[0] && cal1[1] == cal2[1] && cal1[6] == cal2[6]
        } else {
            throw IllegalArgumentException("The date must not be null")
        }
    }
}
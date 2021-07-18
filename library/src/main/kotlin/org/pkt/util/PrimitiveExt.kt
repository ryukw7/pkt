package org.pkt.util

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

fun Double.format(digits: Int = 3): String = java.lang.String.format("%.${digits}f", this)

fun Long.toLocalDateTimeStr(): String =
    SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS").format(Date(this)).toString()

fun Long.toDecimalFormatStr(): String = DecimalFormat("###,###").format(this)
fun Int.toDecimalFormatStr(): String = this.toLong().toDecimalFormatStr()

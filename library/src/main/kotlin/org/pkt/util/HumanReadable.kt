package org.pkt.util

//
// https://stackoverflow.com/questions/3758606/how-to-convert-byte-size-into-human-readable-format-in-java?answertab=votes#tab-top
//
fun <T> T.toHumanReadableBytesStr(si: Boolean = true): String {

    val runtimeErrMsg = "Invalid numeric type. This function allow Int/Long/Byte/Short type only."
    if (!(this is Int || this is Long || this is Byte || this is Short)) {
        throw RuntimeException(runtimeErrMsg)
    }

    val thisDouble = when (this) {
        is Int -> toDouble()
        is Long -> toDouble()
        is Byte -> toDouble()
        is Short -> toDouble()
        else -> throw RuntimeException(runtimeErrMsg)
    }

    val unit = if (si) 1000 else 1024
    if (thisDouble < unit) return "$this B"
    val exp = (Math.log(thisDouble) / Math.log(unit.toDouble())).toInt()
    val pre = (if (si) "kMGTPE" else "KMGTPE")[exp - 1] + if (si) "" else "i"
    return String.format("%.1f %sB", thisDouble / Math.pow(unit.toDouble(), exp.toDouble()), pre)
}

fun <T> List<T>.toPrettyString(indent: Int = 2): String {
    val indentStr = " ".repeat(indent)
    return joinToString(",\n$indentStr", "[\n$indentStr", "\n]")
}

fun <T> Array<T>.toPrettyString(indent: Int = 2) = toList().toPrettyString(indent)

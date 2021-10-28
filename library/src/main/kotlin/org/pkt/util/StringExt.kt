package org.pkt.util

import java.security.MessageDigest
import java.util.regex.Matcher
import java.util.regex.Pattern

fun String.toSha256(): String {
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(this.toByteArray())
    return digest.fold("", { str, it -> str + "%02x".format(it) })
}

private fun Matcher.toMatchedStrs(): List<String> {
    val matchedStrs = mutableListOf<String>()
    while (find()) {
        matchedStrs.add(group())
    }

    return matchedStrs
}

fun String.extractNumbersInStr(): List<String> {
    // https://stackoverflow.com/questions/4703390/how-to-extract-a-floating-number-from-a-string?answertab=votes#tab-top
    val p = Pattern.compile("[-+]?\\d*\\.\\d+|\\d+")
    val m = p.matcher(this)
    return m.toMatchedStrs()
}

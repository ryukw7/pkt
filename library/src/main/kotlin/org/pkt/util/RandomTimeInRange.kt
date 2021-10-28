package org.pkt.util

fun randomTimeInRangeSec(start: Int, end: Int): Long {
    val s = start.seconds
    val e = end.seconds
    return ((s..e).shuffled().first())
}

fun randomTimeInRangeMin(start: Int, end: Int): Int {
    val s = start.minutes.toSeconds
    val e = end.minutes.toSeconds
    return ((s..e).shuffled().first())
}

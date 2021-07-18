package org.pkt.util

const val MILLIS_PER_SEC = 1_000L

val Int.days: Long get() = this * 24.hours
val Int.hours: Long get() = this * 60.minutes
val Int.minutes: Long get() = this * 60.seconds
val Int.seconds: Long get() = this * MILLIS_PER_SEC
val Int.milliseconds: Long get() = this.toLong()

val Long.toSeconds: Int get() = (this / MILLIS_PER_SEC).toInt()

val Long.toHumanReadableTime: String
    get() {
        if (this >= 1.days) return "${(this / 1.days.toDouble()).format(1)} days"
        if (this >= 1.hours) return "${(this / 1.hours.toDouble()).format(1)} hours"
        if (this >= 1.minutes) return "${(this / 1.minutes.toDouble()).format(1)} minutes"
        if (this >= 1.seconds) return "${(this / 1.seconds.toDouble()).format(1)} seconds"

        return "${(this / 1.seconds.toDouble()).format(3)} seconds"
    }

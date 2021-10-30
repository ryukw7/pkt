package org.pkt.util

import io.kotlintest.matchers.numerics.shouldBeGreaterThan
import io.kotlintest.matchers.shouldBeInRange
import org.junit.Test

class RandomTimeInRangeTest {
    @Test
    fun testRandomTimeInRangeSec() {
        repeat(1000) {
            val t = randomTimeInRangeSec(0, 10)
//            println(t)
            t shouldBeInRange LongRange(0, 10_000)
        }
    }

    @Test
    fun testRandomTimeInRangeMin() {
        // given
        val randomDelaySets = mutableSetOf<Int>()
        val repeatTimes = 100
        val expectedDelayMinRange = IntRange(30, 60)
        val expectedDelaySecRange = IntRange(
            expectedDelayMinRange.first.minutes.toSeconds,
            expectedDelayMinRange.last.minutes.toSeconds
        )

        // when
        repeat(repeatTimes) {
            val randomDelay = randomTimeInRangeMin(
                expectedDelayMinRange.first,
                expectedDelayMinRange.last
            )
            randomDelay shouldBeInRange expectedDelaySecRange
            randomDelaySets.add(randomDelay)
//            println(v)
        }

        // then
        println(randomDelaySets.count())
        randomDelaySets.count() shouldBeGreaterThan (repeatTimes - 10)
    }
}

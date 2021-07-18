package org.pkt.util

import io.kotlintest.shouldBe
import org.junit.Test

class DurationMillisKtTest {
    @Test
    fun toHumanReadableTime() {
        2_500L.toHumanReadableTime shouldBe "2.5 seconds"
        2_001L.toHumanReadableTime shouldBe "2.0 seconds"
        1_000L.toHumanReadableTime shouldBe "1.0 seconds"
        999L.toHumanReadableTime shouldBe "0.999 seconds"

        66_000L.toHumanReadableTime shouldBe "1.1 minutes"
        61_000L.toHumanReadableTime shouldBe "1.0 minutes"
        60_000L.toHumanReadableTime shouldBe "1.0 minutes"

        (1.hours + 10.minutes).toHumanReadableTime shouldBe "1.2 hours"
        (1.hours + 6.minutes).toHumanReadableTime shouldBe "1.1 hours"
        (1.hours).toHumanReadableTime shouldBe "1.0 hours"

        (1.days + 3.hours).toHumanReadableTime shouldBe "1.1 days"
        (1.days + 1.hours).toHumanReadableTime shouldBe "1.0 days"
        (1.days).toHumanReadableTime shouldBe "1.0 days"
    }
}

package org.pkt.util

import io.kotlintest.shouldBe
import org.junit.Test

class StringExtTest {
    @Test
    fun toSha256() {
        repeat(1_000) {
            "09:42:8c:ff:54:bf".toSha256() shouldBe "77ea726b2ff5fdc3013c7d0c21c5954acb1b2869b19142bee3b9810be04b269e"
        }
    }

    @Test
    fun extractNumbersStringList() {
        "Current Level: -13.2 db or 14.2 or 3".extractNumbersInStr() shouldBe
                listOf("-13.2", "14.2", "3")
    }
}

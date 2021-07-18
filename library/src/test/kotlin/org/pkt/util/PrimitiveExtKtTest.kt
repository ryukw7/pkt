package org.pkt.util

import io.kotlintest.shouldBe
import org.junit.Test

class PrimitiveExtKtTest {
    @Test
    fun Double_format() {
        mapOf(
            0.1 to "0.100",
            0.11 to "0.110",
            0.111 to "0.111",
            0.1111 to "0.111",
            0.6 to "0.600",
            0.66 to "0.660",
            0.666 to "0.666",
            0.6666 to "0.667"
        ).forEach { (v, formattedStr) ->
            v.format() shouldBe formattedStr
        }

        mapOf(
            0.1 to "0.10000",
            0.11 to "0.11000",
            0.111 to "0.11100",
            0.1111 to "0.11110",
            0.11111 to "0.11111"
        ).forEach { (v, formattedStr) ->
            v.format(5) shouldBe formattedStr
        }
    }

    @Test
    fun Long_toDateTimeStr() {
        mapOf(
            1_546_300_800_000L to "2019-01-01_09:00:00.000",
            1_546_300_800_001L to "2019-01-01_09:00:00.001"
        ).forEach { (unixEpochTimeMs, expectedDateTimeStr) ->
            unixEpochTimeMs.toLocalDateTimeStr() shouldBe expectedDateTimeStr
        }
    }

    @Test
    fun Long_toDecimalFormatStr() {
        mapOf(
            0L to "0",
            1L to "1",
            12L to "12",
            123L to "123",
            1_234L to "1,234",
            1_234_567L to "1,234,567",
            1_234_567_890L to "1,234,567,890"
        ).forEach { (v, expectedStr) ->
            v.toDecimalFormatStr() shouldBe expectedStr
        }
    }
}

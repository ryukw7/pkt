package org.pkt.util

import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import org.junit.Ignore
import org.junit.Test

class HumanReadableKtTest {
    @Test
    fun `toHumanReadableBytesStr - valid input`() {
        mapOf(
            // @formatter:off
            /* ktlint-disable no-multi-spaces */
            0                           to Pair("0 B", "0 B"),
            27                          to Pair("27 B", "27 B"),
            999                         to Pair("999 B", "999 B"),
            1_000                       to Pair("1.0 kB", "1000 B"),
            1_023                       to Pair("1.0 kB", "1023 B"),
            1_024                       to Pair("1.0 kB", "1.0 KiB"),
            1_728                       to Pair("1.7 kB", "1.7 KiB"),
            110_592                     to Pair("110.6 kB", "108.0 KiB"),
            7_077_888                   to Pair("7.1 MB", "6.8 MiB"),
            452_984_832                 to Pair("453.0 MB", "432.0 MiB"),
            28_991_029_248              to Pair("29.0 GB", "27.0 GiB"),
            1_855_425_871_872           to Pair("1.9 TB", "1.7 TiB"),
            9_223_372_036_854_775_807   to Pair("9.2 EB", "8.0 EiB") // Long.MAX_VALUE
            /* ktlint-enable no-multi-spaces */
            // @formatter:on
        ).forEach { (inputNum, str) ->
            inputNum.toHumanReadableBytesStr() shouldBe str.first
            inputNum.toHumanReadableBytesStr(false) shouldBe str.second
        }
    }

    @Ignore
    @Test
    fun `toHumanReadableBytesStr - invalid type call`() {
        arrayOf(
            "abc", // String,
            1.000 // double
        ).forEach {
            shouldThrow<RuntimeException> { it.toHumanReadableBytesStr() }
            shouldThrow<RuntimeException> { it.toHumanReadableBytesStr(false) }
        }
    }

    @Test
    fun toPrettyString() {
        arrayOf(1, 2, 3).toPrettyString() shouldBe """
        [
          1,
          2,
          3
        ]
        """.trimIndent()
    }

    @Test
    fun toPrettyString__indent_4() {
        arrayOf(1, 2, 3).toPrettyString(4) shouldBe """
        [
            1,
            2,
            3
        ]
        """.trimIndent()
    }
}

package org.pkt.util

import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import org.junit.Ignore
import org.junit.Test

class EvictingQueueTest {

    @Test
    fun add() {
        val q = EvictingQueue<Int>(3)
        q.size shouldBe 0
        q.add(1)
        q.size shouldBe 1
        q.add(2)
        q.size shouldBe 2
        q.add(3)
        q.size shouldBe 3
        "$q" shouldBe "[1, 2, 3]"

        q.add(4)
        q.size shouldBe 3
        "$q" shouldBe "[2, 3, 4]"
    }

    @Test
    fun offer() {
        val q = EvictingQueue<Int>(3)
        q.size shouldBe 0
        q.offer(1)
        q.size shouldBe 1
        q.offer(2)
        q.size shouldBe 2
        q.offer(3)
        q.size shouldBe 3
        "$q" shouldBe "[1, 2, 3]"

        q.offer(4)
        q.size shouldBe 3
        "$q" shouldBe "[2, 3, 4]"
    }

    @Test
    fun put() {
        val q = EvictingQueue<Int>(3)
        q.size shouldBe 0
        q.put(1)
        q.size shouldBe 1
        q.put(2)
        q.size shouldBe 2
        q.put(3)
        q.size shouldBe 3
        "$q" shouldBe "[1, 2, 3]"

        q.put(4)
        q.size shouldBe 3
        "$q" shouldBe "[2, 3, 4]"
    }

    @Test
    fun clear() {
        val q = EvictingQueue<Int>(3)
        q.add(1)
        q.add(2)
        q.add(3)
        q.size shouldBe 3
        q.clear()
        q.size shouldBe 0
    }

    @Ignore
    @Test
    fun waitForEnqueue() {
        val q = EvictingQueue<Int>(3)
        shouldThrow<IllegalStateException> { q.waitForEnqueue() }
        q.add(1)
        val v = q.waitForEnqueue()
        v shouldBe 1
    }

    @Test
    fun remainingCapacity() {
        val q = EvictingQueue<Int>(3)
        q.remainingCapacity() shouldBe 3

        q.add(1)
        q.remainingCapacity() shouldBe 2
        q.add(2)
        q.remainingCapacity() shouldBe 1
        q.add(3)
        q.remainingCapacity() shouldBe 0
    }

    @Test
    fun contains() {
        val q = EvictingQueue<Int>(3)
        q.add(1)
        q.add(2)
        q.add(3)

        q.contains(1) shouldBe true
        q.contains(2) shouldBe true
        q.contains(3) shouldBe true
        (1 in q) shouldBe true
        (2 in q) shouldBe true
        (3 in q) shouldBe true

        q.contains(4) shouldBe false
        (4 in q) shouldBe false
        (4 !in q) shouldBe true
    }
}

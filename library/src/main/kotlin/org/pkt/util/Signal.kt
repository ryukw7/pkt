package org.pkt.util

import org.pkt.util.Signal.Companion.DEFAULT_WAIT_TIME
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

fun wait(signal: Signal, time: Long = DEFAULT_WAIT_TIME) = signal.await(time)

class Signal {
    private val lock = ReentrantLock()
    private val condition = lock.newCondition()

    fun emit() = lock.withLock { condition.signalAll() }
    internal fun await(time: Long) = lock.withLock { condition.await(time, TimeUnit.MILLISECONDS) }

    companion object {
        val DEFAULT_WAIT_TIME = 1.seconds
    }
}

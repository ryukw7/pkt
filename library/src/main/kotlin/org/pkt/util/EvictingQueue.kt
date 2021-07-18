package org.pkt.util

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit

open class EvictingQueue<E>(maxSize: Int) : LinkedBlockingQueue<E>(maxSize) {

    @Synchronized
    override fun add(element: E): Boolean {
        if (remainingCapacity() == 0) poll()

        return super.offer(element)
    }

    override fun offer(e: E): Boolean = add(e)
    override fun put(e: E) { add(e) }

    fun waitForEnqueue(timeout: Long = 500L) = poll(timeout, TimeUnit.MILLISECONDS)
        ?: throw IllegalStateException("no message arrived in $timeout ms!")
}

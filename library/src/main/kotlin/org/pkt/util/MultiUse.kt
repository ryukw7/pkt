package org.pkt.util

import java.io.Closeable

// https://medium.com/@appmattus/effective-kotlin-item-9-prefer-try-with-resources-to-try-finally-aec8c202c30a
inline fun <T : Closeable?> Array<T>.use(block: () -> Unit) {
    var exception: Throwable? = null
    try {
        return block()
    } catch (e: Throwable) {
        exception = e
        throw e
    } finally {
        when (exception) {
            null -> forEach { it?.close() }
            else -> forEach {
                try {
                    it?.close()
                } catch (closeException: Throwable) {
                    exception.addSuppressed(closeException)
                }
            }
        }
    }
}

// Import the necessary Java synchronization and scheduling classes.

package edu.vuum.mocca;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

/**
 * @class SimpleAtomicLong
 *
 * @brief This class implements a subset of the
 *        java.util.concurrent.atomic.SimpleAtomicLong class using a
 *        ReentrantReadWriteLock to illustrate how they work.
 */
class SimpleAtomicLong
{
    /**
     * The value that's manipulated atomically via the methods.
     */
    private long mValue;


    /**
     * The ReentrantReadWriteLock used to serialize access to mValue.
     */
    // TODO - add the implementation
    private ReentrantReadWriteLock mLock;

    /**
     * Creates a new SimpleAtomicLong with the given initial value.
     */
    public SimpleAtomicLong(long initialValue) {
        // TODO - you fill in here
        this.mValue = initialValue;
        this.mLock = new ReentrantReadWriteLock();
    }

    /**
     * @brief Gets the current value
     * 
     * @returns The current value
     */
    public long get() {
        // TODO - you fill in here
        long value = 0;
        final Lock read = mLock.readLock();

        read.lock();
        try{
            value = this.mValue;
        }finally {
            read.lock();
        }

        return value;
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the updated value
     */
    public long decrementAndGet() {
        // TODO - you fill in here
        long value = 0;
        final Lock write = mLock.writeLock();

        write.lock();
        try{
            value = --this.mValue;
        }finally {
            write.lock();
        }

        return value;
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the previous value
     */
    public long getAndIncrement() {
        // TODO - you fill in here
        long value = 0;
        final Lock write = mLock.writeLock();

        write.lock();
        try{
            value = this.mValue++;
        }finally {
            write.lock();
        }

        return value;
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the previous value
     */
    public long getAndDecrement() {
        // TODO - you fill in here
        long value = 0;
        final Lock write = mLock.writeLock();

        write.lock();
        try{
            value = this.mValue--;
        }finally {
            write.lock();
        }

        return value;
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the updated value
     */
    public long incrementAndGet() {
        // TODO - you fill in here
        long value = 0;
        final Lock write = mLock.writeLock();

        write.lock();
        try{
            value = ++this.mValue;
        }finally {
            write.lock();
        }

        return value;
    }
}


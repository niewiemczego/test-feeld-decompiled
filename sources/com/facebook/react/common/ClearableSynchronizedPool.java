package com.facebook.react.common;

import androidx.core.util.Pools;

public class ClearableSynchronizedPool<T> implements Pools.Pool<T> {
    private final Object[] mPool;
    private int mSize = 0;

    public ClearableSynchronizedPool(int i) {
        this.mPool = new Object[i];
    }

    public synchronized T acquire() {
        int i = this.mSize;
        if (i == 0) {
            return null;
        }
        int i2 = i - 1;
        this.mSize = i2;
        T[] tArr = this.mPool;
        T t = tArr[i2];
        tArr[i2] = null;
        return t;
    }

    public synchronized boolean release(T t) {
        int i = this.mSize;
        Object[] objArr = this.mPool;
        if (i == objArr.length) {
            return false;
        }
        objArr[i] = t;
        this.mSize = i + 1;
        return true;
    }

    public synchronized void clear() {
        for (int i = 0; i < this.mSize; i++) {
            this.mPool[i] = null;
        }
        this.mSize = 0;
    }
}

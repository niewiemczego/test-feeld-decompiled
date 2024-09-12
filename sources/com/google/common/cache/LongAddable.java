package com.google.common.cache;

@ElementTypesAreNonnullByDefault
interface LongAddable {
    void add(long j);

    void increment();

    long sum();
}

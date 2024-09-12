package com.google.common.hash;

@ElementTypesAreNonnullByDefault
interface LongAddable {
    void add(long j);

    void increment();

    long sum();
}

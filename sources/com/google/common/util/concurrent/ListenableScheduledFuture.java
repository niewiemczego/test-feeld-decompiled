package com.google.common.util.concurrent;

import java.util.concurrent.ScheduledFuture;

@ElementTypesAreNonnullByDefault
public interface ListenableScheduledFuture<V> extends ScheduledFuture<V>, ListenableFuture<V> {
}

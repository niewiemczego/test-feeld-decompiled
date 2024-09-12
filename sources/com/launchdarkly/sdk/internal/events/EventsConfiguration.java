package com.launchdarkly.sdk.internal.events;

import com.launchdarkly.sdk.AttributeRef;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class EventsConfiguration {
    public static final int DEFAULT_EVENT_SENDING_THREAD_POOL_SIZE = 5;
    final boolean allAttributesPrivate;
    final int capacity;
    final EventContextDeduplicator contextDeduplicator;
    final long diagnosticRecordingIntervalMillis;
    final DiagnosticStore diagnosticStore;
    final EventSender eventSender;
    final int eventSendingThreadPoolSize;
    final URI eventsUri;
    final long flushIntervalMillis;
    final boolean initiallyInBackground;
    final boolean initiallyOffline;
    final List<AttributeRef> privateAttributes;

    public EventsConfiguration(boolean z, int i, EventContextDeduplicator eventContextDeduplicator, long j, DiagnosticStore diagnosticStore2, EventSender eventSender2, int i2, URI uri, long j2, boolean z2, boolean z3, Collection<AttributeRef> collection) {
        this.allAttributesPrivate = z;
        this.capacity = i < 0 ? 1 : i;
        this.contextDeduplicator = eventContextDeduplicator;
        this.diagnosticRecordingIntervalMillis = j;
        this.diagnosticStore = diagnosticStore2;
        this.eventSender = eventSender2;
        this.eventSendingThreadPoolSize = i2 < 0 ? 5 : i2;
        this.eventsUri = uri;
        this.flushIntervalMillis = j2;
        this.initiallyInBackground = z2;
        this.initiallyOffline = z3;
        this.privateAttributes = collection == null ? Collections.emptyList() : new ArrayList<>(collection);
    }
}

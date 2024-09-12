package io.sentry;

import io.sentry.exception.SentryEnvelopeException;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import io.sentry.util.Objects;
import java.io.IOException;
import java.util.ArrayList;

public final class SentryEnvelope {
    private final SentryEnvelopeHeader header;
    private final Iterable<SentryEnvelopeItem> items;

    public Iterable<SentryEnvelopeItem> getItems() {
        return this.items;
    }

    public SentryEnvelopeHeader getHeader() {
        return this.header;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Iterable<io.sentry.SentryEnvelopeItem>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SentryEnvelope(io.sentry.SentryEnvelopeHeader r2, java.lang.Iterable<io.sentry.SentryEnvelopeItem> r3) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "SentryEnvelopeHeader is required."
            java.lang.Object r2 = io.sentry.util.Objects.requireNonNull(r2, r0)
            io.sentry.SentryEnvelopeHeader r2 = (io.sentry.SentryEnvelopeHeader) r2
            r1.header = r2
            java.lang.String r2 = "SentryEnvelope items are required."
            java.lang.Object r2 = io.sentry.util.Objects.requireNonNull(r3, r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r1.items = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryEnvelope.<init>(io.sentry.SentryEnvelopeHeader, java.lang.Iterable):void");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Iterable<io.sentry.SentryEnvelopeItem>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SentryEnvelope(io.sentry.protocol.SentryId r2, io.sentry.protocol.SdkVersion r3, java.lang.Iterable<io.sentry.SentryEnvelopeItem> r4) {
        /*
            r1 = this;
            r1.<init>()
            io.sentry.SentryEnvelopeHeader r0 = new io.sentry.SentryEnvelopeHeader
            r0.<init>(r2, r3)
            r1.header = r0
            java.lang.String r2 = "SentryEnvelope items are required."
            java.lang.Object r2 = io.sentry.util.Objects.requireNonNull(r4, r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r1.items = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryEnvelope.<init>(io.sentry.protocol.SentryId, io.sentry.protocol.SdkVersion, java.lang.Iterable):void");
    }

    public SentryEnvelope(SentryId sentryId, SdkVersion sdkVersion, SentryEnvelopeItem sentryEnvelopeItem) {
        Objects.requireNonNull(sentryEnvelopeItem, "SentryEnvelopeItem is required.");
        this.header = new SentryEnvelopeHeader(sentryId, sdkVersion);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(sentryEnvelopeItem);
        this.items = arrayList;
    }

    public static SentryEnvelope from(ISerializer iSerializer, Session session, SdkVersion sdkVersion) throws IOException {
        Objects.requireNonNull(iSerializer, "Serializer is required.");
        Objects.requireNonNull(session, "session is required.");
        return new SentryEnvelope((SentryId) null, sdkVersion, SentryEnvelopeItem.fromSession(iSerializer, session));
    }

    public static SentryEnvelope from(ISerializer iSerializer, SentryBaseEvent sentryBaseEvent, SdkVersion sdkVersion) throws IOException {
        Objects.requireNonNull(iSerializer, "Serializer is required.");
        Objects.requireNonNull(sentryBaseEvent, "item is required.");
        return new SentryEnvelope(sentryBaseEvent.getEventId(), sdkVersion, SentryEnvelopeItem.fromEvent(iSerializer, sentryBaseEvent));
    }

    public static SentryEnvelope from(ISerializer iSerializer, ProfilingTraceData profilingTraceData, long j, SdkVersion sdkVersion) throws SentryEnvelopeException {
        Objects.requireNonNull(iSerializer, "Serializer is required.");
        Objects.requireNonNull(profilingTraceData, "Profiling trace data is required.");
        return new SentryEnvelope(new SentryId(profilingTraceData.getProfileId()), sdkVersion, SentryEnvelopeItem.fromProfilingTrace(profilingTraceData, j, iSerializer));
    }
}

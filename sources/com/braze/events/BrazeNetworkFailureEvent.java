package com.braze.events;

import bo.app.a2;
import bo.app.b0;
import bo.app.h0;
import bo.app.y3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0001#B\u001b\u0012\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\"J\r\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÂ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÂ\u0003J!\u0010\t\u001a\u00020\u00002\f\b\u0002\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0018\u0010\u0007\u001a\u00060\u0002j\u0002`\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/braze/events/BrazeNetworkFailureEvent;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "component1", "Lbo/app/a2;", "component2", "originalException", "brazeRequest", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/Exception;", "Lbo/app/a2;", "networkExceptionMessage", "Ljava/lang/String;", "getNetworkExceptionMessage", "()Ljava/lang/String;", "", "requestInitiationTime", "Ljava/lang/Long;", "getRequestInitiationTime", "()Ljava/lang/Long;", "Lcom/braze/events/BrazeNetworkFailureEvent$RequestType;", "requestType", "Lcom/braze/events/BrazeNetworkFailureEvent$RequestType;", "getRequestType", "()Lcom/braze/events/BrazeNetworkFailureEvent$RequestType;", "<init>", "(Ljava/lang/Exception;Lbo/app/a2;)V", "RequestType", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public final class BrazeNetworkFailureEvent {
    private final a2 brazeRequest;
    private final String networkExceptionMessage;
    private final Exception originalException;
    private final Long requestInitiationTime;
    private final RequestType requestType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/braze/events/BrazeNetworkFailureEvent$RequestType;", "", "(Ljava/lang/String;I)V", "CONTENT_CARDS_SYNC", "NEWS_FEED_SYNC", "OTHER", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum RequestType {
        CONTENT_CARDS_SYNC,
        NEWS_FEED_SYNC,
        OTHER
    }

    public BrazeNetworkFailureEvent(Exception exc, a2 a2Var) {
        RequestType requestType2;
        Intrinsics.checkNotNullParameter(exc, "originalException");
        Intrinsics.checkNotNullParameter(a2Var, "brazeRequest");
        this.originalException = exc;
        this.brazeRequest = a2Var;
        this.networkExceptionMessage = exc.getMessage();
        this.requestInitiationTime = a2Var.k();
        if (a2Var instanceof b0) {
            requestType2 = RequestType.CONTENT_CARDS_SYNC;
        } else if (a2Var instanceof h0) {
            y3 f = a2Var.f();
            boolean z = true;
            if ((f == null || !f.w()) ? false : z) {
                requestType2 = RequestType.NEWS_FEED_SYNC;
            } else {
                requestType2 = RequestType.OTHER;
            }
        } else {
            requestType2 = RequestType.OTHER;
        }
        this.requestType = requestType2;
    }

    private final Exception component1() {
        return this.originalException;
    }

    private final a2 component2() {
        return this.brazeRequest;
    }

    public static /* synthetic */ BrazeNetworkFailureEvent copy$default(BrazeNetworkFailureEvent brazeNetworkFailureEvent, Exception exc, a2 a2Var, int i, Object obj) {
        if ((i & 1) != 0) {
            exc = brazeNetworkFailureEvent.originalException;
        }
        if ((i & 2) != 0) {
            a2Var = brazeNetworkFailureEvent.brazeRequest;
        }
        return brazeNetworkFailureEvent.copy(exc, a2Var);
    }

    public final BrazeNetworkFailureEvent copy(Exception exc, a2 a2Var) {
        Intrinsics.checkNotNullParameter(exc, "originalException");
        Intrinsics.checkNotNullParameter(a2Var, "brazeRequest");
        return new BrazeNetworkFailureEvent(exc, a2Var);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrazeNetworkFailureEvent)) {
            return false;
        }
        BrazeNetworkFailureEvent brazeNetworkFailureEvent = (BrazeNetworkFailureEvent) obj;
        return Intrinsics.areEqual((Object) this.originalException, (Object) brazeNetworkFailureEvent.originalException) && Intrinsics.areEqual((Object) this.brazeRequest, (Object) brazeNetworkFailureEvent.brazeRequest);
    }

    public final String getNetworkExceptionMessage() {
        return this.networkExceptionMessage;
    }

    public final Long getRequestInitiationTime() {
        return this.requestInitiationTime;
    }

    public final RequestType getRequestType() {
        return this.requestType;
    }

    public int hashCode() {
        return (this.originalException.hashCode() * 31) + this.brazeRequest.hashCode();
    }

    public String toString() {
        return "BrazeNetworkFailureEvent(originalException=" + this.originalException + ", brazeRequest=" + this.brazeRequest + ')';
    }
}

package com.braze.events;

import bo.app.e5;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002HÂ\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000fR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/braze/events/BrazeSdkAuthenticationErrorEvent;", "", "Lbo/app/e5;", "component1", "", "toString", "sdkAuthError", "copy", "", "hashCode", "other", "", "equals", "Lbo/app/e5;", "getErrorReason", "()Ljava/lang/String;", "errorReason", "getErrorCode", "()I", "errorCode", "", "getRequestInitiationTime", "()Ljava/lang/Long;", "requestInitiationTime", "getSignature", "signature", "getUserId", "userId", "<init>", "(Lbo/app/e5;)V", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public final class BrazeSdkAuthenticationErrorEvent {
    private final e5 sdkAuthError;

    public BrazeSdkAuthenticationErrorEvent(e5 e5Var) {
        Intrinsics.checkNotNullParameter(e5Var, "sdkAuthError");
        this.sdkAuthError = e5Var;
    }

    private final e5 component1() {
        return this.sdkAuthError;
    }

    public static /* synthetic */ BrazeSdkAuthenticationErrorEvent copy$default(BrazeSdkAuthenticationErrorEvent brazeSdkAuthenticationErrorEvent, e5 e5Var, int i, Object obj) {
        if ((i & 1) != 0) {
            e5Var = brazeSdkAuthenticationErrorEvent.sdkAuthError;
        }
        return brazeSdkAuthenticationErrorEvent.copy(e5Var);
    }

    public final BrazeSdkAuthenticationErrorEvent copy(e5 e5Var) {
        Intrinsics.checkNotNullParameter(e5Var, "sdkAuthError");
        return new BrazeSdkAuthenticationErrorEvent(e5Var);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BrazeSdkAuthenticationErrorEvent) && Intrinsics.areEqual((Object) this.sdkAuthError, (Object) ((BrazeSdkAuthenticationErrorEvent) obj).sdkAuthError);
    }

    public final int getErrorCode() {
        return this.sdkAuthError.c();
    }

    public final String getErrorReason() {
        return this.sdkAuthError.d();
    }

    public final Long getRequestInitiationTime() {
        return this.sdkAuthError.b().k();
    }

    public final String getSignature() {
        return this.sdkAuthError.b().l();
    }

    public final String getUserId() {
        return this.sdkAuthError.b().a();
    }

    public int hashCode() {
        return this.sdkAuthError.hashCode();
    }

    public String toString() {
        return this.sdkAuthError.toString();
    }
}

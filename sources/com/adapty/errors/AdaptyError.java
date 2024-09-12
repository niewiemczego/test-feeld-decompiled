package com.adapty.errors;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0013B'\b\u0000\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/adapty/errors/AdaptyError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "originalError", "", "message", "", "adaptyErrorCode", "Lcom/adapty/errors/AdaptyErrorCode;", "(Ljava/lang/Throwable;Ljava/lang/String;Lcom/adapty/errors/AdaptyErrorCode;)V", "getAdaptyErrorCode", "()Lcom/adapty/errors/AdaptyErrorCode;", "getOriginalError", "()Ljava/lang/Throwable;", "getRetryType", "Lcom/adapty/errors/AdaptyError$RetryType;", "isInfinite", "", "getRetryType$adapty_release", "RetryType", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyError.kt */
public final class AdaptyError extends Exception {
    private final AdaptyErrorCode adaptyErrorCode;
    private final Throwable originalError;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/adapty/errors/AdaptyError$RetryType;", "", "(Ljava/lang/String;I)V", "SIMPLE", "PROGRESSIVE", "NONE", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyError.kt */
    public enum RetryType {
        SIMPLE,
        PROGRESSIVE,
        NONE
    }

    public AdaptyError() {
        this((Throwable) null, (String) null, (AdaptyErrorCode) null, 7, (DefaultConstructorMarker) null);
    }

    public final Throwable getOriginalError() {
        return this.originalError;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdaptyError(Throwable th, String str, AdaptyErrorCode adaptyErrorCode2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : th, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? AdaptyErrorCode.UNKNOWN : adaptyErrorCode2);
    }

    public final AdaptyErrorCode getAdaptyErrorCode() {
        return this.adaptyErrorCode;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdaptyError(Throwable th, String str, AdaptyErrorCode adaptyErrorCode2) {
        super(str, th);
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(adaptyErrorCode2, "adaptyErrorCode");
        this.originalError = th;
        this.adaptyErrorCode = adaptyErrorCode2;
    }

    public final /* synthetic */ RetryType getRetryType$adapty_release(boolean z) {
        if (this.adaptyErrorCode == AdaptyErrorCode.SERVER_ERROR) {
            return z ? RetryType.PROGRESSIVE : RetryType.SIMPLE;
        }
        if (this.originalError instanceof IOException) {
            return RetryType.SIMPLE;
        }
        return RetryType.NONE;
    }
}

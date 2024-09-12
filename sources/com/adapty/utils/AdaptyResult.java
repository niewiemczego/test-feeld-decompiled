package com.adapty.utils;

import com.adapty.errors.AdaptyError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/adapty/utils/AdaptyResult;", "T", "", "()V", "Error", "Success", "Lcom/adapty/utils/AdaptyResult$Error;", "Lcom/adapty/utils/AdaptyResult$Success;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyResult.kt */
public abstract class AdaptyResult<T> {
    public /* synthetic */ AdaptyResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/adapty/utils/AdaptyResult$Success;", "T", "Lcom/adapty/utils/AdaptyResult;", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyResult.kt */
    public static final class Success<T> extends AdaptyResult<T> {
        private final T value;

        public Success(T t) {
            super((DefaultConstructorMarker) null);
            this.value = t;
        }

        public final T getValue() {
            return this.value;
        }
    }

    private AdaptyResult() {
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/adapty/utils/AdaptyResult$Error;", "Lcom/adapty/utils/AdaptyResult;", "", "error", "Lcom/adapty/errors/AdaptyError;", "(Lcom/adapty/errors/AdaptyError;)V", "getError", "()Lcom/adapty/errors/AdaptyError;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyResult.kt */
    public static final class Error extends AdaptyResult {
        private final AdaptyError error;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(AdaptyError adaptyError) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(adaptyError, "error");
            this.error = adaptyError;
        }

        public final AdaptyError getError() {
            return this.error;
        }
    }
}

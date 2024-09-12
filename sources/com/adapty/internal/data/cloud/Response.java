package com.adapty.internal.data.cloud;

import com.adapty.errors.AdaptyError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/adapty/internal/data/cloud/Response;", "R", "", "()V", "Error", "Success", "Lcom/adapty/internal/data/cloud/Response$Error;", "Lcom/adapty/internal/data/cloud/Response$Success;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Response.kt */
public abstract class Response<R> {
    public /* synthetic */ Response(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Response() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/adapty/internal/data/cloud/Response$Success;", "T", "Lcom/adapty/internal/data/cloud/Response;", "body", "(Ljava/lang/Object;)V", "getBody", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/adapty/internal/data/cloud/Response$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Response.kt */
    public static final class Success<T> extends Response<T> {
        private final T body;

        public static /* synthetic */ Success copy$default(Success success, T t, int i, Object obj) {
            if ((i & 1) != 0) {
                t = success.body;
            }
            return success.copy(t);
        }

        public final T component1() {
            return this.body;
        }

        public final Success<T> copy(T t) {
            return new Success<>(t);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual((Object) this.body, (Object) ((Success) obj).body);
        }

        public int hashCode() {
            T t = this.body;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        public String toString() {
            return "Success(body=" + this.body + ')';
        }

        public Success(T t) {
            super((DefaultConstructorMarker) null);
            this.body = t;
        }

        public final T getBody() {
            return this.body;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/adapty/internal/data/cloud/Response$Error;", "Lcom/adapty/internal/data/cloud/Response;", "", "error", "Lcom/adapty/errors/AdaptyError;", "(Lcom/adapty/errors/AdaptyError;)V", "getError", "()Lcom/adapty/errors/AdaptyError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Response.kt */
    public static final class Error extends Response {
        private final AdaptyError error;

        public static /* synthetic */ Error copy$default(Error error2, AdaptyError adaptyError, int i, Object obj) {
            if ((i & 1) != 0) {
                adaptyError = error2.error;
            }
            return error2.copy(adaptyError);
        }

        public final AdaptyError component1() {
            return this.error;
        }

        public final Error copy(AdaptyError adaptyError) {
            Intrinsics.checkNotNullParameter(adaptyError, "error");
            return new Error(adaptyError);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual((Object) this.error, (Object) ((Error) obj).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ')';
        }

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

package com.adapty.react;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/adapty/react/AdaptyBridgeResult;", "T", "", "data", "type", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/String;)Lcom/adapty/react/AdaptyBridgeResult;", "equals", "", "other", "hashCode", "", "toString", "react-native-adapty_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdaptyContext.kt */
public final class AdaptyBridgeResult<T> {
    private final T data;
    private final String type;

    public static /* synthetic */ AdaptyBridgeResult copy$default(AdaptyBridgeResult adaptyBridgeResult, T t, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            t = adaptyBridgeResult.data;
        }
        if ((i & 2) != 0) {
            str = adaptyBridgeResult.type;
        }
        return adaptyBridgeResult.copy(t, str);
    }

    public final T component1() {
        return this.data;
    }

    public final String component2() {
        return this.type;
    }

    public final AdaptyBridgeResult<T> copy(T t, String str) {
        Intrinsics.checkNotNullParameter(t, "data");
        Intrinsics.checkNotNullParameter(str, "type");
        return new AdaptyBridgeResult<>(t, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdaptyBridgeResult)) {
            return false;
        }
        AdaptyBridgeResult adaptyBridgeResult = (AdaptyBridgeResult) obj;
        return Intrinsics.areEqual((Object) this.data, (Object) adaptyBridgeResult.data) && Intrinsics.areEqual((Object) this.type, (Object) adaptyBridgeResult.type);
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        return "AdaptyBridgeResult(data=" + this.data + ", type=" + this.type + ')';
    }

    public AdaptyBridgeResult(T t, String str) {
        Intrinsics.checkNotNullParameter(t, "data");
        Intrinsics.checkNotNullParameter(str, "type");
        this.data = t;
        this.type = str;
    }

    public final T getData() {
        return this.data;
    }

    public final String getType() {
        return this.type;
    }
}

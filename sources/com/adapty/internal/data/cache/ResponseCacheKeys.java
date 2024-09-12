package com.adapty.internal.data.cache;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/cache/ResponseCacheKeys;", "", "responseKey", "", "responseHashKey", "(Ljava/lang/String;Ljava/lang/String;)V", "getResponseHashKey", "()Ljava/lang/String;", "getResponseKey", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ResponseCacheKeys.kt */
public final class ResponseCacheKeys {
    private final String responseHashKey;
    private final String responseKey;

    public ResponseCacheKeys(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "responseKey");
        Intrinsics.checkNotNullParameter(str2, "responseHashKey");
        this.responseKey = str;
        this.responseHashKey = str2;
    }

    public final String getResponseKey() {
        return this.responseKey;
    }

    public final String getResponseHashKey() {
        return this.responseHashKey;
    }
}

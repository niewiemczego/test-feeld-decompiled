package com.adapty.internal.data.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/IP;", "", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IP.kt */
public final class IP {
    @SerializedName("ip")
    private final String value;

    public IP(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}

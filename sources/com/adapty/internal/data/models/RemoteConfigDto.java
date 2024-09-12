package com.adapty.internal.data.models;

import com.adapty.internal.crossplatform.AdaptyPaywallTypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/RemoteConfigDto;", "", "lang", "", "data", "(Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getLang", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RemoteConfigDto.kt */
public final class RemoteConfigDto {
    @SerializedName("data")
    private final String data;
    @SerializedName("lang")
    private final String lang;

    public RemoteConfigDto(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, AdaptyPaywallTypeAdapterFactory.LANG);
        this.lang = str;
        this.data = str2;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getData() {
        return this.data;
    }
}

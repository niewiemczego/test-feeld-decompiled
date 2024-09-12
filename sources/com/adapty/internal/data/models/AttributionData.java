package com.adapty.internal.data.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0004\u001a\u00020\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/adapty/internal/data/models/AttributionData;", "", "source", "", "attribution", "networkUserId", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "getAttribution", "()Ljava/lang/Object;", "getNetworkUserId", "()Ljava/lang/String;", "getSource", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AttributionData.kt */
public final class AttributionData {
    @SerializedName("attribution")
    private final Object attribution;
    @SerializedName("network_user_id")
    private final String networkUserId;
    @SerializedName("source")
    private final String source;

    public AttributionData(String str, Object obj, String str2) {
        Intrinsics.checkNotNullParameter(str, "source");
        Intrinsics.checkNotNullParameter(obj, "attribution");
        this.source = str;
        this.attribution = obj;
        this.networkUserId = str2;
    }

    public final String getSource() {
        return this.source;
    }

    public final Object getAttribution() {
        return this.attribution;
    }

    public final String getNetworkUserId() {
        return this.networkUserId;
    }
}

package com.adapty.internal.data.models.requests;

import com.adapty.internal.data.models.AttributionData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00052\u00020\u0001:\u0002\u0005\u0006B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/requests/UpdateAttributionRequest;", "", "data", "Lcom/adapty/internal/data/models/requests/UpdateAttributionRequest$Data;", "(Lcom/adapty/internal/data/models/requests/UpdateAttributionRequest$Data;)V", "Companion", "Data", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UpdateAttributionRequest.kt */
public final class UpdateAttributionRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("data")
    private final Data data;

    public UpdateAttributionRequest(Data data2) {
        Intrinsics.checkNotNullParameter(data2, "data");
        this.data = data2;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/data/models/requests/UpdateAttributionRequest$Data;", "", "type", "", "attributes", "Lcom/adapty/internal/data/models/AttributionData;", "(Ljava/lang/String;Lcom/adapty/internal/data/models/AttributionData;)V", "getAttributes", "()Lcom/adapty/internal/data/models/AttributionData;", "getType", "()Ljava/lang/String;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UpdateAttributionRequest.kt */
    public static final class Data {
        @SerializedName("attributes")
        private final AttributionData attributes;
        @SerializedName("type")
        private final String type;

        public Data(String str, AttributionData attributionData) {
            Intrinsics.checkNotNullParameter(str, "type");
            Intrinsics.checkNotNullParameter(attributionData, "attributes");
            this.type = str;
            this.attributes = attributionData;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Data(String str, AttributionData attributionData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "adapty_analytics_profile_attribution" : str, attributionData);
        }

        public final String getType() {
            return this.type;
        }

        public final AttributionData getAttributes() {
            return this.attributes;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/requests/UpdateAttributionRequest$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/requests/UpdateAttributionRequest;", "attributionData", "Lcom/adapty/internal/data/models/AttributionData;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UpdateAttributionRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UpdateAttributionRequest create(AttributionData attributionData) {
            Intrinsics.checkNotNullParameter(attributionData, "attributionData");
            return new UpdateAttributionRequest(new Data((String) null, attributionData, 1, (DefaultConstructorMarker) null));
        }
    }
}

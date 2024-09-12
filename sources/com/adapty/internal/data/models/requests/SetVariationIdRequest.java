package com.adapty.internal.data.models.requests;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00072\u00020\u0001:\u0002\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/requests/SetVariationIdRequest;", "", "data", "Lcom/adapty/internal/data/models/requests/SetVariationIdRequest$Data;", "(Lcom/adapty/internal/data/models/requests/SetVariationIdRequest$Data;)V", "getData", "()Lcom/adapty/internal/data/models/requests/SetVariationIdRequest$Data;", "Companion", "Data", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SetVariationIdRequest.kt */
public final class SetVariationIdRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("data")
    private final Data data;

    public SetVariationIdRequest(Data data2) {
        Intrinsics.checkNotNullParameter(data2, "data");
        this.data = data2;
    }

    public final Data getData() {
        return this.data;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000bB\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/adapty/internal/data/models/requests/SetVariationIdRequest$Data;", "", "type", "", "attributes", "Lcom/adapty/internal/data/models/requests/SetVariationIdRequest$Data$Attributes;", "(Ljava/lang/String;Lcom/adapty/internal/data/models/requests/SetVariationIdRequest$Data$Attributes;)V", "getAttributes", "()Lcom/adapty/internal/data/models/requests/SetVariationIdRequest$Data$Attributes;", "getType", "()Ljava/lang/String;", "Attributes", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SetVariationIdRequest.kt */
    public static final class Data {
        @SerializedName("attributes")
        private final Attributes attributes;
        @SerializedName("type")
        private final String type;

        public Data(String str, Attributes attributes2) {
            Intrinsics.checkNotNullParameter(str, "type");
            Intrinsics.checkNotNullParameter(attributes2, "attributes");
            this.type = str;
            this.attributes = attributes2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Data(String str, Attributes attributes2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "adapty_analytics_transaction_variation_id" : str, attributes2);
        }

        public final String getType() {
            return this.type;
        }

        public final Attributes getAttributes() {
            return this.attributes;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/requests/SetVariationIdRequest$Data$Attributes;", "", "transactionId", "", "variationId", "(Ljava/lang/String;Ljava/lang/String;)V", "getTransactionId", "()Ljava/lang/String;", "getVariationId", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: SetVariationIdRequest.kt */
        public static final class Attributes {
            @SerializedName("transaction_id")
            private final String transactionId;
            @SerializedName("variation_id")
            private final String variationId;

            public Attributes(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "transactionId");
                Intrinsics.checkNotNullParameter(str2, "variationId");
                this.transactionId = str;
                this.variationId = str2;
            }

            public final String getTransactionId() {
                return this.transactionId;
            }

            public final String getVariationId() {
                return this.variationId;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/adapty/internal/data/models/requests/SetVariationIdRequest$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/requests/SetVariationIdRequest;", "transactionId", "", "variationId", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SetVariationIdRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SetVariationIdRequest create(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "transactionId");
            Intrinsics.checkNotNullParameter(str2, "variationId");
            return new SetVariationIdRequest(new Data((String) null, new Data.Attributes(str, str2), 1, (DefaultConstructorMarker) null));
        }
    }
}

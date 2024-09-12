package com.adapty.internal.crossplatform;

import com.adapty.models.AdaptyPaywallProduct;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J.\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\bH\u0016J4\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyPaywallProductTypeAdapterFactory;", "Lcom/adapty/internal/crossplatform/BaseTypeAdapterFactory;", "Lcom/adapty/models/AdaptyPaywallProduct;", "()V", "read", "in", "Lcom/google/gson/stream/JsonReader;", "delegateAdapter", "Lcom/google/gson/TypeAdapter;", "elementAdapter", "Lcom/google/gson/JsonElement;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "Companion", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyPaywallProductTypeAdapterFactory.kt */
public final class AdaptyPaywallProductTypeAdapterFactory extends BaseTypeAdapterFactory<AdaptyPaywallProduct> {
    @Deprecated
    public static final String ADAPTY_PRODUCT_ID = "adapty_product_id";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String PAYLOAD_DATA = "payload_data";

    public AdaptyPaywallProductTypeAdapterFactory() {
        super(AdaptyPaywallProduct.class);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyPaywallProductTypeAdapterFactory$Companion;", "", "()V", "ADAPTY_PRODUCT_ID", "", "PAYLOAD_DATA", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyPaywallProductTypeAdapterFactory.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void write(JsonWriter jsonWriter, AdaptyPaywallProduct adaptyPaywallProduct, TypeAdapter<AdaptyPaywallProduct> typeAdapter, TypeAdapter<JsonElement> typeAdapter2) {
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        Intrinsics.checkNotNullParameter(adaptyPaywallProduct, "value");
        Intrinsics.checkNotNullParameter(typeAdapter, "delegateAdapter");
        Intrinsics.checkNotNullParameter(typeAdapter2, "elementAdapter");
        JsonObject asJsonObject = typeAdapter.toJsonTree(adaptyPaywallProduct).getAsJsonObject();
        String json = typeAdapter2.toJson(asJsonObject.getAsJsonObject(PAYLOAD_DATA));
        Intrinsics.checkNotNullExpressionValue(json, "elementAdapter.toJson(payloadData)");
        asJsonObject.addProperty(PAYLOAD_DATA, UtilsKt.toBase64(json));
        asJsonObject.addProperty(ADAPTY_PRODUCT_ID, "not implemented");
        typeAdapter2.write(jsonWriter, asJsonObject);
    }

    public AdaptyPaywallProduct read(JsonReader jsonReader, TypeAdapter<AdaptyPaywallProduct> typeAdapter, TypeAdapter<JsonElement> typeAdapter2) {
        Intrinsics.checkNotNullParameter(jsonReader, "in");
        Intrinsics.checkNotNullParameter(typeAdapter, "delegateAdapter");
        Intrinsics.checkNotNullParameter(typeAdapter2, "elementAdapter");
        JsonObject asJsonObject = typeAdapter2.read(jsonReader).getAsJsonObject();
        String asString = asJsonObject.get(PAYLOAD_DATA).getAsString();
        Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(PAYLOAD_DATA).asString");
        asJsonObject.add(PAYLOAD_DATA, typeAdapter2.fromJson(UtilsKt.fromBase64(asString)).getAsJsonObject());
        return typeAdapter.fromJsonTree(asJsonObject);
    }
}

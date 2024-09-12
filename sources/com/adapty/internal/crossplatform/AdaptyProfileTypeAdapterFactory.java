package com.adapty.internal.crossplatform;

import com.adapty.models.AdaptyProfile;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyProfileTypeAdapterFactory;", "Lcom/adapty/internal/crossplatform/BaseTypeAdapterFactory;", "Lcom/adapty/models/AdaptyProfile;", "()V", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "delegateAdapter", "Lcom/google/gson/TypeAdapter;", "elementAdapter", "Lcom/google/gson/JsonElement;", "Companion", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyProfileTypeAdapterFactory.kt */
public final class AdaptyProfileTypeAdapterFactory extends BaseTypeAdapterFactory<AdaptyProfile> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String SEGMENT_HASH = "segment_hash";

    public AdaptyProfileTypeAdapterFactory() {
        super(AdaptyProfile.class);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyProfileTypeAdapterFactory$Companion;", "", "()V", "SEGMENT_HASH", "", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyProfileTypeAdapterFactory.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void write(JsonWriter jsonWriter, AdaptyProfile adaptyProfile, TypeAdapter<AdaptyProfile> typeAdapter, TypeAdapter<JsonElement> typeAdapter2) {
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        Intrinsics.checkNotNullParameter(adaptyProfile, "value");
        Intrinsics.checkNotNullParameter(typeAdapter, "delegateAdapter");
        Intrinsics.checkNotNullParameter(typeAdapter2, "elementAdapter");
        JsonObject asJsonObject = typeAdapter.toJsonTree(adaptyProfile).getAsJsonObject();
        asJsonObject.addProperty(SEGMENT_HASH, "not implemented");
        typeAdapter2.write(jsonWriter, asJsonObject);
    }
}

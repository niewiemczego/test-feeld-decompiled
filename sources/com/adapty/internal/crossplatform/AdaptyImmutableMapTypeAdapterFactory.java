package com.adapty.internal.crossplatform;

import com.adapty.utils.ImmutableMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00102\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J>\u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\bH\u0016JD\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyImmutableMapTypeAdapterFactory;", "Lcom/adapty/internal/crossplatform/BaseTypeAdapterFactory;", "Lcom/adapty/utils/ImmutableMap;", "()V", "read", "in", "Lcom/google/gson/stream/JsonReader;", "delegateAdapter", "Lcom/google/gson/TypeAdapter;", "elementAdapter", "Lcom/google/gson/JsonElement;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "Companion", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyImmutableMapTypeAdapterFactory.kt */
public final class AdaptyImmutableMapTypeAdapterFactory extends BaseTypeAdapterFactory<ImmutableMap<?, ?>> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String MAP = "map";

    public AdaptyImmutableMapTypeAdapterFactory() {
        super(ImmutableMap.class);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyImmutableMapTypeAdapterFactory$Companion;", "", "()V", "MAP", "", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyImmutableMapTypeAdapterFactory.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void write(JsonWriter jsonWriter, ImmutableMap<?, ?> immutableMap, TypeAdapter<ImmutableMap<?, ?>> typeAdapter, TypeAdapter<JsonElement> typeAdapter2) {
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        Intrinsics.checkNotNullParameter(immutableMap, "value");
        Intrinsics.checkNotNullParameter(typeAdapter, "delegateAdapter");
        Intrinsics.checkNotNullParameter(typeAdapter2, "elementAdapter");
        typeAdapter2.write(jsonWriter, typeAdapter.toJsonTree(immutableMap).getAsJsonObject().getAsJsonObject(MAP));
    }

    public ImmutableMap<?, ?> read(JsonReader jsonReader, TypeAdapter<ImmutableMap<?, ?>> typeAdapter, TypeAdapter<JsonElement> typeAdapter2) {
        Intrinsics.checkNotNullParameter(jsonReader, "in");
        Intrinsics.checkNotNullParameter(typeAdapter, "delegateAdapter");
        Intrinsics.checkNotNullParameter(typeAdapter2, "elementAdapter");
        JsonObject asJsonObject = typeAdapter2.read(jsonReader).getAsJsonObject();
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(MAP, asJsonObject);
        return typeAdapter.fromJsonTree(jsonObject);
    }
}

package com.adapty.internal.crossplatform;

import com.adapty.utils.AdaptyResult;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/adapty/internal/crossplatform/AdaptyResultTypeAdapterFactory$create$result$1", "Lcom/google/gson/TypeAdapter;", "Lcom/adapty/utils/AdaptyResult;", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyResultTypeAdapterFactory.kt */
public final class AdaptyResultTypeAdapterFactory$create$result$1 extends TypeAdapter<AdaptyResult<?>> {
    final /* synthetic */ TypeAdapter<JsonElement> $elementAdapter;
    final /* synthetic */ TypeAdapter<AdaptyResult.Error> $errorAdapter;
    final /* synthetic */ TypeAdapter<AdaptyResult.Success<?>> $successAdapter;

    public AdaptyResult<?> read(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "in");
        return null;
    }

    AdaptyResultTypeAdapterFactory$create$result$1(TypeAdapter<AdaptyResult.Success<?>> typeAdapter, TypeAdapter<AdaptyResult.Error> typeAdapter2, TypeAdapter<JsonElement> typeAdapter3) {
        this.$successAdapter = typeAdapter;
        this.$errorAdapter = typeAdapter2;
        this.$elementAdapter = typeAdapter3;
    }

    public void write(JsonWriter jsonWriter, AdaptyResult<?> adaptyResult) {
        JsonObject jsonObject;
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        Intrinsics.checkNotNullParameter(adaptyResult, "value");
        if (adaptyResult instanceof AdaptyResult.Success) {
            jsonObject = this.$successAdapter.toJsonTree(adaptyResult).getAsJsonObject();
            jsonObject.add("success", jsonObject.remove("value"));
            if (((AdaptyResult.Success) adaptyResult).getValue() == null) {
                jsonWriter.setSerializeNulls(true);
            }
        } else if (adaptyResult instanceof AdaptyResult.Error) {
            jsonObject = this.$errorAdapter.toJsonTree(adaptyResult).getAsJsonObject();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.$elementAdapter.write(jsonWriter, jsonObject);
    }
}

package com.adapty.internal.data.cache;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/adapty/internal/data/cache/CacheEntityTypeAdapterFactory$create$result$1", "Lcom/google/gson/TypeAdapter;", "read", "in", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CacheEntityTypeAdapterFactory.kt */
public final class CacheEntityTypeAdapterFactory$create$result$1 extends TypeAdapter<T> {
    final /* synthetic */ TypeAdapter<T> $delegateAdapter;
    final /* synthetic */ TypeAdapter<JsonElement> $elementAdapter;

    CacheEntityTypeAdapterFactory$create$result$1(TypeAdapter<T> typeAdapter, TypeAdapter<JsonElement> typeAdapter2) {
        this.$delegateAdapter = typeAdapter;
        this.$elementAdapter = typeAdapter2;
    }

    public void write(JsonWriter jsonWriter, T t) {
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        this.$delegateAdapter.write(jsonWriter, t);
    }

    public T read(JsonReader jsonReader) {
        Object obj;
        Intrinsics.checkNotNullParameter(jsonReader, "in");
        JsonObject asJsonObject = this.$elementAdapter.read(jsonReader).getAsJsonObject();
        Long l = null;
        try {
            Result.Companion companion = Result.Companion;
            JsonElement jsonElement = asJsonObject.get(CacheEntityTypeAdapterFactory.CACHED_AT);
            obj = Result.m983constructorimpl(jsonElement != null ? Long.valueOf(jsonElement.getAsLong()) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m983constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m989isFailureimpl(obj)) {
            l = obj;
        }
        if (l == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("value", asJsonObject);
            jsonObject.addProperty(CacheEntityTypeAdapterFactory.CACHED_AT, (Number) 0L);
            asJsonObject = jsonObject;
        }
        return this.$delegateAdapter.fromJsonTree(asJsonObject);
    }
}

package com.adapty.internal.crossplatform;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/adapty/internal/crossplatform/AdaptyViewConfigBaseTypeAdapterFactory$create$result$1", "Lcom/google/gson/TypeAdapter;", "read", "in", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyViewConfigBaseTypeAdapterFactory.kt */
public final class AdaptyViewConfigBaseTypeAdapterFactory$create$result$1 extends TypeAdapter<TYPE> {
    final /* synthetic */ List<TypeAdapter<? extends TYPE>> $childAdapters;
    final /* synthetic */ TypeAdapter<JsonElement> $elementAdapter;
    final /* synthetic */ AdaptyViewConfigBaseTypeAdapterFactory<TYPE> this$0;

    AdaptyViewConfigBaseTypeAdapterFactory$create$result$1(AdaptyViewConfigBaseTypeAdapterFactory<TYPE> adaptyViewConfigBaseTypeAdapterFactory, List<? extends TypeAdapter<? extends TYPE>> list, TypeAdapter<JsonElement> typeAdapter) {
        this.this$0 = adaptyViewConfigBaseTypeAdapterFactory;
        this.$childAdapters = list;
        this.$elementAdapter = typeAdapter;
    }

    public void write(JsonWriter jsonWriter, TYPE type) {
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        Pair<JsonElement, String> createJsonElementWithClassValueOnWrite = this.this$0.createJsonElementWithClassValueOnWrite(type, this.$childAdapters);
        JsonElement component1 = createJsonElementWithClassValueOnWrite.component1();
        Intrinsics.checkNotNull(component1, "null cannot be cast to non-null type com.google.gson.JsonObject");
        JsonObject jsonObject = (JsonObject) component1;
        jsonObject.addProperty(UtilsKt.CLASS_KEY, createJsonElementWithClassValueOnWrite.component2());
        this.$elementAdapter.write(jsonWriter, jsonObject);
    }

    public TYPE read(JsonReader jsonReader) {
        JsonElement remove;
        String asString;
        Intrinsics.checkNotNullParameter(jsonReader, "in");
        JsonElement read = this.$elementAdapter.read(jsonReader);
        JsonObject jsonObject = read instanceof JsonObject ? (JsonObject) read : null;
        if (!(jsonObject == null || (remove = jsonObject.remove(UtilsKt.CLASS_KEY)) == null)) {
            if (!remove.isJsonPrimitive()) {
                remove = null;
            }
            if (!(remove == null || (asString = remove.getAsString()) == null)) {
                if (!(asString.length() > 0)) {
                    asString = null;
                }
                if (asString != null) {
                    return this.this$0.createResultOnRead(jsonObject, asString, this.$childAdapters);
                }
            }
        }
        return null;
    }
}

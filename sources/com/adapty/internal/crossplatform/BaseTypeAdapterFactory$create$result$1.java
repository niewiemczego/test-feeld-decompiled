package com.adapty.internal.crossplatform;

import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/adapty/internal/crossplatform/BaseTypeAdapterFactory$create$result$1", "Lcom/google/gson/TypeAdapter;", "read", "in", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BaseTypeAdapterFactory.kt */
public final class BaseTypeAdapterFactory$create$result$1 extends TypeAdapter<TYPE> {
    final /* synthetic */ TypeAdapter<TYPE> $delegateAdapter;
    final /* synthetic */ TypeAdapter<JsonElement> $elementAdapter;
    final /* synthetic */ BaseTypeAdapterFactory<TYPE> this$0;

    BaseTypeAdapterFactory$create$result$1(BaseTypeAdapterFactory<TYPE> baseTypeAdapterFactory, TypeAdapter<TYPE> typeAdapter, TypeAdapter<JsonElement> typeAdapter2) {
        this.this$0 = baseTypeAdapterFactory;
        this.$delegateAdapter = typeAdapter;
        this.$elementAdapter = typeAdapter2;
    }

    public void write(JsonWriter jsonWriter, TYPE type) {
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        BaseTypeAdapterFactory<TYPE> baseTypeAdapterFactory = this.this$0;
        TypeAdapter<TYPE> typeAdapter = this.$delegateAdapter;
        Intrinsics.checkNotNullExpressionValue(typeAdapter, "delegateAdapter");
        TypeAdapter<JsonElement> typeAdapter2 = this.$elementAdapter;
        Intrinsics.checkNotNullExpressionValue(typeAdapter2, "elementAdapter");
        baseTypeAdapterFactory.write(jsonWriter, type, typeAdapter, typeAdapter2);
    }

    public TYPE read(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "in");
        BaseTypeAdapterFactory<TYPE> baseTypeAdapterFactory = this.this$0;
        TypeAdapter<TYPE> typeAdapter = this.$delegateAdapter;
        Intrinsics.checkNotNullExpressionValue(typeAdapter, "delegateAdapter");
        TypeAdapter<JsonElement> typeAdapter2 = this.$elementAdapter;
        Intrinsics.checkNotNullExpressionValue(typeAdapter2, "elementAdapter");
        return baseTypeAdapterFactory.read(jsonReader, typeAdapter, typeAdapter2);
    }
}

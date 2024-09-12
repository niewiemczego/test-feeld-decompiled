package com.adapty.internal.crossplatform;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J,\u0010\u0006\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\u0007\"\u0004\b\u0001\u0010\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\fH\u0016J3\u0010\r\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0016¢\u0006\u0002\u0010\u0013J9\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0016¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/adapty/internal/crossplatform/BaseTypeAdapterFactory;", "TYPE", "Lcom/google/gson/TypeAdapterFactory;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "create", "Lcom/google/gson/TypeAdapter;", "T", "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "read", "in", "Lcom/google/gson/stream/JsonReader;", "delegateAdapter", "elementAdapter", "Lcom/google/gson/JsonElement;", "(Lcom/google/gson/stream/JsonReader;Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;)Ljava/lang/Object;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;)V", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BaseTypeAdapterFactory.kt */
public abstract class BaseTypeAdapterFactory<TYPE> implements TypeAdapterFactory {
    private final Class<TYPE> clazz;

    public BaseTypeAdapterFactory(Class<TYPE> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.clazz = cls;
    }

    public void write(JsonWriter jsonWriter, TYPE type, TypeAdapter<TYPE> typeAdapter, TypeAdapter<JsonElement> typeAdapter2) {
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        Intrinsics.checkNotNullParameter(typeAdapter, "delegateAdapter");
        Intrinsics.checkNotNullParameter(typeAdapter2, "elementAdapter");
        typeAdapter.write(jsonWriter, type);
    }

    public TYPE read(JsonReader jsonReader, TypeAdapter<TYPE> typeAdapter, TypeAdapter<JsonElement> typeAdapter2) {
        Intrinsics.checkNotNullParameter(jsonReader, "in");
        Intrinsics.checkNotNullParameter(typeAdapter, "delegateAdapter");
        Intrinsics.checkNotNullParameter(typeAdapter2, "elementAdapter");
        return typeAdapter.read(jsonReader);
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(typeToken, "type");
        if (!this.clazz.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        TypeAdapter<T> nullSafe = new BaseTypeAdapterFactory$create$result$1(this, gson.getDelegateAdapter(this, TypeToken.get(this.clazz)), gson.getAdapter(JsonElement.class)).nullSafe();
        Intrinsics.checkNotNull(nullSafe, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T of com.adapty.internal.crossplatform.BaseTypeAdapterFactory.create>");
        return nullSafe;
    }
}

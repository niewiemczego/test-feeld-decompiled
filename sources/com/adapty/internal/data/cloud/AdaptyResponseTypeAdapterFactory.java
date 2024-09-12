package com.adapty.internal.data.cloud;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J,\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\t\"\u0004\b\u0001\u0010\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004H\u0016J3\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\tH\u0002¢\u0006\u0002\u0010\u0014J+\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/adapty/internal/data/cloud/AdaptyResponseTypeAdapterFactory;", "TYPE", "Lcom/google/gson/TypeAdapterFactory;", "typeToken", "Lcom/google/gson/reflect/TypeToken;", "responseDataExtractor", "Lcom/adapty/internal/data/cloud/ResponseDataExtractor;", "(Lcom/google/gson/reflect/TypeToken;Lcom/adapty/internal/data/cloud/ResponseDataExtractor;)V", "create", "Lcom/google/gson/TypeAdapter;", "T", "gson", "Lcom/google/gson/Gson;", "type", "read", "in", "Lcom/google/gson/stream/JsonReader;", "delegateAdapter", "elementAdapter", "Lcom/google/gson/JsonElement;", "(Lcom/google/gson/stream/JsonReader;Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;)Ljava/lang/Object;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;Lcom/google/gson/TypeAdapter;)V", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyResponseTypeAdapterFactory.kt */
public final class AdaptyResponseTypeAdapterFactory<TYPE> implements TypeAdapterFactory {
    private final ResponseDataExtractor responseDataExtractor;
    private final TypeToken<TYPE> typeToken;

    public AdaptyResponseTypeAdapterFactory(TypeToken<TYPE> typeToken2, ResponseDataExtractor responseDataExtractor2) {
        Intrinsics.checkNotNullParameter(typeToken2, "typeToken");
        Intrinsics.checkNotNullParameter(responseDataExtractor2, "responseDataExtractor");
        this.typeToken = typeToken2;
        this.responseDataExtractor = responseDataExtractor2;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken2) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(typeToken2, "type");
        try {
            if (!this.typeToken.isAssignableFrom(typeToken2.getType())) {
                return null;
            }
            TypeAdapter<T> nullSafe = new AdaptyResponseTypeAdapterFactory$create$result$1(this, gson.getDelegateAdapter(this, this.typeToken), gson.getAdapter(JsonElement.class)).nullSafe();
            Intrinsics.checkNotNull(nullSafe, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T of com.adapty.internal.data.cloud.AdaptyResponseTypeAdapterFactory.create>");
            return nullSafe;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final void write(JsonWriter jsonWriter, TYPE type, TypeAdapter<TYPE> typeAdapter) {
        typeAdapter.write(jsonWriter, type);
    }

    /* access modifiers changed from: private */
    public final TYPE read(JsonReader jsonReader, TypeAdapter<TYPE> typeAdapter, TypeAdapter<JsonElement> typeAdapter2) {
        JsonElement read = typeAdapter2.read(jsonReader);
        ResponseDataExtractor responseDataExtractor2 = this.responseDataExtractor;
        Intrinsics.checkNotNullExpressionValue(read, "jsonElement");
        JsonElement extract = responseDataExtractor2.extract(read);
        if (extract != null) {
            read = extract;
        }
        return typeAdapter.fromJsonTree(read);
    }
}

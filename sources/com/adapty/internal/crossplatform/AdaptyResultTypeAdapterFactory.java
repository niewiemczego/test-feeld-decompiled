package com.adapty.internal.crossplatform;

import com.adapty.utils.AdaptyResult;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0016¨\u0006\n"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyResultTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", "create", "Lcom/google/gson/TypeAdapter;", "T", "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyResultTypeAdapterFactory.kt */
public final class AdaptyResultTypeAdapterFactory implements TypeAdapterFactory {
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(typeToken, "type");
        if (!AdaptyResult.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        TypeAdapterFactory typeAdapterFactory = this;
        TypeAdapter<T> nullSafe = new AdaptyResultTypeAdapterFactory$create$result$1(gson.getDelegateAdapter(typeAdapterFactory, TypeToken.get(AdaptyResult.Success.class)), gson.getDelegateAdapter(typeAdapterFactory, TypeToken.get(AdaptyResult.Error.class)), gson.getAdapter(JsonElement.class)).nullSafe();
        Intrinsics.checkNotNull(nullSafe, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T of com.adapty.internal.crossplatform.AdaptyResultTypeAdapterFactory.create>");
        return nullSafe;
    }
}

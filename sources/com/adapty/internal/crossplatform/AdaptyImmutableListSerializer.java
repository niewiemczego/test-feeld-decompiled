package com.adapty.internal.crossplatform;

import com.adapty.utils.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyImmutableListSerializer;", "Lcom/google/gson/JsonSerializer;", "Lcom/adapty/utils/ImmutableList;", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyImmutableListSerializer.kt */
public final class AdaptyImmutableListSerializer implements JsonSerializer<ImmutableList<?>> {
    public JsonElement serialize(ImmutableList<?> immutableList, Type type, JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(immutableList, "src");
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        Iterable<Object> iterable = immutableList;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object add : iterable) {
            arrayList.add(add);
        }
        JsonElement serialize = jsonSerializationContext.serialize((List) arrayList);
        Intrinsics.checkNotNullExpressionValue(serialize, "context.serialize(src.map { it })");
        return serialize;
    }
}

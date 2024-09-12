package com.adapty.internal.crossplatform;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J,\u0010\u0006\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\u0007\"\u0004\b\u0001\u0010\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\fH\u0016J7\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0011\u001a\u00028\u00002\u0014\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00070\u0013H&¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00070\u00132\u0006\u0010\t\u001a\u00020\nH&J5\u0010\u0016\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\u0014\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00070\u0013H&¢\u0006\u0002\u0010\u001aJ2\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u0007\"\b\b\u0001\u0010\u001c*\u00028\u0000*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00070\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyViewConfigBaseTypeAdapterFactory;", "TYPE", "Lcom/google/gson/TypeAdapterFactory;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "create", "Lcom/google/gson/TypeAdapter;", "T", "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "createJsonElementWithClassValueOnWrite", "Lkotlin/Pair;", "Lcom/google/gson/JsonElement;", "", "value", "orderedChildAdapters", "", "(Ljava/lang/Object;Ljava/util/List;)Lkotlin/Pair;", "createOrderedChildAdapters", "createResultOnRead", "jsonObject", "Lcom/google/gson/JsonObject;", "classValue", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/util/List;)Ljava/lang/Object;", "getFor", "ACTUAL_TYPE", "index", "", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyViewConfigBaseTypeAdapterFactory.kt */
public abstract class AdaptyViewConfigBaseTypeAdapterFactory<TYPE> implements TypeAdapterFactory {
    private final Class<TYPE> clazz;

    public abstract Pair<JsonElement, String> createJsonElementWithClassValueOnWrite(TYPE type, List<? extends TypeAdapter<? extends TYPE>> list);

    public abstract List<TypeAdapter<? extends TYPE>> createOrderedChildAdapters(Gson gson);

    public abstract TYPE createResultOnRead(JsonObject jsonObject, String str, List<? extends TypeAdapter<? extends TYPE>> list);

    public AdaptyViewConfigBaseTypeAdapterFactory(Class<TYPE> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.clazz = cls;
    }

    /* access modifiers changed from: protected */
    public final <ACTUAL_TYPE extends TYPE> TypeAdapter<ACTUAL_TYPE> getFor(List<? extends TypeAdapter<? extends TYPE>> list, int i) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Object obj = list.get(i);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.google.gson.TypeAdapter<ACTUAL_TYPE of com.adapty.internal.crossplatform.AdaptyViewConfigBaseTypeAdapterFactory.getFor>");
        return (TypeAdapter) obj;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(typeToken, "type");
        if (!this.clazz.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        TypeAdapter<T> nullSafe = new AdaptyViewConfigBaseTypeAdapterFactory$create$result$1(this, createOrderedChildAdapters(gson), gson.getAdapter(JsonElement.class)).nullSafe();
        Intrinsics.checkNotNull(nullSafe, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T of com.adapty.internal.crossplatform.AdaptyViewConfigBaseTypeAdapterFactory.create>");
        return nullSafe;
    }
}

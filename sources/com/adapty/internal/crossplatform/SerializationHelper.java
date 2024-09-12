package com.adapty.internal.crossplatform;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J/\u0010\t\u001a\n \u000b*\u0004\u0018\u0001H\nH\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u000f¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u0006\u0010\u0012\u001a\u00020\u0001R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/adapty/internal/crossplatform/SerializationHelper;", "", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "fromJson", "T", "kotlin.jvm.PlatformType", "json", "", "type", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "toJson", "src", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SerializationHelper.kt */
public final class SerializationHelper {
    private final Lazy gson$delegate = LazyKt.lazy(SerializationHelper$gson$2.INSTANCE);

    private final Gson getGson() {
        Object value = this.gson$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-gson>(...)");
        return (Gson) value;
    }

    public final <T> T fromJson(String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.checkNotNullParameter(cls, "type");
        return getGson().fromJson(str, cls);
    }

    public final String toJson(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "src");
        return getGson().toJson(obj);
    }
}

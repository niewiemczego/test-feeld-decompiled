package com.adapty.internal.crossplatform;

import com.adapty.models.AdaptyPurchasedInfo;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyPurchasedInfoSerializer;", "Lcom/google/gson/JsonSerializer;", "Lcom/adapty/models/AdaptyPurchasedInfo;", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyPurchasedInfoSerializer.kt */
public final class AdaptyPurchasedInfoSerializer implements JsonSerializer<AdaptyPurchasedInfo> {
    public JsonElement serialize(AdaptyPurchasedInfo adaptyPurchasedInfo, Type type, JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(adaptyPurchasedInfo, "src");
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        JsonElement serialize = jsonSerializationContext.serialize(adaptyPurchasedInfo.getProfile());
        Intrinsics.checkNotNullExpressionValue(serialize, "context.serialize(src.profile)");
        return serialize;
    }
}

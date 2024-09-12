package com.adapty.internal.crossplatform;

import com.adapty.models.AdaptyPaywall;
import com.android.billingclient.api.ProductDetails;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/adapty/internal/crossplatform/SerializationExclusionStrategy;", "Lcom/google/gson/ExclusionStrategy;", "()V", "shouldSkipClass", "", "clazz", "Ljava/lang/Class;", "shouldSkipField", "f", "Lcom/google/gson/FieldAttributes;", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SerializationExclusionStrategy.kt */
public final class SerializationExclusionStrategy implements ExclusionStrategy {
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        Intrinsics.checkNotNullParameter(fieldAttributes, "f");
        return Intrinsics.areEqual((Object) fieldAttributes.getDeclaringClass(), (Object) AdaptyPaywall.class) && Intrinsics.areEqual((Object) fieldAttributes.getName(), (Object) "remoteConfig");
    }

    public boolean shouldSkipClass(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return Intrinsics.areEqual((Object) cls, (Object) ProductDetails.class);
    }
}

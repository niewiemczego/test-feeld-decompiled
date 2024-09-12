package com.adapty.internal.crossplatform;

import com.adapty.ui.AdaptyUI;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyUIActionTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", "create", "Lcom/google/gson/TypeAdapter;", "T", "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "Companion", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyUIActionTypeAdapterFactory.kt */
public final class AdaptyUIActionTypeAdapterFactory implements TypeAdapterFactory {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String TYPE = "type";
    @Deprecated
    public static final String TYPE_CLOSE = "close";
    @Deprecated
    public static final String TYPE_CUSTOM = "custom";
    @Deprecated
    public static final String TYPE_OPEN_URL = "open_url";
    @Deprecated
    public static final String VALUE = "value";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyUIActionTypeAdapterFactory$Companion;", "", "()V", "TYPE", "", "TYPE_CLOSE", "TYPE_CUSTOM", "TYPE_OPEN_URL", "VALUE", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyUIActionTypeAdapterFactory.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(typeToken, "type");
        if (!AdaptyUI.Action.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        TypeAdapter<T> nullSafe = new AdaptyUIActionTypeAdapterFactory$create$result$1(gson.getAdapter(JsonElement.class)).nullSafe();
        Intrinsics.checkNotNull(nullSafe, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T of com.adapty.internal.crossplatform.AdaptyUIActionTypeAdapterFactory.create>");
        return nullSafe;
    }
}

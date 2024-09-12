package com.adapty.internal.data.cloud;

import com.adapty.internal.data.models.requests.CreateOrUpdateProfileRequest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0016J\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000f"}, d2 = {"Lcom/adapty/internal/data/cloud/CreateOrUpdateProfileRequestTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", "create", "Lcom/google/gson/TypeAdapter;", "T", "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "getAsJsonObjectOrNull", "Lcom/google/gson/JsonObject;", "memberName", "", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CreateOrUpdateProfileRequestTypeAdapterFactory.kt */
public final class CreateOrUpdateProfileRequestTypeAdapterFactory implements TypeAdapterFactory {
    @Deprecated
    public static final String ATTRS = "attributes";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String DATA = "data";
    @Deprecated
    public static final String META = "installation_meta";
    @Deprecated
    public static final String STORE_COUNTRY = "store_country";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/adapty/internal/data/cloud/CreateOrUpdateProfileRequestTypeAdapterFactory$Companion;", "", "()V", "ATTRS", "", "DATA", "META", "STORE_COUNTRY", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CreateOrUpdateProfileRequestTypeAdapterFactory.kt */
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
        if (!CreateOrUpdateProfileRequest.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        TypeAdapter<T> nullSafe = new CreateOrUpdateProfileRequestTypeAdapterFactory$create$result$1(gson.getDelegateAdapter(this, TypeToken.get(CreateOrUpdateProfileRequest.class)), this, gson.getAdapter(JsonElement.class)).nullSafe();
        Intrinsics.checkNotNull(nullSafe, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T of com.adapty.internal.data.cloud.CreateOrUpdateProfileRequestTypeAdapterFactory.create>");
        return nullSafe;
    }

    /* access modifiers changed from: private */
    public final JsonObject getAsJsonObjectOrNull(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null) {
            return null;
        }
        if (!jsonElement.isJsonObject()) {
            jsonElement = null;
        }
        if (jsonElement != null) {
            return jsonElement.getAsJsonObject();
        }
        return null;
    }
}

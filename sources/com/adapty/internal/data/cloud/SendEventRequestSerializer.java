package com.adapty.internal.data.cloud;

import com.adapty.internal.data.models.requests.SendEventRequest;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/adapty/internal/data/cloud/SendEventRequestSerializer;", "Lcom/google/gson/JsonSerializer;", "Lcom/adapty/internal/data/models/requests/SendEventRequest;", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SendEventRequestSerializer.kt */
public final class SendEventRequestSerializer implements JsonSerializer<SendEventRequest> {
    @Deprecated
    public static final String ATTRS = "attributes";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String DATA = "data";
    @Deprecated
    public static final String EVENTS = "events";
    @Deprecated
    public static final String TYPE = "type";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/adapty/internal/data/cloud/SendEventRequestSerializer$Companion;", "", "()V", "ATTRS", "", "DATA", "EVENTS", "TYPE", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SendEventRequestSerializer.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public JsonElement serialize(SendEventRequest sendEventRequest, Type type, JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(sendEventRequest, "src");
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("events", jsonSerializationContext.serialize(sendEventRequest.getEvents()));
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("type", "sdk_background_event");
        jsonObject2.add("attributes", jsonObject);
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.add("data", jsonObject2);
        return jsonObject3;
    }
}

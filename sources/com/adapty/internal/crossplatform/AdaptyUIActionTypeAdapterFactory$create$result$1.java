package com.adapty.internal.crossplatform;

import com.adapty.ui.AdaptyUI;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/adapty/internal/crossplatform/AdaptyUIActionTypeAdapterFactory$create$result$1", "Lcom/google/gson/TypeAdapter;", "Lcom/adapty/ui/AdaptyUI$Action;", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyUIActionTypeAdapterFactory.kt */
public final class AdaptyUIActionTypeAdapterFactory$create$result$1 extends TypeAdapter<AdaptyUI.Action> {
    final /* synthetic */ TypeAdapter<JsonElement> $elementAdapter;

    public AdaptyUI.Action read(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "in");
        return null;
    }

    AdaptyUIActionTypeAdapterFactory$create$result$1(TypeAdapter<JsonElement> typeAdapter) {
        this.$elementAdapter = typeAdapter;
    }

    public void write(JsonWriter jsonWriter, AdaptyUI.Action action) {
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        Intrinsics.checkNotNullParameter(action, "value");
        JsonObject jsonObject = new JsonObject();
        if (Intrinsics.areEqual((Object) action, (Object) AdaptyUI.Action.Close.INSTANCE)) {
            jsonObject.addProperty("type", AdaptyUIActionTypeAdapterFactory.TYPE_CLOSE);
        } else if (action instanceof AdaptyUI.Action.OpenUrl) {
            jsonObject.addProperty("type", AdaptyUIActionTypeAdapterFactory.TYPE_OPEN_URL);
            jsonObject.addProperty("value", ((AdaptyUI.Action.OpenUrl) action).getUrl());
        } else if (action instanceof AdaptyUI.Action.Custom) {
            jsonObject.addProperty("type", AdaptyUIActionTypeAdapterFactory.TYPE_CUSTOM);
            jsonObject.addProperty("value", ((AdaptyUI.Action.Custom) action).getCustomId());
        }
        this.$elementAdapter.write(jsonWriter, jsonObject);
    }
}

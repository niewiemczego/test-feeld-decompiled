package com.adapty.internal.data.cloud;

import com.adapty.internal.data.models.requests.CreateOrUpdateProfileRequest;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/adapty/internal/data/cloud/CreateOrUpdateProfileRequestTypeAdapterFactory$create$result$1", "Lcom/google/gson/TypeAdapter;", "Lcom/adapty/internal/data/models/requests/CreateOrUpdateProfileRequest;", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CreateOrUpdateProfileRequestTypeAdapterFactory.kt */
public final class CreateOrUpdateProfileRequestTypeAdapterFactory$create$result$1 extends TypeAdapter<CreateOrUpdateProfileRequest> {
    final /* synthetic */ TypeAdapter<CreateOrUpdateProfileRequest> $delegateAdapter;
    final /* synthetic */ TypeAdapter<JsonElement> $elementAdapter;
    final /* synthetic */ CreateOrUpdateProfileRequestTypeAdapterFactory this$0;

    public CreateOrUpdateProfileRequest read(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "in");
        return null;
    }

    CreateOrUpdateProfileRequestTypeAdapterFactory$create$result$1(TypeAdapter<CreateOrUpdateProfileRequest> typeAdapter, CreateOrUpdateProfileRequestTypeAdapterFactory createOrUpdateProfileRequestTypeAdapterFactory, TypeAdapter<JsonElement> typeAdapter2) {
        this.$delegateAdapter = typeAdapter;
        this.this$0 = createOrUpdateProfileRequestTypeAdapterFactory;
        this.$elementAdapter = typeAdapter2;
    }

    public void write(JsonWriter jsonWriter, CreateOrUpdateProfileRequest createOrUpdateProfileRequest) {
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        Intrinsics.checkNotNullParameter(createOrUpdateProfileRequest, "value");
        JsonObject asJsonObject = this.$delegateAdapter.toJsonTree(createOrUpdateProfileRequest).getAsJsonObject();
        CreateOrUpdateProfileRequestTypeAdapterFactory createOrUpdateProfileRequestTypeAdapterFactory = this.this$0;
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "jsonObject");
        JsonObject access$getAsJsonObjectOrNull = createOrUpdateProfileRequestTypeAdapterFactory.getAsJsonObjectOrNull(asJsonObject, "data");
        JsonElement jsonElement = null;
        JsonObject access$getAsJsonObjectOrNull2 = access$getAsJsonObjectOrNull != null ? this.this$0.getAsJsonObjectOrNull(access$getAsJsonObjectOrNull, "attributes") : null;
        if (access$getAsJsonObjectOrNull2 != null) {
            JsonObject access$getAsJsonObjectOrNull3 = this.this$0.getAsJsonObjectOrNull(access$getAsJsonObjectOrNull2, CreateOrUpdateProfileRequestTypeAdapterFactory.META);
            if (access$getAsJsonObjectOrNull3 != null) {
                jsonElement = access$getAsJsonObjectOrNull3.remove(CreateOrUpdateProfileRequestTypeAdapterFactory.STORE_COUNTRY);
            }
            if (jsonElement != null) {
                access$getAsJsonObjectOrNull2.add(CreateOrUpdateProfileRequestTypeAdapterFactory.STORE_COUNTRY, jsonElement);
            }
        }
        this.$elementAdapter.write(jsonWriter, asJsonObject);
    }
}

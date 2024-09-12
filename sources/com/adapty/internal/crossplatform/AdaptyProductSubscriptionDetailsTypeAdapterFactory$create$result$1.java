package com.adapty.internal.crossplatform;

import com.adapty.models.AdaptyProductSubscriptionDetails;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/adapty/internal/crossplatform/AdaptyProductSubscriptionDetailsTypeAdapterFactory$create$result$1", "Lcom/google/gson/TypeAdapter;", "Lcom/adapty/models/AdaptyProductSubscriptionDetails;", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyProductSubscriptionDetailsTypeAdapterFactory.kt */
public final class AdaptyProductSubscriptionDetailsTypeAdapterFactory$create$result$1 extends TypeAdapter<AdaptyProductSubscriptionDetails> {
    final /* synthetic */ TypeAdapter<AdaptyProductSubscriptionDetails> $delegateAdapter;
    final /* synthetic */ TypeAdapter<JsonElement> $elementAdapter;
    final /* synthetic */ Gson $gson;

    AdaptyProductSubscriptionDetailsTypeAdapterFactory$create$result$1(TypeAdapter<AdaptyProductSubscriptionDetails> typeAdapter, Gson gson, TypeAdapter<JsonElement> typeAdapter2) {
        this.$delegateAdapter = typeAdapter;
        this.$gson = gson;
        this.$elementAdapter = typeAdapter2;
    }

    public void write(JsonWriter jsonWriter, AdaptyProductSubscriptionDetails adaptyProductSubscriptionDetails) {
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        Intrinsics.checkNotNullParameter(adaptyProductSubscriptionDetails, "value");
        JsonObject asJsonObject = this.$delegateAdapter.toJsonTree(adaptyProductSubscriptionDetails).getAsJsonObject();
        asJsonObject.add(AdaptyProductSubscriptionDetailsTypeAdapterFactory.INTRODUCTORY_OFFER_ELIGIBILITY, this.$gson.toJsonTree(adaptyProductSubscriptionDetails.getIntroductoryOfferEligibility()));
        this.$elementAdapter.write(jsonWriter, asJsonObject);
    }

    public AdaptyProductSubscriptionDetails read(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "in");
        JsonObject asJsonObject = this.$elementAdapter.read(jsonReader).getAsJsonObject();
        asJsonObject.remove(AdaptyProductSubscriptionDetailsTypeAdapterFactory.INTRODUCTORY_OFFER_ELIGIBILITY);
        return this.$delegateAdapter.fromJsonTree(asJsonObject);
    }
}

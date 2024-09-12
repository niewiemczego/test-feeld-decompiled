package com.adapty.internal.crossplatform;

import com.adapty.models.AdaptySubscriptionUpdateParameters;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyReplacementModeDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/adapty/models/AdaptySubscriptionUpdateParameters$ReplacementMode;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyReplacementModeDeserializer.kt */
public final class AdaptyReplacementModeDeserializer implements JsonDeserializer<AdaptySubscriptionUpdateParameters.ReplacementMode> {
    public AdaptySubscriptionUpdateParameters.ReplacementMode deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        String asString = jsonElement.getAsString();
        if (asString != null) {
            switch (asString.hashCode()) {
                case -1683224060:
                    if (asString.equals("charge_full_price")) {
                        return AdaptySubscriptionUpdateParameters.ReplacementMode.CHARGE_FULL_PRICE;
                    }
                    break;
                case -216757012:
                    if (asString.equals("charge_prorated_price")) {
                        return AdaptySubscriptionUpdateParameters.ReplacementMode.CHARGE_PRORATED_PRICE;
                    }
                    break;
                case 647890911:
                    if (asString.equals("deferred")) {
                        return AdaptySubscriptionUpdateParameters.ReplacementMode.DEFERRED;
                    }
                    break;
                case 1666355193:
                    if (asString.equals("without_proration")) {
                        return AdaptySubscriptionUpdateParameters.ReplacementMode.WITHOUT_PRORATION;
                    }
                    break;
                case 1932277847:
                    if (asString.equals("with_time_proration")) {
                        return AdaptySubscriptionUpdateParameters.ReplacementMode.WITH_TIME_PRORATION;
                    }
                    break;
            }
        }
        return null;
    }
}

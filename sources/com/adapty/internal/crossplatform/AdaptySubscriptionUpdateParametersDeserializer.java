package com.adapty.internal.crossplatform;

import com.adapty.models.AdaptySubscriptionUpdateParameters;
import com.facebook.internal.security.CertificateUtil;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptySubscriptionUpdateParametersDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/adapty/models/AdaptySubscriptionUpdateParameters;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptySubscriptionUpdateParametersDeserializer.kt */
public final class AdaptySubscriptionUpdateParametersDeserializer implements JsonDeserializer<AdaptySubscriptionUpdateParameters> {
    public AdaptySubscriptionUpdateParameters deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        Object obj;
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        JsonObject jsonObject = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
        if (jsonObject == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            AdaptySubscriptionUpdateParametersDeserializer adaptySubscriptionUpdateParametersDeserializer = this;
            String asString = jsonObject.getAsJsonPrimitive("old_sub_vendor_product_id").getAsString();
            Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.getAsJsonPrim…dor_product_id\").asString");
            obj = Result.m983constructorimpl((String) StringsKt.split$default((CharSequence) asString, new String[]{CertificateUtil.DELIMITER}, false, 0, 6, (Object) null).get(0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m983constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m989isFailureimpl(obj)) {
            obj = null;
        }
        String str = (String) obj;
        JsonElement jsonElement2 = jsonObject.get("replacement_mode");
        if (str == null || jsonElement2 == null) {
            return null;
        }
        Object deserialize = jsonDeserializationContext.deserialize(jsonElement2, AdaptySubscriptionUpdateParameters.ReplacementMode.class);
        Intrinsics.checkNotNullExpressionValue(deserialize, "context.deserialize(repl…lacementMode::class.java)");
        return new AdaptySubscriptionUpdateParameters(str, (AdaptySubscriptionUpdateParameters.ReplacementMode) deserialize);
    }
}

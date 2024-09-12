package com.adapty.internal.crossplatform;

import com.adapty.models.AdaptyEligibility;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyEligibilityAdapter;", "Lcom/google/gson/JsonSerializer;", "Lcom/adapty/models/AdaptyEligibility;", "Lcom/google/gson/JsonDeserializer;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "serialize", "src", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyEligibilityAdapter.kt */
public final class AdaptyEligibilityAdapter implements JsonSerializer<AdaptyEligibility>, JsonDeserializer<AdaptyEligibility> {
    public JsonElement serialize(AdaptyEligibility adaptyEligibility, Type type, JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(adaptyEligibility, "src");
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        String name = adaptyEligibility.name();
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
        String lowerCase = name.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        JsonElement serialize = jsonSerializationContext.serialize(lowerCase);
        Intrinsics.checkNotNullExpressionValue(serialize, "context.serialize(src.na…owercase(Locale.ENGLISH))");
        return serialize;
    }

    public AdaptyEligibility deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        String asString = jsonElement.getAsString();
        if (Intrinsics.areEqual((Object) asString, (Object) "eligible")) {
            return AdaptyEligibility.ELIGIBLE;
        }
        if (Intrinsics.areEqual((Object) asString, (Object) "ineligible")) {
            return AdaptyEligibility.INELIGIBLE;
        }
        return AdaptyEligibility.NOT_APPLICABLE;
    }
}

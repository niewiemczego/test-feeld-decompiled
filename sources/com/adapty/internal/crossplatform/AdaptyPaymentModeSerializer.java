package com.adapty.internal.crossplatform;

import com.adapty.models.AdaptyProductDiscountPhase;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyPaymentModeSerializer;", "Lcom/google/gson/JsonSerializer;", "Lcom/adapty/models/AdaptyProductDiscountPhase$PaymentMode;", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyPaymentModeSerializer.kt */
public final class AdaptyPaymentModeSerializer implements JsonSerializer<AdaptyProductDiscountPhase.PaymentMode> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyPaymentModeSerializer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdaptyProductDiscountPhase.PaymentMode.values().length];
            try {
                iArr[AdaptyProductDiscountPhase.PaymentMode.PAY_UPFRONT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JsonElement serialize(AdaptyProductDiscountPhase.PaymentMode paymentMode, Type type, JsonSerializationContext jsonSerializationContext) {
        String str;
        Intrinsics.checkNotNullParameter(paymentMode, "src");
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        if (WhenMappings.$EnumSwitchMapping$0[paymentMode.ordinal()] == 1) {
            str = "pay_up_front";
        } else {
            String name = paymentMode.name();
            Locale locale = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
            str = name.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
        }
        JsonElement serialize = jsonSerializationContext.serialize(str);
        Intrinsics.checkNotNullExpressionValue(serialize, "context.serialize(\n     …)\n            }\n        )");
        return serialize;
    }
}

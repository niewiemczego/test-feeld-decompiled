package com.adapty.internal.utils;

import com.google.gson.JsonDeserializer;
import java.math.BigDecimal;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/utils/BigDecimalDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Ljava/math/BigDecimal;", "()V", "deserialize", "jsonElement", "Lcom/google/gson/JsonElement;", "type", "Ljava/lang/reflect/Type;", "jsonDeserializationContext", "Lcom/google/gson/JsonDeserializationContext;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BigDecimalDeserializer.kt */
public final class BigDecimalDeserializer implements JsonDeserializer<BigDecimal> {
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return r8;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.math.BigDecimal deserialize(com.google.gson.JsonElement r7, java.lang.reflect.Type r8, com.google.gson.JsonDeserializationContext r9) {
        /*
            r6 = this;
            java.lang.String r8 = "jsonElement"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            java.math.BigDecimal r8 = r7.getAsBigDecimal()     // Catch:{ NumberFormatException -> 0x000f }
            java.lang.String r9 = "{\n            jsonElement.asBigDecimal\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)     // Catch:{ NumberFormatException -> 0x000f }
            goto L_0x0044
        L_0x000f:
            com.google.gson.JsonPrimitive r8 = new com.google.gson.JsonPrimitive     // Catch:{ NumberFormatException -> 0x003c }
            java.lang.String r0 = r7.getAsString()     // Catch:{ NumberFormatException -> 0x003c }
            java.lang.String r7 = "jsonElement.asString"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r7)     // Catch:{ NumberFormatException -> 0x003c }
            java.lang.String r1 = ","
            java.lang.String r2 = "."
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r7 = kotlin.text.StringsKt.replace$default((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2, (boolean) r3, (int) r4, (java.lang.Object) r5)     // Catch:{ NumberFormatException -> 0x003c }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ NumberFormatException -> 0x003c }
            kotlin.text.Regex r9 = new kotlin.text.Regex     // Catch:{ NumberFormatException -> 0x003c }
            java.lang.String r0 = "[^0-9.]"
            r9.<init>((java.lang.String) r0)     // Catch:{ NumberFormatException -> 0x003c }
            java.lang.String r0 = ""
            java.lang.String r7 = r9.replace((java.lang.CharSequence) r7, (java.lang.String) r0)     // Catch:{ NumberFormatException -> 0x003c }
            r8.<init>((java.lang.String) r7)     // Catch:{ NumberFormatException -> 0x003c }
            java.math.BigDecimal r7 = r8.getAsBigDecimal()     // Catch:{ NumberFormatException -> 0x003c }
            goto L_0x003e
        L_0x003c:
            java.math.BigDecimal r7 = java.math.BigDecimal.ZERO
        L_0x003e:
            r8 = r7
            java.lang.String r7 = "{\n            try {\n    …O\n            }\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
        L_0x0044:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.BigDecimalDeserializer.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):java.math.BigDecimal");
    }
}

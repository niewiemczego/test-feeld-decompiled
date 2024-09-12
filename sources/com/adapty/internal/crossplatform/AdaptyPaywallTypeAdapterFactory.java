package com.adapty.internal.crossplatform;

import com.adapty.models.AdaptyPaywall;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J.\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\bH\u0016J4\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyPaywallTypeAdapterFactory;", "Lcom/adapty/internal/crossplatform/BaseTypeAdapterFactory;", "Lcom/adapty/models/AdaptyPaywall;", "()V", "read", "in", "Lcom/google/gson/stream/JsonReader;", "delegateAdapter", "Lcom/google/gson/TypeAdapter;", "elementAdapter", "Lcom/google/gson/JsonElement;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "Companion", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyPaywallTypeAdapterFactory.kt */
public final class AdaptyPaywallTypeAdapterFactory extends BaseTypeAdapterFactory<AdaptyPaywall> {
    @Deprecated
    public static final String BASE_PLAN_ID = "base_plan_id";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String DATA = "data";
    @Deprecated
    public static final String IS_CONSUMABLE = "is_consumable";
    @Deprecated
    public static final String LANG = "lang";
    @Deprecated
    public static final String LOCALE = "locale";
    @Deprecated
    public static final String OFFER_ID = "offer_id";
    @Deprecated
    public static final String PRODUCTS = "products";
    @Deprecated
    public static final String REMOTE_CONFIG = "remote_config";
    @Deprecated
    public static final String REMOTE_CONFIG_STR = "remote_config_string";
    @Deprecated
    public static final String TYPE = "type";

    public AdaptyPaywallTypeAdapterFactory() {
        super(AdaptyPaywall.class);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyPaywallTypeAdapterFactory$Companion;", "", "()V", "BASE_PLAN_ID", "", "DATA", "IS_CONSUMABLE", "LANG", "LOCALE", "OFFER_ID", "PRODUCTS", "REMOTE_CONFIG", "REMOTE_CONFIG_STR", "TYPE", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyPaywallTypeAdapterFactory.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c2 A[Catch:{ Exception -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00dd A[Catch:{ Exception -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ff A[Catch:{ Exception -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0104 A[Catch:{ Exception -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x010e A[Catch:{ Exception -> 0x011f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.adapty.models.AdaptyPaywall read(com.google.gson.stream.JsonReader r12, com.google.gson.TypeAdapter<com.adapty.models.AdaptyPaywall> r13, com.google.gson.TypeAdapter<com.google.gson.JsonElement> r14) {
        /*
            r11 = this;
            java.lang.String r0 = "is_consumable"
            java.lang.String r1 = "offer_id"
            java.lang.String r2 = "base_plan_id"
            java.lang.String r3 = "remote_config"
            java.lang.String r4 = "in"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r4)
            java.lang.String r4 = "delegateAdapter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r4)
            java.lang.String r4 = "elementAdapter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r4)
            java.lang.Object r12 = r14.read(r12)
            com.google.gson.JsonElement r12 = (com.google.gson.JsonElement) r12
            com.google.gson.JsonObject r12 = r12.getAsJsonObject()
            com.google.gson.JsonElement r4 = r12.remove(r3)     // Catch:{ Exception -> 0x011f }
            com.google.gson.JsonObject r4 = r4.getAsJsonObject()     // Catch:{ Exception -> 0x011f }
            java.lang.String r5 = "locale"
            java.lang.String r6 = "lang"
            com.google.gson.JsonElement r6 = r4.get(r6)     // Catch:{ Exception -> 0x011f }
            java.lang.String r6 = r6.getAsString()     // Catch:{ Exception -> 0x011f }
            r12.addProperty((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x011f }
            java.lang.String r5 = "data"
            com.google.gson.JsonElement r4 = r4.get(r5)     // Catch:{ Exception -> 0x011f }
            r5 = 0
            r6 = 0
            if (r4 == 0) goto L_0x0072
            boolean r7 = r4.isJsonPrimitive()     // Catch:{ Exception -> 0x011f }
            if (r7 == 0) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r4 = r6
        L_0x004a:
            if (r4 == 0) goto L_0x0072
            java.lang.String r4 = r4.getAsString()     // Catch:{ Exception -> 0x011f }
            if (r4 == 0) goto L_0x0072
            r7 = r4
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ Exception -> 0x011f }
            int r7 = r7.length()     // Catch:{ Exception -> 0x011f }
            if (r7 <= 0) goto L_0x005d
            r7 = 1
            goto L_0x005e
        L_0x005d:
            r7 = r5
        L_0x005e:
            if (r7 == 0) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r4 = r6
        L_0x0062:
            if (r4 == 0) goto L_0x0072
            java.lang.String r7 = "remote_config_string"
            r12.addProperty((java.lang.String) r7, (java.lang.String) r4)     // Catch:{ Exception -> 0x011f }
            java.lang.Object r14 = r14.fromJson((java.lang.String) r4)     // Catch:{ Exception -> 0x011f }
            com.google.gson.JsonElement r14 = (com.google.gson.JsonElement) r14     // Catch:{ Exception -> 0x011f }
            r12.add(r3, r14)     // Catch:{ Exception -> 0x011f }
        L_0x0072:
            java.lang.String r14 = "products"
            com.google.gson.JsonArray r14 = r12.getAsJsonArray(r14)     // Catch:{ Exception -> 0x011f }
            if (r14 == 0) goto L_0x011f
            java.lang.Iterable r14 = (java.lang.Iterable) r14     // Catch:{ Exception -> 0x011f }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x011f }
        L_0x0080:
            boolean r3 = r14.hasNext()     // Catch:{ Exception -> 0x011f }
            if (r3 == 0) goto L_0x011f
            java.lang.Object r3 = r14.next()     // Catch:{ Exception -> 0x011f }
            com.google.gson.JsonElement r3 = (com.google.gson.JsonElement) r3     // Catch:{ Exception -> 0x011f }
            boolean r4 = r3.isJsonObject()     // Catch:{ Exception -> 0x011f }
            if (r4 == 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r3 = r6
        L_0x0094:
            if (r3 == 0) goto L_0x0080
            com.google.gson.JsonObject r3 = r3.getAsJsonObject()     // Catch:{ Exception -> 0x011f }
            if (r3 == 0) goto L_0x0080
            java.lang.String r4 = "asJsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Exception -> 0x011f }
            com.google.gson.JsonElement r4 = r3.remove(r2)     // Catch:{ Exception -> 0x011f }
            if (r4 == 0) goto L_0x00bb
            java.lang.String r7 = "remove(BASE_PLAN_ID)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)     // Catch:{ Exception -> 0x011f }
            boolean r7 = r4.isJsonPrimitive()     // Catch:{ Exception -> 0x011f }
            if (r7 == 0) goto L_0x00b3
            goto L_0x00b4
        L_0x00b3:
            r4 = r6
        L_0x00b4:
            if (r4 == 0) goto L_0x00bb
            java.lang.String r4 = r4.getAsString()     // Catch:{ Exception -> 0x011f }
            goto L_0x00bc
        L_0x00bb:
            r4 = r6
        L_0x00bc:
            com.google.gson.JsonElement r7 = r3.remove(r1)     // Catch:{ Exception -> 0x011f }
            if (r7 == 0) goto L_0x00d6
            java.lang.String r8 = "remove(OFFER_ID)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)     // Catch:{ Exception -> 0x011f }
            boolean r8 = r7.isJsonPrimitive()     // Catch:{ Exception -> 0x011f }
            if (r8 == 0) goto L_0x00ce
            goto L_0x00cf
        L_0x00ce:
            r7 = r6
        L_0x00cf:
            if (r7 == 0) goto L_0x00d6
            java.lang.String r7 = r7.getAsString()     // Catch:{ Exception -> 0x011f }
            goto L_0x00d7
        L_0x00d6:
            r7 = r6
        L_0x00d7:
            com.google.gson.JsonElement r8 = r3.remove(r0)     // Catch:{ Exception -> 0x011f }
            if (r8 == 0) goto L_0x00f5
            java.lang.String r9 = "remove(IS_CONSUMABLE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)     // Catch:{ Exception -> 0x011f }
            boolean r9 = r8.isJsonPrimitive()     // Catch:{ Exception -> 0x011f }
            if (r9 == 0) goto L_0x00e9
            goto L_0x00ea
        L_0x00e9:
            r8 = r6
        L_0x00ea:
            if (r8 == 0) goto L_0x00f5
            boolean r8 = r8.getAsBoolean()     // Catch:{ Exception -> 0x011f }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ Exception -> 0x011f }
            goto L_0x00f6
        L_0x00f5:
            r8 = r6
        L_0x00f6:
            java.lang.String r9 = "type"
            com.google.gson.JsonObject r10 = new com.google.gson.JsonObject     // Catch:{ Exception -> 0x011f }
            r10.<init>()     // Catch:{ Exception -> 0x011f }
            if (r8 == 0) goto L_0x0104
            boolean r8 = r8.booleanValue()     // Catch:{ Exception -> 0x011f }
            goto L_0x0105
        L_0x0104:
            r8 = r5
        L_0x0105:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ Exception -> 0x011f }
            r10.addProperty((java.lang.String) r0, (java.lang.Boolean) r8)     // Catch:{ Exception -> 0x011f }
            if (r4 == 0) goto L_0x0116
            r10.addProperty((java.lang.String) r2, (java.lang.String) r4)     // Catch:{ Exception -> 0x011f }
            if (r7 == 0) goto L_0x0116
            r10.addProperty((java.lang.String) r1, (java.lang.String) r7)     // Catch:{ Exception -> 0x011f }
        L_0x0116:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x011f }
            com.google.gson.JsonElement r10 = (com.google.gson.JsonElement) r10     // Catch:{ Exception -> 0x011f }
            r3.add(r9, r10)     // Catch:{ Exception -> 0x011f }
            goto L_0x0080
        L_0x011f:
            com.google.gson.JsonElement r12 = (com.google.gson.JsonElement) r12
            java.lang.Object r12 = r13.fromJsonTree(r12)
            com.adapty.models.AdaptyPaywall r12 = (com.adapty.models.AdaptyPaywall) r12
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.crossplatform.AdaptyPaywallTypeAdapterFactory.read(com.google.gson.stream.JsonReader, com.google.gson.TypeAdapter, com.google.gson.TypeAdapter):com.adapty.models.AdaptyPaywall");
    }

    public void write(JsonWriter jsonWriter, AdaptyPaywall adaptyPaywall, TypeAdapter<AdaptyPaywall> typeAdapter, TypeAdapter<JsonElement> typeAdapter2) {
        JsonObject asJsonObject;
        JsonObject asJsonObject2;
        String asString;
        String asString2;
        String asString3;
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        Intrinsics.checkNotNullParameter(adaptyPaywall, "value");
        Intrinsics.checkNotNullParameter(typeAdapter, "delegateAdapter");
        Intrinsics.checkNotNullParameter(typeAdapter2, "elementAdapter");
        JsonObject asJsonObject3 = typeAdapter.toJsonTree(adaptyPaywall).getAsJsonObject();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(LANG, asJsonObject3.remove("locale").getAsString());
        JsonElement remove = asJsonObject3.remove(REMOTE_CONFIG_STR);
        if (remove != null) {
            if (!remove.isJsonPrimitive()) {
                remove = null;
            }
            if (!(remove == null || (asString3 = remove.getAsString()) == null)) {
                jsonObject.addProperty("data", asString3);
            }
        }
        Unit unit = Unit.INSTANCE;
        asJsonObject3.add(REMOTE_CONFIG, jsonObject);
        JsonArray<JsonElement> asJsonArray = asJsonObject3.getAsJsonArray(PRODUCTS);
        if (asJsonArray != null) {
            for (JsonElement jsonElement : asJsonArray) {
                if (!jsonElement.isJsonObject()) {
                    jsonElement = null;
                }
                if (!(jsonElement == null || (asJsonObject = jsonElement.getAsJsonObject()) == null)) {
                    Intrinsics.checkNotNullExpressionValue(asJsonObject, "asJsonObject");
                    JsonElement remove2 = asJsonObject.remove("type");
                    if (remove2 != null) {
                        if (!remove2.isJsonObject()) {
                            remove2 = null;
                        }
                        if (!(remove2 == null || (asJsonObject2 = remove2.getAsJsonObject()) == null)) {
                            JsonElement jsonElement2 = asJsonObject2.get(IS_CONSUMABLE);
                            if (jsonElement2 != null) {
                                Intrinsics.checkNotNullExpressionValue(jsonElement2, "get(IS_CONSUMABLE)");
                                if (!jsonElement2.isJsonPrimitive()) {
                                    jsonElement2 = null;
                                }
                                if (jsonElement2 != null) {
                                    asJsonObject.addProperty(IS_CONSUMABLE, Boolean.valueOf(jsonElement2.getAsBoolean()));
                                }
                            }
                            JsonElement jsonElement3 = asJsonObject2.get(BASE_PLAN_ID);
                            if (jsonElement3 != null) {
                                Intrinsics.checkNotNullExpressionValue(jsonElement3, "get(BASE_PLAN_ID)");
                                if (!jsonElement3.isJsonPrimitive()) {
                                    jsonElement3 = null;
                                }
                                if (!(jsonElement3 == null || (asString2 = jsonElement3.getAsString()) == null)) {
                                    Intrinsics.checkNotNullExpressionValue(asString2, "asString");
                                    asJsonObject.addProperty(BASE_PLAN_ID, asString2);
                                }
                            }
                            JsonElement jsonElement4 = asJsonObject2.get(OFFER_ID);
                            if (jsonElement4 != null) {
                                Intrinsics.checkNotNullExpressionValue(jsonElement4, "get(OFFER_ID)");
                                if (!jsonElement4.isJsonPrimitive()) {
                                    jsonElement4 = null;
                                }
                                if (!(jsonElement4 == null || (asString = jsonElement4.getAsString()) == null)) {
                                    Intrinsics.checkNotNullExpressionValue(asString, "asString");
                                    asJsonObject.addProperty(OFFER_ID, asString);
                                }
                            }
                        }
                    }
                }
            }
        }
        typeAdapter2.write(jsonWriter, asJsonObject3);
    }
}

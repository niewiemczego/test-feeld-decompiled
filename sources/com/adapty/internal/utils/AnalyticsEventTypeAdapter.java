package com.adapty.internal.utils;

import com.adapty.internal.data.models.AnalyticsEvent;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J \u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0014H\u0016¨\u0006\u0016"}, d2 = {"Lcom/adapty/internal/utils/AnalyticsEventTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/adapty/internal/data/models/AnalyticsEvent;", "Lcom/google/gson/JsonSerializer;", "()V", "deserialize", "jsonElement", "Lcom/google/gson/JsonElement;", "type", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "getEventParam", "", "eventJson", "Lcom/google/gson/JsonObject;", "paramKey", "serialize", "src", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnalyticsEventTypeAdapter.kt */
public final class AnalyticsEventTypeAdapter implements JsonDeserializer<AnalyticsEvent>, JsonSerializer<AnalyticsEvent> {
    @Deprecated
    public static final String COUNTER = "counter";
    @Deprecated
    public static final String CREATED_AT = "created_at";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String DATA = "Data";
    @Deprecated
    public static final String DEVICE_ID = "device_id";
    @Deprecated
    public static final String DEVICE_ID_OLD = "profile_installation_meta_id";
    @Deprecated
    public static final String EVENT_ID = "event_id";
    @Deprecated
    public static final String EVENT_NAME = "event_name";
    @Deprecated
    public static final String PARTITION_KEY = "PartitionKey";
    @Deprecated
    public static final String PLATFORM = "platform";
    @Deprecated
    public static final String PROFILE_ID = "profile_id";
    @Deprecated
    public static final String SESSION_ID = "session_id";
    /* access modifiers changed from: private */
    @Deprecated
    public static final Set<String> defaultKeys = SetsKt.setOf("event_id", EVENT_NAME, "profile_id", "session_id", "device_id", DEVICE_ID_OLD, CREATED_AT, "platform", COUNTER);

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00af, code lost:
        if (r13 == null) goto L_0x00b1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.adapty.internal.data.models.AnalyticsEvent deserialize(com.google.gson.JsonElement r13, java.lang.reflect.Type r14, com.google.gson.JsonDeserializationContext r15) {
        /*
            r12 = this;
            java.lang.String r0 = "jsonElement"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r14 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r14)
            kotlin.Result$Companion r14 = kotlin.Result.Companion     // Catch:{ all -> 0x001d }
            r14 = r12
            com.adapty.internal.utils.AnalyticsEventTypeAdapter r14 = (com.adapty.internal.utils.AnalyticsEventTypeAdapter) r14     // Catch:{ all -> 0x001d }
            com.google.gson.JsonObject r13 = r13.getAsJsonObject()     // Catch:{ all -> 0x001d }
            java.lang.Object r13 = kotlin.Result.m983constructorimpl(r13)     // Catch:{ all -> 0x001d }
            goto L_0x0028
        L_0x001d:
            r13 = move-exception
            kotlin.Result$Companion r14 = kotlin.Result.Companion
            java.lang.Object r13 = kotlin.ResultKt.createFailure(r13)
            java.lang.Object r13 = kotlin.Result.m983constructorimpl(r13)
        L_0x0028:
            boolean r14 = kotlin.Result.m989isFailureimpl(r13)
            r15 = 0
            if (r14 == 0) goto L_0x0030
            r13 = r15
        L_0x0030:
            com.google.gson.JsonObject r13 = (com.google.gson.JsonObject) r13
            if (r13 != 0) goto L_0x0035
            return r15
        L_0x0035:
            java.lang.String r14 = "Data"
            boolean r0 = r13.has(r14)
            if (r0 == 0) goto L_0x00b2
            java.lang.String r0 = "PartitionKey"
            boolean r0 = r13.has(r0)
            if (r0 == 0) goto L_0x00b2
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0057 }
            r0 = r12
            com.adapty.internal.utils.AnalyticsEventTypeAdapter r0 = (com.adapty.internal.utils.AnalyticsEventTypeAdapter) r0     // Catch:{ all -> 0x0057 }
            com.google.gson.JsonElement r13 = r13.get(r14)     // Catch:{ all -> 0x0057 }
            java.lang.String r13 = r13.getAsString()     // Catch:{ all -> 0x0057 }
            java.lang.Object r13 = kotlin.Result.m983constructorimpl(r13)     // Catch:{ all -> 0x0057 }
            goto L_0x0062
        L_0x0057:
            r13 = move-exception
            kotlin.Result$Companion r14 = kotlin.Result.Companion
            java.lang.Object r13 = kotlin.ResultKt.createFailure(r13)
            java.lang.Object r13 = kotlin.Result.m983constructorimpl(r13)
        L_0x0062:
            boolean r14 = kotlin.Result.m989isFailureimpl(r13)
            if (r14 == 0) goto L_0x0069
            r13 = r15
        L_0x0069:
            r0 = r13
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x00b1
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "\\u003d"
            java.lang.String r2 = "="
            java.lang.String r13 = kotlin.text.StringsKt.replace$default((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2, (boolean) r3, (int) r4, (java.lang.Object) r5)
            byte[] r13 = com.google.android.gms.common.util.Base64Utils.decode(r13)
            java.lang.String r14 = "decode(encoded.replace(\"\\\\u003d\", \"=\"))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            java.lang.String r13 = kotlin.text.StringsKt.decodeToString(r13)
            kotlin.Result$Companion r14 = kotlin.Result.Companion     // Catch:{ all -> 0x0098 }
            r14 = r12
            com.adapty.internal.utils.AnalyticsEventTypeAdapter r14 = (com.adapty.internal.utils.AnalyticsEventTypeAdapter) r14     // Catch:{ all -> 0x0098 }
            com.google.gson.JsonElement r13 = com.google.gson.JsonParser.parseString(r13)     // Catch:{ all -> 0x0098 }
            com.google.gson.JsonObject r13 = r13.getAsJsonObject()     // Catch:{ all -> 0x0098 }
            java.lang.Object r13 = kotlin.Result.m983constructorimpl(r13)     // Catch:{ all -> 0x0098 }
            goto L_0x00a3
        L_0x0098:
            r13 = move-exception
            kotlin.Result$Companion r14 = kotlin.Result.Companion
            java.lang.Object r13 = kotlin.ResultKt.createFailure(r13)
            java.lang.Object r13 = kotlin.Result.m983constructorimpl(r13)
        L_0x00a3:
            boolean r14 = kotlin.Result.m989isFailureimpl(r13)
            if (r14 == 0) goto L_0x00aa
            r13 = r15
        L_0x00aa:
            com.google.gson.JsonObject r13 = (com.google.gson.JsonObject) r13
            if (r13 != 0) goto L_0x00af
            return r15
        L_0x00af:
            if (r13 != 0) goto L_0x00b2
        L_0x00b1:
            return r15
        L_0x00b2:
            java.util.HashMap r14 = new java.util.HashMap
            r14.<init>()
            java.util.Set r0 = r13.keySet()
            java.lang.String r1 = "eventJson.keySet()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x00c6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00f4
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.util.Set<java.lang.String> r2 = defaultKeys
            boolean r2 = r2.contains(r1)
            if (r2 != 0) goto L_0x00c6
            com.google.gson.JsonElement r2 = r13.get(r1)
            boolean r3 = r2 instanceof com.google.gson.JsonPrimitive
            if (r3 == 0) goto L_0x00e5
            com.google.gson.JsonPrimitive r2 = (com.google.gson.JsonPrimitive) r2
            goto L_0x00e6
        L_0x00e5:
            r2 = r15
        L_0x00e6:
            if (r2 == 0) goto L_0x00c6
            r3 = r14
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r4 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            r3.put(r1, r2)
            goto L_0x00c6
        L_0x00f4:
            java.lang.String r0 = "event_id"
            java.lang.String r2 = r12.getEventParam(r13, r0)
            if (r2 != 0) goto L_0x00fd
            return r15
        L_0x00fd:
            java.lang.String r0 = "event_name"
            java.lang.String r3 = r12.getEventParam(r13, r0)
            if (r3 != 0) goto L_0x0106
            return r15
        L_0x0106:
            java.lang.String r0 = "profile_id"
            java.lang.String r4 = r12.getEventParam(r13, r0)
            if (r4 != 0) goto L_0x010f
            return r15
        L_0x010f:
            java.lang.String r0 = "session_id"
            java.lang.String r5 = r12.getEventParam(r13, r0)
            if (r5 != 0) goto L_0x0118
            return r15
        L_0x0118:
            java.lang.String r0 = "device_id"
            java.lang.String r0 = r12.getEventParam(r13, r0)
            if (r0 != 0) goto L_0x0129
            java.lang.String r0 = "profile_installation_meta_id"
            java.lang.String r0 = r12.getEventParam(r13, r0)
            if (r0 != 0) goto L_0x0129
            return r15
        L_0x0129:
            r6 = r0
            java.lang.String r0 = "created_at"
            java.lang.String r7 = r12.getEventParam(r13, r0)
            if (r7 != 0) goto L_0x0133
            return r15
        L_0x0133:
            java.lang.String r0 = "platform"
            java.lang.String r8 = r12.getEventParam(r13, r0)
            if (r8 != 0) goto L_0x013c
            return r15
        L_0x013c:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0154 }
            r0 = r12
            com.adapty.internal.utils.AnalyticsEventTypeAdapter r0 = (com.adapty.internal.utils.AnalyticsEventTypeAdapter) r0     // Catch:{ all -> 0x0154 }
            java.lang.String r0 = "counter"
            com.google.gson.JsonPrimitive r13 = r13.getAsJsonPrimitive(r0)     // Catch:{ all -> 0x0154 }
            long r0 = r13.getAsLong()     // Catch:{ all -> 0x0154 }
            java.lang.Long r13 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x0154 }
            java.lang.Object r13 = kotlin.Result.m983constructorimpl(r13)     // Catch:{ all -> 0x0154 }
            goto L_0x015f
        L_0x0154:
            r13 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r13 = kotlin.ResultKt.createFailure(r13)
            java.lang.Object r13 = kotlin.Result.m983constructorimpl(r13)
        L_0x015f:
            boolean r0 = kotlin.Result.m989isFailureimpl(r13)
            if (r0 == 0) goto L_0x0166
            goto L_0x0167
        L_0x0166:
            r15 = r13
        L_0x0167:
            java.lang.Long r15 = (java.lang.Long) r15
            if (r15 == 0) goto L_0x0170
            long r0 = r15.longValue()
            goto L_0x0172
        L_0x0170:
            r0 = 0
        L_0x0172:
            r10 = r0
            com.adapty.internal.data.models.AnalyticsEvent r13 = new com.adapty.internal.data.models.AnalyticsEvent
            r9 = r14
            java.util.Map r9 = (java.util.Map) r9
            r1 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r13.setOrdinal(r10)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.AnalyticsEventTypeAdapter.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):com.adapty.internal.data.models.AnalyticsEvent");
    }

    public JsonElement serialize(AnalyticsEvent analyticsEvent, Type type, JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(analyticsEvent, "src");
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("event_id", analyticsEvent.getEventId());
        jsonObject.addProperty(EVENT_NAME, analyticsEvent.getEventName());
        jsonObject.addProperty("profile_id", analyticsEvent.getProfileId());
        jsonObject.addProperty("session_id", analyticsEvent.getSessionId());
        jsonObject.addProperty("device_id", analyticsEvent.getDeviceId());
        jsonObject.addProperty(CREATED_AT, analyticsEvent.getCreatedAt());
        jsonObject.addProperty("platform", analyticsEvent.getPlatform());
        jsonObject.addProperty(COUNTER, (Number) Long.valueOf(analyticsEvent.getOrdinal()));
        for (Map.Entry next : analyticsEvent.getOther().entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (value instanceof JsonPrimitive) {
                jsonObject.add(str, (JsonElement) value);
            } else if (value instanceof Number) {
                jsonObject.add(str, new JsonPrimitive((Number) value));
            } else if (value instanceof String) {
                jsonObject.add(str, new JsonPrimitive((String) value));
            } else if (value instanceof Boolean) {
                jsonObject.add(str, new JsonPrimitive((Boolean) value));
            }
        }
        return jsonObject;
    }

    private final String getEventParam(JsonObject jsonObject, String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            AnalyticsEventTypeAdapter analyticsEventTypeAdapter = this;
            obj = Result.m983constructorimpl(jsonObject.getAsJsonPrimitive(str).getAsString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m983constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m989isFailureimpl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/adapty/internal/utils/AnalyticsEventTypeAdapter$Companion;", "", "()V", "COUNTER", "", "CREATED_AT", "DATA", "DEVICE_ID", "DEVICE_ID_OLD", "EVENT_ID", "EVENT_NAME", "PARTITION_KEY", "PLATFORM", "PROFILE_ID", "SESSION_ID", "defaultKeys", "", "getDefaultKeys", "()Ljava/util/Set;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnalyticsEventTypeAdapter.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getDefaultKeys() {
            return AnalyticsEventTypeAdapter.defaultKeys;
        }
    }
}

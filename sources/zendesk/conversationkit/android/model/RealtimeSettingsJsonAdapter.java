package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import java.lang.reflect.Constructor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lzendesk/conversationkit/android/model/RealtimeSettingsJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/RealtimeSettings;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "constructorRef", "Ljava/lang/reflect/Constructor;", "intAdapter", "", "longAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "timeUnitAdapter", "Ljava/util/concurrent/TimeUnit;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RealtimeSettingsJsonAdapter.kt */
public final class RealtimeSettingsJsonAdapter extends JsonAdapter<RealtimeSettings> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private volatile Constructor<RealtimeSettings> constructorRef;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<Long> longAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<TimeUnit> timeUnitAdapter;

    public RealtimeSettingsJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("enabled", "baseUrl", "retryInterval", "maxConnectionAttempts", "connectionDelay", "timeUnit", "appId", "userId");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"enabled\", \"baseUrl\",…Unit\", \"appId\", \"userId\")");
        this.options = of;
        JsonAdapter<Boolean> adapter = moshi.adapter(Boolean.TYPE, SetsKt.emptySet(), "enabled");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Boolean::c…tySet(),\n      \"enabled\")");
        this.booleanAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "baseUrl");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…tySet(),\n      \"baseUrl\")");
        this.stringAdapter = adapter2;
        JsonAdapter<Long> adapter3 = moshi.adapter(Long.TYPE, SetsKt.emptySet(), "retryInterval");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Long::clas…),\n      \"retryInterval\")");
        this.longAdapter = adapter3;
        JsonAdapter<Integer> adapter4 = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "maxConnectionAttempts");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Int::class… \"maxConnectionAttempts\")");
        this.intAdapter = adapter4;
        JsonAdapter<TimeUnit> adapter5 = moshi.adapter(TimeUnit.class, SetsKt.emptySet(), "timeUnit");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(TimeUnit::…  emptySet(), \"timeUnit\")");
        this.timeUnitAdapter = adapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(38);
        sb.append("GeneratedJsonAdapter(").append("RealtimeSettings").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0115, code lost:
        r15 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0117, code lost:
        r14 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0119, code lost:
        r13 = r19;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zendesk.conversationkit.android.model.RealtimeSettings fromJson(com.squareup.moshi.JsonReader r35) {
        /*
            r34 = this;
            r0 = r34
            r1 = r35
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r35.beginObject()
            r3 = -1
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0015:
            boolean r9 = r35.hasNext()
            java.lang.String r10 = "userId"
            java.lang.String r11 = "appId"
            java.lang.String r12 = "connectionDelay"
            java.lang.String r2 = "maxConnectionAttempts"
            r17 = r15
            java.lang.String r15 = "retryInterval"
            r18 = r14
            java.lang.String r14 = "baseUrl"
            r19 = r13
            java.lang.String r13 = "enabled"
            if (r9 == 0) goto L_0x011d
            com.squareup.moshi.JsonReader$Options r9 = r0.options
            int r9 = r1.selectName(r9)
            switch(r9) {
                case -1: goto L_0x010f;
                case 0: goto L_0x00f6;
                case 1: goto L_0x00dd;
                case 2: goto L_0x00c4;
                case 3: goto L_0x00ac;
                case 4: goto L_0x0092;
                case 5: goto L_0x0071;
                case 6: goto L_0x0055;
                case 7: goto L_0x003b;
                default: goto L_0x0039;
            }
        L_0x0039:
            goto L_0x0115
        L_0x003b:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r2
            java.lang.String r15 = (java.lang.String) r15
            if (r15 == 0) goto L_0x0048
            goto L_0x0117
        L_0x0048:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"userId\",…        \"userId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0055:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r14 = r2
            java.lang.String r14 = (java.lang.String) r14
            if (r14 == 0) goto L_0x0064
            r15 = r17
            goto L_0x0119
        L_0x0064:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r11, r1)
            java.lang.String r2 = "unexpectedNull(\"appId\", …pId\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0071:
            com.squareup.moshi.JsonAdapter<java.util.concurrent.TimeUnit> r2 = r0.timeUnitAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r2
            java.util.concurrent.TimeUnit r13 = (java.util.concurrent.TimeUnit) r13
            if (r13 == 0) goto L_0x0083
            r3 = r3 & -33
            r15 = r17
            r14 = r18
            goto L_0x0015
        L_0x0083:
            java.lang.String r2 = "timeUnit"
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"timeUnit…      \"timeUnit\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0092:
            com.squareup.moshi.JsonAdapter<java.lang.Long> r2 = r0.longAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.lang.Long r8 = (java.lang.Long) r8
            if (r8 == 0) goto L_0x009f
            goto L_0x0115
        L_0x009f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"connecti…connectionDelay\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00ac:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r6 = r0.intAdapter
            java.lang.Object r6 = r6.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 == 0) goto L_0x00b7
            goto L_0x0115
        L_0x00b7:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"maxConne…nectionAttempts\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00c4:
            com.squareup.moshi.JsonAdapter<java.lang.Long> r2 = r0.longAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.Long r5 = (java.lang.Long) r5
            if (r5 == 0) goto L_0x00d0
            goto L_0x0115
        L_0x00d0:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"retryInt… \"retryInterval\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00dd:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x00e9
            goto L_0x0115
        L_0x00e9:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"baseUrl\"…       \"baseUrl\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00f6:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.booleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            if (r4 == 0) goto L_0x0102
            goto L_0x0115
        L_0x0102:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"enabled\"…       \"enabled\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x010f:
            r35.skipName()
            r35.skipValue()
        L_0x0115:
            r15 = r17
        L_0x0117:
            r14 = r18
        L_0x0119:
            r13 = r19
            goto L_0x0015
        L_0x011d:
            r35.endObject()
            java.lang.String r9 = "missingProperty(\"enabled\", \"enabled\", reader)"
            r0 = -33
            if (r3 != r0) goto L_0x01b1
            zendesk.conversationkit.android.model.RealtimeSettings r0 = new zendesk.conversationkit.android.model.RealtimeSettings
            if (r4 == 0) goto L_0x01a7
            boolean r3 = r4.booleanValue()
            if (r7 == 0) goto L_0x019b
            if (r5 == 0) goto L_0x018f
            long r13 = r5.longValue()
            if (r6 == 0) goto L_0x0183
            int r2 = r6.intValue()
            if (r8 == 0) goto L_0x0177
            long r15 = r8.longValue()
            if (r19 == 0) goto L_0x016f
            if (r18 == 0) goto L_0x0163
            if (r17 == 0) goto L_0x0157
            r5 = r0
            r6 = r3
            r8 = r13
            r10 = r2
            r11 = r15
            r13 = r19
            r14 = r18
            r15 = r17
            r5.<init>(r6, r7, r8, r10, r11, r13, r14, r15)
            return r0
        L_0x0157:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r10, r10, r1)
            java.lang.String r1 = "missingProperty(\"userId\", \"userId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0163:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r11, r11, r1)
            java.lang.String r1 = "missingProperty(\"appId\", \"appId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x016f:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type java.util.concurrent.TimeUnit"
            r0.<init>(r1)
            throw r0
        L_0x0177:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r12, r12, r1)
            java.lang.String r1 = "missingProperty(\"connect…connectionDelay\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0183:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            java.lang.String r1 = "missingProperty(\"maxConn…nectionAttempts\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x018f:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r15, r15, r1)
            java.lang.String r1 = "missingProperty(\"retryIn… \"retryInterval\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x019b:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r14, r14, r1)
            java.lang.String r1 = "missingProperty(\"baseUrl\", \"baseUrl\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x01a7:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r13, r13, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r9)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x01b1:
            r0 = r34
            r20 = r9
            java.lang.reflect.Constructor<zendesk.conversationkit.android.model.RealtimeSettings> r9 = r0.constructorRef
            r21 = 9
            r22 = 8
            r23 = 7
            r24 = 6
            r25 = 5
            r26 = 4
            r27 = 3
            r28 = 2
            r29 = 1
            r30 = 0
            r31 = r13
            r13 = 10
            if (r9 != 0) goto L_0x020b
            java.lang.Class<zendesk.conversationkit.android.model.RealtimeSettings> r9 = zendesk.conversationkit.android.model.RealtimeSettings.class
            r32 = r14
            java.lang.Class[] r14 = new java.lang.Class[r13]
            java.lang.Class r33 = java.lang.Boolean.TYPE
            r14[r30] = r33
            java.lang.Class<java.lang.String> r33 = java.lang.String.class
            r14[r29] = r33
            java.lang.Class r33 = java.lang.Long.TYPE
            r14[r28] = r33
            java.lang.Class r33 = java.lang.Integer.TYPE
            r14[r27] = r33
            java.lang.Class r33 = java.lang.Long.TYPE
            r14[r26] = r33
            java.lang.Class<java.util.concurrent.TimeUnit> r33 = java.util.concurrent.TimeUnit.class
            r14[r25] = r33
            java.lang.Class<java.lang.String> r33 = java.lang.String.class
            r14[r24] = r33
            java.lang.Class<java.lang.String> r33 = java.lang.String.class
            r14[r23] = r33
            java.lang.Class r33 = java.lang.Integer.TYPE
            r14[r22] = r33
            java.lang.Class<?> r33 = com.squareup.moshi.internal.Util.DEFAULT_CONSTRUCTOR_MARKER
            r14[r21] = r33
            java.lang.reflect.Constructor r9 = r9.getDeclaredConstructor(r14)
            r0.constructorRef = r9
            java.lang.String r14 = "RealtimeSettings::class.…his.constructorRef = it }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r14)
            goto L_0x020d
        L_0x020b:
            r32 = r14
        L_0x020d:
            java.lang.Object[] r13 = new java.lang.Object[r13]
            if (r4 == 0) goto L_0x02ac
            boolean r4 = r4.booleanValue()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r13[r30] = r4
            if (r7 == 0) goto L_0x029e
            r13[r29] = r7
            if (r5 == 0) goto L_0x0292
            long r4 = r5.longValue()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r13[r28] = r4
            if (r6 == 0) goto L_0x0286
            int r2 = r6.intValue()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r13[r27] = r2
            if (r8 == 0) goto L_0x027a
            long r4 = r8.longValue()
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r13[r26] = r2
            r13[r25] = r19
            if (r18 == 0) goto L_0x026e
            r13[r24] = r18
            if (r17 == 0) goto L_0x0262
            r13[r23] = r17
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r13[r22] = r1
            r1 = 0
            r13[r21] = r1
            java.lang.Object r1 = r9.newInstance(r13)
            java.lang.String r2 = "localConstructor.newInst…torMarker */ null\n      )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            zendesk.conversationkit.android.model.RealtimeSettings r1 = (zendesk.conversationkit.android.model.RealtimeSettings) r1
            return r1
        L_0x0262:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r10, r1)
            java.lang.String r2 = "missingProperty(\"userId\", \"userId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x026e:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r11, r11, r1)
            java.lang.String r2 = "missingProperty(\"appId\", \"appId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x027a:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r12, r12, r1)
            java.lang.String r2 = "missingProperty(\"connect…y\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0286:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            java.lang.String r2 = "missingProperty(\"maxConn…nectionAttempts\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0292:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r15, r1)
            java.lang.String r2 = "missingProperty(\"retryIn… \"retryInterval\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x029e:
            r2 = r32
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            java.lang.String r2 = "missingProperty(\"baseUrl\", \"baseUrl\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x02ac:
            r2 = r31
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            r2 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.model.RealtimeSettingsJsonAdapter.fromJson(com.squareup.moshi.JsonReader):zendesk.conversationkit.android.model.RealtimeSettings");
    }

    public void toJson(JsonWriter jsonWriter, RealtimeSettings realtimeSettings) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (realtimeSettings != null) {
            jsonWriter.beginObject();
            jsonWriter.name("enabled");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(realtimeSettings.getEnabled()));
            jsonWriter.name("baseUrl");
            this.stringAdapter.toJson(jsonWriter, realtimeSettings.getBaseUrl());
            jsonWriter.name("retryInterval");
            this.longAdapter.toJson(jsonWriter, Long.valueOf(realtimeSettings.getRetryInterval()));
            jsonWriter.name("maxConnectionAttempts");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(realtimeSettings.getMaxConnectionAttempts()));
            jsonWriter.name("connectionDelay");
            this.longAdapter.toJson(jsonWriter, Long.valueOf(realtimeSettings.getConnectionDelay()));
            jsonWriter.name("timeUnit");
            this.timeUnitAdapter.toJson(jsonWriter, realtimeSettings.getTimeUnit());
            jsonWriter.name("appId");
            this.stringAdapter.toJson(jsonWriter, realtimeSettings.getAppId());
            jsonWriter.name("userId");
            this.stringAdapter.toJson(jsonWriter, realtimeSettings.getUserId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

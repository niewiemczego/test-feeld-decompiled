package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lzendesk/conversationkit/android/model/UserJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/User;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "listOfConversationAdapter", "", "Lzendesk/conversationkit/android/model/Conversation;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "realtimeSettingsAdapter", "Lzendesk/conversationkit/android/model/RealtimeSettings;", "stringAdapter", "typingSettingsAdapter", "Lzendesk/conversationkit/android/model/TypingSettings;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserJsonAdapter.kt */
public final class UserJsonAdapter extends JsonAdapter<User> {
    private volatile Constructor<User> constructorRef;
    private final JsonAdapter<List<Conversation>> listOfConversationAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<RealtimeSettings> realtimeSettingsAdapter;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<TypingSettings> typingSettingsAdapter;

    public UserJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "externalId", "givenName", "surname", "email", "locale", "signedUpAt", "conversations", "realtimeSettings", "typingSettings", "sessionToken", "jwt");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"id\", \"externalId\", \"…\", \"sessionToken\", \"jwt\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "externalId");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…emptySet(), \"externalId\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<List<Conversation>> adapter3 = moshi.adapter(Types.newParameterizedType(List.class, Conversation.class), SetsKt.emptySet(), "conversations");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP…tySet(), \"conversations\")");
        this.listOfConversationAdapter = adapter3;
        JsonAdapter<RealtimeSettings> adapter4 = moshi.adapter(RealtimeSettings.class, SetsKt.emptySet(), "realtimeSettings");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(RealtimeSe…et(), \"realtimeSettings\")");
        this.realtimeSettingsAdapter = adapter4;
        JsonAdapter<TypingSettings> adapter5 = moshi.adapter(TypingSettings.class, SetsKt.emptySet(), "typingSettings");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(TypingSett…ySet(), \"typingSettings\")");
        this.typingSettingsAdapter = adapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(26);
        sb.append("GeneratedJsonAdapter(").append("User").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0105, code lost:
        r15 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0107, code lost:
        r11 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0109, code lost:
        r10 = r19;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zendesk.conversationkit.android.model.User fromJson(com.squareup.moshi.JsonReader r40) {
        /*
            r39 = this;
            r0 = r39
            r1 = r40
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r40.beginObject()
            r3 = -1
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x001a:
            boolean r4 = r40.hasNext()
            java.lang.String r2 = "typingSettings"
            r17 = r15
            java.lang.String r15 = "realtimeSettings"
            r18 = r11
            java.lang.String r11 = "conversations"
            r19 = r10
            java.lang.String r10 = "id"
            if (r4 == 0) goto L_0x010d
            com.squareup.moshi.JsonReader$Options r4 = r0.options
            int r4 = r1.selectName(r4)
            switch(r4) {
                case -1: goto L_0x00ff;
                case 0: goto L_0x00e6;
                case 1: goto L_0x00dc;
                case 2: goto L_0x00d2;
                case 3: goto L_0x00c8;
                case 4: goto L_0x00be;
                case 5: goto L_0x00af;
                case 6: goto L_0x00a3;
                case 7: goto L_0x0089;
                case 8: goto L_0x006f;
                case 9: goto L_0x0055;
                case 10: goto L_0x0048;
                case 11: goto L_0x003a;
                default: goto L_0x0038;
            }
        L_0x0038:
            goto L_0x0105
        L_0x003a:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r16 = r2
            java.lang.String r16 = (java.lang.String) r16
            r3 = r3 & -2049(0xfffffffffffff7ff, float:NaN)
            goto L_0x0105
        L_0x0048:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r2
            java.lang.String r15 = (java.lang.String) r15
            r3 = r3 & -1025(0xfffffffffffffbff, float:NaN)
            goto L_0x0107
        L_0x0055:
            com.squareup.moshi.JsonAdapter<zendesk.conversationkit.android.model.TypingSettings> r4 = r0.typingSettingsAdapter
            java.lang.Object r4 = r4.fromJson((com.squareup.moshi.JsonReader) r1)
            r14 = r4
            zendesk.conversationkit.android.model.TypingSettings r14 = (zendesk.conversationkit.android.model.TypingSettings) r14
            if (r14 == 0) goto L_0x0062
            goto L_0x0105
        L_0x0062:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"typingSe…\"typingSettings\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x006f:
            com.squareup.moshi.JsonAdapter<zendesk.conversationkit.android.model.RealtimeSettings> r2 = r0.realtimeSettingsAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r2
            zendesk.conversationkit.android.model.RealtimeSettings r13 = (zendesk.conversationkit.android.model.RealtimeSettings) r13
            if (r13 == 0) goto L_0x007c
            goto L_0x0105
        L_0x007c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"realtime…ealtimeSettings\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0089:
            com.squareup.moshi.JsonAdapter<java.util.List<zendesk.conversationkit.android.model.Conversation>> r2 = r0.listOfConversationAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r2
            java.util.List r12 = (java.util.List) r12
            if (r12 == 0) goto L_0x0096
            goto L_0x0105
        L_0x0096:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r11, r1)
            java.lang.String r2 = "unexpectedNull(\"conversa… \"conversations\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00a3:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11
            r15 = r17
            goto L_0x0109
        L_0x00af:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            r15 = r17
            r11 = r18
            goto L_0x001a
        L_0x00be:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x0105
        L_0x00c8:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0105
        L_0x00d2:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0105
        L_0x00dc:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0105
        L_0x00e6:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x00f2
            goto L_0x0105
        L_0x00f2:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"id\", \"id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00ff:
            r40.skipName()
            r40.skipValue()
        L_0x0105:
            r15 = r17
        L_0x0107:
            r11 = r18
        L_0x0109:
            r10 = r19
            goto L_0x001a
        L_0x010d:
            r40.endObject()
            r4 = -3073(0xfffffffffffff3ff, float:NaN)
            java.lang.String r0 = "missingProperty(\"convers… \"conversations\", reader)"
            r20 = r10
            java.lang.String r10 = "missingProperty(\"id\", \"id\", reader)"
            if (r3 != r4) goto L_0x015d
            zendesk.conversationkit.android.model.User r3 = new zendesk.conversationkit.android.model.User
            if (r5 == 0) goto L_0x0151
            if (r12 == 0) goto L_0x0147
            if (r13 == 0) goto L_0x013b
            if (r14 == 0) goto L_0x012f
            r4 = r3
            r10 = r19
            r11 = r18
            r15 = r17
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r3
        L_0x012f:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            java.lang.String r1 = "missingProperty(\"typingS…\"typingSettings\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x013b:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r15, r15, r1)
            java.lang.String r1 = "missingProperty(\"realtim…ealtimeSettings\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0147:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r11, r11, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0151:
            r0 = r20
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r10)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x015d:
            r4 = r39
            r21 = r20
            r20 = r10
            r10 = r0
            java.lang.reflect.Constructor<zendesk.conversationkit.android.model.User> r0 = r4.constructorRef
            r22 = 13
            r23 = 12
            r24 = 11
            r25 = 10
            r26 = 9
            r27 = 8
            r28 = 7
            r29 = 6
            r30 = 5
            r31 = 4
            r32 = 3
            r33 = 2
            r34 = 1
            r35 = 0
            r36 = r10
            r10 = 14
            if (r0 != 0) goto L_0x01d2
            java.lang.Class<zendesk.conversationkit.android.model.User> r0 = zendesk.conversationkit.android.model.User.class
            r37 = r11
            java.lang.Class[] r11 = new java.lang.Class[r10]
            java.lang.Class<java.lang.String> r38 = java.lang.String.class
            r11[r35] = r38
            java.lang.Class<java.lang.String> r38 = java.lang.String.class
            r11[r34] = r38
            java.lang.Class<java.lang.String> r38 = java.lang.String.class
            r11[r33] = r38
            java.lang.Class<java.lang.String> r38 = java.lang.String.class
            r11[r32] = r38
            java.lang.Class<java.lang.String> r38 = java.lang.String.class
            r11[r31] = r38
            java.lang.Class<java.lang.String> r38 = java.lang.String.class
            r11[r30] = r38
            java.lang.Class<java.lang.String> r38 = java.lang.String.class
            r11[r29] = r38
            java.lang.Class<java.util.List> r38 = java.util.List.class
            r11[r28] = r38
            java.lang.Class<zendesk.conversationkit.android.model.RealtimeSettings> r38 = zendesk.conversationkit.android.model.RealtimeSettings.class
            r11[r27] = r38
            java.lang.Class<zendesk.conversationkit.android.model.TypingSettings> r38 = zendesk.conversationkit.android.model.TypingSettings.class
            r11[r26] = r38
            java.lang.Class<java.lang.String> r38 = java.lang.String.class
            r11[r25] = r38
            java.lang.Class<java.lang.String> r38 = java.lang.String.class
            r11[r24] = r38
            java.lang.Class r38 = java.lang.Integer.TYPE
            r11[r23] = r38
            java.lang.Class<?> r38 = com.squareup.moshi.internal.Util.DEFAULT_CONSTRUCTOR_MARKER
            r11[r22] = r38
            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r11)
            r4.constructorRef = r0
            java.lang.String r11 = "User::class.java.getDecl…his.constructorRef = it }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r11)
            goto L_0x01d4
        L_0x01d2:
            r37 = r11
        L_0x01d4:
            java.lang.Object[] r10 = new java.lang.Object[r10]
            if (r5 == 0) goto L_0x0231
            r10[r35] = r5
            r10[r34] = r6
            r10[r33] = r7
            r10[r32] = r8
            r10[r31] = r9
            r10[r30] = r19
            r10[r29] = r18
            if (r12 == 0) goto L_0x0223
            r10[r28] = r12
            if (r13 == 0) goto L_0x0217
            r10[r27] = r13
            if (r14 == 0) goto L_0x020b
            r10[r26] = r14
            r10[r25] = r17
            r10[r24] = r16
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r10[r23] = r1
            r1 = 0
            r10[r22] = r1
            java.lang.Object r0 = r0.newInstance(r10)
            java.lang.String r1 = "localConstructor.newInst…torMarker */ null\n      )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            zendesk.conversationkit.android.model.User r0 = (zendesk.conversationkit.android.model.User) r0
            return r0
        L_0x020b:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            java.lang.String r1 = "missingProperty(\"typingS…\"typingSettings\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0217:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r15, r15, r1)
            java.lang.String r1 = "missingProperty(\"realtim…s\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0223:
            r0 = r37
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            r1 = r36
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0231:
            r0 = r21
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            r1 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.model.UserJsonAdapter.fromJson(com.squareup.moshi.JsonReader):zendesk.conversationkit.android.model.User");
    }

    public void toJson(JsonWriter jsonWriter, User user) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (user != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, user.getId());
            jsonWriter.name("externalId");
            this.nullableStringAdapter.toJson(jsonWriter, user.getExternalId());
            jsonWriter.name("givenName");
            this.nullableStringAdapter.toJson(jsonWriter, user.getGivenName());
            jsonWriter.name("surname");
            this.nullableStringAdapter.toJson(jsonWriter, user.getSurname());
            jsonWriter.name("email");
            this.nullableStringAdapter.toJson(jsonWriter, user.getEmail());
            jsonWriter.name("locale");
            this.nullableStringAdapter.toJson(jsonWriter, user.getLocale());
            jsonWriter.name("signedUpAt");
            this.nullableStringAdapter.toJson(jsonWriter, user.getSignedUpAt());
            jsonWriter.name("conversations");
            this.listOfConversationAdapter.toJson(jsonWriter, user.getConversations());
            jsonWriter.name("realtimeSettings");
            this.realtimeSettingsAdapter.toJson(jsonWriter, user.getRealtimeSettings());
            jsonWriter.name("typingSettings");
            this.typingSettingsAdapter.toJson(jsonWriter, user.getTypingSettings());
            jsonWriter.name("sessionToken");
            this.nullableStringAdapter.toJson(jsonWriter, user.getSessionToken$zendesk_conversationkit_conversationkit_android());
            jsonWriter.name("jwt");
            this.nullableStringAdapter.toJson(jsonWriter, user.getJwt$zendesk_conversationkit_conversationkit_android());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

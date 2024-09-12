package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.time.LocalDateTime;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lzendesk/conversationkit/android/model/ConversationJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/Conversation;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "conversationTypeAdapter", "Lzendesk/conversationkit/android/model/ConversationType;", "listOfMessageAdapter", "", "Lzendesk/conversationkit/android/model/Message;", "listOfParticipantAdapter", "Lzendesk/conversationkit/android/model/Participant;", "listOfStringAdapter", "", "nullableDoubleAdapter", "", "nullableLocalDateTimeAdapter", "Ljava/time/LocalDateTime;", "nullableParticipantAdapter", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationJsonAdapter.kt */
public final class ConversationJsonAdapter extends JsonAdapter<Conversation> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<ConversationType> conversationTypeAdapter;
    private final JsonAdapter<List<Message>> listOfMessageAdapter;
    private final JsonAdapter<List<Participant>> listOfParticipantAdapter;
    private final JsonAdapter<List<String>> listOfStringAdapter;
    private final JsonAdapter<Double> nullableDoubleAdapter;
    private final JsonAdapter<LocalDateTime> nullableLocalDateTimeAdapter;
    private final JsonAdapter<Participant> nullableParticipantAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConversationJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "displayName", "description", "iconUrl", "type", "isDefault", "business", "businessLastRead", "lastUpdatedAt", "myself", "participants", "messages", "hasPrevious");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"id\", \"displayName\",\n…messages\", \"hasPrevious\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "displayName");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…mptySet(), \"displayName\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<ConversationType> adapter3 = moshi.adapter(ConversationType.class, SetsKt.emptySet(), "type");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Conversati…java, emptySet(), \"type\")");
        this.conversationTypeAdapter = adapter3;
        JsonAdapter<Boolean> adapter4 = moshi.adapter(Boolean.TYPE, SetsKt.emptySet(), "isDefault");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Boolean::c…Set(),\n      \"isDefault\")");
        this.booleanAdapter = adapter4;
        JsonAdapter<List<String>> adapter5 = moshi.adapter(Types.newParameterizedType(List.class, String.class), SetsKt.emptySet(), "business");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Types.newP…ySet(),\n      \"business\")");
        this.listOfStringAdapter = adapter5;
        JsonAdapter<LocalDateTime> adapter6 = moshi.adapter(LocalDateTime.class, SetsKt.emptySet(), "businessLastRead");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(LocalDateT…et(), \"businessLastRead\")");
        this.nullableLocalDateTimeAdapter = adapter6;
        JsonAdapter<Double> adapter7 = moshi.adapter(Double.class, SetsKt.emptySet(), "lastUpdatedAt");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(Double::cl…tySet(), \"lastUpdatedAt\")");
        this.nullableDoubleAdapter = adapter7;
        JsonAdapter<Participant> adapter8 = moshi.adapter(Participant.class, SetsKt.emptySet(), "myself");
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(Participan…va, emptySet(), \"myself\")");
        this.nullableParticipantAdapter = adapter8;
        JsonAdapter<List<Participant>> adapter9 = moshi.adapter(Types.newParameterizedType(List.class, Participant.class), SetsKt.emptySet(), "participants");
        Intrinsics.checkNotNullExpressionValue(adapter9, "moshi.adapter(Types.newP…ptySet(), \"participants\")");
        this.listOfParticipantAdapter = adapter9;
        JsonAdapter<List<Message>> adapter10 = moshi.adapter(Types.newParameterizedType(List.class, Message.class), SetsKt.emptySet(), "messages");
        Intrinsics.checkNotNullExpressionValue(adapter10, "moshi.adapter(Types.newP…ySet(),\n      \"messages\")");
        this.listOfMessageAdapter = adapter10;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(34);
        sb.append("GeneratedJsonAdapter(").append("Conversation").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0166, code lost:
        r13 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0168, code lost:
        r12 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x016a, code lost:
        r11 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x016c, code lost:
        r7 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x016e, code lost:
        r6 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0170, code lost:
        r5 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0172, code lost:
        r3 = r22;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zendesk.conversationkit.android.model.Conversation fromJson(com.squareup.moshi.JsonReader r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r25.beginObject()
            r2 = 0
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r10 = r8
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
        L_0x0019:
            boolean r9 = r25.hasNext()
            r16 = r13
            java.lang.String r13 = "hasPrevious"
            r17 = r12
            java.lang.String r12 = "messages"
            r18 = r11
            java.lang.String r11 = "participants"
            r19 = r7
            java.lang.String r7 = "business"
            r20 = r6
            java.lang.String r6 = "isDefault"
            r21 = r5
            java.lang.String r5 = "type"
            r22 = r3
            java.lang.String r3 = "id"
            if (r9 == 0) goto L_0x0176
            com.squareup.moshi.JsonReader$Options r9 = r0.options
            int r9 = r1.selectName(r9)
            switch(r9) {
                case -1: goto L_0x0160;
                case 0: goto L_0x0148;
                case 1: goto L_0x0134;
                case 2: goto L_0x0122;
                case 3: goto L_0x0112;
                case 4: goto L_0x00f9;
                case 5: goto L_0x00e0;
                case 6: goto L_0x00c6;
                case 7: goto L_0x00b7;
                case 8: goto L_0x00aa;
                case 9: goto L_0x009f;
                case 10: goto L_0x0085;
                case 11: goto L_0x006b;
                case 12: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x0166
        L_0x0047:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r3 = r0.booleanAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            if (r3 == 0) goto L_0x005e
            r13 = r16
            r12 = r17
            r11 = r18
            r7 = r19
            r6 = r20
            r5 = r21
            goto L_0x0019
        L_0x005e:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"hasPrevi…\", \"hasPrevious\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x006b:
            com.squareup.moshi.JsonAdapter<java.util.List<zendesk.conversationkit.android.model.Message>> r3 = r0.listOfMessageAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r3
            java.util.List r15 = (java.util.List) r15
            if (r15 == 0) goto L_0x0078
            goto L_0x0166
        L_0x0078:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"messages\", \"messages\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0085:
            com.squareup.moshi.JsonAdapter<java.util.List<zendesk.conversationkit.android.model.Participant>> r3 = r0.listOfParticipantAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r14 = r3
            java.util.List r14 = (java.util.List) r14
            if (r14 == 0) goto L_0x0092
            goto L_0x0166
        L_0x0092:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r11, r1)
            java.lang.String r2 = "unexpectedNull(\"particip…, \"participants\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x009f:
            com.squareup.moshi.JsonAdapter<zendesk.conversationkit.android.model.Participant> r3 = r0.nullableParticipantAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r3
            zendesk.conversationkit.android.model.Participant r13 = (zendesk.conversationkit.android.model.Participant) r13
            goto L_0x0168
        L_0x00aa:
            com.squareup.moshi.JsonAdapter<java.lang.Double> r3 = r0.nullableDoubleAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r3
            java.lang.Double r12 = (java.lang.Double) r12
            r13 = r16
            goto L_0x016a
        L_0x00b7:
            com.squareup.moshi.JsonAdapter<java.time.LocalDateTime> r3 = r0.nullableLocalDateTimeAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r3
            java.time.LocalDateTime r11 = (java.time.LocalDateTime) r11
            r13 = r16
            r12 = r17
            goto L_0x016c
        L_0x00c6:
            com.squareup.moshi.JsonAdapter<java.util.List<java.lang.String>> r3 = r0.listOfStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r3
            java.util.List r10 = (java.util.List) r10
            if (r10 == 0) goto L_0x00d3
            goto L_0x0166
        L_0x00d3:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r7, r7, r1)
            java.lang.String r2 = "unexpectedNull(\"business\", \"business\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00e0:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.booleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            if (r2 == 0) goto L_0x00ec
            goto L_0x0166
        L_0x00ec:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r6, r6, r1)
            java.lang.String r2 = "unexpectedNull(\"isDefaul…     \"isDefault\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00f9:
            com.squareup.moshi.JsonAdapter<zendesk.conversationkit.android.model.ConversationType> r3 = r0.conversationTypeAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r3
            zendesk.conversationkit.android.model.ConversationType r8 = (zendesk.conversationkit.android.model.ConversationType) r8
            if (r8 == 0) goto L_0x0105
            goto L_0x0166
        L_0x0105:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r5, r5, r1)
            java.lang.String r2 = "unexpectedNull(\"type\",\n            \"type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0112:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r3
            java.lang.String r7 = (java.lang.String) r7
            r13 = r16
            r12 = r17
            r11 = r18
            goto L_0x016e
        L_0x0122:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r3
            java.lang.String r6 = (java.lang.String) r6
            r13 = r16
            r12 = r17
            r11 = r18
            r7 = r19
            goto L_0x0170
        L_0x0134:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r3
            java.lang.String r5 = (java.lang.String) r5
            r13 = r16
            r12 = r17
            r11 = r18
            r7 = r19
            r6 = r20
            goto L_0x0172
        L_0x0148:
            com.squareup.moshi.JsonAdapter<java.lang.String> r4 = r0.stringAdapter
            java.lang.Object r4 = r4.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x0153
            goto L_0x0166
        L_0x0153:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r3, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"id\", \"id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0160:
            r25.skipName()
            r25.skipValue()
        L_0x0166:
            r13 = r16
        L_0x0168:
            r12 = r17
        L_0x016a:
            r11 = r18
        L_0x016c:
            r7 = r19
        L_0x016e:
            r6 = r20
        L_0x0170:
            r5 = r21
        L_0x0172:
            r3 = r22
            goto L_0x0019
        L_0x0176:
            r25.endObject()
            zendesk.conversationkit.android.model.Conversation r23 = new zendesk.conversationkit.android.model.Conversation
            if (r4 == 0) goto L_0x01ed
            if (r8 == 0) goto L_0x01e1
            if (r2 == 0) goto L_0x01d5
            boolean r9 = r2.booleanValue()
            if (r10 == 0) goto L_0x01c9
            if (r14 == 0) goto L_0x01bd
            if (r15 == 0) goto L_0x01b1
            if (r22 == 0) goto L_0x01a5
            boolean r1 = r22.booleanValue()
            r3 = r23
            r5 = r21
            r6 = r20
            r7 = r19
            r11 = r18
            r12 = r17
            r13 = r16
            r16 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r23
        L_0x01a5:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r13, r1)
            java.lang.String r2 = "missingProperty(\"hasPrev…ous\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01b1:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r12, r12, r1)
            java.lang.String r2 = "missingProperty(\"messages\", \"messages\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01bd:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r11, r11, r1)
            java.lang.String r2 = "missingProperty(\"partici…nts\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01c9:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r7, r7, r1)
            java.lang.String r2 = "missingProperty(\"business\", \"business\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01d5:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r6, r6, r1)
            java.lang.String r2 = "missingProperty(\"isDefault\", \"isDefault\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01e1:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r5, r5, r1)
            java.lang.String r2 = "missingProperty(\"type\", \"type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01ed:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r3, r3, r1)
            java.lang.String r2 = "missingProperty(\"id\", \"id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.model.ConversationJsonAdapter.fromJson(com.squareup.moshi.JsonReader):zendesk.conversationkit.android.model.Conversation");
    }

    public void toJson(JsonWriter jsonWriter, Conversation conversation) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (conversation != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, conversation.getId());
            jsonWriter.name("displayName");
            this.nullableStringAdapter.toJson(jsonWriter, conversation.getDisplayName());
            jsonWriter.name("description");
            this.nullableStringAdapter.toJson(jsonWriter, conversation.getDescription());
            jsonWriter.name("iconUrl");
            this.nullableStringAdapter.toJson(jsonWriter, conversation.getIconUrl());
            jsonWriter.name("type");
            this.conversationTypeAdapter.toJson(jsonWriter, conversation.getType());
            jsonWriter.name("isDefault");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(conversation.isDefault()));
            jsonWriter.name("business");
            this.listOfStringAdapter.toJson(jsonWriter, conversation.getBusiness());
            jsonWriter.name("businessLastRead");
            this.nullableLocalDateTimeAdapter.toJson(jsonWriter, conversation.getBusinessLastRead());
            jsonWriter.name("lastUpdatedAt");
            this.nullableDoubleAdapter.toJson(jsonWriter, conversation.getLastUpdatedAt());
            jsonWriter.name("myself");
            this.nullableParticipantAdapter.toJson(jsonWriter, conversation.getMyself());
            jsonWriter.name("participants");
            this.listOfParticipantAdapter.toJson(jsonWriter, conversation.getParticipants());
            jsonWriter.name("messages");
            this.listOfMessageAdapter.toJson(jsonWriter, conversation.getMessages());
            jsonWriter.name("hasPrevious");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(conversation.getHasPrevious()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.time.LocalDateTime;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00120\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lzendesk/conversationkit/android/model/MessageJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/Message;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "authorAdapter", "Lzendesk/conversationkit/android/model/Author;", "doubleAdapter", "", "localDateTimeAdapter", "Ljava/time/LocalDateTime;", "messageContentAdapter", "Lzendesk/conversationkit/android/model/MessageContent;", "messageStatusAdapter", "Lzendesk/conversationkit/android/model/MessageStatus;", "nullableLocalDateTimeAdapter", "nullableMapOfStringAnyAdapter", "", "", "", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageJsonAdapter.kt */
public final class MessageJsonAdapter extends JsonAdapter<Message> {
    private final JsonAdapter<Author> authorAdapter;
    private final JsonAdapter<Double> doubleAdapter;
    private final JsonAdapter<LocalDateTime> localDateTimeAdapter;
    private final JsonAdapter<MessageContent> messageContentAdapter;
    private final JsonAdapter<MessageStatus> messageStatusAdapter;
    private final JsonAdapter<LocalDateTime> nullableLocalDateTimeAdapter;
    private final JsonAdapter<Map<String, Object>> nullableMapOfStringAnyAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public MessageJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "author", "status", "created", "received", "beforeTimestamp", "content", TtmlNode.TAG_METADATA, "sourceId", "localId", "payload");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"id\", \"author\", \"stat…ocalId\",\n      \"payload\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<Author> adapter2 = moshi.adapter(Author.class, SetsKt.emptySet(), "author");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Author::cl…ptySet(),\n      \"author\")");
        this.authorAdapter = adapter2;
        JsonAdapter<MessageStatus> adapter3 = moshi.adapter(MessageStatus.class, SetsKt.emptySet(), "status");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(MessageSta…va, emptySet(), \"status\")");
        this.messageStatusAdapter = adapter3;
        JsonAdapter<LocalDateTime> adapter4 = moshi.adapter(LocalDateTime.class, SetsKt.emptySet(), "created");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(LocalDateT…a, emptySet(), \"created\")");
        this.nullableLocalDateTimeAdapter = adapter4;
        JsonAdapter<LocalDateTime> adapter5 = moshi.adapter(LocalDateTime.class, SetsKt.emptySet(), "received");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(LocalDateT…, emptySet(), \"received\")");
        this.localDateTimeAdapter = adapter5;
        JsonAdapter<Double> adapter6 = moshi.adapter(Double.TYPE, SetsKt.emptySet(), "beforeTimestamp");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Double::cl…\n      \"beforeTimestamp\")");
        this.doubleAdapter = adapter6;
        JsonAdapter<MessageContent> adapter7 = moshi.adapter(MessageContent.class, SetsKt.emptySet(), "content");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(MessageCon…a, emptySet(), \"content\")");
        this.messageContentAdapter = adapter7;
        JsonAdapter<Map<String, Object>> adapter8 = moshi.adapter(Types.newParameterizedType(Map.class, String.class, Object.class), SetsKt.emptySet(), TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(Types.newP…, emptySet(), \"metadata\")");
        this.nullableMapOfStringAnyAdapter = adapter8;
        JsonAdapter<String> adapter9 = moshi.adapter(String.class, SetsKt.emptySet(), "sourceId");
        Intrinsics.checkNotNullExpressionValue(adapter9, "moshi.adapter(String::cl…  emptySet(), \"sourceId\")");
        this.nullableStringAdapter = adapter9;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(29);
        sb.append("GeneratedJsonAdapter(").append("Message").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0135, code lost:
        r15 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0137, code lost:
        r13 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0139, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x013b, code lost:
        r7 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x013d, code lost:
        r14 = r20;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zendesk.conversationkit.android.model.Message fromJson(com.squareup.moshi.JsonReader r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r23.beginObject()
            r2 = 0
            r4 = r2
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r11 = r8
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
        L_0x0017:
            boolean r3 = r23.hasNext()
            java.lang.String r9 = "localId"
            java.lang.String r10 = "content"
            r16 = r15
            java.lang.String r15 = "beforeTimestamp"
            r17 = r13
            java.lang.String r13 = "received"
            r18 = r12
            java.lang.String r12 = "status"
            r19 = r7
            java.lang.String r7 = "author"
            r20 = r14
            java.lang.String r14 = "id"
            if (r3 == 0) goto L_0x0141
            com.squareup.moshi.JsonReader$Options r3 = r0.options
            int r3 = r1.selectName(r3)
            switch(r3) {
                case -1: goto L_0x012f;
                case 0: goto L_0x0116;
                case 1: goto L_0x00fd;
                case 2: goto L_0x00e4;
                case 3: goto L_0x00d4;
                case 4: goto L_0x00bb;
                case 5: goto L_0x00a2;
                case 6: goto L_0x0088;
                case 7: goto L_0x0079;
                case 8: goto L_0x006c;
                case 9: goto L_0x004b;
                case 10: goto L_0x0040;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x0135
        L_0x0040:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r3
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x0137
        L_0x004b:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.stringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r14 = r3
            java.lang.String r14 = (java.lang.String) r14
            if (r14 == 0) goto L_0x005f
            r15 = r16
            r13 = r17
            r12 = r18
            r7 = r19
            goto L_0x0017
        L_0x005f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r9, r9, r1)
            java.lang.String r2 = "unexpectedNull(\"localId\"…       \"localId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x006c:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r3
            java.lang.String r13 = (java.lang.String) r13
            r15 = r16
            goto L_0x0139
        L_0x0079:
            com.squareup.moshi.JsonAdapter<java.util.Map<java.lang.String, java.lang.Object>> r3 = r0.nullableMapOfStringAnyAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r3
            java.util.Map r12 = (java.util.Map) r12
            r15 = r16
            r13 = r17
            goto L_0x013b
        L_0x0088:
            com.squareup.moshi.JsonAdapter<zendesk.conversationkit.android.model.MessageContent> r3 = r0.messageContentAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r3
            zendesk.conversationkit.android.model.MessageContent r11 = (zendesk.conversationkit.android.model.MessageContent) r11
            if (r11 == 0) goto L_0x0095
            goto L_0x0135
        L_0x0095:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"content\", \"content\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00a2:
            com.squareup.moshi.JsonAdapter<java.lang.Double> r2 = r0.doubleAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Double r2 = (java.lang.Double) r2
            if (r2 == 0) goto L_0x00ae
            goto L_0x0135
        L_0x00ae:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"beforeTi…beforeTimestamp\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00bb:
            com.squareup.moshi.JsonAdapter<java.time.LocalDateTime> r3 = r0.localDateTimeAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r3
            java.time.LocalDateTime r8 = (java.time.LocalDateTime) r8
            if (r8 == 0) goto L_0x00c7
            goto L_0x0135
        L_0x00c7:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"received\", \"received\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00d4:
            com.squareup.moshi.JsonAdapter<java.time.LocalDateTime> r3 = r0.nullableLocalDateTimeAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r3
            java.time.LocalDateTime r7 = (java.time.LocalDateTime) r7
            r15 = r16
            r13 = r17
            r12 = r18
            goto L_0x013d
        L_0x00e4:
            com.squareup.moshi.JsonAdapter<zendesk.conversationkit.android.model.MessageStatus> r3 = r0.messageStatusAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r3
            zendesk.conversationkit.android.model.MessageStatus r6 = (zendesk.conversationkit.android.model.MessageStatus) r6
            if (r6 == 0) goto L_0x00f0
            goto L_0x0135
        L_0x00f0:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"status\",…        \"status\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00fd:
            com.squareup.moshi.JsonAdapter<zendesk.conversationkit.android.model.Author> r3 = r0.authorAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r3
            zendesk.conversationkit.android.model.Author r5 = (zendesk.conversationkit.android.model.Author) r5
            if (r5 == 0) goto L_0x0109
            goto L_0x0135
        L_0x0109:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r7, r7, r1)
            java.lang.String r2 = "unexpectedNull(\"author\",…        \"author\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0116:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.stringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x0122
            goto L_0x0135
        L_0x0122:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"id\", \"id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x012f:
            r23.skipName()
            r23.skipValue()
        L_0x0135:
            r15 = r16
        L_0x0137:
            r13 = r17
        L_0x0139:
            r12 = r18
        L_0x013b:
            r7 = r19
        L_0x013d:
            r14 = r20
            goto L_0x0017
        L_0x0141:
            r23.endObject()
            zendesk.conversationkit.android.model.Message r21 = new zendesk.conversationkit.android.model.Message
            if (r4 == 0) goto L_0x01b1
            if (r5 == 0) goto L_0x01a5
            if (r6 == 0) goto L_0x0199
            if (r8 == 0) goto L_0x018d
            if (r2 == 0) goto L_0x0181
            double r12 = r2.doubleValue()
            if (r11 == 0) goto L_0x0175
            if (r20 == 0) goto L_0x0169
            r3 = r21
            r7 = r19
            r9 = r12
            r12 = r18
            r13 = r17
            r14 = r20
            r15 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15)
            return r21
        L_0x0169:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r9, r9, r1)
            java.lang.String r2 = "missingProperty(\"localId\", \"localId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0175:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r10, r1)
            java.lang.String r2 = "missingProperty(\"content\", \"content\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0181:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r15, r1)
            java.lang.String r2 = "missingProperty(\"beforeT…beforeTimestamp\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x018d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r13, r1)
            java.lang.String r2 = "missingProperty(\"received\", \"received\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0199:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r12, r12, r1)
            java.lang.String r2 = "missingProperty(\"status\", \"status\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01a5:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r7, r7, r1)
            java.lang.String r2 = "missingProperty(\"author\", \"author\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01b1:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r14, r14, r1)
            java.lang.String r2 = "missingProperty(\"id\", \"id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.model.MessageJsonAdapter.fromJson(com.squareup.moshi.JsonReader):zendesk.conversationkit.android.model.Message");
    }

    public void toJson(JsonWriter jsonWriter, Message message) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (message != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, message.getId());
            jsonWriter.name("author");
            this.authorAdapter.toJson(jsonWriter, message.getAuthor());
            jsonWriter.name("status");
            this.messageStatusAdapter.toJson(jsonWriter, message.getStatus());
            jsonWriter.name("created");
            this.nullableLocalDateTimeAdapter.toJson(jsonWriter, message.getCreated());
            jsonWriter.name("received");
            this.localDateTimeAdapter.toJson(jsonWriter, message.getReceived());
            jsonWriter.name("beforeTimestamp");
            this.doubleAdapter.toJson(jsonWriter, Double.valueOf(message.getBeforeTimestamp()));
            jsonWriter.name("content");
            this.messageContentAdapter.toJson(jsonWriter, message.getContent());
            jsonWriter.name(TtmlNode.TAG_METADATA);
            this.nullableMapOfStringAnyAdapter.toJson(jsonWriter, message.getMetadata());
            jsonWriter.name("sourceId");
            this.nullableStringAdapter.toJson(jsonWriter, message.getSourceId());
            jsonWriter.name("localId");
            this.stringAdapter.toJson(jsonWriter, message.getLocalId());
            jsonWriter.name("payload");
            this.nullableStringAdapter.toJson(jsonWriter, message.getPayload());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

package zendesk.messaging.android.push.internal;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lzendesk/messaging/android/push/internal/MessagePayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/messaging/android/push/internal/MessagePayload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "doubleAdapter", "", "nullableLongAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessagePayloadJsonAdapter.kt */
public final class MessagePayloadJsonAdapter extends JsonAdapter<MessagePayload> {
    private final JsonAdapter<Double> doubleAdapter;
    private final JsonAdapter<Long> nullableLongAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public MessagePayloadJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("_id", "authorId", "role", "name", "avatarUrl", "received", "type", "text", "mediaUrl", "mediaType", "mediaSize");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"_id\", \"authorId\", \"r…\"mediaType\", \"mediaSize\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "name");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…      emptySet(), \"name\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<Double> adapter3 = moshi.adapter(Double.TYPE, SetsKt.emptySet(), "received");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Double::cl…ySet(),\n      \"received\")");
        this.doubleAdapter = adapter3;
        JsonAdapter<Long> adapter4 = moshi.adapter(Long.class, SetsKt.emptySet(), "mediaSize");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Long::clas… emptySet(), \"mediaSize\")");
        this.nullableLongAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(36);
        sb.append("GeneratedJsonAdapter(").append("MessagePayload").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0105, code lost:
        r15 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0107, code lost:
        r14 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0109, code lost:
        r13 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x010b, code lost:
        r12 = r19;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zendesk.messaging.android.push.internal.MessagePayload fromJson(com.squareup.moshi.JsonReader r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r22.beginObject()
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
            boolean r3 = r22.hasNext()
            java.lang.String r9 = "_id"
            java.lang.String r10 = "id"
            r16 = r15
            java.lang.String r15 = "type"
            r17 = r14
            java.lang.String r14 = "received"
            r18 = r13
            java.lang.String r13 = "role"
            r19 = r12
            java.lang.String r12 = "authorId"
            if (r3 == 0) goto L_0x010f
            com.squareup.moshi.JsonReader$Options r3 = r0.options
            int r3 = r1.selectName(r3)
            switch(r3) {
                case -1: goto L_0x00ff;
                case 0: goto L_0x00e7;
                case 1: goto L_0x00cf;
                case 2: goto L_0x00b7;
                case 3: goto L_0x00ad;
                case 4: goto L_0x00a3;
                case 5: goto L_0x008c;
                case 6: goto L_0x0073;
                case 7: goto L_0x0063;
                case 8: goto L_0x0054;
                case 9: goto L_0x0047;
                case 10: goto L_0x003c;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x0105
        L_0x003c:
            com.squareup.moshi.JsonAdapter<java.lang.Long> r3 = r0.nullableLongAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r3
            java.lang.Long r15 = (java.lang.Long) r15
            goto L_0x0107
        L_0x0047:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r14 = r3
            java.lang.String r14 = (java.lang.String) r14
            r15 = r16
            goto L_0x0109
        L_0x0054:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r3
            java.lang.String r13 = (java.lang.String) r13
            r15 = r16
            r14 = r17
            goto L_0x010b
        L_0x0063:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r3
            java.lang.String r12 = (java.lang.String) r12
            r15 = r16
            r14 = r17
            r13 = r18
            goto L_0x0017
        L_0x0073:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.stringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r3
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x0080
            goto L_0x0105
        L_0x0080:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"type\", \"type\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x008c:
            com.squareup.moshi.JsonAdapter<java.lang.Double> r2 = r0.doubleAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Double r2 = (java.lang.Double) r2
            if (r2 == 0) goto L_0x0097
            goto L_0x0105
        L_0x0097:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"received…      \"received\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00a3:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r3
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0105
        L_0x00ad:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r3
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0105
        L_0x00b7:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.stringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r3
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x00c3
            goto L_0x0105
        L_0x00c3:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"role\", \"role\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00cf:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.stringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r3
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x00db
            goto L_0x0105
        L_0x00db:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"authorId…      \"authorId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00e7:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.stringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x00f3
            goto L_0x0105
        L_0x00f3:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r9, r1)
            java.lang.String r2 = "unexpectedNull(\"id\", \"_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00ff:
            r22.skipName()
            r22.skipValue()
        L_0x0105:
            r15 = r16
        L_0x0107:
            r14 = r17
        L_0x0109:
            r13 = r18
        L_0x010b:
            r12 = r19
            goto L_0x0017
        L_0x010f:
            r22.endObject()
            zendesk.messaging.android.push.internal.MessagePayload r20 = new zendesk.messaging.android.push.internal.MessagePayload
            if (r4 == 0) goto L_0x0160
            if (r5 == 0) goto L_0x0154
            if (r6 == 0) goto L_0x0148
            if (r2 == 0) goto L_0x013c
            double r9 = r2.doubleValue()
            if (r11 == 0) goto L_0x0130
            r3 = r20
            r12 = r19
            r13 = r18
            r14 = r17
            r15 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15)
            return r20
        L_0x0130:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r15, r1)
            java.lang.String r2 = "missingProperty(\"type\", \"type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x013c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r14, r14, r1)
            java.lang.String r2 = "missingProperty(\"received\", \"received\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0148:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r13, r1)
            java.lang.String r2 = "missingProperty(\"role\", \"role\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0154:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r12, r12, r1)
            java.lang.String r2 = "missingProperty(\"authorId\", \"authorId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0160:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r9, r1)
            java.lang.String r2 = "missingProperty(\"id\", \"_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.push.internal.MessagePayloadJsonAdapter.fromJson(com.squareup.moshi.JsonReader):zendesk.messaging.android.push.internal.MessagePayload");
    }

    public void toJson(JsonWriter jsonWriter, MessagePayload messagePayload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (messagePayload != null) {
            jsonWriter.beginObject();
            jsonWriter.name("_id");
            this.stringAdapter.toJson(jsonWriter, messagePayload.getId());
            jsonWriter.name("authorId");
            this.stringAdapter.toJson(jsonWriter, messagePayload.getAuthorId());
            jsonWriter.name("role");
            this.stringAdapter.toJson(jsonWriter, messagePayload.getRole());
            jsonWriter.name("name");
            this.nullableStringAdapter.toJson(jsonWriter, messagePayload.getName());
            jsonWriter.name("avatarUrl");
            this.nullableStringAdapter.toJson(jsonWriter, messagePayload.getAvatarUrl());
            jsonWriter.name("received");
            this.doubleAdapter.toJson(jsonWriter, Double.valueOf(messagePayload.getReceived()));
            jsonWriter.name("type");
            this.stringAdapter.toJson(jsonWriter, messagePayload.getType());
            jsonWriter.name("text");
            this.nullableStringAdapter.toJson(jsonWriter, messagePayload.getText());
            jsonWriter.name("mediaUrl");
            this.nullableStringAdapter.toJson(jsonWriter, messagePayload.getMediaUrl());
            jsonWriter.name("mediaType");
            this.nullableStringAdapter.toJson(jsonWriter, messagePayload.getMediaType());
            jsonWriter.name("mediaSize");
            this.nullableLongAdapter.toJson(jsonWriter, messagePayload.getMediaSize());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

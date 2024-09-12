package zendesk.conversationkit.android.internal.rest.model;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/MessageFieldDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/MessageFieldDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableIntAdapter", "", "nullableListOfMessageFieldOptionDtoAdapter", "", "Lzendesk/conversationkit/android/internal/rest/model/MessageFieldOptionDto;", "nullableMapOfStringAnyAdapter", "", "", "", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageFieldDtoJsonAdapter.kt */
public final class MessageFieldDtoJsonAdapter extends JsonAdapter<MessageFieldDto> {
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonAdapter<List<MessageFieldOptionDto>> nullableListOfMessageFieldOptionDtoAdapter;
    private final JsonAdapter<Map<String, Object>> nullableMapOfStringAnyAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public MessageFieldDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("_id", "name", "label", "type", TtmlNode.TAG_METADATA, ReactTextInputShadowNode.PROP_PLACEHOLDER, "text", SDKConstants.PARAM_CONTEXT_MIN_SIZE, SDKConstants.PARAM_CONTEXT_MAX_SIZE, "email", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "select", "selectSize");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"_id\", \"name\", \"label…ect\",\n      \"selectSize\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<Map<String, Object>> adapter2 = moshi.adapter(Types.newParameterizedType(Map.class, String.class, Object.class), SetsKt.emptySet(), TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…, emptySet(), \"metadata\")");
        this.nullableMapOfStringAnyAdapter = adapter2;
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, SetsKt.emptySet(), ReactTextInputShadowNode.PROP_PLACEHOLDER);
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(String::cl…mptySet(), \"placeholder\")");
        this.nullableStringAdapter = adapter3;
        JsonAdapter<Integer> adapter4 = moshi.adapter(Integer.class, SetsKt.emptySet(), SDKConstants.PARAM_CONTEXT_MIN_SIZE);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Int::class…   emptySet(), \"minSize\")");
        this.nullableIntAdapter = adapter4;
        JsonAdapter<List<MessageFieldOptionDto>> adapter5 = moshi.adapter(Types.newParameterizedType(List.class, MessageFieldOptionDto.class), SetsKt.emptySet(), SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Types.newP…), emptySet(), \"options\")");
        this.nullableListOfMessageFieldOptionDtoAdapter = adapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(37);
        sb.append("GeneratedJsonAdapter(").append("MessageFieldDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0117, code lost:
        r15 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0119, code lost:
        r14 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x011b, code lost:
        r13 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x011d, code lost:
        r12 = r20;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zendesk.conversationkit.android.internal.rest.model.MessageFieldDto fromJson(com.squareup.moshi.JsonReader r22) {
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
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r16 = r15
        L_0x001b:
            boolean r2 = r22.hasNext()
            java.lang.String r3 = "_id"
            r17 = r15
            java.lang.String r15 = "id"
            r18 = r14
            java.lang.String r14 = "type"
            r19 = r13
            java.lang.String r13 = "label"
            r20 = r12
            java.lang.String r12 = "name"
            if (r2 == 0) goto L_0x0121
            com.squareup.moshi.JsonReader$Options r2 = r0.options
            int r2 = r1.selectName(r2)
            switch(r2) {
                case -1: goto L_0x0111;
                case 0: goto L_0x00f8;
                case 1: goto L_0x00df;
                case 2: goto L_0x00c6;
                case 3: goto L_0x00ad;
                case 4: goto L_0x00a3;
                case 5: goto L_0x0098;
                case 6: goto L_0x008d;
                case 7: goto L_0x0082;
                case 8: goto L_0x0072;
                case 9: goto L_0x0063;
                case 10: goto L_0x0056;
                case 11: goto L_0x004b;
                case 12: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0117
        L_0x003f:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.nullableIntAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r16 = r2
            java.lang.Integer r16 = (java.lang.Integer) r16
            goto L_0x0117
        L_0x004b:
            com.squareup.moshi.JsonAdapter<java.util.List<zendesk.conversationkit.android.internal.rest.model.MessageFieldOptionDto>> r2 = r0.nullableListOfMessageFieldOptionDtoAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r2
            java.util.List r15 = (java.util.List) r15
            goto L_0x0119
        L_0x0056:
            com.squareup.moshi.JsonAdapter<java.util.List<zendesk.conversationkit.android.internal.rest.model.MessageFieldOptionDto>> r2 = r0.nullableListOfMessageFieldOptionDtoAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r14 = r2
            java.util.List r14 = (java.util.List) r14
            r15 = r17
            goto L_0x011b
        L_0x0063:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r2
            java.lang.String r13 = (java.lang.String) r13
            r15 = r17
            r14 = r18
            goto L_0x011d
        L_0x0072:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.nullableIntAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r2
            java.lang.Integer r12 = (java.lang.Integer) r12
            r15 = r17
            r14 = r18
            r13 = r19
            goto L_0x001b
        L_0x0082:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.nullableIntAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            java.lang.Integer r11 = (java.lang.Integer) r11
            goto L_0x0117
        L_0x008d:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x0117
        L_0x0098:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x0117
        L_0x00a3:
            com.squareup.moshi.JsonAdapter<java.util.Map<java.lang.String, java.lang.Object>> r2 = r0.nullableMapOfStringAnyAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.util.Map r8 = (java.util.Map) r8
            goto L_0x0117
        L_0x00ad:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x00b9
            goto L_0x0117
        L_0x00b9:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"type\", \"type\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00c6:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x00d2
            goto L_0x0117
        L_0x00d2:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"label\", …bel\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00df:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x00eb
            goto L_0x0117
        L_0x00eb:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"name\", \"name\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00f8:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x0104
            goto L_0x0117
        L_0x0104:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"id\", \"_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0111:
            r22.skipName()
            r22.skipValue()
        L_0x0117:
            r15 = r17
        L_0x0119:
            r14 = r18
        L_0x011b:
            r13 = r19
        L_0x011d:
            r12 = r20
            goto L_0x001b
        L_0x0121:
            r22.endObject()
            zendesk.conversationkit.android.internal.rest.model.MessageFieldDto r2 = new zendesk.conversationkit.android.internal.rest.model.MessageFieldDto
            if (r4 == 0) goto L_0x015f
            if (r5 == 0) goto L_0x0153
            if (r6 == 0) goto L_0x0147
            if (r7 == 0) goto L_0x013b
            r3 = r2
            r12 = r20
            r13 = r19
            r14 = r18
            r15 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r2
        L_0x013b:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r14, r14, r1)
            java.lang.String r2 = "missingProperty(\"type\", \"type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0147:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r13, r1)
            java.lang.String r2 = "missingProperty(\"label\", \"label\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0153:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r12, r12, r1)
            java.lang.String r2 = "missingProperty(\"name\", \"name\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x015f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r3, r1)
            java.lang.String r2 = "missingProperty(\"id\", \"_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.rest.model.MessageFieldDtoJsonAdapter.fromJson(com.squareup.moshi.JsonReader):zendesk.conversationkit.android.internal.rest.model.MessageFieldDto");
    }

    public void toJson(JsonWriter jsonWriter, MessageFieldDto messageFieldDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (messageFieldDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("_id");
            this.stringAdapter.toJson(jsonWriter, messageFieldDto.getId());
            jsonWriter.name("name");
            this.stringAdapter.toJson(jsonWriter, messageFieldDto.getName());
            jsonWriter.name("label");
            this.stringAdapter.toJson(jsonWriter, messageFieldDto.getLabel());
            jsonWriter.name("type");
            this.stringAdapter.toJson(jsonWriter, messageFieldDto.getType());
            jsonWriter.name(TtmlNode.TAG_METADATA);
            this.nullableMapOfStringAnyAdapter.toJson(jsonWriter, messageFieldDto.getMetadata());
            jsonWriter.name(ReactTextInputShadowNode.PROP_PLACEHOLDER);
            this.nullableStringAdapter.toJson(jsonWriter, messageFieldDto.getPlaceholder());
            jsonWriter.name("text");
            this.nullableStringAdapter.toJson(jsonWriter, messageFieldDto.getText());
            jsonWriter.name(SDKConstants.PARAM_CONTEXT_MIN_SIZE);
            this.nullableIntAdapter.toJson(jsonWriter, messageFieldDto.getMinSize());
            jsonWriter.name(SDKConstants.PARAM_CONTEXT_MAX_SIZE);
            this.nullableIntAdapter.toJson(jsonWriter, messageFieldDto.getMaxSize());
            jsonWriter.name("email");
            this.nullableStringAdapter.toJson(jsonWriter, messageFieldDto.getEmail());
            jsonWriter.name(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
            this.nullableListOfMessageFieldOptionDtoAdapter.toJson(jsonWriter, messageFieldDto.getOptions());
            jsonWriter.name("select");
            this.nullableListOfMessageFieldOptionDtoAdapter.toJson(jsonWriter, messageFieldDto.getSelect());
            jsonWriter.name("selectSize");
            this.nullableIntAdapter.toJson(jsonWriter, messageFieldDto.getSelectSize());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

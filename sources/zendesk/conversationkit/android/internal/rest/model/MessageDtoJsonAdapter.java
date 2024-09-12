package zendesk.conversationkit.android.internal.rest.model;

import com.facebook.GraphRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
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

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%H\u0016J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010+\u001a\u00020\u001bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0001X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0019\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001a0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/MessageDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/MessageDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "doubleAdapter", "", "nullableBooleanAdapter", "", "nullableCoordinatesDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/CoordinatesDto;", "nullableDisplaySettingsDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/DisplaySettingsDto;", "nullableListOfMessageActionDtoAdapter", "", "Lzendesk/conversationkit/android/internal/rest/model/MessageActionDto;", "nullableListOfMessageFieldDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/MessageFieldDto;", "nullableListOfMessageItemDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/MessageItemDto;", "nullableLocationDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/LocationDto;", "nullableLongAdapter", "", "nullableMapOfStringAnyAdapter", "", "", "", "nullableMessageSourceDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/MessageSourceDto;", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageDtoJsonAdapter.kt */
public final class MessageDtoJsonAdapter extends JsonAdapter<MessageDto> {
    private final JsonAdapter<Double> doubleAdapter;
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    private final JsonAdapter<CoordinatesDto> nullableCoordinatesDtoAdapter;
    private final JsonAdapter<DisplaySettingsDto> nullableDisplaySettingsDtoAdapter;
    private final JsonAdapter<List<MessageActionDto>> nullableListOfMessageActionDtoAdapter;
    private final JsonAdapter<List<MessageFieldDto>> nullableListOfMessageFieldDtoAdapter;
    private final JsonAdapter<List<MessageItemDto>> nullableListOfMessageItemDtoAdapter;
    private final JsonAdapter<LocationDto> nullableLocationDtoAdapter;
    private final JsonAdapter<Long> nullableLongAdapter;
    private final JsonAdapter<Map<String, Object>> nullableMapOfStringAnyAdapter;
    private final JsonAdapter<MessageSourceDto> nullableMessageSourceDtoAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public MessageDtoJsonAdapter(Moshi moshi) {
        Moshi moshi2 = moshi;
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        JsonReader.Options of = JsonReader.Options.of("_id", "authorId", "role", "name", "avatarUrl", "received", "type", "text", "textFallback", "altText", "payload", TtmlNode.TAG_METADATA, "mediaUrl", "mediaType", "mediaSize", "coordinates", FirebaseAnalytics.Param.LOCATION, "actions", FirebaseAnalytics.Param.ITEMS, "displaySettings", "blockChatInput", GraphRequest.FIELDS_PARAM, "quotedMessageId", "source");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"_id\", \"authorId\", \"r…otedMessageId\", \"source\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi2.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi2.adapter(String.class, SetsKt.emptySet(), "name");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…      emptySet(), \"name\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<Double> adapter3 = moshi2.adapter(Double.TYPE, SetsKt.emptySet(), "received");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Double::cl…ySet(),\n      \"received\")");
        this.doubleAdapter = adapter3;
        JsonAdapter<Map<String, Object>> adapter4 = moshi2.adapter(Types.newParameterizedType(Map.class, String.class, Object.class), SetsKt.emptySet(), TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Types.newP…, emptySet(), \"metadata\")");
        this.nullableMapOfStringAnyAdapter = adapter4;
        JsonAdapter<Long> adapter5 = moshi2.adapter(Long.class, SetsKt.emptySet(), "mediaSize");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Long::clas… emptySet(), \"mediaSize\")");
        this.nullableLongAdapter = adapter5;
        JsonAdapter<CoordinatesDto> adapter6 = moshi2.adapter(CoordinatesDto.class, SetsKt.emptySet(), "coordinates");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Coordinate…mptySet(), \"coordinates\")");
        this.nullableCoordinatesDtoAdapter = adapter6;
        JsonAdapter<LocationDto> adapter7 = moshi2.adapter(LocationDto.class, SetsKt.emptySet(), FirebaseAnalytics.Param.LOCATION);
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(LocationDt…, emptySet(), \"location\")");
        this.nullableLocationDtoAdapter = adapter7;
        JsonAdapter<List<MessageActionDto>> adapter8 = moshi2.adapter(Types.newParameterizedType(List.class, MessageActionDto.class), SetsKt.emptySet(), "actions");
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(Types.newP…   emptySet(), \"actions\")");
        this.nullableListOfMessageActionDtoAdapter = adapter8;
        JsonAdapter<List<MessageItemDto>> adapter9 = moshi2.adapter(Types.newParameterizedType(List.class, MessageItemDto.class), SetsKt.emptySet(), FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullExpressionValue(adapter9, "moshi.adapter(Types.newP…     emptySet(), \"items\")");
        this.nullableListOfMessageItemDtoAdapter = adapter9;
        JsonAdapter<DisplaySettingsDto> adapter10 = moshi2.adapter(DisplaySettingsDto.class, SetsKt.emptySet(), "displaySettings");
        Intrinsics.checkNotNullExpressionValue(adapter10, "moshi.adapter(DisplaySet…Set(), \"displaySettings\")");
        this.nullableDisplaySettingsDtoAdapter = adapter10;
        JsonAdapter<Boolean> adapter11 = moshi2.adapter(Boolean.class, SetsKt.emptySet(), "blockChatInput");
        Intrinsics.checkNotNullExpressionValue(adapter11, "moshi.adapter(Boolean::c…ySet(), \"blockChatInput\")");
        this.nullableBooleanAdapter = adapter11;
        JsonAdapter<List<MessageFieldDto>> adapter12 = moshi2.adapter(Types.newParameterizedType(List.class, MessageFieldDto.class), SetsKt.emptySet(), GraphRequest.FIELDS_PARAM);
        Intrinsics.checkNotNullExpressionValue(adapter12, "moshi.adapter(Types.newP…    emptySet(), \"fields\")");
        this.nullableListOfMessageFieldDtoAdapter = adapter12;
        JsonAdapter<MessageSourceDto> adapter13 = moshi2.adapter(MessageSourceDto.class, SetsKt.emptySet(), "source");
        Intrinsics.checkNotNullExpressionValue(adapter13, "moshi.adapter(MessageSou…va, emptySet(), \"source\")");
        this.nullableMessageSourceDtoAdapter = adapter13;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("GeneratedJsonAdapter(").append("MessageDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01c2, code lost:
        r15 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01c4, code lost:
        r14 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01c6, code lost:
        r13 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01c8, code lost:
        r12 = r32;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zendesk.conversationkit.android.internal.rest.model.MessageDto fromJson(com.squareup.moshi.JsonReader r35) {
        /*
            r34 = this;
            r0 = r34
            r1 = r35
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r35.beginObject()
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
            r16 = r15
            r17 = r16
            r18 = r17
            r19 = r18
            r20 = r19
            r21 = r20
            r22 = r21
            r23 = r22
            r24 = r23
            r25 = r24
            r26 = r25
            r27 = r26
            r28 = r27
        L_0x0031:
            boolean r3 = r35.hasNext()
            java.lang.String r9 = "_id"
            java.lang.String r10 = "id"
            r29 = r15
            java.lang.String r15 = "type"
            r30 = r14
            java.lang.String r14 = "received"
            r31 = r13
            java.lang.String r13 = "role"
            r32 = r12
            java.lang.String r12 = "authorId"
            if (r3 == 0) goto L_0x01cc
            com.squareup.moshi.JsonReader$Options r3 = r0.options
            int r3 = r1.selectName(r3)
            switch(r3) {
                case -1: goto L_0x01bc;
                case 0: goto L_0x01a3;
                case 1: goto L_0x018a;
                case 2: goto L_0x0171;
                case 3: goto L_0x0167;
                case 4: goto L_0x015d;
                case 5: goto L_0x0145;
                case 6: goto L_0x012b;
                case 7: goto L_0x011a;
                case 8: goto L_0x010b;
                case 9: goto L_0x00fe;
                case 10: goto L_0x00f3;
                case 11: goto L_0x00e7;
                case 12: goto L_0x00db;
                case 13: goto L_0x00cf;
                case 14: goto L_0x00c3;
                case 15: goto L_0x00b7;
                case 16: goto L_0x00ab;
                case 17: goto L_0x009f;
                case 18: goto L_0x0093;
                case 19: goto L_0x0087;
                case 20: goto L_0x007b;
                case 21: goto L_0x006f;
                case 22: goto L_0x0063;
                case 23: goto L_0x0057;
                default: goto L_0x0055;
            }
        L_0x0055:
            goto L_0x01c2
        L_0x0057:
            com.squareup.moshi.JsonAdapter<zendesk.conversationkit.android.internal.rest.model.MessageSourceDto> r3 = r0.nullableMessageSourceDtoAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r28 = r3
            zendesk.conversationkit.android.internal.rest.model.MessageSourceDto r28 = (zendesk.conversationkit.android.internal.rest.model.MessageSourceDto) r28
            goto L_0x01c2
        L_0x0063:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r27 = r3
            java.lang.String r27 = (java.lang.String) r27
            goto L_0x01c2
        L_0x006f:
            com.squareup.moshi.JsonAdapter<java.util.List<zendesk.conversationkit.android.internal.rest.model.MessageFieldDto>> r3 = r0.nullableListOfMessageFieldDtoAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r26 = r3
            java.util.List r26 = (java.util.List) r26
            goto L_0x01c2
        L_0x007b:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r3 = r0.nullableBooleanAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r25 = r3
            java.lang.Boolean r25 = (java.lang.Boolean) r25
            goto L_0x01c2
        L_0x0087:
            com.squareup.moshi.JsonAdapter<zendesk.conversationkit.android.internal.rest.model.DisplaySettingsDto> r3 = r0.nullableDisplaySettingsDtoAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r24 = r3
            zendesk.conversationkit.android.internal.rest.model.DisplaySettingsDto r24 = (zendesk.conversationkit.android.internal.rest.model.DisplaySettingsDto) r24
            goto L_0x01c2
        L_0x0093:
            com.squareup.moshi.JsonAdapter<java.util.List<zendesk.conversationkit.android.internal.rest.model.MessageItemDto>> r3 = r0.nullableListOfMessageItemDtoAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r23 = r3
            java.util.List r23 = (java.util.List) r23
            goto L_0x01c2
        L_0x009f:
            com.squareup.moshi.JsonAdapter<java.util.List<zendesk.conversationkit.android.internal.rest.model.MessageActionDto>> r3 = r0.nullableListOfMessageActionDtoAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r22 = r3
            java.util.List r22 = (java.util.List) r22
            goto L_0x01c2
        L_0x00ab:
            com.squareup.moshi.JsonAdapter<zendesk.conversationkit.android.internal.rest.model.LocationDto> r3 = r0.nullableLocationDtoAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r21 = r3
            zendesk.conversationkit.android.internal.rest.model.LocationDto r21 = (zendesk.conversationkit.android.internal.rest.model.LocationDto) r21
            goto L_0x01c2
        L_0x00b7:
            com.squareup.moshi.JsonAdapter<zendesk.conversationkit.android.internal.rest.model.CoordinatesDto> r3 = r0.nullableCoordinatesDtoAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r20 = r3
            zendesk.conversationkit.android.internal.rest.model.CoordinatesDto r20 = (zendesk.conversationkit.android.internal.rest.model.CoordinatesDto) r20
            goto L_0x01c2
        L_0x00c3:
            com.squareup.moshi.JsonAdapter<java.lang.Long> r3 = r0.nullableLongAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r19 = r3
            java.lang.Long r19 = (java.lang.Long) r19
            goto L_0x01c2
        L_0x00cf:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r18 = r3
            java.lang.String r18 = (java.lang.String) r18
            goto L_0x01c2
        L_0x00db:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r17 = r3
            java.lang.String r17 = (java.lang.String) r17
            goto L_0x01c2
        L_0x00e7:
            com.squareup.moshi.JsonAdapter<java.util.Map<java.lang.String, java.lang.Object>> r3 = r0.nullableMapOfStringAnyAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r16 = r3
            java.util.Map r16 = (java.util.Map) r16
            goto L_0x01c2
        L_0x00f3:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r3
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x01c4
        L_0x00fe:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r14 = r3
            java.lang.String r14 = (java.lang.String) r14
            r15 = r29
            goto L_0x01c6
        L_0x010b:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r3
            java.lang.String r13 = (java.lang.String) r13
            r15 = r29
            r14 = r30
            goto L_0x01c8
        L_0x011a:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r3
            java.lang.String r12 = (java.lang.String) r12
            r15 = r29
            r14 = r30
            r13 = r31
            goto L_0x0031
        L_0x012b:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.stringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r3
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x0138
            goto L_0x01c2
        L_0x0138:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"type\", \"type\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0145:
            com.squareup.moshi.JsonAdapter<java.lang.Double> r2 = r0.doubleAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Double r2 = (java.lang.Double) r2
            if (r2 == 0) goto L_0x0150
            goto L_0x01c2
        L_0x0150:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"received…      \"received\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x015d:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r3
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x01c2
        L_0x0167:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.nullableStringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r3
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x01c2
        L_0x0171:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.stringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r3
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x017d
            goto L_0x01c2
        L_0x017d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"role\", \"role\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x018a:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.stringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r3
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x0196
            goto L_0x01c2
        L_0x0196:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"authorId…      \"authorId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01a3:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.stringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x01af
            goto L_0x01c2
        L_0x01af:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r9, r1)
            java.lang.String r2 = "unexpectedNull(\"id\", \"_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01bc:
            r35.skipName()
            r35.skipValue()
        L_0x01c2:
            r15 = r29
        L_0x01c4:
            r14 = r30
        L_0x01c6:
            r13 = r31
        L_0x01c8:
            r12 = r32
            goto L_0x0031
        L_0x01cc:
            r35.endObject()
            zendesk.conversationkit.android.internal.rest.model.MessageDto r33 = new zendesk.conversationkit.android.internal.rest.model.MessageDto
            if (r4 == 0) goto L_0x021d
            if (r5 == 0) goto L_0x0211
            if (r6 == 0) goto L_0x0205
            if (r2 == 0) goto L_0x01f9
            double r9 = r2.doubleValue()
            if (r11 == 0) goto L_0x01ed
            r3 = r33
            r12 = r32
            r13 = r31
            r14 = r30
            r15 = r29
            r3.<init>(r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return r33
        L_0x01ed:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r15, r1)
            java.lang.String r2 = "missingProperty(\"type\", \"type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01f9:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r14, r14, r1)
            java.lang.String r2 = "missingProperty(\"received\", \"received\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0205:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r13, r1)
            java.lang.String r2 = "missingProperty(\"role\", \"role\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0211:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r12, r12, r1)
            java.lang.String r2 = "missingProperty(\"authorId\", \"authorId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x021d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r9, r1)
            java.lang.String r2 = "missingProperty(\"id\", \"_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.rest.model.MessageDtoJsonAdapter.fromJson(com.squareup.moshi.JsonReader):zendesk.conversationkit.android.internal.rest.model.MessageDto");
    }

    public void toJson(JsonWriter jsonWriter, MessageDto messageDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (messageDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("_id");
            this.stringAdapter.toJson(jsonWriter, messageDto.getId());
            jsonWriter.name("authorId");
            this.stringAdapter.toJson(jsonWriter, messageDto.getAuthorId());
            jsonWriter.name("role");
            this.stringAdapter.toJson(jsonWriter, messageDto.getRole());
            jsonWriter.name("name");
            this.nullableStringAdapter.toJson(jsonWriter, messageDto.getName());
            jsonWriter.name("avatarUrl");
            this.nullableStringAdapter.toJson(jsonWriter, messageDto.getAvatarUrl());
            jsonWriter.name("received");
            this.doubleAdapter.toJson(jsonWriter, Double.valueOf(messageDto.getReceived()));
            jsonWriter.name("type");
            this.stringAdapter.toJson(jsonWriter, messageDto.getType());
            jsonWriter.name("text");
            this.nullableStringAdapter.toJson(jsonWriter, messageDto.getText());
            jsonWriter.name("textFallback");
            this.nullableStringAdapter.toJson(jsonWriter, messageDto.getTextFallback());
            jsonWriter.name("altText");
            this.nullableStringAdapter.toJson(jsonWriter, messageDto.getAltText());
            jsonWriter.name("payload");
            this.nullableStringAdapter.toJson(jsonWriter, messageDto.getPayload());
            jsonWriter.name(TtmlNode.TAG_METADATA);
            this.nullableMapOfStringAnyAdapter.toJson(jsonWriter, messageDto.getMetadata());
            jsonWriter.name("mediaUrl");
            this.nullableStringAdapter.toJson(jsonWriter, messageDto.getMediaUrl());
            jsonWriter.name("mediaType");
            this.nullableStringAdapter.toJson(jsonWriter, messageDto.getMediaType());
            jsonWriter.name("mediaSize");
            this.nullableLongAdapter.toJson(jsonWriter, messageDto.getMediaSize());
            jsonWriter.name("coordinates");
            this.nullableCoordinatesDtoAdapter.toJson(jsonWriter, messageDto.getCoordinates());
            jsonWriter.name(FirebaseAnalytics.Param.LOCATION);
            this.nullableLocationDtoAdapter.toJson(jsonWriter, messageDto.getLocation());
            jsonWriter.name("actions");
            this.nullableListOfMessageActionDtoAdapter.toJson(jsonWriter, messageDto.getActions());
            jsonWriter.name(FirebaseAnalytics.Param.ITEMS);
            this.nullableListOfMessageItemDtoAdapter.toJson(jsonWriter, messageDto.getItems());
            jsonWriter.name("displaySettings");
            this.nullableDisplaySettingsDtoAdapter.toJson(jsonWriter, messageDto.getDisplaySettings());
            jsonWriter.name("blockChatInput");
            this.nullableBooleanAdapter.toJson(jsonWriter, messageDto.getBlockChatInput());
            jsonWriter.name(GraphRequest.FIELDS_PARAM);
            this.nullableListOfMessageFieldDtoAdapter.toJson(jsonWriter, messageDto.getFields());
            jsonWriter.name("quotedMessageId");
            this.nullableStringAdapter.toJson(jsonWriter, messageDto.getQuotedMessageId());
            jsonWriter.name("source");
            this.nullableMessageSourceDtoAdapter.toJson(jsonWriter, messageDto.getSource());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

package zendesk.conversationkit.android.internal.rest.model;

import com.facebook.GraphRequest;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.SendMessageDto;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/SendMessageDto_FormResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/SendMessageDto$FormResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "listOfSendFieldResponseDtoAdapter", "", "Lzendesk/conversationkit/android/internal/rest/model/SendFieldResponseDto;", "nullableMapOfStringAnyAdapter", "", "", "", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SendMessageDto_FormResponseJsonAdapter.kt */
public final class SendMessageDto_FormResponseJsonAdapter extends JsonAdapter<SendMessageDto.FormResponse> {
    private volatile Constructor<SendMessageDto.FormResponse> constructorRef;
    private final JsonAdapter<List<SendFieldResponseDto>> listOfSendFieldResponseDtoAdapter;
    private final JsonAdapter<Map<String, Object>> nullableMapOfStringAnyAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public SendMessageDto_FormResponseJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("role", TtmlNode.TAG_METADATA, "payload", GraphRequest.FIELDS_PARAM, "quotedMessageId");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"role\", \"metadata\", \"…elds\", \"quotedMessageId\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "role");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(),\n      \"role\")");
        this.stringAdapter = adapter;
        JsonAdapter<Map<String, Object>> adapter2 = moshi.adapter(Types.newParameterizedType(Map.class, String.class, Object.class), SetsKt.emptySet(), TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…, emptySet(), \"metadata\")");
        this.nullableMapOfStringAnyAdapter = adapter2;
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, SetsKt.emptySet(), "payload");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(String::cl…   emptySet(), \"payload\")");
        this.nullableStringAdapter = adapter3;
        JsonAdapter<List<SendFieldResponseDto>> adapter4 = moshi.adapter(Types.newParameterizedType(List.class, SendFieldResponseDto.class), SetsKt.emptySet(), GraphRequest.FIELDS_PARAM);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Types.newP…    emptySet(), \"fields\")");
        this.listOfSendFieldResponseDtoAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(49);
        sb.append("GeneratedJsonAdapter(").append("SendMessageDto.FormResponse").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public SendMessageDto.FormResponse fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i = -1;
        String str = null;
        Map map = null;
        String str2 = null;
        List list = null;
        String str3 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader2.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader2);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("role", "role", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"role\", \"role\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                map = this.nullableMapOfStringAnyAdapter.fromJson(jsonReader2);
                i &= -3;
            } else if (selectName == 2) {
                str2 = this.nullableStringAdapter.fromJson(jsonReader2);
                i &= -5;
            } else if (selectName == 3) {
                list = this.listOfSendFieldResponseDtoAdapter.fromJson(jsonReader2);
                if (list == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(GraphRequest.FIELDS_PARAM, GraphRequest.FIELDS_PARAM, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"fields\", \"fields\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 4 && (str3 = this.stringAdapter.fromJson(jsonReader2)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("quotedMessageId", "quotedMessageId", jsonReader2);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"quotedMe…quotedMessageId\", reader)");
                throw unexpectedNull3;
            }
        }
        jsonReader.endObject();
        if (i != -7) {
            Constructor<SendMessageDto.FormResponse> constructor = this.constructorRef;
            if (constructor == null) {
                constructor = SendMessageDto.FormResponse.class.getDeclaredConstructor(new Class[]{String.class, Map.class, String.class, List.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "SendMessageDto.FormRespo…his.constructorRef = it }");
            }
            Object[] objArr = new Object[7];
            if (str != null) {
                objArr[0] = str;
                objArr[1] = map;
                objArr[2] = str2;
                if (list != null) {
                    objArr[3] = list;
                    if (str3 != null) {
                        objArr[4] = str3;
                        objArr[5] = Integer.valueOf(i);
                        objArr[6] = null;
                        SendMessageDto.FormResponse newInstance = constructor.newInstance(objArr);
                        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                        return newInstance;
                    }
                    JsonDataException missingProperty = Util.missingProperty("quotedMessageId", "quotedMessageId", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"quotedM…d\",\n              reader)");
                    throw missingProperty;
                }
                JsonDataException missingProperty2 = Util.missingProperty(GraphRequest.FIELDS_PARAM, GraphRequest.FIELDS_PARAM, jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"fields\", \"fields\", reader)");
                throw missingProperty2;
            }
            JsonDataException missingProperty3 = Util.missingProperty("role", "role", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"role\", \"role\", reader)");
            throw missingProperty3;
        } else if (str == null) {
            JsonDataException missingProperty4 = Util.missingProperty("role", "role", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"role\", \"role\", reader)");
            throw missingProperty4;
        } else if (list == null) {
            JsonDataException missingProperty5 = Util.missingProperty(GraphRequest.FIELDS_PARAM, GraphRequest.FIELDS_PARAM, jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"fields\", \"fields\", reader)");
            throw missingProperty5;
        } else if (str3 != null) {
            return new SendMessageDto.FormResponse(str, map, str2, list, str3);
        } else {
            JsonDataException missingProperty6 = Util.missingProperty("quotedMessageId", "quotedMessageId", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"quotedM…quotedMessageId\", reader)");
            throw missingProperty6;
        }
    }

    public void toJson(JsonWriter jsonWriter, SendMessageDto.FormResponse formResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (formResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("role");
            this.stringAdapter.toJson(jsonWriter, formResponse.getRole());
            jsonWriter.name(TtmlNode.TAG_METADATA);
            this.nullableMapOfStringAnyAdapter.toJson(jsonWriter, formResponse.getMetadata());
            jsonWriter.name("payload");
            this.nullableStringAdapter.toJson(jsonWriter, formResponse.getPayload());
            jsonWriter.name(GraphRequest.FIELDS_PARAM);
            this.listOfSendFieldResponseDtoAdapter.toJson(jsonWriter, formResponse.getFields());
            jsonWriter.name("quotedMessageId");
            this.stringAdapter.toJson(jsonWriter, formResponse.getQuotedMessageId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

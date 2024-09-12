package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.SendMessageDto;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/SendMessageDto_TextJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/SendMessageDto$Text;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableMapOfStringAnyAdapter", "", "", "", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SendMessageDto_TextJsonAdapter.kt */
public final class SendMessageDto_TextJsonAdapter extends JsonAdapter<SendMessageDto.Text> {
    private volatile Constructor<SendMessageDto.Text> constructorRef;
    private final JsonAdapter<Map<String, Object>> nullableMapOfStringAnyAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public SendMessageDto_TextJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("role", TtmlNode.TAG_METADATA, "payload", "text");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"role\", \"metadata\", \"payload\",\n      \"text\")");
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
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(41);
        sb.append("GeneratedJsonAdapter(").append("SendMessageDto.Text").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public SendMessageDto.Text fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i = -1;
        String str = null;
        Map map = null;
        String str2 = null;
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
            } else if (selectName == 3 && (str3 = this.stringAdapter.fromJson(jsonReader2)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("text", "text", jsonReader2);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"text\", \"text\",\n            reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (i != -7) {
            Constructor<SendMessageDto.Text> constructor = this.constructorRef;
            if (constructor == null) {
                constructor = SendMessageDto.Text.class.getDeclaredConstructor(new Class[]{String.class, Map.class, String.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "SendMessageDto.Text::cla…his.constructorRef = it }");
            }
            Object[] objArr = new Object[6];
            if (str != null) {
                objArr[0] = str;
                objArr[1] = map;
                objArr[2] = str2;
                if (str3 != null) {
                    objArr[3] = str3;
                    objArr[4] = Integer.valueOf(i);
                    objArr[5] = null;
                    SendMessageDto.Text newInstance = constructor.newInstance(objArr);
                    Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                    return newInstance;
                }
                JsonDataException missingProperty = Util.missingProperty("text", "text", jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"text\", \"text\", reader)");
                throw missingProperty;
            }
            JsonDataException missingProperty2 = Util.missingProperty("role", "role", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"role\", \"role\", reader)");
            throw missingProperty2;
        } else if (str == null) {
            JsonDataException missingProperty3 = Util.missingProperty("role", "role", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"role\", \"role\", reader)");
            throw missingProperty3;
        } else if (str3 != null) {
            return new SendMessageDto.Text(str, map, str2, str3);
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("text", "text", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"text\", \"text\", reader)");
            throw missingProperty4;
        }
    }

    public void toJson(JsonWriter jsonWriter, SendMessageDto.Text text) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (text != null) {
            jsonWriter.beginObject();
            jsonWriter.name("role");
            this.stringAdapter.toJson(jsonWriter, text.getRole());
            jsonWriter.name(TtmlNode.TAG_METADATA);
            this.nullableMapOfStringAnyAdapter.toJson(jsonWriter, text.getMetadata());
            jsonWriter.name("payload");
            this.nullableStringAdapter.toJson(jsonWriter, text.getPayload());
            jsonWriter.name("text");
            this.stringAdapter.toJson(jsonWriter, text.getText());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

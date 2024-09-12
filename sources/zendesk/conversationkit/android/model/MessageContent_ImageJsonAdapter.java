package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.MessageContent;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lzendesk/conversationkit/android/model/MessageContent_ImageJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/MessageContent$Image;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "longAdapter", "", "nullableListOfMessageActionAdapter", "", "Lzendesk/conversationkit/android/model/MessageAction;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageContent_ImageJsonAdapter.kt */
public final class MessageContent_ImageJsonAdapter extends JsonAdapter<MessageContent.Image> {
    private volatile Constructor<MessageContent.Image> constructorRef;
    private final JsonAdapter<Long> longAdapter;
    private final JsonAdapter<List<MessageAction>> nullableListOfMessageActionAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public MessageContent_ImageJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("text", "mediaUrl", "localUri", "mediaType", "mediaSize", "actions");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"text\", \"mediaUrl\", \"…, \"mediaSize\", \"actions\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "text");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(),\n      \"text\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "localUri");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…  emptySet(), \"localUri\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<Long> adapter3 = moshi.adapter(Long.TYPE, SetsKt.emptySet(), "mediaSize");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Long::clas…Set(),\n      \"mediaSize\")");
        this.longAdapter = adapter3;
        JsonAdapter<List<MessageAction>> adapter4 = moshi.adapter(Types.newParameterizedType(List.class, MessageAction.class), SetsKt.emptySet(), "actions");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Types.newP…   emptySet(), \"actions\")");
        this.nullableListOfMessageActionAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(42);
        sb.append("GeneratedJsonAdapter(").append("MessageContent.Image").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public MessageContent.Image fromJson(JsonReader jsonReader) {
        String str;
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i = -1;
        Long l = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        List list = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str2 = this.stringAdapter.fromJson(jsonReader2);
                    if (str2 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("text", "text", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"text\", \"text\",\n            reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    str3 = this.stringAdapter.fromJson(jsonReader2);
                    if (str3 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("mediaUrl", "mediaUrl", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"mediaUrl…      \"mediaUrl\", reader)");
                        throw unexpectedNull2;
                    }
                case 2:
                    str4 = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 3:
                    str5 = this.stringAdapter.fromJson(jsonReader2);
                    if (str5 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("mediaType", "mediaType", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"mediaTyp…     \"mediaType\", reader)");
                        throw unexpectedNull3;
                    }
                case 4:
                    l = this.longAdapter.fromJson(jsonReader2);
                    if (l != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("mediaSize", "mediaSize", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"mediaSiz…     \"mediaSize\", reader)");
                        throw unexpectedNull4;
                    }
                case 5:
                    list = this.nullableListOfMessageActionAdapter.fromJson(jsonReader2);
                    i &= -33;
                    break;
            }
        }
        jsonReader.endObject();
        String str6 = "missingProperty(\"text\", \"text\", reader)";
        if (i != -33) {
            String str7 = str6;
            String str8 = "text";
            Constructor<MessageContent.Image> constructor = this.constructorRef;
            String str9 = "missingProperty(\"mediaUrl\", \"mediaUrl\", reader)";
            if (constructor == null) {
                str = "mediaUrl";
                constructor = MessageContent.Image.class.getDeclaredConstructor(new Class[]{String.class, String.class, String.class, String.class, Long.TYPE, List.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "MessageContent.Image::cl…his.constructorRef = it }");
            } else {
                str = "mediaUrl";
            }
            Object[] objArr = new Object[8];
            if (str2 != null) {
                objArr[0] = str2;
                if (str3 != null) {
                    objArr[1] = str3;
                    objArr[2] = str4;
                    if (str5 != null) {
                        objArr[3] = str5;
                        if (l != null) {
                            objArr[4] = Long.valueOf(l.longValue());
                            objArr[5] = list;
                            objArr[6] = Integer.valueOf(i);
                            objArr[7] = null;
                            MessageContent.Image newInstance = constructor.newInstance(objArr);
                            Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                            return newInstance;
                        }
                        JsonDataException missingProperty = Util.missingProperty("mediaSize", "mediaSize", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"mediaSize\", \"mediaSize\", reader)");
                        throw missingProperty;
                    }
                    JsonDataException missingProperty2 = Util.missingProperty("mediaType", "mediaType", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"mediaType\", \"mediaType\", reader)");
                    throw missingProperty2;
                }
                String str10 = str;
                JsonDataException missingProperty3 = Util.missingProperty(str10, str10, jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty3, str9);
                throw missingProperty3;
            }
            String str11 = str8;
            JsonDataException missingProperty4 = Util.missingProperty(str11, str11, jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, str7);
            throw missingProperty4;
        } else if (str2 == null) {
            JsonDataException missingProperty5 = Util.missingProperty("text", "text", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, str6);
            throw missingProperty5;
        } else if (str3 == null) {
            JsonDataException missingProperty6 = Util.missingProperty("mediaUrl", "mediaUrl", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"mediaUrl\", \"mediaUrl\", reader)");
            throw missingProperty6;
        } else if (str5 == null) {
            JsonDataException missingProperty7 = Util.missingProperty("mediaType", "mediaType", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty7, "missingProperty(\"mediaType\", \"mediaType\", reader)");
            throw missingProperty7;
        } else if (l != null) {
            return new MessageContent.Image(str2, str3, str4, str5, l.longValue(), list);
        } else {
            JsonDataException missingProperty8 = Util.missingProperty("mediaSize", "mediaSize", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty8, "missingProperty(\"mediaSize\", \"mediaSize\", reader)");
            throw missingProperty8;
        }
    }

    public void toJson(JsonWriter jsonWriter, MessageContent.Image image) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (image != null) {
            jsonWriter.beginObject();
            jsonWriter.name("text");
            this.stringAdapter.toJson(jsonWriter, image.getText());
            jsonWriter.name("mediaUrl");
            this.stringAdapter.toJson(jsonWriter, image.getMediaUrl());
            jsonWriter.name("localUri");
            this.nullableStringAdapter.toJson(jsonWriter, image.getLocalUri());
            jsonWriter.name("mediaType");
            this.stringAdapter.toJson(jsonWriter, image.getMediaType());
            jsonWriter.name("mediaSize");
            this.longAdapter.toJson(jsonWriter, Long.valueOf(image.getMediaSize()));
            jsonWriter.name("actions");
            this.nullableListOfMessageActionAdapter.toJson(jsonWriter, image.getActions());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

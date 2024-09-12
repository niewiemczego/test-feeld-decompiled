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

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lzendesk/conversationkit/android/model/MessageContent_TextJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/MessageContent$Text;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableListOfMessageActionAdapter", "", "Lzendesk/conversationkit/android/model/MessageAction;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageContent_TextJsonAdapter.kt */
public final class MessageContent_TextJsonAdapter extends JsonAdapter<MessageContent.Text> {
    private volatile Constructor<MessageContent.Text> constructorRef;
    private final JsonAdapter<List<MessageAction>> nullableListOfMessageActionAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public MessageContent_TextJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("text", "actions");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"text\", \"actions\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "text");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(),\n      \"text\")");
        this.stringAdapter = adapter;
        JsonAdapter<List<MessageAction>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, MessageAction.class), SetsKt.emptySet(), "actions");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…   emptySet(), \"actions\")");
        this.nullableListOfMessageActionAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(41);
        sb.append("GeneratedJsonAdapter(").append("MessageContent.Text").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public MessageContent.Text fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        int i = -1;
        String str = null;
        List list = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("text", "text", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"text\", \"text\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                list = this.nullableListOfMessageActionAdapter.fromJson(jsonReader);
                i &= -3;
            }
        }
        jsonReader.endObject();
        if (i != -3) {
            Constructor<MessageContent.Text> constructor = this.constructorRef;
            if (constructor == null) {
                constructor = MessageContent.Text.class.getDeclaredConstructor(new Class[]{String.class, List.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "MessageContent.Text::cla…his.constructorRef = it }");
            }
            Object[] objArr = new Object[4];
            if (str != null) {
                objArr[0] = str;
                objArr[1] = list;
                objArr[2] = Integer.valueOf(i);
                objArr[3] = null;
                MessageContent.Text newInstance = constructor.newInstance(objArr);
                Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException missingProperty = Util.missingProperty("text", "text", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"text\", \"text\", reader)");
            throw missingProperty;
        } else if (str != null) {
            return new MessageContent.Text(str, list);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("text", "text", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"text\", \"text\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(JsonWriter jsonWriter, MessageContent.Text text) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (text != null) {
            jsonWriter.beginObject();
            jsonWriter.name("text");
            this.stringAdapter.toJson(jsonWriter, text.getText());
            jsonWriter.name("actions");
            this.nullableListOfMessageActionAdapter.toJson(jsonWriter, text.getActions());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

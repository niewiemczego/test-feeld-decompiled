package zendesk.messaging.android.internal.conversationscreen.cache;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/cache/MessagingUIPersistenceJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/messaging/android/internal/conversationscreen/cache/MessagingUIPersistence;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessagingUIPersistenceJsonAdapter.kt */
public final class MessagingUIPersistenceJsonAdapter extends JsonAdapter<MessagingUIPersistence> {
    private volatile Constructor<MessagingUIPersistence> constructorRef;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public MessagingUIPersistenceJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("conversationId", "composerText");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"conversationId\", \"composerText\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "conversationId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…,\n      \"conversationId\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(44);
        sb.append("GeneratedJsonAdapter(").append("MessagingUIPersistence").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public MessagingUIPersistence fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        int i = -1;
        String str = null;
        String str2 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("conversationId", "conversationId", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"conversa…\"conversationId\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 != null) {
                    i &= -3;
                } else {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("composerText", "composerText", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"composer…  \"composerText\", reader)");
                    throw unexpectedNull2;
                }
            } else {
                continue;
            }
        }
        jsonReader.endObject();
        if (i != -3) {
            Constructor<MessagingUIPersistence> constructor = this.constructorRef;
            if (constructor == null) {
                constructor = MessagingUIPersistence.class.getDeclaredConstructor(new Class[]{String.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "MessagingUIPersistence::…his.constructorRef = it }");
            }
            Object[] objArr = new Object[4];
            if (str != null) {
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = Integer.valueOf(i);
                objArr[3] = null;
                MessagingUIPersistence newInstance = constructor.newInstance(objArr);
                Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException missingProperty = Util.missingProperty("conversationId", "conversationId", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"convers…\"conversationId\", reader)");
            throw missingProperty;
        } else if (str == null) {
            JsonDataException missingProperty2 = Util.missingProperty("conversationId", "conversationId", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"convers…\"conversationId\", reader)");
            throw missingProperty2;
        } else if (str2 != null) {
            return new MessagingUIPersistence(str, str2);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public void toJson(JsonWriter jsonWriter, MessagingUIPersistence messagingUIPersistence) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (messagingUIPersistence != null) {
            jsonWriter.beginObject();
            jsonWriter.name("conversationId");
            this.stringAdapter.toJson(jsonWriter, messagingUIPersistence.getConversationId());
            jsonWriter.name("composerText");
            this.stringAdapter.toJson(jsonWriter, messagingUIPersistence.getComposerText());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

package zendesk.conversationkit.android.internal.faye;

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
import zendesk.conversationkit.android.internal.rest.model.MessageDto;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lzendesk/conversationkit/android/internal/faye/WsFayeMessageDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/faye/WsFayeMessageDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableMessageDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/MessageDto;", "nullableWsActivityEventDtoAdapter", "Lzendesk/conversationkit/android/internal/faye/WsActivityEventDto;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "wsConversationDtoAdapter", "Lzendesk/conversationkit/android/internal/faye/WsConversationDto;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WsFayeMessageDtoJsonAdapter.kt */
public final class WsFayeMessageDtoJsonAdapter extends JsonAdapter<WsFayeMessageDto> {
    private volatile Constructor<WsFayeMessageDto> constructorRef;
    private final JsonAdapter<MessageDto> nullableMessageDtoAdapter;
    private final JsonAdapter<WsActivityEventDto> nullableWsActivityEventDtoAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<WsConversationDto> wsConversationDtoAdapter;

    public WsFayeMessageDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("type", "conversation", "message", "activity");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"type\", \"conversation…ssage\",\n      \"activity\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "type");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(),\n      \"type\")");
        this.stringAdapter = adapter;
        JsonAdapter<WsConversationDto> adapter2 = moshi.adapter(WsConversationDto.class, SetsKt.emptySet(), "conversation");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(WsConversa…ptySet(), \"conversation\")");
        this.wsConversationDtoAdapter = adapter2;
        JsonAdapter<MessageDto> adapter3 = moshi.adapter(MessageDto.class, SetsKt.emptySet(), "message");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(MessageDto…a, emptySet(), \"message\")");
        this.nullableMessageDtoAdapter = adapter3;
        JsonAdapter<WsActivityEventDto> adapter4 = moshi.adapter(WsActivityEventDto.class, SetsKt.emptySet(), "activity");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(WsActivity…, emptySet(), \"activity\")");
        this.nullableWsActivityEventDtoAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(38);
        sb.append("GeneratedJsonAdapter(").append("WsFayeMessageDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public WsFayeMessageDto fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i = -1;
        String str = null;
        WsConversationDto wsConversationDto = null;
        MessageDto messageDto = null;
        WsActivityEventDto wsActivityEventDto = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader2.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader2);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("type", "type", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"type\", \"type\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                wsConversationDto = this.wsConversationDtoAdapter.fromJson(jsonReader2);
                if (wsConversationDto == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("conversation", "conversation", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"conversa…, \"conversation\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                messageDto = this.nullableMessageDtoAdapter.fromJson(jsonReader2);
                i &= -5;
            } else if (selectName == 3) {
                wsActivityEventDto = this.nullableWsActivityEventDtoAdapter.fromJson(jsonReader2);
                i &= -9;
            }
        }
        jsonReader.endObject();
        if (i != -13) {
            Constructor<WsFayeMessageDto> constructor = this.constructorRef;
            if (constructor == null) {
                constructor = WsFayeMessageDto.class.getDeclaredConstructor(new Class[]{String.class, WsConversationDto.class, MessageDto.class, WsActivityEventDto.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "WsFayeMessageDto::class.…his.constructorRef = it }");
            }
            Object[] objArr = new Object[6];
            if (str != null) {
                objArr[0] = str;
                if (wsConversationDto != null) {
                    objArr[1] = wsConversationDto;
                    objArr[2] = messageDto;
                    objArr[3] = wsActivityEventDto;
                    objArr[4] = Integer.valueOf(i);
                    objArr[5] = null;
                    WsFayeMessageDto newInstance = constructor.newInstance(objArr);
                    Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                    return newInstance;
                }
                JsonDataException missingProperty = Util.missingProperty("conversation", "conversation", jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"convers…, \"conversation\", reader)");
                throw missingProperty;
            }
            JsonDataException missingProperty2 = Util.missingProperty("type", "type", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"type\", \"type\", reader)");
            throw missingProperty2;
        } else if (str == null) {
            JsonDataException missingProperty3 = Util.missingProperty("type", "type", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"type\", \"type\", reader)");
            throw missingProperty3;
        } else if (wsConversationDto != null) {
            return new WsFayeMessageDto(str, wsConversationDto, messageDto, wsActivityEventDto);
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("conversation", "conversation", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"convers…n\",\n              reader)");
            throw missingProperty4;
        }
    }

    public void toJson(JsonWriter jsonWriter, WsFayeMessageDto wsFayeMessageDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (wsFayeMessageDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("type");
            this.stringAdapter.toJson(jsonWriter, wsFayeMessageDto.getType());
            jsonWriter.name("conversation");
            this.wsConversationDtoAdapter.toJson(jsonWriter, wsFayeMessageDto.getConversation());
            jsonWriter.name("message");
            this.nullableMessageDtoAdapter.toJson(jsonWriter, wsFayeMessageDto.getMessage());
            jsonWriter.name("activity");
            this.nullableWsActivityEventDtoAdapter.toJson(jsonWriter, wsFayeMessageDto.getActivity());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

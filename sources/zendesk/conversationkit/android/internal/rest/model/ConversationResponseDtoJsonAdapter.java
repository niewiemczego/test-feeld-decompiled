package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/ConversationResponseDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/ConversationResponseDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "appUserDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/AppUserDto;", "conversationDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/ConversationDto;", "mapOfStringAppUserDtoAdapter", "", "", "nullableBooleanAdapter", "", "nullableListOfMessageDtoAdapter", "", "Lzendesk/conversationkit/android/internal/rest/model/MessageDto;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationResponseDtoJsonAdapter.kt */
public final class ConversationResponseDtoJsonAdapter extends JsonAdapter<ConversationResponseDto> {
    private final JsonAdapter<AppUserDto> appUserDtoAdapter;
    private final JsonAdapter<ConversationDto> conversationDtoAdapter;
    private final JsonAdapter<Map<String, AppUserDto>> mapOfStringAppUserDtoAdapter;
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    private final JsonAdapter<List<MessageDto>> nullableListOfMessageDtoAdapter;
    private final JsonReader.Options options;

    public ConversationResponseDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("conversation", "messages", "hasPrevious", "appUser", "appUsers");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"conversation\", \"mess…\", \"appUser\", \"appUsers\")");
        this.options = of;
        JsonAdapter<ConversationDto> adapter = moshi.adapter(ConversationDto.class, SetsKt.emptySet(), "conversation");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Conversati…ptySet(), \"conversation\")");
        this.conversationDtoAdapter = adapter;
        JsonAdapter<List<MessageDto>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, MessageDto.class), SetsKt.emptySet(), "messages");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…  emptySet(), \"messages\")");
        this.nullableListOfMessageDtoAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.class, SetsKt.emptySet(), "hasPrevious");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…mptySet(), \"hasPrevious\")");
        this.nullableBooleanAdapter = adapter3;
        JsonAdapter<AppUserDto> adapter4 = moshi.adapter(AppUserDto.class, SetsKt.emptySet(), "appUser");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(AppUserDto…   emptySet(), \"appUser\")");
        this.appUserDtoAdapter = adapter4;
        JsonAdapter<Map<String, AppUserDto>> adapter5 = moshi.adapter(Types.newParameterizedType(Map.class, String.class, AppUserDto.class), SetsKt.emptySet(), "appUsers");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Types.newP…, emptySet(), \"appUsers\")");
        this.mapOfStringAppUserDtoAdapter = adapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(45);
        sb.append("GeneratedJsonAdapter(").append("ConversationResponseDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public ConversationResponseDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        ConversationDto conversationDto = null;
        List list = null;
        Boolean bool = null;
        AppUserDto appUserDto = null;
        Map map = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                conversationDto = this.conversationDtoAdapter.fromJson(jsonReader);
                if (conversationDto == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("conversation", "conversation", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"conversa…, \"conversation\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                list = this.nullableListOfMessageDtoAdapter.fromJson(jsonReader);
            } else if (selectName == 2) {
                bool = this.nullableBooleanAdapter.fromJson(jsonReader);
            } else if (selectName == 3) {
                appUserDto = this.appUserDtoAdapter.fromJson(jsonReader);
                if (appUserDto == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("appUser", "appUser", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"appUser\"…       \"appUser\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 4 && (map = this.mapOfStringAppUserDtoAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("appUsers", "appUsers", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"appUsers\", \"appUsers\", reader)");
                throw unexpectedNull3;
            }
        }
        jsonReader.endObject();
        if (conversationDto == null) {
            JsonDataException missingProperty = Util.missingProperty("conversation", "conversation", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"convers…ion\",\n            reader)");
            throw missingProperty;
        } else if (appUserDto == null) {
            JsonDataException missingProperty2 = Util.missingProperty("appUser", "appUser", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"appUser\", \"appUser\", reader)");
            throw missingProperty2;
        } else if (map != null) {
            return new ConversationResponseDto(conversationDto, list, bool, appUserDto, map);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("appUsers", "appUsers", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"appUsers\", \"appUsers\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, ConversationResponseDto conversationResponseDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (conversationResponseDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("conversation");
            this.conversationDtoAdapter.toJson(jsonWriter, conversationResponseDto.getConversation());
            jsonWriter.name("messages");
            this.nullableListOfMessageDtoAdapter.toJson(jsonWriter, conversationResponseDto.getMessages());
            jsonWriter.name("hasPrevious");
            this.nullableBooleanAdapter.toJson(jsonWriter, conversationResponseDto.getHasPrevious());
            jsonWriter.name("appUser");
            this.appUserDtoAdapter.toJson(jsonWriter, conversationResponseDto.getAppUser());
            jsonWriter.name("appUsers");
            this.mapOfStringAppUserDtoAdapter.toJson(jsonWriter, conversationResponseDto.getAppUsers());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

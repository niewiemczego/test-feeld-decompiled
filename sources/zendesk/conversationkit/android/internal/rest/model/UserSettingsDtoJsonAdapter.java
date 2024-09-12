package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/UserSettingsDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/UserSettingsDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "realtimeSettingsDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/RealtimeSettingsDto;", "typingSettingsDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/TypingSettingsDto;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserSettingsDtoJsonAdapter.kt */
public final class UserSettingsDtoJsonAdapter extends JsonAdapter<UserSettingsDto> {
    private final JsonReader.Options options;
    private final JsonAdapter<RealtimeSettingsDto> realtimeSettingsDtoAdapter;
    private final JsonAdapter<TypingSettingsDto> typingSettingsDtoAdapter;

    public UserSettingsDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("realtime", "typing");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"realtime\", \"typing\")");
        this.options = of;
        JsonAdapter<RealtimeSettingsDto> adapter = moshi.adapter(RealtimeSettingsDto.class, SetsKt.emptySet(), "realtime");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(RealtimeSe…, emptySet(), \"realtime\")");
        this.realtimeSettingsDtoAdapter = adapter;
        JsonAdapter<TypingSettingsDto> adapter2 = moshi.adapter(TypingSettingsDto.class, SetsKt.emptySet(), "typing");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(TypingSett…va, emptySet(), \"typing\")");
        this.typingSettingsDtoAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(37);
        sb.append("GeneratedJsonAdapter(").append("UserSettingsDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public UserSettingsDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        RealtimeSettingsDto realtimeSettingsDto = null;
        TypingSettingsDto typingSettingsDto = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                realtimeSettingsDto = this.realtimeSettingsDtoAdapter.fromJson(jsonReader);
                if (realtimeSettingsDto == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("realtime", "realtime", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"realtime\", \"realtime\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (typingSettingsDto = this.typingSettingsDtoAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("typing", "typing", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"typing\", \"typing\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (realtimeSettingsDto == null) {
            JsonDataException missingProperty = Util.missingProperty("realtime", "realtime", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"realtime\", \"realtime\", reader)");
            throw missingProperty;
        } else if (typingSettingsDto != null) {
            return new UserSettingsDto(realtimeSettingsDto, typingSettingsDto);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("typing", "typing", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"typing\", \"typing\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(JsonWriter jsonWriter, UserSettingsDto userSettingsDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (userSettingsDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("realtime");
            this.realtimeSettingsDtoAdapter.toJson(jsonWriter, userSettingsDto.getRealtime());
            jsonWriter.name("typing");
            this.typingSettingsDtoAdapter.toJson(jsonWriter, userSettingsDto.getTyping());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

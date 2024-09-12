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

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/AppUserResponseDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/AppUserResponseDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "appUserDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/AppUserDto;", "conversationsPaginationDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/ConversationsPaginationDto;", "listOfConversationDtoAdapter", "", "Lzendesk/conversationkit/android/internal/rest/model/ConversationDto;", "mapOfStringAppUserDtoAdapter", "", "", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "userSettingsDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/UserSettingsDto;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppUserResponseDtoJsonAdapter.kt */
public final class AppUserResponseDtoJsonAdapter extends JsonAdapter<AppUserResponseDto> {
    private final JsonAdapter<AppUserDto> appUserDtoAdapter;
    private final JsonAdapter<ConversationsPaginationDto> conversationsPaginationDtoAdapter;
    private final JsonAdapter<List<ConversationDto>> listOfConversationDtoAdapter;
    private final JsonAdapter<Map<String, AppUserDto>> mapOfStringAppUserDtoAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<UserSettingsDto> userSettingsDtoAdapter;

    public AppUserResponseDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("settings", "conversations", "conversationsPagination", "appUser", "appUsers", "sessionToken");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"settings\", \"conversa…ppUsers\", \"sessionToken\")");
        this.options = of;
        JsonAdapter<UserSettingsDto> adapter = moshi.adapter(UserSettingsDto.class, SetsKt.emptySet(), "settings");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(UserSettin…, emptySet(), \"settings\")");
        this.userSettingsDtoAdapter = adapter;
        JsonAdapter<List<ConversationDto>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, ConversationDto.class), SetsKt.emptySet(), "conversations");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…tySet(), \"conversations\")");
        this.listOfConversationDtoAdapter = adapter2;
        JsonAdapter<ConversationsPaginationDto> adapter3 = moshi.adapter(ConversationsPaginationDto.class, SetsKt.emptySet(), "conversationsPagination");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Conversati…conversationsPagination\")");
        this.conversationsPaginationDtoAdapter = adapter3;
        JsonAdapter<AppUserDto> adapter4 = moshi.adapter(AppUserDto.class, SetsKt.emptySet(), "appUser");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(AppUserDto…   emptySet(), \"appUser\")");
        this.appUserDtoAdapter = adapter4;
        JsonAdapter<Map<String, AppUserDto>> adapter5 = moshi.adapter(Types.newParameterizedType(Map.class, String.class, AppUserDto.class), SetsKt.emptySet(), "appUsers");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Types.newP…, emptySet(), \"appUsers\")");
        this.mapOfStringAppUserDtoAdapter = adapter5;
        JsonAdapter<String> adapter6 = moshi.adapter(String.class, SetsKt.emptySet(), "sessionToken");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(String::cl…ptySet(), \"sessionToken\")");
        this.nullableStringAdapter = adapter6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("GeneratedJsonAdapter(").append("AppUserResponseDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public AppUserResponseDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        UserSettingsDto userSettingsDto = null;
        List list = null;
        ConversationsPaginationDto conversationsPaginationDto = null;
        AppUserDto appUserDto = null;
        Map map = null;
        String str = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    userSettingsDto = this.userSettingsDtoAdapter.fromJson(jsonReader);
                    if (userSettingsDto != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("settings", "settings", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"settings\", \"settings\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    list = this.listOfConversationDtoAdapter.fromJson(jsonReader);
                    if (list != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("conversations", "conversations", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"conversa… \"conversations\", reader)");
                        throw unexpectedNull2;
                    }
                case 2:
                    conversationsPaginationDto = this.conversationsPaginationDtoAdapter.fromJson(jsonReader);
                    if (conversationsPaginationDto != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("conversationsPagination", "conversationsPagination", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"conversa…tionsPagination\", reader)");
                        throw unexpectedNull3;
                    }
                case 3:
                    appUserDto = this.appUserDtoAdapter.fromJson(jsonReader);
                    if (appUserDto != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("appUser", "appUser", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"appUser\"…       \"appUser\", reader)");
                        throw unexpectedNull4;
                    }
                case 4:
                    map = this.mapOfStringAppUserDtoAdapter.fromJson(jsonReader);
                    if (map != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("appUsers", "appUsers", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"appUsers\", \"appUsers\", reader)");
                        throw unexpectedNull5;
                    }
                case 5:
                    str = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.endObject();
        if (userSettingsDto == null) {
            JsonDataException missingProperty = Util.missingProperty("settings", "settings", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"settings\", \"settings\", reader)");
            throw missingProperty;
        } else if (list == null) {
            JsonDataException missingProperty2 = Util.missingProperty("conversations", "conversations", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"convers… \"conversations\", reader)");
            throw missingProperty2;
        } else if (conversationsPaginationDto == null) {
            JsonDataException missingProperty3 = Util.missingProperty("conversationsPagination", "conversationsPagination", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"convers…ion\",\n            reader)");
            throw missingProperty3;
        } else if (appUserDto == null) {
            JsonDataException missingProperty4 = Util.missingProperty("appUser", "appUser", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"appUser\", \"appUser\", reader)");
            throw missingProperty4;
        } else if (map != null) {
            return new AppUserResponseDto(userSettingsDto, list, conversationsPaginationDto, appUserDto, map, str);
        } else {
            JsonDataException missingProperty5 = Util.missingProperty("appUsers", "appUsers", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"appUsers\", \"appUsers\", reader)");
            throw missingProperty5;
        }
    }

    public void toJson(JsonWriter jsonWriter, AppUserResponseDto appUserResponseDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (appUserResponseDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("settings");
            this.userSettingsDtoAdapter.toJson(jsonWriter, appUserResponseDto.getSettings());
            jsonWriter.name("conversations");
            this.listOfConversationDtoAdapter.toJson(jsonWriter, appUserResponseDto.getConversations());
            jsonWriter.name("conversationsPagination");
            this.conversationsPaginationDtoAdapter.toJson(jsonWriter, appUserResponseDto.getConversationsPagination());
            jsonWriter.name("appUser");
            this.appUserDtoAdapter.toJson(jsonWriter, appUserResponseDto.getAppUser());
            jsonWriter.name("appUsers");
            this.mapOfStringAppUserDtoAdapter.toJson(jsonWriter, appUserResponseDto.getAppUsers());
            jsonWriter.name("sessionToken");
            this.nullableStringAdapter.toJson(jsonWriter, appUserResponseDto.getSessionToken());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

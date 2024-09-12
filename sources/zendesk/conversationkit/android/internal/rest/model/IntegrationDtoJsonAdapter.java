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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/IntegrationDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/IntegrationDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IntegrationDtoJsonAdapter.kt */
public final class IntegrationDtoJsonAdapter extends JsonAdapter<IntegrationDto> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public IntegrationDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("_id", "canUserCreateMoreConversations", "canUserSeeConversationList");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"_id\",\n      \"canUser…UserSeeConversationList\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<Boolean> adapter2 = moshi.adapter(Boolean.TYPE, SetsKt.emptySet(), "canUserCreateMoreConversations");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Boolean::c…CreateMoreConversations\")");
        this.booleanAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(36);
        sb.append("GeneratedJsonAdapter(").append("IntegrationDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public IntegrationDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        Boolean bool = null;
        Boolean bool2 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("id", "_id", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"_id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                bool = this.booleanAdapter.fromJson(jsonReader);
                if (bool == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("canUserCreateMoreConversations", "canUserCreateMoreConversations", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"canUserC…reConversations\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (bool2 = this.booleanAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("canUserSeeConversationList", "canUserSeeConversationList", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"canUserS…ist\",\n            reader)");
                throw unexpectedNull3;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("id", "_id", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"id\", \"_id\", reader)");
            throw missingProperty;
        } else if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (bool2 != null) {
                return new IntegrationDto(str, booleanValue, bool2.booleanValue());
            }
            JsonDataException missingProperty2 = Util.missingProperty("canUserSeeConversationList", "canUserSeeConversationList", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"canUser…ist\",\n            reader)");
            throw missingProperty2;
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("canUserCreateMoreConversations", "canUserCreateMoreConversations", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"canUser…reConversations\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, IntegrationDto integrationDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (integrationDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("_id");
            this.stringAdapter.toJson(jsonWriter, integrationDto.getId());
            jsonWriter.name("canUserCreateMoreConversations");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(integrationDto.getCanUserCreateMoreConversations()));
            jsonWriter.name("canUserSeeConversationList");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(integrationDto.getCanUserSeeConversationList()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

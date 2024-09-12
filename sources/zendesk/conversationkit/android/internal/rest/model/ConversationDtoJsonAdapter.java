package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/ConversationDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/ConversationDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "nullableDoubleAdapter", "", "nullableListOfMessageDtoAdapter", "", "Lzendesk/conversationkit/android/internal/rest/model/MessageDto;", "nullableListOfParticipantDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/ParticipantDto;", "nullableListOfStringAdapter", "", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationDtoJsonAdapter.kt */
public final class ConversationDtoJsonAdapter extends JsonAdapter<ConversationDto> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<Double> nullableDoubleAdapter;
    private final JsonAdapter<List<MessageDto>> nullableListOfMessageDtoAdapter;
    private final JsonAdapter<List<ParticipantDto>> nullableListOfParticipantDtoAdapter;
    private final JsonAdapter<List<String>> nullableListOfStringAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConversationDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("_id", "displayName", "description", "iconUrl", "type", "isDefault", "appMakers", "appMakerLastRead", "lastUpdatedAt", "participants", "messages");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"_id\", \"displayName\",…articipants\", \"messages\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "displayName");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…mptySet(), \"displayName\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.TYPE, SetsKt.emptySet(), "isDefault");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…Set(),\n      \"isDefault\")");
        this.booleanAdapter = adapter3;
        JsonAdapter<List<String>> adapter4 = moshi.adapter(Types.newParameterizedType(List.class, String.class), SetsKt.emptySet(), "appMakers");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Types.newP…Set(),\n      \"appMakers\")");
        this.nullableListOfStringAdapter = adapter4;
        JsonAdapter<Double> adapter5 = moshi.adapter(Double.class, SetsKt.emptySet(), "appMakerLastRead");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Double::cl…et(), \"appMakerLastRead\")");
        this.nullableDoubleAdapter = adapter5;
        JsonAdapter<List<ParticipantDto>> adapter6 = moshi.adapter(Types.newParameterizedType(List.class, ParticipantDto.class), SetsKt.emptySet(), "participants");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Types.newP…ptySet(), \"participants\")");
        this.nullableListOfParticipantDtoAdapter = adapter6;
        JsonAdapter<List<MessageDto>> adapter7 = moshi.adapter(Types.newParameterizedType(List.class, MessageDto.class), SetsKt.emptySet(), "messages");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(Types.newP…  emptySet(), \"messages\")");
        this.nullableListOfMessageDtoAdapter = adapter7;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(37);
        sb.append("GeneratedJsonAdapter(").append("ConversationDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public ConversationDto fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        Boolean bool = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        List list = null;
        Double d = null;
        Double d2 = null;
        List list2 = null;
        List list3 = null;
        while (true) {
            List list4 = list3;
            List list5 = list2;
            if (jsonReader.hasNext()) {
                switch (jsonReader2.selectName(this.options)) {
                    case -1:
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        break;
                    case 0:
                        str = this.stringAdapter.fromJson(jsonReader2);
                        if (str == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("id", "_id", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"_id\", reader)");
                            throw unexpectedNull;
                        }
                        break;
                    case 1:
                        str2 = this.nullableStringAdapter.fromJson(jsonReader2);
                        break;
                    case 2:
                        str3 = this.nullableStringAdapter.fromJson(jsonReader2);
                        break;
                    case 3:
                        str4 = this.nullableStringAdapter.fromJson(jsonReader2);
                        break;
                    case 4:
                        str5 = this.stringAdapter.fromJson(jsonReader2);
                        if (str5 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("type", "type", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"type\", \"type\",\n            reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 5:
                        bool = this.booleanAdapter.fromJson(jsonReader2);
                        if (bool == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("isDefault", "isDefault", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"isDefaul…     \"isDefault\", reader)");
                            throw unexpectedNull3;
                        }
                        break;
                    case 6:
                        list = this.nullableListOfStringAdapter.fromJson(jsonReader2);
                        break;
                    case 7:
                        d = this.nullableDoubleAdapter.fromJson(jsonReader2);
                        break;
                    case 8:
                        d2 = this.nullableDoubleAdapter.fromJson(jsonReader2);
                        break;
                    case 9:
                        list2 = this.nullableListOfParticipantDtoAdapter.fromJson(jsonReader2);
                        list3 = list4;
                        continue;
                    case 10:
                        list3 = this.nullableListOfMessageDtoAdapter.fromJson(jsonReader2);
                        break;
                }
                list3 = list4;
                list2 = list5;
            } else {
                jsonReader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty("id", "_id", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"id\", \"_id\", reader)");
                    throw missingProperty;
                } else if (str5 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("type", "type", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"type\", \"type\", reader)");
                    throw missingProperty2;
                } else if (bool != null) {
                    return new ConversationDto(str, str2, str3, str4, str5, bool.booleanValue(), list, d, d2, list5, list4);
                } else {
                    JsonDataException missingProperty3 = Util.missingProperty("isDefault", "isDefault", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"isDefault\", \"isDefault\", reader)");
                    throw missingProperty3;
                }
            }
        }
    }

    public void toJson(JsonWriter jsonWriter, ConversationDto conversationDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (conversationDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("_id");
            this.stringAdapter.toJson(jsonWriter, conversationDto.getId());
            jsonWriter.name("displayName");
            this.nullableStringAdapter.toJson(jsonWriter, conversationDto.getDisplayName());
            jsonWriter.name("description");
            this.nullableStringAdapter.toJson(jsonWriter, conversationDto.getDescription());
            jsonWriter.name("iconUrl");
            this.nullableStringAdapter.toJson(jsonWriter, conversationDto.getIconUrl());
            jsonWriter.name("type");
            this.stringAdapter.toJson(jsonWriter, conversationDto.getType());
            jsonWriter.name("isDefault");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(conversationDto.isDefault()));
            jsonWriter.name("appMakers");
            this.nullableListOfStringAdapter.toJson(jsonWriter, conversationDto.getAppMakers());
            jsonWriter.name("appMakerLastRead");
            this.nullableDoubleAdapter.toJson(jsonWriter, conversationDto.getAppMakerLastRead());
            jsonWriter.name("lastUpdatedAt");
            this.nullableDoubleAdapter.toJson(jsonWriter, conversationDto.getLastUpdatedAt());
            jsonWriter.name("participants");
            this.nullableListOfParticipantDtoAdapter.toJson(jsonWriter, conversationDto.getParticipants());
            jsonWriter.name("messages");
            this.nullableListOfMessageDtoAdapter.toJson(jsonWriter, conversationDto.getMessages());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

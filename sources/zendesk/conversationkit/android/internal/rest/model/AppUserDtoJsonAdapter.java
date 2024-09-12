package zendesk.conversationkit.android.internal.rest.model;

import com.braze.models.FeatureFlag;
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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/AppUserDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/AppUserDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfClientDtoAdapter", "", "Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "mapOfStringAnyAdapter", "", "", "", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppUserDtoJsonAdapter.kt */
public final class AppUserDtoJsonAdapter extends JsonAdapter<AppUserDto> {
    private final JsonAdapter<List<ClientDto>> listOfClientDtoAdapter;
    private final JsonAdapter<Map<String, Object>> mapOfStringAnyAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public AppUserDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("_id", "userId", "givenName", "surname", "email", "locale", "signedUpAt", "clients", "pendingClients", FeatureFlag.PROPERTIES);
        Intrinsics.checkNotNullExpressionValue(of, "of(\"_id\", \"userId\", \"giv…ngClients\", \"properties\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "userId");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…    emptySet(), \"userId\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<List<ClientDto>> adapter3 = moshi.adapter(Types.newParameterizedType(List.class, ClientDto.class), SetsKt.emptySet(), "clients");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP…tySet(),\n      \"clients\")");
        this.listOfClientDtoAdapter = adapter3;
        JsonAdapter<Map<String, Object>> adapter4 = moshi.adapter(Types.newParameterizedType(Map.class, String.class, Object.class), SetsKt.emptySet(), FeatureFlag.PROPERTIES);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Types.newP…emptySet(), \"properties\")");
        this.mapOfStringAnyAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("GeneratedJsonAdapter(").append("AppUserDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public AppUserDto fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        List list = null;
        List list2 = null;
        Map map = null;
        while (true) {
            String str8 = str7;
            String str9 = str6;
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
                        str5 = this.nullableStringAdapter.fromJson(jsonReader2);
                        break;
                    case 5:
                        str6 = this.nullableStringAdapter.fromJson(jsonReader2);
                        str7 = str8;
                        continue;
                    case 6:
                        str7 = this.nullableStringAdapter.fromJson(jsonReader2);
                        break;
                    case 7:
                        list = this.listOfClientDtoAdapter.fromJson(jsonReader2);
                        if (list == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("clients", "clients", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"clients\", \"clients\", reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 8:
                        list2 = this.listOfClientDtoAdapter.fromJson(jsonReader2);
                        if (list2 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("pendingClients", "pendingClients", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"pendingC…\"pendingClients\", reader)");
                            throw unexpectedNull3;
                        }
                        break;
                    case 9:
                        map = this.mapOfStringAnyAdapter.fromJson(jsonReader2);
                        if (map == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull(FeatureFlag.PROPERTIES, FeatureFlag.PROPERTIES, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"properties\", \"properties\", reader)");
                            throw unexpectedNull4;
                        }
                        break;
                }
                str7 = str8;
                str6 = str9;
            } else {
                jsonReader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty("id", "_id", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"id\", \"_id\", reader)");
                    throw missingProperty;
                } else if (list == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("clients", "clients", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"clients\", \"clients\", reader)");
                    throw missingProperty2;
                } else if (list2 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("pendingClients", "pendingClients", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"pending…\"pendingClients\", reader)");
                    throw missingProperty3;
                } else if (map != null) {
                    return new AppUserDto(str, str2, str3, str4, str5, str9, str8, list, list2, map);
                } else {
                    JsonDataException missingProperty4 = Util.missingProperty(FeatureFlag.PROPERTIES, FeatureFlag.PROPERTIES, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"propert…s\", \"properties\", reader)");
                    throw missingProperty4;
                }
            }
        }
    }

    public void toJson(JsonWriter jsonWriter, AppUserDto appUserDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (appUserDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("_id");
            this.stringAdapter.toJson(jsonWriter, appUserDto.getId());
            jsonWriter.name("userId");
            this.nullableStringAdapter.toJson(jsonWriter, appUserDto.getUserId());
            jsonWriter.name("givenName");
            this.nullableStringAdapter.toJson(jsonWriter, appUserDto.getGivenName());
            jsonWriter.name("surname");
            this.nullableStringAdapter.toJson(jsonWriter, appUserDto.getSurname());
            jsonWriter.name("email");
            this.nullableStringAdapter.toJson(jsonWriter, appUserDto.getEmail());
            jsonWriter.name("locale");
            this.nullableStringAdapter.toJson(jsonWriter, appUserDto.getLocale());
            jsonWriter.name("signedUpAt");
            this.nullableStringAdapter.toJson(jsonWriter, appUserDto.getSignedUpAt());
            jsonWriter.name("clients");
            this.listOfClientDtoAdapter.toJson(jsonWriter, appUserDto.getClients());
            jsonWriter.name("pendingClients");
            this.listOfClientDtoAdapter.toJson(jsonWriter, appUserDto.getPendingClients());
            jsonWriter.name(FeatureFlag.PROPERTIES);
            this.mapOfStringAnyAdapter.toJson(jsonWriter, appUserDto.getProperties());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

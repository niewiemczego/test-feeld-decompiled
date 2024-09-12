package zendesk.conversationkit.android.internal.rest.model;

import app.notifee.core.event.LogEvent;
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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/ClientDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "clientInfoDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/ClientInfoDto;", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClientDtoJsonAdapter.kt */
public final class ClientDtoJsonAdapter extends JsonAdapter<ClientDto> {
    private final JsonAdapter<ClientInfoDto> clientInfoDtoAdapter;
    private volatile Constructor<ClientDto> constructorRef;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ClientDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "status", "lastSeen", "platform", "integrationId", "pushNotificationToken", "appVersion", "displayName", LogEvent.LEVEL_INFO);
        Intrinsics.checkNotNullExpressionValue(of, "of(\"id\", \"status\", \"last…\", \"displayName\", \"info\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "status");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…    emptySet(), \"status\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<ClientInfoDto> adapter3 = moshi.adapter(ClientInfoDto.class, SetsKt.emptySet(), LogEvent.LEVEL_INFO);
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(ClientInfo…java, emptySet(), \"info\")");
        this.clientInfoDtoAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(31);
        sb.append("GeneratedJsonAdapter(").append("ClientDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public ClientDto fromJson(JsonReader jsonReader) {
        String str;
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i = -1;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        ClientInfoDto clientInfoDto = null;
        while (true) {
            String str10 = str9;
            if (jsonReader.hasNext()) {
                switch (jsonReader2.selectName(this.options)) {
                    case -1:
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        break;
                    case 0:
                        str2 = this.stringAdapter.fromJson(jsonReader2);
                        if (str2 == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                            throw unexpectedNull;
                        }
                        break;
                    case 1:
                        str3 = this.nullableStringAdapter.fromJson(jsonReader2);
                        i &= -3;
                        break;
                    case 2:
                        str4 = this.nullableStringAdapter.fromJson(jsonReader2);
                        i &= -5;
                        break;
                    case 3:
                        str5 = this.stringAdapter.fromJson(jsonReader2);
                        if (str5 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("platform", "platform", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"platform…      \"platform\", reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 4:
                        str6 = this.stringAdapter.fromJson(jsonReader2);
                        if (str6 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("integrationId", "integrationId", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"integrat… \"integrationId\", reader)");
                            throw unexpectedNull3;
                        }
                        break;
                    case 5:
                        str7 = this.nullableStringAdapter.fromJson(jsonReader2);
                        break;
                    case 6:
                        str8 = this.nullableStringAdapter.fromJson(jsonReader2);
                        break;
                    case 7:
                        str9 = this.nullableStringAdapter.fromJson(jsonReader2);
                        i &= -129;
                        continue;
                    case 8:
                        clientInfoDto = this.clientInfoDtoAdapter.fromJson(jsonReader2);
                        if (clientInfoDto == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull(LogEvent.LEVEL_INFO, LogEvent.LEVEL_INFO, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"info\",\n            \"info\", reader)");
                            throw unexpectedNull4;
                        }
                        break;
                }
                str9 = str10;
            } else {
                jsonReader.endObject();
                String str11 = "id";
                String str12 = "missingProperty(\"platform\", \"platform\", reader)";
                String str13 = "missingProperty(\"id\", \"id\", reader)";
                if (i != -135) {
                    String str14 = "platform";
                    String str15 = str13;
                    Constructor<ClientDto> constructor = this.constructorRef;
                    String str16 = "missingProperty(\"integra… \"integrationId\", reader)";
                    if (constructor == null) {
                        str = "integrationId";
                        constructor = ClientDto.class.getDeclaredConstructor(new Class[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, ClientInfoDto.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                        this.constructorRef = constructor;
                        Intrinsics.checkNotNullExpressionValue(constructor, "ClientDto::class.java.ge…his.constructorRef = it }");
                    } else {
                        str = "integrationId";
                    }
                    Object[] objArr = new Object[11];
                    if (str2 != null) {
                        objArr[0] = str2;
                        objArr[1] = str3;
                        objArr[2] = str4;
                        if (str5 != null) {
                            objArr[3] = str5;
                            if (str6 != null) {
                                objArr[4] = str6;
                                objArr[5] = str7;
                                objArr[6] = str8;
                                objArr[7] = str10;
                                if (clientInfoDto != null) {
                                    objArr[8] = clientInfoDto;
                                    objArr[9] = Integer.valueOf(i);
                                    objArr[10] = null;
                                    ClientDto newInstance = constructor.newInstance(objArr);
                                    Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                                    return newInstance;
                                }
                                JsonDataException missingProperty = Util.missingProperty(LogEvent.LEVEL_INFO, LogEvent.LEVEL_INFO, jsonReader2);
                                Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"info\", \"info\", reader)");
                                throw missingProperty;
                            }
                            String str17 = str;
                            JsonDataException missingProperty2 = Util.missingProperty(str17, str17, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(missingProperty2, str16);
                            throw missingProperty2;
                        }
                        String str18 = str14;
                        JsonDataException missingProperty3 = Util.missingProperty(str18, str18, jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(missingProperty3, str12);
                        throw missingProperty3;
                    }
                    String str19 = str11;
                    JsonDataException missingProperty4 = Util.missingProperty(str19, str19, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty4, str15);
                    throw missingProperty4;
                } else if (str2 == null) {
                    String str20 = str11;
                    JsonDataException missingProperty5 = Util.missingProperty(str20, str20, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty5, str13);
                    throw missingProperty5;
                } else if (str5 == null) {
                    JsonDataException missingProperty6 = Util.missingProperty("platform", "platform", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty6, str12);
                    throw missingProperty6;
                } else if (str6 == null) {
                    JsonDataException missingProperty7 = Util.missingProperty("integrationId", "integrationId", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty7, "missingProperty(\"integra… \"integrationId\", reader)");
                    throw missingProperty7;
                } else if (clientInfoDto != null) {
                    return new ClientDto(str2, str3, str4, str5, str6, str7, str8, str10, clientInfoDto);
                } else {
                    JsonDataException missingProperty8 = Util.missingProperty(LogEvent.LEVEL_INFO, LogEvent.LEVEL_INFO, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty8, "missingProperty(\"info\", \"info\", reader)");
                    throw missingProperty8;
                }
            }
        }
    }

    public void toJson(JsonWriter jsonWriter, ClientDto clientDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (clientDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, clientDto.getId());
            jsonWriter.name("status");
            this.nullableStringAdapter.toJson(jsonWriter, clientDto.getStatus());
            jsonWriter.name("lastSeen");
            this.nullableStringAdapter.toJson(jsonWriter, clientDto.getLastSeen());
            jsonWriter.name("platform");
            this.stringAdapter.toJson(jsonWriter, clientDto.getPlatform());
            jsonWriter.name("integrationId");
            this.stringAdapter.toJson(jsonWriter, clientDto.getIntegrationId());
            jsonWriter.name("pushNotificationToken");
            this.nullableStringAdapter.toJson(jsonWriter, clientDto.getPushNotificationToken());
            jsonWriter.name("appVersion");
            this.nullableStringAdapter.toJson(jsonWriter, clientDto.getAppVersion());
            jsonWriter.name("displayName");
            this.nullableStringAdapter.toJson(jsonWriter, clientDto.getDisplayName());
            jsonWriter.name(LogEvent.LEVEL_INFO);
            this.clientInfoDtoAdapter.toJson(jsonWriter, clientDto.getInfo());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

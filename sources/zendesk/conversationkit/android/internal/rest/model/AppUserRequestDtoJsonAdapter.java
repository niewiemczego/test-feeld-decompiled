package zendesk.conversationkit.android.internal.rest.model;

import com.braze.models.FeatureFlag;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/AppUserRequestDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/AppUserRequestDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "clientDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableMapOfStringAnyAdapter", "", "", "", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppUserRequestDtoJsonAdapter.kt */
public final class AppUserRequestDtoJsonAdapter extends JsonAdapter<AppUserRequestDto> {
    private final JsonAdapter<ClientDto> clientDtoAdapter;
    private volatile Constructor<AppUserRequestDto> constructorRef;
    private final JsonAdapter<Map<String, Object>> nullableMapOfStringAnyAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public AppUserRequestDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("client", "userId", "givenName", "surname", "email", FeatureFlag.PROPERTIES, SDKConstants.PARAM_INTENT);
        Intrinsics.checkNotNullExpressionValue(of, "of(\"client\", \"userId\", \"…, \"properties\", \"intent\")");
        this.options = of;
        JsonAdapter<ClientDto> adapter = moshi.adapter(ClientDto.class, SetsKt.emptySet(), "client");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(ClientDto:…    emptySet(), \"client\")");
        this.clientDtoAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "userId");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…    emptySet(), \"userId\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<Map<String, Object>> adapter3 = moshi.adapter(Types.newParameterizedType(Map.class, String.class, Object.class), SetsKt.emptySet(), FeatureFlag.PROPERTIES);
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP…emptySet(), \"properties\")");
        this.nullableMapOfStringAnyAdapter = adapter3;
        JsonAdapter<String> adapter4 = moshi.adapter(String.class, SetsKt.emptySet(), SDKConstants.PARAM_INTENT);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(String::cl…ptySet(),\n      \"intent\")");
        this.stringAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(39);
        sb.append("GeneratedJsonAdapter(").append("AppUserRequestDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public AppUserRequestDto fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i = -1;
        ClientDto clientDto = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Map map = null;
        String str5 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    clientDto = this.clientDtoAdapter.fromJson(jsonReader2);
                    if (clientDto != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("client", "client", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"client\",…        \"client\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    str = this.nullableStringAdapter.fromJson(jsonReader2);
                    i &= -3;
                    break;
                case 2:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i &= -5;
                    break;
                case 3:
                    str3 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i &= -9;
                    break;
                case 4:
                    str4 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i &= -17;
                    break;
                case 5:
                    map = this.nullableMapOfStringAnyAdapter.fromJson(jsonReader2);
                    i &= -33;
                    break;
                case 6:
                    str5 = this.stringAdapter.fromJson(jsonReader2);
                    if (str5 != null) {
                        i &= -65;
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull(SDKConstants.PARAM_INTENT, SDKConstants.PARAM_INTENT, jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"intent\",…t\",\n              reader)");
                        throw unexpectedNull2;
                    }
            }
        }
        jsonReader.endObject();
        if (i != -127) {
            Constructor<AppUserRequestDto> constructor = this.constructorRef;
            if (constructor == null) {
                constructor = AppUserRequestDto.class.getDeclaredConstructor(new Class[]{ClientDto.class, String.class, String.class, String.class, String.class, Map.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "AppUserRequestDto::class…his.constructorRef = it }");
            }
            Object[] objArr = new Object[9];
            if (clientDto != null) {
                objArr[0] = clientDto;
                objArr[1] = str;
                objArr[2] = str2;
                objArr[3] = str3;
                objArr[4] = str4;
                objArr[5] = map;
                objArr[6] = str5;
                objArr[7] = Integer.valueOf(i);
                objArr[8] = null;
                AppUserRequestDto newInstance = constructor.newInstance(objArr);
                Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException missingProperty = Util.missingProperty("client", "client", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"client\", \"client\", reader)");
            throw missingProperty;
        } else if (clientDto == null) {
            JsonDataException missingProperty2 = Util.missingProperty("client", "client", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"client\", \"client\", reader)");
            throw missingProperty2;
        } else if (str5 != null) {
            return new AppUserRequestDto(clientDto, str, str2, str3, str4, map, str5);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public void toJson(JsonWriter jsonWriter, AppUserRequestDto appUserRequestDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (appUserRequestDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("client");
            this.clientDtoAdapter.toJson(jsonWriter, appUserRequestDto.getClient());
            jsonWriter.name("userId");
            this.nullableStringAdapter.toJson(jsonWriter, appUserRequestDto.getUserId());
            jsonWriter.name("givenName");
            this.nullableStringAdapter.toJson(jsonWriter, appUserRequestDto.getGivenName());
            jsonWriter.name("surname");
            this.nullableStringAdapter.toJson(jsonWriter, appUserRequestDto.getSurname());
            jsonWriter.name("email");
            this.nullableStringAdapter.toJson(jsonWriter, appUserRequestDto.getEmail());
            jsonWriter.name(FeatureFlag.PROPERTIES);
            this.nullableMapOfStringAnyAdapter.toJson(jsonWriter, appUserRequestDto.getProperties());
            jsonWriter.name(SDKConstants.PARAM_INTENT);
            this.stringAdapter.toJson(jsonWriter, appUserRequestDto.getIntent());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

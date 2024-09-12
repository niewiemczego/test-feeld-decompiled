package zendesk.conversationkit.android.internal.rest.model;

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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/AuthorDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/AuthorDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "clientDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthorDtoJsonAdapter.kt */
public final class AuthorDtoJsonAdapter extends JsonAdapter<AuthorDto> {
    private final JsonAdapter<ClientDto> clientDtoAdapter;
    private volatile Constructor<AuthorDto> constructorRef;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public AuthorDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("appUserId", "role", "client", "sessionId");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"appUserId\", \"role\", …ient\",\n      \"sessionId\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "appUserId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…Set(),\n      \"appUserId\")");
        this.stringAdapter = adapter;
        JsonAdapter<ClientDto> adapter2 = moshi.adapter(ClientDto.class, SetsKt.emptySet(), "client");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(ClientDto:…    emptySet(), \"client\")");
        this.clientDtoAdapter = adapter2;
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, SetsKt.emptySet(), "sessionId");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(String::cl… emptySet(), \"sessionId\")");
        this.nullableStringAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(31);
        sb.append("GeneratedJsonAdapter(").append("AuthorDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public AuthorDto fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i = -1;
        String str = null;
        String str2 = null;
        ClientDto clientDto = null;
        String str3 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader2.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader2);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("appUserId", "appUserId", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"appUserI…     \"appUserId\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(jsonReader2);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("role", "role", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"role\", \"role\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                clientDto = this.clientDtoAdapter.fromJson(jsonReader2);
                if (clientDto == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("client", "client", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"client\",…        \"client\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                str3 = this.nullableStringAdapter.fromJson(jsonReader2);
                i &= -9;
            }
        }
        jsonReader.endObject();
        if (i != -9) {
            Constructor<AuthorDto> constructor = this.constructorRef;
            if (constructor == null) {
                constructor = AuthorDto.class.getDeclaredConstructor(new Class[]{String.class, String.class, ClientDto.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "AuthorDto::class.java.ge…his.constructorRef = it }");
            }
            Object[] objArr = new Object[6];
            if (str != null) {
                objArr[0] = str;
                if (str2 != null) {
                    objArr[1] = str2;
                    if (clientDto != null) {
                        objArr[2] = clientDto;
                        objArr[3] = str3;
                        objArr[4] = Integer.valueOf(i);
                        objArr[5] = null;
                        AuthorDto newInstance = constructor.newInstance(objArr);
                        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                        return newInstance;
                    }
                    JsonDataException missingProperty = Util.missingProperty("client", "client", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"client\", \"client\", reader)");
                    throw missingProperty;
                }
                JsonDataException missingProperty2 = Util.missingProperty("role", "role", jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"role\", \"role\", reader)");
                throw missingProperty2;
            }
            JsonDataException missingProperty3 = Util.missingProperty("appUserId", "appUserId", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"appUserId\", \"appUserId\", reader)");
            throw missingProperty3;
        } else if (str == null) {
            JsonDataException missingProperty4 = Util.missingProperty("appUserId", "appUserId", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"appUserId\", \"appUserId\", reader)");
            throw missingProperty4;
        } else if (str2 == null) {
            JsonDataException missingProperty5 = Util.missingProperty("role", "role", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"role\", \"role\", reader)");
            throw missingProperty5;
        } else if (clientDto != null) {
            return new AuthorDto(str, str2, clientDto, str3);
        } else {
            JsonDataException missingProperty6 = Util.missingProperty("client", "client", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"client\", \"client\", reader)");
            throw missingProperty6;
        }
    }

    public void toJson(JsonWriter jsonWriter, AuthorDto authorDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (authorDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("appUserId");
            this.stringAdapter.toJson(jsonWriter, authorDto.getAppUserId());
            jsonWriter.name("role");
            this.stringAdapter.toJson(jsonWriter, authorDto.getRole());
            jsonWriter.name("client");
            this.clientDtoAdapter.toJson(jsonWriter, authorDto.getClient());
            jsonWriter.name("sessionId");
            this.nullableStringAdapter.toJson(jsonWriter, authorDto.getSessionId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

package zendesk.conversationkit.android.internal.rest.user.model;

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
import zendesk.conversationkit.android.internal.rest.model.ClientDto;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/user/model/LoginRequestBodyJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/user/model/LoginRequestBody;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "clientDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoginRequestBodyJsonAdapter.kt */
public final class LoginRequestBodyJsonAdapter extends JsonAdapter<LoginRequestBody> {
    private final JsonAdapter<ClientDto> clientDtoAdapter;
    private volatile Constructor<LoginRequestBody> constructorRef;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public LoginRequestBodyJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("userId", "client", "appUserId", "sessionToken");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"userId\", \"client\", \"…d\",\n      \"sessionToken\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "userId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ptySet(),\n      \"userId\")");
        this.stringAdapter = adapter;
        JsonAdapter<ClientDto> adapter2 = moshi.adapter(ClientDto.class, SetsKt.emptySet(), "client");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(ClientDto:…    emptySet(), \"client\")");
        this.clientDtoAdapter = adapter2;
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, SetsKt.emptySet(), "appUserId");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(String::cl… emptySet(), \"appUserId\")");
        this.nullableStringAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(38);
        sb.append("GeneratedJsonAdapter(").append("LoginRequestBody").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public LoginRequestBody fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i = -1;
        String str = null;
        ClientDto clientDto = null;
        String str2 = null;
        String str3 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader2.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader2);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("userId", "userId", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"userId\",…        \"userId\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                clientDto = this.clientDtoAdapter.fromJson(jsonReader2);
                if (clientDto == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("client", "client", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"client\",…        \"client\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str2 = this.nullableStringAdapter.fromJson(jsonReader2);
                i &= -5;
            } else if (selectName == 3) {
                str3 = this.nullableStringAdapter.fromJson(jsonReader2);
                i &= -9;
            }
        }
        jsonReader.endObject();
        if (i != -13) {
            Constructor<LoginRequestBody> constructor = this.constructorRef;
            if (constructor == null) {
                constructor = LoginRequestBody.class.getDeclaredConstructor(new Class[]{String.class, ClientDto.class, String.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "LoginRequestBody::class.…his.constructorRef = it }");
            }
            Object[] objArr = new Object[6];
            if (str != null) {
                objArr[0] = str;
                if (clientDto != null) {
                    objArr[1] = clientDto;
                    objArr[2] = str2;
                    objArr[3] = str3;
                    objArr[4] = Integer.valueOf(i);
                    objArr[5] = null;
                    LoginRequestBody newInstance = constructor.newInstance(objArr);
                    Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                    return newInstance;
                }
                JsonDataException missingProperty = Util.missingProperty("client", "client", jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"client\", \"client\", reader)");
                throw missingProperty;
            }
            JsonDataException missingProperty2 = Util.missingProperty("userId", "userId", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"userId\", \"userId\", reader)");
            throw missingProperty2;
        } else if (str == null) {
            JsonDataException missingProperty3 = Util.missingProperty("userId", "userId", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"userId\", \"userId\", reader)");
            throw missingProperty3;
        } else if (clientDto != null) {
            return new LoginRequestBody(str, clientDto, str2, str3);
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("client", "client", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"client\", \"client\", reader)");
            throw missingProperty4;
        }
    }

    public void toJson(JsonWriter jsonWriter, LoginRequestBody loginRequestBody) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (loginRequestBody != null) {
            jsonWriter.beginObject();
            jsonWriter.name("userId");
            this.stringAdapter.toJson(jsonWriter, loginRequestBody.getUserId());
            jsonWriter.name("client");
            this.clientDtoAdapter.toJson(jsonWriter, loginRequestBody.getClient());
            jsonWriter.name("appUserId");
            this.nullableStringAdapter.toJson(jsonWriter, loginRequestBody.getAppUserId());
            jsonWriter.name("sessionToken");
            this.nullableStringAdapter.toJson(jsonWriter, loginRequestBody.getSessionToken());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

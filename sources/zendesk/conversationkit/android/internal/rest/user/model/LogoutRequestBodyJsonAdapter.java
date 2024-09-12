package zendesk.conversationkit.android.internal.rest.user.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.ClientDto;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/user/model/LogoutRequestBodyJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/user/model/LogoutRequestBody;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "clientDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LogoutRequestBodyJsonAdapter.kt */
public final class LogoutRequestBodyJsonAdapter extends JsonAdapter<LogoutRequestBody> {
    private final JsonAdapter<ClientDto> clientDtoAdapter;
    private final JsonReader.Options options;

    public LogoutRequestBodyJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("client");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"client\")");
        this.options = of;
        JsonAdapter<ClientDto> adapter = moshi.adapter(ClientDto.class, SetsKt.emptySet(), "client");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(ClientDto:…    emptySet(), \"client\")");
        this.clientDtoAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(39);
        sb.append("GeneratedJsonAdapter(").append("LogoutRequestBody").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public LogoutRequestBody fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        ClientDto clientDto = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0 && (clientDto = this.clientDtoAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("client", "client", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"client\",…        \"client\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        if (clientDto != null) {
            return new LogoutRequestBody(clientDto);
        }
        JsonDataException missingProperty = Util.missingProperty("client", "client", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"client\", \"client\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, LogoutRequestBody logoutRequestBody) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (logoutRequestBody != null) {
            jsonWriter.beginObject();
            jsonWriter.name("client");
            this.clientDtoAdapter.toJson(jsonWriter, logoutRequestBody.getClient());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

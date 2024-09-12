package zendesk.conversationkit.android.internal.rest.model;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.ConversationType;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/CreateConversationRequestDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/CreateConversationRequestDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "clientDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "conversationTypeAdapter", "Lzendesk/conversationkit/android/model/ConversationType;", "intentAdapter", "Lzendesk/conversationkit/android/internal/rest/model/Intent;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CreateConversationRequestDtoJsonAdapter.kt */
public final class CreateConversationRequestDtoJsonAdapter extends JsonAdapter<CreateConversationRequestDto> {
    private final JsonAdapter<ClientDto> clientDtoAdapter;
    private final JsonAdapter<ConversationType> conversationTypeAdapter;
    private final JsonAdapter<Intent> intentAdapter;
    private final JsonReader.Options options;

    public CreateConversationRequestDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("type", SDKConstants.PARAM_INTENT, "client");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"type\", \"intent\", \"client\")");
        this.options = of;
        JsonAdapter<ConversationType> adapter = moshi.adapter(ConversationType.class, SetsKt.emptySet(), "type");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Conversati…java, emptySet(), \"type\")");
        this.conversationTypeAdapter = adapter;
        JsonAdapter<Intent> adapter2 = moshi.adapter(Intent.class, SetsKt.emptySet(), SDKConstants.PARAM_INTENT);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Intent::cl…ptySet(),\n      \"intent\")");
        this.intentAdapter = adapter2;
        JsonAdapter<ClientDto> adapter3 = moshi.adapter(ClientDto.class, SetsKt.emptySet(), "client");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(ClientDto:…    emptySet(), \"client\")");
        this.clientDtoAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(50);
        sb.append("GeneratedJsonAdapter(").append("CreateConversationRequestDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public CreateConversationRequestDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        ConversationType conversationType = null;
        Intent intent = null;
        ClientDto clientDto = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                conversationType = this.conversationTypeAdapter.fromJson(jsonReader);
                if (conversationType == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("type", "type", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"type\",\n            \"type\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                intent = this.intentAdapter.fromJson(jsonReader);
                if (intent == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(SDKConstants.PARAM_INTENT, SDKConstants.PARAM_INTENT, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"intent\",…        \"intent\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (clientDto = this.clientDtoAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("client", "client", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"client\",…        \"client\", reader)");
                throw unexpectedNull3;
            }
        }
        jsonReader.endObject();
        if (conversationType == null) {
            JsonDataException missingProperty = Util.missingProperty("type", "type", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"type\", \"type\", reader)");
            throw missingProperty;
        } else if (intent == null) {
            JsonDataException missingProperty2 = Util.missingProperty(SDKConstants.PARAM_INTENT, SDKConstants.PARAM_INTENT, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"intent\", \"intent\", reader)");
            throw missingProperty2;
        } else if (clientDto != null) {
            return new CreateConversationRequestDto(conversationType, intent, clientDto);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("client", "client", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"client\", \"client\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, CreateConversationRequestDto createConversationRequestDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (createConversationRequestDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("type");
            this.conversationTypeAdapter.toJson(jsonWriter, createConversationRequestDto.getType());
            jsonWriter.name(SDKConstants.PARAM_INTENT);
            this.intentAdapter.toJson(jsonWriter, createConversationRequestDto.getIntent());
            jsonWriter.name("client");
            this.clientDtoAdapter.toJson(jsonWriter, createConversationRequestDto.getClient());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

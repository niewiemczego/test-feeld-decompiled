package zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.jwt;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessage;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "proactiveMessageAuthorAdapter", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageAuthor;", "proactiveMessageContentAdapter", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageContent;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProactiveMessageJsonAdapter.kt */
public final class ProactiveMessageJsonAdapter extends JsonAdapter<ProactiveMessage> {
    private final JsonReader.Options options;
    private final JsonAdapter<ProactiveMessageAuthor> proactiveMessageAuthorAdapter;
    private final JsonAdapter<ProactiveMessageContent> proactiveMessageContentAdapter;

    public ProactiveMessageJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("author", "content");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"author\", \"content\")");
        this.options = of;
        JsonAdapter<ProactiveMessageAuthor> adapter = moshi.adapter(ProactiveMessageAuthor.class, SetsKt.emptySet(), "author");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(ProactiveM…va, emptySet(), \"author\")");
        this.proactiveMessageAuthorAdapter = adapter;
        JsonAdapter<ProactiveMessageContent> adapter2 = moshi.adapter(ProactiveMessageContent.class, SetsKt.emptySet(), "content");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(ProactiveM…a, emptySet(), \"content\")");
        this.proactiveMessageContentAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(38);
        sb.append("GeneratedJsonAdapter(").append("ProactiveMessage").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public ProactiveMessage fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        ProactiveMessageAuthor proactiveMessageAuthor = null;
        ProactiveMessageContent proactiveMessageContent = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                proactiveMessageAuthor = this.proactiveMessageAuthorAdapter.fromJson(jsonReader);
                if (proactiveMessageAuthor == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("author", "author", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"author\", \"author\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (proactiveMessageContent = this.proactiveMessageContentAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("content", "content", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"content\", \"content\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (proactiveMessageAuthor == null) {
            JsonDataException missingProperty = Util.missingProperty("author", "author", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"author\", \"author\", reader)");
            throw missingProperty;
        } else if (proactiveMessageContent != null) {
            return new ProactiveMessage(proactiveMessageAuthor, proactiveMessageContent);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("content", "content", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"content\", \"content\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(JsonWriter jsonWriter, ProactiveMessage proactiveMessage) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (proactiveMessage != null) {
            jsonWriter.beginObject();
            jsonWriter.name("author");
            this.proactiveMessageAuthorAdapter.toJson(jsonWriter, proactiveMessage.getAuthor());
            jsonWriter.name("content");
            this.proactiveMessageContentAdapter.toJson(jsonWriter, proactiveMessage.getContent());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

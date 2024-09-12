package zendesk.conversationkit.android.internal.user;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.user.Jwt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lzendesk/conversationkit/android/internal/user/Jwt_UnifiedJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/user/Jwt$Unified;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Jwt_UnifiedJsonAdapter.kt */
public final class Jwt_UnifiedJsonAdapter extends JsonAdapter<Jwt.Unified> {
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public Jwt_UnifiedJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("external_id");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"external_id\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "externalId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…et(),\n      \"externalId\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(33);
        sb.append("GeneratedJsonAdapter(").append("Jwt.Unified").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public Jwt.Unified fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0 && (str = this.stringAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("externalId", "external_id", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"external…   \"external_id\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        if (str != null) {
            return new Jwt.Unified(str);
        }
        JsonDataException missingProperty = Util.missingProperty("externalId", "external_id", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"externa…\", \"external_id\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, Jwt.Unified unified) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (unified != null) {
            jsonWriter.beginObject();
            jsonWriter.name("external_id");
            this.stringAdapter.toJson(jsonWriter, unified.getExternalId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

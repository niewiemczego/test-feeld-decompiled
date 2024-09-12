package zendesk.conversationkit.android.model;

import com.facebook.hermes.intl.Constants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.MessageAction;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lzendesk/conversationkit/android/model/MessageAction_WebViewJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/MessageAction$WebView;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "nullableMapOfStringAnyAdapter", "", "", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageAction_WebViewJsonAdapter.kt */
public final class MessageAction_WebViewJsonAdapter extends JsonAdapter<MessageAction.WebView> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<Map<String, Object>> nullableMapOfStringAnyAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public MessageAction_WebViewJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", TtmlNode.TAG_METADATA, "text", "uri", "fallback", Constants.COLLATION_DEFAULT);
        Intrinsics.checkNotNullExpressionValue(of, "of(\"id\", \"metadata\", \"te…   \"fallback\", \"default\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<Map<String, Object>> adapter2 = moshi.adapter(Types.newParameterizedType(Map.class, String.class, Object.class), SetsKt.emptySet(), TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…, emptySet(), \"metadata\")");
        this.nullableMapOfStringAnyAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.TYPE, SetsKt.emptySet(), Constants.COLLATION_DEFAULT);
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…tySet(),\n      \"default\")");
        this.booleanAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(43);
        sb.append("GeneratedJsonAdapter(").append("MessageAction.WebView").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public MessageAction.WebView fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Boolean bool = null;
        String str = null;
        Map map = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str = this.stringAdapter.fromJson(jsonReader);
                    if (str != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    map = this.nullableMapOfStringAnyAdapter.fromJson(jsonReader);
                    break;
                case 2:
                    str2 = this.stringAdapter.fromJson(jsonReader);
                    if (str2 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("text", "text", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"text\", \"text\",\n            reader)");
                        throw unexpectedNull2;
                    }
                case 3:
                    str3 = this.stringAdapter.fromJson(jsonReader);
                    if (str3 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("uri", "uri", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"uri\", \"uri\", reader)");
                        throw unexpectedNull3;
                    }
                case 4:
                    str4 = this.stringAdapter.fromJson(jsonReader);
                    if (str4 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("fallback", "fallback", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"fallback…      \"fallback\", reader)");
                        throw unexpectedNull4;
                    }
                case 5:
                    bool = this.booleanAdapter.fromJson(jsonReader);
                    if (bool != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull(Constants.COLLATION_DEFAULT, Constants.COLLATION_DEFAULT, jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"default\"…       \"default\", reader)");
                        throw unexpectedNull5;
                    }
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("id", "id", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("text", "text", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"text\", \"text\", reader)");
            throw missingProperty2;
        } else if (str3 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("uri", "uri", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"uri\", \"uri\", reader)");
            throw missingProperty3;
        } else if (str4 == null) {
            JsonDataException missingProperty4 = Util.missingProperty("fallback", "fallback", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"fallback\", \"fallback\", reader)");
            throw missingProperty4;
        } else if (bool != null) {
            return new MessageAction.WebView(str, map, str2, str3, str4, bool.booleanValue());
        } else {
            JsonDataException missingProperty5 = Util.missingProperty(Constants.COLLATION_DEFAULT, Constants.COLLATION_DEFAULT, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"default\", \"default\", reader)");
            throw missingProperty5;
        }
    }

    public void toJson(JsonWriter jsonWriter, MessageAction.WebView webView) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (webView != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, webView.getId());
            jsonWriter.name(TtmlNode.TAG_METADATA);
            this.nullableMapOfStringAnyAdapter.toJson(jsonWriter, webView.getMetadata());
            jsonWriter.name("text");
            this.stringAdapter.toJson(jsonWriter, webView.getText());
            jsonWriter.name("uri");
            this.stringAdapter.toJson(jsonWriter, webView.getUri());
            jsonWriter.name("fallback");
            this.stringAdapter.toJson(jsonWriter, webView.getFallback());
            jsonWriter.name(Constants.COLLATION_DEFAULT);
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(webView.getDefault()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
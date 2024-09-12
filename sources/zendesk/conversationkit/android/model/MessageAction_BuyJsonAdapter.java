package zendesk.conversationkit.android.model;

import com.google.firebase.analytics.FirebaseAnalytics;
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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lzendesk/conversationkit/android/model/MessageAction_BuyJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/MessageAction$Buy;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "longAdapter", "", "messageActionBuyStateAdapter", "Lzendesk/conversationkit/android/model/MessageActionBuyState;", "nullableMapOfStringAnyAdapter", "", "", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageAction_BuyJsonAdapter.kt */
public final class MessageAction_BuyJsonAdapter extends JsonAdapter<MessageAction.Buy> {
    private final JsonAdapter<Long> longAdapter;
    private final JsonAdapter<MessageActionBuyState> messageActionBuyStateAdapter;
    private final JsonAdapter<Map<String, Object>> nullableMapOfStringAnyAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public MessageAction_BuyJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", TtmlNode.TAG_METADATA, "text", "uri", "amount", FirebaseAnalytics.Param.CURRENCY, "state");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"id\", \"metadata\", \"te…nt\", \"currency\", \"state\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<Map<String, Object>> adapter2 = moshi.adapter(Types.newParameterizedType(Map.class, String.class, Object.class), SetsKt.emptySet(), TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…, emptySet(), \"metadata\")");
        this.nullableMapOfStringAnyAdapter = adapter2;
        JsonAdapter<Long> adapter3 = moshi.adapter(Long.TYPE, SetsKt.emptySet(), "amount");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Long::clas…va, emptySet(), \"amount\")");
        this.longAdapter = adapter3;
        JsonAdapter<MessageActionBuyState> adapter4 = moshi.adapter(MessageActionBuyState.class, SetsKt.emptySet(), "state");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(MessageAct…ava, emptySet(), \"state\")");
        this.messageActionBuyStateAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(39);
        sb.append("GeneratedJsonAdapter(").append("MessageAction.Buy").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public MessageAction.Buy fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        Long l = null;
        String str = null;
        Map map = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        MessageActionBuyState messageActionBuyState = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str = this.stringAdapter.fromJson(jsonReader2);
                    if (str != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    map = this.nullableMapOfStringAnyAdapter.fromJson(jsonReader2);
                    break;
                case 2:
                    str2 = this.stringAdapter.fromJson(jsonReader2);
                    if (str2 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("text", "text", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"text\", \"text\",\n            reader)");
                        throw unexpectedNull2;
                    }
                case 3:
                    str3 = this.stringAdapter.fromJson(jsonReader2);
                    if (str3 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("uri", "uri", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"uri\", \"uri\", reader)");
                        throw unexpectedNull3;
                    }
                case 4:
                    l = this.longAdapter.fromJson(jsonReader2);
                    if (l != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("amount", "amount", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"amount\",…unt\",\n            reader)");
                        throw unexpectedNull4;
                    }
                case 5:
                    str4 = this.stringAdapter.fromJson(jsonReader2);
                    if (str4 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull(FirebaseAnalytics.Param.CURRENCY, FirebaseAnalytics.Param.CURRENCY, jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"currency…      \"currency\", reader)");
                        throw unexpectedNull5;
                    }
                case 6:
                    messageActionBuyState = this.messageActionBuyStateAdapter.fromJson(jsonReader2);
                    if (messageActionBuyState != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("state", "state", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"state\", \"state\", reader)");
                        throw unexpectedNull6;
                    }
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("id", "id", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("text", "text", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"text\", \"text\", reader)");
            throw missingProperty2;
        } else if (str3 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("uri", "uri", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"uri\", \"uri\", reader)");
            throw missingProperty3;
        } else if (l != null) {
            long longValue = l.longValue();
            if (str4 == null) {
                JsonDataException missingProperty4 = Util.missingProperty(FirebaseAnalytics.Param.CURRENCY, FirebaseAnalytics.Param.CURRENCY, jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"currency\", \"currency\", reader)");
                throw missingProperty4;
            } else if (messageActionBuyState != null) {
                return new MessageAction.Buy(str, map, str2, str3, longValue, str4, messageActionBuyState);
            } else {
                JsonDataException missingProperty5 = Util.missingProperty("state", "state", jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"state\", \"state\", reader)");
                throw missingProperty5;
            }
        } else {
            JsonDataException missingProperty6 = Util.missingProperty("amount", "amount", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"amount\", \"amount\", reader)");
            throw missingProperty6;
        }
    }

    public void toJson(JsonWriter jsonWriter, MessageAction.Buy buy) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (buy != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, buy.getId());
            jsonWriter.name(TtmlNode.TAG_METADATA);
            this.nullableMapOfStringAnyAdapter.toJson(jsonWriter, buy.getMetadata());
            jsonWriter.name("text");
            this.stringAdapter.toJson(jsonWriter, buy.getText());
            jsonWriter.name("uri");
            this.stringAdapter.toJson(jsonWriter, buy.getUri());
            jsonWriter.name("amount");
            this.longAdapter.toJson(jsonWriter, Long.valueOf(buy.getAmount()));
            jsonWriter.name(FirebaseAnalytics.Param.CURRENCY);
            this.stringAdapter.toJson(jsonWriter, buy.getCurrency());
            jsonWriter.name("state");
            this.messageActionBuyStateAdapter.toJson(jsonWriter, buy.getState());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

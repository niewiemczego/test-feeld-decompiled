package zendesk.conversationkit.android.model;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.Field;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lzendesk/conversationkit/android/model/Field_TextJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/Field$Text;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Field_TextJsonAdapter.kt */
public final class Field_TextJsonAdapter extends JsonAdapter<Field.Text> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public Field_TextJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "name", "label", ReactTextInputShadowNode.PROP_PLACEHOLDER, SDKConstants.PARAM_CONTEXT_MIN_SIZE, SDKConstants.PARAM_CONTEXT_MAX_SIZE, "text");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"id\", \"name\", \"label\"…Size\", \"maxSize\", \"text\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), SDKConstants.PARAM_CONTEXT_MIN_SIZE);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Int::class…a, emptySet(), \"minSize\")");
        this.intAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("GeneratedJsonAdapter(").append("Field.Text").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public Field.Text fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        Integer num = null;
        Integer num2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (true) {
            String str6 = str5;
            if (jsonReader.hasNext()) {
                switch (jsonReader2.selectName(this.options)) {
                    case -1:
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        break;
                    case 0:
                        str = this.stringAdapter.fromJson(jsonReader2);
                        if (str == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                            throw unexpectedNull;
                        }
                        break;
                    case 1:
                        str2 = this.stringAdapter.fromJson(jsonReader2);
                        if (str2 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("name", "name", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"name\", \"name\",\n            reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 2:
                        str3 = this.stringAdapter.fromJson(jsonReader2);
                        if (str3 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("label", "label", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"label\", …bel\",\n            reader)");
                            throw unexpectedNull3;
                        }
                        break;
                    case 3:
                        str4 = this.stringAdapter.fromJson(jsonReader2);
                        if (str4 == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull(ReactTextInputShadowNode.PROP_PLACEHOLDER, ReactTextInputShadowNode.PROP_PLACEHOLDER, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"placehol…\", \"placeholder\", reader)");
                            throw unexpectedNull4;
                        }
                        break;
                    case 4:
                        num = this.intAdapter.fromJson(jsonReader2);
                        if (num == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull(SDKConstants.PARAM_CONTEXT_MIN_SIZE, SDKConstants.PARAM_CONTEXT_MIN_SIZE, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"minSize\"…       \"minSize\", reader)");
                            throw unexpectedNull5;
                        }
                        break;
                    case 5:
                        num2 = this.intAdapter.fromJson(jsonReader2);
                        if (num2 == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull(SDKConstants.PARAM_CONTEXT_MAX_SIZE, SDKConstants.PARAM_CONTEXT_MAX_SIZE, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"maxSize\"…       \"maxSize\", reader)");
                            throw unexpectedNull6;
                        }
                        break;
                    case 6:
                        str5 = this.stringAdapter.fromJson(jsonReader2);
                        if (str5 != null) {
                            continue;
                        } else {
                            JsonDataException unexpectedNull7 = Util.unexpectedNull("text", "text", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "unexpectedNull(\"text\", \"text\",\n            reader)");
                            throw unexpectedNull7;
                        }
                }
                str5 = str6;
            } else {
                jsonReader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty("id", "id", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"id\", \"id\", reader)");
                    throw missingProperty;
                } else if (str2 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("name", "name", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"name\", \"name\", reader)");
                    throw missingProperty2;
                } else if (str3 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("label", "label", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"label\", \"label\", reader)");
                    throw missingProperty3;
                } else if (str4 == null) {
                    JsonDataException missingProperty4 = Util.missingProperty(ReactTextInputShadowNode.PROP_PLACEHOLDER, ReactTextInputShadowNode.PROP_PLACEHOLDER, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"placeho…der\",\n            reader)");
                    throw missingProperty4;
                } else if (num != null) {
                    int intValue = num.intValue();
                    if (num2 != null) {
                        int intValue2 = num2.intValue();
                        if (str6 != null) {
                            return new Field.Text(str, str2, str3, str4, intValue, intValue2, str6);
                        }
                        JsonDataException missingProperty5 = Util.missingProperty("text", "text", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"text\", \"text\", reader)");
                        throw missingProperty5;
                    }
                    JsonDataException missingProperty6 = Util.missingProperty(SDKConstants.PARAM_CONTEXT_MAX_SIZE, SDKConstants.PARAM_CONTEXT_MAX_SIZE, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"maxSize\", \"maxSize\", reader)");
                    throw missingProperty6;
                } else {
                    JsonDataException missingProperty7 = Util.missingProperty(SDKConstants.PARAM_CONTEXT_MIN_SIZE, SDKConstants.PARAM_CONTEXT_MIN_SIZE, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty7, "missingProperty(\"minSize\", \"minSize\", reader)");
                    throw missingProperty7;
                }
            }
        }
    }

    public void toJson(JsonWriter jsonWriter, Field.Text text) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (text != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, text.getId());
            jsonWriter.name("name");
            this.stringAdapter.toJson(jsonWriter, text.getName());
            jsonWriter.name("label");
            this.stringAdapter.toJson(jsonWriter, text.getLabel());
            jsonWriter.name(ReactTextInputShadowNode.PROP_PLACEHOLDER);
            this.stringAdapter.toJson(jsonWriter, text.getPlaceholder());
            jsonWriter.name(SDKConstants.PARAM_CONTEXT_MIN_SIZE);
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(text.getMinSize()));
            jsonWriter.name(SDKConstants.PARAM_CONTEXT_MAX_SIZE);
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(text.getMaxSize()));
            jsonWriter.name("text");
            this.stringAdapter.toJson(jsonWriter, text.getText());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

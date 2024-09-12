package zendesk.conversationkit.android.model;

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

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lzendesk/conversationkit/android/model/Field_EmailJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/Field$Email;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Field_EmailJsonAdapter.kt */
public final class Field_EmailJsonAdapter extends JsonAdapter<Field.Email> {
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public Field_EmailJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "name", "label", ReactTextInputShadowNode.PROP_PLACEHOLDER, "email");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"id\", \"name\", \"label\"…  \"placeholder\", \"email\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(33);
        sb.append("GeneratedJsonAdapter(").append("Field.Email").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public Field.Email fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("name", "name", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str3 = this.stringAdapter.fromJson(jsonReader);
                if (str3 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("label", "label", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"label\", …bel\",\n            reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                str4 = this.stringAdapter.fromJson(jsonReader);
                if (str4 == null) {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull(ReactTextInputShadowNode.PROP_PLACEHOLDER, ReactTextInputShadowNode.PROP_PLACEHOLDER, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"placehol…\", \"placeholder\", reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName == 4 && (str5 = this.stringAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull5 = Util.unexpectedNull("email", "email", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"email\", …ail\",\n            reader)");
                throw unexpectedNull5;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("id", "id", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("name", "name", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"name\", \"name\", reader)");
            throw missingProperty2;
        } else if (str3 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("label", "label", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"label\", \"label\", reader)");
            throw missingProperty3;
        } else if (str4 == null) {
            JsonDataException missingProperty4 = Util.missingProperty(ReactTextInputShadowNode.PROP_PLACEHOLDER, ReactTextInputShadowNode.PROP_PLACEHOLDER, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"placeho…der\",\n            reader)");
            throw missingProperty4;
        } else if (str5 != null) {
            return new Field.Email(str, str2, str3, str4, str5);
        } else {
            JsonDataException missingProperty5 = Util.missingProperty("email", "email", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"email\", \"email\", reader)");
            throw missingProperty5;
        }
    }

    public void toJson(JsonWriter jsonWriter, Field.Email email) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (email != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, email.getId());
            jsonWriter.name("name");
            this.stringAdapter.toJson(jsonWriter, email.getName());
            jsonWriter.name("label");
            this.stringAdapter.toJson(jsonWriter, email.getLabel());
            jsonWriter.name(ReactTextInputShadowNode.PROP_PLACEHOLDER);
            this.stringAdapter.toJson(jsonWriter, email.getPlaceholder());
            jsonWriter.name("email");
            this.stringAdapter.toJson(jsonWriter, email.getEmail());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

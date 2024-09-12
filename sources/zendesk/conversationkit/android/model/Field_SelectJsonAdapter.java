package zendesk.conversationkit.android.model;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.Field;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lzendesk/conversationkit/android/model/Field_SelectJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/Field$Select;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "listOfFieldOptionAdapter", "", "Lzendesk/conversationkit/android/model/FieldOption;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Field_SelectJsonAdapter.kt */
public final class Field_SelectJsonAdapter extends JsonAdapter<Field.Select> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<List<FieldOption>> listOfFieldOptionAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public Field_SelectJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "name", "label", ReactTextInputShadowNode.PROP_PLACEHOLDER, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "selectSize", "select");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"id\", \"name\", \"label\"…, \"selectSize\", \"select\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<List<FieldOption>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, FieldOption.class), SetsKt.emptySet(), SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…   emptySet(), \"options\")");
        this.listOfFieldOptionAdapter = adapter2;
        JsonAdapter<Integer> adapter3 = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "selectSize");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Int::class…et(),\n      \"selectSize\")");
        this.intAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(34);
        sb.append("GeneratedJsonAdapter(").append("Field.Select").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public Field.Select fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        Integer num = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        List list = null;
        List list2 = null;
        while (true) {
            List list3 = list2;
            Integer num2 = num;
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
                        list = this.listOfFieldOptionAdapter.fromJson(jsonReader2);
                        if (list == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("options_", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"options_\", \"options\", reader)");
                            throw unexpectedNull5;
                        }
                        break;
                    case 5:
                        num = this.intAdapter.fromJson(jsonReader2);
                        if (num != null) {
                            list2 = list3;
                            continue;
                        } else {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("selectSize", "selectSize", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"selectSi…    \"selectSize\", reader)");
                            throw unexpectedNull6;
                        }
                    case 6:
                        list2 = this.listOfFieldOptionAdapter.fromJson(jsonReader2);
                        if (list2 == null) {
                            JsonDataException unexpectedNull7 = Util.unexpectedNull("select", "select", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "unexpectedNull(\"select\", \"select\", reader)");
                            throw unexpectedNull7;
                        }
                        break;
                }
                list2 = list3;
                num = num2;
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
                } else if (list == null) {
                    JsonDataException missingProperty5 = Util.missingProperty("options_", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"options_\", \"options\", reader)");
                    throw missingProperty5;
                } else if (num2 != null) {
                    int intValue = num2.intValue();
                    if (list3 != null) {
                        return new Field.Select(str, str2, str3, str4, list, intValue, list3);
                    }
                    JsonDataException missingProperty6 = Util.missingProperty("select", "select", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"select\", \"select\", reader)");
                    throw missingProperty6;
                } else {
                    JsonDataException missingProperty7 = Util.missingProperty("selectSize", "selectSize", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty7, "missingProperty(\"selectS…e\", \"selectSize\", reader)");
                    throw missingProperty7;
                }
            }
        }
    }

    public void toJson(JsonWriter jsonWriter, Field.Select select) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (select != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, select.getId());
            jsonWriter.name("name");
            this.stringAdapter.toJson(jsonWriter, select.getName());
            jsonWriter.name("label");
            this.stringAdapter.toJson(jsonWriter, select.getLabel());
            jsonWriter.name(ReactTextInputShadowNode.PROP_PLACEHOLDER);
            this.stringAdapter.toJson(jsonWriter, select.getPlaceholder());
            jsonWriter.name(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
            this.listOfFieldOptionAdapter.toJson(jsonWriter, select.getOptions());
            jsonWriter.name("selectSize");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(select.getSelectSize()));
            jsonWriter.name("select");
            this.listOfFieldOptionAdapter.toJson(jsonWriter, select.getSelect());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

package zendesk.android.settings.internal.model;

import com.braze.models.inappmessage.InAppMessageBase;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lzendesk/android/settings/internal/model/ColorThemeDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/settings/internal/model/ColorThemeDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ColorThemeDtoJsonAdapter.kt */
public final class ColorThemeDtoJsonAdapter extends JsonAdapter<ColorThemeDto> {
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ColorThemeDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("primary_color", "message_color", "action_color", "notify_color", InAppMessageBase.ICON_COLOR);
        Intrinsics.checkNotNullExpressionValue(of, "of(\"primary_color\", \"mes…ify_color\", \"icon_color\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "primaryColor");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…(),\n      \"primaryColor\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "notifyColor");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…mptySet(), \"notifyColor\")");
        this.nullableStringAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(35);
        sb.append("GeneratedJsonAdapter(").append("ColorThemeDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public ColorThemeDto fromJson(JsonReader jsonReader) {
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
                    JsonDataException unexpectedNull = Util.unexpectedNull("primaryColor", "primary_color", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"primaryC… \"primary_color\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("messageColor", "message_color", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"messageC… \"message_color\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str3 = this.stringAdapter.fromJson(jsonReader);
                if (str3 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("actionColor", "action_color", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"actionCo…, \"action_color\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                str4 = this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 4) {
                str5 = this.nullableStringAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("primaryColor", "primary_color", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"primary…lor\",\n            reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("messageColor", "message_color", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"message…lor\",\n            reader)");
            throw missingProperty2;
        } else if (str3 != null) {
            return new ColorThemeDto(str, str2, str3, str4, str5);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("actionColor", "action_color", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"actionC…lor\",\n            reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, ColorThemeDto colorThemeDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (colorThemeDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("primary_color");
            this.stringAdapter.toJson(jsonWriter, colorThemeDto.getPrimaryColor());
            jsonWriter.name("message_color");
            this.stringAdapter.toJson(jsonWriter, colorThemeDto.getMessageColor());
            jsonWriter.name("action_color");
            this.stringAdapter.toJson(jsonWriter, colorThemeDto.getActionColor());
            jsonWriter.name("notify_color");
            this.nullableStringAdapter.toJson(jsonWriter, colorThemeDto.getNotifyColor());
            jsonWriter.name(InAppMessageBase.ICON_COLOR);
            this.nullableStringAdapter.toJson(jsonWriter, colorThemeDto.getIconColor());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

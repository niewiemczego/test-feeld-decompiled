package zendesk.android.settings.internal.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import io.sentry.protocol.ViewHierarchyNode;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lzendesk/android/settings/internal/model/SettingsDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/settings/internal/model/SettingsDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "colorThemeDtoAdapter", "Lzendesk/android/settings/internal/model/ColorThemeDto;", "nativeMessagingDtoAdapter", "Lzendesk/android/settings/internal/model/NativeMessagingDto;", "nullableBooleanAdapter", "", "nullableStringAdapter", "", "nullableSunCoConfigDtoAdapter", "Lzendesk/android/settings/internal/model/SunCoConfigDto;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SettingsDtoJsonAdapter.kt */
public final class SettingsDtoJsonAdapter extends JsonAdapter<SettingsDto> {
    private final JsonAdapter<ColorThemeDto> colorThemeDtoAdapter;
    private final JsonAdapter<NativeMessagingDto> nativeMessagingDtoAdapter;
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonAdapter<SunCoConfigDto> nullableSunCoConfigDtoAdapter;
    private final JsonReader.Options options;

    public SettingsDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(ViewHierarchyNode.JsonKeys.IDENTIFIER, "light_theme", "dark_theme", "show_zendesk_logo", "native_messaging", "sunco_config");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"identifier\", \"light_…ssaging\", \"sunco_config\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), ViewHierarchyNode.JsonKeys.IDENTIFIER);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(), \"identifier\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<ColorThemeDto> adapter2 = moshi.adapter(ColorThemeDto.class, SetsKt.emptySet(), "lightTheme");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(ColorTheme…emptySet(), \"lightTheme\")");
        this.colorThemeDtoAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.class, SetsKt.emptySet(), "showZendeskLogo");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…Set(), \"showZendeskLogo\")");
        this.nullableBooleanAdapter = adapter3;
        JsonAdapter<NativeMessagingDto> adapter4 = moshi.adapter(NativeMessagingDto.class, SetsKt.emptySet(), "nativeMessaging");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(NativeMess…Set(), \"nativeMessaging\")");
        this.nativeMessagingDtoAdapter = adapter4;
        JsonAdapter<SunCoConfigDto> adapter5 = moshi.adapter(SunCoConfigDto.class, SetsKt.emptySet(), "sunCoConfigDto");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(SunCoConfi…ySet(), \"sunCoConfigDto\")");
        this.nullableSunCoConfigDtoAdapter = adapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(33);
        sb.append("GeneratedJsonAdapter(").append("SettingsDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public SettingsDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        ColorThemeDto colorThemeDto = null;
        ColorThemeDto colorThemeDto2 = null;
        Boolean bool = null;
        NativeMessagingDto nativeMessagingDto = null;
        SunCoConfigDto sunCoConfigDto = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 1:
                    colorThemeDto = this.colorThemeDtoAdapter.fromJson(jsonReader);
                    if (colorThemeDto != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("lightTheme", "light_theme", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"lightThe…\", \"light_theme\", reader)");
                        throw unexpectedNull;
                    }
                case 2:
                    colorThemeDto2 = this.colorThemeDtoAdapter.fromJson(jsonReader);
                    if (colorThemeDto2 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("darkTheme", "dark_theme", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"darkTheme\", \"dark_theme\", reader)");
                        throw unexpectedNull2;
                    }
                case 3:
                    bool = this.nullableBooleanAdapter.fromJson(jsonReader);
                    break;
                case 4:
                    nativeMessagingDto = this.nativeMessagingDtoAdapter.fromJson(jsonReader);
                    if (nativeMessagingDto != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("nativeMessaging", "native_messaging", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"nativeMe…ative_messaging\", reader)");
                        throw unexpectedNull3;
                    }
                case 5:
                    sunCoConfigDto = this.nullableSunCoConfigDtoAdapter.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.endObject();
        if (colorThemeDto == null) {
            JsonDataException missingProperty = Util.missingProperty("lightTheme", "light_theme", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"lightTh…\", \"light_theme\", reader)");
            throw missingProperty;
        } else if (colorThemeDto2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("darkTheme", "dark_theme", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"darkTheme\", \"dark_theme\", reader)");
            throw missingProperty2;
        } else if (nativeMessagingDto != null) {
            return new SettingsDto(str, colorThemeDto, colorThemeDto2, bool, nativeMessagingDto, sunCoConfigDto);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("nativeMessaging", "native_messaging", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"nativeM…ative_messaging\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, SettingsDto settingsDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (settingsDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name(ViewHierarchyNode.JsonKeys.IDENTIFIER);
            this.nullableStringAdapter.toJson(jsonWriter, settingsDto.getIdentifier());
            jsonWriter.name("light_theme");
            this.colorThemeDtoAdapter.toJson(jsonWriter, settingsDto.getLightTheme());
            jsonWriter.name("dark_theme");
            this.colorThemeDtoAdapter.toJson(jsonWriter, settingsDto.getDarkTheme());
            jsonWriter.name("show_zendesk_logo");
            this.nullableBooleanAdapter.toJson(jsonWriter, settingsDto.getShowZendeskLogo());
            jsonWriter.name("native_messaging");
            this.nativeMessagingDtoAdapter.toJson(jsonWriter, settingsDto.getNativeMessaging());
            jsonWriter.name("sunco_config");
            this.nullableSunCoConfigDtoAdapter.toJson(jsonWriter, settingsDto.getSunCoConfigDto());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

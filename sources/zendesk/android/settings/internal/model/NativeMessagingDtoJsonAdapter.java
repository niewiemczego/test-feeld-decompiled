package zendesk.android.settings.internal.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import io.sentry.protocol.Device;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lzendesk/android/settings/internal/model/NativeMessagingDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/settings/internal/model/NativeMessagingDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "nullableBrandDtoAdapter", "Lzendesk/android/settings/internal/model/BrandDto;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NativeMessagingDtoJsonAdapter.kt */
public final class NativeMessagingDtoJsonAdapter extends JsonAdapter<NativeMessagingDto> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<BrandDto> nullableBrandDtoAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public NativeMessagingDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("integration_id", "platform", "enabled", Device.JsonKeys.BRAND, "title", "description", "logo_url");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"integration_id\", \"pl…description\", \"logo_url\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "integrationId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…tySet(), \"integrationId\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Boolean> adapter2 = moshi.adapter(Boolean.TYPE, SetsKt.emptySet(), "enabled");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Boolean::c…tySet(),\n      \"enabled\")");
        this.booleanAdapter = adapter2;
        JsonAdapter<BrandDto> adapter3 = moshi.adapter(BrandDto.class, SetsKt.emptySet(), Device.JsonKeys.BRAND);
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(BrandDto::…     emptySet(), \"brand\")");
        this.nullableBrandDtoAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("GeneratedJsonAdapter(").append("NativeMessagingDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public NativeMessagingDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Boolean bool = null;
        String str = null;
        String str2 = null;
        BrandDto brandDto = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
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
                    str2 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 2:
                    bool = this.booleanAdapter.fromJson(jsonReader);
                    if (bool != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("enabled", "enabled", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"enabled\"…       \"enabled\", reader)");
                        throw unexpectedNull;
                    }
                case 3:
                    brandDto = this.nullableBrandDtoAdapter.fromJson(jsonReader);
                    break;
                case 4:
                    str3 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 5:
                    str4 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 6:
                    str5 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.endObject();
        if (bool != null) {
            return new NativeMessagingDto(str, str2, bool.booleanValue(), brandDto, str3, str4, str5);
        }
        JsonDataException missingProperty = Util.missingProperty("enabled", "enabled", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"enabled\", \"enabled\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, NativeMessagingDto nativeMessagingDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (nativeMessagingDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("integration_id");
            this.nullableStringAdapter.toJson(jsonWriter, nativeMessagingDto.getIntegrationId());
            jsonWriter.name("platform");
            this.nullableStringAdapter.toJson(jsonWriter, nativeMessagingDto.getPlatform());
            jsonWriter.name("enabled");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(nativeMessagingDto.getEnabled()));
            jsonWriter.name(Device.JsonKeys.BRAND);
            this.nullableBrandDtoAdapter.toJson(jsonWriter, nativeMessagingDto.getBrand());
            jsonWriter.name("title");
            this.nullableStringAdapter.toJson(jsonWriter, nativeMessagingDto.getTitle());
            jsonWriter.name("description");
            this.nullableStringAdapter.toJson(jsonWriter, nativeMessagingDto.getDescription());
            jsonWriter.name("logo_url");
            this.nullableStringAdapter.toJson(jsonWriter, nativeMessagingDto.getLogoUrl());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

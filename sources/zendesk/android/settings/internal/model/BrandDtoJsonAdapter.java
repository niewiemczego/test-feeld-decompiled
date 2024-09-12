package zendesk.android.settings.internal.model;

import com.adapty.internal.utils.AnalyticsEventTypeAdapter;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lzendesk/android/settings/internal/model/BrandDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/settings/internal/model/BrandDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableBooleanAdapter", "", "nullableLongAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BrandDtoJsonAdapter.kt */
public final class BrandDtoJsonAdapter extends JsonAdapter<BrandDto> {
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    private final JsonAdapter<Long> nullableLongAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public BrandDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "account_id", "name", "active", "deleted_at", AnalyticsEventTypeAdapter.CREATED_AT, "updated_at", "route_id", "signature_template");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"id\", \"account_id\", \"…d\", \"signature_template\")");
        this.options = of;
        JsonAdapter<Long> adapter = moshi.adapter(Long.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Long::clas…,\n      emptySet(), \"id\")");
        this.nullableLongAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "name");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…      emptySet(), \"name\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.class, SetsKt.emptySet(), "active");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…pe, emptySet(), \"active\")");
        this.nullableBooleanAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(30);
        sb.append("GeneratedJsonAdapter(").append("BrandDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public BrandDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Long l = null;
        Long l2 = null;
        String str = null;
        Boolean bool = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Long l3 = null;
        String str5 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    l = this.nullableLongAdapter.fromJson(jsonReader);
                    break;
                case 1:
                    l2 = this.nullableLongAdapter.fromJson(jsonReader);
                    break;
                case 2:
                    str = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 3:
                    bool = this.nullableBooleanAdapter.fromJson(jsonReader);
                    break;
                case 4:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 5:
                    str3 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 6:
                    str4 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 7:
                    l3 = this.nullableLongAdapter.fromJson(jsonReader);
                    break;
                case 8:
                    str5 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.endObject();
        return new BrandDto(l, l2, str, bool, str2, str3, str4, l3, str5);
    }

    public void toJson(JsonWriter jsonWriter, BrandDto brandDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (brandDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.nullableLongAdapter.toJson(jsonWriter, brandDto.getId());
            jsonWriter.name("account_id");
            this.nullableLongAdapter.toJson(jsonWriter, brandDto.getAccountId());
            jsonWriter.name("name");
            this.nullableStringAdapter.toJson(jsonWriter, brandDto.getName());
            jsonWriter.name("active");
            this.nullableBooleanAdapter.toJson(jsonWriter, brandDto.getActive());
            jsonWriter.name("deleted_at");
            this.nullableStringAdapter.toJson(jsonWriter, brandDto.getDeletedAt());
            jsonWriter.name(AnalyticsEventTypeAdapter.CREATED_AT);
            this.nullableStringAdapter.toJson(jsonWriter, brandDto.getCreatedAt());
            jsonWriter.name("updated_at");
            this.nullableStringAdapter.toJson(jsonWriter, brandDto.getUpdatedAt());
            jsonWriter.name("route_id");
            this.nullableLongAdapter.toJson(jsonWriter, brandDto.getRouteId());
            jsonWriter.name("signature_template");
            this.nullableStringAdapter.toJson(jsonWriter, brandDto.getSignatureTemplate());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

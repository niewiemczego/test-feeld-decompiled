package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import io.sentry.protocol.OperatingSystem;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/ClientInfoDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/ClientInfoDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClientInfoDtoJsonAdapter.kt */
public final class ClientInfoDtoJsonAdapter extends JsonAdapter<ClientInfoDto> {
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public ClientInfoDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("appId", "appName", "vendor", "sdkVersion", "devicePlatform", OperatingSystem.TYPE, "osVersion", "installer", "carrier", "locale");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"appId\", \"appName\", \"…er\", \"carrier\", \"locale\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "appId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…     emptySet(), \"appId\")");
        this.nullableStringAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(35);
        sb.append("GeneratedJsonAdapter(").append("ClientInfoDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public ClientInfoDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
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
                    str3 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 3:
                    str4 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 4:
                    str5 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 5:
                    str6 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 6:
                    str7 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 7:
                    str8 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 8:
                    str9 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 9:
                    str10 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.endObject();
        return new ClientInfoDto(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    public void toJson(JsonWriter jsonWriter, ClientInfoDto clientInfoDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (clientInfoDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("appId");
            this.nullableStringAdapter.toJson(jsonWriter, clientInfoDto.getAppId());
            jsonWriter.name("appName");
            this.nullableStringAdapter.toJson(jsonWriter, clientInfoDto.getAppName());
            jsonWriter.name("vendor");
            this.nullableStringAdapter.toJson(jsonWriter, clientInfoDto.getVendor());
            jsonWriter.name("sdkVersion");
            this.nullableStringAdapter.toJson(jsonWriter, clientInfoDto.getSdkVersion());
            jsonWriter.name("devicePlatform");
            this.nullableStringAdapter.toJson(jsonWriter, clientInfoDto.getDevicePlatform());
            jsonWriter.name(OperatingSystem.TYPE);
            this.nullableStringAdapter.toJson(jsonWriter, clientInfoDto.getOs());
            jsonWriter.name("osVersion");
            this.nullableStringAdapter.toJson(jsonWriter, clientInfoDto.getOsVersion());
            jsonWriter.name("installer");
            this.nullableStringAdapter.toJson(jsonWriter, clientInfoDto.getInstaller());
            jsonWriter.name("carrier");
            this.nullableStringAdapter.toJson(jsonWriter, clientInfoDto.getCarrier());
            jsonWriter.name("locale");
            this.nullableStringAdapter.toJson(jsonWriter, clientInfoDto.getLocale());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

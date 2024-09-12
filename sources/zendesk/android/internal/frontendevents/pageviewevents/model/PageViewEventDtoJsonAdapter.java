package zendesk.android.internal.frontendevents.pageviewevents.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.internal.frontendevents.FrontendEventsStorage;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lzendesk/android/internal/frontendevents/pageviewevents/model/PageViewEventDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/internal/frontendevents/pageviewevents/model/PageViewEventDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "pageViewDtoAdapter", "Lzendesk/android/internal/frontendevents/pageviewevents/model/PageViewDto;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PageViewEventDtoJsonAdapter.kt */
public final class PageViewEventDtoJsonAdapter extends JsonAdapter<PageViewEventDto> {
    private final JsonReader.Options options;
    private final JsonAdapter<PageViewDto> pageViewDtoAdapter;
    private final JsonAdapter<String> stringAdapter;

    public PageViewEventDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("url", "buid", "channel", "version", "timestamp", FrontendEventsStorage.KEY_SUID, "pageView");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"url\", \"buid\", \"chann…amp\", \"suid\", \"pageView\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "url");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl… emptySet(),\n      \"url\")");
        this.stringAdapter = adapter;
        JsonAdapter<PageViewDto> adapter2 = moshi.adapter(PageViewDto.class, SetsKt.emptySet(), "pageView");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(PageViewDt…  emptySet(), \"pageView\")");
        this.pageViewDtoAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(38);
        sb.append("GeneratedJsonAdapter(").append("PageViewEventDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public PageViewEventDto fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        PageViewDto pageViewDto = null;
        while (true) {
            PageViewDto pageViewDto2 = pageViewDto;
            if (jsonReader.hasNext()) {
                switch (jsonReader2.selectName(this.options)) {
                    case -1:
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        break;
                    case 0:
                        str = this.stringAdapter.fromJson(jsonReader2);
                        if (str == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("url", "url", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"url\", \"url\", reader)");
                            throw unexpectedNull;
                        }
                        break;
                    case 1:
                        str2 = this.stringAdapter.fromJson(jsonReader2);
                        if (str2 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("buid", "buid", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"buid\", \"buid\",\n            reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 2:
                        str3 = this.stringAdapter.fromJson(jsonReader2);
                        if (str3 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("channel", "channel", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"channel\"…       \"channel\", reader)");
                            throw unexpectedNull3;
                        }
                        break;
                    case 3:
                        str4 = this.stringAdapter.fromJson(jsonReader2);
                        if (str4 == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("version", "version", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"version\"…       \"version\", reader)");
                            throw unexpectedNull4;
                        }
                        break;
                    case 4:
                        str5 = this.stringAdapter.fromJson(jsonReader2);
                        if (str5 == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("timestamp", "timestamp", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"timestam…     \"timestamp\", reader)");
                            throw unexpectedNull5;
                        }
                        break;
                    case 5:
                        str6 = this.stringAdapter.fromJson(jsonReader2);
                        if (str6 == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull(FrontendEventsStorage.KEY_SUID, FrontendEventsStorage.KEY_SUID, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"suid\", \"suid\",\n            reader)");
                            throw unexpectedNull6;
                        }
                        break;
                    case 6:
                        pageViewDto = this.pageViewDtoAdapter.fromJson(jsonReader2);
                        if (pageViewDto != null) {
                            continue;
                        } else {
                            JsonDataException unexpectedNull7 = Util.unexpectedNull("pageView", "pageView", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "unexpectedNull(\"pageView…      \"pageView\", reader)");
                            throw unexpectedNull7;
                        }
                }
                pageViewDto = pageViewDto2;
            } else {
                jsonReader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty("url", "url", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"url\", \"url\", reader)");
                    throw missingProperty;
                } else if (str2 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("buid", "buid", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"buid\", \"buid\", reader)");
                    throw missingProperty2;
                } else if (str3 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("channel", "channel", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"channel\", \"channel\", reader)");
                    throw missingProperty3;
                } else if (str4 == null) {
                    JsonDataException missingProperty4 = Util.missingProperty("version", "version", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"version\", \"version\", reader)");
                    throw missingProperty4;
                } else if (str5 == null) {
                    JsonDataException missingProperty5 = Util.missingProperty("timestamp", "timestamp", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"timestamp\", \"timestamp\", reader)");
                    throw missingProperty5;
                } else if (str6 == null) {
                    JsonDataException missingProperty6 = Util.missingProperty(FrontendEventsStorage.KEY_SUID, FrontendEventsStorage.KEY_SUID, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"suid\", \"suid\", reader)");
                    throw missingProperty6;
                } else if (pageViewDto2 != null) {
                    return new PageViewEventDto(str, str2, str3, str4, str5, str6, pageViewDto2);
                } else {
                    JsonDataException missingProperty7 = Util.missingProperty("pageView", "pageView", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty7, "missingProperty(\"pageView\", \"pageView\", reader)");
                    throw missingProperty7;
                }
            }
        }
    }

    public void toJson(JsonWriter jsonWriter, PageViewEventDto pageViewEventDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (pageViewEventDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("url");
            this.stringAdapter.toJson(jsonWriter, pageViewEventDto.getUrl());
            jsonWriter.name("buid");
            this.stringAdapter.toJson(jsonWriter, pageViewEventDto.getBuid());
            jsonWriter.name("channel");
            this.stringAdapter.toJson(jsonWriter, pageViewEventDto.getChannel());
            jsonWriter.name("version");
            this.stringAdapter.toJson(jsonWriter, pageViewEventDto.getVersion());
            jsonWriter.name("timestamp");
            this.stringAdapter.toJson(jsonWriter, pageViewEventDto.getTimestamp());
            jsonWriter.name(FrontendEventsStorage.KEY_SUID);
            this.stringAdapter.toJson(jsonWriter, pageViewEventDto.getSuid());
            jsonWriter.name("pageView");
            this.pageViewDtoAdapter.toJson(jsonWriter, pageViewEventDto.getPageView());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

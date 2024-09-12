package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/ActivityDataRequestDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/ActivityDataRequestDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "activityDataDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/ActivityDataDto;", "authorDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/AuthorDto;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActivityDataRequestDtoJsonAdapter.kt */
public final class ActivityDataRequestDtoJsonAdapter extends JsonAdapter<ActivityDataRequestDto> {
    private final JsonAdapter<ActivityDataDto> activityDataDtoAdapter;
    private final JsonAdapter<AuthorDto> authorDtoAdapter;
    private final JsonReader.Options options;

    public ActivityDataRequestDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("author", "activity");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"author\", \"activity\")");
        this.options = of;
        JsonAdapter<AuthorDto> adapter = moshi.adapter(AuthorDto.class, SetsKt.emptySet(), "author");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(AuthorDto:…    emptySet(), \"author\")");
        this.authorDtoAdapter = adapter;
        JsonAdapter<ActivityDataDto> adapter2 = moshi.adapter(ActivityDataDto.class, SetsKt.emptySet(), "activity");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(ActivityDa…, emptySet(), \"activity\")");
        this.activityDataDtoAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(44);
        sb.append("GeneratedJsonAdapter(").append("ActivityDataRequestDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public ActivityDataRequestDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        AuthorDto authorDto = null;
        ActivityDataDto activityDataDto = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                authorDto = this.authorDtoAdapter.fromJson(jsonReader);
                if (authorDto == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("author", "author", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"author\",…        \"author\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (activityDataDto = this.activityDataDtoAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("activity", "activity", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"activity\", \"activity\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (authorDto == null) {
            JsonDataException missingProperty = Util.missingProperty("author", "author", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"author\", \"author\", reader)");
            throw missingProperty;
        } else if (activityDataDto != null) {
            return new ActivityDataRequestDto(authorDto, activityDataDto);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("activity", "activity", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"activity\", \"activity\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(JsonWriter jsonWriter, ActivityDataRequestDto activityDataRequestDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (activityDataRequestDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("author");
            this.authorDtoAdapter.toJson(jsonWriter, activityDataRequestDto.getAuthor());
            jsonWriter.name("activity");
            this.activityDataDtoAdapter.toJson(jsonWriter, activityDataRequestDto.getActivity());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

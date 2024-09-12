package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lzendesk/conversationkit/android/model/AuthorJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/Author;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "authorTypeAdapter", "Lzendesk/conversationkit/android/model/AuthorType;", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthorJsonAdapter.kt */
public final class AuthorJsonAdapter extends JsonAdapter<Author> {
    private final JsonAdapter<AuthorType> authorTypeAdapter;
    private volatile Constructor<Author> constructorRef;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public AuthorJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("userId", "type", "displayName", "avatarUrl");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"userId\", \"type\", \"di…Name\",\n      \"avatarUrl\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "userId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ptySet(),\n      \"userId\")");
        this.stringAdapter = adapter;
        JsonAdapter<AuthorType> adapter2 = moshi.adapter(AuthorType.class, SetsKt.emptySet(), "type");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(AuthorType…      emptySet(), \"type\")");
        this.authorTypeAdapter = adapter2;
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, SetsKt.emptySet(), "avatarUrl");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(String::cl… emptySet(), \"avatarUrl\")");
        this.nullableStringAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(28);
        sb.append("GeneratedJsonAdapter(").append("Author").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public Author fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i = -1;
        String str = null;
        AuthorType authorType = null;
        String str2 = null;
        String str3 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader2.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader2);
                if (str != null) {
                    i &= -2;
                } else {
                    JsonDataException unexpectedNull = Util.unexpectedNull("userId", "userId", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"userId\",…d\",\n              reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                authorType = this.authorTypeAdapter.fromJson(jsonReader2);
                if (authorType != null) {
                    i &= -3;
                } else {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("type", "type", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"type\", \"…e\",\n              reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str2 = this.stringAdapter.fromJson(jsonReader2);
                if (str2 != null) {
                    i &= -5;
                } else {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("displayName", "displayName", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"displayN…   \"displayName\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                str3 = this.nullableStringAdapter.fromJson(jsonReader2);
                i &= -9;
            }
        }
        jsonReader.endObject();
        if (i != -16) {
            Constructor<Author> constructor = this.constructorRef;
            if (constructor == null) {
                constructor = Author.class.getDeclaredConstructor(new Class[]{String.class, AuthorType.class, String.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "Author::class.java.getDe…his.constructorRef = it }");
            }
            Author newInstance = constructor.newInstance(new Object[]{str, authorType, str2, str3, Integer.valueOf(i), null});
            Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
            return newInstance;
        } else if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (authorType == null) {
            throw new NullPointerException("null cannot be cast to non-null type zendesk.conversationkit.android.model.AuthorType");
        } else if (str2 != null) {
            return new Author(str, authorType, str2, str3);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public void toJson(JsonWriter jsonWriter, Author author) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (author != null) {
            jsonWriter.beginObject();
            jsonWriter.name("userId");
            this.stringAdapter.toJson(jsonWriter, author.getUserId());
            jsonWriter.name("type");
            this.authorTypeAdapter.toJson(jsonWriter, author.getType());
            jsonWriter.name("displayName");
            this.stringAdapter.toJson(jsonWriter, author.getDisplayName());
            jsonWriter.name("avatarUrl");
            this.nullableStringAdapter.toJson(jsonWriter, author.getAvatarUrl());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

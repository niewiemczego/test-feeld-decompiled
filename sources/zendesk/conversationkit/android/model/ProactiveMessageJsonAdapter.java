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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lzendesk/conversationkit/android/model/ProactiveMessageJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/ProactiveMessage;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "intAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProactiveMessageJsonAdapter.kt */
public final class ProactiveMessageJsonAdapter extends JsonAdapter<ProactiveMessage> {
    private volatile Constructor<ProactiveMessage> constructorRef;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ProactiveMessageJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "title", "body", "campaignId", "campaignVersion", "jwt");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"id\", \"title\", \"body\"…\"campaignVersion\", \"jwt\")");
        this.options = of;
        JsonAdapter<Integer> adapter = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Int::class.java, emptySet(), \"id\")");
        this.intAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "title");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…mptySet(),\n      \"title\")");
        this.stringAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(38);
        sb.append("GeneratedJsonAdapter(").append("ProactiveMessage").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public ProactiveMessage fromJson(JsonReader jsonReader) {
        String str;
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        Integer num = 0;
        jsonReader.beginObject();
        int i = -1;
        Integer num2 = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    num = this.intAdapter.fromJson(jsonReader2);
                    if (num != null) {
                        i &= -2;
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    str2 = this.stringAdapter.fromJson(jsonReader2);
                    if (str2 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("title", "title", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"title\", …tle\",\n            reader)");
                        throw unexpectedNull2;
                    }
                case 2:
                    str3 = this.stringAdapter.fromJson(jsonReader2);
                    if (str3 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("body", "body", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"body\", \"body\",\n            reader)");
                        throw unexpectedNull3;
                    }
                case 3:
                    str4 = this.stringAdapter.fromJson(jsonReader2);
                    if (str4 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("campaignId", "campaignId", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"campaign…    \"campaignId\", reader)");
                        throw unexpectedNull4;
                    }
                case 4:
                    num2 = this.intAdapter.fromJson(jsonReader2);
                    if (num2 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("campaignVersion", "campaignVersion", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"campaign…campaignVersion\", reader)");
                        throw unexpectedNull5;
                    }
                case 5:
                    str5 = this.stringAdapter.fromJson(jsonReader2);
                    if (str5 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("jwt", "jwt", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"jwt\", \"jwt\", reader)");
                        throw unexpectedNull6;
                    }
            }
        }
        jsonReader.endObject();
        String str6 = "title";
        String str7 = "missingProperty(\"title\", \"title\", reader)";
        if (i == -2) {
            int intValue = num.intValue();
            if (str2 == null) {
                String str8 = str6;
                JsonDataException missingProperty = Util.missingProperty(str8, str8, jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty, str7);
                throw missingProperty;
            } else if (str3 == null) {
                JsonDataException missingProperty2 = Util.missingProperty("body", "body", jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"body\", \"body\", reader)");
                throw missingProperty2;
            } else if (str4 == null) {
                JsonDataException missingProperty3 = Util.missingProperty("campaignId", "campaignId", jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"campaig…d\", \"campaignId\", reader)");
                throw missingProperty3;
            } else if (num2 != null) {
                int intValue2 = num2.intValue();
                if (str5 != null) {
                    return new ProactiveMessage(intValue, str2, str3, str4, intValue2, str5);
                }
                JsonDataException missingProperty4 = Util.missingProperty("jwt", "jwt", jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"jwt\", \"jwt\", reader)");
                throw missingProperty4;
            } else {
                JsonDataException missingProperty5 = Util.missingProperty("campaignVersion", "campaignVersion", jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"campaig…campaignVersion\", reader)");
                throw missingProperty5;
            }
        } else {
            String str9 = "missingProperty(\"body\", \"body\", reader)";
            Constructor<ProactiveMessage> constructor = this.constructorRef;
            String str10 = "body";
            if (constructor == null) {
                str = "missingProperty(\"campaig…d\", \"campaignId\", reader)";
                constructor = ProactiveMessage.class.getDeclaredConstructor(new Class[]{Integer.TYPE, String.class, String.class, String.class, Integer.TYPE, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "ProactiveMessage::class.…his.constructorRef = it }");
            } else {
                str = "missingProperty(\"campaig…d\", \"campaignId\", reader)";
            }
            Object[] objArr = new Object[8];
            objArr[0] = num;
            if (str2 != null) {
                objArr[1] = str2;
                if (str3 != null) {
                    objArr[2] = str3;
                    if (str4 != null) {
                        objArr[3] = str4;
                        if (num2 != null) {
                            objArr[4] = Integer.valueOf(num2.intValue());
                            if (str5 != null) {
                                objArr[5] = str5;
                                objArr[6] = Integer.valueOf(i);
                                objArr[7] = null;
                                ProactiveMessage newInstance = constructor.newInstance(objArr);
                                Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                                return newInstance;
                            }
                            JsonDataException missingProperty6 = Util.missingProperty("jwt", "jwt", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"jwt\", \"jwt\", reader)");
                            throw missingProperty6;
                        }
                        JsonDataException missingProperty7 = Util.missingProperty("campaignVersion", "campaignVersion", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(missingProperty7, "missingProperty(\"campaig…n\",\n              reader)");
                        throw missingProperty7;
                    }
                    JsonDataException missingProperty8 = Util.missingProperty("campaignId", "campaignId", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty8, str);
                    throw missingProperty8;
                }
                String str11 = str10;
                JsonDataException missingProperty9 = Util.missingProperty(str11, str11, jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty9, str9);
                throw missingProperty9;
            }
            String str12 = str6;
            JsonDataException missingProperty10 = Util.missingProperty(str12, str12, jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty10, str7);
            throw missingProperty10;
        }
    }

    public void toJson(JsonWriter jsonWriter, ProactiveMessage proactiveMessage) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (proactiveMessage != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(proactiveMessage.getId()));
            jsonWriter.name("title");
            this.stringAdapter.toJson(jsonWriter, proactiveMessage.getTitle());
            jsonWriter.name("body");
            this.stringAdapter.toJson(jsonWriter, proactiveMessage.getBody());
            jsonWriter.name("campaignId");
            this.stringAdapter.toJson(jsonWriter, proactiveMessage.getCampaignId());
            jsonWriter.name("campaignVersion");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(proactiveMessage.getCampaignVersion()));
            jsonWriter.name("jwt");
            this.stringAdapter.toJson(jsonWriter, proactiveMessage.getJwt());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

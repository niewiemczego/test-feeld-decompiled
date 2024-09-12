package zendesk.android.internal.proactivemessaging.model;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import io.sentry.protocol.SentryStackFrame;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lzendesk/android/internal/proactivemessaging/model/ConditionJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/internal/proactivemessaging/model/Condition;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "conditionFunctionAdapter", "Lzendesk/android/internal/proactivemessaging/model/ConditionFunction;", "conditionTypeAdapter", "Lzendesk/android/internal/proactivemessaging/model/ConditionType;", "listOfExpressionAdapter", "", "Lzendesk/android/internal/proactivemessaging/model/Expression;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConditionJsonAdapter.kt */
public final class ConditionJsonAdapter extends JsonAdapter<Condition> {
    private final JsonAdapter<ConditionFunction> conditionFunctionAdapter;
    private final JsonAdapter<ConditionType> conditionTypeAdapter;
    private final JsonAdapter<List<Expression>> listOfExpressionAdapter;
    private final JsonReader.Options options;

    public ConditionJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("type", SentryStackFrame.JsonKeys.FUNCTION, StepData.ARGS);
        Intrinsics.checkNotNullExpressionValue(of, "of(\"type\", \"function\", \"args\")");
        this.options = of;
        JsonAdapter<ConditionType> adapter = moshi.adapter(ConditionType.class, SetsKt.emptySet(), "type");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(ConditionT…java, emptySet(), \"type\")");
        this.conditionTypeAdapter = adapter;
        JsonAdapter<ConditionFunction> adapter2 = moshi.adapter(ConditionFunction.class, SetsKt.emptySet(), SentryStackFrame.JsonKeys.FUNCTION);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(ConditionF…, emptySet(), \"function\")");
        this.conditionFunctionAdapter = adapter2;
        JsonAdapter<List<Expression>> adapter3 = moshi.adapter(Types.newParameterizedType(List.class, Expression.class), SetsKt.emptySet(), "expressions");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP…mptySet(), \"expressions\")");
        this.listOfExpressionAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(31);
        sb.append("GeneratedJsonAdapter(").append("Condition").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public Condition fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        ConditionType conditionType = null;
        ConditionFunction conditionFunction = null;
        List list = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                conditionType = this.conditionTypeAdapter.fromJson(jsonReader);
                if (conditionType == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("type", "type", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"type\",\n            \"type\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                conditionFunction = this.conditionFunctionAdapter.fromJson(jsonReader);
                if (conditionFunction == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(SentryStackFrame.JsonKeys.FUNCTION, SentryStackFrame.JsonKeys.FUNCTION, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"function\", \"function\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (list = this.listOfExpressionAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("expressions", StepData.ARGS, jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"expressions\", \"args\", reader)");
                throw unexpectedNull3;
            }
        }
        jsonReader.endObject();
        if (conditionType == null) {
            JsonDataException missingProperty = Util.missingProperty("type", "type", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"type\", \"type\", reader)");
            throw missingProperty;
        } else if (conditionFunction == null) {
            JsonDataException missingProperty2 = Util.missingProperty(SentryStackFrame.JsonKeys.FUNCTION, SentryStackFrame.JsonKeys.FUNCTION, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"function\", \"function\", reader)");
            throw missingProperty2;
        } else if (list != null) {
            return new Condition(conditionType, conditionFunction, list);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("expressions", StepData.ARGS, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"expressions\", \"args\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, Condition condition) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (condition != null) {
            jsonWriter.beginObject();
            jsonWriter.name("type");
            this.conditionTypeAdapter.toJson(jsonWriter, condition.getType());
            jsonWriter.name(SentryStackFrame.JsonKeys.FUNCTION);
            this.conditionFunctionAdapter.toJson(jsonWriter, condition.getFunction());
            jsonWriter.name(StepData.ARGS);
            this.listOfExpressionAdapter.toJson(jsonWriter, condition.getExpressions());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

package zendesk.android.internal.proactivemessaging.model;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.react.uimanager.events.TouchesHelper;
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
import zendesk.android.internal.proactivemessaging.model.Expression;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lzendesk/android/internal/proactivemessaging/model/Expression_ExpressionClassJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/internal/proactivemessaging/model/Expression$ExpressionClass;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "expressionFunctionAdapter", "Lzendesk/android/internal/proactivemessaging/model/ExpressionFunction;", "expressionTargetAdapter", "Lzendesk/android/internal/proactivemessaging/model/ExpressionTarget;", "expressionTypeAdapter", "Lzendesk/android/internal/proactivemessaging/model/ExpressionType;", "listOfAnyAdapter", "", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Expression_ExpressionClassJsonAdapter.kt */
public final class Expression_ExpressionClassJsonAdapter extends JsonAdapter<Expression.ExpressionClass> {
    private final JsonAdapter<ExpressionFunction> expressionFunctionAdapter;
    private final JsonAdapter<ExpressionTarget> expressionTargetAdapter;
    private final JsonAdapter<ExpressionType> expressionTypeAdapter;
    private final JsonAdapter<List<Object>> listOfAnyAdapter;
    private final JsonReader.Options options;

    public Expression_ExpressionClassJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("type", SentryStackFrame.JsonKeys.FUNCTION, TouchesHelper.TARGET_KEY, StepData.ARGS);
        Intrinsics.checkNotNullExpressionValue(of, "of(\"type\", \"function\", \"target\",\n      \"args\")");
        this.options = of;
        JsonAdapter<ExpressionType> adapter = moshi.adapter(ExpressionType.class, SetsKt.emptySet(), "type");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Expression…java, emptySet(), \"type\")");
        this.expressionTypeAdapter = adapter;
        JsonAdapter<ExpressionFunction> adapter2 = moshi.adapter(ExpressionFunction.class, SetsKt.emptySet(), SentryStackFrame.JsonKeys.FUNCTION);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Expression…, emptySet(), \"function\")");
        this.expressionFunctionAdapter = adapter2;
        JsonAdapter<ExpressionTarget> adapter3 = moshi.adapter(ExpressionTarget.class, SetsKt.emptySet(), TouchesHelper.TARGET_KEY);
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Expression…va, emptySet(), \"target\")");
        this.expressionTargetAdapter = adapter3;
        JsonAdapter<List<Object>> adapter4 = moshi.adapter(Types.newParameterizedType(List.class, Object.class), SetsKt.emptySet(), StepData.ARGS);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Types.newP…emptySet(),\n      \"args\")");
        this.listOfAnyAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(48);
        sb.append("GeneratedJsonAdapter(").append("Expression.ExpressionClass").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public Expression.ExpressionClass fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        ExpressionType expressionType = null;
        ExpressionFunction expressionFunction = null;
        ExpressionTarget expressionTarget = null;
        List list = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                expressionType = this.expressionTypeAdapter.fromJson(jsonReader);
                if (expressionType == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("type", "type", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"type\",\n            \"type\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                expressionFunction = this.expressionFunctionAdapter.fromJson(jsonReader);
                if (expressionFunction == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(SentryStackFrame.JsonKeys.FUNCTION, SentryStackFrame.JsonKeys.FUNCTION, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"function\", \"function\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                expressionTarget = this.expressionTargetAdapter.fromJson(jsonReader);
                if (expressionTarget == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull(TouchesHelper.TARGET_KEY, TouchesHelper.TARGET_KEY, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"target\", \"target\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3 && (list = this.listOfAnyAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull4 = Util.unexpectedNull(StepData.ARGS, StepData.ARGS, jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"args\", \"args\",\n            reader)");
                throw unexpectedNull4;
            }
        }
        jsonReader.endObject();
        if (expressionType == null) {
            JsonDataException missingProperty = Util.missingProperty("type", "type", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"type\", \"type\", reader)");
            throw missingProperty;
        } else if (expressionFunction == null) {
            JsonDataException missingProperty2 = Util.missingProperty(SentryStackFrame.JsonKeys.FUNCTION, SentryStackFrame.JsonKeys.FUNCTION, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"function\", \"function\", reader)");
            throw missingProperty2;
        } else if (expressionTarget == null) {
            JsonDataException missingProperty3 = Util.missingProperty(TouchesHelper.TARGET_KEY, TouchesHelper.TARGET_KEY, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"target\", \"target\", reader)");
            throw missingProperty3;
        } else if (list != null) {
            return new Expression.ExpressionClass(expressionType, expressionFunction, expressionTarget, list);
        } else {
            JsonDataException missingProperty4 = Util.missingProperty(StepData.ARGS, StepData.ARGS, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"args\", \"args\", reader)");
            throw missingProperty4;
        }
    }

    public void toJson(JsonWriter jsonWriter, Expression.ExpressionClass expressionClass) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (expressionClass != null) {
            jsonWriter.beginObject();
            jsonWriter.name("type");
            this.expressionTypeAdapter.toJson(jsonWriter, expressionClass.getType());
            jsonWriter.name(SentryStackFrame.JsonKeys.FUNCTION);
            this.expressionFunctionAdapter.toJson(jsonWriter, expressionClass.getFunction());
            jsonWriter.name(TouchesHelper.TARGET_KEY);
            this.expressionTargetAdapter.toJson(jsonWriter, expressionClass.getTarget());
            jsonWriter.name(StepData.ARGS);
            this.listOfAnyAdapter.toJson(jsonWriter, expressionClass.getArgs());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}

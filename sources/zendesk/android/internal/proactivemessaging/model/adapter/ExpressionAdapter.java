package zendesk.android.internal.proactivemessaging.model.adapter;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.ToJson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.internal.proactivemessaging.model.Expression;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¨\u0006\u0010"}, d2 = {"Lzendesk/android/internal/proactivemessaging/model/adapter/ExpressionAdapter;", "", "()V", "fromJson", "Lzendesk/android/internal/proactivemessaging/model/Expression;", "jsonReader", "Lcom/squareup/moshi/JsonReader;", "mainDelegate", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/internal/proactivemessaging/model/Expression$ExpressionClass;", "toJson", "", "jsonWriter", "Lcom/squareup/moshi/JsonWriter;", "expression", "delegate", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExpressionAdapter.kt */
public final class ExpressionAdapter {
    @FromJson
    public final Expression fromJson(JsonReader jsonReader, JsonAdapter<Expression.ExpressionClass> jsonAdapter) {
        Intrinsics.checkNotNullParameter(jsonReader, "jsonReader");
        Intrinsics.checkNotNullParameter(jsonAdapter, "mainDelegate");
        if (jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
            return jsonAdapter.fromJson(jsonReader);
        }
        return new Expression.BoolValue(jsonReader.nextBoolean());
    }

    @ToJson
    public final void toJson(JsonWriter jsonWriter, Expression expression, JsonAdapter<Expression.ExpressionClass> jsonAdapter) {
        Intrinsics.checkNotNullParameter(jsonWriter, "jsonWriter");
        Intrinsics.checkNotNullParameter(expression, "expression");
        Intrinsics.checkNotNullParameter(jsonAdapter, "delegate");
        if (expression instanceof Expression.ExpressionClass) {
            jsonAdapter.toJson(jsonWriter, expression);
        } else if (expression instanceof Expression.BoolValue) {
            jsonWriter.value(((Expression.BoolValue) expression).getValue());
        }
    }
}

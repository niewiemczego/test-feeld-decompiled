package zendesk.android.internal.proactivemessaging.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import io.sentry.protocol.SentryStackFrame;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lzendesk/android/internal/proactivemessaging/model/Condition;", "", "type", "Lzendesk/android/internal/proactivemessaging/model/ConditionType;", "function", "Lzendesk/android/internal/proactivemessaging/model/ConditionFunction;", "expressions", "", "Lzendesk/android/internal/proactivemessaging/model/Expression;", "(Lzendesk/android/internal/proactivemessaging/model/ConditionType;Lzendesk/android/internal/proactivemessaging/model/ConditionFunction;Ljava/util/List;)V", "getExpressions", "()Ljava/util/List;", "getFunction", "()Lzendesk/android/internal/proactivemessaging/model/ConditionFunction;", "getType", "()Lzendesk/android/internal/proactivemessaging/model/ConditionType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Condition.kt */
public final class Condition {
    private final List<Expression> expressions;
    private final ConditionFunction function;
    private final ConditionType type;

    public static /* synthetic */ Condition copy$default(Condition condition, ConditionType conditionType, ConditionFunction conditionFunction, List<Expression> list, int i, Object obj) {
        if ((i & 1) != 0) {
            conditionType = condition.type;
        }
        if ((i & 2) != 0) {
            conditionFunction = condition.function;
        }
        if ((i & 4) != 0) {
            list = condition.expressions;
        }
        return condition.copy(conditionType, conditionFunction, list);
    }

    public final ConditionType component1() {
        return this.type;
    }

    public final ConditionFunction component2() {
        return this.function;
    }

    public final List<Expression> component3() {
        return this.expressions;
    }

    public final Condition copy(ConditionType conditionType, ConditionFunction conditionFunction, @Json(name = "args") List<? extends Expression> list) {
        Intrinsics.checkNotNullParameter(conditionType, "type");
        Intrinsics.checkNotNullParameter(conditionFunction, SentryStackFrame.JsonKeys.FUNCTION);
        Intrinsics.checkNotNullParameter(list, "expressions");
        return new Condition(conditionType, conditionFunction, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Condition)) {
            return false;
        }
        Condition condition = (Condition) obj;
        return this.type == condition.type && this.function == condition.function && Intrinsics.areEqual((Object) this.expressions, (Object) condition.expressions);
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.function.hashCode()) * 31) + this.expressions.hashCode();
    }

    public String toString() {
        return "Condition(type=" + this.type + ", function=" + this.function + ", expressions=" + this.expressions + ')';
    }

    public Condition(ConditionType conditionType, ConditionFunction conditionFunction, @Json(name = "args") List<? extends Expression> list) {
        Intrinsics.checkNotNullParameter(conditionType, "type");
        Intrinsics.checkNotNullParameter(conditionFunction, SentryStackFrame.JsonKeys.FUNCTION);
        Intrinsics.checkNotNullParameter(list, "expressions");
        this.type = conditionType;
        this.function = conditionFunction;
        this.expressions = list;
    }

    public final ConditionType getType() {
        return this.type;
    }

    public final ConditionFunction getFunction() {
        return this.function;
    }

    public final List<Expression> getExpressions() {
        return this.expressions;
    }
}

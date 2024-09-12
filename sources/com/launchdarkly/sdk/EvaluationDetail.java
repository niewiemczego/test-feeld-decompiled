package com.launchdarkly.sdk;

import com.google.gson.annotations.JsonAdapter;
import com.launchdarkly.sdk.EvaluationReason;
import com.launchdarkly.sdk.json.JsonSerializable;
import java.util.ArrayList;
import java.util.Objects;

@JsonAdapter(EvaluationDetailTypeAdapterFactory.class)
public final class EvaluationDetail<T> implements JsonSerializable {
    private static final Iterable<EvaluationDetail<?>> BOOLEAN_SINGLETONS = createBooleanSingletons();
    public static final int NO_VARIATION = -1;
    private final EvaluationReason reason;
    private final T value;
    private final int variationIndex;

    private EvaluationDetail(T t, int i, EvaluationReason evaluationReason) {
        this.value = t;
        this.variationIndex = i < 0 ? -1 : i;
        this.reason = evaluationReason;
    }

    public static <T> EvaluationDetail<T> fromValue(T t, int i, EvaluationReason evaluationReason) {
        if (t != null && (t.getClass() == Boolean.class || t.getClass() == LDValueBool.class)) {
            for (EvaluationDetail<T> next : BOOLEAN_SINGLETONS) {
                if (next.value == t && next.variationIndex == i && next.reason == evaluationReason) {
                    return next;
                }
            }
        }
        return new EvaluationDetail<>(t, i, evaluationReason);
    }

    public static EvaluationDetail<LDValue> error(EvaluationReason.ErrorKind errorKind, LDValue lDValue) {
        return new EvaluationDetail<>(LDValue.normalize(lDValue), -1, EvaluationReason.error(errorKind));
    }

    public EvaluationReason getReason() {
        return this.reason;
    }

    public int getVariationIndex() {
        return this.variationIndex;
    }

    public T getValue() {
        return this.value;
    }

    public boolean isDefaultValue() {
        return this.variationIndex < 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EvaluationDetail)) {
            return false;
        }
        EvaluationDetail evaluationDetail = (EvaluationDetail) obj;
        if (!Objects.equals(this.reason, evaluationDetail.reason) || this.variationIndex != evaluationDetail.variationIndex || !Objects.equals(this.value, evaluationDetail.value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.reason, Integer.valueOf(this.variationIndex), this.value});
    }

    public String toString() {
        return "{" + this.value + "," + this.variationIndex + "," + this.reason + "}";
    }

    private static Iterable<EvaluationDetail<?>> createBooleanSingletons() {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            int i2 = 0;
            while (i2 < 2) {
                int i3 = 0;
                while (i3 < 2) {
                    for (int i4 = 0; i4 < 2; i4++) {
                        boolean z = true;
                        if (i4 == 0) {
                            if (i3 != 1) {
                                z = false;
                            }
                            obj = LDValue.of(z);
                        } else {
                            if (i3 != 1) {
                                z = false;
                            }
                            obj = Boolean.valueOf(z);
                        }
                        int i5 = i3 == 0 ? i : 1 - i;
                        arrayList.add(new EvaluationDetail(obj, i5, i5 == i2 ? EvaluationReason.off() : EvaluationReason.fallthrough()));
                    }
                    i3++;
                }
                i2++;
            }
        }
        return arrayList;
    }
}

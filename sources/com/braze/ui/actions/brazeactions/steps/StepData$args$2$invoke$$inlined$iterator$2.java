package com.braze.ui.actions.brazeactions.steps;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "T", "it", "", "invoke", "(I)Ljava/lang/Object;", "com/braze/support/JsonUtils$iterator$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: JsonUtils.kt */
public final class StepData$args$2$invoke$$inlined$iterator$2 extends Lambda implements Function1<Integer, Object> {
    final /* synthetic */ JSONArray $this_iterator;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepData$args$2$invoke$$inlined$iterator$2(JSONArray jSONArray) {
        super(1);
        this.$this_iterator = jSONArray;
    }

    public final Object invoke(int i) {
        Object obj = this.$this_iterator.get(i);
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}

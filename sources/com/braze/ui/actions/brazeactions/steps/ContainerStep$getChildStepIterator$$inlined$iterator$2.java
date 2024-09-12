package com.braze.ui.actions.brazeactions.steps;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "T", "it", "", "invoke", "(I)Ljava/lang/Object;", "com/braze/support/JsonUtils$iterator$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: JsonUtils.kt */
public final class ContainerStep$getChildStepIterator$$inlined$iterator$2 extends Lambda implements Function1<Integer, JSONObject> {
    final /* synthetic */ JSONArray $this_iterator;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContainerStep$getChildStepIterator$$inlined$iterator$2(JSONArray jSONArray) {
        super(1);
        this.$this_iterator = jSONArray;
    }

    public final JSONObject invoke(int i) {
        Object obj = this.$this_iterator.get(i);
        if (obj != null) {
            return (JSONObject) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}

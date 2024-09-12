package com.braze.ui.actions.brazeactions.steps;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke", "(I)Ljava/lang/Boolean;", "com/braze/support/JsonUtils$iterator$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: JsonUtils.kt */
public final class ContainerStep$getChildStepIterator$$inlined$iterator$1 extends Lambda implements Function1<Integer, Boolean> {
    final /* synthetic */ JSONArray $this_iterator;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContainerStep$getChildStepIterator$$inlined$iterator$1(JSONArray jSONArray) {
        super(1);
        this.$this_iterator = jSONArray;
    }

    public final Boolean invoke(int i) {
        return Boolean.valueOf(this.$this_iterator.opt(i) instanceof JSONObject);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}

package com.braze.ui.actions.brazeactions.steps;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: StepData.kt */
final class StepData$args$2 extends Lambda implements Function0<List<? extends Object>> {
    final /* synthetic */ StepData this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StepData$args$2(StepData stepData) {
        super(0);
        this.this$0 = stepData;
    }

    public final List<Object> invoke() {
        Iterator it;
        JSONArray optJSONArray = this.this$0.getSrcJson().optJSONArray(StepData.ARGS);
        if (optJSONArray == null) {
            it = CollectionsKt.emptyList().iterator();
        } else {
            it = SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(RangesKt.until(0, optJSONArray.length())), new StepData$args$2$invoke$$inlined$iterator$1(optJSONArray)), new StepData$args$2$invoke$$inlined$iterator$2(optJSONArray)).iterator();
        }
        return SequencesKt.toList(SequencesKt.asSequence(it));
    }
}

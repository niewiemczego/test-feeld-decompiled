package com.braze.ui.actions.brazeactions.steps;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: StepData.kt */
final class StepData$isArgCountInBounds$2 extends Lambda implements Function0<String> {
    final /* synthetic */ IntRange $rangedArgCount;
    final /* synthetic */ StepData this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StepData$isArgCountInBounds$2(IntRange intRange, StepData stepData) {
        super(0);
        this.$rangedArgCount = intRange;
        this.this$0 = stepData;
    }

    public final String invoke() {
        return "Expected " + this.$rangedArgCount + " arguments. Got: " + this.this$0.getArgs();
    }
}

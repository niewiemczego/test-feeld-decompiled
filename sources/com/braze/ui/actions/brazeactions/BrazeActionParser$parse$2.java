package com.braze.ui.actions.brazeactions;

import com.braze.ui.actions.brazeactions.steps.StepData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeActionParser.kt */
final class BrazeActionParser$parse$2 extends Lambda implements Function0<String> {
    final /* synthetic */ StepData $data;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazeActionParser$parse$2(StepData stepData) {
        super(0);
        this.$data = stepData;
    }

    public final String invoke() {
        return "Failed to run with data " + this.$data;
    }
}

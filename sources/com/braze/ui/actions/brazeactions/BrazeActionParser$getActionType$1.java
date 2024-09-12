package com.braze.ui.actions.brazeactions;

import com.braze.ui.actions.brazeactions.BrazeActionParser;
import com.braze.ui.actions.brazeactions.steps.StepData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeActionParser.kt */
final class BrazeActionParser$getActionType$1 extends Lambda implements Function0<String> {
    final /* synthetic */ StepData $data;
    final /* synthetic */ BrazeActionParser.ActionType $type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazeActionParser$getActionType$1(BrazeActionParser.ActionType actionType, StepData stepData) {
        super(0);
        this.$type = actionType;
        this.$data = stepData;
    }

    public final String invoke() {
        return "Cannot parse invalid action of type " + this.$type + " and data " + this.$data;
    }
}

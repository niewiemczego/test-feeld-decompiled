package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.enums.Channel;
import com.braze.ui.actions.brazeactions.BrazeActionParser;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/braze/ui/actions/brazeactions/steps/ContainerStep;", "Lcom/braze/ui/actions/brazeactions/steps/BaseBrazeActionStep;", "()V", "STEPS", "", "getChildStepIterator", "", "Lorg/json/JSONObject;", "data", "Lcom/braze/ui/actions/brazeactions/steps/StepData;", "getChildStepIterator$android_sdk_ui_release", "isValid", "", "run", "", "context", "Landroid/content/Context;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContainerStep.kt */
public final class ContainerStep extends BaseBrazeActionStep {
    public static final ContainerStep INSTANCE = new ContainerStep();
    public static final String STEPS = "steps";

    private ContainerStep() {
        super((DefaultConstructorMarker) null);
    }

    public boolean isValid(StepData stepData) {
        Intrinsics.checkNotNullParameter(stepData, "data");
        return stepData.getSrcJson().has(STEPS);
    }

    public void run(Context context, StepData stepData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(stepData, "data");
        Iterator childStepIterator$android_sdk_ui_release = getChildStepIterator$android_sdk_ui_release(stepData);
        while (childStepIterator$android_sdk_ui_release.hasNext()) {
            BrazeActionParser.INSTANCE.parse$android_sdk_ui_release(context, StepData.copy$default(stepData, (JSONObject) childStepIterator$android_sdk_ui_release.next(), (Channel) null, 2, (Object) null));
        }
    }

    public final /* synthetic */ Iterator getChildStepIterator$android_sdk_ui_release(StepData stepData) {
        Intrinsics.checkNotNullParameter(stepData, "data");
        JSONArray jSONArray = stepData.getSrcJson().getJSONArray(STEPS);
        if (jSONArray == null) {
            return CollectionsKt.emptyList().iterator();
        }
        return SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(RangesKt.until(0, jSONArray.length())), new ContainerStep$getChildStepIterator$$inlined$iterator$1(jSONArray)), new ContainerStep$getChildStepIterator$$inlined$iterator$2(jSONArray)).iterator();
    }
}

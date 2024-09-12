package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.Braze;
import com.braze.enums.NotificationSubscriptionType;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/braze/ui/actions/brazeactions/steps/SetEmailSubscriptionStep;", "Lcom/braze/ui/actions/brazeactions/steps/BaseBrazeActionStep;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isValid", "", "data", "Lcom/braze/ui/actions/brazeactions/steps/StepData;", "run", "", "context", "Landroid/content/Context;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SetEmailSubscriptionStep.kt */
public final class SetEmailSubscriptionStep extends BaseBrazeActionStep {
    public static final SetEmailSubscriptionStep INSTANCE;
    private static final String TAG;

    private SetEmailSubscriptionStep() {
        super((DefaultConstructorMarker) null);
    }

    static {
        SetEmailSubscriptionStep setEmailSubscriptionStep = new SetEmailSubscriptionStep();
        INSTANCE = setEmailSubscriptionStep;
        TAG = BrazeLogger.INSTANCE.brazeLogTag(setEmailSubscriptionStep);
    }

    public final String getTAG() {
        return TAG;
    }

    public boolean isValid(StepData stepData) {
        Intrinsics.checkNotNullParameter(stepData, "data");
        if (!StepData.isArgCountInBounds$default(stepData, 1, (IntRange) null, 2, (Object) null) || !stepData.isArgString(0)) {
            return false;
        }
        return true;
    }

    public void run(Context context, StepData stepData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(stepData, "data");
        NotificationSubscriptionType fromValue = NotificationSubscriptionType.Companion.fromValue(String.valueOf(stepData.getFirstArg()));
        if (fromValue == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new SetEmailSubscriptionStep$run$1(stepData), 3, (Object) null);
            return;
        }
        BaseBrazeActionStep.Companion.runOnUser$android_sdk_ui_release(Braze.Companion.getInstance(context), new SetEmailSubscriptionStep$run$2(fromValue));
    }
}

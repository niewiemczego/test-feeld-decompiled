package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import android.os.Bundle;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.actions.UriAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/braze/ui/actions/brazeactions/steps/OpenLinkInWebViewStep;", "Lcom/braze/ui/actions/brazeactions/steps/BaseBrazeActionStep;", "()V", "isValid", "", "data", "Lcom/braze/ui/actions/brazeactions/steps/StepData;", "run", "", "context", "Landroid/content/Context;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OpenLinkInWebViewStep.kt */
public final class OpenLinkInWebViewStep extends BaseBrazeActionStep {
    public static final OpenLinkInWebViewStep INSTANCE = new OpenLinkInWebViewStep();

    private OpenLinkInWebViewStep() {
        super((DefaultConstructorMarker) null);
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
        String valueOf = String.valueOf(stepData.getFirstArg());
        IBrazeDeeplinkHandler instance = BrazeDeeplinkHandler.Companion.getInstance();
        UriAction createUriActionFromUrlString = instance.createUriActionFromUrlString(valueOf, (Bundle) null, true, stepData.getChannel());
        if (createUriActionFromUrlString != null) {
            instance.gotoUri(context, createUriActionFromUrlString);
        }
    }
}

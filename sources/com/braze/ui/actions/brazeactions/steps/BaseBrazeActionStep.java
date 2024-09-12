package com.braze.ui.actions.brazeactions.steps;

import com.braze.Braze;
import com.braze.BrazeUser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/braze/ui/actions/brazeactions/steps/BaseBrazeActionStep;", "Lcom/braze/ui/actions/brazeactions/steps/IBrazeActionStep;", "()V", "Companion", "Lcom/braze/ui/actions/brazeactions/steps/AddToCustomAttributeArrayStep;", "Lcom/braze/ui/actions/brazeactions/steps/AddToSubscriptionGroupStep;", "Lcom/braze/ui/actions/brazeactions/steps/ContainerStep;", "Lcom/braze/ui/actions/brazeactions/steps/LogCustomEventStep;", "Lcom/braze/ui/actions/brazeactions/steps/OpenLinkExternallyStep;", "Lcom/braze/ui/actions/brazeactions/steps/OpenLinkInWebViewStep;", "Lcom/braze/ui/actions/brazeactions/steps/RemoveFromCustomAttributeArrayStep;", "Lcom/braze/ui/actions/brazeactions/steps/RemoveFromSubscriptionGroupStep;", "Lcom/braze/ui/actions/brazeactions/steps/RequestPushPermissionStep;", "Lcom/braze/ui/actions/brazeactions/steps/SetCustomUserAttributeStep;", "Lcom/braze/ui/actions/brazeactions/steps/SetEmailSubscriptionStep;", "Lcom/braze/ui/actions/brazeactions/steps/SetPushNotificationSubscriptionStep;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BaseBrazeActionStep.kt */
public abstract class BaseBrazeActionStep implements IBrazeActionStep {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ BaseBrazeActionStep(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u0004*\u00020\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\u0007H\u0000¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/braze/ui/actions/brazeactions/steps/BaseBrazeActionStep$Companion;", "", "()V", "runOnUser", "", "Lcom/braze/Braze;", "block", "Lkotlin/Function1;", "Lcom/braze/BrazeUser;", "Lkotlin/ParameterName;", "name", "user", "runOnUser$android_sdk_ui_release", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BaseBrazeActionStep.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void runOnUser$android_sdk_ui_release(Braze braze, Function1<? super BrazeUser, Unit> function1) {
            Intrinsics.checkNotNullParameter(braze, "<this>");
            Intrinsics.checkNotNullParameter(function1, "block");
            braze.getCurrentUser(new BaseBrazeActionStep$Companion$runOnUser$1(function1));
        }
    }

    private BaseBrazeActionStep() {
    }
}

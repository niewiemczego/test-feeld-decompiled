package com.adapty.react;

import com.adapty.Adapty;
import com.adapty.internal.crossplatform.CrossplatformHelper;
import com.adapty.models.AdaptyProfile;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.gms.common.Scopes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdaptyReactModule.kt */
final class AdaptyReactModule$callHandler$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AdaptyReactModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdaptyReactModule$callHandler$1(AdaptyReactModule adaptyReactModule) {
        super(0);
        this.this$0 = adaptyReactModule;
    }

    public final void invoke() {
        Adapty.setOnProfileUpdatedListener(new AdaptyReactModule$callHandler$1$$ExternalSyntheticLambda0(this.this$0));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m121invoke$lambda0(AdaptyReactModule adaptyReactModule, AdaptyProfile adaptyProfile) {
        Intrinsics.checkNotNullParameter(adaptyReactModule, "this$0");
        Intrinsics.checkNotNullParameter(adaptyProfile, Scopes.PROFILE);
        ReactContext access$getCtx$p = adaptyReactModule.ctx;
        EventName eventName = EventName.ON_LATEST_PROFILE_LOAD;
        String simpleName = Reflection.getOrCreateKotlinClass(AdaptyProfile.class).getSimpleName();
        if (simpleName == null) {
            simpleName = "Any";
        }
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) access$getCtx$p.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(eventName.getValue(), CrossplatformHelper.Companion.getShared().toJson(new AdaptyBridgeResult(adaptyProfile, simpleName)));
    }
}

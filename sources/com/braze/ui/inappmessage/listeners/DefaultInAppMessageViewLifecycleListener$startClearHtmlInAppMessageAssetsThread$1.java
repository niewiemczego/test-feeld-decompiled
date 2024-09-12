package com.braze.ui.inappmessage.listeners;

import android.app.Activity;
import com.braze.support.BrazeFileUtils;
import com.braze.support.WebContentUtils;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1", f = "DefaultInAppMessageViewLifecycleListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DefaultInAppMessageViewLifecycleListener.kt */
final class DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1(Continuation<? super DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Activity activity = BrazeInAppMessageManager.Companion.getInstance().getActivity();
            if (activity != null) {
                BrazeFileUtils.deleteFileOrDirectory(WebContentUtils.getHtmlInAppMessageAssetCacheDirectory(activity));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

package com.adapty.internal.data.cloud;

import com.adapty.internal.utils.Logger;
import com.adapty.internal.utils.Logger$log$1;
import com.adapty.utils.AdaptyLogLevel;
import com.android.billingclient.api.BillingConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/android/billingclient/api/BillingConfig;", "e", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.StoreManager$getStoreCountry$2", f = "StoreManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StoreManager.kt */
final class StoreManager$getStoreCountry$2 extends SuspendLambda implements Function3<FlowCollector<? super BillingConfig>, Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    StoreManager$getStoreCountry$2(Continuation<? super StoreManager$getStoreCountry$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(FlowCollector<? super BillingConfig> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        StoreManager$getStoreCountry$2 storeManager$getStoreCountry$2 = new StoreManager$getStoreCountry$2(continuation);
        storeManager$getStoreCountry$2.L$0 = th;
        return storeManager$getStoreCountry$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Throwable th = (Throwable) this.L$0;
            Logger logger = Logger.INSTANCE;
            AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.WARN;
            if (logger.canLog(adaptyLogLevel.value)) {
                String message = th.getMessage();
                if (message == null) {
                    message = th.getLocalizedMessage();
                }
                if (message == null) {
                    message = "Unknown error occured on get billing config";
                } else {
                    Intrinsics.checkNotNullExpressionValue(message, "e.message ?: e.localized…ed on get billing config\"");
                }
                logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, message));
            }
            throw th;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

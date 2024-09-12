package com.adapty.internal.data.cloud;

import com.adapty.internal.utils.Logger;
import com.adapty.internal.utils.Logger$log$1;
import com.adapty.utils.AdaptyLogLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "error", "", "attempt", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.StoreManager$retryOnConnectionError$1", f = "StoreManager.kt", i = {}, l = {388}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StoreManager.kt */
final class StoreManager$retryOnConnectionError$1 extends SuspendLambda implements Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> {
    final /* synthetic */ long $maxAttemptCount;
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StoreManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreManager$retryOnConnectionError$1(StoreManager storeManager, long j, Continuation<? super StoreManager$retryOnConnectionError$1> continuation) {
        super(4, continuation);
        this.this$0 = storeManager;
        this.$maxAttemptCount = j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke((FlowCollector) obj, (Throwable) obj2, ((Number) obj3).longValue(), (Continuation<? super Boolean>) (Continuation) obj4);
    }

    public final Object invoke(FlowCollector<? super T> flowCollector, Throwable th, long j, Continuation<? super Boolean> continuation) {
        StoreManager$retryOnConnectionError$1 storeManager$retryOnConnectionError$1 = new StoreManager$retryOnConnectionError$1(this.this$0, this.$maxAttemptCount, continuation);
        storeManager$retryOnConnectionError$1.L$0 = th;
        storeManager$retryOnConnectionError$1.J$0 = j;
        return storeManager$retryOnConnectionError$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Throwable th = (Throwable) this.L$0;
            if (this.this$0.canRetry(th, this.J$0, this.$maxAttemptCount)) {
                this.label = 1;
                if (DelayKt.delay(2000, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                Logger logger = Logger.INSTANCE;
                AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.ERROR;
                if (logger.canLog(adaptyLogLevel.value)) {
                    String message = th.getMessage();
                    if (message == null) {
                        message = th.getLocalizedMessage();
                    }
                    if (message == null) {
                        message = "Unknown billing error occured";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(message, "error.message ?: error.l…wn billing error occured\"");
                    }
                    logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, message));
                }
                return Boxing.boxBoolean(false);
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(true);
    }
}

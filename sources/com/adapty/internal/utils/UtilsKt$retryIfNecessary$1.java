package com.adapty.internal.utils;

import com.adapty.errors.AdaptyError;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "error", "", "attempt", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.utils.UtilsKt$retryIfNecessary$1", f = "utils.kt", i = {}, l = {157, 161}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: utils.kt */
final class UtilsKt$retryIfNecessary$1 extends SuspendLambda implements Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> {
    final /* synthetic */ long $maxAttemptCount;
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: utils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.adapty.errors.AdaptyError$RetryType[] r0 = com.adapty.errors.AdaptyError.RetryType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.adapty.errors.AdaptyError$RetryType r1 = com.adapty.errors.AdaptyError.RetryType.PROGRESSIVE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.adapty.errors.AdaptyError$RetryType r1 = com.adapty.errors.AdaptyError.RetryType.SIMPLE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.UtilsKt$retryIfNecessary$1.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UtilsKt$retryIfNecessary$1(long j, Continuation<? super UtilsKt$retryIfNecessary$1> continuation) {
        super(4, continuation);
        this.$maxAttemptCount = j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke((FlowCollector) obj, (Throwable) obj2, ((Number) obj3).longValue(), (Continuation<? super Boolean>) (Continuation) obj4);
    }

    public final Object invoke(FlowCollector<? super T> flowCollector, Throwable th, long j, Continuation<? super Boolean> continuation) {
        UtilsKt$retryIfNecessary$1 utilsKt$retryIfNecessary$1 = new UtilsKt$retryIfNecessary$1(this.$maxAttemptCount, continuation);
        utilsKt$retryIfNecessary$1.L$0 = th;
        utilsKt$retryIfNecessary$1.J$0 = j;
        return utilsKt$retryIfNecessary$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Throwable th = (Throwable) this.L$0;
            long j = this.J$0;
            if (th instanceof AdaptyError) {
                long j2 = this.$maxAttemptCount;
                if (!(0 <= j2 && j2 <= j)) {
                    int i2 = WhenMappings.$EnumSwitchMapping$0[((AdaptyError) th).getRetryType$adapty_release(j2 < 0).ordinal()];
                    if (i2 == 1) {
                        this.label = 1;
                        if (DelayKt.delay(UtilsKt.getServerErrorDelay(j), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Boxing.boxBoolean(true);
                    } else if (i2 != 2) {
                        return Boxing.boxBoolean(false);
                    } else {
                        this.label = 2;
                        if (DelayKt.delay(2000, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            }
            return Boxing.boxBoolean(false);
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(true);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(true);
    }
}

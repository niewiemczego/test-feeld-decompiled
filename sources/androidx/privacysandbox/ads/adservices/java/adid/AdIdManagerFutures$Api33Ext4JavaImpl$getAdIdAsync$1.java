package androidx.privacysandbox.ads.adservices.java.adid;

import androidx.privacysandbox.ads.adservices.adid.AdId;
import androidx.privacysandbox.ads.adservices.java.adid.AdIdManagerFutures;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Landroidx/privacysandbox/ads/adservices/adid/AdId;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.java.adid.AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1", f = "AdIdManagerFutures.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AdIdManagerFutures.kt */
final class AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AdId>, Object> {
    int label;
    final /* synthetic */ AdIdManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1(AdIdManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, Continuation<? super AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1> continuation) {
        super(2, continuation);
        this.this$0 = api33Ext4JavaImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AdId> continuation) {
        return ((AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.mAdIdManager.getAdId(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}

package androidx.privacysandbox.ads.adservices.adid;

import androidx.privacysandbox.ads.adservices.adid.AdIdManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl", f = "AdIdManager.kt", i = {}, l = {62}, m = "getAdId", n = {}, s = {})
/* compiled from: AdIdManager.kt */
final class AdIdManager$Api33Ext4Impl$getAdId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdIdManager.Api33Ext4Impl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdIdManager$Api33Ext4Impl$getAdId$1(AdIdManager.Api33Ext4Impl api33Ext4Impl, Continuation<? super AdIdManager$Api33Ext4Impl$getAdId$1> continuation) {
        super(continuation);
        this.this$0 = api33Ext4Impl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAdId(this);
    }
}

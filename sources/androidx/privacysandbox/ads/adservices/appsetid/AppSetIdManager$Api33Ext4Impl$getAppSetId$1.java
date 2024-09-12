package androidx.privacysandbox.ads.adservices.appsetid;

import androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager$Api33Ext4Impl", f = "AppSetIdManager.kt", i = {}, l = {55}, m = "getAppSetId", n = {}, s = {})
/* compiled from: AppSetIdManager.kt */
final class AppSetIdManager$Api33Ext4Impl$getAppSetId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppSetIdManager.Api33Ext4Impl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppSetIdManager$Api33Ext4Impl$getAppSetId$1(AppSetIdManager.Api33Ext4Impl api33Ext4Impl, Continuation<? super AppSetIdManager$Api33Ext4Impl$getAppSetId$1> continuation) {
        super(continuation);
        this.this$0 = api33Ext4Impl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAppSetId(this);
    }
}

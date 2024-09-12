package zendesk.android.internal.proactivemessaging;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.internal.proactivemessaging.ProactiveMessagingStorage$getSendOnceCampaignIds$2", f = "ProactiveMessagingStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProactiveMessagingStorage.kt */
final class ProactiveMessagingStorage$getSendOnceCampaignIds$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
    int label;
    final /* synthetic */ ProactiveMessagingStorage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProactiveMessagingStorage$getSendOnceCampaignIds$2(ProactiveMessagingStorage proactiveMessagingStorage, Continuation<? super ProactiveMessagingStorage$getSendOnceCampaignIds$2> continuation) {
        super(2, continuation);
        this.this$0 = proactiveMessagingStorage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProactiveMessagingStorage$getSendOnceCampaignIds$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<String>> continuation) {
        return ((ProactiveMessagingStorage$getSendOnceCampaignIds$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        r4 = r4.getCampaignIds();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.label
            if (r0 != 0) goto L_0x007e
            kotlin.ResultKt.throwOnFailure(r4)
            zendesk.android.internal.proactivemessaging.ProactiveMessagingStorage r4 = r3.this$0
            zendesk.storage.android.Storage r4 = r4.storage
            java.lang.String r0 = "ProactiveMessagingStorage.KEY_SEND_ONCE_CAMPAIGN_IDS"
            java.lang.Class<zendesk.android.internal.proactivemessaging.SendOnceCampaignsStorage> r1 = zendesk.android.internal.proactivemessaging.SendOnceCampaignsStorage.class
            java.lang.String r1 = r1.getName()
            if (r1 == 0) goto L_0x0069
            int r2 = r1.hashCode()
            switch(r2) {
                case -2056817302: goto L_0x0058;
                case -527879800: goto L_0x0046;
                case 344809556: goto L_0x0034;
                case 398795216: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x0069
        L_0x0022:
            java.lang.String r2 = "java.lang.Long"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x002b
            goto L_0x0069
        L_0x002b:
            java.lang.Class r1 = java.lang.Long.TYPE
            java.lang.Object r4 = r4.get(r0, r1)
            zendesk.android.internal.proactivemessaging.SendOnceCampaignsStorage r4 = (zendesk.android.internal.proactivemessaging.SendOnceCampaignsStorage) r4
            goto L_0x006f
        L_0x0034:
            java.lang.String r2 = "java.lang.Boolean"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x003d
            goto L_0x0069
        L_0x003d:
            java.lang.Class r1 = java.lang.Boolean.TYPE
            java.lang.Object r4 = r4.get(r0, r1)
            zendesk.android.internal.proactivemessaging.SendOnceCampaignsStorage r4 = (zendesk.android.internal.proactivemessaging.SendOnceCampaignsStorage) r4
            goto L_0x006f
        L_0x0046:
            java.lang.String r2 = "java.lang.Float"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x004f
            goto L_0x0069
        L_0x004f:
            java.lang.Class r1 = java.lang.Float.TYPE
            java.lang.Object r4 = r4.get(r0, r1)
            zendesk.android.internal.proactivemessaging.SendOnceCampaignsStorage r4 = (zendesk.android.internal.proactivemessaging.SendOnceCampaignsStorage) r4
            goto L_0x006f
        L_0x0058:
            java.lang.String r2 = "java.lang.Integer"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0069
            java.lang.Class r1 = java.lang.Integer.TYPE
            java.lang.Object r4 = r4.get(r0, r1)
            zendesk.android.internal.proactivemessaging.SendOnceCampaignsStorage r4 = (zendesk.android.internal.proactivemessaging.SendOnceCampaignsStorage) r4
            goto L_0x006f
        L_0x0069:
            java.lang.Class<zendesk.android.internal.proactivemessaging.SendOnceCampaignsStorage> r1 = zendesk.android.internal.proactivemessaging.SendOnceCampaignsStorage.class
            java.lang.Object r4 = r4.get(r0, r1)
        L_0x006f:
            zendesk.android.internal.proactivemessaging.SendOnceCampaignsStorage r4 = (zendesk.android.internal.proactivemessaging.SendOnceCampaignsStorage) r4
            if (r4 == 0) goto L_0x0079
            java.util.List r4 = r4.getCampaignIds()
            if (r4 != 0) goto L_0x007d
        L_0x0079:
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
        L_0x007d:
            return r4
        L_0x007e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.internal.proactivemessaging.ProactiveMessagingStorage$getSendOnceCampaignIds$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

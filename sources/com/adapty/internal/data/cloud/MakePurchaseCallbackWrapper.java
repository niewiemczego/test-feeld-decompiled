package com.adapty.internal.data.cloud;

import com.adapty.errors.AdaptyError;
import com.adapty.internal.data.models.AnalyticsEvent;
import com.android.billingclient.api.Purchase;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002:\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001j\u0002`\tBg\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012>\u0010\u0011\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001j\u0002`\t¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000RF\u0010\u0011\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001j\u0002`\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/adapty/internal/data/cloud/MakePurchaseCallbackWrapper;", "Lkotlin/Function2;", "Lcom/android/billingclient/api/Purchase;", "Lkotlin/ParameterName;", "name", "purchase", "Lcom/adapty/errors/AdaptyError;", "error", "", "Lcom/adapty/internal/data/cloud/MakePurchaseCallback;", "productId", "", "oldSubProductId", "requestEvent", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$MakePurchase;", "analyticsTracker", "Lcom/adapty/internal/data/cloud/AnalyticsTracker;", "callback", "(Ljava/lang/String;Ljava/lang/String;Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$MakePurchase;Lcom/adapty/internal/data/cloud/AnalyticsTracker;Lkotlin/jvm/functions/Function2;)V", "wasInvoked", "Ljava/util/concurrent/atomic/AtomicBoolean;", "invoke", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: StoreManager.kt */
final class MakePurchaseCallbackWrapper implements Function2<Purchase, AdaptyError, Unit> {
    private final AnalyticsTracker analyticsTracker;
    private final Function2<Purchase, AdaptyError, Unit> callback;
    private final String oldSubProductId;
    private final String productId;
    private final AnalyticsEvent.GoogleAPIRequestData.MakePurchase requestEvent;
    private final AtomicBoolean wasInvoked = new AtomicBoolean(false);

    public MakePurchaseCallbackWrapper(String str, String str2, AnalyticsEvent.GoogleAPIRequestData.MakePurchase makePurchase, AnalyticsTracker analyticsTracker2, Function2<? super Purchase, ? super AdaptyError, Unit> function2) {
        Intrinsics.checkNotNullParameter(str, "productId");
        Intrinsics.checkNotNullParameter(makePurchase, "requestEvent");
        Intrinsics.checkNotNullParameter(analyticsTracker2, "analyticsTracker");
        Intrinsics.checkNotNullParameter(function2, "callback");
        this.productId = str;
        this.oldSubProductId = str2;
        this.requestEvent = makePurchase;
        this.analyticsTracker = analyticsTracker2;
        this.callback = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Purchase) obj, (AdaptyError) obj2);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r8.getProducts();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void invoke(com.android.billingclient.api.Purchase r8, com.adapty.errors.AdaptyError r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x0010
            java.util.List r1 = r8.getProducts()
            if (r1 == 0) goto L_0x0010
            java.lang.Object r1 = kotlin.collections.CollectionsKt.firstOrNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0011
        L_0x0010:
            r1 = r0
        L_0x0011:
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x002a
            java.lang.String[] r5 = new java.lang.String[r2]
            java.lang.String r6 = r7.productId
            r5[r4] = r6
            java.lang.String r6 = r7.oldSubProductId
            r5[r3] = r6
            java.util.List r5 = kotlin.collections.CollectionsKt.listOfNotNull((T[]) r5)
            boolean r5 = r5.contains(r1)
            if (r5 == 0) goto L_0x0052
        L_0x002a:
            java.util.concurrent.atomic.AtomicBoolean r5 = r7.wasInvoked
            boolean r3 = r5.compareAndSet(r4, r3)
            if (r3 == 0) goto L_0x0052
            com.adapty.internal.data.cloud.AnalyticsTracker r3 = r7.analyticsTracker
            com.adapty.internal.data.models.AnalyticsEvent$GoogleAPIResponseData$MakePurchase$Companion r4 = com.adapty.internal.data.models.AnalyticsEvent.GoogleAPIResponseData.MakePurchase.Companion
            com.adapty.internal.data.models.AnalyticsEvent$GoogleAPIRequestData$MakePurchase r5 = r7.requestEvent
            com.adapty.internal.data.models.AnalyticsEvent$GoogleAPIResponseData$MakePurchase r4 = r4.create(r5, r9, r1)
            com.adapty.internal.data.models.AnalyticsEvent$CustomData r4 = (com.adapty.internal.data.models.AnalyticsEvent.CustomData) r4
            com.adapty.internal.data.cloud.AnalyticsTracker.DefaultImpls.trackSystemEvent$default(r3, r4, r0, r2, r0)
            kotlin.jvm.functions.Function2<com.android.billingclient.api.Purchase, com.adapty.errors.AdaptyError, kotlin.Unit> r2 = r7.callback
            if (r9 != 0) goto L_0x004e
            java.lang.String r3 = r7.productId
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r8 = r0
        L_0x004f:
            r2.invoke(r8, r9)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cloud.MakePurchaseCallbackWrapper.invoke(com.android.billingclient.api.Purchase, com.adapty.errors.AdaptyError):void");
    }
}

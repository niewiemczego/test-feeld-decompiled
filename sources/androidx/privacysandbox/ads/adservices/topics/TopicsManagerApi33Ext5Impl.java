package androidx.privacysandbox.ads.adservices.topics;

import android.adservices.topics.GetTopicsRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0010¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/privacysandbox/ads/adservices/topics/TopicsManagerApi33Ext5Impl;", "Landroidx/privacysandbox/ads/adservices/topics/TopicsManagerImplCommon;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "convertRequest", "Landroid/adservices/topics/GetTopicsRequest;", "request", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest;", "convertRequest$ads_adservices_release", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TopicsManagerApi33Ext5Impl.kt */
public final class TopicsManagerApi33Ext5Impl extends TopicsManagerImplCommon {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TopicsManagerApi33Ext5Impl(android.content.Context r2) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.Class<android.adservices.topics.TopicsManager> r0 = android.adservices.topics.TopicsManager.class
            java.lang.Object r2 = r2.getSystemService(r0)
            java.lang.String r0 = "context.getSystemService…opicsManager::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            android.adservices.topics.TopicsManager r2 = (android.adservices.topics.TopicsManager) r2
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.topics.TopicsManagerApi33Ext5Impl.<init>(android.content.Context):void");
    }

    public GetTopicsRequest convertRequest$ads_adservices_release(GetTopicsRequest getTopicsRequest) {
        Intrinsics.checkNotNullParameter(getTopicsRequest, "request");
        GetTopicsRequest build = new GetTopicsRequest.Builder().setAdsSdkName(getTopicsRequest.getAdsSdkName()).setShouldRecordObservation(getTopicsRequest.shouldRecordObservation()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…ion)\n            .build()");
        return build;
    }
}

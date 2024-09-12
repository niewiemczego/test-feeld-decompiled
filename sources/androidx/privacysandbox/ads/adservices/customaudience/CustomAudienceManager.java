package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.common.AdData;
import android.adservices.common.AdSelectionSignals;
import android.adservices.common.AdTechIdentifier;
import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.LeaveCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;
import android.content.Context;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl$$ExternalSyntheticLambda0;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudienceManager;", "", "()V", "joinCustomAudience", "", "request", "Landroidx/privacysandbox/ads/adservices/customaudience/JoinCustomAudienceRequest;", "(Landroidx/privacysandbox/ads/adservices/customaudience/JoinCustomAudienceRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "leaveCustomAudience", "Landroidx/privacysandbox/ads/adservices/customaudience/LeaveCustomAudienceRequest;", "(Landroidx/privacysandbox/ads/adservices/customaudience/LeaveCustomAudienceRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Api33Ext4Impl", "Companion", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CustomAudienceManager.kt */
public abstract class CustomAudienceManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final CustomAudienceManager obtain(Context context) {
        return Companion.obtain(context);
    }

    public abstract Object joinCustomAudience(JoinCustomAudienceRequest joinCustomAudienceRequest, Continuation<? super Unit> continuation);

    public abstract Object leaveCustomAudience(LeaveCustomAudienceRequest leaveCustomAudienceRequest, Continuation<? super Unit> continuation);

    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000fH\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u001cH\u0002J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001fH\u0002J\u0019\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010$R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudienceManager$Api33Ext4Impl;", "Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudienceManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "customAudienceManager", "Landroid/adservices/customaudience/CustomAudienceManager;", "(Landroid/adservices/customaudience/CustomAudienceManager;)V", "convertAdData", "", "Landroid/adservices/common/AdData;", "input", "Landroidx/privacysandbox/ads/adservices/common/AdData;", "convertAdTechIdentifier", "Landroid/adservices/common/AdTechIdentifier;", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "convertBiddingSignals", "Landroid/adservices/common/AdSelectionSignals;", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "convertCustomAudience", "Landroid/adservices/customaudience/CustomAudience;", "request", "Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience;", "convertJoinRequest", "Landroid/adservices/customaudience/JoinCustomAudienceRequest;", "Landroidx/privacysandbox/ads/adservices/customaudience/JoinCustomAudienceRequest;", "convertLeaveRequest", "Landroid/adservices/customaudience/LeaveCustomAudienceRequest;", "Landroidx/privacysandbox/ads/adservices/customaudience/LeaveCustomAudienceRequest;", "convertTrustedSignals", "Landroid/adservices/customaudience/TrustedBiddingData;", "Landroidx/privacysandbox/ads/adservices/customaudience/TrustedBiddingData;", "joinCustomAudience", "", "(Landroidx/privacysandbox/ads/adservices/customaudience/JoinCustomAudienceRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "leaveCustomAudience", "(Landroidx/privacysandbox/ads/adservices/customaudience/LeaveCustomAudienceRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CustomAudienceManager.kt */
    private static final class Api33Ext4Impl extends CustomAudienceManager {
        /* access modifiers changed from: private */
        public final android.adservices.customaudience.CustomAudienceManager customAudienceManager;

        public Api33Ext4Impl(android.adservices.customaudience.CustomAudienceManager customAudienceManager2) {
            Intrinsics.checkNotNullParameter(customAudienceManager2, "customAudienceManager");
            this.customAudienceManager = customAudienceManager2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Api33Ext4Impl(android.content.Context r2) {
            /*
                r1 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.Class<android.adservices.customaudience.CustomAudienceManager> r0 = android.adservices.customaudience.CustomAudienceManager.class
                java.lang.Object r2 = r2.getSystemService(r0)
                java.lang.String r0 = "context.getSystemService…:class.java\n            )"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.adservices.customaudience.CustomAudienceManager r2 = (android.adservices.customaudience.CustomAudienceManager) r2
                r1.<init>((android.adservices.customaudience.CustomAudienceManager) r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager.Api33Ext4Impl.<init>(android.content.Context):void");
        }

        /* access modifiers changed from: private */
        public final JoinCustomAudienceRequest convertJoinRequest(JoinCustomAudienceRequest joinCustomAudienceRequest) {
            JoinCustomAudienceRequest build = new JoinCustomAudienceRequest.Builder().setCustomAudience(convertCustomAudience(joinCustomAudienceRequest.getCustomAudience())).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
            return build;
        }

        /* access modifiers changed from: private */
        public final LeaveCustomAudienceRequest convertLeaveRequest(LeaveCustomAudienceRequest leaveCustomAudienceRequest) {
            LeaveCustomAudienceRequest build = new LeaveCustomAudienceRequest.Builder().setBuyer(convertAdTechIdentifier(leaveCustomAudienceRequest.getBuyer())).setName(leaveCustomAudienceRequest.getName()).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
            return build;
        }

        private final CustomAudience convertCustomAudience(CustomAudience customAudience) {
            CustomAudience build = new CustomAudience.Builder().setActivationTime(customAudience.getActivationTime()).setAds(convertAdData(customAudience.getAds())).setBiddingLogicUri(customAudience.getBiddingLogicUri()).setBuyer(convertAdTechIdentifier(customAudience.getBuyer())).setDailyUpdateUri(customAudience.getDailyUpdateUri()).setExpirationTime(customAudience.getExpirationTime()).setName(customAudience.getName()).setTrustedBiddingData(convertTrustedSignals(customAudience.getTrustedBiddingSignals())).setUserBiddingSignals(convertBiddingSignals(customAudience.getUserBiddingSignals())).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
            return build;
        }

        private final List<AdData> convertAdData(List<androidx.privacysandbox.ads.adservices.common.AdData> list) {
            List<AdData> arrayList = new ArrayList<>();
            for (androidx.privacysandbox.ads.adservices.common.AdData next : list) {
                AdData build = new AdData.Builder().setMetadata(next.getMetadata()).setRenderUri(next.getRenderUri()).build();
                Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …                 .build()");
                arrayList.add(build);
            }
            return arrayList;
        }

        private final AdTechIdentifier convertAdTechIdentifier(androidx.privacysandbox.ads.adservices.common.AdTechIdentifier adTechIdentifier) {
            AdTechIdentifier fromString = AdTechIdentifier.fromString(adTechIdentifier.getIdentifier());
            Intrinsics.checkNotNullExpressionValue(fromString, "fromString(input.identifier)");
            return fromString;
        }

        private final TrustedBiddingData convertTrustedSignals(TrustedBiddingData trustedBiddingData) {
            if (trustedBiddingData == null) {
                return null;
            }
            return new TrustedBiddingData.Builder().setTrustedBiddingKeys(trustedBiddingData.getTrustedBiddingKeys()).setTrustedBiddingUri(trustedBiddingData.getTrustedBiddingUri()).build();
        }

        private final AdSelectionSignals convertBiddingSignals(androidx.privacysandbox.ads.adservices.common.AdSelectionSignals adSelectionSignals) {
            if (adSelectionSignals == null) {
                return null;
            }
            return AdSelectionSignals.fromString(adSelectionSignals.getSignals());
        }

        public Object joinCustomAudience(JoinCustomAudienceRequest joinCustomAudienceRequest, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.customAudienceManager.joinCustomAudience(convertJoinRequest(joinCustomAudienceRequest), new AdIdManager$Api33Ext4Impl$$ExternalSyntheticLambda0(), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return result;
            }
            return Unit.INSTANCE;
        }

        public Object leaveCustomAudience(LeaveCustomAudienceRequest leaveCustomAudienceRequest, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.customAudienceManager.leaveCustomAudience(convertLeaveRequest(leaveCustomAudienceRequest), new AdIdManager$Api33Ext4Impl$$ExternalSyntheticLambda0(), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return result;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudienceManager$Companion;", "", "()V", "obtain", "Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudienceManager;", "context", "Landroid/content/Context;", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CustomAudienceManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CustomAudienceManager obtain(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (AdServicesInfo.INSTANCE.version() >= 4) {
                return new Api33Ext4Impl(context);
            }
            return null;
        }
    }
}

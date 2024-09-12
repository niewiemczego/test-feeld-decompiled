package androidx.privacysandbox.ads.adservices.java.customaudience;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager;
import androidx.privacysandbox.ads.adservices.customaudience.JoinCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.customaudience.LeaveCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u000b2\u00020\u0001:\u0002\n\u000bB\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\tH'¨\u0006\f"}, d2 = {"Landroidx/privacysandbox/ads/adservices/java/customaudience/CustomAudienceManagerFutures;", "", "()V", "joinCustomAudienceAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "request", "Landroidx/privacysandbox/ads/adservices/customaudience/JoinCustomAudienceRequest;", "leaveCustomAudienceAsync", "Landroidx/privacysandbox/ads/adservices/customaudience/LeaveCustomAudienceRequest;", "Api33Ext4JavaImpl", "Companion", "ads-adservices-java_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CustomAudienceManagerFutures.kt */
public abstract class CustomAudienceManagerFutures {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final CustomAudienceManagerFutures from(Context context) {
        return Companion.from(context);
    }

    public abstract ListenableFuture<Unit> joinCustomAudienceAsync(JoinCustomAudienceRequest joinCustomAudienceRequest);

    public abstract ListenableFuture<Unit> leaveCustomAudienceAsync(LeaveCustomAudienceRequest leaveCustomAudienceRequest);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0017J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u000bH\u0017R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/privacysandbox/ads/adservices/java/customaudience/CustomAudienceManagerFutures$Api33Ext4JavaImpl;", "Landroidx/privacysandbox/ads/adservices/java/customaudience/CustomAudienceManagerFutures;", "mCustomAudienceManager", "Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudienceManager;", "(Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudienceManager;)V", "joinCustomAudienceAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "request", "Landroidx/privacysandbox/ads/adservices/customaudience/JoinCustomAudienceRequest;", "leaveCustomAudienceAsync", "Landroidx/privacysandbox/ads/adservices/customaudience/LeaveCustomAudienceRequest;", "ads-adservices-java_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CustomAudienceManagerFutures.kt */
    private static final class Api33Ext4JavaImpl extends CustomAudienceManagerFutures {
        /* access modifiers changed from: private */
        public final CustomAudienceManager mCustomAudienceManager;

        public Api33Ext4JavaImpl(CustomAudienceManager customAudienceManager) {
            this.mCustomAudienceManager = customAudienceManager;
        }

        public ListenableFuture<Unit> joinCustomAudienceAsync(JoinCustomAudienceRequest joinCustomAudienceRequest) {
            Intrinsics.checkNotNullParameter(joinCustomAudienceRequest, "request");
            return CoroutineAdapterKt.asListenableFuture$default(BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1(this, joinCustomAudienceRequest, (Continuation<? super CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1>) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        public ListenableFuture<Unit> leaveCustomAudienceAsync(LeaveCustomAudienceRequest leaveCustomAudienceRequest) {
            Intrinsics.checkNotNullParameter(leaveCustomAudienceRequest, "request");
            return CoroutineAdapterKt.asListenableFuture$default(BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1(this, leaveCustomAudienceRequest, (Continuation<? super CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1>) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/privacysandbox/ads/adservices/java/customaudience/CustomAudienceManagerFutures$Companion;", "", "()V", "from", "Landroidx/privacysandbox/ads/adservices/java/customaudience/CustomAudienceManagerFutures;", "context", "Landroid/content/Context;", "ads-adservices-java_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CustomAudienceManagerFutures.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CustomAudienceManagerFutures from(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            CustomAudienceManager obtain = CustomAudienceManager.Companion.obtain(context);
            return obtain != null ? new Api33Ext4JavaImpl(obtain) : null;
        }
    }
}

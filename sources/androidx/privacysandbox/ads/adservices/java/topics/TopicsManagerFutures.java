package androidx.privacysandbox.ads.adservices.java.topics;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import androidx.privacysandbox.ads.adservices.topics.TopicsManager;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\n"}, d2 = {"Landroidx/privacysandbox/ads/adservices/java/topics/TopicsManagerFutures;", "", "()V", "getTopicsAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsResponse;", "request", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest;", "Api33Ext4JavaImpl", "Companion", "ads-adservices-java_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TopicsManagerFutures.kt */
public abstract class TopicsManagerFutures {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final TopicsManagerFutures from(Context context) {
        return Companion.from(context);
    }

    public abstract ListenableFuture<GetTopicsResponse> getTopicsAsync(GetTopicsRequest getTopicsRequest);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/privacysandbox/ads/adservices/java/topics/TopicsManagerFutures$Api33Ext4JavaImpl;", "Landroidx/privacysandbox/ads/adservices/java/topics/TopicsManagerFutures;", "mTopicsManager", "Landroidx/privacysandbox/ads/adservices/topics/TopicsManager;", "(Landroidx/privacysandbox/ads/adservices/topics/TopicsManager;)V", "getTopicsAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsResponse;", "request", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest;", "ads-adservices-java_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TopicsManagerFutures.kt */
    private static final class Api33Ext4JavaImpl extends TopicsManagerFutures {
        /* access modifiers changed from: private */
        public final TopicsManager mTopicsManager;

        public Api33Ext4JavaImpl(TopicsManager topicsManager) {
            Intrinsics.checkNotNullParameter(topicsManager, "mTopicsManager");
            this.mTopicsManager = topicsManager;
        }

        public ListenableFuture<GetTopicsResponse> getTopicsAsync(GetTopicsRequest getTopicsRequest) {
            Intrinsics.checkNotNullParameter(getTopicsRequest, "request");
            return CoroutineAdapterKt.asListenableFuture$default(BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new TopicsManagerFutures$Api33Ext4JavaImpl$getTopicsAsync$1(this, getTopicsRequest, (Continuation<? super TopicsManagerFutures$Api33Ext4JavaImpl$getTopicsAsync$1>) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/privacysandbox/ads/adservices/java/topics/TopicsManagerFutures$Companion;", "", "()V", "from", "Landroidx/privacysandbox/ads/adservices/java/topics/TopicsManagerFutures;", "context", "Landroid/content/Context;", "ads-adservices-java_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TopicsManagerFutures.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TopicsManagerFutures from(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            TopicsManager obtain = TopicsManager.Companion.obtain(context);
            return obtain != null ? new Api33Ext4JavaImpl(obtain) : null;
        }
    }
}

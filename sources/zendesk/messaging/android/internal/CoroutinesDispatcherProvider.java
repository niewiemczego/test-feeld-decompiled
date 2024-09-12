package zendesk.messaging.android.internal;

import com.facebook.hermes.intl.Constants;
import io.sentry.protocol.SentryThread;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0017¢\u0006\u0002\u0010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lzendesk/messaging/android/internal/CoroutinesDispatcherProvider;", "", "()V", "main", "Lkotlinx/coroutines/CoroutineDispatcher;", "io", "default", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getDefault", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getIo", "getMain", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoroutinesDispatcherProvider.kt */
public final class CoroutinesDispatcherProvider {

    /* renamed from: default  reason: not valid java name */
    private final CoroutineDispatcher f1default;

    /* renamed from: io  reason: collision with root package name */
    private final CoroutineDispatcher f31io;
    private final CoroutineDispatcher main;

    public static /* synthetic */ CoroutinesDispatcherProvider copy$default(CoroutinesDispatcherProvider coroutinesDispatcherProvider, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineDispatcher = coroutinesDispatcherProvider.main;
        }
        if ((i & 2) != 0) {
            coroutineDispatcher2 = coroutinesDispatcherProvider.f31io;
        }
        if ((i & 4) != 0) {
            coroutineDispatcher3 = coroutinesDispatcherProvider.f1default;
        }
        return coroutinesDispatcherProvider.copy(coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3);
    }

    public final CoroutineDispatcher component1() {
        return this.main;
    }

    public final CoroutineDispatcher component2() {
        return this.f31io;
    }

    public final CoroutineDispatcher component3() {
        return this.f1default;
    }

    public final CoroutinesDispatcherProvider copy(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, SentryThread.JsonKeys.MAIN);
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "io");
        Intrinsics.checkNotNullParameter(coroutineDispatcher3, Constants.COLLATION_DEFAULT);
        return new CoroutinesDispatcherProvider(coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CoroutinesDispatcherProvider)) {
            return false;
        }
        CoroutinesDispatcherProvider coroutinesDispatcherProvider = (CoroutinesDispatcherProvider) obj;
        return Intrinsics.areEqual((Object) this.main, (Object) coroutinesDispatcherProvider.main) && Intrinsics.areEqual((Object) this.f31io, (Object) coroutinesDispatcherProvider.f31io) && Intrinsics.areEqual((Object) this.f1default, (Object) coroutinesDispatcherProvider.f1default);
    }

    public int hashCode() {
        return (((this.main.hashCode() * 31) + this.f31io.hashCode()) * 31) + this.f1default.hashCode();
    }

    public String toString() {
        return "CoroutinesDispatcherProvider(main=" + this.main + ", io=" + this.f31io + ", default=" + this.f1default + ')';
    }

    public CoroutinesDispatcherProvider(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, SentryThread.JsonKeys.MAIN);
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "io");
        Intrinsics.checkNotNullParameter(coroutineDispatcher3, Constants.COLLATION_DEFAULT);
        this.main = coroutineDispatcher;
        this.f31io = coroutineDispatcher2;
        this.f1default = coroutineDispatcher3;
    }

    public final CoroutineDispatcher getMain() {
        return this.main;
    }

    public final CoroutineDispatcher getIo() {
        return this.f31io;
    }

    public final CoroutineDispatcher getDefault() {
        return this.f1default;
    }

    @Inject
    public CoroutinesDispatcherProvider() {
        this(Dispatchers.getMain(), Dispatchers.getIO(), Dispatchers.getDefault());
    }
}

package zendesk.android.internal.frontendevents;

import com.oblador.keychain.KeychainModule;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import zendesk.android.internal.di.ZendeskInitializedComponentScope;
import zendesk.storage.android.Storage;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001b\b\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0011\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lzendesk/android/internal/frontendevents/FrontendEventsStorage;", "", "storage", "Lzendesk/storage/android/Storage;", "persistenceDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lzendesk/storage/android/Storage;Lkotlinx/coroutines/CoroutineDispatcher;)V", "createNewSUID", "", "getSUID", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isOutOfDate", "", "storedTimestamp", "", "resetSUIDTimestamp", "", "Companion", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ZendeskInitializedComponentScope
/* compiled from: FrontendEventsStorage.kt */
public final class FrontendEventsStorage {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String KEY_SUID = "suid";
    @Deprecated
    public static final String KEY_SUID_TIMESTAMP = "suid_timestamp";
    /* access modifiers changed from: private */
    @Deprecated
    public static final long OUT_OF_DATE_DURATION = TimeUnit.MINUTES.toMillis(30);
    private final CoroutineDispatcher persistenceDispatcher;
    /* access modifiers changed from: private */
    public final Storage storage;

    @Inject
    public FrontendEventsStorage(@Named("FRONTEND_EVENTS_STORAGE") Storage storage2, @Named("PERSISTENCE_DISPATCHER") CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(storage2, KeychainModule.Maps.STORAGE);
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "persistenceDispatcher");
        this.storage = storage2;
        this.persistenceDispatcher = coroutineDispatcher;
    }

    public final Object getSUID(Continuation<? super String> continuation) {
        return BuildersKt.withContext(this.persistenceDispatcher, new FrontendEventsStorage$getSUID$2(this, (Continuation<? super FrontendEventsStorage$getSUID$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final String createNewSUID() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.storage.set(KEY_SUID, uuid, String.class);
        return uuid;
    }

    /* access modifiers changed from: private */
    public final void resetSUIDTimestamp() {
        this.storage.set(KEY_SUID_TIMESTAMP, Long.valueOf(System.currentTimeMillis()), Long.TYPE);
    }

    /* access modifiers changed from: private */
    public final boolean isOutOfDate(long j) {
        return System.currentTimeMillis() - j > OUT_OF_DATE_DURATION;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lzendesk/android/internal/frontendevents/FrontendEventsStorage$Companion;", "", "()V", "KEY_SUID", "", "KEY_SUID_TIMESTAMP", "OUT_OF_DATE_DURATION", "", "getOUT_OF_DATE_DURATION", "()J", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FrontendEventsStorage.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getOUT_OF_DATE_DURATION() {
            return FrontendEventsStorage.OUT_OF_DATE_DURATION;
        }
    }
}

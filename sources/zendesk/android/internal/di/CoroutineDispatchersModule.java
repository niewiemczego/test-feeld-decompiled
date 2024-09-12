package zendesk.android.internal.di;

import dagger.Module;
import dagger.Provides;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lzendesk/android/internal/di/CoroutineDispatchersModule;", "", "()V", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "mainDispatcher", "persistenceDispatcher", "Companion", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* compiled from: CoroutineDispatchersModule.kt */
public final class CoroutineDispatchersModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEFAULT_DISPATCHER = "DEFAULT_DISPATCHER";
    public static final String IO_DISPATCHER = "IO_DISPATCHER";
    public static final String MAIN_DISPATCHER = "MAIN_DISPATCHER";
    public static final String PERSISTENCE_DISPATCHER = "PERSISTENCE_DISPATCHER";

    @Singleton
    @Provides
    @Named("MAIN_DISPATCHER")
    public final CoroutineDispatcher mainDispatcher() {
        return Dispatchers.getMain();
    }

    @Singleton
    @Provides
    @Named("DEFAULT_DISPATCHER")
    public final CoroutineDispatcher defaultDispatcher() {
        return Dispatchers.getDefault();
    }

    @Singleton
    @Provides
    @Named("IO_DISPATCHER")
    public final CoroutineDispatcher ioDispatcher() {
        return Dispatchers.getIO();
    }

    @Singleton
    @Provides
    @Named("PERSISTENCE_DISPATCHER")
    public final CoroutineDispatcher persistenceDispatcher() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        return ExecutorsKt.from(newSingleThreadExecutor);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lzendesk/android/internal/di/CoroutineDispatchersModule$Companion;", "", "()V", "DEFAULT_DISPATCHER", "", "IO_DISPATCHER", "MAIN_DISPATCHER", "PERSISTENCE_DISPATCHER", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CoroutineDispatchersModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

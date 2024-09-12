package zendesk.conversationkit.android.internal.app;

import com.oblador.keychain.KeychainModule;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import zendesk.conversationkit.android.model.User;
import zendesk.storage.android.PersistedProperty;
import zendesk.storage.android.Storage;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R/\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068B@BX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lzendesk/conversationkit/android/internal/app/AppStorage;", "", "storage", "Lzendesk/storage/android/Storage;", "(Lzendesk/storage/android/Storage;)V", "<set-?>", "Lzendesk/conversationkit/android/model/User;", "persistedUser", "getPersistedUser", "()Lzendesk/conversationkit/android/model/User;", "setPersistedUser", "(Lzendesk/conversationkit/android/model/User;)V", "persistedUser$delegate", "Lzendesk/storage/android/PersistedProperty;", "persistenceDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "clearUser", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUser", "setUser", "user", "(Lzendesk/conversationkit/android/model/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppStorage.kt */
public final class AppStorage {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(AppStorage.class, "persistedUser", "getPersistedUser()Lzendesk/conversationkit/android/model/User;", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_PERSISTED_USER = "PERSISTED_USER";
    private final PersistedProperty persistedUser$delegate;
    private final ExecutorCoroutineDispatcher persistenceDispatcher;

    public AppStorage(Storage storage) {
        Intrinsics.checkNotNullParameter(storage, KeychainModule.Maps.STORAGE);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        this.persistenceDispatcher = ExecutorsKt.from(newSingleThreadExecutor);
        this.persistedUser$delegate = new PersistedProperty(storage, KEY_PERSISTED_USER, User.class);
    }

    /* access modifiers changed from: private */
    public final User getPersistedUser() {
        return (User) this.persistedUser$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* access modifiers changed from: private */
    public final void setPersistedUser(User user) {
        this.persistedUser$delegate.setValue(this, $$delegatedProperties[0], user);
    }

    public final Object getUser(Continuation<? super User> continuation) {
        return BuildersKt.withContext(this.persistenceDispatcher, new AppStorage$getUser$2(this, (Continuation<? super AppStorage$getUser$2>) null), continuation);
    }

    public final Object setUser(User user, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.persistenceDispatcher, new AppStorage$setUser$2(this, user, (Continuation<? super AppStorage$setUser$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object clearUser(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.persistenceDispatcher, new AppStorage$clearUser$2(this, (Continuation<? super AppStorage$clearUser$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/conversationkit/android/internal/app/AppStorage$Companion;", "", "()V", "KEY_PERSISTED_USER", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AppStorage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

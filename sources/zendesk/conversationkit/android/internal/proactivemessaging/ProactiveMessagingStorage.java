package zendesk.conversationkit.android.internal.proactivemessaging;

import com.oblador.keychain.KeychainModule;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import zendesk.conversationkit.android.model.ProactiveMessage;
import zendesk.storage.android.Storage;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0019\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lzendesk/conversationkit/android/internal/proactivemessaging/ProactiveMessagingStorage;", "", "storage", "Lzendesk/storage/android/Storage;", "(Lzendesk/storage/android/Storage;)V", "persistenceDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "clear", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearProactiveMessage", "proactiveMessageId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProactiveMessage", "Lzendesk/conversationkit/android/model/ProactiveMessage;", "setProactiveMessage", "proactiveMessage", "(Lzendesk/conversationkit/android/model/ProactiveMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProactiveMessagingStorage.kt */
public final class ProactiveMessagingStorage {
    private final ExecutorCoroutineDispatcher persistenceDispatcher;
    /* access modifiers changed from: private */
    public final Storage storage;

    public ProactiveMessagingStorage(Storage storage2) {
        Intrinsics.checkNotNullParameter(storage2, KeychainModule.Maps.STORAGE);
        this.storage = storage2;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        this.persistenceDispatcher = ExecutorsKt.from(newSingleThreadExecutor);
    }

    public final Object clear(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.persistenceDispatcher, new ProactiveMessagingStorage$clear$2(this, (Continuation<? super ProactiveMessagingStorage$clear$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object getProactiveMessage(int i, Continuation<? super ProactiveMessage> continuation) {
        return BuildersKt.withContext(this.persistenceDispatcher, new ProactiveMessagingStorage$getProactiveMessage$2(this, i, (Continuation<? super ProactiveMessagingStorage$getProactiveMessage$2>) null), continuation);
    }

    public final Object setProactiveMessage(ProactiveMessage proactiveMessage, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.persistenceDispatcher, new ProactiveMessagingStorage$setProactiveMessage$2(this, proactiveMessage, (Continuation<? super ProactiveMessagingStorage$setProactiveMessage$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object clearProactiveMessage(int i, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.persistenceDispatcher, new ProactiveMessagingStorage$clearProactiveMessage$2(this, i, (Continuation<? super ProactiveMessagingStorage$clearProactiveMessage$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}

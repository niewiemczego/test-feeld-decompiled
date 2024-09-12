package zendesk.messaging.android.internal.conversationscreen.cache;

import com.oblador.keychain.KeychainModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import zendesk.storage.android.Storage;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/cache/MessagingStorage;", "", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "storage", "Lzendesk/storage/android/Storage;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lzendesk/storage/android/Storage;)V", "clear", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessagingPersistence", "Lzendesk/messaging/android/internal/conversationscreen/cache/MessagingUIPersistence;", "conversationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMessagingPersistence", "messagingUIPersistence", "(Lzendesk/messaging/android/internal/conversationscreen/cache/MessagingUIPersistence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessagingStorage.kt */
public final class MessagingStorage {
    private final CoroutineDispatcher ioDispatcher;
    /* access modifiers changed from: private */
    public final Storage storage;

    public MessagingStorage(CoroutineDispatcher coroutineDispatcher, Storage storage2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(storage2, KeychainModule.Maps.STORAGE);
        this.ioDispatcher = coroutineDispatcher;
        this.storage = storage2;
    }

    public final Object setMessagingPersistence(MessagingUIPersistence messagingUIPersistence, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.ioDispatcher, new MessagingStorage$setMessagingPersistence$2(this, messagingUIPersistence, (Continuation<? super MessagingStorage$setMessagingPersistence$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object getMessagingPersistence(String str, Continuation<? super MessagingUIPersistence> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new MessagingStorage$getMessagingPersistence$2(this, str, (Continuation<? super MessagingStorage$getMessagingPersistence$2>) null), continuation);
    }

    public final Object clear(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.ioDispatcher, new MessagingStorage$clear$2(this, (Continuation<? super MessagingStorage$clear$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}

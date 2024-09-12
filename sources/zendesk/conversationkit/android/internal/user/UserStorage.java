package zendesk.conversationkit.android.internal.user;

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
import zendesk.conversationkit.android.model.Conversation;
import zendesk.storage.android.Storage;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lzendesk/conversationkit/android/internal/user/UserStorage;", "", "storage", "Lzendesk/storage/android/Storage;", "(Lzendesk/storage/android/Storage;)V", "persistenceDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "clear", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConversation", "Lzendesk/conversationkit/android/model/Conversation;", "conversationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setConversation", "conversation", "(Lzendesk/conversationkit/android/model/Conversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserStorage.kt */
public final class UserStorage {
    private final ExecutorCoroutineDispatcher persistenceDispatcher;
    /* access modifiers changed from: private */
    public final Storage storage;

    public UserStorage(Storage storage2) {
        Intrinsics.checkNotNullParameter(storage2, KeychainModule.Maps.STORAGE);
        this.storage = storage2;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        this.persistenceDispatcher = ExecutorsKt.from(newSingleThreadExecutor);
    }

    public final Object clear(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.persistenceDispatcher, new UserStorage$clear$2(this, (Continuation<? super UserStorage$clear$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object getConversation(String str, Continuation<? super Conversation> continuation) {
        return BuildersKt.withContext(this.persistenceDispatcher, new UserStorage$getConversation$2(this, str, (Continuation<? super UserStorage$getConversation$2>) null), continuation);
    }

    public final Object setConversation(Conversation conversation, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.persistenceDispatcher, new UserStorage$setConversation$2(this, conversation, (Continuation<? super UserStorage$setConversation$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}

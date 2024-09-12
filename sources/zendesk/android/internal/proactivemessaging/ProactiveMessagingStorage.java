package zendesk.android.internal.proactivemessaging;

import com.oblador.keychain.KeychainModule;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import zendesk.android.internal.di.ZendeskInitializedComponentScope;
import zendesk.storage.android.Storage;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0001\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001b\b\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lzendesk/android/internal/proactivemessaging/ProactiveMessagingStorage;", "", "storage", "Lzendesk/storage/android/Storage;", "persistenceDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lzendesk/storage/android/Storage;Lkotlinx/coroutines/CoroutineDispatcher;)V", "addSendOnceCampaign", "", "campaignId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSendOnceCampaignIds", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeSendOnceCampaign", "Companion", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ZendeskInitializedComponentScope
/* compiled from: ProactiveMessagingStorage.kt */
public final class ProactiveMessagingStorage {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String KEY_SEND_ONCE_CAMPAIGN_IDS = "ProactiveMessagingStorage.KEY_SEND_ONCE_CAMPAIGN_IDS";
    private final CoroutineDispatcher persistenceDispatcher;
    /* access modifiers changed from: private */
    public final Storage storage;

    @Inject
    public ProactiveMessagingStorage(@Named("PROACTIVE_MESSAGING_STORAGE") Storage storage2, @Named("PERSISTENCE_DISPATCHER") CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(storage2, KeychainModule.Maps.STORAGE);
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "persistenceDispatcher");
        this.storage = storage2;
        this.persistenceDispatcher = coroutineDispatcher;
    }

    public final Object addSendOnceCampaign(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.persistenceDispatcher, new ProactiveMessagingStorage$addSendOnceCampaign$2(this, str, (Continuation<? super ProactiveMessagingStorage$addSendOnceCampaign$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object removeSendOnceCampaign(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.persistenceDispatcher, new ProactiveMessagingStorage$removeSendOnceCampaign$2(this, str, (Continuation<? super ProactiveMessagingStorage$removeSendOnceCampaign$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object getSendOnceCampaignIds(Continuation<? super List<String>> continuation) {
        return BuildersKt.withContext(this.persistenceDispatcher, new ProactiveMessagingStorage$getSendOnceCampaignIds$2(this, (Continuation<? super ProactiveMessagingStorage$getSendOnceCampaignIds$2>) null), continuation);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/android/internal/proactivemessaging/ProactiveMessagingStorage$Companion;", "", "()V", "KEY_SEND_ONCE_CAMPAIGN_IDS", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProactiveMessagingStorage.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

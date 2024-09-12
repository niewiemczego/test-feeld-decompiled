package zendesk.conversationkit.android.internal;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import zendesk.conversationkit.android.internal.rest.RestClientFactory;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lzendesk/conversationkit/android/internal/Environment;", "", "hostAppInfo", "Lzendesk/conversationkit/android/internal/HostAppInfo;", "getHostAppInfo", "()Lzendesk/conversationkit/android/internal/HostAppInfo;", "restClientFactory", "Lzendesk/conversationkit/android/internal/rest/RestClientFactory;", "getRestClientFactory", "()Lzendesk/conversationkit/android/internal/rest/RestClientFactory;", "sdkVersion", "", "getSdkVersion", "()Ljava/lang/String;", "storageFactory", "Lzendesk/conversationkit/android/internal/StorageFactory;", "getStorageFactory", "()Lzendesk/conversationkit/android/internal/StorageFactory;", "conversationKitStore", "Lzendesk/conversationkit/android/internal/ConversationKitStore;", "createConnectivityObserver", "Lzendesk/conversationkit/android/internal/ConnectivityObserver;", "createCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Environment.kt */
public interface Environment {
    public static final Companion Companion = Companion.$$INSTANCE;

    ConversationKitStore conversationKitStore();

    ConnectivityObserver createConnectivityObserver();

    CoroutineScope createCoroutineScope();

    HostAppInfo getHostAppInfo();

    RestClientFactory getRestClientFactory();

    String getSdkVersion();

    StorageFactory getStorageFactory();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lzendesk/conversationkit/android/internal/Environment$Companion;", "", "()V", "main", "Lzendesk/conversationkit/android/internal/Environment;", "context", "Landroid/content/Context;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Environment.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final Environment main(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new MainEnvironment(context, (ConversationKitDispatchers) null, 2, (DefaultConstructorMarker) null);
        }
    }
}

package zendesk.conversationkit.android.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import zendesk.conversationkit.android.BuildConfig;
import zendesk.conversationkit.android.internal.faye.SunCoFayeClientFactory;
import zendesk.conversationkit.android.internal.rest.DefaultRestClientFiles;
import zendesk.conversationkit.android.internal.rest.RestClientFactory;
import zendesk.storage.android.Serializer;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u0018XD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006&"}, d2 = {"Lzendesk/conversationkit/android/internal/MainEnvironment;", "Lzendesk/conversationkit/android/internal/Environment;", "context", "Landroid/content/Context;", "dispatchers", "Lzendesk/conversationkit/android/internal/ConversationKitDispatchers;", "(Landroid/content/Context;Lzendesk/conversationkit/android/internal/ConversationKitDispatchers;)V", "cacheDir", "Ljava/io/File;", "clientDtoProvider", "Lzendesk/conversationkit/android/internal/ClientDtoProvider;", "connectivityManager", "Landroid/net/ConnectivityManager;", "hostAppInfo", "Lzendesk/conversationkit/android/internal/HostAppInfo;", "getHostAppInfo", "()Lzendesk/conversationkit/android/internal/HostAppInfo;", "restClientFactory", "Lzendesk/conversationkit/android/internal/rest/RestClientFactory;", "getRestClientFactory", "()Lzendesk/conversationkit/android/internal/rest/RestClientFactory;", "restClientFiles", "Lzendesk/conversationkit/android/internal/rest/DefaultRestClientFiles;", "sdkVendor", "", "sdkVersion", "getSdkVersion", "()Ljava/lang/String;", "storageFactory", "Lzendesk/conversationkit/android/internal/StorageFactory;", "getStorageFactory", "()Lzendesk/conversationkit/android/internal/StorageFactory;", "conversationKitStore", "Lzendesk/conversationkit/android/internal/ConversationKitStore;", "createConnectivityObserver", "Lzendesk/conversationkit/android/internal/ConnectivityObserver;", "createCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Environment.kt */
public final class MainEnvironment implements Environment {
    private final File cacheDir;
    private final ClientDtoProvider clientDtoProvider;
    private final ConnectivityManager connectivityManager;
    private final ConversationKitDispatchers dispatchers;
    private final HostAppInfo hostAppInfo;
    private final RestClientFactory restClientFactory;
    private final DefaultRestClientFiles restClientFiles;
    /* access modifiers changed from: private */
    public final String sdkVendor;
    private final String sdkVersion;
    private final StorageFactory storageFactory;

    public MainEnvironment(Context context, ConversationKitDispatchers conversationKitDispatchers) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(conversationKitDispatchers, "dispatchers");
        this.dispatchers = conversationKitDispatchers;
        this.sdkVendor = "conversation-kit";
        File file = new File(context.getCacheDir(), "zendesk.conversationkit");
        this.cacheDir = file;
        this.sdkVersion = BuildConfig.VERSION_NAME;
        this.hostAppInfo = HostAppInfo.Companion.from(context);
        this.storageFactory = new StorageFactory(context, (Serializer) null, 2, (DefaultConstructorMarker) null);
        String sdkVersion2 = getSdkVersion();
        HostAppInfo hostAppInfo2 = getHostAppInfo();
        String languageTag = Locale.getDefault().toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "getDefault().toLanguageTag()");
        this.clientDtoProvider = new ClientDtoProvider("conversation-kit", sdkVersion2, hostAppInfo2, languageTag);
        DefaultRestClientFiles defaultRestClientFiles = new DefaultRestClientFiles(context);
        this.restClientFiles = defaultRestClientFiles;
        this.restClientFactory = new RestClientFactory(SetsKt.setOf(TuplesKt.to("x-smooch-appname", new MainEnvironment$restClientFactory$1(this, (Continuation<? super MainEnvironment$restClientFactory$1>) null)), TuplesKt.to("x-smooch-sdk", new MainEnvironment$restClientFactory$2(this, (Continuation<? super MainEnvironment$restClientFactory$2>) null)), TuplesKt.to("User-Agent", new MainEnvironment$restClientFactory$3(this, (Continuation<? super MainEnvironment$restClientFactory$3>) null))), defaultRestClientFiles, file);
        this.connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, ConnectivityManager.class);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MainEnvironment(Context context, ConversationKitDispatchers conversationKitDispatchers, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new DefaultConversationKitDispatchers() : conversationKitDispatchers);
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public HostAppInfo getHostAppInfo() {
        return this.hostAppInfo;
    }

    public StorageFactory getStorageFactory() {
        return this.storageFactory;
    }

    public RestClientFactory getRestClientFactory() {
        return this.restClientFactory;
    }

    public ConnectivityObserver createConnectivityObserver() {
        return new ConnectivityObserver(this.connectivityManager, createCoroutineScope());
    }

    public ConversationKitStore conversationKitStore() {
        SunCoFayeClientFactory sunCoFayeClientFactory = new SunCoFayeClientFactory(createCoroutineScope());
        ConversationKitStore conversationKitStore = new ConversationKitStore(new EffectProcessor(new EffectMapper(), new AccessLevelBuilder(getRestClientFactory(), sunCoFayeClientFactory, getStorageFactory(), this.clientDtoProvider, this.restClientFiles)), createCoroutineScope(), (ConversationKitDispatchers) null, 4, (DefaultConstructorMarker) null);
        sunCoFayeClientFactory.setActionDispatcher(conversationKitStore);
        return conversationKitStore;
    }

    public CoroutineScope createCoroutineScope() {
        return CoroutineScopeKt.CoroutineScope(this.dispatchers.m2752default().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }
}

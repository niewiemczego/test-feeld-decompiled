package zendesk.conversationkit.android.internal;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.ConversationKitSettings;
import zendesk.conversationkit.android.internal.app.AppActionProcessor;
import zendesk.conversationkit.android.internal.app.AppStorage;
import zendesk.conversationkit.android.internal.faye.SunCoFayeClient;
import zendesk.conversationkit.android.internal.faye.SunCoFayeClientFactory;
import zendesk.conversationkit.android.internal.integration.IntegrationActionProcessor;
import zendesk.conversationkit.android.internal.noaccess.NoAccessActionProcessor;
import zendesk.conversationkit.android.internal.rest.RestClientFactory;
import zendesk.conversationkit.android.internal.rest.RestClientFiles;
import zendesk.conversationkit.android.internal.rest.UserRestClient;
import zendesk.conversationkit.android.internal.user.Jwt;
import zendesk.conversationkit.android.internal.user.UserActionProcessor;
import zendesk.conversationkit.android.internal.user.UserStorage;
import zendesk.conversationkit.android.model.Config;
import zendesk.conversationkit.android.model.User;
import zendesk.faye.internal.Bayeux;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u000eJ&\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lzendesk/conversationkit/android/internal/AccessLevelBuilder;", "", "restClientFactory", "Lzendesk/conversationkit/android/internal/rest/RestClientFactory;", "sunCoFayeClientFactory", "Lzendesk/conversationkit/android/internal/faye/SunCoFayeClientFactory;", "storageFactory", "Lzendesk/conversationkit/android/internal/StorageFactory;", "clientDtoProvider", "Lzendesk/conversationkit/android/internal/ClientDtoProvider;", "restClientFiles", "Lzendesk/conversationkit/android/internal/rest/RestClientFiles;", "(Lzendesk/conversationkit/android/internal/rest/RestClientFactory;Lzendesk/conversationkit/android/internal/faye/SunCoFayeClientFactory;Lzendesk/conversationkit/android/internal/StorageFactory;Lzendesk/conversationkit/android/internal/ClientDtoProvider;Lzendesk/conversationkit/android/internal/rest/RestClientFiles;)V", "buildAppAccess", "Lzendesk/conversationkit/android/internal/AccessLevel;", "conversationKitSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "config", "Lzendesk/conversationkit/android/model/Config;", "buildIntegrationAccess", "buildNoAccess", "buildUserAccess", "user", "Lzendesk/conversationkit/android/model/User;", "clientId", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccessLevelBuilder.kt */
public final class AccessLevelBuilder {
    private final ClientDtoProvider clientDtoProvider;
    private final RestClientFactory restClientFactory;
    private final RestClientFiles restClientFiles;
    private final StorageFactory storageFactory;
    private final SunCoFayeClientFactory sunCoFayeClientFactory;

    public AccessLevelBuilder(RestClientFactory restClientFactory2, SunCoFayeClientFactory sunCoFayeClientFactory2, StorageFactory storageFactory2, ClientDtoProvider clientDtoProvider2, RestClientFiles restClientFiles2) {
        Intrinsics.checkNotNullParameter(restClientFactory2, "restClientFactory");
        Intrinsics.checkNotNullParameter(sunCoFayeClientFactory2, "sunCoFayeClientFactory");
        Intrinsics.checkNotNullParameter(storageFactory2, "storageFactory");
        Intrinsics.checkNotNullParameter(clientDtoProvider2, "clientDtoProvider");
        Intrinsics.checkNotNullParameter(restClientFiles2, "restClientFiles");
        this.restClientFactory = restClientFactory2;
        this.sunCoFayeClientFactory = sunCoFayeClientFactory2;
        this.storageFactory = storageFactory2;
        this.clientDtoProvider = clientDtoProvider2;
        this.restClientFiles = restClientFiles2;
    }

    public final AccessLevel buildNoAccess() {
        return new NoAccess(new NoAccessActionProcessor());
    }

    public final AccessLevel buildIntegrationAccess(ConversationKitSettings conversationKitSettings) {
        Intrinsics.checkNotNullParameter(conversationKitSettings, "conversationKitSettings");
        CharSequence baseUrl$zendesk_conversationkit_conversationkit_android = conversationKitSettings.getBaseUrl$zendesk_conversationkit_conversationkit_android();
        if (baseUrl$zendesk_conversationkit_conversationkit_android.length() == 0) {
            baseUrl$zendesk_conversationkit_conversationkit_android = "https://" + conversationKitSettings.getIntegrationId() + ".config" + conversationKitSettings.getRegion().getValue$zendesk_conversationkit_conversationkit_android() + ".smooch.io";
        }
        return new IntegrationAccess(new IntegrationActionProcessor(conversationKitSettings, this.restClientFactory.createIntegrationRestClient(conversationKitSettings.getIntegrationId(), (String) baseUrl$zendesk_conversationkit_conversationkit_android), (ConversationKitDispatchers) null, 4, (DefaultConstructorMarker) null));
    }

    public final AccessLevel buildAppAccess(ConversationKitSettings conversationKitSettings, Config config) {
        ConversationKitSettings conversationKitSettings2 = conversationKitSettings;
        Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
        Config config2 = config;
        Intrinsics.checkNotNullParameter(config2, "config");
        ConversationKitStorage createConversationKitStorage = this.storageFactory.createConversationKitStorage();
        return new AppAccess(new AppActionProcessor(conversationKitSettings2, config2, this.restClientFactory.createAppRestClient(config.getApp().getId(), config.getBaseUrl()), this.clientDtoProvider, this.storageFactory.createAppStorage(config.getApp().getId()), createConversationKitStorage, this.storageFactory.createProactiveMessagingStorage(), (Jwt.Decoder) null, (ConversationKitDispatchers) null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, (DefaultConstructorMarker) null), createConversationKitStorage);
    }

    public final AccessLevel buildUserAccess(ConversationKitSettings conversationKitSettings, Config config, User user, String str) {
        String str2 = str;
        ConversationKitSettings conversationKitSettings2 = conversationKitSettings;
        Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
        Config config2 = config;
        Intrinsics.checkNotNullParameter(config2, "config");
        User user2 = user;
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(str2, Bayeux.KEY_CLIENT_ID);
        ConversationKitStorage createConversationKitStorage = this.storageFactory.createConversationKitStorage();
        SunCoFayeClient create = this.sunCoFayeClientFactory.create(user.getRealtimeSettings(), user.getAuthenticationType());
        UserRestClient createUserRestClient = this.restClientFactory.createUserRestClient(config.getApp().getId(), user.getId(), config.getBaseUrl(), str2);
        UserStorage createUserStorage = this.storageFactory.createUserStorage(user.getId());
        AppStorage createAppStorage = this.storageFactory.createAppStorage(config.getApp().getId());
        ClientDtoProvider clientDtoProvider2 = this.clientDtoProvider;
        return new UserAccess(new UserActionProcessor(conversationKitSettings2, config2, user2, create, createUserRestClient, createUserStorage, createAppStorage, createConversationKitStorage, this.storageFactory.createProactiveMessagingStorage(), this.restClientFiles, clientDtoProvider2, (Jwt.Decoder) null, 2048, (DefaultConstructorMarker) null), createConversationKitStorage);
    }
}

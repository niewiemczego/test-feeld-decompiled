package zendesk.android.internal;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import zendesk.android.settings.internal.model.SunCoConfigDto;
import zendesk.conversationkit.android.model.App;
import zendesk.conversationkit.android.model.Config;
import zendesk.conversationkit.android.model.Integration;
import zendesk.conversationkit.android.model.RestRetryPolicy;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lzendesk/android/internal/ConversationKitProvider;", "", "()V", "createConversationKit", "Lzendesk/conversationkit/android/ConversationKitResult;", "Lzendesk/conversationkit/android/ConversationKit;", "settings", "Lzendesk/android/settings/internal/model/SettingsDto;", "context", "Landroid/content/Context;", "createConversationKit$zendesk_zendesk_android", "(Lzendesk/android/settings/internal/model/SettingsDto;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toConversationKitConfig", "Lzendesk/conversationkit/android/model/Config;", "Lzendesk/android/settings/internal/model/SunCoConfigDto;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationKitProvider.kt */
public final class ConversationKitProvider {
    public static final ConversationKitProvider INSTANCE = new ConversationKitProvider();

    private ConversationKitProvider() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0021, code lost:
        r4 = (r4 = r0.getApp()).getSettings();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createConversationKit$zendesk_zendesk_android(zendesk.android.settings.internal.model.SettingsDto r7, android.content.Context r8, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.ConversationKitResult<? extends zendesk.conversationkit.android.ConversationKit>> r9) {
        /*
            r6 = this;
            zendesk.android.settings.internal.model.SunCoConfigDto r0 = r7.getSunCoConfigDto()
            zendesk.android.settings.internal.model.NativeMessagingDto r1 = r7.getNativeMessaging()
            zendesk.android.settings.internal.model.ColorThemeDto r2 = r7.getLightTheme()
            zendesk.android.messaging.model.ColorTheme r2 = zendesk.android.messaging.model.ColorThemeKt.toColorTheme(r2)
            zendesk.android.settings.internal.model.ColorThemeDto r7 = r7.getDarkTheme()
            zendesk.android.messaging.model.ColorTheme r7 = zendesk.android.messaging.model.ColorThemeKt.toColorTheme(r7)
            r3 = 0
            if (r0 == 0) goto L_0x002c
            zendesk.android.settings.internal.model.AppDto r4 = r0.getApp()
            if (r4 == 0) goto L_0x002c
            zendesk.android.settings.internal.model.AppSettingsDto r4 = r4.getSettings()
            if (r4 == 0) goto L_0x002c
            boolean r4 = r4.isMultiConvoEnabled()
            goto L_0x002d
        L_0x002c:
            r4 = r3
        L_0x002d:
            if (r0 == 0) goto L_0x0039
            zendesk.android.settings.internal.model.IntegrationDto r5 = r0.getIntegration()
            if (r5 == 0) goto L_0x0039
            boolean r3 = r5.getCanUserCreateMoreConversations()
        L_0x0039:
            zendesk.android.messaging.model.MessagingSettings r7 = zendesk.android.messaging.model.MessagingSettingsKt.toMessagingSettings(r1, r2, r7, r4, r3)
            java.lang.String r7 = r7.getIntegrationId()
            if (r0 == 0) goto L_0x005f
            if (r7 != 0) goto L_0x0046
            goto L_0x005f
        L_0x0046:
            zendesk.conversationkit.android.model.Config r0 = r6.toConversationKitConfig(r0)
            zendesk.conversationkit.android.ConversationKitSettings$Companion r1 = zendesk.conversationkit.android.ConversationKitSettings.Companion
            zendesk.conversationkit.android.ConversationKitSettings$Builder r7 = r1.builder(r7)
            zendesk.conversationkit.android.ConversationKitSettings r7 = r7.build()
            zendesk.conversationkit.android.ConversationKitFactory$Companion r1 = zendesk.conversationkit.android.ConversationKitFactory.Companion
            zendesk.conversationkit.android.ConversationKitFactory r8 = r1.from(r8)
            java.lang.Object r7 = r8.create(r7, r0, r9)
            return r7
        L_0x005f:
            zendesk.conversationkit.android.ConversationKitResult$Failure r7 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            zendesk.android.internal.ZendeskError$MissingConfiguration r8 = zendesk.android.internal.ZendeskError.MissingConfiguration.INSTANCE
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            zendesk.conversationkit.android.ConversationKitResult r7 = (zendesk.conversationkit.android.ConversationKitResult) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.internal.ConversationKitProvider.createConversationKit$zendesk_zendesk_android(zendesk.android.settings.internal.model.SettingsDto, android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Config toConversationKitConfig(SunCoConfigDto sunCoConfigDto) {
        return new Config(new App(sunCoConfigDto.getApp().getId(), sunCoConfigDto.getApp().getStatus(), sunCoConfigDto.getApp().getName(), sunCoConfigDto.getApp().getSettings().isMultiConvoEnabled()), sunCoConfigDto.getBaseUrl().getAndroid(), new Integration(sunCoConfigDto.getIntegration().getId(), sunCoConfigDto.getIntegration().getCanUserCreateMoreConversations(), sunCoConfigDto.getIntegration().getCanUserSeeConversationList()), new RestRetryPolicy(sunCoConfigDto.getRestRetryPolicy().getIntervals().getRegular(), sunCoConfigDto.getRestRetryPolicy().getIntervals().getAggressive(), (TimeUnit) null, sunCoConfigDto.getRestRetryPolicy().getBackoffMultiplier(), sunCoConfigDto.getRestRetryPolicy().getMaxRetries(), 4, (DefaultConstructorMarker) null));
    }
}

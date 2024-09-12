package zendesk.android.settings.internal;

import com.squareup.moshi.Moshi;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.internal.di.ZendeskComponentConfig;

@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001f\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lzendesk/android/settings/internal/SettingsRestClient;", "", "settingsApi", "Lzendesk/android/settings/internal/SettingsApi;", "moshi", "Lcom/squareup/moshi/Moshi;", "zendeskComponentConfig", "Lzendesk/android/internal/di/ZendeskComponentConfig;", "(Lzendesk/android/settings/internal/SettingsApi;Lcom/squareup/moshi/Moshi;Lzendesk/android/internal/di/ZendeskComponentConfig;)V", "getSettings", "Lzendesk/android/settings/internal/model/SettingsDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SettingsRestClient.kt */
public final class SettingsRestClient {
    private final Moshi moshi;
    private final SettingsApi settingsApi;
    private final ZendeskComponentConfig zendeskComponentConfig;

    @Inject
    public SettingsRestClient(SettingsApi settingsApi2, Moshi moshi2, ZendeskComponentConfig zendeskComponentConfig2) {
        Intrinsics.checkNotNullParameter(settingsApi2, "settingsApi");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(zendeskComponentConfig2, "zendeskComponentConfig");
        this.settingsApi = settingsApi2;
        this.moshi = moshi2;
        this.zendeskComponentConfig = zendeskComponentConfig2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getSettings(kotlin.coroutines.Continuation<? super zendesk.android.settings.internal.model.SettingsDto> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof zendesk.android.settings.internal.SettingsRestClient$getSettings$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            zendesk.android.settings.internal.SettingsRestClient$getSettings$1 r0 = (zendesk.android.settings.internal.SettingsRestClient$getSettings$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            zendesk.android.settings.internal.SettingsRestClient$getSettings$1 r0 = new zendesk.android.settings.internal.SettingsRestClient$getSettings$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0052
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            zendesk.android.internal.di.ZendeskComponentConfig r5 = r4.zendeskComponentConfig
            zendesk.android.ZendeskCredentials r5 = r5.getChannelKey()
            com.squareup.moshi.Moshi r2 = r4.moshi
            zendesk.android.internal.ChannelKeyFields r5 = zendesk.android.ZendeskCredentialsKt.toChannelKeyFields(r5, r2)
            if (r5 == 0) goto L_0x0059
            zendesk.android.settings.internal.SettingsApi r2 = r4.settingsApi
            java.lang.String r5 = r5.getSettingsUrl()
            r0.label = r3
            java.lang.Object r5 = r2.getSettings(r5, r0)
            if (r5 != r1) goto L_0x0052
            return r1
        L_0x0052:
            zendesk.android.settings.internal.model.SettingsResponseDto r5 = (zendesk.android.settings.internal.model.SettingsResponseDto) r5
            zendesk.android.settings.internal.model.SettingsDto r5 = r5.getSettings()
            return r5
        L_0x0059:
            zendesk.android.internal.ZendeskError$InvalidChannelKey r5 = zendesk.android.internal.ZendeskError.InvalidChannelKey.INSTANCE
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.settings.internal.SettingsRestClient.getSettings(kotlin.coroutines.Continuation):java.lang.Object");
    }
}

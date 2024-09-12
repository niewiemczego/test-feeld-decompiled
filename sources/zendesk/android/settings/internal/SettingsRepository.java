package zendesk.android.settings.internal;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.settings.internal.model.SettingsDto;

@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lzendesk/android/settings/internal/SettingsRepository;", "", "settingsRestClient", "Lzendesk/android/settings/internal/SettingsRestClient;", "(Lzendesk/android/settings/internal/SettingsRestClient;)V", "settings", "Lzendesk/android/settings/internal/model/SettingsDto;", "fetchSettings", "Lzendesk/android/ZendeskResult;", "", "fetchSettings$zendesk_zendesk_android", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SettingsRepository.kt */
public final class SettingsRepository {
    private SettingsDto settings;
    private final SettingsRestClient settingsRestClient;

    @Inject
    public SettingsRepository(SettingsRestClient settingsRestClient2) {
        Intrinsics.checkNotNullParameter(settingsRestClient2, "settingsRestClient");
        this.settingsRestClient = settingsRestClient2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchSettings$zendesk_zendesk_android(kotlin.coroutines.Continuation<? super zendesk.android.ZendeskResult<zendesk.android.settings.internal.model.SettingsDto, ? extends java.lang.Throwable>> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof zendesk.android.settings.internal.SettingsRepository$fetchSettings$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            zendesk.android.settings.internal.SettingsRepository$fetchSettings$1 r0 = (zendesk.android.settings.internal.SettingsRepository$fetchSettings$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            zendesk.android.settings.internal.SettingsRepository$fetchSettings$1 r0 = new zendesk.android.settings.internal.SettingsRepository$fetchSettings$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            java.lang.String r4 = "Zendesk"
            r5 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r5) goto L_0x0031
            java.lang.Object r0 = r0.L$0
            zendesk.android.settings.internal.SettingsRepository r0 = (zendesk.android.settings.internal.SettingsRepository) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ JsonDataException -> 0x008d, all -> 0x005f }
            goto L_0x0051
        L_0x0031:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r7)
            zendesk.android.settings.internal.model.SettingsDto r7 = r6.settings     // Catch:{ JsonDataException -> 0x008d, all -> 0x005f }
            if (r7 != 0) goto L_0x0054
            r7 = r6
            zendesk.android.settings.internal.SettingsRepository r7 = (zendesk.android.settings.internal.SettingsRepository) r7     // Catch:{ JsonDataException -> 0x008d, all -> 0x005f }
            zendesk.android.settings.internal.SettingsRestClient r7 = r6.settingsRestClient     // Catch:{ JsonDataException -> 0x008d, all -> 0x005f }
            r0.L$0 = r6     // Catch:{ JsonDataException -> 0x008d, all -> 0x005f }
            r0.label = r5     // Catch:{ JsonDataException -> 0x008d, all -> 0x005f }
            java.lang.Object r7 = r7.getSettings(r0)     // Catch:{ JsonDataException -> 0x008d, all -> 0x005f }
            if (r7 != r1) goto L_0x0050
            return r1
        L_0x0050:
            r0 = r6
        L_0x0051:
            zendesk.android.settings.internal.model.SettingsDto r7 = (zendesk.android.settings.internal.model.SettingsDto) r7     // Catch:{ JsonDataException -> 0x008d, all -> 0x005f }
            goto L_0x0055
        L_0x0054:
            r0 = r6
        L_0x0055:
            zendesk.android.ZendeskResult$Success r1 = new zendesk.android.ZendeskResult$Success     // Catch:{ JsonDataException -> 0x008d, all -> 0x005f }
            r1.<init>(r7)     // Catch:{ JsonDataException -> 0x008d, all -> 0x005f }
            r0.settings = r7     // Catch:{ JsonDataException -> 0x008d, all -> 0x005f }
            zendesk.android.ZendeskResult r1 = (zendesk.android.ZendeskResult) r1     // Catch:{ JsonDataException -> 0x008d, all -> 0x005f }
            goto L_0x00a4
        L_0x005f:
            r7 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r1 = "Zendesk failed to initialize."
            zendesk.logger.Logger.e(r4, r1, r7, r0)
            boolean r0 = r7 instanceof retrofit2.HttpException
            if (r0 == 0) goto L_0x007e
            r0 = r7
            retrofit2.HttpException r0 = (retrofit2.HttpException) r0
            int r0 = r0.code()
            r1 = 404(0x194, float:5.66E-43)
            if (r0 != r1) goto L_0x007e
            zendesk.android.ZendeskResult$Failure r7 = new zendesk.android.ZendeskResult$Failure
            zendesk.android.internal.ZendeskError$AccountNotFound r0 = zendesk.android.internal.ZendeskError.AccountNotFound.INSTANCE
            r7.<init>(r0)
            goto L_0x0089
        L_0x007e:
            zendesk.android.ZendeskResult$Failure r0 = new zendesk.android.ZendeskResult$Failure
            zendesk.android.internal.ZendeskError$FailedToInitialize r1 = new zendesk.android.internal.ZendeskError$FailedToInitialize
            r1.<init>(r7)
            r0.<init>(r1)
            r7 = r0
        L_0x0089:
            r1 = r7
            zendesk.android.ZendeskResult r1 = (zendesk.android.ZendeskResult) r1
            goto L_0x00a4
        L_0x008d:
            r7 = move-exception
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r1 = "GET request for Settings failed to decode malformed JSON response."
            zendesk.logger.Logger.e(r4, r1, r7, r0)
            zendesk.android.ZendeskResult$Failure r0 = new zendesk.android.ZendeskResult$Failure
            zendesk.android.internal.ZendeskError$FailedToInitialize r1 = new zendesk.android.internal.ZendeskError$FailedToInitialize
            r1.<init>(r7)
            r0.<init>(r1)
            r1 = r0
            zendesk.android.ZendeskResult r1 = (zendesk.android.ZendeskResult) r1
        L_0x00a4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.settings.internal.SettingsRepository.fetchSettings$zendesk_zendesk_android(kotlin.coroutines.Continuation):java.lang.Object");
    }
}

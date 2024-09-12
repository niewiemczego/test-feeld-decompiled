package zendesk.android.settings.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.settings.internal.SettingsRepository", f = "SettingsRepository.kt", i = {0}, l = {33}, m = "fetchSettings$zendesk_zendesk_android", n = {"this"}, s = {"L$0"})
/* compiled from: SettingsRepository.kt */
final class SettingsRepository$fetchSettings$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingsRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsRepository$fetchSettings$1(SettingsRepository settingsRepository, Continuation<? super SettingsRepository$fetchSettings$1> continuation) {
        super(continuation);
        this.this$0 = settingsRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchSettings$zendesk_zendesk_android(this);
    }
}

package zendesk.android.settings.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.settings.internal.SettingsRestClient", f = "SettingsRestClient.kt", i = {}, l = {35}, m = "getSettings", n = {}, s = {})
/* compiled from: SettingsRestClient.kt */
final class SettingsRestClient$getSettings$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingsRestClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsRestClient$getSettings$1(SettingsRestClient settingsRestClient, Continuation<? super SettingsRestClient$getSettings$1> continuation) {
        super(continuation);
        this.this$0 = settingsRestClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getSettings(this);
    }
}

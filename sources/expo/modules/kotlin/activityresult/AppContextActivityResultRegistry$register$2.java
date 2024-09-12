package expo.modules.kotlin.activityresult;

import androidx.activity.result.ActivityResultCallback;
import expo.modules.kotlin.activityresult.AppContextActivityResultRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J#\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0016¢\u0006\u0002\u0010\u000bR \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"expo/modules/kotlin/activityresult/AppContextActivityResultRegistry$register$2", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "contract", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "getContract", "()Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "launch", "", "input", "callback", "Landroidx/activity/result/ActivityResultCallback;", "(Ljava/io/Serializable;Landroidx/activity/result/ActivityResultCallback;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AppContextActivityResultRegistry.kt */
public final class AppContextActivityResultRegistry$register$2 extends AppContextActivityResultLauncher<I, O> {
    final /* synthetic */ AppContextActivityResultContract<I, O> $contract;
    final /* synthetic */ AppContextActivityResultFallbackCallback<I, O> $fallbackCallback;
    final /* synthetic */ String $key;
    private final AppContextActivityResultContract<I, O> contract;
    final /* synthetic */ AppContextActivityResultRegistry this$0;

    AppContextActivityResultRegistry$register$2(AppContextActivityResultContract<I, O> appContextActivityResultContract, AppContextActivityResultRegistry appContextActivityResultRegistry, String str, AppContextActivityResultFallbackCallback<I, O> appContextActivityResultFallbackCallback) {
        this.$contract = appContextActivityResultContract;
        this.this$0 = appContextActivityResultRegistry;
        this.$key = str;
        this.$fallbackCallback = appContextActivityResultFallbackCallback;
        this.contract = appContextActivityResultContract;
    }

    public void launch(I i, ActivityResultCallback<O> activityResultCallback) {
        Intrinsics.checkNotNullParameter(i, "input");
        Intrinsics.checkNotNullParameter(activityResultCallback, "callback");
        Integer num = (Integer) this.this$0.keyToRequestCode.get(this.$key);
        if (num != null) {
            int intValue = num.intValue();
            this.this$0.keyToCallbacksAndContract.put(this.$key, new AppContextActivityResultRegistry.CallbacksAndContract(this.$fallbackCallback, activityResultCallback, this.$contract));
            this.this$0.keyToInputParam.put(this.$key, i);
            this.this$0.launchedKeys.add(this.$key);
            try {
                this.this$0.onLaunch(intValue, this.$contract, i);
            } catch (Exception e) {
                this.this$0.launchedKeys.remove(this.$key);
                throw e;
            }
        } else {
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.$contract + " and input " + i + ". You must ensure the ActivityResultLauncher is registered before calling launch()");
        }
    }

    public AppContextActivityResultContract<I, O> getContract() {
        return this.contract;
    }
}

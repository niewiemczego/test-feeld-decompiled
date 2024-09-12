package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import com.facebook.CallbackManager;
import com.facebook.FacebookException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\r"}, d2 = {"com/facebook/internal/FacebookDialogBase$createActivityResultContractForShowingDialog$1", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/facebook/CallbackManager$ActivityResultParameters;", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "content", "(Landroid/content/Context;Ljava/lang/Object;)Landroid/content/Intent;", "parseResult", "resultCode", "", "intent", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FacebookDialogBase.kt */
public final class FacebookDialogBase$createActivityResultContractForShowingDialog$1 extends ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters> {
    final /* synthetic */ CallbackManager $callbackManager;
    final /* synthetic */ Object $mode;
    final /* synthetic */ FacebookDialogBase<CONTENT, RESULT> this$0;

    FacebookDialogBase$createActivityResultContractForShowingDialog$1(FacebookDialogBase<CONTENT, RESULT> facebookDialogBase, Object obj, CallbackManager callbackManager) {
        this.this$0 = facebookDialogBase;
        this.$mode = obj;
        this.$callbackManager = callbackManager;
    }

    public Intent createIntent(Context context, CONTENT content) {
        Intent intent;
        Intrinsics.checkNotNullParameter(context, "context");
        AppCall access$createAppCallForMode = this.this$0.createAppCallForMode(content, this.$mode);
        if (access$createAppCallForMode == null) {
            intent = null;
        } else {
            intent = access$createAppCallForMode.getRequestIntent();
        }
        if (intent != null) {
            access$createAppCallForMode.setPending();
            return intent;
        }
        throw new FacebookException("Content " + content + " is not supported");
    }

    public CallbackManager.ActivityResultParameters parseResult(int i, Intent intent) {
        CallbackManager callbackManager = this.$callbackManager;
        if (callbackManager != null) {
            callbackManager.onActivityResult(this.this$0.getRequestCode(), i, intent);
        }
        return new CallbackManager.ActivityResultParameters(this.this$0.getRequestCode(), i, intent);
    }
}

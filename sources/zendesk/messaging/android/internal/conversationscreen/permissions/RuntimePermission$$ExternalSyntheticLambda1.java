package zendesk.messaging.android.internal.conversationscreen.permissions;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RuntimePermission$$ExternalSyntheticLambda1 implements ActivityResultCallback {
    public final /* synthetic */ RuntimePermission f$0;

    public /* synthetic */ RuntimePermission$$ExternalSyntheticLambda1(RuntimePermission runtimePermission) {
        this.f$0 = runtimePermission;
    }

    public final void onActivityResult(Object obj) {
        RuntimePermission.m698startActivityForFileResult$lambda2(this.f$0, (ActivityResult) obj);
    }
}

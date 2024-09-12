package zendesk.messaging.android.internal.conversationscreen.permissions;

import androidx.activity.result.ActivityResultCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RuntimePermission$$ExternalSyntheticLambda2 implements ActivityResultCallback {
    public final /* synthetic */ RuntimePermission f$0;

    public /* synthetic */ RuntimePermission$$ExternalSyntheticLambda2(RuntimePermission runtimePermission) {
        this.f$0 = runtimePermission;
    }

    public final void onActivityResult(Object obj) {
        RuntimePermission.m697startActivityForCameraResult$lambda4(this.f$0, (Boolean) obj);
    }
}

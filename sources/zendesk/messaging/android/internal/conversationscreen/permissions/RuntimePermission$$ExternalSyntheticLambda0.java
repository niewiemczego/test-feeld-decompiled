package zendesk.messaging.android.internal.conversationscreen.permissions;

import androidx.activity.result.ActivityResultCallback;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RuntimePermission$$ExternalSyntheticLambda0 implements ActivityResultCallback {
    public final /* synthetic */ RuntimePermission f$0;

    public /* synthetic */ RuntimePermission$$ExternalSyntheticLambda0(RuntimePermission runtimePermission) {
        this.f$0 = runtimePermission;
    }

    public final void onActivityResult(Object obj) {
        RuntimePermission.m696requestForMultiplePermissions$lambda1(this.f$0, (Map) obj);
    }
}

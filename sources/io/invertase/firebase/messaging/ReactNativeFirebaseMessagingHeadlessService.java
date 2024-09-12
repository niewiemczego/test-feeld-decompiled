package io.invertase.firebase.messaging;

import android.content.Intent;
import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.google.firebase.messaging.RemoteMessage;
import io.invertase.firebase.common.ReactNativeFirebaseJSON;
import javax.annotation.Nullable;

public class ReactNativeFirebaseMessagingHeadlessService extends HeadlessJsTaskService {
    private static final String TASK_KEY = "ReactNativeFirebaseMessagingHeadlessTask";
    private static final long TIMEOUT_DEFAULT = 60000;
    private static final String TIMEOUT_JSON_KEY = "messaging_android_headless_task_timeout";

    /* access modifiers changed from: protected */
    @Nullable
    public HeadlessJsTaskConfig getTaskConfig(Intent intent) {
        if (intent.getExtras() == null) {
            return null;
        }
        return new HeadlessJsTaskConfig(TASK_KEY, ReactNativeFirebaseMessagingSerializer.remoteMessageToWritableMap((RemoteMessage) intent.getParcelableExtra("message")), ReactNativeFirebaseJSON.getSharedInstance().getLongValue(TIMEOUT_JSON_KEY, 60000), true);
    }
}

package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.zze;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.Constants;
import java.lang.ref.SoftReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
public abstract class CloudMessagingReceiver extends BroadcastReceiver {
    private static SoftReference zza;

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
    public static final class IntentActionKeys {
        public static final String NOTIFICATION_DISMISS = "com.google.firebase.messaging.NOTIFICATION_DISMISS";
        public static final String NOTIFICATION_OPEN = "com.google.firebase.messaging.NOTIFICATION_OPEN";

        private IntentActionKeys() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
    public static final class IntentKeys {
        public static final String PENDING_INTENT = "pending_intent";
        public static final String WRAPPED_INTENT = "wrapped_intent";

        private IntentKeys() {
        }
    }

    private final int zzb(Context context, Intent intent) {
        Task task;
        if (intent.getExtras() == null) {
            return 500;
        }
        CloudMessage cloudMessage = new CloudMessage(intent);
        if (TextUtils.isEmpty(cloudMessage.getMessageId())) {
            task = Tasks.forResult(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(Constants.MessagePayloadKeys.MSGID, cloudMessage.getMessageId());
            Integer zza2 = cloudMessage.zza();
            if (zza2 != null) {
                bundle.putInt(Constants.MessagePayloadKeys.PRODUCT_ID, zza2.intValue());
            }
            bundle.putBoolean("supports_message_handled", true);
            task = zzu.zzb(context).zzc(2, bundle);
        }
        int onMessageReceive = onMessageReceive(context, cloudMessage);
        try {
            Tasks.await(task, TimeUnit.SECONDS.toMillis(1), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            Log.w("CloudMessagingReceiver", "Message ack failed: ".concat(e.toString()));
        }
        return onMessageReceive;
    }

    private final int zzc(Context context, Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(IntentKeys.PENDING_INTENT);
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove(IntentKeys.PENDING_INTENT);
        } else {
            extras = new Bundle();
        }
        String action = intent.getAction();
        if (action == IntentActionKeys.NOTIFICATION_DISMISS || (action != null && action.equals(IntentActionKeys.NOTIFICATION_DISMISS))) {
            onNotificationDismissed(context, extras);
            return -1;
        }
        Log.e("CloudMessagingReceiver", "Unknown notification action");
        return 500;
    }

    /* access modifiers changed from: protected */
    public Executor getBroadcastExecutor() {
        ExecutorService executorService;
        synchronized (CloudMessagingReceiver.class) {
            SoftReference softReference = zza;
            executorService = softReference != null ? (ExecutorService) softReference.get() : null;
            if (executorService == null) {
                zze.zza();
                executorService = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new NamedThreadFactory("firebase-iid-executor")));
                zza = new SoftReference(executorService);
            }
        }
        return executorService;
    }

    /* access modifiers changed from: protected */
    public abstract int onMessageReceive(Context context, CloudMessage cloudMessage);

    /* access modifiers changed from: protected */
    public void onNotificationDismissed(Context context, Bundle bundle) {
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            getBroadcastExecutor().execute(new zzf(this, intent, context, isOrderedBroadcast(), goAsync()));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Intent intent, Context context, boolean z, BroadcastReceiver.PendingResult pendingResult) {
        int i;
        try {
            Parcelable parcelableExtra = intent.getParcelableExtra(IntentKeys.WRAPPED_INTENT);
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent2 != null) {
                i = zzc(context, intent2);
            } else {
                i = zzb(context, intent);
            }
            if (z) {
                pendingResult.setResultCode(i);
            }
        } finally {
            pendingResult.finish();
        }
    }
}

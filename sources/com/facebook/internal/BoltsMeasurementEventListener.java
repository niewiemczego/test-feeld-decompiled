package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u001c\u0010\t\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/BoltsMeasurementEventListener;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "applicationContext", "close", "", "finalize", "onReceive", "intent", "Landroid/content/Intent;", "open", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BoltsMeasurementEventListener.kt */
public final class BoltsMeasurementEventListener extends BroadcastReceiver {
    private static final String BOLTS_MEASUREMENT_EVENT_PREFIX = "bf_";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
    private static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
    private static final String MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";
    private static BoltsMeasurementEventListener singleton;
    private final Context applicationContext;

    public /* synthetic */ BoltsMeasurementEventListener(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @JvmStatic
    public static final BoltsMeasurementEventListener getInstance(Context context) {
        Class<BoltsMeasurementEventListener> cls = BoltsMeasurementEventListener.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.getInstance(context);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ String access$getMEASUREMENT_EVENT_NOTIFICATION_NAME$cp() {
        Class<BoltsMeasurementEventListener> cls = BoltsMeasurementEventListener.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return MEASUREMENT_EVENT_NOTIFICATION_NAME;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ BoltsMeasurementEventListener access$getSingleton$cp() {
        Class<BoltsMeasurementEventListener> cls = BoltsMeasurementEventListener.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return singleton;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void access$open(BoltsMeasurementEventListener boltsMeasurementEventListener) {
        Class<BoltsMeasurementEventListener> cls = BoltsMeasurementEventListener.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                boltsMeasurementEventListener.open();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final /* synthetic */ void access$setSingleton$cp(BoltsMeasurementEventListener boltsMeasurementEventListener) {
        Class<BoltsMeasurementEventListener> cls = BoltsMeasurementEventListener.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                singleton = boltsMeasurementEventListener;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private BoltsMeasurementEventListener(Context context) {
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
        this.applicationContext = applicationContext2;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u00020\u00048\u0000XD¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/BoltsMeasurementEventListener$Companion;", "", "()V", "BOLTS_MEASUREMENT_EVENT_PREFIX", "", "MEASUREMENT_EVENT_ARGS_KEY", "MEASUREMENT_EVENT_NAME_KEY", "MEASUREMENT_EVENT_NOTIFICATION_NAME", "getMEASUREMENT_EVENT_NOTIFICATION_NAME$facebook_core_release$annotations", "getMEASUREMENT_EVENT_NOTIFICATION_NAME$facebook_core_release", "()Ljava/lang/String;", "singleton", "Lcom/facebook/internal/BoltsMeasurementEventListener;", "getInstance", "context", "Landroid/content/Context;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: BoltsMeasurementEventListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getMEASUREMENT_EVENT_NOTIFICATION_NAME$facebook_core_release$annotations() {
        }

        private Companion() {
        }

        public final String getMEASUREMENT_EVENT_NOTIFICATION_NAME$facebook_core_release() {
            return BoltsMeasurementEventListener.access$getMEASUREMENT_EVENT_NOTIFICATION_NAME$cp();
        }

        @JvmStatic
        public final BoltsMeasurementEventListener getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (BoltsMeasurementEventListener.access$getSingleton$cp() != null) {
                return BoltsMeasurementEventListener.access$getSingleton$cp();
            }
            BoltsMeasurementEventListener boltsMeasurementEventListener = new BoltsMeasurementEventListener(context, (DefaultConstructorMarker) null);
            BoltsMeasurementEventListener.access$open(boltsMeasurementEventListener);
            BoltsMeasurementEventListener.access$setSingleton$cp(boltsMeasurementEventListener);
            return BoltsMeasurementEventListener.access$getSingleton$cp();
        }
    }

    private final void open() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this.applicationContext);
                Intrinsics.checkNotNullExpressionValue(instance, "getInstance(applicationContext)");
                instance.registerReceiver(this, new IntentFilter(MEASUREMENT_EVENT_NOTIFICATION_NAME));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void close() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this.applicationContext);
                Intrinsics.checkNotNullExpressionValue(instance, "getInstance(applicationContext)");
                instance.unregisterReceiver(this);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void finalize() throws Throwable {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                close();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        String str;
        Bundle bundle;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
                Set<String> set = null;
                if (intent == null) {
                    str = null;
                } else {
                    str = intent.getStringExtra("event_name");
                }
                String stringPlus = Intrinsics.stringPlus(BOLTS_MEASUREMENT_EVENT_PREFIX, str);
                if (intent == null) {
                    bundle = null;
                } else {
                    bundle = intent.getBundleExtra(MEASUREMENT_EVENT_ARGS_KEY);
                }
                Bundle bundle2 = new Bundle();
                if (bundle != null) {
                    set = bundle.keySet();
                }
                if (set != null) {
                    for (String str2 : set) {
                        Intrinsics.checkNotNullExpressionValue(str2, "key");
                        Regex regex = new Regex("[^0-9a-zA-Z _-]");
                        bundle2.putString(new Regex("[ -]*$").replace((CharSequence) new Regex("^[ -]*").replace((CharSequence) regex.replace((CharSequence) str2, "-"), ""), ""), (String) bundle.get(str2));
                    }
                }
                internalAppEventsLogger.logEvent(stringPlus, bundle2);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}

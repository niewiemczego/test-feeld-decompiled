package com.braze;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.braze.Braze;
import com.braze.push.NotificationTrampolineActivity;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B5\b\u0017\u0012\u0014\u0010\u0002\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006BK\b\u0007\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019J\u001a\u0010\u001a\u001a\u00020\f2\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0003J\u001a\u0010\u001c\u001a\u00020\f2\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0003J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\bH\u0007R\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/braze/BrazeActivityLifecycleCallbackListener;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "inAppMessagingRegistrationBlocklist", "", "Ljava/lang/Class;", "sessionHandlingBlocklist", "(Ljava/util/Set;Ljava/util/Set;)V", "sessionHandlingEnabled", "", "registerInAppMessageManager", "(ZZLjava/util/Set;Ljava/util/Set;)V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "registerOnApplication", "context", "Landroid/content/Context;", "setInAppMessagingRegistrationBlocklist", "blocklist", "setSessionHandlingBlocklist", "shouldHandleLifecycleMethodsInActivity", "forSessionHandling", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeActivityLifecycleCallbackListener.kt */
public class BrazeActivityLifecycleCallbackListener implements Application.ActivityLifecycleCallbacks {
    /* access modifiers changed from: private */
    public Set<? extends Class<?>> inAppMessagingRegistrationBlocklist;
    private final boolean registerInAppMessageManager;
    /* access modifiers changed from: private */
    public Set<? extends Class<?>> sessionHandlingBlocklist;
    private final boolean sessionHandlingEnabled;

    public BrazeActivityLifecycleCallbackListener() {
        this(false, false, (Set) null, (Set) null, 15, (DefaultConstructorMarker) null);
    }

    public BrazeActivityLifecycleCallbackListener(Set<? extends Class<?>> set) {
        this((Set) set, (Set) null, 2, (DefaultConstructorMarker) null);
    }

    public BrazeActivityLifecycleCallbackListener(boolean z) {
        this(z, false, (Set) null, (Set) null, 14, (DefaultConstructorMarker) null);
    }

    public BrazeActivityLifecycleCallbackListener(boolean z, boolean z2) {
        this(z, z2, (Set) null, (Set) null, 12, (DefaultConstructorMarker) null);
    }

    public BrazeActivityLifecycleCallbackListener(boolean z, boolean z2, Set<? extends Class<?>> set) {
        this(z, z2, set, (Set) null, 8, (DefaultConstructorMarker) null);
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    public BrazeActivityLifecycleCallbackListener(boolean z, boolean z2, Set<? extends Class<?>> set, Set<? extends Class<?>> set2) {
        this.sessionHandlingEnabled = z;
        this.registerInAppMessageManager = z2;
        this.inAppMessagingRegistrationBlocklist = set == null ? SetsKt.emptySet() : set;
        this.sessionHandlingBlocklist = set2 == null ? SetsKt.emptySet() : set2;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new Function0<String>(this) {
            final /* synthetic */ BrazeActivityLifecycleCallbackListener this$0;

            {
                this.this$0 = r1;
            }

            public final String invoke() {
                return "BrazeActivityLifecycleCallbackListener using in-app messaging blocklist: " + this.this$0.inAppMessagingRegistrationBlocklist;
            }
        }, 2, (Object) null);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new Function0<String>(this) {
            final /* synthetic */ BrazeActivityLifecycleCallbackListener this$0;

            {
                this.this$0 = r1;
            }

            public final String invoke() {
                return "BrazeActivityLifecycleCallbackListener using session handling blocklist: " + this.this$0.sessionHandlingBlocklist;
            }
        }, 2, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BrazeActivityLifecycleCallbackListener(boolean z, boolean z2, Set set, Set set2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (Set<? extends Class<?>>) (i & 4) != 0 ? SetsKt.emptySet() : set, (Set<? extends Class<?>>) (i & 8) != 0 ? SetsKt.emptySet() : set2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BrazeActivityLifecycleCallbackListener(Set set, Set set2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((Set<? extends Class<?>>) set, (Set<? extends Class<?>>) (i & 2) != 0 ? SetsKt.emptySet() : set2);
    }

    public BrazeActivityLifecycleCallbackListener(Set<? extends Class<?>> set, Set<? extends Class<?>> set2) {
        this(true, true, set, set2);
    }

    public final void setInAppMessagingRegistrationBlocklist(Set<? extends Class<?>> set) {
        Intrinsics.checkNotNullParameter(set, "blocklist");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeActivityLifecycleCallbackListener$setInAppMessagingRegistrationBlocklist$1(set), 2, (Object) null);
        this.inAppMessagingRegistrationBlocklist = set;
    }

    public final void setSessionHandlingBlocklist(Set<? extends Class<?>> set) {
        Intrinsics.checkNotNullParameter(set, "blocklist");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeActivityLifecycleCallbackListener$setSessionHandlingBlocklist$1(set), 2, (Object) null);
        this.sessionHandlingBlocklist = set;
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.sessionHandlingEnabled && shouldHandleLifecycleMethodsInActivity(activity, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeActivityLifecycleCallbackListener$onActivityStarted$1(activity), 2, (Object) null);
            Braze.Companion companion = Braze.Companion;
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
            companion.getInstance(applicationContext).openSession(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.sessionHandlingEnabled && shouldHandleLifecycleMethodsInActivity(activity, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeActivityLifecycleCallbackListener$onActivityStopped$1(activity), 2, (Object) null);
            Braze.Companion companion = Braze.Companion;
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
            companion.getInstance(applicationContext).closeSession(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.registerInAppMessageManager && shouldHandleLifecycleMethodsInActivity(activity, false)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeActivityLifecycleCallbackListener$onActivityResumed$1(activity), 2, (Object) null);
            BrazeInAppMessageManager.Companion.getInstance().registerInAppMessageManager(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.registerInAppMessageManager && shouldHandleLifecycleMethodsInActivity(activity, false)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeActivityLifecycleCallbackListener$onActivityPaused$1(activity), 2, (Object) null);
            BrazeInAppMessageManager.Companion.getInstance().unregisterInAppMessageManager(activity);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.registerInAppMessageManager && shouldHandleLifecycleMethodsInActivity(activity, false)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeActivityLifecycleCallbackListener$onActivityCreated$1(activity), 2, (Object) null);
            BrazeInAppMessageManager instance = BrazeInAppMessageManager.Companion.getInstance();
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
            instance.ensureSubscribedToInAppMessageEvents(applicationContext);
        }
    }

    public final boolean shouldHandleLifecycleMethodsInActivity(Activity activity, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Class<?> cls = activity.getClass();
        if (Intrinsics.areEqual((Object) cls, (Object) NotificationTrampolineActivity.class)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) BrazeActivityLifecycleCallbackListener$shouldHandleLifecycleMethodsInActivity$1.INSTANCE, 2, (Object) null);
            return false;
        }
        if (z) {
            if (this.sessionHandlingBlocklist.contains(cls)) {
                return false;
            }
        } else if (this.inAppMessagingRegistrationBlocklist.contains(cls)) {
            return false;
        }
        return true;
    }

    public final void registerOnApplication(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) BrazeActivityLifecycleCallbackListener$registerOnApplication$1.INSTANCE);
        }
    }
}

package expo.modules.kotlin.activityaware;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lexpo/modules/kotlin/activityaware/AppCompatActivityAwareHelper;", "Lexpo/modules/kotlin/activityaware/AppCompatActivityAware;", "()V", "activityReference", "Ljava/lang/ref/WeakReference;", "Landroidx/appcompat/app/AppCompatActivity;", "getActivityReference", "()Ljava/lang/ref/WeakReference;", "setActivityReference", "(Ljava/lang/ref/WeakReference;)V", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lexpo/modules/kotlin/activityaware/OnActivityAvailableListener;", "getListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "addOnActivityAvailableListener", "", "listener", "dispatchOnActivityAvailable", "activity", "removeOnActivityAvailableListener", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AppCompatActivityAwareHelper.kt */
public final class AppCompatActivityAwareHelper implements AppCompatActivityAware {
    private WeakReference<AppCompatActivity> activityReference = new WeakReference<>((Object) null);
    private final CopyOnWriteArrayList<OnActivityAvailableListener> listeners = new CopyOnWriteArrayList<>();

    public final CopyOnWriteArrayList<OnActivityAvailableListener> getListeners() {
        return this.listeners;
    }

    public final WeakReference<AppCompatActivity> getActivityReference() {
        return this.activityReference;
    }

    public final void setActivityReference(WeakReference<AppCompatActivity> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.activityReference = weakReference;
    }

    public final void dispatchOnActivityAvailable(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        this.activityReference = new WeakReference<>(appCompatActivity);
        appCompatActivity.runOnUiThread(new AppCompatActivityAwareHelper$$ExternalSyntheticLambda1(this, appCompatActivity));
    }

    /* access modifiers changed from: private */
    /* renamed from: dispatchOnActivityAvailable$lambda-0  reason: not valid java name */
    public static final void m775dispatchOnActivityAvailable$lambda0(AppCompatActivityAwareHelper appCompatActivityAwareHelper, AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivityAwareHelper, "this$0");
        Intrinsics.checkNotNullParameter(appCompatActivity, "$activity");
        Iterator<OnActivityAvailableListener> it = appCompatActivityAwareHelper.listeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityAvailable(appCompatActivity);
        }
    }

    public void addOnActivityAvailableListener(OnActivityAvailableListener onActivityAvailableListener) {
        Intrinsics.checkNotNullParameter(onActivityAvailableListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.add(onActivityAvailableListener);
        AppCompatActivity appCompatActivity = (AppCompatActivity) this.activityReference.get();
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new AppCompatActivityAwareHelper$$ExternalSyntheticLambda0(onActivityAvailableListener, appCompatActivity));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addOnActivityAvailableListener$lambda-2$lambda-1  reason: not valid java name */
    public static final void m774addOnActivityAvailableListener$lambda2$lambda1(OnActivityAvailableListener onActivityAvailableListener, AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(onActivityAvailableListener, "$listener");
        Intrinsics.checkNotNullParameter(appCompatActivity, "$activity");
        onActivityAvailableListener.onActivityAvailable(appCompatActivity);
    }

    public void removeOnActivityAvailableListener(OnActivityAvailableListener onActivityAvailableListener) {
        Intrinsics.checkNotNullParameter(onActivityAvailableListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.remove(onActivityAvailableListener);
    }
}

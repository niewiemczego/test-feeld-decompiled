package io.sentry.android.core.internal.util;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.android.core.internal.gestures.NoOpWindowCallback;
import io.sentry.android.core.performance.WindowContentChangedCallback;
import java.util.concurrent.atomic.AtomicReference;

public class FirstDrawDoneListener implements ViewTreeObserver.OnDrawListener {
    private final Runnable callback;
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private final AtomicReference<View> viewReference;

    public static void registerForNextDraw(Activity activity, Runnable runnable, BuildInfoProvider buildInfoProvider) {
        Window.Callback callback2;
        Window window = activity.getWindow();
        if (window != null) {
            View peekDecorView = window.peekDecorView();
            if (peekDecorView != null) {
                registerForNextDraw(peekDecorView, runnable, buildInfoProvider);
                return;
            }
            Window.Callback callback3 = window.getCallback();
            if (callback3 != null) {
                callback2 = callback3;
            } else {
                callback2 = new NoOpWindowCallback();
            }
            window.setCallback(new WindowContentChangedCallback(callback2, new FirstDrawDoneListener$$ExternalSyntheticLambda1(window, callback3, runnable, buildInfoProvider)));
        }
    }

    static /* synthetic */ void lambda$registerForNextDraw$0(Window window, Window.Callback callback2, Runnable runnable, BuildInfoProvider buildInfoProvider) {
        View peekDecorView = window.peekDecorView();
        if (peekDecorView != null) {
            window.setCallback(callback2);
            registerForNextDraw(peekDecorView, runnable, buildInfoProvider);
        }
    }

    public static void registerForNextDraw(View view, Runnable runnable, BuildInfoProvider buildInfoProvider) {
        FirstDrawDoneListener firstDrawDoneListener = new FirstDrawDoneListener(view, runnable);
        if (buildInfoProvider.getSdkInfoVersion() >= 26 || isAliveAndAttached(view)) {
            view.getViewTreeObserver().addOnDrawListener(firstDrawDoneListener);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View view) {
                    view.getViewTreeObserver().addOnDrawListener(FirstDrawDoneListener.this);
                    view.removeOnAttachStateChangeListener(this);
                }

                public void onViewDetachedFromWindow(View view) {
                    view.removeOnAttachStateChangeListener(this);
                }
            });
        }
    }

    private FirstDrawDoneListener(View view, Runnable runnable) {
        this.viewReference = new AtomicReference<>(view);
        this.callback = runnable;
    }

    public void onDraw() {
        View andSet = this.viewReference.getAndSet((Object) null);
        if (andSet != null) {
            andSet.getViewTreeObserver().addOnGlobalLayoutListener(new FirstDrawDoneListener$$ExternalSyntheticLambda0(this, andSet));
            this.mainThreadHandler.postAtFrontOfQueue(this.callback);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onDraw$1$io-sentry-android-core-internal-util-FirstDrawDoneListener  reason: not valid java name */
    public /* synthetic */ void m911lambda$onDraw$1$iosentryandroidcoreinternalutilFirstDrawDoneListener(View view) {
        view.getViewTreeObserver().removeOnDrawListener(this);
    }

    private static boolean isAliveAndAttached(View view) {
        return view.getViewTreeObserver().isAlive() && view.isAttachedToWindow();
    }
}

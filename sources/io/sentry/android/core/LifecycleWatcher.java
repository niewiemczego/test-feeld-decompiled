package io.sentry.android.core;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.exoplayer2.offline.DownloadService;
import io.sentry.Breadcrumb;
import io.sentry.IHub;
import io.sentry.IScope;
import io.sentry.SentryLevel;
import io.sentry.Session;
import io.sentry.android.core.internal.util.BreadcrumbFactory;
import io.sentry.transport.CurrentDateProvider;
import io.sentry.transport.ICurrentDateProvider;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;

final class LifecycleWatcher implements DefaultLifecycleObserver {
    private final ICurrentDateProvider currentDateProvider;
    private final boolean enableAppLifecycleBreadcrumbs;
    private final boolean enableSessionTracking;
    /* access modifiers changed from: private */
    public final IHub hub;
    private final AtomicLong lastUpdatedSession;
    private final long sessionIntervalMillis;
    private final Timer timer;
    private final Object timerLock;
    private TimerTask timerTask;

    LifecycleWatcher(IHub iHub, long j, boolean z, boolean z2) {
        this(iHub, j, z, z2, CurrentDateProvider.getInstance());
    }

    LifecycleWatcher(IHub iHub, long j, boolean z, boolean z2, ICurrentDateProvider iCurrentDateProvider) {
        this.lastUpdatedSession = new AtomicLong(0);
        this.timerLock = new Object();
        this.sessionIntervalMillis = j;
        this.enableSessionTracking = z;
        this.enableAppLifecycleBreadcrumbs = z2;
        this.hub = iHub;
        this.currentDateProvider = iCurrentDateProvider;
        if (z) {
            this.timer = new Timer(true);
        } else {
            this.timer = null;
        }
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        startSession();
        addAppBreadcrumb(DownloadService.KEY_FOREGROUND);
        AppState.getInstance().setInBackground(false);
    }

    private void startSession() {
        if (this.enableSessionTracking) {
            cancelTask();
            long currentTimeMillis = this.currentDateProvider.getCurrentTimeMillis();
            this.hub.configureScope(new LifecycleWatcher$$ExternalSyntheticLambda0(this));
            long j = this.lastUpdatedSession.get();
            if (j == 0 || j + this.sessionIntervalMillis <= currentTimeMillis) {
                addSessionBreadcrumb("start");
                this.hub.startSession();
            }
            this.lastUpdatedSession.set(currentTimeMillis);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$startSession$0$io-sentry-android-core-LifecycleWatcher  reason: not valid java name */
    public /* synthetic */ void m900lambda$startSession$0$iosentryandroidcoreLifecycleWatcher(IScope iScope) {
        Session session;
        if (this.lastUpdatedSession.get() == 0 && (session = iScope.getSession()) != null && session.getStarted() != null) {
            this.lastUpdatedSession.set(session.getStarted().getTime());
        }
    }

    public void onStop(LifecycleOwner lifecycleOwner) {
        if (this.enableSessionTracking) {
            this.lastUpdatedSession.set(this.currentDateProvider.getCurrentTimeMillis());
            scheduleEndSession();
        }
        AppState.getInstance().setInBackground(true);
        addAppBreadcrumb(AppStateModule.APP_STATE_BACKGROUND);
    }

    private void scheduleEndSession() {
        synchronized (this.timerLock) {
            cancelTask();
            if (this.timer != null) {
                AnonymousClass1 r1 = new TimerTask() {
                    public void run() {
                        LifecycleWatcher.this.addSessionBreadcrumb("end");
                        LifecycleWatcher.this.hub.endSession();
                    }
                };
                this.timerTask = r1;
                this.timer.schedule(r1, this.sessionIntervalMillis);
            }
        }
    }

    private void cancelTask() {
        synchronized (this.timerLock) {
            TimerTask timerTask2 = this.timerTask;
            if (timerTask2 != null) {
                timerTask2.cancel();
                this.timerTask = null;
            }
        }
    }

    private void addAppBreadcrumb(String str) {
        if (this.enableAppLifecycleBreadcrumbs) {
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.setType(NotificationCompat.CATEGORY_NAVIGATION);
            breadcrumb.setData("state", str);
            breadcrumb.setCategory("app.lifecycle");
            breadcrumb.setLevel(SentryLevel.INFO);
            this.hub.addBreadcrumb(breadcrumb);
        }
    }

    /* access modifiers changed from: private */
    public void addSessionBreadcrumb(String str) {
        this.hub.addBreadcrumb(BreadcrumbFactory.forSession(str));
    }

    /* access modifiers changed from: package-private */
    public TimerTask getTimerTask() {
        return this.timerTask;
    }

    /* access modifiers changed from: package-private */
    public Timer getTimer() {
        return this.timer;
    }
}

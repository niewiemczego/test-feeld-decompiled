package io.sentry.android.core;

public final class AppState {
    private static AppState instance = new AppState();
    private Boolean inBackground = null;

    private AppState() {
    }

    public static AppState getInstance() {
        return instance;
    }

    /* access modifiers changed from: package-private */
    public void resetInstance() {
        instance = new AppState();
    }

    public Boolean isInBackground() {
        return this.inBackground;
    }

    /* access modifiers changed from: package-private */
    public synchronized void setInBackground(boolean z) {
        this.inBackground = Boolean.valueOf(z);
    }
}

package com.appsflyer.internal;

import java.util.TimerTask;

public final class AFd1rSDK extends TimerTask {
    private final Thread values;

    public AFd1rSDK(Thread thread) {
        this.values = thread;
    }

    public final void run() {
        this.values.interrupt();
    }
}

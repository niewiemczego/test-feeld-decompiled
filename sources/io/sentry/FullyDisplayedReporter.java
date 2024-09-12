package io.sentry;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class FullyDisplayedReporter {
    private static final FullyDisplayedReporter instance = new FullyDisplayedReporter();
    private final List<FullyDisplayedReporterListener> listeners = new CopyOnWriteArrayList();

    public interface FullyDisplayedReporterListener {
        void onFullyDrawn();
    }

    private FullyDisplayedReporter() {
    }

    public static FullyDisplayedReporter getInstance() {
        return instance;
    }

    public void registerFullyDrawnListener(FullyDisplayedReporterListener fullyDisplayedReporterListener) {
        this.listeners.add(fullyDisplayedReporterListener);
    }

    public void reportFullyDrawn() {
        this.listeners.clear();
        for (FullyDisplayedReporterListener onFullyDrawn : this.listeners) {
            onFullyDrawn.onFullyDrawn();
        }
    }
}

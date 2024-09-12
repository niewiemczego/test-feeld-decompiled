package kotlin.reflect.jvm.internal.impl.load.java;

import app.notifee.core.event.LogEvent;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ReportLevel.kt */
public enum ReportLevel {
    IGNORE("ignore"),
    WARN(LogEvent.LEVEL_WARN),
    STRICT("strict");
    
    public static final Companion Companion = null;
    private final String description;

    private ReportLevel(String str) {
        this.description = str;
    }

    public final String getDescription() {
        return this.description;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    /* compiled from: ReportLevel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean isWarning() {
        return this == WARN;
    }

    public final boolean isIgnore() {
        return this == IGNORE;
    }
}

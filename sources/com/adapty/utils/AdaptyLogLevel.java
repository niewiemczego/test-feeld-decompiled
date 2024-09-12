package com.adapty.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/adapty/utils/AdaptyLogLevel;", "", "name", "", "value", "", "(Ljava/lang/String;I)V", "toString", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyLogLevel.kt */
public final class AdaptyLogLevel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final AdaptyLogLevel ERROR = new AdaptyLogLevel("ERROR", 1);
    public static final AdaptyLogLevel INFO = new AdaptyLogLevel("INFO", 7);
    public static final AdaptyLogLevel NONE = new AdaptyLogLevel("NONE", 0);
    public static final AdaptyLogLevel VERBOSE = new AdaptyLogLevel("VERBOSE", 15);
    public static final AdaptyLogLevel WARN = new AdaptyLogLevel("WARN", 3);
    private final String name;
    public final /* synthetic */ int value;

    private AdaptyLogLevel(String str, int i) {
        this.name = str;
        this.value = i;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/adapty/utils/AdaptyLogLevel$Companion;", "", "()V", "ERROR", "Lcom/adapty/utils/AdaptyLogLevel;", "INFO", "NONE", "VERBOSE", "WARN", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyLogLevel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public String toString() {
        return this.name;
    }
}

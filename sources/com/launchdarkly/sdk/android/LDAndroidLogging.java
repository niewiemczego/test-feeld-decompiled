package com.launchdarkly.sdk.android;

import android.util.Log;
import com.launchdarkly.logging.LDLogAdapter;
import com.launchdarkly.logging.LDLogLevel;
import com.launchdarkly.logging.SimpleFormat;

public abstract class LDAndroidLogging {
    public static LDLogAdapter adapter() {
        return new AdapterImpl(false);
    }

    static LDLogAdapter adapter(boolean z) {
        return new AdapterImpl(z);
    }

    static final class AdapterImpl implements LDLogAdapter {
        /* access modifiers changed from: private */
        public final boolean overrideAndroidLogFilter;

        AdapterImpl(boolean z) {
            this.overrideAndroidLogFilter = z;
        }

        public LDLogAdapter.Channel newChannel(String str) {
            return new ChannelImpl(str);
        }

        private final class ChannelImpl extends ChannelImplBase {
            public ChannelImpl(String str) {
                super(str);
            }

            public boolean isEnabled(LDLogLevel lDLogLevel) {
                return AdapterImpl.this.overrideAndroidLogFilter || Log.isLoggable(this.tag, toAndroidLogLevel(lDLogLevel));
            }

            private int toAndroidLogLevel(LDLogLevel lDLogLevel) {
                int i = AnonymousClass1.$SwitchMap$com$launchdarkly$logging$LDLogLevel[lDLogLevel.ordinal()];
                if (i == 1) {
                    return 3;
                }
                if (i == 2) {
                    return 4;
                }
                if (i != 3) {
                    return i != 4 ? 2 : 6;
                }
                return 5;
            }

            /* access modifiers changed from: protected */
            public void logInternal(LDLogLevel lDLogLevel, String str) {
                int i = AnonymousClass1.$SwitchMap$com$launchdarkly$logging$LDLogLevel[lDLogLevel.ordinal()];
                if (i == 1) {
                    Log.d(this.tag, str);
                } else if (i == 2) {
                    Log.i(this.tag, str);
                } else if (i == 3) {
                    Log.w(this.tag, str);
                } else if (i == 4) {
                    Log.e(this.tag, str);
                }
            }
        }
    }

    /* renamed from: com.launchdarkly.sdk.android.LDAndroidLogging$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$launchdarkly$logging$LDLogLevel;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.launchdarkly.logging.LDLogLevel[] r0 = com.launchdarkly.logging.LDLogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$launchdarkly$logging$LDLogLevel = r0
                com.launchdarkly.logging.LDLogLevel r1 = com.launchdarkly.logging.LDLogLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$launchdarkly$logging$LDLogLevel     // Catch:{ NoSuchFieldError -> 0x001d }
                com.launchdarkly.logging.LDLogLevel r1 = com.launchdarkly.logging.LDLogLevel.INFO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$launchdarkly$logging$LDLogLevel     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.launchdarkly.logging.LDLogLevel r1 = com.launchdarkly.logging.LDLogLevel.WARN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$launchdarkly$logging$LDLogLevel     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.launchdarkly.logging.LDLogLevel r1 = com.launchdarkly.logging.LDLogLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.android.LDAndroidLogging.AnonymousClass1.<clinit>():void");
        }
    }

    static abstract class ChannelImplBase implements LDLogAdapter.Channel {
        protected final String tag;

        /* access modifiers changed from: protected */
        public abstract void logInternal(LDLogLevel lDLogLevel, String str);

        public ChannelImplBase(String str) {
            this.tag = str;
        }

        public void log(LDLogLevel lDLogLevel, Object obj) {
            String str;
            if (isEnabled(lDLogLevel)) {
                if (obj == null) {
                    str = null;
                } else {
                    str = obj.toString();
                }
                logInternal(lDLogLevel, str);
            }
        }

        public void log(LDLogLevel lDLogLevel, String str, Object obj) {
            if (isEnabled(lDLogLevel)) {
                logInternal(lDLogLevel, SimpleFormat.format(str, obj));
            }
        }

        public void log(LDLogLevel lDLogLevel, String str, Object obj, Object obj2) {
            if (isEnabled(lDLogLevel)) {
                logInternal(lDLogLevel, SimpleFormat.format(str, obj, obj2));
            }
        }

        public void log(LDLogLevel lDLogLevel, String str, Object... objArr) {
            if (isEnabled(lDLogLevel)) {
                logInternal(lDLogLevel, SimpleFormat.format(str, objArr));
            }
        }
    }
}

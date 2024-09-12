package com.launchdarkly.logging;

import com.launchdarkly.logging.LDLogAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LDSLF4J {
    private LDSLF4J() {
    }

    public static LDLogAdapter adapter() {
        return AdapterImpl.INSTANCE;
    }

    private static final class AdapterImpl implements LDLogAdapter, LDLogAdapter.IsConfiguredExternally {
        /* access modifiers changed from: private */
        public static final AdapterImpl INSTANCE = new AdapterImpl();

        private AdapterImpl() {
        }

        public LDLogAdapter.Channel newChannel(String str) {
            return new ChannelImpl(LoggerFactory.getLogger(str));
        }
    }

    private static final class ChannelImpl implements LDLogAdapter.Channel {
        private final Logger logger;

        ChannelImpl(Logger logger2) {
            this.logger = logger2;
        }

        public boolean isEnabled(LDLogLevel lDLogLevel) {
            int i = AnonymousClass1.$SwitchMap$com$launchdarkly$logging$LDLogLevel[lDLogLevel.ordinal()];
            if (i == 1) {
                return this.logger.isDebugEnabled();
            }
            if (i == 2) {
                return this.logger.isInfoEnabled();
            }
            if (i != 3) {
                return this.logger.isErrorEnabled();
            }
            return this.logger.isWarnEnabled();
        }

        public void log(LDLogLevel lDLogLevel, Object obj) {
            String str;
            if (isEnabled(lDLogLevel)) {
                if (obj == null) {
                    str = "";
                } else {
                    str = obj.toString();
                }
                int i = AnonymousClass1.$SwitchMap$com$launchdarkly$logging$LDLogLevel[lDLogLevel.ordinal()];
                if (i == 1) {
                    this.logger.debug(str);
                } else if (i == 2) {
                    this.logger.info(str);
                } else if (i == 3) {
                    this.logger.warn(str);
                } else if (i == 4) {
                    this.logger.error(str);
                }
            }
        }

        public void log(LDLogLevel lDLogLevel, String str, Object obj) {
            int i = AnonymousClass1.$SwitchMap$com$launchdarkly$logging$LDLogLevel[lDLogLevel.ordinal()];
            if (i == 1) {
                this.logger.debug(str, obj);
            } else if (i == 2) {
                this.logger.info(str, obj);
            } else if (i == 3) {
                this.logger.warn(str, obj);
            } else if (i == 4) {
                this.logger.error(str, obj);
            }
        }

        public void log(LDLogLevel lDLogLevel, String str, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$launchdarkly$logging$LDLogLevel[lDLogLevel.ordinal()];
            if (i == 1) {
                this.logger.debug(str, obj, obj2);
            } else if (i == 2) {
                this.logger.info(str, obj, obj2);
            } else if (i == 3) {
                this.logger.warn(str, obj, obj2);
            } else if (i == 4) {
                this.logger.error(str, obj, obj2);
            }
        }

        public void log(LDLogLevel lDLogLevel, String str, Object... objArr) {
            int i = AnonymousClass1.$SwitchMap$com$launchdarkly$logging$LDLogLevel[lDLogLevel.ordinal()];
            if (i == 1) {
                this.logger.debug(str, objArr);
            } else if (i == 2) {
                this.logger.info(str, objArr);
            } else if (i == 3) {
                this.logger.warn(str, objArr);
            } else if (i == 4) {
                this.logger.error(str, objArr);
            }
        }
    }

    /* renamed from: com.launchdarkly.logging.LDSLF4J$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.logging.LDSLF4J.AnonymousClass1.<clinit>():void");
        }
    }
}

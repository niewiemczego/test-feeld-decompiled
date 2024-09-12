package com.launchdarkly.logging;

public interface LDLogAdapter {

    public interface Channel {
        boolean isEnabled(LDLogLevel lDLogLevel);

        void log(LDLogLevel lDLogLevel, Object obj);

        void log(LDLogLevel lDLogLevel, String str, Object obj);

        void log(LDLogLevel lDLogLevel, String str, Object obj, Object obj2);

        void log(LDLogLevel lDLogLevel, String str, Object... objArr);
    }

    public interface IsConfiguredExternally {
    }

    Channel newChannel(String str);
}

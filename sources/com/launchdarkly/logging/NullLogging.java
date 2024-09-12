package com.launchdarkly.logging;

import com.launchdarkly.logging.LDLogAdapter;

final class NullLogging implements LDLogAdapter {
    static NullLogging INSTANCE = new NullLogging();

    private NullLogging() {
    }

    public LDLogAdapter.Channel newChannel(String str) {
        return ChannelImpl.INSTANCE;
    }

    private static final class ChannelImpl implements LDLogAdapter.Channel {
        static ChannelImpl INSTANCE = new ChannelImpl();

        public boolean isEnabled(LDLogLevel lDLogLevel) {
            return false;
        }

        public void log(LDLogLevel lDLogLevel, Object obj) {
        }

        public void log(LDLogLevel lDLogLevel, String str, Object obj) {
        }

        public void log(LDLogLevel lDLogLevel, String str, Object obj, Object obj2) {
        }

        public void log(LDLogLevel lDLogLevel, String str, Object... objArr) {
        }

        private ChannelImpl() {
        }
    }
}

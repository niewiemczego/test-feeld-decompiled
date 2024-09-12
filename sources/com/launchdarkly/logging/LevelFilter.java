package com.launchdarkly.logging;

import com.launchdarkly.logging.LDLogAdapter;

class LevelFilter implements LDLogAdapter {
    /* access modifiers changed from: private */
    public final LDLogLevel enableLevel;
    final LDLogAdapter wrappedAdapter;

    public LevelFilter(LDLogAdapter lDLogAdapter, LDLogLevel lDLogLevel) {
        this.wrappedAdapter = lDLogAdapter;
        this.enableLevel = lDLogLevel == null ? LDLogLevel.DEBUG : lDLogLevel;
    }

    public LDLogAdapter.Channel newChannel(String str) {
        return new ChannelImpl(this.wrappedAdapter.newChannel(str));
    }

    private class ChannelImpl implements LDLogAdapter.Channel {
        private final LDLogAdapter.Channel wrappedChannel;

        public ChannelImpl(LDLogAdapter.Channel channel) {
            this.wrappedChannel = channel;
        }

        public boolean isEnabled(LDLogLevel lDLogLevel) {
            return LevelFilter.this.enableLevel.compareTo(lDLogLevel) <= 0 && this.wrappedChannel.isEnabled(lDLogLevel);
        }

        public void log(LDLogLevel lDLogLevel, Object obj) {
            if (isEnabled(lDLogLevel)) {
                this.wrappedChannel.log(lDLogLevel, obj);
            }
        }

        public void log(LDLogLevel lDLogLevel, String str, Object obj) {
            if (isEnabled(lDLogLevel)) {
                this.wrappedChannel.log(lDLogLevel, str, obj);
            }
        }

        public void log(LDLogLevel lDLogLevel, String str, Object obj, Object obj2) {
            if (isEnabled(lDLogLevel)) {
                this.wrappedChannel.log(lDLogLevel, str, obj, obj2);
            }
        }

        public void log(LDLogLevel lDLogLevel, String str, Object... objArr) {
            if (isEnabled(lDLogLevel)) {
                this.wrappedChannel.log(lDLogLevel, str, objArr);
            }
        }
    }
}

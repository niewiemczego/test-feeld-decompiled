package com.launchdarkly.logging;

import com.launchdarkly.logging.LDLogAdapter;

final class MultiLogging implements LDLogAdapter {
    private final LDLogAdapter[] adapters;

    MultiLogging(LDLogAdapter[] lDLogAdapterArr) {
        LDLogAdapter[] lDLogAdapterArr2 = new LDLogAdapter[lDLogAdapterArr.length];
        this.adapters = lDLogAdapterArr2;
        System.arraycopy(lDLogAdapterArr, 0, lDLogAdapterArr2, 0, lDLogAdapterArr.length);
    }

    public LDLogAdapter.Channel newChannel(String str) {
        LDLogAdapter.Channel[] channelArr = new LDLogAdapter.Channel[this.adapters.length];
        int i = 0;
        while (true) {
            LDLogAdapter[] lDLogAdapterArr = this.adapters;
            if (i >= lDLogAdapterArr.length) {
                return new ChannelImpl(channelArr);
            }
            channelArr[i] = lDLogAdapterArr[i].newChannel(str);
            i++;
        }
    }

    private static final class ChannelImpl implements LDLogAdapter.Channel {
        private final LDLogAdapter.Channel[] channels;

        ChannelImpl(LDLogAdapter.Channel[] channelArr) {
            this.channels = channelArr;
        }

        public boolean isEnabled(LDLogLevel lDLogLevel) {
            for (LDLogAdapter.Channel isEnabled : this.channels) {
                if (isEnabled.isEnabled(lDLogLevel)) {
                    return true;
                }
            }
            return false;
        }

        public void log(LDLogLevel lDLogLevel, Object obj) {
            for (LDLogAdapter.Channel log : this.channels) {
                log.log(lDLogLevel, obj);
            }
        }

        public void log(LDLogLevel lDLogLevel, String str, Object obj) {
            for (LDLogAdapter.Channel log : this.channels) {
                log.log(lDLogLevel, str, obj);
            }
        }

        public void log(LDLogLevel lDLogLevel, String str, Object obj, Object obj2) {
            for (LDLogAdapter.Channel log : this.channels) {
                log.log(lDLogLevel, str, obj, obj2);
            }
        }

        public void log(LDLogLevel lDLogLevel, String str, Object... objArr) {
            for (LDLogAdapter.Channel log : this.channels) {
                log.log(lDLogLevel, str, objArr);
            }
        }
    }
}

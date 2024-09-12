package com.launchdarkly.logging;

import com.launchdarkly.logging.LDLogAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class SimpleLogging implements LDLogAdapter {
    final LineWriter lineWriter;
    /* access modifiers changed from: private */
    public final String tag;
    /* access modifiers changed from: private */
    public final DateFormat timestampFormat;

    public interface LineWriter {
        void writeLine(String str);
    }

    public static SimpleDateFormat getDefaultTimestampFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS zzz");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    SimpleLogging(LineWriter lineWriter2, String str, DateFormat dateFormat) {
        this.lineWriter = lineWriter2;
        this.tag = str;
        this.timestampFormat = dateFormat;
    }

    public SimpleLogging tag(String str) {
        return new SimpleLogging(this.lineWriter, str, this.timestampFormat);
    }

    public SimpleLogging timestampFormat(DateFormat dateFormat) {
        return new SimpleLogging(this.lineWriter, this.tag, dateFormat);
    }

    public LDLogAdapter.Channel newChannel(String str) {
        return new ChannelImpl(str);
    }

    private final class ChannelImpl implements LDLogAdapter.Channel {
        private final String name;

        public boolean isEnabled(LDLogLevel lDLogLevel) {
            return true;
        }

        ChannelImpl(String str) {
            this.name = str;
        }

        public void log(LDLogLevel lDLogLevel, Object obj) {
            print(lDLogLevel, obj == null ? "" : obj.toString());
        }

        public void log(LDLogLevel lDLogLevel, String str, Object obj) {
            print(lDLogLevel, SimpleFormat.format(str, obj));
        }

        public void log(LDLogLevel lDLogLevel, String str, Object obj, Object obj2) {
            print(lDLogLevel, SimpleFormat.format(str, obj, obj2));
        }

        public void log(LDLogLevel lDLogLevel, String str, Object... objArr) {
            print(lDLogLevel, SimpleFormat.format(str, objArr));
        }

        private void print(LDLogLevel lDLogLevel, String str) {
            StringBuilder sb = new StringBuilder();
            if (SimpleLogging.this.timestampFormat != null) {
                sb.append(((DateFormat) SimpleLogging.this.timestampFormat.clone()).format(new Date())).append(" ");
            }
            if (SimpleLogging.this.tag != null && !SimpleLogging.this.tag.isEmpty()) {
                sb.append("{").append(SimpleLogging.this.tag).append("} ");
            }
            sb.append("[").append(this.name).append("] ").append(lDLogLevel).append(": ").append(str);
            SimpleLogging.this.lineWriter.writeLine(sb.toString());
        }
    }
}

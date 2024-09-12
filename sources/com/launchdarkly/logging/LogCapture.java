package com.launchdarkly.logging;

import com.facebook.internal.security.CertificateUtil;
import com.launchdarkly.logging.LDLogAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public final class LogCapture implements LDLogAdapter {
    /* access modifiers changed from: private */
    public final List<Message> messages = new ArrayList();
    /* access modifiers changed from: private */
    public final Object messagesLock = new Object();

    LogCapture() {
    }

    public static final class Message {
        /* access modifiers changed from: private */
        public final LDLogLevel level;
        private final String loggerName;
        private final String text;
        private final Date timestamp;

        public Message(Date date, String str, LDLogLevel lDLogLevel, String str2) {
            this.timestamp = date;
            this.loggerName = str;
            this.level = lDLogLevel;
            this.text = str2;
        }

        public Date getTimestamp() {
            return this.timestamp;
        }

        public String getLoggerName() {
            return this.loggerName;
        }

        public LDLogLevel getLevel() {
            return this.level;
        }

        public String getText() {
            return this.text;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Message)) {
                return false;
            }
            Message message = (Message) obj;
            if (!Objects.equals(this.timestamp, message.timestamp) || !Objects.equals(this.loggerName, message.loggerName) || this.level != message.level || !Objects.equals(this.text, message.text)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.timestamp, this.loggerName, this.level, this.text});
        }

        public String toString() {
            return "[" + this.loggerName + "] " + this.level.name() + CertificateUtil.DELIMITER + this.text;
        }

        public String toStringWithTimestamp() {
            return SimpleLogging.getDefaultTimestampFormat().format(this.timestamp) + " " + toString();
        }
    }

    public LDLogAdapter.Channel newChannel(String str) {
        return new ChannelImpl(str);
    }

    public List<Message> getMessages() {
        ArrayList arrayList;
        synchronized (this.messagesLock) {
            arrayList = new ArrayList(this.messages);
        }
        return arrayList;
    }

    public List<String> getMessageStrings() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.messagesLock) {
            for (Message next : this.messages) {
                arrayList.add(next.getLevel().name() + CertificateUtil.DELIMITER + next.getText());
            }
        }
        return arrayList;
    }

    public Message awaitMessage(long j) {
        return awaitMessage((LDLogLevel) null, j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0041 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.launchdarkly.logging.LogCapture.Message awaitMessage(com.launchdarkly.logging.LDLogLevel r7, long r8) {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            long r0 = r0 + r8
            java.lang.Object r8 = r6.messagesLock
            monitor-enter(r8)
        L_0x0008:
            r9 = 0
        L_0x0009:
            java.util.List<com.launchdarkly.logging.LogCapture$Message> r2 = r6.messages     // Catch:{ all -> 0x0043 }
            int r2 = r2.size()     // Catch:{ all -> 0x0043 }
            if (r9 >= r2) goto L_0x002c
            java.util.List<com.launchdarkly.logging.LogCapture$Message> r2 = r6.messages     // Catch:{ all -> 0x0043 }
            java.lang.Object r2 = r2.get(r9)     // Catch:{ all -> 0x0043 }
            com.launchdarkly.logging.LogCapture$Message r2 = (com.launchdarkly.logging.LogCapture.Message) r2     // Catch:{ all -> 0x0043 }
            if (r7 == 0) goto L_0x0025
            com.launchdarkly.logging.LDLogLevel r3 = r2.level     // Catch:{ all -> 0x0043 }
            if (r3 != r7) goto L_0x0022
            goto L_0x0025
        L_0x0022:
            int r9 = r9 + 1
            goto L_0x0009
        L_0x0025:
            java.util.List<com.launchdarkly.logging.LogCapture$Message> r7 = r6.messages     // Catch:{ all -> 0x0043 }
            r7.remove(r9)     // Catch:{ all -> 0x0043 }
            monitor-exit(r8)     // Catch:{ all -> 0x0043 }
            return r2
        L_0x002c:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0043 }
            long r2 = r0 - r2
            r4 = 0
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r4 = 0
            if (r9 > 0) goto L_0x003b
            monitor-exit(r8)     // Catch:{ all -> 0x0043 }
            return r4
        L_0x003b:
            java.lang.Object r9 = r6.messagesLock     // Catch:{ InterruptedException -> 0x0041 }
            r9.wait(r2)     // Catch:{ InterruptedException -> 0x0041 }
            goto L_0x0008
        L_0x0041:
            monitor-exit(r8)     // Catch:{ all -> 0x0043 }
            return r4
        L_0x0043:
            r7 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0043 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.logging.LogCapture.awaitMessage(com.launchdarkly.logging.LDLogLevel, long):com.launchdarkly.logging.LogCapture$Message");
    }

    public Message requireMessage(long j) {
        return requireMessage((LDLogLevel) null, j);
    }

    public Message requireMessage(LDLogLevel lDLogLevel, long j) {
        Message awaitMessage = awaitMessage(lDLogLevel, j);
        if (awaitMessage != null) {
            return awaitMessage;
        }
        throw new AssertionError("expected a log message but did not get one");
    }

    private final class ChannelImpl implements LDLogAdapter.Channel {
        private final String name;

        public boolean isEnabled(LDLogLevel lDLogLevel) {
            return true;
        }

        ChannelImpl(String str) {
            this.name = str;
        }

        private void addMessage(LDLogLevel lDLogLevel, String str) {
            synchronized (LogCapture.this.messagesLock) {
                LogCapture.this.messages.add(new Message(new Date(), this.name, lDLogLevel, str));
                LogCapture.this.messagesLock.notifyAll();
            }
        }

        public void log(LDLogLevel lDLogLevel, Object obj) {
            addMessage(lDLogLevel, obj == null ? "" : obj.toString());
        }

        public void log(LDLogLevel lDLogLevel, String str, Object obj) {
            addMessage(lDLogLevel, SimpleFormat.format(str, obj));
        }

        public void log(LDLogLevel lDLogLevel, String str, Object obj, Object obj2) {
            addMessage(lDLogLevel, SimpleFormat.format(str, obj, obj2));
        }

        public void log(LDLogLevel lDLogLevel, String str, Object... objArr) {
            addMessage(lDLogLevel, SimpleFormat.format(str, objArr));
        }
    }
}

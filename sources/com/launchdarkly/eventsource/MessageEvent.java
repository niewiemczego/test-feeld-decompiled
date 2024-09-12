package com.launchdarkly.eventsource;

import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.util.Objects;

public class MessageEvent {
    public static final String DEFAULT_EVENT_NAME = "message";
    private static final int READER_BUFFER_SIZE = 2000;
    private volatile String data;
    private volatile Reader dataReader;
    private final Object dataReaderLock;
    private final String eventName;
    private final String lastEventId;
    private final URI origin;

    public MessageEvent(String str) {
        this((String) null, str, (String) null, (URI) null);
    }

    public MessageEvent(String str, String str2, URI uri) {
        this((String) null, str, str2, uri);
    }

    public MessageEvent(String str, String str2, String str3, URI uri) {
        this.eventName = str == null ? "message" : str;
        this.data = str2 == null ? "" : str2;
        this.dataReader = null;
        this.dataReaderLock = new Object();
        this.lastEventId = str3;
        this.origin = uri;
    }

    public MessageEvent(String str, Reader reader, String str2, URI uri) {
        this.data = null;
        this.dataReader = reader;
        this.dataReaderLock = new Object();
        this.eventName = str == null ? "message" : str;
        this.lastEventId = str2;
        this.origin = uri;
    }

    public MessageEvent(String str, String str2) {
        this(str, str2, (String) null, (URI) null);
    }

    public String getEventName() {
        return this.eventName;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|(3:13|14|(1:16)(2:25|17))|18|19|20|21) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getData() {
        /*
            r7 = this;
            java.lang.String r0 = r7.data
            if (r0 == 0) goto L_0x0007
            java.lang.String r0 = r7.data
            return r0
        L_0x0007:
            java.lang.Object r0 = r7.dataReaderLock
            monitor-enter(r0)
            java.lang.String r1 = r7.data     // Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x0012
            java.lang.String r1 = r7.data     // Catch:{ all -> 0x0041 }
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return r1
        L_0x0012:
            r1 = 2000(0x7d0, float:2.803E-42)
            char[] r2 = new char[r1]     // Catch:{ all -> 0x0041 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0041 }
            r3.<init>(r1)     // Catch:{ all -> 0x0041 }
        L_0x001b:
            java.io.Reader r4 = r7.dataReader     // Catch:{ IOException -> 0x002e }
            r5 = 0
            int r4 = r4.read(r2, r5, r1)     // Catch:{ IOException -> 0x002e }
            r6 = -1
            if (r4 == r6) goto L_0x0029
            r3.append(r2, r5, r4)     // Catch:{ IOException -> 0x002e }
            goto L_0x001b
        L_0x0029:
            java.io.Reader r1 = r7.dataReader     // Catch:{ IOException -> 0x002e }
            r1.close()     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0041 }
            r7.data = r1     // Catch:{ all -> 0x0041 }
            java.io.StringReader r1 = new java.io.StringReader     // Catch:{ all -> 0x0041 }
            java.lang.String r2 = r7.data     // Catch:{ all -> 0x0041 }
            r1.<init>(r2)     // Catch:{ all -> 0x0041 }
            r7.dataReader = r1     // Catch:{ all -> 0x0041 }
            java.lang.String r1 = r7.data     // Catch:{ all -> 0x0041 }
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return r1
        L_0x0041:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.eventsource.MessageEvent.getData():java.lang.String");
    }

    public Reader getDataReader() {
        Reader reader;
        synchronized (this.dataReaderLock) {
            if (this.dataReader == null) {
                this.dataReader = new StringReader(this.data);
            }
            reader = this.dataReader;
        }
        return reader;
    }

    public String getLastEventId() {
        return this.lastEventId;
    }

    public URI getOrigin() {
        return this.origin;
    }

    public boolean isStreamingData() {
        return this.data == null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:5|6)|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.dataReaderLock
            monitor-enter(r0)
            java.io.Reader r1 = r2.dataReader     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x000c
            java.io.Reader r1 = r2.dataReader     // Catch:{ IOException -> 0x000c }
            r1.close()     // Catch:{ IOException -> 0x000c }
        L_0x000c:
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            return
        L_0x000e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.eventsource.MessageEvent.close():void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MessageEvent messageEvent = (MessageEvent) obj;
        if (!Objects.equals(getEventName(), messageEvent.getEventName()) || !Objects.equals(getData(), messageEvent.getData()) || !Objects.equals(getLastEventId(), messageEvent.getLastEventId()) || !Objects.equals(getOrigin(), messageEvent.getOrigin())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{getEventName(), getData(), getLastEventId(), getOrigin()});
    }

    public String toString() {
        String sb;
        synchronized (this.dataReaderLock) {
            StringBuilder append = new StringBuilder("MessageEvent(eventName=").append(this.eventName).append(",data=").append(this.data == null ? "<streaming>" : this.data);
            if (this.lastEventId != null) {
                append.append(",id=").append(this.lastEventId);
            }
            append.append(",origin=").append(this.origin).append(')');
            sb = append.toString();
        }
        return sb;
    }
}

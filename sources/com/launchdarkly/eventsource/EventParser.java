package com.launchdarkly.eventsource;

import com.launchdarkly.logging.LDLogger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Set;
import java.util.regex.Pattern;

final class EventParser {
    private static final String COMMENT = "";
    private static final String DATA = "data";
    private static final Pattern DIGITS_ONLY = Pattern.compile("^[\\d]+$");
    private static final String EVENT = "event";
    private static final String ID = "id";
    private static final int MIN_READ_BUFFER_SIZE = 200;
    private static final String RETRY = "retry";
    static final int VALUE_BUFFER_INITIAL_CAPACITY = 1000;
    private final ConnectionHandler connectionHandler;
    private ByteArrayOutputStream dataBuffer;
    private boolean dataLineEnded;
    private String eventName;
    private Set<String> expectFields;
    private String fieldName;
    private final EventHandler handler;
    private boolean haveData;
    private String lastEventId;
    private BufferedLineParser lineParser;
    private final LDLogger logger;
    private final URI origin;
    private boolean skipRestOfLine;
    private final boolean streamEventData;
    private ByteArrayOutputStream valueBuffer;
    private PipedOutputStream writingDataStream;

    EventParser(InputStream inputStream, URI uri, EventHandler eventHandler, ConnectionHandler connectionHandler2, int i, boolean z, Set<String> set, LDLogger lDLogger) {
        this.lineParser = new BufferedLineParser(inputStream, i < 200 ? 200 : i);
        this.handler = eventHandler;
        this.origin = uri;
        this.connectionHandler = connectionHandler2;
        this.streamEventData = z;
        this.expectFields = set;
        this.logger = lDLogger;
        this.dataBuffer = new ByteArrayOutputStream(1000);
    }

    public boolean isEof() {
        return this.lineParser.isEof();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0143, code lost:
        if (r1.equals("") == false) goto L_0x011c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean processStream() throws java.io.IOException {
        /*
            r11 = this;
            com.launchdarkly.eventsource.BufferedLineParser r0 = r11.lineParser
            boolean r0 = r0.read()
            com.launchdarkly.eventsource.BufferedLineParser r1 = r11.lineParser
            byte[] r1 = r1.getBuffer()
            com.launchdarkly.eventsource.BufferedLineParser r2 = r11.lineParser
            int r2 = r2.getChunkOffset()
            com.launchdarkly.eventsource.BufferedLineParser r3 = r11.lineParser
            int r3 = r3.getChunkSize()
            boolean r4 = r11.skipRestOfLine
            r5 = 1
            if (r4 == 0) goto L_0x0021
            r0 = r0 ^ r5
            r11.skipRestOfLine = r0
            return r5
        L_0x0021:
            r4 = 0
            if (r3 != 0) goto L_0x002b
            if (r0 == 0) goto L_0x002a
            r11.eventTerminated()
            return r5
        L_0x002a:
            return r4
        L_0x002b:
            java.lang.String r6 = r11.fieldName
            java.lang.String r7 = ""
            if (r6 != 0) goto L_0x006a
            r6 = r4
        L_0x0032:
            if (r6 >= r3) goto L_0x003f
            int r8 = r2 + r6
            byte r8 = r1[r8]
            r9 = 58
            if (r8 == r9) goto L_0x003f
            int r6 = r6 + 1
            goto L_0x0032
        L_0x003f:
            r11.resetValueBuffer()
            if (r6 != r3) goto L_0x0049
            if (r0 != 0) goto L_0x0049
            r11.skipRestOfLine = r5
            return r5
        L_0x0049:
            if (r6 != 0) goto L_0x004d
            r8 = r7
            goto L_0x0054
        L_0x004d:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.launchdarkly.eventsource.Helpers.UTF8
            r8.<init>(r1, r2, r6, r9)
        L_0x0054:
            r11.fieldName = r8
            if (r6 >= r3) goto L_0x0066
            int r6 = r6 + 1
            if (r6 >= r3) goto L_0x0066
            int r8 = r2 + r6
            byte r8 = r1[r8]
            r9 = 32
            if (r8 != r9) goto L_0x0066
            int r6 = r6 + 1
        L_0x0066:
            int r2 = r2 + r6
            int r6 = r3 - r6
            goto L_0x006b
        L_0x006a:
            r6 = r3
        L_0x006b:
            java.lang.String r8 = r11.fieldName
            java.lang.String r9 = "data"
            boolean r8 = r8.equals(r9)
            r9 = 0
            if (r8 == 0) goto L_0x00cf
            java.io.PipedOutputStream r3 = r11.writingDataStream
            r4 = 10
            if (r3 == 0) goto L_0x0089
            boolean r7 = r11.dataLineEnded     // Catch:{ IOException -> 0x00c6 }
            if (r7 == 0) goto L_0x0083
            r3.write(r4)     // Catch:{ IOException -> 0x00c6 }
        L_0x0083:
            java.io.PipedOutputStream r3 = r11.writingDataStream     // Catch:{ IOException -> 0x00c6 }
            r3.write(r1, r2, r6)     // Catch:{ IOException -> 0x00c6 }
            goto L_0x00c6
        L_0x0089:
            boolean r3 = r11.canStreamEventDataNow()
            if (r3 == 0) goto L_0x00b6
            java.io.PipedOutputStream r3 = new java.io.PipedOutputStream
            r3.<init>()
            r11.writingDataStream = r3
            java.io.PipedInputStream r3 = new java.io.PipedInputStream
            java.io.PipedOutputStream r4 = r11.writingDataStream
            r3.<init>(r4)
            com.launchdarkly.eventsource.MessageEvent r4 = new com.launchdarkly.eventsource.MessageEvent
            java.lang.String r7 = r11.eventName
            java.io.InputStreamReader r8 = new java.io.InputStreamReader
            r8.<init>(r3)
            java.lang.String r3 = r11.lastEventId
            java.net.URI r10 = r11.origin
            r4.<init>((java.lang.String) r7, (java.io.Reader) r8, (java.lang.String) r3, (java.net.URI) r10)
            r11.dispatchMessage(r4)
            java.io.PipedOutputStream r3 = r11.writingDataStream     // Catch:{ IOException -> 0x00c6 }
            r3.write(r1, r2, r6)     // Catch:{ IOException -> 0x00c6 }
            goto L_0x00c6
        L_0x00b6:
            boolean r3 = r11.dataLineEnded
            if (r3 == 0) goto L_0x00bf
            java.io.ByteArrayOutputStream r3 = r11.dataBuffer
            r3.write(r4)
        L_0x00bf:
            if (r6 == 0) goto L_0x00c6
            java.io.ByteArrayOutputStream r3 = r11.dataBuffer
            r3.write(r1, r2, r6)
        L_0x00c6:
            r11.dataLineEnded = r0
            r11.haveData = r5
            if (r0 == 0) goto L_0x00ce
            r11.fieldName = r9
        L_0x00ce:
            return r5
        L_0x00cf:
            if (r0 != 0) goto L_0x00e4
            java.io.ByteArrayOutputStream r0 = r11.valueBuffer
            if (r0 != 0) goto L_0x00de
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r3 = 1000(0x3e8, float:1.401E-42)
            r0.<init>(r3)
            r11.valueBuffer = r0
        L_0x00de:
            java.io.ByteArrayOutputStream r0 = r11.valueBuffer
            r0.write(r1, r2, r6)
            return r5
        L_0x00e4:
            java.io.ByteArrayOutputStream r0 = r11.valueBuffer
            if (r0 == 0) goto L_0x0104
            int r0 = r0.size()
            if (r0 != 0) goto L_0x00ef
            goto L_0x0104
        L_0x00ef:
            java.io.ByteArrayOutputStream r0 = r11.valueBuffer
            r0.write(r1, r2, r6)
            java.io.ByteArrayOutputStream r0 = r11.valueBuffer
            java.nio.charset.Charset r1 = com.launchdarkly.eventsource.Helpers.UTF8
            java.lang.String r1 = r1.name()
            java.lang.String r0 = r0.toString(r1)
            r11.resetValueBuffer()
            goto L_0x010f
        L_0x0104:
            if (r3 != 0) goto L_0x0108
            r0 = r7
            goto L_0x010f
        L_0x0108:
            java.lang.String r0 = new java.lang.String
            java.nio.charset.Charset r3 = com.launchdarkly.eventsource.Helpers.UTF8
            r0.<init>(r1, r2, r6, r3)
        L_0x010f:
            java.lang.String r1 = r11.fieldName
            r1.hashCode()
            r2 = -1
            int r3 = r1.hashCode()
            switch(r3) {
                case 0: goto L_0x013f;
                case 3355: goto L_0x0134;
                case 96891546: goto L_0x0129;
                case 108405416: goto L_0x011e;
                default: goto L_0x011c;
            }
        L_0x011c:
            r4 = r2
            goto L_0x0146
        L_0x011e:
            java.lang.String r3 = "retry"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0127
            goto L_0x011c
        L_0x0127:
            r4 = 3
            goto L_0x0146
        L_0x0129:
            java.lang.String r3 = "event"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0132
            goto L_0x011c
        L_0x0132:
            r4 = 2
            goto L_0x0146
        L_0x0134:
            java.lang.String r3 = "id"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x013d
            goto L_0x011c
        L_0x013d:
            r4 = r5
            goto L_0x0146
        L_0x013f:
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x0146
            goto L_0x011c
        L_0x0146:
            switch(r4) {
                case 0: goto L_0x0175;
                case 1: goto L_0x0163;
                case 2: goto L_0x0160;
                case 3: goto L_0x014a;
                default: goto L_0x0149;
            }
        L_0x0149:
            goto L_0x0178
        L_0x014a:
            java.util.regex.Pattern r1 = DIGITS_ONLY
            java.util.regex.Matcher r1 = r1.matcher(r0)
            boolean r1 = r1.matches()
            if (r1 == 0) goto L_0x0178
            com.launchdarkly.eventsource.ConnectionHandler r1 = r11.connectionHandler
            long r2 = java.lang.Long.parseLong(r0)
            r1.setReconnectTimeMillis(r2)
            goto L_0x0178
        L_0x0160:
            r11.eventName = r0
            goto L_0x0178
        L_0x0163:
            java.lang.String r1 = "\u0000"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto L_0x0178
            r11.lastEventId = r0
            if (r0 == 0) goto L_0x0178
            com.launchdarkly.eventsource.ConnectionHandler r1 = r11.connectionHandler
            r1.setLastEventId(r0)
            goto L_0x0178
        L_0x0175:
            r11.processComment(r0)
        L_0x0178:
            r11.fieldName = r9
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.eventsource.EventParser.processStream():boolean");
    }

    private boolean canStreamEventDataNow() {
        if (!this.streamEventData) {
            return false;
        }
        Set<String> set = this.expectFields;
        if (set == null) {
            return true;
        }
        if (set.contains("event") && this.eventName == null) {
            return false;
        }
        if (!this.expectFields.contains("id") || this.lastEventId != null) {
            return true;
        }
        return false;
    }

    private void processComment(String str) {
        try {
            this.handler.onComment(str);
        } catch (Exception e) {
            this.logger.warn("Message handler threw an exception: " + e.toString());
            this.logger.debug("Stack trace: {}", (Object) new LazyStackTrace(e));
            this.handler.onError(e);
        }
    }

    private void eventTerminated() throws UnsupportedEncodingException {
        PipedOutputStream pipedOutputStream = this.writingDataStream;
        if (pipedOutputStream != null) {
            try {
                pipedOutputStream.close();
            } catch (IOException unused) {
            }
            this.writingDataStream = null;
            resetState();
        } else if (!this.haveData) {
            resetState();
        } else {
            MessageEvent messageEvent = new MessageEvent(this.eventName, this.dataBuffer.toString(Helpers.UTF8.name()), this.lastEventId, this.origin);
            String str = this.lastEventId;
            if (str != null) {
                this.connectionHandler.setLastEventId(str);
            }
            dispatchMessage(messageEvent);
            resetState();
        }
    }

    private void dispatchMessage(MessageEvent messageEvent) {
        try {
            this.logger.debug("Dispatching message: {}", (Object) messageEvent);
            this.handler.onMessage(messageEvent.getEventName(), messageEvent);
        } catch (Exception e) {
            this.logger.warn("Message handler threw an exception: " + e.toString());
            this.logger.debug("Stack trace: {}", (Object) new LazyStackTrace(e));
            this.handler.onError(e);
        }
    }

    private void resetState() {
        this.haveData = false;
        this.dataLineEnded = false;
        this.eventName = null;
        resetValueBuffer();
        if (this.dataBuffer.size() == 0) {
            return;
        }
        if (this.dataBuffer.size() > 1000) {
            this.dataBuffer = new ByteArrayOutputStream(1000);
        } else {
            this.dataBuffer.reset();
        }
    }

    private void resetValueBuffer() {
        ByteArrayOutputStream byteArrayOutputStream = this.valueBuffer;
        if (byteArrayOutputStream == null) {
            return;
        }
        if (byteArrayOutputStream.size() > 1000) {
            this.valueBuffer = null;
        } else {
            this.valueBuffer.reset();
        }
    }
}

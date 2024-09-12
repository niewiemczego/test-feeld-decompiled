package io.sentry;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public final class Session implements JsonUnknown, JsonSerializable {
    private String abnormalMechanism;
    private final String distinctId;
    private Double duration;
    private final String environment;
    private final AtomicInteger errorCount;
    private Boolean init;
    private final String ipAddress;
    private final String release;
    private Long sequence;
    private final UUID sessionId;
    private final Object sessionLock;
    private final Date started;
    private State status;
    private Date timestamp;
    private Map<String, Object> unknown;
    private String userAgent;

    public static final class JsonKeys {
        public static final String ABNORMAL_MECHANISM = "abnormal_mechanism";
        public static final String ATTRS = "attrs";
        public static final String DID = "did";
        public static final String DURATION = "duration";
        public static final String ENVIRONMENT = "environment";
        public static final String ERRORS = "errors";
        public static final String INIT = "init";
        public static final String IP_ADDRESS = "ip_address";
        public static final String RELEASE = "release";
        public static final String SEQ = "seq";
        public static final String SID = "sid";
        public static final String STARTED = "started";
        public static final String STATUS = "status";
        public static final String TIMESTAMP = "timestamp";
        public static final String USER_AGENT = "user_agent";
    }

    public enum State {
        Ok,
        Exited,
        Crashed,
        Abnormal
    }

    public Session(State state, Date date, Date date2, int i, String str, UUID uuid, Boolean bool, Long l, Double d, String str2, String str3, String str4, String str5, String str6) {
        this.sessionLock = new Object();
        this.status = state;
        this.started = date;
        this.timestamp = date2;
        this.errorCount = new AtomicInteger(i);
        this.distinctId = str;
        this.sessionId = uuid;
        this.init = bool;
        this.sequence = l;
        this.duration = d;
        this.ipAddress = str2;
        this.userAgent = str3;
        this.environment = str4;
        this.release = str5;
        this.abnormalMechanism = str6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Session(java.lang.String r16, io.sentry.protocol.User r17, java.lang.String r18, java.lang.String r19) {
        /*
            r15 = this;
            io.sentry.Session$State r1 = io.sentry.Session.State.Ok
            java.util.Date r2 = io.sentry.DateUtils.getCurrentDateTime()
            java.util.Date r3 = io.sentry.DateUtils.getCurrentDateTime()
            java.util.UUID r6 = java.util.UUID.randomUUID()
            r0 = 1
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r0)
            if (r17 == 0) goto L_0x001a
            java.lang.String r0 = r17.getIpAddress()
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            r10 = r0
            r11 = 0
            r14 = 0
            r4 = 0
            r8 = 0
            r9 = 0
            r0 = r15
            r5 = r16
            r12 = r18
            r13 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.Session.<init>(java.lang.String, io.sentry.protocol.User, java.lang.String, java.lang.String):void");
    }

    public boolean isTerminated() {
        return this.status != State.Ok;
    }

    public Date getStarted() {
        Date date = this.started;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public String getDistinctId() {
        return this.distinctId;
    }

    public UUID getSessionId() {
        return this.sessionId;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public String getRelease() {
        return this.release;
    }

    public Boolean getInit() {
        return this.init;
    }

    public void setInitAsTrue() {
        this.init = true;
    }

    public int errorCount() {
        return this.errorCount.get();
    }

    public State getStatus() {
        return this.status;
    }

    public Long getSequence() {
        return this.sequence;
    }

    public Double getDuration() {
        return this.duration;
    }

    public String getAbnormalMechanism() {
        return this.abnormalMechanism;
    }

    public Date getTimestamp() {
        Date date = this.timestamp;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void end() {
        end(DateUtils.getCurrentDateTime());
    }

    public void end(Date date) {
        synchronized (this.sessionLock) {
            this.init = null;
            if (this.status == State.Ok) {
                this.status = State.Exited;
            }
            if (date != null) {
                this.timestamp = date;
            } else {
                this.timestamp = DateUtils.getCurrentDateTime();
            }
            Date date2 = this.timestamp;
            if (date2 != null) {
                this.duration = Double.valueOf(calculateDurationTime(date2));
                this.sequence = Long.valueOf(getSequenceTimestamp(this.timestamp));
            }
        }
    }

    private double calculateDurationTime(Date date) {
        return ((double) Math.abs(date.getTime() - this.started.getTime())) / 1000.0d;
    }

    public boolean update(State state, String str, boolean z) {
        return update(state, str, z, (String) null);
    }

    public boolean update(State state, String str, boolean z, String str2) {
        boolean z2;
        synchronized (this.sessionLock) {
            boolean z3 = false;
            z2 = true;
            if (state != null) {
                try {
                    this.status = state;
                    z3 = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (str != null) {
                this.userAgent = str;
                z3 = true;
            }
            if (z) {
                this.errorCount.addAndGet(1);
                z3 = true;
            }
            if (str2 != null) {
                this.abnormalMechanism = str2;
            } else {
                z2 = z3;
            }
            if (z2) {
                this.init = null;
                Date currentDateTime = DateUtils.getCurrentDateTime();
                this.timestamp = currentDateTime;
                if (currentDateTime != null) {
                    this.sequence = Long.valueOf(getSequenceTimestamp(currentDateTime));
                }
            }
        }
        return z2;
    }

    private long getSequenceTimestamp(Date date) {
        long time = date.getTime();
        return time < 0 ? Math.abs(time) : time;
    }

    public Session clone() {
        return new Session(this.status, this.started, this.timestamp, this.errorCount.get(), this.distinctId, this.sessionId, this.init, this.sequence, this.duration, this.ipAddress, this.userAgent, this.environment, this.release, this.abnormalMechanism);
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.sessionId != null) {
            objectWriter.name(JsonKeys.SID).value(this.sessionId.toString());
        }
        if (this.distinctId != null) {
            objectWriter.name(JsonKeys.DID).value(this.distinctId);
        }
        if (this.init != null) {
            objectWriter.name(JsonKeys.INIT).value(this.init);
        }
        objectWriter.name(JsonKeys.STARTED).value(iLogger, this.started);
        objectWriter.name("status").value(iLogger, this.status.name().toLowerCase(Locale.ROOT));
        if (this.sequence != null) {
            objectWriter.name(JsonKeys.SEQ).value((Number) this.sequence);
        }
        objectWriter.name(JsonKeys.ERRORS).value((long) this.errorCount.intValue());
        if (this.duration != null) {
            objectWriter.name("duration").value((Number) this.duration);
        }
        if (this.timestamp != null) {
            objectWriter.name("timestamp").value(iLogger, this.timestamp);
        }
        if (this.abnormalMechanism != null) {
            objectWriter.name(JsonKeys.ABNORMAL_MECHANISM).value(iLogger, this.abnormalMechanism);
        }
        objectWriter.name(JsonKeys.ATTRS);
        objectWriter.beginObject();
        objectWriter.name("release").value(iLogger, this.release);
        if (this.environment != null) {
            objectWriter.name("environment").value(iLogger, this.environment);
        }
        if (this.ipAddress != null) {
            objectWriter.name("ip_address").value(iLogger, this.ipAddress);
        }
        if (this.userAgent != null) {
            objectWriter.name(JsonKeys.USER_AGENT).value(iLogger, this.userAgent);
        }
        objectWriter.endObject();
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.unknown.get(next);
                objectWriter.name(next);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer<Session> {
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.sentry.Session deserialize(io.sentry.JsonObjectReader r28, io.sentry.ILogger r29) throws java.lang.Exception {
            /*
                r27 = this;
                r0 = r27
                r1 = r29
                r28.beginObject()
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
            L_0x0018:
                io.sentry.vendor.gson.stream.JsonToken r2 = r28.peek()
                io.sentry.vendor.gson.stream.JsonToken r0 = io.sentry.vendor.gson.stream.JsonToken.NAME
                r18 = r15
                java.lang.String r15 = "release"
                r19 = r14
                java.lang.String r14 = "status"
                r20 = r13
                java.lang.String r13 = "errors"
                r21 = r12
                java.lang.String r12 = "started"
                if (r2 != r0) goto L_0x01c7
                java.lang.String r0 = r28.nextName()
                r0.hashCode()
                int r2 = r0.hashCode()
                r22 = 3
                r23 = 2
                r24 = -1
                r25 = r11
                r11 = 1
                r26 = 0
                switch(r2) {
                    case -1992012396: goto L_0x00bd;
                    case -1897185151: goto L_0x00b4;
                    case -1294635157: goto L_0x00aa;
                    case -892481550: goto L_0x00a0;
                    case 99455: goto L_0x0095;
                    case 113759: goto L_0x008a;
                    case 113870: goto L_0x007f;
                    case 3237136: goto L_0x0074;
                    case 55126294: goto L_0x0067;
                    case 93152418: goto L_0x005a;
                    case 213717026: goto L_0x004d;
                    default: goto L_0x0049;
                }
            L_0x0049:
                r2 = r24
                goto L_0x00c8
            L_0x004d:
                java.lang.String r2 = "abnormal_mechanism"
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x0056
                goto L_0x0049
            L_0x0056:
                r2 = 10
                goto L_0x00c8
            L_0x005a:
                java.lang.String r2 = "attrs"
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x0063
                goto L_0x0049
            L_0x0063:
                r2 = 9
                goto L_0x00c8
            L_0x0067:
                java.lang.String r2 = "timestamp"
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x0070
                goto L_0x0049
            L_0x0070:
                r2 = 8
                goto L_0x00c8
            L_0x0074:
                java.lang.String r2 = "init"
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x007d
                goto L_0x0049
            L_0x007d:
                r2 = 7
                goto L_0x00c8
            L_0x007f:
                java.lang.String r2 = "sid"
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x0088
                goto L_0x0049
            L_0x0088:
                r2 = 6
                goto L_0x00c8
            L_0x008a:
                java.lang.String r2 = "seq"
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x0093
                goto L_0x0049
            L_0x0093:
                r2 = 5
                goto L_0x00c8
            L_0x0095:
                java.lang.String r2 = "did"
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x009e
                goto L_0x0049
            L_0x009e:
                r2 = 4
                goto L_0x00c8
            L_0x00a0:
                boolean r2 = r0.equals(r14)
                if (r2 != 0) goto L_0x00a7
                goto L_0x0049
            L_0x00a7:
                r2 = r22
                goto L_0x00c8
            L_0x00aa:
                boolean r2 = r0.equals(r13)
                if (r2 != 0) goto L_0x00b1
                goto L_0x0049
            L_0x00b1:
                r2 = r23
                goto L_0x00c8
            L_0x00b4:
                boolean r2 = r0.equals(r12)
                if (r2 != 0) goto L_0x00bb
                goto L_0x0049
            L_0x00bb:
                r2 = r11
                goto L_0x00c8
            L_0x00bd:
                java.lang.String r2 = "duration"
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x00c6
                goto L_0x0049
            L_0x00c6:
                r2 = r26
            L_0x00c8:
                switch(r2) {
                    case 0: goto L_0x01b6;
                    case 1: goto L_0x01af;
                    case 2: goto L_0x01a8;
                    case 3: goto L_0x0197;
                    case 4: goto L_0x0186;
                    case 5: goto L_0x0177;
                    case 6: goto L_0x015f;
                    case 7: goto L_0x0158;
                    case 8: goto L_0x0151;
                    case 9: goto L_0x00e1;
                    case 10: goto L_0x00d9;
                    default: goto L_0x00cb;
                }
            L_0x00cb:
                if (r7 != 0) goto L_0x00d2
                java.util.concurrent.ConcurrentHashMap r7 = new java.util.concurrent.ConcurrentHashMap
                r7.<init>()
            L_0x00d2:
                r2 = r28
                r2.nextUnknown(r1, r7, r0)
                goto L_0x018c
            L_0x00d9:
                r2 = r28
                java.lang.String r17 = r28.nextStringOrNull()
                goto L_0x018c
            L_0x00e1:
                r2 = r28
                r28.beginObject()
                r14 = r19
                r13 = r20
            L_0x00ea:
                io.sentry.vendor.gson.stream.JsonToken r0 = r28.peek()
                io.sentry.vendor.gson.stream.JsonToken r12 = io.sentry.vendor.gson.stream.JsonToken.NAME
                if (r0 != r12) goto L_0x014b
                java.lang.String r0 = r28.nextName()
                r0.hashCode()
                int r12 = r0.hashCode()
                switch(r12) {
                    case -85904877: goto L_0x0125;
                    case 1090594823: goto L_0x011c;
                    case 1480014044: goto L_0x0110;
                    case 1917799825: goto L_0x0103;
                    default: goto L_0x0100;
                }
            L_0x0100:
                r0 = r24
                goto L_0x0130
            L_0x0103:
                java.lang.String r12 = "user_agent"
                boolean r0 = r0.equals(r12)
                if (r0 != 0) goto L_0x010d
                goto L_0x0100
            L_0x010d:
                r0 = r22
                goto L_0x0130
            L_0x0110:
                java.lang.String r12 = "ip_address"
                boolean r0 = r0.equals(r12)
                if (r0 != 0) goto L_0x0119
                goto L_0x0100
            L_0x0119:
                r0 = r23
                goto L_0x0130
            L_0x011c:
                boolean r0 = r0.equals(r15)
                if (r0 != 0) goto L_0x0123
                goto L_0x0100
            L_0x0123:
                r0 = r11
                goto L_0x0130
            L_0x0125:
                java.lang.String r12 = "environment"
                boolean r0 = r0.equals(r12)
                if (r0 != 0) goto L_0x012e
                goto L_0x0100
            L_0x012e:
                r0 = r26
            L_0x0130:
                switch(r0) {
                    case 0: goto L_0x0146;
                    case 1: goto L_0x0141;
                    case 2: goto L_0x013c;
                    case 3: goto L_0x0137;
                    default: goto L_0x0133;
                }
            L_0x0133:
                r28.skipValue()
                goto L_0x00ea
            L_0x0137:
                java.lang.String r14 = r28.nextStringOrNull()
                goto L_0x00ea
            L_0x013c:
                java.lang.String r13 = r28.nextStringOrNull()
                goto L_0x00ea
            L_0x0141:
                java.lang.String r16 = r28.nextStringOrNull()
                goto L_0x00ea
            L_0x0146:
                java.lang.String r18 = r28.nextStringOrNull()
                goto L_0x00ea
            L_0x014b:
                r28.endObject()
                r15 = r18
                goto L_0x0192
            L_0x0151:
                r2 = r28
                java.util.Date r6 = r28.nextDateOrNull(r29)
                goto L_0x018c
            L_0x0158:
                r2 = r28
                java.lang.Boolean r10 = r28.nextBooleanOrNull()
                goto L_0x018c
            L_0x015f:
                r2 = r28
                java.lang.String r0 = r28.nextStringOrNull()     // Catch:{ IllegalArgumentException -> 0x016a }
                java.util.UUID r9 = java.util.UUID.fromString(r0)     // Catch:{ IllegalArgumentException -> 0x016b }
                goto L_0x018c
            L_0x016a:
                r0 = 0
            L_0x016b:
                io.sentry.SentryLevel r12 = io.sentry.SentryLevel.ERROR
                java.lang.Object[] r11 = new java.lang.Object[r11]
                r11[r26] = r0
                java.lang.String r0 = "%s sid is not valid."
                r1.log((io.sentry.SentryLevel) r12, (java.lang.String) r0, (java.lang.Object[]) r11)
                goto L_0x018c
            L_0x0177:
                r2 = r28
                java.lang.Long r11 = r28.nextLongOrNull()
                r15 = r18
                r14 = r19
                r13 = r20
                r12 = r21
                goto L_0x01c3
            L_0x0186:
                r2 = r28
                java.lang.String r8 = r28.nextStringOrNull()
            L_0x018c:
                r15 = r18
                r14 = r19
                r13 = r20
            L_0x0192:
                r12 = r21
            L_0x0194:
                r11 = r25
                goto L_0x01c3
            L_0x0197:
                r2 = r28
                java.lang.String r0 = r28.nextStringOrNull()
                java.lang.String r0 = io.sentry.util.StringUtils.capitalize(r0)
                if (r0 == 0) goto L_0x018c
                io.sentry.Session$State r4 = io.sentry.Session.State.valueOf(r0)
                goto L_0x018c
            L_0x01a8:
                r2 = r28
                java.lang.Integer r3 = r28.nextIntegerOrNull()
                goto L_0x018c
            L_0x01af:
                r2 = r28
                java.util.Date r5 = r28.nextDateOrNull(r29)
                goto L_0x018c
            L_0x01b6:
                r2 = r28
                java.lang.Double r12 = r28.nextDoubleOrNull()
                r15 = r18
                r14 = r19
                r13 = r20
                goto L_0x0194
            L_0x01c3:
                r0 = r27
                goto L_0x0018
            L_0x01c7:
                r2 = r28
                r25 = r11
                if (r4 == 0) goto L_0x0206
                if (r5 == 0) goto L_0x01ff
                if (r3 == 0) goto L_0x01f8
                if (r16 == 0) goto L_0x01f1
                io.sentry.Session r0 = new io.sentry.Session
                int r1 = r3.intValue()
                r3 = r0
                r15 = r7
                r7 = r1
                r11 = r25
                r12 = r21
                r13 = r20
                r14 = r19
                r1 = r15
                r15 = r18
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
                r0.setUnknown(r1)
                r28.endObject()
                return r0
            L_0x01f1:
                r0 = r27
                java.lang.Exception r1 = r0.missingRequiredFieldException(r15, r1)
                throw r1
            L_0x01f8:
                r0 = r27
                java.lang.Exception r1 = r0.missingRequiredFieldException(r13, r1)
                throw r1
            L_0x01ff:
                r0 = r27
                java.lang.Exception r1 = r0.missingRequiredFieldException(r12, r1)
                throw r1
            L_0x0206:
                r0 = r27
                java.lang.Exception r1 = r0.missingRequiredFieldException(r14, r1)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.Session.Deserializer.deserialize(io.sentry.JsonObjectReader, io.sentry.ILogger):io.sentry.Session");
        }

        private Exception missingRequiredFieldException(String str, ILogger iLogger) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            iLogger.log(SentryLevel.ERROR, str2, (Throwable) illegalStateException);
            return illegalStateException;
        }
    }
}

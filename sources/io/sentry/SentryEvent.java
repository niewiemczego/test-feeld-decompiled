package io.sentry;

import io.sentry.SentryBaseEvent;
import io.sentry.SentryLevel;
import io.sentry.protocol.Message;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryThread;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class SentryEvent extends SentryBaseEvent implements JsonUnknown, JsonSerializable {
    /* access modifiers changed from: private */
    public SentryValues<SentryException> exception;
    /* access modifiers changed from: private */
    public List<String> fingerprint;
    /* access modifiers changed from: private */
    public SentryLevel level;
    /* access modifiers changed from: private */
    public String logger;
    /* access modifiers changed from: private */
    public Message message;
    /* access modifiers changed from: private */
    public Map<String, String> modules;
    /* access modifiers changed from: private */
    public SentryValues<SentryThread> threads;
    /* access modifiers changed from: private */
    public Date timestamp;
    /* access modifiers changed from: private */
    public String transaction;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String EXCEPTION = "exception";
        public static final String FINGERPRINT = "fingerprint";
        public static final String LEVEL = "level";
        public static final String LOGGER = "logger";
        public static final String MESSAGE = "message";
        public static final String MODULES = "modules";
        public static final String THREADS = "threads";
        public static final String TIMESTAMP = "timestamp";
        public static final String TRANSACTION = "transaction";
    }

    SentryEvent(SentryId sentryId, Date date) {
        super(sentryId);
        this.timestamp = date;
    }

    public SentryEvent(Throwable th) {
        this();
        this.throwable = th;
    }

    public SentryEvent() {
        this(new SentryId(), DateUtils.getCurrentDateTime());
    }

    public SentryEvent(Date date) {
        this(new SentryId(), date);
    }

    public Date getTimestamp() {
        return (Date) this.timestamp.clone();
    }

    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    public Message getMessage() {
        return this.message;
    }

    public void setMessage(Message message2) {
        this.message = message2;
    }

    public String getLogger() {
        return this.logger;
    }

    public void setLogger(String str) {
        this.logger = str;
    }

    public List<SentryThread> getThreads() {
        SentryValues<SentryThread> sentryValues = this.threads;
        if (sentryValues != null) {
            return sentryValues.getValues();
        }
        return null;
    }

    public void setThreads(List<SentryThread> list) {
        this.threads = new SentryValues<>(list);
    }

    public List<SentryException> getExceptions() {
        SentryValues<SentryException> sentryValues = this.exception;
        if (sentryValues == null) {
            return null;
        }
        return sentryValues.getValues();
    }

    public void setExceptions(List<SentryException> list) {
        this.exception = new SentryValues<>(list);
    }

    public SentryLevel getLevel() {
        return this.level;
    }

    public void setLevel(SentryLevel sentryLevel) {
        this.level = sentryLevel;
    }

    public String getTransaction() {
        return this.transaction;
    }

    public void setTransaction(String str) {
        this.transaction = str;
    }

    public List<String> getFingerprints() {
        return this.fingerprint;
    }

    public void setFingerprints(List<String> list) {
        this.fingerprint = list != null ? new ArrayList(list) : null;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> getModules() {
        return this.modules;
    }

    public void setModules(Map<String, String> map) {
        this.modules = CollectionUtils.newHashMap(map);
    }

    public void setModule(String str, String str2) {
        if (this.modules == null) {
            this.modules = new HashMap();
        }
        this.modules.put(str, str2);
    }

    public void removeModule(String str) {
        Map<String, String> map = this.modules;
        if (map != null) {
            map.remove(str);
        }
    }

    public String getModule(String str) {
        Map<String, String> map = this.modules;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public boolean isCrashed() {
        return getUnhandledException() != null;
    }

    public SentryException getUnhandledException() {
        SentryValues<SentryException> sentryValues = this.exception;
        if (sentryValues == null) {
            return null;
        }
        for (SentryException next : sentryValues.getValues()) {
            if (next.getMechanism() != null && next.getMechanism().isHandled() != null && !next.getMechanism().isHandled().booleanValue()) {
                return next;
            }
        }
        return null;
    }

    public boolean isErrored() {
        SentryValues<SentryException> sentryValues = this.exception;
        return sentryValues != null && !sentryValues.getValues().isEmpty();
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name("timestamp").value(iLogger, this.timestamp);
        if (this.message != null) {
            objectWriter.name("message").value(iLogger, this.message);
        }
        if (this.logger != null) {
            objectWriter.name(JsonKeys.LOGGER).value(this.logger);
        }
        SentryValues<SentryThread> sentryValues = this.threads;
        if (sentryValues != null && !sentryValues.getValues().isEmpty()) {
            objectWriter.name(JsonKeys.THREADS);
            objectWriter.beginObject();
            objectWriter.name("values").value(iLogger, this.threads.getValues());
            objectWriter.endObject();
        }
        SentryValues<SentryException> sentryValues2 = this.exception;
        if (sentryValues2 != null && !sentryValues2.getValues().isEmpty()) {
            objectWriter.name(JsonKeys.EXCEPTION);
            objectWriter.beginObject();
            objectWriter.name("values").value(iLogger, this.exception.getValues());
            objectWriter.endObject();
        }
        if (this.level != null) {
            objectWriter.name("level").value(iLogger, this.level);
        }
        if (this.transaction != null) {
            objectWriter.name("transaction").value(this.transaction);
        }
        if (this.fingerprint != null) {
            objectWriter.name(JsonKeys.FINGERPRINT).value(iLogger, this.fingerprint);
        }
        if (this.modules != null) {
            objectWriter.name(JsonKeys.MODULES).value(iLogger, this.modules);
        }
        new SentryBaseEvent.Serializer().serialize(this, objectWriter, iLogger);
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

    public static final class Deserializer implements JsonDeserializer<SentryEvent> {
        public SentryEvent deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            SentryEvent sentryEvent = new SentryEvent();
            SentryBaseEvent.Deserializer deserializer = new SentryBaseEvent.Deserializer();
            ConcurrentHashMap concurrentHashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -1375934236:
                        if (nextName.equals(JsonKeys.FINGERPRINT)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1337936983:
                        if (nextName.equals(JsonKeys.THREADS)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1097337456:
                        if (nextName.equals(JsonKeys.LOGGER)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 55126294:
                        if (nextName.equals("timestamp")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 102865796:
                        if (nextName.equals("level")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 954925063:
                        if (nextName.equals("message")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 1227433863:
                        if (nextName.equals(JsonKeys.MODULES)) {
                            c = 6;
                            break;
                        }
                        break;
                    case 1481625679:
                        if (nextName.equals(JsonKeys.EXCEPTION)) {
                            c = 7;
                            break;
                        }
                        break;
                    case 2141246174:
                        if (nextName.equals("transaction")) {
                            c = 8;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        List list = (List) jsonObjectReader.nextObjectOrNull();
                        if (list == null) {
                            break;
                        } else {
                            List unused = sentryEvent.fingerprint = list;
                            break;
                        }
                    case 1:
                        jsonObjectReader.beginObject();
                        jsonObjectReader.nextName();
                        SentryValues unused2 = sentryEvent.threads = new SentryValues(jsonObjectReader.nextListOrNull(iLogger, new SentryThread.Deserializer()));
                        jsonObjectReader.endObject();
                        break;
                    case 2:
                        String unused3 = sentryEvent.logger = jsonObjectReader.nextStringOrNull();
                        break;
                    case 3:
                        Date nextDateOrNull = jsonObjectReader.nextDateOrNull(iLogger);
                        if (nextDateOrNull == null) {
                            break;
                        } else {
                            Date unused4 = sentryEvent.timestamp = nextDateOrNull;
                            break;
                        }
                    case 4:
                        SentryLevel unused5 = sentryEvent.level = (SentryLevel) jsonObjectReader.nextOrNull(iLogger, new SentryLevel.Deserializer());
                        break;
                    case 5:
                        Message unused6 = sentryEvent.message = (Message) jsonObjectReader.nextOrNull(iLogger, new Message.Deserializer());
                        break;
                    case 6:
                        Map unused7 = sentryEvent.modules = CollectionUtils.newConcurrentHashMap((Map) jsonObjectReader.nextObjectOrNull());
                        break;
                    case 7:
                        jsonObjectReader.beginObject();
                        jsonObjectReader.nextName();
                        SentryValues unused8 = sentryEvent.exception = new SentryValues(jsonObjectReader.nextListOrNull(iLogger, new SentryException.Deserializer()));
                        jsonObjectReader.endObject();
                        break;
                    case 8:
                        String unused9 = sentryEvent.transaction = jsonObjectReader.nextStringOrNull();
                        break;
                    default:
                        if (!deserializer.deserializeValue(sentryEvent, nextName, jsonObjectReader, iLogger)) {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            jsonObjectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                            break;
                        } else {
                            break;
                        }
                }
            }
            sentryEvent.setUnknown(concurrentHashMap);
            jsonObjectReader.endObject();
            return sentryEvent;
        }
    }
}

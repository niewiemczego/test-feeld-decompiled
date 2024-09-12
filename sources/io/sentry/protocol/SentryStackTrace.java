package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.protocol.SentryStackFrame;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class SentryStackTrace implements JsonUnknown, JsonSerializable {
    /* access modifiers changed from: private */
    public List<SentryStackFrame> frames;
    /* access modifiers changed from: private */
    public Map<String, String> registers;
    /* access modifiers changed from: private */
    public Boolean snapshot;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String FRAMES = "frames";
        public static final String REGISTERS = "registers";
        public static final String SNAPSHOT = "snapshot";
    }

    public SentryStackTrace() {
    }

    public SentryStackTrace(List<SentryStackFrame> list) {
        this.frames = list;
    }

    public List<SentryStackFrame> getFrames() {
        return this.frames;
    }

    public void setFrames(List<SentryStackFrame> list) {
        this.frames = list;
    }

    public Map<String, String> getRegisters() {
        return this.registers;
    }

    public void setRegisters(Map<String, String> map) {
        this.registers = map;
    }

    public Boolean getSnapshot() {
        return this.snapshot;
    }

    public void setSnapshot(Boolean bool) {
        this.snapshot = bool;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.frames != null) {
            objectWriter.name(JsonKeys.FRAMES).value(iLogger, this.frames);
        }
        if (this.registers != null) {
            objectWriter.name(JsonKeys.REGISTERS).value(iLogger, this.registers);
        }
        if (this.snapshot != null) {
            objectWriter.name(JsonKeys.SNAPSHOT).value(this.snapshot);
        }
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

    public static final class Deserializer implements JsonDeserializer<SentryStackTrace> {
        public SentryStackTrace deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            SentryStackTrace sentryStackTrace = new SentryStackTrace();
            jsonObjectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -1266514778:
                        if (nextName.equals(JsonKeys.FRAMES)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 78226992:
                        if (nextName.equals(JsonKeys.REGISTERS)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 284874180:
                        if (nextName.equals(JsonKeys.SNAPSHOT)) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        List unused = sentryStackTrace.frames = jsonObjectReader.nextListOrNull(iLogger, new SentryStackFrame.Deserializer());
                        break;
                    case 1:
                        Map unused2 = sentryStackTrace.registers = CollectionUtils.newConcurrentHashMap((Map) jsonObjectReader.nextObjectOrNull());
                        break;
                    case 2:
                        Boolean unused3 = sentryStackTrace.snapshot = jsonObjectReader.nextBooleanOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                        break;
                }
            }
            sentryStackTrace.setUnknown(concurrentHashMap);
            jsonObjectReader.endObject();
            return sentryStackTrace;
        }
    }
}

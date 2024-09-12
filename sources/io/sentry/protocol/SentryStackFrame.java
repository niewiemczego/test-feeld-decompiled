package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.SentryLockReason;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.CharUtils;

public final class SentryStackFrame implements JsonUnknown, JsonSerializable {
    /* access modifiers changed from: private */
    public Boolean _native;
    /* access modifiers changed from: private */
    public String _package;
    /* access modifiers changed from: private */
    public String absPath;
    /* access modifiers changed from: private */
    public Integer colno;
    /* access modifiers changed from: private */
    public String contextLine;
    /* access modifiers changed from: private */
    public String filename;
    private List<Integer> framesOmitted;
    /* access modifiers changed from: private */
    public String function;
    /* access modifiers changed from: private */
    public String imageAddr;
    /* access modifiers changed from: private */
    public Boolean inApp;
    /* access modifiers changed from: private */
    public String instructionAddr;
    /* access modifiers changed from: private */
    public Integer lineno;
    /* access modifiers changed from: private */
    public SentryLockReason lock;
    /* access modifiers changed from: private */
    public String module;
    /* access modifiers changed from: private */
    public String platform;
    private List<String> postContext;
    private List<String> preContext;
    /* access modifiers changed from: private */
    public String rawFunction;
    /* access modifiers changed from: private */
    public String symbol;
    /* access modifiers changed from: private */
    public String symbolAddr;
    private Map<String, Object> unknown;
    private Map<String, String> vars;

    public static final class JsonKeys {
        public static final String ABS_PATH = "abs_path";
        public static final String COLNO = "colno";
        public static final String CONTEXT_LINE = "context_line";
        public static final String FILENAME = "filename";
        public static final String FUNCTION = "function";
        public static final String IMAGE_ADDR = "image_addr";
        public static final String INSTRUCTION_ADDR = "instruction_addr";
        public static final String IN_APP = "in_app";
        public static final String LINENO = "lineno";
        public static final String LOCK = "lock";
        public static final String MODULE = "module";
        public static final String NATIVE = "native";
        public static final String PACKAGE = "package";
        public static final String PLATFORM = "platform";
        public static final String RAW_FUNCTION = "raw_function";
        public static final String SYMBOL = "symbol";
        public static final String SYMBOL_ADDR = "symbol_addr";
    }

    public List<String> getPreContext() {
        return this.preContext;
    }

    public void setPreContext(List<String> list) {
        this.preContext = list;
    }

    public List<String> getPostContext() {
        return this.postContext;
    }

    public void setPostContext(List<String> list) {
        this.postContext = list;
    }

    public Map<String, String> getVars() {
        return this.vars;
    }

    public void setVars(Map<String, String> map) {
        this.vars = map;
    }

    public List<Integer> getFramesOmitted() {
        return this.framesOmitted;
    }

    public void setFramesOmitted(List<Integer> list) {
        this.framesOmitted = list;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public String getFunction() {
        return this.function;
    }

    public void setFunction(String str) {
        this.function = str;
    }

    public String getModule() {
        return this.module;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public Integer getLineno() {
        return this.lineno;
    }

    public void setLineno(Integer num) {
        this.lineno = num;
    }

    public Integer getColno() {
        return this.colno;
    }

    public void setColno(Integer num) {
        this.colno = num;
    }

    public String getAbsPath() {
        return this.absPath;
    }

    public void setAbsPath(String str) {
        this.absPath = str;
    }

    public String getContextLine() {
        return this.contextLine;
    }

    public void setContextLine(String str) {
        this.contextLine = str;
    }

    public Boolean isInApp() {
        return this.inApp;
    }

    public void setInApp(Boolean bool) {
        this.inApp = bool;
    }

    public String getPackage() {
        return this._package;
    }

    public void setPackage(String str) {
        this._package = str;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public String getImageAddr() {
        return this.imageAddr;
    }

    public void setImageAddr(String str) {
        this.imageAddr = str;
    }

    public String getSymbolAddr() {
        return this.symbolAddr;
    }

    public void setSymbolAddr(String str) {
        this.symbolAddr = str;
    }

    public String getInstructionAddr() {
        return this.instructionAddr;
    }

    public void setInstructionAddr(String str) {
        this.instructionAddr = str;
    }

    public Boolean isNative() {
        return this._native;
    }

    public void setNative(Boolean bool) {
        this._native = bool;
    }

    public String getRawFunction() {
        return this.rawFunction;
    }

    public void setRawFunction(String str) {
        this.rawFunction = str;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public SentryLockReason getLock() {
        return this.lock;
    }

    public void setLock(SentryLockReason sentryLockReason) {
        this.lock = sentryLockReason;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.filename != null) {
            objectWriter.name("filename").value(this.filename);
        }
        if (this.function != null) {
            objectWriter.name(JsonKeys.FUNCTION).value(this.function);
        }
        if (this.module != null) {
            objectWriter.name("module").value(this.module);
        }
        if (this.lineno != null) {
            objectWriter.name(JsonKeys.LINENO).value((Number) this.lineno);
        }
        if (this.colno != null) {
            objectWriter.name(JsonKeys.COLNO).value((Number) this.colno);
        }
        if (this.absPath != null) {
            objectWriter.name(JsonKeys.ABS_PATH).value(this.absPath);
        }
        if (this.contextLine != null) {
            objectWriter.name(JsonKeys.CONTEXT_LINE).value(this.contextLine);
        }
        if (this.inApp != null) {
            objectWriter.name(JsonKeys.IN_APP).value(this.inApp);
        }
        if (this._package != null) {
            objectWriter.name(JsonKeys.PACKAGE).value(this._package);
        }
        if (this._native != null) {
            objectWriter.name("native").value(this._native);
        }
        if (this.platform != null) {
            objectWriter.name("platform").value(this.platform);
        }
        if (this.imageAddr != null) {
            objectWriter.name("image_addr").value(this.imageAddr);
        }
        if (this.symbolAddr != null) {
            objectWriter.name(JsonKeys.SYMBOL_ADDR).value(this.symbolAddr);
        }
        if (this.instructionAddr != null) {
            objectWriter.name(JsonKeys.INSTRUCTION_ADDR).value(this.instructionAddr);
        }
        if (this.rawFunction != null) {
            objectWriter.name(JsonKeys.RAW_FUNCTION).value(this.rawFunction);
        }
        if (this.symbol != null) {
            objectWriter.name(JsonKeys.SYMBOL).value(this.symbol);
        }
        if (this.lock != null) {
            objectWriter.name(JsonKeys.LOCK).value(iLogger, this.lock);
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

    public static final class Deserializer implements JsonDeserializer<SentryStackFrame> {
        public SentryStackFrame deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            SentryStackFrame sentryStackFrame = new SentryStackFrame();
            jsonObjectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -1443345323:
                        if (nextName.equals("image_addr")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1184392185:
                        if (nextName.equals(JsonKeys.IN_APP)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1113875953:
                        if (nextName.equals(JsonKeys.RAW_FUNCTION)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1102671691:
                        if (nextName.equals(JsonKeys.LINENO)) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1068784020:
                        if (nextName.equals("module")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1052618729:
                        if (nextName.equals("native")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -887523944:
                        if (nextName.equals(JsonKeys.SYMBOL)) {
                            c = 6;
                            break;
                        }
                        break;
                    case -807062458:
                        if (nextName.equals(JsonKeys.PACKAGE)) {
                            c = 7;
                            break;
                        }
                        break;
                    case -734768633:
                        if (nextName.equals("filename")) {
                            c = 8;
                            break;
                        }
                        break;
                    case -330260936:
                        if (nextName.equals(JsonKeys.SYMBOL_ADDR)) {
                            c = 9;
                            break;
                        }
                        break;
                    case 3327275:
                        if (nextName.equals(JsonKeys.LOCK)) {
                            c = 10;
                            break;
                        }
                        break;
                    case 94842689:
                        if (nextName.equals(JsonKeys.COLNO)) {
                            c = 11;
                            break;
                        }
                        break;
                    case 410194178:
                        if (nextName.equals(JsonKeys.INSTRUCTION_ADDR)) {
                            c = 12;
                            break;
                        }
                        break;
                    case 1116694660:
                        if (nextName.equals(JsonKeys.CONTEXT_LINE)) {
                            c = CharUtils.CR;
                            break;
                        }
                        break;
                    case 1380938712:
                        if (nextName.equals(JsonKeys.FUNCTION)) {
                            c = 14;
                            break;
                        }
                        break;
                    case 1713445842:
                        if (nextName.equals(JsonKeys.ABS_PATH)) {
                            c = 15;
                            break;
                        }
                        break;
                    case 1874684019:
                        if (nextName.equals("platform")) {
                            c = 16;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        String unused = sentryStackFrame.imageAddr = jsonObjectReader.nextStringOrNull();
                        break;
                    case 1:
                        Boolean unused2 = sentryStackFrame.inApp = jsonObjectReader.nextBooleanOrNull();
                        break;
                    case 2:
                        String unused3 = sentryStackFrame.rawFunction = jsonObjectReader.nextStringOrNull();
                        break;
                    case 3:
                        Integer unused4 = sentryStackFrame.lineno = jsonObjectReader.nextIntegerOrNull();
                        break;
                    case 4:
                        String unused5 = sentryStackFrame.module = jsonObjectReader.nextStringOrNull();
                        break;
                    case 5:
                        Boolean unused6 = sentryStackFrame._native = jsonObjectReader.nextBooleanOrNull();
                        break;
                    case 6:
                        String unused7 = sentryStackFrame.symbol = jsonObjectReader.nextStringOrNull();
                        break;
                    case 7:
                        String unused8 = sentryStackFrame._package = jsonObjectReader.nextStringOrNull();
                        break;
                    case 8:
                        String unused9 = sentryStackFrame.filename = jsonObjectReader.nextStringOrNull();
                        break;
                    case 9:
                        String unused10 = sentryStackFrame.symbolAddr = jsonObjectReader.nextStringOrNull();
                        break;
                    case 10:
                        SentryLockReason unused11 = sentryStackFrame.lock = (SentryLockReason) jsonObjectReader.nextOrNull(iLogger, new SentryLockReason.Deserializer());
                        break;
                    case 11:
                        Integer unused12 = sentryStackFrame.colno = jsonObjectReader.nextIntegerOrNull();
                        break;
                    case 12:
                        String unused13 = sentryStackFrame.instructionAddr = jsonObjectReader.nextStringOrNull();
                        break;
                    case 13:
                        String unused14 = sentryStackFrame.contextLine = jsonObjectReader.nextStringOrNull();
                        break;
                    case 14:
                        String unused15 = sentryStackFrame.function = jsonObjectReader.nextStringOrNull();
                        break;
                    case 15:
                        String unused16 = sentryStackFrame.absPath = jsonObjectReader.nextStringOrNull();
                        break;
                    case 16:
                        String unused17 = sentryStackFrame.platform = jsonObjectReader.nextStringOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                        break;
                }
            }
            sentryStackFrame.setUnknown(concurrentHashMap);
            jsonObjectReader.endObject();
            return sentryStackFrame;
        }
    }
}

package com.launchdarkly.sdk.json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.launchdarkly.sdk.LDValue;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public abstract class LDGson {
    private static final JsonElement JSONELEMENT_FALSE = new JsonPrimitive((Boolean) false);
    private static final JsonElement JSONELEMENT_TRUE = new JsonPrimitive((Boolean) true);

    private LDGson() {
    }

    public static TypeAdapterFactory typeAdapters() {
        return LDTypeAdapterFactory.INSTANCE;
    }

    public static JsonElement valueToJsonElement(LDValue lDValue) {
        if (lDValue == null) {
            return JsonNull.INSTANCE;
        }
        int i = AnonymousClass1.$SwitchMap$com$launchdarkly$sdk$LDValueType[lDValue.getType().ordinal()];
        if (i == 1) {
            return lDValue.booleanValue() ? JSONELEMENT_TRUE : JSONELEMENT_FALSE;
        }
        if (i == 2) {
            return new JsonPrimitive((Number) Double.valueOf(lDValue.doubleValue()));
        }
        if (i == 3) {
            return lDValue.stringValue() == null ? JsonNull.INSTANCE : new JsonPrimitive(lDValue.stringValue());
        }
        if (i == 4) {
            JsonArray jsonArray = new JsonArray();
            for (LDValue valueToJsonElement : lDValue.values()) {
                jsonArray.add(valueToJsonElement(valueToJsonElement));
            }
            return jsonArray;
        } else if (i != 5) {
            return JsonNull.INSTANCE;
        } else {
            JsonObject jsonObject = new JsonObject();
            for (String next : lDValue.keys()) {
                jsonObject.add(next, valueToJsonElement(lDValue.get(next)));
            }
            return jsonObject;
        }
    }

    /* renamed from: com.launchdarkly.sdk.json.LDGson$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$launchdarkly$sdk$LDValueType;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.launchdarkly.sdk.LDValueType[] r0 = com.launchdarkly.sdk.LDValueType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$launchdarkly$sdk$LDValueType = r0
                com.launchdarkly.sdk.LDValueType r1 = com.launchdarkly.sdk.LDValueType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$LDValueType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.launchdarkly.sdk.LDValueType r1 = com.launchdarkly.sdk.LDValueType.NUMBER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$LDValueType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.launchdarkly.sdk.LDValueType r1 = com.launchdarkly.sdk.LDValueType.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$LDValueType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.launchdarkly.sdk.LDValueType r1 = com.launchdarkly.sdk.LDValueType.ARRAY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$LDValueType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.launchdarkly.sdk.LDValueType r1 = com.launchdarkly.sdk.LDValueType.OBJECT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.json.LDGson.AnonymousClass1.<clinit>():void");
        }
    }

    public static <T> Map<T, JsonElement> valueMapToJsonElementMap(Map<T, LDValue> map) {
        HashMap hashMap = new HashMap(map.size());
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(next.getKey(), valueToJsonElement((LDValue) next.getValue()));
        }
        return hashMap;
    }

    private static class LDTypeAdapterFactory implements TypeAdapterFactory {
        /* access modifiers changed from: private */
        public static LDTypeAdapterFactory INSTANCE = new LDTypeAdapterFactory();

        private LDTypeAdapterFactory() {
        }

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (JsonSerializable.class.isAssignableFrom(typeToken.getRawType())) {
                return new LDTypeAdapter(typeToken.getType());
            }
            return null;
        }
    }

    private static class LDTypeAdapter<T> extends TypeAdapter<T> {
        private final Type objectType;

        LDTypeAdapter(Type type) {
            this.objectType = type;
        }

        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
            } else {
                JsonSerialization.serializeToGsonInternal(t, t.getClass(), new DelegatingJsonWriterAdapter(jsonWriter));
            }
        }

        public T read(JsonReader jsonReader) throws IOException {
            return JsonSerialization.deserializeFromGsonInternal(new DelegatingJsonReaderAdapter(jsonReader), this.objectType);
        }
    }

    static class DelegatingJsonReaderAdapter extends GsonReaderAdapter {
        private final JsonReader reader;

        DelegatingJsonReaderAdapter(JsonReader jsonReader) {
            this.reader = jsonReader;
        }

        public void beginArray() throws IOException {
            this.reader.beginArray();
        }

        public void beginObject() throws IOException {
            this.reader.beginObject();
        }

        public void endArray() throws IOException {
            this.reader.endArray();
        }

        public void endObject() throws IOException {
            this.reader.endObject();
        }

        public boolean hasNext() throws IOException {
            return this.reader.hasNext();
        }

        public boolean nextBoolean() throws IOException {
            return this.reader.nextBoolean();
        }

        public double nextDouble() throws IOException {
            return this.reader.nextDouble();
        }

        public int nextInt() throws IOException {
            return this.reader.nextInt();
        }

        public long nextLong() throws IOException {
            return this.reader.nextLong();
        }

        public String nextName() throws IOException {
            return this.reader.nextName();
        }

        public void nextNull() throws IOException {
            this.reader.nextNull();
        }

        public String nextString() throws IOException {
            return this.reader.nextString();
        }

        public void skipValue() throws IOException {
            this.reader.skipValue();
        }

        /* access modifiers changed from: protected */
        public int peekInternal() throws IOException {
            return this.reader.peek().ordinal();
        }
    }

    static class DelegatingJsonWriterAdapter extends GsonWriterAdapter {
        private final JsonWriter writer;

        DelegatingJsonWriterAdapter(JsonWriter jsonWriter) {
            this.writer = jsonWriter;
        }

        /* access modifiers changed from: protected */
        public void beginArrayInternal() throws IOException {
            this.writer.beginArray();
        }

        /* access modifiers changed from: protected */
        public void beginObjectInternal() throws IOException {
            this.writer.beginObject();
        }

        /* access modifiers changed from: protected */
        public void endArrayInternal() throws IOException {
            this.writer.endArray();
        }

        /* access modifiers changed from: protected */
        public void endObjectInternal() throws IOException {
            this.writer.endObject();
        }

        /* access modifiers changed from: protected */
        public void jsonValueInternal(String str) throws IOException {
            this.writer.jsonValue(str);
        }

        /* access modifiers changed from: protected */
        public void nameInternal(String str) throws IOException {
            this.writer.name(str);
        }

        /* access modifiers changed from: protected */
        public void valueInternalNull() throws IOException {
            this.writer.nullValue();
        }

        /* access modifiers changed from: protected */
        public void valueInternalBool(boolean z) throws IOException {
            this.writer.value(z);
        }

        /* access modifiers changed from: protected */
        public void valueInternalDouble(double d) throws IOException {
            this.writer.value(d);
        }

        /* access modifiers changed from: protected */
        public void valueInternalLong(long j) throws IOException {
            this.writer.value(j);
        }

        /* access modifiers changed from: protected */
        public void valueInternalString(String str) throws IOException {
            this.writer.value(str);
        }
    }
}

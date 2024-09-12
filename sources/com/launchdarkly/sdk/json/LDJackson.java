package com.launchdarkly.sdk.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.JsonParseException;
import java.io.IOException;

public class LDJackson {
    private LDJackson() {
    }

    public static Module module() {
        SimpleModule simpleModule = new SimpleModule(LDJackson.class.getName());
        simpleModule.addSerializer(JsonSerializable.class, LDJacksonSerializer.INSTANCE);
        for (Class next : JsonSerialization.getDeserializableClasses()) {
            simpleModule.addDeserializer(next, new LDJacksonDeserializer(next));
        }
        return simpleModule;
    }

    private static class LDJacksonSerializer extends JsonSerializer<JsonSerializable> {
        static final LDJacksonSerializer INSTANCE = new LDJacksonSerializer();

        private LDJacksonSerializer() {
        }

        public void serialize(JsonSerializable jsonSerializable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            GsonWriterToJacksonGeneratorAdapter gsonWriterToJacksonGeneratorAdapter = new GsonWriterToJacksonGeneratorAdapter(jsonGenerator);
            try {
                JsonSerialization.serializeToGsonInternal(jsonSerializable, jsonSerializable.getClass(), gsonWriterToJacksonGeneratorAdapter);
                gsonWriterToJacksonGeneratorAdapter.close();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }
    }

    private static class LDJacksonDeserializer<T extends JsonSerializable> extends JsonDeserializer<T> {
        private final Class<T> objectClass;

        LDJacksonDeserializer(Class<T> cls) {
            this.objectClass = cls;
        }

        public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            GsonReaderToJacksonParserAdapter gsonReaderToJacksonParserAdapter = new GsonReaderToJacksonParserAdapter(jsonParser);
            try {
                T t = (JsonSerializable) JsonSerialization.deserializeFromGsonInternal(gsonReaderToJacksonParserAdapter, this.objectClass);
                gsonReaderToJacksonParserAdapter.close();
                return t;
            } catch (JsonParseException e) {
                throw new com.fasterxml.jackson.core.JsonParseException(jsonParser, e.getMessage());
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }
    }

    static class GsonReaderToJacksonParserAdapter extends GsonReaderAdapter {
        private boolean atToken = true;
        private final JsonParser parser;

        GsonReaderToJacksonParserAdapter(JsonParser jsonParser) {
            this.parser = jsonParser;
        }

        public void beginArray() throws IOException {
            requireToken(JsonToken.START_ARRAY, JsonToken.START_ARRAY, "array");
        }

        public void beginObject() throws IOException {
            requireToken(JsonToken.START_OBJECT, JsonToken.START_OBJECT, "object");
        }

        public void endArray() throws IOException {
            requireToken(JsonToken.END_ARRAY, JsonToken.END_ARRAY, "end of array");
        }

        public void endObject() throws IOException {
            requireToken(JsonToken.END_OBJECT, JsonToken.END_OBJECT, "end of object");
        }

        public boolean hasNext() throws IOException {
            JsonToken peekToken = peekToken();
            return (peekToken == JsonToken.END_ARRAY || peekToken == JsonToken.END_OBJECT) ? false : true;
        }

        public boolean nextBoolean() throws IOException {
            requireToken(JsonToken.VALUE_FALSE, JsonToken.VALUE_TRUE, "boolean");
            return this.parser.getBooleanValue();
        }

        public double nextDouble() throws IOException {
            requireToken(JsonToken.VALUE_NUMBER_FLOAT, JsonToken.VALUE_NUMBER_INT, "number");
            return this.parser.getDoubleValue();
        }

        public int nextInt() throws IOException {
            requireToken(JsonToken.VALUE_NUMBER_FLOAT, JsonToken.VALUE_NUMBER_INT, "number");
            return this.parser.getIntValue();
        }

        public long nextLong() throws IOException {
            requireToken(JsonToken.VALUE_NUMBER_FLOAT, JsonToken.VALUE_NUMBER_INT, "number");
            return this.parser.getLongValue();
        }

        public String nextName() throws IOException {
            requireToken(JsonToken.FIELD_NAME, JsonToken.FIELD_NAME, "property name");
            return this.parser.getCurrentName();
        }

        public void nextNull() throws IOException {
            requireToken(JsonToken.VALUE_NULL, JsonToken.VALUE_NULL, "null");
        }

        public String nextString() throws IOException {
            requireToken(JsonToken.VALUE_STRING, JsonToken.VALUE_NULL, "string");
            return this.parser.getValueAsString();
        }

        public void skipValue() throws IOException {
            consumeToken();
            this.parser.skipChildren();
        }

        /* access modifiers changed from: protected */
        public int peekInternal() throws IOException {
            com.google.gson.stream.JsonToken jsonToken;
            JsonToken peekToken = peekToken();
            if (peekToken == null) {
                return com.google.gson.stream.JsonToken.END_DOCUMENT.ordinal();
            }
            switch (AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[peekToken.ordinal()]) {
                case 1:
                    jsonToken = com.google.gson.stream.JsonToken.END_ARRAY;
                    break;
                case 2:
                    jsonToken = com.google.gson.stream.JsonToken.END_OBJECT;
                    break;
                case 3:
                    jsonToken = com.google.gson.stream.JsonToken.NAME;
                    break;
                case 4:
                    jsonToken = com.google.gson.stream.JsonToken.END_DOCUMENT;
                    break;
                case 5:
                    jsonToken = com.google.gson.stream.JsonToken.BEGIN_ARRAY;
                    break;
                case 6:
                    jsonToken = com.google.gson.stream.JsonToken.BEGIN_OBJECT;
                    break;
                case 7:
                    jsonToken = com.google.gson.stream.JsonToken.BOOLEAN;
                    break;
                case 8:
                    jsonToken = com.google.gson.stream.JsonToken.NULL;
                    break;
                case 9:
                    jsonToken = com.google.gson.stream.JsonToken.NUMBER;
                    break;
                case 10:
                    jsonToken = com.google.gson.stream.JsonToken.NUMBER;
                    break;
                case 11:
                    jsonToken = com.google.gson.stream.JsonToken.STRING;
                    break;
                case 12:
                    jsonToken = com.google.gson.stream.JsonToken.BOOLEAN;
                    break;
                default:
                    jsonToken = com.google.gson.stream.JsonToken.END_DOCUMENT;
                    break;
            }
            return jsonToken.ordinal();
        }

        private void requireToken(JsonToken jsonToken, JsonToken jsonToken2, String str) throws IOException {
            JsonToken consumeToken = consumeToken();
            if (consumeToken != jsonToken && consumeToken != jsonToken2) {
                throw new com.fasterxml.jackson.core.JsonParseException(this.parser, "expected " + str);
            }
        }

        private JsonToken peekToken() throws IOException {
            if (this.atToken) {
                return this.parser.currentToken();
            }
            this.atToken = true;
            return this.parser.nextToken();
        }

        private JsonToken consumeToken() throws IOException {
            if (!this.atToken) {
                return this.parser.nextToken();
            }
            this.atToken = false;
            return this.parser.currentToken();
        }
    }

    /* renamed from: com.launchdarkly.sdk.json.LDJackson$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$core$JsonToken;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.fasterxml.jackson.core.JsonToken[] r0 = com.fasterxml.jackson.core.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$fasterxml$jackson$core$JsonToken = r0
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.END_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$core$JsonToken     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$core$JsonToken     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.FIELD_NAME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$core$JsonToken     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.NOT_AVAILABLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$core$JsonToken     // Catch:{ NoSuchFieldError -> 0x003e }
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.START_ARRAY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$core$JsonToken     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.START_OBJECT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$core$JsonToken     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.VALUE_FALSE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$core$JsonToken     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$core$JsonToken     // Catch:{ NoSuchFieldError -> 0x006c }
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_FLOAT     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$core$JsonToken     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$core$JsonToken     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$core$JsonToken     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.VALUE_TRUE     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.json.LDJackson.AnonymousClass1.<clinit>():void");
        }
    }

    static class GsonWriterToJacksonGeneratorAdapter extends GsonWriterAdapter {
        private final JsonGenerator gen;

        GsonWriterToJacksonGeneratorAdapter(JsonGenerator jsonGenerator) {
            this.gen = jsonGenerator;
        }

        /* access modifiers changed from: protected */
        public void beginArrayInternal() throws IOException {
            this.gen.writeStartArray();
        }

        /* access modifiers changed from: protected */
        public void beginObjectInternal() throws IOException {
            this.gen.writeStartObject();
        }

        /* access modifiers changed from: protected */
        public void endArrayInternal() throws IOException {
            this.gen.writeEndArray();
        }

        /* access modifiers changed from: protected */
        public void endObjectInternal() throws IOException {
            this.gen.writeEndObject();
        }

        /* access modifiers changed from: protected */
        public void jsonValueInternal(String str) throws IOException {
            this.gen.writeRawValue(str);
        }

        /* access modifiers changed from: protected */
        public void nameInternal(String str) throws IOException {
            this.gen.writeFieldName(str);
        }

        /* access modifiers changed from: protected */
        public void valueInternalNull() throws IOException {
            this.gen.writeNull();
        }

        /* access modifiers changed from: protected */
        public void valueInternalBool(boolean z) throws IOException {
            this.gen.writeBoolean(z);
        }

        /* access modifiers changed from: protected */
        public void valueInternalDouble(double d) throws IOException {
            this.gen.writeNumber(d);
        }

        /* access modifiers changed from: protected */
        public void valueInternalLong(long j) throws IOException {
            this.gen.writeNumber(j);
        }

        /* access modifiers changed from: protected */
        public void valueInternalString(String str) throws IOException {
            this.gen.writeString(str);
        }
    }
}

package com.squareup.moshi;

import com.squareup.moshi.JsonReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSource;

final class JsonValueReader extends JsonReader {
    private static final Object JSON_READER_CLOSED = new Object();
    private Object[] stack;

    JsonValueReader(Object obj) {
        this.scopes[this.stackSize] = 7;
        Object[] objArr = new Object[32];
        this.stack = objArr;
        int i = this.stackSize;
        this.stackSize = i + 1;
        objArr[i] = obj;
    }

    JsonValueReader(JsonValueReader jsonValueReader) {
        super(jsonValueReader);
        this.stack = (Object[]) jsonValueReader.stack.clone();
        for (int i = 0; i < this.stackSize; i++) {
            Object[] objArr = this.stack;
            Object obj = objArr[i];
            if (obj instanceof JsonIterator) {
                objArr[i] = ((JsonIterator) obj).clone();
            }
        }
    }

    public void beginArray() throws IOException {
        List list = (List) require(List.class, JsonReader.Token.BEGIN_ARRAY);
        JsonIterator jsonIterator = new JsonIterator(JsonReader.Token.END_ARRAY, list.toArray(new Object[list.size()]), 0);
        this.stack[this.stackSize - 1] = jsonIterator;
        this.scopes[this.stackSize - 1] = 1;
        this.pathIndices[this.stackSize - 1] = 0;
        if (jsonIterator.hasNext()) {
            push(jsonIterator.next());
        }
    }

    public void endArray() throws IOException {
        JsonIterator jsonIterator = (JsonIterator) require(JsonIterator.class, JsonReader.Token.END_ARRAY);
        if (jsonIterator.endToken != JsonReader.Token.END_ARRAY || jsonIterator.hasNext()) {
            throw typeMismatch(jsonIterator, JsonReader.Token.END_ARRAY);
        }
        remove();
    }

    public void beginObject() throws IOException {
        Map map = (Map) require(Map.class, JsonReader.Token.BEGIN_OBJECT);
        JsonIterator jsonIterator = new JsonIterator(JsonReader.Token.END_OBJECT, map.entrySet().toArray(new Object[map.size()]), 0);
        this.stack[this.stackSize - 1] = jsonIterator;
        this.scopes[this.stackSize - 1] = 3;
        if (jsonIterator.hasNext()) {
            push(jsonIterator.next());
        }
    }

    public void endObject() throws IOException {
        JsonIterator jsonIterator = (JsonIterator) require(JsonIterator.class, JsonReader.Token.END_OBJECT);
        if (jsonIterator.endToken != JsonReader.Token.END_OBJECT || jsonIterator.hasNext()) {
            throw typeMismatch(jsonIterator, JsonReader.Token.END_OBJECT);
        }
        this.pathNames[this.stackSize - 1] = null;
        remove();
    }

    public boolean hasNext() throws IOException {
        if (this.stackSize == 0) {
            return false;
        }
        Object obj = this.stack[this.stackSize - 1];
        if (!(obj instanceof Iterator) || ((Iterator) obj).hasNext()) {
            return true;
        }
        return false;
    }

    public JsonReader.Token peek() throws IOException {
        if (this.stackSize == 0) {
            return JsonReader.Token.END_DOCUMENT;
        }
        Object obj = this.stack[this.stackSize - 1];
        if (obj instanceof JsonIterator) {
            return ((JsonIterator) obj).endToken;
        }
        if (obj instanceof List) {
            return JsonReader.Token.BEGIN_ARRAY;
        }
        if (obj instanceof Map) {
            return JsonReader.Token.BEGIN_OBJECT;
        }
        if (obj instanceof Map.Entry) {
            return JsonReader.Token.NAME;
        }
        if (obj instanceof String) {
            return JsonReader.Token.STRING;
        }
        if (obj instanceof Boolean) {
            return JsonReader.Token.BOOLEAN;
        }
        if (obj instanceof Number) {
            return JsonReader.Token.NUMBER;
        }
        if (obj == null) {
            return JsonReader.Token.NULL;
        }
        if (obj == JSON_READER_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw typeMismatch(obj, "a JSON value");
    }

    public String nextName() throws IOException {
        Map.Entry entry = (Map.Entry) require(Map.Entry.class, JsonReader.Token.NAME);
        String stringKey = stringKey(entry);
        this.stack[this.stackSize - 1] = entry.getValue();
        this.pathNames[this.stackSize - 2] = stringKey;
        return stringKey;
    }

    public int selectName(JsonReader.Options options) throws IOException {
        Map.Entry entry = (Map.Entry) require(Map.Entry.class, JsonReader.Token.NAME);
        String stringKey = stringKey(entry);
        int length = options.strings.length;
        for (int i = 0; i < length; i++) {
            if (options.strings[i].equals(stringKey)) {
                this.stack[this.stackSize - 1] = entry.getValue();
                this.pathNames[this.stackSize - 2] = stringKey;
                return i;
            }
        }
        return -1;
    }

    public void skipName() throws IOException {
        if (!this.failOnUnknown) {
            this.stack[this.stackSize - 1] = ((Map.Entry) require(Map.Entry.class, JsonReader.Token.NAME)).getValue();
            this.pathNames[this.stackSize - 2] = "null";
            return;
        }
        JsonReader.Token peek = peek();
        nextName();
        throw new JsonDataException("Cannot skip unexpected " + peek + " at " + getPath());
    }

    public String nextString() throws IOException {
        String str = this.stackSize != 0 ? this.stack[this.stackSize - 1] : null;
        if (str instanceof String) {
            remove();
            return str;
        } else if (str instanceof Number) {
            remove();
            return str.toString();
        } else if (str == JSON_READER_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
        } else {
            throw typeMismatch(str, JsonReader.Token.STRING);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int selectString(com.squareup.moshi.JsonReader.Options r6) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.stackSize
            if (r0 == 0) goto L_0x000d
            java.lang.Object[] r0 = r5.stack
            int r1 = r5.stackSize
            int r1 = r1 + -1
            r0 = r0[r1]
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            boolean r1 = r0 instanceof java.lang.String
            r2 = -1
            if (r1 != 0) goto L_0x0020
            java.lang.Object r6 = JSON_READER_CLOSED
            if (r0 == r6) goto L_0x0018
            return r2
        L_0x0018:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "JsonReader is closed"
            r6.<init>(r0)
            throw r6
        L_0x0020:
            java.lang.String r0 = (java.lang.String) r0
            r1 = 0
            java.lang.String[] r3 = r6.strings
            int r3 = r3.length
        L_0x0026:
            if (r1 >= r3) goto L_0x0039
            java.lang.String[] r4 = r6.strings
            r4 = r4[r1]
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0036
            r5.remove()
            return r1
        L_0x0036:
            int r1 = r1 + 1
            goto L_0x0026
        L_0x0039:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonValueReader.selectString(com.squareup.moshi.JsonReader$Options):int");
    }

    public boolean nextBoolean() throws IOException {
        remove();
        return ((Boolean) require(Boolean.class, JsonReader.Token.BOOLEAN)).booleanValue();
    }

    @Nullable
    public <T> T nextNull() throws IOException {
        require(Void.class, JsonReader.Token.NULL);
        remove();
        return null;
    }

    public double nextDouble() throws IOException {
        double d;
        Object require = require(Object.class, JsonReader.Token.NUMBER);
        if (require instanceof Number) {
            d = ((Number) require).doubleValue();
        } else if (require instanceof String) {
            try {
                d = Double.parseDouble((String) require);
            } catch (NumberFormatException unused) {
                throw typeMismatch(require, JsonReader.Token.NUMBER);
            }
        } else {
            throw typeMismatch(require, JsonReader.Token.NUMBER);
        }
        if (this.lenient || (!Double.isNaN(d) && !Double.isInfinite(d))) {
            remove();
            return d;
        }
        throw new JsonEncodingException("JSON forbids NaN and infinities: " + d + " at path " + getPath());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        throw typeMismatch(r0, com.squareup.moshi.JsonReader.Token.NUMBER);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r0 = new java.math.BigDecimal((java.lang.String) r0).longValueExact();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long nextLong() throws java.io.IOException {
        /*
            r3 = this;
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER
            java.lang.Object r0 = r3.require(r0, r1)
            boolean r1 = r0 instanceof java.lang.Number
            if (r1 == 0) goto L_0x0013
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
            goto L_0x002b
        L_0x0013:
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L_0x0036
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NumberFormatException -> 0x001f }
            long r0 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x001f }
            goto L_0x002b
        L_0x001f:
            java.math.BigDecimal r1 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x002f }
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ NumberFormatException -> 0x002f }
            r1.<init>(r2)     // Catch:{ NumberFormatException -> 0x002f }
            long r0 = r1.longValueExact()     // Catch:{ NumberFormatException -> 0x002f }
        L_0x002b:
            r3.remove()
            return r0
        L_0x002f:
            com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER
            com.squareup.moshi.JsonDataException r0 = r3.typeMismatch(r0, r1)
            throw r0
        L_0x0036:
            com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER
            com.squareup.moshi.JsonDataException r0 = r3.typeMismatch(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonValueReader.nextLong():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        throw typeMismatch(r0, com.squareup.moshi.JsonReader.Token.NUMBER);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r0 = new java.math.BigDecimal((java.lang.String) r0).intValueExact();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int nextInt() throws java.io.IOException {
        /*
            r3 = this;
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER
            java.lang.Object r0 = r3.require(r0, r1)
            boolean r1 = r0 instanceof java.lang.Number
            if (r1 == 0) goto L_0x0013
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            goto L_0x002b
        L_0x0013:
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L_0x0036
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NumberFormatException -> 0x001f }
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x001f }
            goto L_0x002b
        L_0x001f:
            java.math.BigDecimal r1 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x002f }
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ NumberFormatException -> 0x002f }
            r1.<init>(r2)     // Catch:{ NumberFormatException -> 0x002f }
            int r0 = r1.intValueExact()     // Catch:{ NumberFormatException -> 0x002f }
        L_0x002b:
            r3.remove()
            return r0
        L_0x002f:
            com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER
            com.squareup.moshi.JsonDataException r0 = r3.typeMismatch(r0, r1)
            throw r0
        L_0x0036:
            com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER
            com.squareup.moshi.JsonDataException r0 = r3.typeMismatch(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonValueReader.nextInt():int");
    }

    public void skipValue() throws IOException {
        if (!this.failOnUnknown) {
            if (this.stackSize > 1) {
                this.pathNames[this.stackSize - 2] = "null";
            }
            Object obj = this.stackSize != 0 ? this.stack[this.stackSize - 1] : null;
            if (obj instanceof JsonIterator) {
                throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
            } else if (obj instanceof Map.Entry) {
                this.stack[this.stackSize - 1] = ((Map.Entry) this.stack[this.stackSize - 1]).getValue();
            } else if (this.stackSize > 0) {
                remove();
            } else {
                throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
            }
        } else {
            throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
        }
    }

    public BufferedSource nextSource() throws IOException {
        Object readJsonValue = readJsonValue();
        Buffer buffer = new Buffer();
        JsonWriter of = JsonWriter.of(buffer);
        try {
            of.jsonValue(readJsonValue);
            if (of != null) {
                of.close();
            }
            return buffer;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public JsonReader peekJson() {
        return new JsonValueReader(this);
    }

    public void promoteNameToValue() throws IOException {
        if (hasNext()) {
            push(nextName());
        }
    }

    public void close() throws IOException {
        Arrays.fill(this.stack, 0, this.stackSize, (Object) null);
        this.stack[0] = JSON_READER_CLOSED;
        this.scopes[0] = 8;
        this.stackSize = 1;
    }

    private void push(Object obj) {
        if (this.stackSize == this.stack.length) {
            if (this.stackSize != 256) {
                this.scopes = Arrays.copyOf(this.scopes, this.scopes.length * 2);
                this.pathNames = (String[]) Arrays.copyOf(this.pathNames, this.pathNames.length * 2);
                this.pathIndices = Arrays.copyOf(this.pathIndices, this.pathIndices.length * 2);
                Object[] objArr = this.stack;
                this.stack = Arrays.copyOf(objArr, objArr.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        Object[] objArr2 = this.stack;
        int i = this.stackSize;
        this.stackSize = i + 1;
        objArr2[i] = obj;
    }

    @Nullable
    private <T> T require(Class<T> cls, JsonReader.Token token) throws IOException {
        Object obj = this.stackSize != 0 ? this.stack[this.stackSize - 1] : null;
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        if (obj == null && token == JsonReader.Token.NULL) {
            return null;
        }
        if (obj == JSON_READER_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw typeMismatch(obj, token);
    }

    private String stringKey(Map.Entry<?, ?> entry) {
        Object key = entry.getKey();
        if (key instanceof String) {
            return (String) key;
        }
        throw typeMismatch(key, JsonReader.Token.NAME);
    }

    private void remove() {
        this.stackSize--;
        this.stack[this.stackSize] = null;
        this.scopes[this.stackSize] = 0;
        if (this.stackSize > 0) {
            int[] iArr = this.pathIndices;
            int i = this.stackSize - 1;
            iArr[i] = iArr[i] + 1;
            Object obj = this.stack[this.stackSize - 1];
            if (obj instanceof Iterator) {
                Iterator it = (Iterator) obj;
                if (it.hasNext()) {
                    push(it.next());
                }
            }
        }
    }

    static final class JsonIterator implements Iterator<Object>, Cloneable {
        final Object[] array;
        final JsonReader.Token endToken;
        int next;

        JsonIterator(JsonReader.Token token, Object[] objArr, int i) {
            this.endToken = token;
            this.array = objArr;
            this.next = i;
        }

        public boolean hasNext() {
            return this.next < this.array.length;
        }

        public Object next() {
            Object[] objArr = this.array;
            int i = this.next;
            this.next = i + 1;
            return objArr[i];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        public JsonIterator clone() {
            return new JsonIterator(this.endToken, this.array, this.next);
        }
    }
}

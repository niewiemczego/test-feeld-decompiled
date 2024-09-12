package io.sentry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public final class JsonObjectDeserializer {
    private final ArrayList<Token> tokens = new ArrayList<>();

    private interface NextValue {
        Object nextValue() throws IOException;
    }

    private interface Token {
        Object getValue();
    }

    static /* synthetic */ Object lambda$parse$3() throws IOException {
        return null;
    }

    private static final class TokenName implements Token {
        final String value;

        TokenName(String str) {
            this.value = str;
        }

        public Object getValue() {
            return this.value;
        }
    }

    private static final class TokenPrimitive implements Token {
        final Object value;

        TokenPrimitive(Object obj) {
            this.value = obj;
        }

        public Object getValue() {
            return this.value;
        }
    }

    private static final class TokenArray implements Token {
        final ArrayList<Object> value;

        private TokenArray() {
            this.value = new ArrayList<>();
        }

        /* synthetic */ TokenArray(AnonymousClass1 r1) {
            this();
        }

        public Object getValue() {
            return this.value;
        }
    }

    private static final class TokenMap implements Token {
        final HashMap<String, Object> value;

        private TokenMap() {
            this.value = new HashMap<>();
        }

        /* synthetic */ TokenMap(AnonymousClass1 r1) {
            this();
        }

        public Object getValue() {
            return this.value;
        }
    }

    public Object deserialize(JsonObjectReader jsonObjectReader) throws IOException {
        parse(jsonObjectReader);
        Token currentToken = getCurrentToken();
        if (currentToken != null) {
            return currentToken.getValue();
        }
        return null;
    }

    /* renamed from: io.sentry.JsonObjectDeserializer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$sentry$vendor$gson$stream$JsonToken;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.sentry.vendor.gson.stream.JsonToken[] r0 = io.sentry.vendor.gson.stream.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$sentry$vendor$gson$stream$JsonToken = r0
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$sentry$vendor$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x001d }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.END_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$sentry$vendor$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$sentry$vendor$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$sentry$vendor$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x003e }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.NAME     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$io$sentry$vendor$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.STRING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$io$sentry$vendor$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.NUMBER     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$io$sentry$vendor$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x0060 }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$io$sentry$vendor$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x006c }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.NULL     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$io$sentry$vendor$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x0078 }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.END_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.JsonObjectDeserializer.AnonymousClass1.<clinit>():void");
        }
    }

    private void parse(JsonObjectReader jsonObjectReader) throws IOException {
        boolean z;
        switch (AnonymousClass1.$SwitchMap$io$sentry$vendor$gson$stream$JsonToken[jsonObjectReader.peek().ordinal()]) {
            case 1:
                jsonObjectReader.beginArray();
                pushCurrentToken(new TokenArray((AnonymousClass1) null));
                break;
            case 2:
                jsonObjectReader.endArray();
                z = handleArrayOrMapEnd();
                break;
            case 3:
                jsonObjectReader.beginObject();
                pushCurrentToken(new TokenMap((AnonymousClass1) null));
                break;
            case 4:
                jsonObjectReader.endObject();
                z = handleArrayOrMapEnd();
                break;
            case 5:
                pushCurrentToken(new TokenName(jsonObjectReader.nextName()));
                break;
            case 6:
                z = handlePrimitive(new JsonObjectDeserializer$$ExternalSyntheticLambda0(jsonObjectReader));
                break;
            case 7:
                z = handlePrimitive(new JsonObjectDeserializer$$ExternalSyntheticLambda1(this, jsonObjectReader));
                break;
            case 8:
                z = handlePrimitive(new JsonObjectDeserializer$$ExternalSyntheticLambda2(jsonObjectReader));
                break;
            case 9:
                jsonObjectReader.nextNull();
                z = handlePrimitive(new JsonObjectDeserializer$$ExternalSyntheticLambda3());
                break;
            case 10:
                z = true;
                break;
        }
        z = false;
        if (!z) {
            parse(jsonObjectReader);
        }
    }

    private boolean handleArrayOrMapEnd() {
        if (hasOneToken()) {
            return true;
        }
        Token currentToken = getCurrentToken();
        popCurrentToken();
        if (getCurrentToken() instanceof TokenName) {
            TokenName tokenName = (TokenName) getCurrentToken();
            popCurrentToken();
            TokenMap tokenMap = (TokenMap) getCurrentToken();
            if (tokenName == null || currentToken == null || tokenMap == null) {
                return false;
            }
            tokenMap.value.put(tokenName.value, currentToken.getValue());
            return false;
        } else if (!(getCurrentToken() instanceof TokenArray)) {
            return false;
        } else {
            TokenArray tokenArray = (TokenArray) getCurrentToken();
            if (currentToken == null || tokenArray == null) {
                return false;
            }
            tokenArray.value.add(currentToken.getValue());
            return false;
        }
    }

    private boolean handlePrimitive(NextValue nextValue) throws IOException {
        Object nextValue2 = nextValue.nextValue();
        if (getCurrentToken() == null && nextValue2 != null) {
            pushCurrentToken(new TokenPrimitive(nextValue2));
            return true;
        } else if (getCurrentToken() instanceof TokenName) {
            popCurrentToken();
            ((TokenMap) getCurrentToken()).value.put(((TokenName) getCurrentToken()).value, nextValue2);
            return false;
        } else if (!(getCurrentToken() instanceof TokenArray)) {
            return false;
        } else {
            ((TokenArray) getCurrentToken()).value.add(nextValue2);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        return java.lang.Double.valueOf(r3.nextDouble());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        return java.lang.Long.valueOf(r3.nextLong());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0009 */
    /* renamed from: nextNumber */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m873lambda$parse$1$iosentryJsonObjectDeserializer(io.sentry.JsonObjectReader r3) throws java.io.IOException {
        /*
            r2 = this;
            int r0 = r3.nextInt()     // Catch:{ Exception -> 0x0009 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0009 }
            return r3
        L_0x0009:
            double r0 = r3.nextDouble()     // Catch:{ Exception -> 0x0012 }
            java.lang.Double r3 = java.lang.Double.valueOf(r0)     // Catch:{ Exception -> 0x0012 }
            return r3
        L_0x0012:
            long r0 = r3.nextLong()
            java.lang.Long r3 = java.lang.Long.valueOf(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.JsonObjectDeserializer.m873lambda$parse$1$iosentryJsonObjectDeserializer(io.sentry.JsonObjectReader):java.lang.Object");
    }

    private Token getCurrentToken() {
        if (this.tokens.isEmpty()) {
            return null;
        }
        ArrayList<Token> arrayList = this.tokens;
        return arrayList.get(arrayList.size() - 1);
    }

    private void pushCurrentToken(Token token) {
        this.tokens.add(token);
    }

    private void popCurrentToken() {
        if (!this.tokens.isEmpty()) {
            ArrayList<Token> arrayList = this.tokens;
            arrayList.remove(arrayList.size() - 1);
        }
    }

    private boolean hasOneToken() {
        return this.tokens.size() == 1;
    }
}

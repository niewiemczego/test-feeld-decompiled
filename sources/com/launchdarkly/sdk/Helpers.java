package com.launchdarkly.sdk;

import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.util.Iterator;

abstract class Helpers {
    private Helpers() {
    }

    static <T, U> Iterable<U> transform(final Iterable<T> iterable, final Function<T, U> function) {
        return new Iterable<U>() {
            public Iterator<U> iterator() {
                final Iterator it = iterable.iterator();
                return new Iterator<U>() {
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    public U next() {
                        return function.apply(it.next());
                    }
                };
            }
        };
    }

    /* renamed from: com.launchdarkly.sdk.Helpers$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.gson.stream.JsonToken[] r0 = com.google.gson.stream.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$gson$stream$JsonToken = r0
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NULL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.Helpers.AnonymousClass2.<clinit>():void");
        }
    }

    static String readNullableString(JsonReader jsonReader) throws IOException {
        int i = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()];
        if (i == 1) {
            return jsonReader.nextString();
        }
        if (i == 2) {
            jsonReader.nextNull();
            return null;
        }
        throw new JsonParseException("expected string value or null");
    }

    static String readNonNullableString(JsonReader jsonReader) throws IOException {
        if (AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()] == 1) {
            return jsonReader.nextString();
        }
        throw new JsonParseException("expected string value");
    }

    static <T extends Enum<T>> T readEnum(Class<T> cls, JsonReader jsonReader) throws IOException {
        String readNonNullableString = readNonNullableString(jsonReader);
        try {
            return Enum.valueOf(cls, readNonNullableString);
        } catch (IllegalArgumentException unused) {
            throw new JsonParseException(String.format("unsupported value \"%s\" for %s", new Object[]{readNonNullableString, cls}));
        }
    }
}

package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.math.BigDecimal;

public enum ToNumberPolicy implements ToNumberStrategy {
    DOUBLE {
        public Double readNumber(JsonReader jsonReader) throws IOException {
            return Double.valueOf(jsonReader.nextDouble());
        }
    },
    LAZILY_PARSED_NUMBER {
        public Number readNumber(JsonReader jsonReader) throws IOException {
            return new LazilyParsedNumber(jsonReader.nextString());
        }
    },
    LONG_OR_DOUBLE {
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x004a, code lost:
            throw new com.google.gson.stream.MalformedJsonException("JSON forbids NaN and infinities: " + r2 + "; at path " + r7.getPreviousPath());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0070, code lost:
            throw new com.google.gson.JsonParseException("Cannot parse " + r1 + "; at path " + r7.getPreviousPath(), r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
            r2 = java.lang.Double.valueOf(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r2.isInfinite() != false) goto L_0x001f;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Number readNumber(com.google.gson.stream.JsonReader r7) throws java.io.IOException, com.google.gson.JsonParseException {
            /*
                r6 = this;
                java.lang.String r0 = "; at path "
                java.lang.String r1 = r7.nextString()
                long r2 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x000f }
                java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ NumberFormatException -> 0x000f }
                return r7
            L_0x000f:
                java.lang.Double r2 = java.lang.Double.valueOf(r1)     // Catch:{ NumberFormatException -> 0x004b }
                boolean r3 = r2.isInfinite()     // Catch:{ NumberFormatException -> 0x004b }
                if (r3 != 0) goto L_0x001f
                boolean r3 = r2.isNaN()     // Catch:{ NumberFormatException -> 0x004b }
                if (r3 == 0) goto L_0x0025
            L_0x001f:
                boolean r3 = r7.isLenient()     // Catch:{ NumberFormatException -> 0x004b }
                if (r3 == 0) goto L_0x0026
            L_0x0025:
                return r2
            L_0x0026:
                com.google.gson.stream.MalformedJsonException r3 = new com.google.gson.stream.MalformedJsonException     // Catch:{ NumberFormatException -> 0x004b }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x004b }
                r4.<init>()     // Catch:{ NumberFormatException -> 0x004b }
                java.lang.String r5 = "JSON forbids NaN and infinities: "
                java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ NumberFormatException -> 0x004b }
                java.lang.StringBuilder r2 = r4.append(r2)     // Catch:{ NumberFormatException -> 0x004b }
                java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ NumberFormatException -> 0x004b }
                java.lang.String r4 = r7.getPreviousPath()     // Catch:{ NumberFormatException -> 0x004b }
                java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ NumberFormatException -> 0x004b }
                java.lang.String r2 = r2.toString()     // Catch:{ NumberFormatException -> 0x004b }
                r3.<init>((java.lang.String) r2)     // Catch:{ NumberFormatException -> 0x004b }
                throw r3     // Catch:{ NumberFormatException -> 0x004b }
            L_0x004b:
                r2 = move-exception
                com.google.gson.JsonParseException r3 = new com.google.gson.JsonParseException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "Cannot parse "
                java.lang.StringBuilder r4 = r4.append(r5)
                java.lang.StringBuilder r1 = r4.append(r1)
                java.lang.StringBuilder r0 = r1.append(r0)
                java.lang.String r7 = r7.getPreviousPath()
                java.lang.StringBuilder r7 = r0.append(r7)
                java.lang.String r7 = r7.toString()
                r3.<init>(r7, r2)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.ToNumberPolicy.AnonymousClass3.readNumber(com.google.gson.stream.JsonReader):java.lang.Number");
        }
    },
    BIG_DECIMAL {
        public BigDecimal readNumber(JsonReader jsonReader) throws IOException {
            String nextString = jsonReader.nextString();
            try {
                return new BigDecimal(nextString);
            } catch (NumberFormatException e) {
                throw new JsonParseException("Cannot parse " + nextString + "; at path " + jsonReader.getPreviousPath(), e);
            }
        }
    }
}

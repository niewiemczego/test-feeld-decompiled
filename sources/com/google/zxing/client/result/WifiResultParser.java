package com.google.zxing.client.result;

public final class WifiResultParser extends ResultParser {
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        r14 = r14.substring(5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.client.result.WifiParsedResult parse(com.google.zxing.Result r14) {
        /*
            r13 = this;
            java.lang.String r14 = getMassagedText(r14)
            java.lang.String r0 = "WIFI:"
            boolean r0 = r14.startsWith(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            r0 = 5
            java.lang.String r14 = r14.substring(r0)
            java.lang.String r0 = "S:"
            r2 = 59
            r3 = 0
            java.lang.String r6 = matchSinglePrefixedField(r0, r14, r2, r3)
            if (r6 == 0) goto L_0x005d
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x0025
            goto L_0x005d
        L_0x0025:
            java.lang.String r0 = "P:"
            java.lang.String r7 = matchSinglePrefixedField(r0, r14, r2, r3)
            java.lang.String r0 = "T:"
            java.lang.String r0 = matchSinglePrefixedField(r0, r14, r2, r3)
            if (r0 != 0) goto L_0x0035
            java.lang.String r0 = "nopass"
        L_0x0035:
            r5 = r0
            java.lang.String r0 = "H:"
            java.lang.String r1 = matchSinglePrefixedField(r0, r14, r2, r3)
            boolean r8 = java.lang.Boolean.parseBoolean(r1)
            java.lang.String r1 = "I:"
            java.lang.String r9 = matchSinglePrefixedField(r1, r14, r2, r3)
            java.lang.String r1 = "A:"
            java.lang.String r10 = matchSinglePrefixedField(r1, r14, r2, r3)
            java.lang.String r1 = "E:"
            java.lang.String r11 = matchSinglePrefixedField(r1, r14, r2, r3)
            java.lang.String r12 = matchSinglePrefixedField(r0, r14, r2, r3)
            com.google.zxing.client.result.WifiParsedResult r14 = new com.google.zxing.client.result.WifiParsedResult
            r4 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            return r14
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.WifiResultParser.parse(com.google.zxing.Result):com.google.zxing.client.result.WifiParsedResult");
    }
}

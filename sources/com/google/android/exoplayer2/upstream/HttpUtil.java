package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HttpUtil {
    private static final Pattern CONTENT_RANGE_WITH_SIZE = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");
    private static final Pattern CONTENT_RANGE_WITH_START_AND_END = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
    private static final String TAG = "HttpUtil";

    private HttpUtil() {
    }

    public static String buildRangeRequestHeader(long j, long j2) {
        if (j == 0 && j2 == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bytes=");
        sb.append(j);
        sb.append("-");
        if (j2 != -1) {
            sb.append((j + j2) - 1);
        }
        return sb.toString();
    }

    public static long getDocumentSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Matcher matcher = CONTENT_RANGE_WITH_SIZE.matcher(str);
        if (matcher.matches()) {
            return Long.parseLong((String) Assertions.checkNotNull(matcher.group(1)));
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long getContentLength(java.lang.String r9, java.lang.String r10) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r1 = "]"
            java.lang.String r2 = "HttpUtil"
            if (r0 != 0) goto L_0x0029
            long r3 = java.lang.Long.parseLong(r9)     // Catch:{ NumberFormatException -> 0x000f }
            goto L_0x002b
        L_0x000f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Unexpected Content-Length ["
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.google.android.exoplayer2.util.Log.e(r2, r0)
        L_0x0029:
            r3 = -1
        L_0x002b:
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L_0x00af
            java.util.regex.Pattern r0 = CONTENT_RANGE_WITH_START_AND_END
            java.util.regex.Matcher r0 = r0.matcher(r10)
            boolean r5 = r0.matches()
            if (r5 == 0) goto L_0x00af
            r5 = 2
            java.lang.String r5 = r0.group(r5)     // Catch:{ NumberFormatException -> 0x0095 }
            java.lang.Object r5 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r5)     // Catch:{ NumberFormatException -> 0x0095 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ NumberFormatException -> 0x0095 }
            long r5 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException -> 0x0095 }
            r7 = 1
            java.lang.String r0 = r0.group(r7)     // Catch:{ NumberFormatException -> 0x0095 }
            java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r0)     // Catch:{ NumberFormatException -> 0x0095 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NumberFormatException -> 0x0095 }
            long r7 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0095 }
            long r5 = r5 - r7
            r7 = 1
            long r5 = r5 + r7
            r7 = 0
            int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0067
            r3 = r5
            goto L_0x00af
        L_0x0067:
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x00af
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0095 }
            r0.<init>()     // Catch:{ NumberFormatException -> 0x0095 }
            java.lang.String r7 = "Inconsistent headers ["
            java.lang.StringBuilder r0 = r0.append(r7)     // Catch:{ NumberFormatException -> 0x0095 }
            java.lang.StringBuilder r9 = r0.append(r9)     // Catch:{ NumberFormatException -> 0x0095 }
            java.lang.String r0 = "] ["
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch:{ NumberFormatException -> 0x0095 }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ NumberFormatException -> 0x0095 }
            java.lang.StringBuilder r9 = r9.append(r1)     // Catch:{ NumberFormatException -> 0x0095 }
            java.lang.String r9 = r9.toString()     // Catch:{ NumberFormatException -> 0x0095 }
            com.google.android.exoplayer2.util.Log.w(r2, r9)     // Catch:{ NumberFormatException -> 0x0095 }
            long r9 = java.lang.Math.max(r3, r5)     // Catch:{ NumberFormatException -> 0x0095 }
            r3 = r9
            goto L_0x00af
        L_0x0095:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Unexpected Content-Range ["
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.StringBuilder r9 = r9.append(r1)
            java.lang.String r9 = r9.toString()
            com.google.android.exoplayer2.util.Log.e(r2, r9)
        L_0x00af:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.HttpUtil.getContentLength(java.lang.String, java.lang.String):long");
    }
}

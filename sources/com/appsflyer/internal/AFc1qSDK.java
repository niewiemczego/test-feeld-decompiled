package com.appsflyer.internal;

import android.util.Base64;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.json.JSONArray;

public interface AFc1qSDK {
    void AFKeystoreWrapper(byte[] bArr, Map<String, String> map, int i);

    public static final class AFa1vSDK {
        public final String AFInAppEventParameterName;
        public final Boolean AFInAppEventType;
        public Boolean AFKeystoreWrapper;

        public AFa1vSDK() {
        }

        public AFa1vSDK(String str, Boolean bool) {
            this.AFInAppEventParameterName = str;
            this.AFInAppEventType = bool;
        }

        public static double AFInAppEventParameterName(String str) throws ParseException {
            Intrinsics.checkNotNullParameter(str, "");
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException unused) {
                Number parse = NumberFormat.getInstance(Locale.getDefault()).parse(str);
                if (parse != null) {
                    return parse.doubleValue();
                }
                throw new ParseException("Failed parse String into number", 0);
            }
        }

        public static JSONArray valueOf(List<AFc1sSDK> list) {
            Intrinsics.checkNotNullParameter(list, "");
            Iterable<AFc1sSDK> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (AFc1sSDK AFKeystoreWrapper2 : iterable) {
                arrayList.add(AFKeystoreWrapper2.AFKeystoreWrapper());
            }
            return new JSONArray((Collection<?>) (List) arrayList);
        }

        public static boolean AFKeystoreWrapper(HttpURLConnection httpURLConnection) {
            Intrinsics.checkNotNullParameter(httpURLConnection, "");
            return httpURLConnection.getResponseCode() / 100 == 2;
        }

        public static String values(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "");
            byte[] digest = instance.digest(bytes);
            Intrinsics.checkNotNullExpressionValue(digest, "");
            String str2 = "";
            for (byte valueOf : digest) {
                StringBuilder append = new StringBuilder().append(str2);
                String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(valueOf)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                str2 = append.append(format).toString();
            }
            return str2;
        }

        public static String AFKeystoreWrapper(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "");
            String encodeToString = Base64.encodeToString(bytes, 2);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "");
            return encodeToString;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0026, code lost:
            r0 = kotlin.text.StringsKt.toIntOrNull((r0 = r0.getValue()));
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int AFInAppEventType(java.lang.String r4) {
            /*
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                kotlin.text.Regex r0 = new kotlin.text.Regex
                java.lang.String r1 = "(\\d+).?(\\d+)?.?(\\d+)?(-rc\\d+)?(_.*)?"
                r0.<init>((java.lang.String) r1)
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                kotlin.text.MatchResult r4 = r0.matchEntire(r4)
                if (r4 == 0) goto L_0x0073
                kotlin.text.MatchGroupCollection r0 = r4.getGroups()
                r1 = 1
                kotlin.text.MatchGroup r0 = r0.get(r1)
                r1 = 0
                if (r0 == 0) goto L_0x0031
                java.lang.String r0 = r0.getValue()
                if (r0 == 0) goto L_0x0031
                java.lang.Integer r0 = kotlin.text.StringsKt.toIntOrNull(r0)
                if (r0 == 0) goto L_0x0031
                int r0 = r0.intValue()
                goto L_0x0032
            L_0x0031:
                r0 = r1
            L_0x0032:
                r2 = 1000000(0xf4240, float:1.401298E-39)
                int r0 = r0 * r2
                kotlin.text.MatchGroupCollection r2 = r4.getGroups()
                r3 = 2
                kotlin.text.MatchGroup r2 = r2.get(r3)
                if (r2 == 0) goto L_0x0052
                java.lang.String r2 = r2.getValue()
                if (r2 == 0) goto L_0x0052
                java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)
                if (r2 == 0) goto L_0x0052
                int r2 = r2.intValue()
                goto L_0x0053
            L_0x0052:
                r2 = r1
            L_0x0053:
                int r2 = r2 * 1000
                int r0 = r0 + r2
                kotlin.text.MatchGroupCollection r4 = r4.getGroups()
                r2 = 3
                kotlin.text.MatchGroup r4 = r4.get(r2)
                if (r4 == 0) goto L_0x0071
                java.lang.String r4 = r4.getValue()
                if (r4 == 0) goto L_0x0071
                java.lang.Integer r4 = kotlin.text.StringsKt.toIntOrNull(r4)
                if (r4 == 0) goto L_0x0071
                int r1 = r4.intValue()
            L_0x0071:
                int r0 = r0 + r1
                return r0
            L_0x0073:
                r4 = -1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1qSDK.AFa1vSDK.AFInAppEventType(java.lang.String):int");
        }
    }
}

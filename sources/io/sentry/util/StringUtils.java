package io.sentry.util;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.StringCharacterIterator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public final class StringUtils {
    private static final String CORRUPTED_NIL_UUID = "0000-0000";
    private static final Pattern PATTERN_WORD_SNAKE_CASE = Pattern.compile("[\\W_]+");
    private static final String PROPER_NIL_UUID = "00000000-0000-0000-0000-000000000000";
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private StringUtils() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r0 = r0 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getStringAfterDot(java.lang.String r2) {
        /*
            if (r2 == 0) goto L_0x0017
            java.lang.String r0 = "."
            int r0 = r2.lastIndexOf(r0)
            if (r0 < 0) goto L_0x0016
            int r1 = r2.length()
            int r0 = r0 + 1
            if (r1 <= r0) goto L_0x0016
            java.lang.String r2 = r2.substring(r0)
        L_0x0016:
            return r2
        L_0x0017:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.util.StringUtils.getStringAfterDot(java.lang.String):java.lang.String");
    }

    public static String capitalize(String str) {
        return (str == null || str.isEmpty()) ? str : str.substring(0, 1).toUpperCase(Locale.ROOT) + str.substring(1).toLowerCase(Locale.ROOT);
    }

    public static String camelCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] split = PATTERN_WORD_SNAKE_CASE.split(str, -1);
        StringBuilder sb = new StringBuilder();
        for (String capitalize : split) {
            sb.append(capitalize(capitalize));
        }
        return sb.toString();
    }

    public static String removeSurrounding(String str, String str2) {
        return (str == null || str2 == null || !str.startsWith(str2) || !str.endsWith(str2)) ? str : str.substring(str2.length(), str.length() - str2.length());
    }

    public static String byteCountToString(long j) {
        if (-1000 < j && j < 1000) {
            return j + " B";
        }
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator("kMGTPE");
        while (true) {
            if (j <= -999950 || j >= 999950) {
                j /= 1000;
                stringCharacterIterator.next();
            } else {
                return String.format(Locale.ROOT, "%.1f %cB", new Object[]{Double.valueOf(((double) j) / 1000.0d), Character.valueOf(stringCharacterIterator.current())});
            }
        }
    }

    public static String calculateStringHash(String str, ILogger iLogger) {
        if (str != null && !str.isEmpty()) {
            try {
                return new StringBuilder(new BigInteger(1, MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1).digest(str.getBytes(UTF_8))).toString(16)).toString();
            } catch (NoSuchAlgorithmException e) {
                iLogger.log(SentryLevel.INFO, "SHA-1 isn't available to calculate the hash.", (Throwable) e);
            } catch (Throwable th) {
                iLogger.log(SentryLevel.INFO, "string: %s could not calculate its hash", th, str);
            }
        }
        return null;
    }

    public static int countOf(String str, char c) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == c) {
                i++;
            }
        }
        return i;
    }

    public static String normalizeUUID(String str) {
        return str.equals(CORRUPTED_NIL_UUID) ? PROPER_NIL_UUID : str;
    }

    public static String join(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
        StringBuilder sb = new StringBuilder();
        Iterator<? extends CharSequence> it = iterable.iterator();
        if (it.hasNext()) {
            sb.append((CharSequence) it.next());
            while (it.hasNext()) {
                sb.append(charSequence);
                sb.append((CharSequence) it.next());
            }
        }
        return sb.toString();
    }

    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static String removePrefix(String str, String str2) {
        if (str == null) {
            return "";
        }
        return str.indexOf(str2) == 0 ? str.substring(str2.length()) : str;
    }

    public static String substringBefore(String str, String str2) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(str2);
        return indexOf >= 0 ? str.substring(0, indexOf) : str;
    }
}

package org.apache.commons.lang3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;

public class StringUtils {
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;
    private static final int PAD_LIMIT = 8192;
    private static final Pattern WHITESPACE_BLOCK = Pattern.compile("\\s+");
    private static boolean java6Available;
    private static Method java6NormalizeMethod;
    private static Object java6NormalizerFormNFD;
    private static final Pattern java6Pattern;
    private static boolean sunAvailable;
    private static Method sunDecomposeMethod;
    private static final Pattern sunPattern;

    public static String defaultString(String str) {
        return str == null ? "" : str;
    }

    public static String defaultString(String str, String str2) {
        return str == null ? str2 : str;
    }

    static {
        sunAvailable = false;
        sunDecomposeMethod = null;
        Pattern compile = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        sunPattern = compile;
        java6Available = false;
        java6NormalizeMethod = null;
        java6NormalizerFormNFD = null;
        java6Pattern = compile;
        try {
            Class<?> loadClass = Thread.currentThread().getContextClassLoader().loadClass("java.text.Normalizer$Form");
            java6NormalizerFormNFD = loadClass.getField("NFD").get((Object) null);
            java6NormalizeMethod = Thread.currentThread().getContextClassLoader().loadClass("java.text.Normalizer").getMethod("normalize", new Class[]{CharSequence.class, loadClass});
            java6Available = true;
        } catch (ClassNotFoundException unused) {
            java6Available = false;
        } catch (NoSuchFieldException unused2) {
            java6Available = false;
        } catch (IllegalAccessException unused3) {
            java6Available = false;
        } catch (NoSuchMethodException unused4) {
            java6Available = false;
        }
        try {
            sunDecomposeMethod = Thread.currentThread().getContextClassLoader().loadClass("sun.text.Normalizer").getMethod("decompose", new Class[]{String.class, Boolean.TYPE, Integer.TYPE});
            sunAvailable = true;
        } catch (ClassNotFoundException unused5) {
            sunAvailable = false;
        } catch (NoSuchMethodException unused6) {
            sunAvailable = false;
        }
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static boolean isBlank(CharSequence charSequence) {
        int length;
        if (!(charSequence == null || (length = charSequence.length()) == 0)) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(charSequence.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isNotBlank(CharSequence charSequence) {
        return !isBlank(charSequence);
    }

    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String trimToNull(String str) {
        String trim = trim(str);
        if (isEmpty(trim)) {
            return null;
        }
        return trim;
    }

    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    public static String strip(String str) {
        return strip(str, (String) null);
    }

    public static String stripToNull(String str) {
        if (str == null) {
            return null;
        }
        String strip = strip(str, (String) null);
        if (strip.length() == 0) {
            return null;
        }
        return strip;
    }

    public static String stripToEmpty(String str) {
        return str == null ? "" : strip(str, (String) null);
    }

    public static String strip(String str, String str2) {
        if (isEmpty(str)) {
            return str;
        }
        return stripEnd(stripStart(str, str2), str2);
    }

    public static String stripStart(String str, String str2) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        int i = 0;
        if (str2 == null) {
            while (i != length && Character.isWhitespace(str.charAt(i))) {
                i++;
            }
        } else if (str2.length() == 0) {
            return str;
        } else {
            while (i != length && str2.indexOf(str.charAt(i)) != -1) {
                i++;
            }
        }
        return str.substring(i);
    }

    public static String stripEnd(String str, String str2) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        if (str2 == null) {
            while (length != 0 && Character.isWhitespace(str.charAt(length - 1))) {
                length--;
            }
        } else if (str2.length() == 0) {
            return str;
        } else {
            while (length != 0 && str2.indexOf(str.charAt(length - 1)) != -1) {
                length--;
            }
        }
        return str.substring(0, length);
    }

    public static String[] stripAll(String... strArr) {
        return stripAll(strArr, (String) null);
    }

    public static String[] stripAll(String[] strArr, String str) {
        int length;
        if (strArr == null || (length = strArr.length) == 0) {
            return strArr;
        }
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            strArr2[i] = strip(strArr[i], str);
        }
        return strArr2;
    }

    public static String stripAccents(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (java6Available) {
                return removeAccentsJava6(str);
            }
            if (sunAvailable) {
                return removeAccentsSUN(str);
            }
            throw new UnsupportedOperationException("The stripAccents(CharSequence) method requires at least Java 1.6 or a Sun JVM");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("IllegalArgumentException occurred", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("IllegalAccessException occurred", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("InvocationTargetException occurred", e3);
        } catch (SecurityException e4) {
            throw new RuntimeException("SecurityException occurred", e4);
        }
    }

    private static String removeAccentsJava6(CharSequence charSequence) throws IllegalAccessException, InvocationTargetException {
        Object obj;
        if (!java6Available || (obj = java6NormalizerFormNFD) == null) {
            throw new IllegalStateException("java.text.Normalizer is not available");
        }
        Method method = java6NormalizeMethod;
        Object[] objArr = {charSequence, obj};
        return java6Pattern.matcher((String) method.invoke((Object) null, objArr)).replaceAll("");
    }

    private static String removeAccentsSUN(CharSequence charSequence) throws IllegalAccessException, InvocationTargetException {
        if (sunAvailable) {
            Method method = sunDecomposeMethod;
            Object[] objArr = {charSequence, Boolean.FALSE, 0};
            return sunPattern.matcher((String) method.invoke((Object) null, objArr)).replaceAll("");
        }
        throw new IllegalStateException("sun.text.Normalizer is not available");
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null) {
            return charSequence2 == null;
        }
        return charSequence.equals(charSequence2);
    }

    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        }
        return CharSequenceUtils.regionMatches(charSequence, true, 0, charSequence2, 0, Math.max(charSequence.length(), charSequence2.length()));
    }

    public static int indexOf(CharSequence charSequence, int i) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, i, 0);
    }

    public static int indexOf(CharSequence charSequence, int i, int i2) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, i, i2);
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, charSequence2, 0);
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, charSequence2, i);
    }

    public static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return ordinalIndexOf(charSequence, charSequence2, i, false);
    }

    private static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i, boolean z) {
        int i2 = -1;
        if (charSequence == null || charSequence2 == null || i <= 0) {
            return i2;
        }
        int i3 = 0;
        if (charSequence2.length() != 0) {
            if (z) {
                i2 = charSequence.length();
            }
            do {
                if (z) {
                    i2 = CharSequenceUtils.lastIndexOf(charSequence, charSequence2, i2 - 1);
                } else {
                    i2 = CharSequenceUtils.indexOf(charSequence, charSequence2, i2 + 1);
                }
                if (i2 < 0) {
                    return i2;
                }
                i3++;
            } while (i3 < i);
            return i2;
        } else if (z) {
            return charSequence.length();
        } else {
            return 0;
        }
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return indexOfIgnoreCase(charSequence, charSequence2, 0);
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (!(charSequence == null || charSequence2 == null)) {
            if (i < 0) {
                i = 0;
            }
            int length = (charSequence.length() - charSequence2.length()) + 1;
            if (i > length) {
                return -1;
            }
            if (charSequence2.length() == 0) {
                return i;
            }
            while (i < length) {
                if (CharSequenceUtils.regionMatches(charSequence, true, i, charSequence2, 0, charSequence2.length())) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public static int lastIndexOf(CharSequence charSequence, int i) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, i, charSequence.length());
    }

    public static int lastIndexOf(CharSequence charSequence, int i, int i2) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, i, i2);
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, charSequence2, charSequence.length());
    }

    public static int lastOrdinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return ordinalIndexOf(charSequence, charSequence2, i, true);
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, charSequence2, i);
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return lastIndexOfIgnoreCase(charSequence, charSequence2, charSequence.length());
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (!(charSequence == null || charSequence2 == null)) {
            if (i > charSequence.length() - charSequence2.length()) {
                i = charSequence.length() - charSequence2.length();
            }
            if (i < 0) {
                return -1;
            }
            if (charSequence2.length() == 0) {
                return i;
            }
            while (i >= 0) {
                if (CharSequenceUtils.regionMatches(charSequence, true, i, charSequence2, 0, charSequence2.length())) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public static boolean contains(CharSequence charSequence, int i) {
        if (!isEmpty(charSequence) && CharSequenceUtils.indexOf(charSequence, i, 0) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return (charSequence == null || charSequence2 == null || CharSequenceUtils.indexOf(charSequence, charSequence2, 0) < 0) ? false : true;
    }

    public static boolean containsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (!(charSequence == null || charSequence2 == null)) {
            int length = charSequence2.length();
            int length2 = charSequence.length() - length;
            for (int i = 0; i <= length2; i++) {
                if (CharSequenceUtils.regionMatches(charSequence, true, i, charSequence2, 0, length)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsWhitespace(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static int indexOfAny(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int i = length - 1;
            int length2 = cArr.length;
            int i2 = length2 - 1;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = charSequence.charAt(i3);
                for (int i4 = 0; i4 < length2; i4++) {
                    if (cArr[i4] == charAt && (i3 >= i || i4 >= i2 || !Character.isHighSurrogate(charAt) || cArr[i4 + 1] == charSequence.charAt(i3 + 1))) {
                        return i3;
                    }
                }
            }
        }
        return -1;
    }

    public static int indexOfAny(CharSequence charSequence, String str) {
        if (isEmpty(charSequence) || isEmpty(str)) {
            return -1;
        }
        return indexOfAny(charSequence, str.toCharArray());
    }

    public static boolean containsAny(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int length2 = cArr.length;
            int i = length - 1;
            int i2 = length2 - 1;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = charSequence.charAt(i3);
                for (int i4 = 0; i4 < length2; i4++) {
                    if (cArr[i4] == charAt) {
                        if (!Character.isHighSurrogate(charAt) || i4 == i2) {
                            return true;
                        }
                        if (i3 < i && cArr[i4 + 1] == charSequence.charAt(i3 + 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean containsAny(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2 == null) {
            return false;
        }
        return containsAny(charSequence, CharSequenceUtils.toCharArray(charSequence2));
    }

    public static int indexOfAnyBut(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int i = length - 1;
            int length2 = cArr.length;
            int i2 = length2 - 1;
            int i3 = 0;
            while (i3 < length) {
                char charAt = charSequence.charAt(i3);
                int i4 = 0;
                while (i4 < length2) {
                    if (cArr[i4] != charAt || (i3 < i && i4 < i2 && Character.isHighSurrogate(charAt) && cArr[i4 + 1] != charSequence.charAt(i3 + 1))) {
                        i4++;
                    } else {
                        i3++;
                    }
                }
                return i3;
            }
        }
        return -1;
    }

    public static int indexOfAnyBut(CharSequence charSequence, CharSequence charSequence2) {
        if (!isEmpty(charSequence) && !isEmpty(charSequence2)) {
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                char charAt = charSequence.charAt(i);
                boolean z = CharSequenceUtils.indexOf(charSequence2, (int) charAt, 0) >= 0;
                int i2 = i + 1;
                if (i2 < length && Character.isHighSurrogate(charAt)) {
                    char charAt2 = charSequence.charAt(i2);
                    if (z && CharSequenceUtils.indexOf(charSequence2, (int) charAt2, 0) < 0) {
                        return i;
                    }
                } else if (!z) {
                    return i;
                }
                i = i2;
            }
        }
        return -1;
    }

    public static boolean containsOnly(CharSequence charSequence, char... cArr) {
        if (cArr == null || charSequence == null) {
            return false;
        }
        if (charSequence.length() == 0) {
            return true;
        }
        if (cArr.length != 0 && indexOfAnyBut(charSequence, cArr) == -1) {
            return true;
        }
        return false;
    }

    public static boolean containsOnly(CharSequence charSequence, String str) {
        if (charSequence == null || str == null) {
            return false;
        }
        return containsOnly(charSequence, str.toCharArray());
    }

    public static boolean containsNone(CharSequence charSequence, char... cArr) {
        if (!(charSequence == null || cArr == null)) {
            int length = charSequence.length();
            int i = length - 1;
            int length2 = cArr.length;
            int i2 = length2 - 1;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = charSequence.charAt(i3);
                for (int i4 = 0; i4 < length2; i4++) {
                    if (cArr[i4] == charAt) {
                        if (!Character.isHighSurrogate(charAt) || i4 == i2) {
                            return false;
                        }
                        if (i3 < i && cArr[i4 + 1] == charSequence.charAt(i3 + 1)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean containsNone(CharSequence charSequence, String str) {
        if (charSequence == null || str == null) {
            return true;
        }
        return containsNone(charSequence, str.toCharArray());
    }

    public static int indexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int indexOf;
        if (charSequence == null || charSequenceArr == null) {
            return -1;
        }
        int i = Integer.MAX_VALUE;
        for (CharSequence charSequence2 : charSequenceArr) {
            if (!(charSequence2 == null || (indexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, 0)) == -1 || indexOf >= i)) {
                i = indexOf;
            }
        }
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    public static int lastIndexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int lastIndexOf;
        int i = -1;
        if (!(charSequence == null || charSequenceArr == null)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (charSequence2 != null && (lastIndexOf = CharSequenceUtils.lastIndexOf(charSequence, charSequence2, charSequence.length())) > i) {
                    i = lastIndexOf;
                }
            }
        }
        return i;
    }

    public static String substring(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            i += str.length();
        }
        if (i < 0) {
            i = 0;
        }
        if (i > str.length()) {
            return "";
        }
        return str.substring(i);
    }

    public static String substring(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0) {
            i2 += str.length();
        }
        if (i < 0) {
            i += str.length();
        }
        if (i2 > str.length()) {
            i2 = str.length();
        }
        if (i > i2) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        return str.substring(i, i2);
    }

    public static String left(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            return "";
        }
        if (str.length() <= i) {
            return str;
        }
        return str.substring(0, i);
    }

    public static String right(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            return "";
        }
        if (str.length() <= i) {
            return str;
        }
        return str.substring(str.length() - i);
    }

    public static String mid(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0 || i > str.length()) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        int i3 = i2 + i;
        if (str.length() <= i3) {
            return str.substring(i);
        }
        return str.substring(i, i3);
    }

    public static String substringBefore(String str, String str2) {
        if (isEmpty(str) || str2 == null) {
            return str;
        }
        if (str2.length() == 0) {
            return "";
        }
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return str;
        }
        return str.substring(0, indexOf);
    }

    public static String substringAfter(String str, String str2) {
        int indexOf;
        if (isEmpty(str)) {
            return str;
        }
        if (str2 == null || (indexOf = str.indexOf(str2)) == -1) {
            return "";
        }
        return str.substring(indexOf + str2.length());
    }

    public static String substringBeforeLast(String str, String str2) {
        int lastIndexOf;
        if (isEmpty(str) || isEmpty(str2) || (lastIndexOf = str.lastIndexOf(str2)) == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    public static String substringAfterLast(String str, String str2) {
        int lastIndexOf;
        if (isEmpty(str)) {
            return str;
        }
        if (isEmpty(str2) || (lastIndexOf = str.lastIndexOf(str2)) == -1 || lastIndexOf == str.length() - str2.length()) {
            return "";
        }
        return str.substring(lastIndexOf + str2.length());
    }

    public static String substringBetween(String str, String str2) {
        return substringBetween(str, str2, str2);
    }

    public static String substringBetween(String str, String str2, String str3) {
        int indexOf;
        int indexOf2;
        if (str == null || str2 == null || str3 == null || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, str2.length() + indexOf)) == -1) {
            return null;
        }
        return str.substring(indexOf + str2.length(), indexOf2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        r5 = r5 + r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] substringsBetween(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x0058
            boolean r1 = isEmpty(r8)
            if (r1 != 0) goto L_0x0058
            boolean r1 = isEmpty(r9)
            if (r1 == 0) goto L_0x0010
            goto L_0x0058
        L_0x0010:
            int r1 = r7.length()
            if (r1 != 0) goto L_0x0019
            java.lang.String[] r7 = org.apache.commons.lang3.ArrayUtils.EMPTY_STRING_ARRAY
            return r7
        L_0x0019:
            int r2 = r9.length()
            int r3 = r8.length()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = 0
        L_0x0027:
            int r6 = r1 - r2
            if (r5 >= r6) goto L_0x0044
            int r5 = r7.indexOf(r8, r5)
            if (r5 >= 0) goto L_0x0032
            goto L_0x0044
        L_0x0032:
            int r5 = r5 + r3
            int r6 = r7.indexOf(r9, r5)
            if (r6 >= 0) goto L_0x003a
            goto L_0x0044
        L_0x003a:
            java.lang.String r5 = r7.substring(r5, r6)
            r4.add(r5)
            int r5 = r6 + r2
            goto L_0x0027
        L_0x0044:
            boolean r7 = r4.isEmpty()
            if (r7 == 0) goto L_0x004b
            return r0
        L_0x004b:
            int r7 = r4.size()
            java.lang.String[] r7 = new java.lang.String[r7]
            java.lang.Object[] r7 = r4.toArray(r7)
            java.lang.String[] r7 = (java.lang.String[]) r7
            return r7
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.substringsBetween(java.lang.String, java.lang.String, java.lang.String):java.lang.String[]");
    }

    public static String[] split(String str) {
        return split(str, (String) null, -1);
    }

    public static String[] split(String str, char c) {
        return splitWorker(str, c, false);
    }

    public static String[] split(String str, String str2) {
        return splitWorker(str, str2, -1, false);
    }

    public static String[] split(String str, String str2, int i) {
        return splitWorker(str, str2, i, false);
    }

    public static String[] splitByWholeSeparator(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, false);
    }

    public static String[] splitByWholeSeparator(String str, String str2, int i) {
        return splitByWholeSeparatorWorker(str, str2, i, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, true);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2, int i) {
        return splitByWholeSeparatorWorker(str, str2, i, true);
    }

    private static String[] splitByWholeSeparatorWorker(String str, String str2, int i, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        if (str2 == null || "".equals(str2)) {
            return splitWorker(str, (String) null, i, z);
        }
        int length2 = str2.length();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            i2 = str.indexOf(str2, i3);
            if (i2 > -1) {
                if (i2 > i3) {
                    i4++;
                    if (i4 == i) {
                        arrayList.add(str.substring(i3));
                    } else {
                        arrayList.add(str.substring(i3, i2));
                    }
                } else if (z) {
                    i4++;
                    if (i4 == i) {
                        arrayList.add(str.substring(i3));
                        i2 = length;
                    } else {
                        arrayList.add("");
                    }
                }
                i3 = i2 + length2;
            } else {
                arrayList.add(str.substring(i3));
            }
            i2 = length;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitPreserveAllTokens(String str) {
        return splitWorker(str, (String) null, -1, true);
    }

    public static String[] splitPreserveAllTokens(String str, char c) {
        return splitWorker(str, c, true);
    }

    private static String[] splitWorker(String str, char c, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (i < length) {
            if (str.charAt(i) == c) {
                if (z2 || z) {
                    arrayList.add(str.substring(i2, i));
                    z3 = true;
                    z2 = false;
                }
                i2 = i + 1;
                i = i2;
            } else {
                i++;
                z2 = true;
                z3 = false;
            }
        }
        if (z2 || (z && z3)) {
            arrayList.add(str.substring(i2, i));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitPreserveAllTokens(String str, String str2) {
        return splitWorker(str, str2, -1, true);
    }

    public static String[] splitPreserveAllTokens(String str, String str2, int i) {
        return splitWorker(str, str2, i, true);
    }

    private static String[] splitWorker(String str, String str2, int i, boolean z) {
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        int i4;
        boolean z4;
        boolean z5;
        int i5;
        boolean z6;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        if (str2 == null) {
            i2 = 0;
            z3 = false;
            z2 = false;
            i3 = 0;
            int i6 = 1;
            while (i2 < length) {
                if (Character.isWhitespace(str.charAt(i2))) {
                    if (z3 || z) {
                        int i7 = i6 + 1;
                        if (i6 == i) {
                            i2 = length;
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        arrayList.add(str.substring(i3, i2));
                        i6 = i7;
                        z3 = false;
                    }
                    i3 = i2 + 1;
                    i2 = i3;
                } else {
                    i2++;
                    z2 = false;
                    z3 = true;
                }
            }
        } else {
            if (str2.length() == 1) {
                char charAt = str2.charAt(0);
                i5 = 0;
                z5 = false;
                z4 = false;
                i4 = 0;
                int i8 = 1;
                while (i5 < length) {
                    if (str.charAt(i5) == charAt) {
                        if (z5 || z) {
                            int i9 = i8 + 1;
                            if (i8 == i) {
                                i5 = length;
                                z4 = false;
                            } else {
                                z4 = true;
                            }
                            arrayList.add(str.substring(i4, i5));
                            i8 = i9;
                            z5 = false;
                        }
                        i4 = i5 + 1;
                        i5 = i4;
                    } else {
                        i5++;
                        z4 = false;
                        z5 = true;
                    }
                }
            } else {
                int i10 = 0;
                z5 = false;
                z4 = false;
                i4 = 0;
                int i11 = 1;
                while (i5 < length) {
                    if (str2.indexOf(str.charAt(i5)) >= 0) {
                        if (z5 || z) {
                            int i12 = i11 + 1;
                            if (i11 == i) {
                                i5 = length;
                                z6 = false;
                            } else {
                                z6 = true;
                            }
                            arrayList.add(str.substring(i4, i5));
                            i11 = i12;
                            z5 = false;
                        }
                        i4 = i5 + 1;
                        i10 = i4;
                    } else {
                        i10 = i5 + 1;
                        z4 = false;
                        z5 = true;
                    }
                }
            }
            i2 = i5;
            z3 = z5;
            z2 = z4;
            i3 = i4;
        }
        if (z3 || (z && z2)) {
            arrayList.add(str.substring(i3, i2));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitByCharacterType(String str) {
        return splitByCharacterType(str, false);
    }

    public static String[] splitByCharacterTypeCamelCase(String str) {
        return splitByCharacterType(str, true);
    }

    private static String[] splitByCharacterType(String str, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int type = Character.getType(charArray[0]);
        for (int i2 = 1; i2 < charArray.length; i2++) {
            int type2 = Character.getType(charArray[i2]);
            if (type2 != type) {
                if (z && type2 == 2 && type == 1) {
                    int i3 = i2 - 1;
                    if (i3 != i) {
                        arrayList.add(new String(charArray, i, i3 - i));
                        i = i3;
                    }
                } else {
                    arrayList.add(new String(charArray, i, i2 - i));
                    i = i2;
                }
                type = type2;
            }
        }
        arrayList.add(new String(charArray, i, charArray.length - i));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static <T> String join(T... tArr) {
        return join((Object[]) tArr, (String) null);
    }

    public static String join(Object[] objArr, char c) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, c, 0, objArr.length);
    }

    public static String join(Object[] objArr, char c, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i3 * 16);
        for (int i4 = i; i4 < i2; i4++) {
            if (i4 > i) {
                sb.append(c);
            }
            Object obj = objArr[i4];
            if (obj != null) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    public static String join(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, str, 0, objArr.length);
    }

    public static String join(Object[] objArr, String str, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i3 * 16);
        for (int i4 = i; i4 < i2; i4++) {
            if (i4 > i) {
                sb.append(str);
            }
            Object obj = objArr[i4];
            if (obj != null) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    public static String join(Iterator<?> it, char c) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return ObjectUtils.toString(next);
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            sb.append(c);
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }

    public static String join(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return ObjectUtils.toString(next);
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                sb.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }

    public static String join(Iterable<?> iterable, char c) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), c);
    }

    public static String join(Iterable<?> iterable, String str) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), str);
    }

    public static String deleteWhitespace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                cArr[i] = str.charAt(i2);
                i++;
            }
        }
        if (i == length) {
            return str;
        }
        return new String(cArr, 0, i);
    }

    public static String removeStart(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !str.startsWith(str2)) ? str : str.substring(str2.length());
    }

    public static String removeStartIgnoreCase(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !startsWithIgnoreCase(str, str2)) ? str : str.substring(str2.length());
    }

    public static String removeEnd(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !str.endsWith(str2)) ? str : str.substring(0, str.length() - str2.length());
    }

    public static String removeEndIgnoreCase(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !endsWithIgnoreCase(str, str2)) ? str : str.substring(0, str.length() - str2.length());
    }

    public static String remove(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : replace(str, str2, "", -1);
    }

    public static String remove(String str, char c) {
        if (isEmpty(str) || str.indexOf(c) == -1) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i = 0;
        for (char c2 : charArray) {
            if (c2 != c) {
                charArray[i] = c2;
                i++;
            }
        }
        return new String(charArray, 0, i);
    }

    public static String replaceOnce(String str, String str2, String str3) {
        return replace(str, str2, str3, 1);
    }

    public static String replace(String str, String str2, String str3) {
        return replace(str, str2, str3, -1);
    }

    public static String replace(String str, String str2, String str3, int i) {
        if (isEmpty(str) || isEmpty(str2) || str3 == null || i == 0) {
            return str;
        }
        int i2 = 0;
        int indexOf = str.indexOf(str2, 0);
        if (indexOf == -1) {
            return str;
        }
        int length = str2.length();
        int length2 = str3.length() - length;
        if (length2 < 0) {
            length2 = 0;
        }
        int i3 = 64;
        if (i < 0) {
            i3 = 16;
        } else if (i <= 64) {
            i3 = i;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length2 * i3));
        while (indexOf != -1) {
            sb.append(str.substring(i2, indexOf)).append(str3);
            i2 = indexOf + length;
            i--;
            if (i == 0) {
                break;
            }
            indexOf = str.indexOf(str2, i2);
        }
        sb.append(str.substring(i2));
        return sb.toString();
    }

    public static String replaceEach(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, false, 0);
    }

    public static String replaceEachRepeatedly(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, true, strArr == null ? 0 : strArr.length);
    }

    private static String replaceEach(String str, String[] strArr, String[] strArr2, boolean z, int i) {
        String str2;
        String str3;
        int length;
        String str4;
        if (str == null || str.length() == 0 || strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0) {
            return str;
        }
        if (i >= 0) {
            int length2 = strArr.length;
            int length3 = strArr2.length;
            if (length2 == length3) {
                boolean[] zArr = new boolean[length2];
                int i2 = -1;
                int i3 = -1;
                for (int i4 = 0; i4 < length2; i4++) {
                    if (!(zArr[i4] || (str4 = strArr[i4]) == null || str4.length() == 0 || strArr2[i4] == null)) {
                        int indexOf = str.indexOf(strArr[i4]);
                        if (indexOf == -1) {
                            zArr[i4] = true;
                        } else if (i2 == -1 || indexOf < i2) {
                            i3 = i4;
                            i2 = indexOf;
                        }
                    }
                }
                if (i2 == -1) {
                    return str;
                }
                int i5 = 0;
                for (int i6 = 0; i6 < strArr.length; i6++) {
                    if (!(strArr[i6] == null || (str3 = strArr2[i6]) == null || (length = str3.length() - strArr[i6].length()) <= 0)) {
                        i5 += length * 3;
                    }
                }
                StringBuilder sb = new StringBuilder(str.length() + Math.min(i5, str.length() / 5));
                int i7 = 0;
                while (i2 != -1) {
                    while (i7 < i2) {
                        sb.append(str.charAt(i7));
                        i7++;
                    }
                    sb.append(strArr2[i3]);
                    i7 = strArr[i3].length() + i2;
                    i2 = -1;
                    i3 = -1;
                    for (int i8 = 0; i8 < length2; i8++) {
                        if (!(zArr[i8] || (str2 = strArr[i8]) == null || str2.length() == 0 || strArr2[i8] == null)) {
                            int indexOf2 = str.indexOf(strArr[i8], i7);
                            if (indexOf2 == -1) {
                                zArr[i8] = true;
                            } else if (i2 == -1 || indexOf2 < i2) {
                                i3 = i8;
                                i2 = indexOf2;
                            }
                        }
                    }
                }
                int length4 = str.length();
                while (i7 < length4) {
                    sb.append(str.charAt(i7));
                    i7++;
                }
                String sb2 = sb.toString();
                if (!z) {
                    return sb2;
                }
                return replaceEach(sb2, strArr, strArr2, z, i - 1);
            }
            throw new IllegalArgumentException("Search and Replace array lengths don't match: " + length2 + " vs " + length3);
        }
        throw new IllegalStateException("TimeToLive of " + i + " is less than 0: " + str);
    }

    public static String replaceChars(String str, char c, char c2) {
        if (str == null) {
            return null;
        }
        return str.replace(c, c2);
    }

    public static String replaceChars(String str, String str2, String str3) {
        if (isEmpty(str) || isEmpty(str2)) {
            return str;
        }
        if (str3 == null) {
            str3 = "";
        }
        int length = str3.length();
        int length2 = str.length();
        StringBuilder sb = new StringBuilder(length2);
        boolean z = false;
        for (int i = 0; i < length2; i++) {
            char charAt = str.charAt(i);
            int indexOf = str2.indexOf(charAt);
            if (indexOf >= 0) {
                if (indexOf < length) {
                    sb.append(str3.charAt(indexOf));
                }
                z = true;
            } else {
                sb.append(charAt);
            }
        }
        return z ? sb.toString() : str;
    }

    public static String overlay(String str, String str2, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        int length = str.length();
        if (i < 0) {
            i = 0;
        }
        if (i > length) {
            i = length;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > length) {
            i2 = length;
        }
        if (i > i2) {
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        return new StringBuilder(((length + i) - i2) + str2.length() + 1).append(str.substring(0, i)).append(str2).append(str.substring(i2)).toString();
    }

    public static String chomp(String str) {
        if (isEmpty(str)) {
            return str;
        }
        if (str.length() == 1) {
            char charAt = str.charAt(0);
            return (charAt == 13 || charAt == 10) ? "" : str;
        }
        int length = str.length() - 1;
        char charAt2 = str.charAt(length);
        if (charAt2 == 10) {
            if (str.charAt(length - 1) == 13) {
                length--;
            }
        } else if (charAt2 != 13) {
            length++;
        }
        return str.substring(0, length);
    }

    public static String chomp(String str, String str2) {
        return (isEmpty(str) || str2 == null || !str.endsWith(str2)) ? str : str.substring(0, str.length() - str2.length());
    }

    public static String chop(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length < 2) {
            return "";
        }
        int i = length - 1;
        String substring = str.substring(0, i);
        if (str.charAt(i) == 10) {
            int i2 = i - 1;
            if (substring.charAt(i2) == 13) {
                return substring.substring(0, i2);
            }
        }
        return substring;
    }

    public static String repeat(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i <= 0) {
            return "";
        }
        int length = str.length();
        if (i == 1 || length == 0) {
            return str;
        }
        if (length == 1 && i <= 8192) {
            return repeat(str.charAt(0), i);
        }
        int i2 = length * i;
        if (length == 1) {
            return repeat(str.charAt(0), i);
        }
        if (length != 2) {
            StringBuilder sb = new StringBuilder(i2);
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(str);
            }
            return sb.toString();
        }
        char charAt = str.charAt(0);
        char charAt2 = str.charAt(1);
        char[] cArr = new char[i2];
        for (int i4 = (i * 2) - 2; i4 >= 0; i4 = (i4 - 1) - 1) {
            cArr[i4] = charAt;
            cArr[i4 + 1] = charAt2;
        }
        return new String(cArr);
    }

    public static String repeat(String str, String str2, int i) {
        if (str == null || str2 == null) {
            return repeat(str, i);
        }
        return removeEnd(repeat(str + str2, i), str2);
    }

    public static String repeat(char c, int i) {
        char[] cArr = new char[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            cArr[i2] = c;
        }
        return new String(cArr);
    }

    public static String rightPad(String str, int i) {
        return rightPad(str, i, ' ');
    }

    public static String rightPad(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return rightPad(str, i, String.valueOf(c));
        }
        return str.concat(repeat(c, length));
    }

    public static String rightPad(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return rightPad(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str.concat(str2);
        }
        if (length2 < length) {
            return str.concat(str2.substring(0, length2));
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i2 = 0; i2 < length2; i2++) {
            cArr[i2] = charArray[i2 % length];
        }
        return str.concat(new String(cArr));
    }

    public static String leftPad(String str, int i) {
        return leftPad(str, i, ' ');
    }

    public static String leftPad(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return leftPad(str, i, String.valueOf(c));
        }
        return repeat(c, length).concat(str);
    }

    public static String leftPad(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return leftPad(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i2 = 0; i2 < length2; i2++) {
            cArr[i2] = charArray[i2 % length];
        }
        return new String(cArr).concat(str);
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static String center(String str, int i) {
        return center(str, i, ' ');
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r2.length();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String center(java.lang.String r2, int r3, char r4) {
        /*
            if (r2 == 0) goto L_0x0019
            if (r3 > 0) goto L_0x0005
            goto L_0x0019
        L_0x0005:
            int r0 = r2.length()
            int r1 = r3 - r0
            if (r1 > 0) goto L_0x000e
            return r2
        L_0x000e:
            int r1 = r1 / 2
            int r0 = r0 + r1
            java.lang.String r2 = leftPad((java.lang.String) r2, (int) r0, (char) r4)
            java.lang.String r2 = rightPad((java.lang.String) r2, (int) r3, (char) r4)
        L_0x0019:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.center(java.lang.String, int, char):java.lang.String");
    }

    public static String center(String str, int i, String str2) {
        if (str == null || i <= 0) {
            return str;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str.length();
        int i2 = i - length;
        if (i2 <= 0) {
            return str;
        }
        return rightPad(leftPad(str, length + (i2 / 2), str2), i, str2);
    }

    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public static String upperCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(locale);
    }

    public static String lowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    public static String lowerCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(locale);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r2.length();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String capitalize(java.lang.String r2) {
        /*
            if (r2 == 0) goto L_0x0028
            int r0 = r2.length()
            if (r0 != 0) goto L_0x0009
            goto L_0x0028
        L_0x0009:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r0 = 0
            char r0 = r2.charAt(r0)
            char r0 = java.lang.Character.toTitleCase(r0)
            java.lang.StringBuilder r0 = r1.append(r0)
            r1 = 1
            java.lang.String r2 = r2.substring(r1)
            java.lang.StringBuilder r2 = r0.append(r2)
            java.lang.String r2 = r2.toString()
        L_0x0028:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.capitalize(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r2.length();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String uncapitalize(java.lang.String r2) {
        /*
            if (r2 == 0) goto L_0x0028
            int r0 = r2.length()
            if (r0 != 0) goto L_0x0009
            goto L_0x0028
        L_0x0009:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r0 = 0
            char r0 = r2.charAt(r0)
            char r0 = java.lang.Character.toLowerCase(r0)
            java.lang.StringBuilder r0 = r1.append(r0)
            r1 = 1
            java.lang.String r2 = r2.substring(r1)
            java.lang.StringBuilder r2 = r0.append(r2)
            java.lang.String r2 = r2.toString()
        L_0x0028:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.uncapitalize(java.lang.String):java.lang.String");
    }

    public static String swapCase(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (Character.isUpperCase(c)) {
                charArray[i] = Character.toLowerCase(c);
            } else if (Character.isTitleCase(c)) {
                charArray[i] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                charArray[i] = Character.toUpperCase(c);
            }
        }
        return new String(charArray);
    }

    public static int countMatches(CharSequence charSequence, CharSequence charSequence2) {
        int i = 0;
        if (isEmpty(charSequence) || isEmpty(charSequence2)) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int indexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, i);
            if (indexOf == -1) {
                return i2;
            }
            i2++;
            i = indexOf + charSequence2.length();
        }
    }

    public static boolean isAlpha(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetter(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphaSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetter(charSequence.charAt(i)) && charSequence.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumeric(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i)) && charSequence.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAsciiPrintable(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!CharUtils.isAsciiPrintable(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumeric(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(charSequence.charAt(i)) && charSequence.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isWhitespace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllLowerCase(CharSequence charSequence) {
        if (charSequence == null || isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLowerCase(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllUpperCase(CharSequence charSequence) {
        if (charSequence == null || isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isUpperCase(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static <T extends CharSequence> T defaultIfBlank(T t, T t2) {
        return isBlank(t) ? t2 : t;
    }

    public static <T extends CharSequence> T defaultIfEmpty(T t, T t2) {
        return isEmpty(t) ? t2 : t;
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseDelimited(String str, char c) {
        if (str == null) {
            return null;
        }
        String[] split = split(str, c);
        ArrayUtils.reverse((Object[]) split);
        return join((Object[]) split, c);
    }

    public static String abbreviate(String str, int i) {
        return abbreviate(str, 0, i);
    }

    public static String abbreviate(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 4) {
            throw new IllegalArgumentException("Minimum abbreviation width is 4");
        } else if (str.length() <= i2) {
            return str;
        } else {
            if (i > str.length()) {
                i = str.length();
            }
            int i3 = i2 - 3;
            if (str.length() - i < i3) {
                i = str.length() - i3;
            }
            if (i <= 4) {
                return str.substring(0, i3) + "...";
            }
            if (i2 < 7) {
                throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
            } else if (i + i3 < str.length()) {
                return "..." + abbreviate(str.substring(i), i3);
            } else {
                return "..." + str.substring(str.length() - i3);
            }
        }
    }

    public static String abbreviateMiddle(String str, String str2, int i) {
        if (isEmpty(str) || isEmpty(str2) || i >= str.length() || i < str2.length() + 2) {
            return str;
        }
        int length = i - str2.length();
        int i2 = length / 2;
        int i3 = (length % 2) + i2;
        int length2 = str.length() - i2;
        StringBuilder sb = new StringBuilder(i);
        sb.append(str.substring(0, i3));
        sb.append(str2);
        sb.append(str.substring(length2));
        return sb.toString();
    }

    public static String difference(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        int indexOfDifference = indexOfDifference(str, str2);
        if (indexOfDifference == -1) {
            return "";
        }
        return str2.substring(indexOfDifference);
    }

    public static int indexOfDifference(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return -1;
        }
        int i = 0;
        if (!(charSequence == null || charSequence2 == null)) {
            while (i < charSequence.length() && i < charSequence2.length() && charSequence.charAt(i) == charSequence2.charAt(i)) {
                i++;
            }
            if (i < charSequence2.length() || i < charSequence.length()) {
                return i;
            }
            return -1;
        }
        return i;
    }

    public static int indexOfDifference(CharSequence... charSequenceArr) {
        if (charSequenceArr != null && charSequenceArr.length > 1) {
            int length = charSequenceArr.length;
            int i = Integer.MAX_VALUE;
            boolean z = true;
            int i2 = 0;
            boolean z2 = false;
            for (int i3 = 0; i3 < length; i3++) {
                CharSequence charSequence = charSequenceArr[i3];
                if (charSequence == null) {
                    z2 = true;
                    i = 0;
                } else {
                    i = Math.min(charSequence.length(), i);
                    i2 = Math.max(charSequenceArr[i3].length(), i2);
                    z = false;
                }
            }
            if (!z && (i2 != 0 || z2)) {
                if (i == 0) {
                    return 0;
                }
                int i4 = -1;
                for (int i5 = 0; i5 < i; i5++) {
                    char charAt = charSequenceArr[0].charAt(i5);
                    int i6 = 1;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        } else if (charSequenceArr[i6].charAt(i5) != charAt) {
                            i4 = i5;
                            break;
                        } else {
                            i6++;
                        }
                    }
                    if (i4 != -1) {
                        break;
                    }
                }
                return (i4 != -1 || i == i2) ? i4 : i;
            }
        }
        return -1;
    }

    public static String getCommonPrefix(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        int indexOfDifference = indexOfDifference(strArr);
        if (indexOfDifference == -1) {
            String str = strArr[0];
            if (str == null) {
                return "";
            }
            return str;
        } else if (indexOfDifference == 0) {
            return "";
        } else {
            return strArr[0].substring(0, indexOfDifference);
        }
    }

    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int length = charSequence.length();
        int length2 = charSequence2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        if (length > length2) {
            int i = length2;
            length2 = charSequence.length();
            length = i;
        } else {
            CharSequence charSequence3 = charSequence2;
            charSequence2 = charSequence;
            charSequence = charSequence3;
        }
        int i2 = length + 1;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 <= length; i3++) {
            iArr[i3] = i3;
        }
        int i4 = 1;
        while (i4 <= length2) {
            char charAt = charSequence.charAt(i4 - 1);
            iArr2[0] = i4;
            for (int i5 = 1; i5 <= length; i5++) {
                int i6 = i5 - 1;
                iArr2[i5] = Math.min(Math.min(iArr2[i6] + 1, iArr[i5] + 1), iArr[i6] + (charSequence2.charAt(i6) == charAt ? 0 : 1));
            }
            i4++;
            int[] iArr3 = iArr;
            iArr = iArr2;
            iArr2 = iArr3;
        }
        return iArr[length];
    }

    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2, int i) {
        int i2;
        int i3;
        CharSequence charSequence3;
        CharSequence charSequence4;
        int i4 = i;
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        } else if (i4 >= 0) {
            int length = charSequence.length();
            int length2 = charSequence2.length();
            if (length == 0) {
                if (length2 <= i4) {
                    return length2;
                }
                return -1;
            } else if (length2 != 0) {
                if (length > length2) {
                    i2 = charSequence.length();
                    i3 = length2;
                    charSequence4 = charSequence;
                    charSequence3 = charSequence2;
                } else {
                    i3 = length;
                    i2 = length2;
                    charSequence3 = charSequence;
                    charSequence4 = charSequence2;
                }
                int i5 = i3 + 1;
                int[] iArr = new int[i5];
                int[] iArr2 = new int[i5];
                int min = Math.min(i3, i4) + 1;
                char c = 0;
                for (int i6 = 0; i6 < min; i6++) {
                    iArr[i6] = i6;
                }
                int i7 = Integer.MAX_VALUE;
                Arrays.fill(iArr, min, i5, Integer.MAX_VALUE);
                Arrays.fill(iArr2, Integer.MAX_VALUE);
                int i8 = 1;
                while (i8 <= i2) {
                    char charAt = charSequence4.charAt(i8 - 1);
                    iArr2[c] = i8;
                    int max = Math.max(1, i8 - i4);
                    int min2 = Math.min(i3, i8 + i4);
                    if (max > min2) {
                        return -1;
                    }
                    if (max > 1) {
                        iArr2[max - 1] = i7;
                    }
                    while (max <= min2) {
                        int i9 = max - 1;
                        if (charSequence3.charAt(i9) == charAt) {
                            iArr2[max] = iArr[i9];
                        } else {
                            iArr2[max] = Math.min(Math.min(iArr2[i9], iArr[max]), iArr[i9]) + 1;
                        }
                        max++;
                    }
                    i8++;
                    c = 0;
                    i7 = Integer.MAX_VALUE;
                    int[] iArr3 = iArr2;
                    iArr2 = iArr;
                    iArr = iArr3;
                }
                int i10 = iArr[i3];
                if (i10 <= i4) {
                    return i10;
                }
                return -1;
            } else if (length <= i4) {
                return length;
            } else {
                return -1;
            }
        } else {
            throw new IllegalArgumentException("Threshold must not be negative");
        }
    }

    public static boolean startsWith(CharSequence charSequence, CharSequence charSequence2) {
        return startsWith(charSequence, charSequence2, false);
    }

    public static boolean startsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return startsWith(charSequence, charSequence2, true);
    }

    private static boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (charSequence == null || charSequence2 == null) {
            if (charSequence == null && charSequence2 == null) {
                return true;
            }
            return false;
        } else if (charSequence2.length() > charSequence.length()) {
            return false;
        } else {
            return CharSequenceUtils.regionMatches(charSequence, z, 0, charSequence2, 0, charSequence2.length());
        }
    }

    public static boolean startsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            for (CharSequence startsWith : charSequenceArr) {
                if (startsWith(charSequence, startsWith)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean endsWith(CharSequence charSequence, CharSequence charSequence2) {
        return endsWith(charSequence, charSequence2, false);
    }

    public static boolean endsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return endsWith(charSequence, charSequence2, true);
    }

    private static boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (charSequence == null || charSequence2 == null) {
            if (charSequence == null && charSequence2 == null) {
                return true;
            }
            return false;
        } else if (charSequence2.length() > charSequence.length()) {
            return false;
        } else {
            return CharSequenceUtils.regionMatches(charSequence, z, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length());
        }
    }

    public static String normalizeSpace(String str) {
        if (str == null) {
            return null;
        }
        return WHITESPACE_BLOCK.matcher(trim(str)).replaceAll(" ");
    }

    public static boolean endsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            for (CharSequence endsWith : charSequenceArr) {
                if (endsWith(charSequence, endsWith)) {
                    return true;
                }
            }
        }
        return false;
    }
}

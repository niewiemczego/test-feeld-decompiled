package com.squareup.moshi.adapters;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

final class Iso8601Utils {
    static final String GMT_ID = "GMT";
    static final TimeZone TIMEZONE_Z = TimeZone.getTimeZone(GMT_ID);

    Iso8601Utils() {
    }

    public static String format(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TIMEZONE_Z, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(24);
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        sb.append('.');
        padInt(sb, gregorianCalendar.get(14), 3);
        sb.append('Z');
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d0 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException -> 0x01aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01a2 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException -> 0x01aa }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date parse(java.lang.String r18) {
        /*
            r1 = r18
            r0 = 4
            r2 = 0
            int r3 = parseInt(r1, r2, r0)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r4 = 45
            boolean r5 = checkOffset(r1, r0, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            if (r5 == 0) goto L_0x0011
            r0 = 5
        L_0x0011:
            int r5 = r0 + 2
            int r0 = parseInt(r1, r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            boolean r7 = checkOffset(r1, r5, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            if (r7 == 0) goto L_0x001f
            int r5 = r5 + 1
        L_0x001f:
            int r7 = r5 + 2
            int r5 = parseInt(r1, r5, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r8 = 84
            boolean r8 = checkOffset(r1, r7, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r9 = 1
            if (r8 != 0) goto L_0x003f
            int r10 = r18.length()     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            if (r10 > r7) goto L_0x003f
            java.util.GregorianCalendar r2 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            int r0 = r0 - r9
            r2.<init>(r3, r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.util.Date r0 = r2.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            return r0
        L_0x003f:
            r10 = 43
            r11 = 90
            if (r8 == 0) goto L_0x00c2
            int r7 = r7 + 1
            int r8 = r7 + 2
            int r7 = parseInt(r1, r7, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r12 = 58
            boolean r13 = checkOffset(r1, r8, r12)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            if (r13 == 0) goto L_0x0057
            int r8 = r8 + 1
        L_0x0057:
            int r13 = r8 + 2
            int r8 = parseInt(r1, r8, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            boolean r12 = checkOffset(r1, r13, r12)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            if (r12 == 0) goto L_0x0065
            int r13 = r13 + 1
        L_0x0065:
            int r12 = r18.length()     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            if (r12 <= r13) goto L_0x00ba
            char r12 = r1.charAt(r13)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            if (r12 == r11) goto L_0x00ba
            if (r12 == r10) goto L_0x00ba
            if (r12 == r4) goto L_0x00ba
            int r12 = r13 + 2
            int r13 = parseInt(r1, r13, r12)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r14 = 59
            if (r13 <= r14) goto L_0x0084
            r15 = 63
            if (r13 >= r15) goto L_0x0084
            r13 = r14
        L_0x0084:
            r14 = 46
            boolean r14 = checkOffset(r1, r12, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            if (r14 == 0) goto L_0x00b2
            int r12 = r12 + 1
            int r14 = r12 + 1
            int r14 = indexOfNonDigit(r1, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            int r15 = r12 + 3
            int r15 = java.lang.Math.min(r14, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            int r6 = parseInt(r1, r12, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r16 = r3
            r2 = 4621819117588971520(0x4024000000000000, double:10.0)
            int r15 = r15 - r12
            int r12 = 3 - r15
            r17 = r5
            double r4 = (double) r12     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            double r2 = java.lang.Math.pow(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            double r4 = (double) r6     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            double r2 = r2 * r4
            int r2 = (int) r2     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r3 = r7
            r7 = r14
            goto L_0x00ca
        L_0x00b2:
            r16 = r3
            r17 = r5
            r3 = r7
            r7 = r12
            r2 = 0
            goto L_0x00ca
        L_0x00ba:
            r16 = r3
            r17 = r5
            r3 = r7
            r7 = r13
            r2 = 0
            goto L_0x00c9
        L_0x00c2:
            r16 = r3
            r17 = r5
            r2 = 0
            r3 = 0
            r8 = 0
        L_0x00c9:
            r13 = 0
        L_0x00ca:
            int r4 = r18.length()     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            if (r4 <= r7) goto L_0x01a2
            char r4 = r1.charAt(r7)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            if (r4 != r11) goto L_0x00da
            java.util.TimeZone r4 = TIMEZONE_Z     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            goto L_0x0170
        L_0x00da:
            if (r4 == r10) goto L_0x0100
            r5 = 45
            if (r4 != r5) goto L_0x00e1
            goto L_0x0100
        L_0x00e1:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r2.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.String r3 = "Invalid time zone indicator '"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.String r3 = "'"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.String r2 = r2.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r0.<init>(r2)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
        L_0x0100:
            java.lang.String r4 = r1.substring(r7)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.String r5 = "+0000"
            boolean r5 = r5.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            if (r5 != 0) goto L_0x016e
            java.lang.String r5 = "+00:00"
            boolean r5 = r5.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            if (r5 == 0) goto L_0x0115
            goto L_0x016e
        L_0x0115:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r5.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.String r6 = "GMT"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.StringBuilder r4 = r5.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.String r4 = r4.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.util.TimeZone r5 = java.util.TimeZone.getTimeZone(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.String r6 = r5.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            boolean r7 = r6.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            if (r7 != 0) goto L_0x016c
            java.lang.String r7 = ":"
            java.lang.String r10 = ""
            java.lang.String r6 = r6.replace(r7, r10)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            boolean r6 = r6.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            if (r6 == 0) goto L_0x0145
            goto L_0x016c
        L_0x0145:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r2.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.String r3 = "Mismatching time zone indicator: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.String r3 = " given, resolves to "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.String r3 = r5.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.String r2 = r2.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r0.<init>(r2)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
        L_0x016c:
            r4 = r5
            goto L_0x0170
        L_0x016e:
            java.util.TimeZone r4 = TIMEZONE_Z     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
        L_0x0170:
            java.util.GregorianCalendar r5 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r5.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r4 = 0
            r5.setLenient(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r4 = r16
            r5.set(r9, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            int r0 = r0 - r9
            r4 = 2
            r5.set(r4, r0)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r0 = r17
            r4 = 5
            r5.set(r4, r0)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r0 = 11
            r5.set(r0, r3)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r0 = 12
            r5.set(r0, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r0 = 13
            r5.set(r0, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            r0 = 14
            r5.set(r0, r2)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.util.Date r0 = r5.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            return r0
        L_0x01a2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            java.lang.String r2 = "No time zone indicator"
            r0.<init>(r2)     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01ac, IllegalArgumentException -> 0x01aa }
        L_0x01aa:
            r0 = move-exception
            goto L_0x01ad
        L_0x01ac:
            r0 = move-exception
        L_0x01ad:
            com.squareup.moshi.JsonDataException r2 = new com.squareup.moshi.JsonDataException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Not an RFC 3339 date: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            r2.<init>(r1, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.adapters.Iso8601Utils.parse(java.lang.String):java.util.Date");
    }

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                i3 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 >= 0) {
                i3 = (i3 * 10) - digit2;
                i4 = i5;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        }
        return -i3;
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}

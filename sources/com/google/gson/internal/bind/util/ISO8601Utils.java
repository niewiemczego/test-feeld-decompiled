package com.google.gson.internal.bind.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    private static final String UTC_ID = "UTC";

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        char c = '-';
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
        if (z) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int abs = Math.abs(i / 60);
            int abs2 = Math.abs(i % 60);
            if (offset >= 0) {
                c = '+';
            }
            sb.append(c);
            padInt(sb, abs, 2);
            sb.append(':');
            padInt(sb, abs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d3 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01c3 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01cb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date parse(java.lang.String r17, java.text.ParsePosition r18) throws java.text.ParseException {
        /*
            r1 = r17
            r2 = r18
            int r0 = r18.getIndex()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            int r3 = r0 + 4
            int r0 = parseInt(r1, r0, r3)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r4 = 45
            boolean r5 = checkOffset(r1, r3, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            if (r5 == 0) goto L_0x0018
            int r3 = r3 + 1
        L_0x0018:
            int r5 = r3 + 2
            int r3 = parseInt(r1, r3, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            boolean r6 = checkOffset(r1, r5, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            if (r6 == 0) goto L_0x0026
            int r5 = r5 + 1
        L_0x0026:
            int r6 = r5 + 2
            int r5 = parseInt(r1, r5, r6)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r7 = 84
            boolean r7 = checkOffset(r1, r6, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r8 = 0
            r9 = 1
            if (r7 != 0) goto L_0x004d
            int r10 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            if (r10 > r6) goto L_0x004d
            java.util.GregorianCalendar r4 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            int r3 = r3 - r9
            r4.<init>(r0, r3, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r4.setLenient(r8)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r2.setIndex(r6)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.util.Date r0 = r4.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            return r0
        L_0x004d:
            r10 = 43
            r11 = 90
            r12 = 2
            if (r7 == 0) goto L_0x00c9
            int r6 = r6 + 1
            int r7 = r6 + 2
            int r6 = parseInt(r1, r6, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r13 = 58
            boolean r14 = checkOffset(r1, r7, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            if (r14 == 0) goto L_0x0066
            int r7 = r7 + 1
        L_0x0066:
            int r14 = r7 + 2
            int r7 = parseInt(r1, r7, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            boolean r13 = checkOffset(r1, r14, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            if (r13 == 0) goto L_0x0074
            int r14 = r14 + 1
        L_0x0074:
            int r13 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            if (r13 <= r14) goto L_0x00c4
            char r13 = r1.charAt(r14)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            if (r13 == r11) goto L_0x00c4
            if (r13 == r10) goto L_0x00c4
            if (r13 == r4) goto L_0x00c4
            int r13 = r14 + 2
            int r14 = parseInt(r1, r14, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r15 = 59
            if (r14 <= r15) goto L_0x0094
            r15 = 63
            if (r14 >= r15) goto L_0x0094
            r14 = 59
        L_0x0094:
            r15 = 46
            boolean r15 = checkOffset(r1, r13, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            if (r15 == 0) goto L_0x00bf
            int r13 = r13 + 1
            int r15 = r13 + 1
            int r15 = indexOfNonDigit(r1, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            int r8 = r13 + 3
            int r8 = java.lang.Math.min(r15, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            int r16 = parseInt(r1, r13, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            int r8 = r8 - r13
            if (r8 == r9) goto L_0x00b7
            if (r8 == r12) goto L_0x00b4
            goto L_0x00b9
        L_0x00b4:
            int r16 = r16 * 10
            goto L_0x00b9
        L_0x00b7:
            int r16 = r16 * 100
        L_0x00b9:
            r8 = r7
            r13 = r16
            r7 = r6
            r6 = r15
            goto L_0x00cd
        L_0x00bf:
            r8 = r7
            r7 = r6
            r6 = r13
            r13 = 0
            goto L_0x00cd
        L_0x00c4:
            r8 = r7
            r13 = 0
            r7 = r6
            r6 = r14
            goto L_0x00cc
        L_0x00c9:
            r7 = 0
            r8 = 0
            r13 = 0
        L_0x00cc:
            r14 = 0
        L_0x00cd:
            int r15 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            if (r15 <= r6) goto L_0x01c3
            char r15 = r1.charAt(r6)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r12 = 5
            if (r15 != r11) goto L_0x00df
            java.util.TimeZone r4 = TIMEZONE_UTC     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            int r6 = r6 + r9
            goto L_0x0192
        L_0x00df:
            if (r15 == r10) goto L_0x0103
            if (r15 != r4) goto L_0x00e4
            goto L_0x0103
        L_0x00e4:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r3.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.String r4 = "Invalid time zone indicator '"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.StringBuilder r3 = r3.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.String r4 = "'"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
        L_0x0103:
            java.lang.String r4 = r1.substring(r6)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            int r10 = r4.length()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            if (r10 < r12) goto L_0x010e
            goto L_0x0121
        L_0x010e:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r10.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.StringBuilder r4 = r10.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.String r10 = "00"
            java.lang.StringBuilder r4 = r4.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.String r4 = r4.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
        L_0x0121:
            int r10 = r4.length()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            int r6 = r6 + r10
            java.lang.String r10 = "+0000"
            boolean r10 = r10.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            if (r10 != 0) goto L_0x0190
            java.lang.String r10 = "+00:00"
            boolean r10 = r10.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            if (r10 == 0) goto L_0x0137
            goto L_0x0190
        L_0x0137:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r10.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.String r11 = "GMT"
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.StringBuilder r4 = r10.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.String r4 = r4.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.util.TimeZone r10 = java.util.TimeZone.getTimeZone(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.String r11 = r10.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            boolean r15 = r11.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            if (r15 != 0) goto L_0x018e
            java.lang.String r15 = ":"
            java.lang.String r12 = ""
            java.lang.String r11 = r11.replace(r15, r12)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            boolean r11 = r11.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            if (r11 == 0) goto L_0x0167
            goto L_0x018e
        L_0x0167:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r3.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.String r5 = "Mismatching time zone indicator: "
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.String r4 = " given, resolves to "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.String r4 = r10.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
        L_0x018e:
            r4 = r10
            goto L_0x0192
        L_0x0190:
            java.util.TimeZone r4 = TIMEZONE_UTC     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
        L_0x0192:
            java.util.GregorianCalendar r10 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r10.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r4 = 0
            r10.setLenient(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r10.set(r9, r0)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            int r3 = r3 - r9
            r0 = 2
            r10.set(r0, r3)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r0 = 5
            r10.set(r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r0 = 11
            r10.set(r0, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r0 = 12
            r10.set(r0, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r0 = 13
            r10.set(r0, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r0 = 14
            r10.set(r0, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            r2.setIndex(r6)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.util.Date r0 = r10.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            return r0
        L_0x01c3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            java.lang.String r3 = "No time zone indicator"
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01cf, NumberFormatException -> 0x01cd, IllegalArgumentException -> 0x01cb }
        L_0x01cb:
            r0 = move-exception
            goto L_0x01d0
        L_0x01cd:
            r0 = move-exception
            goto L_0x01d0
        L_0x01cf:
            r0 = move-exception
        L_0x01d0:
            if (r1 != 0) goto L_0x01d4
            r1 = 0
            goto L_0x01eb
        L_0x01d4:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 34
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r1 = r1.toString()
        L_0x01eb:
            java.lang.String r3 = r0.getMessage()
            if (r3 == 0) goto L_0x01f7
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0218
        L_0x01f7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "("
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getName()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = ")"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x0218:
            java.text.ParseException r4 = new java.text.ParseException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to parse date ["
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r1 = r5.append(r1)
            java.lang.String r5 = "]: "
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            int r2 = r18.getIndex()
            r4.<init>(r1, r2)
            r4.initCause(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
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

package org.apache.commons.lang3.time;

import androidx.exifinterface.media.ExifInterface;
import com.braze.Constants;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

public class DurationFormatUtils {
    static final Object H = "H";
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'";
    static final Object M = "M";
    static final Object S = ExifInterface.LATITUDE_SOUTH;
    static final Object d = Constants.BRAZE_PUSH_NOTIFICATION_SOUND_DEFAULT_VALUE;
    static final Object m = "m";
    static final Object s = Constants.BRAZE_PUSH_SUMMARY_TEXT_KEY;
    static final Object y = ViewHierarchyNode.JsonKeys.Y;

    public static String formatDurationHMS(long j) {
        return formatDuration(j, "H:mm:ss.SSS");
    }

    public static String formatDurationISO(long j) {
        return formatDuration(j, ISO_EXTENDED_FORMAT_PATTERN, false);
    }

    public static String formatDuration(long j, String str) {
        return formatDuration(j, str, true);
    }

    public static String formatDuration(long j, String str, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        Token[] lexx = lexx(str);
        if (Token.containsTokenWithValue(lexx, d)) {
            int i5 = (int) (j / DateUtils.MILLIS_PER_DAY);
            j -= ((long) i5) * DateUtils.MILLIS_PER_DAY;
            i = i5;
        } else {
            i = 0;
        }
        if (Token.containsTokenWithValue(lexx, H)) {
            int i6 = (int) (j / DateUtils.MILLIS_PER_HOUR);
            j -= ((long) i6) * DateUtils.MILLIS_PER_HOUR;
            i2 = i6;
        } else {
            i2 = 0;
        }
        if (Token.containsTokenWithValue(lexx, m)) {
            int i7 = (int) (j / 60000);
            j -= ((long) i7) * 60000;
            i3 = i7;
        } else {
            i3 = 0;
        }
        if (Token.containsTokenWithValue(lexx, s)) {
            int i8 = (int) (j / 1000);
            j -= ((long) i8) * 1000;
            i4 = i8;
        } else {
            i4 = 0;
        }
        return format(lexx, 0, 0, i, i2, i3, i4, Token.containsTokenWithValue(lexx, S) ? (int) j : 0, z);
    }

    public static String formatDurationWords(long j, boolean z, boolean z2) {
        String formatDuration = formatDuration(j, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (z) {
            formatDuration = " " + formatDuration;
            String replaceOnce = StringUtils.replaceOnce(formatDuration, " 0 days", "");
            if (replaceOnce.length() != formatDuration.length()) {
                String replaceOnce2 = StringUtils.replaceOnce(replaceOnce, " 0 hours", "");
                if (replaceOnce2.length() != replaceOnce.length()) {
                    formatDuration = StringUtils.replaceOnce(replaceOnce2, " 0 minutes", "");
                    if (formatDuration.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
                    }
                } else {
                    formatDuration = replaceOnce;
                }
            }
            if (formatDuration.length() != 0) {
                formatDuration = formatDuration.substring(1);
            }
        }
        if (z2) {
            String replaceOnce3 = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
            if (replaceOnce3.length() != formatDuration.length()) {
                formatDuration = StringUtils.replaceOnce(replaceOnce3, " 0 minutes", "");
                if (formatDuration.length() != replaceOnce3.length()) {
                    String replaceOnce4 = StringUtils.replaceOnce(formatDuration, " 0 hours", "");
                    if (replaceOnce4.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(replaceOnce4, " 0 days", "");
                    }
                } else {
                    formatDuration = replaceOnce3;
                }
            }
        }
        return StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(" " + formatDuration, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String formatPeriodISO(long j, long j2) {
        return formatPeriod(j, j2, ISO_EXTENDED_FORMAT_PATTERN, false, TimeZone.getDefault());
    }

    public static String formatPeriod(long j, long j2, String str) {
        return formatPeriod(j, j2, str, true, TimeZone.getDefault());
    }

    public static String formatPeriod(long j, long j2, String str, boolean z, TimeZone timeZone) {
        int i;
        int i2;
        int i3;
        Token[] lexx = lexx(str);
        Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(new Date(j));
        Calendar instance2 = Calendar.getInstance(timeZone);
        instance2.setTime(new Date(j2));
        int i4 = instance2.get(14) - instance.get(14);
        int i5 = instance2.get(13) - instance.get(13);
        int i6 = instance2.get(12) - instance.get(12);
        int i7 = instance2.get(11) - instance.get(11);
        int i8 = instance2.get(5) - instance.get(5);
        int i9 = instance2.get(2) - instance.get(2);
        int i10 = instance2.get(1) - instance.get(1);
        while (i4 < 0) {
            i4 += 1000;
            i5--;
        }
        while (i5 < 0) {
            i5 += 60;
            i6--;
        }
        while (i6 < 0) {
            i6 += 60;
            i7--;
        }
        while (i7 < 0) {
            i7 += 24;
            i8--;
        }
        int i11 = 0;
        if (Token.containsTokenWithValue(lexx, M)) {
            while (i8 < 0) {
                i8 += instance.getActualMaximum(5);
                i9--;
                instance.add(2, 1);
            }
            while (i9 < 0) {
                i9 += 12;
                i10--;
            }
            if (!Token.containsTokenWithValue(lexx, y) && i10 != 0) {
                while (i10 != 0) {
                    i9 += i10 * 12;
                    i10 = 0;
                }
            }
            i = i9;
        } else {
            if (!Token.containsTokenWithValue(lexx, y)) {
                int i12 = instance2.get(1);
                if (i9 < 0) {
                    i12--;
                }
                while (instance.get(1) != i12) {
                    int actualMaximum = i8 + (instance.getActualMaximum(6) - instance.get(6));
                    if ((instance instanceof GregorianCalendar) && instance.get(2) == 1 && instance.get(5) == 29) {
                        actualMaximum++;
                    }
                    instance.add(1, 1);
                    i8 = actualMaximum + instance.get(6);
                }
                i10 = 0;
            }
            while (instance.get(2) != instance2.get(2)) {
                i8 += instance.getActualMaximum(5);
                instance.add(2, 1);
            }
            i = 0;
            while (i8 < 0) {
                i8 += instance.getActualMaximum(5);
                i--;
                instance.add(2, 1);
            }
        }
        int i13 = i10;
        if (!Token.containsTokenWithValue(lexx, d)) {
            i7 += i8 * 24;
            i2 = 0;
        } else {
            i2 = i8;
        }
        if (!Token.containsTokenWithValue(lexx, H)) {
            i6 += i7 * 60;
            i7 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, m)) {
            i5 += i6 * 60;
            i6 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, s)) {
            i3 = i4 + (i5 * 1000);
        } else {
            i3 = i4;
            i11 = i5;
        }
        return format(lexx, i13, i, i2, i7, i6, i11, i3, z);
    }

    static String format(Token[] tokenArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        int i8 = i7;
        boolean z2 = false;
        for (Token token : tokenArr) {
            Object value = token.getValue();
            int count = token.getCount();
            if (value instanceof StringBuffer) {
                stringBuffer.append(value.toString());
            } else {
                if (value == y) {
                    String num = Integer.toString(i);
                    if (z) {
                        num = StringUtils.leftPad(num, count, '0');
                    }
                    stringBuffer.append(num);
                } else if (value == M) {
                    String num2 = Integer.toString(i2);
                    if (z) {
                        num2 = StringUtils.leftPad(num2, count, '0');
                    }
                    stringBuffer.append(num2);
                } else if (value == d) {
                    String num3 = Integer.toString(i3);
                    if (z) {
                        num3 = StringUtils.leftPad(num3, count, '0');
                    }
                    stringBuffer.append(num3);
                } else if (value == H) {
                    String num4 = Integer.toString(i4);
                    if (z) {
                        num4 = StringUtils.leftPad(num4, count, '0');
                    }
                    stringBuffer.append(num4);
                } else if (value == m) {
                    String num5 = Integer.toString(i5);
                    if (z) {
                        num5 = StringUtils.leftPad(num5, count, '0');
                    }
                    stringBuffer.append(num5);
                } else if (value == s) {
                    String num6 = Integer.toString(i6);
                    if (z) {
                        num6 = StringUtils.leftPad(num6, count, '0');
                    }
                    stringBuffer.append(num6);
                    z2 = true;
                } else if (value == S) {
                    if (z2) {
                        i8 += 1000;
                        String num7 = Integer.toString(i8);
                        if (z) {
                            num7 = StringUtils.leftPad(num7, count, '0');
                        }
                        stringBuffer.append(num7.substring(1));
                    } else {
                        String num8 = Integer.toString(i8);
                        if (z) {
                            num8 = StringUtils.leftPad(num8, count, '0');
                        }
                        stringBuffer.append(num8);
                    }
                }
                z2 = false;
            }
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0093 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static org.apache.commons.lang3.time.DurationFormatUtils.Token[] lexx(java.lang.String r10) {
        /*
            char[] r10 = r10.toCharArray()
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r10.length
            r0.<init>(r1)
            int r1 = r10.length
            r2 = 0
            r3 = 0
            r4 = r2
            r5 = r4
            r6 = r3
            r7 = r6
        L_0x0011:
            if (r4 >= r1) goto L_0x0097
            char r8 = r10[r4]
            r9 = 39
            if (r5 == 0) goto L_0x0020
            if (r8 == r9) goto L_0x0020
            r6.append(r8)
            goto L_0x0093
        L_0x0020:
            if (r8 == r9) goto L_0x0066
            r9 = 72
            if (r8 == r9) goto L_0x0063
            r9 = 77
            if (r8 == r9) goto L_0x0060
            r9 = 83
            if (r8 == r9) goto L_0x005d
            r9 = 100
            if (r8 == r9) goto L_0x005a
            r9 = 109(0x6d, float:1.53E-43)
            if (r8 == r9) goto L_0x0057
            r9 = 115(0x73, float:1.61E-43)
            if (r8 == r9) goto L_0x0054
            r9 = 121(0x79, float:1.7E-43)
            if (r8 == r9) goto L_0x0051
            if (r6 != 0) goto L_0x004d
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            r6.<init>()
            org.apache.commons.lang3.time.DurationFormatUtils$Token r9 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r9.<init>(r6)
            r0.add(r9)
        L_0x004d:
            r6.append(r8)
            goto L_0x007a
        L_0x0051:
            java.lang.Object r8 = y
            goto L_0x007b
        L_0x0054:
            java.lang.Object r8 = s
            goto L_0x007b
        L_0x0057:
            java.lang.Object r8 = m
            goto L_0x007b
        L_0x005a:
            java.lang.Object r8 = d
            goto L_0x007b
        L_0x005d:
            java.lang.Object r8 = S
            goto L_0x007b
        L_0x0060:
            java.lang.Object r8 = M
            goto L_0x007b
        L_0x0063:
            java.lang.Object r8 = H
            goto L_0x007b
        L_0x0066:
            if (r5 == 0) goto L_0x006c
            r5 = r2
            r6 = r3
            r8 = r6
            goto L_0x007b
        L_0x006c:
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            r6.<init>()
            org.apache.commons.lang3.time.DurationFormatUtils$Token r5 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r5.<init>(r6)
            r0.add(r5)
            r5 = 1
        L_0x007a:
            r8 = r3
        L_0x007b:
            if (r8 == 0) goto L_0x0093
            if (r7 == 0) goto L_0x0089
            java.lang.Object r6 = r7.getValue()
            if (r6 != r8) goto L_0x0089
            r7.increment()
            goto L_0x0092
        L_0x0089:
            org.apache.commons.lang3.time.DurationFormatUtils$Token r6 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r6.<init>(r8)
            r0.add(r6)
            r7 = r6
        L_0x0092:
            r6 = r3
        L_0x0093:
            int r4 = r4 + 1
            goto L_0x0011
        L_0x0097:
            int r10 = r0.size()
            org.apache.commons.lang3.time.DurationFormatUtils$Token[] r10 = new org.apache.commons.lang3.time.DurationFormatUtils.Token[r10]
            java.lang.Object[] r10 = r0.toArray(r10)
            org.apache.commons.lang3.time.DurationFormatUtils$Token[] r10 = (org.apache.commons.lang3.time.DurationFormatUtils.Token[]) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DurationFormatUtils.lexx(java.lang.String):org.apache.commons.lang3.time.DurationFormatUtils$Token[]");
    }

    static class Token {
        private int count;
        private final Object value;

        static boolean containsTokenWithValue(Token[] tokenArr, Object obj) {
            for (Token value2 : tokenArr) {
                if (value2.getValue() == obj) {
                    return true;
                }
            }
            return false;
        }

        Token(Object obj) {
            this.value = obj;
            this.count = 1;
        }

        Token(Object obj, int i) {
            this.value = obj;
            this.count = i;
        }

        /* access modifiers changed from: package-private */
        public void increment() {
            this.count++;
        }

        /* access modifiers changed from: package-private */
        public int getCount() {
            return this.count;
        }

        /* access modifiers changed from: package-private */
        public Object getValue() {
            return this.value;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.value.getClass() != token.value.getClass() || this.count != token.count) {
                return false;
            }
            Object obj2 = this.value;
            if (obj2 instanceof StringBuffer) {
                return obj2.toString().equals(token.value.toString());
            }
            if (obj2 instanceof Number) {
                return obj2.equals(token.value);
            }
            if (obj2 == token.value) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return StringUtils.repeat(this.value.toString(), this.count);
        }
    }
}

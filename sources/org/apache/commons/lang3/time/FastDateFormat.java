package org.apache.commons.lang3.time;

import com.launchdarkly.sdk.android.LDConfig;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.Validate;

public class FastDateFormat extends Format {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache = new ConcurrentHashMap(7);
    private static final FormatCache<FastDateFormat> cache = new FormatCache<FastDateFormat>() {
        /* access modifiers changed from: protected */
        public FastDateFormat createInstance(String str, TimeZone timeZone, Locale locale) {
            return new FastDateFormat(str, timeZone, locale);
        }
    };
    private static final long serialVersionUID = 1;
    private final Locale mLocale;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient Rule[] mRules;
    private final TimeZone mTimeZone;

    private interface NumberRule extends Rule {
        void appendTo(StringBuffer stringBuffer, int i);
    }

    private interface Rule {
        void appendTo(StringBuffer stringBuffer, Calendar calendar);

        int estimateLength();
    }

    public static FastDateFormat getInstance() {
        return cache.getDateTimeInstance(3, 3, (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getInstance(String str) {
        return cache.getInstance(str, (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone) {
        return cache.getInstance(str, timeZone, (Locale) null);
    }

    public static FastDateFormat getInstance(String str, Locale locale) {
        return cache.getInstance(str, (TimeZone) null, locale);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone, Locale locale) {
        return cache.getInstance(str, timeZone, locale);
    }

    public static FastDateFormat getDateInstance(int i) {
        return cache.getDateTimeInstance(Integer.valueOf(i), (Integer) null, (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getDateInstance(int i, Locale locale) {
        return cache.getDateTimeInstance(Integer.valueOf(i), (Integer) null, (TimeZone) null, locale);
    }

    public static FastDateFormat getDateInstance(int i, TimeZone timeZone) {
        return cache.getDateTimeInstance(Integer.valueOf(i), (Integer) null, timeZone, (Locale) null);
    }

    public static FastDateFormat getDateInstance(int i, TimeZone timeZone, Locale locale) {
        return cache.getDateTimeInstance(Integer.valueOf(i), (Integer) null, timeZone, locale);
    }

    public static FastDateFormat getTimeInstance(int i) {
        return cache.getDateTimeInstance((Integer) null, Integer.valueOf(i), (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getTimeInstance(int i, Locale locale) {
        return cache.getDateTimeInstance((Integer) null, Integer.valueOf(i), (TimeZone) null, locale);
    }

    public static FastDateFormat getTimeInstance(int i, TimeZone timeZone) {
        return cache.getDateTimeInstance((Integer) null, Integer.valueOf(i), timeZone, (Locale) null);
    }

    public static FastDateFormat getTimeInstance(int i, TimeZone timeZone, Locale locale) {
        return cache.getDateTimeInstance((Integer) null, Integer.valueOf(i), timeZone, locale);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2) {
        return cache.getDateTimeInstance(Integer.valueOf(i), Integer.valueOf(i2), (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2, Locale locale) {
        return cache.getDateTimeInstance(Integer.valueOf(i), Integer.valueOf(i2), (TimeZone) null, locale);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2, TimeZone timeZone) {
        return getDateTimeInstance(i, i2, timeZone, (Locale) null);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2, TimeZone timeZone, Locale locale) {
        return cache.getDateTimeInstance(Integer.valueOf(i), Integer.valueOf(i2), timeZone, locale);
    }

    static String getTimeZoneDisplay(TimeZone timeZone, boolean z, int i, Locale locale) {
        TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, z, i, locale);
        String str = (String) cTimeZoneDisplayCache.get(timeZoneDisplayKey);
        if (str != null) {
            return str;
        }
        String displayName = timeZone.getDisplayName(z, i, locale);
        String putIfAbsent = cTimeZoneDisplayCache.putIfAbsent(timeZoneDisplayKey, displayName);
        return putIfAbsent != null ? putIfAbsent : displayName;
    }

    protected FastDateFormat(String str, TimeZone timeZone, Locale locale) {
        this.mPattern = str;
        this.mTimeZone = timeZone;
        this.mLocale = locale;
        init();
    }

    private void init() {
        List<Rule> parsePattern = parsePattern();
        Rule[] ruleArr = (Rule[]) parsePattern.toArray(new Rule[parsePattern.size()]);
        this.mRules = ruleArr;
        int length = ruleArr.length;
        int i = 0;
        while (true) {
            length--;
            if (length >= 0) {
                i += this.mRules[length].estimateLength();
            } else {
                this.mMaxLengthEstimate = i;
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009b, code lost:
        r11 = r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<org.apache.commons.lang3.time.FastDateFormat.Rule> parsePattern() {
        /*
            r16 = this;
            r0 = r16
            java.text.DateFormatSymbols r1 = new java.text.DateFormatSymbols
            java.util.Locale r2 = r0.mLocale
            r1.<init>(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String[] r3 = r1.getEras()
            java.lang.String[] r4 = r1.getMonths()
            java.lang.String[] r5 = r1.getShortMonths()
            java.lang.String[] r6 = r1.getWeekdays()
            java.lang.String[] r7 = r1.getShortWeekdays()
            java.lang.String[] r1 = r1.getAmPmStrings()
            java.lang.String r8 = r0.mPattern
            int r8 = r8.length()
            r9 = 1
            int[] r10 = new int[r9]
            r11 = 0
            r12 = r11
        L_0x0031:
            if (r12 >= r8) goto L_0x0161
            r10[r11] = r12
            java.lang.String r12 = r0.mPattern
            java.lang.String r12 = r0.parseToken(r12, r10)
            r13 = r10[r11]
            int r14 = r12.length()
            if (r14 != 0) goto L_0x0045
            goto L_0x0161
        L_0x0045:
            char r15 = r12.charAt(r11)
            r9 = 121(0x79, float:1.7E-43)
            r11 = 4
            if (r15 == r9) goto L_0x0149
            r9 = 122(0x7a, float:1.71E-43)
            if (r15 == r9) goto L_0x012d
            r9 = 11
            switch(r15) {
                case 39: goto L_0x010f;
                case 75: goto L_0x0108;
                case 77: goto L_0x00ed;
                case 83: goto L_0x00e6;
                case 87: goto L_0x00e1;
                case 90: goto L_0x00d8;
                case 97: goto L_0x00d0;
                case 100: goto L_0x00ca;
                case 104: goto L_0x00be;
                case 107: goto L_0x00b4;
                case 109: goto L_0x00ad;
                case 115: goto L_0x00a6;
                case 119: goto L_0x00a0;
                default: goto L_0x0057;
            }
        L_0x0057:
            switch(r15) {
                case 68: goto L_0x0096;
                case 69: goto L_0x008a;
                case 70: goto L_0x0083;
                case 71: goto L_0x0078;
                case 72: goto L_0x0073;
                default: goto L_0x005a;
            }
        L_0x005a:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Illegal pattern component: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r12)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0073:
            org.apache.commons.lang3.time.FastDateFormat$NumberRule r9 = r0.selectNumberRule(r9, r14)
            goto L_0x009b
        L_0x0078:
            org.apache.commons.lang3.time.FastDateFormat$TextField r9 = new org.apache.commons.lang3.time.FastDateFormat$TextField
            r11 = 0
            r9.<init>(r11, r3)
            r15 = r11
        L_0x007f:
            r11 = r9
            r9 = 1
            goto L_0x0159
        L_0x0083:
            r9 = 8
            org.apache.commons.lang3.time.FastDateFormat$NumberRule r9 = r0.selectNumberRule(r9, r14)
            goto L_0x009b
        L_0x008a:
            org.apache.commons.lang3.time.FastDateFormat$TextField r9 = new org.apache.commons.lang3.time.FastDateFormat$TextField
            r12 = 7
            if (r14 >= r11) goto L_0x0091
            r11 = r7
            goto L_0x0092
        L_0x0091:
            r11 = r6
        L_0x0092:
            r9.<init>(r12, r11)
            goto L_0x009b
        L_0x0096:
            r9 = 6
            org.apache.commons.lang3.time.FastDateFormat$NumberRule r9 = r0.selectNumberRule(r9, r14)
        L_0x009b:
            r11 = r9
        L_0x009c:
            r9 = 1
        L_0x009d:
            r15 = 0
            goto L_0x0159
        L_0x00a0:
            r9 = 3
            org.apache.commons.lang3.time.FastDateFormat$NumberRule r9 = r0.selectNumberRule(r9, r14)
            goto L_0x009b
        L_0x00a6:
            r9 = 13
            org.apache.commons.lang3.time.FastDateFormat$NumberRule r9 = r0.selectNumberRule(r9, r14)
            goto L_0x009b
        L_0x00ad:
            r9 = 12
            org.apache.commons.lang3.time.FastDateFormat$NumberRule r9 = r0.selectNumberRule(r9, r14)
            goto L_0x009b
        L_0x00b4:
            org.apache.commons.lang3.time.FastDateFormat$TwentyFourHourField r11 = new org.apache.commons.lang3.time.FastDateFormat$TwentyFourHourField
            org.apache.commons.lang3.time.FastDateFormat$NumberRule r9 = r0.selectNumberRule(r9, r14)
            r11.<init>(r9)
            goto L_0x009c
        L_0x00be:
            org.apache.commons.lang3.time.FastDateFormat$TwelveHourField r9 = new org.apache.commons.lang3.time.FastDateFormat$TwelveHourField
            r11 = 10
            org.apache.commons.lang3.time.FastDateFormat$NumberRule r11 = r0.selectNumberRule(r11, r14)
            r9.<init>(r11)
            goto L_0x009b
        L_0x00ca:
            r9 = 5
            org.apache.commons.lang3.time.FastDateFormat$NumberRule r9 = r0.selectNumberRule(r9, r14)
            goto L_0x009b
        L_0x00d0:
            org.apache.commons.lang3.time.FastDateFormat$TextField r9 = new org.apache.commons.lang3.time.FastDateFormat$TextField
            r11 = 9
            r9.<init>(r11, r1)
            goto L_0x009b
        L_0x00d8:
            r9 = 1
            if (r14 != r9) goto L_0x00de
            org.apache.commons.lang3.time.FastDateFormat$TimeZoneNumberRule r9 = org.apache.commons.lang3.time.FastDateFormat.TimeZoneNumberRule.INSTANCE_NO_COLON
            goto L_0x009b
        L_0x00de:
            org.apache.commons.lang3.time.FastDateFormat$TimeZoneNumberRule r9 = org.apache.commons.lang3.time.FastDateFormat.TimeZoneNumberRule.INSTANCE_COLON
            goto L_0x009b
        L_0x00e1:
            org.apache.commons.lang3.time.FastDateFormat$NumberRule r9 = r0.selectNumberRule(r11, r14)
            goto L_0x009b
        L_0x00e6:
            r9 = 14
            org.apache.commons.lang3.time.FastDateFormat$NumberRule r9 = r0.selectNumberRule(r9, r14)
            goto L_0x009b
        L_0x00ed:
            if (r14 < r11) goto L_0x00f6
            org.apache.commons.lang3.time.FastDateFormat$TextField r9 = new org.apache.commons.lang3.time.FastDateFormat$TextField
            r11 = 2
            r9.<init>(r11, r4)
            goto L_0x009b
        L_0x00f6:
            r9 = 3
            r11 = 2
            if (r14 != r9) goto L_0x0100
            org.apache.commons.lang3.time.FastDateFormat$TextField r9 = new org.apache.commons.lang3.time.FastDateFormat$TextField
            r9.<init>(r11, r5)
            goto L_0x009b
        L_0x0100:
            if (r14 != r11) goto L_0x0105
            org.apache.commons.lang3.time.FastDateFormat$TwoDigitMonthField r9 = org.apache.commons.lang3.time.FastDateFormat.TwoDigitMonthField.INSTANCE
            goto L_0x009b
        L_0x0105:
            org.apache.commons.lang3.time.FastDateFormat$UnpaddedMonthField r9 = org.apache.commons.lang3.time.FastDateFormat.UnpaddedMonthField.INSTANCE
            goto L_0x009b
        L_0x0108:
            r9 = 10
            org.apache.commons.lang3.time.FastDateFormat$NumberRule r9 = r0.selectNumberRule(r9, r14)
            goto L_0x009b
        L_0x010f:
            r9 = 1
            java.lang.String r11 = r12.substring(r9)
            int r12 = r11.length()
            if (r12 != r9) goto L_0x0126
            org.apache.commons.lang3.time.FastDateFormat$CharacterLiteral r9 = new org.apache.commons.lang3.time.FastDateFormat$CharacterLiteral
            r12 = 0
            char r11 = r11.charAt(r12)
            r9.<init>(r11)
            goto L_0x009b
        L_0x0126:
            org.apache.commons.lang3.time.FastDateFormat$StringLiteral r9 = new org.apache.commons.lang3.time.FastDateFormat$StringLiteral
            r9.<init>(r11)
            goto L_0x009b
        L_0x012d:
            if (r14 < r11) goto L_0x013d
            org.apache.commons.lang3.time.FastDateFormat$TimeZoneNameRule r9 = new org.apache.commons.lang3.time.FastDateFormat$TimeZoneNameRule
            java.util.TimeZone r11 = r0.mTimeZone
            java.util.Locale r12 = r0.mLocale
            r14 = 1
            r9.<init>(r11, r12, r14)
            r11 = r9
            r9 = r14
            goto L_0x009d
        L_0x013d:
            org.apache.commons.lang3.time.FastDateFormat$TimeZoneNameRule r9 = new org.apache.commons.lang3.time.FastDateFormat$TimeZoneNameRule
            java.util.TimeZone r11 = r0.mTimeZone
            java.util.Locale r12 = r0.mLocale
            r15 = 0
            r9.<init>(r11, r12, r15)
            goto L_0x007f
        L_0x0149:
            r9 = 2
            r15 = 0
            if (r14 != r9) goto L_0x0151
            org.apache.commons.lang3.time.FastDateFormat$TwoDigitYearField r9 = org.apache.commons.lang3.time.FastDateFormat.TwoDigitYearField.INSTANCE
            goto L_0x007f
        L_0x0151:
            if (r14 >= r11) goto L_0x0154
            r14 = r11
        L_0x0154:
            r9 = 1
            org.apache.commons.lang3.time.FastDateFormat$NumberRule r11 = r0.selectNumberRule(r9, r14)
        L_0x0159:
            r2.add(r11)
            int r12 = r13 + 1
            r11 = r15
            goto L_0x0031
        L_0x0161:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.FastDateFormat.parsePattern():java.util.List");
    }

    /* access modifiers changed from: protected */
    public String parseToken(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb.append(charAt);
            while (true) {
                int i2 = i + 1;
                if (i2 >= length || str.charAt(i2) != charAt) {
                    break;
                }
                sb.append(charAt);
                i = i2;
            }
        } else {
            sb.append('\'');
            boolean z = false;
            while (true) {
                if (i >= length) {
                    break;
                }
                char charAt2 = str.charAt(i);
                if (charAt2 == '\'') {
                    int i3 = i + 1;
                    if (i3 >= length || str.charAt(i3) != '\'') {
                        z = !z;
                    } else {
                        sb.append(charAt2);
                        i = i3;
                    }
                } else if (z || ((charAt2 < 'A' || charAt2 > 'Z') && (charAt2 < 'a' || charAt2 > 'z'))) {
                    sb.append(charAt2);
                }
                i++;
            }
            i--;
        }
        iArr[0] = i;
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public NumberRule selectNumberRule(int i, int i2) {
        if (i2 == 1) {
            return new UnpaddedNumberField(i);
        }
        if (i2 != 2) {
            return new PaddedNumberField(i, i2);
        }
        return new TwoDigitNumberField(i);
    }

    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        throw new IllegalArgumentException("Unknown class: " + (obj == null ? "<null>" : obj.getClass().getName()));
    }

    public String format(long j) {
        return format(new Date(j));
    }

    public String format(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.mTimeZone, this.mLocale);
        gregorianCalendar.setTime(date);
        return applyRules(gregorianCalendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public String format(Calendar calendar) {
        return format(calendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public StringBuffer format(long j, StringBuffer stringBuffer) {
        return format(new Date(j), stringBuffer);
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.mTimeZone, this.mLocale);
        gregorianCalendar.setTime(date);
        return applyRules(gregorianCalendar, stringBuffer);
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return applyRules(calendar, stringBuffer);
    }

    /* access modifiers changed from: protected */
    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        for (Rule appendTo : this.mRules) {
            appendTo.appendTo(stringBuffer, calendar);
        }
        return stringBuffer;
    }

    public Object parseObject(String str, ParsePosition parsePosition) {
        parsePosition.setIndex(0);
        parsePosition.setErrorIndex(0);
        return null;
    }

    public String getPattern() {
        return this.mPattern;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateFormat)) {
            return false;
        }
        FastDateFormat fastDateFormat = (FastDateFormat) obj;
        if (!this.mPattern.equals(fastDateFormat.mPattern) || !this.mTimeZone.equals(fastDateFormat.mTimeZone) || !this.mLocale.equals(fastDateFormat.mLocale)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.mPattern.hashCode() + ((this.mTimeZone.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    public String toString() {
        return "FastDateFormat[" + this.mPattern + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init();
    }

    private static class CharacterLiteral implements Rule {
        private final char mValue;

        public int estimateLength() {
            return 1;
        }

        CharacterLiteral(char c) {
            this.mValue = c;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }
    }

    private static class StringLiteral implements Rule {
        private final String mValue;

        StringLiteral(String str) {
            this.mValue = str;
        }

        public int estimateLength() {
            return this.mValue.length();
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }
    }

    private static class TextField implements Rule {
        private final int mField;
        private final String[] mValues;

        TextField(int i, String[] strArr) {
            this.mField = i;
            this.mValues = strArr;
        }

        public int estimateLength() {
            int length = this.mValues.length;
            int i = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i;
                }
                int length2 = this.mValues[length].length();
                if (length2 > i) {
                    i = length2;
                }
            }
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValues[calendar.get(this.mField)]);
        }
    }

    private static class UnpaddedNumberField implements NumberRule {
        private final int mField;

        public int estimateLength() {
            return 4;
        }

        UnpaddedNumberField(int i) {
            this.mField = i;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            if (i < 10) {
                stringBuffer.append((char) (i + 48));
            } else if (i < 100) {
                stringBuffer.append((char) ((i / 10) + 48));
                stringBuffer.append((char) ((i % 10) + 48));
            } else {
                stringBuffer.append(Integer.toString(i));
            }
        }
    }

    private static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        public int estimateLength() {
            return 2;
        }

        UnpaddedMonthField() {
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            if (i < 10) {
                stringBuffer.append((char) (i + 48));
                return;
            }
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }
    }

    private static class PaddedNumberField implements NumberRule {
        private final int mField;
        private final int mSize;

        public int estimateLength() {
            return 4;
        }

        PaddedNumberField(int i, int i2) {
            if (i2 >= 3) {
                this.mField = i;
                this.mSize = i2;
                return;
            }
            throw new IllegalArgumentException();
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            int i2;
            if (i < 100) {
                int i3 = this.mSize;
                while (true) {
                    i3--;
                    if (i3 >= 2) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append((char) ((i / 10) + 48));
                        stringBuffer.append((char) ((i % 10) + 48));
                        return;
                    }
                }
            } else {
                if (i < 1000) {
                    i2 = 3;
                } else {
                    Validate.isTrue(i > -1, "Negative values should not be possible", (long) i);
                    i2 = Integer.toString(i).length();
                }
                int i4 = this.mSize;
                while (true) {
                    i4--;
                    if (i4 >= i2) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append(Integer.toString(i));
                        return;
                    }
                }
            }
        }
    }

    private static class TwoDigitNumberField implements NumberRule {
        private final int mField;

        public int estimateLength() {
            return 2;
        }

        TwoDigitNumberField(int i) {
            this.mField = i;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            if (i < 100) {
                stringBuffer.append((char) ((i / 10) + 48));
                stringBuffer.append((char) ((i % 10) + 48));
                return;
            }
            stringBuffer.append(Integer.toString(i));
        }
    }

    private static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        public int estimateLength() {
            return 2;
        }

        TwoDigitYearField() {
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(1) % 100);
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }
    }

    private static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        public int estimateLength() {
            return 2;
        }

        TwoDigitMonthField() {
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }
    }

    private static class TwelveHourField implements NumberRule {
        private final NumberRule mRule;

        TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(10);
            if (i == 0) {
                i = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(stringBuffer, i);
        }

        public void appendTo(StringBuffer stringBuffer, int i) {
            this.mRule.appendTo(stringBuffer, i);
        }
    }

    private static class TwentyFourHourField implements NumberRule {
        private final NumberRule mRule;

        TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(11);
            if (i == 0) {
                i = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(stringBuffer, i);
        }

        public void appendTo(StringBuffer stringBuffer, int i) {
            this.mRule.appendTo(stringBuffer, i);
        }
    }

    private static class TimeZoneNameRule implements Rule {
        private final String mDaylight;
        private final String mStandard;
        private final TimeZone mTimeZone;

        TimeZoneNameRule(TimeZone timeZone, Locale locale, int i) {
            this.mTimeZone = timeZone;
            this.mStandard = FastDateFormat.getTimeZoneDisplay(timeZone, false, i, locale);
            this.mDaylight = FastDateFormat.getTimeZoneDisplay(timeZone, true, i, locale);
        }

        public int estimateLength() {
            return Math.max(this.mStandard.length(), this.mDaylight.length());
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            if (!this.mTimeZone.useDaylightTime() || calendar.get(16) == 0) {
                stringBuffer.append(this.mStandard);
            } else {
                stringBuffer.append(this.mDaylight);
            }
        }
    }

    private static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        final boolean mColon;

        public int estimateLength() {
            return 5;
        }

        TimeZoneNumberRule(boolean z) {
            this.mColon = z;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(15) + calendar.get(16);
            if (i < 0) {
                stringBuffer.append('-');
                i = -i;
            } else {
                stringBuffer.append('+');
            }
            int i2 = i / LDConfig.DEFAULT_BACKGROUND_POLL_INTERVAL_MILLIS;
            stringBuffer.append((char) ((i2 / 10) + 48));
            stringBuffer.append((char) ((i2 % 10) + 48));
            if (this.mColon) {
                stringBuffer.append(':');
            }
            int i3 = (i / 60000) - (i2 * 60);
            stringBuffer.append((char) ((i3 / 10) + 48));
            stringBuffer.append((char) ((i3 % 10) + 48));
        }
    }

    private static class TimeZoneDisplayKey {
        private final Locale mLocale;
        private final int mStyle;
        private final TimeZone mTimeZone;

        TimeZoneDisplayKey(TimeZone timeZone, boolean z, int i, Locale locale) {
            this.mTimeZone = timeZone;
            this.mStyle = z ? i | Integer.MIN_VALUE : i;
            this.mLocale = locale;
        }

        public int hashCode() {
            return (((this.mStyle * 31) + this.mLocale.hashCode()) * 31) + this.mTimeZone.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeZoneDisplayKey)) {
                return false;
            }
            TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
            if (!this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) || this.mStyle != timeZoneDisplayKey.mStyle || !this.mLocale.equals(timeZoneDisplayKey.mLocale)) {
                return false;
            }
            return true;
        }
    }
}

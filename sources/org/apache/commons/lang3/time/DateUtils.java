package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DateUtils {
    public static final long MILLIS_PER_DAY = 86400000;
    public static final long MILLIS_PER_HOUR = 3600000;
    public static final long MILLIS_PER_MINUTE = 60000;
    public static final long MILLIS_PER_SECOND = 1000;
    private static final int MODIFY_CEILING = 2;
    private static final int MODIFY_ROUND = 1;
    private static final int MODIFY_TRUNCATE = 0;
    public static final int RANGE_MONTH_MONDAY = 6;
    public static final int RANGE_MONTH_SUNDAY = 5;
    public static final int RANGE_WEEK_CENTER = 4;
    public static final int RANGE_WEEK_MONDAY = 2;
    public static final int RANGE_WEEK_RELATIVE = 3;
    public static final int RANGE_WEEK_SUNDAY = 1;
    public static final int SEMI_MONTH = 1001;
    private static final int[][] fields = {new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, 1001}, new int[]{1}, new int[]{0}};

    public static boolean isSameDay(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        return isSameDay(instance, instance2);
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameInstant(Date date, Date date2) {
        if (date != null && date2 != null) {
            return date.getTime() == date2.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameInstant(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.getTime().getTime() == calendar2.getTime().getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameLocalTime(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.get(14) == calendar2.get(14) && calendar.get(13) == calendar2.get(13) && calendar.get(12) == calendar2.get(12) && calendar.get(11) == calendar2.get(11) && calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1) && calendar.get(0) == calendar2.get(0) && calendar.getClass() == calendar2.getClass();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date parseDate(String str, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, strArr, true);
    }

    public static Date parseDateStrictly(String str, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, strArr, false);
    }

    private static Date parseDateWithLeniency(String str, String[] strArr, boolean z) throws ParseException {
        if (str == null || strArr == null) {
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.setLenient(z);
        ParsePosition parsePosition = new ParsePosition(0);
        for (String str2 : strArr) {
            simpleDateFormat.applyPattern(str2.endsWith("ZZ") ? str2.substring(0, str2.length() - 1) : str2);
            parsePosition.setIndex(0);
            String replaceAll = str2.endsWith("ZZ") ? str.replaceAll("([-+][0-9][0-9]):([0-9][0-9])$", "$1$2") : str;
            Date parse = simpleDateFormat.parse(replaceAll, parsePosition);
            if (parse != null && parsePosition.getIndex() == replaceAll.length()) {
                return parse;
            }
        }
        throw new ParseException("Unable to parse the date: " + str, -1);
    }

    public static Date addYears(Date date, int i) {
        return add(date, 1, i);
    }

    public static Date addMonths(Date date, int i) {
        return add(date, 2, i);
    }

    public static Date addWeeks(Date date, int i) {
        return add(date, 3, i);
    }

    public static Date addDays(Date date, int i) {
        return add(date, 5, i);
    }

    public static Date addHours(Date date, int i) {
        return add(date, 11, i);
    }

    public static Date addMinutes(Date date, int i) {
        return add(date, 12, i);
    }

    public static Date addSeconds(Date date, int i) {
        return add(date, 13, i);
    }

    public static Date addMilliseconds(Date date, int i) {
        return add(date, 14, i);
    }

    private static Date add(Date date, int i, int i2) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            instance.add(i, i2);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date setYears(Date date, int i) {
        return set(date, 1, i);
    }

    public static Date setMonths(Date date, int i) {
        return set(date, 2, i);
    }

    public static Date setDays(Date date, int i) {
        return set(date, 5, i);
    }

    public static Date setHours(Date date, int i) {
        return set(date, 11, i);
    }

    public static Date setMinutes(Date date, int i) {
        return set(date, 12, i);
    }

    public static Date setSeconds(Date date, int i) {
        return set(date, 13, i);
    }

    public static Date setMilliseconds(Date date, int i) {
        return set(date, 14, i);
    }

    private static Date set(Date date, int i, int i2) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setLenient(false);
            instance.setTime(date);
            instance.set(i, i2);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar toCalendar(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance;
    }

    public static Date round(Date date, int i) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            modify(instance, i, 1);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar round(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i, 1);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date round(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return round((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return round((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not round " + obj);
        }
    }

    public static Date truncate(Date date, int i) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            modify(instance, i, 0);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar truncate(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i, 0);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date truncate(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return truncate((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return truncate((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not truncate " + obj);
        }
    }

    public static Date ceiling(Date date, int i) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            modify(instance, i, 2);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar ceiling(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i, 2);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date ceiling(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return ceiling((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return ceiling((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not find ceiling of for type: " + obj.getClass());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0129 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void modify(java.util.Calendar r16, int r17, int r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = 1
            int r4 = r0.get(r3)
            r5 = 280000000(0x10b07600, float:6.960157E-29)
            if (r4 > r5) goto L_0x014d
            r4 = 14
            if (r1 != r4) goto L_0x0015
            return
        L_0x0015:
            java.util.Date r5 = r16.getTime()
            long r6 = r5.getTime()
            int r4 = r0.get(r4)
            if (r2 == 0) goto L_0x0027
            r8 = 500(0x1f4, float:7.0E-43)
            if (r4 >= r8) goto L_0x0029
        L_0x0027:
            long r8 = (long) r4
            long r6 = r6 - r8
        L_0x0029:
            r4 = 13
            if (r1 != r4) goto L_0x002f
            r9 = r3
            goto L_0x0030
        L_0x002f:
            r9 = 0
        L_0x0030:
            int r4 = r0.get(r4)
            r10 = 30
            if (r9 != 0) goto L_0x0041
            if (r2 == 0) goto L_0x003c
            if (r4 >= r10) goto L_0x0041
        L_0x003c:
            long r11 = (long) r4
            r13 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 * r13
            long r6 = r6 - r11
        L_0x0041:
            r4 = 12
            if (r1 != r4) goto L_0x0046
            r9 = r3
        L_0x0046:
            int r11 = r0.get(r4)
            if (r9 != 0) goto L_0x0056
            if (r2 == 0) goto L_0x0050
            if (r11 >= r10) goto L_0x0056
        L_0x0050:
            long r9 = (long) r11
            r11 = 60000(0xea60, double:2.9644E-319)
            long r9 = r9 * r11
            long r6 = r6 - r9
        L_0x0056:
            long r9 = r5.getTime()
            int r9 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r9 == 0) goto L_0x0064
            r5.setTime(r6)
            r0.setTime(r5)
        L_0x0064:
            int[][] r5 = fields
            int r6 = r5.length
            r7 = 0
            r9 = 0
        L_0x0069:
            if (r7 >= r6) goto L_0x012e
            r10 = r5[r7]
            int r11 = r10.length
            r12 = 0
        L_0x006f:
            r13 = 15
            r14 = 1001(0x3e9, float:1.403E-42)
            r8 = 2
            r4 = 5
            if (r12 >= r11) goto L_0x00be
            r15 = r10[r12]
            if (r15 != r1) goto L_0x00b8
            if (r2 == r8) goto L_0x0081
            if (r2 != r3) goto L_0x00b7
            if (r9 == 0) goto L_0x00b7
        L_0x0081:
            if (r1 != r14) goto L_0x0096
            int r1 = r0.get(r4)
            if (r1 != r3) goto L_0x008d
            r0.add(r4, r13)
            goto L_0x00b7
        L_0x008d:
            r1 = -15
            r0.add(r4, r1)
            r0.add(r8, r3)
            goto L_0x00b7
        L_0x0096:
            r2 = 9
            if (r1 != r2) goto L_0x00b1
            r1 = 11
            int r2 = r0.get(r1)
            if (r2 != 0) goto L_0x00a8
            r2 = 12
            r0.add(r1, r2)
            goto L_0x00b7
        L_0x00a8:
            r2 = -12
            r0.add(r1, r2)
            r0.add(r4, r3)
            goto L_0x00b7
        L_0x00b1:
            r15 = 0
            r1 = r10[r15]
            r0.add(r1, r3)
        L_0x00b7:
            return
        L_0x00b8:
            r15 = 0
            int r12 = r12 + 1
            r4 = 12
            goto L_0x006f
        L_0x00be:
            r15 = 0
            r11 = 9
            if (r1 == r11) goto L_0x00df
            if (r1 == r14) goto L_0x00c8
        L_0x00c5:
            r11 = 12
            goto L_0x00fa
        L_0x00c8:
            r11 = r10[r15]
            if (r11 != r4) goto L_0x00c5
            int r4 = r0.get(r4)
            int r4 = r4 - r3
            if (r4 < r13) goto L_0x00d5
            int r4 = r4 + -15
        L_0x00d5:
            r9 = 7
            if (r4 <= r9) goto L_0x00da
            r9 = r3
            goto L_0x00db
        L_0x00da:
            r9 = 0
        L_0x00db:
            r15 = r3
            r11 = 12
            goto L_0x00fc
        L_0x00df:
            r4 = r15
            r11 = r10[r4]
            r4 = 11
            if (r11 != r4) goto L_0x00c5
            int r4 = r0.get(r4)
            r11 = 12
            if (r4 < r11) goto L_0x00f0
            int r4 = r4 + -12
        L_0x00f0:
            r15 = r4
            r4 = 6
            if (r15 < r4) goto L_0x00f6
            r9 = r3
            goto L_0x00f7
        L_0x00f6:
            r9 = 0
        L_0x00f7:
            r4 = r15
            r15 = r3
            goto L_0x00fc
        L_0x00fa:
            r4 = 0
            r15 = 0
        L_0x00fc:
            if (r15 != 0) goto L_0x011c
            r15 = 0
            r4 = r10[r15]
            int r4 = r0.getActualMinimum(r4)
            r9 = r10[r15]
            int r9 = r0.getActualMaximum(r9)
            r12 = r10[r15]
            int r12 = r0.get(r12)
            int r12 = r12 - r4
            int r9 = r9 - r4
            int r9 = r9 / r8
            if (r12 <= r9) goto L_0x0118
            r4 = r3
            goto L_0x0119
        L_0x0118:
            r4 = r15
        L_0x0119:
            r9 = r4
            r4 = r12
            goto L_0x011d
        L_0x011c:
            r15 = 0
        L_0x011d:
            if (r4 == 0) goto L_0x0129
            r8 = r10[r15]
            int r10 = r0.get(r8)
            int r10 = r10 - r4
            r0.set(r8, r10)
        L_0x0129:
            int r7 = r7 + 1
            r4 = r11
            goto L_0x0069
        L_0x012e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "The field "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r2 = " is not supported"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x014d:
            java.lang.ArithmeticException r0 = new java.lang.ArithmeticException
            java.lang.String r1 = "Calendar value too large for accurate calculations"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DateUtils.modify(java.util.Calendar, int, int):void");
    }

    public static Iterator<Calendar> iterator(Date date, int i) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            return iterator(instance, i);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0043, code lost:
        r8 = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        if (r1 >= 1) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
        r1 = r1 + 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006d, code lost:
        if (r1 <= 7) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006f, code lost:
        r1 = r1 - 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0071, code lost:
        if (r8 >= 1) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        r8 = r8 + 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0075, code lost:
        if (r8 <= 7) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0077, code lost:
        r8 = r8 - 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007d, code lost:
        if (r5.get(7) == r1) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007f, code lost:
        r5.add(5, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0087, code lost:
        if (r6.get(7) == r8) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0089, code lost:
        r6.add(5, 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0092, code lost:
        return new org.apache.commons.lang3.time.DateUtils.DateIterator(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003e, code lost:
        r8 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Iterator<java.util.Calendar> iterator(java.util.Calendar r8, int r9) {
        /*
            if (r8 == 0) goto L_0x0093
            r0 = -1
            r1 = 2
            r2 = 5
            r3 = 1
            r4 = 7
            switch(r9) {
                case 1: goto L_0x0045;
                case 2: goto L_0x0045;
                case 3: goto L_0x0045;
                case 4: goto L_0x0045;
                case 5: goto L_0x0029;
                case 6: goto L_0x0029;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "The range style "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r9 = r0.append(r9)
            java.lang.String r0 = " is not valid."
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x0029:
            java.util.Calendar r8 = truncate((java.util.Calendar) r8, (int) r1)
            java.lang.Object r5 = r8.clone()
            java.util.Calendar r5 = (java.util.Calendar) r5
            r5.add(r1, r3)
            r5.add(r2, r0)
            r6 = 6
            if (r9 != r6) goto L_0x0040
            r6 = r5
            r5 = r8
        L_0x003e:
            r8 = r3
            goto L_0x0069
        L_0x0040:
            r1 = r3
            r6 = r5
            r5 = r8
        L_0x0043:
            r8 = r4
            goto L_0x0069
        L_0x0045:
            java.util.Calendar r5 = truncate((java.util.Calendar) r8, (int) r2)
            java.util.Calendar r6 = truncate((java.util.Calendar) r8, (int) r2)
            if (r9 == r1) goto L_0x003e
            r1 = 3
            if (r9 == r1) goto L_0x0063
            r7 = 4
            if (r9 == r7) goto L_0x0057
            r1 = r3
            goto L_0x0043
        L_0x0057:
            int r9 = r8.get(r4)
            int r9 = r9 - r1
            int r8 = r8.get(r4)
            int r8 = r8 + r1
            r1 = r9
            goto L_0x0069
        L_0x0063:
            int r1 = r8.get(r4)
            int r8 = r1 + -1
        L_0x0069:
            if (r1 >= r3) goto L_0x006d
            int r1 = r1 + 7
        L_0x006d:
            if (r1 <= r4) goto L_0x0071
            int r1 = r1 + -7
        L_0x0071:
            if (r8 >= r3) goto L_0x0075
            int r8 = r8 + 7
        L_0x0075:
            if (r8 <= r4) goto L_0x0079
            int r8 = r8 + -7
        L_0x0079:
            int r9 = r5.get(r4)
            if (r9 == r1) goto L_0x0083
            r5.add(r2, r0)
            goto L_0x0079
        L_0x0083:
            int r9 = r6.get(r4)
            if (r9 == r8) goto L_0x008d
            r6.add(r2, r3)
            goto L_0x0083
        L_0x008d:
            org.apache.commons.lang3.time.DateUtils$DateIterator r8 = new org.apache.commons.lang3.time.DateUtils$DateIterator
            r8.<init>(r5, r6)
            return r8
        L_0x0093:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "The date must not be null"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DateUtils.iterator(java.util.Calendar, int):java.util.Iterator");
    }

    public static Iterator<?> iterator(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return iterator((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return iterator((Calendar) obj, i);
            }
            throw new ClassCastException("Could not iterate based on " + obj);
        }
    }

    public static long getFragmentInMilliseconds(Date date, int i) {
        return getFragment(date, i, 14);
    }

    public static long getFragmentInSeconds(Date date, int i) {
        return getFragment(date, i, 13);
    }

    public static long getFragmentInMinutes(Date date, int i) {
        return getFragment(date, i, 12);
    }

    public static long getFragmentInHours(Date date, int i) {
        return getFragment(date, i, 11);
    }

    public static long getFragmentInDays(Date date, int i) {
        return getFragment(date, i, 6);
    }

    public static long getFragmentInMilliseconds(Calendar calendar, int i) {
        return getFragment(calendar, i, 14);
    }

    public static long getFragmentInSeconds(Calendar calendar, int i) {
        return getFragment(calendar, i, 13);
    }

    public static long getFragmentInMinutes(Calendar calendar, int i) {
        return getFragment(calendar, i, 12);
    }

    public static long getFragmentInHours(Calendar calendar, int i) {
        return getFragment(calendar, i, 11);
    }

    public static long getFragmentInDays(Calendar calendar, int i) {
        return getFragment(calendar, i, 6);
    }

    private static long getFragment(Date date, int i, int i2) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            return getFragment(instance, i, i2);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    private static long getFragment(Calendar calendar, int i, int i2) {
        long j;
        if (calendar != null) {
            long millisPerUnit = getMillisPerUnit(i2);
            long j2 = 0;
            if (i != 1) {
                if (i == 2) {
                    j = (((long) calendar.get(5)) * MILLIS_PER_DAY) / millisPerUnit;
                }
                if (i != 1 || i == 2 || i == 5 || i == 6) {
                    j2 += (((long) calendar.get(11)) * MILLIS_PER_HOUR) / millisPerUnit;
                } else {
                    switch (i) {
                        case 11:
                            break;
                        case 12:
                            break;
                        case 13:
                            break;
                        case 14:
                            return j2;
                        default:
                            throw new IllegalArgumentException("The fragment " + i + " is not supported");
                    }
                }
                j2 += (((long) calendar.get(12)) * 60000) / millisPerUnit;
                j2 += (((long) calendar.get(13)) * 1000) / millisPerUnit;
                return j2 + (((long) (calendar.get(14) * 1)) / millisPerUnit);
            }
            j = (((long) calendar.get(6)) * MILLIS_PER_DAY) / millisPerUnit;
            j2 = 0 + j;
            if (i != 1) {
            }
            j2 += (((long) calendar.get(11)) * MILLIS_PER_HOUR) / millisPerUnit;
            j2 += (((long) calendar.get(12)) * 60000) / millisPerUnit;
            j2 += (((long) calendar.get(13)) * 1000) / millisPerUnit;
            return j2 + (((long) (calendar.get(14) * 1)) / millisPerUnit);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean truncatedEquals(Calendar calendar, Calendar calendar2, int i) {
        return truncatedCompareTo(calendar, calendar2, i) == 0;
    }

    public static boolean truncatedEquals(Date date, Date date2, int i) {
        return truncatedCompareTo(date, date2, i) == 0;
    }

    public static int truncatedCompareTo(Calendar calendar, Calendar calendar2, int i) {
        return truncate(calendar, i).compareTo(truncate(calendar2, i));
    }

    public static int truncatedCompareTo(Date date, Date date2, int i) {
        return truncate(date, i).compareTo(truncate(date2, i));
    }

    private static long getMillisPerUnit(int i) {
        if (i == 5 || i == 6) {
            return MILLIS_PER_DAY;
        }
        switch (i) {
            case 11:
                return MILLIS_PER_HOUR;
            case 12:
                return 60000;
            case 13:
                return 1000;
            case 14:
                return 1;
            default:
                throw new IllegalArgumentException("The unit " + i + " cannot be represented is milleseconds");
        }
    }

    static class DateIterator implements Iterator<Calendar> {
        private final Calendar endFinal;
        private final Calendar spot;

        DateIterator(Calendar calendar, Calendar calendar2) {
            this.endFinal = calendar2;
            this.spot = calendar;
            calendar.add(5, -1);
        }

        public boolean hasNext() {
            return this.spot.before(this.endFinal);
        }

        public Calendar next() {
            if (!this.spot.equals(this.endFinal)) {
                this.spot.add(5, 1);
                return (Calendar) this.spot.clone();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

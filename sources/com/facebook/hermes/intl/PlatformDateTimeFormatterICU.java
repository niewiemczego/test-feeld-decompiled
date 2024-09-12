package com.facebook.hermes.intl;

import android.icu.text.DateFormat;
import android.icu.text.NumberingSystem;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.icu.util.ULocale;
import com.facebook.hermes.intl.IPlatformDateTimeFormatter;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Date;

public class PlatformDateTimeFormatterICU implements IPlatformDateTimeFormatter {
    private DateFormat mDateFormat = null;

    public String format(double d) {
        return this.mDateFormat.format(new Date((long) d));
    }

    public String fieldToString(AttributedCharacterIterator.Attribute attribute, String str) {
        if (attribute == DateFormat.Field.DAY_OF_WEEK) {
            return "weekday";
        }
        if (attribute == DateFormat.Field.ERA) {
            return "era";
        }
        if (attribute == DateFormat.Field.YEAR) {
            try {
                Double.parseDouble(str);
                return "year";
            } catch (NumberFormatException unused) {
                return "yearName";
            }
        } else if (attribute == DateFormat.Field.MONTH) {
            return "month";
        } else {
            if (attribute == DateFormat.Field.DAY_OF_MONTH) {
                return "day";
            }
            if (attribute == DateFormat.Field.HOUR0 || attribute == DateFormat.Field.HOUR1 || attribute == DateFormat.Field.HOUR_OF_DAY0 || attribute == DateFormat.Field.HOUR_OF_DAY1) {
                return "hour";
            }
            if (attribute == DateFormat.Field.MINUTE) {
                return "minute";
            }
            if (attribute == DateFormat.Field.SECOND) {
                return "second";
            }
            if (attribute == DateFormat.Field.TIME_ZONE) {
                return "timeZoneName";
            }
            if (attribute == DateFormat.Field.AM_PM) {
                return "dayPeriod";
            }
            return attribute.toString().equals("android.icu.text.DateFormat$Field(related year)") ? "relatedYear" : "literal";
        }
    }

    public AttributedCharacterIterator formatToParts(double d) {
        return this.mDateFormat.formatToCharacterIterator(Double.valueOf(d));
    }

    public String getDefaultCalendarName(ILocaleObject<?> iLocaleObject) throws JSRangeErrorException {
        return UnicodeExtensionKeys.resolveCalendarAlias(DateFormat.getDateInstance(3, (ULocale) iLocaleObject.getLocale()).getCalendar().getType());
    }

    private static class PatternUtils {
        private PatternUtils() {
        }

        public static String getPatternWithoutLiterals(String str) {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt == '\'') {
                    z = !z;
                } else if (!z && ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z'))) {
                    sb.append(str.charAt(i));
                }
            }
            return sb.toString();
        }
    }

    public IPlatformDateTimeFormatter.HourCycle getDefaultHourCycle(ILocaleObject<?> iLocaleObject) throws JSRangeErrorException {
        try {
            String patternWithoutLiterals = PatternUtils.getPatternWithoutLiterals(((SimpleDateFormat) DateFormat.getTimeInstance(0, (ULocale) iLocaleObject.getLocale())).toPattern());
            if (patternWithoutLiterals.contains(String.valueOf('h'))) {
                return IPlatformDateTimeFormatter.HourCycle.H12;
            }
            if (patternWithoutLiterals.contains(String.valueOf('K'))) {
                return IPlatformDateTimeFormatter.HourCycle.H11;
            }
            if (patternWithoutLiterals.contains(String.valueOf('H'))) {
                return IPlatformDateTimeFormatter.HourCycle.H23;
            }
            return IPlatformDateTimeFormatter.HourCycle.H24;
        } catch (ClassCastException unused) {
            return IPlatformDateTimeFormatter.HourCycle.H24;
        }
    }

    public String getDefaultTimeZone(ILocaleObject<?> iLocaleObject) throws JSRangeErrorException {
        return Calendar.getInstance((ULocale) iLocaleObject.getLocale()).getTimeZone().getID();
    }

    public String getDefaultNumberingSystem(ILocaleObject<?> iLocaleObject) throws JSRangeErrorException {
        return NumberingSystem.getInstance((ULocale) iLocaleObject.getLocale()).getName();
    }

    private static String getSkeleton(IPlatformDateTimeFormatter.WeekDay weekDay, IPlatformDateTimeFormatter.Era era, IPlatformDateTimeFormatter.Year year, IPlatformDateTimeFormatter.Month month, IPlatformDateTimeFormatter.Day day, IPlatformDateTimeFormatter.Hour hour, IPlatformDateTimeFormatter.Minute minute, IPlatformDateTimeFormatter.Second second, IPlatformDateTimeFormatter.TimeZoneName timeZoneName, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(weekDay.getSkeleonSymbol());
        sb.append(era.getSkeleonSymbol());
        sb.append(year.getSkeleonSymbol());
        sb.append(month.getSkeleonSymbol());
        sb.append(day.getSkeleonSymbol());
        if (z) {
            sb.append(hour.getSkeleonSymbol12());
        } else {
            sb.append(hour.getSkeleonSymbol24());
        }
        sb.append(minute.getSkeleonSymbol());
        sb.append(second.getSkeleonSymbol());
        sb.append(timeZoneName.getSkeleonSymbol());
        return sb.toString();
    }

    public void configure(ILocaleObject<?> iLocaleObject, String str, String str2, IPlatformDateTimeFormatter.FormatMatcher formatMatcher, IPlatformDateTimeFormatter.WeekDay weekDay, IPlatformDateTimeFormatter.Era era, IPlatformDateTimeFormatter.Year year, IPlatformDateTimeFormatter.Month month, IPlatformDateTimeFormatter.Day day, IPlatformDateTimeFormatter.Hour hour, IPlatformDateTimeFormatter.Minute minute, IPlatformDateTimeFormatter.Second second, IPlatformDateTimeFormatter.TimeZoneName timeZoneName, IPlatformDateTimeFormatter.HourCycle hourCycle, Object obj) throws JSRangeErrorException {
        String str3 = str2;
        IPlatformDateTimeFormatter.HourCycle hourCycle2 = hourCycle;
        String skeleton = getSkeleton(weekDay, era, year, month, day, hour, minute, second, timeZoneName, hourCycle2 == IPlatformDateTimeFormatter.HourCycle.H11 || hourCycle2 == IPlatformDateTimeFormatter.HourCycle.H12);
        Calendar calendar = null;
        if (!str.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(JSObjects.getJavaString(str));
            ILocaleObject<?> cloneObject = iLocaleObject.cloneObject();
            cloneObject.setUnicodeExtensions("ca", arrayList);
            calendar = Calendar.getInstance((ULocale) cloneObject.getLocale());
        }
        if (!str2.isEmpty()) {
            try {
                if (NumberingSystem.getInstanceByName(JSObjects.getJavaString(str2)) != null) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(JSObjects.getJavaString(str2));
                    ILocaleObject<?> iLocaleObject2 = iLocaleObject;
                    iLocaleObject.setUnicodeExtensions("nu", arrayList2);
                } else {
                    throw new JSRangeErrorException("Invalid numbering system: " + str3);
                }
            } catch (RuntimeException unused) {
                throw new JSRangeErrorException("Invalid numbering system: " + str3);
            }
        } else {
            ILocaleObject<?> iLocaleObject3 = iLocaleObject;
        }
        if (calendar != null) {
            this.mDateFormat = DateFormat.getPatternInstance(calendar, skeleton, (ULocale) iLocaleObject.getLocale());
        } else {
            this.mDateFormat = DateFormat.getPatternInstance(skeleton, (ULocale) iLocaleObject.getLocale());
        }
        if (!JSObjects.isUndefined(obj) && !JSObjects.isNull(obj)) {
            this.mDateFormat.setTimeZone(TimeZone.getTimeZone(JSObjects.getJavaString(obj)));
        }
    }

    public String[] getAvailableLocales() {
        ArrayList arrayList = new ArrayList();
        for (ULocale languageTag : ULocale.getAvailableLocales()) {
            arrayList.add(languageTag.toLanguageTag());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    PlatformDateTimeFormatterICU() {
    }
}

package com.facebook.hermes.intl;

import android.os.Build;
import com.facebook.hermes.intl.IPlatformDateTimeFormatter;
import com.facebook.hermes.intl.OptionHelpers;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.codec.language.bm.Languages;

public class DateTimeFormat {
    private String mCalendar;
    private IPlatformDateTimeFormatter.Day mDay;
    private IPlatformDateTimeFormatter.Era mEra;
    private IPlatformDateTimeFormatter.FormatMatcher mFormatMatcher;
    private IPlatformDateTimeFormatter.Hour mHour;
    private IPlatformDateTimeFormatter.HourCycle mHourCycle;
    private IPlatformDateTimeFormatter.Minute mMinute;
    private IPlatformDateTimeFormatter.Month mMonth;
    private String mNumberingSystem;
    IPlatformDateTimeFormatter mPlatformDateTimeFormatter;
    private ILocaleObject<?> mResolvedLocaleObject = null;
    private ILocaleObject<?> mResolvedLocaleObjectForResolvedOptions = null;
    private IPlatformDateTimeFormatter.Second mSecond;
    private Object mTimeZone = null;
    private IPlatformDateTimeFormatter.TimeZoneName mTimeZoneName;
    private IPlatformDateTimeFormatter.WeekDay mWeekDay;
    private IPlatformDateTimeFormatter.Year mYear;
    private boolean useDefaultCalendar;
    private boolean useDefaultNumberSystem;

    private boolean isLocaleIdType(String str) {
        return IntlTextUtils.isUnicodeExtensionKeyTypeItem(str, 0, str.length() - 1);
    }

    private Object ToDateTimeOptions(Object obj, String str, String str2) throws JSRangeErrorException {
        Object obj2 = obj;
        String str3 = str;
        String str4 = str2;
        if (JSObjects.isObject(obj)) {
            boolean z = true;
            if (str3.equals("date") || str3.equals(Languages.ANY)) {
                String[] strArr = {"weekday", "year", "month", "day"};
                for (int i = 0; i < 4; i++) {
                    if (!JSObjects.isUndefined(JSObjects.Get(obj2, strArr[i]))) {
                        z = false;
                    }
                }
            }
            if (str3.equals("time") || str3.equals(Languages.ANY)) {
                String[] strArr2 = {"hour", "minute", "second"};
                for (int i2 = 0; i2 < 3; i2++) {
                    if (!JSObjects.isUndefined(JSObjects.Get(obj2, strArr2[i2]))) {
                        z = false;
                    }
                }
            }
            if (z && (str4.equals("date") || str4.equals("all"))) {
                String[] strArr3 = {"year", "month", "day"};
                for (int i3 = 0; i3 < 3; i3++) {
                    JSObjects.Put(obj2, strArr3[i3], Constants.COLLATION_OPTION_NUMERIC);
                }
            }
            if (z && (str4.equals("time") || str4.equals("all"))) {
                String[] strArr4 = {"hour", "minute", "second"};
                for (int i4 = 0; i4 < 3; i4++) {
                    JSObjects.Put(obj2, strArr4[i4], Constants.COLLATION_OPTION_NUMERIC);
                }
            }
            return obj2;
        }
        throw new JSRangeErrorException("Invalid options object !");
    }

    public String normalizeTimeZoneName(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < 'A' || charAt > 'Z') {
                sb.append(charAt);
            } else {
                sb.append((char) (charAt + ' '));
            }
        }
        return sb.toString();
    }

    public String normalizeTimeZone(String str) throws JSRangeErrorException {
        for (String str2 : TimeZone.getAvailableIDs()) {
            if (normalizeTimeZoneName(str2).equals(normalizeTimeZoneName(str))) {
                return str2;
            }
        }
        throw new JSRangeErrorException("Invalid timezone name!");
    }

    private Object DefaultTimeZone() throws JSRangeErrorException {
        return this.mPlatformDateTimeFormatter.getDefaultTimeZone(this.mResolvedLocaleObject);
    }

    private void initializeDateTimeFormat(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        Object obj;
        IPlatformDateTimeFormatter.HourCycle hourCycle;
        List asList = Arrays.asList(new String[]{"ca", "nu", "hc"});
        Object ToDateTimeOptions = ToDateTimeOptions(map, Languages.ANY, "date");
        Object newObject = JSObjects.newObject();
        JSObjects.Put(newObject, Constants.LOCALEMATCHER, OptionHelpers.GetOption(ToDateTimeOptions, Constants.LOCALEMATCHER, OptionHelpers.OptionType.STRING, Constants.LOCALEMATCHER_POSSIBLE_VALUES, Constants.LOCALEMATCHER_BESTFIT));
        Object GetOption = OptionHelpers.GetOption(ToDateTimeOptions, "calendar", OptionHelpers.OptionType.STRING, JSObjects.Undefined(), JSObjects.Undefined());
        if (JSObjects.isUndefined(GetOption) || isLocaleIdType(JSObjects.getJavaString(GetOption))) {
            JSObjects.Put(newObject, "ca", GetOption);
            Object GetOption2 = OptionHelpers.GetOption(ToDateTimeOptions, "numberingSystem", OptionHelpers.OptionType.STRING, JSObjects.Undefined(), JSObjects.Undefined());
            if (JSObjects.isUndefined(GetOption2) || isLocaleIdType(JSObjects.getJavaString(GetOption2))) {
                JSObjects.Put(newObject, "nu", GetOption2);
                Object GetOption3 = OptionHelpers.GetOption(ToDateTimeOptions, "hour12", OptionHelpers.OptionType.BOOLEAN, JSObjects.Undefined(), JSObjects.Undefined());
                Object GetOption4 = OptionHelpers.GetOption(ToDateTimeOptions, "hourCycle", OptionHelpers.OptionType.STRING, new String[]{"h11", "h12", "h23", "h24"}, JSObjects.Undefined());
                if (!JSObjects.isUndefined(GetOption3)) {
                    GetOption4 = JSObjects.Null();
                }
                JSObjects.Put(newObject, "hc", GetOption4);
                HashMap<String, Object> resolveLocale = LocaleResolver.resolveLocale(list, newObject, asList);
                ILocaleObject<?> iLocaleObject = (ILocaleObject) JSObjects.getJavaMap(resolveLocale).get("locale");
                this.mResolvedLocaleObject = iLocaleObject;
                this.mResolvedLocaleObjectForResolvedOptions = iLocaleObject.cloneObject();
                Object Get = JSObjects.Get(resolveLocale, "ca");
                if (!JSObjects.isNull(Get)) {
                    this.useDefaultCalendar = false;
                    this.mCalendar = JSObjects.getJavaString(Get);
                } else {
                    this.useDefaultCalendar = true;
                    this.mCalendar = this.mPlatformDateTimeFormatter.getDefaultCalendarName(this.mResolvedLocaleObject);
                }
                Object Get2 = JSObjects.Get(resolveLocale, "nu");
                if (!JSObjects.isNull(Get2)) {
                    this.useDefaultNumberSystem = false;
                    this.mNumberingSystem = JSObjects.getJavaString(Get2);
                } else {
                    this.useDefaultNumberSystem = true;
                    this.mNumberingSystem = this.mPlatformDateTimeFormatter.getDefaultNumberingSystem(this.mResolvedLocaleObject);
                }
                Object Get3 = JSObjects.Get(resolveLocale, "hc");
                Object Get4 = JSObjects.Get(ToDateTimeOptions, "timeZone");
                if (JSObjects.isUndefined(Get4)) {
                    obj = DefaultTimeZone();
                } else {
                    obj = normalizeTimeZone(Get4.toString());
                }
                this.mTimeZone = obj;
                this.mFormatMatcher = (IPlatformDateTimeFormatter.FormatMatcher) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.FormatMatcher.class, JSObjects.getJavaString(OptionHelpers.GetOption(ToDateTimeOptions, "formatMatcher", OptionHelpers.OptionType.STRING, new String[]{"basic", Constants.LOCALEMATCHER_BESTFIT}, Constants.LOCALEMATCHER_BESTFIT)));
                this.mWeekDay = (IPlatformDateTimeFormatter.WeekDay) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.WeekDay.class, OptionHelpers.GetOption(ToDateTimeOptions, "weekday", OptionHelpers.OptionType.STRING, new String[]{"long", "short", "narrow"}, JSObjects.Undefined()));
                this.mEra = (IPlatformDateTimeFormatter.Era) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.Era.class, OptionHelpers.GetOption(ToDateTimeOptions, "era", OptionHelpers.OptionType.STRING, new String[]{"long", "short", "narrow"}, JSObjects.Undefined()));
                this.mYear = (IPlatformDateTimeFormatter.Year) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.Year.class, OptionHelpers.GetOption(ToDateTimeOptions, "year", OptionHelpers.OptionType.STRING, new String[]{Constants.COLLATION_OPTION_NUMERIC, "2-digit"}, JSObjects.Undefined()));
                this.mMonth = (IPlatformDateTimeFormatter.Month) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.Month.class, OptionHelpers.GetOption(ToDateTimeOptions, "month", OptionHelpers.OptionType.STRING, new String[]{Constants.COLLATION_OPTION_NUMERIC, "2-digit", "long", "short", "narrow"}, JSObjects.Undefined()));
                this.mDay = (IPlatformDateTimeFormatter.Day) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.Day.class, OptionHelpers.GetOption(ToDateTimeOptions, "day", OptionHelpers.OptionType.STRING, new String[]{Constants.COLLATION_OPTION_NUMERIC, "2-digit"}, JSObjects.Undefined()));
                Object GetOption5 = OptionHelpers.GetOption(ToDateTimeOptions, "hour", OptionHelpers.OptionType.STRING, new String[]{Constants.COLLATION_OPTION_NUMERIC, "2-digit"}, JSObjects.Undefined());
                this.mHour = (IPlatformDateTimeFormatter.Hour) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.Hour.class, GetOption5);
                this.mMinute = (IPlatformDateTimeFormatter.Minute) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.Minute.class, OptionHelpers.GetOption(ToDateTimeOptions, "minute", OptionHelpers.OptionType.STRING, new String[]{Constants.COLLATION_OPTION_NUMERIC, "2-digit"}, JSObjects.Undefined()));
                this.mSecond = (IPlatformDateTimeFormatter.Second) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.Second.class, OptionHelpers.GetOption(ToDateTimeOptions, "second", OptionHelpers.OptionType.STRING, new String[]{Constants.COLLATION_OPTION_NUMERIC, "2-digit"}, JSObjects.Undefined()));
                this.mTimeZoneName = (IPlatformDateTimeFormatter.TimeZoneName) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.TimeZoneName.class, OptionHelpers.GetOption(ToDateTimeOptions, "timeZoneName", OptionHelpers.OptionType.STRING, new String[]{"long", "short"}, JSObjects.Undefined()));
                if (JSObjects.isUndefined(GetOption5)) {
                    this.mHourCycle = IPlatformDateTimeFormatter.HourCycle.UNDEFINED;
                    return;
                }
                IPlatformDateTimeFormatter.HourCycle defaultHourCycle = this.mPlatformDateTimeFormatter.getDefaultHourCycle(this.mResolvedLocaleObject);
                if (JSObjects.isNull(Get3)) {
                    hourCycle = defaultHourCycle;
                } else {
                    hourCycle = (IPlatformDateTimeFormatter.HourCycle) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.HourCycle.class, Get3);
                }
                if (!JSObjects.isUndefined(GetOption3)) {
                    if (JSObjects.getJavaBoolean(GetOption3)) {
                        if (defaultHourCycle == IPlatformDateTimeFormatter.HourCycle.H11 || defaultHourCycle == IPlatformDateTimeFormatter.HourCycle.H23) {
                            hourCycle = IPlatformDateTimeFormatter.HourCycle.H11;
                        } else {
                            hourCycle = IPlatformDateTimeFormatter.HourCycle.H12;
                        }
                    } else if (defaultHourCycle == IPlatformDateTimeFormatter.HourCycle.H11 || defaultHourCycle == IPlatformDateTimeFormatter.HourCycle.H23) {
                        hourCycle = IPlatformDateTimeFormatter.HourCycle.H23;
                    } else {
                        hourCycle = IPlatformDateTimeFormatter.HourCycle.H24;
                    }
                }
                this.mHourCycle = hourCycle;
                return;
            }
            throw new JSRangeErrorException("Invalid numbering system !");
        }
        throw new JSRangeErrorException("Invalid calendar option !");
    }

    public DateTimeFormat(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mPlatformDateTimeFormatter = new PlatformDateTimeFormatterICU();
        } else {
            this.mPlatformDateTimeFormatter = new PlatformDateTimeFormatterAndroid();
        }
        initializeDateTimeFormat(list, map);
        IPlatformDateTimeFormatter iPlatformDateTimeFormatter = this.mPlatformDateTimeFormatter;
        ILocaleObject<?> iLocaleObject = this.mResolvedLocaleObject;
        String str = "";
        iPlatformDateTimeFormatter.configure(iLocaleObject, this.useDefaultCalendar ? str : this.mCalendar, !this.useDefaultNumberSystem ? this.mNumberingSystem : str, this.mFormatMatcher, this.mWeekDay, this.mEra, this.mYear, this.mMonth, this.mDay, this.mHour, this.mMinute, this.mSecond, this.mTimeZoneName, this.mHourCycle, this.mTimeZone);
    }

    public static List<String> supportedLocalesOf(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        String javaString = JSObjects.getJavaString(OptionHelpers.GetOption(map, Constants.LOCALEMATCHER, OptionHelpers.OptionType.STRING, Constants.LOCALEMATCHER_POSSIBLE_VALUES, Constants.LOCALEMATCHER_BESTFIT));
        String[] strArr = new String[list.size()];
        if (Build.VERSION.SDK_INT < 24 || !javaString.equals(Constants.LOCALEMATCHER_BESTFIT)) {
            return Arrays.asList(LocaleMatcher.lookupSupportedLocales((String[]) list.toArray(strArr)));
        }
        return Arrays.asList(LocaleMatcher.bestFitSupportedLocales((String[]) list.toArray(strArr)));
    }

    public Map<String, Object> resolvedOptions() throws JSRangeErrorException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("locale", this.mResolvedLocaleObjectForResolvedOptions.toCanonicalTag());
        linkedHashMap.put("numberingSystem", this.mNumberingSystem);
        linkedHashMap.put("calendar", this.mCalendar);
        linkedHashMap.put("timeZone", this.mTimeZone);
        if (this.mHourCycle != IPlatformDateTimeFormatter.HourCycle.UNDEFINED) {
            linkedHashMap.put("hourCycle", this.mHourCycle.toString());
            if (this.mHourCycle == IPlatformDateTimeFormatter.HourCycle.H11 || this.mHourCycle == IPlatformDateTimeFormatter.HourCycle.H12) {
                linkedHashMap.put("hour12", true);
            } else {
                linkedHashMap.put("hour12", false);
            }
        }
        if (this.mWeekDay != IPlatformDateTimeFormatter.WeekDay.UNDEFINED) {
            linkedHashMap.put("weekday", this.mWeekDay.toString());
        }
        if (this.mEra != IPlatformDateTimeFormatter.Era.UNDEFINED) {
            linkedHashMap.put("era", this.mEra.toString());
        }
        if (this.mYear != IPlatformDateTimeFormatter.Year.UNDEFINED) {
            linkedHashMap.put("year", this.mYear.toString());
        }
        if (this.mMonth != IPlatformDateTimeFormatter.Month.UNDEFINED) {
            linkedHashMap.put("month", this.mMonth.toString());
        }
        if (this.mDay != IPlatformDateTimeFormatter.Day.UNDEFINED) {
            linkedHashMap.put("day", this.mDay.toString());
        }
        if (this.mHour != IPlatformDateTimeFormatter.Hour.UNDEFINED) {
            linkedHashMap.put("hour", this.mHour.toString());
        }
        if (this.mMinute != IPlatformDateTimeFormatter.Minute.UNDEFINED) {
            linkedHashMap.put("minute", this.mMinute.toString());
        }
        if (this.mSecond != IPlatformDateTimeFormatter.Second.UNDEFINED) {
            linkedHashMap.put("second", this.mSecond.toString());
        }
        if (this.mTimeZoneName != IPlatformDateTimeFormatter.TimeZoneName.UNDEFINED) {
            linkedHashMap.put("timeZoneName", this.mTimeZoneName.toString());
        }
        return linkedHashMap;
    }

    public String format(double d) throws JSRangeErrorException {
        return this.mPlatformDateTimeFormatter.format(d);
    }

    public List<Map<String, String>> formatToParts(double d) throws JSRangeErrorException {
        ArrayList arrayList = new ArrayList();
        AttributedCharacterIterator formatToParts = this.mPlatformDateTimeFormatter.formatToParts(d);
        StringBuilder sb = new StringBuilder();
        for (char first = formatToParts.first(); first != 65535; first = formatToParts.next()) {
            sb.append(first);
            if (formatToParts.getIndex() + 1 == formatToParts.getRunLimit()) {
                Iterator<AttributedCharacterIterator.Attribute> it = formatToParts.getAttributes().keySet().iterator();
                String fieldToString = it.hasNext() ? this.mPlatformDateTimeFormatter.fieldToString(it.next(), sb.toString()) : "literal";
                String sb2 = sb.toString();
                sb.setLength(0);
                HashMap hashMap = new HashMap();
                hashMap.put("type", fieldToString);
                hashMap.put("value", sb2);
                arrayList.add(hashMap);
            }
        }
        return arrayList;
    }
}

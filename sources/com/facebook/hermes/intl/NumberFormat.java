package com.facebook.hermes.intl;

import android.os.Build;
import com.facebook.hermes.intl.IPlatformNumberFormatter;
import com.facebook.hermes.intl.OptionHelpers;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.profilemeasurements.ProfileMeasurement;
import io.sentry.protocol.SentryStackFrame;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NumberFormat {
    private static String[] s_sanctionedSimpleUnitIdentifiers = {"acre", "bit", ProfileMeasurement.UNIT_BYTES, "celsius", "centimeter", "day", "degree", "fahrenheit", "fluid-ounce", "foot", "gallon", "gigabit", "gigabyte", "gram", "hectare", "hour", "inch", "kilobit", "kilobyte", "kilogram", "kilometer", "liter", "megabit", "megabyte", "meter", "mile", "mile-scandinavian", "milliliter", "millimeter", "millisecond", "minute", "month", "ounce", ProfileMeasurement.UNIT_PERCENT, "petabyte", "pound", "second", "stone", "terabit", "terabyte", "week", "yard", "year"};
    private boolean mGroupingUsed = true;
    private IPlatformNumberFormatter mPlatformNumberFormatter;
    private IPlatformNumberFormatter.CompactDisplay mResolvedCompactDisplay;
    private String mResolvedCurrency = null;
    private IPlatformNumberFormatter.CurrencyDisplay mResolvedCurrencyDisplay = IPlatformNumberFormatter.CurrencyDisplay.SYMBOL;
    private IPlatformNumberFormatter.CurrencySign mResolvedCurrencySign = IPlatformNumberFormatter.CurrencySign.STANDARD;
    private ILocaleObject<?> mResolvedLocaleObject = null;
    private ILocaleObject<?> mResolvedLocaleObjectForResolvedOptions = null;
    private int mResolvedMaximumFractionDigits = -1;
    private int mResolvedMaximumSignificantDigits = -1;
    private int mResolvedMinimumFractionDigits = -1;
    private int mResolvedMinimumIntegerDigits = -1;
    private int mResolvedMinimumSignificantDigits = -1;
    private IPlatformNumberFormatter.Notation mResolvedNotation = null;
    private String mResolvedNumberingSystem = null;
    private IPlatformNumberFormatter.SignDisplay mResolvedSignDisplay = IPlatformNumberFormatter.SignDisplay.AUTO;
    private IPlatformNumberFormatter.Style mResolvedStyle;
    private String mResolvedUnit = null;
    private IPlatformNumberFormatter.UnitDisplay mResolvedUnitDisplay;
    private IPlatformNumberFormatter.RoundingType mRoundingType;
    private boolean mUseDefaultNumberSystem;

    private boolean isSanctionedSimpleUnitIdentifier(String str) {
        return Arrays.binarySearch(s_sanctionedSimpleUnitIdentifiers, str) >= 0;
    }

    private boolean isWellFormedUnitIdentifier(String str) {
        if (isSanctionedSimpleUnitIdentifier(str)) {
            return true;
        }
        int indexOf = str.indexOf("-per-");
        if (indexOf >= 0 && str.indexOf("-per-", indexOf + 1) < 0 && isSanctionedSimpleUnitIdentifier(str.substring(0, indexOf)) && isSanctionedSimpleUnitIdentifier(str.substring(indexOf + 5))) {
            return true;
        }
        return false;
    }

    private String normalizeCurrencyCode(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < 'a' || charAt > 'z') {
                sb.append(charAt);
            } else {
                sb.append((char) (charAt - ' '));
            }
        }
        return sb.toString();
    }

    private boolean isWellFormedCurrencyCode(String str) {
        return normalizeCurrencyCode(str).matches("^[A-Z][A-Z][A-Z]$");
    }

    private void setNumberFormatUnitOptions(Map<String, Object> map) throws JSRangeErrorException {
        this.mResolvedStyle = (IPlatformNumberFormatter.Style) OptionHelpers.searchEnum(IPlatformNumberFormatter.Style.class, JSObjects.getJavaString(OptionHelpers.GetOption(map, "style", OptionHelpers.OptionType.STRING, new String[]{"decimal", ProfileMeasurement.UNIT_PERCENT, FirebaseAnalytics.Param.CURRENCY, "unit"}, "decimal")));
        Object GetOption = OptionHelpers.GetOption(map, FirebaseAnalytics.Param.CURRENCY, OptionHelpers.OptionType.STRING, JSObjects.Undefined(), JSObjects.Undefined());
        if (JSObjects.isUndefined(GetOption)) {
            if (this.mResolvedStyle == IPlatformNumberFormatter.Style.CURRENCY) {
                throw new JSRangeErrorException("Expected currency style !");
            }
        } else if (!isWellFormedCurrencyCode(JSObjects.getJavaString(GetOption))) {
            throw new JSRangeErrorException("Malformed currency code !");
        }
        Object GetOption2 = OptionHelpers.GetOption(map, "currencyDisplay", OptionHelpers.OptionType.STRING, new String[]{SentryStackFrame.JsonKeys.SYMBOL, "narrowSymbol", "code", "name"}, SentryStackFrame.JsonKeys.SYMBOL);
        Object GetOption3 = OptionHelpers.GetOption(map, "currencySign", OptionHelpers.OptionType.STRING, new String[]{"accounting", Constants.COLLATION_STANDARD}, Constants.COLLATION_STANDARD);
        Object GetOption4 = OptionHelpers.GetOption(map, "unit", OptionHelpers.OptionType.STRING, JSObjects.Undefined(), JSObjects.Undefined());
        if (JSObjects.isUndefined(GetOption4)) {
            if (this.mResolvedStyle == IPlatformNumberFormatter.Style.UNIT) {
                throw new JSRangeErrorException("Expected unit !");
            }
        } else if (!isWellFormedUnitIdentifier(JSObjects.getJavaString(GetOption4))) {
            throw new JSRangeErrorException("Malformed unit identifier !");
        }
        Object GetOption5 = OptionHelpers.GetOption(map, "unitDisplay", OptionHelpers.OptionType.STRING, new String[]{"long", "short", "narrow"}, "short");
        if (this.mResolvedStyle == IPlatformNumberFormatter.Style.CURRENCY) {
            this.mResolvedCurrency = normalizeCurrencyCode(JSObjects.getJavaString(GetOption));
            this.mResolvedCurrencyDisplay = (IPlatformNumberFormatter.CurrencyDisplay) OptionHelpers.searchEnum(IPlatformNumberFormatter.CurrencyDisplay.class, JSObjects.getJavaString(GetOption2));
            this.mResolvedCurrencySign = (IPlatformNumberFormatter.CurrencySign) OptionHelpers.searchEnum(IPlatformNumberFormatter.CurrencySign.class, JSObjects.getJavaString(GetOption3));
        } else if (this.mResolvedStyle == IPlatformNumberFormatter.Style.UNIT) {
            this.mResolvedUnit = JSObjects.getJavaString(GetOption4);
            this.mResolvedUnitDisplay = (IPlatformNumberFormatter.UnitDisplay) OptionHelpers.searchEnum(IPlatformNumberFormatter.UnitDisplay.class, JSObjects.getJavaString(GetOption5));
        }
    }

    private void setNumberFormatDigitOptions(Map<String, Object> map, Object obj, Object obj2) throws JSRangeErrorException {
        Object GetNumberOption = OptionHelpers.GetNumberOption(map, "minimumIntegerDigits", JSObjects.newNumber(1.0d), JSObjects.newNumber(21.0d), JSObjects.newNumber(1.0d));
        Object Get = JSObjects.Get(map, "minimumFractionDigits");
        Object Get2 = JSObjects.Get(map, "maximumFractionDigits");
        Object Get3 = JSObjects.Get(map, "minimumSignificantDigits");
        Object Get4 = JSObjects.Get(map, "maximumSignificantDigits");
        this.mResolvedMinimumIntegerDigits = (int) Math.floor(JSObjects.getJavaDouble(GetNumberOption));
        if (!JSObjects.isUndefined(Get3) || !JSObjects.isUndefined(Get4)) {
            this.mRoundingType = IPlatformNumberFormatter.RoundingType.SIGNIFICANT_DIGITS;
            Object DefaultNumberOption = OptionHelpers.DefaultNumberOption(Get3, JSObjects.newNumber(1.0d), JSObjects.newNumber(21.0d), JSObjects.newNumber(1.0d));
            Object DefaultNumberOption2 = OptionHelpers.DefaultNumberOption(Get4, DefaultNumberOption, JSObjects.newNumber(21.0d), JSObjects.newNumber(21.0d));
            this.mResolvedMinimumSignificantDigits = (int) Math.floor(JSObjects.getJavaDouble(DefaultNumberOption));
            this.mResolvedMaximumSignificantDigits = (int) Math.floor(JSObjects.getJavaDouble(DefaultNumberOption2));
        } else if (!JSObjects.isUndefined(Get) || !JSObjects.isUndefined(Get2)) {
            this.mRoundingType = IPlatformNumberFormatter.RoundingType.FRACTION_DIGITS;
            Object DefaultNumberOption3 = OptionHelpers.DefaultNumberOption(Get, JSObjects.newNumber(0.0d), JSObjects.newNumber(20.0d), obj);
            Object DefaultNumberOption4 = OptionHelpers.DefaultNumberOption(Get2, DefaultNumberOption3, JSObjects.newNumber(20.0d), JSObjects.newNumber(Math.max(JSObjects.getJavaDouble(DefaultNumberOption3), JSObjects.getJavaDouble(obj2))));
            this.mResolvedMinimumFractionDigits = (int) Math.floor(JSObjects.getJavaDouble(DefaultNumberOption3));
            this.mResolvedMaximumFractionDigits = (int) Math.floor(JSObjects.getJavaDouble(DefaultNumberOption4));
        } else if (this.mResolvedNotation == IPlatformNumberFormatter.Notation.COMPACT) {
            this.mRoundingType = IPlatformNumberFormatter.RoundingType.COMPACT_ROUNDING;
        } else if (this.mResolvedNotation == IPlatformNumberFormatter.Notation.ENGINEERING) {
            this.mRoundingType = IPlatformNumberFormatter.RoundingType.FRACTION_DIGITS;
            this.mResolvedMaximumFractionDigits = 5;
        } else {
            this.mRoundingType = IPlatformNumberFormatter.RoundingType.FRACTION_DIGITS;
            this.mResolvedMinimumFractionDigits = (int) Math.floor(JSObjects.getJavaDouble(obj));
            this.mResolvedMaximumFractionDigits = (int) Math.floor(JSObjects.getJavaDouble(obj2));
        }
    }

    private boolean isLocaleIdType(String str) {
        return IntlTextUtils.isUnicodeExtensionKeyTypeItem(str, 0, str.length() - 1);
    }

    private void initializeNumberFormat(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        Object obj;
        Object obj2;
        int i;
        Object newObject = JSObjects.newObject();
        JSObjects.Put(newObject, Constants.LOCALEMATCHER, OptionHelpers.GetOption(map, Constants.LOCALEMATCHER, OptionHelpers.OptionType.STRING, Constants.LOCALEMATCHER_POSSIBLE_VALUES, Constants.LOCALEMATCHER_BESTFIT));
        Object GetOption = OptionHelpers.GetOption(map, "numberingSystem", OptionHelpers.OptionType.STRING, JSObjects.Undefined(), JSObjects.Undefined());
        if (JSObjects.isUndefined(GetOption) || isLocaleIdType(JSObjects.getJavaString(GetOption))) {
            JSObjects.Put(newObject, "nu", GetOption);
            HashMap<String, Object> resolveLocale = LocaleResolver.resolveLocale(list, newObject, Collections.singletonList("nu"));
            ILocaleObject<?> iLocaleObject = (ILocaleObject) JSObjects.getJavaMap(resolveLocale).get("locale");
            this.mResolvedLocaleObject = iLocaleObject;
            this.mResolvedLocaleObjectForResolvedOptions = iLocaleObject.cloneObject();
            Object Get = JSObjects.Get(resolveLocale, "nu");
            if (!JSObjects.isNull(Get)) {
                this.mUseDefaultNumberSystem = false;
                this.mResolvedNumberingSystem = JSObjects.getJavaString(Get);
            } else {
                this.mUseDefaultNumberSystem = true;
                this.mResolvedNumberingSystem = this.mPlatformNumberFormatter.getDefaultNumberingSystem(this.mResolvedLocaleObject);
            }
            setNumberFormatUnitOptions(map);
            if (this.mResolvedStyle == IPlatformNumberFormatter.Style.CURRENCY) {
                if (Build.VERSION.SDK_INT >= 24) {
                    i = PlatformNumberFormatterICU.getCurrencyDigits(this.mResolvedCurrency);
                } else {
                    i = PlatformNumberFormatterAndroid.getCurrencyDigits(this.mResolvedCurrency);
                }
                double d = (double) i;
                obj = JSObjects.newNumber(d);
                obj2 = JSObjects.newNumber(d);
            } else {
                obj = JSObjects.newNumber(0.0d);
                if (this.mResolvedStyle == IPlatformNumberFormatter.Style.PERCENT) {
                    obj2 = JSObjects.newNumber(0.0d);
                } else {
                    obj2 = JSObjects.newNumber(3.0d);
                }
            }
            this.mResolvedNotation = (IPlatformNumberFormatter.Notation) OptionHelpers.searchEnum(IPlatformNumberFormatter.Notation.class, JSObjects.getJavaString(OptionHelpers.GetOption(map, "notation", OptionHelpers.OptionType.STRING, new String[]{Constants.COLLATION_STANDARD, "scientific", "engineering", "compact"}, Constants.COLLATION_STANDARD)));
            setNumberFormatDigitOptions(map, obj, obj2);
            Object GetOption2 = OptionHelpers.GetOption(map, "compactDisplay", OptionHelpers.OptionType.STRING, new String[]{"short", "long"}, "short");
            if (this.mResolvedNotation == IPlatformNumberFormatter.Notation.COMPACT) {
                this.mResolvedCompactDisplay = (IPlatformNumberFormatter.CompactDisplay) OptionHelpers.searchEnum(IPlatformNumberFormatter.CompactDisplay.class, JSObjects.getJavaString(GetOption2));
            }
            this.mGroupingUsed = JSObjects.getJavaBoolean(OptionHelpers.GetOption(map, "useGrouping", OptionHelpers.OptionType.BOOLEAN, JSObjects.Undefined(), JSObjects.newBoolean(true)));
            this.mResolvedSignDisplay = (IPlatformNumberFormatter.SignDisplay) OptionHelpers.searchEnum(IPlatformNumberFormatter.SignDisplay.class, JSObjects.getJavaString(OptionHelpers.GetOption(map, "signDisplay", OptionHelpers.OptionType.STRING, new String[]{"auto", "never", "always", "exceptZero"}, "auto")));
            return;
        }
        throw new JSRangeErrorException("Invalid numbering system !");
    }

    public NumberFormat(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mPlatformNumberFormatter = new PlatformNumberFormatterICU();
        } else {
            this.mPlatformNumberFormatter = new PlatformNumberFormatterAndroid();
        }
        initializeNumberFormat(list, map);
        this.mPlatformNumberFormatter.configure(this.mResolvedLocaleObject, this.mUseDefaultNumberSystem ? "" : this.mResolvedNumberingSystem, this.mResolvedStyle, this.mResolvedCurrencySign, this.mResolvedNotation, this.mResolvedCompactDisplay).setCurrency(this.mResolvedCurrency, this.mResolvedCurrencyDisplay).setGrouping(this.mGroupingUsed).setMinIntergerDigits(this.mResolvedMinimumIntegerDigits).setSignificantDigits(this.mRoundingType, this.mResolvedMinimumSignificantDigits, this.mResolvedMaximumSignificantDigits).setFractionDigits(this.mRoundingType, this.mResolvedMinimumFractionDigits, this.mResolvedMaximumFractionDigits).setSignDisplay(this.mResolvedSignDisplay).setUnits(this.mResolvedUnit, this.mResolvedUnitDisplay);
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
        linkedHashMap.put("numberingSystem", this.mResolvedNumberingSystem);
        linkedHashMap.put("style", this.mResolvedStyle.toString());
        if (this.mResolvedStyle == IPlatformNumberFormatter.Style.CURRENCY) {
            linkedHashMap.put(FirebaseAnalytics.Param.CURRENCY, this.mResolvedCurrency);
            linkedHashMap.put("currencyDisplay", this.mResolvedCurrencyDisplay.toString());
            linkedHashMap.put("currencySign", this.mResolvedCurrencySign.toString());
        } else if (this.mResolvedStyle == IPlatformNumberFormatter.Style.UNIT) {
            linkedHashMap.put("unit", this.mResolvedUnit);
            linkedHashMap.put("unitDisplay", this.mResolvedUnitDisplay.toString());
        }
        int i = this.mResolvedMinimumIntegerDigits;
        if (i != -1) {
            linkedHashMap.put("minimumIntegerDigits", Integer.valueOf(i));
        }
        if (this.mRoundingType == IPlatformNumberFormatter.RoundingType.SIGNIFICANT_DIGITS) {
            int i2 = this.mResolvedMaximumSignificantDigits;
            if (i2 != -1) {
                linkedHashMap.put("minimumSignificantDigits", Integer.valueOf(i2));
            }
            int i3 = this.mResolvedMinimumSignificantDigits;
            if (i3 != -1) {
                linkedHashMap.put("maximumSignificantDigits", Integer.valueOf(i3));
            }
        } else if (this.mRoundingType == IPlatformNumberFormatter.RoundingType.FRACTION_DIGITS) {
            int i4 = this.mResolvedMinimumFractionDigits;
            if (i4 != -1) {
                linkedHashMap.put("minimumFractionDigits", Integer.valueOf(i4));
            }
            int i5 = this.mResolvedMaximumFractionDigits;
            if (i5 != -1) {
                linkedHashMap.put("maximumFractionDigits", Integer.valueOf(i5));
            }
        }
        linkedHashMap.put("useGrouping", Boolean.valueOf(this.mGroupingUsed));
        linkedHashMap.put("notation", this.mResolvedNotation.toString());
        if (this.mResolvedNotation == IPlatformNumberFormatter.Notation.COMPACT) {
            linkedHashMap.put("compactDisplay", this.mResolvedCompactDisplay.toString());
        }
        linkedHashMap.put("signDisplay", this.mResolvedSignDisplay.toString());
        return linkedHashMap;
    }

    public String format(double d) throws JSRangeErrorException {
        return this.mPlatformNumberFormatter.format(d);
    }

    public List<Map<String, String>> formatToParts(double d) throws JSRangeErrorException {
        ArrayList arrayList = new ArrayList();
        AttributedCharacterIterator formatToParts = this.mPlatformNumberFormatter.formatToParts(d);
        StringBuilder sb = new StringBuilder();
        for (char first = formatToParts.first(); first != 65535; first = formatToParts.next()) {
            sb.append(first);
            if (formatToParts.getIndex() + 1 == formatToParts.getRunLimit()) {
                Iterator<AttributedCharacterIterator.Attribute> it = formatToParts.getAttributes().keySet().iterator();
                String fieldToString = it.hasNext() ? this.mPlatformNumberFormatter.fieldToString(it.next(), d) : "literal";
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

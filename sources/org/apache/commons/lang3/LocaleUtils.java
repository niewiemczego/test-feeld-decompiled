package org.apache.commons.lang3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LocaleUtils {
    private static final ConcurrentMap<String, List<Locale>> cCountriesByLanguage = new ConcurrentHashMap();
    private static final ConcurrentMap<String, List<Locale>> cLanguagesByCountry = new ConcurrentHashMap();

    public static Locale toLocale(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 2 || length == 5 || length >= 7) {
            char charAt = str.charAt(0);
            char charAt2 = str.charAt(1);
            if (charAt < 'a' || charAt > 'z' || charAt2 < 'a' || charAt2 > 'z') {
                throw new IllegalArgumentException("Invalid locale format: " + str);
            } else if (length == 2) {
                return new Locale(str, "");
            } else {
                if (str.charAt(2) == '_') {
                    char charAt3 = str.charAt(3);
                    if (charAt3 == '_') {
                        return new Locale(str.substring(0, 2), "", str.substring(4));
                    }
                    char charAt4 = str.charAt(4);
                    if (charAt3 < 'A' || charAt3 > 'Z' || charAt4 < 'A' || charAt4 > 'Z') {
                        throw new IllegalArgumentException("Invalid locale format: " + str);
                    } else if (length == 5) {
                        return new Locale(str.substring(0, 2), str.substring(3, 5));
                    } else {
                        if (str.charAt(5) == '_') {
                            return new Locale(str.substring(0, 2), str.substring(3, 5), str.substring(6));
                        }
                        throw new IllegalArgumentException("Invalid locale format: " + str);
                    }
                } else {
                    throw new IllegalArgumentException("Invalid locale format: " + str);
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid locale format: " + str);
        }
    }

    public static List<Locale> localeLookupList(Locale locale) {
        return localeLookupList(locale, locale);
    }

    public static List<Locale> localeLookupList(Locale locale, Locale locale2) {
        ArrayList arrayList = new ArrayList(4);
        if (locale != null) {
            arrayList.add(locale);
            if (locale.getVariant().length() > 0) {
                arrayList.add(new Locale(locale.getLanguage(), locale.getCountry()));
            }
            if (locale.getCountry().length() > 0) {
                arrayList.add(new Locale(locale.getLanguage(), ""));
            }
            if (!arrayList.contains(locale2)) {
                arrayList.add(locale2);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static List<Locale> availableLocaleList() {
        return SyncAvoid.AVAILABLE_LOCALE_LIST;
    }

    public static Set<Locale> availableLocaleSet() {
        return SyncAvoid.AVAILABLE_LOCALE_SET;
    }

    public static boolean isAvailableLocale(Locale locale) {
        return availableLocaleList().contains(locale);
    }

    public static List<Locale> languagesByCountry(String str) {
        if (str == null) {
            return Collections.emptyList();
        }
        List<Locale> list = (List) cLanguagesByCountry.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        List<Locale> availableLocaleList = availableLocaleList();
        for (int i = 0; i < availableLocaleList.size(); i++) {
            Locale locale = availableLocaleList.get(i);
            if (str.equals(locale.getCountry()) && locale.getVariant().length() == 0) {
                arrayList.add(locale);
            }
        }
        List unmodifiableList = Collections.unmodifiableList(arrayList);
        ConcurrentMap<String, List<Locale>> concurrentMap = cLanguagesByCountry;
        concurrentMap.putIfAbsent(str, unmodifiableList);
        return (List) concurrentMap.get(str);
    }

    public static List<Locale> countriesByLanguage(String str) {
        if (str == null) {
            return Collections.emptyList();
        }
        List<Locale> list = (List) cCountriesByLanguage.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        List<Locale> availableLocaleList = availableLocaleList();
        for (int i = 0; i < availableLocaleList.size(); i++) {
            Locale locale = availableLocaleList.get(i);
            if (str.equals(locale.getLanguage()) && locale.getCountry().length() != 0 && locale.getVariant().length() == 0) {
                arrayList.add(locale);
            }
        }
        List unmodifiableList = Collections.unmodifiableList(arrayList);
        ConcurrentMap<String, List<Locale>> concurrentMap = cCountriesByLanguage;
        concurrentMap.putIfAbsent(str, unmodifiableList);
        return (List) concurrentMap.get(str);
    }

    static class SyncAvoid {
        /* access modifiers changed from: private */
        public static List<Locale> AVAILABLE_LOCALE_LIST = Collections.unmodifiableList(new ArrayList(Arrays.asList(Locale.getAvailableLocales())));
        /* access modifiers changed from: private */
        public static Set<Locale> AVAILABLE_LOCALE_SET = Collections.unmodifiableSet(new HashSet(LocaleUtils.availableLocaleList()));

        SyncAvoid() {
        }
    }
}

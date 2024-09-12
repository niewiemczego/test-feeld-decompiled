package org.checkerframework.checker.i18nformatter.qual;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public enum I18nConversionCategory {
    UNUSED((String) null, (int) null),
    GENERAL((String) null, (int) null),
    DATE(new Class[]{Date.class, Number.class}, new String[]{"date", "time"}),
    NUMBER(new Class[]{Number.class}, new String[]{"number", "choice"});
    
    static I18nConversionCategory[] namedCategories;
    public final String[] strings;
    public final Class<?>[] types;

    static {
        I18nConversionCategory i18nConversionCategory;
        I18nConversionCategory i18nConversionCategory2;
        namedCategories = new I18nConversionCategory[]{i18nConversionCategory, i18nConversionCategory2};
    }

    private I18nConversionCategory(Class<?>[] clsArr, String[] strArr) {
        this.types = clsArr;
        this.strings = strArr;
    }

    public static I18nConversionCategory stringToI18nConversionCategory(String str) {
        String lowerCase = str.toLowerCase();
        for (I18nConversionCategory i18nConversionCategory : namedCategories) {
            for (String equals : i18nConversionCategory.strings) {
                if (equals.equals(lowerCase)) {
                    return i18nConversionCategory;
                }
            }
        }
        throw new IllegalArgumentException("Invalid format type " + lowerCase);
    }

    private static <E> Set<E> arrayToSet(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    public static boolean isSubsetOf(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        return intersect(i18nConversionCategory, i18nConversionCategory2) == i18nConversionCategory;
    }

    public static I18nConversionCategory intersect(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        I18nConversionCategory i18nConversionCategory3 = UNUSED;
        if (i18nConversionCategory == i18nConversionCategory3) {
            return i18nConversionCategory2;
        }
        if (i18nConversionCategory2 == i18nConversionCategory3) {
            return i18nConversionCategory;
        }
        I18nConversionCategory i18nConversionCategory4 = GENERAL;
        if (i18nConversionCategory == i18nConversionCategory4) {
            return i18nConversionCategory2;
        }
        if (i18nConversionCategory2 == i18nConversionCategory4) {
            return i18nConversionCategory;
        }
        Set arrayToSet = arrayToSet(i18nConversionCategory.types);
        arrayToSet.retainAll(arrayToSet(i18nConversionCategory2.types));
        I18nConversionCategory[] i18nConversionCategoryArr = {DATE, NUMBER};
        for (int i = 0; i < 2; i++) {
            I18nConversionCategory i18nConversionCategory5 = i18nConversionCategoryArr[i];
            if (arrayToSet(i18nConversionCategory5.types).equals(arrayToSet)) {
                return i18nConversionCategory5;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = GENERAL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r0 = DATE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory union(org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory r1, org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory r2) {
        /*
            org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory r0 = UNUSED
            if (r1 == r0) goto L_0x0018
            if (r2 != r0) goto L_0x0007
            goto L_0x0018
        L_0x0007:
            org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory r0 = GENERAL
            if (r1 == r0) goto L_0x0018
            if (r2 != r0) goto L_0x000e
            goto L_0x0018
        L_0x000e:
            org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory r0 = DATE
            if (r1 == r0) goto L_0x0018
            if (r2 != r0) goto L_0x0015
            goto L_0x0018
        L_0x0015:
            org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory r1 = NUMBER
            return r1
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory.union(org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory, org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory):org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory");
    }

    public boolean isAssignableFrom(Class<?> cls) {
        if (this.types == null || cls == Void.TYPE) {
            return true;
        }
        for (Class<?> isAssignableFrom : this.types) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(name());
        if (this.types == null) {
            sb.append(" conversion category (all types)");
        } else {
            StringJoiner stringJoiner = new StringJoiner(", ", " conversion category (one of: ", ")");
            for (Class<?> canonicalName : this.types) {
                stringJoiner.add(canonicalName.getCanonicalName());
            }
            sb.append(stringJoiner);
        }
        return sb.toString();
    }
}

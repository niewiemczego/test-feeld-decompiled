package com.launchdarkly.logging;

public abstract class SimpleFormat {
    private SimpleFormat() {
    }

    public static String format(String str, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(substituteNext(str, 0, obj, sb)));
        return sb.toString();
    }

    public static String format(String str, Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(substituteNext(str, substituteNext(str, 0, obj, sb), obj2, sb)));
        return sb.toString();
    }

    public static String format(String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object substituteNext : objArr) {
            i = substituteNext(str, i, substituteNext, sb);
        }
        sb.append(str.substring(i));
        return sb.toString();
    }

    private static int substituteNext(String str, int i, Object obj, StringBuilder sb) {
        String str2;
        while (i < str.length()) {
            int indexOf = str.indexOf("{}", i);
            if (indexOf < 0) {
                sb.append(str.substring(i));
                return str.length();
            }
            if (indexOf > 0) {
                int i2 = indexOf - 1;
                if (str.charAt(i2) == '\\') {
                    sb.append(str.substring(i, i2));
                    i = indexOf + 2;
                    sb.append(str.substring(indexOf, i));
                }
            }
            sb.append(str.substring(i, indexOf));
            if (obj == null) {
                str2 = "";
            } else {
                str2 = obj.toString();
            }
            sb.append(str2);
            return indexOf + 2;
        }
        return str.length();
    }
}

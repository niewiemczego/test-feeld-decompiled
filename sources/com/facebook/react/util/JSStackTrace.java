package com.facebook.react.util;

import com.facebook.internal.security.CertificateUtil;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSStackTrace {
    public static final String COLUMN_KEY = "column";
    private static final Pattern FILE_ID_PATTERN = Pattern.compile("\\b((?:seg-\\d+(?:_\\d+)?|\\d+)\\.js)");
    public static final String FILE_KEY = "file";
    public static final String LINE_NUMBER_KEY = "lineNumber";
    public static final String METHOD_NAME_KEY = "methodName";

    public static String format(String str, ReadableArray readableArray) {
        StringBuilder append = new StringBuilder(str).append(", stack:\n");
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            append.append(map.getString(METHOD_NAME_KEY)).append("@").append(parseFileId(map));
            if (!map.hasKey("lineNumber") || map.isNull("lineNumber") || map.getType("lineNumber") != ReadableType.Number) {
                append.append(-1);
            } else {
                append.append(map.getInt("lineNumber"));
            }
            if (map.hasKey("column") && !map.isNull("column") && map.getType("column") == ReadableType.Number) {
                append.append(CertificateUtil.DELIMITER).append(map.getInt("column"));
            }
            append.append("\n");
        }
        return append.toString();
    }

    private static String parseFileId(ReadableMap readableMap) {
        String string;
        if (!readableMap.hasKey("file") || readableMap.isNull("file") || readableMap.getType("file") != ReadableType.String || (string = readableMap.getString("file")) == null) {
            return "";
        }
        Matcher matcher = FILE_ID_PATTERN.matcher(string);
        return matcher.find() ? matcher.group(1) + CertificateUtil.DELIMITER : "";
    }
}

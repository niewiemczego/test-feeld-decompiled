package com.facebook.react.devsupport;

import com.facebook.internal.security.CertificateUtil;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.util.JSStackTrace;
import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StackTraceHelper {
    public static final String COLUMN_KEY = "column";
    public static final String LINE_NUMBER_KEY = "lineNumber";
    private static final Pattern STACK_FRAME_PATTERN1 = Pattern.compile("^(?:(.*?)@)?(.*?)\\:([0-9]+)\\:([0-9]+)$");
    private static final Pattern STACK_FRAME_PATTERN2 = Pattern.compile("\\s*(?:at)\\s*(.+?)\\s*[@(](.*):([0-9]+):([0-9]+)[)]$");

    public static class StackFrameImpl implements StackFrame {
        private final int mColumn;
        private final String mFile;
        private final String mFileName;
        private final boolean mIsCollapsed;
        private final int mLine;
        private final String mMethod;

        private StackFrameImpl(String str, String str2, int i, int i2, boolean z) {
            this.mFile = str;
            this.mMethod = str2;
            this.mLine = i;
            this.mColumn = i2;
            this.mFileName = str != null ? new File(str).getName() : "";
            this.mIsCollapsed = z;
        }

        private StackFrameImpl(String str, String str2, int i, int i2) {
            this(str, str2, i, i2, false);
        }

        private StackFrameImpl(String str, String str2, String str3, int i, int i2) {
            this.mFile = str;
            this.mFileName = str2;
            this.mMethod = str3;
            this.mLine = i;
            this.mColumn = i2;
            this.mIsCollapsed = false;
        }

        public String getFile() {
            return this.mFile;
        }

        public String getMethod() {
            return this.mMethod;
        }

        public int getLine() {
            return this.mLine;
        }

        public int getColumn() {
            return this.mColumn;
        }

        public String getFileName() {
            return this.mFileName;
        }

        public boolean isCollapsed() {
            return this.mIsCollapsed;
        }

        public JSONObject toJSON() {
            return new JSONObject((Map<?, ?>) MapBuilder.of("file", getFile(), JSStackTrace.METHOD_NAME_KEY, getMethod(), "lineNumber", Integer.valueOf(getLine()), "column", Integer.valueOf(getColumn()), "collapse", Boolean.valueOf(isCollapsed())));
        }
    }

    public static StackFrame[] convertJsStackTrace(ReadableArray readableArray) {
        int size = readableArray != null ? readableArray.size() : 0;
        StackFrame[] stackFrameArr = new StackFrame[size];
        for (int i = 0; i < size; i++) {
            ReadableType type = readableArray.getType(i);
            if (type == ReadableType.Map) {
                ReadableMap map = readableArray.getMap(i);
                stackFrameArr[i] = new StackFrameImpl(map.getString("file"), map.getString(JSStackTrace.METHOD_NAME_KEY), (!map.hasKey("lineNumber") || map.isNull("lineNumber")) ? -1 : map.getInt("lineNumber"), (!map.hasKey("column") || map.isNull("column")) ? -1 : map.getInt("column"), map.hasKey("collapse") && !map.isNull("collapse") && map.getBoolean("collapse"));
            } else if (type == ReadableType.String) {
                stackFrameArr[i] = new StackFrameImpl((String) null, readableArray.getString(i), -1, -1);
            }
        }
        return stackFrameArr;
    }

    public static StackFrame[] convertJsStackTrace(JSONArray jSONArray) {
        JSONArray jSONArray2 = jSONArray;
        int length = jSONArray2 != null ? jSONArray.length() : 0;
        StackFrame[] stackFrameArr = new StackFrame[length];
        int i = 0;
        while (i < length) {
            try {
                JSONObject jSONObject = jSONArray2.getJSONObject(i);
                stackFrameArr[i] = new StackFrameImpl(jSONObject.getString("file"), jSONObject.getString(JSStackTrace.METHOD_NAME_KEY), (!jSONObject.has("lineNumber") || jSONObject.isNull("lineNumber")) ? -1 : jSONObject.getInt("lineNumber"), (!jSONObject.has("column") || jSONObject.isNull("column")) ? -1 : jSONObject.getInt("column"), jSONObject.has("collapse") && !jSONObject.isNull("collapse") && jSONObject.getBoolean("collapse"));
                i++;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return stackFrameArr;
    }

    public static StackFrame[] convertJsStackTrace(String str) {
        String[] split = str.split("\n");
        StackFrame[] stackFrameArr = new StackFrame[split.length];
        for (int i = 0; i < split.length; i++) {
            Matcher matcher = STACK_FRAME_PATTERN1.matcher(split[i]);
            Matcher matcher2 = STACK_FRAME_PATTERN2.matcher(split[i]);
            if (matcher2.find()) {
                matcher = matcher2;
            } else if (!matcher.find()) {
                stackFrameArr[i] = new StackFrameImpl((String) null, split[i], -1, -1);
            }
            stackFrameArr[i] = new StackFrameImpl(matcher.group(2), matcher.group(1) == null ? "(unknown)" : matcher.group(1), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)));
        }
        return stackFrameArr;
    }

    public static StackFrame[] convertJavaStackTrace(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StackFrame[] stackFrameArr = new StackFrame[stackTrace.length];
        for (int i = 0; i < stackTrace.length; i++) {
            stackFrameArr[i] = new StackFrameImpl(stackTrace[i].getClassName(), stackTrace[i].getFileName(), stackTrace[i].getMethodName(), stackTrace[i].getLineNumber(), -1);
        }
        return stackFrameArr;
    }

    public static String formatFrameSource(StackFrame stackFrame) {
        StringBuilder sb = new StringBuilder();
        sb.append(stackFrame.getFileName());
        int line = stackFrame.getLine();
        if (line > 0) {
            sb.append(CertificateUtil.DELIMITER).append(line);
            int column = stackFrame.getColumn();
            if (column > 0) {
                sb.append(CertificateUtil.DELIMITER).append(column);
            }
        }
        return sb.toString();
    }

    public static String formatStackTrace(String str, StackFrame[] stackFrameArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("\n");
        for (StackFrame stackFrame : stackFrameArr) {
            sb.append(stackFrame.getMethod()).append("\n").append("    ").append(formatFrameSource(stackFrame)).append("\n");
        }
        return sb.toString();
    }
}

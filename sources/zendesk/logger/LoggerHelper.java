package zendesk.logger;

import java.util.ArrayList;
import java.util.List;

class LoggerHelper {
    private static final String DEFAULT_LOG_TAG = "Zendesk";
    private static final int MAXIMUM_ANDROID_LOG_TAG_LENGTH = 23;

    static char getLevelFromPriority(int i) {
        if (i == 2) {
            return 'V';
        }
        if (i == 3) {
            return 'D';
        }
        if (i == 5) {
            return 'W';
        }
        if (i != 6) {
            return i != 7 ? 'I' : 'A';
        }
        return 'E';
    }

    private LoggerHelper() {
    }

    static List<String> splitLogMessage(String str, int i) {
        int min;
        ArrayList arrayList = new ArrayList();
        if (StringUtils.isEmpty(str)) {
            arrayList.add("");
            return arrayList;
        } else if (i < 1) {
            arrayList.add(str);
            return arrayList;
        } else if (str.length() <= i) {
            arrayList.add(str);
            return arrayList;
        } else {
            int i2 = 0;
            int length = str.length();
            while (i2 < length) {
                int indexOf = str.indexOf(StringUtils.LINE_SEPARATOR, i2);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i2 + i);
                    arrayList.add(str.substring(i2, min));
                    if (min >= indexOf) {
                        break;
                    }
                    i2 = min;
                }
                i2 = min + 1;
            }
            return arrayList;
        }
    }

    static String getAndroidTag(String str) {
        if (StringUtils.isEmpty(str)) {
            return "Zendesk";
        }
        return str.length() > 23 ? str.substring(0, 23) : str;
    }
}

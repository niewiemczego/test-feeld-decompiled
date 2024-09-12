package zendesk.logger;

class StringUtils {
    static final String EMPTY_STRING = "";
    static final String LINE_SEPARATOR = System.getProperty("line.separator");

    StringUtils() {
    }

    static boolean hasLength(String str) {
        return str != null && str.trim().length() > 0;
    }

    static boolean isEmpty(String str) {
        return !hasLength(str);
    }
}

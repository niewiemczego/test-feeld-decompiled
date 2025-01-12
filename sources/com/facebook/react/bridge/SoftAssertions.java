package com.facebook.react.bridge;

public class SoftAssertions {
    public static void assertUnreachable(String str) {
        ReactSoftExceptionLogger.logSoftException("SoftAssertions", new AssertionException(str));
    }

    public static void assertCondition(boolean z, String str) {
        if (!z) {
            ReactSoftExceptionLogger.logSoftException("SoftAssertions", new AssertionException(str));
        }
    }

    public static <T> T assertNotNull(T t) {
        if (t == null) {
            ReactSoftExceptionLogger.logSoftException("SoftAssertions", new AssertionException("Expected object to not be null!"));
        }
        return t;
    }
}

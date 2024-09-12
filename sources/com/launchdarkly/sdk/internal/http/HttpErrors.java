package com.launchdarkly.sdk.internal.http;

import com.launchdarkly.logging.LDLogger;

public abstract class HttpErrors {
    public static boolean isHttpErrorRecoverable(int i) {
        return i < 400 || i >= 500 || i == 400 || i == 408 || i == 429;
    }

    private HttpErrors() {
    }

    public static final class HttpErrorException extends Exception {
        private final int status;

        public HttpErrorException(int i) {
            super("HTTP error " + i);
            this.status = i;
        }

        public int getStatus() {
            return this.status;
        }
    }

    public static boolean checkIfErrorIsRecoverableAndLog(LDLogger lDLogger, String str, String str2, int i, String str3) {
        if (i <= 0 || isHttpErrorRecoverable(i)) {
            lDLogger.warn("Error {} ({}): {}", str2, str3, str);
            return true;
        }
        lDLogger.error("Error {} (giving up permanently): {}", str2, str);
        return false;
    }

    public static String httpErrorDescription(int i) {
        return "HTTP error " + i + ((i == 401 || i == 403) ? " (invalid SDK key)" : "");
    }
}

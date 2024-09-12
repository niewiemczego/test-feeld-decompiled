package com.facebook.react.bridge;

public class ReactIgnorableMountingException extends RuntimeException {
    public ReactIgnorableMountingException(String str) {
        super(str);
    }

    public ReactIgnorableMountingException(String str, Throwable th) {
        super(str, th);
    }

    public ReactIgnorableMountingException(Throwable th) {
        super(th);
    }

    public static boolean isIgnorable(Throwable th) {
        while (th != null) {
            if (th instanceof ReactIgnorableMountingException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }
}

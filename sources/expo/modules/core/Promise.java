package expo.modules.core;

import expo.modules.core.interfaces.CodedThrowable;

public interface Promise {
    public static final String UNKNOWN_ERROR = "E_UNKNOWN_ERROR";

    void reject(String str, String str2, Throwable th);

    void resolve(Object obj);

    void reject(Throwable th) {
        if (th instanceof CodedThrowable) {
            CodedThrowable codedThrowable = (CodedThrowable) th;
            reject(codedThrowable.getCode(), codedThrowable.getMessage(), th);
            return;
        }
        reject("E_UNKNOWN_ERROR", th);
    }

    void reject(String str, String str2) {
        reject(str, str2, (Throwable) null);
    }

    void reject(String str, Throwable th) {
        reject(str, th.getMessage(), th);
    }
}

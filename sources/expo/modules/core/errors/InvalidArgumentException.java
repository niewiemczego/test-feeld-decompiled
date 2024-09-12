package expo.modules.core.errors;

public class InvalidArgumentException extends CodedRuntimeException {
    public String getCode() {
        return "ERR_INVALID_ARGUMENT";
    }

    public InvalidArgumentException(String str) {
        super(str);
    }

    public InvalidArgumentException(Throwable th) {
        super(th);
    }

    public InvalidArgumentException(String str, Throwable th) {
        super(str, th);
    }
}

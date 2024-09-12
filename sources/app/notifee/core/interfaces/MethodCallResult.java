package app.notifee.core.interfaces;

public interface MethodCallResult<T> {
    void onComplete(Exception exc, T t);
}

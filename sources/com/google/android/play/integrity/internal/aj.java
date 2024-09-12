package com.google.android.play.integrity.internal;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
public final class aj implements ai {
    private static final aj a = new aj((Object) null);
    private final Object b;

    private aj(Object obj) {
        this.b = obj;
    }

    public static ai b(Object obj) {
        if (obj != null) {
            return new aj(obj);
        }
        throw new NullPointerException("instance cannot be null");
    }

    public final Object a() {
        return this.b;
    }
}

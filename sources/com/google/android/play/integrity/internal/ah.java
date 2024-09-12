package com.google.android.play.integrity.internal;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
public final class ah implements al {
    private static final Object a = new Object();
    private volatile al b;
    private volatile Object c = a;

    private ah(al alVar) {
        this.b = alVar;
    }

    public static al b(al alVar) {
        return alVar instanceof ah ? alVar : new ah(alVar);
    }

    public final Object a() {
        Object obj = this.c;
        Object obj2 = a;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.c;
                if (obj == obj2) {
                    obj = this.b.a();
                    Object obj3 = this.c;
                    if (obj3 != obj2) {
                        if (obj3 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                    }
                    this.c = obj;
                    this.b = null;
                }
            }
        }
        return obj;
    }
}

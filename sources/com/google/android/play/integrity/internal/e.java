package com.google.android.play.integrity.internal;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class e extends f {
    private final int a;
    private final long b;

    e(int i, long j) {
        this.a = i;
        this.b = j;
    }

    public final int a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.a == fVar.a() && this.b == fVar.b();
        }
    }

    public final int hashCode() {
        long j = this.b;
        return ((this.a ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        int i = this.a;
        long j = this.b;
        return "EventRecord{eventType=" + i + ", eventTimestamp=" + j + "}";
    }
}

package bo.app;

public final class o4 {
    private final long a;

    public o4(long j) {
        this.a = j;
    }

    public final long a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof o4) && this.a == ((o4) obj).a;
    }

    public int hashCode() {
        return Long.hashCode(this.a);
    }

    public String toString() {
        return "PushMaxRequestSuccessEvent(lastUpdateTime=" + this.a + ')';
    }
}

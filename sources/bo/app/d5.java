package bo.app;

public final class d5 {
    private final long a;

    public d5(long j) {
        this.a = j;
    }

    public final long a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d5) && this.a == ((d5) obj).a;
    }

    public int hashCode() {
        return Long.hashCode(this.a);
    }

    public String toString() {
        return "SchedulePushDeliveryFlushEvent(sleepDurationMs=" + this.a + ')';
    }
}

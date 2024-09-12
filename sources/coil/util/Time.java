package coil.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcoil/util/Time;", "", "()V", "provider", "Lkotlin/Function0;", "", "currentMillis", "reset", "", "setCurrentMillis", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Time.kt */
public final class Time {
    public static final Time INSTANCE = new Time();
    private static Function0<Long> provider = Time$provider$1.INSTANCE;

    private Time() {
    }

    public final long currentMillis() {
        return provider.invoke().longValue();
    }

    public final void setCurrentMillis(long j) {
        provider = new Time$setCurrentMillis$1(j);
    }

    public final void reset() {
        provider = Time$reset$1.INSTANCE;
    }
}

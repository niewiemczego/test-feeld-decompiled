package coil.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Time.kt */
/* synthetic */ class Time$reset$1 extends FunctionReferenceImpl implements Function0<Long> {
    public static final Time$reset$1 INSTANCE = new Time$reset$1();

    Time$reset$1() {
        super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
    }

    public final Long invoke() {
        return Long.valueOf(System.currentTimeMillis());
    }
}

package zendesk.android.internal.proactivemessaging.di;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProactiveMessagingModule.kt */
final class ProactiveMessagingModule$providesCurrentTimeProvider$1 extends Lambda implements Function0<Long> {
    public static final ProactiveMessagingModule$providesCurrentTimeProvider$1 INSTANCE = new ProactiveMessagingModule$providesCurrentTimeProvider$1();

    ProactiveMessagingModule$providesCurrentTimeProvider$1() {
        super(0);
    }

    public final Long invoke() {
        return Long.valueOf(System.currentTimeMillis());
    }
}

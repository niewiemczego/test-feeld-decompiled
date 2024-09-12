package com.adapty.internal.di;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/sync/Semaphore;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$9 extends Lambda implements Function0<Semaphore> {
    public static final Dependencies$init$9 INSTANCE = new Dependencies$init$9();

    Dependencies$init$9() {
        super(0);
    }

    public final Semaphore invoke() {
        return SemaphoreKt.Semaphore$default(1, 0, 2, (Object) null);
    }
}

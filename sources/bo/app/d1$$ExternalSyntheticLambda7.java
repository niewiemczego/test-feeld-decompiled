package bo.app;

import com.braze.events.IEventSubscriber;
import java.util.concurrent.Semaphore;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class d1$$ExternalSyntheticLambda7 implements IEventSubscriber {
    public final /* synthetic */ d1 f$0;
    public final /* synthetic */ Semaphore f$1;

    public /* synthetic */ d1$$ExternalSyntheticLambda7(d1 d1Var, Semaphore semaphore) {
        this.f$0 = d1Var;
        this.f$1 = semaphore;
    }

    public final void trigger(Object obj) {
        d1.a(this.f$0, this.f$1, (Throwable) obj);
    }
}

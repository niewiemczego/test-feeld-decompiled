package androidx.work;

import androidx.core.util.Consumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Configuration$Builder$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ InitializationExceptionHandler f$0;

    public /* synthetic */ Configuration$Builder$$ExternalSyntheticLambda0(InitializationExceptionHandler initializationExceptionHandler) {
        this.f$0 = initializationExceptionHandler;
    }

    public final void accept(Object obj) {
        this.f$0.handleException((Throwable) obj);
    }
}

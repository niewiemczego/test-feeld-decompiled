package org.apache.commons.io;

import java.io.IOException;
import java.util.function.Consumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ Exception f$0;

    public /* synthetic */ FileUtils$$ExternalSyntheticLambda0(Exception exc) {
        this.f$0 = exc;
    }

    public final void accept(Object obj) {
        this.f$0.addSuppressed((IOException) obj);
    }
}

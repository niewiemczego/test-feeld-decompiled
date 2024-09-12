package org.apache.commons.io.input;

import java.io.IOException;
import org.apache.commons.io.function.IOConsumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ProxyInputStream$$ExternalSyntheticLambda0 implements IOConsumer {
    public final /* synthetic */ ProxyInputStream f$0;

    public /* synthetic */ ProxyInputStream$$ExternalSyntheticLambda0(ProxyInputStream proxyInputStream) {
        this.f$0 = proxyInputStream;
    }

    public final void accept(Object obj) {
        this.f$0.handleIOException((IOException) obj);
    }
}

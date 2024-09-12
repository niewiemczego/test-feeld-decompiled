package org.apache.commons.io.output;

import java.io.IOException;
import org.apache.commons.io.function.IOConsumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ProxyWriter$$ExternalSyntheticLambda0 implements IOConsumer {
    public final /* synthetic */ ProxyWriter f$0;

    public /* synthetic */ ProxyWriter$$ExternalSyntheticLambda0(ProxyWriter proxyWriter) {
        this.f$0 = proxyWriter;
    }

    public final void accept(Object obj) {
        this.f$0.handleIOException((IOException) obj);
    }
}

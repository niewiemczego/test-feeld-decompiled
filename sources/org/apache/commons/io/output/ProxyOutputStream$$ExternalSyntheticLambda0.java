package org.apache.commons.io.output;

import java.io.IOException;
import org.apache.commons.io.function.IOConsumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ProxyOutputStream$$ExternalSyntheticLambda0 implements IOConsumer {
    public final /* synthetic */ ProxyOutputStream f$0;

    public /* synthetic */ ProxyOutputStream$$ExternalSyntheticLambda0(ProxyOutputStream proxyOutputStream) {
        this.f$0 = proxyOutputStream;
    }

    public final void accept(Object obj) {
        this.f$0.handleIOException((IOException) obj);
    }
}

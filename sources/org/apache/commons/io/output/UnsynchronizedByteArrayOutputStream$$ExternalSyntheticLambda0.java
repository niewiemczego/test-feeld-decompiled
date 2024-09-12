package org.apache.commons.io.output;

import java.io.InputStream;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.AbstractByteArrayOutputStream;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UnsynchronizedByteArrayOutputStream$$ExternalSyntheticLambda0 implements AbstractByteArrayOutputStream.InputStreamConstructor {
    public final InputStream construct(byte[] bArr, int i, int i2) {
        return new UnsynchronizedByteArrayInputStream(bArr, i, i2);
    }
}

package io.sentry;

import java.io.StringReader;
import java.nio.charset.Charset;

public final class EnvelopeReader implements IEnvelopeReader {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final ISerializer serializer;

    public EnvelopeReader(ISerializer iSerializer) {
        this.serializer = iSerializer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007f, code lost:
        if (r11[r6] != 10) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0091, code lost:
        throw new java.lang.IllegalArgumentException("Envelope has invalid data following an item.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ec, code lost:
        throw new java.lang.IllegalArgumentException("Item header at index '" + r2.size() + "' is null or empty.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.sentry.SentryEnvelope read(java.io.InputStream r11) throws java.io.IOException {
        /*
            r10 = this;
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 0
            r3 = -1
            r5 = r2
            r4 = r3
        L_0x000d:
            int r6 = r11.read(r0)     // Catch:{ all -> 0x0128 }
            r7 = 10
            if (r6 <= 0) goto L_0x0029
            r8 = r2
        L_0x0016:
            if (r4 != r3) goto L_0x0024
            if (r8 >= r6) goto L_0x0024
            byte r9 = r0[r8]     // Catch:{ all -> 0x0128 }
            if (r9 != r7) goto L_0x0021
            int r4 = r5 + r8
            goto L_0x0024
        L_0x0021:
            int r8 = r8 + 1
            goto L_0x0016
        L_0x0024:
            r1.write(r0, r2, r6)     // Catch:{ all -> 0x0128 }
            int r5 = r5 + r6
            goto L_0x000d
        L_0x0029:
            byte[] r11 = r1.toByteArray()     // Catch:{ all -> 0x0128 }
            int r0 = r11.length     // Catch:{ all -> 0x0128 }
            if (r0 == 0) goto L_0x0120
            if (r4 == r3) goto L_0x0118
            io.sentry.SentryEnvelopeHeader r0 = r10.deserializeEnvelopeHeader(r11, r2, r4)     // Catch:{ all -> 0x0128 }
            if (r0 == 0) goto L_0x0110
            int r4 = r4 + 1
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0128 }
            r2.<init>()     // Catch:{ all -> 0x0128 }
        L_0x003f:
            r5 = r4
        L_0x0040:
            int r6 = r11.length     // Catch:{ all -> 0x0128 }
            if (r5 >= r6) goto L_0x004b
            byte r6 = r11[r5]     // Catch:{ all -> 0x0128 }
            if (r6 != r7) goto L_0x0048
            goto L_0x004c
        L_0x0048:
            int r5 = r5 + 1
            goto L_0x0040
        L_0x004b:
            r5 = r3
        L_0x004c:
            if (r5 == r3) goto L_0x00ed
            int r6 = r5 - r4
            io.sentry.SentryEnvelopeItemHeader r4 = r10.deserializeEnvelopeItemHeader(r11, r4, r6)     // Catch:{ all -> 0x0128 }
            if (r4 == 0) goto L_0x00ca
            int r6 = r4.getLength()     // Catch:{ all -> 0x0128 }
            if (r6 <= 0) goto L_0x00ca
            int r6 = r4.getLength()     // Catch:{ all -> 0x0128 }
            int r6 = r6 + r5
            int r6 = r6 + 1
            int r8 = r11.length     // Catch:{ all -> 0x0128 }
            if (r6 > r8) goto L_0x0092
            int r5 = r5 + 1
            byte[] r5 = java.util.Arrays.copyOfRange(r11, r5, r6)     // Catch:{ all -> 0x0128 }
            io.sentry.SentryEnvelopeItem r8 = new io.sentry.SentryEnvelopeItem     // Catch:{ all -> 0x0128 }
            r8.<init>((io.sentry.SentryEnvelopeItemHeader) r4, (byte[]) r5)     // Catch:{ all -> 0x0128 }
            r2.add(r8)     // Catch:{ all -> 0x0128 }
            int r4 = r11.length     // Catch:{ all -> 0x0128 }
            if (r6 != r4) goto L_0x0078
            goto L_0x0081
        L_0x0078:
            int r4 = r6 + 1
            int r5 = r11.length     // Catch:{ all -> 0x0128 }
            if (r4 != r5) goto L_0x003f
            byte r11 = r11[r6]     // Catch:{ all -> 0x0128 }
            if (r11 != r7) goto L_0x008a
        L_0x0081:
            io.sentry.SentryEnvelope r11 = new io.sentry.SentryEnvelope     // Catch:{ all -> 0x0128 }
            r11.<init>(r0, r2)     // Catch:{ all -> 0x0128 }
            r1.close()
            return r11
        L_0x008a:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0128 }
            java.lang.String r0 = "Envelope has invalid data following an item."
            r11.<init>(r0)     // Catch:{ all -> 0x0128 }
            throw r11     // Catch:{ all -> 0x0128 }
        L_0x0092:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0128 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            r3.<init>()     // Catch:{ all -> 0x0128 }
            java.lang.String r4 = "Invalid length for item at index '"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0128 }
            int r2 = r2.size()     // Catch:{ all -> 0x0128 }
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ all -> 0x0128 }
            java.lang.String r3 = "'. Item is '"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0128 }
            java.lang.StringBuilder r2 = r2.append(r6)     // Catch:{ all -> 0x0128 }
            java.lang.String r3 = "' bytes. There are '"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0128 }
            int r11 = r11.length     // Catch:{ all -> 0x0128 }
            java.lang.StringBuilder r11 = r2.append(r11)     // Catch:{ all -> 0x0128 }
            java.lang.String r2 = "' in the buffer."
            java.lang.StringBuilder r11 = r11.append(r2)     // Catch:{ all -> 0x0128 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0128 }
            r0.<init>(r11)     // Catch:{ all -> 0x0128 }
            throw r0     // Catch:{ all -> 0x0128 }
        L_0x00ca:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0128 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            r0.<init>()     // Catch:{ all -> 0x0128 }
            java.lang.String r3 = "Item header at index '"
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ all -> 0x0128 }
            int r2 = r2.size()     // Catch:{ all -> 0x0128 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0128 }
            java.lang.String r2 = "' is null or empty."
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0128 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0128 }
            r11.<init>(r0)     // Catch:{ all -> 0x0128 }
            throw r11     // Catch:{ all -> 0x0128 }
        L_0x00ed:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0128 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            r0.<init>()     // Catch:{ all -> 0x0128 }
            java.lang.String r3 = "Invalid envelope. Item at index '"
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ all -> 0x0128 }
            int r2 = r2.size()     // Catch:{ all -> 0x0128 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0128 }
            java.lang.String r2 = "'. has no header delimiter."
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0128 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0128 }
            r11.<init>(r0)     // Catch:{ all -> 0x0128 }
            throw r11     // Catch:{ all -> 0x0128 }
        L_0x0110:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0128 }
            java.lang.String r0 = "Envelope header is null."
            r11.<init>(r0)     // Catch:{ all -> 0x0128 }
            throw r11     // Catch:{ all -> 0x0128 }
        L_0x0118:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0128 }
            java.lang.String r0 = "Envelope contains no header."
            r11.<init>(r0)     // Catch:{ all -> 0x0128 }
            throw r11     // Catch:{ all -> 0x0128 }
        L_0x0120:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0128 }
            java.lang.String r0 = "Empty stream."
            r11.<init>(r0)     // Catch:{ all -> 0x0128 }
            throw r11     // Catch:{ all -> 0x0128 }
        L_0x0128:
            r11 = move-exception
            r1.close()     // Catch:{ all -> 0x012d }
            goto L_0x0131
        L_0x012d:
            r0 = move-exception
            r11.addSuppressed(r0)
        L_0x0131:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.EnvelopeReader.read(java.io.InputStream):io.sentry.SentryEnvelope");
    }

    private SentryEnvelopeHeader deserializeEnvelopeHeader(byte[] bArr, int i, int i2) {
        StringReader stringReader = new StringReader(new String(bArr, i, i2, UTF_8));
        try {
            SentryEnvelopeHeader sentryEnvelopeHeader = (SentryEnvelopeHeader) this.serializer.deserialize(stringReader, SentryEnvelopeHeader.class);
            stringReader.close();
            return sentryEnvelopeHeader;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private SentryEnvelopeItemHeader deserializeEnvelopeItemHeader(byte[] bArr, int i, int i2) {
        StringReader stringReader = new StringReader(new String(bArr, i, i2, UTF_8));
        try {
            SentryEnvelopeItemHeader sentryEnvelopeItemHeader = (SentryEnvelopeItemHeader) this.serializer.deserialize(stringReader, SentryEnvelopeItemHeader.class);
            stringReader.close();
            return sentryEnvelopeItemHeader;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}

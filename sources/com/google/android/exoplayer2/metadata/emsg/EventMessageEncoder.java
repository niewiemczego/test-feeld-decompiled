package com.google.android.exoplayer2.metadata.emsg;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class EventMessageEncoder {
    private final ByteArrayOutputStream byteArrayOutputStream;
    private final DataOutputStream dataOutputStream;

    public EventMessageEncoder() {
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(512);
        this.byteArrayOutputStream = byteArrayOutputStream2;
        this.dataOutputStream = new DataOutputStream(byteArrayOutputStream2);
    }

    public byte[] encode(EventMessage eventMessage) {
        this.byteArrayOutputStream.reset();
        try {
            writeNullTerminatedString(this.dataOutputStream, eventMessage.schemeIdUri);
            writeNullTerminatedString(this.dataOutputStream, eventMessage.value != null ? eventMessage.value : "");
            this.dataOutputStream.writeLong(eventMessage.durationMs);
            this.dataOutputStream.writeLong(eventMessage.id);
            this.dataOutputStream.write(eventMessage.messageData);
            this.dataOutputStream.flush();
            return this.byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeNullTerminatedString(DataOutputStream dataOutputStream2, String str) throws IOException {
        dataOutputStream2.writeBytes(str);
        dataOutputStream2.writeByte(0);
    }
}

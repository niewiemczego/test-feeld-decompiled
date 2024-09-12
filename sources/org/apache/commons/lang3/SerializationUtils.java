package org.apache.commons.lang3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Serializable;

public class SerializationUtils {
    public static <T extends Serializable> T clone(T t) {
        return (Serializable) deserialize(serialize(t));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0020 A[SYNTHETIC, Splitter:B:19:0x0020] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void serialize(java.io.Serializable r2, java.io.OutputStream r3) {
        /*
            if (r3 == 0) goto L_0x0024
            r0 = 0
            java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0017 }
            r1.<init>(r3)     // Catch:{ IOException -> 0x0017 }
            r1.writeObject(r2)     // Catch:{ IOException -> 0x0012, all -> 0x000f }
            r1.close()     // Catch:{ IOException -> 0x000e }
        L_0x000e:
            return
        L_0x000f:
            r2 = move-exception
            r0 = r1
            goto L_0x001e
        L_0x0012:
            r2 = move-exception
            r0 = r1
            goto L_0x0018
        L_0x0015:
            r2 = move-exception
            goto L_0x001e
        L_0x0017:
            r2 = move-exception
        L_0x0018:
            org.apache.commons.lang3.SerializationException r3 = new org.apache.commons.lang3.SerializationException     // Catch:{ all -> 0x0015 }
            r3.<init>((java.lang.Throwable) r2)     // Catch:{ all -> 0x0015 }
            throw r3     // Catch:{ all -> 0x0015 }
        L_0x001e:
            if (r0 == 0) goto L_0x0023
            r0.close()     // Catch:{ IOException -> 0x0023 }
        L_0x0023:
            throw r2
        L_0x0024:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "The OutputStream must not be null"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.SerializationUtils.serialize(java.io.Serializable, java.io.OutputStream):void");
    }

    public static byte[] serialize(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        serialize(serializable, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x002b A[SYNTHETIC, Splitter:B:25:0x002b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object deserialize(java.io.InputStream r2) {
        /*
            if (r2 == 0) goto L_0x002f
            r0 = 0
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ ClassNotFoundException -> 0x0022, IOException -> 0x001b }
            r1.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x0022, IOException -> 0x001b }
            java.lang.Object r2 = r1.readObject()     // Catch:{ ClassNotFoundException -> 0x0016, IOException -> 0x0013, all -> 0x0010 }
            r1.close()     // Catch:{ IOException -> 0x000f }
        L_0x000f:
            return r2
        L_0x0010:
            r2 = move-exception
            r0 = r1
            goto L_0x0029
        L_0x0013:
            r2 = move-exception
            r0 = r1
            goto L_0x001c
        L_0x0016:
            r2 = move-exception
            r0 = r1
            goto L_0x0023
        L_0x0019:
            r2 = move-exception
            goto L_0x0029
        L_0x001b:
            r2 = move-exception
        L_0x001c:
            org.apache.commons.lang3.SerializationException r1 = new org.apache.commons.lang3.SerializationException     // Catch:{ all -> 0x0019 }
            r1.<init>((java.lang.Throwable) r2)     // Catch:{ all -> 0x0019 }
            throw r1     // Catch:{ all -> 0x0019 }
        L_0x0022:
            r2 = move-exception
        L_0x0023:
            org.apache.commons.lang3.SerializationException r1 = new org.apache.commons.lang3.SerializationException     // Catch:{ all -> 0x0019 }
            r1.<init>((java.lang.Throwable) r2)     // Catch:{ all -> 0x0019 }
            throw r1     // Catch:{ all -> 0x0019 }
        L_0x0029:
            if (r0 == 0) goto L_0x002e
            r0.close()     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            throw r2
        L_0x002f:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "The InputStream must not be null"
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.SerializationUtils.deserialize(java.io.InputStream):java.lang.Object");
    }

    public static Object deserialize(byte[] bArr) {
        if (bArr != null) {
            return deserialize((InputStream) new ByteArrayInputStream(bArr));
        }
        throw new IllegalArgumentException("The byte[] must not be null");
    }
}

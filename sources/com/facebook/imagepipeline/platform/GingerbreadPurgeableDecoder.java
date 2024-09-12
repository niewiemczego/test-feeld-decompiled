package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;
import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {
    private static Method sGetFileDescriptorMethod;
    @Nullable
    private final WebpBitmapFactory mWebpBitmapFactory = WebpSupportStatus.loadWebpBitmapFactoryIfExists();

    /* access modifiers changed from: protected */
    public Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options) {
        return decodeFileDescriptorAsPurgeable(closeableReference, closeableReference.get().size(), (byte[]) null, options);
    }

    /* access modifiers changed from: protected */
    public Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i, BitmapFactory.Options options) {
        return decodeFileDescriptorAsPurgeable(closeableReference, i, endsWithEOI(closeableReference, i) ? null : EOI, options);
    }

    private static MemoryFile copyToMemoryFile(CloseableReference<PooledByteBuffer> closeableReference, int i, @Nullable byte[] bArr) throws IOException {
        Closeable closeable;
        LimitedInputStream limitedInputStream;
        PooledByteBufferInputStream pooledByteBufferInputStream = null;
        MemoryFile memoryFile = new MemoryFile((String) null, (bArr == null ? 0 : bArr.length) + i);
        memoryFile.allowPurging(false);
        try {
            PooledByteBufferInputStream pooledByteBufferInputStream2 = new PooledByteBufferInputStream(closeableReference.get());
            try {
                limitedInputStream = new LimitedInputStream(pooledByteBufferInputStream2, i);
                try {
                    OutputStream outputStream = memoryFile.getOutputStream();
                    ByteStreams.copy(limitedInputStream, outputStream);
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i, bArr.length);
                    }
                    CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                    Closeables.closeQuietly((InputStream) pooledByteBufferInputStream2);
                    Closeables.closeQuietly((InputStream) limitedInputStream);
                    Closeables.close(outputStream, true);
                    return memoryFile;
                } catch (Throwable th) {
                    th = th;
                    closeable = null;
                    pooledByteBufferInputStream = pooledByteBufferInputStream2;
                    CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                    Closeables.closeQuietly((InputStream) pooledByteBufferInputStream);
                    Closeables.closeQuietly((InputStream) limitedInputStream);
                    Closeables.close(closeable, true);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                limitedInputStream = null;
                pooledByteBufferInputStream = pooledByteBufferInputStream2;
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                Closeables.closeQuietly((InputStream) pooledByteBufferInputStream);
                Closeables.closeQuietly((InputStream) limitedInputStream);
                Closeables.close(closeable, true);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            limitedInputStream = null;
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
            Closeables.closeQuietly((InputStream) pooledByteBufferInputStream);
            Closeables.closeQuietly((InputStream) limitedInputStream);
            Closeables.close(closeable, true);
            throw th;
        }
    }

    private synchronized Method getFileDescriptorMethod() {
        if (sGetFileDescriptorMethod == null) {
            try {
                sGetFileDescriptorMethod = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
            } catch (Exception e) {
                throw Throwables.propagate(e);
            }
        }
        return sGetFileDescriptorMethod;
    }

    private FileDescriptor getMemoryFileDescriptor(MemoryFile memoryFile) {
        try {
            return (FileDescriptor) Preconditions.checkNotNull(getFileDescriptorMethod().invoke(memoryFile, new Object[0]));
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap decodeFileDescriptorAsPurgeable(com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> r2, int r3, @javax.annotation.Nullable byte[] r4, android.graphics.BitmapFactory.Options r5) {
        /*
            r1 = this;
            r0 = 0
            android.os.MemoryFile r2 = copyToMemoryFile(r2, r3, r4)     // Catch:{ IOException -> 0x002f }
            java.io.FileDescriptor r3 = r1.getMemoryFileDescriptor(r2)     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
            com.facebook.common.webp.WebpBitmapFactory r4 = r1.mWebpBitmapFactory     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
            if (r4 == 0) goto L_0x001f
            android.graphics.Bitmap r3 = r4.decodeFileDescriptor(r3, r0, r5)     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
            java.lang.String r4 = "BitmapFactory returned null"
            java.lang.Object r3 = com.facebook.common.internal.Preconditions.checkNotNull(r3, r4)     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
            if (r2 == 0) goto L_0x001e
            r2.close()
        L_0x001e:
            return r3
        L_0x001f:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
            java.lang.String r4 = "WebpBitmapFactory is null"
            r3.<init>(r4)     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
            throw r3     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
        L_0x0027:
            r3 = move-exception
            r0 = r2
            goto L_0x0035
        L_0x002a:
            r3 = move-exception
            r0 = r2
            goto L_0x0030
        L_0x002d:
            r3 = move-exception
            goto L_0x0035
        L_0x002f:
            r3 = move-exception
        L_0x0030:
            java.lang.RuntimeException r2 = com.facebook.common.internal.Throwables.propagate(r3)     // Catch:{ all -> 0x002d }
            throw r2     // Catch:{ all -> 0x002d }
        L_0x0035:
            if (r0 == 0) goto L_0x003a
            r0.close()
        L_0x003a:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.platform.GingerbreadPurgeableDecoder.decodeFileDescriptorAsPurgeable(com.facebook.common.references.CloseableReference, int, byte[], android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }
}

package com.github.penfeizhou.animation.apng.decode;

import com.github.penfeizhou.animation.apng.io.APNGReader;
import com.github.penfeizhou.animation.apng.io.APNGWriter;
import com.github.penfeizhou.animation.decode.Frame;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

public class APNGFrame extends Frame<APNGReader, APNGWriter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ThreadLocal<CRC32> sCRC32 = new ThreadLocal<>();
    private static final byte[] sPNGEndChunk = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
    private static final byte[] sPNGSignatures = {-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};
    public final byte blend_op;
    public final byte dispose_op;
    byte[] ihdrData;
    List<Chunk> imageChunks = new ArrayList();
    List<Chunk> prefixChunks = new ArrayList();

    private CRC32 getCRC32() {
        ThreadLocal<CRC32> threadLocal = sCRC32;
        CRC32 crc32 = threadLocal.get();
        if (crc32 != null) {
            return crc32;
        }
        CRC32 crc322 = new CRC32();
        threadLocal.set(crc322);
        return crc322;
    }

    public APNGFrame(APNGReader aPNGReader, FCTLChunk fCTLChunk) {
        super(aPNGReader);
        this.blend_op = fCTLChunk.blend_op;
        this.dispose_op = fCTLChunk.dispose_op;
        this.frameDuration = (fCTLChunk.delay_num * 1000) / (fCTLChunk.delay_den == 0 ? 100 : fCTLChunk.delay_den);
        if (this.frameDuration < 10) {
            this.frameDuration = 100;
        }
        this.frameWidth = fCTLChunk.width;
        this.frameHeight = fCTLChunk.height;
        this.frameX = fCTLChunk.x_offset;
        this.frameY = fCTLChunk.y_offset;
    }

    private int encode(APNGWriter aPNGWriter) throws IOException {
        int i;
        int i2 = 33;
        for (Chunk chunk : this.prefixChunks) {
            i2 += chunk.length + 12;
        }
        for (Chunk next : this.imageChunks) {
            if (next instanceof IDATChunk) {
                i = next.length + 12;
            } else if (next instanceof FDATChunk) {
                i = next.length + 8;
            }
            i2 += i;
        }
        int length = i2 + sPNGEndChunk.length;
        aPNGWriter.reset(length);
        aPNGWriter.putBytes(sPNGSignatures);
        aPNGWriter.writeInt(13);
        int position = aPNGWriter.position();
        aPNGWriter.writeFourCC(IHDRChunk.ID);
        aPNGWriter.writeInt(this.frameWidth);
        aPNGWriter.writeInt(this.frameHeight);
        aPNGWriter.putBytes(this.ihdrData);
        CRC32 crc32 = getCRC32();
        crc32.reset();
        crc32.update(aPNGWriter.toByteArray(), position, 17);
        aPNGWriter.writeInt((int) crc32.getValue());
        for (Chunk next2 : this.prefixChunks) {
            if (!(next2 instanceof IENDChunk)) {
                ((APNGReader) this.reader).reset();
                ((APNGReader) this.reader).skip((long) next2.offset);
                ((APNGReader) this.reader).read(aPNGWriter.toByteArray(), aPNGWriter.position(), next2.length + 12);
                aPNGWriter.skip(next2.length + 12);
            }
        }
        for (Chunk next3 : this.imageChunks) {
            if (next3 instanceof IDATChunk) {
                ((APNGReader) this.reader).reset();
                ((APNGReader) this.reader).skip((long) next3.offset);
                ((APNGReader) this.reader).read(aPNGWriter.toByteArray(), aPNGWriter.position(), next3.length + 12);
                aPNGWriter.skip(next3.length + 12);
            } else if (next3 instanceof FDATChunk) {
                aPNGWriter.writeInt(next3.length - 4);
                int position2 = aPNGWriter.position();
                aPNGWriter.writeFourCC(IDATChunk.ID);
                ((APNGReader) this.reader).reset();
                ((APNGReader) this.reader).skip((long) (next3.offset + 4 + 4 + 4));
                ((APNGReader) this.reader).read(aPNGWriter.toByteArray(), aPNGWriter.position(), next3.length - 4);
                aPNGWriter.skip(next3.length - 4);
                crc32.reset();
                crc32.update(aPNGWriter.toByteArray(), position2, next3.length);
                aPNGWriter.writeInt((int) crc32.getValue());
            }
        }
        aPNGWriter.putBytes(sPNGEndChunk);
        return length;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r9 = new android.graphics.BitmapFactory.Options();
        r9.inJustDecodeBounds = false;
        r9.inSampleSize = r7;
        r9.inMutable = true;
        r8 = android.graphics.BitmapFactory.decodeByteArray(r8, 0, r0, r9);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap draw(android.graphics.Canvas r5, android.graphics.Paint r6, int r7, android.graphics.Bitmap r8, com.github.penfeizhou.animation.apng.io.APNGWriter r9) {
        /*
            r4 = this;
            int r0 = r4.encode(r9)     // Catch:{ IOException -> 0x007c }
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x007c }
            r1.<init>()     // Catch:{ IOException -> 0x007c }
            r2 = 0
            r1.inJustDecodeBounds = r2     // Catch:{ IOException -> 0x007c }
            r1.inSampleSize = r7     // Catch:{ IOException -> 0x007c }
            r3 = 1
            r1.inMutable = r3     // Catch:{ IOException -> 0x007c }
            r1.inBitmap = r8     // Catch:{ IOException -> 0x007c }
            byte[] r8 = r9.toByteArray()     // Catch:{ IOException -> 0x007c }
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeByteArray(r8, r2, r0, r1)     // Catch:{ IllegalArgumentException -> 0x001c }
            goto L_0x002b
        L_0x001c:
            android.graphics.BitmapFactory$Options r9 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x007c }
            r9.<init>()     // Catch:{ IOException -> 0x007c }
            r9.inJustDecodeBounds = r2     // Catch:{ IOException -> 0x007c }
            r9.inSampleSize = r7     // Catch:{ IOException -> 0x007c }
            r9.inMutable = r3     // Catch:{ IOException -> 0x007c }
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeByteArray(r8, r2, r0, r9)     // Catch:{ IOException -> 0x007c }
        L_0x002b:
            android.graphics.Rect r9 = r4.srcRect     // Catch:{ IOException -> 0x007c }
            r9.left = r2     // Catch:{ IOException -> 0x007c }
            android.graphics.Rect r9 = r4.srcRect     // Catch:{ IOException -> 0x007c }
            r9.top = r2     // Catch:{ IOException -> 0x007c }
            android.graphics.Rect r9 = r4.srcRect     // Catch:{ IOException -> 0x007c }
            int r0 = r8.getWidth()     // Catch:{ IOException -> 0x007c }
            r9.right = r0     // Catch:{ IOException -> 0x007c }
            android.graphics.Rect r9 = r4.srcRect     // Catch:{ IOException -> 0x007c }
            int r0 = r8.getHeight()     // Catch:{ IOException -> 0x007c }
            r9.bottom = r0     // Catch:{ IOException -> 0x007c }
            android.graphics.Rect r9 = r4.dstRect     // Catch:{ IOException -> 0x007c }
            int r0 = r4.frameX     // Catch:{ IOException -> 0x007c }
            float r0 = (float) r0     // Catch:{ IOException -> 0x007c }
            float r7 = (float) r7     // Catch:{ IOException -> 0x007c }
            float r0 = r0 / r7
            int r0 = (int) r0     // Catch:{ IOException -> 0x007c }
            r9.left = r0     // Catch:{ IOException -> 0x007c }
            android.graphics.Rect r9 = r4.dstRect     // Catch:{ IOException -> 0x007c }
            int r0 = r4.frameY     // Catch:{ IOException -> 0x007c }
            float r0 = (float) r0     // Catch:{ IOException -> 0x007c }
            float r0 = r0 / r7
            int r0 = (int) r0     // Catch:{ IOException -> 0x007c }
            r9.top = r0     // Catch:{ IOException -> 0x007c }
            android.graphics.Rect r9 = r4.dstRect     // Catch:{ IOException -> 0x007c }
            int r0 = r4.frameX     // Catch:{ IOException -> 0x007c }
            float r0 = (float) r0     // Catch:{ IOException -> 0x007c }
            float r0 = r0 / r7
            int r1 = r8.getWidth()     // Catch:{ IOException -> 0x007c }
            float r1 = (float) r1     // Catch:{ IOException -> 0x007c }
            float r0 = r0 + r1
            int r0 = (int) r0     // Catch:{ IOException -> 0x007c }
            r9.right = r0     // Catch:{ IOException -> 0x007c }
            android.graphics.Rect r9 = r4.dstRect     // Catch:{ IOException -> 0x007c }
            int r0 = r4.frameY     // Catch:{ IOException -> 0x007c }
            float r0 = (float) r0     // Catch:{ IOException -> 0x007c }
            float r0 = r0 / r7
            int r7 = r8.getHeight()     // Catch:{ IOException -> 0x007c }
            float r7 = (float) r7     // Catch:{ IOException -> 0x007c }
            float r0 = r0 + r7
            int r7 = (int) r0     // Catch:{ IOException -> 0x007c }
            r9.bottom = r7     // Catch:{ IOException -> 0x007c }
            android.graphics.Rect r7 = r4.srcRect     // Catch:{ IOException -> 0x007c }
            android.graphics.Rect r9 = r4.dstRect     // Catch:{ IOException -> 0x007c }
            r5.drawBitmap(r8, r7, r9, r6)     // Catch:{ IOException -> 0x007c }
            return r8
        L_0x007c:
            r5 = move-exception
            r5.printStackTrace()
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.penfeizhou.animation.apng.decode.APNGFrame.draw(android.graphics.Canvas, android.graphics.Paint, int, android.graphics.Bitmap, com.github.penfeizhou.animation.apng.io.APNGWriter):android.graphics.Bitmap");
    }
}

package com.github.penfeizhou.animation.gif.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.penfeizhou.animation.decode.Frame;
import com.github.penfeizhou.animation.gif.io.GifReader;
import com.github.penfeizhou.animation.gif.io.GifWriter;
import java.io.IOException;

public class GifFrame extends Frame<GifReader, GifWriter> {
    private static final int DEFAULT_DELAY = 10;
    private static final ThreadLocal<byte[]> sDataBlock = new ThreadLocal<>();
    public final ColorTable colorTable;
    public final int disposalMethod;
    private final int imageDataOffset;
    private final boolean interlace;
    private final int lzwMinCodeSize;
    public final int transparentColorIndex;

    private native void uncompressLZW(GifReader gifReader, int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, boolean z, byte[] bArr);

    static {
        System.loadLibrary("animation-decoder-gif");
    }

    public GifFrame(GifReader gifReader, ColorTable colorTable2, GraphicControlExtension graphicControlExtension, ImageDescriptor imageDescriptor) {
        super(gifReader);
        if (graphicControlExtension != null) {
            this.disposalMethod = graphicControlExtension.disposalMethod();
            this.frameDuration = (graphicControlExtension.delayTime <= 0 ? 10 : graphicControlExtension.delayTime) * 10;
            if (graphicControlExtension.transparencyFlag()) {
                this.transparentColorIndex = graphicControlExtension.transparentColorIndex;
            } else {
                this.transparentColorIndex = -1;
            }
        } else {
            this.disposalMethod = 0;
            this.transparentColorIndex = -1;
        }
        this.frameX = imageDescriptor.frameX;
        this.frameY = imageDescriptor.frameY;
        this.frameWidth = imageDescriptor.frameWidth;
        this.frameHeight = imageDescriptor.frameHeight;
        this.interlace = imageDescriptor.interlaceFlag();
        if (imageDescriptor.localColorTableFlag()) {
            this.colorTable = imageDescriptor.localColorTable;
        } else {
            this.colorTable = colorTable2;
        }
        this.lzwMinCodeSize = imageDescriptor.lzwMinimumCodeSize;
        this.imageDataOffset = imageDescriptor.imageDataOffset;
    }

    public boolean transparencyFlag() {
        return this.transparentColorIndex >= 0;
    }

    public Bitmap draw(Canvas canvas, Paint paint, int i, Bitmap bitmap, GifWriter gifWriter) {
        try {
            gifWriter.reset((this.frameWidth * this.frameHeight) / (i * i));
            encode(gifWriter.asIntArray(), i);
            bitmap.copyPixelsFromBuffer(gifWriter.asBuffer().rewind());
            this.srcRect.left = 0;
            this.srcRect.top = 0;
            this.srcRect.right = bitmap.getWidth();
            this.srcRect.bottom = bitmap.getHeight();
            float f = (float) i;
            this.dstRect.left = (int) (((float) this.frameX) / f);
            this.dstRect.top = (int) (((float) this.frameY) / f);
            this.dstRect.right = (int) ((((float) this.frameX) / f) + ((float) bitmap.getWidth()));
            this.dstRect.bottom = (int) ((((float) this.frameY) / f) + ((float) bitmap.getHeight()));
            canvas.drawBitmap(bitmap, this.srcRect, this.dstRect, paint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public void encode(int[] iArr, int i) throws IOException {
        ((GifReader) this.reader).reset();
        ((GifReader) this.reader).skip((long) this.imageDataOffset);
        ThreadLocal<byte[]> threadLocal = sDataBlock;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[255];
            threadLocal.set(bArr);
        }
        int[] iArr2 = iArr;
        uncompressLZW((GifReader) this.reader, this.colorTable.getColorTable(), this.transparentColorIndex, iArr2, this.frameWidth / i, this.frameHeight / i, this.lzwMinCodeSize, this.interlace, bArr);
    }
}

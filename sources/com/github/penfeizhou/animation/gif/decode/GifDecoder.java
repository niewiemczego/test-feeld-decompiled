package com.github.penfeizhou.animation.gif.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.github.penfeizhou.animation.decode.Frame;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import com.github.penfeizhou.animation.gif.io.GifReader;
import com.github.penfeizhou.animation.gif.io.GifWriter;
import com.github.penfeizhou.animation.io.Reader;
import com.github.penfeizhou.animation.loader.Loader;
import java.io.IOException;
import java.nio.ByteBuffer;

public class GifDecoder extends FrameSeqDecoder<GifReader, GifWriter> {
    private int bgColor;
    private GifWriter mGifWriter = new GifWriter();
    private int mLoopCount;
    private final Paint paint;
    private final SnapShot snapShot;

    /* access modifiers changed from: protected */
    public int getDesiredSample(int i, int i2) {
        return 1;
    }

    private static class SnapShot {
        ByteBuffer byteBuffer;

        private SnapShot() {
        }
    }

    public GifDecoder(Loader loader, FrameSeqDecoder.RenderListener renderListener) {
        super(loader, renderListener);
        Paint paint2 = new Paint();
        this.paint = paint2;
        this.bgColor = 0;
        this.snapShot = new SnapShot();
        this.mLoopCount = 0;
        paint2.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    public GifWriter getWriter() {
        if (this.mGifWriter == null) {
            this.mGifWriter = new GifWriter();
        }
        return this.mGifWriter;
    }

    /* access modifiers changed from: protected */
    public GifReader getReader(Reader reader) {
        return new GifReader(reader);
    }

    /* access modifiers changed from: protected */
    public int getLoopCount() {
        return this.mLoopCount;
    }

    /* access modifiers changed from: protected */
    public void release() {
        this.snapShot.byteBuffer = null;
        this.mGifWriter = null;
    }

    /* access modifiers changed from: protected */
    public Rect read(GifReader gifReader) throws IOException {
        ColorTable colorTable = null;
        int i = 0;
        int i2 = 0;
        byte b = -1;
        GraphicControlExtension graphicControlExtension = null;
        for (Block next : GifParser.parse(gifReader)) {
            if (next instanceof LogicalScreenDescriptor) {
                LogicalScreenDescriptor logicalScreenDescriptor = (LogicalScreenDescriptor) next;
                i = logicalScreenDescriptor.screenWidth;
                i2 = logicalScreenDescriptor.screenHeight;
                if (logicalScreenDescriptor.gColorTableFlag()) {
                    b = logicalScreenDescriptor.bgColorIndex & 255;
                }
            } else if (next instanceof ColorTable) {
                colorTable = (ColorTable) next;
            } else if (next instanceof GraphicControlExtension) {
                graphicControlExtension = (GraphicControlExtension) next;
            } else if (next instanceof ImageDescriptor) {
                this.frames.add(new GifFrame(gifReader, colorTable, graphicControlExtension, (ImageDescriptor) next));
            } else if (next instanceof ApplicationExtension) {
                ApplicationExtension applicationExtension = (ApplicationExtension) next;
                if ("NETSCAPE2.0".equals(applicationExtension.identifier)) {
                    this.mLoopCount = applicationExtension.loopCount;
                }
            }
        }
        int i3 = i * i2;
        this.frameBuffer = ByteBuffer.allocate(((i3 / (this.sampleSize * this.sampleSize)) + 1) * 4);
        this.snapShot.byteBuffer = ByteBuffer.allocate(((i3 / (this.sampleSize * this.sampleSize)) + 1) * 4);
        if (colorTable != null && b >= 0 && b < colorTable.getColorTable().length) {
            int i4 = colorTable.getColorTable()[b];
            this.bgColor = Color.rgb(i4 & 255, (i4 >> 8) & 255, (i4 >> 16) & 255);
        }
        return new Rect(0, 0, i, i2);
    }

    /* access modifiers changed from: protected */
    public void renderFrame(Frame<GifReader, GifWriter> frame) {
        GifFrame gifFrame = (GifFrame) frame;
        Bitmap obtainBitmap = obtainBitmap(this.fullRect.width() / this.sampleSize, this.fullRect.height() / this.sampleSize);
        Canvas canvas = (Canvas) this.cachedCanvas.get(obtainBitmap);
        if (canvas == null) {
            canvas = new Canvas(obtainBitmap);
            this.cachedCanvas.put(obtainBitmap, canvas);
        }
        Canvas canvas2 = canvas;
        this.frameBuffer.rewind();
        obtainBitmap.copyPixelsFromBuffer(this.frameBuffer);
        int i = 0;
        if (!gifFrame.transparencyFlag()) {
            i = this.bgColor;
        }
        int i2 = i;
        if (this.frameIndex == 0) {
            obtainBitmap.eraseColor(i2);
        } else {
            GifFrame gifFrame2 = (GifFrame) this.frames.get(this.frameIndex - 1);
            canvas2.save();
            canvas2.clipRect(gifFrame2.frameX / this.sampleSize, gifFrame2.frameY / this.sampleSize, (gifFrame2.frameX + gifFrame2.frameWidth) / this.sampleSize, (gifFrame2.frameY + gifFrame2.frameHeight) / this.sampleSize);
            int i3 = gifFrame2.disposalMethod;
            if (i3 == 2) {
                canvas2.drawColor(this.bgColor, PorterDuff.Mode.CLEAR);
            } else if (i3 == 3) {
                this.snapShot.byteBuffer.rewind();
                canvas2.drawColor(this.bgColor, PorterDuff.Mode.CLEAR);
                Bitmap obtainBitmap2 = obtainBitmap(this.fullRect.width() / this.sampleSize, this.fullRect.height() / this.sampleSize);
                obtainBitmap2.copyPixelsFromBuffer(this.snapShot.byteBuffer);
                canvas2.drawBitmap(obtainBitmap2, 0.0f, 0.0f, this.paint);
                recycleBitmap(obtainBitmap2);
            }
            canvas2.restore();
            if (gifFrame.disposalMethod == 3 && gifFrame2.disposalMethod != 3) {
                this.frameBuffer.rewind();
                this.snapShot.byteBuffer.rewind();
                this.snapShot.byteBuffer.put(this.frameBuffer);
            }
        }
        Bitmap obtainBitmap3 = obtainBitmap(frame.frameWidth / this.sampleSize, frame.frameHeight / this.sampleSize);
        gifFrame.draw(canvas2, this.paint, this.sampleSize, obtainBitmap3, getWriter());
        canvas2.drawColor(i2, PorterDuff.Mode.DST_OVER);
        recycleBitmap(obtainBitmap3);
        this.frameBuffer.rewind();
        obtainBitmap.copyPixelsToBuffer(this.frameBuffer);
        recycleBitmap(obtainBitmap);
    }
}

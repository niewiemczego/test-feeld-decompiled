package com.github.penfeizhou.animation.webp.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.github.penfeizhou.animation.decode.Frame;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import com.github.penfeizhou.animation.io.Reader;
import com.github.penfeizhou.animation.loader.Loader;
import com.github.penfeizhou.animation.webp.io.WebPReader;
import com.github.penfeizhou.animation.webp.io.WebPWriter;
import java.io.IOException;

public class WebPDecoder extends FrameSeqDecoder<WebPReader, WebPWriter> {
    private static final String TAG = "WebPDecoder";
    private boolean alpha;
    private int backgroundColor;
    private int canvasHeight;
    private int canvasWidth;
    private int loopCount;
    private final Paint mTransparentFillPaint;
    private WebPWriter mWriter;
    private Paint paint;

    /* access modifiers changed from: protected */
    public void release() {
    }

    public WebPDecoder(Loader loader, FrameSeqDecoder.RenderListener renderListener) {
        super(loader, renderListener);
        Paint paint2 = new Paint();
        this.mTransparentFillPaint = paint2;
        paint2.setColor(0);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    /* access modifiers changed from: protected */
    public WebPWriter getWriter() {
        if (this.mWriter == null) {
            this.mWriter = new WebPWriter();
        }
        return this.mWriter;
    }

    /* access modifiers changed from: protected */
    public WebPReader getReader(Reader reader) {
        return new WebPReader(reader);
    }

    /* access modifiers changed from: protected */
    public int getLoopCount() {
        return this.loopCount;
    }

    /* access modifiers changed from: protected */
    public Rect read(WebPReader webPReader) throws IOException {
        boolean z = false;
        boolean z2 = false;
        for (BaseChunk next : WebPParser.parse(webPReader)) {
            if (next instanceof VP8XChunk) {
                VP8XChunk vP8XChunk = (VP8XChunk) next;
                this.canvasWidth = vP8XChunk.canvasWidth;
                this.canvasHeight = vP8XChunk.canvasHeight;
                this.alpha = vP8XChunk.alpha();
                z2 = true;
            } else if (next instanceof ANIMChunk) {
                ANIMChunk aNIMChunk = (ANIMChunk) next;
                this.backgroundColor = aNIMChunk.backgroundColor;
                this.loopCount = aNIMChunk.loopCount;
                z = true;
            } else if (next instanceof ANMFChunk) {
                this.frames.add(new AnimationFrame(webPReader, (ANMFChunk) next));
            }
        }
        if (!z) {
            if (!z2) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(webPReader.toInputStream(), (Rect) null, options);
                this.canvasWidth = options.outWidth;
                this.canvasHeight = options.outHeight;
            }
            this.frames.add(new StillFrame(webPReader, this.canvasWidth, this.canvasHeight));
            this.loopCount = 1;
        }
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setAntiAlias(true);
        if (!this.alpha) {
            this.mTransparentFillPaint.setColor(this.backgroundColor);
        }
        return new Rect(0, 0, this.canvasWidth, this.canvasHeight);
    }

    /* access modifiers changed from: protected */
    public void renderFrame(Frame<WebPReader, WebPWriter> frame) {
        Bitmap obtainBitmap;
        if (frame != null && this.fullRect != null && this.fullRect.width() > 0 && this.fullRect.height() > 0 && (obtainBitmap = obtainBitmap(this.fullRect.width() / this.sampleSize, this.fullRect.height() / this.sampleSize)) != null) {
            Canvas canvas = (Canvas) this.cachedCanvas.get(obtainBitmap);
            if (canvas == null) {
                canvas = new Canvas(obtainBitmap);
                this.cachedCanvas.put(obtainBitmap, canvas);
            }
            this.frameBuffer.rewind();
            obtainBitmap.copyPixelsFromBuffer(this.frameBuffer);
            if (this.frameIndex != 0) {
                Frame frame2 = (Frame) this.frames.get(this.frameIndex - 1);
                if ((frame2 instanceof AnimationFrame) && ((AnimationFrame) frame2).disposalMethod) {
                    float f = (((float) frame2.frameX) * 2.0f) / ((float) this.sampleSize);
                    float f2 = (((float) frame2.frameY) * 2.0f) / ((float) this.sampleSize);
                    float f3 = ((float) ((frame2.frameX * 2) + frame2.frameWidth)) / ((float) this.sampleSize);
                    canvas.drawRect(f, f2, f3, ((float) ((frame2.frameY * 2) + frame2.frameHeight)) / ((float) this.sampleSize), this.mTransparentFillPaint);
                }
            } else if (this.alpha) {
                canvas.drawColor(0, PorterDuff.Mode.SRC);
            } else {
                canvas.drawColor(this.backgroundColor, PorterDuff.Mode.SRC);
            }
            Bitmap bitmap = null;
            if (frame.frameWidth > 0 && frame.frameHeight > 0) {
                bitmap = obtainBitmap(frame.frameWidth / this.sampleSize, frame.frameHeight / this.sampleSize);
            }
            recycleBitmap(frame.draw(canvas, this.paint, this.sampleSize, bitmap, getWriter()));
            recycleBitmap(bitmap);
            this.frameBuffer.rewind();
            obtainBitmap.copyPixelsToBuffer(this.frameBuffer);
            recycleBitmap(obtainBitmap);
        }
    }
}

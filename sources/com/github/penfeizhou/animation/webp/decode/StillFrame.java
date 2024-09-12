package com.github.penfeizhou.animation.webp.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Xfermode;
import com.github.penfeizhou.animation.decode.Frame;
import com.github.penfeizhou.animation.webp.io.WebPReader;
import com.github.penfeizhou.animation.webp.io.WebPWriter;
import java.io.IOException;

public class StillFrame extends Frame<WebPReader, WebPWriter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public StillFrame(WebPReader webPReader, int i, int i2) {
        super(webPReader);
        this.frameWidth = i;
        this.frameHeight = i2;
    }

    public Bitmap draw(Canvas canvas, Paint paint, int i, Bitmap bitmap, WebPWriter webPWriter) {
        Bitmap bitmap2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        options.inMutable = true;
        options.inBitmap = bitmap;
        Bitmap bitmap3 = null;
        try {
            bitmap2 = BitmapFactory.decodeStream(((WebPReader) this.reader).toInputStream(), (Rect) null, options);
        } catch (IllegalArgumentException e) {
            try {
                e.printStackTrace();
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmap2 = BitmapFactory.decodeStream(((WebPReader) this.reader).toInputStream(), (Rect) null, options2);
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                return bitmap3;
            }
        }
        try {
            paint.setXfermode((Xfermode) null);
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
            return bitmap2;
        } catch (IOException e3) {
            e = e3;
            bitmap3 = bitmap2;
        }
    }
}

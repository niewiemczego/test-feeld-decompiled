package com.github.penfeizhou.animation.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.github.penfeizhou.animation.io.Reader;
import com.github.penfeizhou.animation.io.Writer;

public abstract class Frame<R extends Reader, W extends Writer> {
    protected final Rect dstRect = new Rect();
    public int frameDuration;
    public int frameHeight;
    public int frameWidth;
    public int frameX;
    public int frameY;
    protected final R reader;
    protected final Rect srcRect = new Rect();

    public abstract Bitmap draw(Canvas canvas, Paint paint, int i, Bitmap bitmap, W w);

    public Frame(R r) {
        this.reader = r;
    }
}

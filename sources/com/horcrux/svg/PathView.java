package com.horcrux.svg;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.ReactContext;

class PathView extends RenderableView {
    private Path mPath = new Path();

    public PathView(ReactContext reactContext) {
        super(reactContext);
        PathParser.mScale = this.mScale;
    }

    public void setD(String str) {
        this.mPath = PathParser.parse(str);
        this.elements = PathParser.elements;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        return this.mPath;
    }
}

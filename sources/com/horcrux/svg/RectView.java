package com.horcrux.svg;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;

class RectView extends RenderableView {
    private SVGLength mH;
    private SVGLength mRx;
    private SVGLength mRy;
    private SVGLength mW;
    private SVGLength mX;
    private SVGLength mY;

    public RectView(ReactContext reactContext) {
        super(reactContext);
    }

    public void setX(Dynamic dynamic) {
        this.mX = SVGLength.from(dynamic);
        invalidate();
    }

    public void setX(String str) {
        this.mX = SVGLength.from(str);
        invalidate();
    }

    public void setX(Double d) {
        this.mX = SVGLength.from(d);
        invalidate();
    }

    public void setY(Dynamic dynamic) {
        this.mY = SVGLength.from(dynamic);
        invalidate();
    }

    public void setY(String str) {
        this.mY = SVGLength.from(str);
        invalidate();
    }

    public void setY(Double d) {
        this.mY = SVGLength.from(d);
        invalidate();
    }

    public void setWidth(Dynamic dynamic) {
        this.mW = SVGLength.from(dynamic);
        invalidate();
    }

    public void setWidth(String str) {
        this.mW = SVGLength.from(str);
        invalidate();
    }

    public void setWidth(Double d) {
        this.mW = SVGLength.from(d);
        invalidate();
    }

    public void setHeight(Dynamic dynamic) {
        this.mH = SVGLength.from(dynamic);
        invalidate();
    }

    public void setHeight(String str) {
        this.mH = SVGLength.from(str);
        invalidate();
    }

    public void setHeight(Double d) {
        this.mH = SVGLength.from(d);
        invalidate();
    }

    public void setRx(Dynamic dynamic) {
        this.mRx = SVGLength.from(dynamic);
        invalidate();
    }

    public void setRx(String str) {
        this.mRx = SVGLength.from(str);
        invalidate();
    }

    public void setRx(Double d) {
        this.mRx = SVGLength.from(d);
        invalidate();
    }

    public void setRy(Dynamic dynamic) {
        this.mRy = SVGLength.from(dynamic);
        invalidate();
    }

    public void setRy(String str) {
        this.mRy = SVGLength.from(str);
        invalidate();
    }

    public void setRy(Double d) {
        this.mRy = SVGLength.from(d);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Path getPath(android.graphics.Canvas r20, android.graphics.Paint r21) {
        /*
            r19 = this;
            r0 = r19
            android.graphics.Path r9 = new android.graphics.Path
            r9.<init>()
            com.horcrux.svg.SVGLength r1 = r0.mX
            double r1 = r0.relativeOnWidth(r1)
            com.horcrux.svg.SVGLength r3 = r0.mY
            double r3 = r0.relativeOnHeight(r3)
            com.horcrux.svg.SVGLength r5 = r0.mW
            double r5 = r0.relativeOnWidth(r5)
            com.horcrux.svg.SVGLength r7 = r0.mH
            double r7 = r0.relativeOnHeight(r7)
            com.horcrux.svg.SVGLength r10 = r0.mRx
            if (r10 != 0) goto L_0x003d
            com.horcrux.svg.SVGLength r11 = r0.mRy
            if (r11 == 0) goto L_0x0028
            goto L_0x003d
        L_0x0028:
            float r10 = (float) r1
            float r11 = (float) r3
            double r1 = r1 + r5
            float r5 = (float) r1
            double r3 = r3 + r7
            float r6 = (float) r3
            android.graphics.Path$Direction r7 = android.graphics.Path.Direction.CW
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r5
            r5 = r6
            r6 = r7
            r1.addRect(r2, r3, r4, r5, r6)
            r9.close()
            goto L_0x0099
        L_0x003d:
            if (r10 != 0) goto L_0x0047
            com.horcrux.svg.SVGLength r10 = r0.mRy
            double r10 = r0.relativeOnHeight(r10)
        L_0x0045:
            r12 = r10
            goto L_0x005a
        L_0x0047:
            com.horcrux.svg.SVGLength r11 = r0.mRy
            if (r11 != 0) goto L_0x0050
            double r10 = r0.relativeOnWidth(r10)
            goto L_0x0045
        L_0x0050:
            double r10 = r0.relativeOnWidth(r10)
            com.horcrux.svg.SVGLength r12 = r0.mRy
            double r12 = r0.relativeOnHeight(r12)
        L_0x005a:
            r14 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r16 = r5 / r14
            int r18 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r18 <= 0) goto L_0x0064
            r10 = r16
        L_0x0064:
            double r14 = r7 / r14
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 <= 0) goto L_0x006b
            r12 = r14
        L_0x006b:
            int r14 = android.os.Build.VERSION.SDK_INT
            r15 = 21
            if (r14 < r15) goto L_0x0087
            float r14 = (float) r1
            float r15 = (float) r3
            double r1 = r1 + r5
            float r5 = (float) r1
            double r3 = r3 + r7
            float r6 = (float) r3
            float r7 = (float) r10
            float r8 = (float) r12
            android.graphics.Path$Direction r10 = android.graphics.Path.Direction.CW
            r1 = r9
            r2 = r14
            r3 = r15
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r10
            r1.addRoundRect(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0099
        L_0x0087:
            android.graphics.RectF r14 = new android.graphics.RectF
            float r15 = (float) r1
            float r0 = (float) r3
            double r1 = r1 + r5
            float r1 = (float) r1
            double r3 = r3 + r7
            float r2 = (float) r3
            r14.<init>(r15, r0, r1, r2)
            float r0 = (float) r10
            float r1 = (float) r12
            android.graphics.Path$Direction r2 = android.graphics.Path.Direction.CW
            r9.addRoundRect(r14, r0, r1, r2)
        L_0x0099:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.RectView.getPath(android.graphics.Canvas, android.graphics.Paint):android.graphics.Path");
    }
}

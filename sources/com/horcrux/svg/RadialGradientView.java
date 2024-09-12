package com.horcrux.svg;

import android.graphics.Matrix;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.ReactConstants;
import com.horcrux.svg.Brush;
import javax.annotation.Nullable;

class RadialGradientView extends DefinitionView {
    private static final float[] sRawMatrix = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private SVGLength mCx;
    private SVGLength mCy;
    private SVGLength mFx;
    private SVGLength mFy;
    private ReadableArray mGradient;
    private Brush.BrushUnits mGradientUnits;
    private Matrix mMatrix = null;
    private SVGLength mRx;
    private SVGLength mRy;

    public RadialGradientView(ReactContext reactContext) {
        super(reactContext);
    }

    public void setFx(Dynamic dynamic) {
        this.mFx = SVGLength.from(dynamic);
        invalidate();
    }

    public void setFx(String str) {
        this.mFx = SVGLength.from(str);
        invalidate();
    }

    public void setFx(Double d) {
        this.mFx = SVGLength.from(d);
        invalidate();
    }

    public void setFy(Dynamic dynamic) {
        this.mFy = SVGLength.from(dynamic);
        invalidate();
    }

    public void setFy(String str) {
        this.mFy = SVGLength.from(str);
        invalidate();
    }

    public void setFy(Double d) {
        this.mFy = SVGLength.from(d);
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

    public void setCx(Dynamic dynamic) {
        this.mCx = SVGLength.from(dynamic);
        invalidate();
    }

    public void setCx(String str) {
        this.mCx = SVGLength.from(str);
        invalidate();
    }

    public void setCx(Double d) {
        this.mCx = SVGLength.from(d);
        invalidate();
    }

    public void setCy(Dynamic dynamic) {
        this.mCy = SVGLength.from(dynamic);
        invalidate();
    }

    public void setCy(String str) {
        this.mCy = SVGLength.from(str);
        invalidate();
    }

    public void setCy(Double d) {
        this.mCy = SVGLength.from(d);
        invalidate();
    }

    public void setGradient(ReadableArray readableArray) {
        this.mGradient = readableArray;
        invalidate();
    }

    public void setGradientUnits(int i) {
        if (i == 0) {
            this.mGradientUnits = Brush.BrushUnits.OBJECT_BOUNDING_BOX;
        } else if (i == 1) {
            this.mGradientUnits = Brush.BrushUnits.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    public void setGradientTransform(@Nullable ReadableArray readableArray) {
        if (readableArray != null) {
            float[] fArr = sRawMatrix;
            int matrixData = PropHelper.toMatrixData(readableArray, fArr, this.mScale);
            if (matrixData == 6) {
                if (this.mMatrix == null) {
                    this.mMatrix = new Matrix();
                }
                this.mMatrix.setValues(fArr);
            } else if (matrixData != -1) {
                FLog.w(ReactConstants.TAG, "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.mMatrix = null;
        }
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        if (this.mName != null) {
            Brush brush = new Brush(Brush.BrushType.RADIAL_GRADIENT, new SVGLength[]{this.mFx, this.mFy, this.mRx, this.mRy, this.mCx, this.mCy}, this.mGradientUnits);
            brush.setGradientColors(this.mGradient);
            Matrix matrix = this.mMatrix;
            if (matrix != null) {
                brush.setGradientTransform(matrix);
            }
            SvgView svgView = getSvgView();
            if (this.mGradientUnits == Brush.BrushUnits.USER_SPACE_ON_USE) {
                brush.setUserSpaceBoundingBox(svgView.getCanvasBounds());
            }
            svgView.defineBrush(brush, this.mName);
        }
    }
}

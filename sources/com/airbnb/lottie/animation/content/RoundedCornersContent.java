package com.airbnb.lottie.animation.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class RoundedCornersContent implements ShapeModifierContent, BaseKeyframeAnimation.AnimationListener {
    private static final float ROUNDED_CORNER_MAGIC_NUMBER = 0.5519f;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<Float, Float> roundedCorners;
    private ShapeData shapeData;

    public void setContents(List<Content> list, List<Content> list2) {
    }

    public RoundedCornersContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, RoundedCorners roundedCorners2) {
        this.lottieDrawable = lottieDrawable2;
        this.name = roundedCorners2.getName();
        BaseKeyframeAnimation<Float, Float> createAnimation = roundedCorners2.getCornerRadius().createAnimation();
        this.roundedCorners = createAnimation;
        baseLayer.addAnimation(createAnimation);
        createAnimation.addUpdateListener(this);
    }

    public String getName() {
        return this.name;
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public BaseKeyframeAnimation<Float, Float> getRoundedCorners() {
        return this.roundedCorners;
    }

    public ShapeData modifyShape(ShapeData shapeData2) {
        PointF pointF;
        boolean z;
        List<CubicCurveData> list;
        List<CubicCurveData> curves = shapeData2.getCurves();
        if (curves.size() <= 2) {
            return shapeData2;
        }
        float floatValue = this.roundedCorners.getValue().floatValue();
        if (floatValue == 0.0f) {
            return shapeData2;
        }
        ShapeData shapeData3 = getShapeData(shapeData2);
        shapeData3.setInitialPoint(shapeData2.getInitialPoint().x, shapeData2.getInitialPoint().y);
        List<CubicCurveData> curves2 = shapeData3.getCurves();
        boolean isClosed = shapeData2.isClosed();
        int i = 0;
        int i2 = 0;
        while (i < curves.size()) {
            CubicCurveData cubicCurveData = curves.get(i);
            CubicCurveData cubicCurveData2 = curves.get(floorMod(i - 1, curves.size()));
            CubicCurveData cubicCurveData3 = curves.get(floorMod(i - 2, curves.size()));
            PointF vertex = (i != 0 || isClosed) ? cubicCurveData2.getVertex() : shapeData2.getInitialPoint();
            if (i != 0 || isClosed) {
                pointF = cubicCurveData2.getControlPoint2();
            } else {
                pointF = vertex;
            }
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            PointF vertex2 = cubicCurveData3.getVertex();
            PointF vertex3 = cubicCurveData.getVertex();
            boolean z2 = !shapeData2.isClosed() && i == 0 && i == curves.size() + -1;
            if (!pointF.equals(vertex) || !controlPoint1.equals(vertex) || z2) {
                list = curves;
                z = isClosed;
                CubicCurveData cubicCurveData4 = curves2.get(floorMod(i2 - 1, curves2.size()));
                cubicCurveData4.setControlPoint2(cubicCurveData2.getVertex().x, cubicCurveData2.getVertex().y);
                cubicCurveData4.setVertex(cubicCurveData2.getVertex().x, cubicCurveData2.getVertex().y);
                curves2.get(i2).setControlPoint1(cubicCurveData.getVertex().x, cubicCurveData.getVertex().y);
            } else {
                float f = vertex.x - vertex2.x;
                float f2 = vertex.y - vertex2.y;
                float f3 = vertex3.x - vertex.x;
                float f4 = vertex3.y - vertex.y;
                list = curves;
                z = isClosed;
                float min = Math.min(floatValue / ((float) Math.hypot((double) f, (double) f2)), 0.5f);
                float min2 = Math.min(floatValue / ((float) Math.hypot((double) f3, (double) f4)), 0.5f);
                float f5 = vertex.x + ((vertex2.x - vertex.x) * min);
                float f6 = vertex.y + ((vertex2.y - vertex.y) * min);
                float f7 = vertex.x + ((vertex3.x - vertex.x) * min2);
                float f8 = vertex.y + ((vertex3.y - vertex.y) * min2);
                float f9 = f5 - ((f5 - vertex.x) * ROUNDED_CORNER_MAGIC_NUMBER);
                float f10 = f6 - ((f6 - vertex.y) * ROUNDED_CORNER_MAGIC_NUMBER);
                float f11 = f7 - ((f7 - vertex.x) * ROUNDED_CORNER_MAGIC_NUMBER);
                float f12 = f8 - ((f8 - vertex.y) * ROUNDED_CORNER_MAGIC_NUMBER);
                CubicCurveData cubicCurveData5 = curves2.get(floorMod(i2 - 1, curves2.size()));
                CubicCurveData cubicCurveData6 = curves2.get(i2);
                cubicCurveData5.setControlPoint2(f5, f6);
                cubicCurveData5.setVertex(f5, f6);
                if (i == 0) {
                    shapeData3.setInitialPoint(f5, f6);
                }
                cubicCurveData6.setControlPoint1(f9, f10);
                i2++;
                cubicCurveData6.setControlPoint2(f11, f12);
                cubicCurveData6.setVertex(f7, f8);
                curves2.get(i2).setControlPoint1(f7, f8);
            }
            i2++;
            i++;
            curves = list;
            isClosed = z;
        }
        return shapeData3;
    }

    private ShapeData getShapeData(ShapeData shapeData2) {
        PointF pointF;
        List<CubicCurveData> curves = shapeData2.getCurves();
        boolean isClosed = shapeData2.isClosed();
        int size = curves.size() - 1;
        int i = 0;
        while (size >= 0) {
            CubicCurveData cubicCurveData = curves.get(size);
            CubicCurveData cubicCurveData2 = curves.get(floorMod(size - 1, curves.size()));
            PointF vertex = (size != 0 || isClosed) ? cubicCurveData2.getVertex() : shapeData2.getInitialPoint();
            if (size != 0 || isClosed) {
                pointF = cubicCurveData2.getControlPoint2();
            } else {
                pointF = vertex;
            }
            i = (!pointF.equals(vertex) || !cubicCurveData.getControlPoint1().equals(vertex) || (!shapeData2.isClosed() && size == 0 && size == curves.size() - 1)) ? i + 1 : i + 2;
            size--;
        }
        ShapeData shapeData3 = this.shapeData;
        if (shapeData3 == null || shapeData3.getCurves().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new CubicCurveData());
            }
            this.shapeData = new ShapeData(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.shapeData.setClosed(isClosed);
        return this.shapeData;
    }

    private static int floorMod(int i, int i2) {
        return i - (floorDiv(i, i2) * i2);
    }

    private static int floorDiv(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }
}

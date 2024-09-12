package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

public class GenericDraweeHierarchyInflater {
    public static GenericDraweeHierarchy inflateHierarchy(Context context, @Nullable AttributeSet attributeSet) {
        return inflateBuilder(context, attributeSet).build();
    }

    public static GenericDraweeHierarchyBuilder inflateBuilder(Context context, @Nullable AttributeSet attributeSet) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("GenericDraweeHierarchyBuilder#inflateBuilder");
        }
        GenericDraweeHierarchyBuilder updateBuilder = updateBuilder(new GenericDraweeHierarchyBuilder(context.getResources()), context, attributeSet);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return updateBuilder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01cb, code lost:
        if (r14 != false) goto L_0x01e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01e5, code lost:
        if (r5 != false) goto L_0x01e7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0203  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.drawee.generic.GenericDraweeHierarchyBuilder updateBuilder(com.facebook.drawee.generic.GenericDraweeHierarchyBuilder r18, android.content.Context r19, @javax.annotation.Nullable android.util.AttributeSet r20) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            if (r2 == 0) goto L_0x0211
            int[] r6 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy
            android.content.res.TypedArray r2 = r1.obtainStyledAttributes(r2, r6)
            int r7 = r2.getIndexCount()     // Catch:{ all -> 0x01f1 }
            r5 = 1
            r6 = 0
            r8 = 0
            r9 = 1
            r10 = 1
            r11 = 1
            r12 = 1
            r13 = 1
            r14 = 1
            r15 = 1
            r16 = 0
        L_0x001e:
            if (r8 >= r7) goto L_0x019b
            int r3 = r2.getIndex(r8)     // Catch:{ all -> 0x0198 }
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_actualImageScaleType     // Catch:{ all -> 0x0198 }
            if (r3 != r4) goto L_0x0031
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r3 = getScaleTypeFromXml(r2, r3)     // Catch:{ all -> 0x0198 }
            r0.setActualImageScaleType(r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x0031:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_placeholderImage     // Catch:{ all -> 0x0198 }
            if (r3 != r4) goto L_0x003e
            android.graphics.drawable.Drawable r3 = getDrawable(r1, r2, r3)     // Catch:{ all -> 0x0198 }
            r0.setPlaceholderImage((android.graphics.drawable.Drawable) r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x003e:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_pressedStateOverlayImage     // Catch:{ all -> 0x0198 }
            if (r3 != r4) goto L_0x004b
            android.graphics.drawable.Drawable r3 = getDrawable(r1, r2, r3)     // Catch:{ all -> 0x0198 }
            r0.setPressedStateOverlay(r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x004b:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_progressBarImage     // Catch:{ all -> 0x0198 }
            if (r3 != r4) goto L_0x0058
            android.graphics.drawable.Drawable r3 = getDrawable(r1, r2, r3)     // Catch:{ all -> 0x0198 }
            r0.setProgressBarImage((android.graphics.drawable.Drawable) r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x0058:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_fadeDuration     // Catch:{ all -> 0x0198 }
            if (r3 != r4) goto L_0x0065
            r4 = 0
            int r3 = r2.getInt(r3, r4)     // Catch:{ all -> 0x0198 }
            r0.setFadeDuration(r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x0065:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_viewAspectRatio     // Catch:{ all -> 0x0198 }
            if (r3 != r4) goto L_0x0072
            r4 = 0
            float r3 = r2.getFloat(r3, r4)     // Catch:{ all -> 0x0198 }
            r0.setDesiredAspectRatio(r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x0072:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_placeholderImageScaleType     // Catch:{ all -> 0x0198 }
            if (r3 != r4) goto L_0x007e
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r3 = getScaleTypeFromXml(r2, r3)     // Catch:{ all -> 0x0198 }
            r0.setPlaceholderImageScaleType(r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x007e:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_retryImage     // Catch:{ all -> 0x0198 }
            if (r3 != r4) goto L_0x008a
            android.graphics.drawable.Drawable r3 = getDrawable(r1, r2, r3)     // Catch:{ all -> 0x0198 }
            r0.setRetryImage((android.graphics.drawable.Drawable) r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x008a:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_retryImageScaleType     // Catch:{ all -> 0x0198 }
            if (r3 != r4) goto L_0x0096
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r3 = getScaleTypeFromXml(r2, r3)     // Catch:{ all -> 0x0198 }
            r0.setRetryImageScaleType(r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x0096:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_failureImage     // Catch:{ all -> 0x0198 }
            if (r3 != r4) goto L_0x00a2
            android.graphics.drawable.Drawable r3 = getDrawable(r1, r2, r3)     // Catch:{ all -> 0x0198 }
            r0.setFailureImage((android.graphics.drawable.Drawable) r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x00a2:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_failureImageScaleType     // Catch:{ all -> 0x0198 }
            if (r3 != r4) goto L_0x00ae
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r3 = getScaleTypeFromXml(r2, r3)     // Catch:{ all -> 0x0198 }
            r0.setFailureImageScaleType(r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x00ae:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_progressBarImageScaleType     // Catch:{ all -> 0x0198 }
            if (r3 != r4) goto L_0x00ba
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r3 = getScaleTypeFromXml(r2, r3)     // Catch:{ all -> 0x0198 }
            r0.setProgressBarImageScaleType(r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x00ba:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_progressBarAutoRotateInterval     // Catch:{ all -> 0x0198 }
            if (r3 != r4) goto L_0x00c5
            int r6 = r2.getInteger(r3, r6)     // Catch:{ all -> 0x0198 }
        L_0x00c2:
            r4 = 0
            goto L_0x0192
        L_0x00c5:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_backgroundImage     // Catch:{ all -> 0x0198 }
            if (r3 != r4) goto L_0x00d1
            android.graphics.drawable.Drawable r3 = getDrawable(r1, r2, r3)     // Catch:{ all -> 0x0198 }
            r0.setBackground(r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x00d1:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_overlayImage     // Catch:{ all -> 0x0198 }
            if (r3 != r4) goto L_0x00dd
            android.graphics.drawable.Drawable r3 = getDrawable(r1, r2, r3)     // Catch:{ all -> 0x0198 }
            r0.setOverlay(r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x00dd:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundAsCircle     // Catch:{ all -> 0x0198 }
            if (r3 != r4) goto L_0x00ee
            com.facebook.drawee.generic.RoundingParams r4 = getRoundingParams(r18)     // Catch:{ all -> 0x0198 }
            r1 = 0
            boolean r3 = r2.getBoolean(r3, r1)     // Catch:{ all -> 0x0198 }
            r4.setRoundAsCircle(r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x00ee:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundedCornerRadius     // Catch:{ all -> 0x0198 }
            if (r3 != r1) goto L_0x00f9
            r4 = r16
            int r16 = r2.getDimensionPixelSize(r3, r4)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x00f9:
            r4 = r16
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundTopLeft     // Catch:{ all -> 0x0198 }
            if (r3 != r1) goto L_0x0106
            boolean r9 = r2.getBoolean(r3, r9)     // Catch:{ all -> 0x0198 }
        L_0x0103:
            r16 = r4
            goto L_0x00c2
        L_0x0106:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundTopRight     // Catch:{ all -> 0x0198 }
            if (r3 != r1) goto L_0x010f
            boolean r11 = r2.getBoolean(r3, r11)     // Catch:{ all -> 0x0198 }
            goto L_0x0103
        L_0x010f:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundBottomLeft     // Catch:{ all -> 0x0198 }
            if (r3 != r1) goto L_0x0118
            boolean r15 = r2.getBoolean(r3, r15)     // Catch:{ all -> 0x0198 }
            goto L_0x0103
        L_0x0118:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundBottomRight     // Catch:{ all -> 0x0198 }
            if (r3 != r1) goto L_0x0121
            boolean r13 = r2.getBoolean(r3, r13)     // Catch:{ all -> 0x0198 }
            goto L_0x0103
        L_0x0121:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundTopStart     // Catch:{ all -> 0x0198 }
            if (r3 != r1) goto L_0x012a
            boolean r10 = r2.getBoolean(r3, r10)     // Catch:{ all -> 0x0198 }
            goto L_0x0103
        L_0x012a:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundTopEnd     // Catch:{ all -> 0x0198 }
            if (r3 != r1) goto L_0x0133
            boolean r12 = r2.getBoolean(r3, r12)     // Catch:{ all -> 0x0198 }
            goto L_0x0103
        L_0x0133:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundBottomStart     // Catch:{ all -> 0x0198 }
            if (r3 != r1) goto L_0x013d
            boolean r1 = r2.getBoolean(r3, r5)     // Catch:{ all -> 0x0198 }
            r5 = r1
            goto L_0x0103
        L_0x013d:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundBottomEnd     // Catch:{ all -> 0x0198 }
            if (r3 != r1) goto L_0x0146
            boolean r14 = r2.getBoolean(r3, r14)     // Catch:{ all -> 0x0198 }
            goto L_0x0103
        L_0x0146:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundWithOverlayColor     // Catch:{ all -> 0x0198 }
            if (r3 != r1) goto L_0x015a
            com.facebook.drawee.generic.RoundingParams r1 = getRoundingParams(r18)     // Catch:{ all -> 0x0198 }
            r16 = r4
            r4 = 0
            int r3 = r2.getColor(r3, r4)     // Catch:{ all -> 0x0198 }
            r1.setOverlayColor(r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x015a:
            r16 = r4
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundingBorderWidth     // Catch:{ all -> 0x0198 }
            if (r3 != r1) goto L_0x016f
            com.facebook.drawee.generic.RoundingParams r1 = getRoundingParams(r18)     // Catch:{ all -> 0x0198 }
            r4 = 0
            int r3 = r2.getDimensionPixelSize(r3, r4)     // Catch:{ all -> 0x0198 }
            float r3 = (float) r3     // Catch:{ all -> 0x0198 }
            r1.setBorderWidth(r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x016f:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundingBorderColor     // Catch:{ all -> 0x0198 }
            if (r3 != r1) goto L_0x0181
            com.facebook.drawee.generic.RoundingParams r1 = getRoundingParams(r18)     // Catch:{ all -> 0x0198 }
            r4 = 0
            int r3 = r2.getColor(r3, r4)     // Catch:{ all -> 0x0198 }
            r1.setBorderColor(r3)     // Catch:{ all -> 0x0198 }
            goto L_0x00c2
        L_0x0181:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundingBorderPadding     // Catch:{ all -> 0x0198 }
            if (r3 != r1) goto L_0x00c2
            com.facebook.drawee.generic.RoundingParams r1 = getRoundingParams(r18)     // Catch:{ all -> 0x0198 }
            r4 = 0
            int r3 = r2.getDimensionPixelSize(r3, r4)     // Catch:{ all -> 0x0198 }
            float r3 = (float) r3     // Catch:{ all -> 0x0198 }
            r1.setPadding(r3)     // Catch:{ all -> 0x0198 }
        L_0x0192:
            int r8 = r8 + 1
            r1 = r19
            goto L_0x001e
        L_0x0198:
            r0 = move-exception
            goto L_0x01fa
        L_0x019b:
            r4 = 0
            r2.recycle()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 17
            if (r1 < r2) goto L_0x01ce
            android.content.res.Resources r1 = r19.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.getLayoutDirection()
            r2 = 1
            if (r1 != r2) goto L_0x01ce
            if (r9 == 0) goto L_0x01ba
            if (r12 == 0) goto L_0x01ba
            r1 = 1
            goto L_0x01bb
        L_0x01ba:
            r1 = r4
        L_0x01bb:
            if (r11 == 0) goto L_0x01c1
            if (r10 == 0) goto L_0x01c1
            r2 = 1
            goto L_0x01c2
        L_0x01c1:
            r2 = r4
        L_0x01c2:
            if (r13 == 0) goto L_0x01c8
            if (r5 == 0) goto L_0x01c8
            r3 = 1
            goto L_0x01c9
        L_0x01c8:
            r3 = r4
        L_0x01c9:
            if (r15 == 0) goto L_0x01e8
            if (r14 == 0) goto L_0x01e8
            goto L_0x01e7
        L_0x01ce:
            if (r9 == 0) goto L_0x01d4
            if (r10 == 0) goto L_0x01d4
            r1 = 1
            goto L_0x01d5
        L_0x01d4:
            r1 = r4
        L_0x01d5:
            if (r11 == 0) goto L_0x01db
            if (r12 == 0) goto L_0x01db
            r2 = 1
            goto L_0x01dc
        L_0x01db:
            r2 = r4
        L_0x01dc:
            if (r13 == 0) goto L_0x01e2
            if (r14 == 0) goto L_0x01e2
            r3 = 1
            goto L_0x01e3
        L_0x01e2:
            r3 = r4
        L_0x01e3:
            if (r15 == 0) goto L_0x01e8
            if (r5 == 0) goto L_0x01e8
        L_0x01e7:
            r4 = 1
        L_0x01e8:
            r5 = r1
            r1 = r16
            r17 = r6
            r6 = r4
            r4 = r17
            goto L_0x0217
        L_0x01f1:
            r0 = move-exception
            r5 = 1
            r9 = 1
            r10 = 1
            r11 = 1
            r12 = 1
            r13 = 1
            r14 = 1
            r15 = 1
        L_0x01fa:
            r2.recycle()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 17
            if (r1 < r2) goto L_0x0210
            android.content.res.Resources r1 = r19.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.getLayoutDirection()
            r2 = 1
        L_0x0210:
            throw r0
        L_0x0211:
            r2 = 1
            r4 = 0
            r3 = r2
            r5 = r3
            r6 = r5
            r1 = r4
        L_0x0217:
            android.graphics.drawable.Drawable r7 = r18.getProgressBarImage()
            if (r7 == 0) goto L_0x022b
            if (r4 <= 0) goto L_0x022b
            com.facebook.drawee.drawable.AutoRotateDrawable r7 = new com.facebook.drawee.drawable.AutoRotateDrawable
            android.graphics.drawable.Drawable r8 = r18.getProgressBarImage()
            r7.<init>(r8, r4)
            r0.setProgressBarImage((android.graphics.drawable.Drawable) r7)
        L_0x022b:
            if (r1 <= 0) goto L_0x0248
            com.facebook.drawee.generic.RoundingParams r4 = getRoundingParams(r18)
            if (r5 == 0) goto L_0x0235
            float r5 = (float) r1
            goto L_0x0236
        L_0x0235:
            r5 = 0
        L_0x0236:
            if (r2 == 0) goto L_0x023a
            float r2 = (float) r1
            goto L_0x023b
        L_0x023a:
            r2 = 0
        L_0x023b:
            if (r3 == 0) goto L_0x023f
            float r3 = (float) r1
            goto L_0x0240
        L_0x023f:
            r3 = 0
        L_0x0240:
            if (r6 == 0) goto L_0x0244
            float r1 = (float) r1
            goto L_0x0245
        L_0x0244:
            r1 = 0
        L_0x0245:
            r4.setCornersRadii(r5, r2, r3, r1)
        L_0x0248:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.generic.GenericDraweeHierarchyInflater.updateBuilder(com.facebook.drawee.generic.GenericDraweeHierarchyBuilder, android.content.Context, android.util.AttributeSet):com.facebook.drawee.generic.GenericDraweeHierarchyBuilder");
    }

    private static RoundingParams getRoundingParams(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        if (genericDraweeHierarchyBuilder.getRoundingParams() == null) {
            genericDraweeHierarchyBuilder.setRoundingParams(new RoundingParams());
        }
        return genericDraweeHierarchyBuilder.getRoundingParams();
    }

    @Nullable
    private static Drawable getDrawable(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getResources().getDrawable(resourceId);
    }

    @Nullable
    private static ScalingUtils.ScaleType getScaleTypeFromXml(TypedArray typedArray, int i) {
        switch (typedArray.getInt(i, -2)) {
            case -1:
                return null;
            case 0:
                return ScalingUtils.ScaleType.FIT_XY;
            case 1:
                return ScalingUtils.ScaleType.FIT_START;
            case 2:
                return ScalingUtils.ScaleType.FIT_CENTER;
            case 3:
                return ScalingUtils.ScaleType.FIT_END;
            case 4:
                return ScalingUtils.ScaleType.CENTER;
            case 5:
                return ScalingUtils.ScaleType.CENTER_INSIDE;
            case 6:
                return ScalingUtils.ScaleType.CENTER_CROP;
            case 7:
                return ScalingUtils.ScaleType.FOCUS_CROP;
            case 8:
                return ScalingUtils.ScaleType.FIT_BOTTOM_START;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }
}

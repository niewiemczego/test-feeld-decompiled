package com.facebook.react.views.text;

import android.content.Context;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.LruCache;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaMeasureMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TextLayoutManagerMapBuffer {
    public static final short AS_KEY_CACHE_ID = 3;
    public static final short AS_KEY_FRAGMENTS = 2;
    public static final short AS_KEY_HASH = 0;
    public static final short AS_KEY_STRING = 1;
    private static final boolean DEFAULT_INCLUDE_FONT_PADDING = true;
    private static final boolean ENABLE_MEASURE_LOGGING = false;
    public static final short FR_KEY_HEIGHT = 4;
    public static final short FR_KEY_IS_ATTACHMENT = 2;
    public static final short FR_KEY_REACT_TAG = 1;
    public static final short FR_KEY_STRING = 0;
    public static final short FR_KEY_TEXT_ATTRIBUTES = 5;
    public static final short FR_KEY_WIDTH = 3;
    private static final String INLINE_VIEW_PLACEHOLDER = "0";
    public static final short PA_KEY_ADJUST_FONT_SIZE_TO_FIT = 3;
    public static final short PA_KEY_ELLIPSIZE_MODE = 1;
    public static final short PA_KEY_HYPHENATION_FREQUENCY = 5;
    public static final short PA_KEY_INCLUDE_FONT_PADDING = 4;
    public static final short PA_KEY_MAX_NUMBER_OF_LINES = 0;
    public static final short PA_KEY_TEXT_BREAK_STRATEGY = 2;
    private static final String TAG = "TextLayoutManagerMapBuffer";
    private static final LruCache<MapBuffer, Spannable> sSpannableCache = new LruCache<>(100);
    private static final Object sSpannableCacheLock = new Object();
    private static final ConcurrentHashMap<Integer, Spannable> sTagToSpannableCache = new ConcurrentHashMap<>();
    private static final TextPaint sTextPaintInstance = new TextPaint(1);
    private static final short spannableCacheSize = 100;

    public static void setCachedSpannabledForTag(int i, Spannable spannable) {
        sTagToSpannableCache.put(Integer.valueOf(i), spannable);
    }

    public static void deleteCachedSpannableForTag(int i) {
        sTagToSpannableCache.remove(Integer.valueOf(i));
    }

    public static boolean isRTL(MapBuffer mapBuffer) {
        MapBuffer mapBuffer2 = mapBuffer.getMapBuffer(2);
        if (mapBuffer2.getCount() == 0) {
            return false;
        }
        MapBuffer mapBuffer3 = mapBuffer2.getMapBuffer(0).getMapBuffer(5);
        if (mapBuffer3.contains(21) && TextAttributeProps.getLayoutDirection(mapBuffer3.getString(21)) == 1) {
            return true;
        }
        return false;
    }

    private static void buildSpannableFromFragment(Context context, MapBuffer mapBuffer, SpannableStringBuilder spannableStringBuilder, List<SetSpanOperation> list) {
        List<SetSpanOperation> list2 = list;
        int count = mapBuffer.getCount();
        for (int i = 0; i < count; i++) {
            MapBuffer mapBuffer2 = mapBuffer.getMapBuffer(i);
            int length = spannableStringBuilder.length();
            TextAttributeProps fromMapBuffer = TextAttributeProps.fromMapBuffer(mapBuffer2.getMapBuffer(5));
            spannableStringBuilder.append(TextTransform.apply(mapBuffer2.getString(0), fromMapBuffer.mTextTransform));
            int length2 = spannableStringBuilder.length();
            int i2 = mapBuffer2.contains(1) ? mapBuffer2.getInt(1) : -1;
            if (mapBuffer2.contains(2) && mapBuffer2.getBoolean(2)) {
                list2.add(new SetSpanOperation(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new TextInlineViewPlaceholderSpan(i2, (int) PixelUtil.toPixelFromSP(mapBuffer2.getDouble(3)), (int) PixelUtil.toPixelFromSP(mapBuffer2.getDouble(4)))));
            } else if (length2 >= length) {
                if (fromMapBuffer.mIsAccessibilityLink) {
                    list2.add(new SetSpanOperation(length, length2, new ReactClickableSpan(i2)));
                }
                if (fromMapBuffer.mIsColorSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactForegroundColorSpan(fromMapBuffer.mColor)));
                }
                if (fromMapBuffer.mIsBackgroundColorSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactBackgroundColorSpan(fromMapBuffer.mBackgroundColor)));
                }
                if (!Float.isNaN(fromMapBuffer.getLetterSpacing())) {
                    list2.add(new SetSpanOperation(length, length2, new CustomLetterSpacingSpan(fromMapBuffer.getLetterSpacing())));
                }
                list2.add(new SetSpanOperation(length, length2, new ReactAbsoluteSizeSpan(fromMapBuffer.mFontSize)));
                if (!(fromMapBuffer.mFontStyle == -1 && fromMapBuffer.mFontWeight == -1 && fromMapBuffer.mFontFamily == null)) {
                    list2.add(new SetSpanOperation(length, length2, new CustomStyleSpan(fromMapBuffer.mFontStyle, fromMapBuffer.mFontWeight, fromMapBuffer.mFontFeatureSettings, fromMapBuffer.mFontFamily, context.getAssets())));
                }
                if (fromMapBuffer.mIsUnderlineTextDecorationSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactUnderlineSpan()));
                }
                if (fromMapBuffer.mIsLineThroughTextDecorationSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactStrikethroughSpan()));
                }
                if (!(fromMapBuffer.mTextShadowOffsetDx == 0.0f && fromMapBuffer.mTextShadowOffsetDy == 0.0f)) {
                    list2.add(new SetSpanOperation(length, length2, new ShadowStyleSpan(fromMapBuffer.mTextShadowOffsetDx, fromMapBuffer.mTextShadowOffsetDy, fromMapBuffer.mTextShadowRadius, fromMapBuffer.mTextShadowColor)));
                }
                if (!Float.isNaN(fromMapBuffer.getEffectiveLineHeight())) {
                    list2.add(new SetSpanOperation(length, length2, new CustomLineHeightSpan(fromMapBuffer.getEffectiveLineHeight())));
                }
                list2.add(new SetSpanOperation(length, length2, new ReactTagSpan(i2)));
            }
        }
    }

    public static Spannable getOrCreateSpannableForText(Context context, MapBuffer mapBuffer, ReactTextViewManagerCallback reactTextViewManagerCallback) {
        return createSpannableFromAttributedString(context, mapBuffer, reactTextViewManagerCallback);
    }

    private static Spannable createSpannableFromAttributedString(Context context, MapBuffer mapBuffer, ReactTextViewManagerCallback reactTextViewManagerCallback) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList<SetSpanOperation> arrayList = new ArrayList<>();
        buildSpannableFromFragment(context, mapBuffer.getMapBuffer(2), spannableStringBuilder, arrayList);
        int i = 0;
        for (SetSpanOperation execute : arrayList) {
            execute.execute(spannableStringBuilder, i);
            i++;
        }
        if (reactTextViewManagerCallback != null) {
            reactTextViewManagerCallback.onPostProcessSpannable(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    private static Layout createLayout(Spannable spannable, BoringLayout.Metrics metrics, float f, YogaMeasureMode yogaMeasureMode, boolean z, int i, int i2) {
        int i3;
        Spannable spannable2 = spannable;
        BoringLayout.Metrics metrics2 = metrics;
        float f2 = f;
        boolean z2 = z;
        int i4 = i;
        int i5 = i2;
        int length = spannable.length();
        boolean z3 = yogaMeasureMode == YogaMeasureMode.UNDEFINED || f2 < 0.0f;
        TextPaint textPaint = sTextPaintInstance;
        float desiredWidth = metrics2 == null ? Layout.getDesiredWidth(spannable2, textPaint) : Float.NaN;
        if (metrics2 == null && (z3 || (!YogaConstants.isUndefined(desiredWidth) && desiredWidth <= f2))) {
            int ceil = (int) Math.ceil((double) desiredWidth);
            if (Build.VERSION.SDK_INT >= 23) {
                return StaticLayout.Builder.obtain(spannable2, 0, length, textPaint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(z2).setBreakStrategy(i4).setHyphenationFrequency(i5).build();
            }
            return new StaticLayout(spannable, textPaint, ceil, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, z);
        } else if (metrics2 != null && (z3 || ((float) metrics2.width) <= f2)) {
            int i6 = metrics2.width;
            if (metrics2.width < 0) {
                ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Text width is invalid: " + metrics2.width));
                i3 = 0;
            } else {
                i3 = i6;
            }
            return BoringLayout.make(spannable, textPaint, i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, metrics, z);
        } else if (Build.VERSION.SDK_INT < 23) {
            return new StaticLayout(spannable, textPaint, (int) f2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, z);
        } else {
            StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannable2, 0, length, textPaint, (int) f2).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(z2).setBreakStrategy(i4).setHyphenationFrequency(i5);
            if (Build.VERSION.SDK_INT >= 28) {
                hyphenationFrequency.setUseLineSpacingFromFallbacks(true);
            }
            return hyphenationFrequency.build();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ad, code lost:
        if (r12 > r21) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c1, code lost:
        if (r1 > r23) goto L_0x00c3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long measureText(android.content.Context r18, com.facebook.react.common.mapbuffer.MapBuffer r19, com.facebook.react.common.mapbuffer.MapBuffer r20, float r21, com.facebook.yoga.YogaMeasureMode r22, float r23, com.facebook.yoga.YogaMeasureMode r24, com.facebook.react.views.text.ReactTextViewManagerCallback r25, float[] r26) {
        /*
            r0 = r19
            r1 = r20
            r9 = r22
            r10 = r24
            android.text.TextPaint r2 = sTextPaintInstance
            r3 = 3
            boolean r4 = r0.contains(r3)
            if (r4 == 0) goto L_0x002f
            int r0 = r0.getInt(r3)
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, android.text.Spannable> r3 = sTagToSpannableCache
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            boolean r4 = r3.containsKey(r4)
            if (r4 == 0) goto L_0x002c
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r0 = r3.get(r0)
            android.text.Spannable r0 = (android.text.Spannable) r0
            goto L_0x0037
        L_0x002c:
            r0 = 0
            return r0
        L_0x002f:
            r3 = r18
            r4 = r25
            android.text.Spannable r0 = getOrCreateSpannableForText(r3, r0, r4)
        L_0x0037:
            r3 = 2
            java.lang.String r3 = r1.getString(r3)
            int r7 = com.facebook.react.views.text.TextAttributeProps.getTextBreakStrategy(r3)
            r3 = 4
            boolean r4 = r1.contains(r3)
            r11 = 1
            if (r4 == 0) goto L_0x004e
            boolean r3 = r1.getBoolean(r3)
            r6 = r3
            goto L_0x004f
        L_0x004e:
            r6 = r11
        L_0x004f:
            r3 = 5
            java.lang.String r3 = r1.getString(r3)
            int r8 = com.facebook.react.views.text.TextAttributeProps.getTextBreakStrategy(r3)
            if (r0 == 0) goto L_0x018e
            android.text.BoringLayout$Metrics r3 = android.text.BoringLayout.isBoring(r0, r2)
            if (r3 != 0) goto L_0x0063
            android.text.Layout.getDesiredWidth(r0, r2)
        L_0x0063:
            com.facebook.yoga.YogaMeasureMode r2 = com.facebook.yoga.YogaMeasureMode.UNDEFINED
            r12 = 0
            if (r9 == r2) goto L_0x006a
            int r2 = (r21 > r12 ? 1 : (r21 == r12 ? 0 : -1))
        L_0x006a:
            r2 = r0
            r4 = r21
            r5 = r22
            android.text.Layout r2 = createLayout(r2, r3, r4, r5, r6, r7, r8)
            r3 = 0
            boolean r4 = r1.contains(r3)
            r5 = -1
            if (r4 == 0) goto L_0x0080
            int r1 = r1.getInt(r3)
            goto L_0x0081
        L_0x0080:
            r1 = r5
        L_0x0081:
            if (r1 == r5) goto L_0x008f
            if (r1 != 0) goto L_0x0086
            goto L_0x008f
        L_0x0086:
            int r4 = r2.getLineCount()
            int r1 = java.lang.Math.min(r1, r4)
            goto L_0x0093
        L_0x008f:
            int r1 = r2.getLineCount()
        L_0x0093:
            com.facebook.yoga.YogaMeasureMode r4 = com.facebook.yoga.YogaMeasureMode.EXACTLY
            if (r9 != r4) goto L_0x0098
            goto L_0x00af
        L_0x0098:
            r4 = r3
        L_0x0099:
            if (r4 >= r1) goto L_0x00a7
            float r6 = r2.getLineWidth(r4)
            int r7 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r7 <= 0) goto L_0x00a4
            r12 = r6
        L_0x00a4:
            int r4 = r4 + 1
            goto L_0x0099
        L_0x00a7:
            com.facebook.yoga.YogaMeasureMode r4 = com.facebook.yoga.YogaMeasureMode.AT_MOST
            if (r9 != r4) goto L_0x00b1
            int r4 = (r12 > r21 ? 1 : (r12 == r21 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b1
        L_0x00af:
            r12 = r21
        L_0x00b1:
            com.facebook.yoga.YogaMeasureMode r4 = com.facebook.yoga.YogaMeasureMode.EXACTLY
            if (r10 == r4) goto L_0x00c3
            int r1 = r1 - r11
            int r1 = r2.getLineBottom(r1)
            float r1 = (float) r1
            com.facebook.yoga.YogaMeasureMode r4 = com.facebook.yoga.YogaMeasureMode.AT_MOST
            if (r10 != r4) goto L_0x00c5
            int r4 = (r1 > r23 ? 1 : (r1 == r23 ? 0 : -1))
            if (r4 <= 0) goto L_0x00c5
        L_0x00c3:
            r1 = r23
        L_0x00c5:
            r4 = r3
            r6 = r4
        L_0x00c7:
            int r7 = r0.length()
            if (r4 >= r7) goto L_0x0181
            int r7 = r0.length()
            java.lang.Class<com.facebook.react.views.text.TextInlineViewPlaceholderSpan> r8 = com.facebook.react.views.text.TextInlineViewPlaceholderSpan.class
            int r7 = r0.nextSpanTransition(r4, r7, r8)
            java.lang.Class<com.facebook.react.views.text.TextInlineViewPlaceholderSpan> r8 = com.facebook.react.views.text.TextInlineViewPlaceholderSpan.class
            java.lang.Object[] r4 = r0.getSpans(r4, r7, r8)
            com.facebook.react.views.text.TextInlineViewPlaceholderSpan[] r4 = (com.facebook.react.views.text.TextInlineViewPlaceholderSpan[]) r4
            int r8 = r4.length
            r9 = r3
        L_0x00e1:
            if (r9 >= r8) goto L_0x017e
            r10 = r4[r9]
            int r13 = r0.getSpanStart(r10)
            int r14 = r2.getLineForOffset(r13)
            int r15 = r2.getEllipsisCount(r14)
            if (r15 <= 0) goto L_0x00f5
            r15 = r11
            goto L_0x00f6
        L_0x00f5:
            r15 = r3
        L_0x00f6:
            if (r15 == 0) goto L_0x010e
            int r15 = r2.getLineStart(r14)
            int r16 = r2.getEllipsisStart(r14)
            int r15 = r15 + r16
            if (r13 < r15) goto L_0x010e
            int r15 = r2.getLineEnd(r14)
            if (r13 < r15) goto L_0x010b
            goto L_0x010e
        L_0x010b:
            r5 = r11
            goto L_0x0177
        L_0x010e:
            int r15 = r10.getWidth()
            float r15 = (float) r15
            int r10 = r10.getHeight()
            float r10 = (float) r10
            boolean r3 = r2.isRtlCharAt(r13)
            int r11 = r2.getParagraphDirection(r14)
            if (r11 != r5) goto L_0x0124
            r11 = 1
            goto L_0x0125
        L_0x0124:
            r11 = 0
        L_0x0125:
            int r16 = r0.length()
            r17 = 1
            int r5 = r16 + -1
            if (r13 != r5) goto L_0x013e
            if (r11 == 0) goto L_0x0138
            float r3 = r2.getLineWidth(r14)
            float r3 = r12 - r3
            goto L_0x015f
        L_0x0138:
            float r3 = r2.getLineRight(r14)
            float r3 = r3 - r15
            goto L_0x015f
        L_0x013e:
            if (r11 != r3) goto L_0x0143
            r17 = 1
            goto L_0x0145
        L_0x0143:
            r17 = 0
        L_0x0145:
            if (r17 == 0) goto L_0x014c
            float r5 = r2.getPrimaryHorizontal(r13)
            goto L_0x0150
        L_0x014c:
            float r5 = r2.getSecondaryHorizontal(r13)
        L_0x0150:
            if (r11 == 0) goto L_0x0159
            float r11 = r2.getLineRight(r14)
            float r11 = r11 - r5
            float r5 = r12 - r11
        L_0x0159:
            if (r3 == 0) goto L_0x015e
            float r3 = r5 - r15
            goto L_0x015f
        L_0x015e:
            r3 = r5
        L_0x015f:
            int r5 = r2.getLineBaseline(r14)
            float r5 = (float) r5
            float r5 = r5 - r10
            int r10 = r6 * 2
            float r5 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r5)
            r26[r10] = r5
            r5 = 1
            int r10 = r10 + r5
            float r3 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r3)
            r26[r10] = r3
            int r6 = r6 + 1
        L_0x0177:
            int r9 = r9 + 1
            r11 = r5
            r3 = 0
            r5 = -1
            goto L_0x00e1
        L_0x017e:
            r4 = r7
            goto L_0x00c7
        L_0x0181:
            float r0 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r12)
            float r1 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r1)
            long r0 = com.facebook.yoga.YogaMeasureOutput.make((float) r0, (float) r1)
            return r0
        L_0x018e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Spannable element has not been prepared in onBeforeLayout"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.TextLayoutManagerMapBuffer.measureText(android.content.Context, com.facebook.react.common.mapbuffer.MapBuffer, com.facebook.react.common.mapbuffer.MapBuffer, float, com.facebook.yoga.YogaMeasureMode, float, com.facebook.yoga.YogaMeasureMode, com.facebook.react.views.text.ReactTextViewManagerCallback, float[]):long");
    }

    public static WritableArray measureLines(Context context, MapBuffer mapBuffer, MapBuffer mapBuffer2, float f) {
        TextPaint textPaint = sTextPaintInstance;
        Spannable orCreateSpannableForText = getOrCreateSpannableForText(context, mapBuffer, (ReactTextViewManagerCallback) null);
        BoringLayout.Metrics isBoring = BoringLayout.isBoring(orCreateSpannableForText, textPaint);
        int textBreakStrategy = TextAttributeProps.getTextBreakStrategy(mapBuffer2.getString(2));
        return FontMetricsUtil.getFontMetrics(orCreateSpannableForText, createLayout(orCreateSpannableForText, isBoring, f, YogaMeasureMode.EXACTLY, mapBuffer2.contains(4) ? mapBuffer2.getBoolean(4) : true, textBreakStrategy, TextAttributeProps.getTextBreakStrategy(mapBuffer2.getString(5))), textPaint, context);
    }

    public static class SetSpanOperation {
        protected int end;
        protected int start;
        protected ReactSpan what;

        public SetSpanOperation(int i, int i2, ReactSpan reactSpan) {
            this.start = i;
            this.end = i2;
            this.what = reactSpan;
        }

        public void execute(Spannable spannable, int i) {
            int i2 = this.start;
            spannable.setSpan(this.what, i2, this.end, ((i << 16) & 16711680) | ((i2 == 0 ? 18 : 34) & -16711681));
        }
    }
}

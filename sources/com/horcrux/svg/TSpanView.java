package com.horcrux.svg;

import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import com.horcrux.svg.TextProperties;
import java.text.Bidi;
import java.util.ArrayList;
import javax.annotation.Nullable;

class TSpanView extends TextView {
    private static final String FONTS = "fonts/";
    private static final String OTF = ".otf";
    private static final String TTF = ".ttf";
    static final String additionalLigatures = "'hlig', 'cala', ";
    static final String defaultFeatures = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', ";
    static final String disableDiscretionaryLigatures = "'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, ";
    static final String fontWeightTag = "'wght' ";
    private static final double radToDeg = 57.29577951308232d;
    static final String requiredFontFeatures = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk',";
    private static final double tau = 6.283185307179586d;
    private final AssetManager assets = this.mContext.getResources().getAssets();
    private final ArrayList<String> emoji = new ArrayList<>();
    private final ArrayList<Matrix> emojiTransforms = new ArrayList<>();
    private Path mCachedPath;
    @Nullable
    String mContent;
    private TextPathView textPath;

    public TSpanView(ReactContext reactContext) {
        super(reactContext);
    }

    public void setContent(@Nullable String str) {
        this.mContent = str;
        invalidate();
    }

    public void invalidate() {
        this.mCachedPath = null;
        super.invalidate();
    }

    /* access modifiers changed from: package-private */
    public void clearCache() {
        this.mCachedPath = null;
        super.clearCache();
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f) {
        if (this.mContent == null) {
            clip(canvas, paint);
            drawGroup(canvas, paint, f);
        } else if (this.mInlineSize == null || this.mInlineSize.value == 0.0d) {
            int size = this.emoji.size();
            if (size > 0) {
                applyTextPropertiesToPaint(paint, getTextRootGlyphContext().getFont());
                for (int i = 0; i < size; i++) {
                    canvas.save();
                    canvas.concat(this.emojiTransforms.get(i));
                    canvas.drawText(this.emoji.get(i), 0.0f, 0.0f, paint);
                    canvas.restore();
                }
            }
            drawPath(canvas, paint, f);
        } else {
            if (setupFillPaint(paint, this.fillOpacity * f)) {
                drawWrappedText(canvas, paint);
            }
            if (setupStrokePaint(paint, f * this.strokeOpacity)) {
                drawWrappedText(canvas, paint);
            }
        }
    }

    private void drawWrappedText(Canvas canvas, Paint paint) {
        Layout.Alignment alignment;
        Canvas canvas2 = canvas;
        GlyphContext textRootGlyphContext = getTextRootGlyphContext();
        pushGlyphContext();
        FontData font = textRootGlyphContext.getFont();
        TextPaint textPaint = new TextPaint(paint);
        applyTextPropertiesToPaint(textPaint, font);
        applySpacingAndFeatures(textPaint, font);
        double fontSize = textRootGlyphContext.getFontSize();
        int i = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[font.textAnchor.ordinal()];
        if (i == 2) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        } else if (i != 3) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        Layout.Alignment alignment2 = alignment;
        StaticLayout staticLayout = getStaticLayout(textPaint, alignment2, true, new SpannableString(this.mContent), (int) PropHelper.fromRelative(this.mInlineSize, (double) canvas.getWidth(), 0.0d, (double) this.mScale, fontSize));
        int lineAscent = staticLayout.getLineAscent(0);
        popGlyphContext();
        canvas.save();
        canvas2.translate((float) textRootGlyphContext.nextX(0.0d), (float) (textRootGlyphContext.nextY() + ((double) lineAscent)));
        staticLayout.draw(canvas2);
        canvas.restore();
    }

    private StaticLayout getStaticLayout(TextPaint textPaint, Layout.Alignment alignment, boolean z, SpannableString spannableString, int i) {
        if (Build.VERSION.SDK_INT < 23) {
            return new StaticLayout(spannableString, textPaint, i, alignment, 1.0f, 0.0f, z);
        }
        return StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), textPaint, i).setAlignment(alignment).setLineSpacing(0.0f, 1.0f).setIncludePad(z).setBreakStrategy(1).setHyphenationFrequency(1).build();
    }

    public static String visualToLogical(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Bidi bidi = new Bidi(str, -2);
        if (bidi.isLeftToRight()) {
            return str;
        }
        int runCount = bidi.getRunCount();
        byte[] bArr = new byte[runCount];
        Integer[] numArr = new Integer[runCount];
        for (int i = 0; i < runCount; i++) {
            bArr[i] = (byte) bidi.getRunLevel(i);
            numArr[i] = Integer.valueOf(i);
        }
        Bidi.reorderVisually(bArr, 0, numArr, 0, runCount);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < runCount; i2++) {
            int intValue = numArr[i2].intValue();
            int runStart = bidi.getRunStart(intValue);
            int runLimit = bidi.getRunLimit(intValue);
            if ((bArr[intValue] & 1) != 0) {
                while (true) {
                    runLimit--;
                    if (runLimit < runStart) {
                        break;
                    }
                    sb.append(str.charAt(runLimit));
                }
            } else {
                sb.append(str, runStart, runLimit);
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = this.mCachedPath;
        if (path != null) {
            return path;
        }
        if (this.mContent == null) {
            Path groupPath = getGroupPath(canvas, paint);
            this.mCachedPath = groupPath;
            return groupPath;
        }
        setupTextPath();
        pushGlyphContext();
        this.mCachedPath = getLinePath(visualToLogical(this.mContent), paint, canvas);
        popGlyphContext();
        return this.mCachedPath;
    }

    /* access modifiers changed from: package-private */
    public double getSubtreeTextChunksTotalAdvance(Paint paint) {
        if (!Double.isNaN(this.cachedAdvance)) {
            return this.cachedAdvance;
        }
        String str = this.mContent;
        double d = 0.0d;
        if (str == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof TextView) {
                    d += ((TextView) childAt).getSubtreeTextChunksTotalAdvance(paint);
                }
            }
            this.cachedAdvance = d;
            return d;
        } else if (str.length() == 0) {
            this.cachedAdvance = 0.0d;
            return 0.0d;
        } else {
            FontData font = getTextRootGlyphContext().getFont();
            applyTextPropertiesToPaint(paint, font);
            applySpacingAndFeatures(paint, font);
            this.cachedAdvance = (double) paint.measureText(str);
            return this.cachedAdvance;
        }
    }

    private void applySpacingAndFeatures(Paint paint, FontData fontData) {
        if (Build.VERSION.SDK_INT >= 21) {
            double d = fontData.letterSpacing;
            paint.setLetterSpacing((float) (d / (fontData.fontSize * ((double) this.mScale))));
            if (d == 0.0d && fontData.fontVariantLigatures == TextProperties.FontVariantLigatures.normal) {
                paint.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'hlig', 'cala', " + fontData.fontFeatureSettings);
            } else {
                paint.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, " + fontData.fontFeatureSettings);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                paint.setFontVariationSettings(fontWeightTag + fontData.absoluteFontWeight + fontData.fontVariationSettings);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01f2, code lost:
        r10 = r4 * r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01f8, code lost:
        r4 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Path getLinePath(java.lang.String r70, android.graphics.Paint r71, android.graphics.Canvas r72) {
        /*
            r69 = this;
            r6 = r69
            r14 = r71
            r15 = r72
            int r13 = r70.length()
            android.graphics.Path r12 = new android.graphics.Path
            r12.<init>()
            java.util.ArrayList<java.lang.String> r0 = r6.emoji
            r0.clear()
            java.util.ArrayList<android.graphics.Matrix> r0 = r6.emojiTransforms
            r0.clear()
            if (r13 != 0) goto L_0x001c
            return r12
        L_0x001c:
            r0 = 0
            com.horcrux.svg.TextPathView r1 = r6.textPath
            r11 = 0
            if (r1 == 0) goto L_0x0025
            r16 = 1
            goto L_0x0027
        L_0x0025:
            r16 = r11
        L_0x0027:
            r17 = 0
            if (r16 == 0) goto L_0x0049
            android.graphics.PathMeasure r0 = new android.graphics.PathMeasure
            com.horcrux.svg.TextPathView r1 = r6.textPath
            android.graphics.Path r1 = r1.getTextPath(r15, r14)
            r0.<init>(r1, r11)
            float r1 = r0.getLength()
            double r1 = (double) r1
            boolean r3 = r0.isClosed()
            int r4 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r4 != 0) goto L_0x0044
            return r12
        L_0x0044:
            r9 = r0
            r7 = r1
            r19 = r3
            goto L_0x004e
        L_0x0049:
            r9 = r0
            r19 = r11
            r7 = r17
        L_0x004e:
            com.horcrux.svg.GlyphContext r4 = r69.getTextRootGlyphContext()
            com.horcrux.svg.FontData r0 = r4.getFont()
            r6.applyTextPropertiesToPaint(r14, r0)
            com.horcrux.svg.GlyphPathBag r5 = new com.horcrux.svg.GlyphPathBag
            r5.<init>(r14)
            boolean[] r2 = new boolean[r13]
            char[] r20 = r70.toCharArray()
            r21 = r12
            double r11 = r0.kerning
            r22 = r11
            double r11 = r0.wordSpacing
            r25 = r11
            double r10 = r0.letterSpacing
            boolean r1 = r0.manualKerning
            r3 = 1
            r27 = r1 ^ 1
            int r1 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r1 != 0) goto L_0x0081
            com.horcrux.svg.TextProperties$FontVariantLigatures r1 = r0.fontVariantLigatures
            com.horcrux.svg.TextProperties$FontVariantLigatures r3 = com.horcrux.svg.TextProperties.FontVariantLigatures.normal
            if (r1 != r3) goto L_0x0081
            r1 = 1
            goto L_0x0082
        L_0x0081:
            r1 = 0
        L_0x0082:
            int r3 = android.os.Build.VERSION.SDK_INT
            r12 = 21
            if (r3 < r12) goto L_0x00df
            if (r1 == 0) goto L_0x00a3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'hlig', 'cala', "
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r3 = r0.fontFeatureSettings
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            r14.setFontFeatureSettings(r1)
            goto L_0x00bb
        L_0x00a3:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, "
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r3 = r0.fontFeatureSettings
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            r14.setFontFeatureSettings(r1)
        L_0x00bb:
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r1 < r3) goto L_0x00df
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "'wght' "
            java.lang.StringBuilder r1 = r1.append(r3)
            int r3 = r0.absoluteFontWeight
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r3 = r0.fontVariationSettings
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            r14.setFontVariationSettings(r1)
        L_0x00df:
            com.facebook.react.bridge.ReadableMap r12 = r0.fontData
            float[] r3 = new float[r13]
            r1 = r70
            r14.getTextWidths(r1, r3)
            com.horcrux.svg.TextProperties$TextAnchor r1 = r0.textAnchor
            com.horcrux.svg.TextView r0 = r69.getTextAnchorRoot()
            r28 = r9
            r29 = r10
            double r9 = r0.getSubtreeTextChunksTotalAdvance(r14)
            double r31 = r6.getTextAnchorOffset(r1, r9)
            double r42 = r4.getFontSize()
            r44 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r16 == 0) goto L_0x0154
            com.horcrux.svg.TextPathView r0 = r6.textPath
            com.horcrux.svg.TextProperties$TextPathMidLine r0 = r0.getMidLine()
            com.horcrux.svg.TextProperties$TextPathMidLine r11 = com.horcrux.svg.TextProperties.TextPathMidLine.sharp
            if (r0 != r11) goto L_0x010e
            r11 = 1
            goto L_0x010f
        L_0x010e:
            r11 = 0
        L_0x010f:
            com.horcrux.svg.TextPathView r0 = r6.textPath
            com.horcrux.svg.TextProperties$TextPathSide r0 = r0.getSide()
            r33 = r1
            com.horcrux.svg.TextProperties$TextPathSide r1 = com.horcrux.svg.TextProperties.TextPathSide.right
            if (r0 != r1) goto L_0x011e
            r34 = -1
            goto L_0x0120
        L_0x011e:
            r34 = 1
        L_0x0120:
            com.horcrux.svg.TextPathView r0 = r6.textPath
            com.horcrux.svg.SVGLength r1 = r0.getStartOffset()
            r0 = r69
            r35 = r11
            r11 = r33
            r46 = r2
            r47 = r3
            r2 = r7
            r15 = r4
            r48 = r5
            r4 = r42
            double r0 = r0.getAbsoluteStartOffset(r1, r2, r4)
            double r31 = r31 + r0
            if (r19 == 0) goto L_0x014c
            double r2 = r7 / r44
            com.horcrux.svg.TextProperties$TextAnchor r4 = com.horcrux.svg.TextProperties.TextAnchor.middle
            if (r11 != r4) goto L_0x0146
            double r2 = -r2
            goto L_0x0148
        L_0x0146:
            r2 = r17
        L_0x0148:
            double r0 = r0 + r2
            double r2 = r0 + r7
            goto L_0x014f
        L_0x014c:
            r2 = r7
            r0 = r17
        L_0x014f:
            r4 = r34
            r5 = r35
            goto L_0x0160
        L_0x0154:
            r46 = r2
            r47 = r3
            r15 = r4
            r48 = r5
            r2 = r7
            r0 = r17
            r4 = 1
            r5 = 0
        L_0x0160:
            r49 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            com.horcrux.svg.SVGLength r11 = r6.mTextLength
            r51 = r7
            if (r11 == 0) goto L_0x01a8
            com.horcrux.svg.SVGLength r8 = r6.mTextLength
            int r11 = r72.getWidth()
            r33 = r8
            double r7 = (double) r11
            r36 = 0
            float r11 = r6.mScale
            r53 = r0
            double r0 = (double) r11
            r34 = r7
            r38 = r0
            r40 = r42
            double r0 = com.horcrux.svg.PropHelper.fromRelative(r33, r34, r36, r38, r40)
            int r7 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r7 < 0) goto L_0x01a0
            int[] r7 = com.horcrux.svg.TSpanView.AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust
            com.horcrux.svg.TextProperties$TextLengthAdjust r8 = r6.mLengthAdjust
            int r8 = r8.ordinal()
            r7 = r7[r8]
            r8 = 2
            if (r7 == r8) goto L_0x019d
            double r0 = r0 - r9
            int r7 = r13 + -1
            double r7 = (double) r7
            double r0 = r0 / r7
            double r10 = r29 + r0
            r29 = r10
            goto L_0x01aa
        L_0x019d:
            double r49 = r0 / r9
            goto L_0x01aa
        L_0x01a0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Negative textLength value"
            r0.<init>(r1)
            throw r0
        L_0x01a8:
            r53 = r0
        L_0x01aa:
            double r0 = (double) r4
            double r10 = r49 * r0
            android.graphics.Paint$FontMetrics r7 = r71.getFontMetrics()
            float r8 = r7.descent
            double r8 = (double) r8
            r40 = r4
            float r4 = r7.leading
            r55 = r10
            double r10 = (double) r4
            double r10 = r10 + r8
            float r4 = r7.ascent
            float r4 = -r4
            r41 = r5
            float r5 = r7.leading
            float r4 = r4 + r5
            double r4 = (double) r4
            float r7 = r7.top
            float r7 = -r7
            r57 = r2
            double r2 = (double) r7
            double r33 = r2 + r10
            java.lang.String r7 = r69.getBaselineShift()
            com.horcrux.svg.TextProperties$AlignmentBaseline r35 = r69.getAlignmentBaseline()
            if (r35 == 0) goto L_0x0211
            int[] r36 = com.horcrux.svg.TSpanView.AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline
            int r37 = r35.ordinal()
            r36 = r36[r37]
            switch(r36) {
                case 2: goto L_0x020e;
                case 3: goto L_0x020e;
                case 4: goto L_0x020e;
                case 5: goto L_0x0211;
                case 6: goto L_0x020e;
                case 7: goto L_0x01fa;
                case 8: goto L_0x01f5;
                case 9: goto L_0x01f0;
                case 10: goto L_0x01ea;
                case 11: goto L_0x01e8;
                case 12: goto L_0x01e8;
                case 13: goto L_0x01e8;
                case 14: goto L_0x01f8;
                case 15: goto L_0x01e5;
                case 16: goto L_0x01e3;
                default: goto L_0x01e2;
            }
        L_0x01e2:
            goto L_0x0211
        L_0x01e3:
            r10 = r2
            goto L_0x01f8
        L_0x01e5:
            double r10 = r33 / r44
            goto L_0x01f8
        L_0x01e8:
            r10 = r4
            goto L_0x01f8
        L_0x01ea:
            r2 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            goto L_0x01f2
        L_0x01f0:
            r2 = 4602678819172646912(0x3fe0000000000000, double:0.5)
        L_0x01f2:
            double r10 = r4 * r2
            goto L_0x01f8
        L_0x01f5:
            double r4 = r4 - r8
            double r10 = r4 / r44
        L_0x01f8:
            r4 = 0
            goto L_0x0214
        L_0x01fa:
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            java.lang.String r3 = "x"
            r4 = 0
            r5 = 1
            r14.getTextBounds(r3, r4, r5, r2)
            int r2 = r2.height()
            double r2 = (double) r2
            double r10 = r2 / r44
            goto L_0x0214
        L_0x020e:
            r4 = 0
            double r10 = -r8
            goto L_0x0214
        L_0x0211:
            r4 = 0
            r10 = r17
        L_0x0214:
            if (r7 == 0) goto L_0x02e0
            boolean r2 = r7.isEmpty()
            if (r2 != 0) goto L_0x02e0
            int[] r2 = com.horcrux.svg.TSpanView.AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline
            int r3 = r35.ordinal()
            r2 = r2[r3]
            r3 = 14
            if (r2 == r3) goto L_0x02e0
            r3 = 16
            if (r2 == r3) goto L_0x02e0
            r7.hashCode()
            int r2 = r7.hashCode()
            switch(r2) {
                case -1720785339: goto L_0x024e;
                case 114240: goto L_0x0243;
                case 109801339: goto L_0x0238;
                default: goto L_0x0236;
            }
        L_0x0236:
            r2 = -1
            goto L_0x0258
        L_0x0238:
            java.lang.String r2 = "super"
            boolean r2 = r7.equals(r2)
            if (r2 != 0) goto L_0x0241
            goto L_0x0236
        L_0x0241:
            r2 = 2
            goto L_0x0258
        L_0x0243:
            java.lang.String r2 = "sub"
            boolean r2 = r7.equals(r2)
            if (r2 != 0) goto L_0x024c
            goto L_0x0236
        L_0x024c:
            r2 = 1
            goto L_0x0258
        L_0x024e:
            java.lang.String r2 = "baseline"
            boolean r2 = r7.equals(r2)
            if (r2 != 0) goto L_0x0257
            goto L_0x0236
        L_0x0257:
            r2 = r4
        L_0x0258:
            java.lang.String r3 = "os2"
            java.lang.String r5 = "unitsPerEm"
            java.lang.String r8 = "tables"
            switch(r2) {
                case 0: goto L_0x02e0;
                case 1: goto L_0x02ab;
                case 2: goto L_0x0275;
                default: goto L_0x0261;
            }
        L_0x0261:
            float r2 = r6.mScale
            double r2 = (double) r2
            double r34 = r2 * r42
            float r2 = r6.mScale
            double r2 = (double) r2
            r33 = r7
            r36 = r2
            r38 = r42
            double r2 = com.horcrux.svg.PropHelper.fromRelative(r33, r34, r36, r38)
            double r10 = r10 - r2
            goto L_0x02e0
        L_0x0275:
            if (r12 == 0) goto L_0x02e0
            boolean r2 = r12.hasKey(r8)
            if (r2 == 0) goto L_0x02e0
            boolean r2 = r12.hasKey(r5)
            if (r2 == 0) goto L_0x02e0
            int r2 = r12.getInt(r5)
            com.facebook.react.bridge.ReadableMap r5 = r12.getMap(r8)
            boolean r7 = r5.hasKey(r3)
            if (r7 == 0) goto L_0x02e0
            com.facebook.react.bridge.ReadableMap r3 = r5.getMap(r3)
            java.lang.String r5 = "ySuperscriptYOffset"
            boolean r7 = r3.hasKey(r5)
            if (r7 == 0) goto L_0x02e0
            double r7 = r3.getDouble(r5)
            float r3 = r6.mScale
            double r4 = (double) r3
            double r4 = r4 * r42
            double r4 = r4 * r7
            double r2 = (double) r2
            double r4 = r4 / r2
            double r10 = r10 - r4
            goto L_0x02e0
        L_0x02ab:
            if (r12 == 0) goto L_0x02e0
            boolean r2 = r12.hasKey(r8)
            if (r2 == 0) goto L_0x02e0
            boolean r2 = r12.hasKey(r5)
            if (r2 == 0) goto L_0x02e0
            int r2 = r12.getInt(r5)
            com.facebook.react.bridge.ReadableMap r4 = r12.getMap(r8)
            boolean r5 = r4.hasKey(r3)
            if (r5 == 0) goto L_0x02e0
            com.facebook.react.bridge.ReadableMap r3 = r4.getMap(r3)
            java.lang.String r4 = "ySubscriptYOffset"
            boolean r5 = r3.hasKey(r4)
            if (r5 == 0) goto L_0x02e0
            double r3 = r3.getDouble(r4)
            float r5 = r6.mScale
            double r7 = (double) r5
            double r7 = r7 * r42
            double r7 = r7 * r3
            double r2 = (double) r2
            double r7 = r7 / r2
            double r10 = r10 + r7
        L_0x02e0:
            r2 = r10
            android.graphics.Matrix r4 = new android.graphics.Matrix
            r4.<init>()
            android.graphics.Matrix r5 = new android.graphics.Matrix
            r5.<init>()
            android.graphics.Matrix r12 = new android.graphics.Matrix
            r12.<init>()
            r7 = 9
            float[] r11 = new float[r7]
            float[] r10 = new float[r7]
            r9 = 0
        L_0x02f7:
            if (r9 >= r13) goto L_0x0540
            char r7 = r20[r9]
            java.lang.String r8 = java.lang.String.valueOf(r7)
            boolean r33 = r46[r9]
            if (r33 == 0) goto L_0x030a
            java.lang.String r8 = ""
            r6 = r8
            r34 = r13
            r8 = 0
            goto L_0x0343
        L_0x030a:
            r59 = r8
            r24 = r9
            r8 = 0
        L_0x030f:
            r34 = 1
            int r6 = r24 + 1
            if (r6 >= r13) goto L_0x033e
            r34 = r47[r6]
            r35 = 0
            int r34 = (r34 > r35 ? 1 : (r34 == r35 ? 0 : -1))
            if (r34 <= 0) goto L_0x031e
            goto L_0x033e
        L_0x031e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r34 = r13
            r13 = r59
            java.lang.StringBuilder r8 = r8.append(r13)
            char r13 = r20[r6]
            java.lang.StringBuilder r8 = r8.append(r13)
            java.lang.String r59 = r8.toString()
            r8 = 1
            r46[r6] = r8
            r24 = r6
            r13 = r34
            r8 = 1
            goto L_0x030f
        L_0x033e:
            r34 = r13
            r13 = r59
            r6 = r13
        L_0x0343:
            float r13 = r14.measureText(r6)
            double r13 = (double) r13
            double r13 = r13 * r49
            r35 = r6
            if (r27 == 0) goto L_0x035b
            r6 = r47[r9]
            r37 = r8
            r36 = r9
            double r8 = (double) r6
            double r8 = r8 * r49
            double r8 = r8 - r13
            r22 = r8
            goto L_0x035f
        L_0x035b:
            r37 = r8
            r36 = r9
        L_0x035f:
            r6 = 32
            if (r7 != r6) goto L_0x0365
            r6 = 1
            goto L_0x0366
        L_0x0365:
            r6 = 0
        L_0x0366:
            if (r6 == 0) goto L_0x036b
            r8 = r25
            goto L_0x036d
        L_0x036b:
            r8 = r17
        L_0x036d:
            double r8 = r8 + r29
            double r8 = r8 + r13
            if (r33 == 0) goto L_0x0377
            r42 = r2
            r2 = r17
            goto L_0x037d
        L_0x0377:
            double r38 = r22 + r8
            r42 = r2
            r2 = r38
        L_0x037d:
            double r2 = r15.nextX(r2)
            r39 = r10
            r38 = r11
            double r10 = r15.nextY()
            double r59 = r15.nextDeltaX()
            double r61 = r15.nextDeltaY()
            r63 = r10
            double r10 = r15.nextRotation()
            if (r33 != 0) goto L_0x0500
            if (r6 == 0) goto L_0x039d
            goto L_0x0500
        L_0x039d:
            double r8 = r8 * r0
            double r13 = r13 * r0
            double r2 = r2 + r59
            double r2 = r2 * r0
            double r2 = r31 + r2
            double r2 = r2 - r8
            if (r16 == 0) goto L_0x0444
            double r8 = r2 + r13
            double r13 = r13 / r44
            r33 = r7
            double r6 = r2 + r13
            int r59 = (r6 > r57 ? 1 : (r6 == r57 ? 0 : -1))
            if (r59 <= 0) goto L_0x03b5
            goto L_0x0500
        L_0x03b5:
            int r59 = (r6 > r53 ? 1 : (r6 == r53 ? 0 : -1))
            if (r59 >= 0) goto L_0x03bb
            goto L_0x0500
        L_0x03bb:
            r59 = r15
            r15 = 3
            if (r41 == 0) goto L_0x03cb
            float r2 = (float) r6
            r3 = r28
            r3.getMatrix(r2, r5, r15)
            r65 = r10
            r15 = r38
            goto L_0x042b
        L_0x03cb:
            r65 = r10
            r10 = r28
            int r11 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r11 >= 0) goto L_0x03dd
            r11 = 0
            r10.getMatrix(r11, r4, r15)
            float r2 = (float) r2
            r4.preTranslate(r2, r11)
            r11 = 1
            goto L_0x03e2
        L_0x03dd:
            float r2 = (float) r2
            r11 = 1
            r10.getMatrix(r2, r4, r11)
        L_0x03e2:
            float r2 = (float) r6
            r10.getMatrix(r2, r5, r11)
            int r2 = (r8 > r51 ? 1 : (r8 == r51 ? 0 : -1))
            if (r2 <= 0) goto L_0x03f7
            r6 = r51
            float r2 = (float) r6
            r10.getMatrix(r2, r12, r15)
            double r8 = r8 - r6
            float r2 = (float) r8
            r3 = 0
            r12.preTranslate(r2, r3)
            goto L_0x03fd
        L_0x03f7:
            r6 = r51
            float r2 = (float) r8
            r10.getMatrix(r2, r12, r11)
        L_0x03fd:
            r15 = r38
            r4.getValues(r15)
            r9 = r39
            r12.getValues(r9)
            r8 = 2
            r2 = r15[r8]
            double r2 = (double) r2
            r19 = 5
            r11 = r15[r19]
            r51 = r6
            double r6 = (double) r11
            r11 = r9[r8]
            r28 = r10
            double r10 = (double) r11
            r8 = r9[r19]
            double r8 = (double) r8
            double r10 = r10 - r2
            double r8 = r8 - r6
            double r2 = java.lang.Math.atan2(r8, r10)
            r6 = 4633260481411531256(0x404ca5dc1a63c1f8, double:57.29577951308232)
            double r2 = r2 * r6
            double r2 = r2 * r0
            float r2 = (float) r2
            r5.preRotate(r2)
        L_0x042b:
            double r2 = -r13
            float r2 = (float) r2
            double r6 = r61 + r42
            float r3 = (float) r6
            r5.preTranslate(r2, r3)
            r10 = r55
            float r2 = (float) r10
            r6 = r40
            float r3 = (float) r6
            r5.preScale(r2, r3)
            r7 = r63
            float r2 = (float) r7
            r3 = 0
            r5.postTranslate(r3, r2)
            goto L_0x045b
        L_0x0444:
            r33 = r7
            r65 = r10
            r59 = r15
            r15 = r38
            r6 = r40
            r10 = r55
            r7 = r63
            float r2 = (float) r2
            double r7 = r7 + r61
            double r7 = r7 + r42
            float r3 = (float) r7
            r5.setTranslate(r2, r3)
        L_0x045b:
            r2 = r65
            float r2 = (float) r2
            r5.preRotate(r2)
            if (r37 == 0) goto L_0x0499
            android.graphics.Path r2 = new android.graphics.Path
            r2.<init>()
            r9 = 0
            int r3 = r35.length()
            r13 = 0
            r14 = 0
            r37 = r51
            r19 = 2
            r7 = r71
            r8 = r35
            r33 = r36
            r36 = r28
            r28 = r39
            r39 = r10
            r24 = r28
            r11 = 1
            r10 = r3
            r3 = r15
            r15 = r11
            r11 = r13
            r13 = r21
            r21 = r12
            r12 = r14
            r67 = r13
            r14 = r34
            r13 = r2
            r7.getTextPath(r8, r9, r10, r11, r12, r13)
            r7 = r2
            r13 = r35
            r2 = r48
            goto L_0x04b7
        L_0x0499:
            r3 = r15
            r67 = r21
            r7 = r33
            r14 = r34
            r13 = r35
            r33 = r36
            r24 = r39
            r2 = r48
            r37 = r51
            r15 = 1
            r19 = 2
            r39 = r10
            r21 = r12
            r36 = r28
            android.graphics.Path r7 = r2.getOrCreateAndCache(r7, r13)
        L_0x04b7:
            android.graphics.RectF r8 = new android.graphics.RectF
            r8.<init>()
            r7.computeBounds(r8, r15)
            float r8 = r8.width()
            r9 = 0
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 != 0) goto L_0x04ef
            r72.save()
            r8 = r72
            r10 = r59
            r8.concat(r5)
            r7 = r9
            r9 = r69
            java.util.ArrayList<java.lang.String> r11 = r9.emoji
            r11.add(r13)
            java.util.ArrayList<android.graphics.Matrix> r11 = r9.emojiTransforms
            android.graphics.Matrix r12 = new android.graphics.Matrix
            r12.<init>(r5)
            r11.add(r12)
            r11 = r71
            r8.drawText(r13, r7, r7, r11)
            r72.restore()
            r12 = r67
            goto L_0x0522
        L_0x04ef:
            r9 = r69
            r11 = r71
            r8 = r72
            r10 = r59
            r7.transform(r5)
            r12 = r67
            r12.addPath(r7)
            goto L_0x0522
        L_0x0500:
            r9 = r69
            r11 = r71
            r8 = r72
            r10 = r15
            r14 = r34
            r33 = r36
            r3 = r38
            r24 = r39
            r6 = r40
            r2 = r48
            r37 = r51
            r39 = r55
            r15 = 1
            r19 = 2
            r36 = r28
            r68 = r21
            r21 = r12
            r12 = r68
        L_0x0522:
            int r7 = r33 + 1
            r48 = r2
            r15 = r10
            r13 = r14
            r10 = r24
            r28 = r36
            r51 = r37
            r55 = r39
            r40 = r6
            r6 = r9
            r14 = r11
            r11 = r3
            r9 = r7
            r2 = r42
            r68 = r21
            r21 = r12
            r12 = r68
            goto L_0x02f7
        L_0x0540:
            r9 = r6
            r12 = r21
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.TSpanView.getLinePath(java.lang.String, android.graphics.Paint, android.graphics.Canvas):android.graphics.Path");
    }

    /* renamed from: com.horcrux.svg.TSpanView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor;
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust;

        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(2:35|36)|37|39|40|(2:41|42)|43|45|46|47|48|(3:49|50|52)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|39|40|(2:41|42)|43|45|46|47|48|49|50|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|39|40|(2:41|42)|43|45|46|47|48|49|50|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(47:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|39|40|41|42|43|45|46|47|48|49|50|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(48:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|39|40|41|42|43|45|46|47|48|49|50|52) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00d1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00ec */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00f6 */
        static {
            /*
                com.horcrux.svg.TextProperties$AlignmentBaseline[] r0 = com.horcrux.svg.TextProperties.AlignmentBaseline.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline = r0
                r1 = 1
                com.horcrux.svg.TextProperties$AlignmentBaseline r2 = com.horcrux.svg.TextProperties.AlignmentBaseline.baseline     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x001d }
                com.horcrux.svg.TextProperties$AlignmentBaseline r3 = com.horcrux.svg.TextProperties.AlignmentBaseline.textBottom     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.afterEdge     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.textAfterEdge     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x003e }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.alphabetic     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.ideographic     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.middle     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r5 = 7
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.central     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r5 = 8
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x006c }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.mathematical     // Catch:{ NoSuchFieldError -> 0x006c }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r5 = 9
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.hanging     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r5 = 10
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.textTop     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r5 = 11
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.beforeEdge     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r5 = 12
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x009c }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.textBeforeEdge     // Catch:{ NoSuchFieldError -> 0x009c }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r5 = 13
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.bottom     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r5 = 14
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.center     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r5 = 15
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.top     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r5 = 16
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                com.horcrux.svg.TextProperties$TextLengthAdjust[] r3 = com.horcrux.svg.TextProperties.TextLengthAdjust.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust = r3
                com.horcrux.svg.TextProperties$TextLengthAdjust r4 = com.horcrux.svg.TextProperties.TextLengthAdjust.spacing     // Catch:{ NoSuchFieldError -> 0x00d1 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d1 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x00d1 }
            L_0x00d1:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust     // Catch:{ NoSuchFieldError -> 0x00db }
                com.horcrux.svg.TextProperties$TextLengthAdjust r4 = com.horcrux.svg.TextProperties.TextLengthAdjust.spacingAndGlyphs     // Catch:{ NoSuchFieldError -> 0x00db }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00db }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x00db }
            L_0x00db:
                com.horcrux.svg.TextProperties$TextAnchor[] r3 = com.horcrux.svg.TextProperties.TextAnchor.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor = r3
                com.horcrux.svg.TextProperties$TextAnchor r4 = com.horcrux.svg.TextProperties.TextAnchor.start     // Catch:{ NoSuchFieldError -> 0x00ec }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ec }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x00ec }
            L_0x00ec:
                int[] r1 = $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor     // Catch:{ NoSuchFieldError -> 0x00f6 }
                com.horcrux.svg.TextProperties$TextAnchor r3 = com.horcrux.svg.TextProperties.TextAnchor.middle     // Catch:{ NoSuchFieldError -> 0x00f6 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f6 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x00f6 }
            L_0x00f6:
                int[] r0 = $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor     // Catch:{ NoSuchFieldError -> 0x0100 }
                com.horcrux.svg.TextProperties$TextAnchor r1 = com.horcrux.svg.TextProperties.TextAnchor.end     // Catch:{ NoSuchFieldError -> 0x0100 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0100 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0100 }
            L_0x0100:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.TSpanView.AnonymousClass1.<clinit>():void");
        }
    }

    private double getAbsoluteStartOffset(SVGLength sVGLength, double d, double d2) {
        return PropHelper.fromRelative(sVGLength, d, 0.0d, (double) this.mScale, d2);
    }

    private double getTextAnchorOffset(TextProperties.TextAnchor textAnchor, double d) {
        int i = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor.ordinal()];
        if (i == 2) {
            return (-d) / 2.0d;
        }
        if (i != 3) {
            return 0.0d;
        }
        return -d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r0 = android.graphics.Typeface.create(android.graphics.Typeface.createFromAsset(r10.assets, r7), r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x00d1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void applyTextPropertiesToPaint(android.graphics.Paint r11, com.horcrux.svg.FontData r12) {
        /*
            r10 = this;
            com.horcrux.svg.TextProperties$FontWeight r0 = r12.fontWeight
            com.horcrux.svg.TextProperties$FontWeight r1 = com.horcrux.svg.TextProperties.FontWeight.Bold
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x0011
            int r0 = r12.absoluteFontWeight
            r1 = 550(0x226, float:7.71E-43)
            if (r0 < r1) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r0 = r2
            goto L_0x0012
        L_0x0011:
            r0 = r3
        L_0x0012:
            com.horcrux.svg.TextProperties$FontStyle r1 = r12.fontStyle
            com.horcrux.svg.TextProperties$FontStyle r4 = com.horcrux.svg.TextProperties.FontStyle.italic
            if (r1 != r4) goto L_0x001a
            r1 = r3
            goto L_0x001b
        L_0x001a:
            r1 = r2
        L_0x001b:
            if (r0 == 0) goto L_0x0021
            if (r1 == 0) goto L_0x0021
            r2 = 3
            goto L_0x0028
        L_0x0021:
            if (r0 == 0) goto L_0x0025
            r2 = r3
            goto L_0x0028
        L_0x0025:
            if (r1 == 0) goto L_0x0028
            r2 = 2
        L_0x0028:
            r0 = 0
            int r4 = r12.absoluteFontWeight
            java.lang.String r5 = r12.fontFamily
            if (r5 == 0) goto L_0x00db
            int r6 = r5.length()
            if (r6 <= 0) goto L_0x00db
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "fonts/"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r5)
            java.lang.String r8 = ".otf"
            java.lang.StringBuilder r6 = r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.StringBuilder r7 = r8.append(r7)
            java.lang.StringBuilder r7 = r7.append(r5)
            java.lang.String r8 = ".ttf"
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            int r8 = android.os.Build.VERSION.SDK_INT
            r9 = 26
            if (r8 < r9) goto L_0x00c6
            android.graphics.Typeface$Builder r0 = new android.graphics.Typeface$Builder
            android.content.res.AssetManager r8 = r10.assets
            r0.<init>(r8, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "'wght' "
            java.lang.StringBuilder r6 = r6.append(r8)
            java.lang.StringBuilder r6 = r6.append(r4)
            java.lang.String r9 = r12.fontVariationSettings
            java.lang.StringBuilder r6 = r6.append(r9)
            java.lang.String r6 = r6.toString()
            r0.setFontVariationSettings(r6)
            r0.setWeight(r4)
            r0.setItalic(r1)
            android.graphics.Typeface r0 = r0.build()
            if (r0 != 0) goto L_0x00db
            android.graphics.Typeface$Builder r0 = new android.graphics.Typeface$Builder
            android.content.res.AssetManager r6 = r10.assets
            r0.<init>(r6, r7)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r6 = r6.append(r8)
            java.lang.StringBuilder r6 = r6.append(r4)
            java.lang.String r7 = r12.fontVariationSettings
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r0.setFontVariationSettings(r6)
            r0.setWeight(r4)
            r0.setItalic(r1)
            android.graphics.Typeface r0 = r0.build()
            goto L_0x00db
        L_0x00c6:
            android.content.res.AssetManager r8 = r10.assets     // Catch:{ Exception -> 0x00d1 }
            android.graphics.Typeface r0 = android.graphics.Typeface.createFromAsset(r8, r6)     // Catch:{ Exception -> 0x00d1 }
            android.graphics.Typeface r0 = android.graphics.Typeface.create(r0, r2)     // Catch:{ Exception -> 0x00d1 }
            goto L_0x00db
        L_0x00d1:
            android.content.res.AssetManager r6 = r10.assets     // Catch:{ Exception -> 0x00db }
            android.graphics.Typeface r0 = android.graphics.Typeface.createFromAsset(r6, r7)     // Catch:{ Exception -> 0x00db }
            android.graphics.Typeface r0 = android.graphics.Typeface.create(r0, r2)     // Catch:{ Exception -> 0x00db }
        L_0x00db:
            if (r0 != 0) goto L_0x00e7
            com.facebook.react.views.text.ReactFontManager r6 = com.facebook.react.views.text.ReactFontManager.getInstance()     // Catch:{ Exception -> 0x00e7 }
            android.content.res.AssetManager r7 = r10.assets     // Catch:{ Exception -> 0x00e7 }
            android.graphics.Typeface r0 = r6.getTypeface((java.lang.String) r5, (int) r2, (android.content.res.AssetManager) r7)     // Catch:{ Exception -> 0x00e7 }
        L_0x00e7:
            int r2 = android.os.Build.VERSION.SDK_INT
            r5 = 28
            if (r2 < r5) goto L_0x00f1
            android.graphics.Typeface r0 = android.graphics.Typeface.create(r0, r4, r1)
        L_0x00f1:
            r11.setLinearText(r3)
            r11.setSubpixelText(r3)
            r11.setTypeface(r0)
            double r0 = r12.fontSize
            float r12 = r10.mScale
            double r2 = (double) r12
            double r0 = r0 * r2
            float r12 = (float) r0
            r11.setTextSize(r12)
            int r12 = android.os.Build.VERSION.SDK_INT
            r0 = 21
            if (r12 < r0) goto L_0x010e
            r12 = 0
            r11.setLetterSpacing(r12)
        L_0x010e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.TSpanView.applyTextPropertiesToPaint(android.graphics.Paint, com.horcrux.svg.FontData):void");
    }

    private void setupTextPath() {
        ViewParent parent = getParent();
        while (parent != null) {
            if (parent.getClass() == TextPathView.class) {
                this.textPath = (TextPathView) parent;
                return;
            } else if (parent instanceof TextView) {
                parent = parent.getParent();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int hitTest(float[] fArr) {
        if (this.mContent == null) {
            return super.hitTest(fArr);
        }
        if (this.mPath != null && this.mInvertible && this.mTransformInvertible) {
            float[] fArr2 = new float[2];
            this.mInvMatrix.mapPoints(fArr2, fArr);
            this.mInvTransform.mapPoints(fArr2);
            int round = Math.round(fArr2[0]);
            int round2 = Math.round(fArr2[1]);
            initBounds();
            if ((this.mRegion != null && this.mRegion.contains(round, round2)) || (this.mStrokeRegion != null && this.mStrokeRegion.contains(round, round2))) {
                if (getClipPath() == null || this.mClipRegion.contains(round, round2)) {
                    return getId();
                }
                return -1;
            }
        }
        return -1;
    }
}

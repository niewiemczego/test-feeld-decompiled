package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class WebViewSubtitleOutput extends FrameLayout implements SubtitleView.Output {
    private static final float CSS_LINE_HEIGHT = 1.2f;
    private static final String DEFAULT_BACKGROUND_CSS_CLASS = "default_bg";
    private float bottomPaddingFraction;
    private final CanvasSubtitleOutput canvasSubtitleOutput;
    private float defaultTextSize;
    private int defaultTextSizeType;
    private CaptionStyleCompat style;
    private List<Cue> textCues;
    private final WebView webView;

    private static int anchorTypeToTranslatePercent(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    private static String convertVerticalTypeToCss(int i) {
        return i != 1 ? i != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
    }

    public WebViewSubtitleOutput(Context context) {
        this(context, (AttributeSet) null);
    }

    public WebViewSubtitleOutput(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.textCues = Collections.emptyList();
        this.style = CaptionStyleCompat.DEFAULT;
        this.defaultTextSize = 0.0533f;
        this.defaultTextSizeType = 0;
        this.bottomPaddingFraction = 0.08f;
        CanvasSubtitleOutput canvasSubtitleOutput2 = new CanvasSubtitleOutput(context, attributeSet);
        this.canvasSubtitleOutput = canvasSubtitleOutput2;
        AnonymousClass1 r2 = new WebView(this, context, attributeSet) {
            public boolean onTouchEvent(MotionEvent motionEvent) {
                super.onTouchEvent(motionEvent);
                return false;
            }

            public boolean performClick() {
                super.performClick();
                return false;
            }
        };
        this.webView = r2;
        r2.setBackgroundColor(0);
        addView(canvasSubtitleOutput2);
        addView(r2);
    }

    public void update(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2) {
        this.style = captionStyleCompat;
        this.defaultTextSize = f;
        this.defaultTextSizeType = i;
        this.bottomPaddingFraction = f2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Cue cue = list.get(i2);
            if (cue.bitmap != null) {
                arrayList.add(cue);
            } else {
                arrayList2.add(cue);
            }
        }
        if (!this.textCues.isEmpty() || !arrayList2.isEmpty()) {
            this.textCues = arrayList2;
            updateWebView();
        }
        this.canvasSubtitleOutput.update(arrayList, captionStyleCompat, f, i, f2);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && !this.textCues.isEmpty()) {
            updateWebView();
        }
    }

    public void destroy() {
        this.webView.destroy();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x014e, code lost:
        if (r13 != 0) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0151, code lost:
        if (r13 != 0) goto L_0x0153;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x024f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateWebView() {
        /*
            r26 = this;
            r0 = r26
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 4
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.google.android.exoplayer2.ui.CaptionStyleCompat r4 = r0.style
            int r4 = r4.foregroundColor
            java.lang.String r4 = com.google.android.exoplayer2.ui.HtmlUtils.toCssRgba(r4)
            r5 = 0
            r3[r5] = r4
            int r4 = r0.defaultTextSizeType
            float r6 = r0.defaultTextSize
            java.lang.String r4 = r0.convertTextSizeToCss(r4, r6)
            r6 = 1
            r3[r6] = r4
            r4 = 1067030938(0x3f99999a, float:1.2)
            java.lang.Float r7 = java.lang.Float.valueOf(r4)
            r8 = 2
            r3[r8] = r7
            com.google.android.exoplayer2.ui.CaptionStyleCompat r7 = r0.style
            java.lang.String r7 = convertCaptionStyleToCssTextShadow(r7)
            r9 = 3
            r3[r9] = r7
            java.lang.String r7 = "<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>"
            java.lang.String r3 = com.google.android.exoplayer2.util.Util.formatInvariant(r7, r3)
            r1.append(r3)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r7 = "default_bg"
            java.lang.String r10 = com.google.android.exoplayer2.ui.HtmlUtils.cssAllClassDescendantsSelector(r7)
            java.lang.Object[] r11 = new java.lang.Object[r6]
            com.google.android.exoplayer2.ui.CaptionStyleCompat r12 = r0.style
            int r12 = r12.backgroundColor
            java.lang.String r12 = com.google.android.exoplayer2.ui.HtmlUtils.toCssRgba(r12)
            r11[r5] = r12
            java.lang.String r12 = "background-color:%s;"
            java.lang.String r11 = com.google.android.exoplayer2.util.Util.formatInvariant(r12, r11)
            r3.put(r10, r11)
            r10 = r5
        L_0x005d:
            java.util.List<com.google.android.exoplayer2.text.Cue> r11 = r0.textCues
            int r11 = r11.size()
            if (r10 >= r11) goto L_0x026e
            java.util.List<com.google.android.exoplayer2.text.Cue> r11 = r0.textCues
            java.lang.Object r11 = r11.get(r10)
            com.google.android.exoplayer2.text.Cue r11 = (com.google.android.exoplayer2.text.Cue) r11
            float r12 = r11.position
            r13 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            r14 = 1120403456(0x42c80000, float:100.0)
            if (r12 == 0) goto L_0x007c
            float r12 = r11.position
            float r12 = r12 * r14
            goto L_0x007e
        L_0x007c:
            r12 = 1112014848(0x42480000, float:50.0)
        L_0x007e:
            int r15 = r11.positionAnchor
            int r15 = anchorTypeToTranslatePercent(r15)
            float r2 = r11.line
            int r2 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            r17 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r9 = "%.2f%%"
            if (r2 == 0) goto L_0x00e4
            int r2 = r11.lineType
            if (r2 == r6) goto L_0x00b4
            java.lang.Object[] r2 = new java.lang.Object[r6]
            float r8 = r11.line
            float r8 = r8 * r14
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            r2[r5] = r8
            java.lang.String r2 = com.google.android.exoplayer2.util.Util.formatInvariant(r9, r2)
            int r8 = r11.verticalType
            if (r8 != r6) goto L_0x00ad
            int r8 = r11.lineAnchor
            int r8 = anchorTypeToTranslatePercent(r8)
            int r8 = -r8
            goto L_0x00f8
        L_0x00ad:
            int r8 = r11.lineAnchor
            int r8 = anchorTypeToTranslatePercent(r8)
            goto L_0x00f8
        L_0x00b4:
            float r2 = r11.line
            r8 = 0
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            java.lang.String r8 = "%.2fem"
            if (r2 < 0) goto L_0x00cf
            java.lang.Object[] r2 = new java.lang.Object[r6]
            float r13 = r11.line
            float r13 = r13 * r4
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            r2[r5] = r13
            java.lang.String r2 = com.google.android.exoplayer2.util.Util.formatInvariant(r8, r2)
            r8 = r5
            r13 = r8
            goto L_0x00f9
        L_0x00cf:
            java.lang.Object[] r2 = new java.lang.Object[r6]
            float r13 = r11.line
            float r13 = -r13
            float r13 = r13 - r17
            float r13 = r13 * r4
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            r2[r5] = r13
            java.lang.String r2 = com.google.android.exoplayer2.util.Util.formatInvariant(r8, r2)
            r8 = r5
            r13 = r6
            goto L_0x00f9
        L_0x00e4:
            java.lang.Object[] r2 = new java.lang.Object[r6]
            float r8 = r0.bottomPaddingFraction
            float r17 = r17 - r8
            float r17 = r17 * r14
            java.lang.Float r8 = java.lang.Float.valueOf(r17)
            r2[r5] = r8
            java.lang.String r2 = com.google.android.exoplayer2.util.Util.formatInvariant(r9, r2)
            r8 = -100
        L_0x00f8:
            r13 = r5
        L_0x00f9:
            float r4 = r11.size
            r18 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r4 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r4 == 0) goto L_0x0112
            java.lang.Object[] r4 = new java.lang.Object[r6]
            float r6 = r11.size
            float r6 = r6 * r14
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            r4[r5] = r6
            java.lang.String r4 = com.google.android.exoplayer2.util.Util.formatInvariant(r9, r4)
            goto L_0x0114
        L_0x0112:
            java.lang.String r4 = "fit-content"
        L_0x0114:
            android.text.Layout$Alignment r6 = r11.textAlignment
            java.lang.String r6 = convertAlignmentToCss(r6)
            int r9 = r11.verticalType
            java.lang.String r9 = convertVerticalTypeToCss(r9)
            int r14 = r11.textSizeType
            float r5 = r11.textSize
            java.lang.String r5 = r0.convertTextSizeToCss(r14, r5)
            boolean r14 = r11.windowColorSet
            if (r14 == 0) goto L_0x012f
            int r14 = r11.windowColor
            goto L_0x0133
        L_0x012f:
            com.google.android.exoplayer2.ui.CaptionStyleCompat r14 = r0.style
            int r14 = r14.windowColor
        L_0x0133:
            java.lang.String r14 = com.google.android.exoplayer2.ui.HtmlUtils.toCssRgba(r14)
            r20 = r8
            int r8 = r11.verticalType
            java.lang.String r21 = "right"
            java.lang.String r22 = "left"
            java.lang.String r23 = "top"
            r24 = r15
            r15 = 1
            if (r8 == r15) goto L_0x0151
            r15 = 2
            if (r8 == r15) goto L_0x014e
            if (r13 == 0) goto L_0x0159
            java.lang.String r23 = "bottom"
            goto L_0x0159
        L_0x014e:
            if (r13 == 0) goto L_0x0153
            goto L_0x0155
        L_0x0151:
            if (r13 == 0) goto L_0x0155
        L_0x0153:
            r21 = r22
        L_0x0155:
            r22 = r23
            r23 = r21
        L_0x0159:
            int r8 = r11.verticalType
            r13 = 2
            if (r8 == r13) goto L_0x016a
            int r8 = r11.verticalType
            r13 = 1
            if (r8 != r13) goto L_0x0164
            goto L_0x016a
        L_0x0164:
            java.lang.String r8 = "width"
            r15 = r24
            goto L_0x0170
        L_0x016a:
            java.lang.String r8 = "height"
            r15 = r20
            r20 = r24
        L_0x0170:
            java.lang.CharSequence r13 = r11.text
            android.content.Context r21 = r26.getContext()
            android.content.res.Resources r21 = r21.getResources()
            android.util.DisplayMetrics r0 = r21.getDisplayMetrics()
            float r0 = r0.density
            com.google.android.exoplayer2.ui.SpannedToHtmlConverter$HtmlAndCss r0 = com.google.android.exoplayer2.ui.SpannedToHtmlConverter.convert(r13, r0)
            java.util.Set r13 = r3.keySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x018c:
            boolean r21 = r13.hasNext()
            if (r21 == 0) goto L_0x01c4
            java.lang.Object r21 = r13.next()
            r24 = r13
            r13 = r21
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r21 = r3.get(r13)
            r25 = r0
            r0 = r21
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r3.put(r13, r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x01bb
            java.lang.Object r13 = r3.get(r13)
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x01b9
            goto L_0x01bb
        L_0x01b9:
            r0 = 0
            goto L_0x01bc
        L_0x01bb:
            r0 = 1
        L_0x01bc:
            com.google.android.exoplayer2.util.Assertions.checkState(r0)
            r13 = r24
            r0 = r25
            goto L_0x018c
        L_0x01c4:
            r25 = r0
            r0 = 14
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r10)
            r19 = 0
            r0[r19] = r13
            r13 = 1
            r0[r13] = r22
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            r13 = 2
            r0[r13] = r12
            r12 = 3
            r0[r12] = r23
            r16 = 4
            r0[r16] = r2
            r2 = 5
            r0[r2] = r8
            r2 = 6
            r0[r2] = r4
            r2 = 7
            r0[r2] = r6
            r2 = 8
            r0[r2] = r9
            r2 = 9
            r0[r2] = r5
            r2 = 10
            r0[r2] = r14
            r2 = 11
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
            r0[r2] = r4
            r2 = 12
            java.lang.Integer r4 = java.lang.Integer.valueOf(r20)
            r0[r2] = r4
            r2 = 13
            java.lang.String r4 = getBlockShearTransformFunction(r11)
            r0[r2] = r4
            java.lang.String r2 = "<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>"
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.formatInvariant(r2, r0)
            java.lang.StringBuilder r0 = r1.append(r0)
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]
            r5 = 0
            r4[r5] = r7
            java.lang.String r6 = "<span class='%s'>"
            java.lang.String r4 = com.google.android.exoplayer2.util.Util.formatInvariant(r6, r4)
            r0.append(r4)
            android.text.Layout$Alignment r0 = r11.multiRowAlignment
            java.lang.String r4 = "</span>"
            if (r0 == 0) goto L_0x024f
            java.lang.Object[] r0 = new java.lang.Object[r2]
            android.text.Layout$Alignment r2 = r11.multiRowAlignment
            java.lang.String r2 = convertAlignmentToCss(r2)
            r0[r5] = r2
            java.lang.String r2 = "<span style='display:inline-block; text-align:%s;'>"
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.formatInvariant(r2, r0)
            java.lang.StringBuilder r0 = r1.append(r0)
            r2 = r25
            java.lang.String r2 = r2.html
            java.lang.StringBuilder r0 = r0.append(r2)
            r0.append(r4)
            goto L_0x0256
        L_0x024f:
            r2 = r25
            java.lang.String r0 = r2.html
            r1.append(r0)
        L_0x0256:
            java.lang.StringBuilder r0 = r1.append(r4)
            java.lang.String r2 = "</div>"
            r0.append(r2)
            int r10 = r10 + 1
            r4 = 1067030938(0x3f99999a, float:1.2)
            r5 = 0
            r0 = r26
            r9 = r12
            r8 = r13
            r2 = r16
            r6 = 1
            goto L_0x005d
        L_0x026e:
            java.lang.String r0 = "</div></body></html>"
            r1.append(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "<html><head><style>"
            r0.append(r2)
            java.util.Set r2 = r3.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0285:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x02ad
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.StringBuilder r5 = r0.append(r4)
            java.lang.String r6 = "{"
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.Object r4 = r3.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r5 = "}"
            r4.append(r5)
            goto L_0x0285
        L_0x02ad:
            java.lang.String r2 = "</style></head>"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r2 = 0
            r1.insert(r2, r0)
            r0 = r26
            android.webkit.WebView r2 = r0.webView
            java.lang.String r1 = r1.toString()
            java.nio.charset.Charset r3 = com.google.common.base.Charsets.UTF_8
            byte[] r1 = r1.getBytes(r3)
            r3 = 1
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r3)
            java.lang.String r3 = "text/html"
            java.lang.String r4 = "base64"
            r2.loadData(r1, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.WebViewSubtitleOutput.updateWebView():void");
    }

    private static String getBlockShearTransformFunction(Cue cue) {
        if (cue.shearDegrees == 0.0f) {
            return "";
        }
        return Util.formatInvariant("%s(%.2fdeg)", (cue.verticalType == 2 || cue.verticalType == 1) ? "skewY" : "skewX", Float.valueOf(cue.shearDegrees));
    }

    private String convertTextSizeToCss(int i, float f) {
        float resolveTextSize = SubtitleViewUtils.resolveTextSize(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (resolveTextSize == -3.4028235E38f) {
            return "unset";
        }
        return Util.formatInvariant("%.2fpx", Float.valueOf(resolveTextSize / getContext().getResources().getDisplayMetrics().density));
    }

    private static String convertCaptionStyleToCssTextShadow(CaptionStyleCompat captionStyleCompat) {
        int i = captionStyleCompat.edgeType;
        if (i == 1) {
            return Util.formatInvariant("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", HtmlUtils.toCssRgba(captionStyleCompat.edgeColor));
        } else if (i == 2) {
            return Util.formatInvariant("0.1em 0.12em 0.15em %s", HtmlUtils.toCssRgba(captionStyleCompat.edgeColor));
        } else if (i == 3) {
            return Util.formatInvariant("0.06em 0.08em 0.15em %s", HtmlUtils.toCssRgba(captionStyleCompat.edgeColor));
        } else if (i != 4) {
            return "unset";
        } else {
            return Util.formatInvariant("-0.05em -0.05em 0.15em %s", HtmlUtils.toCssRgba(captionStyleCompat.edgeColor));
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.WebViewSubtitleOutput$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$text$Layout$Alignment;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                android.text.Layout$Alignment[] r0 = android.text.Layout.Alignment.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$text$Layout$Alignment = r0
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$android$text$Layout$Alignment     // Catch:{ NoSuchFieldError -> 0x001d }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$android$text$Layout$Alignment     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.WebViewSubtitleOutput.AnonymousClass2.<clinit>():void");
        }
    }

    private static String convertAlignmentToCss(Layout.Alignment alignment) {
        if (alignment == null) {
            return TtmlNode.CENTER;
        }
        int i = AnonymousClass2.$SwitchMap$android$text$Layout$Alignment[alignment.ordinal()];
        if (i != 1) {
            return i != 2 ? TtmlNode.CENTER : "end";
        }
        return "start";
    }
}

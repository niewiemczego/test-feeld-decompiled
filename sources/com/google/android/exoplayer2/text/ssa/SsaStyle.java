package com.google.android.exoplayer2.text.ssa;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SsaStyle {
    public static final int SSA_ALIGNMENT_BOTTOM_CENTER = 2;
    public static final int SSA_ALIGNMENT_BOTTOM_LEFT = 1;
    public static final int SSA_ALIGNMENT_BOTTOM_RIGHT = 3;
    public static final int SSA_ALIGNMENT_MIDDLE_CENTER = 5;
    public static final int SSA_ALIGNMENT_MIDDLE_LEFT = 4;
    public static final int SSA_ALIGNMENT_MIDDLE_RIGHT = 6;
    public static final int SSA_ALIGNMENT_TOP_CENTER = 8;
    public static final int SSA_ALIGNMENT_TOP_LEFT = 7;
    public static final int SSA_ALIGNMENT_TOP_RIGHT = 9;
    public static final int SSA_ALIGNMENT_UNKNOWN = -1;
    public static final int SSA_BORDER_STYLE_BOX = 3;
    public static final int SSA_BORDER_STYLE_OUTLINE = 1;
    public static final int SSA_BORDER_STYLE_UNKNOWN = -1;
    private static final String TAG = "SsaStyle";
    public final int alignment;
    public final boolean bold;
    public final int borderStyle;
    public final float fontSize;
    public final boolean italic;
    public final String name;
    public final Integer outlineColor;
    public final Integer primaryColor;
    public final boolean strikeout;
    public final boolean underline;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SsaAlignment {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SsaBorderStyle {
    }

    private static boolean isValidAlignment(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    private static boolean isValidBorderStyle(int i) {
        return i == 1 || i == 3;
    }

    private SsaStyle(String str, int i, Integer num, Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.name = str;
        this.alignment = i;
        this.primaryColor = num;
        this.outlineColor = num2;
        this.fontSize = f;
        this.bold = z;
        this.italic = z2;
        this.underline = z3;
        this.strikeout = z4;
        this.borderStyle = i2;
    }

    public static SsaStyle fromStyleLine(String str, Format format) {
        String str2 = str;
        Format format2 = format;
        Assertions.checkArgument(str2.startsWith("Style:"));
        String[] split = TextUtils.split(str2.substring(6), ",");
        if (split.length != format2.length) {
            Log.w(TAG, Util.formatInvariant("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(format2.length), Integer.valueOf(split.length), str2));
            return null;
        }
        try {
            return new SsaStyle(split[format2.nameIndex].trim(), format2.alignmentIndex != -1 ? parseAlignment(split[format2.alignmentIndex].trim()) : -1, format2.primaryColorIndex != -1 ? parseColor(split[format2.primaryColorIndex].trim()) : null, format2.outlineColorIndex != -1 ? parseColor(split[format2.outlineColorIndex].trim()) : null, format2.fontSizeIndex != -1 ? parseFontSize(split[format2.fontSizeIndex].trim()) : -3.4028235E38f, format2.boldIndex != -1 && parseBooleanValue(split[format2.boldIndex].trim()), format2.italicIndex != -1 && parseBooleanValue(split[format2.italicIndex].trim()), format2.underlineIndex != -1 && parseBooleanValue(split[format2.underlineIndex].trim()), format2.strikeoutIndex != -1 && parseBooleanValue(split[format2.strikeoutIndex].trim()), format2.borderStyleIndex != -1 ? parseBorderStyle(split[format2.borderStyleIndex].trim()) : -1);
        } catch (RuntimeException e) {
            Log.w(TAG, "Skipping malformed 'Style:' line: '" + str2 + "'", e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static int parseAlignment(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (isValidAlignment(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        Log.w(TAG, "Ignoring unknown alignment: " + str);
        return -1;
    }

    private static int parseBorderStyle(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (isValidBorderStyle(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        Log.w(TAG, "Ignoring unknown BorderStyle: " + str);
        return -1;
    }

    public static Integer parseColor(String str) {
        long j;
        try {
            if (str.startsWith("&H")) {
                j = Long.parseLong(str.substring(2), 16);
            } else {
                j = Long.parseLong(str);
            }
            Assertions.checkArgument(j <= 4294967295L);
            return Integer.valueOf(Color.argb(Ints.checkedCast(((j >> 24) & 255) ^ 255), Ints.checkedCast(j & 255), Ints.checkedCast((j >> 8) & 255), Ints.checkedCast((j >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            Log.w(TAG, "Failed to parse color expression: '" + str + "'", e);
            return null;
        }
    }

    private static float parseFontSize(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            Log.w(TAG, "Failed to parse font size: '" + str + "'", e);
            return -3.4028235E38f;
        }
    }

    private static boolean parseBooleanValue(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt == 1 || parseInt == -1;
        } catch (NumberFormatException e) {
            Log.w(TAG, "Failed to parse boolean value: '" + str + "'", e);
            return false;
        }
    }

    static final class Format {
        public final int alignmentIndex;
        public final int boldIndex;
        public final int borderStyleIndex;
        public final int fontSizeIndex;
        public final int italicIndex;
        public final int length;
        public final int nameIndex;
        public final int outlineColorIndex;
        public final int primaryColorIndex;
        public final int strikeoutIndex;
        public final int underlineIndex;

        private Format(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            this.nameIndex = i;
            this.alignmentIndex = i2;
            this.primaryColorIndex = i3;
            this.outlineColorIndex = i4;
            this.fontSizeIndex = i5;
            this.boldIndex = i6;
            this.italicIndex = i7;
            this.underlineIndex = i8;
            this.strikeoutIndex = i9;
            this.borderStyleIndex = i10;
            this.length = i11;
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.google.android.exoplayer2.text.ssa.SsaStyle.Format fromFormatLine(java.lang.String r17) {
            /*
                r0 = 7
                r1 = r17
                java.lang.String r1 = r1.substring(r0)
                java.lang.String r2 = ","
                java.lang.String[] r1 = android.text.TextUtils.split(r1, r2)
                r2 = 0
                r3 = -1
                r4 = r2
                r6 = r3
                r7 = r6
                r8 = r7
                r9 = r8
                r10 = r9
                r11 = r10
                r12 = r11
                r13 = r12
                r14 = r13
                r15 = r14
            L_0x001a:
                int r5 = r1.length
                if (r4 >= r5) goto L_0x00c1
                r5 = r1[r4]
                java.lang.String r5 = r5.trim()
                java.lang.String r5 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r5)
                r5.hashCode()
                int r16 = r5.hashCode()
                switch(r16) {
                    case -1178781136: goto L_0x009b;
                    case -1026963764: goto L_0x0090;
                    case -192095652: goto L_0x0085;
                    case -70925746: goto L_0x007a;
                    case 3029637: goto L_0x006f;
                    case 3373707: goto L_0x0064;
                    case 366554320: goto L_0x0059;
                    case 767321349: goto L_0x004e;
                    case 1767875043: goto L_0x0041;
                    case 1988365454: goto L_0x0034;
                    default: goto L_0x0031;
                }
            L_0x0031:
                r0 = r3
                goto L_0x00a5
            L_0x0034:
                java.lang.String r0 = "outlinecolour"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x003d
                goto L_0x0031
            L_0x003d:
                r0 = 9
                goto L_0x00a5
            L_0x0041:
                java.lang.String r0 = "alignment"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x004a
                goto L_0x0031
            L_0x004a:
                r0 = 8
                goto L_0x00a5
            L_0x004e:
                java.lang.String r0 = "borderstyle"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x0057
                goto L_0x0031
            L_0x0057:
                r0 = 7
                goto L_0x00a5
            L_0x0059:
                java.lang.String r0 = "fontsize"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x0062
                goto L_0x0031
            L_0x0062:
                r0 = 6
                goto L_0x00a5
            L_0x0064:
                java.lang.String r0 = "name"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x006d
                goto L_0x0031
            L_0x006d:
                r0 = 5
                goto L_0x00a5
            L_0x006f:
                java.lang.String r0 = "bold"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x0078
                goto L_0x0031
            L_0x0078:
                r0 = 4
                goto L_0x00a5
            L_0x007a:
                java.lang.String r0 = "primarycolour"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x0083
                goto L_0x0031
            L_0x0083:
                r0 = 3
                goto L_0x00a5
            L_0x0085:
                java.lang.String r0 = "strikeout"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x008e
                goto L_0x0031
            L_0x008e:
                r0 = 2
                goto L_0x00a5
            L_0x0090:
                java.lang.String r0 = "underline"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x0099
                goto L_0x0031
            L_0x0099:
                r0 = 1
                goto L_0x00a5
            L_0x009b:
                java.lang.String r0 = "italic"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x00a4
                goto L_0x0031
            L_0x00a4:
                r0 = r2
            L_0x00a5:
                switch(r0) {
                    case 0: goto L_0x00bb;
                    case 1: goto L_0x00b9;
                    case 2: goto L_0x00b7;
                    case 3: goto L_0x00b5;
                    case 4: goto L_0x00b3;
                    case 5: goto L_0x00b1;
                    case 6: goto L_0x00af;
                    case 7: goto L_0x00ad;
                    case 8: goto L_0x00ab;
                    case 9: goto L_0x00a9;
                    default: goto L_0x00a8;
                }
            L_0x00a8:
                goto L_0x00bc
            L_0x00a9:
                r9 = r4
                goto L_0x00bc
            L_0x00ab:
                r7 = r4
                goto L_0x00bc
            L_0x00ad:
                r15 = r4
                goto L_0x00bc
            L_0x00af:
                r10 = r4
                goto L_0x00bc
            L_0x00b1:
                r6 = r4
                goto L_0x00bc
            L_0x00b3:
                r11 = r4
                goto L_0x00bc
            L_0x00b5:
                r8 = r4
                goto L_0x00bc
            L_0x00b7:
                r14 = r4
                goto L_0x00bc
            L_0x00b9:
                r13 = r4
                goto L_0x00bc
            L_0x00bb:
                r12 = r4
            L_0x00bc:
                int r4 = r4 + 1
                r0 = 7
                goto L_0x001a
            L_0x00c1:
                if (r6 == r3) goto L_0x00cd
                com.google.android.exoplayer2.text.ssa.SsaStyle$Format r0 = new com.google.android.exoplayer2.text.ssa.SsaStyle$Format
                int r1 = r1.length
                r5 = r0
                r16 = r1
                r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
                goto L_0x00ce
            L_0x00cd:
                r0 = 0
            L_0x00ce:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ssa.SsaStyle.Format.fromFormatLine(java.lang.String):com.google.android.exoplayer2.text.ssa.SsaStyle$Format");
        }
    }

    static final class Overrides {
        private static final Pattern ALIGNMENT_OVERRIDE_PATTERN = Pattern.compile("\\\\an(\\d+)");
        private static final Pattern BRACES_PATTERN = Pattern.compile("\\{([^}]*)\\}");
        private static final Pattern MOVE_PATTERN = Pattern.compile(Util.formatInvariant("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", PADDED_DECIMAL_PATTERN));
        private static final String PADDED_DECIMAL_PATTERN = "\\s*\\d+(?:\\.\\d+)?\\s*";
        private static final Pattern POSITION_PATTERN = Pattern.compile(Util.formatInvariant("\\\\pos\\((%1$s),(%1$s)\\)", PADDED_DECIMAL_PATTERN));
        private static final String TAG = "SsaStyle.Overrides";
        public final int alignment;
        public final PointF position;

        private Overrides(int i, PointF pointF) {
            this.alignment = i;
            this.position = pointF;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(9:4|5|6|(1:8)|9|10|(2:12|18)(1:17)|15|1) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0021 */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0009 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.google.android.exoplayer2.text.ssa.SsaStyle.Overrides parseFromDialogue(java.lang.String r5) {
            /*
                java.util.regex.Pattern r0 = BRACES_PATTERN
                java.util.regex.Matcher r5 = r0.matcher(r5)
                r0 = -1
                r1 = 0
                r2 = r0
            L_0x0009:
                boolean r3 = r5.find()
                if (r3 == 0) goto L_0x0029
                r3 = 1
                java.lang.String r3 = r5.group(r3)
                java.lang.Object r3 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r3)
                java.lang.String r3 = (java.lang.String) r3
                android.graphics.PointF r4 = parsePosition(r3)     // Catch:{ RuntimeException -> 0x0021 }
                if (r4 == 0) goto L_0x0021
                r1 = r4
            L_0x0021:
                int r3 = parseAlignmentOverride(r3)     // Catch:{ RuntimeException -> 0x0009 }
                if (r3 == r0) goto L_0x0009
                r2 = r3
                goto L_0x0009
            L_0x0029:
                com.google.android.exoplayer2.text.ssa.SsaStyle$Overrides r5 = new com.google.android.exoplayer2.text.ssa.SsaStyle$Overrides
                r5.<init>(r2, r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ssa.SsaStyle.Overrides.parseFromDialogue(java.lang.String):com.google.android.exoplayer2.text.ssa.SsaStyle$Overrides");
        }

        public static String stripStyleOverrides(String str) {
            return BRACES_PATTERN.matcher(str).replaceAll("");
        }

        private static PointF parsePosition(String str) {
            String str2;
            String str3;
            Matcher matcher = POSITION_PATTERN.matcher(str);
            Matcher matcher2 = MOVE_PATTERN.matcher(str);
            boolean find = matcher.find();
            boolean find2 = matcher2.find();
            if (find) {
                if (find2) {
                    Log.i(TAG, "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                str2 = matcher.group(1);
                str3 = matcher.group(2);
            } else if (!find2) {
                return null;
            } else {
                str2 = matcher2.group(1);
                str3 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) Assertions.checkNotNull(str2)).trim()), Float.parseFloat(((String) Assertions.checkNotNull(str3)).trim()));
        }

        private static int parseAlignmentOverride(String str) {
            Matcher matcher = ALIGNMENT_OVERRIDE_PATTERN.matcher(str);
            if (matcher.find()) {
                return SsaStyle.parseAlignment((String) Assertions.checkNotNull(matcher.group(1)));
            }
            return -1;
        }
    }
}

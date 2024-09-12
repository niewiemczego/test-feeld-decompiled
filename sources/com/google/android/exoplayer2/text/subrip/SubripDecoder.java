package com.google.android.exoplayer2.text.subrip;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SubripDecoder extends SimpleSubtitleDecoder {
    private static final String ALIGN_BOTTOM_LEFT = "{\\an1}";
    private static final String ALIGN_BOTTOM_MID = "{\\an2}";
    private static final String ALIGN_BOTTOM_RIGHT = "{\\an3}";
    private static final String ALIGN_MID_LEFT = "{\\an4}";
    private static final String ALIGN_MID_MID = "{\\an5}";
    private static final String ALIGN_MID_RIGHT = "{\\an6}";
    private static final String ALIGN_TOP_LEFT = "{\\an7}";
    private static final String ALIGN_TOP_MID = "{\\an8}";
    private static final String ALIGN_TOP_RIGHT = "{\\an9}";
    private static final float END_FRACTION = 0.92f;
    private static final float MID_FRACTION = 0.5f;
    private static final float START_FRACTION = 0.08f;
    private static final String SUBRIP_ALIGNMENT_TAG = "\\{\\\\an[1-9]\\}";
    private static final Pattern SUBRIP_TAG_PATTERN = Pattern.compile("\\{\\\\.*?\\}");
    private static final String SUBRIP_TIMECODE = "(?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?";
    private static final Pattern SUBRIP_TIMING_LINE = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    private static final String TAG = "SubripDecoder";
    private final ArrayList<String> tags = new ArrayList<>();
    private final StringBuilder textBuilder = new StringBuilder();

    public SubripDecoder() {
        super(TAG);
    }

    /* access modifiers changed from: protected */
    public Subtitle decode(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        while (true) {
            String readLine = parsableByteArray.readLine();
            int i2 = 0;
            if (readLine == null) {
                break;
            } else if (readLine.length() != 0) {
                try {
                    Integer.parseInt(readLine);
                    String readLine2 = parsableByteArray.readLine();
                    if (readLine2 == null) {
                        Log.w(TAG, "Unexpected end");
                        break;
                    }
                    Matcher matcher = SUBRIP_TIMING_LINE.matcher(readLine2);
                    if (matcher.matches()) {
                        longArray.add(parseTimecode(matcher, 1));
                        longArray.add(parseTimecode(matcher, 6));
                        this.textBuilder.setLength(0);
                        this.tags.clear();
                        for (String readLine3 = parsableByteArray.readLine(); !TextUtils.isEmpty(readLine3); readLine3 = parsableByteArray.readLine()) {
                            if (this.textBuilder.length() > 0) {
                                this.textBuilder.append("<br>");
                            }
                            this.textBuilder.append(processLine(readLine3, this.tags));
                        }
                        Spanned fromHtml = Html.fromHtml(this.textBuilder.toString());
                        String str = null;
                        while (true) {
                            if (i2 >= this.tags.size()) {
                                break;
                            }
                            String str2 = this.tags.get(i2);
                            if (str2.matches(SUBRIP_ALIGNMENT_TAG)) {
                                str = str2;
                                break;
                            }
                            i2++;
                        }
                        arrayList.add(buildCue(fromHtml, str));
                        arrayList.add(Cue.EMPTY);
                    } else {
                        Log.w(TAG, "Skipping invalid timing: " + readLine2);
                    }
                } catch (NumberFormatException unused) {
                    Log.w(TAG, "Skipping invalid index: " + readLine);
                }
            }
        }
        return new SubripSubtitle((Cue[]) arrayList.toArray(new Cue[0]), longArray.toArray());
    }

    private String processLine(String str, ArrayList<String> arrayList) {
        String trim = str.trim();
        StringBuilder sb = new StringBuilder(trim);
        Matcher matcher = SUBRIP_TAG_PATTERN.matcher(trim);
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group();
            arrayList.add(group);
            int start = matcher.start() - i;
            int length = group.length();
            sb.replace(start, start + length, "");
            i += length;
        }
        return sb.toString();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.text.Cue buildCue(android.text.Spanned r17, java.lang.String r18) {
        /*
            r16 = this;
            r0 = r18
            com.google.android.exoplayer2.text.Cue$Builder r1 = new com.google.android.exoplayer2.text.Cue$Builder
            r1.<init>()
            r2 = r17
            com.google.android.exoplayer2.text.Cue$Builder r1 = r1.setText(r2)
            if (r0 != 0) goto L_0x0014
            com.google.android.exoplayer2.text.Cue r0 = r1.build()
            return r0
        L_0x0014:
            int r2 = r18.hashCode()
            java.lang.String r6 = "{\\an9}"
            java.lang.String r7 = "{\\an8}"
            java.lang.String r8 = "{\\an7}"
            java.lang.String r9 = "{\\an6}"
            java.lang.String r10 = "{\\an5}"
            java.lang.String r11 = "{\\an4}"
            java.lang.String r12 = "{\\an3}"
            java.lang.String r13 = "{\\an2}"
            java.lang.String r14 = "{\\an1}"
            r4 = 4
            r5 = 3
            r15 = 2
            r3 = 1
            switch(r2) {
                case -685620710: goto L_0x007c;
                case -685620679: goto L_0x0074;
                case -685620648: goto L_0x006c;
                case -685620617: goto L_0x0064;
                case -685620586: goto L_0x005c;
                case -685620555: goto L_0x0054;
                case -685620524: goto L_0x004c;
                case -685620493: goto L_0x0043;
                case -685620462: goto L_0x003b;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x0084
        L_0x003b:
            boolean r2 = r0.equals(r6)
            if (r2 == 0) goto L_0x0084
            r2 = 5
            goto L_0x0085
        L_0x0043:
            boolean r2 = r0.equals(r7)
            if (r2 == 0) goto L_0x0084
            r2 = 8
            goto L_0x0085
        L_0x004c:
            boolean r2 = r0.equals(r8)
            if (r2 == 0) goto L_0x0084
            r2 = r15
            goto L_0x0085
        L_0x0054:
            boolean r2 = r0.equals(r9)
            if (r2 == 0) goto L_0x0084
            r2 = r4
            goto L_0x0085
        L_0x005c:
            boolean r2 = r0.equals(r10)
            if (r2 == 0) goto L_0x0084
            r2 = 7
            goto L_0x0085
        L_0x0064:
            boolean r2 = r0.equals(r11)
            if (r2 == 0) goto L_0x0084
            r2 = r3
            goto L_0x0085
        L_0x006c:
            boolean r2 = r0.equals(r12)
            if (r2 == 0) goto L_0x0084
            r2 = r5
            goto L_0x0085
        L_0x0074:
            boolean r2 = r0.equals(r13)
            if (r2 == 0) goto L_0x0084
            r2 = 6
            goto L_0x0085
        L_0x007c:
            boolean r2 = r0.equals(r14)
            if (r2 == 0) goto L_0x0084
            r2 = 0
            goto L_0x0085
        L_0x0084:
            r2 = -1
        L_0x0085:
            if (r2 == 0) goto L_0x009a
            if (r2 == r3) goto L_0x009a
            if (r2 == r15) goto L_0x009a
            if (r2 == r5) goto L_0x0096
            if (r2 == r4) goto L_0x0096
            r4 = 5
            if (r2 == r4) goto L_0x0096
            r1.setPositionAnchor(r3)
            goto L_0x009e
        L_0x0096:
            r1.setPositionAnchor(r15)
            goto L_0x009e
        L_0x009a:
            r2 = 0
            r1.setPositionAnchor(r2)
        L_0x009e:
            int r2 = r18.hashCode()
            switch(r2) {
                case -685620710: goto L_0x00e7;
                case -685620679: goto L_0x00df;
                case -685620648: goto L_0x00d7;
                case -685620617: goto L_0x00cf;
                case -685620586: goto L_0x00c7;
                case -685620555: goto L_0x00be;
                case -685620524: goto L_0x00b6;
                case -685620493: goto L_0x00ae;
                case -685620462: goto L_0x00a6;
                default: goto L_0x00a5;
            }
        L_0x00a5:
            goto L_0x00ef
        L_0x00a6:
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x00ef
            r0 = 5
            goto L_0x00f0
        L_0x00ae:
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x00ef
            r0 = 4
            goto L_0x00f0
        L_0x00b6:
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x00ef
            r0 = r5
            goto L_0x00f0
        L_0x00be:
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x00ef
            r0 = 8
            goto L_0x00f0
        L_0x00c7:
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x00ef
            r0 = 7
            goto L_0x00f0
        L_0x00cf:
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x00ef
            r0 = 6
            goto L_0x00f0
        L_0x00d7:
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x00ef
            r0 = r15
            goto L_0x00f0
        L_0x00df:
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x00ef
            r0 = r3
            goto L_0x00f0
        L_0x00e7:
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x00ef
            r0 = 0
            goto L_0x00f0
        L_0x00ef:
            r0 = -1
        L_0x00f0:
            if (r0 == 0) goto L_0x0107
            if (r0 == r3) goto L_0x0107
            if (r0 == r15) goto L_0x0107
            if (r0 == r5) goto L_0x0102
            r2 = 4
            if (r0 == r2) goto L_0x0102
            r2 = 5
            if (r0 == r2) goto L_0x0102
            r1.setLineAnchor(r3)
            goto L_0x010a
        L_0x0102:
            r0 = 0
            r1.setLineAnchor(r0)
            goto L_0x010a
        L_0x0107:
            r1.setLineAnchor(r15)
        L_0x010a:
            int r0 = r1.getPositionAnchor()
            float r0 = getFractionalPositionForAnchorType(r0)
            com.google.android.exoplayer2.text.Cue$Builder r0 = r1.setPosition(r0)
            int r1 = r1.getLineAnchor()
            float r1 = getFractionalPositionForAnchorType(r1)
            r2 = 0
            com.google.android.exoplayer2.text.Cue$Builder r0 = r0.setLine(r1, r2)
            com.google.android.exoplayer2.text.Cue r0 = r0.build()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.subrip.SubripDecoder.buildCue(android.text.Spanned, java.lang.String):com.google.android.exoplayer2.text.Cue");
    }

    private static long parseTimecode(Matcher matcher, int i) {
        String group = matcher.group(i + 1);
        long parseLong = (group != null ? Long.parseLong(group) * 60 * 60 * 1000 : 0) + (Long.parseLong((String) Assertions.checkNotNull(matcher.group(i + 2))) * 60 * 1000) + (Long.parseLong((String) Assertions.checkNotNull(matcher.group(i + 3))) * 1000);
        String group2 = matcher.group(i + 4);
        if (group2 != null) {
            parseLong += Long.parseLong(group2);
        }
        return parseLong * 1000;
    }

    static float getFractionalPositionForAnchorType(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return END_FRACTION;
        }
        throw new IllegalArgumentException();
    }
}

package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class RtspSessionTiming {
    public static final RtspSessionTiming DEFAULT = new RtspSessionTiming(0, C.TIME_UNSET);
    private static final long LIVE_START_TIME = 0;
    private static final Pattern NPT_RANGE_PATTERN = Pattern.compile("npt[:=]([.\\d]+|now)\\s?-\\s?([.\\d]+)?");
    private static final String START_TIMING_NTP_FORMAT = "npt=%.3f-";
    public final long startTimeMs;
    public final long stopTimeMs;

    public static RtspSessionTiming parseTiming(String str) throws ParserException {
        long j;
        long j2;
        Matcher matcher = NPT_RANGE_PATTERN.matcher(str);
        RtspMessageUtil.checkManifestExpression(matcher.matches(), str);
        boolean z = true;
        String group = matcher.group(1);
        RtspMessageUtil.checkManifestExpression(group != null, str);
        if (((String) Util.castNonNull(group)).equals("now")) {
            j = 0;
        } else {
            j = (long) (Float.parseFloat(group) * 1000.0f);
        }
        String group2 = matcher.group(2);
        if (group2 != null) {
            try {
                j2 = (long) (Float.parseFloat(group2) * 1000.0f);
                if (j2 < j) {
                    z = false;
                }
                RtspMessageUtil.checkManifestExpression(z, str);
            } catch (NumberFormatException e) {
                throw ParserException.createForMalformedManifest(group2, e);
            }
        } else {
            j2 = C.TIME_UNSET;
        }
        return new RtspSessionTiming(j, j2);
    }

    public static String getOffsetStartTimeTiming(long j) {
        return Util.formatInvariant(START_TIMING_NTP_FORMAT, Double.valueOf(((double) j) / 1000.0d));
    }

    private RtspSessionTiming(long j, long j2) {
        this.startTimeMs = j;
        this.stopTimeMs = j2;
    }

    public boolean isLive() {
        return this.stopTimeMs == C.TIME_UNSET;
    }

    public long getDurationMs() {
        return this.stopTimeMs - this.startTimeMs;
    }
}

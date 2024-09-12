package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.util.Base64;
import android.util.Pair;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

final class RtspMediaTrack {
    private static final String AAC_CODECS_PREFIX = "mp4a.40.";
    private static final int DEFAULT_H263_HEIGHT = 288;
    private static final int DEFAULT_H263_WIDTH = 352;
    private static final int DEFAULT_MP4V_HEIGHT = 288;
    private static final int DEFAULT_MP4V_WIDTH = 352;
    private static final int DEFAULT_VP8_HEIGHT = 240;
    private static final int DEFAULT_VP8_WIDTH = 320;
    private static final int DEFAULT_VP9_HEIGHT = 240;
    private static final int DEFAULT_VP9_WIDTH = 320;
    private static final String GENERIC_CONTROL_ATTR = "*";
    private static final String H264_CODECS_PREFIX = "avc1.";
    private static final String MPEG4_CODECS_PREFIX = "mp4v.";
    private static final int OPUS_CLOCK_RATE = 48000;
    private static final String PARAMETER_AMR_INTERLEAVING = "interleaving";
    private static final String PARAMETER_AMR_OCTET_ALIGN = "octet-align";
    private static final String PARAMETER_H265_SPROP_MAX_DON_DIFF = "sprop-max-don-diff";
    private static final String PARAMETER_H265_SPROP_PPS = "sprop-pps";
    private static final String PARAMETER_H265_SPROP_SPS = "sprop-sps";
    private static final String PARAMETER_H265_SPROP_VPS = "sprop-vps";
    private static final String PARAMETER_MP4V_CONFIG = "config";
    private static final String PARAMETER_PROFILE_LEVEL_ID = "profile-level-id";
    private static final String PARAMETER_SPROP_PARAMS = "sprop-parameter-sets";
    public final RtpPayloadFormat payloadFormat;
    public final Uri uri;

    public RtspMediaTrack(MediaDescription mediaDescription, Uri uri2) {
        Assertions.checkArgument(mediaDescription.attributes.containsKey(SessionDescription.ATTR_CONTROL));
        this.payloadFormat = generatePayloadFormat(mediaDescription);
        this.uri = extractTrackUri(uri2, (String) Util.castNonNull(mediaDescription.attributes.get(SessionDescription.ATTR_CONTROL)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RtspMediaTrack rtspMediaTrack = (RtspMediaTrack) obj;
        if (!this.payloadFormat.equals(rtspMediaTrack.payloadFormat) || !this.uri.equals(rtspMediaTrack.uri)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((JfifUtil.MARKER_EOI + this.payloadFormat.hashCode()) * 31) + this.uri.hashCode();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat generatePayloadFormat(com.google.android.exoplayer2.source.rtsp.MediaDescription r11) {
        /*
            com.google.android.exoplayer2.Format$Builder r0 = new com.google.android.exoplayer2.Format$Builder
            r0.<init>()
            int r1 = r11.bitrate
            if (r1 <= 0) goto L_0x000e
            int r1 = r11.bitrate
            r0.setAverageBitrate(r1)
        L_0x000e:
            com.google.android.exoplayer2.source.rtsp.MediaDescription$RtpMapAttribute r1 = r11.rtpMapAttribute
            int r1 = r1.payloadType
            com.google.android.exoplayer2.source.rtsp.MediaDescription$RtpMapAttribute r2 = r11.rtpMapAttribute
            java.lang.String r2 = r2.mediaEncoding
            java.lang.String r3 = com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat.getMimeTypeFromRtpMediaType(r2)
            r0.setSampleMimeType(r3)
            com.google.android.exoplayer2.source.rtsp.MediaDescription$RtpMapAttribute r4 = r11.rtpMapAttribute
            int r4 = r4.clockRate
            java.lang.String r5 = r11.mediaType
            java.lang.String r6 = "audio"
            boolean r5 = r6.equals(r5)
            r6 = -1
            if (r5 == 0) goto L_0x003c
            com.google.android.exoplayer2.source.rtsp.MediaDescription$RtpMapAttribute r5 = r11.rtpMapAttribute
            int r5 = r5.encodingParameters
            int r5 = inferChannelCount(r5, r3)
            com.google.android.exoplayer2.Format$Builder r7 = r0.setSampleRate(r4)
            r7.setChannelCount(r5)
            goto L_0x003d
        L_0x003c:
            r5 = r6
        L_0x003d:
            com.google.common.collect.ImmutableMap r11 = r11.getFmtpParametersAsMap()
            int r7 = r3.hashCode()
            r8 = 0
            r9 = 1
            switch(r7) {
                case -1664118616: goto L_0x00d9;
                case -1662541442: goto L_0x00cf;
                case -1606874997: goto L_0x00c5;
                case -53558318: goto L_0x00bb;
                case 187078296: goto L_0x00b0;
                case 187094639: goto L_0x00a5;
                case 1187890754: goto L_0x009b;
                case 1331836730: goto L_0x0091;
                case 1503095341: goto L_0x0087;
                case 1504891608: goto L_0x007c;
                case 1599127256: goto L_0x0070;
                case 1599127257: goto L_0x0064;
                case 1903231877: goto L_0x0058;
                case 1903589369: goto L_0x004c;
                default: goto L_0x004a;
            }
        L_0x004a:
            goto L_0x00e3
        L_0x004c:
            java.lang.String r7 = "audio/g711-mlaw"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x00e3
            r3 = 13
            goto L_0x00e4
        L_0x0058:
            java.lang.String r7 = "audio/g711-alaw"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x00e3
            r3 = 12
            goto L_0x00e4
        L_0x0064:
            java.lang.String r7 = "video/x-vnd.on2.vp9"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x00e3
            r3 = 9
            goto L_0x00e4
        L_0x0070:
            java.lang.String r7 = "video/x-vnd.on2.vp8"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x00e3
            r3 = 8
            goto L_0x00e4
        L_0x007c:
            java.lang.String r7 = "audio/opus"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x00e3
            r3 = 3
            goto L_0x00e4
        L_0x0087:
            java.lang.String r7 = "audio/3gpp"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x00e3
            r3 = r9
            goto L_0x00e4
        L_0x0091:
            java.lang.String r7 = "video/avc"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x00e3
            r3 = 6
            goto L_0x00e4
        L_0x009b:
            java.lang.String r7 = "video/mp4v-es"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x00e3
            r3 = 4
            goto L_0x00e4
        L_0x00a5:
            java.lang.String r7 = "audio/raw"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x00e3
            r3 = 10
            goto L_0x00e4
        L_0x00b0:
            java.lang.String r7 = "audio/ac3"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x00e3
            r3 = 11
            goto L_0x00e4
        L_0x00bb:
            java.lang.String r7 = "audio/mp4a-latm"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x00e3
            r3 = r8
            goto L_0x00e4
        L_0x00c5:
            java.lang.String r7 = "audio/amr-wb"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x00e3
            r3 = 2
            goto L_0x00e4
        L_0x00cf:
            java.lang.String r7 = "video/hevc"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x00e3
            r3 = 7
            goto L_0x00e4
        L_0x00d9:
            java.lang.String r7 = "video/3gpp"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x00e3
            r3 = 5
            goto L_0x00e4
        L_0x00e3:
            r3 = r6
        L_0x00e4:
            r7 = 240(0xf0, float:3.36E-43)
            r10 = 320(0x140, float:4.48E-43)
            switch(r3) {
                case 0: goto L_0x017d;
                case 1: goto L_0x0151;
                case 2: goto L_0x0151;
                case 3: goto L_0x013b;
                case 4: goto L_0x012f;
                case 5: goto L_0x0122;
                case 6: goto L_0x0115;
                case 7: goto L_0x0108;
                case 8: goto L_0x00ff;
                case 9: goto L_0x00f6;
                case 10: goto L_0x00ed;
                default: goto L_0x00eb;
            }
        L_0x00eb:
            goto L_0x0190
        L_0x00ed:
            int r2 = com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat.getRawPcmEncodingType(r2)
            r0.setPcmEncoding(r2)
            goto L_0x0190
        L_0x00f6:
            com.google.android.exoplayer2.Format$Builder r2 = r0.setWidth(r10)
            r2.setHeight(r7)
            goto L_0x0190
        L_0x00ff:
            com.google.android.exoplayer2.Format$Builder r2 = r0.setWidth(r10)
            r2.setHeight(r7)
            goto L_0x0190
        L_0x0108:
            boolean r2 = r11.isEmpty()
            r2 = r2 ^ r9
            com.google.android.exoplayer2.util.Assertions.checkArgument(r2)
            processH265FmtpAttribute(r0, r11)
            goto L_0x0190
        L_0x0115:
            boolean r2 = r11.isEmpty()
            r2 = r2 ^ r9
            com.google.android.exoplayer2.util.Assertions.checkArgument(r2)
            processH264FmtpAttribute(r0, r11)
            goto L_0x0190
        L_0x0122:
            r2 = 352(0x160, float:4.93E-43)
            com.google.android.exoplayer2.Format$Builder r2 = r0.setWidth(r2)
            r3 = 288(0x120, float:4.04E-43)
            r2.setHeight(r3)
            goto L_0x0190
        L_0x012f:
            boolean r2 = r11.isEmpty()
            r2 = r2 ^ r9
            com.google.android.exoplayer2.util.Assertions.checkArgument(r2)
            processMPEG4FmtpAttribute(r0, r11)
            goto L_0x0190
        L_0x013b:
            if (r5 == r6) goto L_0x013f
            r2 = r9
            goto L_0x0140
        L_0x013f:
            r2 = r8
        L_0x0140:
            com.google.android.exoplayer2.util.Assertions.checkArgument(r2)
            r2 = 48000(0xbb80, float:6.7262E-41)
            if (r4 != r2) goto L_0x014a
            r2 = r9
            goto L_0x014b
        L_0x014a:
            r2 = r8
        L_0x014b:
            java.lang.String r3 = "Invalid OPUS clock rate."
            com.google.android.exoplayer2.util.Assertions.checkArgument(r2, r3)
            goto L_0x0190
        L_0x0151:
            if (r5 != r9) goto L_0x0155
            r2 = r9
            goto L_0x0156
        L_0x0155:
            r2 = r8
        L_0x0156:
            java.lang.String r3 = "Multi channel AMR is not currently supported."
            com.google.android.exoplayer2.util.Assertions.checkArgument(r2, r3)
            boolean r2 = r11.isEmpty()
            r2 = r2 ^ r9
            java.lang.String r3 = "fmtp parameters must include octet-align."
            com.google.android.exoplayer2.util.Assertions.checkArgument(r2, r3)
            java.lang.String r2 = "octet-align"
            boolean r2 = r11.containsKey(r2)
            java.lang.String r3 = "Only octet aligned mode is currently supported."
            com.google.android.exoplayer2.util.Assertions.checkArgument(r2, r3)
            java.lang.String r2 = "interleaving"
            boolean r2 = r11.containsKey(r2)
            r2 = r2 ^ r9
            java.lang.String r3 = "Interleaving mode is not currently supported."
            com.google.android.exoplayer2.util.Assertions.checkArgument(r2, r3)
            goto L_0x0190
        L_0x017d:
            if (r5 == r6) goto L_0x0181
            r2 = r9
            goto L_0x0182
        L_0x0181:
            r2 = r8
        L_0x0182:
            com.google.android.exoplayer2.util.Assertions.checkArgument(r2)
            boolean r2 = r11.isEmpty()
            r2 = r2 ^ r9
            com.google.android.exoplayer2.util.Assertions.checkArgument(r2)
            processAacFmtpAttribute(r0, r11, r5, r4)
        L_0x0190:
            if (r4 <= 0) goto L_0x0193
            r8 = r9
        L_0x0193:
            com.google.android.exoplayer2.util.Assertions.checkArgument(r8)
            com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat r2 = new com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat
            com.google.android.exoplayer2.Format r0 = r0.build()
            r2.<init>(r0, r1, r4, r11)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.rtsp.RtspMediaTrack.generatePayloadFormat(com.google.android.exoplayer2.source.rtsp.MediaDescription):com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat");
    }

    private static int inferChannelCount(int i, String str) {
        if (i != -1) {
            return i;
        }
        return str.equals(MimeTypes.AUDIO_AC3) ? 6 : 1;
    }

    private static void processAacFmtpAttribute(Format.Builder builder, ImmutableMap<String, String> immutableMap, int i, int i2) {
        Assertions.checkArgument(immutableMap.containsKey(PARAMETER_PROFILE_LEVEL_ID));
        builder.setCodecs(AAC_CODECS_PREFIX + ((String) Assertions.checkNotNull(immutableMap.get(PARAMETER_PROFILE_LEVEL_ID))));
        builder.setInitializationData(ImmutableList.of(AacUtil.buildAacLcAudioSpecificConfig(i2, i)));
    }

    private static void processMPEG4FmtpAttribute(Format.Builder builder, ImmutableMap<String, String> immutableMap) {
        String str = immutableMap.get(PARAMETER_MP4V_CONFIG);
        if (str != null) {
            byte[] bytesFromHexString = Util.getBytesFromHexString(str);
            builder.setInitializationData(ImmutableList.of(bytesFromHexString));
            Pair<Integer, Integer> videoResolutionFromMpeg4VideoConfig = CodecSpecificDataUtil.getVideoResolutionFromMpeg4VideoConfig(bytesFromHexString);
            builder.setWidth(((Integer) videoResolutionFromMpeg4VideoConfig.first).intValue()).setHeight(((Integer) videoResolutionFromMpeg4VideoConfig.second).intValue());
        } else {
            builder.setWidth(352).setHeight(288);
        }
        String str2 = immutableMap.get(PARAMETER_PROFILE_LEVEL_ID);
        StringBuilder append = new StringBuilder().append(MPEG4_CODECS_PREFIX);
        if (str2 == null) {
            str2 = "1";
        }
        builder.setCodecs(append.append(str2).toString());
    }

    private static byte[] getInitializationDataFromParameterSet(String str) {
        byte[] decode = Base64.decode(str, 0);
        byte[] bArr = new byte[(decode.length + NalUnitUtil.NAL_START_CODE.length)];
        System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, bArr, 0, NalUnitUtil.NAL_START_CODE.length);
        System.arraycopy(decode, 0, bArr, NalUnitUtil.NAL_START_CODE.length, decode.length);
        return bArr;
    }

    private static void processH264FmtpAttribute(Format.Builder builder, ImmutableMap<String, String> immutableMap) {
        Assertions.checkArgument(immutableMap.containsKey(PARAMETER_SPROP_PARAMS));
        String[] split = Util.split((String) Assertions.checkNotNull(immutableMap.get(PARAMETER_SPROP_PARAMS)), ",");
        Assertions.checkArgument(split.length == 2);
        ImmutableList of = ImmutableList.of(getInitializationDataFromParameterSet(split[0]), getInitializationDataFromParameterSet(split[1]));
        builder.setInitializationData(of);
        byte[] bArr = (byte[]) of.get(0);
        NalUnitUtil.SpsData parseSpsNalUnit = NalUnitUtil.parseSpsNalUnit(bArr, NalUnitUtil.NAL_START_CODE.length, bArr.length);
        builder.setPixelWidthHeightRatio(parseSpsNalUnit.pixelWidthHeightRatio);
        builder.setHeight(parseSpsNalUnit.height);
        builder.setWidth(parseSpsNalUnit.width);
        String str = immutableMap.get(PARAMETER_PROFILE_LEVEL_ID);
        if (str != null) {
            builder.setCodecs(H264_CODECS_PREFIX + str);
        } else {
            builder.setCodecs(CodecSpecificDataUtil.buildAvcCodecString(parseSpsNalUnit.profileIdc, parseSpsNalUnit.constraintsFlagsAndReservedZero2Bits, parseSpsNalUnit.levelIdc));
        }
    }

    private static void processH265FmtpAttribute(Format.Builder builder, ImmutableMap<String, String> immutableMap) {
        if (immutableMap.containsKey(PARAMETER_H265_SPROP_MAX_DON_DIFF)) {
            int parseInt = Integer.parseInt((String) Assertions.checkNotNull(immutableMap.get(PARAMETER_H265_SPROP_MAX_DON_DIFF)));
            Assertions.checkArgument(parseInt == 0, "non-zero sprop-max-don-diff " + parseInt + " is not supported");
        }
        Assertions.checkArgument(immutableMap.containsKey(PARAMETER_H265_SPROP_VPS));
        Assertions.checkArgument(immutableMap.containsKey(PARAMETER_H265_SPROP_SPS));
        Assertions.checkArgument(immutableMap.containsKey(PARAMETER_H265_SPROP_PPS));
        ImmutableList of = ImmutableList.of(getInitializationDataFromParameterSet((String) Assertions.checkNotNull(immutableMap.get(PARAMETER_H265_SPROP_VPS))), getInitializationDataFromParameterSet((String) Assertions.checkNotNull(immutableMap.get(PARAMETER_H265_SPROP_SPS))), getInitializationDataFromParameterSet((String) Assertions.checkNotNull(immutableMap.get(PARAMETER_H265_SPROP_PPS))));
        builder.setInitializationData(of);
        byte[] bArr = (byte[]) of.get(1);
        NalUnitUtil.H265SpsData parseH265SpsNalUnit = NalUnitUtil.parseH265SpsNalUnit(bArr, NalUnitUtil.NAL_START_CODE.length, bArr.length);
        builder.setPixelWidthHeightRatio(parseH265SpsNalUnit.pixelWidthHeightRatio);
        builder.setHeight(parseH265SpsNalUnit.height).setWidth(parseH265SpsNalUnit.width);
        builder.setCodecs(CodecSpecificDataUtil.buildHevcCodecString(parseH265SpsNalUnit.generalProfileSpace, parseH265SpsNalUnit.generalTierFlag, parseH265SpsNalUnit.generalProfileIdc, parseH265SpsNalUnit.generalProfileCompatibilityFlags, parseH265SpsNalUnit.constraintBytes, parseH265SpsNalUnit.generalLevelIdc));
    }

    private static Uri extractTrackUri(Uri uri2, String str) {
        Uri parse = Uri.parse(str);
        if (parse.isAbsolute()) {
            return parse;
        }
        if (str.equals("*")) {
            return uri2;
        }
        return uri2.buildUpon().appendEncodedPath(str).build();
    }
}

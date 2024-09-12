package com.google.android.exoplayer2.util;

import android.net.Uri;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;

public final class FileTypes {
    public static final int AC3 = 0;
    public static final int AC4 = 1;
    public static final int ADTS = 2;
    public static final int AMR = 3;
    public static final int AVI = 16;
    private static final String EXTENSION_AAC = ".aac";
    private static final String EXTENSION_AC3 = ".ac3";
    private static final String EXTENSION_AC4 = ".ac4";
    private static final String EXTENSION_ADTS = ".adts";
    private static final String EXTENSION_AMR = ".amr";
    private static final String EXTENSION_AVI = ".avi";
    private static final String EXTENSION_EC3 = ".ec3";
    private static final String EXTENSION_FLAC = ".flac";
    private static final String EXTENSION_FLV = ".flv";
    private static final String EXTENSION_JPEG = ".jpeg";
    private static final String EXTENSION_JPG = ".jpg";
    private static final String EXTENSION_M2P = ".m2p";
    private static final String EXTENSION_MID = ".mid";
    private static final String EXTENSION_MIDI = ".midi";
    private static final String EXTENSION_MP3 = ".mp3";
    private static final String EXTENSION_MP4 = ".mp4";
    private static final String EXTENSION_MPEG = ".mpeg";
    private static final String EXTENSION_MPG = ".mpg";
    private static final String EXTENSION_OPUS = ".opus";
    private static final String EXTENSION_PREFIX_CMF = ".cmf";
    private static final String EXTENSION_PREFIX_M4 = ".m4";
    private static final String EXTENSION_PREFIX_MK = ".mk";
    private static final String EXTENSION_PREFIX_MP4 = ".mp4";
    private static final String EXTENSION_PREFIX_OG = ".og";
    private static final String EXTENSION_PREFIX_TS = ".ts";
    private static final String EXTENSION_PS = ".ps";
    private static final String EXTENSION_SMF = ".smf";
    private static final String EXTENSION_TS = ".ts";
    private static final String EXTENSION_VTT = ".vtt";
    private static final String EXTENSION_WAV = ".wav";
    private static final String EXTENSION_WAVE = ".wave";
    private static final String EXTENSION_WEBM = ".webm";
    private static final String EXTENSION_WEBVTT = ".webvtt";
    public static final int FLAC = 4;
    public static final int FLV = 5;
    static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final int JPEG = 14;
    public static final int MATROSKA = 6;
    public static final int MIDI = 15;
    public static final int MP3 = 7;
    public static final int MP4 = 8;
    public static final int OGG = 9;
    public static final int PS = 10;
    public static final int TS = 11;
    public static final int UNKNOWN = -1;
    public static final int WAV = 12;
    public static final int WEBVTT = 13;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private FileTypes() {
    }

    public static int inferFileTypeFromResponseHeaders(Map<String, List<String>> map) {
        List list = map.get("Content-Type");
        return inferFileTypeFromMimeType((list == null || list.isEmpty()) ? null : (String) list.get(0));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int inferFileTypeFromMimeType(java.lang.String r19) {
        /*
            r0 = -1
            if (r19 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = com.google.android.exoplayer2.util.MimeTypes.normalizeMimeType(r19)
            r1.hashCode()
            int r2 = r1.hashCode()
            r3 = 16
            r4 = 15
            r5 = 14
            r6 = 13
            r7 = 12
            r8 = 11
            r9 = 10
            r10 = 9
            r11 = 8
            r12 = 7
            r13 = 6
            r14 = 5
            r15 = 4
            r16 = 3
            r17 = 1
            r18 = 0
            switch(r2) {
                case -2123537834: goto L_0x0171;
                case -1662384011: goto L_0x0164;
                case -1662384007: goto L_0x0158;
                case -1662095187: goto L_0x014b;
                case -1606874997: goto L_0x013f;
                case -1487394660: goto L_0x0133;
                case -1248337486: goto L_0x0127;
                case -1079884372: goto L_0x011b;
                case -1004728940: goto L_0x010e;
                case -387023398: goto L_0x0101;
                case -43467528: goto L_0x00f4;
                case 13915911: goto L_0x00e7;
                case 187078296: goto L_0x00da;
                case 187078297: goto L_0x00cd;
                case 187078669: goto L_0x00c0;
                case 187090232: goto L_0x00b3;
                case 187091926: goto L_0x00a6;
                case 187099443: goto L_0x0099;
                case 1331848029: goto L_0x008c;
                case 1503095341: goto L_0x007f;
                case 1504578661: goto L_0x0072;
                case 1504619009: goto L_0x0065;
                case 1504824762: goto L_0x0058;
                case 1504831518: goto L_0x004b;
                case 1505118770: goto L_0x003e;
                case 2039520277: goto L_0x0031;
                default: goto L_0x002e;
            }
        L_0x002e:
            r1 = r0
            goto L_0x017d
        L_0x0031:
            java.lang.String r2 = "video/x-matroska"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x003a
            goto L_0x002e
        L_0x003a:
            r1 = 25
            goto L_0x017d
        L_0x003e:
            java.lang.String r2 = "audio/webm"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0047
            goto L_0x002e
        L_0x0047:
            r1 = 24
            goto L_0x017d
        L_0x004b:
            java.lang.String r2 = "audio/mpeg"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0054
            goto L_0x002e
        L_0x0054:
            r1 = 23
            goto L_0x017d
        L_0x0058:
            java.lang.String r2 = "audio/midi"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0061
            goto L_0x002e
        L_0x0061:
            r1 = 22
            goto L_0x017d
        L_0x0065:
            java.lang.String r2 = "audio/flac"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x006e
            goto L_0x002e
        L_0x006e:
            r1 = 21
            goto L_0x017d
        L_0x0072:
            java.lang.String r2 = "audio/eac3"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x007b
            goto L_0x002e
        L_0x007b:
            r1 = 20
            goto L_0x017d
        L_0x007f:
            java.lang.String r2 = "audio/3gpp"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0088
            goto L_0x002e
        L_0x0088:
            r1 = 19
            goto L_0x017d
        L_0x008c:
            java.lang.String r2 = "video/mp4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0095
            goto L_0x002e
        L_0x0095:
            r1 = 18
            goto L_0x017d
        L_0x0099:
            java.lang.String r2 = "audio/wav"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00a2
            goto L_0x002e
        L_0x00a2:
            r1 = 17
            goto L_0x017d
        L_0x00a6:
            java.lang.String r2 = "audio/ogg"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00b0
            goto L_0x002e
        L_0x00b0:
            r1 = r3
            goto L_0x017d
        L_0x00b3:
            java.lang.String r2 = "audio/mp4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00bd
            goto L_0x002e
        L_0x00bd:
            r1 = r4
            goto L_0x017d
        L_0x00c0:
            java.lang.String r2 = "audio/amr"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00ca
            goto L_0x002e
        L_0x00ca:
            r1 = r5
            goto L_0x017d
        L_0x00cd:
            java.lang.String r2 = "audio/ac4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00d7
            goto L_0x002e
        L_0x00d7:
            r1 = r6
            goto L_0x017d
        L_0x00da:
            java.lang.String r2 = "audio/ac3"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00e4
            goto L_0x002e
        L_0x00e4:
            r1 = r7
            goto L_0x017d
        L_0x00e7:
            java.lang.String r2 = "video/x-flv"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00f1
            goto L_0x002e
        L_0x00f1:
            r1 = r8
            goto L_0x017d
        L_0x00f4:
            java.lang.String r2 = "application/webm"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00fe
            goto L_0x002e
        L_0x00fe:
            r1 = r9
            goto L_0x017d
        L_0x0101:
            java.lang.String r2 = "audio/x-matroska"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x010b
            goto L_0x002e
        L_0x010b:
            r1 = r10
            goto L_0x017d
        L_0x010e:
            java.lang.String r2 = "text/vtt"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0118
            goto L_0x002e
        L_0x0118:
            r1 = r11
            goto L_0x017d
        L_0x011b:
            java.lang.String r2 = "video/x-msvideo"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0125
            goto L_0x002e
        L_0x0125:
            r1 = r12
            goto L_0x017d
        L_0x0127:
            java.lang.String r2 = "application/mp4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0131
            goto L_0x002e
        L_0x0131:
            r1 = r13
            goto L_0x017d
        L_0x0133:
            java.lang.String r2 = "image/jpeg"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x013d
            goto L_0x002e
        L_0x013d:
            r1 = r14
            goto L_0x017d
        L_0x013f:
            java.lang.String r2 = "audio/amr-wb"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0149
            goto L_0x002e
        L_0x0149:
            r1 = r15
            goto L_0x017d
        L_0x014b:
            java.lang.String r2 = "video/webm"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0155
            goto L_0x002e
        L_0x0155:
            r1 = r16
            goto L_0x017d
        L_0x0158:
            java.lang.String r2 = "video/mp2t"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0162
            goto L_0x002e
        L_0x0162:
            r1 = 2
            goto L_0x017d
        L_0x0164:
            java.lang.String r2 = "video/mp2p"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x016e
            goto L_0x002e
        L_0x016e:
            r1 = r17
            goto L_0x017d
        L_0x0171:
            java.lang.String r2 = "audio/eac3-joc"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x017b
            goto L_0x002e
        L_0x017b:
            r1 = r18
        L_0x017d:
            switch(r1) {
                case 0: goto L_0x0190;
                case 1: goto L_0x018f;
                case 2: goto L_0x018e;
                case 3: goto L_0x018d;
                case 4: goto L_0x018c;
                case 5: goto L_0x018b;
                case 6: goto L_0x018a;
                case 7: goto L_0x0189;
                case 8: goto L_0x0188;
                case 9: goto L_0x018d;
                case 10: goto L_0x018d;
                case 11: goto L_0x0187;
                case 12: goto L_0x0190;
                case 13: goto L_0x0186;
                case 14: goto L_0x018c;
                case 15: goto L_0x018a;
                case 16: goto L_0x0185;
                case 17: goto L_0x0184;
                case 18: goto L_0x018a;
                case 19: goto L_0x018c;
                case 20: goto L_0x0190;
                case 21: goto L_0x0183;
                case 22: goto L_0x0182;
                case 23: goto L_0x0181;
                case 24: goto L_0x018d;
                case 25: goto L_0x018d;
                default: goto L_0x0180;
            }
        L_0x0180:
            return r0
        L_0x0181:
            return r12
        L_0x0182:
            return r4
        L_0x0183:
            return r15
        L_0x0184:
            return r7
        L_0x0185:
            return r10
        L_0x0186:
            return r17
        L_0x0187:
            return r14
        L_0x0188:
            return r6
        L_0x0189:
            return r3
        L_0x018a:
            return r11
        L_0x018b:
            return r5
        L_0x018c:
            return r16
        L_0x018d:
            return r13
        L_0x018e:
            return r8
        L_0x018f:
            return r9
        L_0x0190:
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.FileTypes.inferFileTypeFromMimeType(java.lang.String):int");
    }

    public static int inferFileTypeFromUri(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(EXTENSION_AC3) || lastPathSegment.endsWith(EXTENSION_EC3)) {
            return 0;
        }
        if (lastPathSegment.endsWith(EXTENSION_AC4)) {
            return 1;
        }
        if (lastPathSegment.endsWith(EXTENSION_ADTS) || lastPathSegment.endsWith(EXTENSION_AAC)) {
            return 2;
        }
        if (lastPathSegment.endsWith(EXTENSION_AMR)) {
            return 3;
        }
        if (lastPathSegment.endsWith(EXTENSION_FLAC)) {
            return 4;
        }
        if (lastPathSegment.endsWith(EXTENSION_FLV)) {
            return 5;
        }
        if (lastPathSegment.endsWith(EXTENSION_MID) || lastPathSegment.endsWith(EXTENSION_MIDI) || lastPathSegment.endsWith(EXTENSION_SMF)) {
            return 15;
        }
        if (lastPathSegment.startsWith(EXTENSION_PREFIX_MK, lastPathSegment.length() - 4) || lastPathSegment.endsWith(EXTENSION_WEBM)) {
            return 6;
        }
        if (lastPathSegment.endsWith(EXTENSION_MP3)) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(EXTENSION_PREFIX_M4, lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(EXTENSION_PREFIX_CMF, lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(EXTENSION_PREFIX_OG, lastPathSegment.length() - 4) || lastPathSegment.endsWith(EXTENSION_OPUS)) {
            return 9;
        }
        if (lastPathSegment.endsWith(EXTENSION_PS) || lastPathSegment.endsWith(EXTENSION_MPEG) || lastPathSegment.endsWith(EXTENSION_MPG) || lastPathSegment.endsWith(EXTENSION_M2P)) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(EXTENSION_WAV) || lastPathSegment.endsWith(EXTENSION_WAVE)) {
            return 12;
        }
        if (lastPathSegment.endsWith(EXTENSION_VTT) || lastPathSegment.endsWith(EXTENSION_WEBVTT)) {
            return 13;
        }
        if (lastPathSegment.endsWith(EXTENSION_JPG) || lastPathSegment.endsWith(EXTENSION_JPEG)) {
            return 14;
        }
        if (lastPathSegment.endsWith(EXTENSION_AVI)) {
            return 16;
        }
        return -1;
    }
}

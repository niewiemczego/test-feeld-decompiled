package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.Iterables;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

public final class HlsPlaylistParser implements ParsingLoadable.Parser<HlsPlaylist> {
    private static final String ATTR_CLOSED_CAPTIONS_NONE = "CLOSED-CAPTIONS=NONE";
    private static final String BOOLEAN_FALSE = "NO";
    private static final String BOOLEAN_TRUE = "YES";
    private static final String KEYFORMAT_IDENTITY = "identity";
    private static final String KEYFORMAT_PLAYREADY = "com.microsoft.playready";
    private static final String KEYFORMAT_WIDEVINE_PSSH_BINARY = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
    private static final String KEYFORMAT_WIDEVINE_PSSH_JSON = "com.widevine";
    private static final String LOG_TAG = "HlsPlaylistParser";
    private static final String METHOD_AES_128 = "AES-128";
    private static final String METHOD_NONE = "NONE";
    private static final String METHOD_SAMPLE_AES = "SAMPLE-AES";
    private static final String METHOD_SAMPLE_AES_CENC = "SAMPLE-AES-CENC";
    private static final String METHOD_SAMPLE_AES_CTR = "SAMPLE-AES-CTR";
    private static final String PLAYLIST_HEADER = "#EXTM3U";
    private static final Pattern REGEX_ATTR_BYTERANGE = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern REGEX_ATTR_DURATION = Pattern.compile("DURATION=([\\d\\.]+)\\b");
    private static final Pattern REGEX_AUDIO = Pattern.compile("AUDIO=\"(.+?)\"");
    private static final Pattern REGEX_AUTOSELECT = compileBooleanAttrPattern("AUTOSELECT");
    private static final Pattern REGEX_AVERAGE_BANDWIDTH = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern REGEX_BANDWIDTH = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern REGEX_BYTERANGE = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern REGEX_BYTERANGE_LENGTH = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    private static final Pattern REGEX_BYTERANGE_START = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    private static final Pattern REGEX_CAN_BLOCK_RELOAD = compileBooleanAttrPattern("CAN-BLOCK-RELOAD");
    private static final Pattern REGEX_CAN_SKIP_DATE_RANGES = compileBooleanAttrPattern("CAN-SKIP-DATERANGES");
    private static final Pattern REGEX_CAN_SKIP_UNTIL = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
    private static final Pattern REGEX_CHANNELS = Pattern.compile("CHANNELS=\"(.+?)\"");
    private static final Pattern REGEX_CHARACTERISTICS = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern REGEX_CLOSED_CAPTIONS = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
    private static final Pattern REGEX_CODECS = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern REGEX_DEFAULT = compileBooleanAttrPattern("DEFAULT");
    private static final Pattern REGEX_FORCED = compileBooleanAttrPattern("FORCED");
    private static final Pattern REGEX_FRAME_RATE = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    private static final Pattern REGEX_GAP = compileBooleanAttrPattern("GAP");
    private static final Pattern REGEX_GROUP_ID = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern REGEX_HOLD_BACK = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern REGEX_IMPORT = Pattern.compile("IMPORT=\"(.+?)\"");
    private static final Pattern REGEX_INDEPENDENT = compileBooleanAttrPattern("INDEPENDENT");
    private static final Pattern REGEX_INSTREAM_ID = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern REGEX_IV = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern REGEX_KEYFORMAT = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern REGEX_KEYFORMATVERSIONS = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern REGEX_LANGUAGE = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern REGEX_LAST_MSN = Pattern.compile("LAST-MSN=(\\d+)\\b");
    private static final Pattern REGEX_LAST_PART = Pattern.compile("LAST-PART=(\\d+)\\b");
    private static final Pattern REGEX_MEDIA_DURATION = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern REGEX_MEDIA_SEQUENCE = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern REGEX_MEDIA_TITLE = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    private static final Pattern REGEX_METHOD = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern REGEX_NAME = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern REGEX_PART_HOLD_BACK = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern REGEX_PART_TARGET_DURATION = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
    private static final Pattern REGEX_PLAYLIST_TYPE = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern REGEX_PRECISE = compileBooleanAttrPattern("PRECISE");
    private static final Pattern REGEX_PRELOAD_HINT_TYPE = Pattern.compile("TYPE=(PART|MAP)");
    private static final Pattern REGEX_RESOLUTION = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern REGEX_SKIPPED_SEGMENTS = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
    private static final Pattern REGEX_SUBTITLES = Pattern.compile("SUBTITLES=\"(.+?)\"");
    private static final Pattern REGEX_TARGET_DURATION = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern REGEX_TIME_OFFSET = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern REGEX_TYPE = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern REGEX_URI = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern REGEX_VALUE = Pattern.compile("VALUE=\"(.+?)\"");
    private static final Pattern REGEX_VARIABLE_REFERENCE = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");
    private static final Pattern REGEX_VERSION = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern REGEX_VIDEO = Pattern.compile("VIDEO=\"(.+?)\"");
    private static final String TAG_BYTERANGE = "#EXT-X-BYTERANGE";
    private static final String TAG_DEFINE = "#EXT-X-DEFINE";
    private static final String TAG_DISCONTINUITY = "#EXT-X-DISCONTINUITY";
    private static final String TAG_DISCONTINUITY_SEQUENCE = "#EXT-X-DISCONTINUITY-SEQUENCE";
    private static final String TAG_ENDLIST = "#EXT-X-ENDLIST";
    private static final String TAG_GAP = "#EXT-X-GAP";
    private static final String TAG_IFRAME = "#EXT-X-I-FRAMES-ONLY";
    private static final String TAG_INDEPENDENT_SEGMENTS = "#EXT-X-INDEPENDENT-SEGMENTS";
    private static final String TAG_INIT_SEGMENT = "#EXT-X-MAP";
    private static final String TAG_I_FRAME_STREAM_INF = "#EXT-X-I-FRAME-STREAM-INF";
    private static final String TAG_KEY = "#EXT-X-KEY";
    private static final String TAG_MEDIA = "#EXT-X-MEDIA";
    private static final String TAG_MEDIA_DURATION = "#EXTINF";
    private static final String TAG_MEDIA_SEQUENCE = "#EXT-X-MEDIA-SEQUENCE";
    private static final String TAG_PART = "#EXT-X-PART";
    private static final String TAG_PART_INF = "#EXT-X-PART-INF";
    private static final String TAG_PLAYLIST_TYPE = "#EXT-X-PLAYLIST-TYPE";
    private static final String TAG_PREFIX = "#EXT";
    private static final String TAG_PRELOAD_HINT = "#EXT-X-PRELOAD-HINT";
    private static final String TAG_PROGRAM_DATE_TIME = "#EXT-X-PROGRAM-DATE-TIME";
    private static final String TAG_RENDITION_REPORT = "#EXT-X-RENDITION-REPORT";
    private static final String TAG_SERVER_CONTROL = "#EXT-X-SERVER-CONTROL";
    private static final String TAG_SESSION_KEY = "#EXT-X-SESSION-KEY";
    private static final String TAG_SKIP = "#EXT-X-SKIP";
    private static final String TAG_START = "#EXT-X-START";
    private static final String TAG_STREAM_INF = "#EXT-X-STREAM-INF";
    private static final String TAG_TARGET_DURATION = "#EXT-X-TARGETDURATION";
    private static final String TAG_VERSION = "#EXT-X-VERSION";
    private static final String TYPE_AUDIO = "AUDIO";
    private static final String TYPE_CLOSED_CAPTIONS = "CLOSED-CAPTIONS";
    private static final String TYPE_MAP = "MAP";
    private static final String TYPE_PART = "PART";
    private static final String TYPE_SUBTITLES = "SUBTITLES";
    private static final String TYPE_VIDEO = "VIDEO";
    private final HlsMultivariantPlaylist multivariantPlaylist;
    private final HlsMediaPlaylist previousMediaPlaylist;

    public static final class DeltaUpdateException extends IOException {
    }

    public HlsPlaylistParser() {
        this(HlsMultivariantPlaylist.EMPTY, (HlsMediaPlaylist) null);
    }

    public HlsPlaylistParser(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        this.multivariantPlaylist = hlsMultivariantPlaylist;
        this.previousMediaPlaylist = hlsMediaPlaylist;
    }

    public HlsPlaylist parse(Uri uri, InputStream inputStream) throws IOException {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (checkPlaylistHeader(bufferedReader)) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        trim = readLine.trim();
                        if (!trim.isEmpty()) {
                            if (!trim.startsWith(TAG_STREAM_INF)) {
                                if (trim.startsWith(TAG_TARGET_DURATION) || trim.startsWith(TAG_MEDIA_SEQUENCE) || trim.startsWith(TAG_MEDIA_DURATION) || trim.startsWith(TAG_KEY) || trim.startsWith(TAG_BYTERANGE) || trim.equals(TAG_DISCONTINUITY) || trim.equals(TAG_DISCONTINUITY_SEQUENCE)) {
                                    break;
                                } else if (trim.equals(TAG_ENDLIST)) {
                                    break;
                                } else {
                                    arrayDeque.add(trim);
                                }
                            } else {
                                arrayDeque.add(trim);
                                HlsMultivariantPlaylist parseMultivariantPlaylist = parseMultivariantPlaylist(new LineIterator(arrayDeque, bufferedReader), uri.toString());
                                Util.closeQuietly(bufferedReader);
                                return parseMultivariantPlaylist;
                            }
                        }
                    } else {
                        Util.closeQuietly(bufferedReader);
                        throw ParserException.createForMalformedManifest("Failed to parse the playlist, could not identify any tags.", (Throwable) null);
                    }
                }
                arrayDeque.add(trim);
                return parseMediaPlaylist(this.multivariantPlaylist, this.previousMediaPlaylist, new LineIterator(arrayDeque, bufferedReader), uri.toString());
            }
            throw ParserException.createForMalformedManifest("Input does not start with the #EXTM3U header.", (Throwable) null);
        } finally {
            Util.closeQuietly(bufferedReader);
        }
    }

    private static boolean checkPlaylistHeader(BufferedReader bufferedReader) throws IOException {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int skipIgnorableWhitespace = skipIgnorableWhitespace(bufferedReader, true, read);
        for (int i = 0; i < 7; i++) {
            if (skipIgnorableWhitespace != PLAYLIST_HEADER.charAt(i)) {
                return false;
            }
            skipIgnorableWhitespace = bufferedReader.read();
        }
        return Util.isLinebreak(skipIgnorableWhitespace(bufferedReader, false, skipIgnorableWhitespace));
    }

    private static int skipIgnorableWhitespace(BufferedReader bufferedReader, boolean z, int i) throws IOException {
        while (i != -1 && Character.isWhitespace(i) && (z || !Util.isLinebreak(i))) {
            i = bufferedReader.read();
        }
        return i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x045f, code lost:
        r6 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x04a7, code lost:
        r0 = r0 + 1;
        r31 = r6;
        r32 = r9;
        r33 = r14;
        r15 = r20;
        r9 = r21;
        r8 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist parseMultivariantPlaylist(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.LineIterator r36, java.lang.String r37) throws java.io.IOException {
        /*
            r1 = r37
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r10 = 0
            r13 = 0
        L_0x0036:
            boolean r14 = r36.hasNext()
            java.lang.String r15 = "application/x-mpegURL"
            if (r14 == 0) goto L_0x021b
            java.lang.String r14 = r36.next()
            java.lang.String r9 = "#EXT"
            boolean r9 = r14.startsWith(r9)
            if (r9 == 0) goto L_0x004d
            r8.add(r14)
        L_0x004d:
            java.lang.String r9 = "#EXT-X-I-FRAME-STREAM-INF"
            boolean r9 = r14.startsWith(r9)
            r19 = r10
            java.lang.String r10 = "#EXT-X-DEFINE"
            boolean r10 = r14.startsWith(r10)
            if (r10 == 0) goto L_0x006d
            java.util.regex.Pattern r9 = REGEX_NAME
            java.lang.String r9 = parseStringAttr(r14, r9, r11)
            java.util.regex.Pattern r10 = REGEX_VALUE
            java.lang.String r10 = parseStringAttr(r14, r10, r11)
            r11.put(r9, r10)
            goto L_0x00ce
        L_0x006d:
            java.lang.String r10 = "#EXT-X-INDEPENDENT-SEGMENTS"
            boolean r10 = r14.equals(r10)
            if (r10 == 0) goto L_0x0087
            r1 = r0
            r34 = r3
            r33 = r4
            r32 = r5
            r31 = r6
            r29 = r7
            r30 = r8
            r28 = r12
            r10 = 1
            goto L_0x0200
        L_0x0087:
            java.lang.String r10 = "#EXT-X-MEDIA"
            boolean r10 = r14.startsWith(r10)
            if (r10 == 0) goto L_0x0093
            r3.add(r14)
            goto L_0x00ce
        L_0x0093:
            java.lang.String r10 = "#EXT-X-SESSION-KEY"
            boolean r10 = r14.startsWith(r10)
            if (r10 == 0) goto L_0x00c3
            java.util.regex.Pattern r9 = REGEX_KEYFORMAT
            java.lang.String r10 = "identity"
            java.lang.String r9 = parseOptionalStringAttr(r14, r9, r10, r11)
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r9 = parseDrmSchemeData(r14, r9, r11)
            if (r9 == 0) goto L_0x00ce
            java.util.regex.Pattern r10 = REGEX_METHOD
            java.lang.String r10 = parseStringAttr(r14, r10, r11)
            java.lang.String r10 = parseEncryptionScheme(r10)
            com.google.android.exoplayer2.drm.DrmInitData r14 = new com.google.android.exoplayer2.drm.DrmInitData
            r15 = 1
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r15 = new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[r15]
            r16 = 0
            r15[r16] = r9
            r14.<init>((java.lang.String) r10, (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r15)
            r12.add(r14)
            goto L_0x00ce
        L_0x00c3:
            java.lang.String r10 = "#EXT-X-STREAM-INF"
            boolean r10 = r14.startsWith(r10)
            if (r10 != 0) goto L_0x00e1
            if (r9 == 0) goto L_0x00ce
            goto L_0x00e1
        L_0x00ce:
            r1 = r0
            r34 = r3
            r33 = r4
            r32 = r5
            r31 = r6
            r29 = r7
            r30 = r8
            r28 = r12
            r10 = r19
            goto L_0x0200
        L_0x00e1:
            java.lang.String r10 = "CLOSED-CAPTIONS=NONE"
            boolean r10 = r14.contains(r10)
            r13 = r13 | r10
            if (r9 == 0) goto L_0x00ef
            r10 = 16384(0x4000, float:2.2959E-41)
            r20 = r13
            goto L_0x00f2
        L_0x00ef:
            r20 = r13
            r10 = 0
        L_0x00f2:
            java.util.regex.Pattern r13 = REGEX_BANDWIDTH
            int r13 = parseIntAttr(r14, r13)
            r28 = r12
            java.util.regex.Pattern r12 = REGEX_AVERAGE_BANDWIDTH
            r29 = r7
            r7 = -1
            int r12 = parseOptionalIntAttr(r14, r12, r7)
            java.util.regex.Pattern r7 = REGEX_CODECS
            java.lang.String r7 = parseOptionalStringAttr(r14, r7, r11)
            r30 = r8
            java.util.regex.Pattern r8 = REGEX_RESOLUTION
            java.lang.String r8 = parseOptionalStringAttr(r14, r8, r11)
            if (r8 == 0) goto L_0x013a
            r31 = r6
            java.lang.String r6 = "x"
            java.lang.String[] r6 = com.google.android.exoplayer2.util.Util.split(r8, r6)
            r8 = 0
            r21 = r6[r8]
            int r8 = java.lang.Integer.parseInt(r21)
            r18 = 1
            r6 = r6[r18]
            int r6 = java.lang.Integer.parseInt(r6)
            if (r8 <= 0) goto L_0x0133
            if (r6 > 0) goto L_0x0130
            goto L_0x0133
        L_0x0130:
            r17 = r8
            goto L_0x0136
        L_0x0133:
            r6 = -1
            r17 = -1
        L_0x0136:
            r8 = r6
            r6 = r17
            goto L_0x013e
        L_0x013a:
            r31 = r6
            r6 = -1
            r8 = -1
        L_0x013e:
            r17 = -1082130432(0xffffffffbf800000, float:-1.0)
            r32 = r5
            java.util.regex.Pattern r5 = REGEX_FRAME_RATE
            java.lang.String r5 = parseOptionalStringAttr(r14, r5, r11)
            if (r5 == 0) goto L_0x014e
            float r17 = java.lang.Float.parseFloat(r5)
        L_0x014e:
            r33 = r4
            r5 = r17
            java.util.regex.Pattern r4 = REGEX_VIDEO
            java.lang.String r4 = parseOptionalStringAttr(r14, r4, r11)
            r34 = r3
            java.util.regex.Pattern r3 = REGEX_AUDIO
            java.lang.String r3 = parseOptionalStringAttr(r14, r3, r11)
            r35 = r0
            java.util.regex.Pattern r0 = REGEX_SUBTITLES
            java.lang.String r0 = parseOptionalStringAttr(r14, r0, r11)
            r17 = r0
            java.util.regex.Pattern r0 = REGEX_CLOSED_CAPTIONS
            java.lang.String r0 = parseOptionalStringAttr(r14, r0, r11)
            if (r9 == 0) goto L_0x017d
            java.util.regex.Pattern r9 = REGEX_URI
            java.lang.String r9 = parseStringAttr(r14, r9, r11)
            android.net.Uri r9 = com.google.android.exoplayer2.util.UriUtil.resolveToUri(r1, r9)
            goto L_0x018f
        L_0x017d:
            boolean r9 = r36.hasNext()
            if (r9 == 0) goto L_0x0213
            java.lang.String r9 = r36.next()
            java.lang.String r9 = replaceVariableReferences(r9, r11)
            android.net.Uri r9 = com.google.android.exoplayer2.util.UriUtil.resolveToUri(r1, r9)
        L_0x018f:
            com.google.android.exoplayer2.Format$Builder r14 = new com.google.android.exoplayer2.Format$Builder
            r14.<init>()
            int r1 = r2.size()
            com.google.android.exoplayer2.Format$Builder r1 = r14.setId((int) r1)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setContainerMimeType(r15)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setCodecs(r7)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setAverageBitrate(r12)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setPeakBitrate(r13)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setWidth(r6)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setHeight(r8)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setFrameRate(r5)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setRoleFlags(r10)
            com.google.android.exoplayer2.Format r23 = r1.build()
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant r1 = new com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant
            r21 = r1
            r22 = r9
            r24 = r4
            r25 = r3
            r26 = r17
            r27 = r0
            r21.<init>(r22, r23, r24, r25, r26, r27)
            r2.add(r1)
            r1 = r35
            java.lang.Object r5 = r1.get(r9)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            if (r5 != 0) goto L_0x01e6
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r1.put(r9, r5)
        L_0x01e6:
            com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry$VariantInfo r6 = new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry$VariantInfo
            r21 = r6
            r22 = r12
            r23 = r13
            r24 = r4
            r25 = r3
            r26 = r17
            r27 = r0
            r21.<init>(r22, r23, r24, r25, r26, r27)
            r5.add(r6)
            r10 = r19
            r13 = r20
        L_0x0200:
            r0 = r1
            r12 = r28
            r7 = r29
            r8 = r30
            r6 = r31
            r5 = r32
            r4 = r33
            r3 = r34
            r1 = r37
            goto L_0x0036
        L_0x0213:
            java.lang.String r0 = "#EXT-X-STREAM-INF must be followed by another line"
            r1 = 0
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r0, r1)
            throw r0
        L_0x021b:
            r1 = r0
            r34 = r3
            r33 = r4
            r32 = r5
            r31 = r6
            r29 = r7
            r30 = r8
            r19 = r10
            r28 = r12
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r4 = 0
        L_0x0237:
            int r5 = r2.size()
            if (r4 >= r5) goto L_0x0290
            java.lang.Object r5 = r2.get(r4)
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant r5 = (com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist.Variant) r5
            android.net.Uri r6 = r5.url
            boolean r6 = r0.add(r6)
            if (r6 == 0) goto L_0x028c
            com.google.android.exoplayer2.Format r6 = r5.format
            com.google.android.exoplayer2.metadata.Metadata r6 = r6.metadata
            if (r6 != 0) goto L_0x0253
            r6 = 1
            goto L_0x0254
        L_0x0253:
            r6 = 0
        L_0x0254:
            com.google.android.exoplayer2.util.Assertions.checkState(r6)
            com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry r6 = new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry
            android.net.Uri r7 = r5.url
            java.lang.Object r7 = r1.get(r7)
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            java.lang.Object r7 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r7)
            java.util.List r7 = (java.util.List) r7
            r8 = 0
            r6.<init>(r8, r8, r7)
            com.google.android.exoplayer2.metadata.Metadata r7 = new com.google.android.exoplayer2.metadata.Metadata
            r9 = 1
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r10 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r9]
            r9 = 0
            r10[r9] = r6
            r7.<init>((com.google.android.exoplayer2.metadata.Metadata.Entry[]) r10)
            com.google.android.exoplayer2.Format r6 = r5.format
            com.google.android.exoplayer2.Format$Builder r6 = r6.buildUpon()
            com.google.android.exoplayer2.Format$Builder r6 = r6.setMetadata(r7)
            com.google.android.exoplayer2.Format r6 = r6.build()
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant r5 = r5.copyWithFormat(r6)
            r3.add(r5)
            goto L_0x028d
        L_0x028c:
            r8 = 0
        L_0x028d:
            int r4 = r4 + 1
            goto L_0x0237
        L_0x0290:
            r8 = 0
            r1 = r8
            r9 = r1
            r0 = 0
        L_0x0294:
            int r4 = r34.size()
            if (r0 >= r4) goto L_0x04b6
            r4 = r34
            java.lang.Object r5 = r4.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            java.util.regex.Pattern r6 = REGEX_GROUP_ID
            java.lang.String r6 = parseStringAttr(r5, r6, r11)
            java.util.regex.Pattern r7 = REGEX_NAME
            java.lang.String r7 = parseStringAttr(r5, r7, r11)
            com.google.android.exoplayer2.Format$Builder r10 = new com.google.android.exoplayer2.Format$Builder
            r10.<init>()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.StringBuilder r12 = r12.append(r6)
            java.lang.String r14 = ":"
            java.lang.StringBuilder r12 = r12.append(r14)
            java.lang.StringBuilder r12 = r12.append(r7)
            java.lang.String r12 = r12.toString()
            com.google.android.exoplayer2.Format$Builder r10 = r10.setId((java.lang.String) r12)
            com.google.android.exoplayer2.Format$Builder r10 = r10.setLabel(r7)
            com.google.android.exoplayer2.Format$Builder r10 = r10.setContainerMimeType(r15)
            int r12 = parseSelectionFlags(r5)
            com.google.android.exoplayer2.Format$Builder r10 = r10.setSelectionFlags(r12)
            int r12 = parseRoleFlags(r5, r11)
            com.google.android.exoplayer2.Format$Builder r10 = r10.setRoleFlags(r12)
            java.util.regex.Pattern r12 = REGEX_LANGUAGE
            java.lang.String r12 = parseOptionalStringAttr(r5, r12, r11)
            com.google.android.exoplayer2.Format$Builder r10 = r10.setLanguage(r12)
            java.util.regex.Pattern r12 = REGEX_URI
            java.lang.String r12 = parseOptionalStringAttr(r5, r12, r11)
            r14 = r37
            if (r12 != 0) goto L_0x02fc
            r12 = r8
            goto L_0x0300
        L_0x02fc:
            android.net.Uri r12 = com.google.android.exoplayer2.util.UriUtil.resolveToUri(r14, r12)
        L_0x0300:
            com.google.android.exoplayer2.metadata.Metadata r8 = new com.google.android.exoplayer2.metadata.Metadata
            r34 = r4
            r4 = 1
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r14 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r4]
            com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry r4 = new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry
            r20 = r15
            java.util.List r15 = java.util.Collections.emptyList()
            r4.<init>(r6, r7, r15)
            r15 = 0
            r14[r15] = r4
            r8.<init>((com.google.android.exoplayer2.metadata.Metadata.Entry[]) r14)
            java.util.regex.Pattern r4 = REGEX_TYPE
            java.lang.String r4 = parseStringAttr(r5, r4, r11)
            r4.hashCode()
            int r14 = r4.hashCode()
            r15 = 2
            switch(r14) {
                case -959297733: goto L_0x034c;
                case -333210994: goto L_0x0341;
                case 62628790: goto L_0x0336;
                case 81665115: goto L_0x032b;
                default: goto L_0x0329;
            }
        L_0x0329:
            r4 = -1
            goto L_0x0356
        L_0x032b:
            java.lang.String r14 = "VIDEO"
            boolean r4 = r4.equals(r14)
            if (r4 != 0) goto L_0x0334
            goto L_0x0329
        L_0x0334:
            r4 = 3
            goto L_0x0356
        L_0x0336:
            java.lang.String r14 = "AUDIO"
            boolean r4 = r4.equals(r14)
            if (r4 != 0) goto L_0x033f
            goto L_0x0329
        L_0x033f:
            r4 = r15
            goto L_0x0356
        L_0x0341:
            java.lang.String r14 = "CLOSED-CAPTIONS"
            boolean r4 = r4.equals(r14)
            if (r4 != 0) goto L_0x034a
            goto L_0x0329
        L_0x034a:
            r4 = 1
            goto L_0x0356
        L_0x034c:
            java.lang.String r14 = "SUBTITLES"
            boolean r4 = r4.equals(r14)
            if (r4 != 0) goto L_0x0355
            goto L_0x0329
        L_0x0355:
            r4 = 0
        L_0x0356:
            switch(r4) {
                case 0: goto L_0x0462;
                case 1: goto L_0x041e;
                case 2: goto L_0x03ab;
                case 3: goto L_0x0365;
                default: goto L_0x0359;
            }
        L_0x0359:
            r21 = r9
            r6 = r31
            r9 = r32
            r14 = r33
        L_0x0361:
            r16 = 0
            goto L_0x04a7
        L_0x0365:
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant r4 = getVariantWithVideoGroup(r2, r6)
            if (r4 == 0) goto L_0x0390
            com.google.android.exoplayer2.Format r4 = r4.format
            java.lang.String r5 = r4.codecs
            java.lang.String r5 = com.google.android.exoplayer2.util.Util.getCodecsOfType(r5, r15)
            com.google.android.exoplayer2.Format$Builder r14 = r10.setCodecs(r5)
            java.lang.String r5 = com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(r5)
            com.google.android.exoplayer2.Format$Builder r5 = r14.setSampleMimeType(r5)
            int r14 = r4.width
            com.google.android.exoplayer2.Format$Builder r5 = r5.setWidth(r14)
            int r14 = r4.height
            com.google.android.exoplayer2.Format$Builder r5 = r5.setHeight(r14)
            float r4 = r4.frameRate
            r5.setFrameRate(r4)
        L_0x0390:
            if (r12 != 0) goto L_0x0393
            goto L_0x0359
        L_0x0393:
            r10.setMetadata(r8)
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Rendition r4 = new com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Rendition
            com.google.android.exoplayer2.Format r5 = r10.build()
            r4.<init>(r12, r5, r6, r7)
            r14 = r33
            r14.add(r4)
            r21 = r9
            r6 = r31
            r9 = r32
            goto L_0x0361
        L_0x03ab:
            r14 = r33
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant r4 = getVariantWithAudioGroup(r2, r6)
            if (r4 == 0) goto L_0x03c6
            com.google.android.exoplayer2.Format r15 = r4.format
            java.lang.String r15 = r15.codecs
            r21 = r9
            r9 = 1
            java.lang.String r15 = com.google.android.exoplayer2.util.Util.getCodecsOfType(r15, r9)
            r10.setCodecs(r15)
            java.lang.String r15 = com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(r15)
            goto L_0x03c9
        L_0x03c6:
            r21 = r9
            r15 = 0
        L_0x03c9:
            java.util.regex.Pattern r9 = REGEX_CHANNELS
            java.lang.String r5 = parseOptionalStringAttr(r5, r9, r11)
            if (r5 == 0) goto L_0x03fa
            java.lang.String r9 = "/"
            java.lang.String[] r9 = com.google.android.exoplayer2.util.Util.splitAtFirst(r5, r9)
            r16 = 0
            r9 = r9[r16]
            int r9 = java.lang.Integer.parseInt(r9)
            r10.setChannelCount(r9)
            java.lang.String r9 = "audio/eac3"
            boolean r9 = r9.equals(r15)
            if (r9 == 0) goto L_0x03fc
            java.lang.String r9 = "/JOC"
            boolean r5 = r5.endsWith(r9)
            if (r5 == 0) goto L_0x03fc
            java.lang.String r5 = "ec+3"
            r10.setCodecs(r5)
            java.lang.String r15 = "audio/eac3-joc"
            goto L_0x03fc
        L_0x03fa:
            r16 = 0
        L_0x03fc:
            r10.setSampleMimeType(r15)
            if (r12 == 0) goto L_0x0413
            r10.setMetadata(r8)
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Rendition r4 = new com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Rendition
            com.google.android.exoplayer2.Format r5 = r10.build()
            r4.<init>(r12, r5, r6, r7)
            r9 = r32
            r9.add(r4)
            goto L_0x045f
        L_0x0413:
            r9 = r32
            if (r4 == 0) goto L_0x045f
            com.google.android.exoplayer2.Format r4 = r10.build()
            r21 = r4
            goto L_0x045f
        L_0x041e:
            r21 = r9
            r9 = r32
            r14 = r33
            r16 = 0
            java.util.regex.Pattern r4 = REGEX_INSTREAM_ID
            java.lang.String r4 = parseStringAttr(r5, r4, r11)
            java.lang.String r5 = "CC"
            boolean r5 = r4.startsWith(r5)
            if (r5 == 0) goto L_0x043f
            java.lang.String r4 = r4.substring(r15)
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.String r5 = "application/cea-608"
            goto L_0x044a
        L_0x043f:
            r5 = 7
            java.lang.String r4 = r4.substring(r5)
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.String r5 = "application/cea-708"
        L_0x044a:
            if (r1 != 0) goto L_0x0451
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x0451:
            com.google.android.exoplayer2.Format$Builder r5 = r10.setSampleMimeType(r5)
            r5.setAccessibilityChannel(r4)
            com.google.android.exoplayer2.Format r4 = r10.build()
            r1.add(r4)
        L_0x045f:
            r6 = r31
            goto L_0x04a7
        L_0x0462:
            r21 = r9
            r9 = r32
            r14 = r33
            r16 = 0
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant r4 = getVariantWithSubtitleGroup(r2, r6)
            if (r4 == 0) goto L_0x0481
            com.google.android.exoplayer2.Format r4 = r4.format
            java.lang.String r4 = r4.codecs
            r5 = 3
            java.lang.String r4 = com.google.android.exoplayer2.util.Util.getCodecsOfType(r4, r5)
            r10.setCodecs(r4)
            java.lang.String r4 = com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(r4)
            goto L_0x0482
        L_0x0481:
            r4 = 0
        L_0x0482:
            if (r4 != 0) goto L_0x0486
            java.lang.String r4 = "text/vtt"
        L_0x0486:
            com.google.android.exoplayer2.Format$Builder r4 = r10.setSampleMimeType(r4)
            r4.setMetadata(r8)
            if (r12 == 0) goto L_0x049e
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Rendition r4 = new com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Rendition
            com.google.android.exoplayer2.Format r5 = r10.build()
            r4.<init>(r12, r5, r6, r7)
            r6 = r31
            r6.add(r4)
            goto L_0x04a7
        L_0x049e:
            r6 = r31
            java.lang.String r4 = "HlsPlaylistParser"
            java.lang.String r5 = "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping"
            com.google.android.exoplayer2.util.Log.w(r4, r5)
        L_0x04a7:
            int r0 = r0 + 1
            r31 = r6
            r32 = r9
            r33 = r14
            r15 = r20
            r9 = r21
            r8 = 0
            goto L_0x0294
        L_0x04b6:
            r21 = r9
            r6 = r31
            r9 = r32
            r14 = r33
            if (r13 == 0) goto L_0x04c6
            java.util.List r0 = java.util.Collections.emptyList()
            r10 = r0
            goto L_0x04c7
        L_0x04c6:
            r10 = r1
        L_0x04c7:
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist r13 = new com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist
            r0 = r13
            r1 = r37
            r2 = r30
            r4 = r14
            r5 = r9
            r7 = r29
            r8 = r21
            r9 = r10
            r10 = r19
            r12 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.parseMultivariantPlaylist(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$LineIterator, java.lang.String):com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist");
    }

    private static HlsMultivariantPlaylist.Variant getVariantWithAudioGroup(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i);
            if (str.equals(variant.audioGroupId)) {
                return variant;
            }
        }
        return null;
    }

    private static HlsMultivariantPlaylist.Variant getVariantWithVideoGroup(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i);
            if (str.equals(variant.videoGroupId)) {
                return variant;
            }
        }
        return null;
    }

    private static HlsMultivariantPlaylist.Variant getVariantWithSubtitleGroup(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i);
            if (str.equals(variant.subtitleGroupId)) {
                return variant;
            }
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r13v0 */
    /* JADX WARNING: type inference failed for: r13v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r13v75 */
    private static HlsMediaPlaylist parseMediaPlaylist(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist, LineIterator lineIterator, String str) throws IOException {
        boolean z;
        ArrayList arrayList;
        boolean z2;
        ArrayList arrayList2;
        String str2;
        int i;
        HlsMediaPlaylist.Part part;
        long j;
        ArrayList arrayList3;
        ArrayList arrayList4;
        String str3;
        ArrayList arrayList5;
        boolean z3;
        HlsMediaPlaylist hlsMediaPlaylist2;
        String str4;
        String str5;
        ArrayList arrayList6;
        String str6;
        ArrayList arrayList7;
        boolean z4;
        int i2;
        long j2;
        long j3;
        DrmInitData drmInitData;
        boolean z5;
        long j4;
        String str7;
        String str8;
        String str9;
        String str10;
        long j5;
        HlsMultivariantPlaylist hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
        HlsMediaPlaylist hlsMediaPlaylist3 = hlsMediaPlaylist;
        boolean z6 = hlsMultivariantPlaylist2.hasIndependentSegments;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        HlsMediaPlaylist.ServerControl serverControl = new HlsMediaPlaylist.ServerControl(C.TIME_UNSET, false, C.TIME_UNSET, C.TIME_UNSET, false);
        TreeMap treeMap = new TreeMap();
        String str11 = "";
        ? r13 = 0;
        boolean z7 = z6;
        HlsMediaPlaylist.ServerControl serverControl2 = serverControl;
        String str12 = str11;
        int i3 = 0;
        boolean z8 = false;
        boolean z9 = false;
        int i4 = 0;
        boolean z10 = false;
        boolean z11 = false;
        int i5 = 0;
        boolean z12 = false;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        long j14 = C.TIME_UNSET;
        int i6 = 1;
        long j15 = C.TIME_UNSET;
        long j16 = C.TIME_UNSET;
        DrmInitData drmInitData2 = null;
        DrmInitData drmInitData3 = null;
        String str13 = null;
        long j17 = -1;
        String str14 = null;
        String str15 = null;
        HlsMediaPlaylist.Segment segment = null;
        ArrayList arrayList12 = arrayList9;
        HlsMediaPlaylist.Part part2 = null;
        while (lineIterator.hasNext()) {
            String next = lineIterator.next();
            if (next.startsWith(TAG_PREFIX)) {
                arrayList11.add(next);
            }
            if (next.startsWith(TAG_PLAYLIST_TYPE)) {
                String parseStringAttr = parseStringAttr(next, REGEX_PLAYLIST_TYPE, hashMap);
                if ("VOD".equals(parseStringAttr)) {
                    i3 = 1;
                    z = r13;
                } else if ("EVENT".equals(parseStringAttr)) {
                    i3 = 2;
                    z = r13;
                } else {
                    z = r13;
                }
            } else if (next.equals(TAG_IFRAME)) {
                z12 = true;
                z = r13;
            } else {
                if (next.startsWith(TAG_START)) {
                    arrayList = arrayList8;
                    z8 = parseOptionalBooleanAttribute(next, REGEX_PRECISE, r13);
                    j14 = (long) (parseDoubleAttr(next, REGEX_TIME_OFFSET) * 1000000.0d);
                } else {
                    arrayList = arrayList8;
                    if (next.startsWith(TAG_SERVER_CONTROL)) {
                        serverControl2 = parseServerControl(next);
                    } else if (next.startsWith(TAG_PART_INF)) {
                        j16 = (long) (parseDoubleAttr(next, REGEX_PART_TARGET_DURATION) * 1000000.0d);
                    } else if (next.startsWith(TAG_INIT_SEGMENT)) {
                        String parseStringAttr2 = parseStringAttr(next, REGEX_URI, hashMap);
                        String parseOptionalStringAttr = parseOptionalStringAttr(next, REGEX_ATTR_BYTERANGE, hashMap);
                        if (parseOptionalStringAttr != null) {
                            String[] split = Util.split(parseOptionalStringAttr, "@");
                            j17 = Long.parseLong(split[r13]);
                            if (split.length > 1) {
                                j8 = Long.parseLong(split[1]);
                            }
                        }
                        int i7 = (j17 > -1 ? 1 : (j17 == -1 ? 0 : -1));
                        if (i7 == 0) {
                            j8 = 0;
                        }
                        String str16 = str13;
                        String str17 = str14;
                        if (str16 == null || str17 != null) {
                            segment = new HlsMediaPlaylist.Segment(parseStringAttr2, j8, j17, str16, str17);
                            if (i7 != 0) {
                                j8 += j17;
                            }
                            str14 = str17;
                            str13 = str16;
                            arrayList8 = arrayList;
                            j17 = -1;
                            z = r13;
                        } else {
                            throw ParserException.createForMalformedManifest("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", (Throwable) null);
                        }
                    } else {
                        String str18 = str13;
                        String str19 = str14;
                        if (next.startsWith(TAG_TARGET_DURATION)) {
                            j15 = 1000000 * ((long) parseIntAttr(next, REGEX_TARGET_DURATION));
                        } else if (next.startsWith(TAG_MEDIA_SEQUENCE)) {
                            j11 = parseLongAttr(next, REGEX_MEDIA_SEQUENCE);
                            str14 = str19;
                            str13 = str18;
                            j7 = j11;
                            arrayList8 = arrayList;
                            z = false;
                        } else if (next.startsWith(TAG_VERSION)) {
                            i6 = parseIntAttr(next, REGEX_VERSION);
                        } else {
                            if (next.startsWith(TAG_DEFINE)) {
                                String parseOptionalStringAttr2 = parseOptionalStringAttr(next, REGEX_IMPORT, hashMap);
                                if (parseOptionalStringAttr2 != null) {
                                    String str20 = hlsMultivariantPlaylist2.variableDefinitions.get(parseOptionalStringAttr2);
                                    if (str20 != null) {
                                        hashMap.put(parseOptionalStringAttr2, str20);
                                    }
                                } else {
                                    hashMap.put(parseStringAttr(next, REGEX_NAME, hashMap), parseStringAttr(next, REGEX_VALUE, hashMap));
                                }
                                part = part2;
                                arrayList3 = arrayList12;
                                arrayList2 = arrayList11;
                                str2 = str11;
                                str3 = str15;
                                j = j11;
                                arrayList4 = arrayList;
                                z3 = false;
                                i = i3;
                                arrayList5 = arrayList10;
                            } else if (next.startsWith(TAG_MEDIA_DURATION)) {
                                j12 = parseTimeSecondsToUs(next, REGEX_MEDIA_DURATION);
                                str12 = parseOptionalStringAttr(next, REGEX_MEDIA_TITLE, str11, hashMap);
                            } else {
                                if (next.startsWith(TAG_SKIP)) {
                                    int parseIntAttr = parseIntAttr(next, REGEX_SKIPPED_SEGMENTS);
                                    Assertions.checkState(hlsMediaPlaylist3 != null && arrayList.isEmpty());
                                    int i8 = (int) (j7 - ((HlsMediaPlaylist) Util.castNonNull(hlsMediaPlaylist)).mediaSequence);
                                    int i9 = parseIntAttr + i8;
                                    if (i8 < 0 || i9 > hlsMediaPlaylist3.segments.size()) {
                                        throw new DeltaUpdateException();
                                    }
                                    String str21 = str11;
                                    str14 = str19;
                                    long j18 = j10;
                                    while (i8 < i9) {
                                        HlsMediaPlaylist.Segment segment2 = hlsMediaPlaylist3.segments.get(i8);
                                        ArrayList arrayList13 = arrayList12;
                                        ArrayList arrayList14 = arrayList11;
                                        if (j7 != hlsMediaPlaylist3.mediaSequence) {
                                            segment2 = segment2.copyWith(j18, (hlsMediaPlaylist3.discontinuitySequence - i4) + segment2.relativeDiscontinuitySequence);
                                        }
                                        ArrayList arrayList15 = arrayList;
                                        arrayList15.add(segment2);
                                        long j19 = j18 + segment2.durationUs;
                                        if (segment2.byteRangeLength != -1) {
                                            j5 = j19;
                                            j8 = segment2.byteRangeOffset + segment2.byteRangeLength;
                                        } else {
                                            j5 = j19;
                                        }
                                        int i10 = segment2.relativeDiscontinuitySequence;
                                        HlsMediaPlaylist.Segment segment3 = segment2.initializationSegment;
                                        DrmInitData drmInitData4 = segment2.drmInitData;
                                        str18 = segment2.fullSegmentEncryptionKeyUri;
                                        if (segment2.encryptionIV == null || !segment2.encryptionIV.equals(Long.toHexString(j11))) {
                                            str14 = segment2.encryptionIV;
                                        }
                                        j11++;
                                        i8++;
                                        i5 = i10;
                                        segment = segment3;
                                        drmInitData3 = drmInitData4;
                                        arrayList = arrayList15;
                                        j18 = j5;
                                        j9 = j18;
                                        arrayList12 = arrayList13;
                                        arrayList11 = arrayList14;
                                        HlsMultivariantPlaylist hlsMultivariantPlaylist3 = hlsMultivariantPlaylist;
                                        hlsMediaPlaylist3 = hlsMediaPlaylist;
                                    }
                                    ArrayList arrayList16 = arrayList12;
                                    hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                    hlsMediaPlaylist3 = hlsMediaPlaylist;
                                    j10 = j18;
                                    str13 = str18;
                                    arrayList8 = arrayList;
                                    str11 = str21;
                                } else {
                                    ArrayList arrayList17 = arrayList12;
                                    arrayList2 = arrayList11;
                                    str2 = str11;
                                    arrayList4 = arrayList;
                                    if (next.startsWith(TAG_KEY)) {
                                        String parseStringAttr3 = parseStringAttr(next, REGEX_METHOD, hashMap);
                                        String parseOptionalStringAttr3 = parseOptionalStringAttr(next, REGEX_KEYFORMAT, "identity", hashMap);
                                        if (METHOD_NONE.equals(parseStringAttr3)) {
                                            treeMap.clear();
                                            str10 = null;
                                            drmInitData3 = null;
                                            str6 = null;
                                        } else {
                                            String parseOptionalStringAttr4 = parseOptionalStringAttr(next, REGEX_IV, hashMap);
                                            if (!"identity".equals(parseOptionalStringAttr3)) {
                                                String str22 = str15;
                                                str15 = str22 == null ? parseEncryptionScheme(parseStringAttr3) : str22;
                                                DrmInitData.SchemeData parseDrmSchemeData = parseDrmSchemeData(next, parseOptionalStringAttr3, hashMap);
                                                if (parseDrmSchemeData != null) {
                                                    treeMap.put(parseOptionalStringAttr3, parseDrmSchemeData);
                                                    str6 = parseOptionalStringAttr4;
                                                    str10 = null;
                                                    drmInitData3 = null;
                                                }
                                            } else if (METHOD_AES_128.equals(parseStringAttr3)) {
                                                str10 = parseStringAttr(next, REGEX_URI, hashMap);
                                                str6 = parseOptionalStringAttr4;
                                            }
                                            str6 = parseOptionalStringAttr4;
                                            str10 = null;
                                        }
                                        hlsMediaPlaylist2 = hlsMediaPlaylist;
                                        str4 = str10;
                                        arrayList6 = arrayList4;
                                        arrayList7 = arrayList17;
                                        str5 = str2;
                                        arrayList11 = arrayList2;
                                        z2 = false;
                                        hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                        z = z2;
                                    } else {
                                        str3 = str15;
                                        if (next.startsWith(TAG_BYTERANGE)) {
                                            String[] split2 = Util.split(parseStringAttr(next, REGEX_BYTERANGE, hashMap), "@");
                                            j17 = Long.parseLong(split2[0]);
                                            if (split2.length > 1) {
                                                j8 = Long.parseLong(split2[1]);
                                            }
                                        } else {
                                            if (next.startsWith(TAG_DISCONTINUITY_SEQUENCE)) {
                                                i4 = Integer.parseInt(next.substring(next.indexOf(58) + 1));
                                                hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                hlsMediaPlaylist3 = hlsMediaPlaylist;
                                                str7 = str3;
                                                str8 = str19;
                                                str9 = str18;
                                                arrayList12 = arrayList17;
                                                str11 = str2;
                                                z4 = false;
                                                z9 = true;
                                            } else if (next.equals(TAG_DISCONTINUITY)) {
                                                i5++;
                                            } else {
                                                if (next.startsWith(TAG_PROGRAM_DATE_TIME)) {
                                                    if (j6 == 0) {
                                                        j6 = Util.msToUs(Util.parseXsDateTime(next.substring(next.indexOf(58) + 1))) - j10;
                                                    } else {
                                                        i = i3;
                                                        part = part2;
                                                        arrayList5 = arrayList10;
                                                    }
                                                } else if (next.equals(TAG_GAP)) {
                                                    hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                    hlsMediaPlaylist3 = hlsMediaPlaylist;
                                                    str7 = str3;
                                                    str8 = str19;
                                                    str9 = str18;
                                                    arrayList12 = arrayList17;
                                                    str11 = str2;
                                                    z4 = false;
                                                    z11 = true;
                                                } else if (next.equals(TAG_INDEPENDENT_SEGMENTS)) {
                                                    hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                    hlsMediaPlaylist3 = hlsMediaPlaylist;
                                                    str7 = str3;
                                                    str8 = str19;
                                                    str9 = str18;
                                                    arrayList12 = arrayList17;
                                                    str11 = str2;
                                                    z4 = false;
                                                    z7 = true;
                                                } else if (next.equals(TAG_ENDLIST)) {
                                                    hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                    hlsMediaPlaylist3 = hlsMediaPlaylist;
                                                    str7 = str3;
                                                    str8 = str19;
                                                    str9 = str18;
                                                    arrayList12 = arrayList17;
                                                    str11 = str2;
                                                    z4 = false;
                                                    z10 = true;
                                                } else {
                                                    if (next.startsWith(TAG_RENDITION_REPORT)) {
                                                        i2 = i3;
                                                        arrayList10.add(new HlsMediaPlaylist.RenditionReport(Uri.parse(UriUtil.resolve(str, parseStringAttr(next, REGEX_URI, hashMap))), parseOptionalLongAttr(next, REGEX_LAST_MSN, -1), parseOptionalIntAttr(next, REGEX_LAST_PART, -1)));
                                                    } else {
                                                        String str23 = str;
                                                        i2 = i3;
                                                        if (!next.startsWith(TAG_PRELOAD_HINT)) {
                                                            long j20 = j11;
                                                            if (next.startsWith(TAG_PART)) {
                                                                String segmentEncryptionIV = getSegmentEncryptionIV(j20, str18, str19);
                                                                String parseStringAttr4 = parseStringAttr(next, REGEX_URI, hashMap);
                                                                HlsMediaPlaylist.Part part3 = part2;
                                                                ArrayList arrayList18 = arrayList10;
                                                                long parseDoubleAttr = (long) (parseDoubleAttr(next, REGEX_ATTR_DURATION) * 1000000.0d);
                                                                int i11 = i2;
                                                                boolean parseOptionalBooleanAttribute = parseOptionalBooleanAttribute(next, REGEX_INDEPENDENT, false) | (z7 && arrayList17.isEmpty());
                                                                boolean parseOptionalBooleanAttribute2 = parseOptionalBooleanAttribute(next, REGEX_GAP, false);
                                                                String parseOptionalStringAttr5 = parseOptionalStringAttr(next, REGEX_ATTR_BYTERANGE, hashMap);
                                                                if (parseOptionalStringAttr5 != null) {
                                                                    String[] split3 = Util.split(parseOptionalStringAttr5, "@");
                                                                    j4 = Long.parseLong(split3[0]);
                                                                    if (split3.length > 1) {
                                                                        j13 = Long.parseLong(split3[1]);
                                                                    }
                                                                } else {
                                                                    j4 = -1;
                                                                }
                                                                int i12 = (j4 > -1 ? 1 : (j4 == -1 ? 0 : -1));
                                                                if (i12 == 0) {
                                                                    j13 = 0;
                                                                }
                                                                if (drmInitData3 == null && !treeMap.isEmpty()) {
                                                                    DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                                    DrmInitData drmInitData5 = new DrmInitData(str3, schemeDataArr);
                                                                    if (drmInitData2 == null) {
                                                                        drmInitData2 = getPlaylistProtectionSchemes(str3, schemeDataArr);
                                                                    }
                                                                    drmInitData3 = drmInitData5;
                                                                }
                                                                ArrayList arrayList19 = arrayList17;
                                                                arrayList19.add(new HlsMediaPlaylist.Part(parseStringAttr4, segment, parseDoubleAttr, i5, j9, drmInitData3, str18, segmentEncryptionIV, j13, j4, parseOptionalBooleanAttribute2, parseOptionalBooleanAttribute, false));
                                                                j9 += parseDoubleAttr;
                                                                if (i12 != 0) {
                                                                    j13 += j4;
                                                                }
                                                                j11 = j20;
                                                                arrayList10 = arrayList18;
                                                                str13 = str18;
                                                                part2 = part3;
                                                                i3 = i11;
                                                                str11 = str2;
                                                                hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                                hlsMediaPlaylist3 = hlsMediaPlaylist;
                                                                str15 = str3;
                                                                arrayList8 = arrayList4;
                                                                str14 = str19;
                                                                arrayList12 = arrayList19;
                                                                arrayList11 = arrayList2;
                                                            } else {
                                                                part = part2;
                                                                arrayList5 = arrayList10;
                                                                i = i2;
                                                                arrayList3 = arrayList17;
                                                                if (!next.startsWith("#")) {
                                                                    String segmentEncryptionIV2 = getSegmentEncryptionIV(j20, str18, str19);
                                                                    long j21 = j20 + 1;
                                                                    String replaceVariableReferences = replaceVariableReferences(next, hashMap);
                                                                    HlsMediaPlaylist.Segment segment4 = (HlsMediaPlaylist.Segment) hashMap2.get(replaceVariableReferences);
                                                                    int i13 = (j17 > -1 ? 1 : (j17 == -1 ? 0 : -1));
                                                                    if (i13 == 0) {
                                                                        j2 = 0;
                                                                    } else {
                                                                        if (z12 && segment == null && segment4 == null) {
                                                                            segment4 = new HlsMediaPlaylist.Segment(replaceVariableReferences, 0, j8, (String) null, (String) null);
                                                                            hashMap2.put(replaceVariableReferences, segment4);
                                                                        }
                                                                        j2 = j8;
                                                                    }
                                                                    if (drmInitData3 != null || treeMap.isEmpty()) {
                                                                        j3 = j21;
                                                                        z5 = false;
                                                                        drmInitData = drmInitData3;
                                                                    } else {
                                                                        j3 = j21;
                                                                        z5 = false;
                                                                        DrmInitData.SchemeData[] schemeDataArr2 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                                        drmInitData = new DrmInitData(str3, schemeDataArr2);
                                                                        if (drmInitData2 == null) {
                                                                            drmInitData2 = getPlaylistProtectionSchemes(str3, schemeDataArr2);
                                                                        }
                                                                    }
                                                                    arrayList4.add(new HlsMediaPlaylist.Segment(replaceVariableReferences, segment != null ? segment : segment4, str12, j12, i5, j10, drmInitData, str18, segmentEncryptionIV2, j2, j17, z11, arrayList3));
                                                                    j9 = j10 + j12;
                                                                    ArrayList arrayList20 = new ArrayList();
                                                                    if (i13 != 0) {
                                                                        j2 += j17;
                                                                    }
                                                                    j8 = j2;
                                                                    boolean z13 = z5;
                                                                    z11 = z13;
                                                                    arrayList10 = arrayList5;
                                                                    drmInitData3 = drmInitData;
                                                                    str13 = str18;
                                                                    j12 = 0;
                                                                    j10 = j9;
                                                                    j11 = j3;
                                                                    part2 = part;
                                                                    i3 = i;
                                                                    str11 = str2;
                                                                    str12 = str11;
                                                                    j17 = -1;
                                                                    hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                                    str15 = str3;
                                                                    arrayList8 = arrayList4;
                                                                    str14 = str19;
                                                                    arrayList11 = arrayList2;
                                                                    arrayList12 = arrayList20;
                                                                    hlsMediaPlaylist3 = hlsMediaPlaylist;
                                                                    z = z13;
                                                                } else {
                                                                    j = j20;
                                                                    z3 = false;
                                                                }
                                                            }
                                                        } else if (part2 == null && TYPE_PART.equals(parseStringAttr(next, REGEX_PRELOAD_HINT_TYPE, hashMap))) {
                                                            String parseStringAttr5 = parseStringAttr(next, REGEX_URI, hashMap);
                                                            long parseOptionalLongAttr = parseOptionalLongAttr(next, REGEX_BYTERANGE_START, -1);
                                                            long parseOptionalLongAttr2 = parseOptionalLongAttr(next, REGEX_BYTERANGE_LENGTH, -1);
                                                            long j22 = j11;
                                                            String segmentEncryptionIV3 = getSegmentEncryptionIV(j22, str18, str19);
                                                            if (drmInitData3 == null && !treeMap.isEmpty()) {
                                                                DrmInitData.SchemeData[] schemeDataArr3 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                                DrmInitData drmInitData6 = new DrmInitData(str3, schemeDataArr3);
                                                                if (drmInitData2 == null) {
                                                                    drmInitData2 = getPlaylistProtectionSchemes(str3, schemeDataArr3);
                                                                }
                                                                drmInitData3 = drmInitData6;
                                                            }
                                                            int i14 = (parseOptionalLongAttr > -1 ? 1 : (parseOptionalLongAttr == -1 ? 0 : -1));
                                                            if (i14 == 0 || parseOptionalLongAttr2 != -1) {
                                                                part2 = new HlsMediaPlaylist.Part(parseStringAttr5, segment, 0, i5, j9, drmInitData3, str18, segmentEncryptionIV3, i14 != 0 ? parseOptionalLongAttr : 0, parseOptionalLongAttr2, false, false, true);
                                                            }
                                                            j11 = j22;
                                                            str7 = str3;
                                                            i3 = i2;
                                                            str8 = str19;
                                                            str9 = str18;
                                                            arrayList12 = arrayList17;
                                                            str11 = str2;
                                                            z4 = false;
                                                            hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                            hlsMediaPlaylist3 = hlsMediaPlaylist;
                                                        }
                                                    }
                                                    part = part2;
                                                    arrayList5 = arrayList10;
                                                    i = i2;
                                                }
                                                arrayList3 = arrayList17;
                                                j = j11;
                                                z3 = false;
                                            }
                                            arrayList8 = arrayList4;
                                            arrayList11 = arrayList2;
                                            z = z4;
                                        }
                                        hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                        hlsMediaPlaylist3 = hlsMediaPlaylist;
                                        str7 = str3;
                                        str8 = str19;
                                        str9 = str18;
                                        arrayList12 = arrayList17;
                                        str11 = str2;
                                        z4 = false;
                                        arrayList8 = arrayList4;
                                        arrayList11 = arrayList2;
                                        z = z4;
                                    }
                                }
                                z = false;
                            }
                            hlsMediaPlaylist2 = hlsMediaPlaylist;
                            arrayList10 = arrayList5;
                            str4 = str18;
                            j11 = j;
                            part2 = part;
                            i3 = i;
                            str5 = str2;
                            str15 = str3;
                            arrayList6 = arrayList4;
                            str6 = str19;
                            arrayList7 = arrayList3;
                            arrayList11 = arrayList2;
                            z2 = z3;
                            hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                            z = z2;
                        }
                        str14 = str19;
                        str13 = str18;
                        arrayList8 = arrayList;
                        z = false;
                    }
                }
                arrayList8 = arrayList;
                z = r13;
            }
            r13 = z;
        }
        int i15 = i3;
        HlsMediaPlaylist.Part part4 = part2;
        ArrayList arrayList21 = arrayList10;
        ArrayList arrayList22 = arrayList11;
        int i16 = r13;
        ArrayList arrayList23 = arrayList8;
        ArrayList arrayList24 = arrayList12;
        HashMap hashMap3 = new HashMap();
        for (int i17 = i16; i17 < arrayList21.size(); i17++) {
            HlsMediaPlaylist.RenditionReport renditionReport = (HlsMediaPlaylist.RenditionReport) arrayList21.get(i17);
            long j23 = renditionReport.lastMediaSequence;
            if (j23 == -1) {
                j23 = (j7 + ((long) arrayList23.size())) - (arrayList24.isEmpty() ? 1 : 0);
            }
            int i18 = renditionReport.lastPartIndex;
            if (i18 == -1) {
                if (j16 != C.TIME_UNSET) {
                    i18 = (arrayList24.isEmpty() ? ((HlsMediaPlaylist.Segment) Iterables.getLast(arrayList23)).parts : arrayList24).size() - 1;
                }
            }
            hashMap3.put(renditionReport.playlistUri, new HlsMediaPlaylist.RenditionReport(renditionReport.playlistUri, j23, i18));
        }
        if (part4 != null) {
            arrayList24.add(part4);
        }
        return new HlsMediaPlaylist(i15, str, arrayList22, j14, z8, j6, z9, i4, j7, i6, j15, j16, z7, z10, j6 != 0, drmInitData2, arrayList23, arrayList24, serverControl2, hashMap3);
    }

    private static DrmInitData getPlaylistProtectionSchemes(String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i = 0; i < schemeDataArr.length; i++) {
            schemeDataArr2[i] = schemeDataArr[i].copyWithData((byte[]) null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    private static String getSegmentEncryptionIV(long j, String str, String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j);
    }

    private static int parseSelectionFlags(String str) {
        boolean parseOptionalBooleanAttribute = parseOptionalBooleanAttribute(str, REGEX_DEFAULT, false);
        if (parseOptionalBooleanAttribute(str, REGEX_FORCED, false)) {
            parseOptionalBooleanAttribute |= true;
        }
        return parseOptionalBooleanAttribute(str, REGEX_AUTOSELECT, false) ? parseOptionalBooleanAttribute | true ? 1 : 0 : parseOptionalBooleanAttribute ? 1 : 0;
    }

    private static int parseRoleFlags(String str, Map<String, String> map) {
        String parseOptionalStringAttr = parseOptionalStringAttr(str, REGEX_CHARACTERISTICS, map);
        int i = 0;
        if (TextUtils.isEmpty(parseOptionalStringAttr)) {
            return 0;
        }
        String[] split = Util.split(parseOptionalStringAttr, ",");
        if (Util.contains(split, "public.accessibility.describes-video")) {
            i = 512;
        }
        if (Util.contains(split, "public.accessibility.transcribes-spoken-dialog")) {
            i |= 4096;
        }
        if (Util.contains(split, "public.accessibility.describes-music-and-sound")) {
            i |= 1024;
        }
        return Util.contains(split, "public.easy-to-read") ? i | 8192 : i;
    }

    private static DrmInitData.SchemeData parseDrmSchemeData(String str, String str2, Map<String, String> map) throws ParserException {
        String parseOptionalStringAttr = parseOptionalStringAttr(str, REGEX_KEYFORMATVERSIONS, "1", map);
        if (KEYFORMAT_WIDEVINE_PSSH_BINARY.equals(str2)) {
            String parseStringAttr = parseStringAttr(str, REGEX_URI, map);
            return new DrmInitData.SchemeData(C.WIDEVINE_UUID, MimeTypes.VIDEO_MP4, Base64.decode(parseStringAttr.substring(parseStringAttr.indexOf(44)), 0));
        } else if (KEYFORMAT_WIDEVINE_PSSH_JSON.equals(str2)) {
            return new DrmInitData.SchemeData(C.WIDEVINE_UUID, "hls", Util.getUtf8Bytes(str));
        } else {
            if (!KEYFORMAT_PLAYREADY.equals(str2) || !"1".equals(parseOptionalStringAttr)) {
                return null;
            }
            String parseStringAttr2 = parseStringAttr(str, REGEX_URI, map);
            return new DrmInitData.SchemeData(C.PLAYREADY_UUID, MimeTypes.VIDEO_MP4, PsshAtomUtil.buildPsshAtom(C.PLAYREADY_UUID, Base64.decode(parseStringAttr2.substring(parseStringAttr2.indexOf(44)), 0)));
        }
    }

    private static HlsMediaPlaylist.ServerControl parseServerControl(String str) {
        String str2 = str;
        double parseOptionalDoubleAttr = parseOptionalDoubleAttr(str2, REGEX_CAN_SKIP_UNTIL, -9.223372036854776E18d);
        int i = (parseOptionalDoubleAttr > -9.223372036854776E18d ? 1 : (parseOptionalDoubleAttr == -9.223372036854776E18d ? 0 : -1));
        long j = C.TIME_UNSET;
        long j2 = i == 0 ? -9223372036854775807L : (long) (parseOptionalDoubleAttr * 1000000.0d);
        boolean parseOptionalBooleanAttribute = parseOptionalBooleanAttribute(str2, REGEX_CAN_SKIP_DATE_RANGES, false);
        double parseOptionalDoubleAttr2 = parseOptionalDoubleAttr(str2, REGEX_HOLD_BACK, -9.223372036854776E18d);
        long j3 = parseOptionalDoubleAttr2 == -9.223372036854776E18d ? -9223372036854775807L : (long) (parseOptionalDoubleAttr2 * 1000000.0d);
        double parseOptionalDoubleAttr3 = parseOptionalDoubleAttr(str2, REGEX_PART_HOLD_BACK, -9.223372036854776E18d);
        if (parseOptionalDoubleAttr3 != -9.223372036854776E18d) {
            j = (long) (parseOptionalDoubleAttr3 * 1000000.0d);
        }
        return new HlsMediaPlaylist.ServerControl(j2, parseOptionalBooleanAttribute, j3, j, parseOptionalBooleanAttribute(str2, REGEX_CAN_BLOCK_RELOAD, false));
    }

    private static String parseEncryptionScheme(String str) {
        return (METHOD_SAMPLE_AES_CENC.equals(str) || METHOD_SAMPLE_AES_CTR.equals(str)) ? C.CENC_TYPE_cenc : C.CENC_TYPE_cbcs;
    }

    private static int parseIntAttr(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static int parseOptionalIntAttr(String str, Pattern pattern, int i) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1))) : i;
    }

    private static long parseLongAttr(String str, Pattern pattern) throws ParserException {
        return Long.parseLong(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static long parseOptionalLongAttr(String str, Pattern pattern, long j) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) Assertions.checkNotNull(matcher.group(1))) : j;
    }

    private static long parseTimeSecondsToUs(String str, Pattern pattern) throws ParserException {
        return new BigDecimal(parseStringAttr(str, pattern, Collections.emptyMap())).multiply(new BigDecimal(1000000)).longValue();
    }

    private static double parseDoubleAttr(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static String parseStringAttr(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String parseOptionalStringAttr = parseOptionalStringAttr(str, pattern, map);
        if (parseOptionalStringAttr != null) {
            return parseOptionalStringAttr;
        }
        throw ParserException.createForMalformedManifest("Couldn't match " + pattern.pattern() + " in " + str, (Throwable) null);
    }

    private static String parseOptionalStringAttr(String str, Pattern pattern, Map<String, String> map) {
        return parseOptionalStringAttr(str, pattern, (String) null, map);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String parseOptionalStringAttr(java.lang.String r0, java.util.regex.Pattern r1, java.lang.String r2, java.util.Map<java.lang.String, java.lang.String> r3) {
        /*
            java.util.regex.Matcher r0 = r1.matcher(r0)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x0016
            r1 = 1
            java.lang.String r0 = r0.group(r1)
            java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r0)
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
        L_0x0016:
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L_0x0023
            if (r2 != 0) goto L_0x001f
            goto L_0x0023
        L_0x001f:
            java.lang.String r2 = replaceVariableReferences(r2, r3)
        L_0x0023:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.parseOptionalStringAttr(java.lang.String, java.util.regex.Pattern, java.lang.String, java.util.Map):java.lang.String");
    }

    private static double parseOptionalDoubleAttr(String str, Pattern pattern, double d) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) Assertions.checkNotNull(matcher.group(1))) : d;
    }

    private static String replaceVariableReferences(String str, Map<String, String> map) {
        Matcher matcher = REGEX_VARIABLE_REFERENCE.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static boolean parseOptionalBooleanAttribute(String str, Pattern pattern, boolean z) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? BOOLEAN_TRUE.equals(matcher.group(1)) : z;
    }

    private static Pattern compileBooleanAttrPattern(String str) {
        return Pattern.compile(str + "=(" + BOOLEAN_FALSE + "|" + BOOLEAN_TRUE + ")");
    }

    private static class LineIterator {
        private final Queue<String> extraLines;
        private String next;
        private final BufferedReader reader;

        public LineIterator(Queue<String> queue, BufferedReader bufferedReader) {
            this.extraLines = queue;
            this.reader = bufferedReader;
        }

        @EnsuresNonNullIf(expression = {"next"}, result = true)
        public boolean hasNext() throws IOException {
            String trim;
            if (this.next != null) {
                return true;
            }
            if (!this.extraLines.isEmpty()) {
                this.next = (String) Assertions.checkNotNull(this.extraLines.poll());
                return true;
            }
            do {
                String readLine = this.reader.readLine();
                this.next = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.next = trim;
            } while (trim.isEmpty());
            return true;
        }

        public String next() throws IOException {
            if (hasNext()) {
                String str = this.next;
                this.next = null;
                return str;
            }
            throw new NoSuchElementException();
        }
    }
}

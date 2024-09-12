package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.MediaDescription;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.android.exoplayer2.util.Assertions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SessionDescriptionParser {
    private static final Pattern ATTRIBUTE_PATTERN = Pattern.compile("([\\x21\\x23-\\x27\\x2a\\x2b\\x2d\\x2e\\x30-\\x39\\x41-\\x5a\\x5e-\\x7e]+)(?::(.*))?");
    private static final String ATTRIBUTE_TYPE = "a";
    private static final String BANDWIDTH_TYPE = "b";
    private static final String CONNECTION_TYPE = "c";
    private static final String EMAIL_TYPE = "e";
    private static final String INFORMATION_TYPE = "i";
    private static final String KEY_TYPE = "k";
    private static final Pattern MEDIA_DESCRIPTION_PATTERN = Pattern.compile("(\\S+)\\s(\\S+)\\s(\\S+)\\s(\\S+)");
    private static final String MEDIA_TYPE = "m";
    private static final String ORIGIN_TYPE = "o";
    private static final String PHONE_NUMBER_TYPE = "p";
    private static final String REPEAT_TYPE = "r";
    private static final Pattern SDP_LINE_PATTERN = Pattern.compile("([a-z])=\\s?(.+)");
    private static final String SESSION_TYPE = "s";
    private static final String TIMING_TYPE = "t";
    private static final String URI_TYPE = "u";
    private static final String VERSION_TYPE = "v";
    private static final String ZONE_TYPE = "z";

    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01b4, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.source.rtsp.SessionDescription parse(java.lang.String r13) throws com.google.android.exoplayer2.ParserException {
        /*
            com.google.android.exoplayer2.source.rtsp.SessionDescription$Builder r0 = new com.google.android.exoplayer2.source.rtsp.SessionDescription$Builder
            r0.<init>()
            java.lang.String[] r13 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.splitRtspMessageBody(r13)
            int r1 = r13.length
            r2 = 0
            r3 = 0
            r4 = r2
            r5 = r3
        L_0x000e:
            if (r4 >= r1) goto L_0x01d0
            r6 = r13[r4]
            java.lang.String r7 = ""
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x001c
            goto L_0x01b4
        L_0x001c:
            java.util.regex.Pattern r7 = SDP_LINE_PATTERN
            java.util.regex.Matcher r7 = r7.matcher(r6)
            boolean r8 = r7.matches()
            if (r8 == 0) goto L_0x01b8
            r8 = 1
            java.lang.String r9 = r7.group(r8)
            java.lang.Object r9 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r9)
            java.lang.String r9 = (java.lang.String) r9
            r10 = 2
            java.lang.String r7 = r7.group(r10)
            java.lang.Object r7 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r7)
            java.lang.String r7 = (java.lang.String) r7
            r11 = -1
            int r12 = r9.hashCode()
            switch(r12) {
                case 97: goto L_0x00e0;
                case 98: goto L_0x00d5;
                case 99: goto L_0x00cb;
                case 100: goto L_0x0046;
                case 101: goto L_0x00c1;
                case 102: goto L_0x0046;
                case 103: goto L_0x0046;
                case 104: goto L_0x0046;
                case 105: goto L_0x00b7;
                case 106: goto L_0x0046;
                case 107: goto L_0x00ac;
                case 108: goto L_0x0046;
                case 109: goto L_0x00a1;
                case 110: goto L_0x0046;
                case 111: goto L_0x0097;
                case 112: goto L_0x008d;
                case 113: goto L_0x0046;
                case 114: goto L_0x0082;
                case 115: goto L_0x0077;
                case 116: goto L_0x006b;
                case 117: goto L_0x0060;
                case 118: goto L_0x0055;
                case 119: goto L_0x0046;
                case 120: goto L_0x0046;
                case 121: goto L_0x0046;
                case 122: goto L_0x0048;
                default: goto L_0x0046;
            }
        L_0x0046:
            goto L_0x00ea
        L_0x0048:
            java.lang.String r12 = "z"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ea
            r11 = 14
            goto L_0x00ea
        L_0x0055:
            java.lang.String r12 = "v"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ea
            r11 = r2
            goto L_0x00ea
        L_0x0060:
            java.lang.String r12 = "u"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ea
            r11 = 4
            goto L_0x00ea
        L_0x006b:
            java.lang.String r12 = "t"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ea
            r11 = 9
            goto L_0x00ea
        L_0x0077:
            java.lang.String r12 = "s"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ea
            r11 = r10
            goto L_0x00ea
        L_0x0082:
            java.lang.String r12 = "r"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ea
            r11 = 13
            goto L_0x00ea
        L_0x008d:
            java.lang.String r12 = "p"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ea
            r11 = 6
            goto L_0x00ea
        L_0x0097:
            java.lang.String r12 = "o"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ea
            r11 = r8
            goto L_0x00ea
        L_0x00a1:
            java.lang.String r12 = "m"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ea
            r11 = 12
            goto L_0x00ea
        L_0x00ac:
            java.lang.String r12 = "k"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ea
            r11 = 10
            goto L_0x00ea
        L_0x00b7:
            java.lang.String r12 = "i"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ea
            r11 = 3
            goto L_0x00ea
        L_0x00c1:
            java.lang.String r12 = "e"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ea
            r11 = 5
            goto L_0x00ea
        L_0x00cb:
            java.lang.String r12 = "c"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ea
            r11 = 7
            goto L_0x00ea
        L_0x00d5:
            java.lang.String r12 = "b"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ea
            r11 = 8
            goto L_0x00ea
        L_0x00e0:
            java.lang.String r12 = "a"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ea
            r11 = 11
        L_0x00ea:
            switch(r11) {
                case 0: goto L_0x019c;
                case 1: goto L_0x0198;
                case 2: goto L_0x0194;
                case 3: goto L_0x018a;
                case 4: goto L_0x0182;
                case 5: goto L_0x017e;
                case 6: goto L_0x017a;
                case 7: goto L_0x0170;
                case 8: goto L_0x014d;
                case 9: goto L_0x0148;
                case 10: goto L_0x013c;
                case 11: goto L_0x00fa;
                case 12: goto L_0x00ef;
                default: goto L_0x00ed;
            }
        L_0x00ed:
            goto L_0x01b4
        L_0x00ef:
            if (r5 == 0) goto L_0x00f4
            addMediaDescriptionToSession(r0, r5)
        L_0x00f4:
            com.google.android.exoplayer2.source.rtsp.MediaDescription$Builder r5 = parseMediaDescriptionLine(r7)
            goto L_0x01b4
        L_0x00fa:
            java.util.regex.Pattern r9 = ATTRIBUTE_PATTERN
            java.util.regex.Matcher r7 = r9.matcher(r7)
            boolean r9 = r7.matches()
            if (r9 == 0) goto L_0x0124
            java.lang.String r6 = r7.group(r8)
            java.lang.Object r6 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r6)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = r7.group(r10)
            java.lang.String r7 = com.google.common.base.Strings.nullToEmpty(r7)
            if (r5 != 0) goto L_0x011f
            r0.addAttribute(r6, r7)
            goto L_0x01b4
        L_0x011f:
            r5.addAttribute(r6, r7)
            goto L_0x01b4
        L_0x0124:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "Malformed Attribute line: "
            java.lang.StringBuilder r13 = r13.append(r0)
            java.lang.StringBuilder r13 = r13.append(r6)
            java.lang.String r13 = r13.toString()
            com.google.android.exoplayer2.ParserException r13 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r13, r3)
            throw r13
        L_0x013c:
            if (r5 != 0) goto L_0x0143
            r0.setKey(r7)
            goto L_0x01b4
        L_0x0143:
            r5.setKey(r7)
            goto L_0x01b4
        L_0x0148:
            r0.setTiming(r7)
            goto L_0x01b4
        L_0x014d:
            java.lang.String r6 = ":\\s?"
            java.lang.String[] r6 = com.google.android.exoplayer2.util.Util.split(r7, r6)
            int r7 = r6.length
            if (r7 != r10) goto L_0x0158
            r7 = r8
            goto L_0x0159
        L_0x0158:
            r7 = r2
        L_0x0159:
            com.google.android.exoplayer2.util.Assertions.checkArgument(r7)
            r6 = r6[r8]
            int r6 = java.lang.Integer.parseInt(r6)
            if (r5 != 0) goto L_0x016a
            int r6 = r6 * 1000
            r0.setBitrate(r6)
            goto L_0x01b4
        L_0x016a:
            int r6 = r6 * 1000
            r5.setBitrate(r6)
            goto L_0x01b4
        L_0x0170:
            if (r5 != 0) goto L_0x0176
            r0.setConnection(r7)
            goto L_0x01b4
        L_0x0176:
            r5.setConnection(r7)
            goto L_0x01b4
        L_0x017a:
            r0.setPhoneNumber(r7)
            goto L_0x01b4
        L_0x017e:
            r0.setEmailAddress(r7)
            goto L_0x01b4
        L_0x0182:
            android.net.Uri r6 = android.net.Uri.parse(r7)
            r0.setUri(r6)
            goto L_0x01b4
        L_0x018a:
            if (r5 != 0) goto L_0x0190
            r0.setSessionInfo(r7)
            goto L_0x01b4
        L_0x0190:
            r5.setMediaTitle(r7)
            goto L_0x01b4
        L_0x0194:
            r0.setSessionName(r7)
            goto L_0x01b4
        L_0x0198:
            r0.setOrigin(r7)
            goto L_0x01b4
        L_0x019c:
            java.lang.String r6 = "0"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x01a5
            goto L_0x01b4
        L_0x01a5:
            java.lang.Object[] r13 = new java.lang.Object[r8]
            r13[r2] = r7
            java.lang.String r0 = "SDP version %s is not supported."
            java.lang.String r13 = java.lang.String.format(r0, r13)
            com.google.android.exoplayer2.ParserException r13 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r13, r3)
            throw r13
        L_0x01b4:
            int r4 = r4 + 1
            goto L_0x000e
        L_0x01b8:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "Malformed SDP line: "
            java.lang.StringBuilder r13 = r13.append(r0)
            java.lang.StringBuilder r13 = r13.append(r6)
            java.lang.String r13 = r13.toString()
            com.google.android.exoplayer2.ParserException r13 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r13, r3)
            throw r13
        L_0x01d0:
            if (r5 == 0) goto L_0x01d5
            addMediaDescriptionToSession(r0, r5)
        L_0x01d5:
            com.google.android.exoplayer2.source.rtsp.SessionDescription r13 = r0.build()     // Catch:{ IllegalArgumentException -> 0x01dc, IllegalStateException -> 0x01da }
            return r13
        L_0x01da:
            r13 = move-exception
            goto L_0x01dd
        L_0x01dc:
            r13 = move-exception
        L_0x01dd:
            com.google.android.exoplayer2.ParserException r13 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r3, r13)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.rtsp.SessionDescriptionParser.parse(java.lang.String):com.google.android.exoplayer2.source.rtsp.SessionDescription");
    }

    private static void addMediaDescriptionToSession(SessionDescription.Builder builder, MediaDescription.Builder builder2) throws ParserException {
        try {
            builder.addMediaDescription(builder2.build());
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw ParserException.createForMalformedManifest((String) null, e);
        }
    }

    private static MediaDescription.Builder parseMediaDescriptionLine(String str) throws ParserException {
        Matcher matcher = MEDIA_DESCRIPTION_PATTERN.matcher(str);
        if (matcher.matches()) {
            String str2 = (String) Assertions.checkNotNull(matcher.group(1));
            String str3 = (String) Assertions.checkNotNull(matcher.group(2));
            try {
                return new MediaDescription.Builder(str2, Integer.parseInt(str3), (String) Assertions.checkNotNull(matcher.group(3)), Integer.parseInt((String) Assertions.checkNotNull(matcher.group(4))));
            } catch (NumberFormatException e) {
                throw ParserException.createForMalformedManifest("Malformed SDP media description line: " + str, e);
            }
        } else {
            throw ParserException.createForMalformedManifest("Malformed SDP media description line: " + str, (Throwable) null);
        }
    }

    private SessionDescriptionParser() {
    }
}

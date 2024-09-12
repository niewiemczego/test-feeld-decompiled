package com.google.android.exoplayer2.source.rtsp;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableMap;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

final class MediaDescription {
    public static final String MEDIA_TYPE_AUDIO = "audio";
    public static final String MEDIA_TYPE_VIDEO = "video";
    public static final String RTP_AVP_PROFILE = "RTP/AVP";
    public final ImmutableMap<String, String> attributes;
    public final int bitrate;
    public final String connection;
    public final String key;
    public final String mediaTitle;
    public final String mediaType;
    public final int payloadType;
    public final int port;
    public final RtpMapAttribute rtpMapAttribute;
    public final String transportProtocol;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaType {
    }

    public static final class RtpMapAttribute {
        public final int clockRate;
        public final int encodingParameters;
        public final String mediaEncoding;
        public final int payloadType;

        public static RtpMapAttribute parse(String str) throws ParserException {
            String[] splitAtFirst = Util.splitAtFirst(str, " ");
            Assertions.checkArgument(splitAtFirst.length == 2);
            int parseInt = RtspMessageUtil.parseInt(splitAtFirst[0]);
            String[] split = Util.split(splitAtFirst[1].trim(), "/");
            Assertions.checkArgument(split.length >= 2);
            int parseInt2 = RtspMessageUtil.parseInt(split[1]);
            int i = -1;
            if (split.length == 3) {
                i = RtspMessageUtil.parseInt(split[2]);
            }
            return new RtpMapAttribute(parseInt, split[0], parseInt2, i);
        }

        private RtpMapAttribute(int i, String str, int i2, int i3) {
            this.payloadType = i;
            this.mediaEncoding = str;
            this.clockRate = i2;
            this.encodingParameters = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            RtpMapAttribute rtpMapAttribute = (RtpMapAttribute) obj;
            if (this.payloadType == rtpMapAttribute.payloadType && this.mediaEncoding.equals(rtpMapAttribute.mediaEncoding) && this.clockRate == rtpMapAttribute.clockRate && this.encodingParameters == rtpMapAttribute.encodingParameters) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((((JfifUtil.MARKER_EOI + this.payloadType) * 31) + this.mediaEncoding.hashCode()) * 31) + this.clockRate) * 31) + this.encodingParameters;
        }
    }

    public static final class Builder {
        private static final String RTP_MAP_ATTR_AUDIO_FMT = "%d %s/%d/%d";
        private static final int RTP_STATIC_PAYLOAD_TYPE_L16_MONO = 11;
        private static final int RTP_STATIC_PAYLOAD_TYPE_L16_STEREO = 10;
        private static final int RTP_STATIC_PAYLOAD_TYPE_PCMA = 8;
        private static final int RTP_STATIC_PAYLOAD_TYPE_PCMU = 0;
        private final HashMap<String, String> attributes = new HashMap<>();
        /* access modifiers changed from: private */
        public int bitrate = -1;
        /* access modifiers changed from: private */
        public String connection;
        /* access modifiers changed from: private */
        public String key;
        /* access modifiers changed from: private */
        public String mediaTitle;
        /* access modifiers changed from: private */
        public final String mediaType;
        /* access modifiers changed from: private */
        public final int payloadType;
        /* access modifiers changed from: private */
        public final int port;
        /* access modifiers changed from: private */
        public final String transportProtocol;

        public Builder(String str, int i, String str2, int i2) {
            this.mediaType = str;
            this.port = i;
            this.transportProtocol = str2;
            this.payloadType = i2;
        }

        public Builder setMediaTitle(String str) {
            this.mediaTitle = str;
            return this;
        }

        public Builder setConnection(String str) {
            this.connection = str;
            return this;
        }

        public Builder setBitrate(int i) {
            this.bitrate = i;
            return this;
        }

        public Builder setKey(String str) {
            this.key = str;
            return this;
        }

        public Builder addAttribute(String str, String str2) {
            this.attributes.put(str, str2);
            return this;
        }

        public MediaDescription build() {
            RtpMapAttribute rtpMapAttribute;
            try {
                if (this.attributes.containsKey(SessionDescription.ATTR_RTPMAP)) {
                    rtpMapAttribute = RtpMapAttribute.parse((String) Util.castNonNull(this.attributes.get(SessionDescription.ATTR_RTPMAP)));
                } else {
                    rtpMapAttribute = RtpMapAttribute.parse(getRtpMapStringByPayloadType(this.payloadType));
                }
                return new MediaDescription(this, ImmutableMap.copyOf(this.attributes), rtpMapAttribute);
            } catch (ParserException e) {
                throw new IllegalStateException(e);
            }
        }

        private static String getRtpMapStringByPayloadType(int i) {
            Assertions.checkArgument(i < 96);
            if (i == 0) {
                return constructAudioRtpMap(0, "PCMU", 8000, 1);
            }
            if (i == 8) {
                return constructAudioRtpMap(8, "PCMA", 8000, 1);
            }
            if (i == 10) {
                return constructAudioRtpMap(10, "L16", 44100, 2);
            }
            if (i == 11) {
                return constructAudioRtpMap(11, "L16", 44100, 1);
            }
            throw new IllegalStateException("Unsupported static paylod type " + i);
        }

        private static String constructAudioRtpMap(int i, String str, int i2, int i3) {
            return Util.formatInvariant(RTP_MAP_ATTR_AUDIO_FMT, Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    private MediaDescription(Builder builder, ImmutableMap<String, String> immutableMap, RtpMapAttribute rtpMapAttribute2) {
        this.mediaType = builder.mediaType;
        this.port = builder.port;
        this.transportProtocol = builder.transportProtocol;
        this.payloadType = builder.payloadType;
        this.mediaTitle = builder.mediaTitle;
        this.connection = builder.connection;
        this.bitrate = builder.bitrate;
        this.key = builder.key;
        this.attributes = immutableMap;
        this.rtpMapAttribute = rtpMapAttribute2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaDescription mediaDescription = (MediaDescription) obj;
        if (!this.mediaType.equals(mediaDescription.mediaType) || this.port != mediaDescription.port || !this.transportProtocol.equals(mediaDescription.transportProtocol) || this.payloadType != mediaDescription.payloadType || this.bitrate != mediaDescription.bitrate || !this.attributes.equals(mediaDescription.attributes) || !this.rtpMapAttribute.equals(mediaDescription.rtpMapAttribute) || !Util.areEqual(this.mediaTitle, mediaDescription.mediaTitle) || !Util.areEqual(this.connection, mediaDescription.connection) || !Util.areEqual(this.key, mediaDescription.key)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((((((((((JfifUtil.MARKER_EOI + this.mediaType.hashCode()) * 31) + this.port) * 31) + this.transportProtocol.hashCode()) * 31) + this.payloadType) * 31) + this.bitrate) * 31) + this.attributes.hashCode()) * 31) + this.rtpMapAttribute.hashCode()) * 31;
        String str = this.mediaTitle;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.connection;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.key;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public ImmutableMap<String, String> getFmtpParametersAsMap() {
        String str = this.attributes.get(SessionDescription.ATTR_FMTP);
        if (str == null) {
            return ImmutableMap.of();
        }
        String[] splitAtFirst = Util.splitAtFirst(str, " ");
        Assertions.checkArgument(splitAtFirst.length == 2, str);
        String[] split = splitAtFirst[1].split(";\\s?", 0);
        ImmutableMap.Builder builder = new ImmutableMap.Builder();
        for (String splitAtFirst2 : split) {
            String[] splitAtFirst3 = Util.splitAtFirst(splitAtFirst2, "=");
            builder.put(splitAtFirst3[0], splitAtFirst3[1]);
        }
        return builder.buildOrThrow();
    }
}

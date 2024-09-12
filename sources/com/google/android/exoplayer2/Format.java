package com.google.android.exoplayer2;

import android.os.Bundle;
import com.facebook.hermes.intl.Constants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.common.base.Joiner;
import com.oblador.keychain.KeychainModule;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;

public final class Format implements Bundleable {
    public static final Bundleable.Creator<Format> CREATOR = new Format$$ExternalSyntheticLambda0();
    private static final Format DEFAULT = new Builder().build();
    private static final int FIELD_ACCESSIBILITY_CHANNEL = 28;
    private static final int FIELD_AVERAGE_BITRATE = 5;
    private static final int FIELD_CHANNEL_COUNT = 23;
    private static final int FIELD_CODECS = 7;
    private static final int FIELD_COLOR_INFO = 22;
    private static final int FIELD_CONTAINER_MIME_TYPE = 9;
    private static final int FIELD_CRYPTO_TYPE = 29;
    private static final int FIELD_DRM_INIT_DATA = 13;
    private static final int FIELD_ENCODER_DELAY = 26;
    private static final int FIELD_ENCODER_PADDING = 27;
    private static final int FIELD_FRAME_RATE = 17;
    private static final int FIELD_HEIGHT = 16;
    private static final int FIELD_ID = 0;
    private static final int FIELD_INITIALIZATION_DATA = 12;
    private static final int FIELD_LABEL = 1;
    private static final int FIELD_LANGUAGE = 2;
    private static final int FIELD_MAX_INPUT_SIZE = 11;
    private static final int FIELD_METADATA = 8;
    private static final int FIELD_PCM_ENCODING = 25;
    private static final int FIELD_PEAK_BITRATE = 6;
    private static final int FIELD_PIXEL_WIDTH_HEIGHT_RATIO = 19;
    private static final int FIELD_PROJECTION_DATA = 20;
    private static final int FIELD_ROLE_FLAGS = 4;
    private static final int FIELD_ROTATION_DEGREES = 18;
    private static final int FIELD_SAMPLE_MIME_TYPE = 10;
    private static final int FIELD_SAMPLE_RATE = 24;
    private static final int FIELD_SELECTION_FLAGS = 3;
    private static final int FIELD_STEREO_MODE = 21;
    private static final int FIELD_SUBSAMPLE_OFFSET_US = 14;
    private static final int FIELD_WIDTH = 15;
    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = Long.MAX_VALUE;
    public final int accessibilityChannel;
    public final int averageBitrate;
    public final int bitrate;
    public final int channelCount;
    public final String codecs;
    public final ColorInfo colorInfo;
    public final String containerMimeType;
    public final int cryptoType;
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final float frameRate;
    private int hashCode;
    public final int height;
    public final String id;
    public final List<byte[]> initializationData;
    public final String label;
    public final String language;
    public final int maxInputSize;
    public final Metadata metadata;
    public final int pcmEncoding;
    public final int peakBitrate;
    public final float pixelWidthHeightRatio;
    public final byte[] projectionData;
    public final int roleFlags;
    public final int rotationDegrees;
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    private static <T> T defaultIfNull(T t, T t2) {
        return t != null ? t : t2;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public int accessibilityChannel;
        /* access modifiers changed from: private */
        public int averageBitrate;
        /* access modifiers changed from: private */
        public int channelCount;
        /* access modifiers changed from: private */
        public String codecs;
        /* access modifiers changed from: private */
        public ColorInfo colorInfo;
        /* access modifiers changed from: private */
        public String containerMimeType;
        /* access modifiers changed from: private */
        public int cryptoType;
        /* access modifiers changed from: private */
        public DrmInitData drmInitData;
        /* access modifiers changed from: private */
        public int encoderDelay;
        /* access modifiers changed from: private */
        public int encoderPadding;
        /* access modifiers changed from: private */
        public float frameRate;
        /* access modifiers changed from: private */
        public int height;
        /* access modifiers changed from: private */
        public String id;
        /* access modifiers changed from: private */
        public List<byte[]> initializationData;
        /* access modifiers changed from: private */
        public String label;
        /* access modifiers changed from: private */
        public String language;
        /* access modifiers changed from: private */
        public int maxInputSize;
        /* access modifiers changed from: private */
        public Metadata metadata;
        /* access modifiers changed from: private */
        public int pcmEncoding;
        /* access modifiers changed from: private */
        public int peakBitrate;
        /* access modifiers changed from: private */
        public float pixelWidthHeightRatio;
        /* access modifiers changed from: private */
        public byte[] projectionData;
        /* access modifiers changed from: private */
        public int roleFlags;
        /* access modifiers changed from: private */
        public int rotationDegrees;
        /* access modifiers changed from: private */
        public String sampleMimeType;
        /* access modifiers changed from: private */
        public int sampleRate;
        /* access modifiers changed from: private */
        public int selectionFlags;
        /* access modifiers changed from: private */
        public int stereoMode;
        /* access modifiers changed from: private */
        public long subsampleOffsetUs;
        /* access modifiers changed from: private */
        public int width;

        public Builder() {
            this.averageBitrate = -1;
            this.peakBitrate = -1;
            this.maxInputSize = -1;
            this.subsampleOffsetUs = Long.MAX_VALUE;
            this.width = -1;
            this.height = -1;
            this.frameRate = -1.0f;
            this.pixelWidthHeightRatio = 1.0f;
            this.stereoMode = -1;
            this.channelCount = -1;
            this.sampleRate = -1;
            this.pcmEncoding = -1;
            this.accessibilityChannel = -1;
            this.cryptoType = 0;
        }

        private Builder(Format format) {
            this.id = format.id;
            this.label = format.label;
            this.language = format.language;
            this.selectionFlags = format.selectionFlags;
            this.roleFlags = format.roleFlags;
            this.averageBitrate = format.averageBitrate;
            this.peakBitrate = format.peakBitrate;
            this.codecs = format.codecs;
            this.metadata = format.metadata;
            this.containerMimeType = format.containerMimeType;
            this.sampleMimeType = format.sampleMimeType;
            this.maxInputSize = format.maxInputSize;
            this.initializationData = format.initializationData;
            this.drmInitData = format.drmInitData;
            this.subsampleOffsetUs = format.subsampleOffsetUs;
            this.width = format.width;
            this.height = format.height;
            this.frameRate = format.frameRate;
            this.rotationDegrees = format.rotationDegrees;
            this.pixelWidthHeightRatio = format.pixelWidthHeightRatio;
            this.projectionData = format.projectionData;
            this.stereoMode = format.stereoMode;
            this.colorInfo = format.colorInfo;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.pcmEncoding = format.pcmEncoding;
            this.encoderDelay = format.encoderDelay;
            this.encoderPadding = format.encoderPadding;
            this.accessibilityChannel = format.accessibilityChannel;
            this.cryptoType = format.cryptoType;
        }

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public Builder setId(int i) {
            this.id = Integer.toString(i);
            return this;
        }

        public Builder setLabel(String str) {
            this.label = str;
            return this;
        }

        public Builder setLanguage(String str) {
            this.language = str;
            return this;
        }

        public Builder setSelectionFlags(int i) {
            this.selectionFlags = i;
            return this;
        }

        public Builder setRoleFlags(int i) {
            this.roleFlags = i;
            return this;
        }

        public Builder setAverageBitrate(int i) {
            this.averageBitrate = i;
            return this;
        }

        public Builder setPeakBitrate(int i) {
            this.peakBitrate = i;
            return this;
        }

        public Builder setCodecs(String str) {
            this.codecs = str;
            return this;
        }

        public Builder setMetadata(Metadata metadata2) {
            this.metadata = metadata2;
            return this;
        }

        public Builder setContainerMimeType(String str) {
            this.containerMimeType = str;
            return this;
        }

        public Builder setSampleMimeType(String str) {
            this.sampleMimeType = str;
            return this;
        }

        public Builder setMaxInputSize(int i) {
            this.maxInputSize = i;
            return this;
        }

        public Builder setInitializationData(List<byte[]> list) {
            this.initializationData = list;
            return this;
        }

        public Builder setDrmInitData(DrmInitData drmInitData2) {
            this.drmInitData = drmInitData2;
            return this;
        }

        public Builder setSubsampleOffsetUs(long j) {
            this.subsampleOffsetUs = j;
            return this;
        }

        public Builder setWidth(int i) {
            this.width = i;
            return this;
        }

        public Builder setHeight(int i) {
            this.height = i;
            return this;
        }

        public Builder setFrameRate(float f) {
            this.frameRate = f;
            return this;
        }

        public Builder setRotationDegrees(int i) {
            this.rotationDegrees = i;
            return this;
        }

        public Builder setPixelWidthHeightRatio(float f) {
            this.pixelWidthHeightRatio = f;
            return this;
        }

        public Builder setProjectionData(byte[] bArr) {
            this.projectionData = bArr;
            return this;
        }

        public Builder setStereoMode(int i) {
            this.stereoMode = i;
            return this;
        }

        public Builder setColorInfo(ColorInfo colorInfo2) {
            this.colorInfo = colorInfo2;
            return this;
        }

        public Builder setChannelCount(int i) {
            this.channelCount = i;
            return this;
        }

        public Builder setSampleRate(int i) {
            this.sampleRate = i;
            return this;
        }

        public Builder setPcmEncoding(int i) {
            this.pcmEncoding = i;
            return this;
        }

        public Builder setEncoderDelay(int i) {
            this.encoderDelay = i;
            return this;
        }

        public Builder setEncoderPadding(int i) {
            this.encoderPadding = i;
            return this;
        }

        public Builder setAccessibilityChannel(int i) {
            this.accessibilityChannel = i;
            return this;
        }

        public Builder setCryptoType(int i) {
            this.cryptoType = i;
            return this;
        }

        public Format build() {
            return new Format(this);
        }
    }

    @Deprecated
    public static Format createVideoSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, DrmInitData drmInitData2) {
        return new Builder().setId(str).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData2).setWidth(i3).setHeight(i4).setFrameRate(f).build();
    }

    @Deprecated
    public static Format createVideoSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, DrmInitData drmInitData2) {
        return new Builder().setId(str).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData2).setWidth(i3).setHeight(i4).setFrameRate(f).setRotationDegrees(i5).setPixelWidthHeightRatio(f2).build();
    }

    @Deprecated
    public static Format createAudioSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, DrmInitData drmInitData2, int i5, String str4) {
        return new Builder().setId(str).setLanguage(str4).setSelectionFlags(i5).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData2).setChannelCount(i3).setSampleRate(i4).build();
    }

    @Deprecated
    public static Format createAudioSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData2, int i6, String str4) {
        return new Builder().setId(str).setLanguage(str4).setSelectionFlags(i6).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData2).setChannelCount(i3).setSampleRate(i4).setPcmEncoding(i5).build();
    }

    @Deprecated
    public static Format createContainerFormat(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, String str6) {
        return new Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i2).setRoleFlags(i3).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str5).setContainerMimeType(str3).setSampleMimeType(str4).build();
    }

    @Deprecated
    public static Format createSampleFormat(String str, String str2) {
        return new Builder().setId(str).setSampleMimeType(str2).build();
    }

    private Format(Builder builder) {
        this.id = builder.id;
        this.label = builder.label;
        this.language = Util.normalizeLanguageCode(builder.language);
        this.selectionFlags = builder.selectionFlags;
        this.roleFlags = builder.roleFlags;
        int access$600 = builder.averageBitrate;
        this.averageBitrate = access$600;
        int access$700 = builder.peakBitrate;
        this.peakBitrate = access$700;
        this.bitrate = access$700 != -1 ? access$700 : access$600;
        this.codecs = builder.codecs;
        this.metadata = builder.metadata;
        this.containerMimeType = builder.containerMimeType;
        this.sampleMimeType = builder.sampleMimeType;
        this.maxInputSize = builder.maxInputSize;
        this.initializationData = builder.initializationData == null ? Collections.emptyList() : builder.initializationData;
        DrmInitData access$1400 = builder.drmInitData;
        this.drmInitData = access$1400;
        this.subsampleOffsetUs = builder.subsampleOffsetUs;
        this.width = builder.width;
        this.height = builder.height;
        this.frameRate = builder.frameRate;
        int i = 0;
        this.rotationDegrees = builder.rotationDegrees == -1 ? 0 : builder.rotationDegrees;
        this.pixelWidthHeightRatio = builder.pixelWidthHeightRatio == -1.0f ? 1.0f : builder.pixelWidthHeightRatio;
        this.projectionData = builder.projectionData;
        this.stereoMode = builder.stereoMode;
        this.colorInfo = builder.colorInfo;
        this.channelCount = builder.channelCount;
        this.sampleRate = builder.sampleRate;
        this.pcmEncoding = builder.pcmEncoding;
        this.encoderDelay = builder.encoderDelay == -1 ? 0 : builder.encoderDelay;
        this.encoderPadding = builder.encoderPadding != -1 ? builder.encoderPadding : i;
        this.accessibilityChannel = builder.accessibilityChannel;
        if (builder.cryptoType != 0 || access$1400 == null) {
            this.cryptoType = builder.cryptoType;
        } else {
            this.cryptoType = 1;
        }
    }

    public Builder buildUpon() {
        return new Builder();
    }

    @Deprecated
    public Format copyWithMaxInputSize(int i) {
        return buildUpon().setMaxInputSize(i).build();
    }

    @Deprecated
    public Format copyWithSubsampleOffsetUs(long j) {
        return buildUpon().setSubsampleOffsetUs(j).build();
    }

    @Deprecated
    public Format copyWithLabel(String str) {
        return buildUpon().setLabel(str).build();
    }

    @Deprecated
    public Format copyWithManifestFormatInfo(Format format) {
        return withManifestFormatInfo(format);
    }

    public Format withManifestFormatInfo(Format format) {
        Metadata metadata2;
        String str;
        if (this == format) {
            return this;
        }
        int trackType = MimeTypes.getTrackType(this.sampleMimeType);
        String str2 = format.id;
        String str3 = format.label;
        if (str3 == null) {
            str3 = this.label;
        }
        String str4 = this.language;
        if ((trackType == 3 || trackType == 1) && (str = format.language) != null) {
            str4 = str;
        }
        int i = this.averageBitrate;
        if (i == -1) {
            i = format.averageBitrate;
        }
        int i2 = this.peakBitrate;
        if (i2 == -1) {
            i2 = format.peakBitrate;
        }
        String str5 = this.codecs;
        if (str5 == null) {
            String codecsOfType = Util.getCodecsOfType(format.codecs, trackType);
            if (Util.splitCodecs(codecsOfType).length == 1) {
                str5 = codecsOfType;
            }
        }
        Metadata metadata3 = this.metadata;
        if (metadata3 == null) {
            metadata2 = format.metadata;
        } else {
            metadata2 = metadata3.copyWithAppendedEntriesFrom(format.metadata);
        }
        float f = this.frameRate;
        if (f == -1.0f && trackType == 2) {
            f = format.frameRate;
        }
        int i3 = this.selectionFlags | format.selectionFlags;
        int i4 = this.roleFlags | format.roleFlags;
        return buildUpon().setId(str2).setLabel(str3).setLanguage(str4).setSelectionFlags(i3).setRoleFlags(i4).setAverageBitrate(i).setPeakBitrate(i2).setCodecs(str5).setMetadata(metadata2).setDrmInitData(DrmInitData.createSessionCreationData(format.drmInitData, this.drmInitData)).setFrameRate(f).build();
    }

    @Deprecated
    public Format copyWithGaplessInfo(int i, int i2) {
        return buildUpon().setEncoderDelay(i).setEncoderPadding(i2).build();
    }

    @Deprecated
    public Format copyWithFrameRate(float f) {
        return buildUpon().setFrameRate(f).build();
    }

    @Deprecated
    public Format copyWithDrmInitData(DrmInitData drmInitData2) {
        return buildUpon().setDrmInitData(drmInitData2).build();
    }

    @Deprecated
    public Format copyWithMetadata(Metadata metadata2) {
        return buildUpon().setMetadata(metadata2).build();
    }

    @Deprecated
    public Format copyWithBitrate(int i) {
        return buildUpon().setAverageBitrate(i).setPeakBitrate(i).build();
    }

    @Deprecated
    public Format copyWithVideoSize(int i, int i2) {
        return buildUpon().setWidth(i).setHeight(i2).build();
    }

    public Format copyWithCryptoType(int i) {
        return buildUpon().setCryptoType(i).build();
    }

    public int getPixelCount() {
        int i;
        int i2 = this.width;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public String toString() {
        return "Format(" + this.id + ", " + this.label + ", " + this.containerMimeType + ", " + this.sampleMimeType + ", " + this.codecs + ", " + this.bitrate + ", " + this.language + ", [" + this.width + ", " + this.height + ", " + this.frameRate + "], [" + this.channelCount + ", " + this.sampleRate + "])";
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            String str = this.id;
            int i = 0;
            int hashCode2 = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.label;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.language;
            int hashCode4 = (((((((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31) + this.averageBitrate) * 31) + this.peakBitrate) * 31;
            String str4 = this.codecs;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata2 = this.metadata;
            int hashCode6 = (hashCode5 + (metadata2 == null ? 0 : metadata2.hashCode())) * 31;
            String str5 = this.containerMimeType;
            int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.sampleMimeType;
            if (str6 != null) {
                i = str6.hashCode();
            }
            this.hashCode = ((((((((((((((((((((((((((((((hashCode7 + i) * 31) + this.maxInputSize) * 31) + ((int) this.subsampleOffsetUs)) * 31) + this.width) * 31) + this.height) * 31) + Float.floatToIntBits(this.frameRate)) * 31) + this.rotationDegrees) * 31) + Float.floatToIntBits(this.pixelWidthHeightRatio)) * 31) + this.stereoMode) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.pcmEncoding) * 31) + this.encoderDelay) * 31) + this.encoderPadding) * 31) + this.accessibilityChannel) * 31) + this.cryptoType;
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        int i2 = this.hashCode;
        if (i2 != 0 && (i = format.hashCode) != 0 && i2 != i) {
            return false;
        }
        if (this.selectionFlags == format.selectionFlags && this.roleFlags == format.roleFlags && this.averageBitrate == format.averageBitrate && this.peakBitrate == format.peakBitrate && this.maxInputSize == format.maxInputSize && this.subsampleOffsetUs == format.subsampleOffsetUs && this.width == format.width && this.height == format.height && this.rotationDegrees == format.rotationDegrees && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.accessibilityChannel == format.accessibilityChannel && this.cryptoType == format.cryptoType && Float.compare(this.frameRate, format.frameRate) == 0 && Float.compare(this.pixelWidthHeightRatio, format.pixelWidthHeightRatio) == 0 && Util.areEqual(this.id, format.id) && Util.areEqual(this.label, format.label) && Util.areEqual(this.codecs, format.codecs) && Util.areEqual(this.containerMimeType, format.containerMimeType) && Util.areEqual(this.sampleMimeType, format.sampleMimeType) && Util.areEqual(this.language, format.language) && Arrays.equals(this.projectionData, format.projectionData) && Util.areEqual(this.metadata, format.metadata) && Util.areEqual(this.colorInfo, format.colorInfo) && Util.areEqual(this.drmInitData, format.drmInitData) && initializationDataEquals(format)) {
            return true;
        }
        return false;
    }

    public boolean initializationDataEquals(Format format) {
        if (this.initializationData.size() != format.initializationData.size()) {
            return false;
        }
        for (int i = 0; i < this.initializationData.size(); i++) {
            if (!Arrays.equals(this.initializationData.get(i), format.initializationData.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static String toLogString(Format format) {
        if (format == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(format.id).append(", mimeType=").append(format.sampleMimeType);
        if (format.bitrate != -1) {
            sb.append(", bitrate=").append(format.bitrate);
        }
        if (format.codecs != null) {
            sb.append(", codecs=").append(format.codecs);
        }
        if (format.drmInitData != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i = 0; i < format.drmInitData.schemeDataCount; i++) {
                UUID uuid = format.drmInitData.get(i).uuid;
                if (uuid.equals(C.COMMON_PSSH_UUID)) {
                    linkedHashSet.add(C.CENC_TYPE_cenc);
                } else if (uuid.equals(C.CLEARKEY_UUID)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(C.PLAYREADY_UUID)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(C.WIDEVINE_UUID)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(C.UUID_NIL)) {
                    linkedHashSet.add("universal");
                } else {
                    linkedHashSet.add("unknown (" + uuid + ")");
                }
            }
            sb.append(", drm=[");
            Joiner.on(',').appendTo(sb, (Iterable<? extends Object>) linkedHashSet);
            sb.append(']');
        }
        if (!(format.width == -1 || format.height == -1)) {
            sb.append(", res=").append(format.width).append(ViewHierarchyNode.JsonKeys.X).append(format.height);
        }
        if (format.frameRate != -1.0f) {
            sb.append(", fps=").append(format.frameRate);
        }
        if (format.channelCount != -1) {
            sb.append(", channels=").append(format.channelCount);
        }
        if (format.sampleRate != -1) {
            sb.append(", sample_rate=").append(format.sampleRate);
        }
        if (format.language != null) {
            sb.append(", language=").append(format.language);
        }
        if (format.label != null) {
            sb.append(", label=").append(format.label);
        }
        if (format.selectionFlags != 0) {
            ArrayList arrayList = new ArrayList();
            if ((format.selectionFlags & 4) != 0) {
                arrayList.add("auto");
            }
            if ((format.selectionFlags & 1) != 0) {
                arrayList.add(Constants.COLLATION_DEFAULT);
            }
            if ((format.selectionFlags & 2) != 0) {
                arrayList.add("forced");
            }
            sb.append(", selectionFlags=[");
            Joiner.on(',').appendTo(sb, (Iterable<? extends Object>) arrayList);
            sb.append("]");
        }
        if (format.roleFlags != 0) {
            ArrayList arrayList2 = new ArrayList();
            if ((format.roleFlags & 1) != 0) {
                arrayList2.add(SentryThread.JsonKeys.MAIN);
            }
            if ((format.roleFlags & 2) != 0) {
                arrayList2.add("alt");
            }
            if ((format.roleFlags & 4) != 0) {
                arrayList2.add("supplementary");
            }
            if ((format.roleFlags & 8) != 0) {
                arrayList2.add("commentary");
            }
            if ((format.roleFlags & 16) != 0) {
                arrayList2.add("dub");
            }
            if ((format.roleFlags & 32) != 0) {
                arrayList2.add("emergency");
            }
            if ((format.roleFlags & 64) != 0) {
                arrayList2.add(ShareConstants.FEED_CAPTION_PARAM);
            }
            if ((format.roleFlags & 128) != 0) {
                arrayList2.add(KeychainModule.AuthPromptOptions.SUBTITLE);
            }
            if ((format.roleFlags & 256) != 0) {
                arrayList2.add("sign");
            }
            if ((format.roleFlags & 512) != 0) {
                arrayList2.add("describes-video");
            }
            if ((format.roleFlags & 1024) != 0) {
                arrayList2.add("describes-music");
            }
            if ((format.roleFlags & 2048) != 0) {
                arrayList2.add("enhanced-intelligibility");
            }
            if ((format.roleFlags & 4096) != 0) {
                arrayList2.add("transcribes-dialog");
            }
            if ((format.roleFlags & 8192) != 0) {
                arrayList2.add("easy-read");
            }
            if ((format.roleFlags & 16384) != 0) {
                arrayList2.add("trick-play");
            }
            sb.append(", roleFlags=[");
            Joiner.on(',').appendTo(sb, (Iterable<? extends Object>) arrayList2);
            sb.append("]");
        }
        return sb.toString();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(keyForField(0), this.id);
        bundle.putString(keyForField(1), this.label);
        bundle.putString(keyForField(2), this.language);
        bundle.putInt(keyForField(3), this.selectionFlags);
        bundle.putInt(keyForField(4), this.roleFlags);
        bundle.putInt(keyForField(5), this.averageBitrate);
        bundle.putInt(keyForField(6), this.peakBitrate);
        bundle.putString(keyForField(7), this.codecs);
        bundle.putParcelable(keyForField(8), this.metadata);
        bundle.putString(keyForField(9), this.containerMimeType);
        bundle.putString(keyForField(10), this.sampleMimeType);
        bundle.putInt(keyForField(11), this.maxInputSize);
        for (int i = 0; i < this.initializationData.size(); i++) {
            bundle.putByteArray(keyForInitializationData(i), this.initializationData.get(i));
        }
        bundle.putParcelable(keyForField(13), this.drmInitData);
        bundle.putLong(keyForField(14), this.subsampleOffsetUs);
        bundle.putInt(keyForField(15), this.width);
        bundle.putInt(keyForField(16), this.height);
        bundle.putFloat(keyForField(17), this.frameRate);
        bundle.putInt(keyForField(18), this.rotationDegrees);
        bundle.putFloat(keyForField(19), this.pixelWidthHeightRatio);
        bundle.putByteArray(keyForField(20), this.projectionData);
        bundle.putInt(keyForField(21), this.stereoMode);
        if (this.colorInfo != null) {
            bundle.putBundle(keyForField(22), this.colorInfo.toBundle());
        }
        bundle.putInt(keyForField(23), this.channelCount);
        bundle.putInt(keyForField(24), this.sampleRate);
        bundle.putInt(keyForField(25), this.pcmEncoding);
        bundle.putInt(keyForField(26), this.encoderDelay);
        bundle.putInt(keyForField(27), this.encoderPadding);
        bundle.putInt(keyForField(28), this.accessibilityChannel);
        bundle.putInt(keyForField(29), this.cryptoType);
        return bundle;
    }

    /* access modifiers changed from: private */
    public static Format fromBundle(Bundle bundle) {
        Builder builder = new Builder();
        BundleableUtil.ensureClassLoader(bundle);
        int i = 0;
        String string = bundle.getString(keyForField(0));
        Format format = DEFAULT;
        builder.setId((String) defaultIfNull(string, format.id)).setLabel((String) defaultIfNull(bundle.getString(keyForField(1)), format.label)).setLanguage((String) defaultIfNull(bundle.getString(keyForField(2)), format.language)).setSelectionFlags(bundle.getInt(keyForField(3), format.selectionFlags)).setRoleFlags(bundle.getInt(keyForField(4), format.roleFlags)).setAverageBitrate(bundle.getInt(keyForField(5), format.averageBitrate)).setPeakBitrate(bundle.getInt(keyForField(6), format.peakBitrate)).setCodecs((String) defaultIfNull(bundle.getString(keyForField(7)), format.codecs)).setMetadata((Metadata) defaultIfNull((Metadata) bundle.getParcelable(keyForField(8)), format.metadata)).setContainerMimeType((String) defaultIfNull(bundle.getString(keyForField(9)), format.containerMimeType)).setSampleMimeType((String) defaultIfNull(bundle.getString(keyForField(10)), format.sampleMimeType)).setMaxInputSize(bundle.getInt(keyForField(11), format.maxInputSize));
        ArrayList arrayList = new ArrayList();
        while (true) {
            byte[] byteArray = bundle.getByteArray(keyForInitializationData(i));
            if (byteArray == null) {
                break;
            }
            arrayList.add(byteArray);
            i++;
        }
        Builder drmInitData2 = builder.setInitializationData(arrayList).setDrmInitData((DrmInitData) bundle.getParcelable(keyForField(13)));
        String keyForField = keyForField(14);
        Format format2 = DEFAULT;
        drmInitData2.setSubsampleOffsetUs(bundle.getLong(keyForField, format2.subsampleOffsetUs)).setWidth(bundle.getInt(keyForField(15), format2.width)).setHeight(bundle.getInt(keyForField(16), format2.height)).setFrameRate(bundle.getFloat(keyForField(17), format2.frameRate)).setRotationDegrees(bundle.getInt(keyForField(18), format2.rotationDegrees)).setPixelWidthHeightRatio(bundle.getFloat(keyForField(19), format2.pixelWidthHeightRatio)).setProjectionData(bundle.getByteArray(keyForField(20))).setStereoMode(bundle.getInt(keyForField(21), format2.stereoMode));
        Bundle bundle2 = bundle.getBundle(keyForField(22));
        if (bundle2 != null) {
            builder.setColorInfo(ColorInfo.CREATOR.fromBundle(bundle2));
        }
        builder.setChannelCount(bundle.getInt(keyForField(23), format2.channelCount)).setSampleRate(bundle.getInt(keyForField(24), format2.sampleRate)).setPcmEncoding(bundle.getInt(keyForField(25), format2.pcmEncoding)).setEncoderDelay(bundle.getInt(keyForField(26), format2.encoderDelay)).setEncoderPadding(bundle.getInt(keyForField(27), format2.encoderPadding)).setAccessibilityChannel(bundle.getInt(keyForField(28), format2.accessibilityChannel)).setCryptoType(bundle.getInt(keyForField(29), format2.cryptoType));
        return builder.build();
    }

    private static String keyForField(int i) {
        return Integer.toString(i, 36);
    }

    private static String keyForInitializationData(int i) {
        return keyForField(12) + "_" + Integer.toString(i, 36);
    }
}

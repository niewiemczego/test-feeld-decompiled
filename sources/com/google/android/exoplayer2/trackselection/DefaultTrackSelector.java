package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Predicate;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class DefaultTrackSelector extends MappingTrackSelector {
    private static final String AUDIO_CHANNEL_COUNT_CONSTRAINTS_WARN_MESSAGE = "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.";
    /* access modifiers changed from: private */
    public static final Ordering<Integer> FORMAT_VALUE_ORDERING = Ordering.from(new DefaultTrackSelector$$ExternalSyntheticLambda2());
    private static final float FRACTION_TO_CONSIDER_FULLSCREEN = 0.98f;
    /* access modifiers changed from: private */
    public static final Ordering<Integer> NO_ORDER = Ordering.from(new DefaultTrackSelector$$ExternalSyntheticLambda3());
    protected static final int SELECTION_ELIGIBILITY_ADAPTIVE = 2;
    protected static final int SELECTION_ELIGIBILITY_FIXED = 1;
    protected static final int SELECTION_ELIGIBILITY_NO = 0;
    private static final String TAG = "DefaultTrackSelector";
    private AudioAttributes audioAttributes;
    public final Context context;
    private final boolean deviceIsTV;
    private final Object lock;
    private Parameters parameters;
    private SpatializerWrapperV32 spatializer;
    private final ExoTrackSelection.Factory trackSelectionFactory;

    static /* synthetic */ int lambda$static$1(Integer num, Integer num2) {
        return 0;
    }

    public boolean isSetParametersSupported() {
        return true;
    }

    @Deprecated
    public static final class ParametersBuilder extends TrackSelectionParameters.Builder {
        private final Parameters.Builder delegate;

        @Deprecated
        public ParametersBuilder() {
            this.delegate = new Parameters.Builder();
        }

        public ParametersBuilder(Context context) {
            this.delegate = new Parameters.Builder(context);
        }

        /* access modifiers changed from: protected */
        public ParametersBuilder set(TrackSelectionParameters trackSelectionParameters) {
            this.delegate.set(trackSelectionParameters);
            return this;
        }

        public ParametersBuilder setMaxVideoSizeSd() {
            this.delegate.setMaxVideoSizeSd();
            return this;
        }

        public ParametersBuilder clearVideoSizeConstraints() {
            this.delegate.clearVideoSizeConstraints();
            return this;
        }

        public ParametersBuilder setMaxVideoSize(int i, int i2) {
            this.delegate.setMaxVideoSize(i, i2);
            return this;
        }

        public ParametersBuilder setMaxVideoFrameRate(int i) {
            this.delegate.setMaxVideoFrameRate(i);
            return this;
        }

        public ParametersBuilder setMaxVideoBitrate(int i) {
            this.delegate.setMaxVideoBitrate(i);
            return this;
        }

        public ParametersBuilder setMinVideoSize(int i, int i2) {
            this.delegate.setMinVideoSize(i, i2);
            return this;
        }

        public ParametersBuilder setMinVideoFrameRate(int i) {
            this.delegate.setMinVideoFrameRate(i);
            return this;
        }

        public ParametersBuilder setMinVideoBitrate(int i) {
            this.delegate.setMinVideoBitrate(i);
            return this;
        }

        public ParametersBuilder setExceedVideoConstraintsIfNecessary(boolean z) {
            this.delegate.setExceedVideoConstraintsIfNecessary(z);
            return this;
        }

        public ParametersBuilder setAllowVideoMixedMimeTypeAdaptiveness(boolean z) {
            this.delegate.setAllowVideoMixedMimeTypeAdaptiveness(z);
            return this;
        }

        public ParametersBuilder setAllowVideoNonSeamlessAdaptiveness(boolean z) {
            this.delegate.setAllowVideoNonSeamlessAdaptiveness(z);
            return this;
        }

        public ParametersBuilder setAllowVideoMixedDecoderSupportAdaptiveness(boolean z) {
            this.delegate.setAllowVideoMixedDecoderSupportAdaptiveness(z);
            return this;
        }

        public ParametersBuilder setViewportSizeToPhysicalDisplaySize(Context context, boolean z) {
            this.delegate.setViewportSizeToPhysicalDisplaySize(context, z);
            return this;
        }

        public ParametersBuilder clearViewportSizeConstraints() {
            this.delegate.clearViewportSizeConstraints();
            return this;
        }

        public ParametersBuilder setViewportSize(int i, int i2, boolean z) {
            this.delegate.setViewportSize(i, i2, z);
            return this;
        }

        public ParametersBuilder setPreferredVideoMimeType(String str) {
            this.delegate.setPreferredVideoMimeType(str);
            return this;
        }

        public ParametersBuilder setPreferredVideoMimeTypes(String... strArr) {
            this.delegate.setPreferredVideoMimeTypes(strArr);
            return this;
        }

        public ParametersBuilder setPreferredVideoRoleFlags(int i) {
            this.delegate.setPreferredVideoRoleFlags(i);
            return this;
        }

        public ParametersBuilder setPreferredAudioLanguage(String str) {
            this.delegate.setPreferredAudioLanguage(str);
            return this;
        }

        public ParametersBuilder setPreferredAudioLanguages(String... strArr) {
            this.delegate.setPreferredAudioLanguages(strArr);
            return this;
        }

        public ParametersBuilder setPreferredAudioRoleFlags(int i) {
            this.delegate.setPreferredAudioRoleFlags(i);
            return this;
        }

        public ParametersBuilder setMaxAudioChannelCount(int i) {
            this.delegate.setMaxAudioChannelCount(i);
            return this;
        }

        public ParametersBuilder setMaxAudioBitrate(int i) {
            this.delegate.setMaxAudioBitrate(i);
            return this;
        }

        public ParametersBuilder setExceedAudioConstraintsIfNecessary(boolean z) {
            this.delegate.setExceedAudioConstraintsIfNecessary(z);
            return this;
        }

        public ParametersBuilder setAllowAudioMixedMimeTypeAdaptiveness(boolean z) {
            this.delegate.setAllowAudioMixedMimeTypeAdaptiveness(z);
            return this;
        }

        public ParametersBuilder setAllowAudioMixedSampleRateAdaptiveness(boolean z) {
            this.delegate.setAllowAudioMixedSampleRateAdaptiveness(z);
            return this;
        }

        public ParametersBuilder setAllowAudioMixedChannelCountAdaptiveness(boolean z) {
            this.delegate.setAllowAudioMixedChannelCountAdaptiveness(z);
            return this;
        }

        public ParametersBuilder setAllowAudioMixedDecoderSupportAdaptiveness(boolean z) {
            this.delegate.setAllowAudioMixedDecoderSupportAdaptiveness(z);
            return this;
        }

        public ParametersBuilder setPreferredAudioMimeType(String str) {
            this.delegate.setPreferredAudioMimeType(str);
            return this;
        }

        public ParametersBuilder setPreferredAudioMimeTypes(String... strArr) {
            this.delegate.setPreferredAudioMimeTypes(strArr);
            return this;
        }

        public ParametersBuilder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            this.delegate.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
            return this;
        }

        public ParametersBuilder setPreferredTextLanguage(String str) {
            this.delegate.setPreferredTextLanguage(str);
            return this;
        }

        public ParametersBuilder setPreferredTextLanguages(String... strArr) {
            this.delegate.setPreferredTextLanguages(strArr);
            return this;
        }

        public ParametersBuilder setPreferredTextRoleFlags(int i) {
            this.delegate.setPreferredTextRoleFlags(i);
            return this;
        }

        public ParametersBuilder setIgnoredTextSelectionFlags(int i) {
            this.delegate.setIgnoredTextSelectionFlags(i);
            return this;
        }

        public ParametersBuilder setSelectUndeterminedTextLanguage(boolean z) {
            this.delegate.setSelectUndeterminedTextLanguage(z);
            return this;
        }

        @Deprecated
        public ParametersBuilder setDisabledTextTrackSelectionFlags(int i) {
            this.delegate.setDisabledTextTrackSelectionFlags(i);
            return this;
        }

        public ParametersBuilder setForceLowestBitrate(boolean z) {
            this.delegate.setForceLowestBitrate(z);
            return this;
        }

        public ParametersBuilder setForceHighestSupportedBitrate(boolean z) {
            this.delegate.setForceHighestSupportedBitrate(z);
            return this;
        }

        public ParametersBuilder addOverride(TrackSelectionOverride trackSelectionOverride) {
            this.delegate.addOverride(trackSelectionOverride);
            return this;
        }

        public ParametersBuilder clearOverride(TrackGroup trackGroup) {
            this.delegate.clearOverride(trackGroup);
            return this;
        }

        public ParametersBuilder setOverrideForType(TrackSelectionOverride trackSelectionOverride) {
            this.delegate.setOverrideForType(trackSelectionOverride);
            return this;
        }

        public ParametersBuilder clearOverridesOfType(int i) {
            this.delegate.clearOverridesOfType(i);
            return this;
        }

        public ParametersBuilder clearOverrides() {
            this.delegate.clearOverrides();
            return this;
        }

        @Deprecated
        public ParametersBuilder setDisabledTrackTypes(Set<Integer> set) {
            this.delegate.setDisabledTrackTypes(set);
            return this;
        }

        public ParametersBuilder setTrackTypeDisabled(int i, boolean z) {
            this.delegate.setTrackTypeDisabled(i, z);
            return this;
        }

        public ParametersBuilder setExceedRendererCapabilitiesIfNecessary(boolean z) {
            this.delegate.setExceedRendererCapabilitiesIfNecessary(z);
            return this;
        }

        public ParametersBuilder setTunnelingEnabled(boolean z) {
            this.delegate.setTunnelingEnabled(z);
            return this;
        }

        public ParametersBuilder setAllowMultipleAdaptiveSelections(boolean z) {
            this.delegate.setAllowMultipleAdaptiveSelections(z);
            return this;
        }

        public ParametersBuilder setRendererDisabled(int i, boolean z) {
            this.delegate.setRendererDisabled(i, z);
            return this;
        }

        @Deprecated
        public ParametersBuilder setSelectionOverride(int i, TrackGroupArray trackGroupArray, SelectionOverride selectionOverride) {
            this.delegate.setSelectionOverride(i, trackGroupArray, selectionOverride);
            return this;
        }

        @Deprecated
        public ParametersBuilder clearSelectionOverride(int i, TrackGroupArray trackGroupArray) {
            this.delegate.clearSelectionOverride(i, trackGroupArray);
            return this;
        }

        @Deprecated
        public ParametersBuilder clearSelectionOverrides(int i) {
            this.delegate.clearSelectionOverrides(i);
            return this;
        }

        @Deprecated
        public ParametersBuilder clearSelectionOverrides() {
            this.delegate.clearSelectionOverrides();
            return this;
        }

        public Parameters build() {
            return this.delegate.build();
        }
    }

    public static final class Parameters extends TrackSelectionParameters implements Bundleable {
        public static final Bundleable.Creator<Parameters> CREATOR = new DefaultTrackSelector$Parameters$$ExternalSyntheticLambda0();
        @Deprecated
        public static final Parameters DEFAULT;
        public static final Parameters DEFAULT_WITHOUT_CONTEXT;
        private static final int FIELD_ALLOW_AUDIO_MIXED_CHANNEL_COUNT_ADAPTIVENESS = 1006;
        private static final int FIELD_ALLOW_AUDIO_MIXED_DECODER_SUPPORT_ADAPTIVENESS = 1015;
        private static final int FIELD_ALLOW_AUDIO_MIXED_MIME_TYPE_ADAPTIVENESS = 1004;
        private static final int FIELD_ALLOW_AUDIO_MIXED_SAMPLE_RATE_ADAPTIVENESS = 1005;
        private static final int FIELD_ALLOW_MULTIPLE_ADAPTIVE_SELECTIONS = 1009;
        private static final int FIELD_ALLOW_VIDEO_MIXED_DECODER_SUPPORT_ADAPTIVENESS = 1014;
        private static final int FIELD_ALLOW_VIDEO_MIXED_MIME_TYPE_ADAPTIVENESS = 1001;
        private static final int FIELD_ALLOW_VIDEO_NON_SEAMLESS_ADAPTIVENESS = 1002;
        private static final int FIELD_CONSTRAIN_AUDIO_CHANNEL_COUNT_TO_DEVICE_CAPABILITIES = 1016;
        private static final int FIELD_EXCEED_AUDIO_CONSTRAINTS_IF_NCESSARY = 1003;
        private static final int FIELD_EXCEED_RENDERER_CAPABILITIES_IF_NECESSARY = 1007;
        private static final int FIELD_EXCEED_VIDEO_CONSTRAINTS_IF_NECESSARY = 1000;
        private static final int FIELD_RENDERER_DISABLED_INDICES = 1013;
        private static final int FIELD_SELECTION_OVERRIDES = 1012;
        private static final int FIELD_SELECTION_OVERRIDES_RENDERER_INDICES = 1010;
        private static final int FIELD_SELECTION_OVERRIDES_TRACK_GROUP_ARRAYS = 1011;
        private static final int FIELD_TUNNELING_ENABLED = 1008;
        public final boolean allowAudioMixedChannelCountAdaptiveness;
        public final boolean allowAudioMixedDecoderSupportAdaptiveness;
        public final boolean allowAudioMixedMimeTypeAdaptiveness;
        public final boolean allowAudioMixedSampleRateAdaptiveness;
        public final boolean allowMultipleAdaptiveSelections;
        public final boolean allowVideoMixedDecoderSupportAdaptiveness;
        public final boolean allowVideoMixedMimeTypeAdaptiveness;
        public final boolean allowVideoNonSeamlessAdaptiveness;
        public final boolean constrainAudioChannelCountToDeviceCapabilities;
        public final boolean exceedAudioConstraintsIfNecessary;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        /* access modifiers changed from: private */
        public final SparseBooleanArray rendererDisabledFlags;
        /* access modifiers changed from: private */
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
        public final boolean tunnelingEnabled;

        public static final class Builder extends TrackSelectionParameters.Builder {
            /* access modifiers changed from: private */
            public boolean allowAudioMixedChannelCountAdaptiveness;
            /* access modifiers changed from: private */
            public boolean allowAudioMixedDecoderSupportAdaptiveness;
            /* access modifiers changed from: private */
            public boolean allowAudioMixedMimeTypeAdaptiveness;
            /* access modifiers changed from: private */
            public boolean allowAudioMixedSampleRateAdaptiveness;
            /* access modifiers changed from: private */
            public boolean allowMultipleAdaptiveSelections;
            /* access modifiers changed from: private */
            public boolean allowVideoMixedDecoderSupportAdaptiveness;
            /* access modifiers changed from: private */
            public boolean allowVideoMixedMimeTypeAdaptiveness;
            /* access modifiers changed from: private */
            public boolean allowVideoNonSeamlessAdaptiveness;
            /* access modifiers changed from: private */
            public boolean constrainAudioChannelCountToDeviceCapabilities;
            /* access modifiers changed from: private */
            public boolean exceedAudioConstraintsIfNecessary;
            /* access modifiers changed from: private */
            public boolean exceedRendererCapabilitiesIfNecessary;
            /* access modifiers changed from: private */
            public boolean exceedVideoConstraintsIfNecessary;
            /* access modifiers changed from: private */
            public final SparseBooleanArray rendererDisabledFlags;
            /* access modifiers changed from: private */
            public final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
            /* access modifiers changed from: private */
            public boolean tunnelingEnabled;

            @Deprecated
            public Builder() {
                this.selectionOverrides = new SparseArray<>();
                this.rendererDisabledFlags = new SparseBooleanArray();
                init();
            }

            public Builder(Context context) {
                super(context);
                this.selectionOverrides = new SparseArray<>();
                this.rendererDisabledFlags = new SparseBooleanArray();
                init();
            }

            private Builder(Parameters parameters) {
                super((TrackSelectionParameters) parameters);
                this.exceedVideoConstraintsIfNecessary = parameters.exceedVideoConstraintsIfNecessary;
                this.allowVideoMixedMimeTypeAdaptiveness = parameters.allowVideoMixedMimeTypeAdaptiveness;
                this.allowVideoNonSeamlessAdaptiveness = parameters.allowVideoNonSeamlessAdaptiveness;
                this.allowVideoMixedDecoderSupportAdaptiveness = parameters.allowVideoMixedDecoderSupportAdaptiveness;
                this.exceedAudioConstraintsIfNecessary = parameters.exceedAudioConstraintsIfNecessary;
                this.allowAudioMixedMimeTypeAdaptiveness = parameters.allowAudioMixedMimeTypeAdaptiveness;
                this.allowAudioMixedSampleRateAdaptiveness = parameters.allowAudioMixedSampleRateAdaptiveness;
                this.allowAudioMixedChannelCountAdaptiveness = parameters.allowAudioMixedChannelCountAdaptiveness;
                this.allowAudioMixedDecoderSupportAdaptiveness = parameters.allowAudioMixedDecoderSupportAdaptiveness;
                this.constrainAudioChannelCountToDeviceCapabilities = parameters.constrainAudioChannelCountToDeviceCapabilities;
                this.exceedRendererCapabilitiesIfNecessary = parameters.exceedRendererCapabilitiesIfNecessary;
                this.tunnelingEnabled = parameters.tunnelingEnabled;
                this.allowMultipleAdaptiveSelections = parameters.allowMultipleAdaptiveSelections;
                this.selectionOverrides = cloneSelectionOverrides(parameters.selectionOverrides);
                this.rendererDisabledFlags = parameters.rendererDisabledFlags.clone();
            }

            private Builder(Bundle bundle) {
                super(bundle);
                init();
                Parameters parameters = Parameters.DEFAULT_WITHOUT_CONTEXT;
                setExceedVideoConstraintsIfNecessary(bundle.getBoolean(Parameters.keyForField(1000), parameters.exceedVideoConstraintsIfNecessary));
                setAllowVideoMixedMimeTypeAdaptiveness(bundle.getBoolean(Parameters.keyForField(1001), parameters.allowVideoMixedMimeTypeAdaptiveness));
                setAllowVideoNonSeamlessAdaptiveness(bundle.getBoolean(Parameters.keyForField(1002), parameters.allowVideoNonSeamlessAdaptiveness));
                setAllowVideoMixedDecoderSupportAdaptiveness(bundle.getBoolean(Parameters.keyForField(1014), parameters.allowVideoMixedDecoderSupportAdaptiveness));
                setExceedAudioConstraintsIfNecessary(bundle.getBoolean(Parameters.keyForField(1003), parameters.exceedAudioConstraintsIfNecessary));
                setAllowAudioMixedMimeTypeAdaptiveness(bundle.getBoolean(Parameters.keyForField(1004), parameters.allowAudioMixedMimeTypeAdaptiveness));
                setAllowAudioMixedSampleRateAdaptiveness(bundle.getBoolean(Parameters.keyForField(1005), parameters.allowAudioMixedSampleRateAdaptiveness));
                setAllowAudioMixedChannelCountAdaptiveness(bundle.getBoolean(Parameters.keyForField(1006), parameters.allowAudioMixedChannelCountAdaptiveness));
                setAllowAudioMixedDecoderSupportAdaptiveness(bundle.getBoolean(Parameters.keyForField(1015), parameters.allowAudioMixedDecoderSupportAdaptiveness));
                setConstrainAudioChannelCountToDeviceCapabilities(bundle.getBoolean(Parameters.keyForField(1016), parameters.constrainAudioChannelCountToDeviceCapabilities));
                setExceedRendererCapabilitiesIfNecessary(bundle.getBoolean(Parameters.keyForField(1007), parameters.exceedRendererCapabilitiesIfNecessary));
                setTunnelingEnabled(bundle.getBoolean(Parameters.keyForField(1008), parameters.tunnelingEnabled));
                setAllowMultipleAdaptiveSelections(bundle.getBoolean(Parameters.keyForField(1009), parameters.allowMultipleAdaptiveSelections));
                this.selectionOverrides = new SparseArray<>();
                setSelectionOverridesFromBundle(bundle);
                this.rendererDisabledFlags = makeSparseBooleanArrayFromTrueKeys(bundle.getIntArray(Parameters.keyForField(1013)));
            }

            /* access modifiers changed from: protected */
            public Builder set(TrackSelectionParameters trackSelectionParameters) {
                super.set(trackSelectionParameters);
                return this;
            }

            public Builder setMaxVideoSizeSd() {
                super.setMaxVideoSizeSd();
                return this;
            }

            public Builder clearVideoSizeConstraints() {
                super.clearVideoSizeConstraints();
                return this;
            }

            public Builder setMaxVideoSize(int i, int i2) {
                super.setMaxVideoSize(i, i2);
                return this;
            }

            public Builder setMaxVideoFrameRate(int i) {
                super.setMaxVideoFrameRate(i);
                return this;
            }

            public Builder setMaxVideoBitrate(int i) {
                super.setMaxVideoBitrate(i);
                return this;
            }

            public Builder setMinVideoSize(int i, int i2) {
                super.setMinVideoSize(i, i2);
                return this;
            }

            public Builder setMinVideoFrameRate(int i) {
                super.setMinVideoFrameRate(i);
                return this;
            }

            public Builder setMinVideoBitrate(int i) {
                super.setMinVideoBitrate(i);
                return this;
            }

            public Builder setExceedVideoConstraintsIfNecessary(boolean z) {
                this.exceedVideoConstraintsIfNecessary = z;
                return this;
            }

            public Builder setAllowVideoMixedMimeTypeAdaptiveness(boolean z) {
                this.allowVideoMixedMimeTypeAdaptiveness = z;
                return this;
            }

            public Builder setAllowVideoNonSeamlessAdaptiveness(boolean z) {
                this.allowVideoNonSeamlessAdaptiveness = z;
                return this;
            }

            public Builder setAllowVideoMixedDecoderSupportAdaptiveness(boolean z) {
                this.allowVideoMixedDecoderSupportAdaptiveness = z;
                return this;
            }

            public Builder setViewportSizeToPhysicalDisplaySize(Context context, boolean z) {
                super.setViewportSizeToPhysicalDisplaySize(context, z);
                return this;
            }

            public Builder clearViewportSizeConstraints() {
                super.clearViewportSizeConstraints();
                return this;
            }

            public Builder setViewportSize(int i, int i2, boolean z) {
                super.setViewportSize(i, i2, z);
                return this;
            }

            public Builder setPreferredVideoMimeType(String str) {
                super.setPreferredVideoMimeType(str);
                return this;
            }

            public Builder setPreferredVideoMimeTypes(String... strArr) {
                super.setPreferredVideoMimeTypes(strArr);
                return this;
            }

            public Builder setPreferredVideoRoleFlags(int i) {
                super.setPreferredVideoRoleFlags(i);
                return this;
            }

            public Builder setPreferredAudioLanguage(String str) {
                super.setPreferredAudioLanguage(str);
                return this;
            }

            public Builder setPreferredAudioLanguages(String... strArr) {
                super.setPreferredAudioLanguages(strArr);
                return this;
            }

            public Builder setPreferredAudioRoleFlags(int i) {
                super.setPreferredAudioRoleFlags(i);
                return this;
            }

            public Builder setMaxAudioChannelCount(int i) {
                super.setMaxAudioChannelCount(i);
                return this;
            }

            public Builder setMaxAudioBitrate(int i) {
                super.setMaxAudioBitrate(i);
                return this;
            }

            public Builder setExceedAudioConstraintsIfNecessary(boolean z) {
                this.exceedAudioConstraintsIfNecessary = z;
                return this;
            }

            public Builder setAllowAudioMixedMimeTypeAdaptiveness(boolean z) {
                this.allowAudioMixedMimeTypeAdaptiveness = z;
                return this;
            }

            public Builder setAllowAudioMixedSampleRateAdaptiveness(boolean z) {
                this.allowAudioMixedSampleRateAdaptiveness = z;
                return this;
            }

            public Builder setAllowAudioMixedChannelCountAdaptiveness(boolean z) {
                this.allowAudioMixedChannelCountAdaptiveness = z;
                return this;
            }

            public Builder setAllowAudioMixedDecoderSupportAdaptiveness(boolean z) {
                this.allowAudioMixedDecoderSupportAdaptiveness = z;
                return this;
            }

            public Builder setPreferredAudioMimeType(String str) {
                super.setPreferredAudioMimeType(str);
                return this;
            }

            public Builder setPreferredAudioMimeTypes(String... strArr) {
                super.setPreferredAudioMimeTypes(strArr);
                return this;
            }

            public Builder setConstrainAudioChannelCountToDeviceCapabilities(boolean z) {
                this.constrainAudioChannelCountToDeviceCapabilities = z;
                return this;
            }

            public Builder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
                super.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
                return this;
            }

            public Builder setPreferredTextLanguage(String str) {
                super.setPreferredTextLanguage(str);
                return this;
            }

            public Builder setPreferredTextLanguages(String... strArr) {
                super.setPreferredTextLanguages(strArr);
                return this;
            }

            public Builder setPreferredTextRoleFlags(int i) {
                super.setPreferredTextRoleFlags(i);
                return this;
            }

            public Builder setIgnoredTextSelectionFlags(int i) {
                super.setIgnoredTextSelectionFlags(i);
                return this;
            }

            public Builder setSelectUndeterminedTextLanguage(boolean z) {
                super.setSelectUndeterminedTextLanguage(z);
                return this;
            }

            @Deprecated
            public Builder setDisabledTextTrackSelectionFlags(int i) {
                return setIgnoredTextSelectionFlags(i);
            }

            public Builder setForceLowestBitrate(boolean z) {
                super.setForceLowestBitrate(z);
                return this;
            }

            public Builder setForceHighestSupportedBitrate(boolean z) {
                super.setForceHighestSupportedBitrate(z);
                return this;
            }

            public Builder addOverride(TrackSelectionOverride trackSelectionOverride) {
                super.addOverride(trackSelectionOverride);
                return this;
            }

            public Builder clearOverride(TrackGroup trackGroup) {
                super.clearOverride(trackGroup);
                return this;
            }

            public Builder setOverrideForType(TrackSelectionOverride trackSelectionOverride) {
                super.setOverrideForType(trackSelectionOverride);
                return this;
            }

            public Builder clearOverridesOfType(int i) {
                super.clearOverridesOfType(i);
                return this;
            }

            public Builder clearOverrides() {
                super.clearOverrides();
                return this;
            }

            @Deprecated
            public Builder setDisabledTrackTypes(Set<Integer> set) {
                super.setDisabledTrackTypes(set);
                return this;
            }

            public Builder setTrackTypeDisabled(int i, boolean z) {
                super.setTrackTypeDisabled(i, z);
                return this;
            }

            public Builder setExceedRendererCapabilitiesIfNecessary(boolean z) {
                this.exceedRendererCapabilitiesIfNecessary = z;
                return this;
            }

            public Builder setTunnelingEnabled(boolean z) {
                this.tunnelingEnabled = z;
                return this;
            }

            public Builder setAllowMultipleAdaptiveSelections(boolean z) {
                this.allowMultipleAdaptiveSelections = z;
                return this;
            }

            public Builder setRendererDisabled(int i, boolean z) {
                if (this.rendererDisabledFlags.get(i) == z) {
                    return this;
                }
                if (z) {
                    this.rendererDisabledFlags.put(i, true);
                } else {
                    this.rendererDisabledFlags.delete(i);
                }
                return this;
            }

            @Deprecated
            public Builder setSelectionOverride(int i, TrackGroupArray trackGroupArray, SelectionOverride selectionOverride) {
                Map map = this.selectionOverrides.get(i);
                if (map == null) {
                    map = new HashMap();
                    this.selectionOverrides.put(i, map);
                }
                if (map.containsKey(trackGroupArray) && Util.areEqual(map.get(trackGroupArray), selectionOverride)) {
                    return this;
                }
                map.put(trackGroupArray, selectionOverride);
                return this;
            }

            @Deprecated
            public Builder clearSelectionOverride(int i, TrackGroupArray trackGroupArray) {
                Map map = this.selectionOverrides.get(i);
                if (map != null && map.containsKey(trackGroupArray)) {
                    map.remove(trackGroupArray);
                    if (map.isEmpty()) {
                        this.selectionOverrides.remove(i);
                    }
                }
                return this;
            }

            @Deprecated
            public Builder clearSelectionOverrides(int i) {
                Map map = this.selectionOverrides.get(i);
                if (map != null && !map.isEmpty()) {
                    this.selectionOverrides.remove(i);
                }
                return this;
            }

            @Deprecated
            public Builder clearSelectionOverrides() {
                if (this.selectionOverrides.size() == 0) {
                    return this;
                }
                this.selectionOverrides.clear();
                return this;
            }

            public Parameters build() {
                return new Parameters(this);
            }

            private void init() {
                this.exceedVideoConstraintsIfNecessary = true;
                this.allowVideoMixedMimeTypeAdaptiveness = false;
                this.allowVideoNonSeamlessAdaptiveness = true;
                this.allowVideoMixedDecoderSupportAdaptiveness = false;
                this.exceedAudioConstraintsIfNecessary = true;
                this.allowAudioMixedMimeTypeAdaptiveness = false;
                this.allowAudioMixedSampleRateAdaptiveness = false;
                this.allowAudioMixedChannelCountAdaptiveness = false;
                this.allowAudioMixedDecoderSupportAdaptiveness = false;
                this.constrainAudioChannelCountToDeviceCapabilities = true;
                this.exceedRendererCapabilitiesIfNecessary = true;
                this.tunnelingEnabled = false;
                this.allowMultipleAdaptiveSelections = true;
            }

            private static SparseArray<Map<TrackGroupArray, SelectionOverride>> cloneSelectionOverrides(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
                SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2 = new SparseArray<>();
                for (int i = 0; i < sparseArray.size(); i++) {
                    sparseArray2.put(sparseArray.keyAt(i), new HashMap(sparseArray.valueAt(i)));
                }
                return sparseArray2;
            }

            private void setSelectionOverridesFromBundle(Bundle bundle) {
                ImmutableList<TrackGroupArray> immutableList;
                SparseArray<SelectionOverride> sparseArray;
                int[] intArray = bundle.getIntArray(Parameters.keyForField(1010));
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(Parameters.keyForField(1011));
                if (parcelableArrayList == null) {
                    immutableList = ImmutableList.of();
                } else {
                    immutableList = BundleableUtil.fromBundleList(TrackGroupArray.CREATOR, parcelableArrayList);
                }
                SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(Parameters.keyForField(1012));
                if (sparseParcelableArray == null) {
                    sparseArray = new SparseArray<>();
                } else {
                    sparseArray = BundleableUtil.fromBundleSparseArray(SelectionOverride.CREATOR, sparseParcelableArray);
                }
                if (intArray != null && intArray.length == immutableList.size()) {
                    for (int i = 0; i < intArray.length; i++) {
                        setSelectionOverride(intArray[i], immutableList.get(i), sparseArray.get(i));
                    }
                }
            }

            private SparseBooleanArray makeSparseBooleanArrayFromTrueKeys(int[] iArr) {
                if (iArr == null) {
                    return new SparseBooleanArray();
                }
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
                for (int append : iArr) {
                    sparseBooleanArray.append(append, true);
                }
                return sparseBooleanArray;
            }
        }

        static {
            Parameters build = new Builder().build();
            DEFAULT_WITHOUT_CONTEXT = build;
            DEFAULT = build;
        }

        public static Parameters getDefaults(Context context) {
            return new Builder(context).build();
        }

        private Parameters(Builder builder) {
            super(builder);
            this.exceedVideoConstraintsIfNecessary = builder.exceedVideoConstraintsIfNecessary;
            this.allowVideoMixedMimeTypeAdaptiveness = builder.allowVideoMixedMimeTypeAdaptiveness;
            this.allowVideoNonSeamlessAdaptiveness = builder.allowVideoNonSeamlessAdaptiveness;
            this.allowVideoMixedDecoderSupportAdaptiveness = builder.allowVideoMixedDecoderSupportAdaptiveness;
            this.exceedAudioConstraintsIfNecessary = builder.exceedAudioConstraintsIfNecessary;
            this.allowAudioMixedMimeTypeAdaptiveness = builder.allowAudioMixedMimeTypeAdaptiveness;
            this.allowAudioMixedSampleRateAdaptiveness = builder.allowAudioMixedSampleRateAdaptiveness;
            this.allowAudioMixedChannelCountAdaptiveness = builder.allowAudioMixedChannelCountAdaptiveness;
            this.allowAudioMixedDecoderSupportAdaptiveness = builder.allowAudioMixedDecoderSupportAdaptiveness;
            this.constrainAudioChannelCountToDeviceCapabilities = builder.constrainAudioChannelCountToDeviceCapabilities;
            this.exceedRendererCapabilitiesIfNecessary = builder.exceedRendererCapabilitiesIfNecessary;
            this.tunnelingEnabled = builder.tunnelingEnabled;
            this.allowMultipleAdaptiveSelections = builder.allowMultipleAdaptiveSelections;
            this.selectionOverrides = builder.selectionOverrides;
            this.rendererDisabledFlags = builder.rendererDisabledFlags;
        }

        public boolean getRendererDisabled(int i) {
            return this.rendererDisabledFlags.get(i);
        }

        @Deprecated
        public boolean hasSelectionOverride(int i, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i);
            return map != null && map.containsKey(trackGroupArray);
        }

        @Deprecated
        public SelectionOverride getSelectionOverride(int i, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i);
            if (map != null) {
                return (SelectionOverride) map.get(trackGroupArray);
            }
            return null;
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            if (super.equals(parameters) && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.allowVideoMixedMimeTypeAdaptiveness == parameters.allowVideoMixedMimeTypeAdaptiveness && this.allowVideoNonSeamlessAdaptiveness == parameters.allowVideoNonSeamlessAdaptiveness && this.allowVideoMixedDecoderSupportAdaptiveness == parameters.allowVideoMixedDecoderSupportAdaptiveness && this.exceedAudioConstraintsIfNecessary == parameters.exceedAudioConstraintsIfNecessary && this.allowAudioMixedMimeTypeAdaptiveness == parameters.allowAudioMixedMimeTypeAdaptiveness && this.allowAudioMixedSampleRateAdaptiveness == parameters.allowAudioMixedSampleRateAdaptiveness && this.allowAudioMixedChannelCountAdaptiveness == parameters.allowAudioMixedChannelCountAdaptiveness && this.allowAudioMixedDecoderSupportAdaptiveness == parameters.allowAudioMixedDecoderSupportAdaptiveness && this.constrainAudioChannelCountToDeviceCapabilities == parameters.constrainAudioChannelCountToDeviceCapabilities && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.tunnelingEnabled == parameters.tunnelingEnabled && this.allowMultipleAdaptiveSelections == parameters.allowMultipleAdaptiveSelections && areRendererDisabledFlagsEqual(this.rendererDisabledFlags, parameters.rendererDisabledFlags) && areSelectionOverridesEqual(this.selectionOverrides, parameters.selectionOverrides)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowVideoMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowVideoNonSeamlessAdaptiveness ? 1 : 0)) * 31) + (this.allowVideoMixedDecoderSupportAdaptiveness ? 1 : 0)) * 31) + (this.exceedAudioConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowAudioMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedSampleRateAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedChannelCountAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedDecoderSupportAdaptiveness ? 1 : 0)) * 31) + (this.constrainAudioChannelCountToDeviceCapabilities ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + (this.tunnelingEnabled ? 1 : 0)) * 31) + (this.allowMultipleAdaptiveSelections ? 1 : 0);
        }

        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putBoolean(keyForField(1000), this.exceedVideoConstraintsIfNecessary);
            bundle.putBoolean(keyForField(1001), this.allowVideoMixedMimeTypeAdaptiveness);
            bundle.putBoolean(keyForField(1002), this.allowVideoNonSeamlessAdaptiveness);
            bundle.putBoolean(keyForField(1014), this.allowVideoMixedDecoderSupportAdaptiveness);
            bundle.putBoolean(keyForField(1003), this.exceedAudioConstraintsIfNecessary);
            bundle.putBoolean(keyForField(1004), this.allowAudioMixedMimeTypeAdaptiveness);
            bundle.putBoolean(keyForField(1005), this.allowAudioMixedSampleRateAdaptiveness);
            bundle.putBoolean(keyForField(1006), this.allowAudioMixedChannelCountAdaptiveness);
            bundle.putBoolean(keyForField(1015), this.allowAudioMixedDecoderSupportAdaptiveness);
            bundle.putBoolean(keyForField(1016), this.constrainAudioChannelCountToDeviceCapabilities);
            bundle.putBoolean(keyForField(1007), this.exceedRendererCapabilitiesIfNecessary);
            bundle.putBoolean(keyForField(1008), this.tunnelingEnabled);
            bundle.putBoolean(keyForField(1009), this.allowMultipleAdaptiveSelections);
            putSelectionOverridesToBundle(bundle, this.selectionOverrides);
            bundle.putIntArray(keyForField(1013), getKeysFromSparseBooleanArray(this.rendererDisabledFlags));
            return bundle;
        }

        private static void putSelectionOverridesToBundle(Bundle bundle, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray2 = new SparseArray();
            for (int i = 0; i < sparseArray.size(); i++) {
                int keyAt = sparseArray.keyAt(i);
                for (Map.Entry entry : sparseArray.valueAt(i).entrySet()) {
                    SelectionOverride selectionOverride = (SelectionOverride) entry.getValue();
                    if (selectionOverride != null) {
                        sparseArray2.put(arrayList2.size(), selectionOverride);
                    }
                    arrayList2.add((TrackGroupArray) entry.getKey());
                    arrayList.add(Integer.valueOf(keyAt));
                }
                bundle.putIntArray(keyForField(1010), Ints.toArray(arrayList));
                bundle.putParcelableArrayList(keyForField(1011), BundleableUtil.toBundleArrayList(arrayList2));
                bundle.putSparseParcelableArray(keyForField(1012), BundleableUtil.toBundleSparseArray(sparseArray2));
            }
        }

        private static int[] getKeysFromSparseBooleanArray(SparseBooleanArray sparseBooleanArray) {
            int[] iArr = new int[sparseBooleanArray.size()];
            for (int i = 0; i < sparseBooleanArray.size(); i++) {
                iArr[i] = sparseBooleanArray.keyAt(i);
            }
            return iArr;
        }

        private static boolean areRendererDisabledFlagsEqual(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean areSelectionOverridesEqual(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                if (indexOfKey < 0 || !areSelectionOverridesEqual(sparseArray.valueAt(i), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x001a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean areSelectionOverridesEqual(java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r4, java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r5) {
            /*
                int r0 = r4.size()
                int r1 = r5.size()
                r2 = 0
                if (r1 == r0) goto L_0x000c
                return r2
            L_0x000c:
                java.util.Set r4 = r4.entrySet()
                java.util.Iterator r4 = r4.iterator()
            L_0x0014:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x003b
                java.lang.Object r0 = r4.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r1 = r0.getKey()
                com.google.android.exoplayer2.source.TrackGroupArray r1 = (com.google.android.exoplayer2.source.TrackGroupArray) r1
                boolean r3 = r5.containsKey(r1)
                if (r3 == 0) goto L_0x003a
                java.lang.Object r0 = r0.getValue()
                java.lang.Object r1 = r5.get(r1)
                boolean r0 = com.google.android.exoplayer2.util.Util.areEqual(r0, r1)
                if (r0 != 0) goto L_0x0014
            L_0x003a:
                return r2
            L_0x003b:
                r4 = 1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.areSelectionOverridesEqual(java.util.Map, java.util.Map):boolean");
        }
    }

    public static final class SelectionOverride implements Bundleable {
        public static final Bundleable.Creator<SelectionOverride> CREATOR = new DefaultTrackSelector$SelectionOverride$$ExternalSyntheticLambda0();
        private static final int FIELD_GROUP_INDEX = 0;
        private static final int FIELD_TRACKS = 1;
        private static final int FIELD_TRACK_TYPE = 2;
        public final int groupIndex;
        public final int length;
        public final int[] tracks;
        public final int type;

        public SelectionOverride(int i, int... iArr) {
            this(i, iArr, 0);
        }

        public SelectionOverride(int i, int[] iArr, int i2) {
            this.groupIndex = i;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.tracks = copyOf;
            this.length = iArr.length;
            this.type = i2;
            Arrays.sort(copyOf);
        }

        public boolean containsTrack(int i) {
            for (int i2 : this.tracks) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((this.groupIndex * 31) + Arrays.hashCode(this.tracks)) * 31) + this.type;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SelectionOverride selectionOverride = (SelectionOverride) obj;
            if (this.groupIndex == selectionOverride.groupIndex && Arrays.equals(this.tracks, selectionOverride.tracks) && this.type == selectionOverride.type) {
                return true;
            }
            return false;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(keyForField(0), this.groupIndex);
            bundle.putIntArray(keyForField(1), this.tracks);
            bundle.putInt(keyForField(2), this.type);
            return bundle;
        }

        static /* synthetic */ SelectionOverride lambda$static$0(Bundle bundle) {
            boolean z = false;
            int i = bundle.getInt(keyForField(0), -1);
            int[] intArray = bundle.getIntArray(keyForField(1));
            int i2 = bundle.getInt(keyForField(2), -1);
            if (i >= 0 && i2 >= 0) {
                z = true;
            }
            Assertions.checkArgument(z);
            Assertions.checkNotNull(intArray);
            return new SelectionOverride(i, intArray, i2);
        }

        private static String keyForField(int i) {
            return Integer.toString(i, 36);
        }
    }

    static /* synthetic */ int lambda$static$0(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            if (num2.intValue() == -1) {
                return 0;
            }
            return -1;
        } else if (num2.intValue() == -1) {
            return 1;
        } else {
            return num.intValue() - num2.intValue();
        }
    }

    @Deprecated
    public DefaultTrackSelector() {
        this((TrackSelectionParameters) Parameters.DEFAULT_WITHOUT_CONTEXT, (ExoTrackSelection.Factory) new AdaptiveTrackSelection.Factory());
    }

    public DefaultTrackSelector(Context context2) {
        this(context2, (ExoTrackSelection.Factory) new AdaptiveTrackSelection.Factory());
    }

    public DefaultTrackSelector(Context context2, ExoTrackSelection.Factory factory) {
        this(context2, (TrackSelectionParameters) Parameters.getDefaults(context2), factory);
    }

    public DefaultTrackSelector(Context context2, TrackSelectionParameters trackSelectionParameters) {
        this(context2, trackSelectionParameters, (ExoTrackSelection.Factory) new AdaptiveTrackSelection.Factory());
    }

    @Deprecated
    public DefaultTrackSelector(TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory) {
        this(trackSelectionParameters, factory, (Context) null);
    }

    public DefaultTrackSelector(Context context2, TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory) {
        this(trackSelectionParameters, factory, context2);
    }

    private DefaultTrackSelector(TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory, Context context2) {
        this.lock = new Object();
        this.context = context2 != null ? context2.getApplicationContext() : null;
        this.trackSelectionFactory = factory;
        if (trackSelectionParameters instanceof Parameters) {
            this.parameters = (Parameters) trackSelectionParameters;
        } else {
            this.parameters = (context2 == null ? Parameters.DEFAULT_WITHOUT_CONTEXT : Parameters.getDefaults(context2)).buildUpon().set(trackSelectionParameters).build();
        }
        this.audioAttributes = AudioAttributes.DEFAULT;
        boolean z = context2 != null && Util.isTv(context2);
        this.deviceIsTV = z;
        if (!z && context2 != null && Util.SDK_INT >= 32) {
            this.spatializer = SpatializerWrapperV32.tryCreateInstance(context2);
        }
        if (this.parameters.constrainAudioChannelCountToDeviceCapabilities && context2 == null) {
            Log.w(TAG, AUDIO_CHANNEL_COUNT_CONSTRAINTS_WARN_MESSAGE);
        }
    }

    public void release() {
        SpatializerWrapperV32 spatializerWrapperV32;
        synchronized (this.lock) {
            if (Util.SDK_INT >= 32 && (spatializerWrapperV32 = this.spatializer) != null) {
                spatializerWrapperV32.release();
            }
        }
        super.release();
    }

    public Parameters getParameters() {
        Parameters parameters2;
        synchronized (this.lock) {
            parameters2 = this.parameters;
        }
        return parameters2;
    }

    public void setParameters(TrackSelectionParameters trackSelectionParameters) {
        if (trackSelectionParameters instanceof Parameters) {
            setParametersInternal((Parameters) trackSelectionParameters);
        }
        setParametersInternal(new Parameters.Builder().set(trackSelectionParameters).build());
    }

    public void setAudioAttributes(AudioAttributes audioAttributes2) {
        boolean z;
        synchronized (this.lock) {
            z = !this.audioAttributes.equals(audioAttributes2);
            this.audioAttributes = audioAttributes2;
        }
        if (z) {
            maybeInvalidateForAudioChannelCountConstraints();
        }
    }

    @Deprecated
    public void setParameters(ParametersBuilder parametersBuilder) {
        setParametersInternal(parametersBuilder.build());
    }

    public void setParameters(Parameters.Builder builder) {
        setParametersInternal(builder.build());
    }

    public Parameters.Builder buildUponParameters() {
        return getParameters().buildUpon();
    }

    private void setParametersInternal(Parameters parameters2) {
        boolean z;
        Assertions.checkNotNull(parameters2);
        synchronized (this.lock) {
            z = !this.parameters.equals(parameters2);
            this.parameters = parameters2;
        }
        if (z) {
            if (parameters2.constrainAudioChannelCountToDeviceCapabilities && this.context == null) {
                Log.w(TAG, AUDIO_CHANNEL_COUNT_CONSTRAINTS_WARN_MESSAGE);
            }
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public final Pair<RendererConfiguration[], ExoTrackSelection[]> selectTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException {
        Parameters parameters2;
        SpatializerWrapperV32 spatializerWrapperV32;
        synchronized (this.lock) {
            parameters2 = this.parameters;
            if (parameters2.constrainAudioChannelCountToDeviceCapabilities && Util.SDK_INT >= 32 && (spatializerWrapperV32 = this.spatializer) != null) {
                spatializerWrapperV32.ensureInitialized(this, (Looper) Assertions.checkStateNotNull(Looper.myLooper()));
            }
        }
        int rendererCount = mappedTrackInfo.getRendererCount();
        ExoTrackSelection.Definition[] selectAllTracks = selectAllTracks(mappedTrackInfo, iArr, iArr2, parameters2);
        applyTrackSelectionOverrides(mappedTrackInfo, parameters2, selectAllTracks);
        applyLegacyRendererOverrides(mappedTrackInfo, parameters2, selectAllTracks);
        for (int i = 0; i < rendererCount; i++) {
            int rendererType = mappedTrackInfo.getRendererType(i);
            if (parameters2.getRendererDisabled(i) || parameters2.disabledTrackTypes.contains(Integer.valueOf(rendererType))) {
                selectAllTracks[i] = null;
            }
        }
        ExoTrackSelection[] createTrackSelections = this.trackSelectionFactory.createTrackSelections(selectAllTracks, getBandwidthMeter(), mediaPeriodId, timeline);
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[rendererCount];
        for (int i2 = 0; i2 < rendererCount; i2++) {
            boolean z = true;
            if ((parameters2.getRendererDisabled(i2) || parameters2.disabledTrackTypes.contains(Integer.valueOf(mappedTrackInfo.getRendererType(i2)))) || (mappedTrackInfo.getRendererType(i2) != -2 && createTrackSelections[i2] == null)) {
                z = false;
            }
            rendererConfigurationArr[i2] = z ? RendererConfiguration.DEFAULT : null;
        }
        if (parameters2.tunnelingEnabled) {
            maybeConfigureRenderersForTunneling(mappedTrackInfo, iArr, rendererConfigurationArr, createTrackSelections);
        }
        return Pair.create(rendererConfigurationArr, createTrackSelections);
    }

    /* access modifiers changed from: protected */
    public ExoTrackSelection.Definition[] selectAllTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters2) throws ExoPlaybackException {
        String str;
        int rendererCount = mappedTrackInfo.getRendererCount();
        ExoTrackSelection.Definition[] definitionArr = new ExoTrackSelection.Definition[rendererCount];
        Pair<ExoTrackSelection.Definition, Integer> selectVideoTrack = selectVideoTrack(mappedTrackInfo, iArr, iArr2, parameters2);
        if (selectVideoTrack != null) {
            definitionArr[((Integer) selectVideoTrack.second).intValue()] = (ExoTrackSelection.Definition) selectVideoTrack.first;
        }
        Pair<ExoTrackSelection.Definition, Integer> selectAudioTrack = selectAudioTrack(mappedTrackInfo, iArr, iArr2, parameters2);
        if (selectAudioTrack != null) {
            definitionArr[((Integer) selectAudioTrack.second).intValue()] = (ExoTrackSelection.Definition) selectAudioTrack.first;
        }
        if (selectAudioTrack == null) {
            str = null;
        } else {
            str = ((ExoTrackSelection.Definition) selectAudioTrack.first).group.getFormat(((ExoTrackSelection.Definition) selectAudioTrack.first).tracks[0]).language;
        }
        Pair<ExoTrackSelection.Definition, Integer> selectTextTrack = selectTextTrack(mappedTrackInfo, iArr, parameters2, str);
        if (selectTextTrack != null) {
            definitionArr[((Integer) selectTextTrack.second).intValue()] = (ExoTrackSelection.Definition) selectTextTrack.first;
        }
        for (int i = 0; i < rendererCount; i++) {
            int rendererType = mappedTrackInfo.getRendererType(i);
            if (!(rendererType == 2 || rendererType == 1 || rendererType == 3)) {
                definitionArr[i] = selectOtherTrack(rendererType, mappedTrackInfo.getTrackGroups(i), iArr[i], parameters2);
            }
        }
        return definitionArr;
    }

    /* access modifiers changed from: protected */
    public Pair<ExoTrackSelection.Definition, Integer> selectVideoTrack(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters2) throws ExoPlaybackException {
        return selectTracksForType(2, mappedTrackInfo, iArr, new DefaultTrackSelector$$ExternalSyntheticLambda5(parameters2, iArr2), new DefaultTrackSelector$$ExternalSyntheticLambda6());
    }

    /* access modifiers changed from: protected */
    public Pair<ExoTrackSelection.Definition, Integer> selectAudioTrack(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters2) throws ExoPlaybackException {
        boolean z = false;
        int i = 0;
        while (true) {
            if (i < mappedTrackInfo.getRendererCount()) {
                if (2 == mappedTrackInfo.getRendererType(i) && mappedTrackInfo.getTrackGroups(i).length > 0) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return selectTracksForType(1, mappedTrackInfo, iArr, new DefaultTrackSelector$$ExternalSyntheticLambda7(this, parameters2, z), new DefaultTrackSelector$$ExternalSyntheticLambda8());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$selectAudioTrack$3$com-google-android-exoplayer2-trackselection-DefaultTrackSelector  reason: not valid java name */
    public /* synthetic */ List m529lambda$selectAudioTrack$3$comgoogleandroidexoplayer2trackselectionDefaultTrackSelector(Parameters parameters2, boolean z, int i, TrackGroup trackGroup, int[] iArr) {
        return AudioTrackInfo.createForTrackGroup(i, trackGroup, parameters2, iArr, z, new DefaultTrackSelector$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    public boolean isAudioFormatWithinAudioChannelCountConstraints(Format format) {
        boolean z;
        SpatializerWrapperV32 spatializerWrapperV32;
        SpatializerWrapperV32 spatializerWrapperV322;
        synchronized (this.lock) {
            if (this.parameters.constrainAudioChannelCountToDeviceCapabilities && !this.deviceIsTV && format.channelCount > 2 && (!isDolbyAudio(format) || (Util.SDK_INT >= 32 && (spatializerWrapperV322 = this.spatializer) != null && spatializerWrapperV322.isSpatializationSupported()))) {
                if (Util.SDK_INT < 32 || (spatializerWrapperV32 = this.spatializer) == null || !spatializerWrapperV32.isSpatializationSupported() || !this.spatializer.isAvailable() || !this.spatializer.isEnabled() || !this.spatializer.canBeSpatialized(this.audioAttributes, format)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public Pair<ExoTrackSelection.Definition, Integer> selectTextTrack(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, Parameters parameters2, String str) throws ExoPlaybackException {
        return selectTracksForType(3, mappedTrackInfo, iArr, new DefaultTrackSelector$$ExternalSyntheticLambda0(parameters2, str), new DefaultTrackSelector$$ExternalSyntheticLambda1());
    }

    /* access modifiers changed from: protected */
    public ExoTrackSelection.Definition selectOtherTrack(int i, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters2) throws ExoPlaybackException {
        TrackGroup trackGroup = null;
        OtherTrackScore otherTrackScore = null;
        int i2 = 0;
        for (int i3 = 0; i3 < trackGroupArray.length; i3++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < trackGroup2.length; i4++) {
                if (isSupported(iArr2[i4], parameters2.exceedRendererCapabilitiesIfNecessary)) {
                    OtherTrackScore otherTrackScore2 = new OtherTrackScore(trackGroup2.getFormat(i4), iArr2[i4]);
                    if (otherTrackScore == null || otherTrackScore2.compareTo(otherTrackScore) > 0) {
                        trackGroup = trackGroup2;
                        i2 = i4;
                        otherTrackScore = otherTrackScore2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new ExoTrackSelection.Definition(trackGroup, i2);
    }

    private <T extends TrackInfo<T>> Pair<ExoTrackSelection.Definition, Integer> selectTracksForType(int i, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, TrackInfo.Factory<T> factory, Comparator<List<T>> comparator) {
        int i2;
        Object obj;
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2 = mappedTrackInfo;
        ArrayList arrayList = new ArrayList();
        int rendererCount = mappedTrackInfo.getRendererCount();
        int i3 = 0;
        while (i3 < rendererCount) {
            if (i == mappedTrackInfo2.getRendererType(i3)) {
                TrackGroupArray trackGroups = mappedTrackInfo2.getTrackGroups(i3);
                int i4 = 0;
                while (i4 < trackGroups.length) {
                    TrackGroup trackGroup = trackGroups.get(i4);
                    List<T> create = factory.create(i3, trackGroup, iArr[i3][i4]);
                    boolean[] zArr = new boolean[trackGroup.length];
                    int i5 = 0;
                    while (i5 < trackGroup.length) {
                        TrackInfo trackInfo = (TrackInfo) create.get(i5);
                        int selectionEligibility = trackInfo.getSelectionEligibility();
                        if (zArr[i5] || selectionEligibility == 0) {
                            i2 = rendererCount;
                        } else {
                            if (selectionEligibility == 1) {
                                obj = ImmutableList.of(trackInfo);
                                i2 = rendererCount;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(trackInfo);
                                int i6 = i5 + 1;
                                while (i6 < trackGroup.length) {
                                    TrackInfo trackInfo2 = (TrackInfo) create.get(i6);
                                    int i7 = rendererCount;
                                    if (trackInfo2.getSelectionEligibility() == 2 && trackInfo.isCompatibleForAdaptationWith(trackInfo2)) {
                                        arrayList2.add(trackInfo2);
                                        zArr[i6] = true;
                                    }
                                    i6++;
                                    MappingTrackSelector.MappedTrackInfo mappedTrackInfo3 = mappedTrackInfo;
                                    rendererCount = i7;
                                }
                                i2 = rendererCount;
                                obj = arrayList2;
                            }
                            arrayList.add(obj);
                        }
                        i5++;
                        MappingTrackSelector.MappedTrackInfo mappedTrackInfo4 = mappedTrackInfo;
                        rendererCount = i2;
                    }
                    int i8 = rendererCount;
                    i4++;
                    MappingTrackSelector.MappedTrackInfo mappedTrackInfo5 = mappedTrackInfo;
                }
            }
            TrackInfo.Factory<T> factory2 = factory;
            i3++;
            mappedTrackInfo2 = mappedTrackInfo;
            rendererCount = rendererCount;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i9 = 0; i9 < list.size(); i9++) {
            iArr2[i9] = ((TrackInfo) list.get(i9)).trackIndex;
        }
        TrackInfo trackInfo3 = (TrackInfo) list.get(0);
        return Pair.create(new ExoTrackSelection.Definition(trackInfo3.trackGroup, iArr2), Integer.valueOf(trackInfo3.rendererIndex));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        r1 = r3.spatializer;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void maybeInvalidateForAudioChannelCountConstraints() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters r1 = r3.parameters     // Catch:{ all -> 0x0027 }
            boolean r1 = r1.constrainAudioChannelCountToDeviceCapabilities     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x001f
            boolean r1 = r3.deviceIsTV     // Catch:{ all -> 0x0027 }
            if (r1 != 0) goto L_0x001f
            int r1 = com.google.android.exoplayer2.util.Util.SDK_INT     // Catch:{ all -> 0x0027 }
            r2 = 32
            if (r1 < r2) goto L_0x001f
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SpatializerWrapperV32 r1 = r3.spatializer     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x001f
            boolean r1 = r1.isSpatializationSupported()     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x001f
            r1 = 1
            goto L_0x0020
        L_0x001f:
            r1 = 0
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x0026
            r3.invalidate()
        L_0x0026:
            return
        L_0x0027:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.maybeInvalidateForAudioChannelCountConstraints():void");
    }

    private static void applyTrackSelectionOverrides(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Definition[] definitionArr) {
        int rendererCount = mappedTrackInfo.getRendererCount();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < rendererCount; i++) {
            collectTrackSelectionOverrides(mappedTrackInfo.getTrackGroups(i), trackSelectionParameters, hashMap);
        }
        collectTrackSelectionOverrides(mappedTrackInfo.getUnmappedTrackGroups(), trackSelectionParameters, hashMap);
        for (int i2 = 0; i2 < rendererCount; i2++) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) hashMap.get(Integer.valueOf(mappedTrackInfo.getRendererType(i2)));
            if (trackSelectionOverride != null) {
                definitionArr[i2] = (trackSelectionOverride.trackIndices.isEmpty() || mappedTrackInfo.getTrackGroups(i2).indexOf(trackSelectionOverride.mediaTrackGroup) == -1) ? null : new ExoTrackSelection.Definition(trackSelectionOverride.mediaTrackGroup, Ints.toArray(trackSelectionOverride.trackIndices));
            }
        }
    }

    private static void collectTrackSelectionOverrides(TrackGroupArray trackGroupArray, TrackSelectionParameters trackSelectionParameters, Map<Integer, TrackSelectionOverride> map) {
        TrackSelectionOverride trackSelectionOverride;
        for (int i = 0; i < trackGroupArray.length; i++) {
            TrackSelectionOverride trackSelectionOverride2 = trackSelectionParameters.overrides.get(trackGroupArray.get(i));
            if (trackSelectionOverride2 != null && ((trackSelectionOverride = map.get(Integer.valueOf(trackSelectionOverride2.getType()))) == null || (trackSelectionOverride.trackIndices.isEmpty() && !trackSelectionOverride2.trackIndices.isEmpty()))) {
                map.put(Integer.valueOf(trackSelectionOverride2.getType()), trackSelectionOverride2);
            }
        }
    }

    private static void applyLegacyRendererOverrides(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, Parameters parameters2, ExoTrackSelection.Definition[] definitionArr) {
        int rendererCount = mappedTrackInfo.getRendererCount();
        for (int i = 0; i < rendererCount; i++) {
            TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i);
            if (parameters2.hasSelectionOverride(i, trackGroups)) {
                SelectionOverride selectionOverride = parameters2.getSelectionOverride(i, trackGroups);
                definitionArr[i] = (selectionOverride == null || selectionOverride.tracks.length == 0) ? null : new ExoTrackSelection.Definition(trackGroups.get(selectionOverride.groupIndex), selectionOverride.tracks, selectionOverride.type);
            }
        }
    }

    private static void maybeConfigureRenderersForTunneling(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr) {
        boolean z;
        boolean z2 = false;
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            if (i >= mappedTrackInfo.getRendererCount()) {
                z = true;
                break;
            }
            int rendererType = mappedTrackInfo.getRendererType(i);
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i];
            if ((rendererType == 1 || rendererType == 2) && exoTrackSelection != null && rendererSupportsTunneling(iArr[i], mappedTrackInfo.getTrackGroups(i), exoTrackSelection)) {
                if (rendererType == 1) {
                    if (i3 != -1) {
                        break;
                    }
                    i3 = i;
                } else if (i2 != -1) {
                    break;
                } else {
                    i2 = i;
                }
            }
            i++;
        }
        z = false;
        if (!(i3 == -1 || i2 == -1)) {
            z2 = true;
        }
        if (z && z2) {
            RendererConfiguration rendererConfiguration = new RendererConfiguration(true);
            rendererConfigurationArr[i3] = rendererConfiguration;
            rendererConfigurationArr[i2] = rendererConfiguration;
        }
    }

    private static boolean rendererSupportsTunneling(int[][] iArr, TrackGroupArray trackGroupArray, ExoTrackSelection exoTrackSelection) {
        if (exoTrackSelection == null) {
            return false;
        }
        int indexOf = trackGroupArray.indexOf(exoTrackSelection.getTrackGroup());
        for (int i = 0; i < exoTrackSelection.length(); i++) {
            if (RendererCapabilities.getTunnelingSupport(iArr[indexOf][exoTrackSelection.getIndexInTrackGroup(i)]) != 32) {
                return false;
            }
        }
        return true;
    }

    protected static boolean isSupported(int i, boolean z) {
        int formatSupport = RendererCapabilities.getFormatSupport(i);
        return formatSupport == 4 || (z && formatSupport == 3);
    }

    protected static String normalizeUndeterminedLanguageToNull(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C.LANGUAGE_UNDETERMINED)) {
            return null;
        }
        return str;
    }

    protected static int getFormatLanguageScore(Format format, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(format.language)) {
            return 4;
        }
        String normalizeUndeterminedLanguageToNull = normalizeUndeterminedLanguageToNull(str);
        String normalizeUndeterminedLanguageToNull2 = normalizeUndeterminedLanguageToNull(format.language);
        if (normalizeUndeterminedLanguageToNull2 == null || normalizeUndeterminedLanguageToNull == null) {
            if (!z || normalizeUndeterminedLanguageToNull2 != null) {
                return 0;
            }
            return 1;
        } else if (normalizeUndeterminedLanguageToNull2.startsWith(normalizeUndeterminedLanguageToNull) || normalizeUndeterminedLanguageToNull.startsWith(normalizeUndeterminedLanguageToNull2)) {
            return 3;
        } else {
            if (Util.splitAtFirst(normalizeUndeterminedLanguageToNull2, "-")[0].equals(Util.splitAtFirst(normalizeUndeterminedLanguageToNull, "-")[0])) {
                return 2;
            }
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static int getMaxVideoPixelsToRetainForViewport(TrackGroup trackGroup, int i, int i2, boolean z) {
        int i3 = Integer.MAX_VALUE;
        if (!(i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE)) {
            for (int i4 = 0; i4 < trackGroup.length; i4++) {
                Format format = trackGroup.getFormat(i4);
                if (format.width > 0 && format.height > 0) {
                    Point maxVideoSizeInViewport = getMaxVideoSizeInViewport(z, i, i2, format.width, format.height);
                    int i5 = format.width * format.height;
                    if (format.width >= ((int) (((float) maxVideoSizeInViewport.x) * FRACTION_TO_CONSIDER_FULLSCREEN)) && format.height >= ((int) (((float) maxVideoSizeInViewport.y) * FRACTION_TO_CONSIDER_FULLSCREEN)) && i5 < i3) {
                        i3 = i5;
                    }
                }
            }
        }
        return i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r1 != r3) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Point getMaxVideoSizeInViewport(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L_0x0010
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L_0x0008
            r1 = r3
            goto L_0x0009
        L_0x0008:
            r1 = r0
        L_0x0009:
            if (r4 <= r5) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r3 = r0
        L_0x000d:
            if (r1 == r3) goto L_0x0010
            goto L_0x0013
        L_0x0010:
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x0013:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L_0x0023
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r0, (int) r6)
            r3.<init>(r5, r4)
            return r3
        L_0x0023:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r3, (int) r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.getMaxVideoSizeInViewport(boolean, int, int, int, int):android.graphics.Point");
    }

    /* access modifiers changed from: private */
    public static int getRoleFlagMatchScore(int i, int i2) {
        if (i == 0 || i != i2) {
            return Integer.bitCount(i & i2);
        }
        return Integer.MAX_VALUE;
    }

    /* access modifiers changed from: private */
    public static int getVideoCodecPreferenceScore(String str) {
        if (str == null) {
            return 0;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1662735862:
                if (str.equals(MimeTypes.VIDEO_AV1)) {
                    c = 0;
                    break;
                }
                break;
            case -1662541442:
                if (str.equals(MimeTypes.VIDEO_H265)) {
                    c = 1;
                    break;
                }
                break;
            case 1331836730:
                if (str.equals(MimeTypes.VIDEO_H264)) {
                    c = 2;
                    break;
                }
                break;
            case 1599127257:
                if (str.equals(MimeTypes.VIDEO_VP9)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 4;
            case 1:
                return 3;
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return 0;
        }
    }

    private static boolean isDolbyAudio(Format format) {
        if (format.sampleMimeType == null) {
            return false;
        }
        String str = format.sampleMimeType;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                    c = 0;
                    break;
                }
                break;
            case 187078296:
                if (str.equals(MimeTypes.AUDIO_AC3)) {
                    c = 1;
                    break;
                }
                break;
            case 187078297:
                if (str.equals(MimeTypes.AUDIO_AC4)) {
                    c = 2;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals(MimeTypes.AUDIO_E_AC3)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    private static abstract class TrackInfo<T extends TrackInfo<T>> {
        public final Format format;
        public final int rendererIndex;
        public final TrackGroup trackGroup;
        public final int trackIndex;

        public interface Factory<T extends TrackInfo<T>> {
            List<T> create(int i, TrackGroup trackGroup, int[] iArr);
        }

        public abstract int getSelectionEligibility();

        public abstract boolean isCompatibleForAdaptationWith(T t);

        public TrackInfo(int i, TrackGroup trackGroup2, int i2) {
            this.rendererIndex = i;
            this.trackGroup = trackGroup2;
            this.trackIndex = i2;
            this.format = trackGroup2.getFormat(i2);
        }
    }

    private static final class VideoTrackInfo extends TrackInfo<VideoTrackInfo> {
        private final boolean allowMixedMimeTypes;
        private final int bitrate;
        private final int codecPreferenceScore;
        private final boolean hasMainOrNoRoleFlag;
        private final boolean isWithinMaxConstraints;
        private final boolean isWithinMinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final Parameters parameters;
        private final int pixelCount;
        private final int preferredMimeTypeMatchIndex;
        private final int preferredRoleFlagsScore;
        private final int selectionEligibility;
        private final boolean usesHardwareAcceleration;
        private final boolean usesPrimaryDecoder;

        public static ImmutableList<VideoTrackInfo> createForTrackGroup(int i, TrackGroup trackGroup, Parameters parameters2, int[] iArr, int i2) {
            TrackGroup trackGroup2 = trackGroup;
            Parameters parameters3 = parameters2;
            int access$2000 = DefaultTrackSelector.getMaxVideoPixelsToRetainForViewport(trackGroup2, parameters3.viewportWidth, parameters3.viewportHeight, parameters3.viewportOrientationMayChange);
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i3 = 0; i3 < trackGroup2.length; i3++) {
                int pixelCount2 = trackGroup2.getFormat(i3).getPixelCount();
                builder.add((Object) new VideoTrackInfo(i, trackGroup, i3, parameters2, iArr[i3], i2, access$2000 == Integer.MAX_VALUE || (pixelCount2 != -1 && pixelCount2 <= access$2000)));
            }
            return builder.build();
        }

        public VideoTrackInfo(int i, TrackGroup trackGroup, int i2, Parameters parameters2, int i3, int i4, boolean z) {
            super(i, trackGroup, i2);
            this.parameters = parameters2;
            int i5 = parameters2.allowVideoNonSeamlessAdaptiveness ? 24 : 16;
            boolean z2 = true;
            this.allowMixedMimeTypes = parameters2.allowVideoMixedMimeTypeAdaptiveness && (i4 & i5) != 0;
            this.isWithinMaxConstraints = z && (this.format.width == -1 || this.format.width <= parameters2.maxVideoWidth) && ((this.format.height == -1 || this.format.height <= parameters2.maxVideoHeight) && ((this.format.frameRate == -1.0f || this.format.frameRate <= ((float) parameters2.maxVideoFrameRate)) && (this.format.bitrate == -1 || this.format.bitrate <= parameters2.maxVideoBitrate)));
            this.isWithinMinConstraints = z && (this.format.width == -1 || this.format.width >= parameters2.minVideoWidth) && ((this.format.height == -1 || this.format.height >= parameters2.minVideoHeight) && ((this.format.frameRate == -1.0f || this.format.frameRate >= ((float) parameters2.minVideoFrameRate)) && (this.format.bitrate == -1 || this.format.bitrate >= parameters2.minVideoBitrate)));
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i3, false);
            this.bitrate = this.format.bitrate;
            this.pixelCount = this.format.getPixelCount();
            this.preferredRoleFlagsScore = DefaultTrackSelector.getRoleFlagMatchScore(this.format.roleFlags, parameters2.preferredVideoRoleFlags);
            this.hasMainOrNoRoleFlag = this.format.roleFlags == 0 || (this.format.roleFlags & 1) != 0;
            int i6 = Integer.MAX_VALUE;
            int i7 = 0;
            while (true) {
                if (i7 < parameters2.preferredVideoMimeTypes.size()) {
                    if (this.format.sampleMimeType != null && this.format.sampleMimeType.equals(parameters2.preferredVideoMimeTypes.get(i7))) {
                        i6 = i7;
                        break;
                    }
                    i7++;
                } else {
                    break;
                }
            }
            this.preferredMimeTypeMatchIndex = i6;
            this.usesPrimaryDecoder = RendererCapabilities.getDecoderSupport(i3) == 128;
            this.usesHardwareAcceleration = RendererCapabilities.getHardwareAccelerationSupport(i3) != 64 ? false : z2;
            this.codecPreferenceScore = DefaultTrackSelector.getVideoCodecPreferenceScore(this.format.sampleMimeType);
            this.selectionEligibility = evaluateSelectionEligibility(i3, i5);
        }

        public int getSelectionEligibility() {
            return this.selectionEligibility;
        }

        public boolean isCompatibleForAdaptationWith(VideoTrackInfo videoTrackInfo) {
            return (this.allowMixedMimeTypes || Util.areEqual(this.format.sampleMimeType, videoTrackInfo.format.sampleMimeType)) && (this.parameters.allowVideoMixedDecoderSupportAdaptiveness || (this.usesPrimaryDecoder == videoTrackInfo.usesPrimaryDecoder && this.usesHardwareAcceleration == videoTrackInfo.usesHardwareAcceleration));
        }

        private int evaluateSelectionEligibility(int i, int i2) {
            if ((this.format.roleFlags & 16384) != 0 || !DefaultTrackSelector.isSupported(i, this.parameters.exceedRendererCapabilitiesIfNecessary)) {
                return 0;
            }
            if (this.isWithinMaxConstraints || this.parameters.exceedVideoConstraintsIfNecessary) {
                return (!DefaultTrackSelector.isSupported(i, false) || !this.isWithinMinConstraints || !this.isWithinMaxConstraints || this.format.bitrate == -1 || this.parameters.forceHighestSupportedBitrate || this.parameters.forceLowestBitrate || (i & i2) == 0) ? 1 : 2;
            }
            return 0;
        }

        /* access modifiers changed from: private */
        public static int compareNonQualityPreferences(VideoTrackInfo videoTrackInfo, VideoTrackInfo videoTrackInfo2) {
            ComparisonChain compareFalseFirst = ComparisonChain.start().compareFalseFirst(videoTrackInfo.isWithinRendererCapabilities, videoTrackInfo2.isWithinRendererCapabilities).compare(videoTrackInfo.preferredRoleFlagsScore, videoTrackInfo2.preferredRoleFlagsScore).compareFalseFirst(videoTrackInfo.hasMainOrNoRoleFlag, videoTrackInfo2.hasMainOrNoRoleFlag).compareFalseFirst(videoTrackInfo.isWithinMaxConstraints, videoTrackInfo2.isWithinMaxConstraints).compareFalseFirst(videoTrackInfo.isWithinMinConstraints, videoTrackInfo2.isWithinMinConstraints).compare(Integer.valueOf(videoTrackInfo.preferredMimeTypeMatchIndex), Integer.valueOf(videoTrackInfo2.preferredMimeTypeMatchIndex), Ordering.natural().reverse()).compareFalseFirst(videoTrackInfo.usesPrimaryDecoder, videoTrackInfo2.usesPrimaryDecoder).compareFalseFirst(videoTrackInfo.usesHardwareAcceleration, videoTrackInfo2.usesHardwareAcceleration);
            if (videoTrackInfo.usesPrimaryDecoder && videoTrackInfo.usesHardwareAcceleration) {
                compareFalseFirst = compareFalseFirst.compare(videoTrackInfo.codecPreferenceScore, videoTrackInfo2.codecPreferenceScore);
            }
            return compareFalseFirst.result();
        }

        /* access modifiers changed from: private */
        public static int compareQualityPreferences(VideoTrackInfo videoTrackInfo, VideoTrackInfo videoTrackInfo2) {
            Ordering ordering;
            if (!videoTrackInfo.isWithinMaxConstraints || !videoTrackInfo.isWithinRendererCapabilities) {
                ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse();
            } else {
                ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING;
            }
            return ComparisonChain.start().compare(Integer.valueOf(videoTrackInfo.bitrate), Integer.valueOf(videoTrackInfo2.bitrate), videoTrackInfo.parameters.forceLowestBitrate ? DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse() : DefaultTrackSelector.NO_ORDER).compare(Integer.valueOf(videoTrackInfo.pixelCount), Integer.valueOf(videoTrackInfo2.pixelCount), ordering).compare(Integer.valueOf(videoTrackInfo.bitrate), Integer.valueOf(videoTrackInfo2.bitrate), ordering).result();
        }

        public static int compareSelections(List<VideoTrackInfo> list, List<VideoTrackInfo> list2) {
            return ComparisonChain.start().compare((VideoTrackInfo) Collections.max(list, new DefaultTrackSelector$VideoTrackInfo$$ExternalSyntheticLambda0()), (VideoTrackInfo) Collections.max(list2, new DefaultTrackSelector$VideoTrackInfo$$ExternalSyntheticLambda0()), new DefaultTrackSelector$VideoTrackInfo$$ExternalSyntheticLambda0()).compare(list.size(), list2.size()).compare((VideoTrackInfo) Collections.max(list, new DefaultTrackSelector$VideoTrackInfo$$ExternalSyntheticLambda1()), (VideoTrackInfo) Collections.max(list2, new DefaultTrackSelector$VideoTrackInfo$$ExternalSyntheticLambda1()), new DefaultTrackSelector$VideoTrackInfo$$ExternalSyntheticLambda1()).result();
        }
    }

    private static final class AudioTrackInfo extends TrackInfo<AudioTrackInfo> implements Comparable<AudioTrackInfo> {
        private final int bitrate;
        private final int channelCount;
        private final boolean hasMainOrNoRoleFlag;
        private final boolean isDefaultSelectionFlag;
        private final boolean isWithinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final String language = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(this.format.language);
        private final int localeLanguageMatchIndex;
        private final int localeLanguageScore;
        private final Parameters parameters;
        private final int preferredLanguageIndex;
        private final int preferredLanguageScore;
        private final int preferredMimeTypeMatchIndex;
        private final int preferredRoleFlagsScore;
        private final int sampleRate;
        private final int selectionEligibility;
        private final boolean usesHardwareAcceleration;
        private final boolean usesPrimaryDecoder;

        public static ImmutableList<AudioTrackInfo> createForTrackGroup(int i, TrackGroup trackGroup, Parameters parameters2, int[] iArr, boolean z, Predicate<Format> predicate) {
            ImmutableList.Builder builder = ImmutableList.builder();
            TrackGroup trackGroup2 = trackGroup;
            for (int i2 = 0; i2 < trackGroup2.length; i2++) {
                builder.add((Object) new AudioTrackInfo(i, trackGroup, i2, parameters2, iArr[i2], z, predicate));
            }
            return builder.build();
        }

        public AudioTrackInfo(int i, TrackGroup trackGroup, int i2, Parameters parameters2, int i3, boolean z, Predicate<Format> predicate) {
            super(i, trackGroup, i2);
            int i4;
            int i5;
            int i6;
            this.parameters = parameters2;
            boolean z2 = false;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i3, false);
            int i7 = 0;
            while (true) {
                i4 = Integer.MAX_VALUE;
                if (i7 >= parameters2.preferredAudioLanguages.size()) {
                    i5 = 0;
                    i7 = Integer.MAX_VALUE;
                    break;
                }
                i5 = DefaultTrackSelector.getFormatLanguageScore(this.format, (String) parameters2.preferredAudioLanguages.get(i7), false);
                if (i5 > 0) {
                    break;
                }
                i7++;
            }
            this.preferredLanguageIndex = i7;
            this.preferredLanguageScore = i5;
            this.preferredRoleFlagsScore = DefaultTrackSelector.getRoleFlagMatchScore(this.format.roleFlags, parameters2.preferredAudioRoleFlags);
            this.hasMainOrNoRoleFlag = this.format.roleFlags == 0 || (this.format.roleFlags & 1) != 0;
            this.isDefaultSelectionFlag = (this.format.selectionFlags & 1) != 0;
            this.channelCount = this.format.channelCount;
            this.sampleRate = this.format.sampleRate;
            this.bitrate = this.format.bitrate;
            this.isWithinConstraints = (this.format.bitrate == -1 || this.format.bitrate <= parameters2.maxAudioBitrate) && (this.format.channelCount == -1 || this.format.channelCount <= parameters2.maxAudioChannelCount) && predicate.apply(this.format);
            String[] systemLanguageCodes = Util.getSystemLanguageCodes();
            int i8 = 0;
            while (true) {
                if (i8 >= systemLanguageCodes.length) {
                    i6 = 0;
                    i8 = Integer.MAX_VALUE;
                    break;
                }
                i6 = DefaultTrackSelector.getFormatLanguageScore(this.format, systemLanguageCodes[i8], false);
                if (i6 > 0) {
                    break;
                }
                i8++;
            }
            this.localeLanguageMatchIndex = i8;
            this.localeLanguageScore = i6;
            int i9 = 0;
            while (true) {
                if (i9 < parameters2.preferredAudioMimeTypes.size()) {
                    if (this.format.sampleMimeType != null && this.format.sampleMimeType.equals(parameters2.preferredAudioMimeTypes.get(i9))) {
                        i4 = i9;
                        break;
                    }
                    i9++;
                } else {
                    break;
                }
            }
            this.preferredMimeTypeMatchIndex = i4;
            this.usesPrimaryDecoder = RendererCapabilities.getDecoderSupport(i3) == 128;
            this.usesHardwareAcceleration = RendererCapabilities.getHardwareAccelerationSupport(i3) == 64 ? true : z2;
            this.selectionEligibility = evaluateSelectionEligibility(i3, z);
        }

        public int getSelectionEligibility() {
            return this.selectionEligibility;
        }

        public boolean isCompatibleForAdaptationWith(AudioTrackInfo audioTrackInfo) {
            return (this.parameters.allowAudioMixedChannelCountAdaptiveness || (this.format.channelCount != -1 && this.format.channelCount == audioTrackInfo.format.channelCount)) && (this.parameters.allowAudioMixedMimeTypeAdaptiveness || (this.format.sampleMimeType != null && TextUtils.equals(this.format.sampleMimeType, audioTrackInfo.format.sampleMimeType))) && ((this.parameters.allowAudioMixedSampleRateAdaptiveness || (this.format.sampleRate != -1 && this.format.sampleRate == audioTrackInfo.format.sampleRate)) && (this.parameters.allowAudioMixedDecoderSupportAdaptiveness || (this.usesPrimaryDecoder == audioTrackInfo.usesPrimaryDecoder && this.usesHardwareAcceleration == audioTrackInfo.usesHardwareAcceleration)));
        }

        public int compareTo(AudioTrackInfo audioTrackInfo) {
            Ordering ordering;
            if (!this.isWithinConstraints || !this.isWithinRendererCapabilities) {
                ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse();
            } else {
                ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING;
            }
            ComparisonChain compare = ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, audioTrackInfo.isWithinRendererCapabilities).compare(Integer.valueOf(this.preferredLanguageIndex), Integer.valueOf(audioTrackInfo.preferredLanguageIndex), Ordering.natural().reverse()).compare(this.preferredLanguageScore, audioTrackInfo.preferredLanguageScore).compare(this.preferredRoleFlagsScore, audioTrackInfo.preferredRoleFlagsScore).compareFalseFirst(this.isDefaultSelectionFlag, audioTrackInfo.isDefaultSelectionFlag).compareFalseFirst(this.hasMainOrNoRoleFlag, audioTrackInfo.hasMainOrNoRoleFlag).compare(Integer.valueOf(this.localeLanguageMatchIndex), Integer.valueOf(audioTrackInfo.localeLanguageMatchIndex), Ordering.natural().reverse()).compare(this.localeLanguageScore, audioTrackInfo.localeLanguageScore).compareFalseFirst(this.isWithinConstraints, audioTrackInfo.isWithinConstraints).compare(Integer.valueOf(this.preferredMimeTypeMatchIndex), Integer.valueOf(audioTrackInfo.preferredMimeTypeMatchIndex), Ordering.natural().reverse()).compare(Integer.valueOf(this.bitrate), Integer.valueOf(audioTrackInfo.bitrate), this.parameters.forceLowestBitrate ? DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse() : DefaultTrackSelector.NO_ORDER).compareFalseFirst(this.usesPrimaryDecoder, audioTrackInfo.usesPrimaryDecoder).compareFalseFirst(this.usesHardwareAcceleration, audioTrackInfo.usesHardwareAcceleration).compare(Integer.valueOf(this.channelCount), Integer.valueOf(audioTrackInfo.channelCount), ordering).compare(Integer.valueOf(this.sampleRate), Integer.valueOf(audioTrackInfo.sampleRate), ordering);
            Integer valueOf = Integer.valueOf(this.bitrate);
            Integer valueOf2 = Integer.valueOf(audioTrackInfo.bitrate);
            if (!Util.areEqual(this.language, audioTrackInfo.language)) {
                ordering = DefaultTrackSelector.NO_ORDER;
            }
            return compare.compare(valueOf, valueOf2, ordering).result();
        }

        private int evaluateSelectionEligibility(int i, boolean z) {
            if (!DefaultTrackSelector.isSupported(i, this.parameters.exceedRendererCapabilitiesIfNecessary)) {
                return 0;
            }
            if (this.isWithinConstraints || this.parameters.exceedAudioConstraintsIfNecessary) {
                return (!DefaultTrackSelector.isSupported(i, false) || !this.isWithinConstraints || this.format.bitrate == -1 || this.parameters.forceHighestSupportedBitrate || this.parameters.forceLowestBitrate || (!this.parameters.allowMultipleAdaptiveSelections && z)) ? 1 : 2;
            }
            return 0;
        }

        public static int compareSelections(List<AudioTrackInfo> list, List<AudioTrackInfo> list2) {
            return ((AudioTrackInfo) Collections.max(list)).compareTo((AudioTrackInfo) Collections.max(list2));
        }
    }

    private static final class TextTrackInfo extends TrackInfo<TextTrackInfo> implements Comparable<TextTrackInfo> {
        private final boolean hasCaptionRoleFlags;
        private final boolean isDefault;
        private final boolean isForced;
        private final boolean isWithinRendererCapabilities;
        private final int preferredLanguageIndex;
        private final int preferredLanguageScore;
        private final int preferredRoleFlagsScore;
        private final int selectedAudioLanguageScore;
        private final int selectionEligibility;

        public boolean isCompatibleForAdaptationWith(TextTrackInfo textTrackInfo) {
            return false;
        }

        public static ImmutableList<TextTrackInfo> createForTrackGroup(int i, TrackGroup trackGroup, Parameters parameters, int[] iArr, String str) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i2 = 0; i2 < trackGroup.length; i2++) {
                builder.add((Object) new TextTrackInfo(i, trackGroup, i2, parameters, iArr[i2], str));
            }
            return builder.build();
        }

        public TextTrackInfo(int i, TrackGroup trackGroup, int i2, Parameters parameters, int i3, String str) {
            super(i, trackGroup, i2);
            ImmutableList immutableList;
            int i4;
            int i5 = 0;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i3, false);
            int i6 = this.format.selectionFlags & (~parameters.ignoredTextSelectionFlags);
            this.isDefault = (i6 & 1) != 0;
            this.isForced = (i6 & 2) != 0;
            int i7 = Integer.MAX_VALUE;
            if (parameters.preferredTextLanguages.isEmpty()) {
                immutableList = ImmutableList.of("");
            } else {
                immutableList = parameters.preferredTextLanguages;
            }
            int i8 = 0;
            while (true) {
                if (i8 >= immutableList.size()) {
                    i4 = 0;
                    break;
                }
                i4 = DefaultTrackSelector.getFormatLanguageScore(this.format, (String) immutableList.get(i8), parameters.selectUndeterminedTextLanguage);
                if (i4 > 0) {
                    i7 = i8;
                    break;
                }
                i8++;
            }
            this.preferredLanguageIndex = i7;
            this.preferredLanguageScore = i4;
            int access$2100 = DefaultTrackSelector.getRoleFlagMatchScore(this.format.roleFlags, parameters.preferredTextRoleFlags);
            this.preferredRoleFlagsScore = access$2100;
            this.hasCaptionRoleFlags = (this.format.roleFlags & 1088) != 0;
            int formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(this.format, str, DefaultTrackSelector.normalizeUndeterminedLanguageToNull(str) == null);
            this.selectedAudioLanguageScore = formatLanguageScore;
            boolean z = i4 > 0 || (parameters.preferredTextLanguages.isEmpty() && access$2100 > 0) || this.isDefault || (this.isForced && formatLanguageScore > 0);
            if (DefaultTrackSelector.isSupported(i3, parameters.exceedRendererCapabilitiesIfNecessary) && z) {
                i5 = 1;
            }
            this.selectionEligibility = i5;
        }

        public int getSelectionEligibility() {
            return this.selectionEligibility;
        }

        public int compareTo(TextTrackInfo textTrackInfo) {
            ComparisonChain compare = ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, textTrackInfo.isWithinRendererCapabilities).compare(Integer.valueOf(this.preferredLanguageIndex), Integer.valueOf(textTrackInfo.preferredLanguageIndex), Ordering.natural().reverse()).compare(this.preferredLanguageScore, textTrackInfo.preferredLanguageScore).compare(this.preferredRoleFlagsScore, textTrackInfo.preferredRoleFlagsScore).compareFalseFirst(this.isDefault, textTrackInfo.isDefault).compare(Boolean.valueOf(this.isForced), Boolean.valueOf(textTrackInfo.isForced), this.preferredLanguageScore == 0 ? Ordering.natural() : Ordering.natural().reverse()).compare(this.selectedAudioLanguageScore, textTrackInfo.selectedAudioLanguageScore);
            if (this.preferredRoleFlagsScore == 0) {
                compare = compare.compareTrueFirst(this.hasCaptionRoleFlags, textTrackInfo.hasCaptionRoleFlags);
            }
            return compare.result();
        }

        public static int compareSelections(List<TextTrackInfo> list, List<TextTrackInfo> list2) {
            return list.get(0).compareTo(list2.get(0));
        }
    }

    private static final class OtherTrackScore implements Comparable<OtherTrackScore> {
        private final boolean isDefault;
        private final boolean isWithinRendererCapabilities;

        public OtherTrackScore(Format format, int i) {
            this.isDefault = (format.selectionFlags & 1) == 0 ? false : true;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i, false);
        }

        public int compareTo(OtherTrackScore otherTrackScore) {
            return ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, otherTrackScore.isWithinRendererCapabilities).compareFalseFirst(this.isDefault, otherTrackScore.isDefault).result();
        }
    }

    private static class SpatializerWrapperV32 {
        private Handler handler;
        private Spatializer.OnSpatializerStateChangedListener listener;
        private final boolean spatializationSupported;
        private final Spatializer spatializer;

        public static SpatializerWrapperV32 tryCreateInstance(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                return null;
            }
            return new SpatializerWrapperV32(audioManager.getSpatializer());
        }

        private SpatializerWrapperV32(Spatializer spatializer2) {
            this.spatializer = spatializer2;
            this.spatializationSupported = spatializer2.getImmersiveAudioLevel() != 0;
        }

        public void ensureInitialized(final DefaultTrackSelector defaultTrackSelector, Looper looper) {
            if (this.listener == null && this.handler == null) {
                this.listener = new Spatializer.OnSpatializerStateChangedListener(this) {
                    public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
                        defaultTrackSelector.maybeInvalidateForAudioChannelCountConstraints();
                    }

                    public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
                        defaultTrackSelector.maybeInvalidateForAudioChannelCountConstraints();
                    }
                };
                Handler handler2 = new Handler(looper);
                this.handler = handler2;
                Spatializer spatializer2 = this.spatializer;
                Objects.requireNonNull(handler2);
                spatializer2.addOnSpatializerStateChangedListener(new DefaultTrackSelector$SpatializerWrapperV32$$ExternalSyntheticLambda0(handler2), this.listener);
            }
        }

        public boolean isSpatializationSupported() {
            return this.spatializationSupported;
        }

        public boolean isAvailable() {
            return this.spatializer.isAvailable();
        }

        public boolean isEnabled() {
            return this.spatializer.isEnabled();
        }

        public boolean canBeSpatialized(AudioAttributes audioAttributes, Format format) {
            int i;
            if (!MimeTypes.AUDIO_E_AC3_JOC.equals(format.sampleMimeType) || format.channelCount != 16) {
                i = format.channelCount;
            } else {
                i = 12;
            }
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(Util.getAudioTrackChannelConfig(i));
            if (format.sampleRate != -1) {
                channelMask.setSampleRate(format.sampleRate);
            }
            return this.spatializer.canBeSpatialized(audioAttributes.getAudioAttributesV21().audioAttributes, channelMask.build());
        }

        public void release() {
            Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.listener;
            if (onSpatializerStateChangedListener != null && this.handler != null) {
                this.spatializer.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
                ((Handler) Util.castNonNull(this.handler)).removeCallbacksAndMessages((Object) null);
                this.handler = null;
                this.listener = null;
            }
        }
    }
}

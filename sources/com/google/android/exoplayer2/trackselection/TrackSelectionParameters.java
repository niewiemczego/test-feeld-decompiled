package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class TrackSelectionParameters implements Bundleable {
    @Deprecated
    public static final Bundleable.Creator<TrackSelectionParameters> CREATOR = new TrackSelectionParameters$$ExternalSyntheticLambda0();
    @Deprecated
    public static final TrackSelectionParameters DEFAULT;
    public static final TrackSelectionParameters DEFAULT_WITHOUT_CONTEXT;
    protected static final int FIELD_CUSTOM_ID_BASE = 1000;
    private static final int FIELD_DISABLED_TRACK_TYPE = 24;
    private static final int FIELD_FORCE_HIGHEST_SUPPORTED_BITRATE = 22;
    private static final int FIELD_FORCE_LOWEST_BITRATE = 21;
    private static final int FIELD_IGNORED_TEXT_SELECTION_FLAGS = 26;
    private static final int FIELD_MAX_AUDIO_BITRATE = 19;
    private static final int FIELD_MAX_AUDIO_CHANNEL_COUNT = 18;
    private static final int FIELD_MAX_VIDEO_BITRATE = 9;
    private static final int FIELD_MAX_VIDEO_FRAMERATE = 8;
    private static final int FIELD_MAX_VIDEO_HEIGHT = 7;
    private static final int FIELD_MAX_VIDEO_WIDTH = 6;
    private static final int FIELD_MIN_VIDEO_BITRATE = 13;
    private static final int FIELD_MIN_VIDEO_FRAMERATE = 12;
    private static final int FIELD_MIN_VIDEO_HEIGHT = 11;
    private static final int FIELD_MIN_VIDEO_WIDTH = 10;
    private static final int FIELD_PREFERRED_AUDIO_LANGUAGES = 1;
    private static final int FIELD_PREFERRED_AUDIO_MIME_TYPES = 20;
    private static final int FIELD_PREFERRED_AUDIO_ROLE_FLAGS = 2;
    private static final int FIELD_PREFERRED_TEXT_LANGUAGES = 3;
    private static final int FIELD_PREFERRED_TEXT_ROLE_FLAGS = 4;
    private static final int FIELD_PREFERRED_VIDEO_MIMETYPES = 17;
    private static final int FIELD_PREFERRED_VIDEO_ROLE_FLAGS = 25;
    private static final int FIELD_SELECTION_OVERRIDES = 23;
    private static final int FIELD_SELECT_UNDETERMINED_TEXT_LANGUAGE = 5;
    private static final int FIELD_VIEWPORT_HEIGHT = 15;
    private static final int FIELD_VIEWPORT_ORIENTATION_MAY_CHANGE = 16;
    private static final int FIELD_VIEWPORT_WIDTH = 14;
    public final ImmutableSet<Integer> disabledTrackTypes;
    public final boolean forceHighestSupportedBitrate;
    public final boolean forceLowestBitrate;
    public final int ignoredTextSelectionFlags;
    public final int maxAudioBitrate;
    public final int maxAudioChannelCount;
    public final int maxVideoBitrate;
    public final int maxVideoFrameRate;
    public final int maxVideoHeight;
    public final int maxVideoWidth;
    public final int minVideoBitrate;
    public final int minVideoFrameRate;
    public final int minVideoHeight;
    public final int minVideoWidth;
    public final ImmutableMap<TrackGroup, TrackSelectionOverride> overrides;
    public final ImmutableList<String> preferredAudioLanguages;
    public final ImmutableList<String> preferredAudioMimeTypes;
    public final int preferredAudioRoleFlags;
    public final ImmutableList<String> preferredTextLanguages;
    public final int preferredTextRoleFlags;
    public final ImmutableList<String> preferredVideoMimeTypes;
    public final int preferredVideoRoleFlags;
    public final boolean selectUndeterminedTextLanguage;
    public final int viewportHeight;
    public final boolean viewportOrientationMayChange;
    public final int viewportWidth;

    public static class Builder {
        /* access modifiers changed from: private */
        public HashSet<Integer> disabledTrackTypes;
        /* access modifiers changed from: private */
        public boolean forceHighestSupportedBitrate;
        /* access modifiers changed from: private */
        public boolean forceLowestBitrate;
        /* access modifiers changed from: private */
        public int ignoredTextSelectionFlags;
        /* access modifiers changed from: private */
        public int maxAudioBitrate;
        /* access modifiers changed from: private */
        public int maxAudioChannelCount;
        /* access modifiers changed from: private */
        public int maxVideoBitrate;
        /* access modifiers changed from: private */
        public int maxVideoFrameRate;
        /* access modifiers changed from: private */
        public int maxVideoHeight;
        /* access modifiers changed from: private */
        public int maxVideoWidth;
        /* access modifiers changed from: private */
        public int minVideoBitrate;
        /* access modifiers changed from: private */
        public int minVideoFrameRate;
        /* access modifiers changed from: private */
        public int minVideoHeight;
        /* access modifiers changed from: private */
        public int minVideoWidth;
        /* access modifiers changed from: private */
        public HashMap<TrackGroup, TrackSelectionOverride> overrides;
        /* access modifiers changed from: private */
        public ImmutableList<String> preferredAudioLanguages;
        /* access modifiers changed from: private */
        public ImmutableList<String> preferredAudioMimeTypes;
        /* access modifiers changed from: private */
        public int preferredAudioRoleFlags;
        /* access modifiers changed from: private */
        public ImmutableList<String> preferredTextLanguages;
        /* access modifiers changed from: private */
        public int preferredTextRoleFlags;
        /* access modifiers changed from: private */
        public ImmutableList<String> preferredVideoMimeTypes;
        /* access modifiers changed from: private */
        public int preferredVideoRoleFlags;
        /* access modifiers changed from: private */
        public boolean selectUndeterminedTextLanguage;
        /* access modifiers changed from: private */
        public int viewportHeight;
        /* access modifiers changed from: private */
        public boolean viewportOrientationMayChange;
        /* access modifiers changed from: private */
        public int viewportWidth;

        @Deprecated
        public Builder() {
            this.maxVideoWidth = Integer.MAX_VALUE;
            this.maxVideoHeight = Integer.MAX_VALUE;
            this.maxVideoFrameRate = Integer.MAX_VALUE;
            this.maxVideoBitrate = Integer.MAX_VALUE;
            this.viewportWidth = Integer.MAX_VALUE;
            this.viewportHeight = Integer.MAX_VALUE;
            this.viewportOrientationMayChange = true;
            this.preferredVideoMimeTypes = ImmutableList.of();
            this.preferredVideoRoleFlags = 0;
            this.preferredAudioLanguages = ImmutableList.of();
            this.preferredAudioRoleFlags = 0;
            this.maxAudioChannelCount = Integer.MAX_VALUE;
            this.maxAudioBitrate = Integer.MAX_VALUE;
            this.preferredAudioMimeTypes = ImmutableList.of();
            this.preferredTextLanguages = ImmutableList.of();
            this.preferredTextRoleFlags = 0;
            this.ignoredTextSelectionFlags = 0;
            this.selectUndeterminedTextLanguage = false;
            this.forceLowestBitrate = false;
            this.forceHighestSupportedBitrate = false;
            this.overrides = new HashMap<>();
            this.disabledTrackTypes = new HashSet<>();
        }

        public Builder(Context context) {
            this();
            setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
            setViewportSizeToPhysicalDisplaySize(context, true);
        }

        protected Builder(TrackSelectionParameters trackSelectionParameters) {
            init(trackSelectionParameters);
        }

        protected Builder(Bundle bundle) {
            ImmutableList<TrackSelectionOverride> immutableList;
            this.maxVideoWidth = bundle.getInt(TrackSelectionParameters.keyForField(6), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.maxVideoWidth);
            this.maxVideoHeight = bundle.getInt(TrackSelectionParameters.keyForField(7), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.maxVideoHeight);
            this.maxVideoFrameRate = bundle.getInt(TrackSelectionParameters.keyForField(8), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.maxVideoFrameRate);
            this.maxVideoBitrate = bundle.getInt(TrackSelectionParameters.keyForField(9), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.maxVideoBitrate);
            this.minVideoWidth = bundle.getInt(TrackSelectionParameters.keyForField(10), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.minVideoWidth);
            this.minVideoHeight = bundle.getInt(TrackSelectionParameters.keyForField(11), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.minVideoHeight);
            this.minVideoFrameRate = bundle.getInt(TrackSelectionParameters.keyForField(12), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.minVideoFrameRate);
            this.minVideoBitrate = bundle.getInt(TrackSelectionParameters.keyForField(13), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.minVideoBitrate);
            this.viewportWidth = bundle.getInt(TrackSelectionParameters.keyForField(14), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.viewportWidth);
            this.viewportHeight = bundle.getInt(TrackSelectionParameters.keyForField(15), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.viewportHeight);
            this.viewportOrientationMayChange = bundle.getBoolean(TrackSelectionParameters.keyForField(16), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.viewportOrientationMayChange);
            this.preferredVideoMimeTypes = ImmutableList.copyOf((E[]) (String[]) MoreObjects.firstNonNull(bundle.getStringArray(TrackSelectionParameters.keyForField(17)), new String[0]));
            this.preferredVideoRoleFlags = bundle.getInt(TrackSelectionParameters.keyForField(25), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.preferredVideoRoleFlags);
            this.preferredAudioLanguages = normalizeLanguageCodes((String[]) MoreObjects.firstNonNull(bundle.getStringArray(TrackSelectionParameters.keyForField(1)), new String[0]));
            this.preferredAudioRoleFlags = bundle.getInt(TrackSelectionParameters.keyForField(2), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.preferredAudioRoleFlags);
            this.maxAudioChannelCount = bundle.getInt(TrackSelectionParameters.keyForField(18), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.maxAudioChannelCount);
            this.maxAudioBitrate = bundle.getInt(TrackSelectionParameters.keyForField(19), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.maxAudioBitrate);
            this.preferredAudioMimeTypes = ImmutableList.copyOf((E[]) (String[]) MoreObjects.firstNonNull(bundle.getStringArray(TrackSelectionParameters.keyForField(20)), new String[0]));
            this.preferredTextLanguages = normalizeLanguageCodes((String[]) MoreObjects.firstNonNull(bundle.getStringArray(TrackSelectionParameters.keyForField(3)), new String[0]));
            this.preferredTextRoleFlags = bundle.getInt(TrackSelectionParameters.keyForField(4), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.preferredTextRoleFlags);
            this.ignoredTextSelectionFlags = bundle.getInt(TrackSelectionParameters.keyForField(26), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.ignoredTextSelectionFlags);
            this.selectUndeterminedTextLanguage = bundle.getBoolean(TrackSelectionParameters.keyForField(5), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.selectUndeterminedTextLanguage);
            this.forceLowestBitrate = bundle.getBoolean(TrackSelectionParameters.keyForField(21), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.forceLowestBitrate);
            this.forceHighestSupportedBitrate = bundle.getBoolean(TrackSelectionParameters.keyForField(22), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.forceHighestSupportedBitrate);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(TrackSelectionParameters.keyForField(23));
            if (parcelableArrayList == null) {
                immutableList = ImmutableList.of();
            } else {
                immutableList = BundleableUtil.fromBundleList(TrackSelectionOverride.CREATOR, parcelableArrayList);
            }
            this.overrides = new HashMap<>();
            for (int i = 0; i < immutableList.size(); i++) {
                TrackSelectionOverride trackSelectionOverride = immutableList.get(i);
                this.overrides.put(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
            }
            int[] iArr = (int[]) MoreObjects.firstNonNull(bundle.getIntArray(TrackSelectionParameters.keyForField(24)), new int[0]);
            this.disabledTrackTypes = new HashSet<>();
            for (int valueOf : iArr) {
                this.disabledTrackTypes.add(Integer.valueOf(valueOf));
            }
        }

        @EnsuresNonNull({"preferredVideoMimeTypes", "preferredAudioLanguages", "preferredAudioMimeTypes", "preferredTextLanguages", "overrides", "disabledTrackTypes"})
        private void init(TrackSelectionParameters trackSelectionParameters) {
            this.maxVideoWidth = trackSelectionParameters.maxVideoWidth;
            this.maxVideoHeight = trackSelectionParameters.maxVideoHeight;
            this.maxVideoFrameRate = trackSelectionParameters.maxVideoFrameRate;
            this.maxVideoBitrate = trackSelectionParameters.maxVideoBitrate;
            this.minVideoWidth = trackSelectionParameters.minVideoWidth;
            this.minVideoHeight = trackSelectionParameters.minVideoHeight;
            this.minVideoFrameRate = trackSelectionParameters.minVideoFrameRate;
            this.minVideoBitrate = trackSelectionParameters.minVideoBitrate;
            this.viewportWidth = trackSelectionParameters.viewportWidth;
            this.viewportHeight = trackSelectionParameters.viewportHeight;
            this.viewportOrientationMayChange = trackSelectionParameters.viewportOrientationMayChange;
            this.preferredVideoMimeTypes = trackSelectionParameters.preferredVideoMimeTypes;
            this.preferredVideoRoleFlags = trackSelectionParameters.preferredVideoRoleFlags;
            this.preferredAudioLanguages = trackSelectionParameters.preferredAudioLanguages;
            this.preferredAudioRoleFlags = trackSelectionParameters.preferredAudioRoleFlags;
            this.maxAudioChannelCount = trackSelectionParameters.maxAudioChannelCount;
            this.maxAudioBitrate = trackSelectionParameters.maxAudioBitrate;
            this.preferredAudioMimeTypes = trackSelectionParameters.preferredAudioMimeTypes;
            this.preferredTextLanguages = trackSelectionParameters.preferredTextLanguages;
            this.preferredTextRoleFlags = trackSelectionParameters.preferredTextRoleFlags;
            this.ignoredTextSelectionFlags = trackSelectionParameters.ignoredTextSelectionFlags;
            this.selectUndeterminedTextLanguage = trackSelectionParameters.selectUndeterminedTextLanguage;
            this.forceLowestBitrate = trackSelectionParameters.forceLowestBitrate;
            this.forceHighestSupportedBitrate = trackSelectionParameters.forceHighestSupportedBitrate;
            this.disabledTrackTypes = new HashSet<>(trackSelectionParameters.disabledTrackTypes);
            this.overrides = new HashMap<>(trackSelectionParameters.overrides);
        }

        /* access modifiers changed from: protected */
        public Builder set(TrackSelectionParameters trackSelectionParameters) {
            init(trackSelectionParameters);
            return this;
        }

        public Builder setMaxVideoSizeSd() {
            return setMaxVideoSize(AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD);
        }

        public Builder clearVideoSizeConstraints() {
            return setMaxVideoSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public Builder setMaxVideoSize(int i, int i2) {
            this.maxVideoWidth = i;
            this.maxVideoHeight = i2;
            return this;
        }

        public Builder setMaxVideoFrameRate(int i) {
            this.maxVideoFrameRate = i;
            return this;
        }

        public Builder setMaxVideoBitrate(int i) {
            this.maxVideoBitrate = i;
            return this;
        }

        public Builder setMinVideoSize(int i, int i2) {
            this.minVideoWidth = i;
            this.minVideoHeight = i2;
            return this;
        }

        public Builder setMinVideoFrameRate(int i) {
            this.minVideoFrameRate = i;
            return this;
        }

        public Builder setMinVideoBitrate(int i) {
            this.minVideoBitrate = i;
            return this;
        }

        public Builder setViewportSizeToPhysicalDisplaySize(Context context, boolean z) {
            Point currentDisplayModeSize = Util.getCurrentDisplayModeSize(context);
            return setViewportSize(currentDisplayModeSize.x, currentDisplayModeSize.y, z);
        }

        public Builder clearViewportSizeConstraints() {
            return setViewportSize(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public Builder setViewportSize(int i, int i2, boolean z) {
            this.viewportWidth = i;
            this.viewportHeight = i2;
            this.viewportOrientationMayChange = z;
            return this;
        }

        public Builder setPreferredVideoMimeType(String str) {
            if (str == null) {
                return setPreferredVideoMimeTypes(new String[0]);
            }
            return setPreferredVideoMimeTypes(str);
        }

        public Builder setPreferredVideoMimeTypes(String... strArr) {
            this.preferredVideoMimeTypes = ImmutableList.copyOf((E[]) strArr);
            return this;
        }

        public Builder setPreferredVideoRoleFlags(int i) {
            this.preferredVideoRoleFlags = i;
            return this;
        }

        public Builder setPreferredAudioLanguage(String str) {
            if (str == null) {
                return setPreferredAudioLanguages(new String[0]);
            }
            return setPreferredAudioLanguages(str);
        }

        public Builder setPreferredAudioLanguages(String... strArr) {
            this.preferredAudioLanguages = normalizeLanguageCodes(strArr);
            return this;
        }

        public Builder setPreferredAudioRoleFlags(int i) {
            this.preferredAudioRoleFlags = i;
            return this;
        }

        public Builder setMaxAudioChannelCount(int i) {
            this.maxAudioChannelCount = i;
            return this;
        }

        public Builder setMaxAudioBitrate(int i) {
            this.maxAudioBitrate = i;
            return this;
        }

        public Builder setPreferredAudioMimeType(String str) {
            if (str == null) {
                return setPreferredAudioMimeTypes(new String[0]);
            }
            return setPreferredAudioMimeTypes(str);
        }

        public Builder setPreferredAudioMimeTypes(String... strArr) {
            this.preferredAudioMimeTypes = ImmutableList.copyOf((E[]) strArr);
            return this;
        }

        public Builder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            if (Util.SDK_INT >= 19) {
                setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettingsV19(context);
            }
            return this;
        }

        public Builder setPreferredTextLanguage(String str) {
            if (str == null) {
                return setPreferredTextLanguages(new String[0]);
            }
            return setPreferredTextLanguages(str);
        }

        public Builder setPreferredTextLanguages(String... strArr) {
            this.preferredTextLanguages = normalizeLanguageCodes(strArr);
            return this;
        }

        public Builder setPreferredTextRoleFlags(int i) {
            this.preferredTextRoleFlags = i;
            return this;
        }

        public Builder setIgnoredTextSelectionFlags(int i) {
            this.ignoredTextSelectionFlags = i;
            return this;
        }

        public Builder setSelectUndeterminedTextLanguage(boolean z) {
            this.selectUndeterminedTextLanguage = z;
            return this;
        }

        public Builder setForceLowestBitrate(boolean z) {
            this.forceLowestBitrate = z;
            return this;
        }

        public Builder setForceHighestSupportedBitrate(boolean z) {
            this.forceHighestSupportedBitrate = z;
            return this;
        }

        public Builder addOverride(TrackSelectionOverride trackSelectionOverride) {
            this.overrides.put(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
            return this;
        }

        public Builder setOverrideForType(TrackSelectionOverride trackSelectionOverride) {
            clearOverridesOfType(trackSelectionOverride.getType());
            this.overrides.put(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
            return this;
        }

        public Builder clearOverride(TrackGroup trackGroup) {
            this.overrides.remove(trackGroup);
            return this;
        }

        public Builder clearOverridesOfType(int i) {
            Iterator<TrackSelectionOverride> it = this.overrides.values().iterator();
            while (it.hasNext()) {
                if (it.next().getType() == i) {
                    it.remove();
                }
            }
            return this;
        }

        public Builder clearOverrides() {
            this.overrides.clear();
            return this;
        }

        @Deprecated
        public Builder setDisabledTrackTypes(Set<Integer> set) {
            this.disabledTrackTypes.clear();
            this.disabledTrackTypes.addAll(set);
            return this;
        }

        public Builder setTrackTypeDisabled(int i, boolean z) {
            if (z) {
                this.disabledTrackTypes.add(Integer.valueOf(i));
            } else {
                this.disabledTrackTypes.remove(Integer.valueOf(i));
            }
            return this;
        }

        public TrackSelectionParameters build() {
            return new TrackSelectionParameters(this);
        }

        private void setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettingsV19(Context context) {
            CaptioningManager captioningManager;
            if ((Util.SDK_INT >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.preferredTextRoleFlags = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.preferredTextLanguages = ImmutableList.of(Util.getLocaleLanguageTag(locale));
                }
            }
        }

        private static ImmutableList<String> normalizeLanguageCodes(String[] strArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (String checkNotNull : (String[]) Assertions.checkNotNull(strArr)) {
                builder.add((Object) Util.normalizeLanguageCode((String) Assertions.checkNotNull(checkNotNull)));
            }
            return builder.build();
        }
    }

    static {
        TrackSelectionParameters build = new Builder().build();
        DEFAULT_WITHOUT_CONTEXT = build;
        DEFAULT = build;
    }

    public static TrackSelectionParameters getDefaults(Context context) {
        return new Builder(context).build();
    }

    protected TrackSelectionParameters(Builder builder) {
        this.maxVideoWidth = builder.maxVideoWidth;
        this.maxVideoHeight = builder.maxVideoHeight;
        this.maxVideoFrameRate = builder.maxVideoFrameRate;
        this.maxVideoBitrate = builder.maxVideoBitrate;
        this.minVideoWidth = builder.minVideoWidth;
        this.minVideoHeight = builder.minVideoHeight;
        this.minVideoFrameRate = builder.minVideoFrameRate;
        this.minVideoBitrate = builder.minVideoBitrate;
        this.viewportWidth = builder.viewportWidth;
        this.viewportHeight = builder.viewportHeight;
        this.viewportOrientationMayChange = builder.viewportOrientationMayChange;
        this.preferredVideoMimeTypes = builder.preferredVideoMimeTypes;
        this.preferredVideoRoleFlags = builder.preferredVideoRoleFlags;
        this.preferredAudioLanguages = builder.preferredAudioLanguages;
        this.preferredAudioRoleFlags = builder.preferredAudioRoleFlags;
        this.maxAudioChannelCount = builder.maxAudioChannelCount;
        this.maxAudioBitrate = builder.maxAudioBitrate;
        this.preferredAudioMimeTypes = builder.preferredAudioMimeTypes;
        this.preferredTextLanguages = builder.preferredTextLanguages;
        this.preferredTextRoleFlags = builder.preferredTextRoleFlags;
        this.ignoredTextSelectionFlags = builder.ignoredTextSelectionFlags;
        this.selectUndeterminedTextLanguage = builder.selectUndeterminedTextLanguage;
        this.forceLowestBitrate = builder.forceLowestBitrate;
        this.forceHighestSupportedBitrate = builder.forceHighestSupportedBitrate;
        this.overrides = ImmutableMap.copyOf(builder.overrides);
        this.disabledTrackTypes = ImmutableSet.copyOf(builder.disabledTrackTypes);
    }

    public Builder buildUpon() {
        return new Builder(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        if (this.maxVideoWidth == trackSelectionParameters.maxVideoWidth && this.maxVideoHeight == trackSelectionParameters.maxVideoHeight && this.maxVideoFrameRate == trackSelectionParameters.maxVideoFrameRate && this.maxVideoBitrate == trackSelectionParameters.maxVideoBitrate && this.minVideoWidth == trackSelectionParameters.minVideoWidth && this.minVideoHeight == trackSelectionParameters.minVideoHeight && this.minVideoFrameRate == trackSelectionParameters.minVideoFrameRate && this.minVideoBitrate == trackSelectionParameters.minVideoBitrate && this.viewportOrientationMayChange == trackSelectionParameters.viewportOrientationMayChange && this.viewportWidth == trackSelectionParameters.viewportWidth && this.viewportHeight == trackSelectionParameters.viewportHeight && this.preferredVideoMimeTypes.equals(trackSelectionParameters.preferredVideoMimeTypes) && this.preferredVideoRoleFlags == trackSelectionParameters.preferredVideoRoleFlags && this.preferredAudioLanguages.equals(trackSelectionParameters.preferredAudioLanguages) && this.preferredAudioRoleFlags == trackSelectionParameters.preferredAudioRoleFlags && this.maxAudioChannelCount == trackSelectionParameters.maxAudioChannelCount && this.maxAudioBitrate == trackSelectionParameters.maxAudioBitrate && this.preferredAudioMimeTypes.equals(trackSelectionParameters.preferredAudioMimeTypes) && this.preferredTextLanguages.equals(trackSelectionParameters.preferredTextLanguages) && this.preferredTextRoleFlags == trackSelectionParameters.preferredTextRoleFlags && this.ignoredTextSelectionFlags == trackSelectionParameters.ignoredTextSelectionFlags && this.selectUndeterminedTextLanguage == trackSelectionParameters.selectUndeterminedTextLanguage && this.forceLowestBitrate == trackSelectionParameters.forceLowestBitrate && this.forceHighestSupportedBitrate == trackSelectionParameters.forceHighestSupportedBitrate && this.overrides.equals(trackSelectionParameters.overrides) && this.disabledTrackTypes.equals(trackSelectionParameters.disabledTrackTypes)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((this.maxVideoWidth + 31) * 31) + this.maxVideoHeight) * 31) + this.maxVideoFrameRate) * 31) + this.maxVideoBitrate) * 31) + this.minVideoWidth) * 31) + this.minVideoHeight) * 31) + this.minVideoFrameRate) * 31) + this.minVideoBitrate) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31) + this.preferredVideoMimeTypes.hashCode()) * 31) + this.preferredVideoRoleFlags) * 31) + this.preferredAudioLanguages.hashCode()) * 31) + this.preferredAudioRoleFlags) * 31) + this.maxAudioChannelCount) * 31) + this.maxAudioBitrate) * 31) + this.preferredAudioMimeTypes.hashCode()) * 31) + this.preferredTextLanguages.hashCode()) * 31) + this.preferredTextRoleFlags) * 31) + this.ignoredTextSelectionFlags) * 31) + (this.selectUndeterminedTextLanguage ? 1 : 0)) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.forceHighestSupportedBitrate ? 1 : 0)) * 31) + this.overrides.hashCode()) * 31) + this.disabledTrackTypes.hashCode();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(keyForField(6), this.maxVideoWidth);
        bundle.putInt(keyForField(7), this.maxVideoHeight);
        bundle.putInt(keyForField(8), this.maxVideoFrameRate);
        bundle.putInt(keyForField(9), this.maxVideoBitrate);
        bundle.putInt(keyForField(10), this.minVideoWidth);
        bundle.putInt(keyForField(11), this.minVideoHeight);
        bundle.putInt(keyForField(12), this.minVideoFrameRate);
        bundle.putInt(keyForField(13), this.minVideoBitrate);
        bundle.putInt(keyForField(14), this.viewportWidth);
        bundle.putInt(keyForField(15), this.viewportHeight);
        bundle.putBoolean(keyForField(16), this.viewportOrientationMayChange);
        bundle.putStringArray(keyForField(17), (String[]) this.preferredVideoMimeTypes.toArray(new String[0]));
        bundle.putInt(keyForField(25), this.preferredVideoRoleFlags);
        bundle.putStringArray(keyForField(1), (String[]) this.preferredAudioLanguages.toArray(new String[0]));
        bundle.putInt(keyForField(2), this.preferredAudioRoleFlags);
        bundle.putInt(keyForField(18), this.maxAudioChannelCount);
        bundle.putInt(keyForField(19), this.maxAudioBitrate);
        bundle.putStringArray(keyForField(20), (String[]) this.preferredAudioMimeTypes.toArray(new String[0]));
        bundle.putStringArray(keyForField(3), (String[]) this.preferredTextLanguages.toArray(new String[0]));
        bundle.putInt(keyForField(4), this.preferredTextRoleFlags);
        bundle.putInt(keyForField(26), this.ignoredTextSelectionFlags);
        bundle.putBoolean(keyForField(5), this.selectUndeterminedTextLanguage);
        bundle.putBoolean(keyForField(21), this.forceLowestBitrate);
        bundle.putBoolean(keyForField(22), this.forceHighestSupportedBitrate);
        bundle.putParcelableArrayList(keyForField(23), BundleableUtil.toBundleArrayList(this.overrides.values()));
        bundle.putIntArray(keyForField(24), Ints.toArray(this.disabledTrackTypes));
        return bundle;
    }

    public static TrackSelectionParameters fromBundle(Bundle bundle) {
        return new Builder(bundle).build();
    }

    protected static String keyForField(int i) {
        return Integer.toString(i, 36);
    }
}

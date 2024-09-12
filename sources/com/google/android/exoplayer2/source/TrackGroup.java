package com.google.android.exoplayer2.source;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;

public final class TrackGroup implements Bundleable {
    public static final Bundleable.Creator<TrackGroup> CREATOR = new TrackGroup$$ExternalSyntheticLambda0();
    private static final int FIELD_FORMATS = 0;
    private static final int FIELD_ID = 1;
    private static final String TAG = "TrackGroup";
    private final Format[] formats;
    private int hashCode;
    public final String id;
    public final int length;
    public final int type;

    private static int normalizeRoleFlags(int i) {
        return i | 16384;
    }

    public TrackGroup(Format... formatArr) {
        this("", formatArr);
    }

    public TrackGroup(String str, Format... formatArr) {
        Assertions.checkArgument(formatArr.length > 0);
        this.id = str;
        this.formats = formatArr;
        this.length = formatArr.length;
        int trackType = MimeTypes.getTrackType(formatArr[0].sampleMimeType);
        this.type = trackType == -1 ? MimeTypes.getTrackType(formatArr[0].containerMimeType) : trackType;
        verifyCorrectness();
    }

    public TrackGroup copyWithId(String str) {
        return new TrackGroup(str, this.formats);
    }

    public Format getFormat(int i) {
        return this.formats[i];
    }

    public int indexOf(Format format) {
        int i = 0;
        while (true) {
            Format[] formatArr = this.formats;
            if (i >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i]) {
                return i;
            }
            i++;
        }
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((527 + this.id.hashCode()) * 31) + Arrays.hashCode(this.formats);
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        if (!this.id.equals(trackGroup.id) || !Arrays.equals(this.formats, trackGroup.formats)) {
            return false;
        }
        return true;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(keyForField(0), BundleableUtil.toBundleArrayList(Lists.newArrayList((E[]) this.formats)));
        bundle.putString(keyForField(1), this.id);
        return bundle;
    }

    static /* synthetic */ TrackGroup lambda$static$0(Bundle bundle) {
        ImmutableList<Format> immutableList;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(keyForField(0));
        if (parcelableArrayList == null) {
            immutableList = ImmutableList.of();
        } else {
            immutableList = BundleableUtil.fromBundleList(Format.CREATOR, parcelableArrayList);
        }
        return new TrackGroup(bundle.getString(keyForField(1), ""), (Format[]) immutableList.toArray(new Format[0]));
    }

    private static String keyForField(int i) {
        return Integer.toString(i, 36);
    }

    private void verifyCorrectness() {
        String normalizeLanguage = normalizeLanguage(this.formats[0].language);
        int normalizeRoleFlags = normalizeRoleFlags(this.formats[0].roleFlags);
        int i = 1;
        while (true) {
            Format[] formatArr = this.formats;
            if (i >= formatArr.length) {
                return;
            }
            if (!normalizeLanguage.equals(normalizeLanguage(formatArr[i].language))) {
                logErrorMessage("languages", this.formats[0].language, this.formats[i].language, i);
                return;
            } else if (normalizeRoleFlags != normalizeRoleFlags(this.formats[i].roleFlags)) {
                logErrorMessage("role flags", Integer.toBinaryString(this.formats[0].roleFlags), Integer.toBinaryString(this.formats[i].roleFlags), i);
                return;
            } else {
                i++;
            }
        }
    }

    private static String normalizeLanguage(String str) {
        return (str == null || str.equals(C.LANGUAGE_UNDETERMINED)) ? "" : str;
    }

    private static void logErrorMessage(String str, String str2, String str3, int i) {
        Log.e(TAG, "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i + ")"));
    }
}

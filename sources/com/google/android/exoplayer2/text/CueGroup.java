package com.google.android.exoplayer2.text;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public final class CueGroup implements Bundleable {
    public static final Bundleable.Creator<CueGroup> CREATOR = new CueGroup$$ExternalSyntheticLambda0();
    public static final CueGroup EMPTY = new CueGroup(ImmutableList.of());
    private static final int FIELD_CUES = 0;
    public final ImmutableList<Cue> cues;

    public CueGroup(List<Cue> list) {
        this.cues = ImmutableList.copyOf(list);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(keyForField(0), BundleableUtil.toBundleArrayList(filterOutBitmapCues(this.cues)));
        return bundle;
    }

    /* access modifiers changed from: private */
    public static final CueGroup fromBundle(Bundle bundle) {
        ImmutableList<Cue> immutableList;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(keyForField(0));
        if (parcelableArrayList == null) {
            immutableList = ImmutableList.of();
        } else {
            immutableList = BundleableUtil.fromBundleList(Cue.CREATOR, parcelableArrayList);
        }
        return new CueGroup(immutableList);
    }

    private static String keyForField(int i) {
        return Integer.toString(i, 36);
    }

    private static ImmutableList<Cue> filterOutBitmapCues(List<Cue> list) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).bitmap == null) {
                builder.add((Object) list.get(i));
            }
        }
        return builder.build();
    }
}

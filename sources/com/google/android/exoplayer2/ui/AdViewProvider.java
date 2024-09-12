package com.google.android.exoplayer2.ui;

import android.view.ViewGroup;
import com.google.common.collect.ImmutableList;
import java.util.List;

public interface AdViewProvider {
    ViewGroup getAdViewGroup();

    List<AdOverlayInfo> getAdOverlayInfos() {
        return ImmutableList.of();
    }
}

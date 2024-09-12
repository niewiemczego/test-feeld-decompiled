package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionOverride;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrackSelectionView extends LinearLayout {
    private boolean allowAdaptiveSelections;
    private boolean allowMultipleOverrides;
    private final ComponentListener componentListener;
    private final CheckedTextView defaultView;
    private final CheckedTextView disableView;
    private final LayoutInflater inflater;
    private boolean isDisabled;
    private TrackSelectionListener listener;
    private final Map<TrackGroup, TrackSelectionOverride> overrides;
    private final int selectableItemBackgroundResourceId;
    private final List<Tracks.Group> trackGroups;
    private Comparator<TrackInfo> trackInfoComparator;
    private TrackNameProvider trackNameProvider;
    private CheckedTextView[][] trackViews;

    public interface TrackSelectionListener {
        void onTrackSelectionChanged(boolean z, Map<TrackGroup, TrackSelectionOverride> map);
    }

    public static Map<TrackGroup, TrackSelectionOverride> filterOverrides(Map<TrackGroup, TrackSelectionOverride> map, List<Tracks.Group> list, boolean z) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            TrackSelectionOverride trackSelectionOverride = map.get(list.get(i).getMediaTrackGroup());
            if (trackSelectionOverride != null && (z || hashMap.isEmpty())) {
                hashMap.put(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
            }
        }
        return hashMap;
    }

    public TrackSelectionView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(1);
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843534});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.selectableItemBackgroundResourceId = resourceId;
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.inflater = from;
        ComponentListener componentListener2 = new ComponentListener();
        this.componentListener = componentListener2;
        this.trackNameProvider = new DefaultTrackNameProvider(getResources());
        this.trackGroups = new ArrayList();
        this.overrides = new HashMap();
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(17367055, this, false);
        this.disableView = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R.string.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(componentListener2);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(R.layout.exo_list_divider, this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(17367055, this, false);
        this.defaultView = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R.string.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(componentListener2);
        addView(checkedTextView2);
    }

    public void setAllowAdaptiveSelections(boolean z) {
        if (this.allowAdaptiveSelections != z) {
            this.allowAdaptiveSelections = z;
            updateViews();
        }
    }

    public void setAllowMultipleOverrides(boolean z) {
        if (this.allowMultipleOverrides != z) {
            this.allowMultipleOverrides = z;
            if (!z && this.overrides.size() > 1) {
                Map<TrackGroup, TrackSelectionOverride> filterOverrides = filterOverrides(this.overrides, this.trackGroups, false);
                this.overrides.clear();
                this.overrides.putAll(filterOverrides);
            }
            updateViews();
        }
    }

    public void setShowDisableOption(boolean z) {
        this.disableView.setVisibility(z ? 0 : 8);
    }

    public void setTrackNameProvider(TrackNameProvider trackNameProvider2) {
        this.trackNameProvider = (TrackNameProvider) Assertions.checkNotNull(trackNameProvider2);
        updateViews();
    }

    public void init(List<Tracks.Group> list, boolean z, Map<TrackGroup, TrackSelectionOverride> map, Comparator<Format> comparator, TrackSelectionListener trackSelectionListener) {
        TrackSelectionView$$ExternalSyntheticLambda0 trackSelectionView$$ExternalSyntheticLambda0;
        this.isDisabled = z;
        if (comparator == null) {
            trackSelectionView$$ExternalSyntheticLambda0 = null;
        } else {
            trackSelectionView$$ExternalSyntheticLambda0 = new TrackSelectionView$$ExternalSyntheticLambda0(comparator);
        }
        this.trackInfoComparator = trackSelectionView$$ExternalSyntheticLambda0;
        this.listener = trackSelectionListener;
        this.trackGroups.clear();
        this.trackGroups.addAll(list);
        this.overrides.clear();
        this.overrides.putAll(filterOverrides(map, list, this.allowMultipleOverrides));
        updateViews();
    }

    public boolean getIsDisabled() {
        return this.isDisabled;
    }

    public Map<TrackGroup, TrackSelectionOverride> getOverrides() {
        return this.overrides;
    }

    private void updateViews() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.trackGroups.isEmpty()) {
            this.disableView.setEnabled(false);
            this.defaultView.setEnabled(false);
            return;
        }
        this.disableView.setEnabled(true);
        this.defaultView.setEnabled(true);
        this.trackViews = new CheckedTextView[this.trackGroups.size()][];
        boolean shouldEnableMultiGroupSelection = shouldEnableMultiGroupSelection();
        for (int i = 0; i < this.trackGroups.size(); i++) {
            Tracks.Group group = this.trackGroups.get(i);
            boolean shouldEnableAdaptiveSelection = shouldEnableAdaptiveSelection(group);
            this.trackViews[i] = new CheckedTextView[group.length];
            int i2 = group.length;
            TrackInfo[] trackInfoArr = new TrackInfo[i2];
            for (int i3 = 0; i3 < group.length; i3++) {
                trackInfoArr[i3] = new TrackInfo(group, i3);
            }
            Comparator<TrackInfo> comparator = this.trackInfoComparator;
            if (comparator != null) {
                Arrays.sort(trackInfoArr, comparator);
            }
            for (int i4 = 0; i4 < i2; i4++) {
                if (i4 == 0) {
                    addView(this.inflater.inflate(R.layout.exo_list_divider, this, false));
                }
                CheckedTextView checkedTextView = (CheckedTextView) this.inflater.inflate((shouldEnableAdaptiveSelection || shouldEnableMultiGroupSelection) ? 17367056 : 17367055, this, false);
                checkedTextView.setBackgroundResource(this.selectableItemBackgroundResourceId);
                checkedTextView.setText(this.trackNameProvider.getTrackName(trackInfoArr[i4].getFormat()));
                checkedTextView.setTag(trackInfoArr[i4]);
                if (group.isTrackSupported(i4)) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setOnClickListener(this.componentListener);
                } else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.trackViews[i][i4] = checkedTextView;
                addView(checkedTextView);
            }
        }
        updateViewStates();
    }

    private void updateViewStates() {
        this.disableView.setChecked(this.isDisabled);
        this.defaultView.setChecked(!this.isDisabled && this.overrides.size() == 0);
        for (int i = 0; i < this.trackViews.length; i++) {
            TrackSelectionOverride trackSelectionOverride = this.overrides.get(this.trackGroups.get(i).getMediaTrackGroup());
            int i2 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.trackViews[i];
                if (i2 >= checkedTextViewArr.length) {
                    break;
                }
                if (trackSelectionOverride != null) {
                    this.trackViews[i][i2].setChecked(trackSelectionOverride.trackIndices.contains(Integer.valueOf(((TrackInfo) Assertions.checkNotNull(checkedTextViewArr[i2].getTag())).trackIndex)));
                } else {
                    checkedTextViewArr[i2].setChecked(false);
                }
                i2++;
            }
        }
    }

    /* access modifiers changed from: private */
    public void onClick(View view) {
        if (view == this.disableView) {
            onDisableViewClicked();
        } else if (view == this.defaultView) {
            onDefaultViewClicked();
        } else {
            onTrackViewClicked(view);
        }
        updateViewStates();
        TrackSelectionListener trackSelectionListener = this.listener;
        if (trackSelectionListener != null) {
            trackSelectionListener.onTrackSelectionChanged(getIsDisabled(), getOverrides());
        }
    }

    private void onDisableViewClicked() {
        this.isDisabled = true;
        this.overrides.clear();
    }

    private void onDefaultViewClicked() {
        this.isDisabled = false;
        this.overrides.clear();
    }

    private void onTrackViewClicked(View view) {
        boolean z = false;
        this.isDisabled = false;
        TrackInfo trackInfo = (TrackInfo) Assertions.checkNotNull(view.getTag());
        TrackGroup mediaTrackGroup = trackInfo.trackGroup.getMediaTrackGroup();
        int i = trackInfo.trackIndex;
        TrackSelectionOverride trackSelectionOverride = this.overrides.get(mediaTrackGroup);
        if (trackSelectionOverride == null) {
            if (!this.allowMultipleOverrides && this.overrides.size() > 0) {
                this.overrides.clear();
            }
            this.overrides.put(mediaTrackGroup, new TrackSelectionOverride(mediaTrackGroup, (List<Integer>) ImmutableList.of(Integer.valueOf(i))));
            return;
        }
        ArrayList arrayList = new ArrayList(trackSelectionOverride.trackIndices);
        boolean isChecked = ((CheckedTextView) view).isChecked();
        boolean shouldEnableAdaptiveSelection = shouldEnableAdaptiveSelection(trackInfo.trackGroup);
        if (shouldEnableAdaptiveSelection || shouldEnableMultiGroupSelection()) {
            z = true;
        }
        if (isChecked && z) {
            arrayList.remove(Integer.valueOf(i));
            if (arrayList.isEmpty()) {
                this.overrides.remove(mediaTrackGroup);
            } else {
                this.overrides.put(mediaTrackGroup, new TrackSelectionOverride(mediaTrackGroup, (List<Integer>) arrayList));
            }
        } else if (isChecked) {
        } else {
            if (shouldEnableAdaptiveSelection) {
                arrayList.add(Integer.valueOf(i));
                this.overrides.put(mediaTrackGroup, new TrackSelectionOverride(mediaTrackGroup, (List<Integer>) arrayList));
                return;
            }
            this.overrides.put(mediaTrackGroup, new TrackSelectionOverride(mediaTrackGroup, (List<Integer>) ImmutableList.of(Integer.valueOf(i))));
        }
    }

    private boolean shouldEnableAdaptiveSelection(Tracks.Group group) {
        return this.allowAdaptiveSelections && group.isAdaptiveSupported();
    }

    private boolean shouldEnableMultiGroupSelection() {
        return this.allowMultipleOverrides && this.trackGroups.size() > 1;
    }

    private class ComponentListener implements View.OnClickListener {
        private ComponentListener() {
        }

        public void onClick(View view) {
            TrackSelectionView.this.onClick(view);
        }
    }

    private static final class TrackInfo {
        public final Tracks.Group trackGroup;
        public final int trackIndex;

        public TrackInfo(Tracks.Group group, int i) {
            this.trackGroup = group;
            this.trackIndex = i;
        }

        public Format getFormat() {
            return this.trackGroup.getTrackFormat(this.trackIndex);
        }
    }
}

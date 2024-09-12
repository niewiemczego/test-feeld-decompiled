package com.google.android.exoplayer2.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionOverride;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.ui.TrackSelectionView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public final class TrackSelectionDialogBuilder {
    private boolean allowAdaptiveSelections;
    private boolean allowMultipleOverrides;
    private final DialogCallback callback;
    private final Context context;
    private boolean isDisabled;
    private Map<TrackGroup, TrackSelectionOverride> overrides;
    private boolean showDisableOption;
    private int themeResId;
    private final CharSequence title;
    private Comparator<Format> trackFormatComparator;
    private final List<Tracks.Group> trackGroups;
    private TrackNameProvider trackNameProvider;

    public interface DialogCallback {
        void onTracksSelected(boolean z, Map<TrackGroup, TrackSelectionOverride> map);
    }

    public TrackSelectionDialogBuilder(Context context2, CharSequence charSequence, List<Tracks.Group> list, DialogCallback dialogCallback) {
        this.context = context2;
        this.title = charSequence;
        this.trackGroups = ImmutableList.copyOf(list);
        this.callback = dialogCallback;
        this.overrides = Collections.emptyMap();
    }

    public TrackSelectionDialogBuilder(Context context2, CharSequence charSequence, Player player, int i) {
        this.context = context2;
        this.title = charSequence;
        ImmutableList<Tracks.Group> groups = player.getCurrentTracks().getGroups();
        this.trackGroups = new ArrayList();
        for (int i2 = 0; i2 < groups.size(); i2++) {
            Tracks.Group group = groups.get(i2);
            if (group.getType() == i) {
                this.trackGroups.add(group);
            }
        }
        this.overrides = Collections.emptyMap();
        this.callback = new TrackSelectionDialogBuilder$$ExternalSyntheticLambda1(player, i);
    }

    static /* synthetic */ void lambda$new$0(Player player, int i, boolean z, Map map) {
        TrackSelectionParameters.Builder buildUpon = player.getTrackSelectionParameters().buildUpon();
        buildUpon.setTrackTypeDisabled(i, z);
        buildUpon.clearOverridesOfType(i);
        for (TrackSelectionOverride addOverride : map.values()) {
            buildUpon.addOverride(addOverride);
        }
        player.setTrackSelectionParameters(buildUpon.build());
    }

    public TrackSelectionDialogBuilder setTheme(int i) {
        this.themeResId = i;
        return this;
    }

    public TrackSelectionDialogBuilder setIsDisabled(boolean z) {
        this.isDisabled = z;
        return this;
    }

    public TrackSelectionDialogBuilder setOverride(TrackSelectionOverride trackSelectionOverride) {
        Map map;
        if (trackSelectionOverride == null) {
            map = Collections.emptyMap();
        } else {
            map = ImmutableMap.of(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
        }
        return setOverrides(map);
    }

    public TrackSelectionDialogBuilder setOverrides(Map<TrackGroup, TrackSelectionOverride> map) {
        this.overrides = map;
        return this;
    }

    public TrackSelectionDialogBuilder setAllowAdaptiveSelections(boolean z) {
        this.allowAdaptiveSelections = z;
        return this;
    }

    public TrackSelectionDialogBuilder setAllowMultipleOverrides(boolean z) {
        this.allowMultipleOverrides = z;
        return this;
    }

    public TrackSelectionDialogBuilder setShowDisableOption(boolean z) {
        this.showDisableOption = z;
        return this;
    }

    public void setTrackFormatComparator(Comparator<Format> comparator) {
        this.trackFormatComparator = comparator;
    }

    public TrackSelectionDialogBuilder setTrackNameProvider(TrackNameProvider trackNameProvider2) {
        this.trackNameProvider = trackNameProvider2;
        return this;
    }

    public Dialog build() {
        Dialog buildForAndroidX = buildForAndroidX();
        return buildForAndroidX == null ? buildForPlatform() : buildForAndroidX;
    }

    private Dialog buildForPlatform() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context, this.themeResId);
        View inflate = LayoutInflater.from(builder.getContext()).inflate(R.layout.exo_track_selection_dialog, (ViewGroup) null);
        return builder.setTitle(this.title).setView(inflate).setPositiveButton(17039370, setUpDialogView(inflate)).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).create();
    }

    private Dialog buildForAndroidX() {
        try {
            Class<?> cls = Class.forName("androidx.appcompat.app.AlertDialog$Builder");
            Object newInstance = cls.getConstructor(new Class[]{Context.class, Integer.TYPE}).newInstance(new Object[]{this.context, Integer.valueOf(this.themeResId)});
            View inflate = LayoutInflater.from((Context) cls.getMethod("getContext", new Class[0]).invoke(newInstance, new Object[0])).inflate(R.layout.exo_track_selection_dialog, (ViewGroup) null);
            DialogInterface.OnClickListener upDialogView = setUpDialogView(inflate);
            cls.getMethod("setTitle", new Class[]{CharSequence.class}).invoke(newInstance, new Object[]{this.title});
            cls.getMethod("setView", new Class[]{View.class}).invoke(newInstance, new Object[]{inflate});
            cls.getMethod("setPositiveButton", new Class[]{Integer.TYPE, DialogInterface.OnClickListener.class}).invoke(newInstance, new Object[]{17039370, upDialogView});
            cls.getMethod("setNegativeButton", new Class[]{Integer.TYPE, DialogInterface.OnClickListener.class}).invoke(newInstance, new Object[]{17039360, null});
            return (Dialog) cls.getMethod("create", new Class[0]).invoke(newInstance, new Object[0]);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private DialogInterface.OnClickListener setUpDialogView(View view) {
        TrackSelectionView trackSelectionView = (TrackSelectionView) view.findViewById(R.id.exo_track_selection_view);
        trackSelectionView.setAllowMultipleOverrides(this.allowMultipleOverrides);
        trackSelectionView.setAllowAdaptiveSelections(this.allowAdaptiveSelections);
        trackSelectionView.setShowDisableOption(this.showDisableOption);
        TrackNameProvider trackNameProvider2 = this.trackNameProvider;
        if (trackNameProvider2 != null) {
            trackSelectionView.setTrackNameProvider(trackNameProvider2);
        }
        trackSelectionView.init(this.trackGroups, this.isDisabled, this.overrides, this.trackFormatComparator, (TrackSelectionView.TrackSelectionListener) null);
        return new TrackSelectionDialogBuilder$$ExternalSyntheticLambda0(this, trackSelectionView);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setUpDialogView$1$com-google-android-exoplayer2-ui-TrackSelectionDialogBuilder  reason: not valid java name */
    public /* synthetic */ void m544lambda$setUpDialogView$1$comgoogleandroidexoplayer2uiTrackSelectionDialogBuilder(TrackSelectionView trackSelectionView, DialogInterface dialogInterface, int i) {
        this.callback.onTracksSelected(trackSelectionView.getIsDisabled(), trackSelectionView.getOverrides());
    }
}

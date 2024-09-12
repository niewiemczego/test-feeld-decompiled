package com.swmansion.reanimated.layoutReanimation;

import android.view.View;

public class SharedElement {
    public View sourceView;
    public Snapshot sourceViewSnapshot;
    public View targetView;
    public Snapshot targetViewSnapshot;

    public SharedElement(View view, Snapshot snapshot, View view2, Snapshot snapshot2) {
        this.sourceView = view;
        this.sourceViewSnapshot = snapshot;
        this.targetView = view2;
        this.targetViewSnapshot = snapshot2;
    }
}

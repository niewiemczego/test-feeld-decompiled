package com.swmansion.reanimated.layoutReanimation;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ViewGroupManager;
import java.util.ArrayList;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReanimatedNativeHierarchyManager$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ArrayList f$0;
    public final /* synthetic */ View f$1;
    public final /* synthetic */ ViewGroupManager f$2;
    public final /* synthetic */ ViewGroup f$3;

    public /* synthetic */ ReanimatedNativeHierarchyManager$$ExternalSyntheticLambda0(ArrayList arrayList, View view, ViewGroupManager viewGroupManager, ViewGroup viewGroup) {
        this.f$0 = arrayList;
        this.f$1 = view;
        this.f$2 = viewGroupManager;
        this.f$3 = viewGroup;
    }

    public final void run() {
        ReanimatedNativeHierarchyManager.lambda$manageChildren$0(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}

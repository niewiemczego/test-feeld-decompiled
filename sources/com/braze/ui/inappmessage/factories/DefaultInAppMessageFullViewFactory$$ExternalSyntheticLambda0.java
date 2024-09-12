package com.braze.ui.inappmessage.factories;

import android.content.Context;
import android.view.View;
import com.braze.models.inappmessage.InAppMessageFull;
import com.braze.ui.inappmessage.views.InAppMessageFullView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultInAppMessageFullViewFactory$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ InAppMessageFullView f$1;
    public final /* synthetic */ InAppMessageFull f$2;
    public final /* synthetic */ Context f$3;
    public final /* synthetic */ View f$4;

    public /* synthetic */ DefaultInAppMessageFullViewFactory$$ExternalSyntheticLambda0(View view, InAppMessageFullView inAppMessageFullView, InAppMessageFull inAppMessageFull, Context context, View view2) {
        this.f$0 = view;
        this.f$1 = inAppMessageFullView;
        this.f$2 = inAppMessageFull;
        this.f$3 = context;
        this.f$4 = view2;
    }

    public final void run() {
        DefaultInAppMessageFullViewFactory.createInAppMessageView$lambda$4(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}

package com.braze.ui.inappmessage;

import android.view.View;
import com.braze.models.inappmessage.IInAppMessageImmersive;
import com.braze.models.inappmessage.MessageButton;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultInAppMessageViewWrapper$$ExternalSyntheticLambda3 implements View.OnClickListener {
    public final /* synthetic */ DefaultInAppMessageViewWrapper f$0;
    public final /* synthetic */ MessageButton f$1;
    public final /* synthetic */ IInAppMessageImmersive f$2;

    public /* synthetic */ DefaultInAppMessageViewWrapper$$ExternalSyntheticLambda3(DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper, MessageButton messageButton, IInAppMessageImmersive iInAppMessageImmersive) {
        this.f$0 = defaultInAppMessageViewWrapper;
        this.f$1 = messageButton;
        this.f$2 = iInAppMessageImmersive;
    }

    public final void onClick(View view) {
        DefaultInAppMessageViewWrapper.createButtonClickListeners$lambda$5$lambda$4$lambda$3$lambda$2(this.f$0, this.f$1, this.f$2, view);
    }
}

package com.facebook.login.widget;

import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ProfilePictureView$$ExternalSyntheticLambda0 implements ImageRequest.Callback {
    public final /* synthetic */ ProfilePictureView f$0;

    public /* synthetic */ ProfilePictureView$$ExternalSyntheticLambda0(ProfilePictureView profilePictureView) {
        this.f$0 = profilePictureView;
    }

    public final void onCompleted(ImageResponse imageResponse) {
        ProfilePictureView.m404sendImageRequest$lambda2(this.f$0, imageResponse);
    }
}

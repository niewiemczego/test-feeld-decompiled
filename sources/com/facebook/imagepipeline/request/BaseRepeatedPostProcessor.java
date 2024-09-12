package com.facebook.imagepipeline.request;

import javax.annotation.Nullable;

public abstract class BaseRepeatedPostProcessor extends BasePostprocessor implements RepeatedPostprocessor {
    @Nullable
    private RepeatedPostprocessorRunner mCallback;

    public synchronized void setCallback(RepeatedPostprocessorRunner repeatedPostprocessorRunner) {
        this.mCallback = repeatedPostprocessorRunner;
    }

    @Nullable
    private synchronized RepeatedPostprocessorRunner getCallback() {
        return this.mCallback;
    }

    public void update() {
        RepeatedPostprocessorRunner callback = getCallback();
        if (callback != null) {
            callback.update();
        }
    }
}

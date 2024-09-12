package com.swmansion.rnscreens;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import io.sentry.protocol.Request;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/swmansion/rnscreens/FragmentBackPressOverrider;", "", "fragment", "Landroidx/fragment/app/Fragment;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/fragment/app/Fragment;Landroidx/activity/OnBackPressedCallback;)V", "isCallbackAdded", "", "overrideBackAction", "getOverrideBackAction", "()Z", "setOverrideBackAction", "(Z)V", "maybeAddBackCallback", "", "removeBackCallbackIfAdded", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FragmentBackPressOverrider.kt */
public final class FragmentBackPressOverrider {
    private final Fragment fragment;
    private boolean isCallbackAdded;
    private final OnBackPressedCallback onBackPressedCallback;
    private boolean overrideBackAction = true;

    public FragmentBackPressOverrider(Fragment fragment2, OnBackPressedCallback onBackPressedCallback2) {
        Intrinsics.checkNotNullParameter(fragment2, Request.JsonKeys.FRAGMENT);
        Intrinsics.checkNotNullParameter(onBackPressedCallback2, "onBackPressedCallback");
        this.fragment = fragment2;
        this.onBackPressedCallback = onBackPressedCallback2;
    }

    public final boolean getOverrideBackAction() {
        return this.overrideBackAction;
    }

    public final void setOverrideBackAction(boolean z) {
        this.overrideBackAction = z;
    }

    public final void maybeAddBackCallback() {
        OnBackPressedDispatcher onBackPressedDispatcher;
        if (!this.isCallbackAdded && this.overrideBackAction) {
            FragmentActivity activity = this.fragment.getActivity();
            if (!(activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null)) {
                onBackPressedDispatcher.addCallback(this.fragment, this.onBackPressedCallback);
            }
            this.isCallbackAdded = true;
        }
    }

    public final void removeBackCallbackIfAdded() {
        if (this.isCallbackAdded) {
            this.onBackPressedCallback.remove();
            this.isCallbackAdded = false;
        }
    }
}

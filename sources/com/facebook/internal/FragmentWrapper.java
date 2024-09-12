package com.facebook.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import io.sentry.protocol.Request;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\"\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/facebook/internal/FragmentWrapper;", "", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "Landroid/app/Fragment;", "(Landroid/app/Fragment;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "<set-?>", "nativeFragment", "getNativeFragment", "()Landroid/app/Fragment;", "supportFragment", "getSupportFragment", "()Landroidx/fragment/app/Fragment;", "startActivityForResult", "", "intent", "Landroid/content/Intent;", "requestCode", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FragmentWrapper.kt */
public final class FragmentWrapper {
    private Fragment nativeFragment;
    private androidx.fragment.app.Fragment supportFragment;

    public final androidx.fragment.app.Fragment getSupportFragment() {
        return this.supportFragment;
    }

    public final Fragment getNativeFragment() {
        return this.nativeFragment;
    }

    public FragmentWrapper(androidx.fragment.app.Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, Request.JsonKeys.FRAGMENT);
        this.supportFragment = fragment;
    }

    public FragmentWrapper(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, Request.JsonKeys.FRAGMENT);
        this.nativeFragment = fragment;
    }

    public final void startActivityForResult(Intent intent, int i) {
        androidx.fragment.app.Fragment fragment = this.supportFragment;
        if (fragment == null) {
            Fragment fragment2 = this.nativeFragment;
            if (fragment2 != null) {
                fragment2.startActivityForResult(intent, i);
            }
        } else if (fragment != null) {
            fragment.startActivityForResult(intent, i);
        }
    }

    public final Activity getActivity() {
        androidx.fragment.app.Fragment fragment = this.supportFragment;
        FragmentActivity fragmentActivity = null;
        if (fragment != null) {
            if (fragment != null) {
                fragmentActivity = fragment.getActivity();
            }
            return fragmentActivity;
        }
        Fragment fragment2 = this.nativeFragment;
        if (fragment2 == null) {
            return null;
        }
        return fragment2.getActivity();
    }
}

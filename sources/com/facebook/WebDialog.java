package com.facebook;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/WebDialog;", "", "()V", "getWebDialogTheme", "", "setWebDialogTheme", "", "theme", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: WebDialog.kt */
public final class WebDialog {
    public static final WebDialog INSTANCE = new WebDialog();

    private WebDialog() {
    }

    @JvmStatic
    public static final int getWebDialogTheme() {
        return com.facebook.internal.WebDialog.Companion.getWebDialogTheme();
    }

    @JvmStatic
    public static final void setWebDialogTheme(int i) {
        com.facebook.internal.WebDialog.Companion.setWebDialogTheme(i);
    }
}

package com.facebook.login;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/login/CustomTabPrefetchHelper;", "Landroidx/browser/customtabs/CustomTabsServiceConnection;", "()V", "onCustomTabsServiceConnected", "", "name", "Landroid/content/ComponentName;", "newClient", "Landroidx/browser/customtabs/CustomTabsClient;", "onServiceDisconnected", "componentName", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CustomTabPrefetchHelper.kt */
public final class CustomTabPrefetchHelper extends CustomTabsServiceConnection {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static CustomTabsClient client;
    /* access modifiers changed from: private */
    public static final ReentrantLock lock = new ReentrantLock();
    /* access modifiers changed from: private */
    public static CustomTabsSession session;

    @JvmStatic
    public static final CustomTabsSession getPreparedSessionOnce() {
        return Companion.getPreparedSessionOnce();
    }

    @JvmStatic
    public static final void mayLaunchUrl(Uri uri) {
        Companion.mayLaunchUrl(uri);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
    }

    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        Intrinsics.checkNotNullParameter(componentName, "name");
        Intrinsics.checkNotNullParameter(customTabsClient, "newClient");
        customTabsClient.warmup(0);
        Companion companion = Companion;
        client = customTabsClient;
        companion.prepareSession();
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/login/CustomTabPrefetchHelper$Companion;", "", "()V", "client", "Landroidx/browser/customtabs/CustomTabsClient;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "session", "Landroidx/browser/customtabs/CustomTabsSession;", "getPreparedSessionOnce", "mayLaunchUrl", "", "url", "Landroid/net/Uri;", "prepareSession", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CustomTabPrefetchHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final void prepareSession() {
            CustomTabsClient access$getClient$cp;
            CustomTabPrefetchHelper.lock.lock();
            if (CustomTabPrefetchHelper.session == null && (access$getClient$cp = CustomTabPrefetchHelper.client) != null) {
                Companion companion = CustomTabPrefetchHelper.Companion;
                CustomTabPrefetchHelper.session = access$getClient$cp.newSession((CustomTabsCallback) null);
            }
            CustomTabPrefetchHelper.lock.unlock();
        }

        @JvmStatic
        public final void mayLaunchUrl(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "url");
            prepareSession();
            CustomTabPrefetchHelper.lock.lock();
            CustomTabsSession access$getSession$cp = CustomTabPrefetchHelper.session;
            if (access$getSession$cp != null) {
                access$getSession$cp.mayLaunchUrl(uri, (Bundle) null, (List<Bundle>) null);
            }
            CustomTabPrefetchHelper.lock.unlock();
        }

        @JvmStatic
        public final CustomTabsSession getPreparedSessionOnce() {
            CustomTabPrefetchHelper.lock.lock();
            CustomTabsSession access$getSession$cp = CustomTabPrefetchHelper.session;
            CustomTabPrefetchHelper.session = null;
            CustomTabPrefetchHelper.lock.unlock();
            return access$getSession$cp;
        }
    }
}

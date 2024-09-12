package com.facebook;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.Utility;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\f\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u0010H\u0002R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/ProfileManager;", "", "localBroadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "profileCache", "Lcom/facebook/ProfileCache;", "(Landroidx/localbroadcastmanager/content/LocalBroadcastManager;Lcom/facebook/ProfileCache;)V", "value", "Lcom/facebook/Profile;", "currentProfile", "getCurrentProfile", "()Lcom/facebook/Profile;", "setCurrentProfile", "(Lcom/facebook/Profile;)V", "currentProfileField", "loadCurrentProfile", "", "sendCurrentProfileChangedBroadcast", "", "oldProfile", "writeToCache", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ProfileManager.kt */
public final class ProfileManager {
    public static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";
    public static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
    /* access modifiers changed from: private */
    public static volatile ProfileManager instance;
    private Profile currentProfileField;
    private final LocalBroadcastManager localBroadcastManager;
    private final ProfileCache profileCache;

    @JvmStatic
    public static final synchronized ProfileManager getInstance() {
        ProfileManager instance2;
        synchronized (ProfileManager.class) {
            instance2 = Companion.getInstance();
        }
        return instance2;
    }

    public ProfileManager(LocalBroadcastManager localBroadcastManager2, ProfileCache profileCache2) {
        Intrinsics.checkNotNullParameter(localBroadcastManager2, "localBroadcastManager");
        Intrinsics.checkNotNullParameter(profileCache2, "profileCache");
        this.localBroadcastManager = localBroadcastManager2;
        this.profileCache = profileCache2;
    }

    public final Profile getCurrentProfile() {
        return this.currentProfileField;
    }

    public final void setCurrentProfile(Profile profile) {
        setCurrentProfile(profile, true);
    }

    public final boolean loadCurrentProfile() {
        Profile load = this.profileCache.load();
        if (load == null) {
            return false;
        }
        setCurrentProfile(load, false);
        return true;
    }

    private final void setCurrentProfile(Profile profile, boolean z) {
        Profile profile2 = this.currentProfileField;
        this.currentProfileField = profile;
        if (z) {
            if (profile != null) {
                this.profileCache.save(profile);
            } else {
                this.profileCache.clear();
            }
        }
        Utility utility = Utility.INSTANCE;
        if (!Utility.areObjectsEqual(profile2, profile)) {
            sendCurrentProfileChangedBroadcast(profile2, profile);
        }
    }

    private final void sendCurrentProfileChangedBroadcast(Profile profile, Profile profile2) {
        Intent intent = new Intent(ACTION_CURRENT_PROFILE_CHANGED);
        intent.putExtra(EXTRA_OLD_PROFILE, profile);
        intent.putExtra(EXTRA_NEW_PROFILE, profile2);
        this.localBroadcastManager.sendBroadcast(intent);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/ProfileManager$Companion;", "", "()V", "ACTION_CURRENT_PROFILE_CHANGED", "", "EXTRA_NEW_PROFILE", "EXTRA_OLD_PROFILE", "instance", "Lcom/facebook/ProfileManager;", "getInstance", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ProfileManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final synchronized ProfileManager getInstance() {
            ProfileManager access$getInstance$cp;
            if (ProfileManager.instance == null) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                LocalBroadcastManager instance = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
                Intrinsics.checkNotNullExpressionValue(instance, "getInstance(applicationContext)");
                ProfileManager.instance = new ProfileManager(instance, new ProfileCache());
            }
            access$getInstance$cp = ProfileManager.instance;
            if (access$getInstance$cp == null) {
                Intrinsics.throwUninitializedPropertyAccessException("instance");
                throw null;
            }
            return access$getInstance$cp;
        }
    }
}

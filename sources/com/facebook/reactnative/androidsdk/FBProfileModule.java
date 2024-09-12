package com.facebook.reactnative.androidsdk;

import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Timer;
import java.util.TimerTask;

@ReactModule(name = "FBProfile")
public class FBProfileModule extends ReactContextBaseJavaModule {
    public static final String NAME = "FBProfile";
    /* access modifiers changed from: private */
    public ProfileTracker mProfileTracker;

    public String getName() {
        return NAME;
    }

    public FBProfileModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void getCurrentProfile(final Callback callback) {
        if (Profile.getCurrentProfile() == null) {
            final Timer timer = new Timer();
            synchronized (timer) {
                timer.schedule(new TimerTask() {
                    public void run() {
                        timer.cancel();
                        callback.invoke((Object[]) null);
                    }
                }, 30000);
                this.mProfileTracker = new ProfileTracker() {
                    /* access modifiers changed from: protected */
                    public void onCurrentProfileChanged(Profile profile, Profile profile2) {
                        timer.cancel();
                        FBProfileModule.this.mProfileTracker.stopTracking();
                        callback.invoke(Utility.profileToReactMap(profile2));
                    }
                };
            }
            return;
        }
        callback.invoke(Utility.profileToReactMap(Profile.getCurrentProfile()));
    }
}

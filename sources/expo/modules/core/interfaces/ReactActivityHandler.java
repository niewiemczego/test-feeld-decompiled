package expo.modules.core.interfaces;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactRootView;

public interface ReactActivityHandler {
    ReactRootView createReactRootView(Activity activity) {
        return null;
    }

    ViewGroup createReactRootViewContainer(Activity activity) {
        return null;
    }

    ReactActivityDelegate onDidCreateReactActivityDelegate(ReactActivity reactActivity, ReactActivityDelegate reactActivityDelegate) {
        return null;
    }

    boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }
}

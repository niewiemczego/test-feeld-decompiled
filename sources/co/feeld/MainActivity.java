package co.feeld;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactActivityDelegate;
import com.zoontek.rnbootsplash.RNBootSplash;

public class MainActivity extends ReactActivity {
    /* access modifiers changed from: protected */
    public String getMainComponentName() {
        return "feeld";
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        RNBootSplash.init(this, R.style.BootTheme);
        super.onCreate((Bundle) null);
    }

    /* access modifiers changed from: protected */
    public ReactActivityDelegate createReactActivityDelegate() {
        return new DefaultReactActivityDelegate(this, getMainComponentName(), DefaultNewArchitectureEntryPoint.getFabricEnabled(), DefaultNewArchitectureEntryPoint.getConcurrentReactEnabled());
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }
}

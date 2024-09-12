package cl.json.social;

import android.content.ActivityNotFoundException;
import android.os.Build;
import android.provider.Telephony;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

public class SMSShare extends SingleShareIntent {
    private static final String PACKAGE = "com.android.mms";
    private static final String PLAY_STORE_LINK = "market://details?id=com.android.mms";
    private ReactApplicationContext reactContext;

    /* access modifiers changed from: protected */
    public String getDefaultWebLink() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getPlayStoreLink() {
        return PLAY_STORE_LINK;
    }

    public SMSShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        openIntentChooser();
    }

    /* access modifiers changed from: protected */
    public String getPackage() {
        return Build.VERSION.SDK_INT >= 19 ? Telephony.Sms.getDefaultSmsPackage(this.reactContext) : PACKAGE;
    }
}

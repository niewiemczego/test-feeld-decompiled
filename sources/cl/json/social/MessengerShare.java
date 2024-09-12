package cl.json.social;

import android.content.ActivityNotFoundException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

public class MessengerShare extends SingleShareIntent {
    private static final String PACKAGE = "com.facebook.orca";
    private static final String PLAY_STORE_LINK = "market://details?id=com.facebook.orca";

    /* access modifiers changed from: protected */
    public String getDefaultWebLink() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getPackage() {
        return "com.facebook.orca";
    }

    /* access modifiers changed from: protected */
    public String getPlayStoreLink() {
        return PLAY_STORE_LINK;
    }

    public MessengerShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        openIntentChooser();
    }
}

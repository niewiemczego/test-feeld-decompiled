package cl.json.social;

import android.content.ActivityNotFoundException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

public class GooglePlusShare extends SingleShareIntent {
    private static final String DEFAULT_WEB_LINK = "https://plus.google.com/share?url={url}";
    private static final String PACKAGE = "com.google.android.apps.plus";
    private static final String PLAY_STORE_LINK = "market://details?id=com.google.android.apps.plus";

    /* access modifiers changed from: protected */
    public String getDefaultWebLink() {
        return DEFAULT_WEB_LINK;
    }

    /* access modifiers changed from: protected */
    public String getPackage() {
        return PACKAGE;
    }

    /* access modifiers changed from: protected */
    public String getPlayStoreLink() {
        return PLAY_STORE_LINK;
    }

    public GooglePlusShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        openIntentChooser();
    }
}

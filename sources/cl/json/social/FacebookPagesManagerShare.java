package cl.json.social;

import android.content.ActivityNotFoundException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

public class FacebookPagesManagerShare extends SingleShareIntent {
    private static final String DEFAULT_WEB_LINK = "https://www.facebook.com/sharer/sharer.php?u={url}";
    private static final String PACKAGE = "com.facebook.pages.app";

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
        return null;
    }

    public FacebookPagesManagerShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        openIntentChooser();
    }
}

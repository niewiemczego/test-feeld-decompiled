package cl.json.social;

import android.content.ActivityNotFoundException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

public class TwitterShare extends SingleShareIntent {
    private static final String DEFAULT_WEB_LINK = "https://twitter.com/intent/tweet?text={message}&url={url}";
    private static final String PACKAGE = "com.twitter.android";

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

    public TwitterShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        openIntentChooser();
    }
}

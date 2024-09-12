package cl.json.social;

import android.content.ActivityNotFoundException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

public class SnapChatShare extends SingleShareIntent {
    private static final String CLASS = "com.snap.mushroom.MainActivity";
    private static final String PACKAGE = "com.snapchat.android";
    private static final String PLAY_STORE_LINK = "market://details?id=com.snapchat.android";

    /* access modifiers changed from: protected */
    public String getComponentClass() {
        return CLASS;
    }

    /* access modifiers changed from: protected */
    public String getDefaultWebLink() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getPackage() {
        return PACKAGE;
    }

    /* access modifiers changed from: protected */
    public String getPlayStoreLink() {
        return PLAY_STORE_LINK;
    }

    public SnapChatShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        openIntentChooser();
    }
}

package cl.json.social;

import android.content.ActivityNotFoundException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

public class EmailShare extends SingleShareIntent {
    private static final String PACKAGE = "com.google.android.gm";

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
        return null;
    }

    public EmailShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        openIntentChooser();
    }
}

package cl.json.social;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

public class WhatsAppBusinessShare extends SingleShareIntent {
    private static final String PACKAGE = "com.whatsapp.w4b";
    private static final String PLAY_STORE_LINK = "market://details?id=com.whatsapp.w4b";
    private static final int START_ACTIVITY_TIME_GAP_MS = 10;
    private static final String START_CONVERSATION_CLASS = "com.whatsapp.Conversation";

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

    public WhatsAppBusinessShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        if (readableMap.hasKey("whatsAppNumber")) {
            try {
                getIntent().setComponent(new ComponentName(PACKAGE, START_CONVERSATION_CLASS));
                openIntentChooser();
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        getIntent().setComponent((ComponentName) null);
        openIntentChooser();
    }
}

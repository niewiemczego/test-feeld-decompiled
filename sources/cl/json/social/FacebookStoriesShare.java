package cl.json.social;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import cl.json.ShareFile;
import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.share.internal.ShareConstants;
import com.reactnativecommunity.clipboard.ClipboardModule;

public class FacebookStoriesShare extends SingleShareIntent {
    private static final String PACKAGE = "com.facebook.katana";
    private static final String PLAY_STORE_LINK = "market://details?id=com.facebook.katana";

    /* access modifiers changed from: protected */
    public String getDefaultWebLink() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getPackage() {
        return "com.facebook.katana";
    }

    /* access modifiers changed from: protected */
    public String getPlayStoreLink() {
        return PLAY_STORE_LINK;
    }

    public FacebookStoriesShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        setIntent(new Intent("com.facebook.stories.ADD_TO_STORY"));
    }

    public void open(ReadableMap readableMap) throws ActivityNotFoundException, IllegalArgumentException {
        super.open(readableMap);
        shareStory(readableMap);
        openIntentChooser(readableMap);
    }

    private void shareStory(ReadableMap readableMap) {
        String str;
        if (!hasValidKey("appId", readableMap)) {
            throw new IllegalArgumentException("appId was not provided.");
        } else if (hasValidKey("backgroundImage", readableMap) || hasValidKey("backgroundVideo", readableMap) || hasValidKey("stickerImage", readableMap)) {
            Activity currentActivity = this.reactContext.getCurrentActivity();
            boolean z = false;
            if (currentActivity == null) {
                TargetChosenReceiver.sendCallback(false, "Something went wrong");
                return;
            }
            this.intent.putExtra(NativeProtocol.EXTRA_APPLICATION_ID, readableMap.getString("appId"));
            this.intent.putExtra("bottom_background_color", "#906df4");
            this.intent.putExtra("top_background_color", "#837DF4");
            if (hasValidKey("attributionURL", readableMap)) {
                this.intent.putExtra(ShareConstants.STORY_DEEP_LINK_URL, readableMap.getString("attributionURL"));
            }
            if (hasValidKey("backgroundTopColor", readableMap)) {
                this.intent.putExtra("top_background_color", readableMap.getString("backgroundTopColor"));
            }
            if (hasValidKey("backgroundBottomColor", readableMap)) {
                this.intent.putExtra("bottom_background_color", readableMap.getString("backgroundBottomColor"));
            }
            boolean z2 = false;
            if (hasValidKey("useInternalStorage", readableMap)) {
                z2 = Boolean.valueOf(readableMap.getBoolean("useInternalStorage"));
            }
            if (hasValidKey("backgroundImage", readableMap) || hasValidKey("backgroundVideo", readableMap)) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            if (valueOf.booleanValue()) {
                if (hasValidKey("backgroundImage", readableMap)) {
                    str = readableMap.getString("backgroundImage");
                } else {
                    str = hasValidKey("backgroundVideo", readableMap) ? readableMap.getString("backgroundVideo") : "";
                }
                ShareFile shareFile = new ShareFile(str, "image/jpeg", AppStateModule.APP_STATE_BACKGROUND, z2, this.reactContext);
                this.intent.setDataAndType(shareFile.getURI(), shareFile.getType());
                this.intent.setFlags(1);
            }
            if (hasValidKey("stickerImage", readableMap)) {
                ShareFile shareFile2 = new ShareFile(readableMap.getString("stickerImage"), ClipboardModule.MIMETYPE_PNG, "sticker", z2, this.reactContext);
                if (!valueOf.booleanValue()) {
                    this.intent.setType("image/*");
                }
                this.intent.putExtra(ShareConstants.STORY_INTERACTIVE_ASSET_URI, shareFile2.getURI());
                currentActivity.grantUriPermission("com.facebook.katana", shareFile2.getURI(), 1);
            }
        } else {
            throw new IllegalArgumentException("Invalid background or sticker assets provided.");
        }
    }
}

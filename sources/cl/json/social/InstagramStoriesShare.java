package cl.json.social;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import cl.json.ShareFile;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.share.internal.ShareConstants;
import com.reactnativecommunity.clipboard.ClipboardModule;

public class InstagramStoriesShare extends SingleShareIntent {
    private static final String PACKAGE = "com.instagram.android";
    private static final String PLAY_STORE_LINK = "https://play.google.com/store/apps/details?id=com.instagram.android";

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

    public InstagramStoriesShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        setIntent(new Intent("com.instagram.share.ADD_TO_STORY"));
    }

    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        shareStory(readableMap);
        openIntentChooser(readableMap);
    }

    private void shareStory(ReadableMap readableMap) {
        String str;
        String str2;
        String str3;
        if (hasValidKey("backgroundImage", readableMap) || hasValidKey("backgroundVideo", readableMap) || hasValidKey("stickerImage", readableMap)) {
            Activity currentActivity = this.reactContext.getCurrentActivity();
            boolean z = false;
            if (currentActivity == null) {
                TargetChosenReceiver.sendCallback(false, "Something went wrong");
                return;
            }
            this.intent.putExtra("source_application", readableMap.getString("appId"));
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
                    str3 = readableMap.getString("backgroundImage");
                } else if (hasValidKey("backgroundVideo", readableMap)) {
                    str2 = readableMap.getString("backgroundVideo");
                    str = "video/*";
                    ShareFile shareFile = new ShareFile(str2, str, AppStateModule.APP_STATE_BACKGROUND, z2, this.reactContext);
                    this.intent.setDataAndType(shareFile.getURI(), shareFile.getType());
                    this.intent.setFlags(1);
                } else {
                    str3 = "";
                }
                str = "image/jpeg";
                str2 = str3;
                ShareFile shareFile2 = new ShareFile(str2, str, AppStateModule.APP_STATE_BACKGROUND, z2, this.reactContext);
                this.intent.setDataAndType(shareFile2.getURI(), shareFile2.getType());
                this.intent.setFlags(1);
            }
            if (hasValidKey("stickerImage", readableMap)) {
                ShareFile shareFile3 = new ShareFile(readableMap.getString("stickerImage"), ClipboardModule.MIMETYPE_PNG, "sticker", z2, this.reactContext);
                if (!valueOf.booleanValue()) {
                    this.intent.setType("image/*");
                }
                this.intent.putExtra(ShareConstants.STORY_INTERACTIVE_ASSET_URI, shareFile3.getURI());
                currentActivity.grantUriPermission(PACKAGE, shareFile3.getURI(), 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid background or sticker assets provided.");
    }
}

package cl.json.social;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.webkit.internal.AssetHelper;
import cl.json.ShareFile;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

public class InstagramShare extends SingleShareIntent {
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

    public InstagramShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        if (!ShareIntent.hasValidKey("type", readableMap)) {
            Log.e("RNShare", "No type provided");
            return;
        }
        String string = readableMap.getString("type");
        if (string.startsWith("text")) {
            openInstagramIntentChooserForText(this.chooserTitle);
        } else if (!ShareIntent.hasValidKey("url", readableMap)) {
            Log.e("RNShare", "No url provided");
        } else {
            String string2 = readableMap.getString("url");
            if (Boolean.valueOf(string2.startsWith("instagram://")).booleanValue()) {
                openInstagramUrlScheme(string2);
                return;
            }
            String extension = getExtension(string);
            openInstagramIntentChooserForMedia(string2, this.chooserTitle, Boolean.valueOf(string.startsWith("image")), extension);
        }
    }

    /* access modifiers changed from: protected */
    public void openInstagramUrlScheme(String str) {
        Uri parse = Uri.parse(str);
        getIntent().setAction("android.intent.action.VIEW");
        getIntent().setData(parse);
        super.openIntentChooser();
    }

    private String getExtension(String str) {
        String[] split = str.split("/");
        return split[split.length - 1];
    }

    /* access modifiers changed from: protected */
    public void openInstagramIntentChooserForText(String str) {
        getIntent().setPackage(PACKAGE);
        getIntent().setType(AssetHelper.DEFAULT_MIME_TYPE);
        getIntent().setAction("android.intent.action.SEND");
        super.openIntentChooser();
    }

    /* access modifiers changed from: protected */
    public void openInstagramIntentChooserForMedia(String str, String str2, Boolean bool, String str3) {
        ShareFile shareFile;
        Boolean valueOf = Boolean.valueOf(ShareIntent.hasValidKey("useInternalStorage", this.options) && this.options.getBoolean("useInternalStorage"));
        if (bool.booleanValue()) {
            shareFile = new ShareFile(str, "image/" + str3, "image", valueOf, this.reactContext);
        } else {
            shareFile = new ShareFile(str, "video/" + str3, "video", valueOf, this.reactContext);
        }
        Uri uri = shareFile.getURI();
        Intent intent = new Intent("android.intent.action.SEND");
        if (bool.booleanValue()) {
            intent.setType("image/*");
        } else {
            intent.setType("video/*");
        }
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setPackage(PACKAGE);
        Intent intent2 = new Intent("com.instagram.share.ADD_TO_STORY");
        intent2.setDataAndType(uri, str3);
        intent2.addFlags(1);
        intent2.setPackage(PACKAGE);
        Intent createChooser = Intent.createChooser(intent, str2);
        createChooser.addFlags(268435456);
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[]{intent2});
        this.reactContext.getCurrentActivity().grantUriPermission(PACKAGE, uri, 1);
        this.reactContext.startActivity(createChooser);
        TargetChosenReceiver.sendCallback(true, true, getIntent().getPackage());
    }
}

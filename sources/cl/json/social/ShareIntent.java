package cl.json.social;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.webkit.internal.AssetHelper;
import cl.json.RNShareModule;
import cl.json.ShareFile;
import cl.json.ShareFiles;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public abstract class ShareIntent {
    protected ShareFile backgroundAsset;
    protected String chooserTitle = "Share";
    protected ShareFile fileShare;
    protected Intent intent;
    protected ReadableMap options;
    protected final ReactApplicationContext reactContext;
    protected ShareFile stickerAsset;

    /* access modifiers changed from: protected */
    public String getComponentClass() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract String getDefaultWebLink();

    /* access modifiers changed from: protected */
    public abstract String getPackage();

    /* access modifiers changed from: protected */
    public abstract String getPlayStoreLink();

    public ShareIntent(ReactApplicationContext reactApplicationContext) {
        this.reactContext = reactApplicationContext;
        setIntent(new Intent("android.intent.action.SEND"));
        getIntent().setType(AssetHelper.DEFAULT_MIME_TYPE);
    }

    public Intent excludeChooserIntent(Intent intent2, ReadableMap readableMap) {
        ArrayList arrayList = new ArrayList();
        ArrayList<HashMap> arrayList2 = new ArrayList<>();
        Intent intent3 = new Intent(intent2.getAction());
        intent3.setType(intent2.getType());
        List<ResolveInfo> queryIntentActivities = this.reactContext.getPackageManager().queryIntentActivities(intent3, 0);
        if (!queryIntentActivities.isEmpty()) {
            for (ResolveInfo next : queryIntentActivities) {
                if (next.activityInfo != null && !readableMap.getArray("excludedActivityTypes").toString().contains(next.activityInfo.packageName)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("packageName", next.activityInfo.packageName);
                    hashMap.put("className", next.activityInfo.name);
                    hashMap.put("simpleName", String.valueOf(next.activityInfo.loadLabel(this.reactContext.getPackageManager())));
                    arrayList2.add(hashMap);
                }
            }
            if (!arrayList2.isEmpty()) {
                Collections.sort(arrayList2, new Comparator<HashMap<String, String>>() {
                    public int compare(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
                        return hashMap.get("simpleName").compareTo(hashMap2.get("simpleName"));
                    }
                });
                for (HashMap hashMap2 : arrayList2) {
                    Intent intent4 = (Intent) intent2.clone();
                    intent4.setPackage((String) hashMap2.get("packageName"));
                    intent4.setClassName((String) hashMap2.get("packageName"), (String) hashMap2.get("className"));
                    arrayList.add(intent4);
                }
                Intent createChooser = Intent.createChooser((Intent) arrayList.remove(arrayList.size() - 1), "share");
                createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
                return createChooser;
            }
        }
        return Intent.createChooser(intent2, "Share");
    }

    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        this.options = readableMap;
        if (hasValidKey("isNewTask", readableMap) && readableMap.getBoolean("isNewTask")) {
            getIntent().addFlags(268468224);
        }
        if (hasValidKey("subject", readableMap)) {
            getIntent().putExtra("android.intent.extra.SUBJECT", readableMap.getString("subject"));
        }
        if (hasValidKey("email", readableMap)) {
            getIntent().putExtra("android.intent.extra.EMAIL", new String[]{readableMap.getString("email")});
        }
        if (hasValidKey("title", readableMap)) {
            this.chooserTitle = readableMap.getString("title");
        }
        String str = "";
        String string = hasValidKey("message", readableMap) ? readableMap.getString("message") : str;
        if (hasValidKey(NotificationCompat.CATEGORY_SOCIAL, readableMap)) {
            str = readableMap.getString(NotificationCompat.CATEGORY_SOCIAL);
        }
        if (str.equals("sms")) {
            String string2 = readableMap.getString("recipient");
            if (!string2.isEmpty()) {
                getIntent().putExtra("address", string2);
            }
        }
        if (str.equals("whatsapp") && readableMap.hasKey("whatsAppNumber")) {
            getIntent().putExtra("jid", readableMap.getString("whatsAppNumber") + "@s.whatsapp.net");
        }
        if (str.equals("whatsappbusiness") && readableMap.hasKey("whatsAppNumber")) {
            getIntent().putExtra("jid", readableMap.getString("whatsAppNumber") + "@s.whatsapp.net");
        }
        if (hasValidKey("urls", readableMap)) {
            ShareFiles fileShares = getFileShares(readableMap);
            if (fileShares.isFile()) {
                ArrayList<Uri> uri = fileShares.getURI();
                getIntent().setAction("android.intent.action.SEND_MULTIPLE");
                getIntent().setType(fileShares.getType());
                getIntent().putParcelableArrayListExtra("android.intent.extra.STREAM", uri);
                getIntent().addFlags(1);
                if (!TextUtils.isEmpty(string)) {
                    getIntent().putExtra("android.intent.extra.TEXT", string);
                }
            } else if (!TextUtils.isEmpty(string)) {
                getIntent().putExtra("android.intent.extra.TEXT", string + " " + readableMap.getArray("urls").getString(0));
            } else {
                getIntent().putExtra("android.intent.extra.TEXT", readableMap.getArray("urls").getString(0));
            }
        } else if (hasValidKey("url", readableMap)) {
            ShareFile fileShare2 = getFileShare(readableMap);
            this.fileShare = fileShare2;
            if (fileShare2.isFile()) {
                Uri uri2 = this.fileShare.getURI();
                getIntent().setType(this.fileShare.getType());
                getIntent().putExtra("android.intent.extra.STREAM", uri2);
                getIntent().addFlags(1);
                if (!TextUtils.isEmpty(string)) {
                    getIntent().putExtra("android.intent.extra.TEXT", string);
                }
            } else if (!TextUtils.isEmpty(string)) {
                getIntent().putExtra("android.intent.extra.TEXT", string + " " + readableMap.getString("url"));
            } else {
                getIntent().putExtra("android.intent.extra.TEXT", readableMap.getString("url"));
            }
        } else if (!TextUtils.isEmpty(string)) {
            getIntent().putExtra("android.intent.extra.TEXT", string);
        }
    }

    /* access modifiers changed from: protected */
    public ShareFile getFileShare(ReadableMap readableMap) {
        String string = hasValidKey("filename", readableMap) ? readableMap.getString("filename") : null;
        boolean z = false;
        if (hasValidKey("useInternalStorage", readableMap)) {
            z = Boolean.valueOf(readableMap.getBoolean("useInternalStorage"));
        }
        Boolean bool = z;
        if (hasValidKey("type", readableMap)) {
            return new ShareFile(readableMap.getString("url"), readableMap.getString("type"), string, bool, this.reactContext);
        }
        return new ShareFile(readableMap.getString("url"), string, bool, this.reactContext);
    }

    /* access modifiers changed from: protected */
    public ShareFiles getFileShares(ReadableMap readableMap) {
        ArrayList arrayList = new ArrayList();
        if (hasValidKey("filenames", readableMap)) {
            ReadableArray array = readableMap.getArray("filenames");
            for (int i = 0; i < array.size(); i++) {
                arrayList.add(array.getString(i));
            }
        }
        boolean z = false;
        if (hasValidKey("useInternalStorage", readableMap)) {
            z = Boolean.valueOf(readableMap.getBoolean("useInternalStorage"));
        }
        Boolean bool = z;
        if (hasValidKey("type", readableMap)) {
            return new ShareFiles(readableMap.getArray("urls"), arrayList, readableMap.getString("type"), bool, this.reactContext);
        }
        return new ShareFiles(readableMap.getArray("urls"), arrayList, bool, this.reactContext);
    }

    protected static String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("URLEncoder.encode() failed for " + str);
        }
    }

    /* access modifiers changed from: protected */
    public Intent[] getIntentsToViewFile(Intent intent2, Uri uri) {
        List<ResolveInfo> queryIntentActivities = this.reactContext.getPackageManager().queryIntentActivities(intent2, 0);
        Intent[] intentArr = new Intent[queryIntentActivities.size()];
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            ResolveInfo resolveInfo = queryIntentActivities.get(i);
            String str = resolveInfo.activityInfo.packageName;
            Intent intent3 = new Intent();
            intent3.setComponent(new ComponentName(str, resolveInfo.activityInfo.name));
            intent3.setAction("android.intent.action.VIEW");
            intent3.setDataAndType(uri, intent2.getType());
            intent3.addFlags(1);
            intentArr[i] = new Intent(intent3);
        }
        return intentArr;
    }

    /* access modifiers changed from: protected */
    public void openIntentChooser() throws ActivityNotFoundException {
        Intent intent2;
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            TargetChosenReceiver.sendCallback(false, "Something went wrong");
            return;
        }
        IntentSender intentSender = null;
        if (TargetChosenReceiver.isSupported()) {
            intentSender = TargetChosenReceiver.getSharingSenderIntent(this.reactContext);
            intent2 = Intent.createChooser(getIntent(), this.chooserTitle, intentSender);
        } else {
            intent2 = Intent.createChooser(getIntent(), this.chooserTitle);
        }
        intent2.addFlags(1073741824);
        if (hasValidKey("showAppsToView", this.options) && hasValidKey("url", this.options)) {
            Intent intent3 = new Intent("android.intent.action.VIEW");
            intent3.setType(this.fileShare.getType());
            intent2.putExtra("android.intent.extra.INITIAL_INTENTS", getIntentsToViewFile(intent3, this.fileShare.getURI()));
        }
        if (!hasValidKey("excludedActivityTypes", this.options)) {
            currentActivity.startActivityForResult(intent2, RNShareModule.SHARE_REQUEST_CODE);
        } else if (Build.VERSION.SDK_INT >= 24) {
            intent2.putExtra("android.intent.extra.EXCLUDE_COMPONENTS", getExcludedComponentArray(this.options.getArray("excludedActivityTypes")));
            currentActivity.startActivityForResult(intent2, RNShareModule.SHARE_REQUEST_CODE);
        } else {
            currentActivity.startActivityForResult(excludeChooserIntent(getIntent(), this.options), RNShareModule.SHARE_REQUEST_CODE);
        }
        if (intentSender == null) {
            TargetChosenReceiver.sendCallback(true, true, "OK");
        }
    }

    public static boolean isPackageInstalled(String str, Context context) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public Intent getIntent() {
        return this.intent;
    }

    /* access modifiers changed from: protected */
    public void setIntent(Intent intent2) {
        this.intent = intent2;
    }

    public static boolean hasValidKey(String str, ReadableMap readableMap) {
        return readableMap != null && readableMap.hasKey(str) && !readableMap.isNull(str);
    }

    private ComponentName[] getExcludedComponentArray(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        Intent intent2 = new Intent(getIntent().getAction());
        intent2.setType(getIntent().getType());
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> queryIntentActivities = this.reactContext.getPackageManager().queryIntentActivities(intent2, 0);
        for (int i = 0; i < readableArray.size(); i++) {
            String string = readableArray.getString(i);
            for (ResolveInfo next : queryIntentActivities) {
                if (next.activityInfo.packageName.equals(string)) {
                    arrayList.add(new ComponentName(next.activityInfo.packageName, next.activityInfo.name));
                }
            }
        }
        return (ComponentName[]) arrayList.toArray(new ComponentName[0]);
    }
}

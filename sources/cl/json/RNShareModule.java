package cl.json;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import cl.json.social.EmailShare;
import cl.json.social.FacebookPagesManagerShare;
import cl.json.social.FacebookShare;
import cl.json.social.FacebookStoriesShare;
import cl.json.social.GenericShare;
import cl.json.social.GooglePlusShare;
import cl.json.social.InstagramShare;
import cl.json.social.InstagramStoriesShare;
import cl.json.social.LinkedinShare;
import cl.json.social.MessengerShare;
import cl.json.social.PinterestShare;
import cl.json.social.SMSShare;
import cl.json.social.ShareIntent;
import cl.json.social.SnapChatShare;
import cl.json.social.TargetChosenReceiver;
import cl.json.social.TelegramShare;
import cl.json.social.TwitterShare;
import cl.json.social.ViberShare;
import cl.json.social.WhatsAppBusinessShare;
import cl.json.social.WhatsAppShare;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

public class RNShareModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    public static final int SHARE_REQUEST_CODE = 16845;
    private final ReactApplicationContext reactContext;

    public String getName() {
        return "RNShare";
    }

    public void onNewIntent(Intent intent) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 16845) {
            return;
        }
        if (i2 == 0) {
            TargetChosenReceiver.sendCallback(true, false, "CANCELED");
        } else if (i2 == -1) {
            TargetChosenReceiver.sendCallback(true, true);
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        onActivityResult(i, i2, intent);
    }

    private enum SHARES {
        facebook,
        facebookstories,
        generic,
        pagesmanager,
        twitter,
        whatsapp,
        whatsappbusiness,
        instagram,
        instagramstories,
        googleplus,
        email,
        pinterest,
        messenger,
        snapchat,
        sms,
        linkedin,
        telegram,
        viber;

        public static ShareIntent getShareClass(String str, ReactApplicationContext reactApplicationContext) {
            switch (AnonymousClass1.$SwitchMap$cl$json$RNShareModule$SHARES[valueOf(str).ordinal()]) {
                case 1:
                    return new GenericShare(reactApplicationContext);
                case 2:
                    return new FacebookShare(reactApplicationContext);
                case 3:
                    return new FacebookStoriesShare(reactApplicationContext);
                case 4:
                    return new FacebookPagesManagerShare(reactApplicationContext);
                case 5:
                    return new TwitterShare(reactApplicationContext);
                case 6:
                    return new WhatsAppShare(reactApplicationContext);
                case 7:
                    return new WhatsAppBusinessShare(reactApplicationContext);
                case 8:
                    return new InstagramShare(reactApplicationContext);
                case 9:
                    return new InstagramStoriesShare(reactApplicationContext);
                case 10:
                    return new GooglePlusShare(reactApplicationContext);
                case 11:
                    return new EmailShare(reactApplicationContext);
                case 12:
                    return new PinterestShare(reactApplicationContext);
                case 13:
                    return new SMSShare(reactApplicationContext);
                case 14:
                    return new SnapChatShare(reactApplicationContext);
                case 15:
                    return new MessengerShare(reactApplicationContext);
                case 16:
                    return new LinkedinShare(reactApplicationContext);
                case 17:
                    return new TelegramShare(reactApplicationContext);
                case 18:
                    return new ViberShare(reactApplicationContext);
                default:
                    return null;
            }
        }
    }

    /* renamed from: cl.json.RNShareModule$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cl$json$RNShareModule$SHARES;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                cl.json.RNShareModule$SHARES[] r0 = cl.json.RNShareModule.SHARES.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$cl$json$RNShareModule$SHARES = r0
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.generic     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$cl$json$RNShareModule$SHARES     // Catch:{ NoSuchFieldError -> 0x001d }
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.facebook     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$cl$json$RNShareModule$SHARES     // Catch:{ NoSuchFieldError -> 0x0028 }
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.facebookstories     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$cl$json$RNShareModule$SHARES     // Catch:{ NoSuchFieldError -> 0x0033 }
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.pagesmanager     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$cl$json$RNShareModule$SHARES     // Catch:{ NoSuchFieldError -> 0x003e }
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.twitter     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$cl$json$RNShareModule$SHARES     // Catch:{ NoSuchFieldError -> 0x0049 }
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.whatsapp     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$cl$json$RNShareModule$SHARES     // Catch:{ NoSuchFieldError -> 0x0054 }
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.whatsappbusiness     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$cl$json$RNShareModule$SHARES     // Catch:{ NoSuchFieldError -> 0x0060 }
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.instagram     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$cl$json$RNShareModule$SHARES     // Catch:{ NoSuchFieldError -> 0x006c }
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.instagramstories     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$cl$json$RNShareModule$SHARES     // Catch:{ NoSuchFieldError -> 0x0078 }
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.googleplus     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$cl$json$RNShareModule$SHARES     // Catch:{ NoSuchFieldError -> 0x0084 }
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.email     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$cl$json$RNShareModule$SHARES     // Catch:{ NoSuchFieldError -> 0x0090 }
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.pinterest     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$cl$json$RNShareModule$SHARES     // Catch:{ NoSuchFieldError -> 0x009c }
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.sms     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$cl$json$RNShareModule$SHARES     // Catch:{ NoSuchFieldError -> 0x00a8 }
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.snapchat     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$cl$json$RNShareModule$SHARES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.messenger     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$cl$json$RNShareModule$SHARES     // Catch:{ NoSuchFieldError -> 0x00c0 }
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.linkedin     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$cl$json$RNShareModule$SHARES     // Catch:{ NoSuchFieldError -> 0x00cc }
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.telegram     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$cl$json$RNShareModule$SHARES     // Catch:{ NoSuchFieldError -> 0x00d8 }
                cl.json.RNShareModule$SHARES r1 = cl.json.RNShareModule.SHARES.viber     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cl.json.RNShareModule.AnonymousClass1.<clinit>():void");
        }
    }

    public RNShareModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
        this.reactContext = reactApplicationContext;
    }

    @Nullable
    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        for (SHARES shares : SHARES.values()) {
            hashMap.put(shares.toString().toUpperCase(Locale.ROOT), shares.toString());
        }
        return hashMap;
    }

    @ReactMethod
    public void open(ReadableMap readableMap, Callback callback, Callback callback2) {
        TargetChosenReceiver.registerCallbacks(callback2, callback);
        try {
            new GenericShare(this.reactContext).open(readableMap);
        } catch (ActivityNotFoundException e) {
            System.out.println("ERROR " + e.getMessage());
            e.printStackTrace(System.out);
            TargetChosenReceiver.sendCallback(false, "not_available");
        } catch (Exception e2) {
            System.out.println("ERROR " + e2.getMessage());
            e2.printStackTrace(System.out);
            TargetChosenReceiver.sendCallback(false, e2.getMessage());
        }
    }

    @ReactMethod
    public void shareSingle(ReadableMap readableMap, Callback callback, Callback callback2) {
        System.out.println("SHARE SINGLE METHOD");
        TargetChosenReceiver.registerCallbacks(callback2, callback);
        if (ShareIntent.hasValidKey(NotificationCompat.CATEGORY_SOCIAL, readableMap)) {
            try {
                ShareIntent shareClass = SHARES.getShareClass(readableMap.getString(NotificationCompat.CATEGORY_SOCIAL), this.reactContext);
                if (shareClass == null || !(shareClass instanceof ShareIntent)) {
                    throw new ActivityNotFoundException("Invalid share activity");
                }
                shareClass.open(readableMap);
            } catch (ActivityNotFoundException e) {
                System.out.println("ERROR " + e.getMessage());
                e.printStackTrace(System.out);
                TargetChosenReceiver.sendCallback(false, e.getMessage());
            } catch (Exception e2) {
                System.out.println("ERROR " + e2.getMessage());
                e2.printStackTrace(System.out);
                TargetChosenReceiver.sendCallback(false, e2.getMessage());
            }
        } else {
            TargetChosenReceiver.sendCallback(false, "key 'social' missing in options");
        }
    }

    @ReactMethod
    public void isPackageInstalled(String str, Callback callback, Callback callback2) {
        try {
            callback2.invoke(Boolean.valueOf(ShareIntent.isPackageInstalled(str, this.reactContext)));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            callback.invoke(e.getMessage());
        }
    }

    @ReactMethod
    public void isBase64File(String str, Callback callback, Callback callback2) {
        try {
            String scheme = Uri.parse(str).getScheme();
            if (scheme == null || !scheme.equals("data")) {
                callback2.invoke(false);
                return;
            }
            callback2.invoke(true);
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
            e.printStackTrace(System.out);
            callback.invoke(e.getMessage());
        }
    }
}

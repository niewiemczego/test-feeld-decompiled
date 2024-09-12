package com.facebook.messenger;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.bolts.AppLinks;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.FacebookSignatureValidator;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.messenger.MessengerThreadParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u000e\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010&\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J \u0010(\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010)\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/facebook/messenger/MessengerUtils;", "", "()V", "EXTRA_APP_ID", "", "EXTRA_EXTERNAL_URI", "EXTRA_IS_COMPOSE", "EXTRA_IS_REPLY", "EXTRA_METADATA", "EXTRA_PARTICIPANTS", "EXTRA_PROTOCOL_VERSION", "EXTRA_REPLY_TOKEN_KEY", "EXTRA_THREAD_TOKEN_KEY", "ORCA_THREAD_CATEGORY_20150314", "PACKAGE_NAME", "PROTOCOL_VERSION_20150314", "", "TAG", "finishShareToMessenger", "", "activity", "Landroid/app/Activity;", "shareToMessengerParams", "Lcom/facebook/messenger/ShareToMessengerParams;", "getAllAvailableProtocolVersions", "", "context", "Landroid/content/Context;", "getMessengerThreadParamsForIntent", "Lcom/facebook/messenger/MessengerThreadParams;", "intent", "Landroid/content/Intent;", "hasMessengerInstalled", "", "openMessengerInPlayStore", "parseParticipants", "", "s", "shareToMessenger", "requestCode", "shareToMessenger20150314", "startViewUri", "uri", "facebook-messenger_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: MessengerUtils.kt */
public final class MessengerUtils {
    public static final String EXTRA_APP_ID = "com.facebook.orca.extra.APPLICATION_ID";
    public static final String EXTRA_EXTERNAL_URI = "com.facebook.orca.extra.EXTERNAL_URI";
    public static final String EXTRA_IS_COMPOSE = "com.facebook.orca.extra.IS_COMPOSE";
    public static final String EXTRA_IS_REPLY = "com.facebook.orca.extra.IS_REPLY";
    public static final String EXTRA_METADATA = "com.facebook.orca.extra.METADATA";
    public static final String EXTRA_PARTICIPANTS = "com.facebook.orca.extra.PARTICIPANTS";
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.orca.extra.PROTOCOL_VERSION";
    public static final String EXTRA_REPLY_TOKEN_KEY = "com.facebook.orca.extra.REPLY_TOKEN";
    public static final String EXTRA_THREAD_TOKEN_KEY = "com.facebook.orca.extra.THREAD_TOKEN";
    public static final MessengerUtils INSTANCE = new MessengerUtils();
    public static final String ORCA_THREAD_CATEGORY_20150314 = "com.facebook.orca.category.PLATFORM_THREAD_20150314";
    public static final String PACKAGE_NAME = "com.facebook.orca";
    public static final int PROTOCOL_VERSION_20150314 = 20150314;
    private static final String TAG = "MessengerUtils";

    private MessengerUtils() {
    }

    public final void shareToMessenger(Activity activity, int i, ShareToMessengerParams shareToMessengerParams) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(shareToMessengerParams, "shareToMessengerParams");
                if (!hasMessengerInstalled(activity)) {
                    openMessengerInPlayStore(activity);
                } else if (getAllAvailableProtocolVersions(activity).contains(Integer.valueOf(PROTOCOL_VERSION_20150314))) {
                    shareToMessenger20150314(activity, i, shareToMessengerParams);
                } else {
                    openMessengerInPlayStore(activity);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void shareToMessenger20150314(Activity activity, int i, ShareToMessengerParams shareToMessengerParams) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setFlags(1);
            intent.setPackage(PACKAGE_NAME);
            intent.putExtra("android.intent.extra.STREAM", shareToMessengerParams.getUri());
            intent.setType(shareToMessengerParams.getMimeType());
            intent.putExtra(EXTRA_PROTOCOL_VERSION, PROTOCOL_VERSION_20150314);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            intent.putExtra(EXTRA_APP_ID, FacebookSdk.getApplicationId());
            intent.putExtra(EXTRA_METADATA, shareToMessengerParams.getMetaData());
            intent.putExtra(EXTRA_EXTERNAL_URI, shareToMessengerParams.getExternalUri());
            activity.startActivityForResult(intent, i);
        } catch (ActivityNotFoundException unused) {
            activity.startActivity(activity.getPackageManager().getLaunchIntentForPackage(PACKAGE_NAME));
        }
    }

    public final MessengerThreadParams getMessengerThreadParamsForIntent(Intent intent) {
        String str;
        String str2;
        String str3;
        Boolean bool;
        Boolean bool2;
        MessengerThreadParams.Origin origin;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
            Set<String> categories = intent.getCategories();
            if (categories != null && categories.contains(ORCA_THREAD_CATEGORY_20150314)) {
                AppLinks appLinks = AppLinks.INSTANCE;
                Bundle appLinkExtras = AppLinks.getAppLinkExtras(intent);
                if (appLinkExtras == null) {
                    str = null;
                } else {
                    str = appLinkExtras.getString(EXTRA_THREAD_TOKEN_KEY);
                }
                if (appLinkExtras == null) {
                    str2 = null;
                } else {
                    str2 = appLinkExtras.getString(EXTRA_METADATA);
                }
                if (appLinkExtras == null) {
                    str3 = null;
                } else {
                    str3 = appLinkExtras.getString(EXTRA_PARTICIPANTS);
                }
                if (appLinkExtras == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(appLinkExtras.getBoolean(EXTRA_IS_REPLY));
                }
                if (appLinkExtras == null) {
                    bool2 = null;
                } else {
                    bool2 = Boolean.valueOf(appLinkExtras.getBoolean(EXTRA_IS_COMPOSE));
                }
                if (Intrinsics.areEqual((Object) bool, (Object) true)) {
                    origin = MessengerThreadParams.Origin.REPLY_FLOW;
                } else if (Intrinsics.areEqual((Object) bool2, (Object) true)) {
                    origin = MessengerThreadParams.Origin.COMPOSE_FLOW;
                } else {
                    origin = MessengerThreadParams.Origin.UNKNOWN;
                }
                if (!(str == null || str2 == null)) {
                    return new MessengerThreadParams(origin, str, str2, parseParticipants(str3));
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final void finishShareToMessenger(Activity activity, ShareToMessengerParams shareToMessengerParams) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareToMessengerParams, "shareToMessengerParams");
        Intent intent = activity.getIntent();
        Set<String> categories = intent.getCategories();
        if (categories == null) {
            activity.setResult(0, (Intent) null);
            activity.finish();
        } else if (categories.contains(ORCA_THREAD_CATEGORY_20150314)) {
            AppLinks appLinks = AppLinks.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(intent, "originalIntent");
            Bundle appLinkExtras = AppLinks.getAppLinkExtras(intent);
            Intent intent2 = new Intent();
            if (appLinkExtras == null || !categories.contains(ORCA_THREAD_CATEGORY_20150314)) {
                throw new RuntimeException();
            }
            intent2.putExtra(EXTRA_PROTOCOL_VERSION, PROTOCOL_VERSION_20150314);
            intent2.putExtra(EXTRA_THREAD_TOKEN_KEY, appLinkExtras.getString(EXTRA_THREAD_TOKEN_KEY));
            intent2.setDataAndType(shareToMessengerParams.getUri(), shareToMessengerParams.getMimeType());
            intent2.setFlags(1);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            intent2.putExtra(EXTRA_APP_ID, FacebookSdk.getApplicationId());
            intent2.putExtra(EXTRA_METADATA, shareToMessengerParams.getMetaData());
            intent2.putExtra(EXTRA_EXTERNAL_URI, shareToMessengerParams.getExternalUri());
            activity.setResult(-1, intent2);
            activity.finish();
        } else {
            activity.setResult(0, (Intent) null);
            activity.finish();
        }
    }

    public final boolean hasMessengerInstalled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FacebookSignatureValidator facebookSignatureValidator = FacebookSignatureValidator.INSTANCE;
        return FacebookSignatureValidator.validateSignature(context, PACKAGE_NAME);
    }

    public final void openMessengerInPlayStore(Context context) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(context, "context");
                startViewUri(context, "market://details?id=com.facebook.orca");
            } catch (ActivityNotFoundException unused) {
                startViewUri(context, "http://play.google.com/store/apps/details?id=com.facebook.orca");
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.Set<java.lang.Integer> getAllAvailableProtocolVersions(android.content.Context r8) {
        /*
            r7 = this;
            android.content.ContentResolver r0 = r8.getContentResolver()
            java.util.HashSet r8 = new java.util.HashSet
            r8.<init>()
            java.util.Set r8 = (java.util.Set) r8
            java.lang.String r1 = "content://com.facebook.orca.provider.MessengerPlatformProvider/versions"
            android.net.Uri r1 = android.net.Uri.parse(r1)
            java.lang.String r6 = "version"
            java.lang.String[] r2 = new java.lang.String[]{r6}
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)
            if (r0 != 0) goto L_0x0021
            goto L_0x0045
        L_0x0021:
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            r2 = r1
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r2 = r0
            android.database.Cursor r2 = (android.database.Cursor) r2     // Catch:{ all -> 0x0046 }
            int r3 = r2.getColumnIndex(r6)     // Catch:{ all -> 0x0046 }
        L_0x002e:
            boolean r4 = r2.moveToNext()     // Catch:{ all -> 0x0046 }
            if (r4 == 0) goto L_0x0040
            int r4 = r2.getInt(r3)     // Catch:{ all -> 0x0046 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0046 }
            r8.add(r4)     // Catch:{ all -> 0x0046 }
            goto L_0x002e
        L_0x0040:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0046 }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
        L_0x0045:
            return r8
        L_0x0046:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0048 }
        L_0x0048:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r8)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messenger.MessengerUtils.getAllAvailableProtocolVersions(android.content.Context):java.util.Set");
    }

    private final void startViewUri(Context context, String str) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    private final List<String> parseParticipants(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return CollectionsKt.emptyList();
        }
        Object[] array = StringsKt.split$default(charSequence, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            Collection arrayList = new ArrayList(strArr.length);
            for (CharSequence charSequence2 : strArr) {
                int length = charSequence2.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) charSequence2.charAt(!z ? i : length), 32) <= 0;
                    if (!z) {
                        if (!z2) {
                            z = true;
                        } else {
                            i++;
                        }
                    } else if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                }
                arrayList.add(charSequence2.subSequence(i, length + 1).toString());
            }
            return (List) arrayList;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}

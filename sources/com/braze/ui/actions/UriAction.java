package com.braze.ui.actions;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.Channel;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.BrazeWebViewActivity;
import com.braze.ui.actions.brazeactions.BrazeActionParser;
import com.braze.ui.support.UriUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u000f\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0000¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\"\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0005J5\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0 2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0007¢\u0006\u0002\u0010$J\"\u0010%\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0004J\"\u0010&\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\"\u0010'\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0004J\"\u0010(\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0004J\"\u0010)\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0004R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Lcom/braze/ui/actions/UriAction;", "Lcom/braze/ui/actions/IAction;", "uri", "Landroid/net/Uri;", "extras", "Landroid/os/Bundle;", "useWebView", "", "channel", "Lcom/braze/enums/Channel;", "(Landroid/net/Uri;Landroid/os/Bundle;ZLcom/braze/enums/Channel;)V", "original", "(Lcom/braze/ui/actions/UriAction;)V", "getChannel", "()Lcom/braze/enums/Channel;", "getExtras", "()Landroid/os/Bundle;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "getUseWebView", "()Z", "setUseWebView", "(Z)V", "execute", "", "context", "Landroid/content/Context;", "getActionViewIntent", "Landroid/content/Intent;", "getIntentArrayWithConfiguredBackStack", "", "targetIntent", "configurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/Intent;Lcom/braze/configuration/BrazeConfigurationProvider;)[Landroid/content/Intent;", "getWebViewActivityIntent", "openUriWithActionView", "openUriWithActionViewFromPush", "openUriWithWebViewActivity", "openUriWithWebViewActivityFromPush", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UriAction.kt */
public class UriAction implements IAction {
    private final Channel channel;
    private final Bundle extras;
    private Uri uri;
    private boolean useWebView;

    public final Bundle getExtras() {
        return this.extras;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void setUri(Uri uri2) {
        Intrinsics.checkNotNullParameter(uri2, "<set-?>");
        this.uri = uri2;
    }

    public final boolean getUseWebView() {
        return this.useWebView;
    }

    public final void setUseWebView(boolean z) {
        this.useWebView = z;
    }

    public UriAction(Uri uri2, Bundle bundle, boolean z, Channel channel2) {
        Intrinsics.checkNotNullParameter(uri2, "uri");
        Intrinsics.checkNotNullParameter(channel2, "channel");
        this.uri = uri2;
        this.extras = bundle;
        this.useWebView = z;
        this.channel = channel2;
    }

    public UriAction(UriAction uriAction) {
        Intrinsics.checkNotNullParameter(uriAction, "original");
        this.uri = uriAction.uri;
        this.extras = uriAction.extras;
        this.useWebView = uriAction.useWebView;
        this.channel = uriAction.getChannel();
    }

    public void execute(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (BrazeFileUtils.isLocalUri(this.uri)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new UriAction$execute$1(this), 3, (Object) null);
        } else if (BrazeActionParser.INSTANCE.isBrazeActionUri(this.uri)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new UriAction$execute$2(this), 2, (Object) null);
            BrazeActionParser.INSTANCE.execute(context, this.uri, getChannel());
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new UriAction$execute$3(this), 3, (Object) null);
            if (!this.useWebView || !CollectionsKt.contains(BrazeFileUtils.REMOTE_SCHEMES, this.uri.getScheme())) {
                if (getChannel() == Channel.PUSH) {
                    openUriWithActionViewFromPush(context, this.uri, this.extras);
                } else {
                    openUriWithActionView(context, this.uri, this.extras);
                }
            } else if (getChannel() == Channel.PUSH) {
                openUriWithWebViewActivityFromPush(context, this.uri, this.extras);
            } else {
                openUriWithWebViewActivity(context, this.uri, this.extras);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void openUriWithWebViewActivity(Context context, Uri uri2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri2, "uri");
        Intent webViewActivityIntent = getWebViewActivityIntent(context, uri2, bundle);
        webViewActivityIntent.setFlags(BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_OPEN_WITH_WEBVIEW_ACTIVITY));
        try {
            context.startActivity(webViewActivityIntent);
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) UriAction$openUriWithWebViewActivity$1.INSTANCE);
        }
    }

    /* access modifiers changed from: protected */
    public void openUriWithActionView(Context context, Uri uri2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri2, "uri");
        Intent actionViewIntent = getActionViewIntent(context, uri2, bundle);
        actionViewIntent.setFlags(BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_OPEN_WITH_ACTION_VIEW));
        try {
            context.startActivity(actionViewIntent);
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) new UriAction$openUriWithActionView$1(uri2, bundle));
        }
    }

    /* access modifiers changed from: protected */
    public final void openUriWithWebViewActivityFromPush(Context context, Uri uri2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri2, "uri");
        try {
            context.startActivities(getIntentArrayWithConfiguredBackStack(context, bundle, getWebViewActivityIntent(context, uri2, bundle), new BrazeConfigurationProvider(context)));
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) UriAction$openUriWithWebViewActivityFromPush$1.INSTANCE);
        }
    }

    /* access modifiers changed from: protected */
    public final void openUriWithActionViewFromPush(Context context, Uri uri2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri2, "uri");
        try {
            context.startActivities(getIntentArrayWithConfiguredBackStack(context, bundle, getActionViewIntent(context, uri2, bundle), new BrazeConfigurationProvider(context)));
        } catch (ActivityNotFoundException e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e, (Function0<String>) new UriAction$openUriWithActionViewFromPush$1(uri2));
        }
    }

    /* access modifiers changed from: protected */
    public final Intent getWebViewActivityIntent(Context context, Uri uri2, Bundle bundle) {
        Intent intent;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri2, "uri");
        String customHtmlWebViewActivityClassName = new BrazeConfigurationProvider(context).getCustomHtmlWebViewActivityClassName();
        CharSequence charSequence = customHtmlWebViewActivityClassName;
        if ((charSequence == null || StringsKt.isBlank(charSequence)) || !UriUtils.isActivityRegisteredInManifest(context, customHtmlWebViewActivityClassName)) {
            intent = new Intent(context, BrazeWebViewActivity.class);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new UriAction$getWebViewActivityIntent$webViewActivityIntent$1(customHtmlWebViewActivityClassName), 3, (Object) null);
            intent = new Intent().setClassName(context, customHtmlWebViewActivityClassName);
            Intrinsics.checkNotNullExpressionValue(intent, "customWebViewActivityCla…ivityClassName)\n        }");
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("url", uri2.toString());
        return intent;
    }

    /* access modifiers changed from: protected */
    public final Intent getActionViewIntent(Context context, Uri uri2, Bundle bundle) {
        List<ResolveInfo> list;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri2, "uri");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri2);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            list = context.getPackageManager().queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0));
        } else {
            list = context.getPackageManager().queryIntentActivities(intent, 0);
        }
        Intrinsics.checkNotNullExpressionValue(list, "if (Build.VERSION.SDK_IN…ties(intent, 0)\n        }");
        if (list.size() > 1) {
            Iterator<ResolveInfo> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ResolveInfo next = it.next();
                if (Intrinsics.areEqual((Object) next.activityInfo.packageName, (Object) context.getPackageName())) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new UriAction$getActionViewIntent$1(next), 3, (Object) null);
                    intent.setPackage(next.activityInfo.packageName);
                    break;
                }
            }
        }
        return intent;
    }

    public final Intent[] getIntentArrayWithConfiguredBackStack(Context context, Bundle bundle, Intent intent, BrazeConfigurationProvider brazeConfigurationProvider) {
        Context context2 = context;
        Bundle bundle2 = bundle;
        Intent intent2 = intent;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(intent2, "targetIntent");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        Intent intent3 = null;
        if (brazeConfigurationProvider.isPushDeepLinkBackStackActivityEnabled()) {
            String pushDeepLinkBackStackActivityClassName = brazeConfigurationProvider.getPushDeepLinkBackStackActivityClassName();
            CharSequence charSequence = pushDeepLinkBackStackActivityClassName;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) UriAction$getIntentArrayWithConfiguredBackStack$1.INSTANCE, 2, (Object) null);
                intent3 = UriUtils.getMainActivityIntent(context, bundle);
            } else if (UriUtils.isActivityRegisteredInManifest(context2, pushDeepLinkBackStackActivityClassName)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new UriAction$getIntentArrayWithConfiguredBackStack$2(pushDeepLinkBackStackActivityClassName), 2, (Object) null);
                if (bundle2 != null) {
                    intent3 = new Intent().setClassName(context2, pushDeepLinkBackStackActivityClassName).setFlags(BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_BACK_STACK_GET_ROOT_INTENT)).putExtras(bundle2);
                }
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new UriAction$getIntentArrayWithConfiguredBackStack$4(pushDeepLinkBackStackActivityClassName), 2, (Object) null);
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) UriAction$getIntentArrayWithConfiguredBackStack$5.INSTANCE, 2, (Object) null);
        }
        if (intent3 == null) {
            intent2.setFlags(BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_BACK_STACK_ONLY_GET_TARGET_INTENT));
            return new Intent[]{intent2};
        }
        return new Intent[]{intent3, intent2};
    }
}

package com.braze.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.enums.Channel;
import com.braze.support.BrazeLogger;
import com.braze.ui.actions.NewsfeedAction;
import com.braze.ui.actions.UriAction;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J,\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0004H\u0016¨\u0006\u001d"}, d2 = {"Lcom/braze/ui/BrazeDeeplinkHandler;", "Lcom/braze/IBrazeDeeplinkHandler;", "()V", "createUriActionFromUri", "Lcom/braze/ui/actions/UriAction;", "uri", "Landroid/net/Uri;", "extras", "Landroid/os/Bundle;", "openInWebView", "", "channel", "Lcom/braze/enums/Channel;", "createUriActionFromUrlString", "url", "", "getIntentFlags", "", "intentFlagPurpose", "Lcom/braze/IBrazeDeeplinkHandler$IntentFlagPurpose;", "gotoNewsFeed", "", "context", "Landroid/content/Context;", "newsfeedAction", "Lcom/braze/ui/actions/NewsfeedAction;", "gotoUri", "uriAction", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeDeeplinkHandler.kt */
public class BrazeDeeplinkHandler implements IBrazeDeeplinkHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static volatile IBrazeDeeplinkHandler customHandler;
    /* access modifiers changed from: private */
    public static final IBrazeDeeplinkHandler defaultHandler = new BrazeDeeplinkHandler();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BrazeDeeplinkHandler.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.braze.IBrazeDeeplinkHandler$IntentFlagPurpose[] r0 = com.braze.IBrazeDeeplinkHandler.IntentFlagPurpose.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.braze.IBrazeDeeplinkHandler$IntentFlagPurpose r1 = com.braze.IBrazeDeeplinkHandler.IntentFlagPurpose.NOTIFICATION_ACTION_WITH_DEEPLINK     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.braze.IBrazeDeeplinkHandler$IntentFlagPurpose r1 = com.braze.IBrazeDeeplinkHandler.IntentFlagPurpose.NOTIFICATION_PUSH_STORY_PAGE_CLICK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.braze.IBrazeDeeplinkHandler$IntentFlagPurpose r1 = com.braze.IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_OPEN_WITH_WEBVIEW_ACTIVITY     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.braze.IBrazeDeeplinkHandler$IntentFlagPurpose r1 = com.braze.IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_OPEN_WITH_ACTION_VIEW     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.braze.IBrazeDeeplinkHandler$IntentFlagPurpose r1 = com.braze.IBrazeDeeplinkHandler.IntentFlagPurpose.URI_UTILS_GET_MAIN_ACTIVITY_INTENT     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.braze.IBrazeDeeplinkHandler$IntentFlagPurpose r1 = com.braze.IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_BACK_STACK_GET_ROOT_INTENT     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.braze.IBrazeDeeplinkHandler$IntentFlagPurpose r1 = com.braze.IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_BACK_STACK_ONLY_GET_TARGET_INTENT     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.ui.BrazeDeeplinkHandler.WhenMappings.<clinit>():void");
        }
    }

    @JvmStatic
    public static final IBrazeDeeplinkHandler getInstance() {
        return Companion.getInstance();
    }

    @JvmStatic
    public static final void setBrazeDeeplinkHandler(IBrazeDeeplinkHandler iBrazeDeeplinkHandler) {
        Companion.setBrazeDeeplinkHandler(iBrazeDeeplinkHandler);
    }

    public void gotoNewsFeed(Context context, NewsfeedAction newsfeedAction) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(newsfeedAction, "newsfeedAction");
        newsfeedAction.execute(context);
    }

    public void gotoUri(Context context, UriAction uriAction) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uriAction, "uriAction");
        uriAction.execute(context);
    }

    public int getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose intentFlagPurpose) {
        Intrinsics.checkNotNullParameter(intentFlagPurpose, "intentFlagPurpose");
        switch (WhenMappings.$EnumSwitchMapping$0[intentFlagPurpose.ordinal()]) {
            case 1:
            case 2:
                return 1073741824;
            case 3:
            case 4:
            case 5:
                return 872415232;
            case 6:
            case 7:
                return 268435456;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public UriAction createUriActionFromUrlString(String str, Bundle bundle, boolean z, Channel channel) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(channel, "channel");
        try {
            if (!StringsKt.isBlank(str)) {
                Uri parse = Uri.parse(str);
                Intrinsics.checkNotNullExpressionValue(parse, "uri");
                return createUriActionFromUri(parse, bundle, z, channel);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) null, (Function0) BrazeDeeplinkHandler$createUriActionFromUrlString$1.INSTANCE, 2, (Object) null);
            return null;
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) BrazeDeeplinkHandler$createUriActionFromUrlString$2.INSTANCE);
            return null;
        }
    }

    public UriAction createUriActionFromUri(Uri uri, Bundle bundle, boolean z, Channel channel) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(channel, "channel");
        return new UriAction(uri, bundle, z, channel);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/braze/ui/BrazeDeeplinkHandler$Companion;", "", "()V", "customHandler", "Lcom/braze/IBrazeDeeplinkHandler;", "defaultHandler", "getInstance", "setBrazeDeeplinkHandler", "", "brazeDeeplinkHandler", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BrazeDeeplinkHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final IBrazeDeeplinkHandler getInstance() {
            IBrazeDeeplinkHandler access$getCustomHandler$cp = BrazeDeeplinkHandler.customHandler;
            return access$getCustomHandler$cp == null ? BrazeDeeplinkHandler.defaultHandler : access$getCustomHandler$cp;
        }

        @JvmStatic
        public final void setBrazeDeeplinkHandler(IBrazeDeeplinkHandler iBrazeDeeplinkHandler) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeDeeplinkHandler$Companion$setBrazeDeeplinkHandler$1(iBrazeDeeplinkHandler), 3, (Object) null);
            BrazeDeeplinkHandler.customHandler = iBrazeDeeplinkHandler;
        }
    }
}

package com.braze;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.braze.enums.Channel;
import com.braze.ui.actions.NewsfeedAction;
import com.braze.ui.actions.UriAction;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001bJ*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J,\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0003H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0001"}, d2 = {"Lcom/braze/IBrazeDeeplinkHandler;", "", "createUriActionFromUri", "Lcom/braze/ui/actions/UriAction;", "uri", "Landroid/net/Uri;", "extras", "Landroid/os/Bundle;", "openInWebView", "", "channel", "Lcom/braze/enums/Channel;", "createUriActionFromUrlString", "url", "", "getIntentFlags", "", "intentFlagPurpose", "Lcom/braze/IBrazeDeeplinkHandler$IntentFlagPurpose;", "gotoNewsFeed", "", "context", "Landroid/content/Context;", "newsfeedAction", "Lcom/braze/ui/actions/NewsfeedAction;", "gotoUri", "uriAction", "IntentFlagPurpose", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IBrazeDeeplinkHandler.kt */
public interface IBrazeDeeplinkHandler {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/braze/IBrazeDeeplinkHandler$IntentFlagPurpose;", "", "(Ljava/lang/String;I)V", "NOTIFICATION_ACTION_WITH_DEEPLINK", "NOTIFICATION_PUSH_STORY_PAGE_CLICK", "URI_ACTION_OPEN_WITH_WEBVIEW_ACTIVITY", "URI_ACTION_OPEN_WITH_ACTION_VIEW", "URI_ACTION_BACK_STACK_GET_ROOT_INTENT", "URI_ACTION_BACK_STACK_ONLY_GET_TARGET_INTENT", "URI_UTILS_GET_MAIN_ACTIVITY_INTENT", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: IBrazeDeeplinkHandler.kt */
    public enum IntentFlagPurpose {
        NOTIFICATION_ACTION_WITH_DEEPLINK,
        NOTIFICATION_PUSH_STORY_PAGE_CLICK,
        URI_ACTION_OPEN_WITH_WEBVIEW_ACTIVITY,
        URI_ACTION_OPEN_WITH_ACTION_VIEW,
        URI_ACTION_BACK_STACK_GET_ROOT_INTENT,
        URI_ACTION_BACK_STACK_ONLY_GET_TARGET_INTENT,
        URI_UTILS_GET_MAIN_ACTIVITY_INTENT
    }

    UriAction createUriActionFromUri(Uri uri, Bundle bundle, boolean z, Channel channel);

    UriAction createUriActionFromUrlString(String str, Bundle bundle, boolean z, Channel channel);

    int getIntentFlags(IntentFlagPurpose intentFlagPurpose);

    void gotoNewsFeed(Context context, NewsfeedAction newsfeedAction);

    void gotoUri(Context context, UriAction uriAction);
}

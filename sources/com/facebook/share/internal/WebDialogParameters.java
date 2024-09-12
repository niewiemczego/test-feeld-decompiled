package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.facebook.share.model.AppGroupCreationContent;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\u00042\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u0013"}, d2 = {"Lcom/facebook/share/internal/WebDialogParameters;", "", "()V", "create", "Landroid/os/Bundle;", "appGroupCreationContent", "Lcom/facebook/share/model/AppGroupCreationContent;", "gameRequestContent", "Lcom/facebook/share/model/GameRequestContent;", "shareLinkContent", "Lcom/facebook/share/model/ShareLinkContent;", "sharePhotoContent", "Lcom/facebook/share/model/SharePhotoContent;", "createBaseParameters", "shareContent", "Lcom/facebook/share/model/ShareContent;", "createForFeed", "shareFeedContent", "Lcom/facebook/share/internal/ShareFeedContent;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: WebDialogParameters.kt */
public final class WebDialogParameters {
    public static final WebDialogParameters INSTANCE = new WebDialogParameters();

    private WebDialogParameters() {
    }

    @JvmStatic
    public static final Bundle create(AppGroupCreationContent appGroupCreationContent) {
        String appGroupPrivacy;
        Intrinsics.checkNotNullParameter(appGroupCreationContent, "appGroupCreationContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "name", appGroupCreationContent.getName());
        Utility utility2 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "description", appGroupCreationContent.getDescription());
        Utility utility3 = Utility.INSTANCE;
        AppGroupCreationContent.AppGroupPrivacy appGroupPrivacy2 = appGroupCreationContent.getAppGroupPrivacy();
        String str = null;
        if (!(appGroupPrivacy2 == null || (appGroupPrivacy = appGroupPrivacy2.toString()) == null)) {
            Locale locale = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
            str = appGroupPrivacy.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase(locale)");
        }
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_PRIVACY, str);
        return bundle;
    }

    @JvmStatic
    public static final Bundle create(GameRequestContent gameRequestContent) {
        String str;
        String filters;
        String actionType;
        Intrinsics.checkNotNullParameter(gameRequestContent, "gameRequestContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "message", gameRequestContent.getMessage());
        Utility utility2 = Utility.INSTANCE;
        Utility.putCommaSeparatedStringList(bundle, "to", gameRequestContent.getRecipients());
        Utility utility3 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "title", gameRequestContent.getTitle());
        Utility utility4 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "data", gameRequestContent.getData());
        Utility utility5 = Utility.INSTANCE;
        GameRequestContent.ActionType actionType2 = gameRequestContent.getActionType();
        String str2 = null;
        if (actionType2 == null || (actionType = actionType2.toString()) == null) {
            str = null;
        } else {
            Locale locale = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
            str = actionType.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase(locale)");
        }
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, str);
        Utility utility6 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "object_id", gameRequestContent.getObjectId());
        Utility utility7 = Utility.INSTANCE;
        GameRequestContent.Filters filters2 = gameRequestContent.getFilters();
        if (!(filters2 == null || (filters = filters2.toString()) == null)) {
            Locale locale2 = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(locale2, ViewHierarchyConstants.ENGLISH);
            str2 = filters.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.String).toLowerCase(locale)");
        }
        Utility.putNonEmptyString(bundle, "filters", str2);
        Utility utility8 = Utility.INSTANCE;
        Utility.putCommaSeparatedStringList(bundle, ShareConstants.WEB_DIALOG_PARAM_SUGGESTIONS, gameRequestContent.getSuggestions());
        return bundle;
    }

    @JvmStatic
    public static final Bundle create(ShareLinkContent shareLinkContent) {
        Intrinsics.checkNotNullParameter(shareLinkContent, "shareLinkContent");
        Bundle createBaseParameters = createBaseParameters(shareLinkContent);
        Utility utility = Utility.INSTANCE;
        Utility.putUri(createBaseParameters, "href", shareLinkContent.getContentUrl());
        Utility utility2 = Utility.INSTANCE;
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.WEB_DIALOG_PARAM_QUOTE, shareLinkContent.getQuote());
        return createBaseParameters;
    }

    @JvmStatic
    public static final Bundle create(SharePhotoContent sharePhotoContent) {
        Intrinsics.checkNotNullParameter(sharePhotoContent, "sharePhotoContent");
        Bundle createBaseParameters = createBaseParameters(sharePhotoContent);
        List<SharePhoto> photos = sharePhotoContent.getPhotos();
        if (photos == null) {
            photos = CollectionsKt.emptyList();
        }
        Iterable<SharePhoto> iterable = photos;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (SharePhoto imageUrl : iterable) {
            arrayList.add(String.valueOf(imageUrl.getImageUrl()));
        }
        Object[] array = ((List) arrayList).toArray(new String[0]);
        if (array != null) {
            createBaseParameters.putStringArray("media", (String[]) array);
            return createBaseParameters;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @JvmStatic
    public static final Bundle createBaseParameters(ShareContent<?, ?> shareContent) {
        Intrinsics.checkNotNullParameter(shareContent, "shareContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        ShareHashtag shareHashtag = shareContent.getShareHashtag();
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_HASHTAG, shareHashtag == null ? null : shareHashtag.getHashtag());
        return bundle;
    }

    @JvmStatic
    public static final Bundle createForFeed(ShareLinkContent shareLinkContent) {
        Intrinsics.checkNotNullParameter(shareLinkContent, "shareLinkContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility utility2 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "link", Utility.getUriString(shareLinkContent.getContentUrl()));
        Utility utility3 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_QUOTE, shareLinkContent.getQuote());
        Utility utility4 = Utility.INSTANCE;
        ShareHashtag shareHashtag = shareLinkContent.getShareHashtag();
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_HASHTAG, shareHashtag == null ? null : shareHashtag.getHashtag());
        return bundle;
    }

    @JvmStatic
    public static final Bundle createForFeed(ShareFeedContent shareFeedContent) {
        Intrinsics.checkNotNullParameter(shareFeedContent, "shareFeedContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "to", shareFeedContent.getToId());
        Utility utility2 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "link", shareFeedContent.getLink());
        Utility utility3 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "picture", shareFeedContent.getPicture());
        Utility utility4 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "source", shareFeedContent.getMediaSource());
        Utility utility5 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "name", shareFeedContent.getLinkName());
        Utility utility6 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, ShareConstants.FEED_CAPTION_PARAM, shareFeedContent.getLinkCaption());
        Utility utility7 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "description", shareFeedContent.getLinkDescription());
        return bundle;
    }
}

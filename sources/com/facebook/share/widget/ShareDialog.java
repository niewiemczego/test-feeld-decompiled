package com.facebook.share.widget;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.share.Sharer;
import com.facebook.share.internal.CameraEffectFeature;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.ShareStoryFeature;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import io.sentry.protocol.Request;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 12\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00070123456B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0011\b\u0016\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u000f\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB\u000f\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0010B\u0017\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0011B\u0017\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u000e\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0012B\u0019\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0015J \u0010\u001e\u001a\u00020\u00172\u000e\u0010\u001f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020\u0017H\u0016J*\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\u000e\u0010\u001f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010 \u001a\u00020!H\u0002J\u001e\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030-H\u0014J\u0010\u0010.\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J \u0010/\u001a\u00020&2\u000e\u0010\u001f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R2\u0010\u0018\u001a \u0012\u001c\u0012\u001a0\u001aR\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/facebook/share/widget/ShareDialog;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "Lcom/facebook/share/Sharer;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "requestCode", "", "(I)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "Landroid/app/Fragment;", "(Landroid/app/Fragment;)V", "(Landroid/app/Activity;I)V", "(Landroidx/fragment/app/Fragment;I)V", "(Landroid/app/Fragment;I)V", "fragmentWrapper", "Lcom/facebook/internal/FragmentWrapper;", "(Lcom/facebook/internal/FragmentWrapper;I)V", "isAutomaticMode", "", "orderedModeHandlers", "", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "getOrderedModeHandlers", "()Ljava/util/List;", "shouldFailOnDataError", "canShow", "content", "mode", "Lcom/facebook/share/widget/ShareDialog$Mode;", "createBaseAppCall", "Lcom/facebook/internal/AppCall;", "getShouldFailOnDataError", "logDialogShare", "", "context", "Landroid/content/Context;", "registerCallbackImpl", "callbackManager", "Lcom/facebook/internal/CallbackManagerImpl;", "callback", "Lcom/facebook/FacebookCallback;", "setShouldFailOnDataError", "show", "CameraEffectHandler", "Companion", "FeedHandler", "Mode", "NativeHandler", "ShareStoryHandler", "WebShareHandler", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ShareDialog.kt */
public class ShareDialog extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result> implements Sharer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
    private static final String FEED_DIALOG = "feed";
    private static final String TAG = "ShareDialog";
    private static final String WEB_OG_SHARE_DIALOG = "share_open_graph";
    public static final String WEB_SHARE_DIALOG = "share";
    private boolean isAutomaticMode;
    private final List<FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler> orderedModeHandlers;
    private boolean shouldFailOnDataError;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$Mode;", "", "(Ljava/lang/String;I)V", "AUTOMATIC", "NATIVE", "WEB", "FEED", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareDialog.kt */
    public enum Mode {
        AUTOMATIC,
        NATIVE,
        WEB,
        FEED
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareDialog.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.values().length];
            iArr[Mode.AUTOMATIC.ordinal()] = 1;
            iArr[Mode.WEB.ordinal()] = 2;
            iArr[Mode.NATIVE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static boolean canShow(Class<? extends ShareContent<?, ?>> cls) {
        return Companion.canShow(cls);
    }

    @JvmStatic
    public static void show(Activity activity, ShareContent<?, ?> shareContent) {
        Companion.show(activity, shareContent);
    }

    @JvmStatic
    public static void show(Fragment fragment, ShareContent<?, ?> shareContent) {
        Companion.show(fragment, shareContent);
    }

    @JvmStatic
    public static void show(androidx.fragment.app.Fragment fragment, ShareContent<?, ?> shareContent) {
        Companion.show(fragment, shareContent);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShareDialog(Activity activity) {
        this(activity, DEFAULT_REQUEST_CODE);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public ShareDialog(int i) {
        super(i);
        this.isAutomaticMode = true;
        this.orderedModeHandlers = CollectionsKt.arrayListOf(new NativeHandler(this), new FeedHandler(this), new WebShareHandler(this), new CameraEffectHandler(this), new ShareStoryHandler(this));
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShareDialog(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? DEFAULT_REQUEST_CODE : i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShareDialog(androidx.fragment.app.Fragment fragment) {
        this(new FragmentWrapper(fragment), 0, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fragment, Request.JsonKeys.FRAGMENT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShareDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment), 0, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fragment, Request.JsonKeys.FRAGMENT);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareDialog(Activity activity, int i) {
        super(activity, i);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.isAutomaticMode = true;
        this.orderedModeHandlers = CollectionsKt.arrayListOf(new NativeHandler(this), new FeedHandler(this), new WebShareHandler(this), new CameraEffectHandler(this), new ShareStoryHandler(this));
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShareDialog(androidx.fragment.app.Fragment fragment, int i) {
        this(new FragmentWrapper(fragment), i);
        Intrinsics.checkNotNullParameter(fragment, Request.JsonKeys.FRAGMENT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShareDialog(Fragment fragment, int i) {
        this(new FragmentWrapper(fragment), i);
        Intrinsics.checkNotNullParameter(fragment, Request.JsonKeys.FRAGMENT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShareDialog(FragmentWrapper fragmentWrapper, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentWrapper, (i2 & 2) != 0 ? DEFAULT_REQUEST_CODE : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareDialog(FragmentWrapper fragmentWrapper, int i) {
        super(fragmentWrapper, i);
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragmentWrapper");
        this.isAutomaticMode = true;
        this.orderedModeHandlers = CollectionsKt.arrayListOf(new NativeHandler(this), new FeedHandler(this), new WebShareHandler(this), new CameraEffectHandler(this), new ShareStoryHandler(this));
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    /* access modifiers changed from: protected */
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Sharer.Result> facebookCallback) {
        Intrinsics.checkNotNullParameter(callbackManagerImpl, "callbackManager");
        Intrinsics.checkNotNullParameter(facebookCallback, "callback");
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManagerImpl, facebookCallback);
    }

    public boolean getShouldFailOnDataError() {
        return this.shouldFailOnDataError;
    }

    public void setShouldFailOnDataError(boolean z) {
        this.shouldFailOnDataError = z;
    }

    public boolean canShow(ShareContent<?, ?> shareContent, Mode mode) {
        Intrinsics.checkNotNullParameter(shareContent, "content");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Object obj = mode;
        if (mode == Mode.AUTOMATIC) {
            obj = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }
        return canShowImpl(shareContent, obj);
    }

    public void show(ShareContent<?, ?> shareContent, Mode mode) {
        Intrinsics.checkNotNullParameter(shareContent, "content");
        Intrinsics.checkNotNullParameter(mode, "mode");
        boolean z = mode == Mode.AUTOMATIC;
        this.isAutomaticMode = z;
        Object obj = mode;
        if (z) {
            obj = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }
        showImpl(shareContent, obj);
    }

    /* access modifiers changed from: protected */
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode(), (UUID) null, 2, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public List<FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler> getOrderedModeHandlers() {
        return this.orderedModeHandlers;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u001a0\u0001R\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J \u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$NativeHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "(Lcom/facebook/share/widget/ShareDialog;)V", "mode", "", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareDialog.kt */
    private final class NativeHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {
        private Object mode = Mode.NATIVE;
        final /* synthetic */ ShareDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NativeHandler(ShareDialog shareDialog) {
            super(shareDialog);
            Intrinsics.checkNotNullParameter(shareDialog, "this$0");
            this.this$0 = shareDialog;
        }

        public Object getMode() {
            return this.mode;
        }

        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
            if (com.facebook.internal.DialogPresenter.canPresentNativeDialogWithFeature(com.facebook.share.internal.ShareDialogFeature.LINK_SHARE_QUOTES) != false) goto L_0x0050;
         */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean canShow(com.facebook.share.model.ShareContent<?, ?> r4, boolean r5) {
            /*
                r3 = this;
                java.lang.String r0 = "content"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                boolean r0 = r4 instanceof com.facebook.share.model.ShareCameraEffectContent
                r1 = 0
                if (r0 != 0) goto L_0x0060
                boolean r0 = r4 instanceof com.facebook.share.model.ShareStoryContent
                if (r0 == 0) goto L_0x000f
                goto L_0x0060
            L_0x000f:
                r0 = 1
                if (r5 != 0) goto L_0x0050
                com.facebook.share.model.ShareHashtag r5 = r4.getShareHashtag()
                if (r5 == 0) goto L_0x0023
                com.facebook.internal.DialogPresenter r5 = com.facebook.internal.DialogPresenter.INSTANCE
                com.facebook.share.internal.ShareDialogFeature r5 = com.facebook.share.internal.ShareDialogFeature.HASHTAG
                com.facebook.internal.DialogFeature r5 = (com.facebook.internal.DialogFeature) r5
                boolean r5 = com.facebook.internal.DialogPresenter.canPresentNativeDialogWithFeature(r5)
                goto L_0x0024
            L_0x0023:
                r5 = r0
            L_0x0024:
                boolean r2 = r4 instanceof com.facebook.share.model.ShareLinkContent
                if (r2 == 0) goto L_0x0051
                r2 = r4
                com.facebook.share.model.ShareLinkContent r2 = (com.facebook.share.model.ShareLinkContent) r2
                java.lang.String r2 = r2.getQuote()
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                if (r2 == 0) goto L_0x003c
                int r2 = r2.length()
                if (r2 != 0) goto L_0x003a
                goto L_0x003c
            L_0x003a:
                r2 = r1
                goto L_0x003d
            L_0x003c:
                r2 = r0
            L_0x003d:
                if (r2 != 0) goto L_0x0051
                if (r5 == 0) goto L_0x004e
                com.facebook.internal.DialogPresenter r5 = com.facebook.internal.DialogPresenter.INSTANCE
                com.facebook.share.internal.ShareDialogFeature r5 = com.facebook.share.internal.ShareDialogFeature.LINK_SHARE_QUOTES
                com.facebook.internal.DialogFeature r5 = (com.facebook.internal.DialogFeature) r5
                boolean r5 = com.facebook.internal.DialogPresenter.canPresentNativeDialogWithFeature(r5)
                if (r5 == 0) goto L_0x004e
                goto L_0x0050
            L_0x004e:
                r5 = r1
                goto L_0x0051
            L_0x0050:
                r5 = r0
            L_0x0051:
                if (r5 == 0) goto L_0x0060
                com.facebook.share.widget.ShareDialog$Companion r5 = com.facebook.share.widget.ShareDialog.Companion
                java.lang.Class r4 = r4.getClass()
                boolean r4 = r5.canShowNative(r4)
                if (r4 == 0) goto L_0x0060
                r1 = r0
            L_0x0060:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.ShareDialog.NativeHandler.canShow(com.facebook.share.model.ShareContent, boolean):boolean");
        }

        public AppCall createAppCall(ShareContent<?, ?> shareContent) {
            Intrinsics.checkNotNullParameter(shareContent, "content");
            ShareDialog shareDialog = this.this$0;
            shareDialog.logDialogShare(shareDialog.getActivityContext(), shareContent, Mode.NATIVE);
            ShareContentValidation shareContentValidation = ShareContentValidation.INSTANCE;
            ShareContentValidation.validateForNativeShare(shareContent);
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            boolean shouldFailOnDataError = this.this$0.getShouldFailOnDataError();
            DialogFeature access$getFeature = ShareDialog.Companion.getFeature(shareContent.getClass());
            if (access$getFeature == null) {
                return null;
            }
            DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ShareDialog$NativeHandler$createAppCall$1(createBaseAppCall, shareContent, shouldFailOnDataError), access$getFeature);
            return createBaseAppCall;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0004\u0018\u00002\u001a0\u0001R\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J \u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0016J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u000e\u0010\u0018\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$WebShareHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "(Lcom/facebook/share/widget/ShareDialog;)V", "mode", "", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "createAndMapAttachments", "Lcom/facebook/share/model/SharePhotoContent;", "callId", "Ljava/util/UUID;", "createAppCall", "Lcom/facebook/internal/AppCall;", "getActionName", "", "shareContent", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareDialog.kt */
    private final class WebShareHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {
        private Object mode = Mode.WEB;
        final /* synthetic */ ShareDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WebShareHandler(ShareDialog shareDialog) {
            super(shareDialog);
            Intrinsics.checkNotNullParameter(shareDialog, "this$0");
            this.this$0 = shareDialog;
        }

        public Object getMode() {
            return this.mode;
        }

        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }

        public boolean canShow(ShareContent<?, ?> shareContent, boolean z) {
            Intrinsics.checkNotNullParameter(shareContent, "content");
            return ShareDialog.Companion.canShowWebCheck(shareContent);
        }

        public AppCall createAppCall(ShareContent<?, ?> shareContent) {
            Bundle bundle;
            Intrinsics.checkNotNullParameter(shareContent, "content");
            ShareDialog shareDialog = this.this$0;
            shareDialog.logDialogShare(shareDialog.getActivityContext(), shareContent, Mode.WEB);
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            ShareContentValidation shareContentValidation = ShareContentValidation.INSTANCE;
            ShareContentValidation.validateForWebShare(shareContent);
            if (shareContent instanceof ShareLinkContent) {
                WebDialogParameters webDialogParameters = WebDialogParameters.INSTANCE;
                bundle = WebDialogParameters.create((ShareLinkContent) shareContent);
            } else if (!(shareContent instanceof SharePhotoContent)) {
                return null;
            } else {
                SharePhotoContent createAndMapAttachments = createAndMapAttachments((SharePhotoContent) shareContent, createBaseAppCall.getCallId());
                WebDialogParameters webDialogParameters2 = WebDialogParameters.INSTANCE;
                bundle = WebDialogParameters.create(createAndMapAttachments);
            }
            DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, getActionName(shareContent), bundle);
            return createBaseAppCall;
        }

        private final String getActionName(ShareContent<?, ?> shareContent) {
            if ((shareContent instanceof ShareLinkContent) || (shareContent instanceof SharePhotoContent)) {
                return "share";
            }
            return null;
        }

        private final SharePhotoContent createAndMapAttachments(SharePhotoContent sharePhotoContent, UUID uuid) {
            SharePhotoContent.Builder readFrom = new SharePhotoContent.Builder().readFrom(sharePhotoContent);
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            int size = sharePhotoContent.getPhotos().size() - 1;
            if (size >= 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    SharePhoto sharePhoto = sharePhotoContent.getPhotos().get(i);
                    Bitmap bitmap = sharePhoto.getBitmap();
                    if (bitmap != null) {
                        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
                        NativeAppCallAttachmentStore.Attachment createAttachment = NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
                        sharePhoto = new SharePhoto.Builder().readFrom(sharePhoto).setImageUrl(Uri.parse(createAttachment.getAttachmentUrl())).setBitmap((Bitmap) null).build();
                        arrayList2.add(createAttachment);
                    }
                    arrayList.add(sharePhoto);
                    if (i2 > size) {
                        break;
                    }
                    i = i2;
                }
            }
            readFrom.setPhotos(arrayList);
            NativeAppCallAttachmentStore nativeAppCallAttachmentStore2 = NativeAppCallAttachmentStore.INSTANCE;
            NativeAppCallAttachmentStore.addAttachments(arrayList2);
            return readFrom.build();
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u001a0\u0001R\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J \u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$FeedHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "(Lcom/facebook/share/widget/ShareDialog;)V", "mode", "", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareDialog.kt */
    private final class FeedHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {
        private Object mode = Mode.FEED;
        final /* synthetic */ ShareDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FeedHandler(ShareDialog shareDialog) {
            super(shareDialog);
            Intrinsics.checkNotNullParameter(shareDialog, "this$0");
            this.this$0 = shareDialog;
        }

        public Object getMode() {
            return this.mode;
        }

        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }

        public boolean canShow(ShareContent<?, ?> shareContent, boolean z) {
            Intrinsics.checkNotNullParameter(shareContent, "content");
            return (shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareFeedContent);
        }

        public AppCall createAppCall(ShareContent<?, ?> shareContent) {
            Bundle bundle;
            Intrinsics.checkNotNullParameter(shareContent, "content");
            ShareDialog shareDialog = this.this$0;
            shareDialog.logDialogShare(shareDialog.getActivityContext(), shareContent, Mode.FEED);
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            if (shareContent instanceof ShareLinkContent) {
                ShareContentValidation shareContentValidation = ShareContentValidation.INSTANCE;
                ShareContentValidation.validateForWebShare(shareContent);
                WebDialogParameters webDialogParameters = WebDialogParameters.INSTANCE;
                bundle = WebDialogParameters.createForFeed((ShareLinkContent) shareContent);
            } else if (!(shareContent instanceof ShareFeedContent)) {
                return null;
            } else {
                WebDialogParameters webDialogParameters2 = WebDialogParameters.INSTANCE;
                bundle = WebDialogParameters.createForFeed((ShareFeedContent) shareContent);
            }
            DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, ShareDialog.FEED_DIALOG, bundle);
            return createBaseAppCall;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u001a0\u0001R\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J \u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$CameraEffectHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "(Lcom/facebook/share/widget/ShareDialog;)V", "mode", "", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareDialog.kt */
    private final class CameraEffectHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {
        private Object mode = Mode.NATIVE;
        final /* synthetic */ ShareDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CameraEffectHandler(ShareDialog shareDialog) {
            super(shareDialog);
            Intrinsics.checkNotNullParameter(shareDialog, "this$0");
            this.this$0 = shareDialog;
        }

        public Object getMode() {
            return this.mode;
        }

        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }

        public boolean canShow(ShareContent<?, ?> shareContent, boolean z) {
            Intrinsics.checkNotNullParameter(shareContent, "content");
            return (shareContent instanceof ShareCameraEffectContent) && ShareDialog.Companion.canShowNative(shareContent.getClass());
        }

        public AppCall createAppCall(ShareContent<?, ?> shareContent) {
            Intrinsics.checkNotNullParameter(shareContent, "content");
            ShareContentValidation shareContentValidation = ShareContentValidation.INSTANCE;
            ShareContentValidation.validateForNativeShare(shareContent);
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            boolean shouldFailOnDataError = this.this$0.getShouldFailOnDataError();
            DialogFeature access$getFeature = ShareDialog.Companion.getFeature(shareContent.getClass());
            if (access$getFeature == null) {
                return null;
            }
            DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ShareDialog$CameraEffectHandler$createAppCall$1(createBaseAppCall, shareContent, shouldFailOnDataError), access$getFeature);
            return createBaseAppCall;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u001a0\u0001R\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J \u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$ShareStoryHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "(Lcom/facebook/share/widget/ShareDialog;)V", "mode", "", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareDialog.kt */
    private final class ShareStoryHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {
        private Object mode = Mode.NATIVE;
        final /* synthetic */ ShareDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShareStoryHandler(ShareDialog shareDialog) {
            super(shareDialog);
            Intrinsics.checkNotNullParameter(shareDialog, "this$0");
            this.this$0 = shareDialog;
        }

        public Object getMode() {
            return this.mode;
        }

        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }

        public boolean canShow(ShareContent<?, ?> shareContent, boolean z) {
            Intrinsics.checkNotNullParameter(shareContent, "content");
            return (shareContent instanceof ShareStoryContent) && ShareDialog.Companion.canShowNative(shareContent.getClass());
        }

        public AppCall createAppCall(ShareContent<?, ?> shareContent) {
            Intrinsics.checkNotNullParameter(shareContent, "content");
            ShareContentValidation shareContentValidation = ShareContentValidation.INSTANCE;
            ShareContentValidation.validateForStoryShare(shareContent);
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            boolean shouldFailOnDataError = this.this$0.getShouldFailOnDataError();
            DialogFeature access$getFeature = ShareDialog.Companion.getFeature(shareContent.getClass());
            if (access$getFeature == null) {
                return null;
            }
            DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ShareDialog$ShareStoryHandler$createAppCall$1(createBaseAppCall, shareContent, shouldFailOnDataError), access$getFeature);
            return createBaseAppCall;
        }
    }

    /* access modifiers changed from: private */
    public final void logDialogShare(Context context, ShareContent<?, ?> shareContent, Mode mode) {
        if (this.isAutomaticMode) {
            mode = Mode.AUTOMATIC;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        String str = "unknown";
        String str2 = i != 1 ? i != 2 ? i != 3 ? str : "native" : AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB : AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC;
        DialogFeature access$getFeature = Companion.getFeature(shareContent.getClass());
        if (access$getFeature == ShareDialogFeature.SHARE_DIALOG) {
            str = "status";
        } else if (access$getFeature == ShareDialogFeature.PHOTOS) {
            str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO;
        } else if (access$getFeature == ShareDialogFeature.VIDEO) {
            str = "video";
        }
        InternalAppEventsLogger.Companion companion = InternalAppEventsLogger.Companion;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        InternalAppEventsLogger createInstance = companion.createInstance(context, FacebookSdk.getApplicationId());
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_show", str2);
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_TYPE, str);
        createInstance.logEventImplicitly("fb_share_dialog_show", bundle);
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000b\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\u000eH\u0017J \u0010\u0010\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u000e\u0010\u0012\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0002J \u0010\u0013\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\u000eH\u0002J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0016\u0010\r\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\u000eH\u0002J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0017J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0017J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001d2\u000e\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0017J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u000e\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/facebook/share/widget/ShareDialog$Companion;", "", "()V", "DEFAULT_REQUEST_CODE", "", "FEED_DIALOG", "", "TAG", "kotlin.jvm.PlatformType", "WEB_OG_SHARE_DIALOG", "WEB_SHARE_DIALOG", "canShow", "", "contentType", "Ljava/lang/Class;", "Lcom/facebook/share/model/ShareContent;", "canShowNative", "canShowWebCheck", "content", "canShowWebTypeCheck", "getFeature", "Lcom/facebook/internal/DialogFeature;", "show", "", "activity", "Landroid/app/Activity;", "shareContent", "fragment", "Landroid/app/Fragment;", "Landroidx/fragment/app/Fragment;", "fragmentWrapper", "Lcom/facebook/internal/FragmentWrapper;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public void show(Activity activity, ShareContent<?, ?> shareContent) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(shareContent, "shareContent");
            new ShareDialog(activity).show(shareContent);
        }

        @JvmStatic
        public void show(androidx.fragment.app.Fragment fragment, ShareContent<?, ?> shareContent) {
            Intrinsics.checkNotNullParameter(fragment, Request.JsonKeys.FRAGMENT);
            Intrinsics.checkNotNullParameter(shareContent, "shareContent");
            show(new FragmentWrapper(fragment), shareContent);
        }

        @JvmStatic
        public void show(Fragment fragment, ShareContent<?, ?> shareContent) {
            Intrinsics.checkNotNullParameter(fragment, Request.JsonKeys.FRAGMENT);
            Intrinsics.checkNotNullParameter(shareContent, "shareContent");
            show(new FragmentWrapper(fragment), shareContent);
        }

        private final void show(FragmentWrapper fragmentWrapper, ShareContent<?, ?> shareContent) {
            new ShareDialog(fragmentWrapper, 0, 2, (DefaultConstructorMarker) null).show(shareContent);
        }

        @JvmStatic
        public boolean canShow(Class<? extends ShareContent<?, ?>> cls) {
            Intrinsics.checkNotNullParameter(cls, "contentType");
            return canShowWebTypeCheck(cls) || canShowNative(cls);
        }

        /* access modifiers changed from: private */
        public final boolean canShowNative(Class<? extends ShareContent<?, ?>> cls) {
            DialogFeature feature = getFeature(cls);
            if (feature != null) {
                DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
                if (DialogPresenter.canPresentNativeDialogWithFeature(feature)) {
                    return true;
                }
            }
            return false;
        }

        private final boolean canShowWebTypeCheck(Class<? extends ShareContent<?, ?>> cls) {
            return ShareLinkContent.class.isAssignableFrom(cls) || (SharePhotoContent.class.isAssignableFrom(cls) && AccessToken.Companion.isCurrentAccessTokenActive());
        }

        /* access modifiers changed from: private */
        public final boolean canShowWebCheck(ShareContent<?, ?> shareContent) {
            return canShowWebTypeCheck(shareContent.getClass());
        }

        /* access modifiers changed from: private */
        public final DialogFeature getFeature(Class<? extends ShareContent<?, ?>> cls) {
            if (ShareLinkContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.SHARE_DIALOG;
            }
            if (SharePhotoContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.PHOTOS;
            }
            if (ShareVideoContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.VIDEO;
            }
            if (ShareMediaContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.MULTIMEDIA;
            }
            if (ShareCameraEffectContent.class.isAssignableFrom(cls)) {
                return CameraEffectFeature.SHARE_CAMERA_EFFECT;
            }
            if (ShareStoryContent.class.isAssignableFrom(cls)) {
                return ShareStoryFeature.SHARE_STORY_ASSET;
            }
            return null;
        }
    }
}

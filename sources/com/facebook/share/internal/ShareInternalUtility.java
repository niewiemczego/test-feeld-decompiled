package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.reactnativecommunity.clipboard.ClipboardModule;
import io.sentry.SentryEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\"\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0015\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0016H\u0002J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J\u001e\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u001e\u001a\u00020\u0004H\u0007J\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J\u0012\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u0018H\u0007J\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010 2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J\u0012\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u0018H\u0007J\u0018\u0010)\u001a\u00020*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0007J\u001c\u0010.\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J\u001c\u0010/\u001a\u0004\u0018\u00010\u00182\b\u00100\u001a\u0004\u0018\u0001012\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J\u0014\u00102\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001c\u00103\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J,\u00106\u001a\u0002072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u00108\u001a\u0004\u0018\u00010*H\u0007J\"\u00109\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010;\u001a\u0004\u0018\u00010\u0004H\u0007J \u0010<\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\u0006\u0010=\u001a\u00020>H\u0007J*\u0010?\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010@\u001a\u0004\u0018\u00010\u00042\u0006\u0010A\u001a\u00020BH\u0007J\u0018\u0010C\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0007J \u0010D\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\u0006\u0010E\u001a\u00020FH\u0007J,\u0010D\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010G\u001a\u0004\u0018\u00010B2\b\u0010H\u001a\u0004\u0018\u00010\u0004H\u0007J\"\u0010D\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010H\u001a\u0004\u0018\u00010\u0004H\u0007J\"\u0010I\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010@\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010J\u001a\u00020:2\u0006\u0010K\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010\u00142\b\u0010+\u001a\u0004\u0018\u00010RH\u0007J$\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010S\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010RH\u0007J&\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010T\u001a\u0004\u0018\u00010U2\b\u0010+\u001a\u0004\u0018\u00010RH\u0007J*\u0010V\u001a\u00020:2\u0006\u0010\b\u001a\u00020\t2\b\u0010W\u001a\u0004\u0018\u00010X2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0007J\u0010\u0010Y\u001a\u00020:2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020[2\u0006\u0010]\u001a\u000207H\u0007J\u001c\u0010^\u001a\u0004\u0018\u00010_2\b\u0010`\u001a\u0004\u0018\u00010_2\u0006\u0010]\u001a\u000207H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/facebook/share/internal/ShareInternalUtility;", "", "()V", "MY_STAGING_RESOURCES", "", "STAGING_PARAM", "getAppCallFromActivityResult", "Lcom/facebook/internal/AppCall;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "getAttachment", "Lcom/facebook/internal/NativeAppCallAttachmentStore$Attachment;", "callId", "Ljava/util/UUID;", "uri", "Landroid/net/Uri;", "bitmap", "Landroid/graphics/Bitmap;", "medium", "Lcom/facebook/share/model/ShareMedia;", "getBackgroundAssetMediaInfo", "Landroid/os/Bundle;", "storyContent", "Lcom/facebook/share/model/ShareStoryContent;", "appCallId", "getFieldNameAndNamespaceFromFullName", "Landroid/util/Pair;", "fullName", "getMediaInfos", "", "mediaContent", "Lcom/facebook/share/model/ShareMediaContent;", "getNativeDialogCompletionGesture", "result", "getPhotoUrls", "photoContent", "Lcom/facebook/share/model/SharePhotoContent;", "getShareDialogPostId", "getShareResultProcessor", "Lcom/facebook/share/internal/ResultProcessor;", "callback", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/share/Sharer$Result;", "getStickerUrl", "getTextureUrlBundle", "cameraEffectContent", "Lcom/facebook/share/model/ShareCameraEffectContent;", "getUriExtension", "getVideoUrl", "videoContent", "Lcom/facebook/share/model/ShareVideoContent;", "handleActivityResult", "", "resultProcessor", "invokeCallbackWithError", "", "error", "invokeCallbackWithException", "exception", "Ljava/lang/Exception;", "invokeCallbackWithResults", "postId", "graphResponse", "Lcom/facebook/GraphResponse;", "invokeOnCancelCallback", "invokeOnErrorCallback", "ex", "Lcom/facebook/FacebookException;", "response", "message", "invokeOnSuccessCallback", "logShareResult", "shareOutcome", "errorMessage", "newUploadStagingResourceWithImageRequest", "Lcom/facebook/GraphRequest;", "accessToken", "Lcom/facebook/AccessToken;", "image", "Lcom/facebook/GraphRequest$Callback;", "imageUri", "file", "Ljava/io/File;", "registerSharerCallback", "callbackManager", "Lcom/facebook/CallbackManager;", "registerStaticShareCallback", "removeNamespacesFromOGJsonArray", "Lorg/json/JSONArray;", "jsonArray", "requireNamespace", "removeNamespacesFromOGJsonObject", "Lorg/json/JSONObject;", "jsonObject", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ShareInternalUtility.kt */
public final class ShareInternalUtility {
    public static final ShareInternalUtility INSTANCE = new ShareInternalUtility();
    public static final String MY_STAGING_RESOURCES = "me/staging_resources";
    public static final String STAGING_PARAM = "file";

    private ShareInternalUtility() {
    }

    @JvmStatic
    public static final void invokeCallbackWithException(FacebookCallback<Sharer.Result> facebookCallback, Exception exc) {
        Intrinsics.checkNotNullParameter(exc, SentryEvent.JsonKeys.EXCEPTION);
        if (exc instanceof FacebookException) {
            invokeOnErrorCallback(facebookCallback, (FacebookException) exc);
        } else {
            invokeCallbackWithError(facebookCallback, Intrinsics.stringPlus("Error preparing share content: ", exc.getLocalizedMessage()));
        }
    }

    @JvmStatic
    public static final void invokeCallbackWithError(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        invokeOnErrorCallback(facebookCallback, str);
    }

    @JvmStatic
    public static final void invokeCallbackWithResults(FacebookCallback<Sharer.Result> facebookCallback, String str, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(graphResponse, "graphResponse");
        FacebookRequestError error = graphResponse.getError();
        if (error != null) {
            String errorMessage = error.getErrorMessage();
            Utility utility = Utility.INSTANCE;
            if (Utility.isNullOrEmpty(errorMessage)) {
                errorMessage = "Unexpected error sharing.";
            }
            invokeOnErrorCallback(facebookCallback, graphResponse, errorMessage);
            return;
        }
        invokeOnSuccessCallback(facebookCallback, str);
    }

    @JvmStatic
    public static final String getNativeDialogCompletionGesture(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.containsKey(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY)) {
            return bundle.getString(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY);
        }
        return bundle.getString(NativeProtocol.EXTRA_DIALOG_COMPLETION_GESTURE_KEY);
    }

    @JvmStatic
    public static final String getShareDialogPostId(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.containsKey(ShareConstants.RESULT_POST_ID)) {
            return bundle.getString(ShareConstants.RESULT_POST_ID);
        }
        if (bundle.containsKey(ShareConstants.EXTRA_RESULT_POST_ID)) {
            return bundle.getString(ShareConstants.EXTRA_RESULT_POST_ID);
        }
        return bundle.getString(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID);
    }

    @JvmStatic
    public static final boolean handleActivityResult(int i, int i2, Intent intent, ResultProcessor resultProcessor) {
        FacebookException facebookException;
        AppCall appCallFromActivityResult = INSTANCE.getAppCallFromActivityResult(i, i2, intent);
        if (appCallFromActivityResult == null) {
            return false;
        }
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
        NativeAppCallAttachmentStore.cleanupAttachmentsForCall(appCallFromActivityResult.getCallId());
        if (resultProcessor == null) {
            return true;
        }
        Bundle bundle = null;
        if (intent != null) {
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
            facebookException = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(intent));
        } else {
            facebookException = null;
        }
        if (facebookException == null) {
            if (intent != null) {
                NativeProtocol nativeProtocol3 = NativeProtocol.INSTANCE;
                bundle = NativeProtocol.getSuccessResultsFromIntent(intent);
            }
            resultProcessor.onSuccess(appCallFromActivityResult, bundle);
        } else if (facebookException instanceof FacebookOperationCanceledException) {
            resultProcessor.onCancel(appCallFromActivityResult);
        } else {
            resultProcessor.onError(appCallFromActivityResult, facebookException);
        }
        return true;
    }

    @JvmStatic
    public static final ResultProcessor getShareResultProcessor(FacebookCallback<Sharer.Result> facebookCallback) {
        return new ShareInternalUtility$getShareResultProcessor$1(facebookCallback);
    }

    private final AppCall getAppCallFromActivityResult(int i, int i2, Intent intent) {
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        UUID callIdFromIntent = NativeProtocol.getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            return null;
        }
        return AppCall.Companion.finishPendingCall(callIdFromIntent, i);
    }

    @JvmStatic
    public static final void registerStaticShareCallback(int i) {
        CallbackManagerImpl.Companion.registerStaticCallback(i, new ShareInternalUtility$$ExternalSyntheticLambda0(i));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerStaticShareCallback$lambda-0  reason: not valid java name */
    public static final boolean m411registerStaticShareCallback$lambda0(int i, int i2, Intent intent) {
        return handleActivityResult(i, i2, intent, getShareResultProcessor((FacebookCallback<Sharer.Result>) null));
    }

    @JvmStatic
    public static final void registerSharerCallback(int i, CallbackManager callbackManager, FacebookCallback<Sharer.Result> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(i, new ShareInternalUtility$$ExternalSyntheticLambda1(i, facebookCallback));
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    /* access modifiers changed from: private */
    /* renamed from: registerSharerCallback$lambda-1  reason: not valid java name */
    public static final boolean m410registerSharerCallback$lambda1(int i, FacebookCallback facebookCallback, int i2, Intent intent) {
        return handleActivityResult(i, i2, intent, getShareResultProcessor(facebookCallback));
    }

    @JvmStatic
    public static final List<String> getPhotoUrls(SharePhotoContent sharePhotoContent, UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "appCallId");
        List<SharePhoto> photos = sharePhotoContent == null ? null : sharePhotoContent.getPhotos();
        if (photos == null) {
            return null;
        }
        Collection arrayList = new ArrayList();
        for (SharePhoto attachment : photos) {
            NativeAppCallAttachmentStore.Attachment attachment2 = INSTANCE.getAttachment(uuid, attachment);
            if (attachment2 != null) {
                arrayList.add(attachment2);
            }
        }
        List list = (List) arrayList;
        Iterable<NativeAppCallAttachmentStore.Attachment> iterable = list;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (NativeAppCallAttachmentStore.Attachment attachmentUrl : iterable) {
            arrayList2.add(attachmentUrl.getAttachmentUrl());
        }
        List<String> list2 = (List) arrayList2;
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
        NativeAppCallAttachmentStore.addAttachments(list);
        return list2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r1 = r1.getVideo();
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getVideoUrl(com.facebook.share.model.ShareVideoContent r1, java.util.UUID r2) {
        /*
            java.lang.String r0 = "appCallId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = 0
            if (r1 != 0) goto L_0x000a
        L_0x0008:
            r1 = r0
            goto L_0x0015
        L_0x000a:
            com.facebook.share.model.ShareVideo r1 = r1.getVideo()
            if (r1 != 0) goto L_0x0011
            goto L_0x0008
        L_0x0011:
            android.net.Uri r1 = r1.getLocalUrl()
        L_0x0015:
            if (r1 != 0) goto L_0x0018
            return r0
        L_0x0018:
            com.facebook.internal.NativeAppCallAttachmentStore r0 = com.facebook.internal.NativeAppCallAttachmentStore.INSTANCE
            com.facebook.internal.NativeAppCallAttachmentStore$Attachment r1 = com.facebook.internal.NativeAppCallAttachmentStore.createAttachment((java.util.UUID) r2, (android.net.Uri) r1)
            com.facebook.internal.NativeAppCallAttachmentStore r2 = com.facebook.internal.NativeAppCallAttachmentStore.INSTANCE
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r1)
            java.util.Collection r2 = (java.util.Collection) r2
            com.facebook.internal.NativeAppCallAttachmentStore.addAttachments(r2)
            java.lang.String r1 = r1.getAttachmentUrl()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.ShareInternalUtility.getVideoUrl(com.facebook.share.model.ShareVideoContent, java.util.UUID):java.lang.String");
    }

    @JvmStatic
    public static final List<Bundle> getMediaInfos(ShareMediaContent shareMediaContent, UUID uuid) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(uuid, "appCallId");
        List<ShareMedia<?, ?>> media = shareMediaContent == null ? null : shareMediaContent.getMedia();
        if (media == null) {
            return null;
        }
        List arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        for (ShareMedia shareMedia : media) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(uuid, shareMedia);
            if (attachment == null) {
                bundle = null;
            } else {
                arrayList.add(attachment);
                bundle = new Bundle();
                bundle.putString("type", shareMedia.getMediaType().name());
                bundle.putString("uri", attachment.getAttachmentUrl());
            }
            if (bundle != null) {
                arrayList2.add(bundle);
            }
        }
        List<Bundle> list = (List) arrayList2;
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return list;
    }

    @JvmStatic
    public static final Bundle getTextureUrlBundle(ShareCameraEffectContent shareCameraEffectContent, UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "appCallId");
        CameraEffectTextures textures = shareCameraEffectContent == null ? null : shareCameraEffectContent.getTextures();
        if (textures == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        List arrayList = new ArrayList();
        for (String next : textures.keySet()) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(uuid, textures.getTextureUri(next), textures.getTextureBitmap(next));
            if (attachment != null) {
                arrayList.add(attachment);
                bundle.putString(next, attachment.getAttachmentUrl());
            }
        }
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return bundle;
    }

    @JvmStatic
    public static final JSONArray removeNamespacesFromOGJsonArray(JSONArray jSONArray, boolean z) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                Object obj = jSONArray.get(i);
                if (obj instanceof JSONArray) {
                    obj = removeNamespacesFromOGJsonArray((JSONArray) obj, z);
                } else if (obj instanceof JSONObject) {
                    obj = removeNamespacesFromOGJsonObject((JSONObject) obj, z);
                }
                jSONArray2.put(obj);
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return jSONArray2;
    }

    @JvmStatic
    public static final JSONObject removeNamespacesFromOGJsonObject(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            JSONObject jSONObject2 = null;
            return null;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            JSONArray names = jSONObject.names();
            if (names == null) {
                return null;
            }
            int i = 0;
            int length = names.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    String string = names.getString(i);
                    Object obj = jSONObject.get(string);
                    if (obj instanceof JSONObject) {
                        obj = removeNamespacesFromOGJsonObject((JSONObject) obj, true);
                    } else if (obj instanceof JSONArray) {
                        obj = removeNamespacesFromOGJsonArray((JSONArray) obj, true);
                    }
                    Intrinsics.checkNotNullExpressionValue(string, "key");
                    Pair<String, String> fieldNameAndNamespaceFromFullName = getFieldNameAndNamespaceFromFullName(string);
                    String str = (String) fieldNameAndNamespaceFromFullName.first;
                    String str2 = (String) fieldNameAndNamespaceFromFullName.second;
                    if (z) {
                        if (str == null || !Intrinsics.areEqual((Object) str, (Object) DeviceRequestsHelper.SDK_HEADER)) {
                            if (str != null) {
                                if (!Intrinsics.areEqual((Object) str, (Object) "og")) {
                                    jSONObject4.put(str2, obj);
                                }
                            }
                            jSONObject3.put(str2, obj);
                        } else {
                            jSONObject3.put(string, obj);
                        }
                    } else if (str == null || !Intrinsics.areEqual((Object) str, (Object) "fb")) {
                        jSONObject3.put(str2, obj);
                    } else {
                        jSONObject3.put(string, obj);
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            if (jSONObject4.length() > 0) {
                jSONObject3.put("data", (Object) jSONObject4);
            }
            return jSONObject3;
        } catch (JSONException unused) {
            throw new FacebookException("Failed to create json object from share content");
        }
    }

    @JvmStatic
    public static final Pair<String, String> getFieldNameAndNamespaceFromFullName(String str) {
        String str2;
        int i;
        Intrinsics.checkNotNullParameter(str, "fullName");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, ':', 0, false, 6, (Object) null);
        if (indexOf$default == -1 || str.length() <= (i = indexOf$default + 1)) {
            str2 = null;
        } else {
            str2 = str.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            str = str.substring(i);
            Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).substring(startIndex)");
        }
        return new Pair<>(str2, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.graphics.Bitmap] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.facebook.internal.NativeAppCallAttachmentStore.Attachment getAttachment(java.util.UUID r4, com.facebook.share.model.ShareMedia<?, ?> r5) {
        /*
            r3 = this;
            boolean r0 = r5 instanceof com.facebook.share.model.SharePhoto
            r1 = 0
            if (r0 == 0) goto L_0x0013
            com.facebook.share.model.SharePhoto r5 = (com.facebook.share.model.SharePhoto) r5
            android.graphics.Bitmap r1 = r5.getBitmap()
            android.net.Uri r5 = r5.getImageUrl()
        L_0x000f:
            r2 = r1
            r1 = r5
            r5 = r2
            goto L_0x001f
        L_0x0013:
            boolean r0 = r5 instanceof com.facebook.share.model.ShareVideo
            if (r0 == 0) goto L_0x001e
            com.facebook.share.model.ShareVideo r5 = (com.facebook.share.model.ShareVideo) r5
            android.net.Uri r5 = r5.getLocalUrl()
            goto L_0x000f
        L_0x001e:
            r5 = r1
        L_0x001f:
            com.facebook.internal.NativeAppCallAttachmentStore$Attachment r4 = r3.getAttachment(r4, r1, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.ShareInternalUtility.getAttachment(java.util.UUID, com.facebook.share.model.ShareMedia):com.facebook.internal.NativeAppCallAttachmentStore$Attachment");
    }

    private final NativeAppCallAttachmentStore.Attachment getAttachment(UUID uuid, Uri uri, Bitmap bitmap) {
        if (bitmap != null) {
            NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
            return NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
        } else if (uri == null) {
            return null;
        } else {
            NativeAppCallAttachmentStore nativeAppCallAttachmentStore2 = NativeAppCallAttachmentStore.INSTANCE;
            return NativeAppCallAttachmentStore.createAttachment(uuid, uri);
        }
    }

    @JvmStatic
    public static final void invokeOnCancelCallback(FacebookCallback<Sharer.Result> facebookCallback) {
        INSTANCE.logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, (String) null);
        if (facebookCallback != null) {
            facebookCallback.onCancel();
        }
    }

    @JvmStatic
    public static final void invokeOnSuccessCallback(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        INSTANCE.logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED, (String) null);
        if (facebookCallback != null) {
            facebookCallback.onSuccess(new Sharer.Result(str));
        }
    }

    @JvmStatic
    public static final void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, GraphResponse graphResponse, String str) {
        INSTANCE.logShareResult("error", str);
        if (facebookCallback != null) {
            facebookCallback.onError(new FacebookGraphResponseException(graphResponse, str));
        }
    }

    @JvmStatic
    public static final void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        INSTANCE.logShareResult("error", str);
        if (facebookCallback != null) {
            facebookCallback.onError(new FacebookException(str));
        }
    }

    @JvmStatic
    public static final void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(facebookException, "ex");
        INSTANCE.logShareResult("error", facebookException.getMessage());
        if (facebookCallback != null) {
            facebookCallback.onError(facebookException);
        }
    }

    private final void logShareResult(String str, String str2) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_OUTCOME, str);
        if (str2 != null) {
            bundle.putString("error_message", str2);
        }
        internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_SHARE_RESULT, bundle);
    }

    @JvmStatic
    public static final GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Bitmap bitmap, GraphRequest.Callback callback) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", bitmap);
        return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, File file, GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, 268435456), ClipboardModule.MIMETYPE_PNG);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", parcelableResourceWithMimeType);
        return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Uri uri, GraphRequest.Callback callback) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(uri, "imageUri");
        String path = uri.getPath();
        Utility utility = Utility.INSTANCE;
        if (Utility.isFileUri(uri) && path != null) {
            return newUploadStagingResourceWithImageRequest(accessToken, new File(path), callback);
        }
        Utility utility2 = Utility.INSTANCE;
        if (Utility.isContentUri(uri)) {
            GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(uri, ClipboardModule.MIMETYPE_PNG);
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("file", parcelableResourceWithMimeType);
            return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
        }
        throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
    }

    @JvmStatic
    public static final Bundle getStickerUrl(ShareStoryContent shareStoryContent, UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "appCallId");
        if (shareStoryContent == null || shareStoryContent.getStickerAsset() == null) {
            return null;
        }
        new ArrayList().add(shareStoryContent.getStickerAsset());
        NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(uuid, shareStoryContent.getStickerAsset());
        if (attachment == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("uri", attachment.getAttachmentUrl());
        String uriExtension = getUriExtension(attachment.getOriginalUri());
        if (uriExtension != null) {
            Utility utility = Utility.INSTANCE;
            Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
        }
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
        NativeAppCallAttachmentStore.addAttachments(CollectionsKt.listOf(attachment));
        return bundle;
    }

    @JvmStatic
    public static final Bundle getBackgroundAssetMediaInfo(ShareStoryContent shareStoryContent, UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "appCallId");
        Bundle bundle = null;
        if (!(shareStoryContent == null || shareStoryContent.getBackgroundAsset() == null)) {
            ShareMedia<?, ?> backgroundAsset = shareStoryContent.getBackgroundAsset();
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(uuid, backgroundAsset);
            if (attachment == null) {
                return null;
            }
            bundle = new Bundle();
            bundle.putString("type", backgroundAsset.getMediaType().name());
            bundle.putString("uri", attachment.getAttachmentUrl());
            String uriExtension = getUriExtension(attachment.getOriginalUri());
            if (uriExtension != null) {
                Utility utility = Utility.INSTANCE;
                Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
            }
            NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
            NativeAppCallAttachmentStore.addAttachments(CollectionsKt.listOf(attachment));
        }
        return bundle;
    }

    @JvmStatic
    public static final String getUriExtension(Uri uri) {
        if (uri == null) {
            return null;
        }
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) uri2, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            String str = null;
            return null;
        }
        String substring = uri2.substring(lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }
}

package com.braze.ui.inappmessage.utils;

import android.content.Context;
import com.braze.Braze;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.enums.BrazeViewBounds;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageWithImage;
import com.braze.models.inappmessage.IInAppMessageZippedAssetHtml;
import com.braze.models.inappmessage.InAppMessageFull;
import com.braze.models.inappmessage.InAppMessageHtml;
import com.braze.support.BrazeLogger;
import com.braze.support.WebContentUtils;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J8\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\tH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0006H\u0007J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/braze/ui/inappmessage/utils/BackgroundInAppMessagePreparer;", "", "()V", "displayPreparedInAppMessage", "", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "(Lcom/braze/models/inappmessage/IInAppMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getViewBoundsByType", "Lcom/braze/enums/BrazeViewBounds;", "handleLocalImage", "", "localImageUrl", "", "inAppMessageWithImage", "Lcom/braze/models/inappmessage/IInAppMessageWithImage;", "imageLoader", "Lcom/braze/images/IBrazeImageLoader;", "applicationContext", "Landroid/content/Context;", "viewBounds", "prepareInAppMessage", "inAppMessageToPrepare", "prepareInAppMessageForDisplay", "prepareInAppMessageWithBitmapDownload", "prepareInAppMessageWithHtml", "Lcom/braze/models/inappmessage/InAppMessageHtml;", "prepareInAppMessageWithZippedAssetHtml", "inAppMessageHtml", "Lcom/braze/models/inappmessage/IInAppMessageZippedAssetHtml;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackgroundInAppMessagePreparer.kt */
public final class BackgroundInAppMessagePreparer {
    public static final BackgroundInAppMessagePreparer INSTANCE = new BackgroundInAppMessagePreparer();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BackgroundInAppMessagePreparer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.braze.enums.inappmessage.MessageType[] r0 = com.braze.enums.inappmessage.MessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.HTML_FULL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.HTML     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.SLIDEUP     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.MODAL     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer.WhenMappings.<clinit>():void");
        }
    }

    private BackgroundInAppMessagePreparer() {
    }

    @JvmStatic
    public static final void prepareInAppMessageForDisplay(IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessageToPrepare");
        Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new BackgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1(iInAppMessage, (Continuation<? super BackgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final IInAppMessage prepareInAppMessage(IInAppMessage iInAppMessage) {
        IInAppMessage iInAppMessage2 = iInAppMessage;
        if (iInAppMessage.isControl()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessage$1.INSTANCE, 3, (Object) null);
            return iInAppMessage2;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessage$2.INSTANCE, 3, (Object) null);
        int i = WhenMappings.$EnumSwitchMapping$0[iInAppMessage.getMessageType().ordinal()];
        if (i == 1) {
            Intrinsics.checkNotNull(iInAppMessage2, "null cannot be cast to non-null type com.braze.models.inappmessage.IInAppMessageZippedAssetHtml");
            if (!prepareInAppMessageWithZippedAssetHtml((IInAppMessageZippedAssetHtml) iInAppMessage2)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessage$3.INSTANCE, 2, (Object) null);
                return null;
            }
        } else if (i == 2) {
            Intrinsics.checkNotNull(iInAppMessage2, "null cannot be cast to non-null type com.braze.models.inappmessage.InAppMessageHtml");
            prepareInAppMessageWithHtml((InAppMessageHtml) iInAppMessage2);
        } else if (!prepareInAppMessageWithBitmapDownload(iInAppMessage)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessage$4.INSTANCE, 2, (Object) null);
            return null;
        }
        return iInAppMessage2;
    }

    @JvmStatic
    public static final boolean prepareInAppMessageWithZippedAssetHtml(IInAppMessageZippedAssetHtml iInAppMessageZippedAssetHtml) {
        IInAppMessageZippedAssetHtml iInAppMessageZippedAssetHtml2 = iInAppMessageZippedAssetHtml;
        Intrinsics.checkNotNullParameter(iInAppMessageZippedAssetHtml2, "inAppMessageHtml");
        String localAssetsDirectoryUrl = iInAppMessageZippedAssetHtml.getLocalAssetsDirectoryUrl();
        CharSequence charSequence = localAssetsDirectoryUrl;
        if ((charSequence == null || StringsKt.isBlank(charSequence)) || !new File(localAssetsDirectoryUrl).exists()) {
            String assetsZipRemoteUrl = iInAppMessageZippedAssetHtml.getAssetsZipRemoteUrl();
            CharSequence charSequence2 = assetsZipRemoteUrl;
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.I, (Throwable) null, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$2.INSTANCE, 2, (Object) null);
                return true;
            }
            Context applicationContext = BrazeInAppMessageManager.Companion.getInstance().getApplicationContext();
            if (applicationContext == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$3.INSTANCE, 2, (Object) null);
                return false;
            }
            String localHtmlUrlFromRemoteUrl = WebContentUtils.getLocalHtmlUrlFromRemoteUrl(WebContentUtils.getHtmlInAppMessageAssetCacheDirectory(applicationContext), assetsZipRemoteUrl);
            CharSequence charSequence3 = localHtmlUrlFromRemoteUrl;
            if (!(charSequence3 == null || StringsKt.isBlank(charSequence3))) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$4(localHtmlUrlFromRemoteUrl), 3, (Object) null);
                iInAppMessageZippedAssetHtml2.setLocalAssetsDirectoryUrl(localHtmlUrlFromRemoteUrl);
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) new BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$5(iInAppMessageZippedAssetHtml2, localHtmlUrlFromRemoteUrl), 2, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.I, (Throwable) null, (Function0) new BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$1(localAssetsDirectoryUrl), 2, (Object) null);
        return true;
    }

    @JvmStatic
    public static final boolean prepareInAppMessageWithBitmapDownload(IInAppMessage iInAppMessage) {
        IInAppMessage iInAppMessage2 = iInAppMessage;
        if (!(iInAppMessage2 instanceof IInAppMessageWithImage)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$1.INSTANCE, 3, (Object) null);
            return false;
        }
        IInAppMessageWithImage iInAppMessageWithImage = (IInAppMessageWithImage) iInAppMessage2;
        if (iInAppMessageWithImage.getBitmap() != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.I, (Throwable) null, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$2.INSTANCE, 2, (Object) null);
            iInAppMessageWithImage.setImageDownloadSuccessful(true);
            return true;
        }
        BackgroundInAppMessagePreparer backgroundInAppMessagePreparer = INSTANCE;
        BrazeViewBounds viewBoundsByType = backgroundInAppMessagePreparer.getViewBoundsByType(iInAppMessage2);
        Context applicationContext = BrazeInAppMessageManager.Companion.getInstance().getApplicationContext();
        if (applicationContext == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) backgroundInAppMessagePreparer, BrazeLogger.Priority.W, (Throwable) null, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$3.INSTANCE, 2, (Object) null);
            return false;
        }
        IBrazeImageLoader imageLoader = Braze.Companion.getInstance(applicationContext).getImageLoader();
        String localImageUrl = iInAppMessageWithImage.getLocalImageUrl();
        CharSequence charSequence = localImageUrl;
        if (!(charSequence == null || StringsKt.isBlank(charSequence)) && backgroundInAppMessagePreparer.handleLocalImage(localImageUrl, iInAppMessageWithImage, imageLoader, applicationContext, iInAppMessage, viewBoundsByType)) {
            return true;
        }
        String remoteImageUrl = iInAppMessageWithImage.getRemoteImageUrl();
        CharSequence charSequence2 = remoteImageUrl;
        if (!(charSequence2 == null || StringsKt.isBlank(charSequence2))) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) backgroundInAppMessagePreparer, BrazeLogger.Priority.I, (Throwable) null, (Function0) new BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$4(remoteImageUrl), 2, (Object) null);
            iInAppMessageWithImage.setBitmap(imageLoader.getInAppMessageBitmapFromUrl(applicationContext, iInAppMessage2, remoteImageUrl, viewBoundsByType));
            if (iInAppMessageWithImage.getBitmap() == null) {
                return false;
            }
            iInAppMessageWithImage.setImageDownloadSuccessful(true);
            return true;
        }
        BackgroundInAppMessagePreparer backgroundInAppMessagePreparer2 = backgroundInAppMessagePreparer;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) backgroundInAppMessagePreparer, BrazeLogger.Priority.W, (Throwable) null, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$5.INSTANCE, 2, (Object) null);
        if (!(iInAppMessageWithImage instanceof InAppMessageFull)) {
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) backgroundInAppMessagePreparer2, BrazeLogger.Priority.W, (Throwable) null, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$6.INSTANCE, 2, (Object) null);
        return false;
    }

    private final boolean handleLocalImage(String str, IInAppMessageWithImage iInAppMessageWithImage, IBrazeImageLoader iBrazeImageLoader, Context context, IInAppMessage iInAppMessage, BrazeViewBounds brazeViewBounds) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new BackgroundInAppMessagePreparer$handleLocalImage$1(str), 2, (Object) null);
        iInAppMessageWithImage.setBitmap(iBrazeImageLoader.getInAppMessageBitmapFromUrl(context, iInAppMessage, str, brazeViewBounds));
        if (iInAppMessageWithImage.getBitmap() != null) {
            iInAppMessageWithImage.setImageDownloadSuccessful(true);
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BackgroundInAppMessagePreparer$handleLocalImage$2(str), 3, (Object) null);
        iInAppMessageWithImage.setLocalImageUrl((String) null);
        return false;
    }

    public final void prepareInAppMessageWithHtml(InAppMessageHtml inAppMessageHtml) {
        Intrinsics.checkNotNullParameter(inAppMessageHtml, "inAppMessage");
        if (inAppMessageHtml.getLocalPrefetchedAssetPaths().isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithHtml$1.INSTANCE, 3, (Object) null);
            return;
        }
        String message = inAppMessageHtml.getMessage();
        if (message == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithHtml$2.INSTANCE, 3, (Object) null);
            return;
        }
        inAppMessageHtml.setMessage(WebContentUtils.replacePrefetchedUrlsWithLocalAssets(message, inAppMessageHtml.getLocalPrefetchedAssetPaths()));
    }

    private final BrazeViewBounds getViewBoundsByType(IInAppMessage iInAppMessage) {
        int i = WhenMappings.$EnumSwitchMapping$0[iInAppMessage.getMessageType().ordinal()];
        if (i == 3) {
            return BrazeViewBounds.IN_APP_MESSAGE_SLIDEUP;
        }
        if (i != 4) {
            return BrazeViewBounds.NO_BOUNDS;
        }
        return BrazeViewBounds.IN_APP_MESSAGE_MODAL;
    }

    /* access modifiers changed from: private */
    public final Object displayPreparedInAppMessage(IInAppMessage iInAppMessage, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2(this, iInAppMessage, (Continuation<? super BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}

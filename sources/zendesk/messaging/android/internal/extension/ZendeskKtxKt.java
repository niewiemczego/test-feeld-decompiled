package zendesk.messaging.android.internal.extension;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.Zendesk;
import zendesk.android.ZendeskCredentials;
import zendesk.android.messaging.Messaging;
import zendesk.android.messaging.MessagingFactory;
import zendesk.messaging.android.DefaultMessagingFactory;
import zendesk.messaging.android.internal.DefaultMessaging;
import zendesk.messaging.android.internal.di.MessagingComponent;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a;\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u0004H\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"messaging", "Lzendesk/android/ZendeskResult;", "Lzendesk/android/messaging/Messaging;", "", "Lzendesk/android/Zendesk$Companion;", "context", "Landroid/content/Context;", "credentials", "Lzendesk/android/ZendeskCredentials;", "messagingFactory", "Lzendesk/android/messaging/MessagingFactory;", "(Lzendesk/android/Zendesk$Companion;Landroid/content/Context;Lzendesk/android/ZendeskCredentials;Lzendesk/android/messaging/MessagingFactory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messagingComponent", "Lzendesk/messaging/android/internal/di/MessagingComponent;", "zendesk.messaging_messaging-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ZendeskKtx.kt */
public final class ZendeskKtxKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object messaging(zendesk.android.Zendesk.Companion r4, android.content.Context r5, zendesk.android.ZendeskCredentials r6, zendesk.android.messaging.MessagingFactory r7, kotlin.coroutines.Continuation<? super zendesk.android.ZendeskResult<? extends zendesk.android.messaging.Messaging, ? extends java.lang.Throwable>> r8) {
        /*
            boolean r0 = r8 instanceof zendesk.messaging.android.internal.extension.ZendeskKtxKt$messaging$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            zendesk.messaging.android.internal.extension.ZendeskKtxKt$messaging$1 r0 = (zendesk.messaging.android.internal.extension.ZendeskKtxKt$messaging$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            zendesk.messaging.android.internal.extension.ZendeskKtxKt$messaging$1 r0 = new zendesk.messaging.android.internal.extension.ZendeskKtxKt$messaging$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0042
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r6 = r6.getChannelKey()
            r0.label = r3
            java.lang.Object r8 = r4.initialize((android.content.Context) r5, (java.lang.String) r6, (zendesk.android.messaging.MessagingFactory) r7, (kotlin.coroutines.Continuation) r0)
            if (r8 != r1) goto L_0x0042
            return r1
        L_0x0042:
            zendesk.android.ZendeskResult r8 = (zendesk.android.ZendeskResult) r8
            boolean r4 = r8 instanceof zendesk.android.ZendeskResult.Failure
            if (r4 == 0) goto L_0x005d
            zendesk.android.ZendeskResult$Failure r4 = new zendesk.android.ZendeskResult$Failure
            zendesk.android.internal.ZendeskError$FailedToInitialize r5 = new zendesk.android.internal.ZendeskError$FailedToInitialize
            zendesk.android.ZendeskResult$Failure r8 = (zendesk.android.ZendeskResult.Failure) r8
            java.lang.Object r6 = r8.getError()
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r5.<init>(r6)
            r4.<init>(r5)
            zendesk.android.ZendeskResult r4 = (zendesk.android.ZendeskResult) r4
            goto L_0x0074
        L_0x005d:
            boolean r4 = r8 instanceof zendesk.android.ZendeskResult.Success
            if (r4 == 0) goto L_0x0075
            zendesk.android.ZendeskResult$Success r4 = new zendesk.android.ZendeskResult$Success
            zendesk.android.ZendeskResult$Success r8 = (zendesk.android.ZendeskResult.Success) r8
            java.lang.Object r5 = r8.getValue()
            zendesk.android.Zendesk r5 = (zendesk.android.Zendesk) r5
            zendesk.android.messaging.Messaging r5 = r5.getMessaging()
            r4.<init>(r5)
            zendesk.android.ZendeskResult r4 = (zendesk.android.ZendeskResult) r4
        L_0x0074:
            return r4
        L_0x0075:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.extension.ZendeskKtxKt.messaging(zendesk.android.Zendesk$Companion, android.content.Context, zendesk.android.ZendeskCredentials, zendesk.android.messaging.MessagingFactory, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object messaging$default(Zendesk.Companion companion, Context context, ZendeskCredentials zendeskCredentials, MessagingFactory messagingFactory, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            messagingFactory = new DefaultMessagingFactory();
        }
        return messaging(companion, context, zendeskCredentials, messagingFactory, continuation);
    }

    public static final MessagingComponent messagingComponent(Zendesk.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Messaging messaging = companion.getInstance().getMessaging();
        DefaultMessaging defaultMessaging = messaging instanceof DefaultMessaging ? (DefaultMessaging) messaging : null;
        if (defaultMessaging != null) {
            return defaultMessaging.getMessagingComponent$zendesk_messaging_messaging_android();
        }
        return null;
    }
}

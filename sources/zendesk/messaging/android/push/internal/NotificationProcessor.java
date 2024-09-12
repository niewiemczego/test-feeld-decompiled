package zendesk.messaging.android.push.internal;

import android.app.Notification;
import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.Person;
import coil.transform.Transformation;
import com.squareup.moshi.Moshi;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J5\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J8\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u0007J?\u0010\u0019\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ1\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H@ø\u0001\u0000¢\u0006\u0002\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lzendesk/messaging/android/push/internal/NotificationProcessor;", "", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "people", "", "", "Landroidx/core/app/Person;", "createPerson", "context", "Landroid/content/Context;", "authorId", "", "authorName", "avatarUrl", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayLocalNotification", "", "notificationId", "title", "body", "notificationBuilder", "Lzendesk/messaging/android/push/internal/NotificationBuilder;", "smallIconId", "displayPushNotification", "messageData", "", "(Landroid/content/Context;Ljava/util/Map;Lzendesk/messaging/android/push/internal/NotificationBuilder;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBitmapImage", "Landroid/graphics/Bitmap;", "url", "imageTransformation", "Lcoil/transform/Transformation;", "(Landroid/content/Context;Ljava/lang/String;Lcoil/transform/Transformation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotificationProcessor.kt */
public final class NotificationProcessor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "NotificationProcessor";
    private final Moshi moshi;
    private final Map<Integer, Person> people;

    public NotificationProcessor() {
        this((Moshi) null, 1, (DefaultConstructorMarker) null);
    }

    public NotificationProcessor(Moshi moshi2) {
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.moshi = moshi2;
        this.people = new LinkedHashMap();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ NotificationProcessor(com.squareup.moshi.Moshi r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x0012
            com.squareup.moshi.Moshi$Builder r1 = new com.squareup.moshi.Moshi$Builder
            r1.<init>()
            com.squareup.moshi.Moshi r1 = r1.build()
            java.lang.String r2 = "Builder().build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x0012:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.push.internal.NotificationProcessor.<init>(com.squareup.moshi.Moshi, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object displayPushNotification(android.content.Context r11, java.util.Map<java.lang.String, java.lang.String> r12, zendesk.messaging.android.push.internal.NotificationBuilder r13, int r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof zendesk.messaging.android.push.internal.NotificationProcessor$displayPushNotification$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            zendesk.messaging.android.push.internal.NotificationProcessor$displayPushNotification$1 r0 = (zendesk.messaging.android.push.internal.NotificationProcessor$displayPushNotification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            zendesk.messaging.android.push.internal.NotificationProcessor$displayPushNotification$1 r0 = new zendesk.messaging.android.push.internal.NotificationProcessor$displayPushNotification$1
            r0.<init>(r10, r15)
        L_0x0019:
            r6 = r0
            java.lang.Object r15 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            java.lang.String r7 = "NotificationProcessor"
            r8 = 1
            r9 = 0
            if (r1 == 0) goto L_0x0049
            if (r1 != r8) goto L_0x0041
            int r14 = r6.I$0
            java.lang.Object r11 = r6.L$3
            zendesk.messaging.android.push.internal.MessagePayload r11 = (zendesk.messaging.android.push.internal.MessagePayload) r11
            java.lang.Object r12 = r6.L$2
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r6.L$1
            zendesk.messaging.android.push.internal.NotificationBuilder r13 = (zendesk.messaging.android.push.internal.NotificationBuilder) r13
            java.lang.Object r0 = r6.L$0
            android.content.Context r0 = (android.content.Context) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00b1
        L_0x0041:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.String r15 = "conversationId"
            java.lang.Object r15 = r12.get(r15)
            java.lang.String r15 = (java.lang.String) r15
            if (r15 != 0) goto L_0x0063
            r11 = r10
            zendesk.messaging.android.push.internal.NotificationProcessor r11 = (zendesk.messaging.android.push.internal.NotificationProcessor) r11
            java.lang.Object[] r11 = new java.lang.Object[r9]
            java.lang.String r12 = "Unable to parse the received notification payload without a conversation id."
            zendesk.logger.Logger.w(r7, r12, r11)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0063:
            java.lang.String r1 = "message"
            java.lang.Object r12 = r12.get(r1)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x0127 }
            if (r12 == 0) goto L_0x007c
            com.squareup.moshi.Moshi r1 = r10.moshi     // Catch:{ Exception -> 0x0127 }
            java.lang.Class<zendesk.messaging.android.push.internal.MessagePayload> r2 = zendesk.messaging.android.push.internal.MessagePayload.class
            com.squareup.moshi.JsonAdapter r1 = r1.adapter(r2)     // Catch:{ Exception -> 0x0127 }
            java.lang.Object r12 = r1.fromJson((java.lang.String) r12)     // Catch:{ Exception -> 0x0127 }
            zendesk.messaging.android.push.internal.MessagePayload r12 = (zendesk.messaging.android.push.internal.MessagePayload) r12     // Catch:{ Exception -> 0x0127 }
            goto L_0x007d
        L_0x007c:
            r12 = 0
        L_0x007d:
            if (r12 != 0) goto L_0x008c
            r11 = r10
            zendesk.messaging.android.push.internal.NotificationProcessor r11 = (zendesk.messaging.android.push.internal.NotificationProcessor) r11
            java.lang.Object[] r11 = new java.lang.Object[r9]
            java.lang.String r12 = "Unable to parse the received notification payload without a message."
            zendesk.logger.Logger.w(r7, r12, r11)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x008c:
            java.lang.String r3 = r12.getAuthorId()
            java.lang.String r4 = r12.getName()
            java.lang.String r5 = r12.getAvatarUrl()
            r6.L$0 = r11
            r6.L$1 = r13
            r6.L$2 = r15
            r6.L$3 = r12
            r6.I$0 = r14
            r6.label = r8
            r1 = r10
            r2 = r11
            java.lang.Object r1 = r1.createPerson(r2, r3, r4, r5, r6)
            if (r1 != r0) goto L_0x00ad
            return r0
        L_0x00ad:
            r0 = r11
            r11 = r12
            r12 = r15
            r15 = r1
        L_0x00b1:
            androidx.core.app.Person r15 = (androidx.core.app.Person) r15
            java.lang.String r1 = r11.getText()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x00c4
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00c2
            goto L_0x00c4
        L_0x00c2:
            r1 = r9
            goto L_0x00c5
        L_0x00c4:
            r1 = r8
        L_0x00c5:
            if (r1 != 0) goto L_0x00cc
            java.lang.String r1 = r11.getText()
            goto L_0x00d7
        L_0x00cc:
            int r1 = zendesk.messaging.R.string.zma_notification_default_text
            java.lang.String r1 = r0.getString(r1)
            java.lang.String r2 = "{\n            context.ge…n_default_text)\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x00d7:
            double r2 = r11.getReceived()
            r11 = 1000(0x3e8, float:1.401E-42)
            double r4 = (double) r11
            double r2 = r2 * r4
            long r2 = (long) r2
            zendesk.messaging.android.push.internal.NotificationBuilder r11 = r13.setMessagingStyle(r1, r2, r15)
            zendesk.messaging.android.push.internal.NotificationBuilder r11 = r11.setSmallIcon(r14)
            java.lang.String r13 = "msg"
            zendesk.messaging.android.push.internal.NotificationBuilder r11 = r11.setCategory(r13)
            zendesk.messaging.android.push.internal.NotificationBuilder r11 = r11.setAutoCancel(r8)
            java.lang.Object[] r13 = new java.lang.Object[r8]
            r13[r9] = r12
            int r13 = java.util.Objects.hash(r13)
            zendesk.messaging.android.push.internal.NotificationBuilder r11 = r11.setOpenNotificationIntent(r13)
            android.app.Notification r11 = r11.build()
            androidx.core.app.NotificationManagerCompat r13 = androidx.core.app.NotificationManagerCompat.from(r0)
            java.lang.String r14 = "from(context)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            boolean r14 = r13.areNotificationsEnabled()
            if (r14 == 0) goto L_0x011d
            java.lang.Object[] r14 = new java.lang.Object[r8]
            r14[r9] = r12
            int r12 = java.util.Objects.hash(r14)
            r13.notify(r12, r11)
            goto L_0x0124
        L_0x011d:
            java.lang.Object[] r11 = new java.lang.Object[r9]
            java.lang.String r12 = "Cannot display notification because the notification permission is not granted"
            zendesk.logger.Logger.w(r7, r12, r11)
        L_0x0124:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0127:
            r11 = move-exception
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            java.lang.Object[] r12 = new java.lang.Object[r9]
            java.lang.String r13 = "Unable to parse the received notification payload."
            zendesk.logger.Logger.e(r7, r13, r11, r12)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.push.internal.NotificationProcessor.displayPushNotification(android.content.Context, java.util.Map, zendesk.messaging.android.push.internal.NotificationBuilder, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createPerson(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation<? super androidx.core.app.Person> r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof zendesk.messaging.android.push.internal.NotificationProcessor$createPerson$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            zendesk.messaging.android.push.internal.NotificationProcessor$createPerson$1 r0 = (zendesk.messaging.android.push.internal.NotificationProcessor$createPerson$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            zendesk.messaging.android.push.internal.NotificationProcessor$createPerson$1 r0 = new zendesk.messaging.android.push.internal.NotificationProcessor$createPerson$1
            r0.<init>(r4, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$2
            androidx.core.app.Person$Builder r6 = (androidx.core.app.Person.Builder) r6
            java.lang.Object r7 = r0.L$1
            androidx.core.app.Person$Builder r7 = (androidx.core.app.Person.Builder) r7
            java.lang.Object r8 = r0.L$0
            zendesk.messaging.android.push.internal.NotificationProcessor r8 = (zendesk.messaging.android.push.internal.NotificationProcessor) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0087
        L_0x0038:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = 3
            java.lang.Object[] r9 = new java.lang.Object[r9]
            r2 = 0
            r9[r2] = r6
            r9[r3] = r7
            r6 = 2
            r9[r6] = r8
            int r6 = java.util.Objects.hash(r9)
            java.util.Map<java.lang.Integer, androidx.core.app.Person> r9 = r4.people
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            java.lang.Object r9 = r9.get(r2)
            androidx.core.app.Person r9 = (androidx.core.app.Person) r9
            if (r9 == 0) goto L_0x0061
            return r9
        L_0x0061:
            androidx.core.app.Person$Builder r9 = new androidx.core.app.Person$Builder
            r9.<init>()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            androidx.core.app.Person$Builder r7 = r9.setName(r7)
            coil.transform.CircleCropTransformation r9 = new coil.transform.CircleCropTransformation
            r9.<init>()
            coil.transform.Transformation r9 = (coil.transform.Transformation) r9
            r0.L$0 = r4
            r0.L$1 = r7
            r0.L$2 = r7
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r9 = r4.loadBitmapImage(r5, r8, r9, r0)
            if (r9 != r1) goto L_0x0084
            return r1
        L_0x0084:
            r8 = r4
            r5 = r6
            r6 = r7
        L_0x0087:
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            if (r9 == 0) goto L_0x0092
            androidx.core.graphics.drawable.IconCompat r9 = androidx.core.graphics.drawable.IconCompat.createWithBitmap(r9)
            r6.setIcon(r9)
        L_0x0092:
            androidx.core.app.Person r6 = r7.build()
            java.lang.String r7 = "Builder()\n            .s…   }\n            .build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            java.util.Map<java.lang.Integer, androidx.core.app.Person> r7 = r8.people
            r7.put(r5, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.push.internal.NotificationProcessor.createPerson(android.content.Context, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loadBitmapImage(android.content.Context r7, java.lang.String r8, coil.transform.Transformation r9, kotlin.coroutines.Continuation<? super android.graphics.Bitmap> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof zendesk.messaging.android.push.internal.NotificationProcessor$loadBitmapImage$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            zendesk.messaging.android.push.internal.NotificationProcessor$loadBitmapImage$1 r0 = (zendesk.messaging.android.push.internal.NotificationProcessor$loadBitmapImage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            zendesk.messaging.android.push.internal.NotificationProcessor$loadBitmapImage$1 r0 = new zendesk.messaging.android.push.internal.NotificationProcessor$loadBitmapImage$1
            r0.<init>(r6, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r5) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0072
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            if (r10 == 0) goto L_0x0045
            int r10 = r10.length()
            if (r10 != 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r10 = r4
            goto L_0x0046
        L_0x0045:
            r10 = r5
        L_0x0046:
            if (r10 == 0) goto L_0x0049
            return r3
        L_0x0049:
            zendesk.ui.android.internal.ImageLoaderFactory r10 = zendesk.ui.android.internal.ImageLoaderFactory.INSTANCE
            coil.ImageLoader r10 = r10.getImageLoader(r7)
            coil.request.ImageRequest$Builder r2 = new coil.request.ImageRequest$Builder
            r2.<init>((android.content.Context) r7)
            coil.request.ImageRequest$Builder r7 = r2.data(r8)
            coil.request.ImageRequest$Builder r7 = r7.allowHardware(r4)
            if (r9 == 0) goto L_0x0065
            coil.transform.Transformation[] r8 = new coil.transform.Transformation[r5]
            r8[r4] = r9
            r7.transformations((coil.transform.Transformation[]) r8)
        L_0x0065:
            coil.request.ImageRequest r7 = r7.build()
            r0.label = r5
            java.lang.Object r10 = r10.execute(r7, r0)
            if (r10 != r1) goto L_0x0072
            return r1
        L_0x0072:
            coil.request.ImageResult r10 = (coil.request.ImageResult) r10
            boolean r7 = r10 instanceof coil.request.SuccessResult
            if (r7 == 0) goto L_0x0085
            coil.request.SuccessResult r10 = (coil.request.SuccessResult) r10
            android.graphics.drawable.Drawable r7 = r10.getDrawable()
            android.graphics.drawable.BitmapDrawable r7 = (android.graphics.drawable.BitmapDrawable) r7
            android.graphics.Bitmap r3 = r7.getBitmap()
            goto L_0x00b0
        L_0x0085:
            boolean r7 = r10 instanceof coil.request.ErrorResult
            if (r7 == 0) goto L_0x00b1
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Unable to load avatar image: "
            java.lang.StringBuilder r7 = r7.append(r8)
            coil.request.ErrorResult r10 = (coil.request.ErrorResult) r10
            java.lang.Throwable r8 = r10.getThrowable()
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r4]
            java.lang.String r9 = "NotificationProcessor"
            zendesk.logger.Logger.w(r9, r7, r8)
            r7 = r3
            android.graphics.Bitmap r7 = (android.graphics.Bitmap) r7
        L_0x00b0:
            return r3
        L_0x00b1:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.push.internal.NotificationProcessor.loadBitmapImage(android.content.Context, java.lang.String, coil.transform.Transformation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object loadBitmapImage$default(NotificationProcessor notificationProcessor, Context context, String str, Transformation transformation, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            transformation = null;
        }
        return notificationProcessor.loadBitmapImage(context, str, transformation, continuation);
    }

    public final void displayLocalNotification(Context context, int i, String str, String str2, NotificationBuilder notificationBuilder, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "body");
        Intrinsics.checkNotNullParameter(notificationBuilder, "notificationBuilder");
        Notification build = notificationBuilder.setTitle(str).setMessage(str2).setSmallIcon(i2).setCategory("msg").setAutoCancel(true).setOpenNotificationIntent(i).build();
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        if (from.areNotificationsEnabled()) {
            from.notify(i, build);
        } else {
            Logger.w(LOG_TAG, "Cannot display notification because the notification permission is not granted", new Object[0]);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/messaging/android/push/internal/NotificationProcessor$Companion;", "", "()V", "LOG_TAG", "", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NotificationProcessor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

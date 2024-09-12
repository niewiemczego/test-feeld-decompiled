package app.notifee.core.model;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.HtmlCompat;
import app.notifee.core.Logger;
import com.braze.models.inappmessage.InAppMessageBase;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import n.o.t.i.f.e.e.l;
import n.o.t.i.f.e.e.n;

public class NotificationAndroidStyleModel {
    private static final String TAG = "NotificationAndroidStyle";
    private Bundle mNotificationAndroidStyleBundle;

    private NotificationAndroidStyleModel(Bundle bundle) {
        this.mNotificationAndroidStyleBundle = bundle;
    }

    public static NotificationAndroidStyleModel fromBundle(Bundle bundle) {
        return new NotificationAndroidStyleModel(bundle);
    }

    private Task<NotificationCompat.Style> getBigPictureStyleTask(Executor executor) {
        return Tasks.call(executor, new NotificationAndroidStyleModel$$ExternalSyntheticLambda2(this));
    }

    private NotificationCompat.BigTextStyle getBigTextStyle() {
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        if (this.mNotificationAndroidStyleBundle.containsKey("text")) {
            bigTextStyle = bigTextStyle.bigText(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("text"), 0));
        }
        if (this.mNotificationAndroidStyleBundle.containsKey("title")) {
            bigTextStyle = bigTextStyle.setBigContentTitle(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("title"), 0));
        }
        return this.mNotificationAndroidStyleBundle.containsKey("summary") ? bigTextStyle.setSummaryText(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("summary"), 0)) : bigTextStyle;
    }

    private NotificationCompat.InboxStyle getInboxStyle() {
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        if (this.mNotificationAndroidStyleBundle.containsKey("title")) {
            inboxStyle = inboxStyle.setBigContentTitle(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("title"), 0));
        }
        if (this.mNotificationAndroidStyleBundle.containsKey("summary")) {
            inboxStyle = inboxStyle.setSummaryText(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("summary"), 0));
        }
        ArrayList<String> stringArrayList = this.mNotificationAndroidStyleBundle.getStringArrayList("lines");
        for (int i = 0; i < ((ArrayList) Objects.requireNonNull(stringArrayList)).size(); i++) {
            inboxStyle = inboxStyle.addLine(HtmlCompat.fromHtml(stringArrayList.get(i), 0));
        }
        return inboxStyle;
    }

    private Task<NotificationCompat.Style> getMessagingStyleTask(Executor executor) {
        return Tasks.call(executor, new NotificationAndroidStyleModel$$ExternalSyntheticLambda1(this, executor));
    }

    private static Task<Person> getPerson(Executor executor, Bundle bundle) {
        return Tasks.call(executor, new NotificationAndroidStyleModel$$ExternalSyntheticLambda0(bundle));
    }

    static /* synthetic */ Person lambda$getPerson$0(Bundle bundle) throws Exception {
        Person.Builder builder = new Person.Builder();
        builder.setName(bundle.getString("name"));
        if (bundle.containsKey("id")) {
            builder.setKey(bundle.getString("id"));
        }
        if (bundle.containsKey("bot")) {
            builder.setBot(bundle.getBoolean("bot"));
        }
        if (bundle.containsKey("important")) {
            builder.setImportant(bundle.getBoolean("important"));
        }
        if (bundle.containsKey(InAppMessageBase.ICON)) {
            String str = (String) Objects.requireNonNull(bundle.getString(InAppMessageBase.ICON));
            Bitmap bitmap = null;
            try {
                bitmap = (Bitmap) Tasks.await(n.a(str), 10, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                Logger.e(TAG, "Timeout occurred whilst trying to retrieve a person icon: " + str, (Exception) e);
            } catch (Exception e2) {
                Logger.e(TAG, "An error occurred whilst trying to retrieve a person icon: " + str, e2);
            }
            if (bitmap != null) {
                builder.setIcon(IconCompat.createWithAdaptiveBitmap(bitmap));
            }
        }
        if (bundle.containsKey("uri")) {
            builder.setUri(bundle.getString("uri"));
        }
        return builder.build();
    }

    public Task<NotificationCompat.Style> getStyleTask(Executor executor) {
        int a = l.a(this.mNotificationAndroidStyleBundle.get("type"));
        if (a == 0) {
            return getBigPictureStyleTask(executor);
        }
        if (a == 1) {
            return Tasks.forResult(getBigTextStyle());
        }
        if (a == 2) {
            return Tasks.forResult(getInboxStyle());
        }
        if (a != 3) {
            return null;
        }
        return getMessagingStyleTask(executor);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007b A[SYNTHETIC, Splitter:B:19:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* renamed from: lambda$getBigPictureStyleTask$1$app-notifee-core-model-NotificationAndroidStyleModel  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.core.app.NotificationCompat.Style m67lambda$getBigPictureStyleTask$1$appnotifeecoremodelNotificationAndroidStyleModel() throws java.lang.Exception {
        /*
            r9 = this;
            androidx.core.app.NotificationCompat$BigPictureStyle r0 = new androidx.core.app.NotificationCompat$BigPictureStyle
            r0.<init>()
            android.os.Bundle r1 = r9.mNotificationAndroidStyleBundle
            java.lang.String r2 = "picture"
            boolean r1 = r1.containsKey(r2)
            r3 = 10
            java.lang.String r5 = "NotificationAndroidStyle"
            r6 = 0
            if (r1 == 0) goto L_0x0062
            android.os.Bundle r1 = r9.mNotificationAndroidStyleBundle
            java.lang.String r1 = r1.getString(r2)
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            com.google.android.gms.tasks.Task r2 = n.o.t.i.f.e.e.n.a(r1)     // Catch:{ TimeoutException -> 0x0045, Exception -> 0x002d }
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ TimeoutException -> 0x0045, Exception -> 0x002d }
            java.lang.Object r2 = com.google.android.gms.tasks.Tasks.await(r2, r3, r7)     // Catch:{ TimeoutException -> 0x0045, Exception -> 0x002d }
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2     // Catch:{ TimeoutException -> 0x0045, Exception -> 0x002d }
            goto L_0x005d
        L_0x002d:
            r2 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "An error occurred whilst trying to retrieve a big picture style image: "
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r1 = r7.append(r1)
            java.lang.String r1 = r1.toString()
            app.notifee.core.Logger.e((java.lang.String) r5, (java.lang.String) r1, (java.lang.Exception) r2)
            goto L_0x005c
        L_0x0045:
            r2 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Timeout occurred whilst trying to retrieve a big picture style image: "
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r1 = r7.append(r1)
            java.lang.String r1 = r1.toString()
            app.notifee.core.Logger.e((java.lang.String) r5, (java.lang.String) r1, (java.lang.Exception) r2)
        L_0x005c:
            r2 = r6
        L_0x005d:
            if (r2 == 0) goto L_0x0062
            r0.bigPicture((android.graphics.Bitmap) r2)
        L_0x0062:
            android.os.Bundle r1 = r9.mNotificationAndroidStyleBundle
            java.lang.String r2 = "largeIcon"
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto L_0x0078
            android.os.Bundle r1 = r9.mNotificationAndroidStyleBundle
            java.lang.String r1 = r1.getString(r2)
            if (r1 != 0) goto L_0x0079
            r0.bigLargeIcon((android.graphics.Bitmap) r6)
            goto L_0x0079
        L_0x0078:
            r1 = r6
        L_0x0079:
            if (r1 == 0) goto L_0x00bd
            com.google.android.gms.tasks.Task r2 = n.o.t.i.f.e.e.n.a(r1)     // Catch:{ TimeoutException -> 0x00a1, Exception -> 0x0089 }
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ TimeoutException -> 0x00a1, Exception -> 0x0089 }
            java.lang.Object r2 = com.google.android.gms.tasks.Tasks.await(r2, r3, r7)     // Catch:{ TimeoutException -> 0x00a1, Exception -> 0x0089 }
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2     // Catch:{ TimeoutException -> 0x00a1, Exception -> 0x0089 }
            r6 = r2
            goto L_0x00b8
        L_0x0089:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "An error occurred whilst trying to retrieve a big picture style large icon: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            app.notifee.core.Logger.e((java.lang.String) r5, (java.lang.String) r1, (java.lang.Exception) r2)
            goto L_0x00b8
        L_0x00a1:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Timeout occurred whilst trying to retrieve a big picture style large icon: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            app.notifee.core.Logger.e((java.lang.String) r5, (java.lang.String) r1, (java.lang.Exception) r2)
        L_0x00b8:
            if (r6 == 0) goto L_0x00bd
            r0.bigLargeIcon((android.graphics.Bitmap) r6)
        L_0x00bd:
            android.os.Bundle r1 = r9.mNotificationAndroidStyleBundle
            java.lang.String r2 = "title"
            boolean r1 = r1.containsKey(r2)
            r3 = 0
            if (r1 == 0) goto L_0x00d6
            android.os.Bundle r1 = r9.mNotificationAndroidStyleBundle
            java.lang.String r1 = r1.getString(r2)
            android.text.Spanned r1 = androidx.core.text.HtmlCompat.fromHtml(r1, r3)
            androidx.core.app.NotificationCompat$BigPictureStyle r0 = r0.setBigContentTitle(r1)
        L_0x00d6:
            android.os.Bundle r1 = r9.mNotificationAndroidStyleBundle
            java.lang.String r2 = "summary"
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto L_0x00ee
            android.os.Bundle r1 = r9.mNotificationAndroidStyleBundle
            java.lang.String r1 = r1.getString(r2)
            android.text.Spanned r1 = androidx.core.text.HtmlCompat.fromHtml(r1, r3)
            androidx.core.app.NotificationCompat$BigPictureStyle r0 = r0.setSummaryText(r1)
        L_0x00ee:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: app.notifee.core.model.NotificationAndroidStyleModel.m67lambda$getBigPictureStyleTask$1$appnotifeecoremodelNotificationAndroidStyleModel():androidx.core.app.NotificationCompat$Style");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getMessagingStyleTask$2$app-notifee-core-model-NotificationAndroidStyleModel  reason: not valid java name */
    public NotificationCompat.Style m68lambda$getMessagingStyleTask$2$appnotifeecoremodelNotificationAndroidStyleModel(Executor executor) throws Exception {
        NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle((Person) Tasks.await(getPerson(executor, (Bundle) Objects.requireNonNull(this.mNotificationAndroidStyleBundle.getBundle("person"))), 20, TimeUnit.SECONDS));
        if (this.mNotificationAndroidStyleBundle.containsKey("title")) {
            messagingStyle = messagingStyle.setConversationTitle(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("title"), 0));
        }
        if (this.mNotificationAndroidStyleBundle.containsKey("group")) {
            messagingStyle = messagingStyle.setGroupConversation(this.mNotificationAndroidStyleBundle.getBoolean("group"));
        }
        ArrayList parcelableArrayList = this.mNotificationAndroidStyleBundle.getParcelableArrayList("messages");
        for (int i = 0; i < ((ArrayList) Objects.requireNonNull(parcelableArrayList)).size(); i++) {
            Bundle bundle = (Bundle) parcelableArrayList.get(i);
            Person person = null;
            long b = l.b(bundle.get("timestamp"));
            if (bundle.containsKey("person")) {
                person = (Person) Tasks.await(getPerson(executor, (Bundle) Objects.requireNonNull(bundle.getBundle("person"))), 20, TimeUnit.SECONDS);
            }
            messagingStyle = messagingStyle.addMessage((CharSequence) HtmlCompat.fromHtml(bundle.getString("text"), 0), b, person);
        }
        return messagingStyle;
    }

    public Bundle toBundle() {
        return (Bundle) this.mNotificationAndroidStyleBundle.clone();
    }
}

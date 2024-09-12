package com.google.android.exoplayer2.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.core.R;
import com.google.android.exoplayer2.offline.Download;
import java.util.List;

public final class DownloadNotificationHelper {
    private static final int NULL_STRING_ID = 0;
    private final NotificationCompat.Builder notificationBuilder;

    public DownloadNotificationHelper(Context context, String str) {
        this.notificationBuilder = new NotificationCompat.Builder(context.getApplicationContext(), str);
    }

    @Deprecated
    public Notification buildProgressNotification(Context context, int i, PendingIntent pendingIntent, String str, List<Download> list) {
        return buildProgressNotification(context, i, pendingIntent, str, list, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.app.Notification buildProgressNotification(android.content.Context r22, int r23, android.app.PendingIntent r24, java.lang.String r25, java.util.List<com.google.android.exoplayer2.offline.Download> r26, int r27) {
        /*
            r21 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            r9 = r0
            r3 = r1
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
        L_0x000a:
            int r10 = r26.size()
            if (r3 >= r10) goto L_0x004a
            r10 = r26
            java.lang.Object r11 = r10.get(r3)
            com.google.android.exoplayer2.offline.Download r11 = (com.google.android.exoplayer2.offline.Download) r11
            int r12 = r11.state
            if (r12 == 0) goto L_0x0046
            r13 = 2
            if (r12 == r13) goto L_0x0028
            r13 = 5
            if (r12 == r13) goto L_0x0026
            r13 = 7
            if (r12 == r13) goto L_0x0028
            goto L_0x0047
        L_0x0026:
            r7 = r0
            goto L_0x0047
        L_0x0028:
            float r4 = r11.getPercentDownloaded()
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r12 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r12 == 0) goto L_0x0034
            float r2 = r2 + r4
            r9 = r1
        L_0x0034:
            long r11 = r11.getBytesDownloaded()
            r13 = 0
            int r4 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x0040
            r4 = r0
            goto L_0x0041
        L_0x0040:
            r4 = r1
        L_0x0041:
            r6 = r6 | r4
            int r8 = r8 + 1
            r4 = r0
            goto L_0x0047
        L_0x0046:
            r5 = r0
        L_0x0047:
            int r3 = r3 + 1
            goto L_0x000a
        L_0x004a:
            if (r4 == 0) goto L_0x0051
            int r3 = com.google.android.exoplayer2.core.R.string.exo_download_downloading
        L_0x004e:
            r15 = r3
            r3 = r0
            goto L_0x006f
        L_0x0051:
            if (r5 == 0) goto L_0x0068
            if (r27 == 0) goto L_0x0068
            r3 = r27 & 2
            if (r3 == 0) goto L_0x005e
            int r3 = com.google.android.exoplayer2.core.R.string.exo_download_paused_for_wifi
        L_0x005b:
            r15 = r3
            r3 = r1
            goto L_0x006f
        L_0x005e:
            r3 = r27 & 1
            if (r3 == 0) goto L_0x0065
            int r3 = com.google.android.exoplayer2.core.R.string.exo_download_paused_for_network
            goto L_0x005b
        L_0x0065:
            int r3 = com.google.android.exoplayer2.core.R.string.exo_download_paused
            goto L_0x005b
        L_0x0068:
            if (r7 == 0) goto L_0x006d
            int r3 = com.google.android.exoplayer2.core.R.string.exo_download_removing
            goto L_0x004e
        L_0x006d:
            r3 = r0
            r15 = r1
        L_0x006f:
            if (r3 == 0) goto L_0x008a
            r3 = 100
            if (r4 == 0) goto L_0x0083
            float r4 = (float) r8
            float r2 = r2 / r4
            int r2 = (int) r2
            if (r9 == 0) goto L_0x007d
            if (r6 == 0) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            r0 = r1
        L_0x007e:
            r18 = r0
            r17 = r2
            goto L_0x0087
        L_0x0083:
            r18 = r0
            r17 = r1
        L_0x0087:
            r16 = r3
            goto L_0x0090
        L_0x008a:
            r16 = r1
            r17 = r16
            r18 = r17
        L_0x0090:
            r19 = 1
            r20 = 0
            r10 = r21
            r11 = r22
            r12 = r23
            r13 = r24
            r14 = r25
            android.app.Notification r0 = r10.buildNotification(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DownloadNotificationHelper.buildProgressNotification(android.content.Context, int, android.app.PendingIntent, java.lang.String, java.util.List, int):android.app.Notification");
    }

    public Notification buildDownloadCompletedNotification(Context context, int i, PendingIntent pendingIntent, String str) {
        return buildEndStateNotification(context, i, pendingIntent, str, R.string.exo_download_completed);
    }

    public Notification buildDownloadFailedNotification(Context context, int i, PendingIntent pendingIntent, String str) {
        return buildEndStateNotification(context, i, pendingIntent, str, R.string.exo_download_failed);
    }

    private Notification buildEndStateNotification(Context context, int i, PendingIntent pendingIntent, String str, int i2) {
        return buildNotification(context, i, pendingIntent, str, i2, 0, 0, false, false, true);
    }

    private Notification buildNotification(Context context, int i, PendingIntent pendingIntent, String str, int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        String str2;
        this.notificationBuilder.setSmallIcon(i);
        NotificationCompat.Builder builder = this.notificationBuilder;
        NotificationCompat.BigTextStyle bigTextStyle = null;
        if (i2 == 0) {
            str2 = null;
        } else {
            str2 = context.getResources().getString(i2);
        }
        builder.setContentTitle(str2);
        this.notificationBuilder.setContentIntent(pendingIntent);
        NotificationCompat.Builder builder2 = this.notificationBuilder;
        if (str != null) {
            bigTextStyle = new NotificationCompat.BigTextStyle().bigText(str);
        }
        builder2.setStyle(bigTextStyle);
        this.notificationBuilder.setProgress(i3, i4, z);
        this.notificationBuilder.setOngoing(z2);
        this.notificationBuilder.setShowWhen(z3);
        return this.notificationBuilder.build();
    }
}

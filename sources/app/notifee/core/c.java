package app.notifee.core;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.service.notification.StatusBarNotification;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.HtmlCompat;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import app.notifee.core.database.a;
import app.notifee.core.event.NotificationEvent;
import app.notifee.core.interfaces.MethodCallResult;
import app.notifee.core.model.NotificationAndroidModel;
import app.notifee.core.model.NotificationAndroidPressActionModel;
import app.notifee.core.model.NotificationAndroidStyleModel;
import app.notifee.core.model.NotificationModel;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.oblador.keychain.KeychainModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import n.o.t.i.f.e.e.e;
import n.o.t.i.f.e.e.f;
import n.o.t.i.f.e.e.h;
import n.o.t.i.f.e.e.i;
import n.o.t.i.f.e.e.j;
import n.o.t.i.f.e.e.l;
import n.o.t.i.f.e.e.n;
import n.o.t.i.f.e.e.q;

public class c {
    public static final ExecutorService a = Executors.newCachedThreadPool();

    public static Object a(Task task) throws Exception {
        a.a(e.a).a();
        return null;
    }

    public static Object b(int i) throws Exception {
        NotificationManagerCompat from = NotificationManagerCompat.from(e.a);
        if (i == 1 || i == 0) {
            from.cancelAll();
        }
        if (i != 2 && i != 0) {
            return null;
        }
        WorkManager instance = WorkManager.getInstance(e.a);
        instance.cancelAllWorkByTag("app.notifee.core.NotificationManager.TRIGGER");
        instance.pruneWork();
        return null;
    }

    public static Void a(int i, List list, Task task) throws Exception {
        if (i == 1) {
            return null;
        }
        a.a(e.a).a((List<String>) list);
        return null;
    }

    public static Object a(List list, int i, String str) throws Exception {
        WorkManager instance = WorkManager.getInstance(e.a);
        NotificationManagerCompat from = NotificationManagerCompat.from(e.a);
        Iterator it = list.iterator();
        while (true) {
            Integer num = null;
            if (!it.hasNext()) {
                return null;
            }
            String str2 = (String) it.next();
            Logger.i("NotificationManager", "Removing notification with id " + str2);
            if (i != 2) {
                if (str != null && str2.equals("0")) {
                    try {
                        num = Integer.valueOf(Integer.parseInt(str2));
                    } catch (Exception unused) {
                        Logger.e("NotificationManager", "cancelAllNotificationsWithIds -> Failed to parse id as integer  " + str2);
                    }
                    if (num != null) {
                        from.cancel(str, num.intValue());
                    }
                }
                from.cancel(str, str2.hashCode());
            }
            if (i != 1) {
                Logger.i("NotificationManager", "Removing notification with id " + str2);
                instance.cancelUniqueWork("trigger:" + str2);
                instance.pruneWork();
                PendingIntent a2 = b.a(str2);
                AlarmManager a3 = n.o.t.i.f.e.e.a.a();
                if (a2 != null) {
                    a3.cancel(a2);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e3 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.core.app.NotificationCompat.Builder b(app.notifee.core.model.NotificationAndroidModel r10, app.notifee.core.model.NotificationModel r11, com.google.android.gms.tasks.Task r12) throws java.lang.Exception {
        /*
            java.lang.String r0 = "NotificationManager"
            java.lang.Object r12 = r12.getResult()
            androidx.core.app.NotificationCompat$Builder r12 = (androidx.core.app.NotificationCompat.Builder) r12
            java.util.ArrayList r10 = r10.getActions()
            if (r10 != 0) goto L_0x000f
            return r12
        L_0x000f:
            java.util.Iterator r10 = r10.iterator()
        L_0x0013:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x00ec
            java.lang.Object r1 = r10.next()
            app.notifee.core.model.NotificationAndroidActionModel r1 = (app.notifee.core.model.NotificationAndroidActionModel) r1
            android.content.Context r2 = n.o.t.i.f.e.e.e.a
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo()
            int r2 = r2.targetSdkVersion
            r3 = 1
            java.lang.String r4 = "pressAction"
            java.lang.String r5 = "notification"
            r6 = 31
            r7 = 0
            r8 = 2
            if (r2 < r6) goto L_0x0061
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r6) goto L_0x0061
            java.lang.Integer r2 = r11.b()
            int r2 = r2.intValue()
            app.notifee.core.model.NotificationAndroidPressActionModel r6 = r1.getPressAction()
            android.os.Bundle r6 = r6.toBundle()
            java.lang.String[] r4 = new java.lang.String[]{r5, r4}
            android.os.Bundle[] r5 = new android.os.Bundle[r8]
            android.os.Bundle r9 = r11.toBundle()
            r5[r7] = r9
            app.notifee.core.model.NotificationAndroidPressActionModel r9 = r1.getPressAction()
            android.os.Bundle r9 = r9.toBundle()
            r5[r3] = r9
            android.app.PendingIntent r2 = n.o.t.i.f.e.e.j.a((int) r2, (android.os.Bundle) r6, (int) r8, (java.lang.String[]) r4, (android.os.Bundle[]) r5)
            goto L_0x007d
        L_0x0061:
            java.lang.String[] r2 = new java.lang.String[]{r5, r4}
            android.os.Bundle[] r4 = new android.os.Bundle[r8]
            android.os.Bundle r5 = r11.toBundle()
            r4[r7] = r5
            app.notifee.core.model.NotificationAndroidPressActionModel r5 = r1.getPressAction()
            android.os.Bundle r5 = r5.toBundle()
            r4[r3] = r5
            java.lang.String r3 = "app.notifee.core.ReceiverService.ACTION_PRESS_INTENT"
            android.app.PendingIntent r2 = app.notifee.core.ReceiverService.a(r3, r2, r4)
        L_0x007d:
            java.lang.String r3 = r1.getIcon()
            r4 = 0
            if (r3 == 0) goto L_0x00c6
            java.lang.String r5 = r1.getIcon()     // Catch:{ TimeoutException -> 0x00af, Exception -> 0x0097 }
            com.google.android.gms.tasks.Task r5 = n.o.t.i.f.e.e.n.a(r5)     // Catch:{ TimeoutException -> 0x00af, Exception -> 0x0097 }
            r8 = 10
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ TimeoutException -> 0x00af, Exception -> 0x0097 }
            java.lang.Object r5 = com.google.android.gms.tasks.Tasks.await(r5, r8, r6)     // Catch:{ TimeoutException -> 0x00af, Exception -> 0x0097 }
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5     // Catch:{ TimeoutException -> 0x00af, Exception -> 0x0097 }
            goto L_0x00c7
        L_0x0097:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "An error occurred whilst trying to retrieve an action icon: "
            java.lang.StringBuilder r6 = r6.append(r8)
            java.lang.StringBuilder r3 = r6.append(r3)
            java.lang.String r3 = r3.toString()
            app.notifee.core.Logger.e((java.lang.String) r0, (java.lang.String) r3, (java.lang.Exception) r5)
            goto L_0x00c6
        L_0x00af:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "Timeout occurred whilst trying to retrieve an action icon: "
            java.lang.StringBuilder r6 = r6.append(r8)
            java.lang.StringBuilder r3 = r6.append(r3)
            java.lang.String r3 = r3.toString()
            app.notifee.core.Logger.e((java.lang.String) r0, (java.lang.String) r3, (java.lang.Exception) r5)
        L_0x00c6:
            r5 = r4
        L_0x00c7:
            if (r5 == 0) goto L_0x00cd
            androidx.core.graphics.drawable.IconCompat r4 = androidx.core.graphics.drawable.IconCompat.createWithAdaptiveBitmap(r5)
        L_0x00cd:
            androidx.core.app.NotificationCompat$Action$Builder r3 = new androidx.core.app.NotificationCompat$Action$Builder
            java.lang.String r5 = r1.getTitle()
            android.text.Spanned r5 = androidx.core.text.HtmlCompat.fromHtml(r5, r7)
            r3.<init>((androidx.core.graphics.drawable.IconCompat) r4, (java.lang.CharSequence) r5, (android.app.PendingIntent) r2)
            androidx.core.app.RemoteInput r1 = r1.getRemoteInput(r3)
            if (r1 == 0) goto L_0x00e3
            r3.addRemoteInput(r1)
        L_0x00e3:
            androidx.core.app.NotificationCompat$Action r1 = r3.build()
            r12.addAction(r1)
            goto L_0x0013
        L_0x00ec:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: app.notifee.core.c.b(app.notifee.core.model.NotificationAndroidModel, app.notifee.core.model.NotificationModel, com.google.android.gms.tasks.Task):androidx.core.app.NotificationCompat$Builder");
    }

    public static Task<NotificationCompat.Builder> a(NotificationModel notificationModel) {
        NotificationAndroidModel a2 = notificationModel.a();
        c$$ExternalSyntheticLambda3 c__externalsyntheticlambda3 = new c$$ExternalSyntheticLambda3(a2, notificationModel);
        c$$ExternalSyntheticLambda4 c__externalsyntheticlambda4 = new c$$ExternalSyntheticLambda4(a2);
        c$$ExternalSyntheticLambda5 c__externalsyntheticlambda5 = new c$$ExternalSyntheticLambda5(a2, notificationModel);
        c$$ExternalSyntheticLambda6 c__externalsyntheticlambda6 = new c$$ExternalSyntheticLambda6(a2, notificationModel);
        c$$ExternalSyntheticLambda7 c__externalsyntheticlambda7 = new c$$ExternalSyntheticLambda7(a2);
        ExecutorService executorService = a;
        return Tasks.call(executorService, c__externalsyntheticlambda3).continueWith(executorService, c__externalsyntheticlambda4).continueWith(executorService, c__externalsyntheticlambda6).continueWith(executorService, c__externalsyntheticlambda7).continueWith(executorService, c__externalsyntheticlambda5);
    }

    public static /* synthetic */ NotificationCompat.Builder b(NotificationAndroidModel notificationAndroidModel, Task task) throws Exception {
        Task styleTask;
        NotificationCompat.Style style;
        NotificationCompat.Builder builder = (NotificationCompat.Builder) task.getResult();
        NotificationAndroidStyleModel style2 = notificationAndroidModel.getStyle();
        if (!(style2 == null || (styleTask = style2.getStyleTask(a)) == null || (style = (NotificationCompat.Style) Tasks.await(styleTask)) == null)) {
            builder.setStyle(style);
        }
        return builder;
    }

    public static Task<Void> b(NotificationModel notificationModel, Bundle bundle) {
        return a(notificationModel).continueWith(a, new c$$ExternalSyntheticLambda10(notificationModel, bundle));
    }

    public static List b() throws Exception {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT < 23) {
            return arrayList;
        }
        for (StatusBarNotification statusBarNotification : ((NotificationManager) e.a.getSystemService("notification")).getActiveNotifications()) {
            Notification notification = statusBarNotification.getNotification();
            Bundle bundle = notification.extras;
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = bundle.getBundle("notifee.notification");
            Bundle bundle4 = bundle.getBundle("notifee.trigger");
            if (bundle3 == null) {
                bundle3 = new Bundle();
                bundle3.putString("id", "" + statusBarNotification.getId());
                Object obj = bundle.get(NotificationCompat.EXTRA_TITLE);
                if (obj != null) {
                    bundle3.putString("title", obj.toString());
                }
                Object obj2 = bundle.get(NotificationCompat.EXTRA_TEXT);
                if (obj2 != null) {
                    bundle3.putString("body", obj2.toString());
                }
                Object obj3 = bundle.get(NotificationCompat.EXTRA_SUB_TEXT);
                if (obj3 != null) {
                    bundle3.putString(KeychainModule.AuthPromptOptions.SUBTITLE, obj3.toString());
                }
                Bundle bundle5 = new Bundle();
                if (Build.VERSION.SDK_INT >= 26) {
                    bundle5.putString("channelId", notification.getChannelId());
                }
                bundle5.putString("tag", statusBarNotification.getTag());
                bundle5.putString("group", notification.getGroup());
                bundle3.putBundle("android", bundle5);
                bundle2.putString("id", "" + statusBarNotification.getId());
            } else {
                bundle2.putString("id", "" + bundle3.get("id"));
            }
            if (bundle4 != null) {
                bundle2.putBundle("trigger", bundle4);
            }
            bundle2.putBundle("notification", bundle3);
            bundle2.putString("date", "" + statusBarNotification.getPostTime());
            arrayList.add(bundle2);
        }
        return arrayList;
    }

    public static void b(MethodCallResult<List<Bundle>> methodCallResult) {
        new a(e.a).b().addOnCompleteListener(new c$$ExternalSyntheticLambda12(methodCallResult));
    }

    public static void b(MethodCallResult methodCallResult, Task task) {
        ArrayList arrayList = new ArrayList();
        if (task.isSuccessful()) {
            for (q qVar : (List) task.getResult()) {
                Bundle bundle = new Bundle();
                bundle.putBundle("notification", l.a(qVar.b));
                bundle.putBundle("trigger", l.a(qVar.c));
                arrayList.add(bundle);
            }
            methodCallResult.onComplete((Exception) null, arrayList);
            return;
        }
        methodCallResult.onComplete(task.getException(), arrayList);
    }

    public static NotificationCompat.Builder a(NotificationAndroidModel notificationAndroidModel, NotificationModel notificationModel) throws Exception {
        Bundle bundle;
        Boolean bool = Boolean.FALSE;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(e.a, notificationAndroidModel.getChannelId());
        Bundle bundle2 = notificationModel.a.getBundle("data");
        if (bundle2 != null) {
            bundle = (Bundle) bundle2.clone();
        } else {
            bundle = new Bundle();
        }
        builder.setExtras(bundle);
        builder.setDeleteIntent(ReceiverService.a("app.notifee.core.ReceiverService.DELETE_INTENT", new String[]{"notification"}, notificationModel.toBundle()));
        if (e.a.getApplicationInfo().targetSdkVersion < 31 || Build.VERSION.SDK_INT < 31) {
            builder.setContentIntent(ReceiverService.a("app.notifee.core.ReceiverService.PRESS_INTENT", new String[]{"notification", "pressAction"}, notificationModel.toBundle(), notificationAndroidModel.getPressAction()));
        } else {
            builder.setContentIntent(j.a(notificationModel.b().intValue(), notificationAndroidModel.getPressAction(), 1, new String[]{"notification", "pressAction"}, notificationModel.toBundle(), notificationAndroidModel.getPressAction()));
        }
        if (notificationModel.a.getString("title") != null) {
            builder.setContentTitle(HtmlCompat.fromHtml(notificationModel.a.getString("title"), 0));
        }
        if (notificationModel.a.getString(KeychainModule.AuthPromptOptions.SUBTITLE) != null) {
            builder.setSubText(HtmlCompat.fromHtml(notificationModel.a.getString(KeychainModule.AuthPromptOptions.SUBTITLE), 0));
        }
        if (notificationModel.a.getString("body") != null) {
            builder.setContentText(HtmlCompat.fromHtml(notificationModel.a.getString("body"), 0));
        }
        if (notificationAndroidModel.getBadgeIconType() != null) {
            builder.setBadgeIconType(notificationAndroidModel.getBadgeIconType().intValue());
        }
        if (notificationAndroidModel.getCategory() != null) {
            builder.setCategory(notificationAndroidModel.getCategory());
        }
        if (notificationAndroidModel.getColor() != null) {
            builder.setColor(notificationAndroidModel.getColor().intValue());
        }
        builder.setColorized(notificationAndroidModel.getColorized().booleanValue());
        if (Build.VERSION.SDK_INT >= 24) {
            builder.setChronometerCountDown(notificationAndroidModel.getChronometerCountDown().booleanValue());
        }
        if (notificationAndroidModel.getGroup() != null) {
            builder.setGroup(notificationAndroidModel.getGroup());
        }
        builder.setGroupAlertBehavior(notificationAndroidModel.getGroupAlertBehaviour());
        builder.setGroupSummary(notificationAndroidModel.getGroupSummary().booleanValue());
        if (notificationAndroidModel.getInputHistory() != null) {
            builder.setRemoteInputHistory(notificationAndroidModel.getInputHistory());
        }
        if (notificationAndroidModel.getLights() != null) {
            ArrayList<Integer> lights = notificationAndroidModel.getLights();
            builder.setLights(lights.get(0).intValue(), lights.get(1).intValue(), lights.get(2).intValue());
        }
        builder.setLocalOnly(notificationAndroidModel.getLocalOnly().booleanValue());
        if (notificationAndroidModel.getNumber() != null) {
            builder.setNumber(notificationAndroidModel.getNumber().intValue());
        }
        if (notificationAndroidModel.getSound() != null) {
            Uri c = n.c(notificationAndroidModel.getSound());
            if (c != null) {
                bool = Boolean.TRUE;
                builder.setSound(c);
            } else {
                Logger.w("NotificationManager", "Unable to retrieve sound for notification, sound was specified as: " + notificationAndroidModel.getSound());
            }
        }
        builder.setDefaults(notificationAndroidModel.getDefaults(bool).intValue());
        builder.setOngoing(notificationAndroidModel.getOngoing().booleanValue());
        builder.setOnlyAlertOnce(notificationAndroidModel.getOnlyAlertOnce().booleanValue());
        builder.setPriority(notificationAndroidModel.getPriority());
        NotificationAndroidModel.a progress = notificationAndroidModel.getProgress();
        if (progress != null) {
            builder.setProgress(progress.a, progress.b, progress.c);
        }
        if (notificationAndroidModel.getShortcutId() != null) {
            builder.setShortcutId(notificationAndroidModel.getShortcutId());
        }
        builder.setShowWhen(notificationAndroidModel.getShowTimestamp().booleanValue());
        Integer smallIcon = notificationAndroidModel.getSmallIcon();
        if (smallIcon != null) {
            Integer smallIconLevel = notificationAndroidModel.getSmallIconLevel();
            if (smallIconLevel != null) {
                builder.setSmallIcon(smallIcon.intValue(), smallIconLevel.intValue());
            } else {
                builder.setSmallIcon(smallIcon.intValue());
            }
        }
        if (notificationAndroidModel.getSortKey() != null) {
            builder.setSortKey(notificationAndroidModel.getSortKey());
        }
        if (notificationAndroidModel.getTicker() != null) {
            builder.setTicker(notificationAndroidModel.getTicker());
        }
        if (notificationAndroidModel.getTimeoutAfter() != null) {
            builder.setTimeoutAfter(notificationAndroidModel.getTimeoutAfter().longValue());
        }
        builder.setUsesChronometer(notificationAndroidModel.getShowChronometer().booleanValue());
        long[] vibrationPattern = notificationAndroidModel.getVibrationPattern();
        if (vibrationPattern.length > 0) {
            builder.setVibrate(vibrationPattern);
        }
        builder.setVisibility(notificationAndroidModel.getVisibility());
        long timestamp = notificationAndroidModel.getTimestamp();
        if (timestamp > -1) {
            builder.setWhen(timestamp);
        }
        builder.setAutoCancel(notificationAndroidModel.getAutoCancel().booleanValue());
        return builder;
    }

    public static NotificationCompat.Builder a(NotificationAndroidModel notificationAndroidModel, Task task) throws Exception {
        Rect rect;
        Rect rect2;
        Bitmap bitmap;
        float f;
        NotificationCompat.Builder builder = (NotificationCompat.Builder) task.getResult();
        if (notificationAndroidModel.hasLargeIcon().booleanValue()) {
            String largeIcon = notificationAndroidModel.getLargeIcon();
            Bitmap bitmap2 = null;
            try {
                bitmap2 = (Bitmap) Tasks.await(n.a(largeIcon), 10, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                Logger.e("NotificationManager", "Timeout occurred whilst trying to retrieve a largeIcon image: " + largeIcon, (Exception) e);
            } catch (Exception e2) {
                Logger.e("NotificationManager", "An error occurred whilst trying to retrieve a largeIcon image: " + largeIcon, e2);
            }
            if (bitmap2 != null) {
                if (notificationAndroidModel.getCircularLargeIcon().booleanValue()) {
                    int width = bitmap2.getWidth();
                    int height = bitmap2.getHeight();
                    if (width > height) {
                        bitmap = Bitmap.createBitmap(height, height, Bitmap.Config.ARGB_8888);
                        int i = (width - height) / 2;
                        rect2 = new Rect(i, 0, i + height, height);
                        rect = new Rect(0, 0, height, height);
                        f = (float) (height / 2);
                    } else {
                        bitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
                        int i2 = (height - width) / 2;
                        rect2 = new Rect(0, i2, width, i2 + width);
                        Rect rect3 = new Rect(0, 0, width, width);
                        f = (float) (width / 2);
                        rect = rect3;
                    }
                    Canvas canvas = new Canvas(bitmap);
                    Paint paint = new Paint();
                    paint.setAntiAlias(true);
                    canvas.drawARGB(0, 0, 0, 0);
                    paint.setColor(SupportMenu.CATEGORY_MASK);
                    canvas.drawCircle(f, f, f, paint);
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                    canvas.drawBitmap(bitmap2, rect2, rect, paint);
                    bitmap2 = bitmap;
                }
                builder.setLargeIcon(bitmap2);
            }
        }
        return builder;
    }

    public static NotificationCompat.Builder a(NotificationAndroidModel notificationAndroidModel, NotificationModel notificationModel, Task task) throws Exception {
        NotificationCompat.Builder builder = (NotificationCompat.Builder) task.getResult();
        if (notificationAndroidModel.hasFullScreenAction().booleanValue()) {
            NotificationAndroidPressActionModel fullScreenAction = notificationAndroidModel.getFullScreenAction();
            String launchActivity = fullScreenAction.getLaunchActivity();
            Class<?> a2 = h.a(launchActivity);
            if (a2 == null) {
                Logger.e("NotificationManager", String.format("Launch Activity for full-screen action does not exist ('%s').", new Object[]{launchActivity}));
                return builder;
            }
            Intent intent = new Intent(e.a, a2);
            if (fullScreenAction.getLaunchActivityFlags() != -1) {
                intent.addFlags(fullScreenAction.getLaunchActivityFlags());
            }
            if (fullScreenAction.getMainComponent() != null) {
                intent.putExtra("mainComponent", fullScreenAction.getMainComponent());
                intent.putExtra("notification", notificationModel.toBundle());
                f.b(new i(fullScreenAction.getMainComponent()));
            }
            builder.setFullScreenIntent(PendingIntent.getActivity(e.a, notificationModel.b().intValue(), intent, 167772160), true);
        }
        return builder;
    }

    public static Task<Void> a(int i) {
        return Tasks.call(new c$$ExternalSyntheticLambda17(i)).continueWith(a, new c$$ExternalSyntheticLambda1(i));
    }

    public static /* synthetic */ Void a(int i, Task task) throws Exception {
        if (i != 2 && i != 0) {
            return null;
        }
        task.continueWith(b.a()).addOnSuccessListener(new c$$ExternalSyntheticLambda15());
        return null;
    }

    public static Task<Void> a(int i, List<String> list, String str) {
        return Tasks.call(new c$$ExternalSyntheticLambda0(list, i, str)).continueWith(new c$$ExternalSyntheticLambda9(i, list));
    }

    public static Void a(NotificationModel notificationModel, Bundle bundle, Task task) throws Exception {
        NotificationCompat.Builder builder = (NotificationCompat.Builder) task.getResult();
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("notifee.notification", notificationModel.toBundle());
        if (bundle != null) {
            bundle2.putBundle("notifee.trigger", bundle);
        }
        builder.addExtras(bundle2);
        Notification build = builder.build();
        int intValue = notificationModel.b().intValue();
        NotificationAndroidModel a2 = notificationModel.a();
        if (a2.getLoopSound().booleanValue()) {
            build.flags |= 4;
        }
        if (a2.getFlags() != null && a2.getFlags().length > 0) {
            for (int i : a2.getFlags()) {
                build.flags = i | build.flags;
            }
        }
        if (a2.getLightUpScreen().booleanValue()) {
            PowerManager powerManager = (PowerManager) e.a.getSystemService("power");
            if (!Boolean.valueOf(powerManager.isInteractive()).booleanValue()) {
                powerManager.newWakeLock(805306394, "Notifee:lock").acquire();
                powerManager.newWakeLock(1, "Notifee:cpuLock").acquire();
            }
        }
        if (a2.getAsForegroundService().booleanValue()) {
            Bundle bundle3 = notificationModel.toBundle();
            String str = ForegroundService.a;
            Intent intent = new Intent(e.a, ForegroundService.class);
            intent.setAction("app.notifee.core.ForegroundService.START");
            intent.putExtra("hashCode", intValue);
            intent.putExtra("notification", build);
            intent.putExtra("notificationBundle", bundle3);
            if (Build.VERSION.SDK_INT >= 26) {
                e.a.startForegroundService(intent);
            } else {
                e.a.startService(intent);
            }
        } else {
            NotificationManagerCompat.from(e.a).notify(a2.getTag(), intValue, build);
        }
        f.a(new NotificationEvent(3, notificationModel));
        return null;
    }

    public static Task<Void> a(NotificationModel notificationModel, Bundle bundle) {
        return Tasks.call(a, new c$$ExternalSyntheticLambda2(bundle, notificationModel));
    }

    public static Void a(Bundle bundle, NotificationModel notificationModel) throws Exception {
        TimeUnit timeUnit;
        TimeUnit timeUnit2;
        Bundle bundle2 = bundle;
        NotificationModel notificationModel2 = notificationModel;
        int a2 = l.a(bundle2.get("type"));
        int i = -1;
        if (a2 == 0) {
            app.notifee.core.model.a aVar = new app.notifee.core.model.a(bundle2);
            String str = "trigger:" + notificationModel.c();
            long j = 0;
            if (aVar.a.containsKey("timestamp")) {
                long b = l.b(aVar.a.get("timestamp"));
                if (b > 0) {
                    j = (long) Math.round((float) ((b - System.currentTimeMillis()) / 1000));
                }
            }
            int i2 = aVar.b;
            Data.Builder putString = new Data.Builder().putString("workType", "app.notifee.core.NotificationManager.TRIGGER").putString("id", notificationModel.c());
            Boolean bool = aVar.d;
            a.a(e.a);
            a.b.a(new q(notificationModel.c(), l.a(notificationModel.toBundle()), l.a(bundle), bool));
            if (bool.booleanValue()) {
                b.a(notificationModel2, aVar);
            } else {
                WorkManager instance = WorkManager.getInstance(e.a);
                if (i2 == -1) {
                    OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(Worker.class);
                    builder.addTag("app.notifee.core.NotificationManager.TRIGGER");
                    builder.addTag(str);
                    putString.putString("workRequestType", "OneTime");
                    builder.setInputData(putString.build());
                    builder.setInitialDelay(j, TimeUnit.SECONDS);
                    instance.enqueueUniqueWork(str, ExistingWorkPolicy.REPLACE, (OneTimeWorkRequest) builder.build());
                } else {
                    PeriodicWorkRequest.Builder builder2 = new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) Worker.class, (long) aVar.b, aVar.c);
                    builder2.addTag("app.notifee.core.NotificationManager.TRIGGER");
                    builder2.addTag(str);
                    builder2.setInitialDelay(j, TimeUnit.SECONDS);
                    putString.putString("workRequestType", "Periodic");
                    builder2.setInputData(putString.build());
                    instance.enqueueUniquePeriodicWork(str, ExistingPeriodicWorkPolicy.UPDATE, (PeriodicWorkRequest) builder2.build());
                }
            }
        } else if (a2 == 1) {
            String str2 = "trigger:" + notificationModel.c();
            WorkManager instance2 = WorkManager.getInstance(e.a);
            Data.Builder putString2 = new Data.Builder().putString("workType", "app.notifee.core.NotificationManager.TRIGGER").putString("workRequestType", "Periodic").putString("id", notificationModel.c());
            a.a(e.a);
            a.b.a(new q(notificationModel.c(), l.a(notificationModel.toBundle()), l.a(bundle), Boolean.FALSE));
            if (bundle2.containsKey("interval")) {
                i = l.a(bundle2.get("interval"));
            }
            long j2 = (long) i;
            Class<Worker> cls = Worker.class;
            TimeUnit timeUnit3 = TimeUnit.SECONDS;
            if (bundle2.containsKey("timeUnit")) {
                String string = bundle2.getString("timeUnit");
                try {
                    timeUnit = TimeUnit.valueOf(string);
                } catch (IllegalArgumentException e) {
                    timeUnit2 = timeUnit3;
                    Logger.e("IntervalTriggerModel", "An error occurred whilst trying to convert interval time unit: " + string, (Exception) e);
                }
            } else {
                timeUnit2 = timeUnit3;
                timeUnit = timeUnit2;
            }
            PeriodicWorkRequest.Builder builder3 = new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) cls, j2, timeUnit);
            TimeUnit timeUnit4 = TimeUnit.SECONDS;
            if (bundle2.containsKey("timeUnit")) {
                String string2 = bundle2.getString("timeUnit");
                try {
                    timeUnit4 = TimeUnit.valueOf(string2);
                } catch (IllegalArgumentException e2) {
                    Logger.e("IntervalTriggerModel", "An error occurred whilst trying to convert interval time unit: " + string2, (Exception) e2);
                }
            }
            PeriodicWorkRequest.Builder builder4 = (PeriodicWorkRequest.Builder) builder3.setInitialDelay(j2, timeUnit4);
            builder4.addTag("app.notifee.core.NotificationManager.TRIGGER");
            builder4.addTag(str2);
            builder4.setInputData(putString2.build());
            instance2.enqueueUniquePeriodicWork(str2, ExistingPeriodicWorkPolicy.UPDATE, (PeriodicWorkRequest) builder4.build());
        }
        f.a(new NotificationEvent(7, notificationModel2));
        return null;
    }

    public static Task<List<Bundle>> a() {
        return Tasks.call(new c$$ExternalSyntheticLambda11());
    }

    public static void a(MethodCallResult<List<String>> methodCallResult) {
        new a(e.a).b().addOnCompleteListener(new c$$ExternalSyntheticLambda8(methodCallResult));
    }

    public static void a(MethodCallResult methodCallResult, Task task) {
        ArrayList arrayList = new ArrayList();
        if (task.isSuccessful()) {
            for (q qVar : (List) task.getResult()) {
                arrayList.add(qVar.a);
            }
            methodCallResult.onComplete((Exception) null, arrayList);
            return;
        }
        methodCallResult.onComplete(task.getException(), null);
    }

    public static void a(Data data, CallbackToFutureAdapter.Completer<ListenableWorker.Result> completer) {
        String string = data.getString("id");
        a aVar = new a(e.a);
        aVar.b(string).continueWithTask(a, new c$$ExternalSyntheticLambda13(data, completer)).addOnCompleteListener(new c$$ExternalSyntheticLambda14(completer, data, string));
    }

    public static Task a(Data data, CallbackToFutureAdapter.Completer completer, Task task) throws Exception {
        byte[] bArr;
        q qVar = (q) task.getResult();
        Bundle bundle = null;
        if (qVar == null || (bArr = qVar.b) == null) {
            bArr = data.getByteArray("notification");
            if (bArr != null) {
                Logger.w("NotificationManager", "The trigger notification was created using an older version, please consider recreating the notification.");
            } else {
                Logger.w("NotificationManager", "Attempted to handle doScheduledWork but no notification data was found.");
                completer.set(ListenableWorker.Result.success());
                return null;
            }
        }
        NotificationModel notificationModel = new NotificationModel(l.a(bArr));
        byte[] bArr2 = qVar.c;
        if (bArr2 != null) {
            bundle = l.a(bArr2);
        }
        return b(notificationModel, bundle);
    }

    public static void a(CallbackToFutureAdapter.Completer completer, Data data, String str, Task task) {
        completer.set(ListenableWorker.Result.success());
        if (!task.isSuccessful()) {
            Logger.e("NotificationManager", "Failed to display notification", task.getException());
            return;
        }
        String string = data.getString("workRequestType");
        if (string != null && string.equals("OneTime")) {
            a.a(e.a).a(str);
        }
    }
}

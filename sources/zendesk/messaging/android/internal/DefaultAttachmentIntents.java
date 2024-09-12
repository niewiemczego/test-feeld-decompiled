package zendesk.messaging.android.internal;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lzendesk/messaging/android/internal/DefaultAttachmentIntents;", "Lzendesk/messaging/android/internal/AttachmentIntents;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "canOpenAttachmentIntent", "", "canOpenCameraIntent", "getAttachmentIntent", "Landroid/content/Intent;", "getCameraIntent", "shouldAskForCameraPermission", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AttachmentIntents.kt */
public final class DefaultAttachmentIntents implements AttachmentIntents {
    private final Activity activity;

    public DefaultAttachmentIntents(Activity activity2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = activity2;
    }

    public Intent getCameraIntent() {
        return new Intent("android.media.action.IMAGE_CAPTURE");
    }

    public Intent getAttachmentIntent() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setFlags(65);
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        return intent;
    }

    public boolean canOpenCameraIntent() {
        return this.activity.getPackageManager().hasSystemFeature("android.hardware.camera.any");
    }

    public boolean canOpenAttachmentIntent() {
        boolean z;
        if (Build.VERSION.SDK_INT >= 33) {
            PackageManager.ResolveInfoFlags of = PackageManager.ResolveInfoFlags.of(PlaybackStateCompat.ACTION_PREPARE_FROM_URI);
            Intrinsics.checkNotNullExpressionValue(of, "of(PackageManager.MATCH_ALL.toLong())");
            List queryIntentActivities = this.activity.getPackageManager().queryIntentActivities(getAttachmentIntent(), of);
            Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "");
            z = queryIntentActivities.isEmpty();
        } else {
            List<ResolveInfo> queryIntentActivities2 = this.activity.getPackageManager().queryIntentActivities(getAttachmentIntent(), 0);
            Intrinsics.checkNotNullExpressionValue(queryIntentActivities2, "");
            z = queryIntentActivities2.isEmpty();
        }
        return !z;
    }

    public boolean shouldAskForCameraPermission() {
        PackageInfo packageInfo;
        if (Build.VERSION.SDK_INT >= 33) {
            packageInfo = this.activity.getPackageManager().getPackageInfo(this.activity.getPackageName(), PackageManager.PackageInfoFlags.of(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        } else {
            packageInfo = this.activity.getPackageManager().getPackageInfo(this.activity.getPackageName(), 4096);
        }
        String[] strArr = packageInfo.requestedPermissions;
        Intrinsics.checkNotNullExpressionValue(strArr, "packageInfo.requestedPermissions");
        return ArraysKt.contains((T[]) (Object[]) strArr, "android.permission.CAMERA");
    }
}

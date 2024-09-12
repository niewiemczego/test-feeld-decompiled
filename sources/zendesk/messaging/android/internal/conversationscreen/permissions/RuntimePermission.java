package zendesk.messaging.android.internal.conversationscreen.permissions;

import android.app.Activity;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.core.content.PermissionChecker;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import zendesk.messaging.android.internal.model.UploadFile;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\fH\u0003J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0002J!\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u001f2\u0006\u0010 \u001a\u00020\u0016H\u0000¢\u0006\u0002\b!J'\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\t0\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100\tH\u0000¢\u0006\u0002\b$J \u0010%\u001a\u00020\u00182\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\n0'j\b\u0012\u0004\u0012\u00020\n`(H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0010H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010 \u0011*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\t0\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\f0\f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00160\u00160\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/permissions/RuntimePermission;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "activityResultCompleteDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "Lzendesk/messaging/android/internal/model/UploadFile;", "latestTempUri", "Landroid/net/Uri;", "requestForMultiplePermissions", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "kotlin.jvm.PlatformType", "runtimePermissionStateCompletableDeferred", "Lzendesk/messaging/android/internal/conversationscreen/permissions/RuntimePermissionState;", "startActivityForCameraResult", "startActivityForFileResult", "Landroid/content/Intent;", "cancel", "", "cancel$zendesk_messaging_messaging_android", "getTempCapturedImageUri", "getUploadFileFromIntent", "Landroid/app/Activity;", "uri", "requestForActivityResult", "Lkotlinx/coroutines/flow/Flow;", "intent", "requestForActivityResult$zendesk_messaging_messaging_android", "requestRuntimePermission", "permissionsToRequest", "requestRuntimePermission$zendesk_messaging_messaging_android", "setActivityResultCompleteDeferred", "uploadFiles", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "showRequestPermissionRationale", "", "permission", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RuntimePermission.kt */
public final class RuntimePermission {
    private final AppCompatActivity activity;
    /* access modifiers changed from: private */
    public CompletableDeferred<List<UploadFile>> activityResultCompleteDeferred = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    /* access modifiers changed from: private */
    public Uri latestTempUri;
    /* access modifiers changed from: private */
    public final ActivityResultLauncher<String[]> requestForMultiplePermissions;
    /* access modifiers changed from: private */
    public CompletableDeferred<List<RuntimePermissionState>> runtimePermissionStateCompletableDeferred = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    /* access modifiers changed from: private */
    public final ActivityResultLauncher<Uri> startActivityForCameraResult;
    /* access modifiers changed from: private */
    public final ActivityResultLauncher<Intent> startActivityForFileResult;

    public RuntimePermission(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        this.activity = appCompatActivity;
        ActivityResultLauncher<String[]> registerForActivityResult = appCompatActivity.registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new RuntimePermission$$ExternalSyntheticLambda0(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "activity.registerForActi…tableDeferred()\n        }");
        this.requestForMultiplePermissions = registerForActivityResult;
        ActivityResultLauncher<Intent> registerForActivityResult2 = appCompatActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new RuntimePermission$$ExternalSyntheticLambda1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "activity.registerForActi…}\n            }\n        }");
        this.startActivityForFileResult = registerForActivityResult2;
        ActivityResultLauncher<Uri> registerForActivityResult3 = appCompatActivity.registerForActivityResult(new ActivityResultContracts.TakePicture(), new RuntimePermission$$ExternalSyntheticLambda2(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult3, "activity.registerForActi…}\n            }\n        }");
        this.startActivityForCameraResult = registerForActivityResult3;
    }

    public final AppCompatActivity getActivity() {
        return this.activity;
    }

    /* access modifiers changed from: private */
    /* renamed from: requestForMultiplePermissions$lambda-1  reason: not valid java name */
    public static final void m696requestForMultiplePermissions$lambda1(RuntimePermission runtimePermission, Map map) {
        Intrinsics.checkNotNullParameter(runtimePermission, "this$0");
        Intrinsics.checkNotNullExpressionValue(map, "permissionsMap");
        Collection arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            arrayList.add(new RuntimePermissionState(str, ((Boolean) entry.getValue()).booleanValue(), runtimePermission.showRequestPermissionRationale(str)));
        }
        runtimePermission.runtimePermissionStateCompletableDeferred.complete((List) arrayList);
        runtimePermission.runtimePermissionStateCompletableDeferred = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: startActivityForFileResult$lambda-2  reason: not valid java name */
    public static final void m698startActivityForFileResult$lambda2(RuntimePermission runtimePermission, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(runtimePermission, "this$0");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            ClipData clipData = null;
            Uri data2 = data != null ? data.getData() : null;
            Intent data3 = activityResult.getData();
            if (data3 != null) {
                clipData = data3.getClipData();
            }
            if (data2 != null) {
                runtimePermission.setActivityResultCompleteDeferred(CollectionsKt.arrayListOf(runtimePermission.getUploadFileFromIntent(runtimePermission.activity, data2)));
            } else if (clipData != null) {
                int itemCount = clipData.getItemCount();
                ArrayList arrayList = new ArrayList(itemCount);
                for (int i = 0; i < itemCount; i++) {
                    Uri uri = clipData.getItemAt(i).getUri();
                    Intrinsics.checkNotNullExpressionValue(uri, "multipleFileClipData.getItemAt(index).uri");
                    ContentResolver contentResolver = runtimePermission.activity.getContentResolver();
                    if (contentResolver != null) {
                        contentResolver.takePersistableUriPermission(uri, 1);
                    }
                    arrayList.add(runtimePermission.getUploadFileFromIntent(runtimePermission.activity, uri));
                }
                runtimePermission.setActivityResultCompleteDeferred(arrayList);
            } else {
                runtimePermission.activity.setResult(0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startActivityForCameraResult$lambda-4  reason: not valid java name */
    public static final void m697startActivityForCameraResult$lambda4(RuntimePermission runtimePermission, Boolean bool) {
        Uri uri;
        Intrinsics.checkNotNullParameter(runtimePermission, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "isSuccess");
        if (bool.booleanValue() && (uri = runtimePermission.latestTempUri) != null) {
            runtimePermission.setActivityResultCompleteDeferred(CollectionsKt.arrayListOf(runtimePermission.getUploadFileFromIntent(runtimePermission.activity, uri)));
        }
    }

    public final Flow<List<RuntimePermissionState>> requestRuntimePermission$zendesk_messaging_messaging_android(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "permissionsToRequest");
        return FlowKt.flow(new RuntimePermission$requestRuntimePermission$1(this, list, (Continuation<? super RuntimePermission$requestRuntimePermission$1>) null));
    }

    public final Flow<List<UploadFile>> requestForActivityResult$zendesk_messaging_messaging_android(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        return FlowKt.flow(new RuntimePermission$requestForActivityResult$1(intent, this, (Continuation<? super RuntimePermission$requestForActivityResult$1>) null));
    }

    private final boolean showRequestPermissionRationale(String str) {
        return PermissionChecker.checkSelfPermission(this.activity, str) != 0 && ActivityCompat.shouldShowRequestPermissionRationale(this.activity, str);
    }

    /* access modifiers changed from: private */
    public final Uri getTempCapturedImageUri() {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"yyyyMMdd_HHmmss\").format(Date())");
        File createTempFile = File.createTempFile("JPEG_" + format + '_', ".jpg", this.activity.getCacheDir());
        createTempFile.createNewFile();
        createTempFile.deleteOnExit();
        Uri uriForFile = FileProvider.getUriForFile(this.activity.getApplicationContext(), this.activity.getPackageName() + ".zendesk.messaging.provider", createTempFile);
        Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(activity.a…ext, authority, tempFile)");
        return uriForFile;
    }

    private final void setActivityResultCompleteDeferred(ArrayList<UploadFile> arrayList) {
        this.activityResultCompleteDeferred.complete(arrayList);
        this.activityResultCompleteDeferred = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    }

    public final void cancel$zendesk_messaging_messaging_android() {
        if (this.runtimePermissionStateCompletableDeferred.isActive()) {
            Job.DefaultImpls.cancel$default((Job) this.runtimePermissionStateCompletableDeferred, (CancellationException) null, 1, (Object) null);
        }
        this.runtimePermissionStateCompletableDeferred = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        if (this.activityResultCompleteDeferred.isActive()) {
            Job.DefaultImpls.cancel$default((Job) this.activityResultCompleteDeferred, (CancellationException) null, 1, (Object) null);
        }
        this.activityResultCompleteDeferred = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    }

    private final UploadFile getUploadFileFromIntent(Activity activity2, Uri uri) {
        String str;
        Cursor query = activity2.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query != null) {
            query.moveToFirst();
        }
        String string = query != null ? query.getString(query.getColumnIndex("_display_name")) : null;
        String str2 = string == null ? "" : string;
        long j = query != null ? query.getLong(query.getColumnIndex("_size")) : 0;
        if (query != null) {
            query.close();
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str2);
        Intrinsics.checkNotNullExpressionValue(fileExtensionFromUrl, "getFileExtensionFromUrl(name)");
        String lowerCase = fileExtensionFromUrl.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension != null) {
            String lowerCase2 = mimeTypeFromExtension.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (lowerCase2 != null) {
                str = lowerCase2;
                String uri2 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
                return new UploadFile(uri2, str2, j, str);
            }
        }
        str = "";
        String uri22 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri22, "uri.toString()");
        return new UploadFile(uri22, str2, j, str);
    }
}

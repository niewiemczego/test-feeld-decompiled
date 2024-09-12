package expo.modules.adapters.react.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.interfaces.permissions.PermissionsResponseListener;
import expo.modules.interfaces.permissions.PermissionsStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0019\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0002\u0010\u001cJ%\u0010\u001d\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e2\u0006\u0010\u001e\u001a\u00020\fH\u0014¢\u0006\u0002\u0010\u001fJ)\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\f2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0016¢\u0006\u0002\u0010\"J)\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0016¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\u001aH\u0003J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000fH\u0002J\b\u0010*\u001a\u00020+H\u0002J%\u0010,\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e2\u0006\u0010\u001e\u001a\u00020\fH\u0004¢\u0006\u0002\u0010\u001fJ\u0010\u0010-\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0016\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u000201000/H\u0016J\u0010\u00102\u001a\u0002032\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0010\u00104\u001a\u0002032\u0006\u0010)\u001a\u00020\u000fH\u0014J\u0018\u00105\u001a\u0002062\u0006\u0010)\u001a\u00020\u000f2\u0006\u00107\u001a\u000203H\u0002J)\u00108\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\f2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0016¢\u0006\u0002\u0010\"J)\u00109\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0016¢\u0006\u0002\u0010&J!\u0010:\u001a\u00020\u00182\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0016¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020\u0018H\u0002J\u0010\u0010=\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0010\u0010>\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000fH\u0016J\b\u0010?\u001a\u00020\u0018H\u0002J\u0010\u0010@\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020\u001aH\u0016J\b\u0010D\u001a\u00020\u001aH\u0016J\b\u0010E\u001a\u00020\u001aH\u0016J1\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002060G2\u000e\u0010H\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e2\u0006\u0010I\u001a\u00020JH\u0002¢\u0006\u0002\u0010KR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u001c\u0012\u0018\u0012\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\f0\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lexpo/modules/adapters/react/permissions/PermissionsService;", "Lexpo/modules/core/interfaces/InternalModule;", "Lexpo/modules/interfaces/permissions/Permissions;", "Lexpo/modules/core/interfaces/LifecycleEventListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mActivityProvider", "Lexpo/modules/core/interfaces/ActivityProvider;", "mAskAsyncListener", "Lexpo/modules/interfaces/permissions/PermissionsResponseListener;", "mAskAsyncRequestedPermissions", "", "", "[Ljava/lang/String;", "mAskedPermissionsCache", "Landroid/content/SharedPreferences;", "mCurrentPermissionListener", "mPendingPermissionCalls", "Ljava/util/Queue;", "Lkotlin/Pair;", "mWriteSettingsPermissionBeingAsked", "", "addToAskedPermissionsCache", "", "permissions", "([Ljava/lang/String;)V", "askForManifestPermissions", "listener", "([Ljava/lang/String;Lexpo/modules/interfaces/permissions/PermissionsResponseListener;)V", "askForPermissions", "responseListener", "(Lexpo/modules/interfaces/permissions/PermissionsResponseListener;[Ljava/lang/String;)V", "askForPermissionsWithPromise", "promise", "Lexpo/modules/core/Promise;", "(Lexpo/modules/core/Promise;[Ljava/lang/String;)V", "askForWriteSettingsPermissionFirst", "canAskAgain", "permission", "createListenerWithPendingPermissionsRequest", "Lcom/facebook/react/modules/core/PermissionListener;", "delegateRequestToActivity", "didAsk", "getExportedInterfaces", "", "Ljava/lang/Class;", "", "getManifestPermission", "", "getManifestPermissionFromContext", "getPermissionResponseFromNativeResponse", "Lexpo/modules/interfaces/permissions/PermissionsResponse;", "result", "getPermissions", "getPermissionsWithPromise", "hasGrantedPermissions", "([Ljava/lang/String;)Z", "hasWriteSettingsPermission", "isPermissionGranted", "isPermissionPresentInManifest", "isRuntimePermissionsAvailable", "onCreate", "moduleRegistry", "Lexpo/modules/core/ModuleRegistry;", "onHostDestroy", "onHostPause", "onHostResume", "parseNativeResult", "", "permissionsString", "grantResults", "", "([Ljava/lang/String;[I)Ljava/util/Map;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PermissionsService.kt */
public class PermissionsService implements InternalModule, Permissions, LifecycleEventListener {
    private final Context context;
    private ActivityProvider mActivityProvider;
    private PermissionsResponseListener mAskAsyncListener;
    private String[] mAskAsyncRequestedPermissions;
    private SharedPreferences mAskedPermissionsCache;
    private PermissionsResponseListener mCurrentPermissionListener;
    private final Queue<Pair<String[], PermissionsResponseListener>> mPendingPermissionCalls = new LinkedList();
    private boolean mWriteSettingsPermissionBeingAsked;

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    public PermissionsService(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    private final boolean didAsk(String str) {
        SharedPreferences sharedPreferences = this.mAskedPermissionsCache;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAskedPermissionsCache");
            sharedPreferences = null;
        }
        return sharedPreferences.getBoolean(str, false);
    }

    private final void addToAskedPermissionsCache(String[] strArr) {
        SharedPreferences sharedPreferences = this.mAskedPermissionsCache;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAskedPermissionsCache");
            sharedPreferences = null;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String putBoolean : strArr) {
            edit.putBoolean(putBoolean, true);
        }
        edit.apply();
    }

    public List<Class<? extends Object>> getExportedInterfaces() {
        return CollectionsKt.listOf(Permissions.class);
    }

    public void onCreate(ModuleRegistry moduleRegistry) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        ActivityProvider activityProvider = (ActivityProvider) moduleRegistry.getModule(ActivityProvider.class);
        if (activityProvider != null) {
            this.mActivityProvider = activityProvider;
            ((UIManager) moduleRegistry.getModule(UIManager.class)).registerLifecycleEventListener(this);
            SharedPreferences sharedPreferences = this.context.getApplicationContext().getSharedPreferences("expo.modules.permissions.asked", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.applicationConte…ME, Context.MODE_PRIVATE)");
            this.mAskedPermissionsCache = sharedPreferences;
            return;
        }
        throw new IllegalStateException("Couldn't find implementation for ActivityProvider.");
    }

    public void getPermissionsWithPromise(Promise promise, String... strArr) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        getPermissions(new PermissionsService$$ExternalSyntheticLambda2(promise), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public void askForPermissionsWithPromise(Promise promise, String... strArr) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        askForPermissions(new PermissionsService$$ExternalSyntheticLambda1(this, promise, strArr), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    /* access modifiers changed from: private */
    /* renamed from: askForPermissionsWithPromise$lambda-7  reason: not valid java name */
    public static final void m685askForPermissionsWithPromise$lambda7(PermissionsService permissionsService, Promise promise, String[] strArr, Map map) {
        Intrinsics.checkNotNullParameter(permissionsService, "this$0");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(strArr, "$permissions");
        permissionsService.getPermissionsWithPromise(promise, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public void askForPermissions(PermissionsResponseListener permissionsResponseListener, String... strArr) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(permissionsResponseListener, "responseListener");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        if (!ArraysKt.contains((T[]) strArr, "android.permission.WRITE_SETTINGS") || !isRuntimePermissionsAvailable()) {
            askForManifestPermissions(strArr, permissionsResponseListener);
            return;
        }
        List mutableList = ArraysKt.toMutableList((T[]) strArr);
        mutableList.remove("android.permission.WRITE_SETTINGS");
        Object[] array = mutableList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr2 = (String[]) array;
        PermissionsService$$ExternalSyntheticLambda3 permissionsService$$ExternalSyntheticLambda3 = new PermissionsService$$ExternalSyntheticLambda3(this, permissionsResponseListener);
        if (hasWriteSettingsPermission()) {
            askForManifestPermissions(strArr2, permissionsService$$ExternalSyntheticLambda3);
        } else if (this.mAskAsyncListener == null) {
            this.mAskAsyncListener = permissionsService$$ExternalSyntheticLambda3;
            this.mAskAsyncRequestedPermissions = strArr2;
            addToAskedPermissionsCache(new String[]{"android.permission.WRITE_SETTINGS"});
            askForWriteSettingsPermissionFirst();
        } else {
            throw new IllegalStateException("Another permissions request is in progress. Await the old request and then try again.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: askForPermissions$lambda-10  reason: not valid java name */
    public static final void m684askForPermissions$lambda10(PermissionsService permissionsService, PermissionsResponseListener permissionsResponseListener, Map map) {
        Intrinsics.checkNotNullParameter(permissionsService, "this$0");
        Intrinsics.checkNotNullParameter(permissionsResponseListener, "$responseListener");
        int i = permissionsService.hasWriteSettingsPermission() ? 0 : -1;
        Intrinsics.checkNotNullExpressionValue(map, "it");
        map.put("android.permission.WRITE_SETTINGS", permissionsService.getPermissionResponseFromNativeResponse("android.permission.WRITE_SETTINGS", i));
        permissionsResponseListener.onResult(map);
    }

    public boolean isPermissionPresentInManifest(String str) {
        Intrinsics.checkNotNullParameter(str, "permission");
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 4096);
            if (packageInfo != null) {
                String[] strArr = packageInfo.requestedPermissions;
                Intrinsics.checkNotNullExpressionValue(strArr, "requestedPermissions");
                return ArraysKt.contains((T[]) (Object[]) strArr, str);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    private final boolean isPermissionGranted(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) "android.permission.WRITE_SETTINGS")) {
            return hasWriteSettingsPermission();
        }
        return getManifestPermission(str) == 0;
    }

    private final int getManifestPermission(String str) {
        Activity currentActivity;
        ActivityProvider activityProvider = this.mActivityProvider;
        if (activityProvider == null || (currentActivity = activityProvider.getCurrentActivity()) == null || !(currentActivity instanceof PermissionAwareActivity)) {
            return getManifestPermissionFromContext(str);
        }
        return ContextCompat.checkSelfPermission(currentActivity, str);
    }

    /* access modifiers changed from: protected */
    public int getManifestPermissionFromContext(String str) {
        Intrinsics.checkNotNullParameter(str, "permission");
        return ContextCompat.checkSelfPermission(this.context, str);
    }

    private final boolean canAskAgain(String str) {
        Activity currentActivity;
        ActivityProvider activityProvider = this.mActivityProvider;
        if (activityProvider == null || (currentActivity = activityProvider.getCurrentActivity()) == null) {
            return false;
        }
        return ActivityCompat.shouldShowRequestPermissionRationale(currentActivity, str);
    }

    private final Map<String, PermissionsResponse> parseNativeResult(String[] strArr, int[] iArr) {
        HashMap hashMap = new HashMap();
        for (Pair pair : ArraysKt.zip(iArr, (R[]) strArr)) {
            int intValue = ((Number) pair.component1()).intValue();
            String str = (String) pair.component2();
            hashMap.put(str, getPermissionResponseFromNativeResponse(str, intValue));
        }
        return hashMap;
    }

    private final PermissionsResponse getPermissionResponseFromNativeResponse(String str, int i) {
        PermissionsStatus permissionsStatus;
        if (i == 0) {
            permissionsStatus = PermissionsStatus.GRANTED;
        } else if (didAsk(str)) {
            permissionsStatus = PermissionsStatus.DENIED;
        } else {
            permissionsStatus = PermissionsStatus.UNDETERMINED;
        }
        return new PermissionsResponse(permissionsStatus, permissionsStatus == PermissionsStatus.DENIED ? canAskAgain(str) : true);
    }

    /* access modifiers changed from: protected */
    public void askForManifestPermissions(String[] strArr, PermissionsResponseListener permissionsResponseListener) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(permissionsResponseListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!isRuntimePermissionsAvailable()) {
            addToAskedPermissionsCache(strArr);
            Collection arrayList = new ArrayList(strArr.length);
            for (String manifestPermission : strArr) {
                arrayList.add(Integer.valueOf(getManifestPermission(manifestPermission)));
            }
            permissionsResponseListener.onResult(parseNativeResult(strArr, CollectionsKt.toIntArray((List) arrayList)));
            return;
        }
        delegateRequestToActivity(strArr, permissionsResponseListener);
    }

    /* access modifiers changed from: protected */
    public final void delegateRequestToActivity(String[] strArr, PermissionsResponseListener permissionsResponseListener) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(permissionsResponseListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        addToAskedPermissionsCache(strArr);
        ActivityProvider activityProvider = this.mActivityProvider;
        Activity currentActivity = activityProvider != null ? activityProvider.getCurrentActivity() : null;
        if (currentActivity instanceof PermissionAwareActivity) {
            synchronized (this) {
                if (this.mCurrentPermissionListener != null) {
                    Boolean.valueOf(this.mPendingPermissionCalls.add(TuplesKt.to(strArr, permissionsResponseListener)));
                } else {
                    this.mCurrentPermissionListener = permissionsResponseListener;
                    ((PermissionAwareActivity) currentActivity).requestPermissions(strArr, 13, createListenerWithPendingPermissionsRequest());
                    Unit unit = Unit.INSTANCE;
                }
            }
            return;
        }
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = -1;
        }
        permissionsResponseListener.onResult(parseNativeResult(strArr, iArr));
    }

    private final PermissionListener createListenerWithPendingPermissionsRequest() {
        return new PermissionsService$$ExternalSyntheticLambda0(this);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
        return true;
     */
    /* renamed from: createListenerWithPendingPermissionsRequest$lambda-22  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean m686createListenerWithPendingPermissionsRequest$lambda22(expo.modules.adapters.react.permissions.PermissionsService r5, int r6, java.lang.String[] r7, int[] r8) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 13
            r1 = 0
            if (r6 != r0) goto L_0x00d2
            monitor-enter(r5)
            expo.modules.interfaces.permissions.PermissionsResponseListener r6 = r5.mCurrentPermissionListener     // Catch:{ all -> 0x00cf }
            if (r6 == 0) goto L_0x00c3
            java.lang.String r2 = "receivePermissions"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)     // Catch:{ all -> 0x00cf }
            java.lang.String r2 = "grantResults"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)     // Catch:{ all -> 0x00cf }
            java.util.Map r7 = r5.parseNativeResult(r7, r8)     // Catch:{ all -> 0x00cf }
            r6.onResult(r7)     // Catch:{ all -> 0x00cf }
            r6 = 0
            r5.mCurrentPermissionListener = r6     // Catch:{ all -> 0x00cf }
            java.util.Queue<kotlin.Pair<java.lang.String[], expo.modules.interfaces.permissions.PermissionsResponseListener>> r7 = r5.mPendingPermissionCalls     // Catch:{ all -> 0x00cf }
            java.lang.Object r7 = r7.poll()     // Catch:{ all -> 0x00cf }
            kotlin.Pair r7 = (kotlin.Pair) r7     // Catch:{ all -> 0x00cf }
            if (r7 == 0) goto L_0x00c0
            java.lang.String r8 = "poll()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)     // Catch:{ all -> 0x00cf }
            expo.modules.core.interfaces.ActivityProvider r8 = r5.mActivityProvider     // Catch:{ all -> 0x00cf }
            if (r8 == 0) goto L_0x003b
            android.app.Activity r8 = r8.getCurrentActivity()     // Catch:{ all -> 0x00cf }
            goto L_0x003c
        L_0x003b:
            r8 = r6
        L_0x003c:
            boolean r2 = r8 instanceof com.facebook.react.modules.core.PermissionAwareActivity     // Catch:{ all -> 0x00cf }
            if (r2 == 0) goto L_0x0043
            r6 = r8
            com.facebook.react.modules.core.PermissionAwareActivity r6 = (com.facebook.react.modules.core.PermissionAwareActivity) r6     // Catch:{ all -> 0x00cf }
        L_0x0043:
            if (r6 != 0) goto L_0x00a9
            java.lang.Object r6 = r7.getSecond()     // Catch:{ all -> 0x00cf }
            expo.modules.interfaces.permissions.PermissionsResponseListener r6 = (expo.modules.interfaces.permissions.PermissionsResponseListener) r6     // Catch:{ all -> 0x00cf }
            java.lang.Object r8 = r7.getFirst()     // Catch:{ all -> 0x00cf }
            java.lang.String[] r8 = (java.lang.String[]) r8     // Catch:{ all -> 0x00cf }
            java.lang.Object r7 = r7.getFirst()     // Catch:{ all -> 0x00cf }
            java.lang.Object[] r7 = (java.lang.Object[]) r7     // Catch:{ all -> 0x00cf }
            int r7 = r7.length     // Catch:{ all -> 0x00cf }
            int[] r0 = new int[r7]     // Catch:{ all -> 0x00cf }
            r2 = r1
        L_0x005b:
            r3 = -1
            if (r2 >= r7) goto L_0x0063
            r0[r2] = r3     // Catch:{ all -> 0x00cf }
            int r2 = r2 + 1
            goto L_0x005b
        L_0x0063:
            java.util.Map r7 = r5.parseNativeResult(r8, r0)     // Catch:{ all -> 0x00cf }
            r6.onResult(r7)     // Catch:{ all -> 0x00cf }
            java.util.Queue<kotlin.Pair<java.lang.String[], expo.modules.interfaces.permissions.PermissionsResponseListener>> r6 = r5.mPendingPermissionCalls     // Catch:{ all -> 0x00cf }
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ all -> 0x00cf }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x00cf }
        L_0x0072:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x00cf }
            if (r7 == 0) goto L_0x00a3
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x00cf }
            kotlin.Pair r7 = (kotlin.Pair) r7     // Catch:{ all -> 0x00cf }
            java.lang.Object r8 = r7.getSecond()     // Catch:{ all -> 0x00cf }
            expo.modules.interfaces.permissions.PermissionsResponseListener r8 = (expo.modules.interfaces.permissions.PermissionsResponseListener) r8     // Catch:{ all -> 0x00cf }
            java.lang.Object r0 = r7.getFirst()     // Catch:{ all -> 0x00cf }
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ all -> 0x00cf }
            java.lang.Object r7 = r7.getFirst()     // Catch:{ all -> 0x00cf }
            java.lang.Object[] r7 = (java.lang.Object[]) r7     // Catch:{ all -> 0x00cf }
            int r7 = r7.length     // Catch:{ all -> 0x00cf }
            int[] r2 = new int[r7]     // Catch:{ all -> 0x00cf }
            r4 = r1
        L_0x0094:
            if (r4 >= r7) goto L_0x009b
            r2[r4] = r3     // Catch:{ all -> 0x00cf }
            int r4 = r4 + 1
            goto L_0x0094
        L_0x009b:
            java.util.Map r7 = r5.parseNativeResult(r0, r2)     // Catch:{ all -> 0x00cf }
            r8.onResult(r7)     // Catch:{ all -> 0x00cf }
            goto L_0x0072
        L_0x00a3:
            java.util.Queue<kotlin.Pair<java.lang.String[], expo.modules.interfaces.permissions.PermissionsResponseListener>> r6 = r5.mPendingPermissionCalls     // Catch:{ all -> 0x00cf }
            r6.clear()     // Catch:{ all -> 0x00cf }
            goto L_0x00c0
        L_0x00a9:
            java.lang.Object r8 = r7.getSecond()     // Catch:{ all -> 0x00cf }
            expo.modules.interfaces.permissions.PermissionsResponseListener r8 = (expo.modules.interfaces.permissions.PermissionsResponseListener) r8     // Catch:{ all -> 0x00cf }
            r5.mCurrentPermissionListener = r8     // Catch:{ all -> 0x00cf }
            java.lang.Object r7 = r7.getFirst()     // Catch:{ all -> 0x00cf }
            java.lang.String[] r7 = (java.lang.String[]) r7     // Catch:{ all -> 0x00cf }
            com.facebook.react.modules.core.PermissionListener r8 = r5.createListenerWithPendingPermissionsRequest()     // Catch:{ all -> 0x00cf }
            r6.requestPermissions(r7, r0, r8)     // Catch:{ all -> 0x00cf }
            monitor-exit(r5)
            return r1
        L_0x00c0:
            monitor-exit(r5)
            r5 = 1
            return r5
        L_0x00c3:
            java.lang.String r6 = "Required value was null."
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00cf }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00cf }
            r7.<init>(r6)     // Catch:{ all -> 0x00cf }
            throw r7     // Catch:{ all -> 0x00cf }
        L_0x00cf:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        L_0x00d2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.adapters.react.permissions.PermissionsService.m686createListenerWithPendingPermissionsRequest$lambda22(expo.modules.adapters.react.permissions.PermissionsService, int, java.lang.String[], int[]):boolean");
    }

    private final void askForWriteSettingsPermissionFirst() {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + this.context.getPackageName()));
        intent.addFlags(268435456);
        this.mWriteSettingsPermissionBeingAsked = true;
        this.context.startActivity(intent);
    }

    private final boolean hasWriteSettingsPermission() {
        if (isRuntimePermissionsAvailable()) {
            return Settings.System.canWrite(this.context.getApplicationContext());
        }
        return true;
    }

    private final boolean isRuntimePermissionsAvailable() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public void onHostResume() {
        if (this.mWriteSettingsPermissionBeingAsked) {
            boolean z = false;
            this.mWriteSettingsPermissionBeingAsked = false;
            PermissionsResponseListener permissionsResponseListener = this.mAskAsyncListener;
            Intrinsics.checkNotNull(permissionsResponseListener);
            String[] strArr = this.mAskAsyncRequestedPermissions;
            Intrinsics.checkNotNull(strArr);
            this.mAskAsyncListener = null;
            this.mAskAsyncRequestedPermissions = null;
            if (strArr.length == 0) {
                z = true;
            }
            if (!z) {
                askForManifestPermissions(strArr, permissionsResponseListener);
            } else {
                permissionsResponseListener.onResult(new LinkedHashMap());
            }
        }
    }

    public void getPermissions(PermissionsResponseListener permissionsResponseListener, String... strArr) {
        Intrinsics.checkNotNullParameter(permissionsResponseListener, "responseListener");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Collection arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            arrayList.add(Integer.valueOf(isPermissionGranted(strArr[i]) ? 0 : -1));
        }
        permissionsResponseListener.onResult(parseNativeResult(strArr, CollectionsKt.toIntArray((List) arrayList)));
    }

    public boolean hasGrantedPermissions(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        for (String isPermissionGranted : strArr) {
            if (!isPermissionGranted(isPermissionGranted)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a9  */
    /* renamed from: getPermissionsWithPromise$lambda-6  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m687getPermissionsWithPromise$lambda6(expo.modules.core.Promise r6, java.util.Map r7) {
        /*
            java.lang.String r0 = "$promise"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "permissionsMap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            boolean r0 = r7.isEmpty()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0014
        L_0x0012:
            r0 = r2
            goto L_0x003c
        L_0x0014:
            java.util.Set r0 = r7.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x001c:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0012
            java.lang.Object r3 = r0.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r3 = r3.getValue()
            expo.modules.interfaces.permissions.PermissionsResponse r3 = (expo.modules.interfaces.permissions.PermissionsResponse) r3
            expo.modules.interfaces.permissions.PermissionsStatus r3 = r3.getStatus()
            expo.modules.interfaces.permissions.PermissionsStatus r4 = expo.modules.interfaces.permissions.PermissionsStatus.GRANTED
            if (r3 != r4) goto L_0x0038
            r3 = r2
            goto L_0x0039
        L_0x0038:
            r3 = r1
        L_0x0039:
            if (r3 != 0) goto L_0x001c
            r0 = r1
        L_0x003c:
            boolean r3 = r7.isEmpty()
            if (r3 == 0) goto L_0x0044
        L_0x0042:
            r3 = r2
            goto L_0x006c
        L_0x0044:
            java.util.Set r3 = r7.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x004c:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0042
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r4 = r4.getValue()
            expo.modules.interfaces.permissions.PermissionsResponse r4 = (expo.modules.interfaces.permissions.PermissionsResponse) r4
            expo.modules.interfaces.permissions.PermissionsStatus r4 = r4.getStatus()
            expo.modules.interfaces.permissions.PermissionsStatus r5 = expo.modules.interfaces.permissions.PermissionsStatus.DENIED
            if (r4 != r5) goto L_0x0068
            r4 = r2
            goto L_0x0069
        L_0x0068:
            r4 = r1
        L_0x0069:
            if (r4 != 0) goto L_0x004c
            r3 = r1
        L_0x006c:
            boolean r4 = r7.isEmpty()
            if (r4 == 0) goto L_0x0074
        L_0x0072:
            r1 = r2
            goto L_0x0094
        L_0x0074:
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x007c:
            boolean r4 = r7.hasNext()
            if (r4 == 0) goto L_0x0072
            java.lang.Object r4 = r7.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r4 = r4.getValue()
            expo.modules.interfaces.permissions.PermissionsResponse r4 = (expo.modules.interfaces.permissions.PermissionsResponse) r4
            boolean r4 = r4.getCanAskAgain()
            if (r4 != 0) goto L_0x007c
        L_0x0094:
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            java.lang.String r2 = "expires"
            java.lang.String r4 = "never"
            r7.putString(r2, r4)
            if (r0 == 0) goto L_0x00a9
            expo.modules.interfaces.permissions.PermissionsStatus r2 = expo.modules.interfaces.permissions.PermissionsStatus.GRANTED
            java.lang.String r2 = r2.getStatus()
            goto L_0x00b8
        L_0x00a9:
            if (r3 == 0) goto L_0x00b2
            expo.modules.interfaces.permissions.PermissionsStatus r2 = expo.modules.interfaces.permissions.PermissionsStatus.DENIED
            java.lang.String r2 = r2.getStatus()
            goto L_0x00b8
        L_0x00b2:
            expo.modules.interfaces.permissions.PermissionsStatus r2 = expo.modules.interfaces.permissions.PermissionsStatus.UNDETERMINED
            java.lang.String r2 = r2.getStatus()
        L_0x00b8:
            java.lang.String r3 = "status"
            r7.putString(r3, r2)
            java.lang.String r2 = "canAskAgain"
            r7.putBoolean(r2, r1)
            java.lang.String r1 = "granted"
            r7.putBoolean(r1, r0)
            r6.resolve(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.adapters.react.permissions.PermissionsService.m687getPermissionsWithPromise$lambda6(expo.modules.core.Promise, java.util.Map):void");
    }
}

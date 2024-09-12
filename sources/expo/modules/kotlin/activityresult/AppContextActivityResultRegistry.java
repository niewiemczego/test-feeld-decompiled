package expo.modules.kotlin.activityresult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import expo.modules.kotlin.providers.CurrentActivityProvider;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002:;B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007JH\u0010#\u001a\u00020$\"\b\b\u0000\u0010%*\u00020\u0011\"\u0004\b\u0001\u0010&2\u0006\u0010'\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\"2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H&\u0018\u00010\u000fH\u0002J\b\u0010)\u001a\u00020\u0006H\u0002JC\u0010*\u001a\u00020$\"\b\b\u0000\u0010%*\u00020\u0011\"\u0004\b\u0001\u0010&2\u0006\u0010\u001f\u001a\u00020\u00062\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H&0,2\b\b\u0001\u0010-\u001a\u0002H%H\u0007¢\u0006\u0002\u0010.J\u000e\u0010/\u001a\u00020$2\u0006\u00100\u001a\u000201J\\\u00102\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H&03\"\b\b\u0000\u0010%*\u00020\u0011\"\u0004\b\u0001\u0010&2\u0006\u0010'\u001a\u00020\b2\u0006\u00104\u001a\u0002052\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H&0,2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H&07H\u0007J\u000e\u00108\u001a\u00020$2\u0006\u00100\u001a\u000201J\u0010\u00109\u001a\u00020$2\u0006\u0010'\u001a\u00020\bH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u000eX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0016j\b\u0012\u0004\u0012\u00020\b`\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry;", "", "currentActivityProvider", "Lexpo/modules/kotlin/providers/CurrentActivityProvider;", "(Lexpo/modules/kotlin/providers/CurrentActivityProvider;)V", "INITIAL_REQUEST_CODE_VALUE", "", "LOG_TAG", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "keyToCallbacksAndContract", "", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry$CallbacksAndContract;", "keyToInputParam", "Ljava/io/Serializable;", "keyToLifecycleContainers", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry$LifecycleContainer;", "keyToRequestCode", "launchedKeys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pendingResults", "Landroid/os/Bundle;", "random", "Ljava/util/Random;", "requestCodeToKey", "dispatchResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "doDispatch", "", "I", "O", "key", "callbacksAndContract", "generateRandomNumber", "onLaunch", "contract", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "input", "(ILexpo/modules/kotlin/activityresult/AppContextActivityResultContract;Ljava/io/Serializable;)V", "persistInstanceState", "context", "Landroid/content/Context;", "register", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "fallbackCallback", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;", "restoreInstanceState", "unregister", "CallbacksAndContract", "LifecycleContainer", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AppContextActivityResultRegistry.kt */
public final class AppContextActivityResultRegistry {
    private final int INITIAL_REQUEST_CODE_VALUE = 65536;
    private final String LOG_TAG = "ActivityResultRegistry";
    private final CurrentActivityProvider currentActivityProvider;
    /* access modifiers changed from: private */
    public final Map<String, CallbacksAndContract<?, ?>> keyToCallbacksAndContract = new HashMap();
    /* access modifiers changed from: private */
    public final Map<String, Serializable> keyToInputParam = new HashMap();
    private final Map<String, LifecycleContainer> keyToLifecycleContainers = new HashMap();
    /* access modifiers changed from: private */
    public final Map<String, Integer> keyToRequestCode = new HashMap();
    /* access modifiers changed from: private */
    public ArrayList<String> launchedKeys = new ArrayList<>();
    private final Bundle pendingResults = new Bundle();
    private Random random = new Random();
    private final Map<Integer, String> requestCodeToKey = new HashMap();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AppContextActivityResultRegistry.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AppContextActivityResultRegistry(CurrentActivityProvider currentActivityProvider2) {
        Intrinsics.checkNotNullParameter(currentActivityProvider2, "currentActivityProvider");
        this.currentActivityProvider = currentActivityProvider2;
    }

    private final AppCompatActivity getActivity() {
        Activity currentActivity = this.currentActivityProvider.getCurrentActivity();
        AppCompatActivity appCompatActivity = currentActivity instanceof AppCompatActivity ? (AppCompatActivity) currentActivity : null;
        if (appCompatActivity != null) {
            return appCompatActivity;
        }
        throw new IllegalArgumentException("Current Activity is not available at the moment".toString());
    }

    public final <I extends Serializable, O> void onLaunch(int i, AppContextActivityResultContract<I, O> appContextActivityResultContract, I i2) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(appContextActivityResultContract, "contract");
        Intrinsics.checkNotNullParameter(i2, "input");
        Intent createIntent = appContextActivityResultContract.createIntent(getActivity(), i2);
        if (createIntent.hasExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE)) {
            bundle = createIntent.getBundleExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            createIntent.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
        } else {
            bundle = null;
        }
        Bundle bundle2 = bundle;
        String action = createIntent.getAction();
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -1837081951) {
                if (hashCode == -591152331 && action.equals(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST)) {
                    Parcelable parcelableExtra = createIntent.getParcelableExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST);
                    Intrinsics.checkNotNull(parcelableExtra);
                    IntentSenderRequest intentSenderRequest = (IntentSenderRequest) parcelableExtra;
                    try {
                        ActivityCompat.startIntentSenderForResult(getActivity(), intentSenderRequest.getIntentSender(), i, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle2);
                        return;
                    } catch (IntentSender.SendIntentException e) {
                        new Handler(Looper.getMainLooper()).post(new AppContextActivityResultRegistry$$ExternalSyntheticLambda1(this, i, e));
                        return;
                    }
                }
            } else if (action.equals(ActivityResultContracts.RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS)) {
                String[] stringArrayExtra = createIntent.getStringArrayExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS);
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                ActivityCompat.requestPermissions(getActivity(), stringArrayExtra, i);
                return;
            }
        }
        ActivityCompat.startActivityForResult(getActivity(), createIntent, i, bundle2);
    }

    /* access modifiers changed from: private */
    /* renamed from: onLaunch$lambda-1  reason: not valid java name */
    public static final void m776onLaunch$lambda1(AppContextActivityResultRegistry appContextActivityResultRegistry, int i, IntentSender.SendIntentException sendIntentException) {
        Intrinsics.checkNotNullParameter(appContextActivityResultRegistry, "this$0");
        Intrinsics.checkNotNullParameter(sendIntentException, "$e");
        appContextActivityResultRegistry.dispatchResult(i, 0, new Intent().setAction(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST).putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_SEND_INTENT_EXCEPTION, sendIntentException));
    }

    public final <I extends Serializable, O> AppContextActivityResultLauncher<I, O> register(String str, LifecycleOwner lifecycleOwner, AppContextActivityResultContract<I, O> appContextActivityResultContract, AppContextActivityResultFallbackCallback<I, O> appContextActivityResultFallbackCallback) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(appContextActivityResultContract, "contract");
        Intrinsics.checkNotNullParameter(appContextActivityResultFallbackCallback, "fallbackCallback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycleOwner.lifecycle");
        this.keyToCallbacksAndContract.put(str, new CallbacksAndContract(appContextActivityResultFallbackCallback, (ActivityResultCallback) null, appContextActivityResultContract));
        if (this.keyToRequestCode.get(str) == null) {
            int generateRandomNumber = generateRandomNumber();
            this.requestCodeToKey.put(Integer.valueOf(generateRandomNumber), str);
            this.keyToRequestCode.put(str, Integer.valueOf(generateRandomNumber));
            Unit unit = Unit.INSTANCE;
        }
        AppContextActivityResultRegistry$$ExternalSyntheticLambda0 appContextActivityResultRegistry$$ExternalSyntheticLambda0 = new AppContextActivityResultRegistry$$ExternalSyntheticLambda0(this, str);
        LifecycleContainer lifecycleContainer = this.keyToLifecycleContainers.get(str);
        if (lifecycleContainer == null) {
            lifecycleContainer = new LifecycleContainer(lifecycle);
        }
        lifecycleContainer.addObserver(appContextActivityResultRegistry$$ExternalSyntheticLambda0);
        this.keyToLifecycleContainers.put(str, lifecycleContainer);
        return new AppContextActivityResultRegistry$register$2(appContextActivityResultContract, this, str, appContextActivityResultFallbackCallback);
    }

    /* access modifiers changed from: private */
    /* renamed from: register$lambda-4  reason: not valid java name */
    public static final void m777register$lambda4(AppContextActivityResultRegistry appContextActivityResultRegistry, String str, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ActivityResult activityResult;
        Intrinsics.checkNotNullParameter(appContextActivityResultRegistry, "this$0");
        Intrinsics.checkNotNullParameter(str, "$key");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            CallbacksAndContract callbacksAndContract = appContextActivityResultRegistry.keyToCallbacksAndContract.get(str);
            if (callbacksAndContract != null && (activityResult = (ActivityResult) appContextActivityResultRegistry.pendingResults.getParcelable(str)) != null) {
                appContextActivityResultRegistry.pendingResults.remove(str);
                Serializable serializable = appContextActivityResultRegistry.keyToInputParam.get(str);
                Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type I of expo.modules.kotlin.activityresult.AppContextActivityResultRegistry.register$lambda-4$lambda-3");
                Serializable serializable2 = serializable;
                Object parseResult = callbacksAndContract.getContract().parseResult(serializable2, activityResult.getResultCode(), activityResult.getData());
                if (callbacksAndContract.getMainCallback() != null) {
                    callbacksAndContract.getMainCallback().onActivityResult(parseResult);
                } else {
                    callbacksAndContract.getFallbackCallback().onActivityResult(serializable2, parseResult);
                }
            }
        } else if (i == 2) {
            appContextActivityResultRegistry.unregister(str);
        }
    }

    public final void persistInstanceState(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DataPersistor addStringToIntMap = new DataPersistor(context).addStringArrayList("launchedKeys", this.launchedKeys).addStringToIntMap("keyToRequestCode", this.keyToRequestCode);
        Map<String, Serializable> map = this.keyToInputParam;
        Map linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (this.launchedKeys.contains((String) next.getKey())) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        addStringToIntMap.addStringToSerializableMap("keyToParamsForFallbackCallback", linkedHashMap).addBundle("pendingResult", this.pendingResults).addSerializable("random", this.random).persist();
    }

    public final void restoreInstanceState(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DataPersistor dataPersistor = new DataPersistor(context);
        ArrayList<String> retrieveStringArrayList = dataPersistor.retrieveStringArrayList("launchedKeys");
        if (retrieveStringArrayList != null) {
            this.launchedKeys = retrieveStringArrayList;
        }
        Map<String, Serializable> retrieveStringToSerializableMap = dataPersistor.retrieveStringToSerializableMap("keyToParamsForFallbackCallback");
        if (retrieveStringToSerializableMap != null) {
            this.keyToInputParam.putAll(retrieveStringToSerializableMap);
        }
        Bundle retrieveBundle = dataPersistor.retrieveBundle("pendingResult");
        if (retrieveBundle != null) {
            this.pendingResults.putAll(retrieveBundle);
        }
        Serializable retrieveSerializable = dataPersistor.retrieveSerializable("random");
        if (retrieveSerializable != null) {
            this.random = (Random) retrieveSerializable;
        }
        Map<String, Integer> retrieveStringToIntMap = dataPersistor.retrieveStringToIntMap("keyToRequestCode");
        if (retrieveStringToIntMap != null) {
            for (Map.Entry entry : retrieveStringToIntMap.entrySet()) {
                String str = (String) entry.getKey();
                int intValue = ((Number) entry.getValue()).intValue();
                this.keyToRequestCode.put(str, Integer.valueOf(intValue));
                this.requestCodeToKey.put(Integer.valueOf(intValue), str);
            }
        }
    }

    public final void unregister(String str) {
        Integer remove;
        Intrinsics.checkNotNullParameter(str, "key");
        if (!this.launchedKeys.contains(str) && (remove = this.keyToRequestCode.remove(str)) != null) {
            String remove2 = this.requestCodeToKey.remove(Integer.valueOf(remove.intValue()));
        }
        this.keyToCallbacksAndContract.remove(str);
        if (this.pendingResults.containsKey(str)) {
            Log.w(this.LOG_TAG, "Dropping pending result for request " + str + " : " + this.pendingResults.getParcelable(str));
            this.pendingResults.remove(str);
        }
        LifecycleContainer lifecycleContainer = this.keyToLifecycleContainers.get(str);
        if (lifecycleContainer != null) {
            lifecycleContainer.clearObservers();
            LifecycleContainer remove3 = this.keyToLifecycleContainers.remove(str);
        }
    }

    public final boolean dispatchResult(int i, int i2, Intent intent) {
        String str = this.requestCodeToKey.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        doDispatch(str, i2, intent, this.keyToCallbacksAndContract.get(str));
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = r0.getLifecycle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <I extends java.io.Serializable, O> void doDispatch(java.lang.String r4, int r5, android.content.Intent r6, expo.modules.kotlin.activityresult.AppContextActivityResultRegistry.CallbacksAndContract<I, O> r7) {
        /*
            r3 = this;
            java.util.Map<java.lang.String, expo.modules.kotlin.activityresult.AppContextActivityResultRegistry$LifecycleContainer> r0 = r3.keyToLifecycleContainers
            java.lang.Object r0 = r0.get(r4)
            expo.modules.kotlin.activityresult.AppContextActivityResultRegistry$LifecycleContainer r0 = (expo.modules.kotlin.activityresult.AppContextActivityResultRegistry.LifecycleContainer) r0
            r1 = 0
            if (r0 == 0) goto L_0x0016
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            if (r0 == 0) goto L_0x0016
            androidx.lifecycle.Lifecycle$State r0 = r0.getCurrentState()
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            if (r7 == 0) goto L_0x001d
            androidx.activity.result.ActivityResultCallback r1 = r7.getMainCallback()
        L_0x001d:
            java.lang.String r2 = "null cannot be cast to non-null type I of expo.modules.kotlin.activityresult.AppContextActivityResultRegistry.doDispatch"
            if (r1 == 0) goto L_0x0049
            java.util.ArrayList<java.lang.String> r1 = r3.launchedKeys
            boolean r1 = r1.contains(r4)
            if (r1 == 0) goto L_0x0049
            java.util.Map<java.lang.String, java.io.Serializable> r0 = r3.keyToInputParam
            java.lang.Object r0 = r0.get(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r2)
            java.io.Serializable r0 = (java.io.Serializable) r0
            androidx.activity.result.ActivityResultCallback r1 = r7.getMainCallback()
            expo.modules.kotlin.activityresult.AppContextActivityResultContract r7 = r7.getContract()
            java.lang.Object r5 = r7.parseResult(r0, r5, r6)
            r1.onActivityResult(r5)
            java.util.ArrayList<java.lang.String> r5 = r3.launchedKeys
            r5.remove(r4)
            goto L_0x0089
        L_0x0049:
            if (r0 == 0) goto L_0x007d
            androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED
            boolean r0 = r0.isAtLeast(r1)
            if (r0 == 0) goto L_0x007d
            if (r7 == 0) goto L_0x007d
            java.util.ArrayList<java.lang.String> r0 = r3.launchedKeys
            boolean r0 = r0.contains(r4)
            if (r0 == 0) goto L_0x007d
            java.util.Map<java.lang.String, java.io.Serializable> r0 = r3.keyToInputParam
            java.lang.Object r0 = r0.get(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r2)
            java.io.Serializable r0 = (java.io.Serializable) r0
            expo.modules.kotlin.activityresult.AppContextActivityResultFallbackCallback r1 = r7.getFallbackCallback()
            expo.modules.kotlin.activityresult.AppContextActivityResultContract r7 = r7.getContract()
            java.lang.Object r5 = r7.parseResult(r0, r5, r6)
            r1.onActivityResult(r0, r5)
            java.util.ArrayList<java.lang.String> r5 = r3.launchedKeys
            r5.remove(r4)
            goto L_0x0089
        L_0x007d:
            android.os.Bundle r7 = r3.pendingResults
            androidx.activity.result.ActivityResult r0 = new androidx.activity.result.ActivityResult
            r0.<init>(r5, r6)
            android.os.Parcelable r0 = (android.os.Parcelable) r0
            r7.putParcelable(r4, r0)
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.activityresult.AppContextActivityResultRegistry.doDispatch(java.lang.String, int, android.content.Intent, expo.modules.kotlin.activityresult.AppContextActivityResultRegistry$CallbacksAndContract):void");
    }

    private final int generateRandomNumber() {
        int nextInt = this.random.nextInt((Integer.MAX_VALUE - this.INITIAL_REQUEST_CODE_VALUE) + 1);
        int i = this.INITIAL_REQUEST_CODE_VALUE;
        while (true) {
            int i2 = nextInt + i;
            if (!this.requestCodeToKey.containsKey(Integer.valueOf(i2))) {
                return i2;
            }
            nextInt = this.random.nextInt((Integer.MAX_VALUE - this.INITIAL_REQUEST_CODE_VALUE) + 1);
            i = this.INITIAL_REQUEST_CODE_VALUE;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004B=\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bHÆ\u0003J\u0015\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nHÆ\u0003JS\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry$CallbacksAndContract;", "I", "Ljava/io/Serializable;", "O", "", "fallbackCallback", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;", "mainCallback", "Landroidx/activity/result/ActivityResultCallback;", "contract", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "(Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;Landroidx/activity/result/ActivityResultCallback;Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;)V", "getContract", "()Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "getFallbackCallback", "()Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;", "getMainCallback", "()Landroidx/activity/result/ActivityResultCallback;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AppContextActivityResultRegistry.kt */
    private static final class CallbacksAndContract<I extends Serializable, O> {
        private final AppContextActivityResultContract<I, O> contract;
        private final AppContextActivityResultFallbackCallback<I, O> fallbackCallback;
        private final ActivityResultCallback<O> mainCallback;

        public static /* synthetic */ CallbacksAndContract copy$default(CallbacksAndContract callbacksAndContract, AppContextActivityResultFallbackCallback<I, O> appContextActivityResultFallbackCallback, ActivityResultCallback<O> activityResultCallback, AppContextActivityResultContract<I, O> appContextActivityResultContract, int i, Object obj) {
            if ((i & 1) != 0) {
                appContextActivityResultFallbackCallback = callbacksAndContract.fallbackCallback;
            }
            if ((i & 2) != 0) {
                activityResultCallback = callbacksAndContract.mainCallback;
            }
            if ((i & 4) != 0) {
                appContextActivityResultContract = callbacksAndContract.contract;
            }
            return callbacksAndContract.copy(appContextActivityResultFallbackCallback, activityResultCallback, appContextActivityResultContract);
        }

        public final AppContextActivityResultFallbackCallback<I, O> component1() {
            return this.fallbackCallback;
        }

        public final ActivityResultCallback<O> component2() {
            return this.mainCallback;
        }

        public final AppContextActivityResultContract<I, O> component3() {
            return this.contract;
        }

        public final CallbacksAndContract<I, O> copy(AppContextActivityResultFallbackCallback<I, O> appContextActivityResultFallbackCallback, ActivityResultCallback<O> activityResultCallback, AppContextActivityResultContract<I, O> appContextActivityResultContract) {
            Intrinsics.checkNotNullParameter(appContextActivityResultFallbackCallback, "fallbackCallback");
            Intrinsics.checkNotNullParameter(appContextActivityResultContract, "contract");
            return new CallbacksAndContract<>(appContextActivityResultFallbackCallback, activityResultCallback, appContextActivityResultContract);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CallbacksAndContract)) {
                return false;
            }
            CallbacksAndContract callbacksAndContract = (CallbacksAndContract) obj;
            return Intrinsics.areEqual((Object) this.fallbackCallback, (Object) callbacksAndContract.fallbackCallback) && Intrinsics.areEqual((Object) this.mainCallback, (Object) callbacksAndContract.mainCallback) && Intrinsics.areEqual((Object) this.contract, (Object) callbacksAndContract.contract);
        }

        public int hashCode() {
            int hashCode = this.fallbackCallback.hashCode() * 31;
            ActivityResultCallback<O> activityResultCallback = this.mainCallback;
            return ((hashCode + (activityResultCallback == null ? 0 : activityResultCallback.hashCode())) * 31) + this.contract.hashCode();
        }

        public String toString() {
            AppContextActivityResultFallbackCallback<I, O> appContextActivityResultFallbackCallback = this.fallbackCallback;
            ActivityResultCallback<O> activityResultCallback = this.mainCallback;
            return "CallbacksAndContract(fallbackCallback=" + appContextActivityResultFallbackCallback + ", mainCallback=" + activityResultCallback + ", contract=" + this.contract + ")";
        }

        public CallbacksAndContract(AppContextActivityResultFallbackCallback<I, O> appContextActivityResultFallbackCallback, ActivityResultCallback<O> activityResultCallback, AppContextActivityResultContract<I, O> appContextActivityResultContract) {
            Intrinsics.checkNotNullParameter(appContextActivityResultFallbackCallback, "fallbackCallback");
            Intrinsics.checkNotNullParameter(appContextActivityResultContract, "contract");
            this.fallbackCallback = appContextActivityResultFallbackCallback;
            this.mainCallback = activityResultCallback;
            this.contract = appContextActivityResultContract;
        }

        public final AppContextActivityResultFallbackCallback<I, O> getFallbackCallback() {
            return this.fallbackCallback;
        }

        public final ActivityResultCallback<O> getMainCallback() {
            return this.mainCallback;
        }

        public final AppContextActivityResultContract<I, O> getContract() {
            return this.contract;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry$LifecycleContainer;", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;)V", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "observers", "Ljava/util/ArrayList;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lkotlin/collections/ArrayList;", "addObserver", "", "observer", "clearObservers", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AppContextActivityResultRegistry.kt */
    public static final class LifecycleContainer {
        private final Lifecycle lifecycle;
        private final ArrayList<LifecycleEventObserver> observers = new ArrayList<>();

        public LifecycleContainer(Lifecycle lifecycle2) {
            Intrinsics.checkNotNullParameter(lifecycle2, "lifecycle");
            this.lifecycle = lifecycle2;
        }

        public final Lifecycle getLifecycle() {
            return this.lifecycle;
        }

        public final void addObserver(LifecycleEventObserver lifecycleEventObserver) {
            Intrinsics.checkNotNullParameter(lifecycleEventObserver, "observer");
            this.lifecycle.addObserver(lifecycleEventObserver);
            this.observers.add(lifecycleEventObserver);
        }

        public final void clearObservers() {
            for (LifecycleEventObserver removeObserver : this.observers) {
                this.lifecycle.removeObserver(removeObserver);
            }
            this.observers.clear();
        }
    }
}

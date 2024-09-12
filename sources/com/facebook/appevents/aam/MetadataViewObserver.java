package com.facebook.appevents.aam;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/facebook/appevents/aam/MetadataViewObserver;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "isTracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "processedText", "", "", "uiThreadHandler", "Landroid/os/Handler;", "onGlobalFocusChanged", "", "oldView", "Landroid/view/View;", "newView", "process", "view", "processEditText", "runOnUIThread", "runnable", "Ljava/lang/Runnable;", "startTracking", "stopTracking", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: MetadataViewObserver.kt */
public final class MetadataViewObserver implements ViewTreeObserver.OnGlobalFocusChangeListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_TEXT_LENGTH = 100;
    private static final Map<Integer, MetadataViewObserver> observers = new HashMap();
    private final WeakReference<Activity> activityWeakReference;
    private final AtomicBoolean isTracking;
    private final Set<String> processedText;
    private final Handler uiThreadHandler;

    public /* synthetic */ MetadataViewObserver(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }

    @JvmStatic
    public static final void startTrackingActivity(Activity activity) {
        Class<MetadataViewObserver> cls = MetadataViewObserver.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Companion.startTrackingActivity(activity);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final void stopTrackingActivity(Activity activity) {
        Class<MetadataViewObserver> cls = MetadataViewObserver.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Companion.stopTrackingActivity(activity);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private MetadataViewObserver(Activity activity) {
        this.processedText = new LinkedHashSet();
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        this.activityWeakReference = new WeakReference<>(activity);
        this.isTracking = new AtomicBoolean(false);
    }

    public static final /* synthetic */ Map access$getObservers$cp() {
        Class<MetadataViewObserver> cls = MetadataViewObserver.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return observers;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void access$startTracking(MetadataViewObserver metadataViewObserver) {
        Class<MetadataViewObserver> cls = MetadataViewObserver.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                metadataViewObserver.startTracking();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final /* synthetic */ void access$stopTracking(MetadataViewObserver metadataViewObserver) {
        Class<MetadataViewObserver> cls = MetadataViewObserver.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                metadataViewObserver.stopTracking();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void startTracking() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!this.isTracking.getAndSet(true)) {
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    View rootView = AppEventUtility.getRootView((Activity) this.activityWeakReference.get());
                    if (rootView != null) {
                        ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.addOnGlobalFocusChangeListener(this);
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void stopTracking() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (this.isTracking.getAndSet(false)) {
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    View rootView = AppEventUtility.getRootView((Activity) this.activityWeakReference.get());
                    if (rootView != null) {
                        ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.removeOnGlobalFocusChangeListener(this);
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onGlobalFocusChanged(View view, View view2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            if (view != null) {
                try {
                    process(view);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                    return;
                }
            }
            if (view2 != null) {
                process(view2);
            }
        }
    }

    private final void process(View view) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                runOnUIThread(new MetadataViewObserver$$ExternalSyntheticLambda0(view, this));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: process$lambda-0  reason: not valid java name */
    public static final void m247process$lambda0(View view, MetadataViewObserver metadataViewObserver) {
        Class<MetadataViewObserver> cls = MetadataViewObserver.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(view, "$view");
                Intrinsics.checkNotNullParameter(metadataViewObserver, "this$0");
                if (view instanceof EditText) {
                    metadataViewObserver.processEditText(view);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void processEditText(View view) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                String obj = ((EditText) view).getText().toString();
                if (obj != null) {
                    String obj2 = StringsKt.trim((CharSequence) obj).toString();
                    if (obj2 != null) {
                        String lowerCase = obj2.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                        if (!(lowerCase.length() == 0) && !this.processedText.contains(lowerCase)) {
                            if (lowerCase.length() <= 100) {
                                this.processedText.add(lowerCase);
                                Map hashMap = new HashMap();
                                MetadataMatcher metadataMatcher = MetadataMatcher.INSTANCE;
                                List<String> currentViewIndicators = MetadataMatcher.getCurrentViewIndicators(view);
                                List<String> list = null;
                                for (MetadataRule next : MetadataRule.Companion.getRules()) {
                                    Companion companion = Companion;
                                    String access$preNormalize = companion.preNormalize(next.getName(), lowerCase);
                                    if (next.getValRule().length() > 0) {
                                        MetadataMatcher metadataMatcher2 = MetadataMatcher.INSTANCE;
                                        if (!MetadataMatcher.matchValue(access$preNormalize, next.getValRule())) {
                                        }
                                    }
                                    MetadataMatcher metadataMatcher3 = MetadataMatcher.INSTANCE;
                                    if (MetadataMatcher.matchIndicator(currentViewIndicators, next.getKeyRules())) {
                                        companion.putUserData(hashMap, next.getName(), access$preNormalize);
                                    } else {
                                        if (list == null) {
                                            MetadataMatcher metadataMatcher4 = MetadataMatcher.INSTANCE;
                                            list = MetadataMatcher.getAroundViewIndicators(view);
                                        }
                                        MetadataMatcher metadataMatcher5 = MetadataMatcher.INSTANCE;
                                        if (MetadataMatcher.matchIndicator(list, next.getKeyRules())) {
                                            companion.putUserData(hashMap, next.getName(), access$preNormalize);
                                        }
                                    }
                                }
                                InternalAppEventsLogger.Companion.setInternalUserData(hashMap);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void runOnUIThread(Runnable runnable) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    runnable.run();
                } else {
                    this.uiThreadHandler.post(runnable);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J,\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/aam/MetadataViewObserver$Companion;", "", "()V", "MAX_TEXT_LENGTH", "", "observers", "", "Lcom/facebook/appevents/aam/MetadataViewObserver;", "preNormalize", "", "key", "value", "putUserData", "", "userData", "startTrackingActivity", "activity", "Landroid/app/Activity;", "stopTrackingActivity", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: MetadataViewObserver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void startTrackingActivity(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            int hashCode = activity.hashCode();
            Map access$getObservers$cp = MetadataViewObserver.access$getObservers$cp();
            Integer valueOf = Integer.valueOf(hashCode);
            Object obj = access$getObservers$cp.get(valueOf);
            if (obj == null) {
                obj = new MetadataViewObserver(activity, (DefaultConstructorMarker) null);
                access$getObservers$cp.put(valueOf, obj);
            }
            MetadataViewObserver.access$startTracking((MetadataViewObserver) obj);
        }

        @JvmStatic
        public final void stopTrackingActivity(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            MetadataViewObserver metadataViewObserver = (MetadataViewObserver) MetadataViewObserver.access$getObservers$cp().remove(Integer.valueOf(activity.hashCode()));
            if (metadataViewObserver != null) {
                MetadataViewObserver.access$stopTracking(metadataViewObserver);
            }
        }

        /* access modifiers changed from: private */
        public final String preNormalize(String str, String str2) {
            if (!Intrinsics.areEqual((Object) "r2", (Object) str)) {
                return str2;
            }
            return new Regex("[^\\d.]").replace((CharSequence) str2, "");
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
            if (r8.equals("r5") == false) goto L_0x008c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
            if (r8.equals("r4") == false) goto L_0x008c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
            r9 = new kotlin.text.Regex("[^a-z]+").replace((java.lang.CharSequence) r9, "");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void putUserData(java.util.Map<java.lang.String, java.lang.String> r7, java.lang.String r8, java.lang.String r9) {
            /*
                r6 = this;
                int r0 = r8.hashCode()
                r1 = 0
                r2 = 2
                r3 = 0
                switch(r0) {
                    case 3585: goto L_0x0066;
                    case 3586: goto L_0x004d;
                    case 3587: goto L_0x0044;
                    case 3588: goto L_0x000c;
                    default: goto L_0x000a;
                }
            L_0x000a:
                goto L_0x008c
            L_0x000c:
                java.lang.String r0 = "r6"
                boolean r0 = r8.equals(r0)
                if (r0 != 0) goto L_0x0016
                goto L_0x008c
            L_0x0016:
                r0 = r9
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.String r4 = "-"
                r5 = r4
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                boolean r1 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r0, (java.lang.CharSequence) r5, (boolean) r3, (int) r2, (java.lang.Object) r1)
                if (r1 == 0) goto L_0x008c
                kotlin.text.Regex r9 = new kotlin.text.Regex
                r9.<init>((java.lang.String) r4)
                java.util.List r9 = r9.split(r0, r3)
                java.util.Collection r9 = (java.util.Collection) r9
                java.lang.String[] r0 = new java.lang.String[r3]
                java.lang.Object[] r9 = r9.toArray(r0)
                if (r9 == 0) goto L_0x003c
                java.lang.String[] r9 = (java.lang.String[]) r9
                r9 = r9[r3]
                goto L_0x008c
            L_0x003c:
                java.lang.NullPointerException r7 = new java.lang.NullPointerException
                java.lang.String r8 = "null cannot be cast to non-null type kotlin.Array<T>"
                r7.<init>(r8)
                throw r7
            L_0x0044:
                java.lang.String r0 = "r5"
                boolean r0 = r8.equals(r0)
                if (r0 != 0) goto L_0x0056
                goto L_0x008c
            L_0x004d:
                java.lang.String r0 = "r4"
                boolean r0 = r8.equals(r0)
                if (r0 != 0) goto L_0x0056
                goto L_0x008c
            L_0x0056:
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                kotlin.text.Regex r0 = new kotlin.text.Regex
                java.lang.String r1 = "[^a-z]+"
                r0.<init>((java.lang.String) r1)
                java.lang.String r1 = ""
                java.lang.String r9 = r0.replace((java.lang.CharSequence) r9, (java.lang.String) r1)
                goto L_0x008c
            L_0x0066:
                java.lang.String r0 = "r3"
                boolean r0 = r8.equals(r0)
                if (r0 != 0) goto L_0x006f
                goto L_0x008c
            L_0x006f:
                java.lang.String r0 = "m"
                boolean r4 = kotlin.text.StringsKt.startsWith$default(r9, r0, r3, r2, r1)
                if (r4 != 0) goto L_0x008b
                java.lang.String r4 = "b"
                boolean r4 = kotlin.text.StringsKt.startsWith$default(r9, r4, r3, r2, r1)
                if (r4 != 0) goto L_0x008b
                java.lang.String r4 = "ge"
                boolean r9 = kotlin.text.StringsKt.startsWith$default(r9, r4, r3, r2, r1)
                if (r9 == 0) goto L_0x0088
                goto L_0x008b
            L_0x0088:
                java.lang.String r9 = "f"
                goto L_0x008c
            L_0x008b:
                r9 = r0
            L_0x008c:
                r7.put(r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.aam.MetadataViewObserver.Companion.putUserData(java.util.Map, java.lang.String, java.lang.String):void");
        }
    }
}

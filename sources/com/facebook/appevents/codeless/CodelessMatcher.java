package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessLoggingEventListener;
import com.facebook.appevents.codeless.RCTCodelessLoggingEventListener;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ParameterComponent;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.react.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0001\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0007J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0007J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0007J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R@\u0010\u0006\u001a4\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007j\u001e\u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\f`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher;", "", "()V", "activitiesSet", "", "Landroid/app/Activity;", "activityToListenerMap", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashMap;", "Lkotlin/collections/HashSet;", "listenerSet", "uiThreadHandler", "Landroid/os/Handler;", "viewMatchers", "Lcom/facebook/appevents/codeless/CodelessMatcher$ViewMatcher;", "add", "", "activity", "destroy", "matchViews", "remove", "startTracking", "Companion", "MatchedView", "ViewMatcher", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CodelessMatcher.kt */
public final class CodelessMatcher {
    private static final String CURRENT_CLASS_NAME = ".";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PARENT_CLASS_NAME = "..";
    private static final String TAG = CodelessMatcher.class.getCanonicalName();
    private static CodelessMatcher codelessMatcher;
    private final Set<Activity> activitiesSet;
    private final HashMap<Integer, HashSet<String>> activityToListenerMap;
    private HashSet<String> listenerSet;
    private final Handler uiThreadHandler;
    private final Set<ViewMatcher> viewMatchers;

    public /* synthetic */ CodelessMatcher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final synchronized CodelessMatcher getInstance() {
        Class<CodelessMatcher> cls = CodelessMatcher.class;
        synchronized (cls) {
            if (CrashShieldHandler.isObjectCrashing(cls)) {
                return null;
            }
            try {
                CodelessMatcher instance = Companion.getInstance();
                return instance;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
                return null;
            }
        }
    }

    @JvmStatic
    public static final Bundle getParameters(EventBinding eventBinding, View view, View view2) {
        Class<CodelessMatcher> cls = CodelessMatcher.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.getParameters(eventBinding, view, view2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private CodelessMatcher() {
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        Set<Activity> newSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        Intrinsics.checkNotNullExpressionValue(newSetFromMap, "newSetFromMap(WeakHashMap())");
        this.activitiesSet = newSetFromMap;
        this.viewMatchers = new LinkedHashSet();
        this.listenerSet = new HashSet<>();
        this.activityToListenerMap = new HashMap<>();
    }

    public static final /* synthetic */ CodelessMatcher access$getCodelessMatcher$cp() {
        Class<CodelessMatcher> cls = CodelessMatcher.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return codelessMatcher;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        Class<CodelessMatcher> cls = CodelessMatcher.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void access$setCodelessMatcher$cp(CodelessMatcher codelessMatcher2) {
        Class<CodelessMatcher> cls = CodelessMatcher.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                codelessMatcher = codelessMatcher2;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final void add(Activity activity) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(activity, "activity");
                InternalSettings internalSettings = InternalSettings.INSTANCE;
                if (!InternalSettings.isUnityApp()) {
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        this.activitiesSet.add(activity);
                        this.listenerSet.clear();
                        HashSet<String> hashSet = this.activityToListenerMap.get(Integer.valueOf(activity.hashCode()));
                        if (hashSet != null) {
                            this.listenerSet = hashSet;
                        }
                        startTracking();
                        return;
                    }
                    throw new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void remove(Activity activity) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(activity, "activity");
                InternalSettings internalSettings = InternalSettings.INSTANCE;
                if (!InternalSettings.isUnityApp()) {
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        this.activitiesSet.remove(activity);
                        this.viewMatchers.clear();
                        this.activityToListenerMap.put(Integer.valueOf(activity.hashCode()), (HashSet) this.listenerSet.clone());
                        this.listenerSet.clear();
                        return;
                    }
                    throw new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void destroy(Activity activity) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.activityToListenerMap.remove(Integer.valueOf(activity.hashCode()));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void startTracking() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    matchViews();
                } else {
                    this.uiThreadHandler.post(new CodelessMatcher$$ExternalSyntheticLambda0(this));
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startTracking$lambda-1  reason: not valid java name */
    public static final void m257startTracking$lambda1(CodelessMatcher codelessMatcher2) {
        Class<CodelessMatcher> cls = CodelessMatcher.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(codelessMatcher2, "this$0");
                codelessMatcher2.matchViews();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void matchViews() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                for (Activity next : this.activitiesSet) {
                    if (next != null) {
                        AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                        View rootView = AppEventUtility.getRootView(next);
                        String simpleName = next.getClass().getSimpleName();
                        Handler handler = this.uiThreadHandler;
                        HashSet<String> hashSet = this.listenerSet;
                        Intrinsics.checkNotNullExpressionValue(simpleName, "activityName");
                        this.viewMatchers.add(new ViewMatcher(rootView, handler, hashSet, simpleName));
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\u0003R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$MatchedView;", "", "view", "Landroid/view/View;", "viewMapKey", "", "(Landroid/view/View;Ljava/lang/String;)V", "Ljava/lang/ref/WeakReference;", "getViewMapKey", "()Ljava/lang/String;", "getView", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CodelessMatcher.kt */
    public static final class MatchedView {
        private final WeakReference<View> view;
        private final String viewMapKey;

        public MatchedView(View view2, String str) {
            Intrinsics.checkNotNullParameter(view2, ViewHierarchyConstants.VIEW_KEY);
            Intrinsics.checkNotNullParameter(str, "viewMapKey");
            this.view = new WeakReference<>(view2);
            this.viewMapKey = str;
        }

        public final String getViewMapKey() {
            return this.viewMapKey;
        }

        public final View getView() {
            WeakReference<View> weakReference = this.view;
            if (weakReference == null) {
                return null;
            }
            return (View) weakReference.get();
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001fB7\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0002J \u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J \u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J \u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u001c\u0010\u001a\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0002R\u000e\u0010\f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$ViewMatcher;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "Ljava/lang/Runnable;", "rootView", "Landroid/view/View;", "handler", "Landroid/os/Handler;", "listenerSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "activityName", "(Landroid/view/View;Landroid/os/Handler;Ljava/util/HashSet;Ljava/lang/String;)V", "eventBindings", "", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "Ljava/lang/ref/WeakReference;", "attachListener", "", "matchedView", "Lcom/facebook/appevents/codeless/CodelessMatcher$MatchedView;", "mapping", "attachOnClickListener", "attachOnItemClickListener", "attachRCTListener", "findView", "onGlobalLayout", "onScrollChanged", "run", "startMatch", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CodelessMatcher.kt */
    public static final class ViewMatcher implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String activityName;
        private List<EventBinding> eventBindings;
        private final Handler handler;
        private final HashSet<String> listenerSet;
        private final WeakReference<View> rootView;

        @JvmStatic
        public static final List<MatchedView> findViewByPath(EventBinding eventBinding, View view, List<PathComponent> list, int i, int i2, String str) {
            return Companion.findViewByPath(eventBinding, view, list, i, i2, str);
        }

        public ViewMatcher(View view, Handler handler2, HashSet<String> hashSet, String str) {
            Intrinsics.checkNotNullParameter(handler2, "handler");
            Intrinsics.checkNotNullParameter(hashSet, "listenerSet");
            Intrinsics.checkNotNullParameter(str, "activityName");
            this.rootView = new WeakReference<>(view);
            this.handler = handler2;
            this.listenerSet = hashSet;
            this.activityName = str;
            handler2.postDelayed(this, 200);
        }

        public void run() {
            View view;
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    if (!CrashShieldHandler.isObjectCrashing(this)) {
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        String applicationId = FacebookSdk.getApplicationId();
                        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
                        if (appSettingsWithoutQuery == null) {
                            return;
                        }
                        if (appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                            List<EventBinding> parseArray = EventBinding.Companion.parseArray(appSettingsWithoutQuery.getEventBindings());
                            this.eventBindings = parseArray;
                            if (parseArray != null && (view = (View) this.rootView.get()) != null) {
                                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                                if (viewTreeObserver.isAlive()) {
                                    viewTreeObserver.addOnGlobalLayoutListener(this);
                                    viewTreeObserver.addOnScrollChangedListener(this);
                                }
                                startMatch();
                            }
                        }
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }

        public void onGlobalLayout() {
            startMatch();
        }

        public void onScrollChanged() {
            startMatch();
        }

        private final void startMatch() {
            List<EventBinding> list = this.eventBindings;
            if (list != null && this.rootView.get() != null) {
                int i = 0;
                int size = list.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i2 = i + 1;
                        findView(list.get(i), (View) this.rootView.get());
                        if (i2 <= size) {
                            i = i2;
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        private final void findView(EventBinding eventBinding, View view) {
            if (eventBinding != null && view != null) {
                CharSequence activityName2 = eventBinding.getActivityName();
                if ((activityName2 == null || activityName2.length() == 0) || Intrinsics.areEqual((Object) eventBinding.getActivityName(), (Object) this.activityName)) {
                    List<PathComponent> viewPath = eventBinding.getViewPath();
                    if (viewPath.size() <= 25) {
                        for (MatchedView attachListener : Companion.findViewByPath(eventBinding, view, viewPath, 0, -1, this.activityName)) {
                            attachListener(attachListener, view, eventBinding);
                        }
                    }
                }
            }
        }

        private final void attachListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            if (eventBinding != null) {
                try {
                    View view2 = matchedView.getView();
                    if (view2 != null) {
                        ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                        View findRCTRootView = ViewHierarchy.findRCTRootView(view2);
                        if (findRCTRootView == null || !ViewHierarchy.INSTANCE.isRCTButton(view2, findRCTRootView)) {
                            String name = view2.getClass().getName();
                            Intrinsics.checkNotNullExpressionValue(name, "view.javaClass.name");
                            if (!StringsKt.startsWith$default(name, BuildConfig.LIBRARY_PACKAGE_NAME, false, 2, (Object) null)) {
                                if (!(view2 instanceof AdapterView)) {
                                    attachOnClickListener(matchedView, view, eventBinding);
                                } else if (view2 instanceof ListView) {
                                    attachOnItemClickListener(matchedView, view, eventBinding);
                                }
                            }
                        } else {
                            attachRCTListener(matchedView, view, eventBinding);
                        }
                    }
                } catch (Exception e) {
                    Utility utility = Utility.INSTANCE;
                    Utility.logd(CodelessMatcher.access$getTAG$cp(), e);
                }
            }
        }

        private final void attachOnClickListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            boolean z;
            View view2 = matchedView.getView();
            if (view2 != null) {
                String viewMapKey = matchedView.getViewMapKey();
                ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                View.OnClickListener existingOnClickListener = ViewHierarchy.getExistingOnClickListener(view2);
                if (existingOnClickListener instanceof CodelessLoggingEventListener.AutoLoggingOnClickListener) {
                    if (existingOnClickListener == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnClickListener");
                    } else if (((CodelessLoggingEventListener.AutoLoggingOnClickListener) existingOnClickListener).getSupportCodelessLogging()) {
                        z = true;
                        if (!this.listenerSet.contains(viewMapKey) && !z) {
                            CodelessLoggingEventListener codelessLoggingEventListener = CodelessLoggingEventListener.INSTANCE;
                            view2.setOnClickListener(CodelessLoggingEventListener.getOnClickListener(eventBinding, view, view2));
                            this.listenerSet.add(viewMapKey);
                            return;
                        }
                    }
                }
                z = false;
                if (!this.listenerSet.contains(viewMapKey)) {
                }
            }
        }

        private final void attachOnItemClickListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            boolean z;
            AdapterView adapterView = (AdapterView) matchedView.getView();
            if (adapterView != null) {
                String viewMapKey = matchedView.getViewMapKey();
                AdapterView.OnItemClickListener onItemClickListener = adapterView.getOnItemClickListener();
                if (onItemClickListener instanceof CodelessLoggingEventListener.AutoLoggingOnItemClickListener) {
                    if (onItemClickListener == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnItemClickListener");
                    } else if (((CodelessLoggingEventListener.AutoLoggingOnItemClickListener) onItemClickListener).getSupportCodelessLogging()) {
                        z = true;
                        if (!this.listenerSet.contains(viewMapKey) && !z) {
                            CodelessLoggingEventListener codelessLoggingEventListener = CodelessLoggingEventListener.INSTANCE;
                            adapterView.setOnItemClickListener(CodelessLoggingEventListener.getOnItemClickListener(eventBinding, view, adapterView));
                            this.listenerSet.add(viewMapKey);
                            return;
                        }
                    }
                }
                z = false;
                if (!this.listenerSet.contains(viewMapKey)) {
                }
            }
        }

        private final void attachRCTListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            boolean z;
            View view2 = matchedView.getView();
            if (view2 != null) {
                String viewMapKey = matchedView.getViewMapKey();
                ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                View.OnTouchListener existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(view2);
                if (existingOnTouchListener instanceof RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener) {
                    if (existingOnTouchListener == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener");
                    } else if (((RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener) existingOnTouchListener).getSupportCodelessLogging()) {
                        z = true;
                        if (!this.listenerSet.contains(viewMapKey) && !z) {
                            RCTCodelessLoggingEventListener rCTCodelessLoggingEventListener = RCTCodelessLoggingEventListener.INSTANCE;
                            view2.setOnTouchListener(RCTCodelessLoggingEventListener.getOnTouchListener(eventBinding, view, view2));
                            this.listenerSet.add(viewMapKey);
                            return;
                        }
                    }
                }
                z = false;
                if (!this.listenerSet.contains(viewMapKey)) {
                }
            }
        }

        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JH\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¨\u0006\u0018"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$ViewMatcher$Companion;", "", "()V", "findViewByPath", "", "Lcom/facebook/appevents/codeless/CodelessMatcher$MatchedView;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "view", "Landroid/view/View;", "path", "Lcom/facebook/appevents/codeless/internal/PathComponent;", "level", "", "index", "mapKey", "", "findVisibleChildren", "viewGroup", "Landroid/view/ViewGroup;", "isTheSameView", "", "targetView", "pathElement", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: CodelessMatcher.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final List<MatchedView> findViewByPath(EventBinding eventBinding, View view, List<PathComponent> list, int i, int i2, String str) {
                List<View> findVisibleChildren;
                int size;
                List<View> findVisibleChildren2;
                int size2;
                Intrinsics.checkNotNullParameter(list, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
                Intrinsics.checkNotNullParameter(str, "mapKey");
                String str2 = str + '.' + i2;
                List<MatchedView> arrayList = new ArrayList<>();
                if (view == null) {
                    return arrayList;
                }
                if (i >= list.size()) {
                    arrayList.add(new MatchedView(view, str2));
                } else {
                    PathComponent pathComponent = list.get(i);
                    if (Intrinsics.areEqual((Object) pathComponent.getClassName(), (Object) CodelessMatcher.PARENT_CLASS_NAME)) {
                        ViewParent parent = view.getParent();
                        if ((parent instanceof ViewGroup) && (size2 = findVisibleChildren2.size()) > 0) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3 + 1;
                                arrayList.addAll(findViewByPath(eventBinding, (findVisibleChildren2 = findVisibleChildren((ViewGroup) parent)).get(i3), list, i + 1, i3, str2));
                                if (i4 >= size2) {
                                    break;
                                }
                                i3 = i4;
                            }
                        }
                        return arrayList;
                    } else if (Intrinsics.areEqual((Object) pathComponent.getClassName(), (Object) CodelessMatcher.CURRENT_CLASS_NAME)) {
                        arrayList.add(new MatchedView(view, str2));
                        return arrayList;
                    } else if (!isTheSameView(view, pathComponent, i2)) {
                        return arrayList;
                    } else {
                        if (i == list.size() - 1) {
                            arrayList.add(new MatchedView(view, str2));
                        }
                    }
                }
                if ((view instanceof ViewGroup) && (size = findVisibleChildren.size()) > 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        arrayList.addAll(findViewByPath(eventBinding, (findVisibleChildren = findVisibleChildren((ViewGroup) view)).get(i5), list, i + 1, i5, str2));
                        if (i6 >= size) {
                            break;
                        }
                        i5 = i6;
                    }
                }
                return arrayList;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x006b, code lost:
                if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9.getClass().getSimpleName(), (java.lang.Object) (java.lang.String) r11.get(r11.size() - 1)) == false) goto L_0x006d;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private final boolean isTheSameView(android.view.View r9, com.facebook.appevents.codeless.internal.PathComponent r10, int r11) {
                /*
                    r8 = this;
                    int r0 = r10.getIndex()
                    r1 = 0
                    r2 = -1
                    if (r0 == r2) goto L_0x000f
                    int r0 = r10.getIndex()
                    if (r11 == r0) goto L_0x000f
                    return r1
                L_0x000f:
                    java.lang.Class r11 = r9.getClass()
                    java.lang.String r11 = r11.getCanonicalName()
                    java.lang.String r0 = r10.getClassName()
                    boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r0)
                    r0 = 1
                    if (r11 != 0) goto L_0x006e
                    java.lang.String r11 = r10.getClassName()
                    java.lang.CharSequence r11 = (java.lang.CharSequence) r11
                    kotlin.text.Regex r2 = new kotlin.text.Regex
                    java.lang.String r3 = ".*android\\..*"
                    r2.<init>((java.lang.String) r3)
                    boolean r11 = r2.matches(r11)
                    if (r11 == 0) goto L_0x006d
                    java.lang.String r11 = r10.getClassName()
                    r2 = r11
                    java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                    java.lang.String r11 = "."
                    java.lang.String[] r3 = new java.lang.String[]{r11}
                    r4 = 0
                    r5 = 0
                    r6 = 6
                    r7 = 0
                    java.util.List r11 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r2, (java.lang.String[]) r3, (boolean) r4, (int) r5, (int) r6, (java.lang.Object) r7)
                    r2 = r11
                    java.util.Collection r2 = (java.util.Collection) r2
                    boolean r2 = r2.isEmpty()
                    r2 = r2 ^ r0
                    if (r2 == 0) goto L_0x006d
                    int r2 = r11.size()
                    int r2 = r2 - r0
                    java.lang.Object r11 = r11.get(r2)
                    java.lang.String r11 = (java.lang.String) r11
                    java.lang.Class r2 = r9.getClass()
                    java.lang.String r2 = r2.getSimpleName()
                    boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r11)
                    if (r11 != 0) goto L_0x006e
                L_0x006d:
                    return r1
                L_0x006e:
                    int r11 = r10.getMatchBitmask()
                    com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r2 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.ID
                    int r2 = r2.getValue()
                    r11 = r11 & r2
                    if (r11 <= 0) goto L_0x0086
                    int r11 = r10.getId()
                    int r2 = r9.getId()
                    if (r11 == r2) goto L_0x0086
                    return r1
                L_0x0086:
                    int r11 = r10.getMatchBitmask()
                    com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r2 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.TEXT
                    int r2 = r2.getValue()
                    r11 = r11 & r2
                    java.lang.String r2 = ""
                    if (r11 <= 0) goto L_0x00b8
                    java.lang.String r11 = r10.getText()
                    com.facebook.appevents.codeless.internal.ViewHierarchy r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE
                    java.lang.String r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.getTextOfView(r9)
                    com.facebook.internal.Utility r4 = com.facebook.internal.Utility.INSTANCE
                    com.facebook.internal.Utility r4 = com.facebook.internal.Utility.INSTANCE
                    java.lang.String r4 = com.facebook.internal.Utility.sha256hash((java.lang.String) r3)
                    java.lang.String r4 = com.facebook.internal.Utility.coerceValueIfNullOrEmpty(r4, r2)
                    boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r3)
                    if (r3 != 0) goto L_0x00b8
                    boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r4)
                    if (r11 != 0) goto L_0x00b8
                    return r1
                L_0x00b8:
                    int r11 = r10.getMatchBitmask()
                    com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r3 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.DESCRIPTION
                    int r3 = r3.getValue()
                    r11 = r11 & r3
                    if (r11 <= 0) goto L_0x00f2
                    java.lang.String r11 = r10.getDescription()
                    java.lang.CharSequence r3 = r9.getContentDescription()
                    if (r3 != 0) goto L_0x00d1
                    r3 = r2
                    goto L_0x00d9
                L_0x00d1:
                    java.lang.CharSequence r3 = r9.getContentDescription()
                    java.lang.String r3 = r3.toString()
                L_0x00d9:
                    com.facebook.internal.Utility r4 = com.facebook.internal.Utility.INSTANCE
                    com.facebook.internal.Utility r4 = com.facebook.internal.Utility.INSTANCE
                    java.lang.String r4 = com.facebook.internal.Utility.sha256hash((java.lang.String) r3)
                    java.lang.String r4 = com.facebook.internal.Utility.coerceValueIfNullOrEmpty(r4, r2)
                    boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r3)
                    if (r3 != 0) goto L_0x00f2
                    boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r4)
                    if (r11 != 0) goto L_0x00f2
                    return r1
                L_0x00f2:
                    int r11 = r10.getMatchBitmask()
                    com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r3 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.HINT
                    int r3 = r3.getValue()
                    r11 = r11 & r3
                    if (r11 <= 0) goto L_0x0122
                    java.lang.String r11 = r10.getHint()
                    com.facebook.appevents.codeless.internal.ViewHierarchy r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE
                    java.lang.String r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.getHintOfView(r9)
                    com.facebook.internal.Utility r4 = com.facebook.internal.Utility.INSTANCE
                    com.facebook.internal.Utility r4 = com.facebook.internal.Utility.INSTANCE
                    java.lang.String r4 = com.facebook.internal.Utility.sha256hash((java.lang.String) r3)
                    java.lang.String r4 = com.facebook.internal.Utility.coerceValueIfNullOrEmpty(r4, r2)
                    boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r3)
                    if (r3 != 0) goto L_0x0122
                    boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r4)
                    if (r11 != 0) goto L_0x0122
                    return r1
                L_0x0122:
                    int r11 = r10.getMatchBitmask()
                    com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r3 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.TAG
                    int r3 = r3.getValue()
                    r11 = r11 & r3
                    if (r11 <= 0) goto L_0x015c
                    java.lang.String r10 = r10.getTag()
                    java.lang.Object r11 = r9.getTag()
                    if (r11 != 0) goto L_0x013b
                    r9 = r2
                    goto L_0x0143
                L_0x013b:
                    java.lang.Object r9 = r9.getTag()
                    java.lang.String r9 = r9.toString()
                L_0x0143:
                    com.facebook.internal.Utility r11 = com.facebook.internal.Utility.INSTANCE
                    com.facebook.internal.Utility r11 = com.facebook.internal.Utility.INSTANCE
                    java.lang.String r11 = com.facebook.internal.Utility.sha256hash((java.lang.String) r9)
                    java.lang.String r11 = com.facebook.internal.Utility.coerceValueIfNullOrEmpty(r11, r2)
                    boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r9)
                    if (r9 != 0) goto L_0x015c
                    boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
                    if (r9 != 0) goto L_0x015c
                    return r1
                L_0x015c:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.Companion.isTheSameView(android.view.View, com.facebook.appevents.codeless.internal.PathComponent, int):boolean");
            }

            private final List<View> findVisibleChildren(ViewGroup viewGroup) {
                List<View> arrayList = new ArrayList<>();
                int childCount = viewGroup.getChildCount();
                if (childCount > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt.getVisibility() == 0) {
                            Intrinsics.checkNotNullExpressionValue(childAt, "child");
                            arrayList.add(childAt);
                        }
                        if (i2 >= childCount) {
                            break;
                        }
                        i = i2;
                    }
                }
                return arrayList;
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\tH\u0007J\"\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$Companion;", "", "()V", "CURRENT_CLASS_NAME", "", "PARENT_CLASS_NAME", "TAG", "kotlin.jvm.PlatformType", "codelessMatcher", "Lcom/facebook/appevents/codeless/CodelessMatcher;", "getInstance", "getParameters", "Landroid/os/Bundle;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "rootView", "Landroid/view/View;", "hostView", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CodelessMatcher.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final synchronized CodelessMatcher getInstance() {
            CodelessMatcher access$getCodelessMatcher$cp;
            if (CodelessMatcher.access$getCodelessMatcher$cp() == null) {
                CodelessMatcher.access$setCodelessMatcher$cp(new CodelessMatcher((DefaultConstructorMarker) null));
            }
            access$getCodelessMatcher$cp = CodelessMatcher.access$getCodelessMatcher$cp();
            if (access$getCodelessMatcher$cp == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessMatcher");
            }
            return access$getCodelessMatcher$cp;
        }

        @JvmStatic
        public final Bundle getParameters(EventBinding eventBinding, View view, View view2) {
            List<ParameterComponent> viewParameters;
            List<MatchedView> list;
            Intrinsics.checkNotNullParameter(view, "rootView");
            Intrinsics.checkNotNullParameter(view2, "hostView");
            Bundle bundle = new Bundle();
            if (!(eventBinding == null || (viewParameters = eventBinding.getViewParameters()) == null)) {
                for (ParameterComponent next : viewParameters) {
                    if (next.getValue() != null) {
                        if (next.getValue().length() > 0) {
                            bundle.putString(next.getName(), next.getValue());
                        }
                    }
                    if (next.getPath().size() > 0) {
                        if (Intrinsics.areEqual((Object) next.getPathType(), (Object) Constants.PATH_TYPE_RELATIVE)) {
                            ViewMatcher.Companion companion = ViewMatcher.Companion;
                            List<PathComponent> path = next.getPath();
                            String simpleName = view2.getClass().getSimpleName();
                            Intrinsics.checkNotNullExpressionValue(simpleName, "hostView.javaClass.simpleName");
                            list = companion.findViewByPath(eventBinding, view2, path, 0, -1, simpleName);
                        } else {
                            ViewMatcher.Companion companion2 = ViewMatcher.Companion;
                            List<PathComponent> path2 = next.getPath();
                            String simpleName2 = view.getClass().getSimpleName();
                            Intrinsics.checkNotNullExpressionValue(simpleName2, "rootView.javaClass.simpleName");
                            list = companion2.findViewByPath(eventBinding, view, path2, 0, -1, simpleName2);
                        }
                        Iterator<MatchedView> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            MatchedView next2 = it.next();
                            if (next2.getView() != null) {
                                ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                                String textOfView = ViewHierarchy.getTextOfView(next2.getView());
                                if (textOfView.length() > 0) {
                                    bundle.putString(next.getName(), textOfView);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return bundle;
        }
    }
}

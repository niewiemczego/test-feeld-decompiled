package dev.geundung.zendesk.messaging;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import io.sentry.clientreport.DiscardedEvent;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.Zendesk;
import zendesk.android.ZendeskUser;
import zendesk.android.events.ZendeskEvent;
import zendesk.android.pageviewevents.PageView;
import zendesk.messaging.android.DefaultMessagingFactory;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u0018\u001a\u00020\fH\u0007J\u001a\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u001f\u001a\u00020\fH\u0002J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\nH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Ldev/geundung/zendesk/messaging/ZendeskMessagingModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "initialized", "", "module", "Ldev/geundung/zendesk/messaging/ZendeskNativeModule;", "getName", "", "getUnreadMessageCount", "", "promise", "Lcom/facebook/react/bridge/Promise;", "handleNotification", "remoteMessage", "Lcom/facebook/react/bridge/ReadableMap;", "initialize", "config", "login", "token", "logout", "openMessagingView", "reset", "sendEvent", "eventName", "params", "Lcom/facebook/react/bridge/WritableMap;", "sendPageViewEvent", "event", "setupEventObserver", "updatePushNotificationToken", "newToken", "Companion", "react-native-zendesk-messaging_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ZendeskMessagingModule.kt */
public final class ZendeskMessagingModule extends ReactContextBaseJavaModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NAME = "ZendeskMessaging";
    private boolean initialized;
    private final ZendeskNativeModule module = ZendeskNativeModule.Companion.getInstance();
    private final ReactApplicationContext reactContext;

    public String getName() {
        return NAME;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZendeskMessagingModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        this.reactContext = reactApplicationContext;
    }

    private final void sendEvent(String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    private final void setupEventObserver() {
        this.module.addEventListener(new ZendeskMessagingModule$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupEventObserver$lambda-0  reason: not valid java name */
    public static final void m678setupEventObserver$lambda0(ZendeskMessagingModule zendeskMessagingModule, ZendeskEvent zendeskEvent) {
        Intrinsics.checkNotNullParameter(zendeskMessagingModule, "this$0");
        Intrinsics.checkNotNullParameter(zendeskEvent, "zendeskEvent");
        if (zendeskEvent instanceof ZendeskEvent.UnreadMessageCountChanged) {
            WritableMap createMap = Arguments.createMap();
            Intrinsics.checkNotNullExpressionValue(createMap, "createMap()");
            createMap.putDouble("unreadCount", (double) ((ZendeskEvent.UnreadMessageCountChanged) zendeskEvent).getCurrentUnreadCount());
            zendeskMessagingModule.sendEvent("unreadMessageCountChanged", createMap);
        } else if (zendeskEvent instanceof ZendeskEvent.AuthenticationFailed) {
            WritableMap createMap2 = Arguments.createMap();
            Intrinsics.checkNotNullExpressionValue(createMap2, "createMap()");
            createMap2.putString(DiscardedEvent.JsonKeys.REASON, ((ZendeskEvent.AuthenticationFailed) zendeskEvent).getError().getMessage());
            zendeskMessagingModule.sendEvent("authenticationFailed", createMap2);
        }
    }

    @ReactMethod
    public final void initialize(ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "config");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (this.initialized) {
            promise.resolve((Object) null);
            return;
        }
        String string = readableMap.getString("channelKey");
        Intrinsics.checkNotNull(string, "null cannot be cast to non-null type kotlin.String");
        this.module.initialize(this.reactContext, string, new ZendeskMessagingModule$$ExternalSyntheticLambda7(this, promise), new ZendeskMessagingModule$$ExternalSyntheticLambda8(promise), new DefaultMessagingFactory());
    }

    /* access modifiers changed from: private */
    /* renamed from: initialize$lambda-1  reason: not valid java name */
    public static final void m670initialize$lambda1(ZendeskMessagingModule zendeskMessagingModule, Promise promise, Zendesk zendesk2) {
        Intrinsics.checkNotNullParameter(zendeskMessagingModule, "this$0");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(zendesk2, "<anonymous parameter 0>");
        zendeskMessagingModule.setupEventObserver();
        zendeskMessagingModule.initialized = true;
        promise.resolve((Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: initialize$lambda-2  reason: not valid java name */
    public static final void m671initialize$lambda2(Promise promise, Throwable th) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(th, "error");
        promise.reject(th);
    }

    @ReactMethod
    public final void reset() {
        this.module.reset();
        this.initialized = false;
    }

    @ReactMethod
    public final void login(String str, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (!this.initialized) {
            promise.reject((String) null, "Zendesk instance not initialized");
        } else {
            this.module.loginUser(str, new ZendeskMessagingModule$$ExternalSyntheticLambda5(promise), new ZendeskMessagingModule$$ExternalSyntheticLambda6(promise));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: login$lambda-3  reason: not valid java name */
    public static final void m672login$lambda3(Promise promise, ZendeskUser zendeskUser) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(zendeskUser, "user");
        WritableMap createMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(createMap, "createMap()");
        createMap.putString("id", zendeskUser.getId());
        createMap.putString("externalId", zendeskUser.getExternalId());
        promise.resolve(createMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: login$lambda-4  reason: not valid java name */
    public static final void m673login$lambda4(Promise promise, Throwable th) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(th, "error");
        promise.reject(th);
    }

    @ReactMethod
    public final void logout(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (!this.initialized) {
            promise.reject((String) null, "Zendesk instance not initialized");
        } else {
            this.module.logoutUser(new ZendeskMessagingModule$$ExternalSyntheticLambda3(promise), new ZendeskMessagingModule$$ExternalSyntheticLambda4(promise));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: logout$lambda-5  reason: not valid java name */
    public static final void m674logout$lambda5(Promise promise, Unit unit) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 0>");
        promise.resolve((Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: logout$lambda-6  reason: not valid java name */
    public static final void m675logout$lambda6(Promise promise, Throwable th) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(th, "error");
        promise.reject(th);
    }

    @ReactMethod
    public final void openMessagingView(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (!this.initialized) {
            promise.reject((String) null, "Zendesk instance not initialized");
            return;
        }
        this.module.showMessaging(this.reactContext, 268435456);
        promise.resolve((Object) null);
    }

    @ReactMethod
    public final void sendPageViewEvent(ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "event");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (!this.initialized) {
            promise.reject((String) null, "Zendesk instance not initialized");
            return;
        }
        String string = readableMap.getString("pageTitle");
        Intrinsics.checkNotNull(string, "null cannot be cast to non-null type kotlin.String");
        String string2 = readableMap.getString("pageTitle");
        Intrinsics.checkNotNull(string2, "null cannot be cast to non-null type kotlin.String");
        this.module.sendPageViewEvent(new PageView(string2, string), new ZendeskMessagingModule$$ExternalSyntheticLambda0(promise), new ZendeskMessagingModule$$ExternalSyntheticLambda1(promise));
    }

    /* access modifiers changed from: private */
    /* renamed from: sendPageViewEvent$lambda-7  reason: not valid java name */
    public static final void m676sendPageViewEvent$lambda7(Promise promise, Unit unit) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 0>");
        promise.resolve((Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: sendPageViewEvent$lambda-8  reason: not valid java name */
    public static final void m677sendPageViewEvent$lambda8(Promise promise, Throwable th) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(th, "error");
        promise.reject(th);
    }

    @ReactMethod
    public final void updatePushNotificationToken(String str) {
        Intrinsics.checkNotNullParameter(str, "newToken");
        this.module.updatePushNotificationToken(str);
    }

    @ReactMethod
    public final void getUnreadMessageCount(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (!this.initialized) {
            promise.reject((String) null, "Zendesk instance not initialized");
            return;
        }
        Integer unreadMessageCount = this.module.getUnreadMessageCount();
        promise.resolve(Integer.valueOf(unreadMessageCount != null ? unreadMessageCount.intValue() : 0));
    }

    @ReactMethod
    public final void handleNotification(ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "remoteMessage");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            HashMap<String, Object> hashMap = readableMap.toHashMap();
            Intrinsics.checkNotNullExpressionValue(hashMap, "remoteMessage.toHashMap()");
            Map map = MapsKt.toMap(hashMap);
            Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            this.module.handleNotification(this.reactContext, map, new ZendeskMessagingModule$handleNotification$1(promise));
        } catch (Exception e) {
            promise.reject((Throwable) e);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ldev/geundung/zendesk/messaging/ZendeskMessagingModule$Companion;", "", "()V", "NAME", "", "react-native-zendesk-messaging_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ZendeskMessagingModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

package zendesk.conversationkit.android.internal.faye;

import com.oblador.keychain.KeychainModule;
import com.squareup.moshi.Moshi;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zendesk.conversationkit.android.ConnectionStatus;
import zendesk.conversationkit.android.internal.ActionDispatcher;
import zendesk.conversationkit.android.internal.rest.model.MessageDto;
import zendesk.conversationkit.android.model.AuthenticationType;
import zendesk.conversationkit.android.model.RealtimeSettings;
import zendesk.faye.BayeuxOptionalFields;
import zendesk.faye.DisconnectMessage;
import zendesk.faye.FayeClient;
import zendesk.faye.FayeClientError;
import zendesk.faye.FayeClientListener;
import zendesk.faye.SubscribeMessage;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u001a\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0016J \u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-H\u0002J\u0018\u0010.\u001a\u00020\u00152\u0006\u0010&\u001a\u00020 2\u0006\u0010!\u001a\u00020/H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lzendesk/conversationkit/android/internal/faye/DefaultSunCoFayeClient;", "Lzendesk/conversationkit/android/internal/faye/SunCoFayeClient;", "Lzendesk/faye/FayeClientListener;", "fayeClient", "Lzendesk/faye/FayeClient;", "realtimeSettings", "Lzendesk/conversationkit/android/model/RealtimeSettings;", "authenticationType", "Lzendesk/conversationkit/android/model/AuthenticationType;", "actionDispatcher", "Lzendesk/conversationkit/android/internal/ActionDispatcher;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lzendesk/faye/FayeClient;Lzendesk/conversationkit/android/model/RealtimeSettings;Lzendesk/conversationkit/android/model/AuthenticationType;Lzendesk/conversationkit/android/internal/ActionDispatcher;Lkotlinx/coroutines/CoroutineScope;Lcom/squareup/moshi/Moshi;)V", "connectionStatus", "Lzendesk/conversationkit/android/ConnectionStatus;", "currentConnectionAttempts", "", "connect", "", "disconnect", "onClientError", "fayeClientError", "Lzendesk/faye/FayeClientError;", "throwable", "", "onConnectedToServer", "onDisconnectedFromServer", "onMessagePublished", "channel", "", "message", "onMessageReceived", "onSubscribedToChannel", "onUnsubscribedFromChannel", "processActivityEvent", "conversationId", "activity", "Lzendesk/conversationkit/android/internal/faye/WsActivityEventDto;", "conversation", "Lzendesk/conversationkit/android/internal/faye/WsConversationDto;", "processEvent", "event", "Lorg/json/JSONObject;", "processMessageEvent", "Lzendesk/conversationkit/android/internal/rest/model/MessageDto;", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SunCoFayeClient.kt */
public final class DefaultSunCoFayeClient implements SunCoFayeClient, FayeClientListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "SunCoFayeClient";
    private static final String SUBSCRIBE_EXT_FIELD_APP_ID = "appId";
    private static final String SUBSCRIBE_EXT_FIELD_APP_USER_ID = "appUserId";
    private static final String SUBSCRIBE_EXT_FIELD_JWT = "jwt";
    private static final String SUBSCRIBE_EXT_FIELD_SESSION_TOKEN = "sessionToken";
    /* access modifiers changed from: private */
    public final ActionDispatcher actionDispatcher;
    private final AuthenticationType authenticationType;
    private ConnectionStatus connectionStatus;
    private final CoroutineScope coroutineScope;
    /* access modifiers changed from: private */
    public int currentConnectionAttempts;
    /* access modifiers changed from: private */
    public final FayeClient fayeClient;
    private final Moshi moshi;
    /* access modifiers changed from: private */
    public final RealtimeSettings realtimeSettings;

    public void onMessagePublished(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channel");
        Intrinsics.checkNotNullParameter(str2, "message");
    }

    public DefaultSunCoFayeClient(FayeClient fayeClient2, RealtimeSettings realtimeSettings2, AuthenticationType authenticationType2, ActionDispatcher actionDispatcher2, CoroutineScope coroutineScope2, Moshi moshi2) {
        Intrinsics.checkNotNullParameter(fayeClient2, "fayeClient");
        Intrinsics.checkNotNullParameter(realtimeSettings2, "realtimeSettings");
        Intrinsics.checkNotNullParameter(authenticationType2, KeychainModule.Maps.AUTH_TYPE);
        Intrinsics.checkNotNullParameter(actionDispatcher2, "actionDispatcher");
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.fayeClient = fayeClient2;
        this.realtimeSettings = realtimeSettings2;
        this.authenticationType = authenticationType2;
        this.actionDispatcher = actionDispatcher2;
        this.coroutineScope = coroutineScope2;
        this.moshi = moshi2;
        fayeClient2.addListener(this);
        this.connectionStatus = ConnectionStatus.DISCONNECTED;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DefaultSunCoFayeClient(zendesk.faye.FayeClient r8, zendesk.conversationkit.android.model.RealtimeSettings r9, zendesk.conversationkit.android.model.AuthenticationType r10, zendesk.conversationkit.android.internal.ActionDispatcher r11, kotlinx.coroutines.CoroutineScope r12, com.squareup.moshi.Moshi r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r14 = r14 & 32
            if (r14 == 0) goto L_0x0021
            com.squareup.moshi.Moshi$Builder r13 = new com.squareup.moshi.Moshi$Builder
            r13.<init>()
            java.lang.Class<java.util.Date> r14 = java.util.Date.class
            java.lang.reflect.Type r14 = (java.lang.reflect.Type) r14
            com.squareup.moshi.adapters.Rfc3339DateJsonAdapter r15 = new com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
            r15.<init>()
            com.squareup.moshi.JsonAdapter r15 = (com.squareup.moshi.JsonAdapter) r15
            com.squareup.moshi.Moshi$Builder r13 = r13.add(r14, r15)
            com.squareup.moshi.Moshi r13 = r13.build()
            java.lang.String r14 = "Builder()\n        .add(D…apter())\n        .build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
        L_0x0021:
            r6 = r13
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.faye.DefaultSunCoFayeClient.<init>(zendesk.faye.FayeClient, zendesk.conversationkit.android.model.RealtimeSettings, zendesk.conversationkit.android.model.AuthenticationType, zendesk.conversationkit.android.internal.ActionDispatcher, kotlinx.coroutines.CoroutineScope, com.squareup.moshi.Moshi, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public void connect() {
        if (!this.realtimeSettings.getEnabled()) {
            Logger.w(LOG_TAG, "Realtime is not enabled for the user with id " + this.realtimeSettings.getUserId(), new Object[0]);
            return;
        }
        this.connectionStatus = ConnectionStatus.CONNECTING_REALTIME;
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DefaultSunCoFayeClient$connect$1(this, (Continuation<? super DefaultSunCoFayeClient$connect$1>) null), 3, (Object) null);
    }

    public void disconnect() {
        if (!this.realtimeSettings.getEnabled()) {
            Logger.w(LOG_TAG, "Realtime is not enabled for the user with id " + this.realtimeSettings.getUserId(), new Object[0]);
            return;
        }
        this.connectionStatus = ConnectionStatus.DISCONNECTED;
        this.fayeClient.send(DisconnectMessage.Companion.builder().build());
        JobKt__JobKt.cancelChildren$default(this.coroutineScope.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    public void onClientError(FayeClientError fayeClientError, Throwable th) {
        Intrinsics.checkNotNullParameter(fayeClientError, "fayeClientError");
        Logger.e(LOG_TAG, fayeClientError.name(), th, new Object[0]);
        if ((this.connectionStatus == ConnectionStatus.CONNECTING_REALTIME || this.connectionStatus == ConnectionStatus.DISCONNECTED) && this.currentConnectionAttempts < this.realtimeSettings.getMaxConnectionAttempts()) {
            Logger.d(LOG_TAG, "Reconnecting in %d seconds... [%d/%d]", Long.valueOf(this.realtimeSettings.getRetryInterval()), Integer.valueOf(this.currentConnectionAttempts), Integer.valueOf(this.realtimeSettings.getMaxConnectionAttempts()));
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DefaultSunCoFayeClient$onClientError$1(this, (Continuation<? super DefaultSunCoFayeClient$onClientError$1>) null), 3, (Object) null);
        }
        if (this.currentConnectionAttempts > this.realtimeSettings.getMaxConnectionAttempts()) {
            Logger.e(LOG_TAG, "Failed to reconnect. Attempts exhausted.", new Object[0]);
        }
    }

    public void onConnectedToServer() {
        this.currentConnectionAttempts = 0;
        this.connectionStatus = ConnectionStatus.CONNECTED_REALTIME;
        RealtimeSettings realtimeSettings2 = this.realtimeSettings;
        String str = "/sdk/apps/" + realtimeSettings2.getAppId() + "/appusers/" + realtimeSettings2.getUserId();
        RealtimeSettings realtimeSettings3 = this.realtimeSettings;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", (Object) realtimeSettings3.getAppId());
            jSONObject.put("appUserId", (Object) realtimeSettings3.getUserId());
            AuthenticationType authenticationType2 = this.authenticationType;
            if (authenticationType2 instanceof AuthenticationType.SessionToken) {
                jSONObject.put(SUBSCRIBE_EXT_FIELD_SESSION_TOKEN, (Object) ((AuthenticationType.SessionToken) authenticationType2).getValue());
            } else if (authenticationType2 instanceof AuthenticationType.Jwt) {
                jSONObject.put(SUBSCRIBE_EXT_FIELD_JWT, (Object) ((AuthenticationType.Jwt) authenticationType2).getValue());
            } else {
                Intrinsics.areEqual((Object) authenticationType2, (Object) AuthenticationType.Unauthenticated.INSTANCE);
            }
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "with(realtimeSettings) {…args.toString()\n        }");
        this.fayeClient.send(SubscribeMessage.Companion.builder(str).withOptionalFields(BayeuxOptionalFields.Companion.builder().withExt(jSONObject2).build()).build());
    }

    public void onDisconnectedFromServer() {
        this.connectionStatus = ConnectionStatus.DISCONNECTED;
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DefaultSunCoFayeClient$onDisconnectedFromServer$1(this, (Continuation<? super DefaultSunCoFayeClient$onDisconnectedFromServer$1>) null), 3, (Object) null);
    }

    public void onMessageReceived(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channel");
        Intrinsics.checkNotNullParameter(str2, "message");
        try {
            JSONArray jSONArray = new JSONObject(str2).getJSONArray("events");
            Intrinsics.checkNotNullExpressionValue(jSONArray, "JSONObject(message).getJSONArray(\"events\")");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "events.getJSONObject(i)");
                    processEvent(jSONObject);
                } catch (JSONException e) {
                    Logger.e(LOG_TAG, "Unable to processed events: " + jSONArray, e, new Object[0]);
                }
            }
        } catch (JSONException e2) {
            Logger.e(LOG_TAG, "Unable to processed message: " + str2, e2, new Object[0]);
        }
    }

    private final void processEvent(JSONObject jSONObject) {
        WsFayeMessageDto fromJson = this.moshi.adapter(WsFayeMessageDto.class).fromJson(jSONObject.toString());
        if (fromJson != null) {
            WsFayeMessageType findByValue = WsFayeMessageType.Companion.findByValue(fromJson.getType());
            if (findByValue == WsFayeMessageType.MESSAGE && fromJson.getMessage() != null) {
                processMessageEvent(fromJson.getConversation().getId(), fromJson.getMessage());
            } else if (findByValue != WsFayeMessageType.ACTIVITY || fromJson.getActivity() == null) {
                Logger.w(LOG_TAG, "The message has a type which cannot be processed: " + fromJson, new Object[0]);
            } else {
                processActivityEvent(fromJson.getConversation().getId(), fromJson.getActivity(), fromJson.getConversation());
            }
        }
    }

    private final void processMessageEvent(String str, MessageDto messageDto) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DefaultSunCoFayeClient$processMessageEvent$1(this, str, messageDto, (Continuation<? super DefaultSunCoFayeClient$processMessageEvent$1>) null), 3, (Object) null);
    }

    private final void processActivityEvent(String str, WsActivityEventDto wsActivityEventDto, WsConversationDto wsConversationDto) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DefaultSunCoFayeClient$processActivityEvent$1(this, wsActivityEventDto, str, wsConversationDto, (Continuation<? super DefaultSunCoFayeClient$processActivityEvent$1>) null), 3, (Object) null);
    }

    public void onSubscribedToChannel(String str) {
        Intrinsics.checkNotNullParameter(str, "channel");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DefaultSunCoFayeClient$onSubscribedToChannel$1(this, (Continuation<? super DefaultSunCoFayeClient$onSubscribedToChannel$1>) null), 3, (Object) null);
    }

    public void onUnsubscribedFromChannel(String str) {
        Intrinsics.checkNotNullParameter(str, "channel");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DefaultSunCoFayeClient$onUnsubscribedFromChannel$1(this, (Continuation<? super DefaultSunCoFayeClient$onUnsubscribedFromChannel$1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lzendesk/conversationkit/android/internal/faye/DefaultSunCoFayeClient$Companion;", "", "()V", "LOG_TAG", "", "SUBSCRIBE_EXT_FIELD_APP_ID", "SUBSCRIBE_EXT_FIELD_APP_USER_ID", "SUBSCRIBE_EXT_FIELD_JWT", "SUBSCRIBE_EXT_FIELD_SESSION_TOKEN", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SunCoFayeClient.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

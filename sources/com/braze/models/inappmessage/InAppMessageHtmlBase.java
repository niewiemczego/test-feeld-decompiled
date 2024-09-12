package com.braze.models.inappmessage;

import bo.app.c3;
import bo.app.j;
import bo.app.u2;
import bo.app.x1;
import bo.app.z1;
import com.braze.enums.inappmessage.MessageType;
import com.braze.support.BrazeLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0014¢\u0006\u0004\b\u0015\u0010\u0016B\u0019\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u0015\u0010\u001bJ\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/braze/models/inappmessage/InAppMessageHtmlBase;", "Lcom/braze/models/inappmessage/InAppMessageBase;", "Lcom/braze/models/inappmessage/IInAppMessageHtml;", "", "", "remotePathToLocalAssetMap", "", "setLocalPrefetchedAssetPaths", "buttonId", "", "logButtonClick", "onAfterClosed", "localAssetsDirectoryUrl", "Ljava/lang/String;", "getLocalAssetsDirectoryUrl", "()Ljava/lang/String;", "setLocalAssetsDirectoryUrl", "(Ljava/lang/String;)V", "wasButtonClickLogged", "Z", "buttonIdClicked", "<init>", "()V", "Lorg/json/JSONObject;", "jsonObject", "Lbo/app/z1;", "brazeManager", "(Lorg/json/JSONObject;Lbo/app/z1;)V", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public abstract class InAppMessageHtmlBase extends InAppMessageBase implements IInAppMessageHtml {
    private String buttonIdClicked;
    private String localAssetsDirectoryUrl;
    private boolean wasButtonClickLogged;

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger id not found (this is expected for test sends). Not logging html in-app message button click for id: " + this.b;
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Button Id was null or blank for this html in-app message. Ignoring.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Button click already logged for this html in-app message. Ignoring.";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot log an html in-app message button click because the BrazeManager is null.";
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Logged button click for button id: " + this.b + " and trigger id: " + this.c;
        }
    }

    protected InAppMessageHtmlBase() {
        setOpenUriInWebView(true);
    }

    public String getLocalAssetsDirectoryUrl() {
        return this.localAssetsDirectoryUrl;
    }

    public boolean logButtonClick(String str) {
        Intrinsics.checkNotNullParameter(str, "buttonId");
        String triggerId = getTriggerId();
        z1 brazeManager = getBrazeManager();
        if (triggerId == null || triggerId.length() == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new a(str), 3, (Object) null);
            return false;
        } else if (StringsKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) b.b, 2, (Object) null);
            return false;
        } else if (this.wasButtonClickLogged && getMessageType() != MessageType.HTML) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) c.b, 2, (Object) null);
            return false;
        } else if (brazeManager == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) d.b, 2, (Object) null);
            return false;
        } else {
            x1 d2 = j.h.d(triggerId, str);
            if (d2 != null) {
                brazeManager.a(d2);
            }
            this.buttonIdClicked = str;
            this.wasButtonClickLogged = true;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new e(str, triggerId), 3, (Object) null);
            return true;
        }
    }

    public void onAfterClosed() {
        z1 brazeManager;
        super.onAfterClosed();
        if (this.wasButtonClickLogged) {
            String triggerId = getTriggerId();
            boolean z = false;
            if (!(triggerId == null || StringsKt.isBlank(triggerId))) {
                String str = this.buttonIdClicked;
                if (str == null || StringsKt.isBlank(str)) {
                    z = true;
                }
                if (!z && (brazeManager = getBrazeManager()) != null) {
                    brazeManager.a((u2) new c3(getTriggerId(), this.buttonIdClicked));
                }
            }
        }
    }

    public void setLocalAssetsDirectoryUrl(String str) {
        this.localAssetsDirectoryUrl = str;
    }

    public void setLocalPrefetchedAssetPaths(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "remotePathToLocalAssetMap");
        if (!map.isEmpty()) {
            setLocalAssetsDirectoryUrl(((String[]) map.values().toArray(new String[0]))[0]);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InAppMessageHtmlBase(JSONObject jSONObject, z1 z1Var) {
        super(jSONObject, z1Var, false, false, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        setOpenUriInWebView(jSONObject.optBoolean(InAppMessageBase.OPEN_URI_IN_WEBVIEW, true));
    }
}

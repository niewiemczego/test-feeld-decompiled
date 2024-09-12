package com.braze.models.inappmessage;

import android.graphics.Color;
import android.net.Uri;
import bo.app.c3;
import bo.app.e3;
import bo.app.u2;
import bo.app.x1;
import bo.app.z1;
import com.braze.enums.inappmessage.ClickAction;
import com.braze.enums.inappmessage.CropType;
import com.braze.enums.inappmessage.DismissType;
import com.braze.enums.inappmessage.MessageType;
import com.braze.enums.inappmessage.Orientation;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\b'\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B\n\b\u0010¢\u0006\u0005\b\u0001\u0010*B0\b\u0017\u0012\u0007\u0010\u0001\u001a\u00020\u0014\u0012\u0006\u0010{\u001a\u00020z\u0012\b\b\u0002\u0010q\u001a\u00020\t\u0012\b\b\u0002\u0010s\u001a\u00020\t¢\u0006\u0006\b\u0001\u0010\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u001c\u0010\u0013\u001a\u00020\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0016\u0010\u0016\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR(\u0010#\u001a\u00020\t8\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\b#\u0010$\u0012\u0004\b)\u0010*\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R.\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u00118\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R(\u00101\u001a\u00020\t8\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\b1\u0010$\u0012\u0004\b4\u0010*\u001a\u0004\b2\u0010&\"\u0004\b3\u0010(R(\u00105\u001a\u00020\t8\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\b5\u0010$\u0012\u0004\b8\u0010*\u001a\u0004\b6\u0010&\"\u0004\b7\u0010(R\"\u0010:\u001a\u0002098\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R*\u0010B\u001a\u00020@2\u0006\u0010A\u001a\u00020@8\u0016@VX\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010I\u001a\u00020H8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010P\u001a\u00020O8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010^\u001a\u00020]8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010d\u001a\u00020@8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bd\u0010C\u001a\u0004\be\u0010E\"\u0004\bf\u0010GR\"\u0010g\u001a\u00020@8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bg\u0010C\u001a\u0004\bh\u0010E\"\u0004\bi\u0010GR\"\u0010j\u001a\u00020@8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bj\u0010C\u001a\u0004\bk\u0010E\"\u0004\bl\u0010GR\"\u0010m\u001a\u00020@8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bm\u0010C\u001a\u0004\bn\u0010E\"\u0004\bo\u0010GR\u0014\u0010q\u001a\u00020p8\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010s\u001a\u00020p8\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010rR$\u0010t\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR%\u0010{\u001a\u0004\u0018\u00010z8\u0006@\u0006X\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u0010\u0001R,\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0016\u0010\u0004\u001a\u00020\u00038VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0016\u0010\u0001\u001a\u00020\t8VX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010&R\u0015\u0010\u0001\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u001d¨\u0006\u0001"}, d2 = {"Lcom/braze/models/inappmessage/InAppMessageBase;", "Lcom/braze/models/inappmessage/IInAppMessage;", "Lcom/braze/models/inappmessage/IInAppMessageThemeable;", "Lcom/braze/enums/inappmessage/ClickAction;", "clickAction", "", "setClickBehavior", "Landroid/net/Uri;", "uri", "", "logImpression", "logClick", "onAfterClosed", "enableDarkTheme", "", "", "getRemoteAssetPathsForPrefetch", "", "remotePathToLocalAssetMap", "setLocalPrefetchedAssetPaths", "Lorg/json/JSONObject;", "forJsonPut", "internalClickAction", "Lcom/braze/enums/inappmessage/ClickAction;", "internalUri", "Landroid/net/Uri;", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "icon", "getIcon", "setIcon", "openUriInWebView", "Z", "getOpenUriInWebView", "()Z", "setOpenUriInWebView", "(Z)V", "getOpenUriInWebView$annotations", "()V", "extras", "Ljava/util/Map;", "getExtras", "()Ljava/util/Map;", "setExtras", "(Ljava/util/Map;)V", "animateIn", "getAnimateIn", "setAnimateIn", "getAnimateIn$annotations", "animateOut", "getAnimateOut", "setAnimateOut", "getAnimateOut$annotations", "Lcom/braze/enums/inappmessage/DismissType;", "dismissType", "Lcom/braze/enums/inappmessage/DismissType;", "getDismissType", "()Lcom/braze/enums/inappmessage/DismissType;", "setDismissType", "(Lcom/braze/enums/inappmessage/DismissType;)V", "", "value", "durationInMilliseconds", "I", "getDurationInMilliseconds", "()I", "setDurationInMilliseconds", "(I)V", "Lcom/braze/enums/inappmessage/Orientation;", "orientation", "Lcom/braze/enums/inappmessage/Orientation;", "getOrientation", "()Lcom/braze/enums/inappmessage/Orientation;", "setOrientation", "(Lcom/braze/enums/inappmessage/Orientation;)V", "Lcom/braze/enums/inappmessage/CropType;", "cropType", "Lcom/braze/enums/inappmessage/CropType;", "getCropType", "()Lcom/braze/enums/inappmessage/CropType;", "setCropType", "(Lcom/braze/enums/inappmessage/CropType;)V", "Lcom/braze/enums/inappmessage/TextAlign;", "messageTextAlign", "Lcom/braze/enums/inappmessage/TextAlign;", "getMessageTextAlign", "()Lcom/braze/enums/inappmessage/TextAlign;", "setMessageTextAlign", "(Lcom/braze/enums/inappmessage/TextAlign;)V", "", "expirationTimestamp", "J", "getExpirationTimestamp", "()J", "setExpirationTimestamp", "(J)V", "iconBackgroundColor", "getIconBackgroundColor", "setIconBackgroundColor", "messageTextColor", "getMessageTextColor", "setMessageTextColor", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "iconColor", "getIconColor", "setIconColor", "Ljava/util/concurrent/atomic/AtomicBoolean;", "impressionLogged", "Ljava/util/concurrent/atomic/AtomicBoolean;", "clickLogged", "jsonObject", "Lorg/json/JSONObject;", "getJsonObject", "()Lorg/json/JSONObject;", "setJsonObject", "(Lorg/json/JSONObject;)V", "Lbo/app/z1;", "brazeManager", "Lbo/app/z1;", "getBrazeManager", "()Lbo/app/z1;", "setBrazeManager", "(Lbo/app/z1;)V", "Lbo/app/e3;", "inAppMessageDarkThemeWrapper", "Lbo/app/e3;", "getInAppMessageDarkThemeWrapper", "()Lbo/app/e3;", "setInAppMessageDarkThemeWrapper", "(Lbo/app/e3;)V", "getClickAction", "()Lcom/braze/enums/inappmessage/ClickAction;", "getUri", "()Landroid/net/Uri;", "isControl", "getTriggerId", "triggerId", "<init>", "json", "(Lorg/json/JSONObject;Lbo/app/z1;ZZ)V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public abstract class InAppMessageBase implements IInAppMessage, IInAppMessageThemeable {
    protected static final String ANIMATE_IN = "animate_in";
    protected static final String ANIMATE_OUT = "animate_out";
    public static final String BG_COLOR = "bg_color";
    public static final String CLICK_ACTION = "click_action";
    public static final String CROP_TYPE = "crop_type";
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String DISMISS_TYPE = "message_close";
    public static final String DURATION = "duration";
    public static final String EXTRAS = "extras";
    public static final String ICON = "icon";
    public static final String ICON_BG_COLOR = "icon_bg_color";
    public static final String ICON_COLOR = "icon_color";
    public static final int INAPP_MESSAGE_DURATION_DEFAULT_MILLIS = 5000;
    public static final int INAPP_MESSAGE_DURATION_MIN_MILLIS = 999;
    public static final String IS_CONTROL = "is_control";
    public static final String MESSAGE = "message";
    public static final String MESSAGE_TEXT_ALIGN = "text_align_message";
    public static final String MESSAGE_TEXT_COLOR = "text_color";
    public static final String OPEN_URI_IN_WEBVIEW = "use_webview";
    public static final String ORIENTATION = "orientation";
    public static final String TRIGGER_ID = "trigger_id";
    public static final String TYPE = "type";
    public static final String URI = "uri";
    private boolean animateIn;
    private boolean animateOut;
    private int backgroundColor;
    private z1 brazeManager;
    private final AtomicBoolean clickLogged;
    private CropType cropType;
    private DismissType dismissType;
    private int durationInMilliseconds;
    private long expirationTimestamp;
    private Map<String, String> extras;
    private String icon;
    private int iconBackgroundColor;
    private int iconColor;
    private final AtomicBoolean impressionLogged;
    private e3 inAppMessageDarkThemeWrapper;
    private ClickAction internalClickAction;
    private Uri internalUri;
    private JSONObject jsonObject;
    private String message;
    private TextAlign messageTextAlign;
    private int messageTextColor;
    private boolean openUriInWebView;
    private Orientation orientation;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(int i) {
            super(0);
            this.b = i;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Requested in-app message duration " + this.b + " is lower than the minimum of 999. Defaulting to 5000 milliseconds.";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(int i) {
            super(0);
            this.b = i;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Set in-app message duration to " + this.b + " milliseconds.";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot apply dark theme with a null themes wrapper";
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to construct json for in-app message";
        }
    }

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger id not found (this is expected for test sends). Not logging in-app message click.";
        }
    }

    static final class g extends Lambda implements Function0 {
        public static final g b = new g();

        g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot log an in-app message click because the BrazeManager is null.";
        }
    }

    static final class h extends Lambda implements Function0 {
        public static final h b = new h();

        h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Click already logged for this in-app message. Ignoring.";
        }
    }

    static final class i extends Lambda implements Function0 {
        public static final i b = new i();

        i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Logging click on in-app message";
        }
    }

    static final class j extends Lambda implements Function0 {
        public static final j b = new j();

        j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger id not found (this is expected for test sends). Not logging in-app message impression.";
        }
    }

    static final class k extends Lambda implements Function0 {
        public static final k b = new k();

        k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot log an in-app message impression because the BrazeManager is null.";
        }
    }

    static final class l extends Lambda implements Function0 {
        public static final l b = new l();

        l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Impression already logged for this in-app message. Ignoring.";
        }
    }

    static final class m extends Lambda implements Function0 {
        public static final m b = new m();

        m() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "A non-null URI is required in order to set the message ClickAction to URI.";
        }
    }

    static final class n extends Lambda implements Function0 {
        public static final n b = new n();

        n() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "A non-null URI is required in order to set the message ClickAction to URI.";
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InAppMessageBase(JSONObject jSONObject, z1 z1Var) {
        this(jSONObject, z1Var, false, false, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
    }

    public static /* synthetic */ void getAnimateIn$annotations() {
    }

    public static /* synthetic */ void getAnimateOut$annotations() {
    }

    public static /* synthetic */ void getOpenUriInWebView$annotations() {
    }

    public void enableDarkTheme() {
        e3 e3Var = this.inAppMessageDarkThemeWrapper;
        if (e3Var == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) d.b, 3, (Object) null);
        } else if (e3Var != null) {
            if (e3Var.a() != null) {
                setBackgroundColor(e3Var.a().intValue());
            }
            if (e3Var.f() != null) {
                setIconColor(e3Var.f().intValue());
            }
            if (e3Var.e() != null) {
                setIconBackgroundColor(e3Var.e().intValue());
            }
            if (e3Var.g() != null) {
                setMessageTextColor(e3Var.g().intValue());
            }
        }
    }

    public boolean getAnimateIn() {
        return this.animateIn;
    }

    public boolean getAnimateOut() {
        return this.animateOut;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final z1 getBrazeManager() {
        return this.brazeManager;
    }

    public ClickAction getClickAction() {
        return this.internalClickAction;
    }

    public CropType getCropType() {
        return this.cropType;
    }

    public DismissType getDismissType() {
        return this.dismissType;
    }

    public int getDurationInMilliseconds() {
        return this.durationInMilliseconds;
    }

    public long getExpirationTimestamp() {
        return this.expirationTimestamp;
    }

    public Map<String, String> getExtras() {
        return this.extras;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getIconBackgroundColor() {
        return this.iconBackgroundColor;
    }

    public int getIconColor() {
        return this.iconColor;
    }

    public final e3 getInAppMessageDarkThemeWrapper() {
        return this.inAppMessageDarkThemeWrapper;
    }

    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public String getMessage() {
        return this.message;
    }

    public TextAlign getMessageTextAlign() {
        return this.messageTextAlign;
    }

    public int getMessageTextColor() {
        return this.messageTextColor;
    }

    public boolean getOpenUriInWebView() {
        return this.openUriInWebView;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public List<String> getRemoteAssetPathsForPrefetch() {
        return CollectionsKt.emptyList();
    }

    public final String getTriggerId() {
        JSONObject jSONObject = this.jsonObject;
        if (jSONObject != null) {
            return jSONObject.optString(TRIGGER_ID);
        }
        return null;
    }

    public Uri getUri() {
        return this.internalUri;
    }

    public boolean isControl() {
        JSONObject jSONObject = this.jsonObject;
        return jSONObject != null && jSONObject.optBoolean(IS_CONTROL);
    }

    public boolean logClick() {
        String triggerId = getTriggerId();
        if (triggerId == null || StringsKt.isBlank(triggerId)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) f.b, 3, (Object) null);
            return false;
        }
        z1 z1Var = this.brazeManager;
        if (z1Var == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) g.b, 2, (Object) null);
            return false;
        } else if (!this.clickLogged.get() || getMessageType() == MessageType.HTML) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) i.b, 2, (Object) null);
            x1 g2 = bo.app.j.h.g(triggerId);
            if (g2 != null) {
                z1Var.a(g2);
            }
            this.clickLogged.set(true);
            return true;
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) h.b, 2, (Object) null);
            return false;
        }
    }

    public boolean logImpression() {
        String triggerId = getTriggerId();
        if (triggerId == null || StringsKt.isBlank(triggerId)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.D, (Throwable) null, (Function0) j.b, 2, (Object) null);
            return false;
        }
        z1 z1Var = this.brazeManager;
        if (z1Var == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) k.b, 2, (Object) null);
            return false;
        } else if (this.impressionLogged.get()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) l.b, 2, (Object) null);
            return false;
        } else {
            x1 i2 = bo.app.j.h.i(triggerId);
            if (i2 != null) {
                z1Var.a(i2);
            }
            this.impressionLogged.set(true);
            return true;
        }
    }

    public void onAfterClosed() {
        z1 z1Var;
        String triggerId = getTriggerId();
        if (this.clickLogged.get()) {
            if (!(triggerId == null || triggerId.length() == 0) && (z1Var = this.brazeManager) != null) {
                z1Var.a((u2) new c3(triggerId));
            }
        }
    }

    public void setAnimateIn(boolean z) {
        this.animateIn = z;
    }

    public void setAnimateOut(boolean z) {
        this.animateOut = z;
    }

    public void setBackgroundColor(int i2) {
        this.backgroundColor = i2;
    }

    public final void setBrazeManager(z1 z1Var) {
        this.brazeManager = z1Var;
    }

    public void setClickBehavior(ClickAction clickAction) {
        Intrinsics.checkNotNullParameter(clickAction, "clickAction");
        setClickBehavior(clickAction, (Uri) null);
    }

    public void setCropType(CropType cropType2) {
        Intrinsics.checkNotNullParameter(cropType2, "<set-?>");
        this.cropType = cropType2;
    }

    public void setDismissType(DismissType dismissType2) {
        Intrinsics.checkNotNullParameter(dismissType2, "<set-?>");
        this.dismissType = dismissType2;
    }

    public void setDurationInMilliseconds(int i2) {
        if (i2 < 999) {
            this.durationInMilliseconds = 5000;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new b(i2), 3, (Object) null);
            return;
        }
        this.durationInMilliseconds = i2;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new c(i2), 3, (Object) null);
    }

    public void setExpirationTimestamp(long j2) {
        this.expirationTimestamp = j2;
    }

    public void setExtras(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extras = map;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIconBackgroundColor(int i2) {
        this.iconBackgroundColor = i2;
    }

    public void setIconColor(int i2) {
        this.iconColor = i2;
    }

    public final void setInAppMessageDarkThemeWrapper(e3 e3Var) {
        this.inAppMessageDarkThemeWrapper = e3Var;
    }

    public final void setJsonObject(JSONObject jSONObject) {
        this.jsonObject = jSONObject;
    }

    public void setLocalPrefetchedAssetPaths(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "remotePathToLocalAssetMap");
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMessageTextAlign(TextAlign textAlign) {
        Intrinsics.checkNotNullParameter(textAlign, "<set-?>");
        this.messageTextAlign = textAlign;
    }

    public void setMessageTextColor(int i2) {
        this.messageTextColor = i2;
    }

    public void setOpenUriInWebView(boolean z) {
        this.openUriInWebView = z;
    }

    public void setOrientation(Orientation orientation2) {
        Intrinsics.checkNotNullParameter(orientation2, "<set-?>");
        this.orientation = orientation2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InAppMessageBase(JSONObject jSONObject, z1 z1Var, boolean z) {
        this(jSONObject, z1Var, z, false, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
    }

    public JSONObject forJsonPut() {
        JSONObject jSONObject = this.jsonObject;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("message", getMessage());
            jSONObject2.put("duration", getDurationInMilliseconds());
            jSONObject2.putOpt(TRIGGER_ID, getTriggerId());
            jSONObject2.putOpt(CLICK_ACTION, getClickAction().toString());
            jSONObject2.putOpt(DISMISS_TYPE, getDismissType().toString());
            if (getUri() != null) {
                jSONObject2.put("uri", (Object) String.valueOf(getUri()));
            }
            jSONObject2.put(OPEN_URI_IN_WEBVIEW, getOpenUriInWebView());
            jSONObject2.put(ANIMATE_IN, getAnimateIn());
            jSONObject2.put(ANIMATE_OUT, getAnimateOut());
            jSONObject2.put(BG_COLOR, getBackgroundColor());
            jSONObject2.put(MESSAGE_TEXT_COLOR, getMessageTextColor());
            jSONObject2.put(ICON_COLOR, getIconColor());
            jSONObject2.put(ICON_BG_COLOR, getIconBackgroundColor());
            jSONObject2.putOpt(ICON, getIcon());
            jSONObject2.putOpt(CROP_TYPE, getCropType().toString());
            jSONObject2.putOpt("orientation", getOrientation().toString());
            jSONObject2.putOpt(MESSAGE_TEXT_ALIGN, getMessageTextAlign().toString());
            jSONObject2.putOpt(IS_CONTROL, Boolean.valueOf(isControl()));
            if (!getExtras().isEmpty()) {
                jSONObject2.put("extras", (Object) getExtras());
            }
        } catch (JSONException e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) e.b);
        }
        return jSONObject2;
    }

    public void setClickBehavior(ClickAction clickAction, Uri uri) {
        Intrinsics.checkNotNullParameter(clickAction, "clickAction");
        if (uri == null && clickAction == ClickAction.URI) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) m.b, 2, (Object) null);
        } else if (uri != null && clickAction == ClickAction.URI) {
            this.internalClickAction = clickAction;
            this.internalUri = uri;
        } else if (clickAction != ClickAction.URI) {
            this.internalClickAction = clickAction;
            this.internalUri = null;
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) n.b, 2, (Object) null);
        }
    }

    public InAppMessageBase() {
        this.internalClickAction = ClickAction.NONE;
        this.extras = MapsKt.emptyMap();
        this.animateIn = true;
        this.animateOut = true;
        this.dismissType = DismissType.AUTO_DISMISS;
        this.durationInMilliseconds = 5000;
        this.orientation = Orientation.ANY;
        this.cropType = CropType.FIT_CENTER;
        this.messageTextAlign = TextAlign.CENTER;
        this.expirationTimestamp = -1;
        this.iconBackgroundColor = Color.parseColor("#ff0073d5");
        this.messageTextColor = Color.parseColor("#555555");
        this.backgroundColor = -1;
        this.iconColor = -1;
        this.impressionLogged = new AtomicBoolean(false);
        this.clickLogged = new AtomicBoolean(false);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InAppMessageBase(JSONObject jSONObject, z1 z1Var, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONObject, z1Var, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2);
    }

    public InAppMessageBase(JSONObject jSONObject, z1 z1Var, boolean z, boolean z2) {
        JSONObject jSONObject2 = jSONObject;
        z1 z1Var2 = z1Var;
        Intrinsics.checkNotNullParameter(jSONObject2, "json");
        Intrinsics.checkNotNullParameter(z1Var2, "brazeManager");
        this.internalClickAction = ClickAction.NONE;
        this.extras = MapsKt.emptyMap();
        boolean z3 = true;
        this.animateIn = true;
        this.animateOut = true;
        this.dismissType = DismissType.AUTO_DISMISS;
        this.durationInMilliseconds = 5000;
        Orientation orientation2 = Orientation.ANY;
        this.orientation = orientation2;
        this.cropType = CropType.FIT_CENTER;
        this.messageTextAlign = TextAlign.CENTER;
        this.expirationTimestamp = -1;
        this.iconBackgroundColor = Color.parseColor("#ff0073d5");
        this.messageTextColor = Color.parseColor("#555555");
        this.backgroundColor = -1;
        this.iconColor = -1;
        this.impressionLogged = new AtomicBoolean(false);
        this.clickLogged = new AtomicBoolean(false);
        this.jsonObject = jSONObject2;
        this.brazeManager = z1Var2;
        setMessage(jSONObject2.optString("message"));
        setAnimateIn(jSONObject2.optBoolean(ANIMATE_IN, true));
        setAnimateOut(jSONObject2.optBoolean(ANIMATE_OUT, true));
        setDurationInMilliseconds(jSONObject2.optInt("duration"));
        setIcon(jSONObject2.optString(ICON));
        try {
            com.braze.support.c cVar = com.braze.support.c.a;
            String string = jSONObject2.getString("orientation");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String upperCase = string.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            Orientation[] values = Orientation.values();
            int length = values.length;
            int i2 = 0;
            while (i2 < length) {
                Orientation orientation3 = values[i2];
                if (Intrinsics.areEqual((Object) orientation3.name(), (Object) upperCase)) {
                    if (orientation3 != null) {
                        orientation2 = orientation3;
                    }
                    setOrientation(orientation2);
                    setOpenUriInWebView(jSONObject2.optBoolean(OPEN_URI_IN_WEBVIEW, false));
                    setIconBackgroundColor(jSONObject2.optInt(ICON_BG_COLOR));
                    setMessageTextColor(jSONObject2.optInt(MESSAGE_TEXT_COLOR));
                    setBackgroundColor(jSONObject2.optInt(BG_COLOR));
                    setIconColor(jSONObject2.optInt(ICON_COLOR));
                    this.impressionLogged.set(z);
                    this.clickLogged.set(z2);
                    setExtras(JsonUtils.convertJSONObjectToMap(jSONObject2.optJSONObject("extras")));
                    String optString = jSONObject2.optString("uri");
                    ClickAction clickAction = ClickAction.NONE;
                    try {
                        com.braze.support.c cVar2 = com.braze.support.c.a;
                        String string2 = jSONObject2.getString(CLICK_ACTION);
                        Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(key)");
                        Locale locale2 = Locale.US;
                        Intrinsics.checkNotNullExpressionValue(locale2, "US");
                        String upperCase2 = string2.toUpperCase(locale2);
                        Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(locale)");
                        ClickAction[] values2 = ClickAction.values();
                        int length2 = values2.length;
                        int i3 = 0;
                        while (i3 < length2) {
                            ClickAction clickAction2 = values2[i3];
                            if (Intrinsics.areEqual((Object) clickAction2.name(), (Object) upperCase2)) {
                                if (clickAction2 != null) {
                                    clickAction = clickAction2;
                                }
                                if (clickAction == ClickAction.URI) {
                                    if (optString != null && !StringsKt.isBlank(optString)) {
                                        z3 = false;
                                    }
                                    if (!z3) {
                                        this.internalUri = Uri.parse(optString);
                                    }
                                }
                                this.internalClickAction = clickAction;
                                DismissType dismissType2 = DismissType.AUTO_DISMISS;
                                try {
                                    com.braze.support.c cVar3 = com.braze.support.c.a;
                                    String string3 = jSONObject2.getString(DISMISS_TYPE);
                                    Intrinsics.checkNotNullExpressionValue(string3, "jsonObject.getString(key)");
                                    Locale locale3 = Locale.US;
                                    Intrinsics.checkNotNullExpressionValue(locale3, "US");
                                    String upperCase3 = string3.toUpperCase(locale3);
                                    Intrinsics.checkNotNullExpressionValue(upperCase3, "this as java.lang.String).toUpperCase(locale)");
                                    for (DismissType dismissType3 : DismissType.values()) {
                                        if (Intrinsics.areEqual((Object) dismissType3.name(), (Object) upperCase3)) {
                                            if (dismissType3 != null) {
                                                dismissType2 = dismissType3;
                                            }
                                            setDismissType(dismissType2 == DismissType.SWIPE ? DismissType.MANUAL : dismissType2);
                                            this.inAppMessageDarkThemeWrapper = com.braze.support.h.a(jSONObject);
                                            return;
                                        }
                                    }
                                    throw new NoSuchElementException("Array contains no element matching the predicate.");
                                } catch (Exception unused) {
                                }
                            } else {
                                i3++;
                            }
                        }
                        throw new NoSuchElementException("Array contains no element matching the predicate.");
                    } catch (Exception unused2) {
                    }
                } else {
                    i2++;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (Exception unused3) {
        }
    }
}

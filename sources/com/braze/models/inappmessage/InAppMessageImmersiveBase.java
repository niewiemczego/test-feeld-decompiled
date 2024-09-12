package com.braze.models.inappmessage;

import android.graphics.Color;
import bo.app.c3;
import bo.app.e3;
import bo.app.j;
import bo.app.u2;
import bo.app.x1;
import bo.app.z1;
import com.braze.enums.inappmessage.ImageStyle;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.support.BrazeLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001DB\t\b\u0014¢\u0006\u0004\b;\u0010<B\u0019\b\u0016\u0012\u0006\u0010=\u001a\u00020\n\u0012\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b;\u0010@BI\b\u0012\u0012\u0006\u0010=\u001a\u00020\n\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010A\u001a\u000201¢\u0006\u0004\b;\u0010BJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\"\u0010\r\u001a\u00020\f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010:\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010\u0018¨\u0006E"}, d2 = {"Lcom/braze/models/inappmessage/InAppMessageImmersiveBase;", "Lcom/braze/models/inappmessage/InAppMessageWithImageBase;", "Lcom/braze/models/inappmessage/IInAppMessageImmersive;", "Lcom/braze/models/inappmessage/MessageButton;", "messageButton", "", "logButtonClick", "", "onAfterClosed", "enableDarkTheme", "Lorg/json/JSONObject;", "forJsonPut", "", "headerTextColor", "I", "getHeaderTextColor", "()I", "setHeaderTextColor", "(I)V", "closeButtonColor", "getCloseButtonColor", "setCloseButtonColor", "", "header", "Ljava/lang/String;", "getHeader", "()Ljava/lang/String;", "setHeader", "(Ljava/lang/String;)V", "", "messageButtons", "Ljava/util/List;", "getMessageButtons", "()Ljava/util/List;", "setMessageButtons", "(Ljava/util/List;)V", "Lcom/braze/enums/inappmessage/ImageStyle;", "imageStyle", "Lcom/braze/enums/inappmessage/ImageStyle;", "getImageStyle", "()Lcom/braze/enums/inappmessage/ImageStyle;", "setImageStyle", "(Lcom/braze/enums/inappmessage/ImageStyle;)V", "frameColor", "Ljava/lang/Integer;", "getFrameColor", "()Ljava/lang/Integer;", "setFrameColor", "(Ljava/lang/Integer;)V", "Lcom/braze/enums/inappmessage/TextAlign;", "headerTextAlign", "Lcom/braze/enums/inappmessage/TextAlign;", "getHeaderTextAlign", "()Lcom/braze/enums/inappmessage/TextAlign;", "setHeaderTextAlign", "(Lcom/braze/enums/inappmessage/TextAlign;)V", "wasButtonClickLogged", "Z", "buttonIdClicked", "<init>", "()V", "jsonObject", "Lbo/app/z1;", "brazeManager", "(Lorg/json/JSONObject;Lbo/app/z1;)V", "messageTextAlign", "(Lorg/json/JSONObject;Lbo/app/z1;Ljava/lang/String;IILcom/braze/enums/inappmessage/ImageStyle;Lcom/braze/enums/inappmessage/TextAlign;Lcom/braze/enums/inappmessage/TextAlign;)V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public abstract class InAppMessageImmersiveBase extends InAppMessageWithImageBase implements IInAppMessageImmersive {
    private static final String BUTTONS = "btns";
    private static final String CLOSE_BUTTON_COLOR = "close_btn_color";
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final String FRAME_COLOR = "frame_color";
    private static final String HEADER = "header";
    private static final String HEADER_TEXT_ALIGN = "text_align_header";
    private static final String HEADER_TEXT_COLOR = "header_text_color";
    private static final String IMAGE_STYLE = "image_style";
    private String buttonIdClicked;
    private int closeButtonColor;
    private Integer frameColor;
    private String header;
    private TextAlign headerTextAlign;
    private int headerTextColor;
    private ImageStyle imageStyle;
    private List<? extends MessageButton> messageButtons;
    private boolean wasButtonClickLogged;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot apply dark theme with a null themes wrapper";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger id not found (this is expected for test sends). Not logging button click.";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Button click already logged for this message. Ignoring.";
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot log a button click because the BrazeManager is null.";
        }
    }

    public static final class f extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(JSONArray jSONArray) {
            super(1);
            this.b = jSONArray;
        }

        public final Boolean a(int i) {
            return Boolean.valueOf(this.b.opt(i) instanceof JSONObject);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static final class g extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(JSONArray jSONArray) {
            super(1);
            this.b = jSONArray;
        }

        public final Object a(int i) {
            Object obj = this.b.get(i);
            if (obj != null) {
                return (JSONObject) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    protected InAppMessageImmersiveBase() {
        this.headerTextColor = Color.parseColor("#333333");
        this.closeButtonColor = Color.parseColor("#9B9B9B");
        this.messageButtons = CollectionsKt.emptyList();
        this.imageStyle = ImageStyle.TOP;
        this.headerTextAlign = TextAlign.CENTER;
    }

    public void enableDarkTheme() {
        super.enableDarkTheme();
        e3 inAppMessageDarkThemeWrapper = getInAppMessageDarkThemeWrapper();
        if (inAppMessageDarkThemeWrapper == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) b.b, 3, (Object) null);
            return;
        }
        if (inAppMessageDarkThemeWrapper.c() != null) {
            setFrameColor(inAppMessageDarkThemeWrapper.c());
        }
        if (inAppMessageDarkThemeWrapper.b() != null) {
            setCloseButtonColor(inAppMessageDarkThemeWrapper.b().intValue());
        }
        if (inAppMessageDarkThemeWrapper.d() != null) {
            setHeaderTextColor(inAppMessageDarkThemeWrapper.d().intValue());
        }
        for (MessageButton enableDarkTheme : getMessageButtons()) {
            enableDarkTheme.enableDarkTheme();
        }
    }

    public int getCloseButtonColor() {
        return this.closeButtonColor;
    }

    public Integer getFrameColor() {
        return this.frameColor;
    }

    public String getHeader() {
        return this.header;
    }

    public TextAlign getHeaderTextAlign() {
        return this.headerTextAlign;
    }

    public int getHeaderTextColor() {
        return this.headerTextColor;
    }

    public ImageStyle getImageStyle() {
        return this.imageStyle;
    }

    public List<MessageButton> getMessageButtons() {
        return this.messageButtons;
    }

    public boolean logButtonClick(MessageButton messageButton) {
        Intrinsics.checkNotNullParameter(messageButton, "messageButton");
        z1 brazeManager = getBrazeManager();
        String triggerId = getTriggerId();
        if (triggerId == null || StringsKt.isBlank(triggerId)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) c.b, 3, (Object) null);
            return false;
        } else if (this.wasButtonClickLogged) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) d.b, 2, (Object) null);
            return false;
        } else if (brazeManager == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) e.b, 2, (Object) null);
            return false;
        } else {
            this.buttonIdClicked = messageButton.getStringId();
            x1 a2 = j.h.a(triggerId, messageButton);
            if (a2 != null) {
                brazeManager.a(a2);
            }
            this.wasButtonClickLogged = true;
            return true;
        }
    }

    public void onAfterClosed() {
        super.onAfterClosed();
        z1 brazeManager = getBrazeManager();
        if (this.wasButtonClickLogged) {
            String triggerId = getTriggerId();
            boolean z = false;
            if (!(triggerId == null || StringsKt.isBlank(triggerId))) {
                String str = this.buttonIdClicked;
                if (str == null || StringsKt.isBlank(str)) {
                    z = true;
                }
                if (!z && brazeManager != null) {
                    brazeManager.a((u2) new c3(getTriggerId(), this.buttonIdClicked));
                }
            }
        }
    }

    public void setCloseButtonColor(int i) {
        this.closeButtonColor = i;
    }

    public void setFrameColor(Integer num) {
        this.frameColor = num;
    }

    public void setHeader(String str) {
        this.header = str;
    }

    public void setHeaderTextAlign(TextAlign textAlign) {
        Intrinsics.checkNotNullParameter(textAlign, "<set-?>");
        this.headerTextAlign = textAlign;
    }

    public void setHeaderTextColor(int i) {
        this.headerTextColor = i;
    }

    public void setImageStyle(ImageStyle imageStyle2) {
        Intrinsics.checkNotNullParameter(imageStyle2, "<set-?>");
        this.imageStyle = imageStyle2;
    }

    public void setMessageButtons(List<? extends MessageButton> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.messageButtons = list;
    }

    public JSONObject forJsonPut() {
        JSONObject jsonObject = getJsonObject();
        if (jsonObject != null) {
            return jsonObject;
        }
        JSONObject forJsonPut = super.forJsonPut();
        try {
            forJsonPut.putOpt(HEADER, getHeader());
            forJsonPut.put(HEADER_TEXT_COLOR, getHeaderTextColor());
            forJsonPut.put(CLOSE_BUTTON_COLOR, getCloseButtonColor());
            forJsonPut.putOpt(IMAGE_STYLE, getImageStyle().toString());
            forJsonPut.putOpt(HEADER_TEXT_ALIGN, getHeaderTextAlign().toString());
            Integer frameColor2 = getFrameColor();
            if (frameColor2 != null) {
                forJsonPut.put(FRAME_COLOR, frameColor2.intValue());
            }
            JSONArray jSONArray = new JSONArray();
            for (MessageButton forJsonPut2 : getMessageButtons()) {
                jSONArray.put((Object) forJsonPut2.forJsonPut());
            }
            forJsonPut.put(BUTTONS, (Object) jSONArray);
        } catch (JSONException unused) {
        }
        return forJsonPut;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InAppMessageImmersiveBase(org.json.JSONObject r17, bo.app.z1 r18) {
        /*
            r16 = this;
            r9 = r17
            java.lang.String r0 = "Array contains no element matching the predicate."
            java.lang.String r1 = "this as java.lang.String).toUpperCase(locale)"
            java.lang.String r2 = "US"
            java.lang.String r3 = "jsonObject.getString(key)"
            java.lang.String r4 = "jsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r4)
            java.lang.String r4 = "brazeManager"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r4)
            java.lang.String r4 = "header"
            java.lang.String r4 = r9.optString(r4)
            java.lang.String r6 = "jsonObject.optString(HEADER)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            java.lang.String r6 = "header_text_color"
            int r6 = r9.optInt(r6)
            java.lang.String r7 = "close_btn_color"
            int r7 = r9.optInt(r7)
            java.lang.String r8 = "image_style"
            com.braze.enums.inappmessage.ImageStyle r10 = com.braze.enums.inappmessage.ImageStyle.TOP
            com.braze.support.c r12 = com.braze.support.c.a     // Catch:{ Exception -> 0x0066 }
            java.lang.String r8 = r9.getString(r8)     // Catch:{ Exception -> 0x0066 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)     // Catch:{ Exception -> 0x0066 }
            java.util.Locale r12 = java.util.Locale.US     // Catch:{ Exception -> 0x0066 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r2)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r8 = r8.toUpperCase(r12)     // Catch:{ Exception -> 0x0066 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)     // Catch:{ Exception -> 0x0066 }
            com.braze.enums.inappmessage.ImageStyle[] r12 = com.braze.enums.inappmessage.ImageStyle.values()     // Catch:{ Exception -> 0x0066 }
            int r13 = r12.length     // Catch:{ Exception -> 0x0066 }
            r14 = 0
        L_0x004c:
            if (r14 >= r13) goto L_0x0060
            r15 = r12[r14]     // Catch:{ Exception -> 0x0066 }
            java.lang.String r11 = r15.name()     // Catch:{ Exception -> 0x0066 }
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r8)     // Catch:{ Exception -> 0x0066 }
            if (r11 == 0) goto L_0x005d
            if (r15 != 0) goto L_0x0067
            goto L_0x0066
        L_0x005d:
            int r14 = r14 + 1
            goto L_0x004c
        L_0x0060:
            java.util.NoSuchElementException r8 = new java.util.NoSuchElementException     // Catch:{ Exception -> 0x0066 }
            r8.<init>(r0)     // Catch:{ Exception -> 0x0066 }
            throw r8     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            r15 = r10
        L_0x0067:
            java.lang.String r8 = "text_align_header"
            com.braze.enums.inappmessage.TextAlign r10 = com.braze.enums.inappmessage.TextAlign.CENTER
            com.braze.support.c r11 = com.braze.support.c.a     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r8 = r9.getString(r8)     // Catch:{ Exception -> 0x00a2 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)     // Catch:{ Exception -> 0x00a2 }
            java.util.Locale r11 = java.util.Locale.US     // Catch:{ Exception -> 0x00a2 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r2)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r8 = r8.toUpperCase(r11)     // Catch:{ Exception -> 0x00a2 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)     // Catch:{ Exception -> 0x00a2 }
            com.braze.enums.inappmessage.TextAlign[] r11 = com.braze.enums.inappmessage.TextAlign.values()     // Catch:{ Exception -> 0x00a2 }
            int r12 = r11.length     // Catch:{ Exception -> 0x00a2 }
            r13 = 0
        L_0x0086:
            if (r13 >= r12) goto L_0x009c
            r14 = r11[r13]     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r5 = r14.name()     // Catch:{ Exception -> 0x00a2 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r8)     // Catch:{ Exception -> 0x00a2 }
            if (r5 == 0) goto L_0x0097
            if (r14 != 0) goto L_0x00a3
            goto L_0x00a2
        L_0x0097:
            int r13 = r13 + 1
            r5 = r18
            goto L_0x0086
        L_0x009c:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException     // Catch:{ Exception -> 0x00a2 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x00a2 }
            throw r5     // Catch:{ Exception -> 0x00a2 }
        L_0x00a2:
            r14 = r10
        L_0x00a3:
            java.lang.String r5 = "text_align_message"
            com.braze.enums.inappmessage.TextAlign r8 = com.braze.enums.inappmessage.TextAlign.CENTER
            com.braze.support.c r10 = com.braze.support.c.a     // Catch:{ Exception -> 0x00de }
            java.lang.String r5 = r9.getString(r5)     // Catch:{ Exception -> 0x00de }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)     // Catch:{ Exception -> 0x00de }
            java.util.Locale r3 = java.util.Locale.US     // Catch:{ Exception -> 0x00de }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)     // Catch:{ Exception -> 0x00de }
            java.lang.String r2 = r5.toUpperCase(r3)     // Catch:{ Exception -> 0x00de }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)     // Catch:{ Exception -> 0x00de }
            com.braze.enums.inappmessage.TextAlign[] r1 = com.braze.enums.inappmessage.TextAlign.values()     // Catch:{ Exception -> 0x00de }
            int r3 = r1.length     // Catch:{ Exception -> 0x00de }
            r5 = 0
        L_0x00c2:
            if (r5 >= r3) goto L_0x00d8
            r10 = r1[r5]     // Catch:{ Exception -> 0x00de }
            java.lang.String r11 = r10.name()     // Catch:{ Exception -> 0x00de }
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r2)     // Catch:{ Exception -> 0x00de }
            if (r11 == 0) goto L_0x00d5
            if (r10 != 0) goto L_0x00d3
            goto L_0x00de
        L_0x00d3:
            r8 = r10
            goto L_0x00de
        L_0x00d5:
            int r5 = r5 + 1
            goto L_0x00c2
        L_0x00d8:
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException     // Catch:{ Exception -> 0x00de }
            r1.<init>(r0)     // Catch:{ Exception -> 0x00de }
            throw r1     // Catch:{ Exception -> 0x00de }
        L_0x00de:
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r4
            r4 = r6
            r5 = r7
            r6 = r15
            r7 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            java.lang.String r0 = "btns"
            org.json.JSONArray r0 = r9.optJSONArray(r0)
            org.json.JSONArray r1 = com.braze.support.h.b(r17)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            if (r0 != 0) goto L_0x0106
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            java.util.Iterator r0 = r0.iterator()
            goto L_0x0129
        L_0x0106:
            int r3 = r0.length()
            r4 = 0
            kotlin.ranges.IntRange r3 = kotlin.ranges.RangesKt.until((int) r4, (int) r3)
            kotlin.sequences.Sequence r3 = kotlin.collections.CollectionsKt.asSequence(r3)
            com.braze.models.inappmessage.InAppMessageImmersiveBase$f r4 = new com.braze.models.inappmessage.InAppMessageImmersiveBase$f
            r4.<init>(r0)
            kotlin.sequences.Sequence r3 = kotlin.sequences.SequencesKt.filter(r3, r4)
            com.braze.models.inappmessage.InAppMessageImmersiveBase$g r4 = new com.braze.models.inappmessage.InAppMessageImmersiveBase$g
            r4.<init>(r0)
            kotlin.sequences.Sequence r0 = kotlin.sequences.SequencesKt.map(r3, r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0129:
            java.util.Iterator r0 = kotlin.collections.CollectionsKt.withIndex(r0)
        L_0x012d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0150
            java.lang.Object r3 = r0.next()
            kotlin.collections.IndexedValue r3 = (kotlin.collections.IndexedValue) r3
            com.braze.models.inappmessage.MessageButton r4 = new com.braze.models.inappmessage.MessageButton
            java.lang.Object r5 = r3.getValue()
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            int r3 = r3.getIndex()
            org.json.JSONObject r3 = r1.optJSONObject(r3)
            r4.<init>(r5, r3)
            r2.add(r4)
            goto L_0x012d
        L_0x0150:
            r3 = r16
            r3.setMessageButtons(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.models.inappmessage.InAppMessageImmersiveBase.<init>(org.json.JSONObject, bo.app.z1):void");
    }

    private InAppMessageImmersiveBase(JSONObject jSONObject, z1 z1Var, String str, int i, int i2, ImageStyle imageStyle2, TextAlign textAlign, TextAlign textAlign2) {
        super(jSONObject, z1Var);
        this.headerTextColor = Color.parseColor("#333333");
        this.closeButtonColor = Color.parseColor("#9B9B9B");
        this.messageButtons = CollectionsKt.emptyList();
        this.imageStyle = ImageStyle.TOP;
        this.headerTextAlign = TextAlign.CENTER;
        setHeader(str);
        setHeaderTextColor(i);
        setCloseButtonColor(i2);
        if (jSONObject.has(FRAME_COLOR)) {
            setFrameColor(Integer.valueOf(jSONObject.optInt(FRAME_COLOR)));
        }
        setImageStyle(imageStyle2);
        setHeaderTextAlign(textAlign);
        setMessageTextAlign(textAlign2);
    }
}

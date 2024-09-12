package com.braze.models.inappmessage;

import android.graphics.Color;
import bo.app.e3;
import bo.app.z1;
import com.braze.enums.inappmessage.CropType;
import com.braze.enums.inappmessage.MessageType;
import com.braze.enums.inappmessage.SlideFrom;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\t\b\u0016¢\u0006\u0004\b\u0018\u0010\u0019B\u0019\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0018\u0010\u001dB+\b\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/braze/models/inappmessage/InAppMessageSlideup;", "Lcom/braze/models/inappmessage/InAppMessageWithImageBase;", "", "enableDarkTheme", "Lorg/json/JSONObject;", "forJsonPut", "Lcom/braze/enums/inappmessage/SlideFrom;", "slideFrom", "Lcom/braze/enums/inappmessage/SlideFrom;", "getSlideFrom", "()Lcom/braze/enums/inappmessage/SlideFrom;", "setSlideFrom", "(Lcom/braze/enums/inappmessage/SlideFrom;)V", "", "chevronColor", "I", "getChevronColor", "()I", "setChevronColor", "(I)V", "Lcom/braze/enums/inappmessage/MessageType;", "getMessageType", "()Lcom/braze/enums/inappmessage/MessageType;", "messageType", "<init>", "()V", "jsonObject", "Lbo/app/z1;", "brazeManager", "(Lorg/json/JSONObject;Lbo/app/z1;)V", "(Lorg/json/JSONObject;Lbo/app/z1;Lcom/braze/enums/inappmessage/SlideFrom;I)V", "Companion", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public final class InAppMessageSlideup extends InAppMessageWithImageBase {
    private static final String CHEVRON_COLOR = "close_btn_color";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SLIDE_FROM = "slide_from";
    private int chevronColor;
    private SlideFrom slideFrom;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/braze/models/inappmessage/InAppMessageSlideup$Companion;", "", "()V", "CHEVRON_COLOR", "", "SLIDE_FROM", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot apply dark theme with a null themes wrapper";
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error creating JSON.";
        }
    }

    public InAppMessageSlideup() {
        this.slideFrom = SlideFrom.BOTTOM;
        this.chevronColor = Color.parseColor("#9B9B9B");
        setMessageTextAlign(TextAlign.START);
    }

    public void enableDarkTheme() {
        super.enableDarkTheme();
        e3 inAppMessageDarkThemeWrapper = getInAppMessageDarkThemeWrapper();
        if (inAppMessageDarkThemeWrapper == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.D, (Throwable) null, (Function0) a.b, 2, (Object) null);
            return;
        }
        Integer b2 = inAppMessageDarkThemeWrapper.b();
        if ((b2 == null || b2.intValue() != -1) && inAppMessageDarkThemeWrapper.b() != null) {
            this.chevronColor = inAppMessageDarkThemeWrapper.b().intValue();
        }
    }

    public final int getChevronColor() {
        return this.chevronColor;
    }

    public MessageType getMessageType() {
        return MessageType.SLIDEUP;
    }

    public final SlideFrom getSlideFrom() {
        return this.slideFrom;
    }

    public final void setChevronColor(int i) {
        this.chevronColor = i;
    }

    public final void setSlideFrom(SlideFrom slideFrom2) {
        Intrinsics.checkNotNullParameter(slideFrom2, "<set-?>");
        this.slideFrom = slideFrom2;
    }

    public JSONObject forJsonPut() {
        JSONObject jsonObject = getJsonObject();
        if (jsonObject != null) {
            return jsonObject;
        }
        JSONObject forJsonPut = super.forJsonPut();
        try {
            forJsonPut.put(SLIDE_FROM, (Object) this.slideFrom.toString());
            forJsonPut.put(CHEVRON_COLOR, this.chevronColor);
            forJsonPut.put("type", (Object) getMessageType().name());
        } catch (JSONException e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) b.b);
        }
        return forJsonPut;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InAppMessageSlideup(JSONObject jSONObject, z1 z1Var) {
        this(jSONObject, z1Var, (SlideFrom) JsonUtils.optEnum(jSONObject, SLIDE_FROM, SlideFrom.class, SlideFrom.BOTTOM), jSONObject.optInt(CHEVRON_COLOR));
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
    }

    private InAppMessageSlideup(JSONObject jSONObject, z1 z1Var, SlideFrom slideFrom2, int i) {
        super(jSONObject, z1Var);
        this.slideFrom = SlideFrom.BOTTOM;
        this.chevronColor = Color.parseColor("#9B9B9B");
        if (slideFrom2 != null) {
            this.slideFrom = slideFrom2;
        }
        this.chevronColor = i;
        setCropType((CropType) JsonUtils.optEnum(jSONObject, InAppMessageBase.CROP_TYPE, CropType.class, CropType.FIT_CENTER));
        setMessageTextAlign((TextAlign) JsonUtils.optEnum(jSONObject, InAppMessageBase.MESSAGE_TEXT_ALIGN, TextAlign.class, TextAlign.START));
    }
}
